package com.baidu.tieba.newfaceshop.facemake;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.r0.l2.g.i;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectSingleForumActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.BazhuInfoData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class SelectSingleForumActivity extends BaseActivity<SelectSingleForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i mAdapter;
    public View mBackView;
    public List<BazhuInfoData.BaInfo> mDataList;
    public View mDivider;
    public View mLayoutConfirm;
    public BdListView mListView;
    public NavigationBar mNavigationBar;
    public View.OnClickListener mOnClickListener;
    public AdapterView.OnItemClickListener mOnItemClickListener;
    public View mRootView;
    public TextView mTitleView;
    public TextView mTransmitConfirmButton;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectSingleForumActivity f47261e;

        public a(SelectSingleForumActivity selectSingleForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectSingleForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47261e = selectSingleForumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view.getId() == this.f47261e.mTransmitConfirmButton.getId()) {
                if (this.f47261e.getSelectedData() == null) {
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(SelectSingleForumActivityConfig.KEY_OUTPUT_FORUM, this.f47261e.getSelectedData());
                this.f47261e.setResult(-1, intent);
                this.f47261e.finish();
            } else if (view.getId() == this.f47261e.mBackView.getId()) {
                this.f47261e.setResult(0);
                this.f47261e.finish();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectSingleForumActivity f47262e;

        public b(SelectSingleForumActivity selectSingleForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectSingleForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47262e = selectSingleForumActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                BazhuInfoData.BaInfo baInfo = (BazhuInfoData.BaInfo) this.f47262e.mDataList.get(i2);
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
                if (checkBox.isChecked()) {
                    return;
                }
                if (this.f47262e.getSelectedData() != null && this.f47262e.getSelectedData().isChecked) {
                    this.f47262e.getSelectedData().isChecked = false;
                }
                baInfo.isChecked = true;
                checkBox.setChecked(!checkBox.isChecked());
                this.f47262e.mAdapter.notifyDataSetChanged();
            }
        }
    }

    public SelectSingleForumActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDataList = new ArrayList();
        this.mOnClickListener = new a(this);
        this.mOnItemClickListener = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BazhuInfoData.BaInfo getSelectedData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            for (BazhuInfoData.BaInfo baInfo : this.mDataList) {
                if (baInfo.isChecked) {
                    return baInfo;
                }
            }
            return null;
        }
        return (BazhuInfoData.BaInfo) invokeV.objValue;
    }

    private void setTransmitConfirmButtonText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mTransmitConfirmButton.setText(R.string.select_single_forum_confirm);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.mTransmitConfirmButton, R.drawable.btn_all_blue);
            SkinManager.setViewTextColor(this.mTransmitConfirmButton, R.color.CAM_X0111, 1);
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
            this.mAdapter.c(i2);
            this.mListView.setSelector(SkinManager.getDrawable(R.drawable.selector_select_forum_item));
            SkinManager.setBackgroundColor(this.mLayoutConfirm, R.color.cp_bg_line_d_alpha95);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.select_single_forum_activity);
            this.mRootView = findViewById(R.id.root_view);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mBackView = addSystemImageButton;
            if (addSystemImageButton.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBackView.getLayoutParams();
                layoutParams.leftMargin = l.f(getActivity(), R.dimen.ds10);
                this.mBackView.setLayoutParams(layoutParams);
            }
            this.mTitleView = this.mNavigationBar.setCenterTextTitle(getString(R.string.emotion_make_select_bar));
            this.mBackView.setOnClickListener(this.mOnClickListener);
            this.mDivider = findViewById(R.id.view_divider);
            TextView textView = (TextView) findViewById(R.id.transmit_confirm);
            this.mTransmitConfirmButton = textView;
            textView.setOnClickListener(this.mOnClickListener);
            this.mLayoutConfirm = findViewById(R.id.layout_confirm);
            this.mListView = (BdListView) findViewById(R.id.trasmit_grid_view);
            if (getIntent() != null) {
                ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST");
                if (ListUtils.getCount(parcelableArrayListExtra) > 0) {
                    this.mDataList.addAll(parcelableArrayListExtra);
                }
            }
            this.mListView.setOnItemClickListener(this.mOnItemClickListener);
            i iVar = new i(getActivity());
            this.mAdapter = iVar;
            this.mListView.setAdapter((ListAdapter) iVar);
            this.mAdapter.b(this.mDataList);
            setTransmitConfirmButtonText();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
