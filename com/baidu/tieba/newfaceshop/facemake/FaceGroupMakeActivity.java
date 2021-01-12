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
/* loaded from: classes8.dex */
public class FaceGroupMakeActivity extends BaseActivity implements BarInformationModel.a, d.a {
    private GridView dhj;
    private NoNetworkView fJE;
    private EditText jQE;
    private FaceGroupMakeTitleBar lsB;
    private TextView lsC;
    private LinearLayout lsD;
    private FaceImageLayout lsE;
    private LinearLayout lsF;
    private TextView lsG;
    private TextView lsH;
    private ImageView lsI;
    private d lsJ;
    private ArrayList<FaceData> lsK;
    private FaceData lsL;
    private boolean lsM = false;
    private boolean lsN = false;
    private BarInformationModel lsO;
    private ArrayList<BazhuInfoData.BaInfo> lsP;
    private BazhuInfoData.BaInfo lsQ;
    private Activity mActivity;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        FaceGroupDraft dgD;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        aAx();
        this.mActivity = getPageContext().getPageActivity();
        setContentView(R.layout.face_group_make_activity);
        this.lsK = new ArrayList<>();
        this.lsL = new FaceData();
        this.lsL.type = 4;
        this.lsK.add(this.lsL);
        if (this.lsM && ((dgD = e.dgC().dgD()) == null || dgD.getForumId() != 0)) {
            this.lsN = true;
        }
        initView();
        dgy();
        if (this.lsN) {
            dgA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dgx() {
        return this.lsN;
    }

    private void initView() {
        this.lsD = (LinearLayout) findViewById(R.id.layout_root);
        this.lsE = (FaceImageLayout) findViewById(R.id.layout_image);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.lsB = new FaceGroupMakeTitleBar(this.mActivity);
        this.lsB.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), -1));
        this.lsB.setCloseListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FaceGroupMakeActivity.this.onBack();
            }
        });
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.lsB, (View.OnClickListener) null);
        ao.setBackgroundColor(this.lsB, R.color.CAM_X0201);
        this.fJE = (NoNetworkView) findViewById(R.id.view_no_network);
        if (dgx()) {
            this.lsB.setTitle(this.mActivity.getText(R.string.face_group_make_for_bazhu).toString());
        } else {
            this.lsB.setTitle(this.mActivity.getText(R.string.face_group_make_new).toString());
        }
        this.lsB.setRightText(this.mActivity.getText(R.string.done).toString());
        this.lsB.setRightListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (FaceGroupMakeActivity.this.lsK != null) {
                    String trim = FaceGroupMakeActivity.this.jQE.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim)) {
                        if (FaceGroupMakeActivity.this.lsK.size() - 1 >= 8) {
                            if (FaceGroupMakeActivity.this.lsK.size() - 1 > 24) {
                                FaceGroupMakeActivity.this.showToast(R.string.face_group_add_pic_max);
                                return;
                            } else if (j.isNetWorkAvailable()) {
                                if (FaceGroupMakeActivity.this.dgx() && FaceGroupMakeActivity.this.lsQ == null) {
                                    FaceGroupMakeActivity.this.showToast(R.string.input_one_bar);
                                    return;
                                }
                                ArrayList arrayList = new ArrayList();
                                arrayList.addAll(FaceGroupMakeActivity.this.lsK);
                                arrayList.remove(FaceGroupMakeActivity.this.lsL);
                                e dgC = e.dgC();
                                if (FaceGroupMakeActivity.this.lsQ != null) {
                                    i = FaceGroupMakeActivity.this.lsQ.forum_id;
                                } else {
                                    i = 0;
                                }
                                dgC.a(trim, arrayList, (e.c) null, i);
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
        this.jQE = (EditText) findViewById(R.id.edit_name);
        this.jQE.setFilters(new InputFilter[]{new a(20)});
        this.lsC = (TextView) findViewById(R.id.tv_add_pic_tip);
        dgz();
        this.dhj = (GridView) findViewById(R.id.grid_view);
        this.lsJ = new d(this.lsK);
        this.lsJ.a(this);
        this.dhj.setAdapter((ListAdapter) this.lsJ);
        this.lsE.setListener(new FaceImageLayout.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.3
            @Override // com.baidu.tieba.newfaceshop.facemake.FaceImageLayout.a
            public void dgB() {
                l.hideSoftKeyPad(FaceGroupMakeActivity.this.mActivity, FaceGroupMakeActivity.this.jQE);
            }
        });
        this.lsF = (LinearLayout) findViewById(R.id.bar_name_layout);
        this.lsG = (TextView) findViewById(R.id.tv_publish_to);
        this.lsH = (TextView) findViewById(R.id.tv_publish_bar_name);
        this.lsH.setOnClickListener(this);
        this.lsF.setVisibility(8);
        this.lsI = (ImageView) findViewById(R.id.iv_right_arrow);
        this.lsF.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                FaceGroupMakeActivity.this.lsH.setMaxWidth(((FaceGroupMakeActivity.this.lsF.getWidth() - FaceGroupMakeActivity.this.lsG.getWidth()) - FaceGroupMakeActivity.this.lsI.getWidth()) - l.getDimens(FaceGroupMakeActivity.this.getPageContext().getPageActivity(), R.dimen.ds3));
            }
        });
    }

    private void dgy() {
        FaceGroupDraft dgD = e.dgC().dgD();
        if (dgD != null) {
            if (!TextUtils.isEmpty(dgD.getName())) {
                this.jQE.setText(dgD.getName());
            }
            if (dgD.getList() != null && !dgD.getList().isEmpty()) {
                this.lsK.addAll(dgD.getList());
                this.lsJ.notifyDataSetChanged();
                dgz();
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
                    this.lsK.clear();
                    this.lsK.add(this.lsL);
                    this.lsK.addAll((List) intent.getSerializableExtra(PickFaceTabActivityConfig.CHOOSED_LIST));
                    this.lsJ.notifyDataSetChanged();
                    dgz();
                }
            } else if (i == 25025 && intent != null && (parcelableExtra = intent.getParcelableExtra(SelectSingleForumActivityConfig.KEY_OUTPUT_FORUM)) != null && (parcelableExtra instanceof BazhuInfoData.BaInfo)) {
                a((BazhuInfoData.BaInfo) parcelableExtra);
            }
        }
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.d.a
    public void onAdd() {
        if (this.lsK != null && this.lsK.size() - 1 >= 24) {
            showToast(R.string.face_group_add_pic_max);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.lsK != null) {
            arrayList.addAll(this.lsK);
        }
        arrayList.remove(this.lsL);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PickFaceTabActivityConfig(this.mActivity, RequestResponseCode.REQUEST_FACE_GROUP_PICK_PHOTO, arrayList)));
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.d.a
    public void a(FaceData faceData) {
        if (faceData != null) {
            this.lsK.remove(faceData);
            this.lsJ.notifyDataSetChanged();
            dgz();
        }
    }

    private void dgz() {
        this.lsC.setText(String.format(getText(R.string.face_group_add_pic_tip).toString(), Integer.valueOf(this.lsK.size() - 1)));
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
        if ((this.lsK != null && this.lsK.size() > 1) || !TextUtils.isEmpty(this.jQE.getText())) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            aVar.Ad(getResources().getString(R.string.face_group_make_back_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    e.dgC().dgw();
                    FaceGroupMakeActivity.this.finish();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext()).bqe();
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
        getLayoutMode().onModeChanged(this.lsD);
        ao.setBackgroundResource(this.lsD, R.color.CAM_X0201);
        this.fJE.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.lsG, R.color.CAM_X0106);
        ao.setViewTextColor(this.jQE, R.color.CAM_X0105);
        ao.setViewTextColor(this.lsC, R.color.CAM_X0109);
        if (i == 0) {
            this.jQE.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        } else {
            this.jQE.setHintTextColor(getResources().getColor(R.color.CAM_X0110_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a implements InputFilter {
        private int lsS;

        public a(int i) {
            this.lsS = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (spanned != null && charSequence != null && (ad.getTextLength(spanned.toString()) - (i4 - i3)) + ad.getTextLength(charSequence.toString()) > this.lsS) {
                FaceGroupMakeActivity.this.showToast(R.string.package_add_name_max);
                return "";
            }
            return charSequence;
        }
    }

    public void aAx() {
        this.lsM = getIntent().getBooleanExtra(FaceGroupMakeActivityConfig.TYPE_MAKE_FOR_BAIZHU, false);
    }

    private void dgA() {
        if (this.lsO == null) {
            this.lsO = new BarInformationModel(getPageContext());
        }
        this.lsO.a(this);
    }

    @Override // com.baidu.tieba.newfaceshop.BarInformationModel.a
    public void a(BazhuInfoData bazhuInfoData) {
        if (bazhuInfoData != null) {
            this.lsP = bazhuInfoData.bazhu_info;
        }
        if (!x.isEmpty(this.lsP)) {
            this.lsF.setVisibility(0);
            if (this.lsP.size() == 1) {
                this.lsH.setText(this.lsP.get(0).forum_name);
                this.lsH.setClickable(false);
                this.lsI.setVisibility(8);
                ao.setViewTextColor(this.lsH, R.color.CAM_X0109);
                this.lsQ = this.lsP.get(0);
                return;
            }
            this.lsH.setClickable(true);
            this.lsH.setText(R.string.face_make_choose_forum);
            ao.setViewTextColor(this.lsH, R.color.CAM_X0304);
            FaceGroupDraft dgD = e.dgC().dgD();
            if (dgD != null && dgD.getForumId() != 0) {
                Iterator<BazhuInfoData.BaInfo> it = this.lsP.iterator();
                while (it.hasNext()) {
                    BazhuInfoData.BaInfo next = it.next();
                    if (next != null && next.forum_id == dgD.getForumId()) {
                        a(next);
                        return;
                    }
                }
            }
        }
    }

    private void a(BazhuInfoData.BaInfo baInfo) {
        if (baInfo != null && baInfo.forum_id > 0 && !TextUtils.isEmpty(baInfo.forum_name)) {
            if (this.lsQ == null) {
                this.lsQ = new BazhuInfoData.BaInfo();
            }
            this.lsQ.forum_id = baInfo.forum_id;
            this.lsQ.forum_name = baInfo.forum_name;
            this.lsH.setText(this.lsQ.forum_name);
            if (!x.isEmpty(this.lsP)) {
                Iterator<BazhuInfoData.BaInfo> it = this.lsP.iterator();
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
        if (view == this.lsH && !x.isEmpty(this.lsP)) {
            SelectSingleForumActivityConfig selectSingleForumActivityConfig = new SelectSingleForumActivityConfig(getPageContext().getContext(), RequestResponseCode.REQUEST_CHOOSE_FORUM);
            selectSingleForumActivityConfig.setForumList(this.lsP);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectSingleForumActivityConfig));
        }
    }
}
