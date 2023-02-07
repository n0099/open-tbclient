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
/* loaded from: classes7.dex */
public class yy0 extends qy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout e;
    public a f;
    public b g;
    public BdNetUtils.NetStatus h;

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z);

        void b(@NonNull BdVideoSeries bdVideoSeries);

        View c();
    }

    /* loaded from: classes7.dex */
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
        public final yy0 h;

        @Override // com.baidu.tieba.yy0.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        /* loaded from: classes7.dex */
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

        public b(@NonNull Context context, @NonNull yy0 yy0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, yy0Var};
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
            this.h = yy0Var;
            e();
        }

        @Override // com.baidu.tieba.yy0.a
        public void b(@NonNull BdVideoSeries bdVideoSeries) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdVideoSeries) == null) {
                String string = this.a.getResources().getString(R.string.nad_not_wifi_tips);
                int a2 = nz0.a(bdVideoSeries);
                ClarityUrlList clarityList = bdVideoSeries.getClarityList();
                if (a2 >= 0 && clarityList != null && clarityList.size() > 0) {
                    String string2 = this.a.getResources().getString(R.string.nad_video_net_tip_size, String.valueOf(clarityList.get(0).k()));
                    this.c.setText(this.a.getResources().getString(R.string.nad_video_net_tip_duration) + w41.a(a2, false));
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

        @Override // com.baidu.tieba.yy0.a
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b;
            }
            return (View) invokeV.objValue;
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a).inflate(R.layout.nad_bd_embeded_net_tips_layout, (ViewGroup) null);
                this.b = viewGroup;
                this.c = (TextView) viewGroup.findViewById(R.id.tv_net_duration);
                this.d = (TextView) this.b.findViewById(R.id.tv_net_size);
                this.e = (TextView) this.b.findViewById(R.id.nad_tv_net_divide);
                this.f = (TextView) this.b.findViewById(R.id.tv_net_tips);
                this.g = (Button) this.b.findViewById(R.id.bt_continue_play);
            }
        }
    }

    public yy0() {
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
            StringBuilder sb = new StringBuilder(t().getString(R.string.nad_player_message_network_3g));
            if (!h1.isEmpty()) {
                sb.append("，\n");
                sb.append(str);
                sb.append(h1);
                sb.append("MB");
            }
            g41.a().showToast(t(), sb.toString());
        }
    }

    @Override // com.baidu.tieba.iy0, com.baidu.tieba.ww0
    public void d(@NonNull vv0 vv0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vv0Var) == null) {
            String c2 = vv0Var.c();
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
                if (c == 1) {
                    this.e.setVisibility(8);
                    return;
                }
                return;
            }
            int g = vv0Var.g(1);
            if (g == 904 || g == 956) {
                this.e.setVisibility(8);
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            F(lv0.w(LayerEvent.ACTION_CLICK_NET_TIP));
            this.e.setVisibility(8);
            O(true);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            F(lv0.w(LayerEvent.ACTION_HIDE_CACHE_LOADING));
        }
    }

    @Override // com.baidu.tieba.vy0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ww0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new int[]{2, 4, 1, 3};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qy0, com.baidu.tieba.iy0, com.baidu.tieba.vy0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onLayerRelease();
            this.g = null;
            this.f = null;
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            i61.a().b(z);
        }
    }

    @Override // com.baidu.tieba.iy0, com.baidu.tieba.ww0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                this.e.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.iy0, com.baidu.tieba.ww0
    public void k(@NonNull vv0 vv0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vv0Var) == null) && this.f != null) {
            if (LayerEvent.ACTION_SWITCH_FULL.equals(vv0Var.c())) {
                this.f.a(true);
            } else if (LayerEvent.ACTION_SWITCH_HALF.equals(vv0Var.c())) {
                this.f.a(false);
            }
        }
    }

    @Override // com.baidu.tieba.iy0, com.baidu.tieba.ww0
    public void n(@NonNull vv0 vv0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, vv0Var) == null) && SystemEvent.ACTION_CONNECT_CHANGED.equals(vv0Var.c())) {
            BdNetUtils.NetStatus a2 = BdNetUtils.a();
            if (a2 == BdNetUtils.NetStatus.NET_MOBILE && !BdNetUtils.h() && this.h != BdNetUtils.NetStatus.NET_MOBILE) {
                if (u().Y() && u().r() > 0 && u().S()) {
                    L(this.c.getString(R.string.nad_video_net_tip_rest_size));
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
                        g41.a().a(t(), R.string.nad_player_message_network_wifi);
                    }
                }
            }
            this.h = a2;
        }
    }

    @Override // com.baidu.tieba.iy0, com.baidu.tieba.ww0
    public void q(@NonNull vv0 vv0Var) {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, vv0Var) != null) || !ControlEvent.ACTION_SHOW_TIP.equals(vv0Var.c()) || u().U0() || (o1 = u().o1()) == null) {
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
