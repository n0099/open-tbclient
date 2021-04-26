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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.atomData.PickFaceTabActivityConfig;
import com.baidu.tbadk.core.atomData.SelectSingleForumActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.BazhuInfoData;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.tieba.newfaceshop.BarInformationModel;
import com.baidu.tieba.newfaceshop.facemake.FaceImageLayout;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.i0.r.s.a;
import d.a.i0.z0.i0;
import d.a.j0.y1.g.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class FaceGroupMakeActivity extends BaseActivity implements d.c, BarInformationModel.b {
    public static final int NO_FORUM_ID = 0;
    public ImageView ivArrow;
    public Activity mActivity;
    public FaceData mAddIconData;
    public ArrayList<BazhuInfoData.BaInfo> mBarList;
    public LinearLayout mBazhuTitleLayout;
    public TextView mChooseBarTv;
    public BazhuInfoData.BaInfo mChoosedData;
    public ArrayList<FaceData> mChoosedImageList;
    public EditText mEditName;
    public d.a.j0.y1.g.d mEmotionAdapter;
    public GridView mGridView;
    public FaceImageLayout mLayoutImage;
    public LinearLayout mLayoutRoot;
    public BarInformationModel mModel;
    public NavigationBar mNavigationBar;
    public NoNetworkView mNoNetView;
    public TextView mPublishTxtTv;
    public FaceGroupMakeTitleBar mTitleBar;
    public TextView mTvAddPicTip;
    public boolean isFromBazhu = false;
    public boolean isBarEmotion = false;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FaceGroupMakeActivity.this.onBack();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FaceGroupMakeActivity.this.mChoosedImageList == null) {
                return;
            }
            String trim = FaceGroupMakeActivity.this.mEditName.getText().toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                if (FaceGroupMakeActivity.this.mChoosedImageList.size() - 1 >= 8) {
                    if (FaceGroupMakeActivity.this.mChoosedImageList.size() - 1 > 24) {
                        FaceGroupMakeActivity.this.showToast(R.string.face_group_add_pic_max);
                        return;
                    } else if (j.z()) {
                        if (FaceGroupMakeActivity.this.isBarEmotion() && FaceGroupMakeActivity.this.mChoosedData == null) {
                            FaceGroupMakeActivity.this.showToast(R.string.input_one_bar);
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(FaceGroupMakeActivity.this.mChoosedImageList);
                        arrayList.remove(FaceGroupMakeActivity.this.mAddIconData);
                        d.a.j0.y1.g.e.l().A(trim, arrayList, null, FaceGroupMakeActivity.this.mChoosedData != null ? FaceGroupMakeActivity.this.mChoosedData.forum_id : 0);
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

    /* loaded from: classes3.dex */
    public class c implements FaceImageLayout.a {
        public c() {
        }

        @Override // com.baidu.tieba.newfaceshop.facemake.FaceImageLayout.a
        public void a() {
            l.x(FaceGroupMakeActivity.this.mActivity, FaceGroupMakeActivity.this.mEditName);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public d() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            FaceGroupMakeActivity.this.mChooseBarTv.setMaxWidth(((FaceGroupMakeActivity.this.mBazhuTitleLayout.getWidth() - FaceGroupMakeActivity.this.mPublishTxtTv.getWidth()) - FaceGroupMakeActivity.this.ivArrow.getWidth()) - l.g(FaceGroupMakeActivity.this.getPageContext().getPageActivity(), R.dimen.ds3));
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
            d.a.j0.y1.g.e.l().i();
            FaceGroupMakeActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements a.e {
        public f() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class g implements InputFilter {

        /* renamed from: e  reason: collision with root package name */
        public int f19366e;

        public g(int i2) {
            this.f19366e = i2;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            if (spanned == null || charSequence == null || (i0.b(spanned.toString()) - (i5 - i4)) + i0.b(charSequence.toString()) <= this.f19366e) {
                return charSequence;
            }
            FaceGroupMakeActivity.this.showToast(R.string.package_add_name_max);
            return "";
        }
    }

    private void handleForumData(BazhuInfoData.BaInfo baInfo) {
        if (baInfo == null || baInfo.forum_id <= 0 || TextUtils.isEmpty(baInfo.forum_name)) {
            return;
        }
        if (this.mChoosedData == null) {
            this.mChoosedData = new BazhuInfoData.BaInfo();
        }
        BazhuInfoData.BaInfo baInfo2 = this.mChoosedData;
        baInfo2.forum_id = baInfo.forum_id;
        String str = baInfo.forum_name;
        baInfo2.forum_name = str;
        this.mChooseBarTv.setText(str);
        if (ListUtils.isEmpty(this.mBarList)) {
            return;
        }
        Iterator<BazhuInfoData.BaInfo> it = this.mBarList.iterator();
        while (it.hasNext()) {
            BazhuInfoData.BaInfo next = it.next();
            if (baInfo.forum_id == next.forum_id) {
                next.isChecked = true;
            } else {
                next.isChecked = false;
            }
        }
    }

    private void initView() {
        this.mLayoutRoot = (LinearLayout) findViewById(R.id.layout_root);
        this.mLayoutImage = (FaceImageLayout) findViewById(R.id.layout_image);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mTitleBar = new FaceGroupMakeTitleBar(this.mActivity);
        this.mTitleBar.setLayoutParams(new RelativeLayout.LayoutParams(l.k(getPageContext().getPageActivity()), -1));
        this.mTitleBar.setCloseListener(new a());
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleBar, (View.OnClickListener) null);
        SkinManager.setBackgroundColor(this.mTitleBar, R.color.CAM_X0201);
        this.mNoNetView = (NoNetworkView) findViewById(R.id.view_no_network);
        if (isBarEmotion()) {
            this.mTitleBar.setTitle(this.mActivity.getText(R.string.face_group_make_for_bazhu).toString());
        } else {
            this.mTitleBar.setTitle(this.mActivity.getText(R.string.face_group_make_new).toString());
        }
        this.mTitleBar.setRightText(this.mActivity.getText(R.string.done).toString());
        this.mTitleBar.setRightListener(new b());
        EditText editText = (EditText) findViewById(R.id.edit_name);
        this.mEditName = editText;
        editText.setFilters(new InputFilter[]{new g(20)});
        this.mTvAddPicTip = (TextView) findViewById(R.id.tv_add_pic_tip);
        updateAddPicTip();
        this.mGridView = (GridView) findViewById(R.id.grid_view);
        d.a.j0.y1.g.d dVar = new d.a.j0.y1.g.d(this.mChoosedImageList);
        this.mEmotionAdapter = dVar;
        dVar.f(this);
        this.mGridView.setAdapter((ListAdapter) this.mEmotionAdapter);
        this.mLayoutImage.setListener(new c());
        this.mBazhuTitleLayout = (LinearLayout) findViewById(R.id.bar_name_layout);
        this.mPublishTxtTv = (TextView) findViewById(R.id.tv_publish_to);
        TextView textView = (TextView) findViewById(R.id.tv_publish_bar_name);
        this.mChooseBarTv = textView;
        textView.setOnClickListener(this);
        this.mBazhuTitleLayout.setVisibility(8);
        this.ivArrow = (ImageView) findViewById(R.id.iv_right_arrow);
        this.mBazhuTitleLayout.getViewTreeObserver().addOnGlobalLayoutListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isBarEmotion() {
        return this.isBarEmotion;
    }

    private void loadBarData() {
        if (this.mModel == null) {
            this.mModel = new BarInformationModel(getPageContext());
        }
        this.mModel.s(this);
    }

    private void loadDraft() {
        FaceGroupDraft k = d.a.j0.y1.g.e.l().k();
        if (k != null) {
            if (!TextUtils.isEmpty(k.getName())) {
                this.mEditName.setText(k.getName());
            }
            if (k.getList() == null || k.getList().isEmpty()) {
                return;
            }
            this.mChoosedImageList.addAll(k.getList());
            this.mEmotionAdapter.notifyDataSetChanged();
            updateAddPicTip();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBack() {
        ArrayList<FaceData> arrayList = this.mChoosedImageList;
        if ((arrayList != null && arrayList.size() > 1) || !TextUtils.isEmpty(this.mEditName.getText())) {
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.mActivity);
            aVar.setMessage(getResources().getString(R.string.face_group_make_back_tip));
            aVar.setPositiveButton(R.string.confirm, new e());
            aVar.setNegativeButton(R.string.cancel, new f());
            aVar.create(getPageContext()).show();
            return;
        }
        finish();
    }

    private void updateAddPicTip() {
        this.mTvAddPicTip.setText(String.format(getText(R.string.face_group_add_pic_tip).toString(), Integer.valueOf(this.mChoosedImageList.size() - 1)));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    public void getIntentData() {
        this.isFromBazhu = getIntent().getBooleanExtra(FaceGroupMakeActivityConfig.TYPE_MAKE_FOR_BAIZHU, false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Parcelable parcelableExtra;
        Serializable serializableExtra;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            return;
        }
        if (i2 == 25022) {
            if (intent == null || (serializableExtra = intent.getSerializableExtra(PickFaceTabActivityConfig.CHOOSED_LIST)) == null || !(serializableExtra instanceof List)) {
                return;
            }
            this.mChoosedImageList.clear();
            this.mChoosedImageList.add(this.mAddIconData);
            this.mChoosedImageList.addAll((List) intent.getSerializableExtra(PickFaceTabActivityConfig.CHOOSED_LIST));
            this.mEmotionAdapter.notifyDataSetChanged();
            updateAddPicTip();
        } else if (i2 != 25025 || intent == null || (parcelableExtra = intent.getParcelableExtra(SelectSingleForumActivityConfig.KEY_OUTPUT_FORUM)) == null || !(parcelableExtra instanceof BazhuInfoData.BaInfo)) {
        } else {
            handleForumData((BazhuInfoData.BaInfo) parcelableExtra);
        }
    }

    @Override // d.a.j0.y1.g.d.c
    public void onAdd() {
        ArrayList<FaceData> arrayList = this.mChoosedImageList;
        if (arrayList != null && arrayList.size() - 1 >= 24) {
            showToast(R.string.face_group_add_pic_max);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList<FaceData> arrayList3 = this.mChoosedImageList;
        if (arrayList3 != null) {
            arrayList2.addAll(arrayList3);
        }
        arrayList2.remove(this.mAddIconData);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PickFaceTabActivityConfig(this.mActivity, 25022, arrayList2)));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        onBack();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        getLayoutMode().k(i2 == 1);
        getLayoutMode().j(this.mLayoutRoot);
        SkinManager.setBackgroundResource(this.mLayoutRoot, R.color.CAM_X0201);
        this.mNoNetView.c(getPageContext(), i2);
        SkinManager.setViewTextColor(this.mPublishTxtTv, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.mEditName, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.mTvAddPicTip, R.color.CAM_X0109);
        if (i2 == 0) {
            this.mEditName.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        } else {
            this.mEditName.setHintTextColor(getResources().getColor(R.color.CAM_X0110_1));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view != this.mChooseBarTv || ListUtils.isEmpty(this.mBarList)) {
            return;
        }
        SelectSingleForumActivityConfig selectSingleForumActivityConfig = new SelectSingleForumActivityConfig(getPageContext().getContext(), 25025);
        selectSingleForumActivityConfig.setForumList(this.mBarList);
        sendMessage(new CustomMessage(2002001, selectSingleForumActivityConfig));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        FaceGroupDraft k;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        getIntentData();
        this.mActivity = getPageContext().getPageActivity();
        setContentView(R.layout.face_group_make_activity);
        this.mChoosedImageList = new ArrayList<>();
        FaceData faceData = new FaceData();
        this.mAddIconData = faceData;
        faceData.type = 4;
        this.mChoosedImageList.add(faceData);
        if (this.isFromBazhu && ((k = d.a.j0.y1.g.e.l().k()) == null || k.getForumId() != 0)) {
            this.isBarEmotion = true;
        }
        initView();
        loadDraft();
        if (this.isBarEmotion) {
            loadBarData();
        }
    }

    @Override // d.a.j0.y1.g.d.c
    public void onDel(FaceData faceData) {
        if (faceData == null) {
            return;
        }
        this.mChoosedImageList.remove(faceData);
        this.mEmotionAdapter.notifyDataSetChanged();
        updateAddPicTip();
    }

    @Override // com.baidu.tieba.newfaceshop.BarInformationModel.b
    public void success(BazhuInfoData bazhuInfoData) {
        if (bazhuInfoData != null) {
            this.mBarList = bazhuInfoData.bazhu_info;
        }
        if (ListUtils.isEmpty(this.mBarList)) {
            return;
        }
        this.mBazhuTitleLayout.setVisibility(0);
        if (this.mBarList.size() == 1) {
            this.mChooseBarTv.setText(this.mBarList.get(0).forum_name);
            this.mChooseBarTv.setClickable(false);
            this.ivArrow.setVisibility(8);
            SkinManager.setViewTextColor(this.mChooseBarTv, R.color.CAM_X0109);
            this.mChoosedData = this.mBarList.get(0);
            return;
        }
        this.mChooseBarTv.setClickable(true);
        this.mChooseBarTv.setText(R.string.face_make_choose_forum);
        SkinManager.setViewTextColor(this.mChooseBarTv, R.color.CAM_X0304);
        FaceGroupDraft k = d.a.j0.y1.g.e.l().k();
        if (k == null || k.getForumId() == 0) {
            return;
        }
        Iterator<BazhuInfoData.BaInfo> it = this.mBarList.iterator();
        while (it.hasNext()) {
            BazhuInfoData.BaInfo next = it.next();
            if (next != null && next.forum_id == k.getForumId()) {
                handleForumData(next);
                return;
            }
        }
    }
}
