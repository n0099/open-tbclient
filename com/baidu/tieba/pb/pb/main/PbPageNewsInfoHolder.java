package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.a.j;
import b.a.e.f.p.l;
import b.a.q0.s.q.e1;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
import b.a.r0.k2.u.f.h0;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PbPageNewsInfoHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e1 f53344a;

    /* renamed from: b  reason: collision with root package name */
    public e1 f53345b;

    /* renamed from: c  reason: collision with root package name */
    public e1 f53346c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f53347d;

    /* renamed from: e  reason: collision with root package name */
    public int f53348e;

    /* renamed from: f  reason: collision with root package name */
    public h0 f53349f;

    /* renamed from: g  reason: collision with root package name */
    public b f53350g;
    public LinearLayout game_info;
    public ImageView game_info_img;
    public TextView game_info_text;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f53351h;
    public LinearLayout news_info;
    public ImageView news_info_img;
    public TextView news_info_text;
    public View pb_list_item_top_line;
    public View pb_news_info_divider;
    public LinearLayout pb_news_info_layout;
    public RelativeLayout pb_top_code;
    public TextView top_code_detail_subtitle_text;
    public TextView top_code_detail_summary_text;
    public TextView top_code_get_btn;
    public TbImageView top_code_img;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbPageNewsInfoHolder f53352e;

        public a(PbPageNewsInfoHolder pbPageNewsInfoHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbPageNewsInfoHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53352e = pbPageNewsInfoHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f53352e.f53347d.getPageActivity()) && l.D()) {
                if (this.f53352e.f53350g != null) {
                    this.f53352e.f53350g.a(this.f53352e.f53349f);
                }
                PbPageNewsInfoHolder pbPageNewsInfoHolder = this.f53352e;
                if (view == pbPageNewsInfoHolder.pb_top_code) {
                    if (pbPageNewsInfoHolder.f53344a == null || TextUtils.isEmpty(this.f53352e.f53344a.f14068a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f53352e.f53347d.getPageActivity()), new String[]{this.f53352e.f53344a.f14068a});
                    TiebaStatic.log(new StatisticItem("c11410").param("obj_source", this.f53352e.f53344a.f14068a));
                } else if (view == pbPageNewsInfoHolder.news_info) {
                    BdLog.e("link: " + this.f53352e.f53345b.f14068a);
                    if (this.f53352e.f53345b == null || TextUtils.isEmpty(this.f53352e.f53345b.f14068a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f53352e.f53347d.getPageActivity()), new String[]{this.f53352e.f53345b.f14068a});
                    TiebaStatic.log(new StatisticItem("c11409").param("obj_source", this.f53352e.f53345b.f14068a));
                } else if (view != pbPageNewsInfoHolder.game_info || pbPageNewsInfoHolder.f53346c == null || TextUtils.isEmpty(this.f53352e.f53346c.f14068a)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f53352e.f53347d.getPageActivity()), new String[]{this.f53352e.f53346c.f14068a});
                    TiebaStatic.log(new StatisticItem("c11408").param("obj_source", this.f53352e.f53346c.f14068a));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(h0 h0Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbPageNewsInfoHolder(TbPageContext tbPageContext, View view, b bVar) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53348e = 3;
        this.f53351h = new a(this);
        this.f53347d = tbPageContext;
        this.f53350g = bVar;
        this.pb_news_info_layout = (LinearLayout) view.findViewById(i.pb_news_info_layout);
        this.pb_list_item_top_line = view.findViewById(i.pb_list_item_top_line);
        this.pb_top_code = (RelativeLayout) view.findViewById(i.pb_top_code);
        this.top_code_img = (TbImageView) view.findViewById(i.top_code_img);
        this.top_code_get_btn = (TextView) view.findViewById(i.top_code_get_btn);
        this.top_code_detail_summary_text = (TextView) view.findViewById(i.top_code_detail_summary_text);
        this.top_code_detail_subtitle_text = (TextView) view.findViewById(i.top_code_detail_subtitle_text);
        this.news_info = (LinearLayout) view.findViewById(i.news_info);
        this.news_info_img = (ImageView) view.findViewById(i.news_info_img);
        this.news_info_text = (TextView) view.findViewById(i.news_info_text);
        this.game_info = (LinearLayout) view.findViewById(i.game_info);
        this.game_info_img = (ImageView) view.findViewById(i.game_info_img);
        this.game_info_text = (TextView) view.findViewById(i.game_info_text);
        this.pb_news_info_divider = view.findViewById(i.pb_news_info_divider);
        setOnClickListener(this.f53351h);
    }

    public void bindDataToView(h0 h0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, h0Var) == null) || h0Var == null) {
            return;
        }
        this.f53349f = h0Var;
        e1 e1Var = h0Var.G0;
        this.f53344a = e1Var;
        this.f53345b = h0Var.H0;
        this.f53346c = h0Var.I0;
        if (e1Var != null) {
            this.top_code_img.startLoad(e1Var.f14071d, 10, false);
            this.top_code_detail_summary_text.setText(this.f53344a.f14069b);
            this.top_code_detail_subtitle_text.setText(this.f53344a.f14072e);
            this.top_code_get_btn.setText(this.f53344a.f14073f);
            SkinManager.setBackgroundResource(this.top_code_get_btn, h.selector_star_btn_like);
            SkinManager.setViewTextColor(this.top_code_get_btn, h.news_text_color_selector);
        } else {
            this.pb_top_code.setVisibility(8);
        }
        e1 e1Var2 = this.f53345b;
        if (e1Var2 != null) {
            this.news_info_text.setText(e1Var2.f14069b);
            SkinManager.setBackgroundResource(this.news_info_img, h.icon_frs_news);
        } else {
            this.news_info.setVisibility(8);
            this.news_info_text.setVisibility(8);
            this.news_info_img.setVisibility(8);
        }
        e1 e1Var3 = this.f53346c;
        if (e1Var3 != null) {
            this.game_info_text.setText(e1Var3.f14069b);
            SkinManager.setBackgroundResource(this.game_info_img, h.icon_frs_game);
        } else {
            this.game_info.setVisibility(8);
            this.game_info_text.setVisibility(8);
            this.game_info_text.setVisibility(8);
        }
        this.pb_news_info_layout.setTag(h0Var);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f53348e == i2) {
            return;
        }
        this.f53347d.getLayoutMode().k(i2 == 1);
        this.f53347d.getLayoutMode().j(getView());
        this.f53348e = i2;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.pb_top_code.setOnClickListener(onClickListener);
            this.news_info.setOnClickListener(onClickListener);
            this.game_info.setOnClickListener(onClickListener);
        }
    }
}
