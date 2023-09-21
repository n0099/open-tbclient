package com.baidu.tieba.im.widget.sharecard;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.e26;
import com.baidu.tieba.im.data.ShareForumMsgData;
import com.baidu.tieba.im.data.ShareThreadMsgData;
import com.baidu.tieba.im.db.pojo.MediaPojo;
import com.baidu.tieba.im.db.pojo.PbContentPojo;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.to8;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class ChatShareCard extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int c0;
    public static final int d0;
    public static final int e0;
    public static final int f0;
    public static final int g0;
    public static final int h0;
    public static final int i0;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public RelativeLayout C;
    public RelativeLayout D;
    public TbImageView E;
    public TbImageView F;
    public TbImageView G;
    public TbImageView H;
    public TbImageView I;
    public TbImageView J;
    public TbImageView K;
    public ImageView L;
    public TextView M;
    public TextView N;
    public TextView O;
    public PlayVoiceBntNew P;
    public PlayVoiceBntNew Q;
    public TextView R;
    public ShareThreadMsgData S;

    /* renamed from: T  reason: collision with root package name */
    public ShareForumMsgData f1115T;
    public short U;
    public int V;
    public long W;
    public short a;
    public long a0;
    public LinearLayout b;
    public String b0;
    public BarImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public LinearLayout g;
    public BarImageView h;
    public HeadPendantClickableView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public RelativeLayout m;
    public RelativeLayout n;
    public TbImageView o;
    public TbImageView p;
    public TbImageView q;
    public TbImageView r;
    public TbImageView s;
    public TbImageView t;
    public TbImageView u;
    public ImageView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public FrameLayout z;

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(998952338, "Lcom/baidu/tieba/im/widget/sharecard/ChatShareCard;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(998952338, "Lcom/baidu/tieba/im/widget/sharecard/ChatShareCard;");
                return;
            }
        }
        c0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1);
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        d0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
        e0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds595);
        f0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds540);
        g0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1);
        h0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds340);
        i0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds548);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChatShareCard(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final List<String> h(List<MediaPojo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                for (MediaPojo mediaPojo : list) {
                    arrayList.add(mediaPojo.M());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final List<PbContentPojo> j(ShareThreadMsgData shareThreadMsgData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, shareThreadMsgData)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(shareThreadMsgData.getRich_abstract())) {
                for (PbContentPojo pbContentPojo : shareThreadMsgData.getRich_abstract()) {
                    if (!StringUtils.isNull(pbContentPojo.link)) {
                        arrayList.add(pbContentPojo);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final boolean r(ShareThreadMsgData shareThreadMsgData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, shareThreadMsgData)) == null) {
            if (!ListUtils.isEmpty(shareThreadMsgData.getRich_abstract())) {
                for (PbContentPojo pbContentPojo : shareThreadMsgData.getRich_abstract()) {
                    if (!StringUtils.isNull(pbContentPojo.link)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatShareCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        q();
    }

    public final void o(PlayVoiceBntNew playVoiceBntNew, ShareThreadMsgData shareThreadMsgData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, playVoiceBntNew, shareThreadMsgData) == null) && shareThreadMsgData != null) {
            if (shareThreadMsgData.getDuring_time() > 0) {
                VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                voiceModel.setDuration(shareThreadMsgData.getDuring_time() / 1000);
                playVoiceBntNew.setVisibility(0);
                playVoiceBntNew.setVoiceModel(voiceModel);
                playVoiceBntNew.setTag(voiceModel);
                playVoiceBntNew.b();
                playVoiceBntNew.l();
                return;
            }
            playVoiceBntNew.setVisibility(8);
        }
    }

    private void setStrokeWith(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, tbImageView) == null) {
            tbImageView.setBorderWidth(g0);
            tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
        }
    }

    public final boolean i(MediaPojo mediaPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaPojo)) == null) {
            if (mediaPojo == null || mediaPojo.width > mediaPojo.height) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final short n(ShareThreadMsgData shareThreadMsgData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, shareThreadMsgData)) == null) {
            int thread_type = shareThreadMsgData.getThread_type();
            if (thread_type == 40) {
                return (short) 2;
            }
            if (thread_type != 8 && !shareThreadMsgData.isIs_share_thread()) {
                return (short) 1;
            }
            return (short) 3;
        }
        return invokeL.shortValue;
    }

    public void setChatRoomId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.W = j;
        }
    }

    public void setCurrentCardType(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Short.valueOf(s)}) == null) {
            this.a = s;
        }
    }

    public void setFid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            this.a0 = j;
        }
    }

    public void setFname(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.b0 = str;
        }
    }

    public final boolean t(ShareThreadMsgData shareThreadMsgData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, shareThreadMsgData)) == null) {
            if (shareThreadMsgData.getDuring_time() != 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void a(OrmObject ormObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, ormObject) != null) || ormObject == null) {
            return;
        }
        short s = this.a;
        if (s != 32) {
            if (s == 33) {
                this.g.setVisibility(8);
                this.b.setVisibility(0);
                if (ormObject instanceof ShareForumMsgData) {
                    ShareForumMsgData shareForumMsgData = (ShareForumMsgData) ormObject;
                    this.f1115T = shareForumMsgData;
                    b(shareForumMsgData);
                    return;
                }
                return;
            }
            return;
        }
        this.g.setVisibility(0);
        this.b.setVisibility(8);
        p();
        if (ormObject instanceof ShareThreadMsgData) {
            ShareThreadMsgData shareThreadMsgData = (ShareThreadMsgData) ormObject;
            this.S = shareThreadMsgData;
            short n = n(shareThreadMsgData);
            this.U = n;
            if (n == 1) {
                c(shareThreadMsgData);
            } else if (n == 2) {
                e(shareThreadMsgData);
            } else if (n == 3) {
                d(shareThreadMsgData);
            }
        }
    }

    public final void c(ShareThreadMsgData shareThreadMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareThreadMsgData) == null) {
            m(shareThreadMsgData);
            k(this.l, this.k, shareThreadMsgData, e0, true, false, true);
            if (shareThreadMsgData.getMedia_list() != null && shareThreadMsgData.getMedia_list().size() > 0) {
                this.m.setVisibility(0);
                this.n.setVisibility(8);
                this.z.setVisibility(8);
                f(shareThreadMsgData.getMedia_list(), new TbImageView[]{this.o, this.p, this.q, this.r, this.s}, this.y);
            } else {
                this.m.setVisibility(8);
            }
            o(this.Q, shareThreadMsgData);
            l(shareThreadMsgData);
        }
    }

    public final void e(ShareThreadMsgData shareThreadMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, shareThreadMsgData) == null) {
            m(shareThreadMsgData);
            k(this.l, this.k, shareThreadMsgData, e0, false, false, true);
            if (!StringUtils.isNull(shareThreadMsgData.getThumbnail_url())) {
                this.m.setVisibility(0);
                this.n.setVisibility(0);
                this.z.setVisibility(8);
                this.p.setVisibility(8);
                this.o.setVisibility(8);
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                this.s.setVisibility(8);
                g(shareThreadMsgData, this.n, new TbImageView[]{this.t, this.u}, this.v, this.x, this.w);
            } else {
                this.m.setVisibility(8);
            }
            o(this.Q, shareThreadMsgData);
            l(shareThreadMsgData);
        }
    }

    public final void m(ShareThreadMsgData shareThreadMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, shareThreadMsgData) == null) {
            if (!StringUtils.isNull(shareThreadMsgData.getForum_avatar())) {
                this.i.setVisibility(8);
                this.h.setVisibility(0);
                this.h.startLoad(shareThreadMsgData.getForum_avatar(), 10, false);
                this.j.setText(shareThreadMsgData.getForum_name() + getContext().getString(R.string.obfuscated_res_0x7f0f077f));
                return;
            }
            this.i.setVisibility(0);
            this.h.setVisibility(8);
            this.i.k(shareThreadMsgData.getAuthor_portrait(), 12, false);
            this.j.setText(shareThreadMsgData.getAuthor_name_show());
        }
    }

    public final void b(ShareForumMsgData shareForumMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareForumMsgData) == null) {
            this.d.setText(shareForumMsgData.getForum_name() + getContext().getString(R.string.obfuscated_res_0x7f0f077f));
            if (!StringUtils.isNull(shareForumMsgData.getSlogan())) {
                this.e.setVisibility(0);
                this.e.setText(String.format(getContext().getString(R.string.forum_slogan), shareForumMsgData.getSlogan()));
            } else {
                this.e.setVisibility(8);
            }
            this.f.setText(String.format(getContext().getString(R.string.attention_and_post), StringHelper.numberUniformFormatExtraWithRoundInt(shareForumMsgData.getMember_count()), StringHelper.numberUniformFormatExtraWithRoundInt(shareForumMsgData.getThread_count())));
            this.c.startLoad(shareForumMsgData.getAvatar(), 10, false);
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            if (!StringUtils.isNull(str) && str.endsWith("MsgleftView")) {
                SkinManager.setBackgroundResource(this, R.drawable.icon_pic_im_bubble_share_left);
            } else if (!StringUtils.isNull(str) && str.endsWith("MsgrightView")) {
                SkinManager.setBackgroundResource(this, R.drawable.icon_pic_im_bubble_share_right);
            }
            EMManager.from(this.d).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.e).setTextColor(R.color.CAM_X0107);
            EMManager.from(this.f).setTextColor(R.color.CAM_X0109);
            EMManager.from(this.j).setTextColor(R.color.CAM_X0107);
            EMManager.from(this.R).setTextColor(R.color.CAM_X0109);
            EMManager.from(this.z).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0204);
            EMManager.from(this.y).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0607);
            EMManager.from(this.O).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0607);
        }
    }

    public final void d(ShareThreadMsgData shareThreadMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, shareThreadMsgData) == null) {
            m(shareThreadMsgData);
            k(this.l, this.k, shareThreadMsgData, e0, false, false, true);
            if (shareThreadMsgData.getOrigin_thread_info() != null) {
                this.m.setVisibility(8);
                this.z.setVisibility(0);
                ShareThreadMsgData origin_thread_info = shareThreadMsgData.getOrigin_thread_info();
                k(this.B, this.A, origin_thread_info, f0, false, true, false);
                if (n(origin_thread_info) == 2) {
                    if (!StringUtils.isNull(origin_thread_info.getThumbnail_url())) {
                        this.C.setVisibility(0);
                        this.D.setVisibility(0);
                        this.G.setVisibility(8);
                        this.H.setVisibility(8);
                        this.I.setVisibility(8);
                        this.J.setVisibility(8);
                        this.K.setVisibility(8);
                        g(origin_thread_info, this.D, new TbImageView[]{this.E, this.F}, this.L, this.N, this.M);
                    } else {
                        this.C.setVisibility(8);
                    }
                } else if (h(origin_thread_info.getMedia_list()).size() > 0) {
                    this.C.setVisibility(0);
                    this.D.setVisibility(8);
                    f(origin_thread_info.getMedia_list(), new TbImageView[]{this.G, this.H, this.I, this.J, this.K}, this.O);
                } else {
                    this.C.setVisibility(8);
                }
                o(this.P, origin_thread_info);
            }
            l(shareThreadMsgData);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            if (this.a == 32) {
                if (this.S != null) {
                    short s = this.U;
                    if (s != 1 && s != 3) {
                        if (s == 2) {
                            VideoItemData videoItemData = new VideoItemData();
                            videoItemData.thread_id = String.valueOf(this.S.getId());
                            VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(getContext(), Arrays.asList(videoItemData), 0, (Rect) null, "");
                            videoRecommentPlayActivityConfig.setVideoShowIndex(0);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
                        }
                    } else {
                        PbActivityConfig pbActivityConfig = new PbActivityConfig(getContext());
                        pbActivityConfig.createNormalCfg(String.valueOf(this.S.getId()), "", "", false);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                    }
                }
                to8.d("c15286", 1, this.V, this.a0, this.b0, this.W);
                return;
            }
            if (this.f1115T != null) {
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(getContext());
                frsActivityConfig.createNormalCfg(this.f1115T.getForum_name(), "");
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, frsActivityConfig));
            }
            to8.d("c15286", 2, this.V, this.a0, this.b0, this.W);
        }
    }

    public final void f(List<MediaPojo> list, TbImageView[] tbImageViewArr, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, list, tbImageViewArr, textView) == null) {
            List<String> h = h(list);
            int size = h.size();
            if (size == 1) {
                for (int i = 2; i < 5; i++) {
                    tbImageViewArr[i].setVisibility(8);
                }
                if (i((MediaPojo) ListUtils.getItem(list, 0))) {
                    tbImageViewArr[0].setVisibility(0);
                    tbImageViewArr[1].setVisibility(8);
                    tbImageViewArr[0].setRadiusById(R.string.J_X05);
                    tbImageViewArr[0].setConrers(15);
                    tbImageViewArr[0].setDrawCorner(true);
                    tbImageViewArr[0].setPlaceHolder(3);
                    tbImageViewArr[0].setLongIconSupport(true);
                    tbImageViewArr[0].setGifIconSupport(true);
                    tbImageViewArr[0].startLoad(h.get(0), 10, false);
                    return;
                }
                tbImageViewArr[0].setVisibility(8);
                tbImageViewArr[1].setVisibility(0);
                tbImageViewArr[1].setRadiusById(R.string.J_X05);
                tbImageViewArr[1].setConrers(15);
                tbImageViewArr[1].setDrawCorner(true);
                tbImageViewArr[1].setPlaceHolder(3);
                tbImageViewArr[1].setLongIconSupport(false);
                tbImageViewArr[1].setGifIconSupport(true);
                tbImageViewArr[1].startLoad(h.get(0), 10, false);
            } else if (size == 2) {
                tbImageViewArr[0].setVisibility(8);
                tbImageViewArr[1].setVisibility(8);
                tbImageViewArr[2].setVisibility(0);
                tbImageViewArr[3].setVisibility(0);
                tbImageViewArr[4].setVisibility(8);
                tbImageViewArr[2].setRadiusById(R.string.J_X05);
                tbImageViewArr[2].setConrers(5);
                tbImageViewArr[2].setDrawCorner(true);
                tbImageViewArr[2].setPlaceHolder(2);
                tbImageViewArr[2].startLoad(h.get(0), 10, false);
                tbImageViewArr[3].setDrawCorner(true);
                tbImageViewArr[3].setRadiusById(R.string.J_X05);
                tbImageViewArr[3].setConrers(10);
                tbImageViewArr[3].setPlaceHolder(2);
                tbImageViewArr[3].startLoad(h.get(1), 10, false);
            } else if (size >= 3) {
                for (int i2 = 0; i2 < 5; i2++) {
                    if (i2 < 2) {
                        tbImageViewArr[i2].setVisibility(8);
                    } else {
                        tbImageViewArr[i2].setVisibility(0);
                    }
                }
                tbImageViewArr[2].setRadiusById(R.string.J_X05);
                tbImageViewArr[2].setDrawCorner(true);
                tbImageViewArr[2].setConrers(5);
                tbImageViewArr[2].setPlaceHolder(2);
                tbImageViewArr[2].startLoad(h.get(0), 10, false);
                tbImageViewArr[3].setRadiusById(R.string.J_X02);
                tbImageViewArr[3].setDrawCorner(false);
                tbImageViewArr[3].setPlaceHolder(2);
                tbImageViewArr[3].startLoad(h.get(1), 10, false);
                tbImageViewArr[4].setRadiusById(R.string.J_X05);
                tbImageViewArr[4].setDrawCorner(true);
                tbImageViewArr[4].setConrers(10);
                tbImageViewArr[4].setPlaceHolder(2);
                tbImageViewArr[4].startLoad(h.get(2), 10, false);
                if (size > 3) {
                    tbImageViewArr[4].setGifIconSupport(false);
                    textView.setVisibility(0);
                    textView.setText(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + (size - 3));
                    return;
                }
                tbImageViewArr[4].setGifIconSupport(true);
                textView.setVisibility(8);
            }
        }
    }

    public final void g(ShareThreadMsgData shareThreadMsgData, RelativeLayout relativeLayout, TbImageView[] tbImageViewArr, ImageView imageView, TextView textView, TextView textView2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{shareThreadMsgData, relativeLayout, tbImageViewArr, imageView, textView, textView2}) == null) {
            String thumbnail_url = shareThreadMsgData.getThumbnail_url();
            if (shareThreadMsgData.getThumbnail_height() > shareThreadMsgData.getThumbnail_width()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.width = d0;
                layoutParams.height = i0;
                relativeLayout.setLayoutParams(layoutParams);
                tbImageViewArr[0].setVisibility(0);
                tbImageViewArr[1].setVisibility(8);
                tbImageViewArr[0].setConrers(15);
                tbImageViewArr[0].setRadiusById(R.string.J_X05);
                tbImageViewArr[0].setDrawCorner(true);
                tbImageViewArr[0].setPlaceHolder(3);
                tbImageViewArr[0].startLoad(thumbnail_url, 10, false);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = h0;
                relativeLayout.setLayoutParams(layoutParams2);
                tbImageViewArr[0].setVisibility(8);
                tbImageViewArr[1].setVisibility(0);
                tbImageViewArr[1].setConrers(15);
                tbImageViewArr[1].setRadiusById(R.string.J_X05);
                tbImageViewArr[1].setDrawCorner(true);
                tbImageViewArr[1].setPlaceHolder(3);
                tbImageViewArr[1].startLoad(thumbnail_url, 10, false);
            }
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            textView.setText(StringHelper.stringForVideoTime(shareThreadMsgData.getVideo_duration() * 1000));
            textView2.setText(String.format(getContext().getResources().getString(R.string.play_count_new), StringHelper.numFormatOverWan(shareThreadMsgData.getPlay_count())));
        }
    }

    public final void k(TextView textView, TextView textView2, ShareThreadMsgData shareThreadMsgData, int i, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{textView, textView2, shareThreadMsgData, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && shareThreadMsgData != null) {
            ThreadData threadData = new ThreadData();
            if (this.U == 2) {
                threadData.threadType = 40;
                threadData.setRichTitleList(ShareThreadMsgData.parseContent(shareThreadMsgData.getRich_title()));
                threadData.setTitle(shareThreadMsgData.title);
            } else {
                if (z && !t(shareThreadMsgData)) {
                    threadData.setTitle(shareThreadMsgData.title);
                }
                if (!StringUtils.isNull(e26.H(ShareThreadMsgData.parseContent(shareThreadMsgData.getRich_abstract())).toString())) {
                    if (r(shareThreadMsgData) && !t(shareThreadMsgData) && z3) {
                        threadData.setRichAbstractList(ShareThreadMsgData.parseContent(j(shareThreadMsgData)));
                    } else {
                        threadData.setRichAbstractList(ShareThreadMsgData.parseContent(shareThreadMsgData.getRich_abstract()));
                    }
                } else if (!ListUtils.isEmpty(shareThreadMsgData.getRich_title())) {
                    threadData.setRichTitleList(ShareThreadMsgData.parseContent(shareThreadMsgData.getRich_title()));
                    threadData.setTitle(shareThreadMsgData.title);
                } else {
                    threadData.setTitle(shareThreadMsgData.title);
                }
            }
            threadData.praserTimeConsumingInfo();
            ThreadCardUtils.setTitle(textView2, threadData, false);
            if (s(shareThreadMsgData, z2)) {
                ThreadCardUtils.setAbstract(textView, textView2, threadData, i, false, true);
            }
        }
    }

    public final void l(ShareThreadMsgData shareThreadMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, shareThreadMsgData) == null) {
            if (!StringUtils.isNull(shareThreadMsgData.getForum_avatar()) && !StringUtils.isNull(shareThreadMsgData.getAuthor_name_show())) {
                this.R.setVisibility(0);
                this.R.setText(String.format(getContext().getString(R.string.thread_come_from), shareThreadMsgData.getAuthor_name_show()));
                return;
            }
            this.R.setVisibility(8);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.s.setVisibility(8);
            this.t.setVisibility(8);
            this.u.setVisibility(8);
            this.y.setVisibility(8);
            this.z.setVisibility(8);
            this.A.setVisibility(8);
            this.B.setVisibility(8);
            this.C.setVisibility(8);
            this.D.setVisibility(8);
            this.E.setVisibility(8);
            this.F.setVisibility(8);
            this.G.setVisibility(8);
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            this.J.setVisibility(8);
            this.K.setVisibility(8);
            this.O.setVisibility(8);
            this.P.setVisibility(8);
            this.Q.setVisibility(8);
            this.R.setVisibility(8);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.layout_chat_share_card, (ViewGroup) this, true);
            setOnClickListener(this);
            this.b = (LinearLayout) findViewById(R.id.share_forum_container);
            BarImageView barImageView = (BarImageView) findViewById(R.id.img_forum);
            this.c = barImageView;
            barImageView.setShowOval(true);
            this.c.setStrokeWith(c0);
            this.c.setStrokeColorResId(R.color.CAM_X0401);
            this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.c.setPlaceHolder(1);
            this.d = (TextView) findViewById(R.id.forum_name);
            this.e = (TextView) findViewById(R.id.forum_abstract);
            this.f = (TextView) findViewById(R.id.forum_contern);
            this.g = (LinearLayout) findViewById(R.id.share_thread_container);
            BarImageView barImageView2 = (BarImageView) findViewById(R.id.img_forum_header);
            this.h = barImageView2;
            barImageView2.setShowOval(true);
            this.h.setStrokeWith(c0);
            this.h.setStrokeColorResId(R.color.CAM_X0401);
            this.h.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.h.setPlaceHolder(1);
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) findViewById(R.id.img_user_header);
            this.i = headPendantClickableView;
            headPendantClickableView.getHeadView().setIsRound(true);
            this.i.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.i.getHeadView().setDefaultResource(17170445);
            this.i.getHeadView().setPlaceHolder(1);
            this.i.setIsclearmode(true);
            this.j = (TextView) findViewById(R.id.thread_header_name);
            TextView textView = (TextView) findViewById(R.id.thread_title);
            this.k = textView;
            textView.setMaxLines(1);
            this.k.setEllipsize(TextUtils.TruncateAt.END);
            this.l = (TextView) findViewById(R.id.thread_content);
            this.m = (RelativeLayout) findViewById(R.id.thread_pic_layout);
            this.z = (FrameLayout) findViewById(R.id.thread_original);
            this.Q = (PlayVoiceBntNew) findViewById(R.id.thread_voice);
            this.R = (TextView) findViewById(R.id.thread_share_from);
            this.p = (TbImageView) findViewById(R.id.photo_h_thumbnail);
            this.o = (TbImageView) findViewById(R.id.photo_v_thumbnail);
            this.q = (TbImageView) findViewById(R.id.img_01);
            this.r = (TbImageView) findViewById(R.id.img_02);
            this.s = (TbImageView) findViewById(R.id.img_03);
            setStrokeWith(this.q);
            setStrokeWith(this.r);
            setStrokeWith(this.s);
            setStrokeWith(this.p);
            setStrokeWith(this.o);
            this.n = (RelativeLayout) findViewById(R.id.video_layout);
            this.t = (TbImageView) findViewById(R.id.video_v_thumbnail);
            this.u = (TbImageView) findViewById(R.id.video_h_thumbnail);
            setStrokeWith(this.t);
            setStrokeWith(this.u);
            this.v = (ImageView) findViewById(R.id.video_play);
            this.w = (TextView) findViewById(R.id.video_play_count);
            this.x = (TextView) findViewById(R.id.video_duration);
            this.y = (TextView) findViewById(R.id.img_num);
            TextView textView2 = (TextView) findViewById(R.id.original_thread_title);
            this.A = textView2;
            textView2.setMaxLines(1);
            this.A.setEllipsize(TextUtils.TruncateAt.END);
            this.B = (TextView) findViewById(R.id.original_thread_content);
            this.C = (RelativeLayout) findViewById(R.id.original_thread_pic_layout);
            this.D = (RelativeLayout) findViewById(R.id.original_video_layout);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.original_video_v_thumbnail);
            this.E = tbImageView;
            setStrokeWith(tbImageView);
            TbImageView tbImageView2 = (TbImageView) findViewById(R.id.original_video_h_thumbnail);
            this.F = tbImageView2;
            setStrokeWith(tbImageView2);
            TbImageView tbImageView3 = (TbImageView) findViewById(R.id.original_photo_h_thumbnail);
            this.H = tbImageView3;
            setStrokeWith(tbImageView3);
            TbImageView tbImageView4 = (TbImageView) findViewById(R.id.original_photo_v_thumbnail);
            this.G = tbImageView4;
            setStrokeWith(tbImageView4);
            TbImageView tbImageView5 = (TbImageView) findViewById(R.id.original_img_01);
            this.I = tbImageView5;
            setStrokeWith(tbImageView5);
            TbImageView tbImageView6 = (TbImageView) findViewById(R.id.original_img_02);
            this.J = tbImageView6;
            setStrokeWith(tbImageView6);
            TbImageView tbImageView7 = (TbImageView) findViewById(R.id.original_img_03);
            this.K = tbImageView7;
            setStrokeWith(tbImageView7);
            this.L = (ImageView) findViewById(R.id.original_video_play);
            this.M = (TextView) findViewById(R.id.original_video_play_count);
            this.N = (TextView) findViewById(R.id.original_video_duration);
            this.O = (TextView) findViewById(R.id.original_img_num);
            this.P = (PlayVoiceBntNew) findViewById(R.id.original_thread_voice);
            u("");
        }
    }

    public final boolean s(ShareThreadMsgData shareThreadMsgData, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048596, this, shareThreadMsgData, z)) == null) {
            if (this.U != 2 && !r(shareThreadMsgData) && shareThreadMsgData.getDuring_time() == 0 && !shareThreadMsgData.isIs_share_thread() && !z) {
                return false;
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }
}
