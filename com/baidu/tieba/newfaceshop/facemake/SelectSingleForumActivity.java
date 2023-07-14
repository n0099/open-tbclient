package com.baidu.tieba.newfaceshop.facemake;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
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
import com.baidu.tieba.sb9;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class SelectSingleForumActivity extends BaseActivity<SelectSingleForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public BdListView b;
    public NavigationBar c;
    public View d;
    public TextView e;
    public sb9 f;
    public List<BazhuInfoData.BaInfo> g;
    public View h;
    public View i;
    public View j;
    public View.OnClickListener k;
    public AdapterView.OnItemClickListener l;

    /* loaded from: classes7.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2.getId() == this.a.a.getId()) {
                if (this.a.z1() == null) {
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(SelectSingleForumActivityConfig.KEY_OUTPUT_FORUM, this.a.z1());
                this.a.setResult(-1, intent);
                this.a.finish();
            } else if (view2.getId() == this.a.d.getId()) {
                this.a.setResult(0);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
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
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                BazhuInfoData.BaInfo baInfo = (BazhuInfoData.BaInfo) this.a.g.get(i);
                CheckBox checkBox = (CheckBox) view2.findViewById(R.id.obfuscated_res_0x7f09266d);
                if (!checkBox.isChecked()) {
                    if (this.a.z1() != null && this.a.z1().isChecked) {
                        this.a.z1().isChecked = false;
                    }
                    baInfo.isChecked = true;
                    checkBox.setChecked(!checkBox.isChecked());
                    this.a.f.notifyDataSetChanged();
                }
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
        this.g = new ArrayList();
        this.k = new a(this);
        this.l = new b(this);
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.setText(R.string.obfuscated_res_0x7f0f1341);
        }
    }

    public final BazhuInfoData.BaInfo z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            for (BazhuInfoData.BaInfo baInfo : this.g) {
                if (baInfo.isChecked) {
                    return baInfo;
                }
            }
            return null;
        }
        return (BazhuInfoData.BaInfo) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.c.onChangeSkinType(getPageContext(), i);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.a, R.drawable.btn_all_blue);
            SkinManager.setViewTextColor(this.a, R.color.CAM_X0111, 1);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            this.f.c(i);
            this.b.setSelector(SkinManager.getDrawable(R.drawable.selector_select_forum_item));
            SkinManager.setBackgroundColor(this.j, R.color.cp_bg_line_d_alpha95);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0891);
            this.h = findViewById(R.id.obfuscated_res_0x7f091f6a);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.c = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d = addSystemImageButton;
            if (addSystemImageButton.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
                layoutParams.leftMargin = yi.g(getActivity(), R.dimen.obfuscated_res_0x7f070359);
                this.d.setLayoutParams(layoutParams);
            }
            this.e = this.c.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0645));
            this.d.setOnClickListener(this.k);
            this.i = findViewById(R.id.view_divider);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09266e);
            this.a = textView;
            textView.setOnClickListener(this.k);
            this.j = findViewById(R.id.obfuscated_res_0x7f091478);
            this.b = (BdListView) findViewById(R.id.obfuscated_res_0x7f092672);
            if (getIntent() != null) {
                ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST");
                if (ListUtils.getCount(parcelableArrayListExtra) > 0) {
                    this.g.addAll(parcelableArrayListExtra);
                }
            }
            this.b.setOnItemClickListener(this.l);
            sb9 sb9Var = new sb9(getActivity());
            this.f = sb9Var;
            this.b.setAdapter((ListAdapter) sb9Var);
            this.f.b(this.g);
            A1();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
