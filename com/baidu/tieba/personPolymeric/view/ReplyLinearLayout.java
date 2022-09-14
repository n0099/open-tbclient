package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ReplyLinearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static ViewGroup.LayoutParams d;
    public transient /* synthetic */ FieldHolder $fh;
    public List<TextView> a;
    public boolean b;
    public View.OnClickListener c;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyLinearLayout a;

        public a(ReplyLinearLayout replyLinearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyLinearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replyLinearLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String[] strArr = (String[]) view2.getTag();
                TiebaStatic.log(new StatisticItem("c12043").param("obj_type", this.a.b ? 1 : 2));
                if (strArr != null) {
                    Context context = this.a.getContext();
                    if ("0".equals(strArr[3])) {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(context).createNormalCfg(strArr[1], strArr[2], "person_page");
                        createNormalCfg.setStartFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                        return;
                    }
                    SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(context).createSubPbActivityConfig(strArr[1], strArr[2], "person_post_reply", false, null, false);
                    createSubPbActivityConfig.setKeyPageStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReplyLinearLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void b(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, textView, i) == null) {
            if (i == 0) {
                SkinManager.setViewTextColor(textView, R.color.common_color_10039, 1);
                textView.setPadding(0, ej.d(getContext(), 10.0f), 0, ej.d(getContext(), 10.0f));
                return;
            }
            int i2 = i % 3;
            if (i2 == 2) {
                SkinManager.setViewTextColor(textView, R.color.common_color_10081, 1);
                textView.setBackgroundResource(R.color.CAM_X0201);
                textView.setPadding(0, ej.d(getContext(), 10.0f), 0, ej.d(getContext(), 2.0f));
            } else if (i2 == 0) {
                SkinManager.setViewTextColor(textView, R.color.common_color_10005, 1);
                textView.setPadding(0, ej.d(getContext(), 2.0f), 0, ej.d(getContext(), 10.0f));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setContent(ArrayList<String[]> arrayList) {
        int i;
        CharSequence[] charSequenceArr;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            if (d == null) {
                d = new LinearLayout.LayoutParams(-1, -2);
            }
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
            int size = ((arrayList.size() - 1) * 3) + 1;
            int size2 = size - this.a.size();
            for (int i4 = 0; i4 < size2; i4++) {
                TextView textView = new TextView(getContext());
                this.a.add(textView);
                addView(textView);
            }
            for (int i5 = 0; i5 < this.a.size(); i5++) {
                TextView textView2 = this.a.get(i5);
                if (i5 < size) {
                    if (i5 != 0 && i5 != 1) {
                        int i6 = i5 % 3;
                        if (i6 == 0 || i6 == 1) {
                            i = i5 / 3;
                        } else if (i6 == 2) {
                            i = (i5 / 3) + 1;
                        }
                        charSequenceArr = (String[]) arrayList.get(i);
                        if (i5 != 0 || (i3 = i5 % 3) == 2) {
                            textView2.setText(charSequenceArr[0]);
                        } else if (i3 == 0) {
                            textView2.setText(charSequenceArr[4]);
                        }
                        textView2.setTag(charSequenceArr);
                        textView2.setOnClickListener(this.c);
                        b(textView2, i5);
                        if (i5 != 0) {
                            textView2.setTextSize(17.0f);
                            textView2.setMaxLines(3);
                            textView2.setLayoutParams(d);
                            SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                        } else if (i5 == 1 || (i2 = i5 % 3) == 1) {
                            textView2.setLayoutParams(layoutParams);
                            SkinManager.setBackgroundResource(textView2, R.color.CAM_X0204);
                        } else if (i2 == 2) {
                            textView2.setTextSize(15.0f);
                            textView2.setMaxLines(2);
                            textView2.setLayoutParams(d);
                            SkinManager.setViewTextColor(textView2, R.color.CAM_X0106, 1);
                        } else if (i2 == 0) {
                            textView2.setTextSize(10.0f);
                            textView2.setLayoutParams(d);
                            SkinManager.setViewTextColor(textView2, R.color.CAM_X0109, 1);
                        }
                        textView2.setVisibility(0);
                    }
                    i = 0;
                    charSequenceArr = (String[]) arrayList.get(i);
                    if (i5 != 0) {
                    }
                    textView2.setText(charSequenceArr[0]);
                    textView2.setTag(charSequenceArr);
                    textView2.setOnClickListener(this.c);
                    b(textView2, i5);
                    if (i5 != 0) {
                    }
                    textView2.setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                }
            }
        }
    }

    public void setIsHost(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.b = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new a(this);
        this.a = new ArrayList();
    }
}
