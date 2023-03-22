package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.mj8;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class lq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseVideoPBReplyFragment a;
    public AbsVideoPbFragment b;
    public int c;
    public boolean d;
    public final TbRichTextView.a0 e;
    public mj8 f;

    /* loaded from: classes5.dex */
    public class a implements TbRichTextView.a0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lq8 a;

        public a(lq8 lq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lq8Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v31, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:38:0x01bc A[Catch: Exception -> 0x04b3, TryCatch #0 {Exception -> 0x04b3, blocks: (B:5:0x0014, B:9:0x004a, B:11:0x005a, B:12:0x00af, B:15:0x00e9, B:17:0x00fc, B:19:0x0108, B:21:0x0112, B:22:0x011c, B:24:0x0122, B:26:0x0128, B:29:0x0139, B:32:0x014a, B:33:0x0180, B:36:0x0187, B:38:0x01bc, B:40:0x01e8, B:41:0x01fb, B:43:0x022d, B:45:0x0231, B:47:0x024a, B:48:0x0259, B:50:0x02af, B:52:0x02db, B:53:0x02ee, B:54:0x0321, B:57:0x032a, B:59:0x0332, B:62:0x0344, B:63:0x035e, B:65:0x0366, B:67:0x0374, B:68:0x037a, B:69:0x037d, B:71:0x0387, B:73:0x0391, B:75:0x039b, B:76:0x039f, B:78:0x03a5, B:80:0x03af, B:82:0x03c2, B:83:0x03da, B:85:0x03e5, B:86:0x03f4, B:88:0x0441, B:90:0x046d, B:91:0x0480), top: B:100:0x0014 }] */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.a0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            mq8 E1;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.a.L().Q1());
                    statisticItem.param("fid", this.a.a.L().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    if (z2) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    statisticItem.param("obj_type", i2);
                    TiebaStatic.log(statisticItem);
                    if (this.a.b.I4()) {
                        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem2.param("fid", this.a.a.L().getForumId());
                        statisticItem2.param("tid", this.a.a.L().Q1());
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("post_id", this.a.a.L().U0());
                        statisticItem2.param("obj_source", 1);
                        statisticItem2.param("obj_type", 10);
                        statisticItem2.param("obj_locate", this.a.b.Y3());
                        TiebaStatic.log(statisticItem2);
                    }
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pic_pb", "");
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.o(str, i, eVar);
                    if (this.a.a.L().w1().l0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i4 = -1;
                        if (view2.getParent() instanceof TbRichTextView) {
                            TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                            if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().V() != null) {
                                ArrayList<TbRichTextImageInfo> V = tbRichTextView.getRichText().V();
                                int i5 = 0;
                                int i6 = -1;
                                while (i5 < V.size()) {
                                    if (V.get(i5) != null) {
                                        arrayList.add(V.get(i5).getSrc());
                                        if (i6 == i4 && str != null && str.equals(V.get(i5).getSrc())) {
                                            i6 = i5;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = V.get(i5).getSrc();
                                        imageUrlData.originalUrl = V.get(i5).getSrc();
                                        imageUrlData.isLongPic = V.get(i5).Y();
                                        concurrentHashMap.put(V.get(i5).getSrc(), imageUrlData);
                                    }
                                    i5++;
                                    i4 = -1;
                                }
                                i3 = i6;
                                ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                                builder.A(arrayList);
                                builder.E(i3);
                                builder.F(false);
                                builder.O(eVar.f);
                                builder.I(this.a.a.L().H1());
                                builder.y(concurrentHashMap);
                                builder.K(true);
                                builder.N(false);
                                if (this.a.a.L() != null) {
                                    builder.J(this.a.a.L().Z0());
                                    builder.D(this.a.a.L().getFromForumId());
                                    if (this.a.a.L().w1() != null) {
                                        builder.Q(this.a.a.L().w1().Q());
                                    }
                                }
                                ImageViewerConfig x = builder.x(this.a.a.getPageContext().getPageActivity());
                                x.getIntent().putExtra("from", "pb");
                                this.a.a.sendMessage(new CustomMessage(2010000, x));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            }
                        }
                        i3 = -1;
                        ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                        builder2.A(arrayList);
                        builder2.E(i3);
                        builder2.F(false);
                        builder2.O(eVar.f);
                        builder2.I(this.a.a.L().H1());
                        builder2.y(concurrentHashMap);
                        builder2.K(true);
                        builder2.N(false);
                        if (this.a.a.L() != null) {
                        }
                        ImageViewerConfig x2 = builder2.x(this.a.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.a.sendMessage(new CustomMessage(2010000, x2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else if (eVar.h) {
                        TbRichText r = this.a.r(str, i);
                        if (r != null && this.a.c >= 0 && this.a.c < r.T().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String a = li8.a(r.T().get(this.a.c));
                            int i7 = 0;
                            while (true) {
                                if (i7 >= eVar.a.size()) {
                                    break;
                                } else if (eVar.a.get(i7).equals(a)) {
                                    eVar.j = i7;
                                    arrayList2.add(a);
                                    break;
                                } else {
                                    i7++;
                                }
                            }
                            if (r.getPostId() != 0 && (E1 = this.a.a.E1()) != null) {
                                ArrayList<gn> a2 = E1.a();
                                if (ListUtils.getCount(a2) > 0) {
                                    Iterator<gn> it = a2.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        gn next = it.next();
                                        if ((next instanceof bc9) && r.getPostId() == gg.g(((bc9) next).O(), 0L)) {
                                            mp8.b(this.a.a.L().w1(), (bc9) next, ((bc9) next).d0, 8, 3);
                                            break;
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!ListUtils.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, eVar.b.get(str2));
                            }
                            ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                            builder3.A(arrayList2);
                            builder3.C(eVar.c);
                            builder3.B(eVar.d);
                            builder3.R(eVar.e);
                            builder3.F(eVar.g);
                            builder3.K(true);
                            builder3.M(eVar.i);
                            builder3.y(concurrentHashMap2);
                            builder3.N(false);
                            builder3.I(this.a.a.L().H1());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            if (this.a.a.L() != null) {
                                builder3.J(this.a.a.L().Z0());
                                builder3.D(this.a.a.L().getFromForumId());
                                if (this.a.a.L().w1() != null) {
                                    builder3.Q(this.a.a.L().w1().Q());
                                }
                            }
                            ImageViewerConfig x3 = builder3.x(this.a.a.getPageContext().getPageActivity());
                            x3.getIntent().putExtra("from", "pb");
                            this.a.a.sendMessage(new CustomMessage(2010000, x3));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        }
                    } else {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(eVar.a, 0));
                        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                        if (!ListUtils.isEmpty(arrayList3)) {
                            String str3 = (String) arrayList3.get(0);
                            concurrentHashMap3.put(str3, eVar.b.get(str3));
                        }
                        ImageViewerConfig.Builder builder4 = new ImageViewerConfig.Builder();
                        builder4.A(arrayList3);
                        builder4.C(eVar.c);
                        builder4.B(eVar.d);
                        builder4.R(eVar.e);
                        builder4.F(eVar.g);
                        builder4.K(true);
                        builder4.M(eVar.a.get(0));
                        builder4.y(concurrentHashMap3);
                        builder4.I(this.a.a.L().H1());
                        builder4.N(false);
                        builder4.O(eVar.f);
                        builder4.z(eVar.f);
                        builder4.G(false);
                        if (this.a.a.L() != null) {
                            builder4.J(this.a.a.L().Z0());
                            builder4.D(this.a.a.L().getFromForumId());
                            if (this.a.a.L().w1() != null) {
                                builder4.Q(this.a.a.L().w1().Q());
                            }
                        }
                        ImageViewerConfig x4 = builder4.x(this.a.a.getPageContext().getPageActivity());
                        x4.getIntent().putExtra("from", "pb");
                        this.a.a.sendMessage(new CustomMessage(2010000, x4));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements mj8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lq8 a;

        @Override // com.baidu.tieba.mj8.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.mj8.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public b(lq8 lq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lq8Var;
        }

        @Override // com.baidu.tieba.mj8.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.a.b;
                if (absVideoPbFragment != null && absVideoPbFragment.isAdded()) {
                    if (view2 != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091dc7) {
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.b;
                            if (absVideoPbFragment2 != null && absVideoPbFragment2.m5(view2)) {
                                return true;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f090150) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof bc9)) {
                                return false;
                            }
                            bc9 bc9Var = (bc9) obj;
                            if (!TextUtils.isEmpty(bc9Var.t()) && pv4.c().g()) {
                                return this.a.n(bc9Var.O());
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09199c) {
                            if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                                this.a.q((SparseArray) view2.getTag(R.id.tag_from));
                            }
                        } else if ((view2 instanceof TbRichTextView) || view2.getId() == R.id.pb_post_header_layout) {
                            SparseArray sparseArray = null;
                            if (view2.getTag() instanceof SparseArray) {
                                sparseArray = (SparseArray) view2.getTag();
                            }
                            if (sparseArray == null) {
                                return false;
                            }
                            this.a.q(sparseArray);
                        }
                    }
                    AbsVideoPbFragment absVideoPbFragment3 = this.a.b;
                    if (absVideoPbFragment3 != null) {
                        absVideoPbFragment3.W5();
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public lq8(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseVideoPBReplyFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = false;
        this.e = new a(this);
        this.f = new mj8(new b(this));
        this.a = baseVideoPBReplyFragment;
        this.b = baseVideoPBReplyFragment.D();
    }

    public final boolean h(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.Z() == null) {
                return false;
            }
            return tbRichTextData.Z().Y();
        }
        return invokeL.booleanValue;
    }

    public final boolean i(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.Z() == null) {
                return false;
            }
            return tbRichTextData.Z().Z();
        }
        return invokeL.booleanValue;
    }

    public final String k(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.Z() == null) {
                return null;
            }
            return tbRichTextData.Z().U();
        }
        return (String) invokeL.objValue;
    }

    public final long l(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.Z() == null) {
                return 0L;
            }
            return tbRichTextData.Z().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final void e(ki8 ki8Var, ArrayList<bc9> arrayList) {
        List<bc9> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, ki8Var, arrayList) == null) && ki8Var != null && ki8Var.V() != null && ki8Var.V().a != null && (list = ki8Var.V().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<bc9> it = arrayList.iterator();
                while (it.hasNext()) {
                    bc9 next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            bc9 bc9Var = (bc9) it2.next();
                            if (bc9Var != null && !TextUtils.isEmpty(next.O()) && !TextUtils.isEmpty(bc9Var.O()) && next.O().equals(bc9Var.O())) {
                                arrayList2.add(bc9Var);
                            }
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    arrayList3.removeAll(arrayList2);
                }
                if (arrayList3.size() > 0) {
                    arrayList.addAll(arrayList3);
                }
            }
        }
    }

    public final TbRichText f(ArrayList<bc9> arrayList, String str, int i) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, i)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    TbRichText Z = arrayList.get(i2).Z();
                    if (Z != null && (T = Z.T()) != null) {
                        int size = T.size();
                        int i3 = -1;
                        for (int i4 = 0; i4 < size; i4++) {
                            if (T.get(i4) != null && T.get(i4).getType() == 8) {
                                i3++;
                                if (!T.get(i4).Z().S().equals(str) && !T.get(i4).Z().T().equals(str)) {
                                    if (i3 > i) {
                                        break;
                                    }
                                } else {
                                    int i5 = (int) hi.i(TbadkCoreApplication.getInst());
                                    int width = T.get(i4).Z().getWidth() * i5;
                                    int height = T.get(i4).Z().getHeight() * i5;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.c = i4;
                                    return Z;
                                }
                            }
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return (TbRichText) invokeLLI.objValue;
    }

    public final int g(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z;
        TbRichTextImageInfo Z;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i), Integer.valueOf(i2), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.d = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.T().size();
                int i4 = i;
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    TbRichTextData tbRichTextData = tbRichText.T().get(i6);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i5++;
                        int i7 = (int) hi.i(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.Z().getWidth() * i7;
                        int height = tbRichTextData.Z().getHeight() * i7;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z && tbRichTextData.Z().X()) {
                            if (tbRichTextData.getType() != 20) {
                                String a2 = li8.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a2)) {
                                    arrayList.add(a2);
                                    if (tbRichTextData != null && (Z = tbRichTextData.Z()) != null) {
                                        String S = Z.S();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            S = Z.T();
                                        } else {
                                            if (((VideoPbViewModel) ViewModelProviders.of(this.a.M()).get(VideoPbViewModel.class)).m()) {
                                                i3 = 17;
                                            } else {
                                                i3 = 18;
                                            }
                                            imageUrlData.urlType = i3;
                                        }
                                        imageUrlData.imageUrl = S;
                                        imageUrlData.originalUrl = k(tbRichTextData);
                                        imageUrlData.originalSize = l(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = i(tbRichTextData);
                                        imageUrlData.isLongPic = h(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = gg.g(this.a.L().Q1(), -1L);
                                        imageUrlData.mIsReserver = this.a.L().H1();
                                        imageUrlData.mIsSeeHost = this.a.L().Z0();
                                        if (concurrentHashMap != null) {
                                            concurrentHashMap.put(a2, imageUrlData);
                                        }
                                    }
                                }
                                if (!this.d) {
                                    i4++;
                                }
                            }
                        } else if (tbRichText == tbRichText2) {
                            if (i5 <= i2) {
                                i4--;
                            }
                        }
                    }
                }
                return i4;
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    public TbRichTextView.a0 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (TbRichTextView.a0) invokeV.objValue;
    }

    public mj8 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (mj8) invokeV.objValue;
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        BaseVideoPBReplyFragment baseVideoPBReplyFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (StringUtils.isNull(str) || (baseVideoPBReplyFragment = this.a) == null || !ViewHelper.checkUpIsLogin(baseVideoPBReplyFragment.getPageContext().getPageActivity())) {
                return false;
            }
            String s = m35.m().s("bubble_link", "");
            if (StringUtils.isNull(s)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(this.a.getPageContext().getPageActivity())));
            } else {
                gt4.x(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getResources().getString(R.string.editor_privilege), s + "?props_id=" + str, true, true, true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o(String str, int i, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048586, this, str, i, eVar) != null) || eVar == null) {
            return;
        }
        ki8 w1 = this.a.L().w1();
        TbRichText r = r(str, i);
        if (r == null || (tbRichTextData = r.T().get(this.c)) == null) {
            return;
        }
        eVar.f = String.valueOf(r.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z = false;
        if (!tbRichTextData.Z().X()) {
            eVar.h = false;
            String a2 = li8.a(tbRichTextData);
            eVar.a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                if (((VideoPbViewModel) ViewModelProviders.of(this.a.M()).get(VideoPbViewModel.class)).m()) {
                    i3 = 17;
                } else {
                    i3 = 18;
                }
                imageUrlData.urlType = i3;
            }
            imageUrlData.originalUrl = k(tbRichTextData);
            imageUrlData.originalUrl = k(tbRichTextData);
            imageUrlData.originalSize = l(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = i(tbRichTextData);
            imageUrlData.isLongPic = h(tbRichTextData);
            imageUrlData.postId = r.getPostId();
            imageUrlData.mIsReserver = this.a.L().H1();
            imageUrlData.mIsSeeHost = this.a.L().Z0();
            eVar.b.put(a2, imageUrlData);
            if (w1 != null) {
                if (w1.l() != null) {
                    eVar.c = w1.l().getName();
                    eVar.d = w1.l().getId();
                }
                if (w1.Q() != null) {
                    eVar.e = w1.Q().getId();
                }
                if (w1.s() == 1) {
                    z = true;
                }
                eVar.g = z;
            }
            imageUrlData.threadId = gg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = w1.H().size();
        this.d = false;
        eVar.j = -1;
        if (w1.j() != null) {
            i2 = g(w1.j().Z(), r, i, i, eVar.a, eVar.b);
        } else {
            i2 = i;
        }
        int i4 = i2;
        for (int i5 = 0; i5 < size; i5++) {
            bc9 bc9Var = w1.H().get(i5);
            if (bc9Var.O() == null || w1.j() == null || w1.j().O() == null || !bc9Var.O().equals(w1.j().O())) {
                i4 = g(bc9Var.Z(), r, i4, i, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (w1 != null) {
            if (w1.l() != null) {
                eVar.c = w1.l().getName();
                eVar.d = w1.l().getId();
            }
            if (w1.Q() != null) {
                eVar.e = w1.Q().getId();
            }
            if (w1.s() == 1) {
                z = true;
            }
            eVar.g = z;
        }
        eVar.j = i4;
    }

    public AbsPbActivity.e p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            String str2 = null;
            if (this.a.L() != null && this.a.L().w1() != null && this.a.L().w1().H() != null && this.a.L().w1().H().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i = 0;
                while (true) {
                    if (i < this.a.L().w1().H().size()) {
                        if (str.equals(this.a.L().w1().H().get(i).O())) {
                            break;
                        }
                        i++;
                    } else {
                        i = 0;
                        break;
                    }
                }
                bc9 bc9Var = this.a.L().w1().H().get(i);
                if (bc9Var.Z() != null && bc9Var.Z().T() != null) {
                    Iterator<TbRichTextData> it = bc9Var.Z().T().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.Z() != null) {
                                str2 = next.Z().S();
                            }
                        }
                    }
                    o(str2, 0, eVar);
                    li8.b(bc9Var, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void q(SparseArray<Object> sparseArray) {
        bc9 bc9Var;
        int i;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, sparseArray) != null) || !this.a.checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof bc9) || (bc9Var = (bc9) sparseArray.get(R.id.tag_clip_board)) == null || this.a.L() == null || this.a.L().w1() == null || bc9Var.E() == 1) {
            return;
        }
        String Q1 = this.a.L().Q1();
        String O = bc9Var.O();
        if (this.a.L().w1() != null) {
            i = this.a.L().w1().Y();
        } else {
            i = 0;
        }
        AbsPbActivity.e p = p(O);
        if (p == null) {
            return;
        }
        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.a.getPageContext().getPageActivity());
        boolean I4 = this.b.I4();
        SmallTailInfo g0 = bc9Var.g0();
        AntiData d = this.a.L().w1().d();
        if (bc9Var.r() != null) {
            arrayList = bc9Var.r().getIconInfo();
        } else {
            arrayList = null;
        }
        SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(Q1, O, "pb", true, I4, null, false, null, i, g0, d, false, arrayList, 0).addBigImageData(p.a, p.b, p.g, p.j);
        addBigImageData.setKeyPageStartFrom(this.a.L().v1());
        addBigImageData.setFromFrsForumId(this.a.L().getFromForumId());
        addBigImageData.setWorksInfoData(this.a.L().V1());
        addBigImageData.setKeyFromForumId(this.a.L().getForumId());
        addBigImageData.setBjhData(this.a.L().O0());
        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final TbRichText r(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, str, i)) == null) {
            TbRichText tbRichText = null;
            if (this.a.L() == null || this.a.L().w1() == null || str == null || i < 0) {
                return null;
            }
            ki8 w1 = this.a.L().w1();
            if (w1.j() != null) {
                ArrayList<bc9> arrayList = new ArrayList<>();
                arrayList.add(w1.j());
                tbRichText = f(arrayList, str, i);
            }
            if (tbRichText == null) {
                ArrayList<bc9> H = w1.H();
                e(w1, H);
                return f(H, str, i);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }
}
