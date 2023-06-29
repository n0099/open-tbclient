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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
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
import com.baidu.tieba.g55;
import com.baidu.tieba.h05;
import com.baidu.tieba.j59;
import com.baidu.tieba.k59;
import com.baidu.tieba.newfaceshop.BarInformationModel;
import com.baidu.tieba.newfaceshop.facemake.FaceImageLayout;
import com.baidu.tieba.xi;
import com.baidu.tieba.zx5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class FaceGroupMakeActivity extends BaseActivity implements j59.c, BarInformationModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public FaceGroupMakeTitleBar b;
    public NoNetworkView c;
    public TextView d;
    public GridView e;
    public EditText f;
    public LinearLayout g;
    public FaceImageLayout h;
    public LinearLayout i;
    public TextView j;
    public TextView k;
    public ImageView l;
    public j59 m;
    public ArrayList<FaceData> n;
    public FaceData o;
    public Activity p;
    public boolean q;
    public boolean r;
    public BarInformationModel s;
    public ArrayList<BazhuInfoData.BaInfo> t;
    public BazhuInfoData.BaInfo u;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceGroupMakeActivity a;

        public a(FaceGroupMakeActivity faceGroupMakeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceGroupMakeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.P1();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceGroupMakeActivity a;

        public b(FaceGroupMakeActivity faceGroupMakeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceGroupMakeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.n == null) {
                return;
            }
            String trim = this.a.f.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f06e9);
            } else if (this.a.n.size() - 1 < 8) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f06f3);
            } else if (this.a.n.size() - 1 > 24) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f06e7);
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0e0f);
            } else if (this.a.M1() && this.a.u == null) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0a84);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.a.n);
                arrayList.remove(this.a.o);
                k59 l = k59.l();
                if (this.a.u != null) {
                    i = this.a.u.forum_id;
                } else {
                    i = 0;
                }
                l.A(trim, arrayList, null, i);
                Intent intent = new Intent();
                intent.putExtra(DownloadStatisticConstants.UBC_PAGE_UPLOADING, true);
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements FaceImageLayout.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceGroupMakeActivity a;

        public c(FaceGroupMakeActivity faceGroupMakeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceGroupMakeActivity;
        }

        @Override // com.baidu.tieba.newfaceshop.facemake.FaceImageLayout.a
        public void onIntercept() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xi.z(this.a.p, this.a.f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceGroupMakeActivity a;

        public d(FaceGroupMakeActivity faceGroupMakeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceGroupMakeActivity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k.setMaxWidth(((this.a.i.getWidth() - this.a.j.getWidth()) - this.a.l.getWidth()) - xi.g(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0703b0));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements g55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceGroupMakeActivity a;

        public e(FaceGroupMakeActivity faceGroupMakeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceGroupMakeActivity;
        }

        @Override // com.baidu.tieba.g55.e
        public void onClick(g55 g55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g55Var) == null) {
                g55Var.dismiss();
                k59.l().i();
                this.a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements g55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceGroupMakeActivity a;

        public f(FaceGroupMakeActivity faceGroupMakeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceGroupMakeActivity;
        }

        @Override // com.baidu.tieba.g55.e
        public void onClick(g55 g55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g55Var) == null) {
                g55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ FaceGroupMakeActivity b;

        public g(FaceGroupMakeActivity faceGroupMakeActivity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = faceGroupMakeActivity;
            this.a = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                if (spanned != null && charSequence != null && (zx5.c(spanned.toString()) - (i4 - i3)) + zx5.c(charSequence.toString()) > this.a) {
                    this.b.showToast(R.string.obfuscated_res_0x7f0f0f00);
                    return "";
                }
                return charSequence;
            }
            return (CharSequence) invokeCommon.objValue;
        }
    }

    public FaceGroupMakeActivity() {
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
        this.q = false;
        this.r = false;
    }

    public void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.q = getIntent().getBooleanExtra(FaceGroupMakeActivityConfig.TYPE_MAKE_FOR_BAIZHU, false);
        }
    }

    public final boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.s == null) {
                this.s = new BarInformationModel(getPageContext());
            }
            this.s.U(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            P1();
        }
    }

    @Override // com.baidu.tieba.j59.c
    public void W0(FaceData faceData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, faceData) != null) || faceData == null) {
            return;
        }
        this.n.remove(faceData);
        this.m.notifyDataSetChanged();
        Q1();
    }

    @Override // com.baidu.tieba.newfaceshop.BarInformationModel.b
    public void D(BazhuInfoData bazhuInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bazhuInfoData) == null) {
            if (bazhuInfoData != null) {
                this.t = bazhuInfoData.bazhu_info;
            }
            if (ListUtils.isEmpty(this.t)) {
                return;
            }
            this.i.setVisibility(0);
            if (this.t.size() == 1) {
                this.k.setText(this.t.get(0).forum_name);
                this.k.setClickable(false);
                this.l.setVisibility(8);
                SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
                this.u = this.t.get(0);
                return;
            }
            this.k.setClickable(true);
            this.k.setText(R.string.obfuscated_res_0x7f0f06f7);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0304);
            FaceGroupDraft k = k59.l().k();
            if (k != null && k.getForumId() != 0) {
                Iterator<BazhuInfoData.BaInfo> it = this.t.iterator();
                while (it.hasNext()) {
                    BazhuInfoData.BaInfo next = it.next();
                    if (next != null && next.forum_id == k.getForumId()) {
                        L1(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.j59.c
    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList<FaceData> arrayList = this.n;
            if (arrayList != null && arrayList.size() - 1 >= 24) {
                showToast(R.string.obfuscated_res_0x7f0f06e7);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList<FaceData> arrayList3 = this.n;
            if (arrayList3 != null) {
                arrayList2.addAll(arrayList3);
            }
            arrayList2.remove(this.o);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PickFaceTabActivityConfig(this.p, 25022, arrayList2)));
        }
    }

    public final void O1() {
        FaceGroupDraft k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (k = k59.l().k()) != null) {
            if (!TextUtils.isEmpty(k.getName())) {
                this.f.setText(k.getName());
            }
            if (k.getList() != null && !k.getList().isEmpty()) {
                this.n.addAll(k.getList());
                this.m.notifyDataSetChanged();
                Q1();
            }
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ArrayList<FaceData> arrayList = this.n;
            if ((arrayList != null && arrayList.size() > 1) || !TextUtils.isEmpty(this.f.getText())) {
                g55 g55Var = new g55(this.p);
                g55Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f06ed));
                g55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04be, new e(this));
                g55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03cc, new f(this));
                g55Var.create(getPageContext()).show();
                return;
            }
            finish();
        }
    }

    public final void L1(BazhuInfoData.BaInfo baInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, baInfo) == null) && baInfo != null && baInfo.forum_id > 0 && !TextUtils.isEmpty(baInfo.forum_name)) {
            if (this.u == null) {
                this.u = new BazhuInfoData.BaInfo();
            }
            BazhuInfoData.BaInfo baInfo2 = this.u;
            baInfo2.forum_id = baInfo.forum_id;
            String str = baInfo.forum_name;
            baInfo2.forum_name = str;
            this.k.setText(str);
            if (ListUtils.isEmpty(this.t)) {
                return;
            }
            Iterator<BazhuInfoData.BaInfo> it = this.t.iterator();
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        FaceGroupDraft k;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            K1();
            this.p = getPageContext().getPageActivity();
            setContentView(R.layout.obfuscated_res_0x7f0d02be);
            this.n = new ArrayList<>();
            FaceData faceData = new FaceData();
            this.o = faceData;
            faceData.type = 4;
            this.n.add(faceData);
            if (this.q && ((k = k59.l().k()) == null || k.getForumId() != 0)) {
                this.r = true;
            }
            initView();
            O1();
            if (this.r) {
                N1();
            }
        }
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.d.setText(String.format(getText(R.string.obfuscated_res_0x7f0f06e8).toString(), Integer.valueOf(this.n.size() - 1)));
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.g = (LinearLayout) findViewById(R.id.layout_root);
            this.h = (FaceImageLayout) findViewById(R.id.obfuscated_res_0x7f091474);
            this.a = (NavigationBar) findViewById(R.id.navigation_bar);
            this.b = new FaceGroupMakeTitleBar(this.p);
            this.b.setLayoutParams(new RelativeLayout.LayoutParams(xi.l(getPageContext().getPageActivity()), -1));
            this.b.setCloseListener(new a(this));
            this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.b, (View.OnClickListener) null);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0201);
            this.c = (NoNetworkView) findViewById(R.id.view_no_network);
            if (M1()) {
                this.b.setTitle(this.p.getText(R.string.obfuscated_res_0x7f0f06ee).toString());
            } else {
                this.b.setTitle(this.p.getText(R.string.obfuscated_res_0x7f0f06ef).toString());
            }
            this.b.setRightText(this.p.getText(R.string.obfuscated_res_0x7f0f05a4).toString());
            this.b.setRightListener(new b(this));
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f09096b);
            this.f = editText;
            editText.setFilters(new InputFilter[]{new g(this, 20)});
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f09266c);
            Q1();
            this.e = (GridView) findViewById(R.id.obfuscated_res_0x7f090e5e);
            j59 j59Var = new j59(this.n);
            this.m = j59Var;
            j59Var.f(this);
            this.e.setAdapter((ListAdapter) this.m);
            this.h.setListener(new c(this));
            this.i = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090356);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f09270d);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09270c);
            this.k = textView;
            textView.setOnClickListener(this);
            this.i.setVisibility(8);
            this.l = (ImageView) findViewById(R.id.obfuscated_res_0x7f091208);
            this.i.getViewTreeObserver().addOnGlobalLayoutListener(new d(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Parcelable parcelableExtra;
        Serializable serializableExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 != -1) {
                return;
            }
            if (i == 25022) {
                if (intent != null && (serializableExtra = intent.getSerializableExtra(PickFaceTabActivityConfig.CHOOSED_LIST)) != null && (serializableExtra instanceof List)) {
                    this.n.clear();
                    this.n.add(this.o);
                    this.n.addAll((List) intent.getSerializableExtra(PickFaceTabActivityConfig.CHOOSED_LIST));
                    this.m.notifyDataSetChanged();
                    Q1();
                }
            } else if (i == 25025 && intent != null && (parcelableExtra = intent.getParcelableExtra(SelectSingleForumActivityConfig.KEY_OUTPUT_FORUM)) != null && (parcelableExtra instanceof BazhuInfoData.BaInfo)) {
                L1((BazhuInfoData.BaInfo) parcelableExtra);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.onChangeSkinType(getPageContext(), i);
            h05 layoutMode = getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            getLayoutMode().k(this.g);
            SkinManager.setBackgroundResource(this.g, R.color.CAM_X0201);
            this.c.d(getPageContext(), i);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            if (i == 0) {
                this.f.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
            } else {
                this.f.setHintTextColor(getResources().getColor(R.color.CAM_X0110_2));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.k && !ListUtils.isEmpty(this.t)) {
                SelectSingleForumActivityConfig selectSingleForumActivityConfig = new SelectSingleForumActivityConfig(getPageContext().getContext(), 25025);
                selectSingleForumActivityConfig.setForumList(this.t);
                sendMessage(new CustomMessage(2002001, selectSingleForumActivityConfig));
            }
        }
    }
}
