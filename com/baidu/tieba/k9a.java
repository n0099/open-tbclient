package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NamoaixudEntry;
/* loaded from: classes6.dex */
public class k9a extends nl6<u8a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public View j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public TBSpecificationBtn n;
    public View o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public View v;
    public TbImageView w;
    public NamoaixudEntry x;
    public View.OnClickListener y;

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0801 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k9a a;

        public a(k9a k9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k9aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k9aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == this.a.l.getId()) {
                    if (this.a.x != null) {
                        TbSingleton.getInstance().setDuXiaoManActivityTimestamp(JavaTypesHelper.toLong(this.a.x.activity_timestamp, 0L));
                        this.a.v.setVisibility(8);
                        if ("1".equals(this.a.x.activity_link_type)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2001447, this.a.x.activity_link_addr));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c14713").param("obj_locate", 2));
                } else if (view2.getId() == this.a.j.getId()) {
                    if (this.a.x != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001447, this.a.x.goto_button_url));
                    }
                    TiebaStatic.log(new StatisticItem("c14713").param("obj_locate", 1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k9a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = new a(this);
        this.i = i();
        int dimens = BdUtilHelper.getDimens(this.c, R.dimen.M_W_X003);
        this.i.setPadding(dimens, 0, dimens, 0);
        this.k = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092685);
        TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0925a4);
        this.l = textView;
        textView.setOnClickListener(this.y);
        View findViewById = this.i.findViewById(R.id.obfuscated_res_0x7f091c9e);
        this.j = findViewById;
        findViewById.setOnClickListener(this.y);
        this.m = (ImageView) this.i.findViewById(R.id.img_arrow);
        this.n = (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f090502);
        this.o = this.i.findViewById(R.id.obfuscated_res_0x7f090a63);
        this.p = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090a64);
        this.q = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092735);
        this.r = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0904bb);
        this.s = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0902b1);
        this.t = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090462);
        this.u = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0902b2);
        this.v = this.i.findViewById(R.id.obfuscated_res_0x7f091f80);
        this.w = (TbImageView) this.i.findViewById(R.id.obfuscated_res_0x7f091171);
        k(h(), this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: z */
    public void j(u8a u8aVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, u8aVar) == null) && u8aVar != null && u8aVar.c() != null) {
            NamoaixudEntry c = u8aVar.c();
            this.x = c;
            if ("1".equals(c.layout_type)) {
                this.q.setVisibility(0);
                this.r.setVisibility(8);
                this.s.setVisibility(0);
                this.t.setVisibility(8);
                this.u.setVisibility(0);
            } else {
                this.q.setVisibility(8);
                this.r.setVisibility(0);
                this.s.setVisibility(8);
                this.t.setVisibility(0);
                this.u.setVisibility(8);
            }
            this.q.setText(this.x.tip);
            if (JavaTypesHelper.toLong(this.x.activity_timestamp, 0L) != TbSingleton.getInstance().getDuXiaoManActivityTimestamp()) {
                this.v.setVisibility(0);
            } else {
                this.v.setVisibility(8);
            }
            this.l.setText(this.x.activity_desc);
            this.s.setText(this.x.amount);
            this.u.setText(this.x.amount_msg);
            if (this.a == 0) {
                str = this.x.encourage_icon;
            } else {
                str = this.x.encourage_icon_dark;
            }
            this.w.startLoad(str, 10, false);
            if (TextUtils.isEmpty(this.x.encourage_desc)) {
                this.o.setVisibility(8);
            } else {
                this.o.setVisibility(0);
                this.p.setText(this.x.encourage_desc);
            }
            this.n.setText(this.x.goto_button_name);
            this.t.setText(this.x.amount_msg);
            k(h(), this.a);
            TiebaStatic.log("c14712");
        }
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            EMManager.from(this.j).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            EMManager.from(this.k).setTextColor(R.color.CAM_X0105).setTextStyle(R.string.F_X02);
            EMManager.from(this.q).setTextColor(R.color.CAM_X0109).setTextStyle(R.string.F_X01);
            EMManager.from(this.r).setTextColor(R.color.CAM_X0109).setTextStyle(R.string.F_X01);
            EMManager.from(this.l).setTextColor(R.color.CAM_X0107).setTextStyle(R.string.F_X01);
            EMManager.from(this.s).setTextColor(R.color.CAM_X0105).setTextStyle(R.string.F_X02);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            this.n.k();
            EMManager.from(this.o).setCorner(R.string.J_X04).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0321);
            EMManager.from(this.p).setTextColor(R.color.CAM_X0321).setTextStyle(R.string.F_X01);
            EMManager.from(this.u).setTextColor(R.color.CAM_X0109).setTextStyle(R.string.F_X01);
            EMManager.from(this.t).setTextColor(R.color.CAM_X0105).setTextStyle(R.string.F_X01);
        }
    }
}
