package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.cv5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class zu5 extends yu5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv5 a;
        public final /* synthetic */ zu5 b;

        public a(zu5 zu5Var, cv5 cv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zu5Var, cv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zu5Var;
            this.a = cv5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = new StatisticItem("c12659");
                statisticItem.param("tid", this.a.a.getTid());
                TiebaStatic.log(statisticItem);
                zu5 zu5Var = this.b;
                zu5Var.b(zu5Var.a, this.a.a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zu5(TbPageContext tbPageContext) {
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
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view3;
        b bVar;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                bVar = new b(null);
                view3 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d07f6, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f091b6b);
                bVar.a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
                bVar.b = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f091b6e);
                bVar.c = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f091b6a);
                bVar.d = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f091b6f);
                bVar.e = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f091b6c);
                bVar.f = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f091b6d);
                SkinManager.setBackgroundColor(view3, R.color.CAM_X0201);
                SkinManager.setViewTextColor(bVar.b, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(bVar.c, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.d, (int) R.color.CAM_X0107);
                SkinManager.setViewTextColor(bVar.f, (int) R.color.CAM_X0301);
                view3.setTag(bVar);
            } else {
                view3 = view2;
                bVar = (b) view2.getTag();
            }
            cv5 item = getItem(i);
            if (item != null && (threadData = item.a) != null && threadData.getAuthor() != null && item.a.getThreadAlaInfo() != null) {
                MetaData author = item.a.getAuthor();
                bVar.a.K(item.a.getThreadAlaInfo().cover, 10, false);
                bVar.b.setText(item.a.getTitle());
                this.d = 0;
                bVar.e.setVisibility(8);
                bVar.f.setVisibility(8);
                if (!ListUtils.isEmpty(item.d)) {
                    for (cv5.a aVar : item.d) {
                        if (aVar != null) {
                            int i2 = aVar.a;
                            if (1 == i2) {
                                bVar.e.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.b)) {
                                    bVar.e.setText(aVar.b);
                                }
                                this.d++;
                            } else if (2 == i2) {
                                bVar.f.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.b)) {
                                    bVar.f.setText(aVar.b);
                                }
                                this.d++;
                            }
                        }
                    }
                }
                String name_show = author.getName_show();
                int i3 = this.d <= 1 ? 14 : 13;
                if (dj.byteLength(name_show) > i3) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i3, StringHelper.STRING_MORE);
                }
                bVar.d.setText(name_show);
                bVar.c.setText(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f11e5, StringHelper.numberUniformFormatExtra(item.a.getThreadAlaInfo().audience_count)));
                view3.setOnClickListener(new a(this, item));
                StatisticItem statisticItem = new StatisticItem("c12658");
                statisticItem.param("tid", item.a.getTid());
                xu5.b().a(statisticItem);
            }
            return view3;
        }
        return (View) invokeILL.objValue;
    }
}
