package com.baidu.tieba;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes5.dex */
public class s57 extends p16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public k57 j;
    public ClickableHeaderImageView k;
    public TextView l;
    public ImageView m;
    public TextView n;
    public AgreeView o;
    public TextView p;
    public ImageView q;
    public TbRichTextView r;
    public ConstrainImageGroup s;
    public RelativeLayout t;
    public View u;
    public TbImageView v;
    public TextView w;
    public View x;
    public boolean y;
    public int z;

    @Override // com.baidu.tieba.p16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.layout.obfuscated_res_0x7f0d0898 : invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements kk5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedList a;
        public final /* synthetic */ ThreadData b;
        public final /* synthetic */ s57 c;

        public a(s57 s57Var, LinkedList linkedList, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s57Var, linkedList, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s57Var;
            this.a = linkedList;
            this.b = threadData;
        }

        @Override // com.baidu.tieba.kk5
        public void a(View view2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                if (z) {
                    this.c.u();
                } else {
                    this.c.E(view2, this.a, i, this.b);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s57(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = true;
        this.z = 3;
        this.i = tbPageContext;
        t();
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            TiebaStatic.log(new StatisticItem("c13356").param("obj_locate", str).param("tid", this.j.b.getTid()).param("topic_id", this.j.c).param("obj_type", String.valueOf(this.j.e)));
        }
    }

    public void A(vg vgVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, vgVar) == null) && (constrainImageGroup = this.s) != null) {
            constrainImageGroup.setImageViewPool(vgVar);
        }
    }

    public void B(vg vgVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vgVar) == null) && (constrainImageGroup = this.s) != null) {
            constrainImageGroup.setConstrainLayoutPool(vgVar);
        }
    }

    public final void D(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            o(bdUniqueId);
            ConstrainImageGroup constrainImageGroup = this.s;
            if (constrainImageGroup != null) {
                constrainImageGroup.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public final void C(k57 k57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k57Var) == null) {
            ThreadData threadData = k57Var.b;
            ArrayList<MediaData> medias = threadData.getMedias();
            if (jq4.c().g() && ListUtils.getCount(medias) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(linkedList) > 0) {
                    this.t.setVisibility(0);
                    this.s.setFromCDN(this.y);
                    this.s.setImageClickListener(new a(this, linkedList, threadData));
                    this.s.setImageMediaList(linkedList);
                    return;
                }
                this.t.setVisibility(8);
                return;
            }
            this.t.setVisibility(8);
        }
    }

    public final void E(View view2, List list, int i, ThreadData threadData) {
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048580, this, view2, list, i, threadData) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                fj.M(this.b.getPageActivity(), R.string.obfuscated_res_0x7f0f0ed3);
                return;
            }
            ArrayList arrayList = new ArrayList();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                MediaData mediaData = (MediaData) it.next();
                if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                    arrayList.add(mediaData.getSrc_pic());
                    if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        if (this.y) {
                            i2 = 13;
                        } else {
                            i2 = 14;
                        }
                        imageUrlData.urlType = i2;
                        imageUrlData.imageUrl = mediaData.getPicUrl();
                        imageUrlData.originalUrl = mediaData.getOriginalUrl();
                        imageUrlData.originalSize = mediaData.getOriginalSize();
                        imageUrlData.isLongPic = mediaData.isLongPic();
                        imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                        imageUrlData.threadId = eh.g(threadData.getTid(), -1L);
                        imageUrlData.postId = mediaData.getPostId();
                        concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                    }
                }
            }
            if (arrayList.size() <= 0) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    MediaData mediaData2 = (MediaData) it2.next();
                    if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                        arrayList.add(mediaData2.getPicUrl());
                    }
                }
            }
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
            builder.A(arrayList);
            builder.E(i);
            builder.C(threadData.getForum_name());
            builder.O(threadData.getFirst_post_id());
            builder.B(String.valueOf(threadData.getFid()));
            builder.R(threadData.getTid());
            builder.F(this.y);
            if (arrayList.size() > 0) {
                str = (String) arrayList.get(0);
            } else {
                str = "";
            }
            builder.M(str);
            builder.I(true);
            builder.y(concurrentHashMap);
            builder.K(true);
            builder.Q(threadData);
            builder.P(rect, UtilHelper.fixedDrawableRect(rect, view2));
            ImageViewerConfig x = builder.x(this.b.getPageActivity());
            if (this.h == 2) {
                x.getIntent().putExtra("from", "index");
            } else {
                x.getIntent().putExtra("from", ImageViewerConfig.FROM_OTHER);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, x));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.b;
            historyMessage.threadId = threadData.getId();
            historyMessage.threadName = threadData.getTitle();
            historyMessage.forumName = threadData.getForum_name();
            historyMessage.postID = threadData.getFirstPostId();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    @Override // com.baidu.tieba.p16
    public void m(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) && this.z != i && this.j != null) {
            this.z = i;
            this.k.setSkinType(i);
            k57 k57Var = this.j;
            if (k57Var.f) {
                int i2 = k57Var.d;
                if (i2 == 1) {
                    SkinManager.setImageResource(this.m, R.drawable.label_topic_agree_red);
                    this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0301));
                } else if (i2 == 2) {
                    SkinManager.setImageResource(this.m, R.drawable.label_topic_disagree_blue);
                    this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0302));
                } else {
                    SkinManager.setImageResource(this.m, R.drawable.label_topic_eat_black);
                    this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0106));
                }
            }
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0107);
            if (this.q != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.obfuscated_res_0x7f080a2f, R.color.CAM_X0107, null);
            }
            this.o.L(i);
            this.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setBackgroundShapeDrawable(this.u, fj.f(this.i.getPageActivity(), R.dimen.tbds6), R.color.CAM_X0209, R.color.cp_bg_line_j_alpha50);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0109);
            this.s.b();
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0205);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        k57 k57Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && (k57Var = this.j) != null && k57Var.b != null) {
            if (view2 == this.r) {
                if (k57Var.e == 1) {
                    v();
                } else {
                    u();
                }
                s("1");
            }
            if (view2 != this.p && view2 != this.q) {
                if (view2 == this.l) {
                    w();
                    return;
                }
                u();
                s("2");
                return;
            }
            if (this.j.e == 1) {
                v();
            } else {
                u();
            }
            s("3");
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            View k = k();
            this.k = (ClickableHeaderImageView) k.findViewById(R.id.obfuscated_res_0x7f090591);
            this.m = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f090595);
            this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090592);
            this.n = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09058f);
            TbRichTextView tbRichTextView = (TbRichTextView) k.findViewById(R.id.obfuscated_res_0x7f090593);
            this.r = tbRichTextView;
            tbRichTextView.setClickable(true);
            this.r.setTextEllipsize(TextUtils.TruncateAt.END);
            this.r.setMaxLines(2);
            kl5 kl5Var = new kl5();
            kl5Var.v(fj.f(getContext(), R.dimen.tbds44));
            kl5Var.o(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
            this.r.setLayoutStrategy(kl5Var);
            this.t = (RelativeLayout) k.findViewById(R.id.obfuscated_res_0x7f0922b9);
            this.s = (ConstrainImageGroup) k.findViewById(R.id.obfuscated_res_0x7f090590);
            this.s.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
            hk5 hk5Var = new hk5(3);
            hk5Var.d(1.0d);
            this.s.setImageProcessor(hk5Var);
            AgreeView agreeView = (AgreeView) k.findViewById(R.id.obfuscated_res_0x7f09058c);
            this.o = agreeView;
            agreeView.v();
            this.p = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0922ab);
            this.q = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f0922ac);
            this.u = k.findViewById(R.id.obfuscated_res_0x7f09058e);
            TbImageView tbImageView = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f090597);
            this.v = tbImageView;
            tbImageView.setRadius(fj.f(getContext(), R.dimen.tbds6));
            this.v.setConrers(5);
            this.v.setDrawCorner(true);
            this.w = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090598);
            this.x = k.findViewById(R.id.obfuscated_res_0x7f09058d);
            this.l.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.w.setOnClickListener(this);
        }
    }

    public void u() {
        k57 k57Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (k57Var = this.j) != null && k57Var.b != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.i.getPageActivity()).createFromThreadCfg(this.j.b, null, "none", 18003, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.j.b.getFid()));
            addLocateParam.setFrom("from_personalize");
            addLocateParam.setForumName(this.j.b.getForum_name());
            addLocateParam.setStartFrom(this.h);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            a26.a(this.j.b.getTid());
            this.b.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String format = String.format("%1$s", this.j.b.getTopAgreePost().M());
            String valueOf = String.valueOf(this.j.b.getTid());
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.i.getPageActivity());
            PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(valueOf, format + "", 1, "mention");
            createNormalCfg.setStartFrom(12);
            createNormalCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    public final void w() {
        k57 k57Var;
        ThreadData threadData;
        MetaData author;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (k57Var = this.j) != null && (threadData = k57Var.b) != null) {
            if (k57Var.e == 1 && threadData.getTopAgreePost() != null) {
                author = threadData.getTopAgreePost().s();
            } else {
                author = threadData.getAuthor();
            }
            if (author != null && !StringUtils.isNull(author.getName_show()) && !StringUtils.isNull(author.getUserId())) {
                long g = eh.g(author.getUserId(), 0L);
                if (g == eh.g(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                    z = true;
                } else {
                    z = false;
                }
                if (threadData.getThreadVideoInfo() != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(g, z, author.isBigV(), z2, "topic_detail");
                createNormalConfig.setSourceTid(threadData.getTid());
                createNormalConfig.setSourceNid(threadData.getNid());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p16
    /* renamed from: x */
    public void l(k57 k57Var) {
        String name_show;
        String formatTime;
        int reply_num;
        AgreeData agreeData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, k57Var) == null) && k57Var != null && k57Var.b != null) {
            this.j = k57Var;
            m(this.i, TbadkCoreApplication.getInst().getSkinType());
            ThreadData threadData = this.j.b;
            PostData topAgreePost = threadData.getTopAgreePost();
            if (topAgreePost == null) {
                return;
            }
            this.k.setPlaceHolder(1);
            if (this.j.e == 1) {
                this.k.setData(threadData, false, true);
            } else {
                this.k.setData(threadData, false, false);
            }
            this.k.setIsRound(true);
            this.k.setBorderWidth(2);
            this.k.setDrawBorder(true);
            this.k.setPageId(this.i.getUniqueId());
            if (this.j.f) {
                this.m.setVisibility(0);
                int i = this.j.d;
                if (i == 1) {
                    this.m.setImageResource(R.drawable.label_topic_agree_red);
                    this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0301));
                } else if (i == 2) {
                    this.m.setImageResource(R.drawable.label_topic_disagree_blue);
                    this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0302));
                } else {
                    this.m.setImageResource(R.drawable.label_topic_eat_black);
                    this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0106));
                }
            } else {
                this.m.setVisibility(8);
            }
            if (this.j.e == 1) {
                name_show = topAgreePost.s().getName_show();
                formatTime = StringHelper.getFormatTime(topAgreePost.g0());
                reply_num = topAgreePost.c0();
            } else {
                name_show = threadData.getAuthor().getName_show();
                formatTime = StringHelper.getFormatTime(threadData.getCreateTime());
                reply_num = threadData.getReply_num();
            }
            if (!StringUtils.isNull(name_show)) {
                this.l.setText(StringHelper.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
            }
            if (StringUtils.isNull(threadData.getForum_name())) {
                this.n.setText(formatTime);
            } else {
                this.n.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0490), StringHelper.cutChineseAndEnglishWithSuffix(threadData.getForum_name(), 10, StringHelper.STRING_MORE), formatTime));
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.obfuscated_res_0x7f080a2f, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            String numFormatOverWan = StringHelper.numFormatOverWan(reply_num);
            if (reply_num > 0) {
                this.p.setVisibility(0);
                this.p.setText(numFormatOverWan);
            } else {
                this.p.setText(this.i.getString(R.string.obfuscated_res_0x7f0f0086));
                this.p.setVisibility(0);
            }
            if (this.j.e == 1) {
                agreeData = topAgreePost.q();
                agreeData.objType = 1;
            } else {
                agreeData = threadData.getAgreeData();
                agreeData.objType = 3;
            }
            agreeData.threadId = threadData.getTid();
            this.o.setData(agreeData);
            this.o.setTopicId(String.valueOf(this.j.c));
            z(topAgreePost, threadData);
            y(k57Var, threadData);
            D(f());
        }
    }

    public final void y(k57 k57Var, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, k57Var, threadData) == null) {
            if (this.j.e == 1) {
                this.u.setVisibility(0);
                this.t.setVisibility(8);
                String title = threadData.getTitle();
                if (StringUtils.isNull(title)) {
                    this.u.setVisibility(8);
                    return;
                }
                this.u.setVisibility(0);
                this.w.setText(title);
                String str = null;
                if (ListUtils.getCount(threadData.getMedias()) != 0 && !ListUtils.isEmpty(k57Var.b.getMedias())) {
                    Iterator<MediaData> it = k57Var.b.getMedias().iterator();
                    while (it.hasNext()) {
                        MediaData next = it.next();
                        if (next != null && next.getType() == 3) {
                            str = next.getPicUrl();
                            if (StringUtils.isNull(str)) {
                                str = next.getSmallUrl();
                            }
                            if (StringUtils.isNull(str)) {
                                str = next.getThumbnails_url();
                            }
                            if (StringUtils.isNull(str)) {
                                str = next.getSrc_pic();
                            }
                            if (!StringUtils.isNull(str)) {
                                break;
                            }
                        }
                    }
                }
                if (StringUtils.isNull(str)) {
                    SkinManager.setImageResource(this.v, R.drawable.pic_frs_topic_shareinone);
                    return;
                }
                this.v.setPlaceHolder(1);
                this.v.L(str, 10, false);
                return;
            }
            this.u.setVisibility(8);
            this.t.setVisibility(0);
            C(k57Var);
        }
    }

    public final void z(PostData postData, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, postData, threadData) == null) {
            if (this.j.e == 1) {
                this.r.setVisibility(0);
                this.r.setText(postData.X());
                return;
            }
            List<PbContent> firstFloorList = threadData.getFirstFloorList();
            if (ListUtils.getCount(firstFloorList) > 0) {
                this.r.setVisibility(0);
                this.r.setText(TbRichTextView.Y(firstFloorList, false, threadData));
                return;
            }
            SpannableString parseAbstract = threadData.parseAbstract();
            if (parseAbstract != null && !StringUtils.isNull(parseAbstract.toString())) {
                this.r.setVisibility(0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "0");
                    jSONObject.put("text", parseAbstract);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                this.r.setText(TbRichTextView.U(jSONArray, false));
                return;
            }
            this.r.setVisibility(8);
        }
    }
}
