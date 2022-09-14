package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.utils.BdNetUtils;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"InflateParams"})
/* loaded from: classes4.dex */
public class kw0 extends cw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout e;
    public a f;
    public b g;
    public BdNetUtils.NetStatus h;

    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z);

        void b(@NonNull BdVideoSeries bdVideoSeries);

        View c();
    }

    /* loaded from: classes4.dex */
    public static class b implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;
        public ViewGroup b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public Button g;
        public final kw0 h;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.h.M();
                }
            }
        }

        public b(@NonNull Context context, @NonNull kw0 kw0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, kw0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.h = kw0Var;
            e();
        }

        @Override // com.baidu.tieba.kw0.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        @Override // com.baidu.tieba.kw0.a
        public void b(@NonNull BdVideoSeries bdVideoSeries) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdVideoSeries) == null) {
                String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0be3);
                int a2 = zw0.a(bdVideoSeries);
                ClarityUrlList clarityList = bdVideoSeries.getClarityList();
                if (a2 >= 0 && clarityList != null && clarityList.size() > 0) {
                    String string2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c22, String.valueOf(clarityList.get(0).k()));
                    this.c.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c1e) + c21.a(a2, false));
                    this.d.setText(string2);
                    this.e.setVisibility(0);
                    this.d.setVisibility(0);
                    this.c.setVisibility(0);
                } else {
                    this.e.setVisibility(8);
                    this.d.setVisibility(8);
                    this.c.setVisibility(8);
                }
                this.f.setText(string);
                this.g.setOnClickListener(new a(this));
            }
        }

        @Override // com.baidu.tieba.kw0.a
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (View) invokeV.objValue;
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d05d7, (ViewGroup) null);
                this.b = viewGroup;
                this.c = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0923cf);
                this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0923d0);
                this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091619);
                this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0923d1);
                this.g = (Button) this.b.findViewById(R.id.obfuscated_res_0x7f090412);
            }
        }
    }

    public kw0() {
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
        this.h = BdNetUtils.NetStatus.NET_DOWN;
        FrameLayout frameLayout = new FrameLayout(this.c);
        this.e = frameLayout;
        frameLayout.setVisibility(8);
    }

    public final void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            String h1 = u().h1();
            StringBuilder sb = new StringBuilder(t().getString(R.string.obfuscated_res_0x7f0f0bef));
            if (!h1.isEmpty()) {
                sb.append("，\n");
                sb.append(str);
                sb.append(h1);
                sb.append("MB");
            }
            n11.a().showToast(t(), sb.toString());
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            F(xs0.w(LayerEvent.ACTION_CLICK_NET_TIP));
            this.e.setVisibility(8);
            O(true);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            F(xs0.w(LayerEvent.ACTION_HIDE_CACHE_LOADING));
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            n31.a().b(z);
        }
    }

    @Override // com.baidu.tieba.uv0, com.baidu.tieba.iu0
    public void d(@NonNull ht0 ht0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ht0Var) == null) {
            String c2 = ht0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode != 154871702) {
                if (hashCode == 1370689931 && c2.equals(PlayerEvent.ACTION_ON_INFO)) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (c2.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                    c = 1;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    return;
                }
                this.e.setVisibility(8);
                return;
            }
            int g = ht0Var.g(1);
            if (g == 904 || g == 956) {
                this.e.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.hw0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iu0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new int[]{2, 4, 1, 3} : (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uv0, com.baidu.tieba.iu0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                this.e.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.uv0, com.baidu.tieba.iu0
    public void k(@NonNull ht0 ht0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ht0Var) == null) || this.f == null) {
            return;
        }
        if (LayerEvent.ACTION_SWITCH_FULL.equals(ht0Var.c())) {
            this.f.a(true);
        } else if (LayerEvent.ACTION_SWITCH_HALF.equals(ht0Var.c())) {
            this.f.a(false);
        }
    }

    @Override // com.baidu.tieba.uv0, com.baidu.tieba.iu0
    public void n(@NonNull ht0 ht0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, ht0Var) == null) && SystemEvent.ACTION_CONNECT_CHANGED.equals(ht0Var.c())) {
            BdNetUtils.NetStatus a2 = BdNetUtils.a();
            if (a2 == BdNetUtils.NetStatus.NET_MOBILE && !BdNetUtils.h() && this.h != BdNetUtils.NetStatus.NET_MOBILE) {
                if (u().Y() && u().r() > 0 && u().S()) {
                    L(this.c.getString(R.string.obfuscated_res_0x7f0f0c21));
                }
            } else {
                BdNetUtils.NetStatus netStatus = BdNetUtils.NetStatus.NET_WIFI;
                if (a2 == netStatus && this.h != netStatus) {
                    this.e.setVisibility(8);
                    if (u().S() && !u().a0()) {
                        if (u().R()) {
                            u().m0();
                        } else if (u().C() == 0) {
                            u().K0();
                        } else {
                            u().l0();
                        }
                        n11.a().a(t(), R.string.obfuscated_res_0x7f0f0bf1);
                    }
                }
            }
            this.h = a2;
        }
    }

    @Override // com.baidu.tieba.cw0, com.baidu.tieba.uv0, com.baidu.tieba.hw0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onLayerRelease();
            this.g = null;
            this.f = null;
        }
    }

    @Override // com.baidu.tieba.uv0, com.baidu.tieba.iu0
    public void q(@NonNull ht0 ht0Var) {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, ht0Var) == null) || !ControlEvent.ACTION_SHOW_TIP.equals(ht0Var.c()) || u().U0() || (o1 = u().o1()) == null) {
            return;
        }
        if (this.g == null) {
            this.g = new b(this.c, this);
        }
        b bVar = this.g;
        this.f = bVar;
        if (bVar == null) {
            this.e.removeAllViews();
            this.e.setVisibility(8);
            return;
        }
        if (this.e.getChildAt(0) != this.f.c()) {
            this.e.removeAllViews();
            this.e.addView(this.f.c());
        }
        this.f.c().setVisibility(0);
        this.f.b(o1);
        this.e.setVisibility(0);
        u().y().y(true);
        u().y().j(this);
        N();
    }
}
