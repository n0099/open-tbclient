package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ul6 extends zk6<ThreadData> implements s16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View i;
    public TbPageContext<?> j;
    public HeadImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public ThreadData o;
    public rl6 p;
    public FrsBaseVideoView q;

    @Override // com.baidu.tieba.s16
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.zk6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.frs_hottopic_video_card : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ul6(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View i3 = i();
        i3.setOnClickListener(this);
        this.j = tbPageContext;
        HeadImageView headImageView = (HeadImageView) i3.findViewById(R.id.topic_icon);
        this.k = headImageView;
        headImageView.setIsRound(true);
        this.k.setDefaultResource(R.drawable.pic_head_topic);
        this.l = (TextView) i3.findViewById(R.id.card_topic_name);
        this.n = (TextView) i3.findViewById(R.id.card_thread_title);
        this.m = (TextView) i3.findViewById(R.id.card_reply_time);
        this.i = i3.findViewById(R.id.card_divider_line);
        FrsBaseVideoView frsBaseVideoView = (FrsBaseVideoView) i3.findViewById(R.id.base_video_view);
        this.q = frsBaseVideoView;
        frsBaseVideoView.setClickListener(this);
    }

    @Override // com.baidu.tieba.zk6
    public void l(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            this.k.invalidate();
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(i(), R.drawable.addresslist_item_bg);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            FrsBaseVideoView frsBaseVideoView = this.q;
            if (frsBaseVideoView != null) {
                frsBaseVideoView.h(i);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, view2) != null) || this.o == null) {
            return;
        }
        if (f() != null) {
            f().b(view2, this.o, this.p);
        }
        jl6.a(this.o.getTid());
        jl6.l(this.n, this.o.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
        p();
    }

    public final void p() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (threadData = this.o) != null && threadData.getAuthor() != null && this.o.getAuthor().getName_show() != null) {
            rt5.f(this.j, null, this.o.getAuthor().getName_show());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zk6
    /* renamed from: r */
    public void k(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) {
            if (threadData == null) {
                if (i() != null) {
                    i().setVisibility(8);
                    return;
                }
                return;
            }
            this.o = threadData;
            if (i() != null) {
                i().setVisibility(0);
                i().setOnClickListener(this);
            }
            FrsBaseVideoView frsBaseVideoView = this.q;
            if (frsBaseVideoView != null) {
                frsBaseVideoView.g(this.o, threadData.getHotTopicInfo());
            }
            if (threadData.getAuthor() != null) {
                this.l.setText(threadData.getAuthor().getName_show());
            }
            this.m.setText(StringHelper.getFormatTime(threadData.getLast_time_int() * 1000));
            String str = threadData.getTopicUserName() + "：";
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.append((CharSequence) threadData.parseTitleOrAbstractForFrsNew(false, true));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
            this.n.setText(spannableStringBuilder);
            jl6.l(this.n, this.o.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
            l(this.j, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
