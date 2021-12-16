package com.baidu.tieba.tblauncherInterestGuide;

import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import c.a.s0.z3.c;
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
/* loaded from: classes12.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NEWUSERINTERESTSELECT = "newUserInterestSelect";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Hashtable<Integer, TbImageView> f49993e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f49994f;

    /* renamed from: g  reason: collision with root package name */
    public View f49995g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f49996h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f49997i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f49998j;

    /* renamed from: k  reason: collision with root package name */
    public TbImageView f49999k;
    public TbImageView l;
    public TbImageView m;
    public TbImageView n;
    public TbImageView o;
    public TbImageView p;
    public TbImageView q;
    public NewUserGuideActivity r;
    public NewUserGuideModel s;
    public Button t;
    public boolean u;
    public boolean v;
    public boolean w;
    public final View.OnClickListener x;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewUserGuideMainFragment f50000e;

        /* renamed from: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class C1932a implements b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C1932a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                    this.a.f50000e.f49995g.setVisibility(8);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50000e = newUserGuideMainFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                    if (view == this.f50000e.t) {
                        if (this.f50000e.r.getIsChanged()) {
                            TbadkApplication.getInst().setLikeBarChanged(true);
                        }
                        this.f50000e.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.f50000e.r.getPageContext().getPageActivity()).createNewUserCfg(1, this.f50000e.u)));
                        this.f50000e.r.finish();
                    }
                } else if (this.f50000e.w) {
                    this.f50000e.w = false;
                    TiebaStatic.log("newUserInterestSelect");
                    c cVar = new c(this.f50000e.r, (InterestFrsData.Tag) view.getTag(), new C1932a(this));
                    this.f50000e.f49995g.setVisibility(0);
                    cVar.d();
                    this.f50000e.w = true;
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void a();
    }

    public NewUserGuideMainFragment() {
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
        this.f49993e = new Hashtable<>();
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = new a(this);
    }

    public final void j(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) || this.s == null || this.v) {
            return;
        }
        if (bundle != null) {
            this.u = bundle.getBoolean("is_new_user");
        } else {
            this.u = this.r.getIntent().getBooleanExtra("is_new_user", false);
        }
        k(this.s.y());
    }

    public final void k(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interestFrsData) == null) || interestFrsData == null || (tag_list = interestFrsData.getTag_list()) == null || tag_list.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < tag_list.size(); i2++) {
            InterestFrsData.Tag tag = tag_list.get(i2);
            if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.f49993e.get(Integer.valueOf(tag.getBid()))) != null) {
                tbImageView.setTag(tag);
                tbImageView.startLoad(tag.getBicon(), 21, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            NewUserGuideActivity newUserGuideActivity = (NewUserGuideActivity) getBaseFragmentActivity();
            this.r = newUserGuideActivity;
            this.s = newUserGuideActivity.getNewUserGuideModel();
            j(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) {
            try {
                ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(R.layout.guide_main, (ViewGroup) null);
                this.f49994f = viewGroup2;
                this.f49995g = viewGroup2.findViewById(R.id.root_main_view_cover);
                this.f49996h = (TbImageView) this.f49994f.findViewById(R.id.icon_1);
                this.f49997i = (TbImageView) this.f49994f.findViewById(R.id.icon_2);
                this.f49998j = (TbImageView) this.f49994f.findViewById(R.id.icon_3);
                this.f49999k = (TbImageView) this.f49994f.findViewById(R.id.icon_4);
                this.l = (TbImageView) this.f49994f.findViewById(R.id.icon_5);
                this.m = (TbImageView) this.f49994f.findViewById(R.id.icon_6);
                this.n = (TbImageView) this.f49994f.findViewById(R.id.icon_7);
                this.o = (TbImageView) this.f49994f.findViewById(R.id.icon_8);
                this.p = (TbImageView) this.f49994f.findViewById(R.id.icon_9);
                this.q = (TbImageView) this.f49994f.findViewById(R.id.icon_10);
                this.t = (Button) this.f49994f.findViewById(R.id.btn_next);
                this.f49993e.put(1, this.f49996h);
                this.f49993e.put(2, this.f49997i);
                this.f49993e.put(3, this.f49998j);
                this.f49993e.put(4, this.f49999k);
                this.f49993e.put(5, this.l);
                this.f49993e.put(6, this.m);
                this.f49993e.put(7, this.n);
                this.f49993e.put(8, this.o);
                this.f49993e.put(9, this.p);
                this.f49993e.put(10, this.q);
                this.t.setOnClickListener(this.x);
                this.f49996h.setOnClickListener(this.x);
                this.f49997i.setOnClickListener(this.x);
                this.f49998j.setOnClickListener(this.x);
                this.f49999k.setOnClickListener(this.x);
                this.l.setOnClickListener(this.x);
                this.m.setOnClickListener(this.x);
                this.n.setOnClickListener(this.x);
                this.o.setOnClickListener(this.x);
                this.p.setOnClickListener(this.x);
                this.p.setOnClickListener(this.x);
                this.q.setOnClickListener(this.x);
                return this.f49994f;
            } catch (InflateException e2) {
                if (!TbadkApplication.getInst().isDebugMode()) {
                    BdLog.e(e2);
                    this.r.startMainTabEnterFourm();
                    TbadkApplication.getInst().onAppMemoryLow();
                    return new FrameLayout(layoutInflater.getContext());
                }
                throw e2;
            }
        }
        return (View) invokeLLL.objValue;
    }

    public void setData(InterestFrsData interestFrsData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, interestFrsData) == null) {
            k(interestFrsData);
            this.v = true;
        }
    }
}
