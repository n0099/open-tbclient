package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class k88 extends m36<v78> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public LinearLayout q;
    public LinearLayout r;
    public LinearLayout s;
    public LinearLayout t;
    public UserData u;
    public int v;
    public int w;

    @Override // com.baidu.tieba.m36
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d070e : invokeV.intValue;
    }

    /* loaded from: classes4.dex */
    public class a implements CacheModel.c<js7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k88 a;

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void f(WriteCacheRespMsg<List<js7>> writeCacheRespMsg, WriteCacheMessage<js7> writeCacheMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, writeCacheRespMsg, writeCacheMessage) == null) {
            }
        }

        public a(k88 k88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k88Var;
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void h(ReadCacheRespMsg<List<js7>> readCacheRespMsg, ReadCacheMessage<js7> readCacheMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, readCacheRespMsg, readCacheMessage) == null) && readCacheRespMsg != null && readCacheRespMsg.getData() != null) {
                this.a.m.setText(Integer.toString(readCacheRespMsg.getData().size()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k88(TbPageContext<?> tbPageContext) {
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
        this.v = 3;
        this.w = 0;
        View k = k();
        this.i = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0902e5);
        this.j = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0902e6);
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0921ff);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09220d);
        this.m = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090da9);
        this.n = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090daa);
        this.o = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090685);
        this.p = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090686);
        this.q = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0902e4);
        this.r = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0921cf);
        this.t = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f090da8);
        this.s = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f090684);
    }

    @Override // com.baidu.tieba.m36
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) && this.v != i) {
            qw4 d = qw4.d(k());
            d.n(R.string.J_X14);
            d.m(1);
            d.f(R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0109);
            this.v = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, view2) != null) || view2 == null) {
            return;
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f0909b0) {
            if (this.u == null) {
                return;
            }
            PersonRedTipManager.getInstance().updateRedTipState(2, false, true);
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.b.getPageActivity(), false, this.u.getUserId(), this.u.getSex()).updateBjhUser(this.u.isBaijiahaoUser())));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f0906cc) {
            if (this.u == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 5));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.b.getPageActivity(), true, this.u.getUserId(), this.u.getSex()).updateBjhUser(this.u.isBaijiahaoUser()).updateFollowNum(this.w, this.u.getPortrait())));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f0902e4) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 7));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.b.getPageActivity(), this.u.getLike_bars(), this.u.getUserId(), this.u.getSex())));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f0921cf) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 8));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.b.getPageActivity(), this.u.getUserId(), this.u.getSex(), this.u.getPortrait())));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f090684) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 9));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(getContext())));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f090da8) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 10));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(getContext())));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.m36
    /* renamed from: s */
    public void l(v78 v78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, v78Var) == null) {
            this.u = v78Var.e;
            this.w = v78Var.a;
            this.i.setText(Integer.toString(v78Var.b));
            this.k.setText(StringHelper.longNumFormatOver9999wan(v78Var.c));
            PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(this.b);
            pbHistoryCacheModel.R(new a(this));
            pbHistoryCacheModel.O();
            this.o.setText(Integer.toString(this.u.getFavoriteNum()));
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.s.setOnClickListener(this);
            m(g(), TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
