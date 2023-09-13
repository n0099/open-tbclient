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
import com.baidu.tieba.md6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jd6 extends id6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ md6 a;
        public final /* synthetic */ jd6 b;

        public a(jd6 jd6Var, md6 md6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd6Var, md6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jd6Var;
            this.a = md6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = new StatisticItem("c12659");
                statisticItem.param("tid", this.a.a.getTid());
                TiebaStatic.log(statisticItem);
                jd6 jd6Var = this.b;
                jd6Var.b(jd6Var.a, this.a.a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
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
    public jd6(TbPageContext tbPageContext) {
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                bVar = new b(null);
                view3 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d090e, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f091e7b);
                bVar.a = tbImageView;
                tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
                bVar.b = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f091e7e);
                bVar.c = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f091e7a);
                bVar.d = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f091e7f);
                bVar.e = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f091e7c);
                bVar.f = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f091e7d);
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
            md6 item = getItem(i);
            if (item != null && (threadData = item.a) != null && threadData.getAuthor() != null && item.a.getThreadAlaInfo() != null) {
                MetaData author = item.a.getAuthor();
                bVar.a.startLoad(item.a.getThreadAlaInfo().cover, 10, false);
                bVar.b.setText(item.a.getTitle());
                this.d = 0;
                bVar.e.setVisibility(8);
                bVar.f.setVisibility(8);
                if (!ListUtils.isEmpty(item.d)) {
                    for (md6.a aVar : item.d) {
                        if (aVar != null) {
                            int i3 = aVar.a;
                            if (1 == i3) {
                                bVar.e.setVisibility(0);
                                if (!TextUtils.isEmpty(aVar.b)) {
                                    bVar.e.setText(aVar.b);
                                }
                                this.d++;
                            } else if (2 == i3) {
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
                if (this.d <= 1) {
                    i2 = 14;
                } else {
                    i2 = 13;
                }
                if (ei.byteLength(name_show) > i2) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i2, "...");
                }
                bVar.d.setText(name_show);
                bVar.c.setText(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f144e, StringHelper.numberUniformFormatExtra(item.a.getThreadAlaInfo().audience_count)));
                view3.setOnClickListener(new a(this, item));
                StatisticItem statisticItem = new StatisticItem("c12658");
                statisticItem.param("tid", item.a.getTid());
                hd6.b().a(statisticItem);
            }
            return view3;
        }
        return (View) invokeILL.objValue;
    }
}
