package com.baidu.tieba;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsMoreFeedForumsConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.s45;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class ym7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<FrsFragment> a;
    public LinearLayout b;
    public View c;
    public TextView d;
    public ImageView e;
    public TextView f;
    public View g;
    public View h;
    public List<zm7> i;
    public List<FeedForumData> j;
    public LikeModel k;
    public Handler l;
    public int m;
    public String n;
    public boolean o;
    public boolean p;
    public View.OnClickListener q;
    public h9 r;

    /* loaded from: classes8.dex */
    public class d extends h9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ym7 a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LikeReturnData a;
            public final /* synthetic */ d b;

            public a(d dVar, LikeReturnData likeReturnData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, likeReturnData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = likeReturnData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Iterator it = this.b.a.j.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        FeedForumData feedForumData = (FeedForumData) it.next();
                        if (feedForumData.getForumId().equals(this.a.getFid())) {
                            this.b.a.j.remove(feedForumData);
                            break;
                        }
                    }
                    if (this.b.a.j.size() <= 0) {
                        this.b.a.m();
                    } else {
                        this.b.a.p();
                    }
                }
            }
        }

        public d(ym7 ym7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ym7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ym7Var;
        }

        @Override // com.baidu.tieba.h9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.a.k.getErrorCode(), this.a.k.getErrorString())) {
                    AntiHelper.u(this.a.a.getPageActivity(), this.a.k.getErrorString());
                } else if (obj != null) {
                    LikeReturnData likeReturnData = (LikeReturnData) obj;
                    if (ListUtils.getCount(this.a.j) > 0 && likeReturnData != null) {
                        Iterator it = this.a.i.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            zm7 zm7Var = (zm7) it.next();
                            FeedForumData feedForumData = (FeedForumData) zm7Var.f.getTag();
                            if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(likeReturnData.getFid())) {
                                feedForumData.setIsLike(1);
                                this.a.l(zm7Var);
                                break;
                            }
                        }
                        if (this.a.m == 1) {
                            this.a.l.postDelayed(new a(this, likeReturnData), 1000L);
                        }
                    }
                } else if (!StringUtils.isNull(this.a.k.getErrorString())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), this.a.k.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ym7 a;

        public a(ym7 ym7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ym7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ym7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            FeedForumData feedForumData;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090c8f) {
                    if (ViewHelper.checkUpIsLogin(this.a.a.getPageActivity()) && (feedForumData = (FeedForumData) view2.getTag()) != null) {
                        this.a.k.f0(feedForumData.getForumName(), feedForumData.getForumId());
                        if (this.a.m == 1) {
                            str3 = "c10028";
                        } else {
                            str3 = "c10040";
                        }
                        TiebaStatic.log(new StatisticItem(str3).param("fid", feedForumData.getForumId()));
                    }
                } else if (view2.getId() != R.id.obfuscated_res_0x7f091527) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f090d00) {
                        FeedForumData feedForumData2 = (FeedForumData) view2.getTag();
                        if (feedForumData2 != null) {
                            if (this.a.m == 1) {
                                str = FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND;
                            } else {
                                str = "";
                            }
                            this.a.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.a.getPageActivity()).createNormalCfg(feedForumData2.getForumName(), str)));
                            if (this.a.m == 2) {
                                str2 = "c10042";
                            } else {
                                str2 = "c10030";
                            }
                            TiebaStatic.log(new StatisticItem(str2).param("fid", feedForumData2.getForumId()));
                        }
                    } else if (view2.getId() == this.a.f.getId() && ListUtils.getCount(this.a.j) > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(this.a.a.getPageActivity(), (Serializable) this.a.j)));
                        TiebaStatic.log(new StatisticItem("c10046").param("fid", this.a.n));
                    }
                } else {
                    this.a.s();
                    TiebaStatic.log(new StatisticItem("c10029").param("fid", this.a.n));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ym7 a;

        public b(ym7 ym7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ym7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ym7Var;
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                if (this.a.j != null) {
                    this.a.j.clear();
                }
                this.a.m();
                s45Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(ym7 ym7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ym7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                s45Var.dismiss();
            }
        }
    }

    public ym7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new ArrayList();
        this.l = new Handler();
        this.m = 1;
        this.n = "";
        this.o = false;
        this.q = new a(this);
        this.r = new d(this);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            s45 s45Var = new s45(this.a.getPageActivity());
            s45Var.setMessage(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0e97));
            s45Var.setPositiveButton(R.string.alert_yes_button, new b(this));
            s45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03cf, new c(this));
            s45Var.create(this.a).show();
        }
    }

    public ym7(TbPageContext tbPageContext, View view2, int i, boolean z, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, Integer.valueOf(i), Boolean.valueOf(z), bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = new ArrayList();
        this.l = new Handler();
        this.m = 1;
        this.n = "";
        this.o = false;
        this.q = new a(this);
        this.r = new d(this);
        n(tbPageContext, view2, i, z, bdUniqueId);
    }

    public final void l(zm7 zm7Var) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zm7Var) == null) && zm7Var != null && (entelechyUserLikeButton = zm7Var.f) != null) {
            entelechyUserLikeButton.h(true);
            zm7Var.f.setEnabled(false);
        }
    }

    public final String k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i < 0) {
                return "0";
            }
            if (i < 10000) {
                return String.valueOf(i);
            }
            if (i == 10000) {
                return "1W";
            }
            float f = i / 10000.0f;
            if (f <= 9999.9f) {
                return String.format("%.1fW", Float.valueOf(f));
            }
            return "9999.9+W";
        }
        return (String) invokeI.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.setVisibility(8);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.setVisibility(0);
        }
    }

    public void n(TbPageContext tbPageContext, View view2, int i, boolean z, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbPageContext, view2, Integer.valueOf(i), Boolean.valueOf(z), bdUniqueId}) == null) {
            this.a = tbPageContext;
            this.b = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090cd1);
            this.c = view2.findViewById(R.id.obfuscated_res_0x7f090cd2);
            this.g = view2.findViewById(R.id.obfuscated_res_0x7f0914b5);
            this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091528);
            ImageView imageView = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091527);
            this.e = imageView;
            imageView.setOnClickListener(this.q);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090b0b);
            this.h = view2.findViewById(R.id.obfuscated_res_0x7f090b0a);
            this.f.setOnClickListener(this.q);
            LikeModel likeModel = new LikeModel(tbPageContext);
            this.k = likeModel;
            likeModel.setUniqueId(bdUniqueId);
            this.k.setLoadDataCallBack(this.r);
            this.m = i;
            this.p = z;
        }
    }

    public void o(String str, List<FeedForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            this.n = str;
            this.j = list;
            p();
            if (this.m == 2 && !this.o) {
                TiebaStatic.log(new StatisticItem("c10035").param("fid", this.n));
                this.o = true;
            }
        }
    }

    public final void p() {
        int size;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (ListUtils.getCount(this.j) == 0) {
                m();
                return;
            }
            r();
            if (this.j.size() > 2) {
                size = 2;
            } else {
                size = this.j.size();
            }
            int size2 = size - this.i.size();
            if (size2 > 0) {
                for (int i2 = 0; i2 < size2; i2++) {
                    if (this.m == 1) {
                        i = R.layout.obfuscated_res_0x7f0d036f;
                    } else {
                        i = R.layout.obfuscated_res_0x7f0d0357;
                    }
                    View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(i, (ViewGroup) null);
                    this.b.addView(inflate);
                    this.i.add(new zm7(inflate));
                }
            } else if (size2 < 0) {
                for (int i3 = 0; i3 < (-size2); i3++) {
                    int size3 = this.i.size() - 1;
                    this.b.removeView(this.i.get(size3).a);
                    this.i.remove(size3);
                }
            }
            for (int i4 = 0; i4 < size; i4++) {
                FeedForumData feedForumData = this.j.get(i4);
                zm7 zm7Var = this.i.get(i4);
                if (feedForumData != null && zm7Var != null) {
                    zm7Var.a.setTag(feedForumData);
                    zm7Var.a.setOnClickListener(this.q);
                    zm7Var.b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                    zm7Var.b.setPlaceHolder(1);
                    zm7Var.b.startLoad(feedForumData.getAvatar(), 15, false);
                    zm7Var.c.setText(feedForumData.getForumName());
                    zm7Var.d.setText(String.format(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f02f6), k(feedForumData.getMemberCount()), k(feedForumData.getPostNum())));
                    zm7Var.e.setText(feedForumData.getReason());
                    if (feedForumData.getIsLike() == 0) {
                        zm7Var.f.setClickable(true);
                        zm7Var.f.setOnClickListener(this.q);
                        zm7Var.f.setTag(feedForumData);
                        zm7Var.f.h(false);
                        zm7Var.f.setEnabled(true);
                    } else {
                        l(zm7Var);
                    }
                }
            }
            if (this.p) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
            }
            q();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0108, 1);
            SkinManager.setImageResource(this.e, R.drawable.icon_frs_recommend_arrow_down);
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0110, 1);
            for (zm7 zm7Var : this.i) {
                SkinManager.setBackgroundResource(zm7Var.a, R.drawable.frs_like_feed_forum_item_bg);
                SkinManager.setViewTextColor(zm7Var.c, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(zm7Var.d, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(zm7Var.e, R.color.CAM_X0305, 1);
                EntelechyUserLikeButton entelechyUserLikeButton = zm7Var.f;
                entelechyUserLikeButton.h(!entelechyUserLikeButton.isEnabled());
            }
        }
    }
}
