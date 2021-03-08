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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.BazhuInfoData;
import com.baidu.tbadk.util.ag;
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
/* loaded from: classes8.dex */
public class FaceGroupMakeActivity extends BaseActivity implements BarInformationModel.a, d.a {
    private GridView dkY;
    private NoNetworkView fNp;
    private EditText kaw;
    private FaceGroupMakeTitleBar lCW;
    private TextView lCX;
    private LinearLayout lCY;
    private FaceImageLayout lCZ;
    private LinearLayout lDa;
    private TextView lDb;
    private TextView lDc;
    private ImageView lDd;
    private d lDe;
    private ArrayList<FaceData> lDf;
    private FaceData lDg;
    private boolean lDh = false;
    private boolean lDi = false;
    private BarInformationModel lDj;
    private ArrayList<BazhuInfoData.BaInfo> lDk;
    private BazhuInfoData.BaInfo lDl;
    private Activity mActivity;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        FaceGroupDraft diU;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        aAY();
        this.mActivity = getPageContext().getPageActivity();
        setContentView(R.layout.face_group_make_activity);
        this.lDf = new ArrayList<>();
        this.lDg = new FaceData();
        this.lDg.type = 4;
        this.lDf.add(this.lDg);
        if (this.lDh && ((diU = e.diT().diU()) == null || diU.getForumId() != 0)) {
            this.lDi = true;
        }
        initView();
        diP();
        if (this.lDi) {
            diR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean diO() {
        return this.lDi;
    }

    private void initView() {
        this.lCY = (LinearLayout) findViewById(R.id.layout_root);
        this.lCZ = (FaceImageLayout) findViewById(R.id.layout_image);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.lCW = new FaceGroupMakeTitleBar(this.mActivity);
        this.lCW.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), -1));
        this.lCW.setCloseListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FaceGroupMakeActivity.this.onBack();
            }
        });
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.lCW, (View.OnClickListener) null);
        ap.setBackgroundColor(this.lCW, R.color.CAM_X0201);
        this.fNp = (NoNetworkView) findViewById(R.id.view_no_network);
        if (diO()) {
            this.lCW.setTitle(this.mActivity.getText(R.string.face_group_make_for_bazhu).toString());
        } else {
            this.lCW.setTitle(this.mActivity.getText(R.string.face_group_make_new).toString());
        }
        this.lCW.setRightText(this.mActivity.getText(R.string.done).toString());
        this.lCW.setRightListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (FaceGroupMakeActivity.this.lDf != null) {
                    String trim = FaceGroupMakeActivity.this.kaw.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim)) {
                        if (FaceGroupMakeActivity.this.lDf.size() - 1 >= 8) {
                            if (FaceGroupMakeActivity.this.lDf.size() - 1 > 24) {
                                FaceGroupMakeActivity.this.showToast(R.string.face_group_add_pic_max);
                                return;
                            } else if (j.isNetWorkAvailable()) {
                                if (FaceGroupMakeActivity.this.diO() && FaceGroupMakeActivity.this.lDl == null) {
                                    FaceGroupMakeActivity.this.showToast(R.string.input_one_bar);
                                    return;
                                }
                                ArrayList arrayList = new ArrayList();
                                arrayList.addAll(FaceGroupMakeActivity.this.lDf);
                                arrayList.remove(FaceGroupMakeActivity.this.lDg);
                                e diT = e.diT();
                                if (FaceGroupMakeActivity.this.lDl != null) {
                                    i = FaceGroupMakeActivity.this.lDl.forum_id;
                                } else {
                                    i = 0;
                                }
                                diT.a(trim, arrayList, (e.c) null, i);
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
        this.kaw = (EditText) findViewById(R.id.edit_name);
        this.kaw.setFilters(new InputFilter[]{new a(20)});
        this.lCX = (TextView) findViewById(R.id.tv_add_pic_tip);
        diQ();
        this.dkY = (GridView) findViewById(R.id.grid_view);
        this.lDe = new d(this.lDf);
        this.lDe.a(this);
        this.dkY.setAdapter((ListAdapter) this.lDe);
        this.lCZ.setListener(new FaceImageLayout.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.3
            @Override // com.baidu.tieba.newfaceshop.facemake.FaceImageLayout.a
            public void diS() {
                l.hideSoftKeyPad(FaceGroupMakeActivity.this.mActivity, FaceGroupMakeActivity.this.kaw);
            }
        });
        this.lDa = (LinearLayout) findViewById(R.id.bar_name_layout);
        this.lDb = (TextView) findViewById(R.id.tv_publish_to);
        this.lDc = (TextView) findViewById(R.id.tv_publish_bar_name);
        this.lDc.setOnClickListener(this);
        this.lDa.setVisibility(8);
        this.lDd = (ImageView) findViewById(R.id.iv_right_arrow);
        this.lDa.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                FaceGroupMakeActivity.this.lDc.setMaxWidth(((FaceGroupMakeActivity.this.lDa.getWidth() - FaceGroupMakeActivity.this.lDb.getWidth()) - FaceGroupMakeActivity.this.lDd.getWidth()) - l.getDimens(FaceGroupMakeActivity.this.getPageContext().getPageActivity(), R.dimen.ds3));
            }
        });
    }

    private void diP() {
        FaceGroupDraft diU = e.diT().diU();
        if (diU != null) {
            if (!TextUtils.isEmpty(diU.getName())) {
                this.kaw.setText(diU.getName());
            }
            if (diU.getList() != null && !diU.getList().isEmpty()) {
                this.lDf.addAll(diU.getList());
                this.lDe.notifyDataSetChanged();
                diQ();
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
                    this.lDf.clear();
                    this.lDf.add(this.lDg);
                    this.lDf.addAll((List) intent.getSerializableExtra(PickFaceTabActivityConfig.CHOOSED_LIST));
                    this.lDe.notifyDataSetChanged();
                    diQ();
                }
            } else if (i == 25025 && intent != null && (parcelableExtra = intent.getParcelableExtra(SelectSingleForumActivityConfig.KEY_OUTPUT_FORUM)) != null && (parcelableExtra instanceof BazhuInfoData.BaInfo)) {
                a((BazhuInfoData.BaInfo) parcelableExtra);
            }
        }
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.d.a
    public void onAdd() {
        if (this.lDf != null && this.lDf.size() - 1 >= 24) {
            showToast(R.string.face_group_add_pic_max);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.lDf != null) {
            arrayList.addAll(this.lDf);
        }
        arrayList.remove(this.lDg);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PickFaceTabActivityConfig(this.mActivity, RequestResponseCode.REQUEST_FACE_GROUP_PICK_PHOTO, arrayList)));
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.d.a
    public void a(FaceData faceData) {
        if (faceData != null) {
            this.lDf.remove(faceData);
            this.lDe.notifyDataSetChanged();
            diQ();
        }
    }

    private void diQ() {
        this.lCX.setText(String.format(getText(R.string.face_group_add_pic_tip).toString(), Integer.valueOf(this.lDf.size() - 1)));
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
        if ((this.lDf != null && this.lDf.size() > 1) || !TextUtils.isEmpty(this.kaw.getText())) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            aVar.AB(getResources().getString(R.string.face_group_make_back_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    e.diT().diN();
                    FaceGroupMakeActivity.this.finish();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext()).bqz();
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
        getLayoutMode().onModeChanged(this.lCY);
        ap.setBackgroundResource(this.lCY, R.color.CAM_X0201);
        this.fNp.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.lDb, R.color.CAM_X0106);
        ap.setViewTextColor(this.kaw, R.color.CAM_X0105);
        ap.setViewTextColor(this.lCX, R.color.CAM_X0109);
        if (i == 0) {
            this.kaw.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        } else {
            this.kaw.setHintTextColor(getResources().getColor(R.color.CAM_X0110_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a implements InputFilter {
        private int lDn;

        public a(int i) {
            this.lDn = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (spanned != null && charSequence != null && (ag.getTextLength(spanned.toString()) - (i4 - i3)) + ag.getTextLength(charSequence.toString()) > this.lDn) {
                FaceGroupMakeActivity.this.showToast(R.string.package_add_name_max);
                return "";
            }
            return charSequence;
        }
    }

    public void aAY() {
        this.lDh = getIntent().getBooleanExtra(FaceGroupMakeActivityConfig.TYPE_MAKE_FOR_BAIZHU, false);
    }

    private void diR() {
        if (this.lDj == null) {
            this.lDj = new BarInformationModel(getPageContext());
        }
        this.lDj.a(this);
    }

    @Override // com.baidu.tieba.newfaceshop.BarInformationModel.a
    public void a(BazhuInfoData bazhuInfoData) {
        if (bazhuInfoData != null) {
            this.lDk = bazhuInfoData.bazhu_info;
        }
        if (!y.isEmpty(this.lDk)) {
            this.lDa.setVisibility(0);
            if (this.lDk.size() == 1) {
                this.lDc.setText(this.lDk.get(0).forum_name);
                this.lDc.setClickable(false);
                this.lDd.setVisibility(8);
                ap.setViewTextColor(this.lDc, R.color.CAM_X0109);
                this.lDl = this.lDk.get(0);
                return;
            }
            this.lDc.setClickable(true);
            this.lDc.setText(R.string.face_make_choose_forum);
            ap.setViewTextColor(this.lDc, R.color.CAM_X0304);
            FaceGroupDraft diU = e.diT().diU();
            if (diU != null && diU.getForumId() != 0) {
                Iterator<BazhuInfoData.BaInfo> it = this.lDk.iterator();
                while (it.hasNext()) {
                    BazhuInfoData.BaInfo next = it.next();
                    if (next != null && next.forum_id == diU.getForumId()) {
                        a(next);
                        return;
                    }
                }
            }
        }
    }

    private void a(BazhuInfoData.BaInfo baInfo) {
        if (baInfo != null && baInfo.forum_id > 0 && !TextUtils.isEmpty(baInfo.forum_name)) {
            if (this.lDl == null) {
                this.lDl = new BazhuInfoData.BaInfo();
            }
            this.lDl.forum_id = baInfo.forum_id;
            this.lDl.forum_name = baInfo.forum_name;
            this.lDc.setText(this.lDl.forum_name);
            if (!y.isEmpty(this.lDk)) {
                Iterator<BazhuInfoData.BaInfo> it = this.lDk.iterator();
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
        if (view == this.lDc && !y.isEmpty(this.lDk)) {
            SelectSingleForumActivityConfig selectSingleForumActivityConfig = new SelectSingleForumActivityConfig(getPageContext().getContext(), RequestResponseCode.REQUEST_CHOOSE_FORUM);
            selectSingleForumActivityConfig.setForumList(this.lDk);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectSingleForumActivityConfig));
        }
    }
}
