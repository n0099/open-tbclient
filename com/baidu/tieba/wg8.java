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
/* loaded from: classes6.dex */
public class wg8 extends p9<BrowseSettingActivity> {
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
    public ru4 i;
    public ru4 j;
    public ru4 k;
    public ru4 l;
    public ArrayList<av4> m;
    public ArrayList<av4> n;
    public ArrayList<av4> o;
    public ArrayList<av4> p;
    public TbSettingTextTipView q;
    public final AdapterView.OnItemClickListener r;
    public final AdapterView.OnItemClickListener s;
    public final AdapterView.OnItemClickListener t;
    public final AdapterView.OnItemClickListener u;

    /* loaded from: classes6.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(wg8 wg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg8Var};
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
        public void i0(View view2, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
                ox4.k().w("slide_local_switch_is_clicked", 1);
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
        public final /* synthetic */ wg8 a;

        public b(wg8 wg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wg8Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.i.h(i);
                if (i == 0) {
                    hq4.c().j(true);
                    hq4.c().k(0);
                } else if (i == 1) {
                    hq4.c().j(true);
                    hq4.c().k(1);
                    TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 1));
                } else if (i == 2) {
                    hq4.c().j(true);
                    hq4.c().k(2);
                    TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 3));
                } else if (i == 3) {
                    hq4.c().j(false);
                }
                this.a.i.d();
                this.a.K();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wg8 a;

        public c(wg8 wg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wg8Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.j.h(i);
                int i2 = 0;
                if (i == 0) {
                    TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 1));
                    i2 = 1;
                } else if (i == 1) {
                    TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 2));
                    i2 = 2;
                } else if (i == 2) {
                    TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 3));
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(this.a.a.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                hq4.c().i(i2);
                this.a.L(i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wg8 a;

        public d(wg8 wg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wg8Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.k.h(i);
                if (i == 0) {
                    TbadkCoreApplication.getInst().setFontSize(0);
                } else if (i == 1) {
                    TbadkCoreApplication.getInst().setFontSize(1);
                } else if (i == 2) {
                    TbadkCoreApplication.getInst().setFontSize(2);
                } else if (i == 3) {
                    TbadkCoreApplication.getInst().setFontSize(3);
                }
                this.a.I();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wg8 a;

        public e(wg8 wg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wg8Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.l.h(i);
                if (i == 0) {
                    TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                    TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 2));
                } else if (i == 1) {
                    TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                    TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 1));
                } else if (i == 2) {
                    TbadkCoreApplication.getInst().setVideoAutoPlay(3);
                    TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 3));
                }
                this.a.M();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wg8(BrowseSettingActivity browseSettingActivity) {
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
                super((r9) newInitContext.callArgs[0]);
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
        this.r = new b(this);
        this.s = new c(this);
        this.t = new d(this);
        this.u = new e(this);
        this.a = browseSettingActivity;
        z();
        G();
        y();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l = new ru4(this.a.getPageContext());
            this.p = new ArrayList<>();
            int autoPlaySwitch = TbadkCoreApplication.getInst().getAutoPlaySwitch();
            this.p.add(new av4(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f152c), (String) null, autoPlaySwitch == 2));
            this.p.add(new av4(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f152d), (String) null, autoPlaySwitch == 1));
            this.p.add(new av4(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f03f8), (String) null, autoPlaySwitch == 3));
            if (RichTextGifViewSwitch.isOn()) {
                this.l.l(R.string.obfuscated_res_0x7f0f1536);
            } else {
                this.l.l(R.string.obfuscated_res_0x7f0f152b);
            }
            this.l.k(this.p, this.u);
            this.l.c();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            v();
            this.j.n();
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            w();
            this.k.n();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            x();
            this.i.n();
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            A();
            this.l.n();
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            L(hq4.c().b());
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            K();
            F();
            I();
            M();
            H();
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.q.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (TbadkCoreApplication.getInst().getFontSize() == 0) {
                this.f.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f065f));
            } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
                this.f.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f065c));
            } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
                this.f.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f065d));
            } else {
                this.f.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f065e));
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!hq4.c().g()) {
                this.d.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f03f8));
            } else if (hq4.c().e() == 1) {
                this.d.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f1564));
            } else if (hq4.c().e() == 2) {
                this.d.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f156b));
            } else {
                this.d.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f1567));
            }
        }
    }

    public final void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            if (i == 0) {
                this.e.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f08f3));
            } else if (i == 1) {
                this.e.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f08f4));
            } else if (i != 2) {
            } else {
                this.e.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f08f2));
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (TbadkCoreApplication.getInst().getAutoPlaySwitch() == 1) {
                this.g.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f152d));
            } else if (TbadkCoreApplication.getInst().getAutoPlaySwitch() == 3) {
                this.g.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f03f8));
            } else if (TbadkCoreApplication.getInst().getAutoPlaySwitch() == 2) {
                this.g.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f152c));
            }
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.a.getLayoutMode().l(i == 1);
            this.a.getLayoutMode().k(this.b);
            this.c.onChangeSkinType(getPageContext(), i);
            this.h.c(this.a.getPageContext(), i);
            ru4 ru4Var = this.i;
            if (ru4Var != null) {
                ru4Var.g();
            }
            ru4 ru4Var2 = this.j;
            if (ru4Var2 != null) {
                ru4Var2.g();
            }
            ru4 ru4Var3 = this.k;
            if (ru4Var3 != null) {
                ru4Var3.g();
            }
            ru4 ru4Var4 = this.l;
            if (ru4Var4 != null) {
                ru4Var4.g();
            }
        }
    }

    public TbSettingTextTipView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.e : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.q : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.d : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.g : (TbSettingTextTipView) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.o = new ArrayList<>();
            int b2 = hq4.c().b();
            this.o.add(new av4(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f08f4), (String) null, b2 == 1));
            this.o.add(new av4(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f08f2), (String) null, b2 == 2));
            this.o.add(new av4(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f08f3), (String) null, b2 == 0));
            ru4 ru4Var = new ru4(this.a.getPageContext());
            ru4Var.l(R.string.obfuscated_res_0x7f0f00ce);
            this.j = ru4Var;
            ru4Var.k(this.o, this.s);
            ru4Var.c();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.k = new ru4(this.a.getPageContext());
            this.m = new ArrayList<>();
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            this.m.add(new av4(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f065f), (String) null, fontSize == 0));
            this.m.add(new av4(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f065c), (String) null, fontSize == 1));
            this.m.add(new av4(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f065d), (String) null, fontSize == 2));
            this.m.add(new av4(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f065e), (String) null, fontSize == 3));
            this.k.l(R.string.obfuscated_res_0x7f0f065b);
            this.k.k(this.m, this.t);
            this.k.c();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.n = new ArrayList<>();
            int e2 = hq4.c().e();
            boolean g = hq4.c().g();
            boolean z = false;
            this.n.add(new av4(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1567), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1568), g && e2 == 0));
            this.n.add(new av4(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1564), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1569), g && e2 == 1));
            ArrayList<av4> arrayList = this.n;
            String string = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f156b);
            String string2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f156a);
            if (g && e2 == 2) {
                z = true;
            }
            arrayList.add(new av4(string, string2, z));
            ru4 ru4Var = new ru4(this.a.getPageContext());
            this.i = ru4Var;
            ru4Var.l(R.string.obfuscated_res_0x7f0f034b);
            ru4 ru4Var2 = this.i;
            ru4Var2.k(this.n, this.r);
            ru4Var2.c();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.d.setOnClickListener(this.a);
            this.e.setOnClickListener(this.a);
            this.f.setOnClickListener(this.a);
            this.g.setOnClickListener(this.a);
            this.q.setOnClickListener(this.a);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d0163);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f0925c4);
            this.c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0349));
            this.q = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090773);
            this.d = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090ecf);
            this.e = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09011a);
            this.f = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090a37);
            this.g = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09250c);
            if (RichTextGifViewSwitch.isOn()) {
                this.g.setText(R.string.obfuscated_res_0x7f0f1536);
            } else {
                this.g.setText(R.string.obfuscated_res_0x7f0f152b);
            }
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.a.findViewById(R.id.obfuscated_res_0x7f091f04);
            this.h = msgSettingItemView;
            msgSettingItemView.setText(R.string.obfuscated_res_0x7f0f11c6);
            this.h.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
            this.h.setOnSwitchStateChangeListener(new a(this));
            this.b = this.a.findViewById(R.id.obfuscated_res_0x7f091792);
        }
    }
}
