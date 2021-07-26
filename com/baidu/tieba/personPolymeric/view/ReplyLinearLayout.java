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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ReplyLinearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static ViewGroup.LayoutParams f20388h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<TextView> f20389e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20390f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f20391g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyLinearLayout f20392e;

        public a(ReplyLinearLayout replyLinearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyLinearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20392e = replyLinearLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String[] strArr = (String[]) view.getTag();
                TiebaStatic.log(new StatisticItem("c12043").param("obj_type", this.f20392e.f20390f ? 1 : 2));
                if (strArr != null) {
                    Context context = this.f20392e.getContext();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void b(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, textView, i2) == null) {
            if (i2 == 0) {
                SkinManager.setViewTextColor(textView, R.color.common_color_10039, 1);
                textView.setPadding(0, l.e(getContext(), 10.0f), 0, l.e(getContext(), 10.0f));
                return;
            }
            int i3 = i2 % 3;
            if (i3 == 2) {
                SkinManager.setViewTextColor(textView, R.color.common_color_10081, 1);
                textView.setBackgroundResource(R.color.CAM_X0201);
                textView.setPadding(0, l.e(getContext(), 10.0f), 0, l.e(getContext(), 2.0f));
            } else if (i3 == 0) {
                SkinManager.setViewTextColor(textView, R.color.common_color_10005, 1);
                textView.setPadding(0, l.e(getContext(), 2.0f), 0, l.e(getContext(), 10.0f));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setContent(ArrayList<String[]> arrayList) {
        int i2;
        CharSequence[] charSequenceArr;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            if (f20388h == null) {
                f20388h = new LinearLayout.LayoutParams(-1, -2);
            }
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
            int size = ((arrayList.size() - 1) * 3) + 1;
            int size2 = size - this.f20389e.size();
            for (int i5 = 0; i5 < size2; i5++) {
                TextView textView = new TextView(getContext());
                this.f20389e.add(textView);
                addView(textView);
            }
            for (int i6 = 0; i6 < this.f20389e.size(); i6++) {
                TextView textView2 = this.f20389e.get(i6);
                if (i6 < size) {
                    if (i6 != 0 && i6 != 1) {
                        int i7 = i6 % 3;
                        if (i7 == 0 || i7 == 1) {
                            i2 = i6 / 3;
                        } else if (i7 == 2) {
                            i2 = (i6 / 3) + 1;
                        }
                        charSequenceArr = (String[]) arrayList.get(i2);
                        if (i6 != 0 || (i4 = i6 % 3) == 2) {
                            textView2.setText(charSequenceArr[0]);
                        } else if (i4 == 0) {
                            textView2.setText(charSequenceArr[4]);
                        }
                        textView2.setTag(charSequenceArr);
                        textView2.setOnClickListener(this.f20391g);
                        b(textView2, i6);
                        if (i6 != 0) {
                            textView2.setTextSize(17.0f);
                            textView2.setMaxLines(3);
                            textView2.setLayoutParams(f20388h);
                            SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                        } else if (i6 == 1 || (i3 = i6 % 3) == 1) {
                            textView2.setLayoutParams(layoutParams);
                            SkinManager.setBackgroundResource(textView2, R.color.CAM_X0204);
                        } else if (i3 == 2) {
                            textView2.setTextSize(15.0f);
                            textView2.setMaxLines(2);
                            textView2.setLayoutParams(f20388h);
                            SkinManager.setViewTextColor(textView2, R.color.CAM_X0106, 1);
                        } else if (i3 == 0) {
                            textView2.setTextSize(10.0f);
                            textView2.setLayoutParams(f20388h);
                            SkinManager.setViewTextColor(textView2, R.color.CAM_X0109, 1);
                        }
                        textView2.setVisibility(0);
                    }
                    i2 = 0;
                    charSequenceArr = (String[]) arrayList.get(i2);
                    if (i6 != 0) {
                    }
                    textView2.setText(charSequenceArr[0]);
                    textView2.setTag(charSequenceArr);
                    textView2.setOnClickListener(this.f20391g);
                    b(textView2, i6);
                    if (i6 != 0) {
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
            this.f20390f = z;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20391g = new a(this);
        this.f20389e = new ArrayList();
    }
}
