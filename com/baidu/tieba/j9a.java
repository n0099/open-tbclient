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
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
import com.baidu.tieba.myCollection.baseHistory.PbHistoryData;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class j9a extends nl6<t8a> {
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

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d07f9 : invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements CacheModel.CacheModelCallback<PbHistoryData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j9a a;

        @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
        public void onCacheDataWrite(WriteCacheRespMsg<List<PbHistoryData>> writeCacheRespMsg, WriteCacheMessage<PbHistoryData> writeCacheMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeCacheRespMsg, writeCacheMessage) == null) {
            }
        }

        public a(j9a j9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j9aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j9aVar;
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
        public void onCacheDataGet(ReadCacheRespMsg<List<PbHistoryData>> readCacheRespMsg, ReadCacheMessage<PbHistoryData> readCacheMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, readCacheRespMsg, readCacheMessage) == null) && readCacheRespMsg != null && readCacheRespMsg.getData() != null) {
                this.a.m.setText(Integer.toString(readCacheRespMsg.getData().size()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j9a(TbPageContext<?> tbPageContext) {
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
        View i3 = i();
        this.i = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f090312);
        this.j = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f090313);
        this.k = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f09261e);
        this.l = (TextView) i3.findViewById(R.id.thread_title);
        this.m = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f090fc9);
        this.n = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f090fca);
        this.o = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f090791);
        this.p = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f090792);
        this.q = (LinearLayout) i3.findViewById(R.id.obfuscated_res_0x7f090311);
        this.r = (LinearLayout) i3.findViewById(R.id.obfuscated_res_0x7f0925f0);
        this.t = (LinearLayout) i3.findViewById(R.id.obfuscated_res_0x7f090fc8);
        this.s = (LinearLayout) i3.findViewById(R.id.obfuscated_res_0x7f090790);
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) && this.v != i) {
            EMManager.from(i()).setCorner(R.string.J_X14).setCardType(1).setBackGroundColor(R.color.CAM_X0201);
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
        if (view2.getId() == R.id.obfuscated_res_0x7f090b3f) {
            if (this.u == null) {
                return;
            }
            PersonRedTipManager.getInstance().updateRedTipState(2, false, true);
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.b.getPageActivity(), false, this.u.getUserId(), this.u.getSex()).updateBjhUser(this.u.isBaijiahaoUser())));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f0907df) {
            if (this.u == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 5));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.b.getPageActivity(), true, this.u.getUserId(), this.u.getSex()).updateBjhUser(this.u.isBaijiahaoUser()).updateFollowNum(this.w, this.u.getPortrait())));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f090311) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 7));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.b.getPageActivity(), this.u.getLike_bars(), this.u.getUserId(), this.u.getSex())));
            TiebaStatic.log(new StatisticItem("c15316"));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f0925f0) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 8));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.b.getPageActivity(), this.u.getUserId(), this.u.getSex(), this.u.getPortrait())));
            TiebaStatic.log(new StatisticItem("c15315"));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f090790) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 9));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(c())));
            TiebaStatic.log(new StatisticItem("c15317"));
        } else if (view2.getId() == R.id.obfuscated_res_0x7f090fc8) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 10));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(c())));
            TiebaStatic.log(new StatisticItem("c15318"));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: r */
    public void j(t8a t8aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, t8aVar) == null) {
            this.u = t8aVar.e;
            this.w = t8aVar.a;
            this.i.setText(Integer.toString(t8aVar.b));
            this.k.setText(StringHelper.longNumFormatOver9999wan(t8aVar.c));
            PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(this.b);
            pbHistoryCacheModel.setCallback(new a(this));
            pbHistoryCacheModel.loadCache();
            this.o.setText(Integer.toString(this.u.getFavoriteNum()));
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.s.setOnClickListener(this);
            k(h(), TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
