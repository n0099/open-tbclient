package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment;
import com.baidu.tieba.vk9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class xr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseVideoPBReplyFragment a;
    public AbsVideoPbFragment b;
    public int c;
    public boolean d;
    public final TbRichTextView.z e;
    public vk9 f;

    /* loaded from: classes8.dex */
    public class a implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xr9 a;

        public a(xr9 xr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xr9Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x01c7 A[Catch: Exception -> 0x04ed, TryCatch #0 {Exception -> 0x04ed, blocks: (B:5:0x0014, B:9:0x004a, B:12:0x00d8, B:14:0x00de, B:16:0x00f1, B:18:0x00fd, B:20:0x0107, B:21:0x0111, B:23:0x0117, B:25:0x011d, B:28:0x012e, B:31:0x013f, B:35:0x015d, B:36:0x0184, B:39:0x018b, B:41:0x01c7, B:43:0x01f3, B:44:0x0206, B:46:0x023b, B:48:0x023f, B:50:0x025a, B:51:0x026b, B:53:0x02cd, B:55:0x02f9, B:56:0x030c, B:57:0x0342, B:60:0x034b, B:62:0x0353, B:65:0x0365, B:66:0x037f, B:68:0x0387, B:70:0x0395, B:71:0x039b, B:72:0x039e, B:74:0x03a8, B:76:0x03b2, B:78:0x03bc, B:79:0x03c0, B:81:0x03c6, B:83:0x03d0, B:85:0x03e4, B:87:0x0401, B:89:0x040c, B:90:0x041d, B:92:0x0475, B:94:0x04a1, B:95:0x04b4), top: B:104:0x0014 }] */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            yr9 W1;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.a.X().L1());
                    statisticItem.param("fid", this.a.a.X().getForumId());
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
                    statisticItem2.param("fid", this.a.a.X().getForumId());
                    statisticItem2.param("tid", this.a.a.X().L1());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("post_id", this.a.a.X().P0());
                    statisticItem2.param("obj_source", 1);
                    statisticItem2.param("obj_type", 10);
                    statisticItem2.param("obj_locate", this.a.b.G3());
                    TiebaStatic.log(statisticItem2);
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pic_pb", "");
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.o(str, i, eVar);
                    aj9 r1 = this.a.a.X().r1();
                    if (r1 != null && r1.j0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i5 = -1;
                        if (view2.getParent() instanceof TbRichTextView) {
                            TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                            if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().Q() != null) {
                                ArrayList<TbRichTextImageInfo> Q = tbRichTextView.getRichText().Q();
                                int i6 = 0;
                                int i7 = -1;
                                while (i6 < Q.size()) {
                                    if (Q.get(i6) != null) {
                                        arrayList.add(Q.get(i6).getSrc());
                                        if (i7 == i5 && str != null && str.equals(Q.get(i6).getSrc())) {
                                            i7 = i6;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        String src = Q.get(i6).getSrc();
                                        imageUrlData.imageUrl = src;
                                        imageUrlData.imageThumbUrl = src;
                                        if (r1.m0()) {
                                            i4 = 17;
                                        } else {
                                            i4 = 18;
                                        }
                                        imageUrlData.urlThumbType = i4;
                                        imageUrlData.originalUrl = Q.get(i6).getSrc();
                                        imageUrlData.isLongPic = Q.get(i6).T();
                                        concurrentHashMap.put(Q.get(i6).getSrc(), imageUrlData);
                                    }
                                    i6++;
                                    i5 = -1;
                                }
                                i3 = i7;
                                ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                                builder.setData(arrayList).setIndex(i3).setIsCDN(false).setPostId(eVar.f).setIsReserve(this.a.a.X().D1()).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false);
                                if (this.a.a.X() != null) {
                                    builder.setIsSeeHost(this.a.a.X().U0());
                                    builder.setFromForumId(this.a.a.X().getFromForumId());
                                    if (this.a.a.X().r1() != null) {
                                        builder.setThreadData(this.a.a.X().r1().O());
                                    }
                                }
                                ImageViewerConfig bulid = builder.bulid(this.a.a.getPageContext().getPageActivity());
                                bulid.getIntent().putExtra("from", "pb");
                                this.a.a.sendMessage(new CustomMessage(2010000, bulid));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            }
                        }
                        i3 = -1;
                        ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                        builder2.setData(arrayList).setIndex(i3).setIsCDN(false).setPostId(eVar.f).setIsReserve(this.a.a.X().D1()).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false);
                        if (this.a.a.X() != null) {
                        }
                        ImageViewerConfig bulid2 = builder2.bulid(this.a.a.getPageContext().getPageActivity());
                        bulid2.getIntent().putExtra("from", "pb");
                        this.a.a.sendMessage(new CustomMessage(2010000, bulid2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else if (eVar.h) {
                        TbRichText r = this.a.r(str, i);
                        if (r != null && this.a.c >= 0 && this.a.c < r.O().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String a = bj9.a(r.O().get(this.a.c));
                            int i8 = 0;
                            while (true) {
                                if (i8 >= eVar.a.size()) {
                                    break;
                                } else if (eVar.a.get(i8).equals(a)) {
                                    eVar.j = i8;
                                    arrayList2.add(a);
                                    break;
                                } else {
                                    i8++;
                                }
                            }
                            if (r.getPostId() != 0 && (W1 = this.a.a.W1()) != null) {
                                ArrayList<cn> a2 = W1.a();
                                if (ListUtils.getCount(a2) > 0) {
                                    Iterator<cn> it = a2.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        cn next = it.next();
                                        if ((next instanceof tha) && r.getPostId() == JavaTypesHelper.toLong(((tha) next).U(), 0L)) {
                                            nr9.b(this.a.a.X().r1(), (tha) next, ((tha) next).f0, 8, 3);
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
                            builder3.setData(arrayList2).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.i).setAssistUrls(concurrentHashMap2).setNeedBroadCaset(false).setIsReserve(this.a.a.X().D1()).setPostId(eVar.f).setBjhPostId(eVar.f);
                            if (this.a.a.X() != null) {
                                builder3.setIsSeeHost(this.a.a.X().U0());
                                builder3.setFromForumId(this.a.a.X().getFromForumId());
                                if (this.a.a.X().r1() != null) {
                                    builder3.setThreadData(this.a.a.X().r1().O());
                                }
                            }
                            ImageViewerConfig bulid3 = builder3.bulid(this.a.a.getPageContext().getPageActivity());
                            bulid3.getIntent().putExtra("from", "pb");
                            this.a.a.sendMessage(new CustomMessage(2010000, bulid3));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        }
                    } else {
                        ArrayList<String> arrayList3 = new ArrayList<>();
                        arrayList3.add((String) ListUtils.getItem(eVar.a, 0));
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!ListUtils.isEmpty(arrayList3)) {
                            String str3 = arrayList3.get(0);
                            concurrentHashMap3.put(str3, eVar.b.get(str3));
                        }
                        ImageViewerConfig.Builder builder4 = new ImageViewerConfig.Builder();
                        builder4.setData(arrayList3).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.a.get(0)).setAssistUrls(concurrentHashMap3).setIsReserve(this.a.a.X().D1()).setNeedBroadCaset(false).setPostId(eVar.f).setBjhPostId(eVar.f).setIsCanDrag(false);
                        if (this.a.a.X() != null) {
                            builder4.setIsSeeHost(this.a.a.X().U0());
                            builder4.setFromForumId(this.a.a.X().getFromForumId());
                            if (this.a.a.X().r1() != null) {
                                builder4.setThreadData(this.a.a.X().r1().O());
                            }
                        }
                        ImageViewerConfig bulid4 = builder4.bulid(this.a.a.getPageContext().getPageActivity());
                        bulid4.getIntent().putExtra("from", "pb");
                        this.a.a.sendMessage(new CustomMessage(2010000, bulid4));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements vk9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xr9 a;

        @Override // com.baidu.tieba.vk9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.vk9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public b(xr9 xr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xr9Var;
        }

        @Override // com.baidu.tieba.vk9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.a.b;
                if (absVideoPbFragment != null && absVideoPbFragment.isAdded()) {
                    if (view2 != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091f50) {
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.b;
                            if (absVideoPbFragment2 != null && absVideoPbFragment2.A4(view2)) {
                                return true;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09015a) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof tha)) {
                                return false;
                            }
                            tha thaVar = (tha) obj;
                            if (!TextUtils.isEmpty(thaVar.v()) && m05.c().g()) {
                                return this.a.n(thaVar.U());
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091ae6) {
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
                        absVideoPbFragment3.b5();
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public xr9(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
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
        this.f = new vk9(new b(this));
        this.a = baseVideoPBReplyFragment;
        this.b = baseVideoPBReplyFragment.S();
    }

    public final boolean h(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.U() == null) {
                return false;
            }
            return tbRichTextData.U().T();
        }
        return invokeL.booleanValue;
    }

    public final boolean i(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.U() == null) {
                return false;
            }
            return tbRichTextData.U().U();
        }
        return invokeL.booleanValue;
    }

    public final String k(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.U() == null) {
                return null;
            }
            return tbRichTextData.U().P();
        }
        return (String) invokeL.objValue;
    }

    public final long l(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.U() == null) {
                return 0L;
            }
            return tbRichTextData.U().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final void e(aj9 aj9Var, ArrayList<tha> arrayList) {
        List<tha> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, aj9Var, arrayList) == null) && aj9Var != null && aj9Var.T() != null && aj9Var.T().a != null && (list = aj9Var.T().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<tha> it = arrayList.iterator();
                while (it.hasNext()) {
                    tha next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            tha thaVar = (tha) it2.next();
                            if (thaVar != null && !TextUtils.isEmpty(next.U()) && !TextUtils.isEmpty(thaVar.U()) && next.U().equals(thaVar.U())) {
                                arrayList2.add(thaVar);
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

    public final TbRichText f(ArrayList<tha> arrayList, String str, int i) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, i)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    TbRichText f0 = arrayList.get(i2).f0();
                    if (f0 != null && (O = f0.O()) != null) {
                        int size = O.size();
                        int i3 = -1;
                        for (int i4 = 0; i4 < size; i4++) {
                            if (O.get(i4) != null && O.get(i4).getType() == 8) {
                                i3++;
                                if (!O.get(i4).U().N().equals(str) && !O.get(i4).U().O().equals(str)) {
                                    if (i3 > i) {
                                        break;
                                    }
                                } else {
                                    int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                                    int width = O.get(i4).U().getWidth() * equipmentDensity;
                                    int height = O.get(i4).U().getHeight() * equipmentDensity;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.c = i4;
                                    return f0;
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
        TbRichTextImageInfo U;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i), Integer.valueOf(i2), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.d = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.O().size();
                int i4 = i;
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    TbRichTextData tbRichTextData = tbRichText.O().get(i6);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i5++;
                        int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.U().getWidth() * equipmentDensity;
                        int height = tbRichTextData.U().getHeight() * equipmentDensity;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z && tbRichTextData.U().S()) {
                            if (tbRichTextData.getType() != 20) {
                                String a2 = bj9.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a2)) {
                                    arrayList.add(a2);
                                    if (tbRichTextData != null && (U = tbRichTextData.U()) != null) {
                                        String N = U.N();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            N = U.O();
                                        } else {
                                            aj9 aj9Var = null;
                                            BaseVideoPBReplyFragment baseVideoPBReplyFragment = this.a;
                                            if (baseVideoPBReplyFragment != null && baseVideoPBReplyFragment.X() != null && this.a.X().r1() != null) {
                                                aj9Var = this.a.X().r1();
                                            }
                                            if (aj9Var != null && aj9Var.m0()) {
                                                i3 = 17;
                                            } else {
                                                i3 = 18;
                                            }
                                            imageUrlData.urlType = i3;
                                        }
                                        imageUrlData.imageUrl = N;
                                        imageUrlData.urlThumbType = imageUrlData.urlType;
                                        imageUrlData.imageThumbUrl = N;
                                        imageUrlData.originalUrl = k(tbRichTextData);
                                        imageUrlData.originalSize = l(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = i(tbRichTextData);
                                        imageUrlData.isLongPic = h(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = JavaTypesHelper.toLong(this.a.X().L1(), -1L);
                                        imageUrlData.mIsReserver = this.a.X().D1();
                                        imageUrlData.mIsSeeHost = this.a.X().U0();
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

    public TbRichTextView.z j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (TbRichTextView.z) invokeV.objValue;
    }

    public vk9 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (vk9) invokeV.objValue;
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        BaseVideoPBReplyFragment baseVideoPBReplyFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (StringUtils.isNull(str) || (baseVideoPBReplyFragment = this.a) == null || !ViewHelper.checkUpIsLogin(baseVideoPBReplyFragment.getPageContext().getPageActivity())) {
                return false;
            }
            String string = SharedPrefHelper.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(this.a.getPageContext().getPageActivity())));
            } else {
                BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getResources().getString(R.string.editor_privilege), string + "?props_id=" + str, true, true, true);
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
        aj9 r1 = this.a.X().r1();
        TbRichText r = r(str, i);
        if (r == null || (tbRichTextData = r.O().get(this.c)) == null) {
            return;
        }
        eVar.f = String.valueOf(r.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z = false;
        if (!tbRichTextData.U().S()) {
            eVar.h = false;
            String a2 = bj9.a(tbRichTextData);
            eVar.a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                if (r1 != null && r1.m0()) {
                    i3 = 17;
                } else {
                    i3 = 18;
                }
                imageUrlData.urlType = i3;
            }
            imageUrlData.urlThumbType = imageUrlData.urlType;
            imageUrlData.imageThumbUrl = imageUrlData.imageUrl;
            imageUrlData.originalUrl = k(tbRichTextData);
            imageUrlData.originalUrl = k(tbRichTextData);
            imageUrlData.originalSize = l(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = i(tbRichTextData);
            imageUrlData.isLongPic = h(tbRichTextData);
            imageUrlData.postId = r.getPostId();
            imageUrlData.mIsReserver = this.a.X().D1();
            imageUrlData.mIsSeeHost = this.a.X().U0();
            eVar.b.put(a2, imageUrlData);
            if (r1 != null) {
                if (r1.k() != null) {
                    eVar.c = r1.k().getName();
                    eVar.d = r1.k().getId();
                }
                if (r1.O() != null) {
                    eVar.e = r1.O().getId();
                }
                if (r1.r() == 1) {
                    z = true;
                }
                eVar.g = z;
            }
            imageUrlData.threadId = JavaTypesHelper.toLong(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = r1.F().size();
        this.d = false;
        eVar.j = -1;
        if (r1.i() != null) {
            i2 = g(r1.i().f0(), r, i, i, eVar.a, eVar.b);
        } else {
            i2 = i;
        }
        int i4 = i2;
        for (int i5 = 0; i5 < size; i5++) {
            tha thaVar = r1.F().get(i5);
            if (thaVar.U() == null || r1.i() == null || r1.i().U() == null || !thaVar.U().equals(r1.i().U())) {
                i4 = g(thaVar.f0(), r, i4, i, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (r1 != null) {
            if (r1.k() != null) {
                eVar.c = r1.k().getName();
                eVar.d = r1.k().getId();
            }
            if (r1.O() != null) {
                eVar.e = r1.O().getId();
            }
            if (r1.r() == 1) {
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
            if (this.a.X() != null && this.a.X().r1() != null && this.a.X().r1().F() != null && this.a.X().r1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i = 0;
                while (true) {
                    if (i < this.a.X().r1().F().size()) {
                        if (str.equals(this.a.X().r1().F().get(i).U())) {
                            break;
                        }
                        i++;
                    } else {
                        i = 0;
                        break;
                    }
                }
                tha thaVar = this.a.X().r1().F().get(i);
                if (thaVar.f0() != null && thaVar.f0().O() != null) {
                    Iterator<TbRichTextData> it = thaVar.f0().O().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.U() != null) {
                                str2 = next.U().N();
                            }
                        }
                    }
                    o(str2, 0, eVar);
                    bj9.b(thaVar, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void q(SparseArray<Object> sparseArray) {
        tha thaVar;
        int i;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, sparseArray) != null) || !this.a.checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof tha) || (thaVar = (tha) sparseArray.get(R.id.tag_clip_board)) == null || this.a.X() == null || this.a.X().r1() == null || thaVar.L() == 1) {
            return;
        }
        String L1 = this.a.X().L1();
        String U = thaVar.U();
        if (this.a.X().r1() != null) {
            i = this.a.X().r1().W();
        } else {
            i = 0;
        }
        AbsPbActivity.e p = p(U);
        if (p == null) {
            return;
        }
        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.a.getPageContext().getPageActivity());
        SmallTailInfo m0 = thaVar.m0();
        AntiData c = this.a.X().r1().c();
        if (thaVar.t() != null) {
            arrayList = thaVar.t().getIconInfo();
        } else {
            arrayList = null;
        }
        SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(L1, U, "pb", true, true, null, false, null, i, m0, c, false, arrayList, 0).addBigImageData(p.a, p.b, p.g, p.j);
        addBigImageData.setKeyPageStartFrom(this.a.X().q1());
        addBigImageData.setFromFrsForumId(this.a.X().getFromForumId());
        addBigImageData.setWorksInfoData(this.a.X().Q1());
        addBigImageData.setKeyFromForumId(this.a.X().getForumId());
        addBigImageData.setBjhData(this.a.X().I0());
        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final TbRichText r(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, str, i)) == null) {
            TbRichText tbRichText = null;
            if (this.a.X() == null || this.a.X().r1() == null || str == null || i < 0) {
                return null;
            }
            aj9 r1 = this.a.X().r1();
            if (r1.i() != null) {
                ArrayList<tha> arrayList = new ArrayList<>();
                arrayList.add(r1.i());
                tbRichText = f(arrayList, str, i);
            }
            if (tbRichText == null) {
                ArrayList<tha> F = r1.F();
                e(r1, F);
                return f(F, str, i);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }
}
