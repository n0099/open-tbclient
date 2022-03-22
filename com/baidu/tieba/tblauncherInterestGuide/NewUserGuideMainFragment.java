package com.baidu.tieba.tblauncherInterestGuide;

import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import c.a.p0.d4.f;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes6.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Hashtable<Integer, TbImageView> a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f36264b;

    /* renamed from: c  reason: collision with root package name */
    public View f36265c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f36266d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f36267e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f36268f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f36269g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f36270h;
    public TbImageView i;
    public TbImageView j;
    public TbImageView k;
    public TbImageView l;
    public TbImageView m;
    public NewUserGuideActivity n;
    public NewUserGuideModel o;
    public Button p;
    public boolean q;
    public boolean r;
    public boolean s;
    public final View.OnClickListener t;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewUserGuideMainFragment a;

        /* renamed from: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1892a implements b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C1892a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.f36265c.setVisibility(8);
                }
            }
        }

        public a(NewUserGuideMainFragment newUserGuideMainFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newUserGuideMainFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newUserGuideMainFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                    if (view == this.a.p) {
                        if (this.a.n.getIsChanged()) {
                            TbadkApplication.getInst().setLikeBarChanged(true);
                        }
                        this.a.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.a.n.getPageContext().getPageActivity()).createNewUserCfg(1, this.a.q)));
                        this.a.n.finish();
                    }
                } else if (this.a.s) {
                    this.a.s = false;
                    TiebaStatic.log("newUserInterestSelect");
                    f fVar = new f(this.a.n, (InterestFrsData.Tag) view.getTag(), new C1892a(this));
                    this.a.f36265c.setVisibility(0);
                    fVar.d();
                    this.a.s = true;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();
    }

    public NewUserGuideMainFragment() {
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
        this.a = new Hashtable<>();
        this.q = false;
        this.r = false;
        this.s = true;
        this.t = new a(this);
    }

    public final void I0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) || this.o == null || this.r) {
            return;
        }
        if (bundle != null) {
            this.q = bundle.getBoolean("is_new_user");
        } else {
            this.q = this.n.getIntent().getBooleanExtra("is_new_user", false);
        }
        J0(this.o.A());
    }

    public final void J0(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interestFrsData) == null) || interestFrsData == null || (tag_list = interestFrsData.getTag_list()) == null || tag_list.size() == 0) {
            return;
        }
        for (int i = 0; i < tag_list.size(); i++) {
            InterestFrsData.Tag tag = tag_list.get(i);
            if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.a.get(Integer.valueOf(tag.getBid()))) != null) {
                tbImageView.setTag(tag);
                tbImageView.J(tag.getBicon(), 21, false);
            }
        }
    }

    public void K0(InterestFrsData interestFrsData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interestFrsData) == null) {
            J0(interestFrsData);
            this.r = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            NewUserGuideActivity newUserGuideActivity = (NewUserGuideActivity) getBaseFragmentActivity();
            this.n = newUserGuideActivity;
            this.o = newUserGuideActivity.getNewUserGuideModel();
            I0(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            try {
                ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0393, (ViewGroup) null);
                this.f36264b = viewGroup2;
                this.f36265c = viewGroup2.findViewById(R.id.obfuscated_res_0x7f091ae8);
                this.f36266d = (TbImageView) this.f36264b.findViewById(R.id.obfuscated_res_0x7f090e0a);
                this.f36267e = (TbImageView) this.f36264b.findViewById(R.id.obfuscated_res_0x7f090e0c);
                this.f36268f = (TbImageView) this.f36264b.findViewById(R.id.obfuscated_res_0x7f090e0d);
                this.f36269g = (TbImageView) this.f36264b.findViewById(R.id.obfuscated_res_0x7f090e0e);
                this.f36270h = (TbImageView) this.f36264b.findViewById(R.id.obfuscated_res_0x7f090e0f);
                this.i = (TbImageView) this.f36264b.findViewById(R.id.obfuscated_res_0x7f090e10);
                this.j = (TbImageView) this.f36264b.findViewById(R.id.obfuscated_res_0x7f090e11);
                this.k = (TbImageView) this.f36264b.findViewById(R.id.obfuscated_res_0x7f090e12);
                this.l = (TbImageView) this.f36264b.findViewById(R.id.obfuscated_res_0x7f090e13);
                this.m = (TbImageView) this.f36264b.findViewById(R.id.obfuscated_res_0x7f090e0b);
                this.p = (Button) this.f36264b.findViewById(R.id.obfuscated_res_0x7f090427);
                this.a.put(1, this.f36266d);
                this.a.put(2, this.f36267e);
                this.a.put(3, this.f36268f);
                this.a.put(4, this.f36269g);
                this.a.put(5, this.f36270h);
                this.a.put(6, this.i);
                this.a.put(7, this.j);
                this.a.put(8, this.k);
                this.a.put(9, this.l);
                this.a.put(10, this.m);
                this.p.setOnClickListener(this.t);
                this.f36266d.setOnClickListener(this.t);
                this.f36267e.setOnClickListener(this.t);
                this.f36268f.setOnClickListener(this.t);
                this.f36269g.setOnClickListener(this.t);
                this.f36270h.setOnClickListener(this.t);
                this.i.setOnClickListener(this.t);
                this.j.setOnClickListener(this.t);
                this.k.setOnClickListener(this.t);
                this.l.setOnClickListener(this.t);
                this.l.setOnClickListener(this.t);
                this.m.setOnClickListener(this.t);
                return this.f36264b;
            } catch (InflateException e2) {
                if (!TbadkApplication.getInst().isDebugMode()) {
                    BdLog.e(e2);
                    this.n.startMainTabEnterFourm();
                    TbadkApplication.getInst().onAppMemoryLow();
                    return new FrameLayout(layoutInflater.getContext());
                }
                throw e2;
            }
        }
        return (View) invokeLLL.objValue;
    }
}
