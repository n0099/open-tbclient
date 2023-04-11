package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.x56;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class v56 extends t56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long e;
    public c f;
    public Drawable g;

    /* loaded from: classes6.dex */
    public interface c {
        void a(x56 x56Var);
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x56 a;
        public final /* synthetic */ v56 b;

        public a(v56 v56Var, x56 x56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v56Var, x56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v56Var;
            this.a = x56Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.f != null) {
                this.b.f.a(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x56 a;
        public final /* synthetic */ MetaData b;
        public final /* synthetic */ v56 c;

        public b(v56 v56Var, x56 x56Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v56Var, x56Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = v56Var;
            this.a = x56Var;
            this.b = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            boolean g = this.c.g(this.a.d);
            StatisticItem statisticItem = new StatisticItem("c12661");
            statisticItem.param("obj_id", this.a.a.getAuthor().getUserId());
            statisticItem.param("obj_type", g ? 1 : 0);
            TiebaStatic.log(statisticItem);
            if (this.c.g(this.a.d)) {
                v56 v56Var = this.c;
                v56Var.b(v56Var.a, this.a.a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_WHOLE_TAB);
                return;
            }
            this.c.h(this.b);
        }
    }

    /* loaded from: classes6.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;

        public d(v56 v56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(v56 v56Var, a aVar) {
            this(v56Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v56(TbPageContext tbPageContext) {
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
        this.e = gg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.g = SkinManager.getDrawable(this.b.getResources(), (int) R.drawable.icon_video_direct_seeding);
    }

    public final void h(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.b).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.e).equals(metaData.getUserId()), metaData.isBigV())));
        }
    }

    public final boolean g(List<x56.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (!ListUtils.isEmpty(list)) {
                for (x56.a aVar : list) {
                    if (aVar != null && 1 == aVar.a) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f = cVar;
        }
    }

    public final void j(boolean z, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, dVar) == null) {
            if (z) {
                dVar.g.setVisibility(8);
                dVar.f.setVisibility(0);
                dVar.f.setEnabled(false);
                return;
            }
            dVar.f.setVisibility(8);
            dVar.g.setVisibility(0);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view3;
        d dVar;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                dVar = new d(this, null);
                view3 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0863, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f091d06);
                dVar.a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
                dVar.a.setIsRound(true);
                dVar.a.setAutoChangeStyle(false);
                dVar.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                dVar.b = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f091d0b);
                dVar.c = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f091d08);
                dVar.d = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f091d09);
                dVar.e = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f091d07);
                dVar.f = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f091d05);
                dVar.g = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f091d0a);
                SkinManager.setBackgroundColor(view3, R.color.CAM_X0201);
                SkinManager.setViewTextColor(dVar.b, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(dVar.e, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(dVar.f, (int) R.color.CAM_X0110);
                SkinManager.setViewTextColor(dVar.g, (int) R.color.obfuscated_res_0x7f0608f8);
                dVar.c.setCompoundDrawablesWithIntrinsicBounds(this.g, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(dVar.d, (int) R.color.CAM_X0301);
                view3.setTag(dVar);
            } else {
                view3 = view2;
                dVar = (d) view2.getTag();
            }
            x56 item = getItem(i);
            if (item != null && (threadData = item.a) != null && threadData.getAuthor() != null) {
                com.baidu.tbadk.core.data.MetaData author = item.a.getAuthor();
                int i2 = 12;
                dVar.a.N(author.getPortrait(), 12, false);
                this.d = 0;
                dVar.c.setVisibility(8);
                dVar.d.setVisibility(8);
                if (!ListUtils.isEmpty(item.d)) {
                    for (x56.a aVar : item.d) {
                        if (aVar != null) {
                            int i3 = aVar.a;
                            if (1 == i3) {
                                dVar.c.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.b)) {
                                    dVar.c.setText(aVar.b);
                                }
                                this.d++;
                            } else if (2 == i3) {
                                dVar.d.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.b)) {
                                    dVar.d.setText(aVar.b);
                                }
                                this.d++;
                            }
                        }
                    }
                }
                boolean z = item.b;
                String name_show = author.getName_show();
                if (this.d <= 1) {
                    i2 = 14;
                } else if (!z) {
                    i2 = 10;
                }
                if (hi.byteLength(name_show) > i2) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE);
                }
                dVar.b.setText(name_show);
                dVar.e.setText(StringHelper.getFormatTimeShort(item.c * 1000));
                j(z, dVar);
                dVar.g.setOnClickListener(new a(this, item));
                view3.setOnClickListener(new b(this, item, author));
                StatisticItem statisticItem = new StatisticItem("c12660");
                statisticItem.param("obj_id", item.a.getAuthor().getUserId());
                s56.b().a(statisticItem);
            }
            return view3;
        }
        return (View) invokeILL.objValue;
    }
}
