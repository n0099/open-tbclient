package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.ku8;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
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
public class m09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseVideoPBReplyFragment a;
    public AbsVideoPbFragment b;
    public int c;
    public boolean d;
    public final TbRichTextView.a0 e;
    public ku8 f;

    /* loaded from: classes5.dex */
    public class a implements TbRichTextView.a0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m09 a;

        public a(m09 m09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m09Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v31, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:35:0x01b2 A[Catch: Exception -> 0x04a9, TryCatch #0 {Exception -> 0x04a9, blocks: (B:5:0x0014, B:9:0x004a, B:12:0x00df, B:14:0x00f2, B:16:0x00fe, B:18:0x0108, B:19:0x0112, B:21:0x0118, B:23:0x011e, B:26:0x012f, B:29:0x0140, B:30:0x0176, B:33:0x017d, B:35:0x01b2, B:37:0x01de, B:38:0x01f1, B:40:0x0223, B:42:0x0227, B:44:0x0240, B:45:0x024f, B:47:0x02a5, B:49:0x02d1, B:50:0x02e4, B:51:0x0317, B:54:0x0320, B:56:0x0328, B:59:0x033a, B:60:0x0354, B:62:0x035c, B:64:0x036a, B:65:0x0370, B:66:0x0373, B:68:0x037d, B:70:0x0387, B:72:0x0391, B:73:0x0395, B:75:0x039b, B:77:0x03a5, B:79:0x03b8, B:80:0x03d0, B:82:0x03db, B:83:0x03ea, B:85:0x0437, B:87:0x0463, B:88:0x0476), top: B:97:0x0014 }] */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.a0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            n09 E1;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.a.P().N1());
                    statisticItem.param("fid", this.a.a.P().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    if (z2) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    statisticItem.param("obj_type", i2);
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem2.param("fid", this.a.a.P().getForumId());
                    statisticItem2.param("tid", this.a.a.P().N1());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("post_id", this.a.a.P().S0());
                    statisticItem2.param("obj_source", 1);
                    statisticItem2.param("obj_type", 10);
                    statisticItem2.param("obj_locate", this.a.b.n3());
                    TiebaStatic.log(statisticItem2);
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pic_pb", "");
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.o(str, i, eVar);
                    if (this.a.a.P().u1().h0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i4 = -1;
                        if (view2.getParent() instanceof TbRichTextView) {
                            TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                            if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().U() != null) {
                                ArrayList<TbRichTextImageInfo> U = tbRichTextView.getRichText().U();
                                int i5 = 0;
                                int i6 = -1;
                                while (i5 < U.size()) {
                                    if (U.get(i5) != null) {
                                        arrayList.add(U.get(i5).getSrc());
                                        if (i6 == i4 && str != null && str.equals(U.get(i5).getSrc())) {
                                            i6 = i5;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = U.get(i5).getSrc();
                                        imageUrlData.originalUrl = U.get(i5).getSrc();
                                        imageUrlData.isLongPic = U.get(i5).X();
                                        concurrentHashMap.put(U.get(i5).getSrc(), imageUrlData);
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
                                builder.I(this.a.a.P().F1());
                                builder.y(concurrentHashMap);
                                builder.K(true);
                                builder.N(false);
                                if (this.a.a.P() != null) {
                                    builder.J(this.a.a.P().X0());
                                    builder.D(this.a.a.P().getFromForumId());
                                    if (this.a.a.P().u1() != null) {
                                        builder.Q(this.a.a.P().u1().M());
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
                        builder2.I(this.a.a.P().F1());
                        builder2.y(concurrentHashMap);
                        builder2.K(true);
                        builder2.N(false);
                        if (this.a.a.P() != null) {
                        }
                        ImageViewerConfig x2 = builder2.x(this.a.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.a.sendMessage(new CustomMessage(2010000, x2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else if (eVar.h) {
                        TbRichText r = this.a.r(str, i);
                        if (r != null && this.a.c >= 0 && this.a.c < r.S().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String a = it8.a(r.S().get(this.a.c));
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
                                ArrayList<in> a2 = E1.a();
                                if (ListUtils.getCount(a2) > 0) {
                                    Iterator<in> it = a2.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        in next = it.next();
                                        if ((next instanceof am9) && r.getPostId() == gg.g(((am9) next).O(), 0L)) {
                                            c09.b(this.a.a.P().u1(), (am9) next, ((am9) next).d0, 8, 3);
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
                            builder3.I(this.a.a.P().F1());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            if (this.a.a.P() != null) {
                                builder3.J(this.a.a.P().X0());
                                builder3.D(this.a.a.P().getFromForumId());
                                if (this.a.a.P().u1() != null) {
                                    builder3.Q(this.a.a.P().u1().M());
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
                        builder4.I(this.a.a.P().F1());
                        builder4.N(false);
                        builder4.O(eVar.f);
                        builder4.z(eVar.f);
                        builder4.G(false);
                        if (this.a.a.P() != null) {
                            builder4.J(this.a.a.P().X0());
                            builder4.D(this.a.a.P().getFromForumId());
                            if (this.a.a.P().u1() != null) {
                                builder4.Q(this.a.a.P().u1().M());
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
    public class b implements ku8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m09 a;

        @Override // com.baidu.tieba.ku8.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.ku8.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public b(m09 m09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m09Var;
        }

        @Override // com.baidu.tieba.ku8.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.a.b;
                if (absVideoPbFragment != null && absVideoPbFragment.isAdded()) {
                    if (view2 != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091db6) {
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.b;
                            if (absVideoPbFragment2 != null && absVideoPbFragment2.i4(view2)) {
                                return true;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09014e) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof am9)) {
                                return false;
                            }
                            am9 am9Var = (am9) obj;
                            if (!TextUtils.isEmpty(am9Var.s()) && sv4.c().g()) {
                                return this.a.n(am9Var.O());
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091997) {
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
                        absVideoPbFragment3.I4();
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public m09(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
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
        this.f = new ku8(new b(this));
        this.a = baseVideoPBReplyFragment;
        this.b = baseVideoPBReplyFragment.M();
    }

    public final boolean h(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.Y() == null) {
                return false;
            }
            return tbRichTextData.Y().X();
        }
        return invokeL.booleanValue;
    }

    public final boolean i(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.Y() == null) {
                return false;
            }
            return tbRichTextData.Y().Y();
        }
        return invokeL.booleanValue;
    }

    public final String k(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.Y() == null) {
                return null;
            }
            return tbRichTextData.Y().T();
        }
        return (String) invokeL.objValue;
    }

    public final long l(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.Y() == null) {
                return 0L;
            }
            return tbRichTextData.Y().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final void e(ht8 ht8Var, ArrayList<am9> arrayList) {
        List<am9> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, ht8Var, arrayList) == null) && ht8Var != null && ht8Var.R() != null && ht8Var.R().a != null && (list = ht8Var.R().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<am9> it = arrayList.iterator();
                while (it.hasNext()) {
                    am9 next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            am9 am9Var = (am9) it2.next();
                            if (am9Var != null && !TextUtils.isEmpty(next.O()) && !TextUtils.isEmpty(am9Var.O()) && next.O().equals(am9Var.O())) {
                                arrayList2.add(am9Var);
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

    public final TbRichText f(ArrayList<am9> arrayList, String str, int i) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> S;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, i)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    TbRichText a0 = arrayList.get(i2).a0();
                    if (a0 != null && (S = a0.S()) != null) {
                        int size = S.size();
                        int i3 = -1;
                        for (int i4 = 0; i4 < size; i4++) {
                            if (S.get(i4) != null && S.get(i4).getType() == 8) {
                                i3++;
                                if (!S.get(i4).Y().R().equals(str) && !S.get(i4).Y().S().equals(str)) {
                                    if (i3 > i) {
                                        break;
                                    }
                                } else {
                                    int i5 = (int) ii.i(TbadkCoreApplication.getInst());
                                    int width = S.get(i4).Y().getWidth() * i5;
                                    int height = S.get(i4).Y().getHeight() * i5;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.c = i4;
                                    return a0;
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
        TbRichTextImageInfo Y;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i), Integer.valueOf(i2), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.d = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.S().size();
                int i4 = i;
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    TbRichTextData tbRichTextData = tbRichText.S().get(i6);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i5++;
                        int i7 = (int) ii.i(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.Y().getWidth() * i7;
                        int height = tbRichTextData.Y().getHeight() * i7;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z && tbRichTextData.Y().W()) {
                            if (tbRichTextData.getType() != 20) {
                                String a2 = it8.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a2)) {
                                    arrayList.add(a2);
                                    if (tbRichTextData != null && (Y = tbRichTextData.Y()) != null) {
                                        String R = Y.R();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            R = Y.S();
                                        } else {
                                            ht8 ht8Var = null;
                                            BaseVideoPBReplyFragment baseVideoPBReplyFragment = this.a;
                                            if (baseVideoPBReplyFragment != null && baseVideoPBReplyFragment.P() != null && this.a.P().u1() != null) {
                                                ht8Var = this.a.P().u1();
                                            }
                                            if (ht8Var != null && ht8Var.k0()) {
                                                i3 = 17;
                                            } else {
                                                i3 = 18;
                                            }
                                            imageUrlData.urlType = i3;
                                        }
                                        imageUrlData.imageUrl = R;
                                        imageUrlData.originalUrl = k(tbRichTextData);
                                        imageUrlData.originalSize = l(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = i(tbRichTextData);
                                        imageUrlData.isLongPic = h(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = gg.g(this.a.P().N1(), -1L);
                                        imageUrlData.mIsReserver = this.a.P().F1();
                                        imageUrlData.mIsSeeHost = this.a.P().X0();
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

    public ku8 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (ku8) invokeV.objValue;
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        BaseVideoPBReplyFragment baseVideoPBReplyFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (StringUtils.isNull(str) || (baseVideoPBReplyFragment = this.a) == null || !ViewHelper.checkUpIsLogin(baseVideoPBReplyFragment.getPageContext().getPageActivity())) {
                return false;
            }
            String s = q45.m().s("bubble_link", "");
            if (StringUtils.isNull(s)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(this.a.getPageContext().getPageActivity())));
            } else {
                jt4.x(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getResources().getString(R.string.editor_privilege), s + "?props_id=" + str, true, true, true);
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
        ht8 u1 = this.a.P().u1();
        TbRichText r = r(str, i);
        if (r == null || (tbRichTextData = r.S().get(this.c)) == null) {
            return;
        }
        eVar.f = String.valueOf(r.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z = false;
        if (!tbRichTextData.Y().W()) {
            eVar.h = false;
            String a2 = it8.a(tbRichTextData);
            eVar.a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                if (u1 != null && u1.k0()) {
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
            imageUrlData.mIsReserver = this.a.P().F1();
            imageUrlData.mIsSeeHost = this.a.P().X0();
            eVar.b.put(a2, imageUrlData);
            if (u1 != null) {
                if (u1.k() != null) {
                    eVar.c = u1.k().getName();
                    eVar.d = u1.k().getId();
                }
                if (u1.M() != null) {
                    eVar.e = u1.M().getId();
                }
                if (u1.r() == 1) {
                    z = true;
                }
                eVar.g = z;
            }
            imageUrlData.threadId = gg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = u1.F().size();
        this.d = false;
        eVar.j = -1;
        if (u1.i() != null) {
            i2 = g(u1.i().a0(), r, i, i, eVar.a, eVar.b);
        } else {
            i2 = i;
        }
        int i4 = i2;
        for (int i5 = 0; i5 < size; i5++) {
            am9 am9Var = u1.F().get(i5);
            if (am9Var.O() == null || u1.i() == null || u1.i().O() == null || !am9Var.O().equals(u1.i().O())) {
                i4 = g(am9Var.a0(), r, i4, i, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (u1 != null) {
            if (u1.k() != null) {
                eVar.c = u1.k().getName();
                eVar.d = u1.k().getId();
            }
            if (u1.M() != null) {
                eVar.e = u1.M().getId();
            }
            if (u1.r() == 1) {
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
            if (this.a.P() != null && this.a.P().u1() != null && this.a.P().u1().F() != null && this.a.P().u1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i = 0;
                while (true) {
                    if (i < this.a.P().u1().F().size()) {
                        if (str.equals(this.a.P().u1().F().get(i).O())) {
                            break;
                        }
                        i++;
                    } else {
                        i = 0;
                        break;
                    }
                }
                am9 am9Var = this.a.P().u1().F().get(i);
                if (am9Var.a0() != null && am9Var.a0().S() != null) {
                    Iterator<TbRichTextData> it = am9Var.a0().S().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.Y() != null) {
                                str2 = next.Y().R();
                            }
                        }
                    }
                    o(str2, 0, eVar);
                    it8.b(am9Var, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void q(SparseArray<Object> sparseArray) {
        am9 am9Var;
        int i;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, sparseArray) != null) || !this.a.checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof am9) || (am9Var = (am9) sparseArray.get(R.id.tag_clip_board)) == null || this.a.P() == null || this.a.P().u1() == null || am9Var.E() == 1) {
            return;
        }
        String N1 = this.a.P().N1();
        String O = am9Var.O();
        if (this.a.P().u1() != null) {
            i = this.a.P().u1().U();
        } else {
            i = 0;
        }
        AbsPbActivity.e p = p(O);
        if (p == null) {
            return;
        }
        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.a.getPageContext().getPageActivity());
        SmallTailInfo h0 = am9Var.h0();
        AntiData c = this.a.P().u1().c();
        if (am9Var.q() != null) {
            arrayList = am9Var.q().getIconInfo();
        } else {
            arrayList = null;
        }
        SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(N1, O, "pb", true, true, null, false, null, i, h0, c, false, arrayList, 0).addBigImageData(p.a, p.b, p.g, p.j);
        addBigImageData.setKeyPageStartFrom(this.a.P().t1());
        addBigImageData.setFromFrsForumId(this.a.P().getFromForumId());
        addBigImageData.setWorksInfoData(this.a.P().S1());
        addBigImageData.setKeyFromForumId(this.a.P().getForumId());
        addBigImageData.setBjhData(this.a.P().M0());
        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final TbRichText r(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, str, i)) == null) {
            TbRichText tbRichText = null;
            if (this.a.P() == null || this.a.P().u1() == null || str == null || i < 0) {
                return null;
            }
            ht8 u1 = this.a.P().u1();
            if (u1.i() != null) {
                ArrayList<am9> arrayList = new ArrayList<>();
                arrayList.add(u1.i());
                tbRichText = f(arrayList, str, i);
            }
            if (tbRichText == null) {
                ArrayList<am9> F = u1.F();
                e(u1, F);
                return f(F, str, i);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }
}
