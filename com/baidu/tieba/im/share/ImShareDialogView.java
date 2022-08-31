package com.baidu.tieba.im.share;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.share.ImShareDialogView;
import com.baidu.tieba.ki5;
import com.baidu.tieba.ns4;
import com.baidu.tieba.qz8;
import com.baidu.tieba.ri;
import com.baidu.tieba.y97;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ImShareDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView a;
    public LinearLayout b;
    public FrameLayout c;
    public GifView d;
    public TbImageView e;
    public TextView f;
    public LinearLayout g;
    public BarImageView h;
    public TextView i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public SpanGroupEditText m;
    public TextView n;
    public TextView o;
    public y97 p;
    public CustomMessageListener q;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImShareDialogView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImShareDialogView imShareDialogView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imShareDialogView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imShareDialogView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.f();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImShareDialogView(Context context) {
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

    private void setImage(ThreadData threadData) {
        MediaData mediaData;
        String picUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, threadData) == null) {
            if (threadData.getThreadType() == 40 && threadData.getThreadVideoInfo() != null) {
                picUrl = threadData.getThreadVideoInfo().thumbnail_url;
                this.e.setVisibility(0);
                this.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0808af, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            } else {
                new MediaData();
                if (threadData.isImShareFromPb()) {
                    OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
                    if (originalThreadInfo != null && !ListUtils.isEmpty(originalThreadInfo.h)) {
                        mediaData = threadData.originalThreadData.h.get(0);
                        mediaData.setSrc_pic(threadData.originalThreadData.c);
                    } else {
                        this.c.setVisibility(8);
                        return;
                    }
                } else if (ListUtils.isEmpty(threadData.getMedias())) {
                    this.c.setVisibility(8);
                    return;
                } else {
                    mediaData = threadData.getMedias().get(0);
                }
                if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                    picUrl = mediaData.getSrc_pic();
                } else {
                    picUrl = !TextUtils.isEmpty(mediaData.getPicUrl()) ? mediaData.getPicUrl() : null;
                }
            }
            if (TextUtils.isEmpty(picUrl)) {
                this.c.setVisibility(8);
                return;
            }
            this.d.setVisibility(0);
            this.d.j0(picUrl, 38);
        }
    }

    private void setInfoText(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, threadData) == null) {
            CharSequence string = getContext().getString(R.string.obfuscated_res_0x7f0f08c8);
            if (!TextUtils.isEmpty(threadData.getTitleText()) && threadData.getIsNoTitle() == 0) {
                string = b(threadData, threadData.getTitleText());
            } else if (!TextUtils.isEmpty(threadData.getTitle()) && threadData.getIsNoTitle() == 0) {
                string = b(threadData, threadData.getTitle());
            } else if (!TextUtils.isEmpty(threadData.getAbstractText())) {
                string = b(threadData, threadData.getAbstractText());
                c(threadData, string);
                d(threadData, string);
            } else if (!TextUtils.isEmpty(threadData.getAbstract())) {
                string = b(threadData, threadData.getAbstract());
                c(threadData, string);
                d(threadData, string);
            } else if (threadData.isImShareFromPb() && threadData.getPbFirstShareData() != null && threadData.getPbFirstShareData().V() != null) {
                string = threadData.getPbFirstShareData().V().toString();
            }
            this.f.setText(string);
        }
    }

    public final CharSequence b(ThreadData threadData, CharSequence charSequence) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, threadData, charSequence)) == null) {
            if (threadData == null || !threadData.isShareThread || threadData.originalThreadData == null) {
                return charSequence;
            }
            SpannableStringBuilder append = new SpannableStringBuilder(charSequence).append((CharSequence) "//");
            OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
            return new SpannableString(append.append((CharSequence) new SpannableString(ki5.G(originalThreadInfo.s, originalThreadInfo.E, false, threadData, originalThreadInfo.g()))));
        }
        return (CharSequence) invokeLL.objValue;
    }

    public final void c(ThreadData threadData, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData, charSequence) == null) && threadData.isVoiceThreadType()) {
            String str = ((Object) charSequence) + getContext().getString(R.string.obfuscated_res_0x7f0f08ce);
        }
    }

    public final void d(ThreadData threadData, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, threadData, charSequence) == null) || threadData.getPollData() == null) {
            return;
        }
        String str = ((Object) charSequence) + getContext().getString(R.string.obfuscated_res_0x7f0f08cf);
    }

    public final void e(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, metaData) == null) {
            String name_show = metaData.getName_show();
            EMTextView eMTextView = this.a;
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f08cd);
            Object[] objArr = new Object[1];
            if (name_show == null) {
                name_show = "";
            }
            objArr[0] = name_show;
            eMTextView.setText(String.format(string, objArr));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ns4 d = ns4.d(this);
            d.n(R.string.J_X14);
            d.f(R.color.CAM_X0212);
            ns4.d(this.a).v(R.color.CAM_X0109);
            ns4 d2 = ns4.d(this.b);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0207);
            ns4.d(this.f).v(R.color.CAM_X0107);
            ns4 d3 = ns4.d(this.g);
            d3.n(R.string.J_X05);
            d3.f(R.color.CAM_X0207);
            ns4 d4 = ns4.d(this.i);
            d4.v(R.color.CAM_X0105);
            d4.A(R.string.F_X02);
            ns4.d(this.j).v(R.color.CAM_X0107);
            ns4.d(this.k).v(R.color.CAM_X0109);
            ns4.d(this.l).v(R.color.CAM_X0109);
            this.h.setStrokeColorResId(R.color.CAM_X0401);
            ns4 d5 = ns4.d(this.m);
            d5.n(R.string.J_X05);
            d5.f(R.color.CAM_X0207);
            this.m.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                qz8.l(this.m, R.drawable.obfuscated_res_0x7f0804ae);
            } else {
                qz8.l(this.m, R.drawable.obfuscated_res_0x7f0804af);
            }
            this.m.setHintTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), (int) R.color.CAM_X0109));
            ns4.d(this.n).x(R.color.CAM_X0107);
            ns4.d(this.o).x(R.color.CAM_X0304);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.n.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.w97
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ImShareDialogView.this.i(view2);
                    }
                }
            });
            this.o.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v97
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ImShareDialogView.this.j(view2);
                    }
                }
            });
        }
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            setOrientation(1);
            setLayoutParams(layoutParams);
            LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d03bf, this);
            this.a = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090e77);
            this.b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090e72);
            this.c = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090e74);
            GifView gifView = (GifView) findViewById(R.id.obfuscated_res_0x7f090e73);
            this.d = gifView;
            gifView.setConrers(15);
            this.d.setRadiusById(R.string.J_X04);
            this.d.setDrawCorner(true);
            this.d.setDrawBorder(true);
            this.d.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.L_X01));
            this.d.setBorderSurroundContent(true);
            this.d.setAutoPlay(true);
            this.d.setShowStaticDrawable(false);
            this.d.setSupportNoImage(false);
            this.d.setGifIconSupport(true);
            this.e = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090e76);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090e75);
            this.g = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090e67);
            BarImageView barImageView = (BarImageView) findViewById(R.id.obfuscated_res_0x7f090e68);
            this.h = barImageView;
            barImageView.setPlaceHolder(1);
            this.h.setShowOval(true);
            this.h.setAutoChangeStyle(true);
            this.h.setShowInnerBorder(true);
            this.h.setStrokeWith(ri.f(TbadkCoreApplication.getInst(), R.dimen.L_X01));
            this.h.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f090e6b);
            this.j = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090e66);
            this.k = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090e65);
            this.l = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090e6a);
            SpanGroupEditText spanGroupEditText = (SpanGroupEditText) findViewById(R.id.obfuscated_res_0x7f090e6c);
            this.m = spanGroupEditText;
            spanGroupEditText.setHint(R.string.obfuscated_res_0x7f0f08ca);
            this.m.setMaxLines(3);
            this.m.setMinLines(3);
            this.m.setIncludeFontPadding(false);
            this.m.setGravity(48);
            this.m.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
            this.m.setLineSpacing(ri.f(getContext(), R.dimen.M_T_X002), 1.0f);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090e6e);
            this.n = textView;
            textView.setText(context.getString(R.string.obfuscated_res_0x7f0f0371));
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f090e71);
            this.o = textView2;
            textView2.setText(context.getString(R.string.obfuscated_res_0x7f0f008b));
        }
    }

    public /* synthetic */ void i(View view2) {
        y97 y97Var = this.p;
        if (y97Var != null) {
            y97Var.a();
        }
    }

    public /* synthetic */ void j(View view2) {
        if (this.p != null) {
            this.p.b(this.m.getText() != null ? this.m.getText().toString() : "");
        }
    }

    public final void k(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, forumData) == null) {
            this.h.K(forumData.getImage_url(), 10, false);
            this.i.setText("" + forumData.getName() + getResources().getString(R.string.obfuscated_res_0x7f0f065b));
            if (!TextUtils.isEmpty(forumData.getSlogan())) {
                this.j.setVisibility(0);
                this.j.setText(forumData.getSlogan());
            } else {
                this.j.setVisibility(8);
            }
            this.k.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0425), StringHelper.numberUniformFormatExtra(forumData.getMember_num())));
            this.l.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f06c4), StringHelper.numberUniformFormatExtra(forumData.getThread_num())));
        }
    }

    public void l(ForumData forumData, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, forumData, metaData) == null) || forumData == null || TextUtils.isEmpty(forumData.getId()) || metaData == null) {
            return;
        }
        this.g.setVisibility(0);
        this.b.setVisibility(8);
        e(metaData);
        k(forumData);
    }

    public void m(ThreadData threadData, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, threadData, metaData) == null) || threadData == null || metaData == null) {
            return;
        }
        this.b.setVisibility(0);
        this.g.setVisibility(8);
        this.e.setVisibility(8);
        e(metaData);
        setImage(threadData);
        setInfoText(threadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onAttachedToWindow();
            if (this.q == null) {
                this.q = new a(this, 2001304);
                MessageManager.getInstance().registerListener(this.q);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    public void setShareClickCallBack(y97 y97Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, y97Var) == null) {
            this.p = y97Var;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImShareDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImShareDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        h(context);
        g();
        f();
    }
}
