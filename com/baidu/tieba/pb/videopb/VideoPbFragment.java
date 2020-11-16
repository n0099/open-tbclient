package com.baidu.tieba.pb.videopb;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.arch.lifecycle.q;
import android.arch.lifecycle.y;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.media.ExifInterface;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tbadk.widget.richText.h;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.g.b;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.bb;
import com.baidu.tieba.pb.pb.main.be;
import com.baidu.tieba.pb.pb.main.v;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import java.io.Serializable;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes21.dex */
public class VideoPbFragment extends BaseFragment implements VoiceManager.c, TbRichTextView.c, h, com.baidu.tieba.pb.videopb.a, b {
    private AppBarLayout Ym;
    private EditorTools abp;
    private ImageView agU;
    private CustomViewPager eKk;
    private com.baidu.adp.lib.d.b<ImageView> fFn;
    private com.baidu.adp.lib.d.b<GifView> fFo;
    private com.baidu.adp.lib.d.b<TextView> fIE;
    private com.baidu.adp.lib.d.b<View> fIF;
    private com.baidu.adp.lib.d.b<LinearLayout> fIG;
    private com.baidu.adp.lib.d.b<RelativeLayout> fIH;
    public View fwY;
    private ImageView gFi;
    private com.baidu.tieba.callfans.a hZs;
    private VoiceManager iIc;
    private com.baidu.tieba.g.b iMX;
    private com.baidu.tieba.frs.profession.permission.c iMx;
    public am kwi;
    public bb kzS;
    private View lBK;
    private v lCK;
    private View lCb;
    private LinearLayout lCd;
    private HeadImageView lCe;
    private ImageView lCf;
    private ImageView lCg;
    private ImageView lCh;
    private com.baidu.tieba.pb.view.c lCi;
    private TextView lCj;
    private TextView lCk;
    private int lCm;
    private int lCn;
    private String lDb;
    public View lHG;
    private ValueAnimator lMA;
    public com.baidu.tieba.pb.videopb.b.a lMB;
    private float lMF;
    private float lMG;
    private boolean lMH;
    private ObjectAnimator lML;
    private ObjectAnimator lMM;
    private NewPagerSlidingTabBaseStrip lMj;
    private VideoPbFragmentAdapter lMk;
    private View lMl;
    private View lMm;
    private VideoContainerLayout lMn;
    private com.baidu.tieba.pb.videopb.videoView.a lMo;
    private f lMp;
    private View lMq;
    private View lMr;
    private TextView lMt;
    private TextView lMu;
    private ImageView lMv;
    private TBSpecificationBtn lMw;
    private TbImageView lMx;
    private View lMy;
    private ValueAnimator lMz;
    private com.baidu.tieba.pb.videopb.c.a lnU;
    private PbActivity ltC;
    private com.baidu.tieba.pb.pb.main.emotion.model.a ltU;
    int ltX;
    private PbFakeFloorModel ltx;
    private com.baidu.tbadk.core.view.c luA;
    private g lus;
    private com.baidu.tbadk.editortools.pb.e lut;
    private com.baidu.tieba.frs.profession.permission.c luv;
    private EmotionImageData luw;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int lMf = 0;
    public static int lMg = 1;
    public static int lMh = 0;
    public static int lCC = 3;
    public static int lCD = 0;
    public static int lCE = 3;
    public static int lCF = 4;
    public static int lCG = 5;
    public static int lCH = 6;
    private static final int jHw = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int lMi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a lvt = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.g.b.a
        public void cI(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.diL();
            } else {
                com.baidu.tieba.pb.a.b.diK();
            }
        }
    };
    private long ltJ = 0;
    private boolean ltQ = false;
    View.OnClickListener lMs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.lnU == null || VideoPbFragment.this.lnU.drC()) {
                if (VideoPbFragment.this.lnU != null) {
                    if (VideoPbFragment.this.lnU.isChushou) {
                        VideoPbFragment.this.eC(VideoPbFragment.this.lnU.thirdRoomId, VideoPbFragment.this.lnU.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.lnU.drD();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null && VideoPbFragment.this.diV().getPbData().getForum() != null) {
                        TiebaStatic.log(new ar("c13713").dR("fid", VideoPbFragment.this.diV().getPbData().getForum().getId()).dR("fname", VideoPbFragment.this.diV().getPbData().getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.diV().getPbData().getThreadId()).w("obj_param1", VideoPbFragment.this.lnU.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new ar("c13590").dR("obj_id", VideoPbFragment.this.lnU.getTitle()).dR("obj_name", VideoPbFragment.this.lnU.drz()).ak("obj_type", 2).dR("fid", VideoPbFragment.this.diV().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.diV().getPbData().getThreadId()));
            String link = VideoPbFragment.this.lnU.getLink();
            if (!TextUtils.isEmpty(link)) {
                if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                    bf.bqF().b(VideoPbFragment.this.getPageContext(), new String[]{link});
                    return;
                }
                Uri parse = Uri.parse(link);
                if (parse != null) {
                    UtilHelper.dealOneScheme(VideoPbFragment.this.getActivity(), parse.toString());
                }
            }
        }
    };
    private boolean mIsLoading = false;
    private com.baidu.tbadk.baseEditMark.a luf = null;
    private com.baidu.tbadk.coreExtra.model.a eMq = null;
    private ForumManageModel hZq = null;
    private boolean ltN = false;
    private View lCc = null;
    private TextView jKO = null;
    private boolean lBY = false;
    private String foT = null;
    private boolean lui = false;
    private boolean luj = false;
    private boolean luk = false;
    private boolean ltP = false;
    int[] ltW = new int[2];
    private int ltY = -1;
    private int ltZ = Integer.MIN_VALUE;
    private int luG = 0;
    private int lMD = Integer.MIN_VALUE;
    private boolean bDs = false;
    private boolean lrD = com.baidu.tbadk.a.d.bhn();
    private final PbModel.a lvj = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h rF;
            VideoPbFragment.this.dni();
            VideoPbFragment.this.cSZ();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.uV(false);
            if (z && fVar != null) {
                bx dhH = fVar.dhH();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(fVar, i2);
                VideoPbFragment.this.L(fVar);
                com.baidu.tieba.pb.videopb.c.a dim = fVar.dim();
                if (dim != null && !dim.lOC) {
                    VideoPbFragment.this.a(dim);
                }
                VideoPbFragment.this.M(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.luf != null) {
                    VideoPbFragment.this.luf.is(fVar.bhP());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.foT = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.foT) && VideoPbFragment.this.lut != null && VideoPbFragment.this.lut.byN() != null && (rF = VideoPbFragment.this.lut.byN().rF(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.foT)) {
                        ((View) rF).setOnClickListener(VideoPbFragment.this.fpG);
                    }
                }
                if (VideoPbFragment.this.kwi != null && dhH != null && dhH.blC() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(dhH.blC());
                    VideoPbFragment.this.kwi.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.diV().dkU());
                        jSONObject.put("fid", VideoPbFragment.this.diV().getForumId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB, jSONObject));
                }
                if (i != 0) {
                    k kVar = new k();
                    kVar.setOpType("2");
                    kVar.start();
                }
                if ((!com.baidu.tbadk.a.d.bhp() || VideoPbFragment.this.dqD() != null) && VideoPbFragment.this.dqB() != null) {
                    if (com.baidu.tbadk.a.d.bhp()) {
                        if (i != -1) {
                            ArrayList<PostData> arrayList = null;
                            if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null) {
                                arrayList = VideoPbFragment.this.diV().getPbData().dhJ();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dJQ() == 1)) {
                                if (VideoPbFragment.this.dqD().dku()) {
                                    VideoPbFragment.this.dqD().Pk(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dqD().Pk(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dqD().Pj(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dqD().Pj("");
                        }
                        VideoPbFragment.this.dqD().endLoadData();
                    } else {
                        if (i != -1) {
                            ArrayList<PostData> arrayList2 = null;
                            if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null) {
                                arrayList2 = VideoPbFragment.this.diV().getPbData().dhJ();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 1 && arrayList2.get(0) != null && arrayList2.get(0).dJQ() == 1)) {
                                if (VideoPbFragment.this.dqB().dku()) {
                                    VideoPbFragment.this.dqB().Pk(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dqB().Pk(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dqB().Pj(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dqB().Pj("");
                        }
                        VideoPbFragment.this.dqB().endLoadData();
                    }
                } else {
                    return;
                }
            }
            com.baidu.tieba.t.c.dIO().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0571a lvl = new a.InterfaceC0571a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0571a
        public void d(boolean z, boolean z2, String str) {
            VideoPbFragment.this.dni();
            if (z && VideoPbFragment.this.diV() != null) {
                if (VideoPbFragment.this.luf != null) {
                    VideoPbFragment.this.luf.is(z2);
                }
                VideoPbFragment.this.diV().uA(z2);
                if (VideoPbFragment.this.diV().bhP()) {
                    VideoPbFragment.this.dkf();
                } else if (com.baidu.tbadk.a.d.bhp() && VideoPbFragment.this.dqD() != null) {
                    VideoPbFragment.this.dqD().drm();
                } else if (VideoPbFragment.this.dqB() != null) {
                    VideoPbFragment.this.dqB().drm();
                }
                if (z2) {
                    if (VideoPbFragment.this.luf != null) {
                        if (VideoPbFragment.this.luf.bhS() != null && VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null && VideoPbFragment.this.diV().getPbData().dhH() != null && VideoPbFragment.this.diV().getPbData().dhH().blC() != null) {
                            MarkData bhS = VideoPbFragment.this.luf.bhS();
                            MetaData blC = VideoPbFragment.this.diV().getPbData().dhH().blC();
                            if (bhS != null && blC != null) {
                                if (!au.equals(TbadkCoreApplication.getCurrentAccount(), blC.getUserId()) && !blC.hadConcerned()) {
                                    VideoPbFragment.this.lMB.b(blC);
                                } else {
                                    VideoPbFragment.this.showToast(R.string.add_mark_on_pb);
                                }
                            } else {
                                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.add_mark));
                            }
                        } else {
                            return;
                        }
                    }
                    VideoPbFragment.this.dkc();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b foX = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bzr() {
            if (VideoPbFragment.this.kzS == null || VideoPbFragment.this.kzS.dob() == null || !VideoPbFragment.this.kzS.dob().dSU()) {
                return !VideoPbFragment.this.Gn(am.eMl);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kzS.dob().dSW());
            if (VideoPbFragment.this.lut != null && (VideoPbFragment.this.lut.bzI() || VideoPbFragment.this.lut.bzJ())) {
                VideoPbFragment.this.lut.a(false, VideoPbFragment.this.kzS.doe());
            }
            VideoPbFragment.this.kzS.vb(true);
            return true;
        }
    };
    private final CustomMessageListener luN = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.diV() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.lut != null) {
                    VideoPbFragment.this.uT(VideoPbFragment.this.lut.bzB());
                }
                VideoPbFragment.this.dmK();
                VideoPbFragment.this.lMB.dnA();
            }
        }
    };
    private CustomMessageListener luQ = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        VideoPbFragment.this.b((p) eVar.getData());
                        return;
                    case 1:
                        VideoPbFragment.this.a((ForumManageModel.b) eVar.getData(), false);
                        return;
                    case 2:
                        if (eVar.getData() == null) {
                            VideoPbFragment.this.a(false, (MarkData) null);
                            return;
                        } else {
                            VideoPbFragment.this.a(true, (MarkData) eVar.getData());
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private final CustomMessageListener iJE = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.bDs) {
                VideoPbFragment.this.dkx();
            }
        }
    };
    private CustomMessageListener lvk = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.64
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.djW();
            }
        }
    };
    private CustomMessageListener lvc = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.lMB != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.lMB.luB) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.lMB.cgz();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.lMB.getExtra();
                DataRes dataRes = aVar.nmH;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (au.isEmpty(str)) {
                        sparseArray.put(R.id.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.tag_user_mute_msg, str);
                    }
                    sparseArray.put(R.id.tag_user_mute_visible, true);
                    z = z2;
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, false);
                }
                int intValue = ((Integer) sparseArray.get(R.id.tag_from)).intValue();
                if (intValue == 0) {
                    VideoPbFragment.this.lMB.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.lMB.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener lva = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.lMB != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.lMB.luB) {
                VideoPbFragment.this.lMB.cgz();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.diV().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dhX().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.luA.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.lMB.Ds(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.lMB.dkt();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (au.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.luA.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lvb = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.lMB != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.lMB.luB) {
                VideoPbFragment.this.lMB.cgz();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.luA.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (au.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.luA.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b luy = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bzr() {
            if (VideoPbFragment.this.kzS == null || VideoPbFragment.this.kzS.doc() == null || !VideoPbFragment.this.kzS.doc().dSU()) {
                return !VideoPbFragment.this.Gn(am.eMm);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kzS.doc().dSW());
            if (VideoPbFragment.this.lCK != null && VideoPbFragment.this.lCK.djG() != null && VideoPbFragment.this.lCK.djG().bzJ()) {
                VideoPbFragment.this.lCK.djG().a(VideoPbFragment.this.kzS.doe());
            }
            VideoPbFragment.this.kzS.vc(true);
            return true;
        }
    };
    private final NewWriteModel.d fpd = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                ar arVar = new ar("c13268");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null) {
                    arVar.dR("fid", VideoPbFragment.this.diV().getPbData().getForumId());
                }
                arVar.dR("tid", VideoPbFragment.this.diV().dkU());
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            VideoPbFragment.this.cyn();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.diV() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.diV().Pe(postWriteCallBackData.getPostId());
                    if (com.baidu.tbadk.a.d.bhp() && VideoPbFragment.this.dqD() != null) {
                        VideoPbFragment.this.luG = VideoPbFragment.this.dqD().dnk();
                        VideoPbFragment.this.lMD = VideoPbFragment.this.dqD().drp();
                        VideoPbFragment.this.diV().db(VideoPbFragment.this.luG, VideoPbFragment.this.lMD);
                    } else if (VideoPbFragment.this.dqB() != null) {
                        VideoPbFragment.this.luG = VideoPbFragment.this.dqB().dnk();
                        VideoPbFragment.this.lMD = VideoPbFragment.this.dqB().drp();
                        VideoPbFragment.this.diV().db(VideoPbFragment.this.luG, VideoPbFragment.this.lMD);
                    }
                }
                if (VideoPbFragment.this.eKk != null) {
                    if (com.baidu.tbadk.a.d.bhp()) {
                        VideoPbFragment.this.eKk.setCurrentItem(VideoPbFragment.lMh);
                    } else {
                        VideoPbFragment.this.eKk.setCurrentItem(VideoPbFragment.lMg);
                    }
                }
                VideoPbFragment.this.lMB.dnA();
                VideoPbFragment.this.kzS.doa();
                if (VideoPbFragment.this.lut != null) {
                    VideoPbFragment.this.uT(VideoPbFragment.this.lut.bzB());
                }
                VideoPbFragment.this.dmG();
                VideoPbFragment.this.uV(true);
                VideoPbFragment.this.diV().dlp();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (com.baidu.tbadk.a.d.bhp() && VideoPbFragment.this.dqD() != null) {
                                VideoPbFragment.this.dqD().drm();
                            } else if (VideoPbFragment.this.dqB() != null) {
                                VideoPbFragment.this.dqB().drm();
                            }
                        }
                    } else if (VideoPbFragment.this.diV().getHostMode()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.diV().getPbData();
                        if (pbData != null && pbData.dhH() != null && pbData.dhH().blC() != null && (userId = pbData.dhH().blC().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.diV().dlg()) {
                            VideoPbFragment.this.dng();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.diV().dlg()) {
                        VideoPbFragment.this.dng();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.ul(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.lut.bzI() || VideoPbFragment.this.lut.bzJ()) {
                    VideoPbFragment.this.lut.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.kzS.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.kwi != null) {
                    VideoPbFragment.this.kwi.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.AJ(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AJ(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(VideoPbFragment.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new ar("c13746").ak("obj_locate", 1).ak("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bog();
                TiebaStatic.log(new ar("c13745").ak("obj_locate", 1).ak("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener fpG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.foT);
        }
    };
    private CustomMessageListener luP = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.lut != null) {
                    VideoPbFragment.this.uT(VideoPbFragment.this.lut.bzB());
                }
                VideoPbFragment.this.uV(false);
            }
        }
    };
    private int lME = 0;
    private boolean lMI = true;
    private View.OnTouchListener lMJ = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.lME == 1) {
                if (!VideoPbFragment.this.lMI) {
                    VideoPbFragment.this.dqG();
                    UtilHelper.showStatusBar(VideoPbFragment.this.dkB(), VideoPbFragment.this.dkB().getRootView());
                    VideoPbFragment.this.lMI = true;
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(VideoPbFragment.this.lMK);
                    com.baidu.adp.lib.f.e.mY().postDelayed(VideoPbFragment.this.lMK, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (VideoPbFragment.this.lME == 2 && (VideoPbFragment.this.lMI || VideoPbFragment.this.dqI())) {
                VideoPbFragment.this.dqH();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dkB(), VideoPbFragment.this.dkB().getRootView());
                VideoPbFragment.this.lMI = false;
                if (VideoPbFragment.this.lMo != null) {
                    VideoPbFragment.this.lMo.vx(false);
                }
            }
            VideoPbFragment.this.lME = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener iUc = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.lME = 0;
            VideoPbFragment.this.lMF = 0.0f;
            VideoPbFragment.this.lMG = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.lMF += f;
            VideoPbFragment.this.lMG += f2;
            if (VideoPbFragment.this.lME == 0 && !VideoPbFragment.this.lMH && VideoPbFragment.this.lMo != null && !VideoPbFragment.this.lMo.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.lMG) <= Math.abs(VideoPbFragment.this.lMF) || VideoPbFragment.this.lMG > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.lMG) > Math.abs(VideoPbFragment.this.lMF) && VideoPbFragment.this.lMG > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.lME = 2;
                    }
                } else {
                    VideoPbFragment.this.lME = 1;
                }
            }
            return true;
        }
    };
    private Runnable lMK = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.lMI && !VideoPbFragment.this.dqI()) {
                VideoPbFragment.this.dqH();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dkB(), VideoPbFragment.this.dkB().getRootView());
                VideoPbFragment.this.lMI = false;
            }
        }
    };
    private final com.baidu.adp.base.d hZx = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.diV() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.hZq.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.hZq.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.diV().dlp();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.lJC != 1002 || bVar.gQe) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.QR, dVar.naF, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.hZq.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.hZq.getLoadDataMode(), gVar.QR, gVar.naF, false);
                    VideoPbFragment.this.lMB.bd(gVar.naI);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener fyo = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.iMX.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d lvh = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                ar arVar = new ar("c13268");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null) {
                    arVar.dR("fid", VideoPbFragment.this.diV().getPbData().getForumId());
                }
                if (VideoPbFragment.this.diV() != null) {
                    arVar.dR("tid", VideoPbFragment.this.diV().dkU());
                }
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            if (z) {
                if (VideoPbFragment.this.kzS != null) {
                    VideoPbFragment.this.kzS.dnZ();
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(VideoPbFragment.this.getPageContext(), postWriteCallBackData);
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.kwi != null) {
                    VideoPbFragment.this.kwi.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.AJ(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AJ(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(VideoPbFragment.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new ar("c13746").ak("obj_locate", 1).ak("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bog();
                TiebaStatic.log(new ar("c13745").ak("obj_locate", 1).ak("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.kzS != null) {
                if (VideoPbFragment.this.lCK != null && VideoPbFragment.this.lCK.djG() != null && VideoPbFragment.this.lCK.djG().bzJ()) {
                    VideoPbFragment.this.lCK.djG().a(postWriteCallBackData);
                }
                VideoPbFragment.this.kzS.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c foW = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bzs() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener aEk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        /* JADX DEBUG: Multi-variable search result rejected for r1v149, resolved type: com.baidu.tieba.pb.videopb.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray sparseArray;
            boolean C;
            int i = 2;
            int i2 = 3;
            int i3 = 1;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    ar arVar = new ar("c13398");
                    arVar.dR("tid", VideoPbFragment.this.diV().dkU());
                    arVar.dR("fid", VideoPbFragment.this.diV().getForumId());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.ak("obj_locate", 1);
                    TiebaStatic.log(arVar);
                    if (VideoPbFragment.this.ltN) {
                        VideoPbFragment.this.ltN = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null && VideoPbFragment.this.ltx != null && postData.blC() != null && postData.dJQ() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.lCK != null) {
                                    VideoPbFragment.this.lCK.djC();
                                }
                                p pVar = new p();
                                pVar.a(VideoPbFragment.this.diV().getPbData().getForum());
                                pVar.setThreadData(VideoPbFragment.this.diV().getPbData().dhH());
                                pVar.g(postData);
                                VideoPbFragment.this.ltx.d(pVar);
                                VideoPbFragment.this.ltx.setPostId(postData.getId());
                                VideoPbFragment.this.a(view, postData.blC().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.diV().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.lut != null) {
                                    VideoPbFragment.this.uT(VideoPbFragment.this.lut.bzB());
                                }
                            }
                        }
                    }
                } else if ((VideoPbFragment.this.dqB() != null && VideoPbFragment.this.dqB().dnw() != null && view == VideoPbFragment.this.dqB().dnw()) || ((com.baidu.tbadk.a.d.bhp() && VideoPbFragment.this.dqD() != null && VideoPbFragment.this.dqD().dnw() != null && view == VideoPbFragment.this.dqD().dnw()) || view.getId() == R.id.pb_more)) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.diV().uy(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        if (com.baidu.tbadk.a.d.bhp()) {
                            VideoPbFragment.this.dqD().dnh();
                        } else {
                            VideoPbFragment.this.dqB().dnh();
                        }
                    }
                } else if (VideoPbFragment.this.lMB != null && VideoPbFragment.this.lMB.doH() != null && view == VideoPbFragment.this.lMB.doH().dme()) {
                    VideoPbFragment.this.lMB.aYV();
                } else if ((VideoPbFragment.this.lMB != null && ((VideoPbFragment.this.lMB.doH() != null && view == VideoPbFragment.this.lMB.doH().dmf()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) || view.getId() == R.id.floor_owner_reply || view.getId() == R.id.reply_title) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.lMB.dnA();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.cyn();
                        VideoPbFragment.this.dng();
                        if (view.getId() == R.id.owner_reply) {
                            C = VideoPbFragment.this.diV().C(true, VideoPbFragment.this.dkj());
                        } else {
                            C = view.getId() == R.id.all_reply ? VideoPbFragment.this.diV().C(false, VideoPbFragment.this.dkj()) : VideoPbFragment.this.diV().Pb(VideoPbFragment.this.dkj());
                        }
                        view.setTag(Boolean.valueOf(C));
                        if (C) {
                            VideoPbFragment.this.cTa();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.fwY) {
                    if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null) {
                        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            ar arVar2 = new ar("c13266");
                            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                            arVar2.dR("fid", VideoPbFragment.this.diV().getPbData().getForumId());
                            arVar2.dR("tid", VideoPbFragment.this.diV().dkU());
                            arVar2.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(arVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.ltC, VideoPbFragment.this.fwY);
                        VideoPbFragment.this.ltC.finish();
                    }
                } else if (view == VideoPbFragment.this.lHG && VideoPbFragment.this.lMB != null) {
                    if (VideoPbFragment.this.diV() == null || VideoPbFragment.this.diV().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> dhJ = VideoPbFragment.this.diV().getPbData().dhJ();
                    if ((dhJ == null || dhJ.size() <= 0) && VideoPbFragment.this.diV().dkW()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new ar("c12378").dR("tid", VideoPbFragment.this.diV().dkU()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", VideoPbFragment.this.diV().getForumId()));
                    VideoPbFragment.this.lMB.djX();
                } else if (VideoPbFragment.this.lMB.doH() != null && view == VideoPbFragment.this.lMB.doH().dmj()) {
                    if (VideoPbFragment.this.diV() != null) {
                        VideoPbFragment.this.lMB.dnA();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.cyn();
                            VideoPbFragment.this.dng();
                            VideoPbFragment.this.diV().Gt(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.lMB != null && VideoPbFragment.this.lMB.doH() != null && view == VideoPbFragment.this.lMB.doH().dmf()) {
                    VideoPbFragment.this.lMB.aYV();
                } else if (VideoPbFragment.this.lMB != null && ((VideoPbFragment.this.lMB.doH() != null && view == VideoPbFragment.this.lMB.doH().dmm()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                    VideoPbFragment.this.lMB.dnA();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.cyn();
                            VideoPbFragment.this.dng();
                            VideoPbFragment.this.lMB.dz(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.diV().dln()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.lMB != null && VideoPbFragment.this.lMB.doH() != null && view == VideoPbFragment.this.lMB.doH().dmd()) {
                    if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null && VideoPbFragment.this.diV().getPbData().dhH() != null) {
                        VideoPbFragment.this.lMB.aYV();
                        TiebaStatic.log(new ar("c13062"));
                        VideoPbFragment.this.lMB.OW(VideoPbFragment.this.diV().getPbData().dhH().blT());
                    }
                } else if (view.getId() == R.id.pb_floor_feedback) {
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (VideoPbFragment.this.lMB != null) {
                        VideoPbFragment.this.lMB.f(sparseArray);
                    }
                } else if (VideoPbFragment.this.lMB != null && VideoPbFragment.this.lMB.doH() != null && view == VideoPbFragment.this.lMB.doH().dmn()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        ap.C(true, false);
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).ak("obj_type", 0).ak("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.CAM_X0201_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).ak("obj_type", 1).ak("obj_source", 1));
                    }
                    VideoPbFragment.this.lMB.doG();
                } else if (VideoPbFragment.this.lMB != null && (view == VideoPbFragment.this.lMB.dne() || (VideoPbFragment.this.lMB.doH() != null && (view == VideoPbFragment.this.lMB.doH().dmi() || view == VideoPbFragment.this.lMB.doH().dmg())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.diV() != null || VideoPbFragment.this.diV().getPbData() != null) {
                        if ((VideoPbFragment.this.diV().getPbData().dhW() == 1 || VideoPbFragment.this.diV().getPbData().dhW() == 3) && !VideoPbFragment.this.hZq.dKJ()) {
                            VideoPbFragment.this.lMB.dnA();
                            if (VideoPbFragment.this.lMB.doH() != null && view == VideoPbFragment.this.lMB.doH().dmg()) {
                                if (VideoPbFragment.this.diV().getPbData().dhH().blx() == 1) {
                                    i2 = 5;
                                } else {
                                    i2 = 4;
                                }
                            } else if (VideoPbFragment.this.lMB.doH() != null && view == VideoPbFragment.this.lMB.doH().dmi()) {
                                if (VideoPbFragment.this.diV().getPbData().dhH().bly() != 1) {
                                    i2 = 6;
                                }
                            } else {
                                i2 = view == VideoPbFragment.this.lMB.dne() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.diV().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.diV().getPbData().dhH().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.hZq.b(id, name, id2, i2, VideoPbFragment.this.lMB.dnf());
                        }
                    }
                } else if (VideoPbFragment.this.lMB != null && VideoPbFragment.this.lMB.doH() != null && view == VideoPbFragment.this.lMB.doH().dml()) {
                    if (VideoPbFragment.this.diV() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.lMB.dnA();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.diV().getPbData(), VideoPbFragment.this.diV().dkW(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.diV().getPbData().getForum().getId(), VideoPbFragment.this.diV().getPbData().getForum().getName(), VideoPbFragment.this.diV().getPbData().dhH().getId(), String.valueOf(VideoPbFragment.this.diV().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.lMB != null && VideoPbFragment.this.lMB.doH() != null && view == VideoPbFragment.this.lMB.doH().dmh()) {
                    if (VideoPbFragment.this.diV() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.diV().getPbData(), VideoPbFragment.this.diV().dkW(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.lMB.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.lMB.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.lMB.aYV();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        ar arVar3 = new ar("c13398");
                        arVar3.dR("tid", VideoPbFragment.this.diV().dkU());
                        arVar3.dR("fid", VideoPbFragment.this.diV().getForumId());
                        arVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar3.ak("obj_locate", 4);
                        TiebaStatic.log(arVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new ar("c10517").ak("obj_locate", 3).dR("fid", VideoPbFragment.this.diV().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null) {
                        if (VideoPbFragment.this.lMB != null) {
                            VideoPbFragment.this.lMB.dnA();
                        }
                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                        PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                        PostData postData3 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                        if (postData2 != null) {
                            if (postData2.dKc() == 1) {
                                TiebaStatic.log(new ar("c12630"));
                            }
                            if (postData2.mYE != null) {
                                ar bqx = postData2.mYE.bqx();
                                bqx.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    bqx.ak("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    bqx.ak("obj_locate", 8);
                                }
                                TiebaStatic.log(bqx);
                            }
                            VideoPbFragment.this.cyn();
                            TiebaStatic.log("c11742");
                            if (postData3 != null) {
                                VideoPbFragment.this.a(postData2, postData3, false, true);
                            } else {
                                VideoPbFragment.this.a(postData2, (PostData) null, false, false);
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                    if (VideoPbFragment.this.diV() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            ar arVar4 = new ar("c13398");
                            arVar4.dR("tid", VideoPbFragment.this.diV().dkU());
                            arVar4.dR("fid", VideoPbFragment.this.diV().getForumId());
                            arVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                            arVar4.ak("obj_locate", 6);
                            TiebaStatic.log(arVar4);
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData4.mYE != null) {
                                    ar bqx2 = postData4.mYE.bqx();
                                    bqx2.delete("obj_locate");
                                    bqx2.ak("obj_locate", 8);
                                    TiebaStatic.log(bqx2);
                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                    TiebaStatic.log(new ar("c13700").dR("tid", VideoPbFragment.this.diV().dkV()).dR("fid", VideoPbFragment.this.diV().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData4.getId()).ak("obj_type", 3));
                                }
                                if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null && VideoPbFragment.this.ltx != null && postData4.blC() != null && postData4.dJQ() != 1) {
                                    if (VideoPbFragment.this.lCK != null) {
                                        VideoPbFragment.this.lCK.djC();
                                    }
                                    if ((VideoPbFragment.this.lrD || com.baidu.tbadk.a.d.bhd()) && postData4.dJN() != null && postData4.dJN().size() != 0) {
                                        if (com.baidu.tbadk.a.d.bhe()) {
                                            VideoPbFragment.this.a(postData4, (PostData) null, false, false);
                                            return;
                                        } else {
                                            VideoPbFragment.this.a(postData4, (PostData) null, true, false);
                                            return;
                                        }
                                    }
                                    p pVar2 = new p();
                                    pVar2.a(VideoPbFragment.this.diV().getPbData().getForum());
                                    pVar2.setThreadData(VideoPbFragment.this.diV().getPbData().dhH());
                                    pVar2.g(postData4);
                                    VideoPbFragment.this.ltx.d(pVar2);
                                    VideoPbFragment.this.ltx.setPostId(postData4.getId());
                                    VideoPbFragment.this.a(view, postData4.blC().getUserId(), "", postData4);
                                    if (VideoPbFragment.this.lut != null) {
                                        VideoPbFragment.this.uT(VideoPbFragment.this.lut.bzB());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.lMB != null && VideoPbFragment.this.diV() != null) {
                        if (com.baidu.tbadk.a.d.bhp() || VideoPbFragment.this.dqB() != null) {
                            if (!com.baidu.tbadk.a.d.bhp() || VideoPbFragment.this.dqD() != null) {
                                VideoPbFragment.this.lMB.dnA();
                                if (VideoPbFragment.this.Go(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.diV() != null) {
                                    VideoPbFragment.this.dke();
                                    if (VideoPbFragment.this.diV().getPbData() != null && VideoPbFragment.this.diV().getPbData().dhH() != null && VideoPbFragment.this.diV().getPbData().dhH().blC() != null) {
                                        TiebaStatic.log(new ar("c13402").dR("tid", VideoPbFragment.this.diV().dkU()).dR("fid", VideoPbFragment.this.diV().getPbData().getForumId()).ak("obj_locate", 3).dR("uid", VideoPbFragment.this.diV().getPbData().dhH().blC().getUserId()));
                                    }
                                    if (VideoPbFragment.this.diV().getPbData().dhH() != null && VideoPbFragment.this.diV().getPbData().dhH().blC() != null && VideoPbFragment.this.diV().getPbData().dhH().blC().getUserId() != null && VideoPbFragment.this.luf != null) {
                                        int h = VideoPbFragment.this.lMB.h(VideoPbFragment.this.diV().getPbData());
                                        bx dhH = VideoPbFragment.this.diV().getPbData().dhH();
                                        if (!dhH.bkk()) {
                                            if (dhH.bkl()) {
                                                i = 3;
                                            } else if (dhH.bnz()) {
                                                i = 4;
                                            } else {
                                                i = dhH.bnA() ? 5 : 1;
                                            }
                                        }
                                        TiebaStatic.log(new ar("c12526").dR("tid", VideoPbFragment.this.diV().dkU()).ak("obj_locate", 1).dR("obj_id", VideoPbFragment.this.diV().getPbData().dhH().blC().getUserId()).ak("obj_type", VideoPbFragment.this.luf.bhP() ? 0 : 1).ak("obj_source", h).ak("obj_param1", i));
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.vv(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.lMB != null && VideoPbFragment.this.eKk != null && VideoPbFragment.this.diV().getPbData() != null && VideoPbFragment.this.diV().getPbData().dhH() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.diV().getPbData();
                        if (pbData.dhH().blt() != 0) {
                            int currentItem = VideoPbFragment.this.eKk.getCurrentItem();
                            if (!com.baidu.tbadk.a.d.bhp() && currentItem == VideoPbFragment.lMf) {
                                VideoPbFragment.this.eKk.setCurrentItem(VideoPbFragment.lMg);
                            } else if (com.baidu.tbadk.a.d.bhp() || currentItem == VideoPbFragment.lMg) {
                                if (!com.baidu.tbadk.a.d.bhp() && VideoPbFragment.this.dqB() == null) {
                                    return;
                                }
                                if ((!com.baidu.tbadk.a.d.bhp() || VideoPbFragment.this.dqD() != null) && VideoPbFragment.this.cBg() != null) {
                                    ar dR = new ar("c13403").dR("tid", VideoPbFragment.this.diV().dkU()).dR("fid", VideoPbFragment.this.diV().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView cBg = VideoPbFragment.this.cBg();
                                    if (cBg != null) {
                                        boolean canScrollVertically = cBg.canScrollVertically(1);
                                        boolean canScrollVertically2 = cBg.canScrollVertically(-1);
                                        if (VideoPbFragment.this.Ym != null) {
                                            VideoPbFragment.this.Ym.setExpanded(false, true);
                                        }
                                        if (cBg.getLayoutManager() != null && (cBg.getLayoutManager() instanceof LinearLayoutManager)) {
                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) cBg.getLayoutManager();
                                            if (!canScrollVertically2 && canScrollVertically) {
                                                if (VideoPbFragment.this.ltY != -1 || VideoPbFragment.this.ltZ != Integer.MIN_VALUE) {
                                                    if (VideoPbFragment.this.ltY > 3 || (VideoPbFragment.this.ltY == 3 && VideoPbFragment.this.ltZ < (-equipmentHeight))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.ltY, VideoPbFragment.this.ltZ + equipmentHeight);
                                                        cBg.smoothScrollBy(0, equipmentHeight);
                                                    } else if (VideoPbFragment.this.ltY >= 2) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.ltY, VideoPbFragment.this.ltZ + (equipmentHeight / 2));
                                                        cBg.smoothScrollBy(0, equipmentHeight / 2);
                                                    } else if (VideoPbFragment.this.ltY == 1) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.ltY, VideoPbFragment.this.ltZ + (equipmentHeight / 4));
                                                        cBg.smoothScrollBy(0, equipmentHeight / 4);
                                                    } else {
                                                        cBg.smoothScrollBy(0, -VideoPbFragment.this.ltZ);
                                                    }
                                                    dR.ak("obj_locate", 2);
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                int firstVisiblePosition = cBg.getFirstVisiblePosition();
                                                View childAt = cBg.getChildAt(0);
                                                int top = childAt == null ? 0 : childAt.getTop();
                                                VideoPbFragment.this.ltY = firstVisiblePosition;
                                                VideoPbFragment.this.ltZ = top;
                                                if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && cBg.getCount() >= 6)) {
                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                    cBg.smoothScrollToPosition(0);
                                                } else {
                                                    cBg.smoothScrollToPosition(0);
                                                }
                                                dR.ak("obj_locate", 1);
                                            }
                                            TiebaStatic.log(dR);
                                            TiebaStatic.log(new ar("c12942").ak("obj_type", 1).ak("obj_locate", 4).dR("tid", VideoPbFragment.this.diV().dkU()).dR("nid", pbData.dhH().getNid()));
                                        } else {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null && VideoPbFragment.this.diV().getPbData().dhH() != null && VideoPbFragment.this.diV().getPbData().dhH().blC() != null) {
                                TiebaStatic.log(new ar("c13402").dR("tid", VideoPbFragment.this.diV().dkU()).dR("fid", VideoPbFragment.this.diV().getPbData().getForumId()).ak("obj_locate", 2).dR("uid", VideoPbFragment.this.diV().getPbData().dhH().blC().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.vw(false);
                        VideoPbFragment.this.djS();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.luG >= 0) {
                        if (VideoPbFragment.this.diV() != null) {
                            VideoPbFragment.this.diV().dlF();
                        }
                        if (com.baidu.tbadk.a.d.bhp() && VideoPbFragment.this.dqD() != null && VideoPbFragment.this.dqD().drk() != null) {
                            VideoPbFragment.this.dqD().drk().setData(VideoPbFragment.this.diV().getPbData());
                        } else if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.dqB() != null && VideoPbFragment.this.dqB().drk() != null) {
                            VideoPbFragment.this.dqB().drk().setData(VideoPbFragment.this.diV().getPbData());
                        }
                        VideoPbFragment.this.luG = 0;
                        VideoPbFragment.this.lMD = Integer.MIN_VALUE;
                        if (com.baidu.tbadk.a.d.bhp() && VideoPbFragment.this.diV() != null && VideoPbFragment.this.dqD() != null) {
                            VideoPbFragment.this.dqD().de(VideoPbFragment.this.diV().dlI(), VideoPbFragment.this.diV().dlJ());
                            VideoPbFragment.this.diV().db(0, 0);
                        } else if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.dqB() != null) {
                            VideoPbFragment.this.dqB().de(VideoPbFragment.this.diV().dlI(), VideoPbFragment.this.diV().dlJ());
                            VideoPbFragment.this.diV().db(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.diV() != null) {
                        ar arVar5 = new ar("c13398");
                        arVar5.dR("tid", VideoPbFragment.this.diV().dkU());
                        arVar5.dR("fid", VideoPbFragment.this.diV().getForumId());
                        arVar5.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar5.ak("obj_locate", 2);
                        TiebaStatic.log(arVar5);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bh.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.bpu().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.dmK();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.dmK();
                } else if (VideoPbFragment.this.lMB.doH() != null && view == VideoPbFragment.this.lMB.doH().dmk()) {
                    VideoPbFragment.this.lMB.dnA();
                    if (VideoPbFragment.this.diV() != null) {
                        VideoPbFragment.this.hZs.setThreadId(VideoPbFragment.this.diV().dkU());
                    }
                    if (VideoPbFragment.this.diV() == null || !VideoPbFragment.this.diV().isPrivacy()) {
                        VideoPbFragment.this.hZs.cnp();
                        if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null && VideoPbFragment.this.diV().getPbData().getThreadId() != null && VideoPbFragment.this.diV().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                            i3 = 2;
                        }
                        if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null) {
                            VideoPbFragment.this.hZs.k(3, i3, VideoPbFragment.this.diV().getPbData().getThreadId());
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                    if (VideoPbFragment.this.diV().getPbData() != null) {
                        VideoPbFragment.this.hZs.k(3, 3, VideoPbFragment.this.diV().getPbData().getThreadId());
                    }
                }
            }
        }
    };
    private View.OnClickListener lqU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.lMB != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.lMB.c(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.lMB.dt(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.lMB.c(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.lMB.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private CustomMessageListener jXy = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(VideoPbFragment.this.getPageContext(), VideoPbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    public SortSwitchButton.a lvf = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zU(int i) {
            if (VideoPbFragment.this.lMB != null) {
                VideoPbFragment.this.lMB.dnA();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.diV() == null || VideoPbFragment.this.diV().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.cyn();
                VideoPbFragment.this.dng();
                if (VideoPbFragment.this.diV().getPbData() != null && VideoPbFragment.this.diV().getPbData().lnk != null && VideoPbFragment.this.diV().getPbData().lnk.size() > i) {
                    int intValue = VideoPbFragment.this.diV().getPbData().lnk.get(i).sort_type.intValue();
                    TiebaStatic.log(new ar("c13699").dR("tid", VideoPbFragment.this.diV().dkV()).dR("fid", VideoPbFragment.this.diV().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).ak("obj_type", Gr(intValue)));
                    if (VideoPbFragment.this.diV().Gy(intValue)) {
                        VideoPbFragment.this.mIsLoading = true;
                    }
                }
                return true;
            }
        }

        private int Gr(int i) {
            if (i == 2) {
                return 1;
            }
            if (i == 0) {
                return 2;
            }
            if (i == 1) {
                return 3;
            }
            return 0;
        }
    };
    private a lMC = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void dkc() {
        if (diV() != null && diV().getPbData() != null && diV().getPbData().dhH() != null) {
            bx dhH = diV().getPbData().dhH();
            dhH.mRecomAbTag = diV().dlP();
            dhH.mRecomWeight = diV().dlN();
            dhH.mRecomSource = diV().dlO();
            dhH.mRecomExtra = diV().dlQ();
            if (dhH.getFid() == 0) {
                dhH.setFid(com.baidu.adp.lib.f.b.toLong(diV().getForumId(), 0L));
            }
            ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dhH, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ul(boolean z) {
        if (diV() != null && diV().getPbData() != null && diV().getPbData().dhH() != null) {
            bx dhH = diV().getPbData().dhH();
            dhH.mRecomAbTag = diV().dlP();
            dhH.mRecomWeight = diV().dlN();
            dhH.mRecomSource = diV().dlO();
            dhH.mRecomExtra = diV().dlQ();
            if (dhH.getFid() == 0) {
                dhH.setFid(com.baidu.adp.lib.f.b.toLong(diV().getForumId(), 0L));
            }
            ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dhH, "c13563");
            TbPageTag eu = com.baidu.tbadk.pageInfo.c.eu(getContext());
            if (a2 != null && eu != null && PageStayDurationConstants.PageName.VIDEO_LIST.equals(eu.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            if (a2 != null) {
                a2.ak("reply_type", 1);
                if (z) {
                    a2.ak("obj_type", 2);
                } else {
                    a2.ak("obj_type", 1);
                }
                TiebaStatic.log(a2);
            }
        }
    }

    public void a(int i, boolean z, String str, boolean z2) {
        hideProgressBar();
        if (z && z2) {
            showToast(getPageContext().getString(R.string.success));
        } else if (z2) {
            if (au.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.naF) ? bVar.naF : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.AJ(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.iW(true);
                aVar.b(getPageContext());
                aVar.bog();
            } else {
                a(0, bVar.QR, bVar.naF, z);
            }
            if (bVar.QR) {
                if (bVar.ioW == 1) {
                    ArrayList<PostData> dhJ = diV().getPbData().dhJ();
                    int size = dhJ.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dhJ.get(i).getId())) {
                            i++;
                        } else {
                            dhJ.remove(i);
                            break;
                        }
                    }
                    diV().getPbData().dhH().of(diV().getPbData().dhH().blt() - 1);
                    if (com.baidu.tbadk.a.d.bhp() && dqD() != null) {
                        dqD().drm();
                    } else if (dqB() != null) {
                        dqB().drm();
                    }
                } else if (bVar.ioW == 0) {
                    dkd();
                } else if (bVar.ioW == 2) {
                    ArrayList<PostData> dhJ2 = diV().getPbData().dhJ();
                    int size2 = dhJ2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dhJ2.get(i2).dJN().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dhJ2.get(i2).dJN().get(i3).getId())) {
                                i3++;
                            } else {
                                dhJ2.get(i2).dJN().remove(i3);
                                dhJ2.get(i2).dJP();
                                z2 = true;
                                break;
                            }
                        }
                        dhJ2.get(i2).Ss(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        if (com.baidu.tbadk.a.d.bhp() && dqD() != null) {
                            dqD().drm();
                        } else if (dqB() != null) {
                            dqB().drm();
                        }
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = diV().getPbData().dhV().loU;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dJN().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dJN().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dJN().remove(i2);
                    list.get(i).dJP();
                    z = true;
                    break;
                }
            }
            list.get(i).Ss(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            if (com.baidu.tbadk.a.d.bhp() && dqD() != null) {
                dqD().drm();
            } else if (dqB() != null) {
                dqB().drm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && diV() != null && diV().getPbData() != null && diV().getPbData().dhH() != null) {
            a(this.hZq.getLoadDataMode(), gVar.QR, gVar.naF, false);
            if (gVar.QR) {
                this.lui = true;
                if (i == 2 || i == 3) {
                    this.luj = true;
                    this.luk = false;
                } else if (i == 4 || i == 5) {
                    this.luj = false;
                    this.luk = true;
                }
                if (i == 2) {
                    diV().getPbData().dhH().oi(1);
                    diV().setIsGood(1);
                } else if (i == 3) {
                    diV().getPbData().dhH().oi(0);
                    diV().setIsGood(0);
                } else if (i == 4) {
                    diV().getPbData().dhH().oh(1);
                    diV().Gs(1);
                } else if (i == 5) {
                    diV().getPbData().dhH().oh(0);
                    diV().Gs(0);
                }
            }
            if (diV().getPbData().dhH() != null && dqC() != null) {
                dqC().drw();
            }
        }
    }

    private void dkd() {
        if (diV().dkX() || diV().dkZ()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", diV().dkU());
            PbActivity pbActivity = this.ltC;
            PbActivity pbActivity2 = this.ltC;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, diV().dkU()));
        if (dkg()) {
            this.ltC.finish();
        }
    }

    private boolean dkg() {
        if (diV() == null) {
            return true;
        }
        if (diV().getPbData() == null || !diV().getPbData().dik()) {
            if (diV().bhP()) {
                final MarkData dlo = diV().dlo();
                if (dlo == null || !diV().getIsFromMark() || cBg() == null) {
                    return true;
                }
                final MarkData Gz = diV().Gz(cBg().getFirstVisiblePosition());
                if (Gz == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dlo);
                    this.ltC.setResult(-1, intent);
                    return true;
                } else if (Gz.getPostId() == null || Gz.getPostId().equals(dlo.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dlo);
                    this.ltC.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.AJ(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.luf != null) {
                                if (VideoPbFragment.this.luf.bhP()) {
                                    VideoPbFragment.this.luf.bhQ();
                                    VideoPbFragment.this.luf.is(false);
                                }
                                VideoPbFragment.this.luf.a(Gz);
                                VideoPbFragment.this.luf.is(true);
                                VideoPbFragment.this.luf.bhR();
                            }
                            dlo.setPostId(Gz.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dlo);
                            VideoPbFragment.this.ltC.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dji();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dlo);
                            VideoPbFragment.this.ltC.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dji();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.bog();
                    return false;
                }
            } else if (diV().getPbData() == null || diV().getPbData().dhJ() == null || diV().getPbData().dhJ().size() <= 0 || !diV().getIsFromMark()) {
                return true;
            } else {
                this.ltC.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dji() {
        this.ltC.dji();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void vv(boolean z) {
        com.baidu.tieba.pb.data.f pbData;
        int i;
        if (diV() != null && this.lMB != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = diV().getPbData()) != null) {
                bx dhH = pbData.dhH();
                if (dhH != null && dhH.blC() != null) {
                    TiebaStatic.log(new ar("c13402").dR("tid", diV().dkU()).dR("fid", pbData.getForumId()).ak("obj_locate", 4).dR("uid", dhH.blC().getUserId()));
                }
                if (dhH != null) {
                    if (dhH.bkk()) {
                        i = 2;
                    } else if (dhH.bkl()) {
                        i = 3;
                    } else if (dhH.bnz()) {
                        i = 4;
                    } else if (dhH.bnA()) {
                        i = 5;
                    }
                    ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    arVar.dR("tid", diV().dkU());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.dR("fid", diV().getForumId());
                    if (!z) {
                        arVar.ak("obj_locate", 6);
                    } else {
                        arVar.ak("obj_locate", 5);
                    }
                    arVar.ak("obj_name", i);
                    arVar.ak("obj_type", 2);
                    if (dhH != null) {
                        if (dhH.bkk()) {
                            arVar.ak("obj_type", 10);
                        } else if (dhH.bkl()) {
                            arVar.ak("obj_type", 9);
                        } else if (dhH.bnA()) {
                            arVar.ak("obj_type", 8);
                        } else if (dhH.bnz()) {
                            arVar.ak("obj_type", 7);
                        } else if (dhH.isShareThread) {
                            arVar.ak("obj_type", 6);
                        } else if (dhH.threadType == 0) {
                            arVar.ak("obj_type", 1);
                        } else if (dhH.threadType == 40) {
                            arVar.ak("obj_type", 2);
                        } else if (dhH.threadType == 49) {
                            arVar.ak("obj_type", 3);
                        } else if (dhH.threadType == 54) {
                            arVar.ak("obj_type", 4);
                        } else {
                            arVar.ak("obj_type", 5);
                        }
                        arVar.dR("nid", dhH.getNid());
                        arVar.ak(IntentConfig.CARD_TYPE, dhH.bnD());
                        arVar.dR(IntentConfig.RECOM_SOURCE, dhH.mRecomSource);
                        arVar.dR("ab_tag", dhH.mRecomAbTag);
                        arVar.dR("weight", dhH.mRecomWeight);
                        arVar.dR("extra", dhH.mRecomExtra);
                        arVar.dR("nid", dhH.getNid());
                        if (dhH.getBaijiahaoData() != null && !au.isEmpty(dhH.getBaijiahaoData().oriUgcVid)) {
                            arVar.dR("obj_param6", dhH.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (dkB() != null) {
                        com.baidu.tbadk.pageInfo.c.b(dkB(), arVar);
                    }
                    TiebaStatic.log(arVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (diV().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> dhJ = pbData.dhJ();
                        if ((dhJ == null || dhJ.size() <= 0) && diV().dkW()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.lMB.dnA();
                        cyn();
                        TiebaStatic.log(new ar("c11939"));
                        if (!AntiHelper.d(getContext(), dhH)) {
                            if (this.lCi != null) {
                                this.lCi.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                Gp(z ? 2 : 1);
                                return;
                            }
                            this.lMB.showLoadingDialog();
                            diV().dlz().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                ar arVar2 = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                arVar2.dR("tid", diV().dkU());
                arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar2.dR("fid", diV().getForumId());
                if (!z) {
                }
                arVar2.ak("obj_name", i);
                arVar2.ak("obj_type", 2);
                if (dhH != null) {
                }
                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (dkB() != null) {
                }
                TiebaStatic.log(arVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment dqi() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        L(eVar.dqO());
        M(eVar.dqO());
        if (diV() != null && diV().getPbData() != null) {
            boolean isFromMark = diV().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = diV().getPbData();
            if (isFromMark) {
                PostData K = K(pbData);
                if (pbData.bhO() != null && !pbData.bhO().equals(K.getId()) && this.eKk != null) {
                    if (com.baidu.tbadk.a.d.bhp()) {
                        this.eKk.setCurrentItem(lMh);
                    } else {
                        this.eKk.setCurrentItem(lMg);
                    }
                }
            }
        }
        eVar.dqP().observe(this, new q<bx>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aQ */
            public void onChanged(@Nullable bx bxVar) {
                BdTypeRecyclerView cBg;
                if (bxVar != null && bxVar.blU() != null) {
                    if (VideoPbFragment.this.lMo.getVideoUrl() == null || !VideoPbFragment.this.lMo.getVideoUrl().equals(bxVar.blU().video_url)) {
                        if (!au.isEmpty(VideoPbFragment.this.lMo.getVideoUrl())) {
                            VideoPbFragment.this.ltP = true;
                            if (com.baidu.tbadk.a.d.bhp()) {
                                VideoPbFragment.this.eKk.setCurrentItem(VideoPbFragment.lMh);
                            } else {
                                VideoPbFragment.this.eKk.setCurrentItem(VideoPbFragment.lMf);
                            }
                            if (com.baidu.tbadk.a.d.bhp() && (cBg = VideoPbFragment.this.cBg()) != null) {
                                cBg.scrollToPosition(0);
                            }
                        }
                        if (VideoPbFragment.this.lMp == null || !VideoPbFragment.this.lMp.isPlaying()) {
                            VideoPbFragment.this.dqj();
                            VideoPbFragment.this.aP(bxVar);
                        }
                        VideoPbFragment.this.dqk();
                        if (VideoPbFragment.this.lMp.drc()) {
                            VideoPbFragment.this.lMp.start();
                        }
                        boolean z = !au.equals(VideoPbFragment.this.lMo.getVideoUrl(), bxVar.blU().video_url);
                        VideoPbFragment.this.lMo.setData(bxVar);
                        if (com.baidu.tbadk.a.d.bhp()) {
                            VideoPbFragment.this.lMo.vE(false);
                        } else {
                            VideoPbFragment.this.lMo.vE(VideoPbFragment.this.eKk.getCurrentItem() == 0);
                        }
                        if (z) {
                            VideoPbFragment.this.lMo.startPlay();
                            VideoPbFragment.this.lMo.drO();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.lMo.setData(bxVar);
                }
            }
        });
        eVar.dqY().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: s */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.eKk.setCurrentItem(num.intValue());
            }
        });
        eVar.dqT().observe(this, new q<bx>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aQ */
            public void onChanged(@Nullable bx bxVar) {
                VideoPbFragment.this.lMo.aU(bxVar);
            }
        });
        eVar.dqU().observe(this, new q<bx>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aQ */
            public void onChanged(@Nullable bx bxVar) {
                VideoPbFragment.this.lMo.aV(bxVar);
            }
        });
        eVar.dqV().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.dqu();
            }
        });
        eVar.dqW().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqj() {
        ViewGroup.LayoutParams layoutParams = this.lMr.getLayoutParams();
        layoutParams.height = 0;
        this.lMr.setLayoutParams(layoutParams);
        this.lMr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqk() {
        if (this.lMp == null) {
            this.lMp = new f(getBaseFragmentActivity(), this.lMn);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(dkB()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.lMn.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.lMp.b(eVar.dqQ(), rect);
            if (this.lMp.drc()) {
                this.lMp.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (com.baidu.tbadk.a.d.bhp()) {
                            if (eVar.dqR() || VideoPbFragment.this.diV().getTabIndex() == VideoPbFragment.lMh) {
                                VideoPbFragment.this.eKk.setCurrentItem(VideoPbFragment.lMh);
                            }
                        } else if (eVar.dqR() || VideoPbFragment.this.diV().getTabIndex() == VideoPbFragment.lMg) {
                            VideoPbFragment.this.eKk.setCurrentItem(VideoPbFragment.lMg);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (com.baidu.tbadk.a.d.bhp()) {
                            if (eVar.dqR() || VideoPbFragment.this.diV().getTabIndex() == VideoPbFragment.lMh) {
                                VideoPbFragment.this.eKk.setCurrentItem(VideoPbFragment.lMh);
                            }
                        } else if (eVar.dqR() || VideoPbFragment.this.diV().getTabIndex() == VideoPbFragment.lMg) {
                            VideoPbFragment.this.eKk.setCurrentItem(VideoPbFragment.lMg);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (com.baidu.tbadk.a.d.bhp()) {
                if (eVar.dqR() || diV().getTabIndex() == lMh) {
                    this.eKk.setCurrentItem(lMh);
                }
            } else if (eVar.dqR() || diV().getTabIndex() == lMg) {
                this.eKk.setCurrentItem(lMg);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.lMH && (this.lMI || dqI())) {
            dqH();
            UtilHelper.hideStatusBar(dkB(), dkB().getRootView());
            this.lMI = false;
            if (this.lMo != null) {
                this.lMo.vx(false);
            }
        }
        if (i == 4) {
            return this.lMo.dxb();
        }
        if (i == 24) {
            return this.lMo.drL();
        }
        if (i == 25) {
            return this.lMo.drM();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aP(bx bxVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect dlR;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bxVar != null && bxVar.blU() != null) {
            int intValue = bxVar.blU().video_width.intValue();
            int intValue2 = bxVar.blU().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (diV() != null || (dlR = diV().dlR()) == null) ? ceil : dlR.height();
                i = 0;
                layoutParams = this.lMn.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.lMn.setLayoutParams(layoutParams);
                this.lMn.setMaxHeight(ceil);
                this.lMn.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.lMn.setOriginHeight(height);
                if (!com.baidu.tbadk.a.d.bhp()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.lMj.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, lMi);
                    } else {
                        layoutParams3.height = lMi;
                    }
                    this.lMj.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.Ym.getLayoutParams();
                if (!com.baidu.tbadk.a.d.bhp()) {
                    ceil += lMi;
                }
                if (layoutParams2 != null) {
                    layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                } else {
                    layoutParams2.height = ceil;
                }
                this.Ym.setLayoutParams(layoutParams2);
                if (i == 0 && (this.Ym.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.Ym.getLayoutParams()).getBehavior();
                    if (behavior instanceof VideoZoomBehavior) {
                        ((VideoZoomBehavior) behavior).setTopAndBottomOffset(-i);
                        return;
                    }
                    return;
                }
            }
        }
        d = 1.7777777777777777d;
        if (d > 1.7777777777777777d) {
        }
        if (d >= equipmentHeight) {
        }
        int ceil2 = (int) Math.ceil(equipmentWidth / equipmentHeight);
        if (diV() != null) {
        }
        i = 0;
        layoutParams = this.lMn.getLayoutParams();
        if (layoutParams != null) {
        }
        this.lMn.setLayoutParams(layoutParams);
        this.lMn.setMaxHeight(ceil2);
        this.lMn.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.lMn.setOriginHeight(height);
        if (!com.baidu.tbadk.a.d.bhp()) {
        }
        layoutParams2 = (CoordinatorLayout.LayoutParams) this.Ym.getLayoutParams();
        if (!com.baidu.tbadk.a.d.bhp()) {
        }
        if (layoutParams2 != null) {
        }
        this.Ym.setLayoutParams(layoutParams2);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.ltJ = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        ar(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.luA = new com.baidu.tbadk.core.view.c();
        this.luA.toastTime = 1000L;
        if (this.lMB != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.lMB.luB;
            userMuteAddAndDelCustomMessage.setTag(this.lMB.luB);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.lMB.luB;
            userMuteCheckCustomMessage.setTag(this.lMB.luB);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.hZs = new com.baidu.tieba.callfans.a(getPageContext());
        com.baidu.tieba.t.c.dIO().z(getUniqueId());
    }

    private void initData() {
        this.luf = com.baidu.tbadk.baseEditMark.a.a(this.ltC);
        if (this.luf != null) {
            this.luf.a(this.lvl);
        }
        this.hZq = new ForumManageModel(this.ltC);
        this.hZq.setLoadDataCallBack(this.hZx);
        this.eMq = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.lMB = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void ar(Bundle bundle) {
        this.lus = new g();
        d(this.lus);
        this.lut = (com.baidu.tbadk.editortools.pb.e) this.lus.ei(getActivity());
        this.lut.a(this.ltC.getPageContext());
        this.lut.a(this.fpd);
        this.lut.a(this.foW);
        this.lut.setFrom(1);
        this.lut.a(this.ltC.getPageContext(), bundle);
        this.lut.byN().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lut.byN().kc(true);
        uk(true);
        this.lut.a(diV().dlk(), diV().dkU(), diV().dlB());
        registerListener(this.luQ);
        registerListener(this.lvk);
        registerListener(this.luP);
        registerListener(this.luN);
        registerListener(this.iJE);
        if (!diV().dlb()) {
            this.lut.Dn(diV().dkU());
        }
        if (diV().dlC()) {
            this.lut.Dl(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.lut.Dl(dmM());
        }
        this.kzS = new bb();
        if (this.lut.bzt() != null) {
            this.kzS.e(this.lut.bzt().getInputView());
        }
        this.lut.a(this.foX);
        this.kwi = new am(getPageContext());
        this.kwi.a(new am.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z) {
                    if (i == am.eMl) {
                        VideoPbFragment.this.lut.a((String) null, (WriteData) null);
                    } else if (i == am.eMm && VideoPbFragment.this.lCK != null && VideoPbFragment.this.lCK.djG() != null) {
                        VideoPbFragment.this.lCK.djG().bzR();
                    } else if (i == am.eMn) {
                        VideoPbFragment.this.c(VideoPbFragment.this.luw);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = (RelativeLayout) layoutInflater.inflate(R.layout.video_pb_fragment, viewGroup, false);
        initUI();
        return this.rootView;
    }

    private void initUI() {
        this.iMX = new com.baidu.tieba.g.b(getActivity());
        this.iMX.a(lvt);
        this.lMH = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        bCo();
        this.Ym = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.lMl = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.lMn = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.lMo = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.lMn);
        this.lMo.setStageType("2002");
        this.lMo.setUniqueId(getUniqueId());
        this.lMo.af(this);
        this.lMo.dA(dkB().getRootView());
        this.lMo.dB(this.lMq);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.lMj = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.lMr = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.eKk = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.lMm = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.lMm.setOnClickListener(this.aEk);
        dqm();
        dql();
        dqn();
        this.lMk = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.eKk.setAdapter(this.lMk);
        this.lMj.setViewPager(this.eKk);
        this.lMj.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (com.baidu.tbadk.a.d.bhp() && VideoPbFragment.this.dqD() != null) {
                        VideoPbFragment.this.dqD().vD(false);
                    } else if (VideoPbFragment.this.dqB() != null) {
                        VideoPbFragment.this.dqB().vD(false);
                    }
                    if (VideoPbFragment.this.dqC() != null) {
                        VideoPbFragment.this.dqC().vD(true);
                        VideoPbFragment.this.GY(VideoPbFragment.this.dqC().drq() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.dqV() != null && eVar.dqV().getValue() != null && eVar.dqV().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.lMo.vE(z);
                    VideoPbFragment.this.dmK();
                    if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null) {
                        TiebaStatic.log(new ar("c13592").dR("tid", VideoPbFragment.this.diV().dkU()).dR("fid", VideoPbFragment.this.diV().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.dqC() != null) {
                        VideoPbFragment.this.dqC().vD(false);
                    }
                    if (com.baidu.tbadk.a.d.bhp() && VideoPbFragment.this.dqD() != null) {
                        VideoPbFragment.this.dqD().vD(true);
                        int drq = VideoPbFragment.this.dqD().drq();
                        int drr = VideoPbFragment.this.dqD().drr();
                        if (drq != 0) {
                            VideoPbFragment.this.GY(8);
                            VideoPbFragment.this.dqD().GY(0);
                        } else if (drr != 0) {
                            VideoPbFragment.this.dqD().GY(8);
                            VideoPbFragment.this.GY(0);
                        } else {
                            VideoPbFragment.this.dqD().GY(8);
                            VideoPbFragment.this.GY(8);
                        }
                    } else if (VideoPbFragment.this.dqB() != null) {
                        VideoPbFragment.this.dqB().vD(true);
                        int drq2 = VideoPbFragment.this.dqB().drq();
                        int drr2 = VideoPbFragment.this.dqB().drr();
                        if (drq2 != 0) {
                            VideoPbFragment.this.GY(8);
                            VideoPbFragment.this.dqB().GY(0);
                        } else if (drr2 != 0) {
                            VideoPbFragment.this.dqB().GY(8);
                            VideoPbFragment.this.GY(0);
                        } else {
                            VideoPbFragment.this.dqB().GY(8);
                            VideoPbFragment.this.GY(8);
                        }
                    }
                    VideoPbFragment.this.lMo.vE(false);
                    VideoPbFragment.this.Ym.setExpanded(false, true);
                    if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null) {
                        TiebaStatic.log(new ar("c13593").dR("tid", VideoPbFragment.this.diV().dkU()).dR("fid", VideoPbFragment.this.diV().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.lMk.Ha(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.lBK = this.rootView.findViewById(R.id.viewstub_progress);
        dqo();
        bTk();
        if (!this.lMH && this.lMI) {
            dqH();
            UtilHelper.hideStatusBar(dkB(), dkB().getRootView());
            this.lMI = false;
        }
        if (com.baidu.tbadk.a.d.bhp()) {
            this.lMj.getLayoutParams().height = 0;
        }
    }

    private void dql() {
        this.lMt = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.lMx = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.lMu = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.lMv = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.lMw = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.lMy = this.rootView.findViewById(R.id.ala_live_point);
        this.lMx.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.lMx.setConrers(15);
        this.lMw.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.lMv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.lnU == null || VideoPbFragment.this.lnU.drC()) {
                    if (VideoPbFragment.this.lnU != null) {
                        TiebaStatic.log(new ar("c13608").dR("tid", VideoPbFragment.this.diV().getPbData().getThreadId()));
                        VideoPbFragment.this.lnU.lOC = true;
                    }
                } else {
                    TiebaStatic.log(new ar("c13591"));
                }
                VideoPbFragment.this.dqw();
            }
        });
        this.lMw.setOnClickListener(this.lMs);
        this.lMr.setOnClickListener(this.lMs);
    }

    private void dqm() {
        this.lMj.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.lMj.setContainerLayoutParams(layoutParams);
        this.lMj.setRectPaintColor(R.color.CAM_X0302);
        this.lMj.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.lMj.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.lMj.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.lMj.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.lMj.setExpandedTabLayoutParams(layoutParams2);
    }

    public void vw(boolean z) {
        if (this.Ym != null) {
            this.Ym.setExpanded(z);
        }
    }

    private void dqn() {
        this.lCb = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.lCc = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.lCm = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lCn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lCe = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lCe.setVisibility(0);
        this.lCe.setIsRound(true);
        this.lCe.setBorderWidth(l.getDimens(getContext(), R.dimen.L_X01));
        this.lCe.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.lCe.setPlaceHolder(0);
        dmQ();
        this.jKO = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lCd = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lCd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.vw(false);
                VideoPbFragment.this.djS();
                if (VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null && VideoPbFragment.this.diV().getPbData().dhH() != null && VideoPbFragment.this.diV().getPbData().dhH().blC() != null) {
                    TiebaStatic.log(new ar("c13701").dR("tid", VideoPbFragment.this.diV().dkV()).dR("fid", VideoPbFragment.this.diV().getPbData().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new ar("c13402").dR("tid", VideoPbFragment.this.diV().dkU()).dR("fid", VideoPbFragment.this.diV().getPbData().getForumId()).ak("obj_locate", 1).dR("uid", VideoPbFragment.this.diV().getPbData().dhH().blC().getUserId()));
                }
            }
        });
        this.lCf = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lCf.setOnClickListener(this.aEk);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lCg = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.lCg.setOnClickListener(this.aEk);
        if (booleanExtra) {
            this.lCg.setVisibility(8);
        } else {
            this.lCg.setVisibility(0);
        }
        this.lCh = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.lCh.setOnClickListener(this.aEk);
        this.lCi = new com.baidu.tieba.pb.view.c(this.lCh);
        this.lCi.drX();
        this.lCj = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lCj.setVisibility(0);
        uV(false);
    }

    private void dmQ() {
        if (this.lCe != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lCe.setImageResource(0);
            this.lCe.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.lCe.setImageResource(R.drawable.transparent_bg);
    }

    private void bCo() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cyo();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.lMq = this.rootView.findViewById(R.id.status_bar_background);
        if (this.lMH) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(dkB());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.lMq.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(dkB());
            this.lMq.setLayoutParams(layoutParams2);
            this.lMq.setVisibility(0);
        }
        this.fwY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aEk);
        this.gFi = (ImageView) this.fwY.findViewById(R.id.widget_navi_back_button);
        SvgManager.bqB().a(this.gFi, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.lHG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aEk);
        this.agU = (ImageView) this.lHG.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.lHG.setLayoutParams(layoutParams3);
        SvgManager.bqB().a(this.agU, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.lHG.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.iUc);
        this.mNavigationBar.setOnTouchListener(this.lMJ);
    }

    public void dqo() {
        setEditorTools(this.lut.byN());
    }

    private void bTk() {
        this.ltx = new PbFakeFloorModel(getPageContext());
        this.lCK = new v(getPageContext(), this.ltx, this.rootView);
        this.lCK.T(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dmK();
            }
        });
        this.lCK.a(this.lvh);
        this.ltx.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.ltx.t(postData);
                if (com.baidu.tbadk.a.d.bhp() || VideoPbFragment.this.dqD() != null) {
                    VideoPbFragment.this.dqD().drm();
                } else if (VideoPbFragment.this.dqB() != null) {
                    VideoPbFragment.this.dqB().drm();
                }
                VideoPbFragment.this.lCK.djC();
                VideoPbFragment.this.abp.bxk();
                VideoPbFragment.this.uV(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, PostData postData2, boolean z, boolean z2) {
        PbActivity.a OZ;
        String dkU = diV().dkU();
        String id = postData.getId();
        String str = "";
        if (postData2 != null) {
            str = postData2.getId();
        }
        int i = 0;
        if (diV().getPbData() != null) {
            i = diV().getPbData().dhW();
        }
        if (dqB() != null && dqB().dro() != null) {
            OZ = dqB().dro().OZ(id);
        } else if (dqD() != null && dqD().dro() != null) {
            OZ = dqD().dro().OZ(id);
        } else {
            return;
        }
        if (postData != null && diV() != null && diV().getPbData() != null && OZ != null) {
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dkU, id, "pb", true, null, false, str, i, postData.dpH(), diV().getPbData().getAnti(), false, postData.blC().getIconInfo()).addBigImageData(OZ.lqp, OZ.evM, OZ.evK, OZ.index);
            if (z2) {
                addBigImageData.setHighLightPostId(str);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(diV().getForumId());
            addBigImageData.setBjhData(diV().dld());
            addBigImageData.setKeyPageStartFrom(diV().dlE());
            addBigImageData.setFromFrsForumId(diV().getFromForumId());
            addBigImageData.setIsOpenEditor(z);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.ltC = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (diV() != null) {
            diV().aC(bundle);
        }
        if (getPageContext() != null && getPageContext().getPageActivity() != null) {
            getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bDs = true;
        getVoiceManager().onPause(getPageContext());
        this.lMo.rh(true);
        if (diV() != null && !diV().dlb()) {
            this.lut.Dm(diV().dkU());
        }
        com.baidu.tbadk.BdToken.c.bfy().bfJ();
        MessageManager.getInstance().unRegisterListener(this.lva);
        MessageManager.getInstance().unRegisterListener(this.lvb);
        MessageManager.getInstance().unRegisterListener(this.lvc);
        MessageManager.getInstance().unRegisterListener(this.jXy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bDs = false;
        getVoiceManager().onResume(getPageContext());
        this.lMo.rh(false);
        dkx();
        registerListener(this.lva);
        registerListener(this.lvb);
        registerListener(this.lvc);
        registerListener(this.jXy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.lMk != null && this.eKk != null) {
            this.lMk.Ha(z ? this.eKk.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        dmQ();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.t.c.dIO().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.t.c.dIO().A(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.lCi != null) {
            this.lCi.onDestroy();
        }
        if (this.hZq != null) {
            this.hZq.cancelLoadData();
        }
        if (this.lMo != null) {
            this.lMo.onDestroy();
        }
        if (this.ltU != null) {
            this.ltU.cancelLoadData();
        }
        if (this.kwi != null) {
            this.kwi.onDestroy();
        }
        if (diV() != null) {
            diV().cancelLoadData();
            diV().destory();
            if (diV().dly() != null) {
                diV().dly().onDestroy();
            }
        }
        if (this.lut != null) {
            this.lut.onDestroy();
        }
        this.luA = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.ltC);
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        ap.setBackgroundColor(this.mStatusBar, R.color.CAM_X0611);
        ap.setBackgroundColor(this.lMq, R.color.CAM_X0608);
        ap.setBackgroundColor(this.lMj, R.color.CAM_X0207);
        if (this.lMj != null) {
            this.lMj.onChangeSkinType();
        }
        if (this.kzS != null) {
            this.kzS.onChangeSkinType();
        }
        if (this.lMp == null || !this.lMp.isPlaying()) {
            ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        }
        if (this.abp != null) {
            this.abp.onChangeSkinType(i);
        }
        if (this.lCK != null) {
            this.lCK.onChangeSkinType(i);
        }
        if (this.lCe != null) {
            this.lCe.setBorderColor(ap.getColor(R.color.CAM_X0401));
        }
        if (this.lCd != null) {
            this.lCd.setBackgroundDrawable(ap.aP(l.getDimens(getContext(), R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
        }
        if (diV() != null && diV().bhP()) {
            WebPManager.a(this.lCg, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.a(this.lCg, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.a(this.lCf, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        SvgManager.bqB().a(this.lMv, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (diV() != null) {
            x(diV().getPbData());
        }
        ap.setBackgroundResource(this.lMl, R.drawable.personalize_tab_shadow);
        ap.setBackgroundColor(this.lMr, R.color.CAM_X0206);
        ap.setBackgroundColor(this.lCc, R.color.CAM_X0207);
        ap.setBackgroundColor(this.lCb, R.color.CAM_X0203);
        ap.setViewTextColor(this.lMu, R.color.CAM_X0109);
        ap.setViewTextColor(this.lMt, R.color.CAM_X0105);
        ap.setViewTextColor(this.jKO, R.color.CAM_X0109);
        ap.setViewTextColor(this.lCk, R.color.CAM_X0105);
        ap.setViewTextColor(this.lCj, R.color.CAM_X0107);
        ap.c(this.lCj, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        if (com.baidu.tbadk.a.d.bhp() && dqD() != null) {
            dqD().onChangeSkinType(i);
        } else if (dqB() != null) {
            dqB().onChangeSkinType(i);
        }
        if (dqC() != null) {
            dqC().onChangeSkinType(i);
        }
        if (this.lMy != null) {
            this.lMy.setBackgroundDrawable(ap.aP(l.getDimens(this.lMy.getContext(), R.dimen.tbds32), ap.getColor(R.color.CAM_X0309)));
        }
        cyn();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iIc == null) {
            this.iIc = VoiceManager.instance();
        }
        return this.iIc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyn() {
        if (this.iIc != null) {
            this.iIc.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dkz() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dkA() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel diV() {
        return this.ltC.diV();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dkB() {
        return this.ltC;
    }

    public com.baidu.tbadk.baseEditMark.a dqp() {
        return this.luf;
    }

    public View.OnClickListener dqq() {
        return this.aEk;
    }

    public View.OnClickListener dqr() {
        return this.lqU;
    }

    public View.OnLongClickListener dqs() {
        return this.lMB.dqs();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (be.Po(objArr[i].getLink()) && (drawable = ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.d(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                    spannableStringBuilder.setSpan(objArr[i], spannableStringBuilder.getSpanStart(objArr[i]), spannableStringBuilder.length(), 18);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                    spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                    return;
                }
            }
        }
    }

    public BdTypeRecyclerView cBg() {
        Iterator<BaseFragment> it = this.lMk.dqM().iterator();
        while (it.hasNext()) {
            BaseFragment next = it.next();
            if (next instanceof DetailInfoAndReplyFragment) {
                return ((DetailInfoAndReplyFragment) next).getListView();
            }
            if (next instanceof ReplyFragment) {
                return ((ReplyFragment) next).getListView();
            }
        }
        return null;
    }

    private void uk(boolean z) {
        this.lut.kj(z);
        this.lut.kk(z);
        this.lut.kl(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.lMB != null) {
            if (z) {
                this.lMB.dnA();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.lMB.dnB();
            } else {
                this.lMB.dnA();
            }
        }
    }

    public boolean Gn(int i) {
        if (this.kwi == null || diV() == null || diV().getPbData() == null || diV().getPbData().getAnti() == null) {
            return true;
        }
        return this.kwi.aO(diV().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean djU() {
        if ((diV() != null && diV().getPbData().dik()) || this.kwi == null || diV() == null || diV().getPbData() == null || diV().getPbData().getAnti() == null) {
            return true;
        }
        return this.kwi.pp(diV().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && diV() != null) {
            gVar.setForumName(diV().diO());
            if (diV().getPbData() != null && diV().getPbData().getForum() != null) {
                gVar.a(diV().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(diV());
        }
    }

    public void dnb() {
        if (this.abp != null) {
            this.abp.display();
            if (this.lut != null) {
                this.lut.bzy();
            }
            dnK();
        }
    }

    public com.baidu.tbadk.editortools.pb.e djH() {
        return this.lut;
    }

    private boolean djR() {
        PbModel diV = diV();
        if (diV == null || diV.getPbData() == null) {
            return false;
        }
        bx dhH = diV.getPbData().dhH();
        diV.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), dhH);
    }

    public void djS() {
        if (checkUpIsLogin() && diV() != null && diV().getPbData() != null && diV().getPbData().getForum() != null && !djR()) {
            if (diV().getPbData().dik()) {
                cLJ();
                return;
            }
            if (this.iMx == null) {
                this.iMx = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iMx.AA(0);
                this.iMx.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void pL(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void C(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void pM(boolean z) {
                        if (z) {
                            if (VideoPbFragment.this.lut != null && VideoPbFragment.this.lut.byN() != null) {
                                VideoPbFragment.this.lut.byN().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            VideoPbFragment.this.cLJ();
                        }
                    }
                });
            }
            this.iMx.G(diV().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(diV().dkU(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.lut.onActivityResult(i, i2, intent);
        if (this.ltU != null) {
            this.ltU.onActivityResult(i, i2, intent);
        }
        if (this.lCK != null) {
            this.lCK.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dke();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.p.a.dzt().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.luw = emotionImageData;
                        if (Gn(am.eMn)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                default:
                    return;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (dkB() != null) {
            if (this.lMI && !TbSingleton.getInstance().isNotchScreen(dkB()) && !TbSingleton.getInstance().isCutoutScreen(dkB())) {
                dqH();
                UtilHelper.hideStatusBar(dkB(), dkB().getRootView());
                this.lMI = false;
            }
            this.lMC.lMX = z;
            dqt();
            dqu();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.ltC;
        if (i == 0) {
            dmG();
            if (this.lCK != null) {
                this.lCK.djC();
            }
            uV(false);
        }
        dmK();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.lut.resetData();
                        this.lut.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lut.b(writeData);
                        m rI = this.lut.byN().rI(6);
                        if (rI != null && rI.fmx != null) {
                            rI.fmx.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.ltC;
                        if (i == -1) {
                            this.lut.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lCK != null && this.lCK.djG() != null) {
                            com.baidu.tbadk.editortools.pb.h djG = this.lCK.djG();
                            djG.setThreadData(diV().getPbData().dhH());
                            djG.b(writeData);
                            djG.setVoiceModel(pbEditorData.getVoiceModel());
                            m rI2 = djG.byN().rI(6);
                            if (rI2 != null && rI2.fmx != null) {
                                rI2.fmx.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.ltC;
                            if (i == -1) {
                                djG.bzR();
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (diV() != null && !diV().dlb()) {
                    antiData.setBlock_forum_name(diV().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(diV().getPbData().getForum().getId());
                    antiData.setUser_name(diV().getPbData().getUserData().getUserName());
                    antiData.setUser_id(diV().getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            String errorString = postWriteCallBackData.getErrorString();
            String preMsg = postWriteCallBackData.getPreMsg();
            String colorMsg = postWriteCallBackData.getColorMsg();
            if (postWriteCallBackData.getIconStampData() != null) {
                com.baidu.tbadk.coreExtra.c.b.a(getPageContext(), postWriteCallBackData);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bP(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ak("obj_locate", ay.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ak("obj_locate", ay.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ak("obj_locate", ay.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.lMB != null) {
                this.lMB.Ds(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void dkD() {
        if (diV() != null && this.ltC != null) {
            if (this.lut == null || !this.lut.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.lut = (com.baidu.tbadk.editortools.pb.e) dVar.ei(getContext());
                this.lut.a(this.ltC.getPageContext());
                this.lut.a(this.fpd);
                this.lut.a(this.foW);
                this.lut.a(this.ltC.getPageContext(), this.ltC.getIntent() == null ? null : this.ltC.getIntent().getExtras());
                this.lut.byN().kc(true);
                setEditorTools(this.lut.byN());
                if (!diV().dlb()) {
                    this.lut.Dn(diV().dkU());
                }
                if (diV().dlC()) {
                    this.lut.Dl(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.lut.Dl(dmM());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.abp = editorTools;
        this.abp.setId(R.id.pb_editor);
        this.abp.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dmK();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.abp.getParent() == null) {
            this.rootView.addView(this.abp, layoutParams);
        }
        this.abp.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.abp.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof u) {
                    if (((u) aVar.data).buc() == EmotionGroupType.BIG_EMOTION || ((u) aVar.data).buc() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.lut.c((u) aVar.data);
                            VideoPbFragment.this.lut.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dmG();
        this.lut.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.abp != null && VideoPbFragment.this.abp.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.kzS != null && VideoPbFragment.this.kzS.dob() != null) {
                    if (!VideoPbFragment.this.kzS.dob().dSV()) {
                        VideoPbFragment.this.kzS.vb(false);
                    }
                    VideoPbFragment.this.kzS.dob().yx(false);
                }
            }
        });
    }

    public void cLJ() {
        if (!checkUpIsLogin()) {
            if (diV() != null) {
                TiebaStatic.log(new ar("c10517").ak("obj_locate", 2).dR("fid", diV().getForumId()));
            }
        } else if (djU()) {
            if (this.lut != null && (this.lut.bzI() || this.lut.bzJ())) {
                this.lut.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.abp != null) {
                dnb();
                this.lMC.lMW = false;
                if (this.abp.rI(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.abp.rI(2).fmx, false, null);
                }
            }
            dnK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !djR() && djU()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.ltW);
                this.ltX = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.lCK != null && postData != null) {
                String str3 = "";
                if (postData.dJS() != null) {
                    str3 = postData.dJS().toString();
                }
                this.lCK.OT(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.blC().getName_show(), str3));
            }
            if (diV() != null && diV().getPbData() != null && diV().getPbData().dik()) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.ltC.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.ltW[1] + VideoPbFragment.this.ltX) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cBg() != null) {
                            VideoPbFragment.this.cBg().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.lCK != null) {
                            VideoPbFragment.this.lut.byN().setVisibility(8);
                            VideoPbFragment.this.lCK.h(str, str2, VideoPbFragment.this.dmM(), (VideoPbFragment.this.diV() == null || VideoPbFragment.this.diV().getPbData() == null || VideoPbFragment.this.diV().getPbData().dhH() == null || !VideoPbFragment.this.diV().getPbData().dhH().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h djG = VideoPbFragment.this.lCK.djG();
                            if (djG != null && VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null) {
                                djG.a(VideoPbFragment.this.diV().getPbData().getAnti());
                                djG.setThreadData(VideoPbFragment.this.diV().getPbData().dhH());
                            }
                            if (VideoPbFragment.this.kzS.dod() == null && VideoPbFragment.this.lCK.djG().bzZ() != null) {
                                VideoPbFragment.this.lCK.djG().bzZ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kzS != null && VideoPbFragment.this.kzS.doc() != null) {
                                            if (!VideoPbFragment.this.kzS.doc().dSV()) {
                                                VideoPbFragment.this.kzS.vc(false);
                                            }
                                            VideoPbFragment.this.kzS.doc().yx(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kzS.f(VideoPbFragment.this.lCK.djG().bzZ().getInputView());
                                VideoPbFragment.this.lCK.djG().a(VideoPbFragment.this.luy);
                            }
                        }
                        VideoPbFragment.this.dnK();
                    }
                }, 0L);
                return;
            }
            if (this.luv == null) {
                this.luv = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.luv.AA(1);
                this.luv.a(new AnonymousClass48(str, str2));
            }
            if (diV() != null && diV().getPbData() != null && diV().getPbData().getForum() != null) {
                this.luv.G(diV().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(diV().dkU(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$48  reason: invalid class name */
    /* loaded from: classes21.dex */
    public class AnonymousClass48 implements c.a {
        final /* synthetic */ String lvD;
        final /* synthetic */ String lvE;

        AnonymousClass48(String str, String str2) {
            this.lvD = str;
            this.lvE = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pL(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pM(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.ltW[1] + VideoPbFragment.this.ltX) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cBg() != null) {
                            VideoPbFragment.this.cBg().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.lCK != null) {
                            VideoPbFragment.this.lut.byN().setVisibility(8);
                            VideoPbFragment.this.lCK.h(AnonymousClass48.this.lvD, AnonymousClass48.this.lvE, VideoPbFragment.this.dmM(), (VideoPbFragment.this.diV() == null || VideoPbFragment.this.diV().getPbData() == null || VideoPbFragment.this.diV().getPbData().dhH() == null || !VideoPbFragment.this.diV().getPbData().dhH().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h djG = VideoPbFragment.this.lCK.djG();
                            if (djG != null && VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null) {
                                djG.a(VideoPbFragment.this.diV().getPbData().getAnti());
                                djG.setThreadData(VideoPbFragment.this.diV().getPbData().dhH());
                            }
                            if (VideoPbFragment.this.kzS.dod() == null && VideoPbFragment.this.lCK.djG().bzZ() != null) {
                                VideoPbFragment.this.lCK.djG().bzZ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kzS != null && VideoPbFragment.this.kzS.doc() != null) {
                                            if (!VideoPbFragment.this.kzS.doc().dSV()) {
                                                VideoPbFragment.this.kzS.vc(false);
                                            }
                                            VideoPbFragment.this.kzS.doc().yx(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kzS.f(VideoPbFragment.this.lCK.djG().bzZ().getInputView());
                                VideoPbFragment.this.lCK.djG().a(VideoPbFragment.this.luy);
                            }
                        }
                        VideoPbFragment.this.dnK();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData K;
        ac acVar;
        StringBuilder sb = null;
        if (fVar != null && (K = K(fVar)) != null) {
            String userId = K.blC().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, K.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dhW()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (K.blC() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, K.blC().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, K.blC().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, K.blC().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, K.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, K.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dhW()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bt> die = fVar.die();
                if (com.baidu.tbadk.core.util.y.getCount(die) > 0) {
                    sb = new StringBuilder();
                    for (bt btVar : die) {
                        if (btVar != null && !StringUtils.isNull(btVar.getForumName()) && (acVar = btVar.eBt) != null && acVar.ezg && !acVar.ezh && (acVar.type == 1 || acVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(btVar.getForumName(), 12)).append(TbadkCoreApplication.getInst().getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(TbadkCoreApplication.getInst().getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dke() {
        MarkData Gz;
        if (diV() != null && diV().getPbData() != null) {
            if (com.baidu.tbadk.a.d.bhp() || dqB() != null) {
                if ((!com.baidu.tbadk.a.d.bhp() || dqD() != null) && this.luf != null) {
                    if (diV().getPbData() != null && diV().getPbData().dik()) {
                        Gz = diV().Gz(0);
                    } else if (this.eKk != null && this.eKk.getCurrentItem() == lMf) {
                        Gz = diV().o(K(diV().getPbData()));
                    } else if (com.baidu.tbadk.a.d.bhp()) {
                        Gz = diV().Gz(dqD().dnl());
                    } else {
                        Gz = diV().Gz(dqB().dnl());
                    }
                    if (Gz != null) {
                        if (!Gz.isApp() || (Gz = diV().Gz(dqB().dnl() + 1)) != null) {
                            dng();
                            this.luf.a(Gz);
                            if (!this.luf.bhP()) {
                                this.luf.bhR();
                                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                                return;
                            }
                            this.luf.bhQ();
                            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Go(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EmotionImageData emotionImageData) {
        if (emotionImageData != null) {
            if (this.ltU == null) {
                this.ltU = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.ltC);
                this.ltU.b(this.foW);
                this.ltU.c(this.fpd);
            }
            this.ltU.a(emotionImageData, diV(), diV().getPbData());
        }
    }

    public PostData K(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dhU() != null) {
            return fVar.dhU();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dhJ())) {
            Iterator<PostData> it = fVar.dhJ().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dJQ() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dhQ();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.blC() != null && postData.blC().getUserTbVipInfoData() != null && postData.blC().getUserTbVipInfoData().getvipIntro() != null) {
            postData.blC().getGodUserData().setIntro(postData.blC().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dhH() == null || fVar.dhH().blC() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData blC = fVar.dhH().blC();
        String userId = blC.getUserId();
        HashMap<String, MetaData> userMap = fVar.dhH().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = blC;
        }
        postData.Kf(1);
        postData.setId(fVar.dhH().blT());
        postData.setTitle(fVar.dhH().getTitle());
        postData.setTime(fVar.dhH().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dkj() {
        ArrayList<PostData> dhJ;
        int count;
        int i;
        if (diV() == null || diV().getPbData() == null || diV().getPbData().dhJ() == null || (count = com.baidu.tbadk.core.util.y.getCount((dhJ = diV().getPbData().dhJ()))) == 0) {
            return "";
        }
        if (diV().dlm()) {
            Iterator<PostData> it = dhJ.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dJQ() == 1) {
                    return next.getId();
                }
            }
        }
        if (cBg() == null) {
            i = 0;
        } else if (com.baidu.tbadk.a.d.bhp()) {
            i = dqD().dnk();
        } else {
            i = dqB().dnk();
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dhJ, i);
        if (postData == null || postData.blC() == null) {
            return "";
        }
        if (diV().Pc(postData.blC().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(dhJ, i2);
            if (postData2 == null || postData2.blC() == null || postData2.blC().getUserId() == null) {
                break;
            } else if (diV().Pc(postData2.blC().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(dhJ, i3);
            if (postData3 == null || postData3.blC() == null || postData3.blC().getUserId() == null) {
                return "";
            }
            if (diV().Pc(postData3.blC().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkf() {
        if (diV() != null) {
            com.baidu.tieba.pb.data.f pbData = diV().getPbData();
            diV().uA(true);
            if (this.luf != null) {
                pbData.ON(this.luf.bhO());
            }
            if (com.baidu.tbadk.a.d.bhp() && dqD() != null) {
                dqD().drm();
            } else if (dqB() != null) {
                dqB().drm();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (diV() != null) {
            dni();
            diV().uA(z);
            if (this.luf != null) {
                this.luf.is(z);
                if (markData != null) {
                    this.luf.a(markData);
                }
            }
            if (diV().bhP()) {
                dkf();
            } else if (com.baidu.tbadk.a.d.bhp() && dqD() != null) {
                dqD().drm();
            } else if (dqB() != null) {
                dqB().drm();
            }
        }
    }

    public void b(p pVar) {
        boolean z;
        MetaData metaData;
        if (diV() != null && diV().getPbData() != null && pVar.dix() != null) {
            String id = pVar.dix().getId();
            ArrayList<PostData> dhJ = diV().getPbData().dhJ();
            int i = 0;
            while (true) {
                if (i >= dhJ.size()) {
                    z = true;
                    break;
                }
                PostData postData = dhJ.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> diF = pVar.diF();
                    postData.Ke(pVar.getTotalCount());
                    if (postData.dJN() == null || diF == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = diF.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.blC() != null && (metaData = postData.getUserMap().get(next.blC().getUserId())) != null) {
                                next.a(metaData);
                                next.xy(true);
                                next.a(getPageContext(), diV().Pc(metaData.getUserId()));
                            }
                        }
                        z = diF.size() != postData.dJN().size();
                        if (postData.dJN() != null && postData.dJN().size() < 2) {
                            postData.dJN().clear();
                            postData.dJN().addAll(diF);
                        }
                    }
                    if (postData.dJJ() != null) {
                        postData.dJK();
                    }
                }
            }
            if (!diV().getIsFromMark() && z) {
                if (com.baidu.tbadk.a.d.bhp() && dqD() != null) {
                    dqD().drm();
                } else if (dqB() != null) {
                    dqB().drm();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djW() {
        if (diV() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.RC(diV().getForumId()) && diV().getPbData() != null && diV().getPbData().getForum() != null) {
            if (diV().getPbData().getForum().isLike() == 1) {
                diV().dlA().gi(diV().getForumId(), diV().dkU());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            bx dhH = fVar.dhH();
            if (dhH != null && dhH.bkm()) {
                dkD();
            } else {
                d(this.lus);
            }
            if (this.lut != null) {
                uT(this.lut.bzB());
                this.lut.a(fVar.getAnti());
                this.lut.a(fVar.getForum(), fVar.getUserData());
                this.lut.setThreadData(dhH);
                if (diV() != null) {
                    this.lut.a(diV().dlk(), diV().dkU(), diV().dlB());
                }
                if (dhH != null) {
                    this.lut.km(dhH.bnb());
                }
            }
        }
    }

    public void dmK() {
        reset();
        dmG();
        this.lCK.djC();
        uV(false);
    }

    private void reset() {
        if (this.lut != null && this.abp != null) {
            com.baidu.tbadk.editortools.pb.a.bzq().setStatus(0);
            this.lut.bzL();
            this.lut.bza();
            if (this.lut.getWriteImagesInfo() != null) {
                this.lut.getWriteImagesInfo().setMaxImagesAllowed(this.lut.isBJH ? 1 : 9);
            }
            this.lut.rS(SendView.ALL);
            this.lut.rT(SendView.ALL);
            com.baidu.tbadk.editortools.h rF = this.abp.rF(23);
            com.baidu.tbadk.editortools.h rF2 = this.abp.rF(2);
            com.baidu.tbadk.editortools.h rF3 = this.abp.rF(5);
            if (rF2 != null) {
                rF2.display();
            }
            if (rF3 != null) {
                rF3.display();
            }
            if (rF != null) {
                rF.hide();
            }
            this.abp.invalidate();
        }
    }

    public void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dhH() != null) {
            x(fVar);
            this.lCg.setVisibility(fVar.dik() ? 8 : 0);
            if (fVar.bhP()) {
                WebPManager.a(this.lCg, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lCg, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String GH = GH(fVar.dhH().blt());
            if (this.lCj != null) {
                this.lCj.setText(GH);
            }
            if (this.lCk != null) {
                this.lCk.setText(GH);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dhH()));
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bb(fVar.dhH())) {
            if (this.lCi != null) {
                this.lCi.setEnable(false);
                this.lCi.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.lCh.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.lCh.setLayoutParams(layoutParams);
            WebPManager.a(this.lCh, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.lCi == null || !this.lCi.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.lCh.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.lCh.setLayoutParams(layoutParams2);
            WebPManager.a(this.lCh, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    private String GH(int i) {
        if (i == 0) {
            return getString(R.string.pb_comment_red_dot_no_reply);
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (i > 9990000) {
            return "· · ·";
        }
        if (i >= 1000000) {
            numberFormat.setMaximumFractionDigits(0);
            return numberFormat.format(i / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else if (i >= 10000) {
            numberFormat.setMaximumFractionDigits(1);
            return numberFormat.format(i / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else {
            return "" + i;
        }
    }

    public void uV(boolean z) {
        if (this.lCc != null) {
            uT(this.lut.bzB());
            if (this.lBY) {
                uK(z);
            } else {
                uL(z);
            }
            dqt();
            dqu();
        }
    }

    public void dnK() {
        if (this.lCc != null) {
            this.lCb.setVisibility(8);
            this.lCc.setVisibility(8);
            this.lMC.lMW = false;
            dqt();
            dqu();
        }
    }

    private void dqt() {
        if (this.lMo != null) {
            if (this.lMC.dqL()) {
                this.lMo.ww(false);
            } else {
                this.lMo.ww(this.lMo.bWv() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqu() {
        if (this.lMo != null && this.eKk != null) {
            if (com.baidu.tbadk.a.d.bhp()) {
                this.lMo.vE(false);
            } else if (this.eKk.getCurrentItem() != 0) {
                this.lMo.vE(false);
            } else if (this.lMC.dqL()) {
                this.lMo.vE(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.lMo.vE(eVar.dqV() == null || eVar.dqV().getValue() == null || eVar.dqV().getValue().booleanValue());
                }
            }
        }
    }

    private void Gp(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(dkB(), djV(), i);
    }

    private int djV() {
        if (diV() == null || diV().getPbData() == null || diV().getPbData().dhH() == null) {
            return -1;
        }
        return diV().getPbData().dhH().bmp();
    }

    public void uT(boolean z) {
        this.lBY = z;
    }

    public void uK(boolean z) {
        if (this.lCc != null && this.jKO != null) {
            this.jKO.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lCc.startAnimation(alphaAnimation);
            }
            this.lCb.setVisibility(0);
            this.lCc.setVisibility(0);
            this.lMC.lMW = true;
        }
    }

    public void uL(boolean z) {
        if (this.lCc != null && this.jKO != null) {
            this.jKO.setText(dmM());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lCc.startAnimation(alphaAnimation);
            }
            this.lCb.setVisibility(0);
            this.lCc.setVisibility(0);
            this.lMC.lMW = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null && this.lnU == null) {
            this.lnU = aVar;
            this.lMt.setText(aVar.getTitle());
            this.lMu.setText(aVar.drz());
            String drA = aVar.drA();
            TBSpecificationBtn tBSpecificationBtn = this.lMw;
            if (TextUtils.isEmpty(drA)) {
                drA = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(drA);
            this.lMx.startLoad(aVar.getImage(), 10, false);
            this.lMy.setVisibility(aVar.drC() ? 0 : 8);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.lnU == null || VideoPbFragment.this.lnU.drC()) {
                        if (VideoPbFragment.this.lnU != null && VideoPbFragment.this.diV() != null && VideoPbFragment.this.diV().getPbData() != null && VideoPbFragment.this.diV().getPbData().getForum() != null) {
                            TiebaStatic.log(new ar("c13712").dR("fid", VideoPbFragment.this.diV().getPbData().getForum().getId()).dR("fname", VideoPbFragment.this.diV().getPbData().getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.diV().getPbData().getThreadId()).w("obj_param1", VideoPbFragment.this.lnU.userId));
                        }
                    } else {
                        TiebaStatic.log(new ar("c13608").dR("obj_id", VideoPbFragment.this.lnU.getTitle()).dR("obj_name", VideoPbFragment.this.lnU.drz()).ak("obj_type", 2).dR("fid", VideoPbFragment.this.diV().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.diV().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.dqv();
                }
            }, aVar.drB().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqv() {
        ViewGroup.LayoutParams layoutParams = this.lMr.getLayoutParams();
        if (layoutParams != null) {
            if (this.lMz == null || !this.lMz.isRunning()) {
                this.lMr.setAlpha(0.0f);
                this.lMr.setVisibility(0);
                e(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqw() {
        if (this.lMr.getLayoutParams() != null) {
            if (this.lMz == null || !this.lMz.isRunning()) {
                dqx();
            }
        }
    }

    private void dqx() {
        final ViewGroup.LayoutParams layoutParams = this.lMr.getLayoutParams();
        if (layoutParams != null) {
            if (this.lMA == null || !this.lMA.isRunning()) {
                this.lMA = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.lMA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.lMr.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.lMA.setDuration(200L);
                this.lMA.start();
                this.lMA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPbFragment.this.d(layoutParams);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.Ym.getLayoutParams();
        final int i = layoutParams2.height;
        this.lMz = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.lMz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.jHw);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.jHw);
                VideoPbFragment.this.lMr.setLayoutParams(layoutParams);
                VideoPbFragment.this.Ym.setLayoutParams(layoutParams2);
            }
        });
        this.lMz.setDuration(300L);
        this.lMz.start();
        this.lMz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.lMr.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void e(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.Ym.getLayoutParams();
        final int i = layoutParams2.height;
        this.lMz = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lMz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.jHw);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.lMr.setLayoutParams(layoutParams);
                VideoPbFragment.this.Ym.setLayoutParams(layoutParams2);
            }
        });
        this.lMz.setDuration(300L);
        this.lMz.start();
        this.lMz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.dqy();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqy() {
        this.lMz = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lMz.setDuration(300L);
        this.lMz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.lMr.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.lMz.start();
    }

    public String dmM() {
        if (!au.isEmpty(this.lDb)) {
            return this.lDb;
        }
        this.lDb = TbadkCoreApplication.getInst().getResources().getString(com.baidu.tieba.pb.pb.main.ay.dmC());
        return this.lDb;
    }

    public void dni() {
        hideProgressBar();
        if (com.baidu.tbadk.a.d.bhp() && dqD() != null) {
            dqD().endLoadData();
            dqD().dnj();
        } else if (dqB() != null) {
            dqB().endLoadData();
            dqB().dnj();
        }
    }

    public boolean dm(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.biL().isShowImages()) {
                    return OY(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (diV() == null || diV().getPbData() == null) {
                        return true;
                    }
                    if (this.lCK != null) {
                        this.lCK.djC();
                    }
                    p pVar = new p();
                    pVar.a(diV().getPbData().getForum());
                    pVar.setThreadData(diV().getPbData().dhH());
                    pVar.g(postData);
                    this.ltx.d(pVar);
                    this.ltx.setPostId(postData.getId());
                    a(view, postData.blC().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lut != null) {
                        uT(this.lut.bzB());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void dqz() {
        if (this.lut != null) {
            uT(this.lut.bzB());
        }
        dmK();
        this.lMB.dnA();
    }

    private boolean OY(String str) {
        if (!StringUtils.isNull(str) && bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.a.startWebActivity(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void cTa() {
        if (this.lBK != null) {
            this.lBK.setVisibility(0);
        }
    }

    public void cSZ() {
        if (this.lBK != null) {
            this.lBK.setVisibility(8);
        }
    }

    public void GY(int i) {
        if (this.lMl != null) {
            this.lMl.setVisibility(i);
        }
    }

    public void dng() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a djZ() {
        return this.lvj;
    }

    public void dmG() {
        if (this.abp != null) {
            this.abp.hide();
        }
    }

    public void cyo() {
        if (this.ltC.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.ltC.getCurrentFocus());
        }
    }

    public void M(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dhH() != null) {
            String valueOf = String.valueOf(fVar.dhH().blt());
            if (fVar.dhH().blt() == 0) {
                valueOf = "";
            }
            this.lMj.Em(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.lMk.dqM()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (diV() != null && diV().getPbData() != null && diV().getPbData().dhH() != null && diV().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(lCD)).intValue();
                if (intValue == lCE) {
                    if (!this.hZq.dKJ()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.hZq.SE(au.R(jSONArray));
                        }
                        this.hZq.a(diV().getPbData().getForum().getId(), diV().getPbData().getForum().getName(), diV().getPbData().dhH().getId(), str, intValue3, intValue2, booleanValue, diV().getPbData().dhH().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == lCF || intValue == lCH) {
                    if (diV().dlx() != null) {
                        diV().dlx().Gj(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == lCF) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eC(String str, String str2) {
        bf.bqF().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bFM() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bFN() {
        if (this.fFn == null) {
            this.fFn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bFZ */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.biL().isShowImages();
                    foreDrawableImageView.setDefaultBg(ap.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: a */
                public void destroyObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: b */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.k.biL().isShowImages()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(R.drawable.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: c */
                public ImageView passivateObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.fFn;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bFO() {
        if (this.fIE == null) {
            this.fIE = TbRichTextView.A(getPageContext().getPageActivity(), 8);
        }
        return this.fIE;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bFP() {
        if (this.fFo == null) {
            this.fFo = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: csv */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.biL().isShowImages();
                    gifView.setDefaultBg(ap.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
                        gifView.setAdjustViewBounds(false);
                        gifView.setInterceptOnClick(false);
                    } else {
                        gifView.setDefaultResource(R.drawable.icon_click);
                        gifView.setAdjustViewBounds(true);
                        gifView.setInterceptOnClick(true);
                    }
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: g */
                public void destroyObject(GifView gifView) {
                    gifView.setBackgroundDrawable(null);
                    gifView.setImageDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: h */
                public GifView activateObject(GifView gifView) {
                    gifView.setTag(null);
                    if (com.baidu.tbadk.core.k.biL().isShowImages()) {
                        gifView.setAdjustViewBounds(false);
                        gifView.setInterceptOnClick(false);
                    } else {
                        gifView.setDefaultResource(R.drawable.icon_click);
                        gifView.setAdjustViewBounds(true);
                        gifView.setInterceptOnClick(true);
                    }
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: i */
                public GifView passivateObject(GifView gifView) {
                    gifView.release();
                    gifView.onDestroy();
                    gifView.setImageDrawable(null);
                    gifView.bAr();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fFo;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bFQ() {
        if (this.fIF == null) {
            this.fIF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dkE */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dp */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dq */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).bYE();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dr */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fIF;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bFR() {
        if (this.fIG == null) {
            this.fIG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dkG */
                public LinearLayout makeObject() {
                    LinearLayout linearLayout = new LinearLayout(VideoPbFragment.this.getPageContext().getPageActivity());
                    linearLayout.setId(R.id.pb_text_voice_layout);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setGravity(16);
                    linearLayout.setBaselineAligned(true);
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(layoutParams);
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: f */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.fIG;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bFS() {
        this.fIH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dkF */
            public RelativeLayout makeObject() {
                return new RelativeLayout(VideoPbFragment.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public RelativeLayout activateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public RelativeLayout passivateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.fIH;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void au(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.ltN = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void f(Context context, String str, boolean z) {
        if (be.Po(str) && diV() != null && diV().dkU() != null) {
            TiebaStatic.log(new ar("c11664").ak("obj_param1", 1).dR("post_id", diV().dkU()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.flv = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            be.dof().f(getPageContext(), str);
        }
        this.ltN = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void av(Context context, String str) {
        be.dof().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.ltN = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aw(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ax(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.lMB.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b dri = this.lMB.dri();
            if (dri == null) {
                this.lMB.djQ();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                dri.getItemView(1).setVisibility(8);
            } else {
                dri.getItemView(1).setVisibility(0);
            }
            dri.boi();
            this.ltN = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ay(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            bf.bqF().b(getPageContext(), new String[]{str});
            this.ltN = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a dqA() {
        return this.eMq;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bDk() {
        return this.fyo;
    }

    public ReplyFragment dqB() {
        if (this.lMk == null || !(this.lMk.GZ(lMg) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.lMk.GZ(lMg);
    }

    public DetailInfoFragment dqC() {
        if (this.lMk == null || !(this.lMk.GZ(lMf) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.lMk.GZ(lMf);
    }

    public DetailInfoAndReplyFragment dqD() {
        if (this.lMk == null || !(this.lMk.GZ(lMh) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.lMk.GZ(lMh);
    }

    public boolean diN() {
        PbModel diV = this.ltC.diV();
        if (diV == null) {
            return false;
        }
        return diV.diN();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dhT;
        PbModel diV = this.ltC.diV();
        if (diV != null && diV.getPbData() != null && !diV.getPbData().dik()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = diV.getPbData().dhH().getId();
            if (diV.isShareThread() && diV.getPbData().dhH().eEF != null) {
                historyMessage.threadName = diV.getPbData().dhH().eEF.showText;
            } else {
                historyMessage.threadName = diV.getPbData().dhH().getTitle();
            }
            if (diV.isShareThread() && !diN()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = diV.getPbData().getForum().getName();
            }
            ArrayList<PostData> dhJ = diV.getPbData().dhJ();
            int dnk = dqB() != null ? dqB().dnk() : 0;
            if (dhJ != null && dnk >= 0 && dnk < dhJ.size()) {
                historyMessage.postID = dhJ.get(dnk).getId();
            }
            historyMessage.isHostOnly = diV.getHostMode();
            historyMessage.isSquence = diV.dkW();
            historyMessage.isShareThread = diV.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lut != null) {
            this.lut.onDestroy();
        }
        if (diV != null && (diV.dkX() || diV.dkZ())) {
            Intent intent = new Intent();
            intent.putExtra("tid", diV.dkU());
            if (this.lui) {
                if (this.luk) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", diV.cqF());
                }
                if (this.luj) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", diV.getIsGood());
                }
            }
            if (diV.getPbData() != null && System.currentTimeMillis() - this.ltJ >= 40000 && (dhT = diV.getPbData().dhT()) != null && !com.baidu.tbadk.core.util.y.isEmpty(dhT.getDataList())) {
                intent.putExtra("guess_like_data", dhT);
            }
            PbActivity pbActivity = this.ltC;
            PbActivity pbActivity2 = this.ltC;
            pbActivity.setResult(-1, intent);
        }
        if (dkg()) {
            if (diV != null) {
                com.baidu.tieba.pb.data.f pbData = diV.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.ltP) {
                        if (this.lMn != null) {
                            Rect rect = new Rect();
                            this.lMn.getGlobalVisibleRect(rect);
                            as.dmr().h(rect);
                        }
                        as.dmr().GD(this.eKk.getCurrentItem());
                        BdTypeRecyclerView cBg = cBg();
                        Parcelable parcelable = null;
                        if (cBg != null) {
                            parcelable = cBg.onSaveInstanceState();
                        }
                        as.dmr().a(diV.dle(), parcelable, diV.dkW(), diV.getHostMode(), false);
                    }
                }
            } else {
                as.dmr().reset();
            }
            dji();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.lMo != null && !this.lMo.bWv()) {
            if ((this.lMo.isFullScreen() && configuration.orientation == 1) || (!this.lMo.isFullScreen() && configuration.orientation == 2)) {
                this.lMo.vF(false);
            }
        }
    }

    public boolean dqE() {
        if (this.lMo == null) {
            return false;
        }
        return this.lMo.bWv();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.t.c.dIO().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a {
        public boolean lMW;
        public boolean lMX;

        private a() {
            this.lMX = true;
        }

        public boolean dqL() {
            return (this.lMW && this.lMX) ? false : true;
        }
    }

    public void dqF() {
        this.ltY = -1;
        this.ltZ = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkx() {
        if (diV() != null && !au.isEmpty(diV().dkU())) {
            com.baidu.tbadk.BdToken.c.bfy().p(com.baidu.tbadk.BdToken.b.eow, com.baidu.adp.lib.f.b.toLong(diV().dkU(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.lMm.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqG() {
        if (this.lML == null) {
            this.lML = ObjectAnimator.ofFloat(this.lMq, "alpha", 0.0f, 1.0f);
            this.lML.setDuration(200L);
        }
        this.lML.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqH() {
        if (this.lMM == null) {
            this.lMM = ObjectAnimator.ofFloat(this.lMq, "alpha", 1.0f, 0.0f);
            this.lMM.setDuration(200L);
        }
        this.lMM.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dqI() {
        return this.lMo != null && this.lMo.dqJ();
    }

    public boolean dqJ() {
        return this.lMI;
    }

    public void vx(boolean z) {
        this.lMI = z;
    }

    public void ur(boolean z) {
        this.ltQ = z;
    }

    public boolean dkv() {
        return this.ltQ;
    }
}
