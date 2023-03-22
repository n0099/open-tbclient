package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes5.dex */
public class p98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface e {
        void a(int i);

        void b();
    }

    /* loaded from: classes5.dex */
    public static class a implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
                e eVar = this.a;
                if (eVar != null) {
                    eVar.a(this.b.getBcode());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
                e eVar = this.a;
                if (eVar != null) {
                    eVar.b();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
                e eVar = this.a;
                if (eVar != null) {
                    eVar.a(this.b.getBcode());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
                e eVar = this.a;
                if (eVar != null) {
                    eVar.b();
                }
            }
        }
    }

    public static void a(TbPageContext<?> tbPageContext, BubbleListData.BubbleData bubbleData, e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65536, null, tbPageContext, bubbleData, eVar) != null) || bubbleData == null) {
            return;
        }
        zz4 zz4Var = new zz4(tbPageContext.getPageActivity());
        zz4Var.setCanceledOnTouchOutside(false);
        Date date = new Date();
        Date date2 = new Date(date.getTime() + (bubbleData.getTime_interval() * 1000));
        String dateStringDay = gi.getDateStringDay(date);
        String dateStringDay2 = gi.getDateStringDay(date2);
        String format = String.format(tbPageContext.getResources().getString(R.string.obfuscated_res_0x7f0f036e), bubbleData.getBname(), Integer.valueOf(bubbleData.getTime_interval() / 86400));
        View inflate = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.bubble_free_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0923d4);
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0923d5);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0108, 1);
        textView.setText(format);
        textView2.setText(dateStringDay + tbPageContext.getString(R.string.obfuscated_res_0x7f0f1527) + dateStringDay2);
        zz4Var.setContentView(inflate);
        zz4Var.setPositiveButton(R.string.use_immediately, new a(eVar, bubbleData));
        zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038e, new b(eVar));
        zz4Var.create(tbPageContext);
        zz4Var.show();
    }

    public static void b(TbPageContext<?> tbPageContext, BubbleListData.BubbleData bubbleData, e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65537, null, tbPageContext, bubbleData, eVar) != null) || bubbleData == null) {
            return;
        }
        zz4 zz4Var = new zz4(tbPageContext.getPageActivity());
        zz4Var.setCanceledOnTouchOutside(false);
        zz4Var.setMessage(String.format(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0370), bubbleData.getLevel_name()));
        zz4Var.setPositiveButton(R.string.open_now, new c(eVar, bubbleData));
        zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038e, new d(eVar));
        zz4Var.create(tbPageContext);
        zz4Var.show();
    }
}
