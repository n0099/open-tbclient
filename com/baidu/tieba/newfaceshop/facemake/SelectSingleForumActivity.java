package com.baidu.tieba.newfaceshop.facemake;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.r2.g.i;
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
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectSingleForumActivity a;

        public a(SelectSingleForumActivity selectSingleForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectSingleForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectSingleForumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view.getId() == this.a.mTransmitConfirmButton.getId()) {
                if (this.a.getSelectedData() == null) {
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(SelectSingleForumActivityConfig.KEY_OUTPUT_FORUM, this.a.getSelectedData());
                this.a.setResult(-1, intent);
                this.a.finish();
            } else if (view.getId() == this.a.mBackView.getId()) {
                this.a.setResult(0);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectSingleForumActivity a;

        public b(SelectSingleForumActivity selectSingleForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectSingleForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectSingleForumActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                BazhuInfoData.BaInfo baInfo = (BazhuInfoData.BaInfo) this.a.mDataList.get(i);
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.obfuscated_res_0x7f092145);
                if (checkBox.isChecked()) {
                    return;
                }
                if (this.a.getSelectedData() != null && this.a.getSelectedData().isChecked) {
                    this.a.getSelectedData().isChecked = false;
                }
                baInfo.isChecked = true;
                checkBox.setChecked(!checkBox.isChecked());
                this.a.mAdapter.notifyDataSetChanged();
            }
        }
    }

    public SelectSingleForumActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.mTransmitConfirmButton.setText(R.string.obfuscated_res_0x7f0f10cd);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            SkinManager.setViewTextColor(this.mTitleView, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.mTransmitConfirmButton, R.drawable.btn_all_blue);
            SkinManager.setViewTextColor(this.mTransmitConfirmButton, R.color.CAM_X0111, 1);
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
            this.mAdapter.c(i);
            this.mListView.setSelector(SkinManager.getDrawable(R.drawable.selector_select_forum_item));
            SkinManager.setBackgroundColor(this.mLayoutConfirm, R.color.cp_bg_line_d_alpha95);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0768);
            this.mRootView = findViewById(R.id.obfuscated_res_0x7f091aee);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.mNavigationBar = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mBackView = addSystemImageButton;
            if (addSystemImageButton.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBackView.getLayoutParams();
                layoutParams.leftMargin = n.f(getActivity(), R.dimen.obfuscated_res_0x7f070229);
                this.mBackView.setLayoutParams(layoutParams);
            }
            this.mTitleView = this.mNavigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f053f));
            this.mBackView.setOnClickListener(this.mOnClickListener);
            this.mDivider = findViewById(R.id.obfuscated_res_0x7f0923bb);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092147);
            this.mTransmitConfirmButton = textView;
            textView.setOnClickListener(this.mOnClickListener);
            this.mLayoutConfirm = findViewById(R.id.obfuscated_res_0x7f0911d0);
            this.mListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f09214d);
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
