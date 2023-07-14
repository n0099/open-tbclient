package com.baidu.tieba;

import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes8.dex */
public class v3a extends j9<BrowseSettingActivity> {
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
    public t55 i;
    public t55 j;
    public t55 k;
    public t55 l;
    public ArrayList<c65> m;
    public ArrayList<c65> n;
    public ArrayList<c65> o;
    public ArrayList<c65> p;
    public TbSettingTextTipView q;
    public TbSettingTextTipView r;
    public final AdapterView.OnItemClickListener s;
    public final AdapterView.OnItemClickListener t;
    public final AdapterView.OnItemClickListener u;
    public final AdapterView.OnItemClickListener v;

    /* loaded from: classes8.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(v3a v3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v3aVar};
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
        public void c0(View view2, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
                da5.p().F("slide_local_switch_is_clicked", 1);
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

    /* loaded from: classes8.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v3a a;

        public b(v3a v3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v3aVar;
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
                                a15.c().j(false);
                            }
                        } else {
                            a15.c().j(true);
                            a15.c().k(2);
                            TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 3));
                        }
                    } else {
                        a15.c().j(true);
                        a15.c().k(1);
                        TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 1));
                    }
                } else {
                    a15.c().j(true);
                    a15.c().k(0);
                }
                this.a.i.d();
                this.a.a0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v3a a;

        public c(v3a v3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v3aVar;
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
                a15.c().i(i2);
                this.a.b0(i2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v3a a;

        public d(v3a v3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v3aVar;
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
                this.a.Z();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v3a a;

        public e(v3a v3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v3aVar;
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
                this.a.c0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v3a(BrowseSettingActivity browseSettingActivity) {
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
                super((l9) newInitContext.callArgs[0]);
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
        Q();
        X();
        P();
    }

    public TbSettingTextTipView F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.q;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.r;
        }
        return (TbSettingTextTipView) invokeV.objValue;
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            M();
            this.j.n();
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            N();
            this.k.n();
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            O();
            this.i.n();
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            R();
            this.l.n();
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            b0(a15.c().b());
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            a0();
            W();
            Z();
            c0();
            Y();
        }
    }

    public final void M() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.o = new ArrayList<>();
            int b2 = a15.c().b();
            ArrayList<c65> arrayList = this.o;
            String string = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a73);
            boolean z3 = false;
            if (b2 == 1) {
                z = true;
            } else {
                z = false;
            }
            arrayList.add(new c65(string, (String) null, z));
            ArrayList<c65> arrayList2 = this.o;
            String string2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a71);
            if (b2 == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList2.add(new c65(string2, (String) null, z2));
            ArrayList<c65> arrayList3 = this.o;
            String string3 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a72);
            if (b2 == 0) {
                z3 = true;
            }
            arrayList3.add(new c65(string3, (String) null, z3));
            t55 t55Var = new t55(this.a.getPageContext());
            t55Var.l(R.string.obfuscated_res_0x7f0f00fa);
            this.j = t55Var;
            t55Var.k(this.o, this.t);
            t55Var.c();
        }
    }

    public void Z() {
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

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!a15.c().g()) {
                this.d.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f0471));
            } else if (a15.c().e() == 1) {
                this.d.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f181c));
            } else if (a15.c().e() == 2) {
                this.d.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f1823));
            } else {
                this.d.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f181f));
            }
        }
    }

    public final void N() {
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k = new t55(this.a.getPageContext());
            this.m = new ArrayList<>();
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            ArrayList<c65> arrayList = this.m;
            String string = this.a.getPageContext().getString(R.string.font_size_xlarge);
            boolean z4 = false;
            if (fontSize == 0) {
                z = true;
            } else {
                z = false;
            }
            arrayList.add(new c65(string, (String) null, z));
            ArrayList<c65> arrayList2 = this.m;
            String string2 = this.a.getPageContext().getString(R.string.font_size_big);
            if (fontSize == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList2.add(new c65(string2, (String) null, z2));
            ArrayList<c65> arrayList3 = this.m;
            String string3 = this.a.getPageContext().getString(R.string.font_size_mid);
            if (fontSize == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList3.add(new c65(string3, (String) null, z3));
            ArrayList<c65> arrayList4 = this.m;
            String string4 = this.a.getPageContext().getString(R.string.font_size_small);
            if (fontSize == 3) {
                z4 = true;
            }
            arrayList4.add(new c65(string4, (String) null, z4));
            this.k.l(R.string.font_size);
            this.k.k(this.m, this.u);
            this.k.c();
        }
    }

    public final void O() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.n = new ArrayList<>();
            int e2 = a15.c().e();
            boolean g = a15.c().g();
            ArrayList<c65> arrayList = this.n;
            String string = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f181f);
            String string2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1820);
            boolean z3 = false;
            if (g && e2 == 0) {
                z = true;
            } else {
                z = false;
            }
            arrayList.add(new c65(string, string2, z));
            ArrayList<c65> arrayList2 = this.n;
            String string3 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f181c);
            String string4 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1821);
            if (g && e2 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList2.add(new c65(string3, string4, z2));
            ArrayList<c65> arrayList3 = this.n;
            String string5 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1823);
            String string6 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1822);
            if (g && e2 == 2) {
                z3 = true;
            }
            arrayList3.add(new c65(string5, string6, z3));
            t55 t55Var = new t55(this.a.getPageContext());
            this.i = t55Var;
            t55Var.l(R.string.obfuscated_res_0x7f0f038c);
            t55 t55Var2 = this.i;
            t55Var2.k(this.n, this.s);
            t55Var2.c();
        }
    }

    public final void R() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = new t55(this.a.getPageContext());
            this.p = new ArrayList<>();
            int autoPlaySwitch = TbadkCoreApplication.getInst().getAutoPlaySwitch();
            ArrayList<c65> arrayList = this.p;
            String string = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f17d6);
            boolean z3 = false;
            if (autoPlaySwitch == 2) {
                z = true;
            } else {
                z = false;
            }
            arrayList.add(new c65(string, (String) null, z));
            ArrayList<c65> arrayList2 = this.p;
            String string2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f17d7);
            if (autoPlaySwitch == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList2.add(new c65(string2, (String) null, z2));
            ArrayList<c65> arrayList3 = this.p;
            String string3 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0471);
            if (autoPlaySwitch == 3) {
                z3 = true;
            }
            arrayList3.add(new c65(string3, (String) null, z3));
            if (RichTextGifViewSwitch.isOn()) {
                this.l.l(R.string.obfuscated_res_0x7f0f17e6);
            } else {
                this.l.l(R.string.obfuscated_res_0x7f0f17d5);
            }
            this.l.k(this.p, this.v);
            this.l.c();
        }
    }

    public final void P() {
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

    public final void Y() {
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

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d0181);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f038a));
            this.q = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09084f);
            this.r = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091986);
            this.d = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0910ad);
            this.e = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090133);
            this.f = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090b8d);
            this.g = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09287a);
            if (RichTextGifViewSwitch.isOn()) {
                this.g.setText(R.string.obfuscated_res_0x7f0f17e6);
            } else {
                this.g.setText(R.string.obfuscated_res_0x7f0f17d5);
            }
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.a.findViewById(R.id.obfuscated_res_0x7f09220b);
            this.h = msgSettingItemView;
            msgSettingItemView.setText(R.string.slide_anim_switch);
            this.h.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
            this.h.setOnSwitchStateChangeListener(new a(this));
            this.b = this.a.findViewById(R.id.obfuscated_res_0x7f091a18);
        }
    }

    public final void b0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        this.e.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f0a71));
                        return;
                    }
                    return;
                }
                this.e.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f0a73));
                return;
            }
            this.e.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f0a72));
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (TbadkCoreApplication.getInst().getAutoPlaySwitch() == 1) {
                this.g.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f17d7));
            } else if (TbadkCoreApplication.getInst().getAutoPlaySwitch() == 3) {
                this.g.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f0471));
            } else if (TbadkCoreApplication.getInst().getAutoPlaySwitch() == 2) {
                this.g.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f17d6));
            }
        }
    }

    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            q05 layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.b);
            this.c.onChangeSkinType(getPageContext(), i);
            this.h.c(this.a.getPageContext(), i);
            t55 t55Var = this.i;
            if (t55Var != null) {
                t55Var.g();
            }
            t55 t55Var2 = this.j;
            if (t55Var2 != null) {
                t55Var2.g();
            }
            t55 t55Var3 = this.k;
            if (t55Var3 != null) {
                t55Var3.g();
            }
            t55 t55Var4 = this.l;
            if (t55Var4 != null) {
                t55Var4.g();
            }
        }
    }
}
