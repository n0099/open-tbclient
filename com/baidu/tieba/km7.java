package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.nu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes4.dex */
public class km7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
                e eVar = this.a;
                if (eVar != null) {
                    eVar.a(this.b.getBcode());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
                e eVar = this.a;
                if (eVar != null) {
                    eVar.b();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
                e eVar = this.a;
                if (eVar != null) {
                    eVar.a(this.b.getBcode());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
                e eVar = this.a;
                if (eVar != null) {
                    eVar.b();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i);

        void b();
    }

    public static void a(TbPageContext<?> tbPageContext, BubbleListData.BubbleData bubbleData, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, bubbleData, eVar) == null) || bubbleData == null) {
            return;
        }
        nu4 nu4Var = new nu4(tbPageContext.getPageActivity());
        nu4Var.setCanceledOnTouchOutside(false);
        Date date = new Date();
        Date date2 = new Date(date.getTime() + (bubbleData.getTime_interval() * 1000));
        String dateStringDay = dj.getDateStringDay(date);
        String dateStringDay2 = dj.getDateStringDay(date2);
        String format = String.format(tbPageContext.getResources().getString(R.string.obfuscated_res_0x7f0f0356), bubbleData.getBname(), Integer.valueOf(bubbleData.getTime_interval() / 86400));
        View inflate = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0166, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921f1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921f2);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0108, 1);
        textView.setText(format);
        textView2.setText(dateStringDay + tbPageContext.getString(R.string.obfuscated_res_0x7f0f1447) + dateStringDay2);
        nu4Var.setContentView(inflate);
        nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f14fc, new a(eVar, bubbleData));
        nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new b(eVar));
        nu4Var.create(tbPageContext);
        nu4Var.show();
    }

    public static void b(TbPageContext<?> tbPageContext, BubbleListData.BubbleData bubbleData, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, bubbleData, eVar) == null) || bubbleData == null) {
            return;
        }
        nu4 nu4Var = new nu4(tbPageContext.getPageActivity());
        nu4Var.setCanceledOnTouchOutside(false);
        nu4Var.setMessage(String.format(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0358), bubbleData.getLevel_name()));
        nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d13, new c(eVar, bubbleData));
        nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new d(eVar));
        nu4Var.create(tbPageContext);
        nu4Var.show();
    }
}
