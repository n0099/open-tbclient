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
/* loaded from: classes9.dex */
public class FaceGroupMakeActivity extends BaseActivity implements BarInformationModel.a, d.a {
    private GridView djx;
    private NoNetworkView fLP;
    private EditText jYg;
    private FaceGroupMakeTitleBar lAG;
    private TextView lAH;
    private LinearLayout lAI;
    private FaceImageLayout lAJ;
    private LinearLayout lAK;
    private TextView lAL;
    private TextView lAM;
    private ImageView lAN;
    private d lAO;
    private ArrayList<FaceData> lAP;
    private FaceData lAQ;
    private boolean lAR = false;
    private boolean lAS = false;
    private BarInformationModel lAT;
    private ArrayList<BazhuInfoData.BaInfo> lAU;
    private BazhuInfoData.BaInfo lAV;
    private Activity mActivity;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        FaceGroupDraft diE;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        aAV();
        this.mActivity = getPageContext().getPageActivity();
        setContentView(R.layout.face_group_make_activity);
        this.lAP = new ArrayList<>();
        this.lAQ = new FaceData();
        this.lAQ.type = 4;
        this.lAP.add(this.lAQ);
        if (this.lAR && ((diE = e.diD().diE()) == null || diE.getForumId() != 0)) {
            this.lAS = true;
        }
        initView();
        diz();
        if (this.lAS) {
            diB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean diy() {
        return this.lAS;
    }

    private void initView() {
        this.lAI = (LinearLayout) findViewById(R.id.layout_root);
        this.lAJ = (FaceImageLayout) findViewById(R.id.layout_image);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.lAG = new FaceGroupMakeTitleBar(this.mActivity);
        this.lAG.setLayoutParams(new RelativeLayout.LayoutParams(l.getEquipmentWidth(getPageContext().getPageActivity()), -1));
        this.lAG.setCloseListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FaceGroupMakeActivity.this.onBack();
            }
        });
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.lAG, (View.OnClickListener) null);
        ap.setBackgroundColor(this.lAG, R.color.CAM_X0201);
        this.fLP = (NoNetworkView) findViewById(R.id.view_no_network);
        if (diy()) {
            this.lAG.setTitle(this.mActivity.getText(R.string.face_group_make_for_bazhu).toString());
        } else {
            this.lAG.setTitle(this.mActivity.getText(R.string.face_group_make_new).toString());
        }
        this.lAG.setRightText(this.mActivity.getText(R.string.done).toString());
        this.lAG.setRightListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (FaceGroupMakeActivity.this.lAP != null) {
                    String trim = FaceGroupMakeActivity.this.jYg.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim)) {
                        if (FaceGroupMakeActivity.this.lAP.size() - 1 >= 8) {
                            if (FaceGroupMakeActivity.this.lAP.size() - 1 > 24) {
                                FaceGroupMakeActivity.this.showToast(R.string.face_group_add_pic_max);
                                return;
                            } else if (j.isNetWorkAvailable()) {
                                if (FaceGroupMakeActivity.this.diy() && FaceGroupMakeActivity.this.lAV == null) {
                                    FaceGroupMakeActivity.this.showToast(R.string.input_one_bar);
                                    return;
                                }
                                ArrayList arrayList = new ArrayList();
                                arrayList.addAll(FaceGroupMakeActivity.this.lAP);
                                arrayList.remove(FaceGroupMakeActivity.this.lAQ);
                                e diD = e.diD();
                                if (FaceGroupMakeActivity.this.lAV != null) {
                                    i = FaceGroupMakeActivity.this.lAV.forum_id;
                                } else {
                                    i = 0;
                                }
                                diD.a(trim, arrayList, (e.c) null, i);
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
        this.jYg = (EditText) findViewById(R.id.edit_name);
        this.jYg.setFilters(new InputFilter[]{new a(20)});
        this.lAH = (TextView) findViewById(R.id.tv_add_pic_tip);
        diA();
        this.djx = (GridView) findViewById(R.id.grid_view);
        this.lAO = new d(this.lAP);
        this.lAO.a(this);
        this.djx.setAdapter((ListAdapter) this.lAO);
        this.lAJ.setListener(new FaceImageLayout.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.3
            @Override // com.baidu.tieba.newfaceshop.facemake.FaceImageLayout.a
            public void diC() {
                l.hideSoftKeyPad(FaceGroupMakeActivity.this.mActivity, FaceGroupMakeActivity.this.jYg);
            }
        });
        this.lAK = (LinearLayout) findViewById(R.id.bar_name_layout);
        this.lAL = (TextView) findViewById(R.id.tv_publish_to);
        this.lAM = (TextView) findViewById(R.id.tv_publish_bar_name);
        this.lAM.setOnClickListener(this);
        this.lAK.setVisibility(8);
        this.lAN = (ImageView) findViewById(R.id.iv_right_arrow);
        this.lAK.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                FaceGroupMakeActivity.this.lAM.setMaxWidth(((FaceGroupMakeActivity.this.lAK.getWidth() - FaceGroupMakeActivity.this.lAL.getWidth()) - FaceGroupMakeActivity.this.lAN.getWidth()) - l.getDimens(FaceGroupMakeActivity.this.getPageContext().getPageActivity(), R.dimen.ds3));
            }
        });
    }

    private void diz() {
        FaceGroupDraft diE = e.diD().diE();
        if (diE != null) {
            if (!TextUtils.isEmpty(diE.getName())) {
                this.jYg.setText(diE.getName());
            }
            if (diE.getList() != null && !diE.getList().isEmpty()) {
                this.lAP.addAll(diE.getList());
                this.lAO.notifyDataSetChanged();
                diA();
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
                    this.lAP.clear();
                    this.lAP.add(this.lAQ);
                    this.lAP.addAll((List) intent.getSerializableExtra(PickFaceTabActivityConfig.CHOOSED_LIST));
                    this.lAO.notifyDataSetChanged();
                    diA();
                }
            } else if (i == 25025 && intent != null && (parcelableExtra = intent.getParcelableExtra(SelectSingleForumActivityConfig.KEY_OUTPUT_FORUM)) != null && (parcelableExtra instanceof BazhuInfoData.BaInfo)) {
                a((BazhuInfoData.BaInfo) parcelableExtra);
            }
        }
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.d.a
    public void onAdd() {
        if (this.lAP != null && this.lAP.size() - 1 >= 24) {
            showToast(R.string.face_group_add_pic_max);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.lAP != null) {
            arrayList.addAll(this.lAP);
        }
        arrayList.remove(this.lAQ);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PickFaceTabActivityConfig(this.mActivity, RequestResponseCode.REQUEST_FACE_GROUP_PICK_PHOTO, arrayList)));
    }

    @Override // com.baidu.tieba.newfaceshop.facemake.d.a
    public void a(FaceData faceData) {
        if (faceData != null) {
            this.lAP.remove(faceData);
            this.lAO.notifyDataSetChanged();
            diA();
        }
    }

    private void diA() {
        this.lAH.setText(String.format(getText(R.string.face_group_add_pic_tip).toString(), Integer.valueOf(this.lAP.size() - 1)));
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
        if ((this.lAP != null && this.lAP.size() > 1) || !TextUtils.isEmpty(this.jYg.getText())) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
            aVar.Au(getResources().getString(R.string.face_group_make_back_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    e.diD().dix();
                    FaceGroupMakeActivity.this.finish();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeActivity.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext()).bqx();
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
        getLayoutMode().onModeChanged(this.lAI);
        ap.setBackgroundResource(this.lAI, R.color.CAM_X0201);
        this.fLP.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.lAL, R.color.CAM_X0106);
        ap.setViewTextColor(this.jYg, R.color.CAM_X0105);
        ap.setViewTextColor(this.lAH, R.color.CAM_X0109);
        if (i == 0) {
            this.jYg.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        } else {
            this.jYg.setHintTextColor(getResources().getColor(R.color.CAM_X0110_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements InputFilter {
        private int lAX;

        public a(int i) {
            this.lAX = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (spanned != null && charSequence != null && (ag.getTextLength(spanned.toString()) - (i4 - i3)) + ag.getTextLength(charSequence.toString()) > this.lAX) {
                FaceGroupMakeActivity.this.showToast(R.string.package_add_name_max);
                return "";
            }
            return charSequence;
        }
    }

    public void aAV() {
        this.lAR = getIntent().getBooleanExtra(FaceGroupMakeActivityConfig.TYPE_MAKE_FOR_BAIZHU, false);
    }

    private void diB() {
        if (this.lAT == null) {
            this.lAT = new BarInformationModel(getPageContext());
        }
        this.lAT.a(this);
    }

    @Override // com.baidu.tieba.newfaceshop.BarInformationModel.a
    public void a(BazhuInfoData bazhuInfoData) {
        if (bazhuInfoData != null) {
            this.lAU = bazhuInfoData.bazhu_info;
        }
        if (!y.isEmpty(this.lAU)) {
            this.lAK.setVisibility(0);
            if (this.lAU.size() == 1) {
                this.lAM.setText(this.lAU.get(0).forum_name);
                this.lAM.setClickable(false);
                this.lAN.setVisibility(8);
                ap.setViewTextColor(this.lAM, R.color.CAM_X0109);
                this.lAV = this.lAU.get(0);
                return;
            }
            this.lAM.setClickable(true);
            this.lAM.setText(R.string.face_make_choose_forum);
            ap.setViewTextColor(this.lAM, R.color.CAM_X0304);
            FaceGroupDraft diE = e.diD().diE();
            if (diE != null && diE.getForumId() != 0) {
                Iterator<BazhuInfoData.BaInfo> it = this.lAU.iterator();
                while (it.hasNext()) {
                    BazhuInfoData.BaInfo next = it.next();
                    if (next != null && next.forum_id == diE.getForumId()) {
                        a(next);
                        return;
                    }
                }
            }
        }
    }

    private void a(BazhuInfoData.BaInfo baInfo) {
        if (baInfo != null && baInfo.forum_id > 0 && !TextUtils.isEmpty(baInfo.forum_name)) {
            if (this.lAV == null) {
                this.lAV = new BazhuInfoData.BaInfo();
            }
            this.lAV.forum_id = baInfo.forum_id;
            this.lAV.forum_name = baInfo.forum_name;
            this.lAM.setText(this.lAV.forum_name);
            if (!y.isEmpty(this.lAU)) {
                Iterator<BazhuInfoData.BaInfo> it = this.lAU.iterator();
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
        if (view == this.lAM && !y.isEmpty(this.lAU)) {
            SelectSingleForumActivityConfig selectSingleForumActivityConfig = new SelectSingleForumActivityConfig(getPageContext().getContext(), RequestResponseCode.REQUEST_CHOOSE_FORUM);
            selectSingleForumActivityConfig.setForumList(this.lAU);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectSingleForumActivityConfig));
        }
    }
}
