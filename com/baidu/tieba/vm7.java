package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.pu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes6.dex */
public class vm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface e {
        void a(int i);

        void b();
    }

    /* loaded from: classes6.dex */
    public final class a implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public final /* synthetic */ BubbleListData.BubbleData b;

        public a(e eVar, BubbleListData.BubbleData bubbleData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bubbleData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = bubbleData;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
                e eVar = this.a;
                if (eVar != null) {
                    eVar.a(this.b.getBcode());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class b implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
                e eVar = this.a;
                if (eVar != null) {
                    eVar.b();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class c implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public final /* synthetic */ BubbleListData.BubbleData b;

        public c(e eVar, BubbleListData.BubbleData bubbleData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bubbleData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = bubbleData;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
                e eVar = this.a;
                if (eVar != null) {
                    eVar.a(this.b.getBcode());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class d implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
                e eVar = this.a;
                if (eVar != null) {
                    eVar.b();
                }
            }
        }
    }

    public static void a(TbPageContext tbPageContext, BubbleListData.BubbleData bubbleData, e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65536, null, tbPageContext, bubbleData, eVar) != null) || bubbleData == null) {
            return;
        }
        pu4 pu4Var = new pu4(tbPageContext.getPageActivity());
        pu4Var.setCanceledOnTouchOutside(false);
        Date date = new Date();
        Date date2 = new Date(date.getTime() + (bubbleData.getTime_interval() * 1000));
        String dateStringDay = ej.getDateStringDay(date);
        String dateStringDay2 = ej.getDateStringDay(date2);
        String format = String.format(tbPageContext.getResources().getString(R.string.obfuscated_res_0x7f0f0356), bubbleData.getBname(), Integer.valueOf(bubbleData.getTime_interval() / 86400));
        View inflate = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0165, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921db);
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921dc);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0108, 1);
        textView.setText(format);
        textView2.setText(dateStringDay + tbPageContext.getString(R.string.obfuscated_res_0x7f0f1460) + dateStringDay2);
        pu4Var.setContentView(inflate);
        pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1515, new a(eVar, bubbleData));
        pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new b(eVar));
        pu4Var.create(tbPageContext);
        pu4Var.show();
    }

    public static void b(TbPageContext tbPageContext, BubbleListData.BubbleData bubbleData, e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65537, null, tbPageContext, bubbleData, eVar) != null) || bubbleData == null) {
            return;
        }
        pu4 pu4Var = new pu4(tbPageContext.getPageActivity());
        pu4Var.setCanceledOnTouchOutside(false);
        pu4Var.setMessage(String.format(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0358), bubbleData.getLevel_name()));
        pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d24, new c(eVar, bubbleData));
        pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new d(eVar));
        pu4Var.create(tbPageContext);
        pu4Var.show();
    }
}
