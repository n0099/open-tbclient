package com.baidu.tieba.newfaceshop.facemake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.atomData.PickFaceTabActivityConfig;
import com.baidu.tbadk.core.atomData.SelectSingleForumActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.BazhuInfoData;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.tieba.newfaceshop.BarInformationModel;
import com.baidu.tieba.newfaceshop.facemake.FaceImageLayout;
import com.baidu.tieba.newfaceshop.facemake.d;
import com.baidu.tieba.newfaceshop.facemake.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class FaceGroupMakeActivity extends BaseActivity implements BarInformationModel.a, d.a {
    private GridView dlY;
    private NoNetworkView fOl;
    private EditText jVj;
    private FaceGroupMakeTitleBar lxh;
    private TextView lxi;
    private LinearLayout lxj;
    private FaceImageLayout lxk;
    private LinearLayout lxl;
    private TextView lxm;
    private TextView lxn;
    private ImageView lxo;
    private d lxp;
    private ArrayList<FaceData> lxq;
    private FaceData lxr;
    private boolean lxs = false;
    private boolean lxt = false;
    private BarInformationModel lxu;
    private ArrayList<BazhuInfoData.BaInfo> lxv;
    private BazhuInfoData.BaInfo lxw;
    private Activity mActivity;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        FaceGroupDraft dkv;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        aEr();
        this.mActivity = getPageContext().getPageActivity();
        setContentView(R.layout.face_group_make_activity);
        this.lxq = new ArrayList<>();
        this.lxr = new FaceData();
        this.lxr.type = 4;
        this.lxq.add(this.lxr);
        if (this.lxs && ((dkv = e.dku().dkv()) == null || dkv.getForumId() != 0)) {
            this.lxt = true;
        }
        initView();
        dkq();
        if (this.lxt) {
            dks();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dkp() {
        return this.lxt;
    }

    private void initView() {
        this.lxj = (LinearLayout) findViewById(R.id.layout_root);
        this.lxk = (FaceImageLayout) findViewById(R.id.layout_image);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.lxh = new FaceGroupMakeTitleBar(this.mActivity);
        this.lxh.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), -1));
        this.lxh.setCloseListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FaceGroupMakeActivity.this.onBack();
            }
        });
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.lxh, (View.OnClickListener) null);
        ao.setBackgroundColor(this.lxh, R.color.CAM_X0201);
        this.fOl = (NoNetworkView) findViewById(R.id.view_no_network);
        if (dkp()) {
            this.lxh.setTitle(this.mActivity.getText(R.string.face_group_make_for_bazhu).toString());
        } else {
            this.lxh.setTitle(this.mActivity.getText(R.string.face_group_make_new).toString());
        }
        this.lxh.setRightText(this.mActivity.getText(R.string.done).toString());
        this.lxh.setRightListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (FaceGroupMakeActivity.this.lxq != null) {
                    String trim = FaceGroupMakeActivity.this.jVj.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim)) {
                        if (FaceGroupMakeActivity.this.lxq.size() - 1 >= 8) {
                            if (FaceGroupMakeActivity.this.lxq.size() - 1 > 24) {
                                FaceGroupMakeActivity.this.showToast(R.string.face_group_add_pic_max);
                                return;
                            } else if (j.isNetWorkAvailable()) {
                                if (FaceGroupMakeActivity.this.dkp() && FaceGroupMakeActivity.this.lxw == null) {
                                    FaceGroupMakeActivity.this.showToast(R.string.input_one_bar);
                                    return;
                                }
                                ArrayList arrayList = new ArrayList();
                                arrayList.addAll(FaceGroupMakeActivity.this.lxq);
                                arrayList.remove(FaceGroupMakeActivity.this.lxr);
                                e dku = e.dku();
                                if (FaceGroupMakeActivity.this.lxw != null) {
                                    i = FaceGroupMakeActivity.this.lxw.forum_id;
                                } else {
                                    i = 0;
                                }
                                dku.a(trim, arrayList, (e.c) null, i);
                                Intent intent = new Intent();
                                intent.putExtra("uploading", true);
                                FaceGroupMakeActivity.this.setResult(-1, intent);
                                FaceGroupMakeActivity.this.finish();
                                return;
                            } else {
                                FaceGroupMakeActivity.this.showToast(R.string.neterror);
                                return;
                            }
                        }
                        FaceGroupMakeActivity.this.showToast(R.string.face_group_pic_less_tip);
                        return;
                    }
                    FaceGroupMakeActivity.this.showToast(R.string.face_group_empty_name_tip);
                }
            }
        });
        this.jVj = (EditText) findViewById(R.id.edit_name);
        this.jVj.setFilters(new InputFilter[]{new a(20)});
        this.lxi = (TextView) findViewById(R.id.tv_add_pic_tip);
        dkr();
        this.dlY = (GridView) findViewById(R.id.grid_view);
        this.lxp = new d(this.lxq);
        this.lxp.a(this);
        this.dlY.setAdapter((ListAdapter) this.lxp);
        this.lxk.setListener(new FaceImageLayout.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.3
            @Override // com.baidu.tieba.newfaceshop.facemake.FaceImageLayout.a
            public void dkt() {
                l.hideSoftKeyPad(FaceGroupMakeActivity.this.mActivity, FaceGroupMakeActivity.this.jVj);
            }
        });
        this.lxl = (LinearLayout) findViewById(R.id.bar_name_layout);
        this.lxm = (TextView) findViewById(R.id.tv_publish_to);
        this.lxn = (TextView) findViewById(R.id.tv_publish_bar_name);
        this.lxn.setOnClickListener(this);
        this.lxl.setVisibility(8);
        this.lxo = (ImageView) findViewById(R.id.iv_right_arrow);
        this.lxl.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                FaceGroupMakeActivity.this.lxn.setMaxWidth(((FaceGroupMakeActivity.this.lxl.getWidth() - FaceGroupMakeActivity.this.lxm.getWidth()) - FaceGroupMakeActivity.this.lxo.getWidth()) - l.getDimens(FaceGroupMakeActivity.this.getPageContext().getPageActivity(), R.dimen.ds3));
            }
        });
    }

    private void dkq() {
        FaceGroupDraft dkv = e.dku().dkv();
        if (dkv != null) {
            if (!TextUtils.isEmpty(dkv.getName())) {
                this.jVj.setText(dkv.getName());
            }
            if (dkv.getList() != null && !dkv.getList().isEmpty()) {
                this.lxq.addAll(dkv.getList());
                this.lxp.notifyDataSetChanged();
                dkr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Parcelable parcelableExtra;
        Serializable serializableExtra;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 25022) {
                if (intent != null && (serializableExtra = intent.getSerializableExtra(PickFaceTabActivityConfig.CHOOSED_LIST)) != null && (serializableExtra instanceof List)) {
                    this.lxq.clear();
                    this.lxq.add(this.lxr);
                    this.lxq.addAll((List) intent.getSerializableExtra(PickFaceTabActivityConfig.CHOOSED_LIST));
                    this.lxp.notifyDataSetChanged();
                    dkr();
                }
            } else if (i == 25025 && intent != null && (parcelableExtra = intent.getParcelableExtra(SelectSingleForumActivityConfig.KEY_OUTPUT_FORUM)) != null && (parcelableExtra instanceof BazhuInfoData.BaInfo)) {
                a((BazhuInfoData.BaInfo) parcelableExtra);
            }
        }
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.d.a
    public void onAdd() {
        if (this.lxq != null && this.lxq.size() - 1 >= 24) {
            showToast(R.string.face_group_add_pic_max);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.lxq != null) {
            arrayList.addAll(this.lxq);
        }
        arrayList.remove(this.lxr);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PickFaceTabActivityConfig(this.mActivity, RequestResponseCode.REQUEST_FACE_GROUP_PICK_PHOTO, arrayList)));
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.d.a
    public void a(FaceData faceData) {
        if (faceData != null) {
            this.lxq.remove(faceData);
            this.lxp.notifyDataSetChanged();
            dkr();
        }
    }

    private void dkr() {
        this.lxi.setText(String.format(getText(R.string.face_group_add_pic_tip).toString(), Integer.valueOf(this.lxq.size() - 1)));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        onBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBack() {
        if ((this.lxq != null && this.lxq.size() > 1) || !TextUtils.isEmpty(this.jVj.getText())) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            aVar.Bo(getResources().getString(R.string.face_group_make_back_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    e.dku().dko();
                    FaceGroupMakeActivity.this.finish();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext()).btY();
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lxj);
        ao.setBackgroundResource(this.lxj, R.color.CAM_X0201);
        this.fOl.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.lxm, R.color.CAM_X0106);
        ao.setViewTextColor(this.jVj, R.color.CAM_X0105);
        ao.setViewTextColor(this.lxi, R.color.CAM_X0109);
        if (i == 0) {
            this.jVj.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        } else {
            this.jVj.setHintTextColor(getResources().getColor(R.color.CAM_X0110_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements InputFilter {
        private int lxy;

        public a(int i) {
            this.lxy = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (spanned != null && charSequence != null && (ad.getTextLength(spanned.toString()) - (i4 - i3)) + ad.getTextLength(charSequence.toString()) > this.lxy) {
                FaceGroupMakeActivity.this.showToast(R.string.package_add_name_max);
                return "";
            }
            return charSequence;
        }
    }

    public void aEr() {
        this.lxs = getIntent().getBooleanExtra(FaceGroupMakeActivityConfig.TYPE_MAKE_FOR_BAIZHU, false);
    }

    private void dks() {
        if (this.lxu == null) {
            this.lxu = new BarInformationModel(getPageContext());
        }
        this.lxu.a(this);
    }

    @Override // com.baidu.tieba.newfaceshop.BarInformationModel.a
    public void a(BazhuInfoData bazhuInfoData) {
        if (bazhuInfoData != null) {
            this.lxv = bazhuInfoData.bazhu_info;
        }
        if (!x.isEmpty(this.lxv)) {
            this.lxl.setVisibility(0);
            if (this.lxv.size() == 1) {
                this.lxn.setText(this.lxv.get(0).forum_name);
                this.lxn.setClickable(false);
                this.lxo.setVisibility(8);
                ao.setViewTextColor(this.lxn, R.color.CAM_X0109);
                this.lxw = this.lxv.get(0);
                return;
            }
            this.lxn.setClickable(true);
            this.lxn.setText(R.string.face_make_choose_forum);
            ao.setViewTextColor(this.lxn, R.color.CAM_X0304);
            FaceGroupDraft dkv = e.dku().dkv();
            if (dkv != null && dkv.getForumId() != 0) {
                Iterator<BazhuInfoData.BaInfo> it = this.lxv.iterator();
                while (it.hasNext()) {
                    BazhuInfoData.BaInfo next = it.next();
                    if (next != null && next.forum_id == dkv.getForumId()) {
                        a(next);
                        return;
                    }
                }
            }
        }
    }

    private void a(BazhuInfoData.BaInfo baInfo) {
        if (baInfo != null && baInfo.forum_id > 0 && !TextUtils.isEmpty(baInfo.forum_name)) {
            if (this.lxw == null) {
                this.lxw = new BazhuInfoData.BaInfo();
            }
            this.lxw.forum_id = baInfo.forum_id;
            this.lxw.forum_name = baInfo.forum_name;
            this.lxn.setText(this.lxw.forum_name);
            if (!x.isEmpty(this.lxv)) {
                Iterator<BazhuInfoData.BaInfo> it = this.lxv.iterator();
                while (it.hasNext()) {
                    BazhuInfoData.BaInfo next = it.next();
                    if (baInfo.forum_id == next.forum_id) {
                        next.isChecked = true;
                    } else {
                        next.isChecked = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.lxn && !x.isEmpty(this.lxv)) {
            SelectSingleForumActivityConfig selectSingleForumActivityConfig = new SelectSingleForumActivityConfig(getPageContext().getContext(), RequestResponseCode.REQUEST_CHOOSE_FORUM);
            selectSingleForumActivityConfig.setForumList(this.lxv);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectSingleForumActivityConfig));
        }
    }
}
