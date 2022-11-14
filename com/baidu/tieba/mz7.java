package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFloorComplaint;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.qy7;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w36;
import com.baidu.tieba.y28;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class mz7 extends kn<PostData, PbCommenFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext b;
    public View.OnClickListener c;
    public View.OnClickListener d;
    public TbRichTextView.y e;
    public qy7 f;
    public View.OnLongClickListener g;
    public String h;
    public ox7 i;
    public boolean j;
    public SparseIntArray k;
    public y38 l;
    public w28 m;
    public y28 n;
    public TbRichTextView.s o;
    public boolean p;
    public og<ConstrainImageLayout> q;
    public og<TbImageView> r;
    public qy7 s;

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ mz7 b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostData a;
            public final /* synthetic */ i b;

            public a(i iVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = iVar;
                this.a = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    y28.b bVar = this.b.b.n.b;
                    i iVar = this.b;
                    bVar.a(iVar.b.i, null, this.a, iVar.a.q.getLayoutStrategy());
                }
            }
        }

        public i(mz7 mz7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mz7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.obfuscated_res_0x7f0920b1) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f0920b1)) != null && this.a.c != null && this.b.n != null) {
                ah.a().postDelayed(new a(this, postData), 100L);
                String S = this.b.i.S();
                if ((StringUtils.isNull(S) || "0".equals(this.b.i.S())) && this.b.i.Q() != null) {
                    S = this.b.i.Q().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.b.i.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.M()).param("obj_source", this.b.X(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ mz7 c;

        public a(mz7 mz7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz7Var, pbCommenFloorItemViewHolder, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mz7Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.Y.getVisibility() == 8) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.D(this.a, !z, this.b.G());
                this.b.O0(!z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ String b;

        public b(mz7 mz7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz7Var, pbCommenFloorItemViewHolder, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.f.getMeasuredWidth();
                String str = this.b;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                q18.b(measuredWidth, str, pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.i, pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.N, pbCommenFloorItemViewHolder.M);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ mz7 c;

        public c(mz7 mz7Var, String str, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz7Var, str, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mz7Var;
            this.a = str;
            this.b = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null) {
                    TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.c.b.getPageActivity(), "", this.a, true);
                    tbWebViewActivityConfig.setFixTitle(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                }
                if (this.c.i != null) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.c.i.m());
                    statisticItem.param("fname", this.c.i.n());
                    statisticItem.param("tid", this.c.i.S());
                    statisticItem.param("pid", this.b.M());
                    statisticItem.param("obj_type", this.b.F());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements pg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz7 a;

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        public d(mz7 mz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new ConstrainImageLayout(this.a.mContext);
            }
            return (ConstrainImageLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements pg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz7 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public e(mz7 mz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        public TbImageView h(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbImageView)) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements qy7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz7 a;

        @Override // com.baidu.tieba.qy7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public f(mz7 mz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz7Var;
        }

        @Override // com.baidu.tieba.qy7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.f != null) {
                    if ((view2 instanceof TbListTextView) && this.a.d != null) {
                        this.a.d.onClick(view2);
                        return true;
                    }
                    this.a.f.a(view2);
                    this.a.f.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.qy7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || view2.getId() == R.id.obfuscated_res_0x7f090a2a) {
                    return true;
                }
                if (view2 instanceof RelativeLayout) {
                    this.a.F(view2);
                } else {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (parent instanceof RelativeLayout) {
                            this.a.F((RelativeLayout) parent);
                            break;
                        } else {
                            parent = parent.getParent();
                            i++;
                        }
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public g(mz7 mz7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y.performClick();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ mz7 b;

        public h(mz7 mz7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mz7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.i != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.j0) != null && agreeView.getData() != null) {
                this.a.j0.getImgAgree();
                String S = this.b.i.S();
                if ((StringUtils.isNull(S) || "0".equals(this.b.i.S())) && this.b.i.Q() != null) {
                    S = this.b.i.Q().getNid();
                }
                TiebaStatic.log(new StatisticItem("c14442").param("tid", S).param("fname", this.b.i.n()).param("fid", this.b.i.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.j0.getData().postId));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ mz7 b;

        public j(mz7 mz7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mz7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.i != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.o) != null && agreeView.getData() != null) {
                if (view2 == this.a.o.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String S = this.b.i.S();
                if ((StringUtils.isNull(S) || "0".equals(this.b.i.S())) && this.b.i.Q() != null) {
                    S = this.b.i.Q().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.b.i.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.o.getData().postId).param("obj_source", this.b.X(this.a.o)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ mz7 b;

        public k(mz7 mz7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mz7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.i != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.j0) != null && agreeView.getData() != null) {
                if (view2 == this.a.j0.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String S = this.b.i.S();
                if ((StringUtils.isNull(S) || "0".equals(this.b.i.S())) && this.b.i.Q() != null) {
                    S = this.b.i.Q().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.b.i.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.j0.getData().postId).param("obj_source", this.b.X(this.a.j0)).param("obj_type", i));
                TiebaStatic.log(new StatisticItem("c14440").param("tid", S).param("fname", this.b.i.n()).param("fid", this.b.i.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.j0.getData().postId));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz7 a;

        public l(mz7 mz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz7Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.f != null) {
                    this.a.f.a(view2);
                    return this.a.f.onSingleTapConfirmed(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mz7(Context context, BdUniqueId bdUniqueId, TbPageContext tbPageContext) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = new SparseIntArray();
        this.l = null;
        this.q = new og<>(new d(this), 6, 0);
        this.r = new og<>(new e(this), 12, 0);
        this.s = new qy7(new f(this));
        this.b = tbPageContext;
        this.a = V(R.dimen.tbds14);
    }

    public final void B(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.f);
            pbCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.s.setOnTouchListener(new l(this));
        }
    }

    public int V(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            int i3 = this.k.get(i2, -1);
            if (i3 != -1) {
                return i3;
            }
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i2);
            this.k.put(i2, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return invokeI.intValue;
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.p = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onLongClickListener) == null) {
            this.g = onLongClickListener;
        }
    }

    public void d0(w28 w28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, w28Var) == null) {
            this.m = w28Var;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
            this.d = onClickListener;
        }
    }

    public void e0(y28 y28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, y28Var) == null) {
            this.n = y28Var;
        }
    }

    public void f0(qy7 qy7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, qy7Var) == null) {
            this.f = qy7Var;
        }
    }

    public void g0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, sVar) == null) {
            this.o = sVar;
        }
    }

    public final void i0(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, textView) != null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (!(tag instanceof PostData)) {
            return;
        }
        j0(textView, (PostData) tag);
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onClickListener) == null) {
            this.c = onClickListener;
        }
    }

    public void n(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, yVar) == null) {
            this.e = yVar;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.h = str;
        }
    }

    public void r(ox7 ox7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, ox7Var) == null) {
            this.i = ox7Var;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.j = z;
        }
    }

    public final void H(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && postData != null && (imageView = pbCommenFloorItemViewHolder.O) != null && this.i != null) {
            imageView.setVisibility(8);
        }
    }

    public final void K(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            ImageView imageView = pbCommenFloorItemViewHolder.d0;
            if (postData.b0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void Q(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.c) != null) {
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
        }
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.h(postData.S, postData.M(), false);
        }
    }

    public final void C(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int m = ((((yi.m(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                m = (m - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = V(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().H = (m - i3) - V(R.dimen.tbds122);
            if (UtilHelper.isOppoFoldLargeScreen(TbadkCoreApplication.getInst().getContext())) {
                m /= 2;
            }
            tbRichTextView.getLayoutStrategy().q((int) ((m - i3) * 1.0f));
            tbRichTextView.getLayoutStrategy().p((int) (m * 1.618f * 1.0f));
        }
    }

    public final void D(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.Y.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f05f3);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.a0.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.Y.setVisibility(0);
            pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f0405);
        }
    }

    public final void E(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, postData}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.P) != null && pbCommenFloorItemViewHolder.Z != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.Z.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !ListUtils.isEmpty(postData.b0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.P.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.Z.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(0);
                if (z2) {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().l(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().l(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.Z.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = yi.g(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.P.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().l(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = yi.g(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.P.setLayoutParams(layoutParams);
            }
        }
    }

    public final void P(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048589, this, pbCommenFloorItemViewHolder, postData, view2) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = yi.g(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = yi.g(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.q.setPadding(0, 0, 0, 0);
            pbCommenFloorItemViewHolder.q.k0(null);
            pbCommenFloorItemViewHolder.q.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f08127e);
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().x(R.drawable.pic_video);
            C(pbCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(postData.v()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.q.setIsFromCDN(this.j);
            pbCommenFloorItemViewHolder.q.setText(postData.X(), true, this.o);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.obfuscated_res_0x7f092094, postData);
            sparseArray.put(R.id.obfuscated_res_0x7f0920ad, Boolean.FALSE);
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.obfuscated_res_0x7f0920a7, sparseArray);
            pbCommenFloorItemViewHolder.t0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.k0.setTag(sparseArray);
        }
    }

    public final void F(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).j0) != null && agreeView.getData() != null) {
            pbCommenFloorItemViewHolder.j0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.j0.K();
        }
    }

    public final void G(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, postData) == null) && postData != null) {
            int i2 = 8;
            if (postData.c0) {
                i2 = 2;
            }
            StatisticItem i3 = p48.i(this.i, postData, postData.d0, i2, 6);
            postData.e0 = i3;
            if (!ListUtils.isEmpty(postData.b0())) {
                Iterator<PostData> it = postData.b0().iterator();
                while (it.hasNext()) {
                    it.next().e0 = i3;
                }
            }
        }
    }

    public final String X(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, view2)) == null) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            Object obj = "1";
            if (sparseArray == null) {
                return "1";
            }
            Object obj2 = sparseArray.get(R.id.obfuscated_res_0x7f0918cb);
            if (obj2 != null) {
                obj = obj2;
            }
            sparseArray.remove(R.id.obfuscated_res_0x7f0918cb);
            view2.setTag(sparseArray);
            return obj.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        ox7 ox7Var;
        ox7 ox7Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            String str = null;
            boolean z3 = true;
            if (postData.D() > 0 && (ox7Var2 = this.i) != null && !ox7Var2.l0()) {
                String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f09af), Integer.valueOf(postData.D()));
                pbCommenFloorItemViewHolder.J.setVisibility(0);
                pbCommenFloorItemViewHolder.J.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.J.setVisibility(8);
                z = false;
            }
            if (postData.s() != null) {
                str = postData.s().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z2 = true;
                    n55 T = postData.T();
                    z3 = (T != null || StringUtils.isNull(T.b()) || (ox7Var = this.i) == null || ox7Var.l0()) ? false : false;
                    if (!z) {
                        pbCommenFloorItemViewHolder.l.setVisibility(0);
                        i2 = this.a;
                    } else {
                        pbCommenFloorItemViewHolder.l.setVisibility(8);
                        i2 = 0;
                    }
                    if (z3 && !z2) {
                        pbCommenFloorItemViewHolder.m.setVisibility(8);
                        i3 = 0;
                    } else {
                        pbCommenFloorItemViewHolder.m.setVisibility(0);
                        i3 = this.a;
                    }
                    pbCommenFloorItemViewHolder.k.setPadding(i2, 0, i3, 0);
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.i0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(postData.i0()));
                    } else {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(postData.i0()));
                    }
                    if (!z2) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds14), 0, 0, 0);
                        pbCommenFloorItemViewHolder.n.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1549) + str);
                    } else if (z3) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setPadding(this.a, 0, 0, 0);
                        if (postData.b0) {
                            pbCommenFloorItemViewHolder.n.setText(StringHelper.cutStringWithSuffix(T.b(), 7, StringHelper.STRING_MORE));
                        } else {
                            pbCommenFloorItemViewHolder.n.setText(T.b());
                        }
                    } else {
                        pbCommenFloorItemViewHolder.n.setVisibility(8);
                    }
                    TextView textView = pbCommenFloorItemViewHolder.m0;
                    textView.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
                }
            }
            z2 = false;
            n55 T2 = postData.T();
            if (T2 != null) {
            }
            if (!z) {
            }
            if (z3) {
            }
            pbCommenFloorItemViewHolder.m.setVisibility(0);
            i3 = this.a;
            pbCommenFloorItemViewHolder.k.setPadding(i2, 0, i3, 0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.i0()), "yyyy"))) {
            }
            if (!z2) {
            }
            TextView textView2 = pbCommenFloorItemViewHolder.m0;
            textView2.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
        }
    }

    public final void j0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            if (postData.s() != null) {
                MetaData s = postData.s();
                String str = this.h;
                if (str != null && !str.equals("0") && this.h.equals(s.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.obfuscated_res_0x7f0f0894);
                    textView.setBackgroundColor(0);
                    pw4 d2 = pw4.d(textView);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.v(R.color.CAM_X0302);
                    d2.k(R.color.CAM_X0302);
                    return;
                } else if (s.getIs_bawu() == 1 && postData.s0()) {
                    pw4 d3 = pw4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0347);
                    return;
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    pw4 d4 = pw4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0300);
                    return;
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    pw4 d5 = pw4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0301);
                    return;
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    pw4 d6 = pw4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02fd);
                    return;
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    pw4 d7 = pw4.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02fe);
                    return;
                } else {
                    textView.setVisibility(8);
                    return;
                }
            }
            textView.setVisibility(8);
        }
    }

    public final void L(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048585, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.l0.setVisibility(8);
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.o.setVisibility(8);
            pbCommenFloorItemViewHolder.t0.setVisibility(8);
            U(pbCommenFloorItemViewHolder, postData, view2, i2);
            H(pbCommenFloorItemViewHolder, postData);
            M(pbCommenFloorItemViewHolder, postData);
            P(pbCommenFloorItemViewHolder, postData, view2);
            O(pbCommenFloorItemViewHolder, postData, view2, i2);
            I(pbCommenFloorItemViewHolder, postData);
            R(pbCommenFloorItemViewHolder, postData);
            N(pbCommenFloorItemViewHolder, postData);
            S(pbCommenFloorItemViewHolder, postData);
            cz7.c(pbCommenFloorItemViewHolder, postData, view2, this.s);
            K(pbCommenFloorItemViewHolder, postData);
            Q(pbCommenFloorItemViewHolder, postData);
            T(pbCommenFloorItemViewHolder, postData);
            cz7.i(pbCommenFloorItemViewHolder, view2, postData, this.p, true);
        }
    }

    public final void M(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && postData != null && postData.q() != null) {
            postData.q().objType = 1;
            postData.q().isInPost = true;
            ThreadData threadData = null;
            ox7 ox7Var = this.i;
            if (ox7Var != null && ox7Var.Q() != null) {
                threadData = this.i.Q();
                postData.q().threadId = threadData.getTid();
                postData.q().forumId = String.valueOf(threadData.getFid());
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.o.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.o.setThreadData(threadData);
            pbCommenFloorItemViewHolder.o.setData(postData.q());
            pbCommenFloorItemViewHolder.j0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.j0.setData(postData.q());
        }
    }

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.s() != null && postData.e0() != null) {
                TbRichText X = postData.X();
                if (X != null && StringUtils.isNull(X.toString()) && StringUtils.isNull(postData.v())) {
                    z = true;
                } else {
                    z = false;
                }
                if (postData.s().getSmallTailThemeData() != null) {
                    str = postData.s().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.Q.setTag(R.id.obfuscated_res_0x7f0920c4, str);
                pbCommenFloorItemViewHolder.R.setTag(R.id.obfuscated_res_0x7f0920c4, str);
                w58.c(postData.e0(), pbCommenFloorItemViewHolder.Q, pbCommenFloorItemViewHolder.R, pbCommenFloorItemViewHolder.S, false, false, z, postData.s().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.Q.setVisibility(8);
            pbCommenFloorItemViewHolder.R.setVisibility(8);
        }
    }

    public final void N(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.W != null && pbCommenFloorItemViewHolder.T != null) {
            if (postData != null && (alaLiveInfoCoreData = postData.T) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.W.setText(postData.T.liveTitle);
                pbCommenFloorItemViewHolder.T.setTag(postData.T);
                pbCommenFloorItemViewHolder.T.setVisibility(0);
                StatisticItem statisticItem = new StatisticItem("c12639");
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            pbCommenFloorItemViewHolder.T.setVisibility(8);
        }
    }

    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData.H() != 2 && postData.H() != 4) {
                pbCommenFloorItemViewHolder.Z.setVisibility(8);
                pbCommenFloorItemViewHolder.Y.setVisibility(0);
                E(false, pbCommenFloorItemViewHolder, postData);
                return;
            }
            pbCommenFloorItemViewHolder.Z.setOnClickListener(new a(this, pbCommenFloorItemViewHolder, postData));
            pbCommenFloorItemViewHolder.Z.setVisibility(0);
            D(pbCommenFloorItemViewHolder, postData.u0(), postData.G());
            E(true, pbCommenFloorItemViewHolder, postData);
        }
    }

    public final void O(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048588, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.d0() > 0) {
                pbCommenFloorItemViewHolder.x.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.x.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.x.setTag(sparseArray);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f0920b1, postData);
                if (postData.H() == 2) {
                    pbCommenFloorItemViewHolder.x.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.x.setVisibility(0);
                }
                pbCommenFloorItemViewHolder.w.setVisibility(8);
            }
            ImageView imageView = pbCommenFloorItemViewHolder.y;
            if (imageView != null) {
                SparseArray sparseArray2 = (SparseArray) imageView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.y.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.obfuscated_res_0x7f0920b1, postData);
            }
            if (this.i != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.i.m());
                statisticItem.param("fname", this.i.n());
                statisticItem.param("tid", this.i.S());
                statisticItem.param("pid", postData.M());
                TiebaStatic.log(statisticItem);
            }
            if (pbCommenFloorItemViewHolder.b0 != null) {
                PbFloorComplaint pbFloorComplaint = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f091845);
                pbCommenFloorItemViewHolder.b0 = pbFloorComplaint;
                pbCommenFloorItemViewHolder.c0 = Boolean.TRUE;
                pbFloorComplaint.setRemindText(postData.F());
                pbCommenFloorItemViewHolder.b0.setRemindIcon(postData.F());
                if (postData.F() == 0) {
                    pbCommenFloorItemViewHolder.b0.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.b0.setVisibility(0);
                    if (this.i != null) {
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT_SHOW);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.i.m());
                        statisticItem2.param("fname", this.i.n());
                        statisticItem2.param("tid", this.i.S());
                        statisticItem2.param("pid", postData.M());
                        statisticItem2.param("obj_type", postData.F());
                        TiebaStatic.log(statisticItem2);
                    }
                }
                pbCommenFloorItemViewHolder.b0.setAmendIconListener(new c(this, postData.E(), postData));
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.z;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.obfuscated_res_0x7f0920b1, postData);
            }
            pbCommenFloorItemViewHolder.w.setVisibility(8);
            if (!postData.r0() && !postData.q0(false)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.v.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams2.topMargin = yi.g(this.mContext, R.dimen.tbds10);
                layoutParams2.leftMargin = yi.g(this.mContext, R.dimen.tbds148);
                layoutParams2.rightMargin = yi.g(this.mContext, R.dimen.M_W_X007);
                layoutParams2.bottomMargin = yi.g(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams2);
                if (this.l == null) {
                    y38 y38Var = new y38(this.mContext);
                    this.l = y38Var;
                    y38Var.f(this.j);
                    this.l.h(this.c);
                    this.l.e(this.d);
                    String str = null;
                    ox7 ox7Var = this.i;
                    if (ox7Var != null && ox7Var.Q() != null && this.i.Q().getAuthor() != null) {
                        str = this.i.Q().getAuthor().getUserId();
                    }
                    boolean z = true;
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    ox7 ox7Var2 = this.i;
                    if (ox7Var2 != null) {
                        this.l.j(ox7Var2.Y(), z);
                        this.l.i(this.i.Q());
                    }
                }
                this.l.g(postData.M());
                pbCommenFloorItemViewHolder.v.setSubPbAdapter(this.l);
                pbCommenFloorItemViewHolder.v.setVisibility(0);
                pbCommenFloorItemViewHolder.v.setData(postData, view2);
                pbCommenFloorItemViewHolder.v.setChildOnClickListener(this.d);
                pbCommenFloorItemViewHolder.v.setChildOnLongClickListener(this.g);
                pbCommenFloorItemViewHolder.v.setChildOnTouchListener(this.s);
            }
            if (postData.P) {
                pbCommenFloorItemViewHolder.P.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.P.setVisibility(4);
            }
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.u.getLayoutParams();
            layoutParams3.topMargin = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
            layoutParams3.bottomMargin = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
            if (pbCommenFloorItemViewHolder.w.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.u.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.u.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.n0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1031));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:231:0x066c  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0680  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x06cd  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0733  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x073d  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x077c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i3;
        int i4;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048594, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.s() != null) {
                postData.s().isBaijiahaoUser();
            }
            int i5 = 0;
            if (postData.R) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.e.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.e.setVisibility(8);
            }
            ThreadData threadData = null;
            pbCommenFloorItemViewHolder.p.setTag(null);
            pbCommenFloorItemViewHolder.p.setUserId(null);
            pbCommenFloorItemViewHolder.g.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.L.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.q.setIsHost(false);
            String str5 = "";
            if (postData.s() != null) {
                String str6 = this.h;
                if (str6 != null && !str6.equals("0") && this.h.equals(postData.s().getUserId())) {
                    pbCommenFloorItemViewHolder.q.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.s().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.s().getTShowInfoNew();
                UserIconBox userIconBox = pbCommenFloorItemViewHolder.N;
                if (userIconBox != null) {
                    userIconBox.setTag(R.id.obfuscated_res_0x7f0920ea, postData.s().getUserId());
                    w28 w28Var = this.m;
                    if (w28Var != null) {
                        pbCommenFloorItemViewHolder.N.setOnClickListener(w28Var.c);
                    }
                    int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.N;
                    i3 = R.id.obfuscated_res_0x7f0920ea;
                    userIconBox2.g(iconInfo, 2, g2, g2, g3);
                } else {
                    i3 = R.id.obfuscated_res_0x7f0920ea;
                }
                if (pbCommenFloorItemViewHolder.M != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.M.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    w28 w28Var2 = this.m;
                    if (w28Var2 != null) {
                        pbCommenFloorItemViewHolder.M.setOnClickListener(w28Var2.e);
                    }
                    int g4 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.M.h(tShowInfoNew, 3, g4, g4, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                    if (UbsABTestHelper.isPBPlanA()) {
                        if (DeviceInfoUtil.isMate30()) {
                            q18.F(pbCommenFloorItemViewHolder.g);
                        } else {
                            pw4.d(pbCommenFloorItemViewHolder.g).A(R.string.F_X02);
                        }
                        SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
                    } else {
                        SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0107, 1);
                    }
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
                }
                String avater = postData.s().getAvater();
                if (postData.c0) {
                    i4 = 2;
                } else {
                    i4 = 8;
                }
                pbCommenFloorItemViewHolder.g.setTag(i3, postData.s().getUserId());
                pbCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f0920f2, postData.s().getUserName());
                pbCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f0920f4, postData.s().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f0920e0, p48.i(this.i, postData, postData.d0, i4, 2));
                String name_show = postData.s().getName_show();
                String userName = postData.s().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.g.setText(ow7.b(this.mContext, pbCommenFloorItemViewHolder.g.getText().toString()));
                    pbCommenFloorItemViewHolder.g.setGravity(16);
                    pbCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f0920be, ow7.a());
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
                }
                if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.L.setBigVDimenSize(R.dimen.tbds36);
                    pbCommenFloorItemViewHolder.L.j(postData.s(), 4);
                    pbCommenFloorItemViewHolder.p.setVisibility(8);
                    pbCommenFloorItemViewHolder.L.setVisibility(0);
                    pbCommenFloorItemViewHolder.L.getHeadView().K(avater, 28, false);
                    pbCommenFloorItemViewHolder.L.getHeadView().setUserId(postData.s().getUserId());
                    pbCommenFloorItemViewHolder.L.getHeadView().setUserName(postData.s().getUserName());
                    ox7 ox7Var = this.i;
                    if (ox7Var == null) {
                        str3 = "";
                    } else {
                        str3 = ox7Var.m();
                    }
                    pbCommenFloorItemViewHolder.L.getHeadView().setFid(str3);
                    ox7 ox7Var2 = this.i;
                    if (ox7Var2 == null) {
                        str4 = "";
                    } else {
                        str4 = ox7Var2.n();
                    }
                    pbCommenFloorItemViewHolder.L.getHeadView().setFName(str4);
                    pbCommenFloorItemViewHolder.L.getHeadView().setFloor(postData.D());
                    pbCommenFloorItemViewHolder.L.getHeadView().setTid(postData.M());
                    pbCommenFloorItemViewHolder.L.getHeadView().setTag(R.id.obfuscated_res_0x7f0920e0, p48.i(this.i, postData, postData.d0, i4, 2));
                    pbCommenFloorItemViewHolder.L.i(postData.s());
                } else {
                    pbCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.p, postData.s(), 4);
                    pbCommenFloorItemViewHolder.p.setUserId(postData.s().getUserId());
                    ox7 ox7Var3 = this.i;
                    if (ox7Var3 == null) {
                        str = "";
                    } else {
                        str = ox7Var3.m();
                    }
                    pbCommenFloorItemViewHolder.p.setFid(str);
                    ox7 ox7Var4 = this.i;
                    if (ox7Var4 == null) {
                        str2 = "";
                    } else {
                        str2 = ox7Var4.n();
                    }
                    pbCommenFloorItemViewHolder.p.setFName(str2);
                    pbCommenFloorItemViewHolder.p.setFloor(postData.D());
                    pbCommenFloorItemViewHolder.p.setTid(postData.M());
                    pbCommenFloorItemViewHolder.p.setUserName(postData.s().getUserName(), postData.k0());
                    pbCommenFloorItemViewHolder.p.setTag(R.id.obfuscated_res_0x7f0920f4, postData.s().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.p.setTag(R.id.obfuscated_res_0x7f0920e0, p48.i(this.i, postData, postData.d0, i4, 2));
                    pbCommenFloorItemViewHolder.p.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.p.K(avater, 28, false);
                    pbCommenFloorItemViewHolder.p.setVisibility(0);
                    pbCommenFloorItemViewHolder.L.setVisibility(8);
                }
                if (postData.s() != null && postData.s().getAlaInfo() != null && postData.s().getAlaUserData() != null && postData.s().getAlaUserData().live_status == 1) {
                    pbCommenFloorItemViewHolder.d(true);
                    pbCommenFloorItemViewHolder.p.setLiveStatus(1);
                    pbCommenFloorItemViewHolder.p.setAlaInfo(postData.s().getAlaInfo());
                    pbCommenFloorItemViewHolder.L.getHeadView().setLiveStatus(1);
                    pbCommenFloorItemViewHolder.L.getHeadView().setAlaInfo(postData.s().getAlaInfo());
                    threadData = null;
                } else {
                    pbCommenFloorItemViewHolder.d(false);
                    pbCommenFloorItemViewHolder.p.setLiveStatus(0);
                    threadData = null;
                    pbCommenFloorItemViewHolder.p.setAlaInfo(null);
                    pbCommenFloorItemViewHolder.L.getHeadView().setLiveStatus(0);
                    pbCommenFloorItemViewHolder.L.getHeadView().setAlaInfo(null);
                }
                j0(pbCommenFloorItemViewHolder.i, postData);
            }
            int level_id = postData.s().getLevel_id();
            ox7 ox7Var5 = this.i;
            if (ox7Var5 != null && ox7Var5.l0()) {
                level_id = 0;
            }
            if (level_id > 0) {
                pbCommenFloorItemViewHolder.K.setVisibility(0);
                SkinManager.setImageResource(pbCommenFloorItemViewHolder.K, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
            } else {
                pbCommenFloorItemViewHolder.K.setVisibility(8);
            }
            int i6 = 15;
            if (pbCommenFloorItemViewHolder.N.getChildCount() == 1) {
                i6 = 13;
            } else if (pbCommenFloorItemViewHolder.N.getChildCount() > 1) {
                i6 = 11;
            }
            if (pbCommenFloorItemViewHolder.i.getVisibility() == 0) {
                i6 -= 2;
            }
            if (pbCommenFloorItemViewHolder.M.getChildCount() > 0) {
                i6 -= 2;
            }
            if (postData.y() > 1000) {
                i6 -= 2;
            }
            if (postData.y() > 10) {
                i6 -= 2;
            }
            if (i6 < 10) {
                pbCommenFloorItemViewHolder.N.setVisibility(8);
                if (pbCommenFloorItemViewHolder.N.getChildCount() == 1) {
                    i6 += 2;
                } else if (pbCommenFloorItemViewHolder.N.getChildCount() > 1) {
                    i6 += 4;
                }
                if (i6 < 10 && pbCommenFloorItemViewHolder.i.getVisibility() == 0) {
                    i6 += 2;
                    pbCommenFloorItemViewHolder.i.setVisibility(8);
                }
                if (i6 < 10 && pbCommenFloorItemViewHolder.K.getVisibility() == 0) {
                    pbCommenFloorItemViewHolder.K.setVisibility(8);
                }
            }
            int m = q18.m();
            if (postData.s() != null) {
                str5 = postData.s().getName_show();
            }
            int d2 = tj5.d(str5);
            if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
                int i7 = m - 2;
                if (d2 > i7) {
                    str5 = tj5.l(str5, i7) + StringHelper.STRING_MORE;
                }
            } else if (d2 > m) {
                str5 = tj5.l(str5, m) + StringHelper.STRING_MORE;
            }
            if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
                pbCommenFloorItemViewHolder.g.setText(W(postData.s().getSealPrefix(), str5));
            } else {
                pbCommenFloorItemViewHolder.g.setText(str5);
                pbCommenFloorItemViewHolder.f.post(new b(this, pbCommenFloorItemViewHolder, str5));
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f092094, postData);
            sparseArray.put(R.id.obfuscated_res_0x7f0920b1, postData);
            sparseArray.put(R.id.obfuscated_res_0x7f0920b3, view2);
            sparseArray.put(R.id.obfuscated_res_0x7f0920c2, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f0920c1, Integer.valueOf(postData.D()));
            sparseArray.put(R.id.obfuscated_res_0x7f0920a4, postData.M());
            sparseArray.put(R.id.obfuscated_res_0x7f091829, pbCommenFloorItemViewHolder.o);
            sparseArray.put(R.id.obfuscated_res_0x7f09182a, pbCommenFloorItemViewHolder.j0);
            sparseArray.put(R.id.obfuscated_res_0x7f091827, pbCommenFloorItemViewHolder.y);
            sparseArray.put(R.id.obfuscated_res_0x7f091828, pbCommenFloorItemViewHolder.z);
            ox7 ox7Var6 = this.i;
            if (ox7Var6 != null && ox7Var6.Q() != null) {
                threadData = this.i.Q();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                sparseArray.put(R.id.obfuscated_res_0x7f091826, Boolean.TRUE);
            } else {
                sparseArray.put(R.id.obfuscated_res_0x7f091826, Boolean.FALSE);
            }
            if (postData.s() != null && !StringUtils.isNull(postData.s().getVirtualUserUrl())) {
                z = true;
            } else {
                z = false;
            }
            ox7 ox7Var7 = this.i;
            if (ox7Var7 != null && ox7Var7.Y() != 0 && !Y()) {
                if (this.i.Y() != 1002 && this.i.Y() != 3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.i.Y() != 3 && !this.i.l0()) {
                    z3 = true;
                    z4 = true;
                } else {
                    z3 = false;
                    z4 = false;
                }
                if (postData != null && postData.s() != null) {
                    String userId = postData.s().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z2 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z2 = false;
                    }
                }
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
            }
            ox7 ox7Var8 = this.i;
            if (ox7Var8 != null && ox7Var8.Q() != null && this.i.Q().getAuthor() != null && postData.s() != null) {
                String userId2 = this.i.Q().getAuthor().getUserId();
                String userId3 = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z5 = false;
                        z3 = true;
                        z6 = true;
                    } else {
                        z5 = true;
                        z3 = true;
                        z6 = false;
                    }
                    z7 = true;
                    if (postData != null && postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                        z3 = true;
                        z6 = true;
                    }
                    if (z) {
                        z2 = false;
                        z5 = false;
                        z3 = false;
                    }
                    if (postData.D() != 1) {
                        i5 = 1;
                    }
                    if (!z2) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920dd, Boolean.TRUE);
                        sparseArray.put(R.id.obfuscated_res_0x7f0920b4, Integer.valueOf(this.i.Y()));
                        if (postData.s() != null) {
                            sparseArray.put(R.id.obfuscated_res_0x7f0920a1, postData.s().getUserName());
                            sparseArray.put(R.id.obfuscated_res_0x7f0920a2, postData.s().getName_show());
                            sparseArray.put(R.id.obfuscated_res_0x7f0920a3, postData.s().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920dd, Boolean.FALSE);
                    }
                    if (!z5) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920f1, Boolean.TRUE);
                        sparseArray.put(R.id.obfuscated_res_0x7f0920ab, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.s() != null) {
                            sparseArray.put(R.id.obfuscated_res_0x7f0920ed, postData.s().getUserId());
                            sparseArray.put(R.id.obfuscated_res_0x7f0920ee, postData.s().getUserName());
                            sparseArray.put(R.id.obfuscated_res_0x7f0920ec, postData.s().getName_show());
                        }
                        if (this.i.Q() != null) {
                            sparseArray.put(R.id.obfuscated_res_0x7f0920f0, this.i.Q().getId());
                        }
                        sparseArray.put(R.id.obfuscated_res_0x7f0920ef, postData.M());
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920f1, Boolean.FALSE);
                    }
                    if (!z3) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920db, Boolean.TRUE);
                        sparseArray.put(R.id.obfuscated_res_0x7f0920a8, Boolean.valueOf(postData.r0()));
                        sparseArray.put(R.id.obfuscated_res_0x7f0920b4, Integer.valueOf(this.i.Y()));
                        sparseArray.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z6));
                        sparseArray.put(R.id.obfuscated_res_0x7f092098, Integer.valueOf(i5));
                        sparseArray.put(R.id.obfuscated_res_0x7f092096, postData.M());
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920db, Boolean.FALSE);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f0920b5, Boolean.valueOf(z4));
                    sparseArray.put(R.id.obfuscated_res_0x7f0920ac, Boolean.valueOf(z7));
                    pbCommenFloorItemViewHolder.q.setTag(sparseArray);
                    pbCommenFloorItemViewHolder.s.setTag(sparseArray);
                }
            }
            z5 = false;
            z6 = false;
            z7 = false;
            if (postData != null) {
                z3 = true;
                z6 = true;
            }
            if (z) {
            }
            if (postData.D() != 1) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (!z3) {
            }
            sparseArray.put(R.id.obfuscated_res_0x7f0920b5, Boolean.valueOf(z4));
            sparseArray.put(R.id.obfuscated_res_0x7f0920ac, Boolean.valueOf(z7));
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
        }
    }

    public final SpannableStringBuilder W(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null) {
                return spannableStringBuilder;
            }
            if (str != null) {
                arrayList.add(new w36.a(str, R.drawable.pic_smalldot_title));
                return w36.h(this.mContext, str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            ox7 ox7Var = this.i;
            if (ox7Var != null && ox7Var.Q() != null) {
                return this.i.Q().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: Z */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06fc, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f0918ab)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06f4, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.b, inflate, 0);
            pbCommenFloorItemViewHolder.t.setConstrainLayoutPool(this.q);
            pbCommenFloorItemViewHolder.t.setImageViewPool(this.r);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.v;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(true);
                pbCommenFloorItemViewHolder.v.setIsVideoThread(false);
            }
            h0(pbCommenFloorItemViewHolder);
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View a0(int i2, View view2, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            h0(pbCommenFloorItemViewHolder);
            b0(pbCommenFloorItemViewHolder);
            B(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) getItem(i2);
            if (postData2 != null) {
                postData2.d0 = i2 + 1;
                postData2.l1();
                G(postData2);
                L(pbCommenFloorItemViewHolder, postData2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.s);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.g);
            pbCommenFloorItemViewHolder.g.setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.p.setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.L.setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.L.getHeadView().setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.q.setOnLongClickListener(this.g);
            pbCommenFloorItemViewHolder.q.setOnTouchListener(this.s);
            pbCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(this.d);
            pbCommenFloorItemViewHolder.q.setOnImageClickListener(this.e);
            pbCommenFloorItemViewHolder.q.setOnImageTouchListener(this.s);
            pbCommenFloorItemViewHolder.q.setOnEmotionClickListener(this.m.f);
            pbCommenFloorItemViewHolder.q.setOnVoiceAfterClickListener(this.d);
            pbCommenFloorItemViewHolder.Q.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.R.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.T.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.w.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.x.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.s0.setOnTouchListener(this.s);
            pbCommenFloorItemViewHolder.s0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.o0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.k0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.t0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.l0.setOnClickListener(new g(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.c.setOnClickListener(new h(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.y.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.z.setOnClickListener(new i(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.o.A = new j(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.j0.A = new k(this, pbCommenFloorItemViewHolder);
        }
    }

    public final void h0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            i0(pbCommenFloorItemViewHolder.i);
            boolean z = true;
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    q18.F(pbCommenFloorItemViewHolder.g);
                } else {
                    pw4.d(pbCommenFloorItemViewHolder.g).A(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.J, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.n, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbCommenFloorItemViewHolder.s.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.s.g(skinType);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.n0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.v, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f0809c7, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f0809c8, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.v.d();
            pbCommenFloorItemViewHolder.t.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.W, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.U, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.T, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.V, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.X, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.a0, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.Y.getVisibility() != 8) {
                z = false;
            }
            if (z) {
                pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f0405);
            } else {
                ox7 ox7Var = this.i;
                if (ox7Var != null && StringUtils.isNull(ox7Var.k())) {
                    pbCommenFloorItemViewHolder.a0.setText(this.i.k());
                } else {
                    pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f05f3);
                }
            }
            pbCommenFloorItemViewHolder.o.M(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.c(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.k0, R.drawable.obfuscated_res_0x7f0809a2, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.t0, R.drawable.obfuscated_res_0x7f0809a2, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.b();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.kn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        a0(i2, view2, viewGroup, postData, pbCommenFloorItemViewHolder);
        return view2;
    }
}
