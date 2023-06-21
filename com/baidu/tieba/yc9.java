package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pbextra.adapter.PbInterviewLiveNormalItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yc9 extends g79<b0a, PbInterviewLiveNormalItemViewHolder> implements View.OnClickListener, d69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int g;
    public boolean h;
    public boolean i;
    public j49 j;
    public boolean k;
    public View.OnClickListener l;
    public TbRichTextView.z m;
    public q59 n;
    public View.OnLongClickListener o;
    public int p;
    public int q;
    public boolean r;
    public final boolean s;

    @Override // com.baidu.tieba.d69
    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
        }
    }

    @Override // com.baidu.tieba.d69
    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
        }
    }

    @Override // com.baidu.tieba.d69
    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public a(yc9 yc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yc9(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((jc9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        boolean z = false;
        this.g = 0;
        this.h = true;
        this.i = true;
        this.j = null;
        this.k = true;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.r = false;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 14 && i3 <= 16) {
            z = true;
        }
        this.s = z;
        t(pbFragment);
    }

    public View A(int i, View view2, ViewGroup viewGroup, b0a b0aVar, PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, b0aVar, pbInterviewLiveNormalItemViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) b0aVar, (b0a) pbInterviewLiveNormalItemViewHolder);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            B(pbInterviewLiveNormalItemViewHolder);
            y(pbInterviewLiveNormalItemViewHolder, b0aVar);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void B(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbInterviewLiveNormalItemViewHolder) == null) {
            pbInterviewLiveNormalItemViewHolder.b.setOnLongClickListener(this.o);
            pbInterviewLiveNormalItemViewHolder.b.setOnTouchListener(this.n);
            pbInterviewLiveNormalItemViewHolder.b.setOnImageClickListener(this.m);
            jc9 jc9Var = this.a;
            if (jc9Var != null && jc9Var.V() != null) {
                pbInterviewLiveNormalItemViewHolder.b.setOnEmotionClickListener(this.a.V().c.f);
            }
        }
    }

    @Override // com.baidu.tieba.g79
    public void t(jc9 jc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jc9Var) == null) {
            super.t(jc9Var);
            if (jc9Var != null) {
                this.p = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201);
                this.q = wi.l(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070253);
            }
        }
    }

    @Override // com.baidu.tieba.d69
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.h = z;
        }
    }

    @Override // com.baidu.tieba.d69
    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onLongClickListener) == null) {
            this.o = onLongClickListener;
        }
    }

    @Override // com.baidu.tieba.d69
    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    @Override // com.baidu.tieba.d69
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.k = z;
        }
    }

    @Override // com.baidu.tieba.d69
    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.d69
    public void n(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zVar) == null) {
            this.m = zVar;
        }
    }

    @Override // com.baidu.tieba.d69
    public void r(j49 j49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, j49Var) == null) {
            this.j = j49Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: z */
    public PbInterviewLiveNormalItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, viewGroup)) == null) {
            return new PbInterviewLiveNormalItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0765, viewGroup, false), this.i, this.h, this.g, false);
        }
        return (PbInterviewLiveNormalItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.g79, com.baidu.tieba.jn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        A(i, view2, viewGroup, (b0a) obj, (PbInterviewLiveNormalItemViewHolder) viewHolder);
        return view2;
    }

    public final void u(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, b0a b0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, pbInterviewLiveNormalItemViewHolder, b0aVar) == null) {
            if (!TextUtils.isEmpty(b0aVar.t()) && this.h) {
                pbInterviewLiveNormalItemViewHolder.b.setOnClickListener(this.l);
            } else {
                pbInterviewLiveNormalItemViewHolder.b.setOnClickListener(null);
            }
            pbInterviewLiveNormalItemViewHolder.b.setTextViewCheckSelection(false);
            pbInterviewLiveNormalItemViewHolder.b.setTextViewOnClickListener(new a(this));
        }
    }

    public final void x(TbRichTextView tbRichTextView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048593, this, tbRichTextView, i) != null) || tbRichTextView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
        layoutParams.leftMargin = i;
        tbRichTextView.getLayoutStrategy().r(this.q - (i - this.p));
        tbRichTextView.setLayoutParams(layoutParams);
    }

    public final void y(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, b0a b0aVar) {
        m45 taskInfoData;
        int i;
        float f;
        String str;
        String str2;
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, pbInterviewLiveNormalItemViewHolder, b0aVar) == null) && pbInterviewLiveNormalItemViewHolder != null && b0aVar != null) {
            x(pbInterviewLiveNormalItemViewHolder.b, (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.b.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pbInterviewLiveNormalItemViewHolder.b.setLayoutParams(layoutParams);
            pbInterviewLiveNormalItemViewHolder.b.setPadding(0, 0, 0, 0);
            pbInterviewLiveNormalItemViewHolder.b.p0(null);
            b0aVar.y1();
            if (b0aVar.I() == 1) {
                pbInterviewLiveNormalItemViewHolder.d.setVisibility(0);
                if (b0aVar.q() != null) {
                    long userIdLong = b0aVar.q().getUserIdLong();
                    String userName = b0aVar.q().getUserName();
                    str2 = b0aVar.q().getName_show();
                    str = userName;
                    j = userIdLong;
                } else {
                    str = null;
                    str2 = null;
                    j = 0;
                }
                pbInterviewLiveNormalItemViewHolder.d.g(b0aVar.Q(), str, str2, j, ug.g(this.j.N().getId(), 0L), ug.g(b0aVar.S(), 0L));
                pbInterviewLiveNormalItemViewHolder.d.i();
                if (this.k) {
                    PraiseData praise = this.j.N().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        pbInterviewLiveNormalItemViewHolder.e.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.c.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.f.setVisibility(0);
                        pbInterviewLiveNormalItemViewHolder.e.setIsFromPb(true);
                        pbInterviewLiveNormalItemViewHolder.e.setData(praise, this.j.N().getId(), praise.getPostId(), true);
                        pbInterviewLiveNormalItemViewHolder.e.i(this.d);
                    } else {
                        pbInterviewLiveNormalItemViewHolder.e.setVisibility(8);
                        pbInterviewLiveNormalItemViewHolder.c.setVisibility(8);
                        pbInterviewLiveNormalItemViewHolder.f.setVisibility(8);
                    }
                } else {
                    pbInterviewLiveNormalItemViewHolder.e.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.c.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.f.setVisibility(8);
                }
                pbInterviewLiveNormalItemViewHolder.e.setVisibility(0);
                pbInterviewLiveNormalItemViewHolder.c.setVisibility(0);
                pbInterviewLiveNormalItemViewHolder.f.setVisibility(0);
                x(pbInterviewLiveNormalItemViewHolder.b, (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201));
            } else {
                pbInterviewLiveNormalItemViewHolder.d.setVisibility(8);
            }
            pbInterviewLiveNormalItemViewHolder.b.getLayoutStrategy().z(R.drawable.pic_video);
            pbInterviewLiveNormalItemViewHolder.b.setTextColor(SkinManager.getColor(R.color.common_color_10039));
            pbInterviewLiveNormalItemViewHolder.b.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbInterviewLiveNormalItemViewHolder.b.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            if (this.h) {
                pbInterviewLiveNormalItemViewHolder.b.getLayoutStrategy().h(R.drawable.transparent_bg);
            } else {
                pbInterviewLiveNormalItemViewHolder.b.getLayoutStrategy().h(R.drawable.icon_click);
            }
            pbInterviewLiveNormalItemViewHolder.b.setIsFromCDN(this.e);
            TbRichText e0 = b0aVar.e0();
            if (!this.r && this.s) {
                pbInterviewLiveNormalItemViewHolder.b.setText(e0, true);
            } else {
                pbInterviewLiveNormalItemViewHolder.b.setText(e0, false);
            }
            if (this.j.N().getTaskInfoData() != null) {
                TbImageView tbImageView = pbInterviewLiveNormalItemViewHolder.a;
                String m = this.j.N().getTaskInfoData().m();
                if (this.e) {
                    i = 17;
                } else {
                    i = 18;
                }
                tbImageView.N(m, i, false);
                int l = wi.l(this.mContext);
                float l2 = taskInfoData.l() / taskInfoData.n();
                if (l2 > 1.0f) {
                    f = l * 1.0f;
                } else if (l2 < 0.2f) {
                    f = l * 0.2f;
                } else {
                    f = l * l2;
                }
                int i2 = (int) f;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.a.getLayoutParams();
                layoutParams2.height = i2;
                layoutParams2.width = l;
                pbInterviewLiveNormalItemViewHolder.a.setLayoutParams(layoutParams2);
            } else {
                pbInterviewLiveNormalItemViewHolder.a.setVisibility(8);
            }
            u(pbInterviewLiveNormalItemViewHolder, b0aVar);
        }
    }
}
