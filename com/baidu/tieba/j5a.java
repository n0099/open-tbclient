package com.baidu.tieba;

import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.switchs.RichTextGifViewSwitch;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.tieba.setting.more.BrowseSettingActivity;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class j5a extends BdBaseView<BrowseSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BrowseSettingActivity a;
    public View b;
    public NavigationBar c;
    public TbSettingTextTipView d;
    public TbSettingTextTipView e;
    public TbSettingTextTipView f;
    public TbSettingTextTipView g;
    public MsgSettingItemView h;
    public kz4 i;
    public kz4 j;
    public kz4 k;
    public kz4 l;
    public ArrayList<tz4> m;
    public ArrayList<tz4> n;
    public ArrayList<tz4> o;
    public ArrayList<tz4> p;
    public TbSettingTextTipView q;
    public TbSettingTextTipView r;
    public final AdapterView.OnItemClickListener s;
    public final AdapterView.OnItemClickListener t;
    public final AdapterView.OnItemClickListener u;
    public final AdapterView.OnItemClickListener v;

    /* loaded from: classes6.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(j5a j5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void z(View view2, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
                SharedPrefHelper.getInstance().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new StatisticItem("c13396").param("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new StatisticItem("c13396").param("obj_type", 2));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j5a a;

        public b(j5a j5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j5aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.i.h(i);
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                uu4.c().j(false);
                            }
                        } else {
                            uu4.c().j(true);
                            uu4.c().k(2);
                            TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 3));
                        }
                    } else {
                        uu4.c().j(true);
                        uu4.c().k(1);
                        TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 1));
                    }
                } else {
                    uu4.c().j(true);
                    uu4.c().k(0);
                }
                this.a.i.d();
                this.a.U();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j5a a;

        public c(j5a j5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j5aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.j.h(i);
                int i2 = 0;
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 3));
                        }
                    } else {
                        TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 2));
                        i2 = 2;
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 1));
                    i2 = 1;
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(this.a.a.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                uu4.c().i(i2);
                this.a.V(i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j5a a;

        public d(j5a j5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j5aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.k.h(i);
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                TbadkCoreApplication.getInst().setFontSize(3);
                            }
                        } else {
                            TbadkCoreApplication.getInst().setFontSize(2);
                        }
                    } else {
                        TbadkCoreApplication.getInst().setFontSize(1);
                    }
                } else {
                    TbadkCoreApplication.getInst().setFontSize(0);
                }
                this.a.T();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j5a a;

        public e(j5a j5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j5aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.l.h(i);
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            TbadkCoreApplication.getInst().setVideoAutoPlay(3);
                            TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 3));
                        }
                    } else {
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 1));
                    }
                } else {
                    TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                    TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 2));
                }
                this.a.W();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j5a(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {browseSettingActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.s = new b(this);
        this.t = new c(this);
        this.u = new d(this);
        this.v = new e(this);
        this.a = browseSettingActivity;
        K();
        R();
        J();
    }

    public TbSettingTextTipView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.q;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.r;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            G();
            this.j.n();
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            H();
            this.k.n();
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            I();
            this.i.n();
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            L();
            this.l.n();
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            V(uu4.c().b());
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            U();
            Q();
            T();
            W();
            S();
        }
    }

    public final void G() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.o = new ArrayList<>();
            int b2 = uu4.c().b();
            ArrayList<tz4> arrayList = this.o;
            String string = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a91);
            boolean z3 = false;
            if (b2 == 1) {
                z = true;
            } else {
                z = false;
            }
            arrayList.add(new tz4(string, (String) null, z));
            ArrayList<tz4> arrayList2 = this.o;
            String string2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a8f);
            if (b2 == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList2.add(new tz4(string2, (String) null, z2));
            ArrayList<tz4> arrayList3 = this.o;
            String string3 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a90);
            if (b2 == 0) {
                z3 = true;
            }
            arrayList3.add(new tz4(string3, (String) null, z3));
            kz4 kz4Var = new kz4(this.a.getPageContext());
            kz4Var.l(R.string.obfuscated_res_0x7f0f00fa);
            this.j = kz4Var;
            kz4Var.k(this.o, this.t);
            kz4Var.c();
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (TbadkCoreApplication.getInst().getFontSize() == 0) {
                this.f.setTip(this.mContext.getString(R.string.font_size_xlarge));
            } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
                this.f.setTip(this.mContext.getString(R.string.font_size_big));
            } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
                this.f.setTip(this.mContext.getString(R.string.font_size_mid));
            } else {
                this.f.setTip(this.mContext.getString(R.string.font_size_small));
            }
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!uu4.c().g()) {
                this.d.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f0476));
            } else if (uu4.c().e() == 1) {
                this.d.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f182c));
            } else if (uu4.c().e() == 2) {
                this.d.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f1833));
            } else {
                this.d.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f182f));
            }
        }
    }

    public final void H() {
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k = new kz4(this.a.getPageContext());
            this.m = new ArrayList<>();
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            ArrayList<tz4> arrayList = this.m;
            String string = this.a.getPageContext().getString(R.string.font_size_xlarge);
            boolean z4 = false;
            if (fontSize == 0) {
                z = true;
            } else {
                z = false;
            }
            arrayList.add(new tz4(string, (String) null, z));
            ArrayList<tz4> arrayList2 = this.m;
            String string2 = this.a.getPageContext().getString(R.string.font_size_big);
            if (fontSize == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList2.add(new tz4(string2, (String) null, z2));
            ArrayList<tz4> arrayList3 = this.m;
            String string3 = this.a.getPageContext().getString(R.string.font_size_mid);
            if (fontSize == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList3.add(new tz4(string3, (String) null, z3));
            ArrayList<tz4> arrayList4 = this.m;
            String string4 = this.a.getPageContext().getString(R.string.font_size_small);
            if (fontSize == 3) {
                z4 = true;
            }
            arrayList4.add(new tz4(string4, (String) null, z4));
            this.k.l(R.string.font_size);
            this.k.k(this.m, this.u);
            this.k.c();
        }
    }

    public final void I() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.n = new ArrayList<>();
            int e2 = uu4.c().e();
            boolean g = uu4.c().g();
            ArrayList<tz4> arrayList = this.n;
            String string = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f182f);
            String string2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1830);
            boolean z3 = false;
            if (g && e2 == 0) {
                z = true;
            } else {
                z = false;
            }
            arrayList.add(new tz4(string, string2, z));
            ArrayList<tz4> arrayList2 = this.n;
            String string3 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f182c);
            String string4 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1831);
            if (g && e2 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList2.add(new tz4(string3, string4, z2));
            ArrayList<tz4> arrayList3 = this.n;
            String string5 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1833);
            String string6 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1832);
            if (g && e2 == 2) {
                z3 = true;
            }
            arrayList3.add(new tz4(string5, string6, z3));
            kz4 kz4Var = new kz4(this.a.getPageContext());
            this.i = kz4Var;
            kz4Var.l(R.string.obfuscated_res_0x7f0f0390);
            kz4 kz4Var2 = this.i;
            kz4Var2.k(this.n, this.s);
            kz4Var2.c();
        }
    }

    public final void L() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = new kz4(this.a.getPageContext());
            this.p = new ArrayList<>();
            int autoPlaySwitch = TbadkCoreApplication.getInst().getAutoPlaySwitch();
            ArrayList<tz4> arrayList = this.p;
            String string = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f17e6);
            boolean z3 = false;
            if (autoPlaySwitch == 2) {
                z = true;
            } else {
                z = false;
            }
            arrayList.add(new tz4(string, (String) null, z));
            ArrayList<tz4> arrayList2 = this.p;
            String string2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f17e7);
            if (autoPlaySwitch == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList2.add(new tz4(string2, (String) null, z2));
            ArrayList<tz4> arrayList3 = this.p;
            String string3 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0476);
            if (autoPlaySwitch == 3) {
                z3 = true;
            }
            arrayList3.add(new tz4(string3, (String) null, z3));
            if (RichTextGifViewSwitch.isOn()) {
                this.l.l(R.string.obfuscated_res_0x7f0f17f6);
            } else {
                this.l.l(R.string.obfuscated_res_0x7f0f17e5);
            }
            this.l.k(this.p, this.v);
            this.l.c();
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.d.setOnClickListener(this.a);
            this.e.setOnClickListener(this.a);
            this.f.setOnClickListener(this.a);
            this.g.setOnClickListener(this.a);
            this.q.setOnClickListener(this.a);
            this.r.setOnClickListener(this.a);
        }
    }

    public final void S() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TbSettingTextTipView tbSettingTextTipView = this.q;
            int i2 = 0;
            if (TbSingleton.getInstance().isDebugToolMode()) {
                i = 0;
            } else {
                i = 8;
            }
            tbSettingTextTipView.setVisibility(i);
            TbSettingTextTipView tbSettingTextTipView2 = this.r;
            if (!TbSingleton.getInstance().isDebugToolMode()) {
                i2 = 8;
            }
            tbSettingTextTipView2.setVisibility(i2);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d018a);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f038e));
            this.q = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09086c);
            this.r = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0919ec);
            this.d = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0910e1);
            this.e = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090135);
            this.f = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090bb4);
            this.g = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0928c0);
            if (RichTextGifViewSwitch.isOn()) {
                this.g.setText(R.string.obfuscated_res_0x7f0f17f6);
            } else {
                this.g.setText(R.string.obfuscated_res_0x7f0f17e5);
            }
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.a.findViewById(R.id.obfuscated_res_0x7f092264);
            this.h = msgSettingItemView;
            msgSettingItemView.setText(R.string.slide_anim_switch);
            this.h.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
            this.h.setOnSwitchStateChangeListener(new a(this));
            this.b = this.a.findViewById(R.id.obfuscated_res_0x7f091a84);
        }
    }

    public final void V(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        this.e.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f0a8f));
                        return;
                    }
                    return;
                }
                this.e.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f0a91));
                return;
            }
            this.e.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f0a90));
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (TbadkCoreApplication.getInst().getAutoPlaySwitch() == 1) {
                this.g.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f17e7));
            } else if (TbadkCoreApplication.getInst().getAutoPlaySwitch() == 3) {
                this.g.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f0476));
            } else if (TbadkCoreApplication.getInst().getAutoPlaySwitch() == 2) {
                this.g.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f17e6));
            }
        }
    }

    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(this.b);
            this.c.onChangeSkinType(getPageContext(), i);
            this.h.c(this.a.getPageContext(), i);
            kz4 kz4Var = this.i;
            if (kz4Var != null) {
                kz4Var.g();
            }
            kz4 kz4Var2 = this.j;
            if (kz4Var2 != null) {
                kz4Var2.g();
            }
            kz4 kz4Var3 = this.k;
            if (kz4Var3 != null) {
                kz4Var3.g();
            }
            kz4 kz4Var4 = this.l;
            if (kz4Var4 != null) {
                kz4Var4.g();
            }
        }
    }
}
