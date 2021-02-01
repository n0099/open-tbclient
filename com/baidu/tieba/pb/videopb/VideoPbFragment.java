package com.baidu.tieba.pb.videopb;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
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
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.MaskView;
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
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.q;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.aj;
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.r;
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
import com.google.android.material.appbar.AppBarLayout;
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
/* loaded from: classes2.dex */
public class VideoPbFragment extends BaseFragment implements VoiceManager.c, TbRichTextView.c, h, com.baidu.tieba.pb.videopb.a, b {
    private AppBarLayout ZM;
    private EditorTools acR;
    private ImageView ahC;
    private CustomViewPager eZd;
    public View fLW;
    private com.baidu.adp.lib.d.b<ImageView> fUl;
    private com.baidu.adp.lib.d.b<GifView> fUm;
    private com.baidu.adp.lib.d.b<TextView> fXB;
    private com.baidu.adp.lib.d.b<View> fXC;
    private com.baidu.adp.lib.d.b<LinearLayout> fXD;
    private com.baidu.adp.lib.d.b<RelativeLayout> fXE;
    private ImageView gYc;
    private com.baidu.tieba.callfans.a ixM;
    private VoiceManager jgg;
    private com.baidu.tieba.frs.profession.permission.c jkC;
    private com.baidu.tieba.f.b jlc;
    public View jwO;
    public am kSl;
    public ar kWo;
    private com.baidu.tieba.pb.videopb.c.a lKI;
    private MaskView lPR;
    private PbFakeFloorModel lQO;
    private PbActivity lQT;
    private g lRO;
    private com.baidu.tbadk.editortools.pb.e lRP;
    private com.baidu.tieba.frs.profession.permission.c lRR;
    private EmotionImageData lRS;
    private com.baidu.tbadk.core.view.c lRW;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lRm;
    private View lRo;
    private View lRp;
    private View lRq;
    int lRs;
    private ImageView lZA;
    private com.baidu.tieba.pb.view.d lZB;
    private TextView lZC;
    private TextView lZD;
    private int lZF;
    private int lZG;
    private View lZc;
    private View lZu;
    private LinearLayout lZw;
    private HeadImageView lZx;
    private ImageView lZy;
    private ImageView lZz;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private r mae;
    private String may;
    private NewPagerSlidingTabBaseStrip mjW;
    private VideoPbFragmentAdapter mjX;
    private View mjY;
    private View mjZ;
    private VideoContainerLayout mka;
    private com.baidu.tieba.pb.videopb.videoView.a mkb;
    private e mkc;
    private View mkd;
    private View mke;
    private TextView mkg;
    private TextView mkh;
    private ImageView mki;
    private TBSpecificationBtn mkj;
    private TbImageView mkk;
    private View mkl;
    private ValueAnimator mkm;
    private ValueAnimator mkn;
    public com.baidu.tieba.pb.videopb.b.a mko;
    private float mks;
    private float mkt;
    private boolean mku;
    private ObjectAnimator mky;
    private ObjectAnimator mkz;
    private RelativeLayout rootView;
    public static int mjS = 0;
    public static int mjT = 1;
    public static int mjU = 0;
    public static int lZV = 3;
    public static int lZW = 0;
    public static int lZX = 3;
    public static int lZY = 4;
    public static int lZZ = 5;
    public static int maa = 6;
    private static final int klQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int mjV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a lSP = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void dd(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.dmg();
            } else {
                com.baidu.tieba.pb.a.b.dmf();
            }
        }
    };
    private long lRb = 0;
    private boolean lRi = false;
    View.OnClickListener mkf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.lKI == null || VideoPbFragment.this.lKI.dvh()) {
                if (VideoPbFragment.this.lKI != null) {
                    if (VideoPbFragment.this.lKI.isChushou) {
                        VideoPbFragment.this.eI(VideoPbFragment.this.lKI.thirdRoomId, VideoPbFragment.this.lKI.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.lKI.dvi();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null && VideoPbFragment.this.dmq().getPbData().getForum() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13713").dR("fid", VideoPbFragment.this.dmq().getPbData().getForum().getId()).dR("fname", VideoPbFragment.this.dmq().getPbData().getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.dmq().getPbData().getThreadId()).v("obj_param1", VideoPbFragment.this.lKI.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13590").dR("obj_id", VideoPbFragment.this.lKI.getTitle()).dR("obj_name", VideoPbFragment.this.lKI.dve()).ap("obj_type", 2).dR("fid", VideoPbFragment.this.dmq().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.dmq().getPbData().getThreadId()));
            String link = VideoPbFragment.this.lKI.getLink();
            if (!TextUtils.isEmpty(link)) {
                if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                    bf.bsV().b(VideoPbFragment.this.getPageContext(), new String[]{link});
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
    private com.baidu.tbadk.baseEditMark.a lRB = null;
    private com.baidu.tbadk.coreExtra.model.a faF = null;
    private ForumManageModel geq = null;
    private boolean lRf = false;
    private View lZv = null;
    private TextView kpg = null;
    private boolean lZr = false;
    private String fDL = null;
    private boolean lRE = false;
    private boolean lRF = false;
    private boolean lRG = false;
    private boolean lRh = false;
    int[] lRr = new int[2];
    private int lRt = -1;
    private int lRu = Integer.MIN_VALUE;
    private int lSc = 0;
    private int mkq = Integer.MIN_VALUE;
    private boolean isPaused = false;
    private boolean lRy = com.baidu.tbadk.a.d.biY();
    private final PbModel.a lSF = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h qR;
            VideoPbFragment.this.dqM();
            VideoPbFragment.this.dqH();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.vK(false);
            if (z && fVar != null) {
                cb dkZ = fVar.dkZ();
                ((VideoPbViewModel) ViewModelProviders.of(VideoPbFragment.this.getActivity()).get(VideoPbViewModel.class)).c(fVar, i2);
                VideoPbFragment.this.M(fVar);
                com.baidu.tieba.pb.videopb.c.a dlE = fVar.dlE();
                if (dlE != null && !dlE.mmr) {
                    VideoPbFragment.this.a(dlE);
                }
                VideoPbFragment.this.N(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.lRB != null) {
                    VideoPbFragment.this.lRB.ja(fVar.bjZ());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.fDL = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.fDL) && VideoPbFragment.this.lRP != null && VideoPbFragment.this.lRP.bBh() != null && (qR = VideoPbFragment.this.lRP.bBh().qR(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.fDL)) {
                        ((View) qR).setOnClickListener(VideoPbFragment.this.fEx);
                    }
                }
                if (VideoPbFragment.this.kSl != null && dkZ != null && dkZ.bnQ() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(dkZ.bnQ());
                    VideoPbFragment.this.kSl.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.dmq().dot());
                        jSONObject.put("fid", VideoPbFragment.this.dmq().getForumId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB, jSONObject));
                }
                if (i != 0) {
                    com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
                    lVar.setOpType("2");
                    lVar.start();
                }
                if ((!com.baidu.tbadk.a.d.bja() || VideoPbFragment.this.dui() != null) && VideoPbFragment.this.dug() != null) {
                    if (com.baidu.tbadk.a.d.bja()) {
                        if (i != -1) {
                            ArrayList<PostData> arrayList = null;
                            if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null) {
                                arrayList = VideoPbFragment.this.dmq().getPbData().dlb();
                            }
                            if (y.getCount(arrayList) == 0 || (y.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dNx() == 1)) {
                                if (VideoPbFragment.this.dui().dnT()) {
                                    VideoPbFragment.this.dui().PH(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dui().PH(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dui().PG(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dui().PG("");
                        }
                        VideoPbFragment.this.dui().endLoadData();
                    } else {
                        if (i != -1) {
                            ArrayList<PostData> arrayList2 = null;
                            if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null) {
                                arrayList2 = VideoPbFragment.this.dmq().getPbData().dlb();
                            }
                            if (y.getCount(arrayList2) == 0 || (y.getCount(arrayList2) == 1 && arrayList2.get(0) != null && arrayList2.get(0).dNx() == 1)) {
                                if (VideoPbFragment.this.dug().dnT()) {
                                    VideoPbFragment.this.dug().PH(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dug().PH(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dug().PG(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dug().PG("");
                        }
                        VideoPbFragment.this.dug().endLoadData();
                    }
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.dMr().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0554a lSH = new a.InterfaceC0554a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0554a
        public void g(boolean z, boolean z2, String str) {
            VideoPbFragment.this.dqM();
            if (z && VideoPbFragment.this.dmq() != null) {
                if (VideoPbFragment.this.lRB != null) {
                    VideoPbFragment.this.lRB.ja(z2);
                }
                VideoPbFragment.this.dmq().vo(z2);
                if (VideoPbFragment.this.dmq().bjZ()) {
                    VideoPbFragment.this.dnE();
                } else if (com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dui() != null) {
                    VideoPbFragment.this.dui().duR();
                } else if (VideoPbFragment.this.dug() != null) {
                    VideoPbFragment.this.dug().duR();
                }
                if (z2) {
                    if (VideoPbFragment.this.lRB != null) {
                        if (VideoPbFragment.this.lRB.bkc() != null && VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null && VideoPbFragment.this.dmq().getPbData().dkZ() != null && VideoPbFragment.this.dmq().getPbData().dkZ().bnQ() != null) {
                            MarkData bkc = VideoPbFragment.this.lRB.bkc();
                            MetaData bnQ = VideoPbFragment.this.dmq().getPbData().dkZ().bnQ();
                            if (bkc != null && bnQ != null) {
                                if (!au.equals(TbadkCoreApplication.getCurrentAccount(), bnQ.getUserId()) && !bnQ.hadConcerned()) {
                                    VideoPbFragment.this.mko.b(bnQ);
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
                    VideoPbFragment.this.dnB();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b fDP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBL() {
            if (VideoPbFragment.this.kWo == null || VideoPbFragment.this.kWo.drF() == null || !VideoPbFragment.this.kWo.drF().dWp()) {
                return !VideoPbFragment.this.FI(am.faA);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kWo.drF().dWr());
            if (VideoPbFragment.this.lRP != null && (VideoPbFragment.this.lRP.bCc() || VideoPbFragment.this.lRP.bCd())) {
                VideoPbFragment.this.lRP.a(false, VideoPbFragment.this.kWo.drI());
            }
            VideoPbFragment.this.kWo.vQ(true);
            return true;
        }
    };
    private final CustomMessageListener lSj = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.dmq() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.lRP != null) {
                    VideoPbFragment.this.vI(VideoPbFragment.this.lRP.bBV());
                }
                VideoPbFragment.this.dql();
                VideoPbFragment.this.mko.drd();
            }
        }
    };
    private CustomMessageListener lSm = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        VideoPbFragment.this.b((q) eVar.getData());
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
    private final CustomMessageListener jhJ = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.64
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.isPaused) {
                VideoPbFragment.this.dnW();
            }
        }
    };
    private CustomMessageListener lSG = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.dnv();
            }
        }
    };
    private CustomMessageListener lSy = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.66
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.mko != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mko.lRX) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.mko.ckq();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.mko.getExtra();
                DataRes dataRes = aVar.nJZ;
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
                    VideoPbFragment.this.mko.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.mko.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener lSw = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.mko != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mko.lRX) {
                VideoPbFragment.this.mko.ckq();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                f pbData = VideoPbFragment.this.dmq().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dlp().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lRW.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.mko.Dc(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.mko.dnS();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (au.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.lRW.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lSx = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.mko != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mko.lRX) {
                VideoPbFragment.this.mko.ckq();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lRW.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (au.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.lRW.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b lRU = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBL() {
            if (VideoPbFragment.this.kWo == null || VideoPbFragment.this.kWo.drG() == null || !VideoPbFragment.this.kWo.drG().dWp()) {
                return !VideoPbFragment.this.FI(am.faB);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kWo.drG().dWr());
            if (VideoPbFragment.this.mae != null && VideoPbFragment.this.mae.dne() != null && VideoPbFragment.this.mae.dne().bCd()) {
                VideoPbFragment.this.mae.dne().a(VideoPbFragment.this.kWo.drI());
            }
            VideoPbFragment.this.kWo.vR(true);
            return true;
        }
    };
    private final NewWriteModel.d fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13268");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null) {
                    arVar.dR("fid", VideoPbFragment.this.dmq().getPbData().getForumId());
                }
                arVar.dR("tid", VideoPbFragment.this.dmq().dot());
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            VideoPbFragment.this.cCU();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.dmq() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.dmq().PB(postWriteCallBackData.getPostId());
                    if (com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dui() != null) {
                        VideoPbFragment.this.lSc = VideoPbFragment.this.dui().dqO();
                        VideoPbFragment.this.mkq = VideoPbFragment.this.dui().duU();
                        VideoPbFragment.this.dmq().cZ(VideoPbFragment.this.lSc, VideoPbFragment.this.mkq);
                    } else if (VideoPbFragment.this.dug() != null) {
                        VideoPbFragment.this.lSc = VideoPbFragment.this.dug().dqO();
                        VideoPbFragment.this.mkq = VideoPbFragment.this.dug().duU();
                        VideoPbFragment.this.dmq().cZ(VideoPbFragment.this.lSc, VideoPbFragment.this.mkq);
                    }
                }
                if (VideoPbFragment.this.eZd != null) {
                    if (com.baidu.tbadk.a.d.bja()) {
                        VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mjU);
                    } else {
                        VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mjT);
                    }
                }
                VideoPbFragment.this.mko.drd();
                VideoPbFragment.this.kWo.drE();
                if (VideoPbFragment.this.lRP != null) {
                    VideoPbFragment.this.vI(VideoPbFragment.this.lRP.bBV());
                }
                VideoPbFragment.this.dqh();
                VideoPbFragment.this.vK(true);
                VideoPbFragment.this.dmq().doP();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dui() != null) {
                                VideoPbFragment.this.dui().duR();
                            } else if (VideoPbFragment.this.dug() != null) {
                                VideoPbFragment.this.dug().duR();
                            }
                        }
                    } else if (VideoPbFragment.this.dmq().getHostMode()) {
                        f pbData = VideoPbFragment.this.dmq().getPbData();
                        if (pbData != null && pbData.dkZ() != null && pbData.dkZ().bnQ() != null && (userId = pbData.dkZ().bnQ().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.dmq().doG()) {
                            VideoPbFragment.this.dqK();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.dmq().doG()) {
                        VideoPbFragment.this.dqK();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.uZ(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.lRP.bCc() || VideoPbFragment.this.lRP.bCd()) {
                    VideoPbFragment.this.lRP.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.kWo.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.kSl != null) {
                    VideoPbFragment.this.kSl.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Au(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Au(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13746").ap("obj_locate", 1).ap("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bqx();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13745").ap("obj_locate", 1).ap("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener fEx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.fDL);
        }
    };
    private CustomMessageListener lSl = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.lRP != null) {
                    VideoPbFragment.this.vI(VideoPbFragment.this.lRP.bBV());
                }
                VideoPbFragment.this.vK(false);
            }
        }
    };
    private int mkr = 0;
    private boolean mkv = true;
    private View.OnTouchListener mkw = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.mkr == 1) {
                if (!VideoPbFragment.this.mkv) {
                    VideoPbFragment.this.duk();
                    UtilHelper.showStatusBar(VideoPbFragment.this.doa(), VideoPbFragment.this.doa().getRootView());
                    VideoPbFragment.this.mkv = true;
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(VideoPbFragment.this.mkx);
                    com.baidu.adp.lib.f.e.mA().postDelayed(VideoPbFragment.this.mkx, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (VideoPbFragment.this.mkr == 2 && (VideoPbFragment.this.mkv || VideoPbFragment.this.dum())) {
                VideoPbFragment.this.dul();
                UtilHelper.hideStatusBar(VideoPbFragment.this.doa(), VideoPbFragment.this.doa().getRootView());
                VideoPbFragment.this.mkv = false;
                if (VideoPbFragment.this.mkb != null) {
                    VideoPbFragment.this.mkb.wo(false);
                }
            }
            VideoPbFragment.this.mkr = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener jsz = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.mkr = 0;
            VideoPbFragment.this.mks = 0.0f;
            VideoPbFragment.this.mkt = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.mks += f;
            VideoPbFragment.this.mkt += f2;
            if (VideoPbFragment.this.mkr == 0 && !VideoPbFragment.this.mku && VideoPbFragment.this.mkb != null && !VideoPbFragment.this.mkb.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.mkt) <= Math.abs(VideoPbFragment.this.mks) || VideoPbFragment.this.mkt > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.mkt) > Math.abs(VideoPbFragment.this.mks) && VideoPbFragment.this.mkt > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.mkr = 2;
                    }
                } else {
                    VideoPbFragment.this.mkr = 1;
                }
            }
            return true;
        }
    };
    private Runnable mkx = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.mkv && !VideoPbFragment.this.dum()) {
                VideoPbFragment.this.dul();
                UtilHelper.hideStatusBar(VideoPbFragment.this.doa(), VideoPbFragment.this.doa().getRootView());
                VideoPbFragment.this.mkv = false;
            }
        }
    };
    private final com.baidu.adp.base.e ixR = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.dmq() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.geq.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.geq.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.dmq().doP();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.mhl != 1002 || bVar.hkR) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.mSuccess, dVar.nzx, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.geq.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.geq.getLoadDataMode(), gVar.mSuccess, gVar.nzx, false);
                    VideoPbFragment.this.mko.aZ(gVar.nzA);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener bST = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.jlc.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d lSD = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13268");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null) {
                    arVar.dR("fid", VideoPbFragment.this.dmq().getPbData().getForumId());
                }
                if (VideoPbFragment.this.dmq() != null) {
                    arVar.dR("tid", VideoPbFragment.this.dmq().dot());
                }
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            if (z) {
                if (VideoPbFragment.this.kWo != null) {
                    VideoPbFragment.this.kWo.drD();
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
                if (VideoPbFragment.this.kSl != null) {
                    VideoPbFragment.this.kSl.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Au(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Au(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13746").ap("obj_locate", 1).ap("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bqx();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13745").ap("obj_locate", 1).ap("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.kWo != null) {
                if (VideoPbFragment.this.mae != null && VideoPbFragment.this.mae.dne() != null && VideoPbFragment.this.mae.dne().bCd()) {
                    VideoPbFragment.this.mae.dne().a(postWriteCallBackData);
                }
                VideoPbFragment.this.kWo.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c fDO = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bBM() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public final View.OnClickListener aEh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        /* JADX DEBUG: Multi-variable search result rejected for r1v164, resolved type: com.baidu.tieba.pb.videopb.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray sparseArray;
            boolean J;
            int i = 2;
            int i2 = 3;
            int i3 = 1;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13398");
                    arVar.dR("tid", VideoPbFragment.this.dmq().dot());
                    arVar.dR("fid", VideoPbFragment.this.dmq().getForumId());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.ap("obj_locate", 1);
                    TiebaStatic.log(arVar);
                    if (VideoPbFragment.this.lRf) {
                        VideoPbFragment.this.lRf = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null && VideoPbFragment.this.lQO != null && postData.bnQ() != null && postData.dNx() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.mae != null) {
                                    VideoPbFragment.this.mae.dna();
                                }
                                q qVar = new q();
                                qVar.a(VideoPbFragment.this.dmq().getPbData().getForum());
                                qVar.setThreadData(VideoPbFragment.this.dmq().getPbData().dkZ());
                                qVar.g(postData);
                                VideoPbFragment.this.lQO.d(qVar);
                                VideoPbFragment.this.lQO.setPostId(postData.getId());
                                VideoPbFragment.this.a(view, postData.bnQ().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.dmq().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.lRP != null) {
                                    VideoPbFragment.this.vI(VideoPbFragment.this.lRP.bBV());
                                }
                            }
                        }
                    }
                } else if ((VideoPbFragment.this.dug() != null && VideoPbFragment.this.dug().dqZ() != null && view == VideoPbFragment.this.dug().dqZ()) || ((com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dui() != null && VideoPbFragment.this.dui().dqZ() != null && view == VideoPbFragment.this.dui().dqZ()) || view.getId() == R.id.pb_more)) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.dmq().vm(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        if (com.baidu.tbadk.a.d.bja()) {
                            VideoPbFragment.this.dui().dqL();
                        } else {
                            VideoPbFragment.this.dug().dqL();
                        }
                    }
                } else if (VideoPbFragment.this.mko != null && VideoPbFragment.this.mko.dsl() != null && view == VideoPbFragment.this.mko.dsl().dpF()) {
                    VideoPbFragment.this.mko.baM();
                } else if ((VideoPbFragment.this.mko != null && ((VideoPbFragment.this.mko.dsl() != null && view == VideoPbFragment.this.mko.dsl().dpG()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) || view.getId() == R.id.floor_owner_reply || view.getId() == R.id.reply_title) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.mko.drd();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.cCU();
                        VideoPbFragment.this.dqK();
                        if (view.getId() == R.id.owner_reply) {
                            J = VideoPbFragment.this.dmq().J(true, VideoPbFragment.this.dnI());
                        } else {
                            J = view.getId() == R.id.all_reply ? VideoPbFragment.this.dmq().J(false, VideoPbFragment.this.dnI()) : VideoPbFragment.this.dmq().Py(VideoPbFragment.this.dnI());
                        }
                        view.setTag(Boolean.valueOf(J));
                        if (J) {
                            VideoPbFragment.this.dqG();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.fLW) {
                    if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null) {
                        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar("c13266");
                            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                            arVar2.dR("fid", VideoPbFragment.this.dmq().getPbData().getForumId());
                            arVar2.dR("tid", VideoPbFragment.this.dmq().dot());
                            arVar2.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(arVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.lQT, VideoPbFragment.this.fLW);
                        VideoPbFragment.this.lQT.finish();
                    }
                } else if (view == VideoPbFragment.this.jwO && VideoPbFragment.this.mko != null) {
                    if (!com.baidu.tbadk.util.l.isFastDoubleClick()) {
                        if (VideoPbFragment.this.dmq() == null || VideoPbFragment.this.dmq().getPbData() == null) {
                            l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        ArrayList<PostData> dlb = VideoPbFragment.this.dmq().getPbData().dlb();
                        if ((dlb == null || dlb.size() <= 0) && VideoPbFragment.this.dmq().dov()) {
                            l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12378").dR("tid", VideoPbFragment.this.dmq().dot()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", VideoPbFragment.this.dmq().getForumId()));
                        VideoPbFragment.this.mko.dnw();
                    }
                } else if (VideoPbFragment.this.mko.dsl() != null && view == VideoPbFragment.this.mko.dsl().dpK()) {
                    if (VideoPbFragment.this.dmq() != null) {
                        VideoPbFragment.this.mko.drd();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.cCU();
                            VideoPbFragment.this.dqK();
                            VideoPbFragment.this.dmq().FP(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.mko != null && VideoPbFragment.this.mko.dsl() != null && view == VideoPbFragment.this.mko.dsl().dpG()) {
                    VideoPbFragment.this.mko.baM();
                } else if (VideoPbFragment.this.mko != null && ((VideoPbFragment.this.mko.dsl() != null && view == VideoPbFragment.this.mko.dsl().dpN()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                    VideoPbFragment.this.mko.drd();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.cCU();
                            VideoPbFragment.this.dqK();
                            VideoPbFragment.this.mko.dS(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.dmq().doN()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.mko != null && VideoPbFragment.this.mko.dsl() != null && view == VideoPbFragment.this.mko.dsl().dpE()) {
                    if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null && VideoPbFragment.this.dmq().getPbData().dkZ() != null) {
                        VideoPbFragment.this.mko.baM();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13062"));
                        VideoPbFragment.this.mko.Pt(VideoPbFragment.this.dmq().getPbData().dkZ().bog());
                    }
                } else if (view.getId() == R.id.pb_floor_feedback) {
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (VideoPbFragment.this.mko != null) {
                        VideoPbFragment.this.mko.i(sparseArray);
                    }
                } else if (VideoPbFragment.this.mko != null && VideoPbFragment.this.mko.dsl() != null && view == VideoPbFragment.this.mko.dsl().dpO()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        ap.B(true, false);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).ap("obj_type", 0).ap("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.CAM_X0201_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).ap("obj_type", 1).ap("obj_source", 1));
                    }
                    VideoPbFragment.this.mko.dsk();
                } else if (VideoPbFragment.this.mko != null && (view == VideoPbFragment.this.mko.dqI() || (VideoPbFragment.this.mko.dsl() != null && (view == VideoPbFragment.this.mko.dsl().dpJ() || view == VideoPbFragment.this.mko.dsl().dpH())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if ((VideoPbFragment.this.dmq() != null || VideoPbFragment.this.dmq().getPbData() != null) && !VideoPbFragment.this.geq.dOs()) {
                        VideoPbFragment.this.mko.drd();
                        if (VideoPbFragment.this.mko.dsl() != null && view == VideoPbFragment.this.mko.dsl().dpH()) {
                            if (VideoPbFragment.this.dmq().getPbData().dkZ().bnL() == 1) {
                                i2 = 5;
                            } else {
                                i2 = 4;
                            }
                        } else if (VideoPbFragment.this.mko.dsl() != null && view == VideoPbFragment.this.mko.dsl().dpJ()) {
                            if (VideoPbFragment.this.dmq().getPbData().dkZ().bnM() != 1) {
                                i2 = 6;
                            }
                        } else {
                            i2 = view == VideoPbFragment.this.mko.dqI() ? 2 : 0;
                        }
                        ForumData forum = VideoPbFragment.this.dmq().getPbData().getForum();
                        String name = forum.getName();
                        String id = forum.getId();
                        String id2 = VideoPbFragment.this.dmq().getPbData().dkZ().getId();
                        VideoPbFragment.this.showProgressBar();
                        VideoPbFragment.this.geq.c(id, name, id2, i2, VideoPbFragment.this.mko.dqJ());
                    }
                } else if (VideoPbFragment.this.mko != null && VideoPbFragment.this.mko.dsl() != null && view == VideoPbFragment.this.mko.dsl().dpM()) {
                    if (VideoPbFragment.this.dmq() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.mko.drd();
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.dmq().getPbData(), VideoPbFragment.this.dmq().dov(), 1);
                        if (b2 != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.dmq().getPbData().getForum().getId(), VideoPbFragment.this.dmq().getPbData().getForum().getName(), VideoPbFragment.this.dmq().getPbData().dkZ().getId(), String.valueOf(VideoPbFragment.this.dmq().getPbData().getUserData().getUserId()), (String) b2.get(R.id.tag_forbid_user_name), (String) b2.get(R.id.tag_forbid_user_name_show), (String) b2.get(R.id.tag_forbid_user_post_id), (String) b2.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.mko != null && VideoPbFragment.this.mko.dsl() != null && view == VideoPbFragment.this.mko.dsl().dpI()) {
                    if (VideoPbFragment.this.dmq() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b3 = VideoPbFragment.this.b(VideoPbFragment.this.dmq().getPbData(), VideoPbFragment.this.dmq().dov(), 1);
                        if (b3 != null) {
                            if (StringUtils.isNull((String) b3.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.mko.a(((Integer) b3.get(R.id.tag_del_post_type)).intValue(), (String) b3.get(R.id.tag_del_post_id), ((Integer) b3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b3.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.mko.a(((Integer) b3.get(R.id.tag_del_post_type)).intValue(), (String) b3.get(R.id.tag_del_post_id), ((Integer) b3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b3.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b3.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.mko.baM();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        com.baidu.tbadk.core.util.ar arVar3 = new com.baidu.tbadk.core.util.ar("c13398");
                        arVar3.dR("tid", VideoPbFragment.this.dmq().dot());
                        arVar3.dR("fid", VideoPbFragment.this.dmq().getForumId());
                        arVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar3.ap("obj_locate", 4);
                        TiebaStatic.log(arVar3);
                    }
                    if ((view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.pb_post_reply_count) && !com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(VideoPbFragment.this.getActivity(), "pb_chakanhuifu"))) {
                        VideoPbFragment.this.lRo = view;
                    } else if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").ap("obj_locate", 3).dR("fid", VideoPbFragment.this.dmq().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null) {
                        if (VideoPbFragment.this.mko != null) {
                            VideoPbFragment.this.mko.drd();
                        }
                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                        PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                        PostData postData3 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                        if (postData2 != null) {
                            if (postData2.dNJ() == 1) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12630"));
                            }
                            if (postData2.nxt != null) {
                                com.baidu.tbadk.core.util.ar bsN = postData2.nxt.bsN();
                                bsN.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    bsN.ap("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    bsN.ap("obj_locate", 8);
                                }
                                TiebaStatic.log(bsN);
                            }
                            VideoPbFragment.this.cCU();
                            TiebaStatic.log("c11742");
                            if (postData3 != null) {
                                VideoPbFragment.this.a(postData2, postData3, false, true);
                            } else {
                                VideoPbFragment.this.a(postData2, (PostData) null, false, false);
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                    if (VideoPbFragment.this.dmq() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            com.baidu.tbadk.core.util.ar arVar4 = new com.baidu.tbadk.core.util.ar("c13398");
                            arVar4.dR("tid", VideoPbFragment.this.dmq().dot());
                            arVar4.dR("fid", VideoPbFragment.this.dmq().getForumId());
                            arVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                            arVar4.ap("obj_locate", 6);
                            TiebaStatic.log(arVar4);
                        }
                        if (view.getId() == R.id.post_info_commont_img) {
                            if (!com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(VideoPbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                                VideoPbFragment.this.lRp = view;
                                return;
                            }
                        } else if (view.getId() == R.id.pb_post_reply && !com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(VideoPbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                            VideoPbFragment.this.lRp = view;
                            return;
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData4.nxt != null) {
                                    com.baidu.tbadk.core.util.ar bsN2 = postData4.nxt.bsN();
                                    bsN2.delete("obj_locate");
                                    bsN2.ap("obj_locate", 8);
                                    TiebaStatic.log(bsN2);
                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", VideoPbFragment.this.dmq().dou()).dR("fid", VideoPbFragment.this.dmq().getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData4.getId()).ap("obj_source", 1).ap("obj_type", 3));
                                }
                                if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null && VideoPbFragment.this.lQO != null && postData4.bnQ() != null && postData4.dNx() != 1) {
                                    if (VideoPbFragment.this.mae != null) {
                                        VideoPbFragment.this.mae.dna();
                                    }
                                    if (VideoPbFragment.this.lRy && postData4.dNu() != null && postData4.dNu().size() != 0) {
                                        VideoPbFragment.this.a(postData4, (PostData) null, true, false);
                                        return;
                                    }
                                    q qVar2 = new q();
                                    qVar2.a(VideoPbFragment.this.dmq().getPbData().getForum());
                                    qVar2.setThreadData(VideoPbFragment.this.dmq().getPbData().dkZ());
                                    qVar2.g(postData4);
                                    VideoPbFragment.this.lQO.d(qVar2);
                                    VideoPbFragment.this.lQO.setPostId(postData4.getId());
                                    VideoPbFragment.this.a(view, postData4.bnQ().getUserId(), "", postData4);
                                    if (VideoPbFragment.this.lRP != null) {
                                        VideoPbFragment.this.vI(VideoPbFragment.this.lRP.bBV());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.mko != null && VideoPbFragment.this.dmq() != null) {
                        if (com.baidu.tbadk.a.d.bja() || VideoPbFragment.this.dug() != null) {
                            if (!com.baidu.tbadk.a.d.bja() || VideoPbFragment.this.dui() != null) {
                                VideoPbFragment.this.mko.drd();
                                if (view.getId() != R.id.pb_editor_tool_collection || com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(VideoPbFragment.this.getActivity(), "pb_shoucang"))) {
                                    if (VideoPbFragment.this.FK(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.dmq() != null) {
                                        VideoPbFragment.this.dnD();
                                        if (VideoPbFragment.this.dmq().getPbData() != null && VideoPbFragment.this.dmq().getPbData().dkZ() != null && VideoPbFragment.this.dmq().getPbData().dkZ().bnQ() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", VideoPbFragment.this.dmq().dot()).dR("fid", VideoPbFragment.this.dmq().getPbData().getForumId()).ap("obj_locate", 3).dR("uid", VideoPbFragment.this.dmq().getPbData().dkZ().bnQ().getUserId()));
                                        }
                                        if (VideoPbFragment.this.dmq().getPbData().dkZ() != null && VideoPbFragment.this.dmq().getPbData().dkZ().bnQ() != null && VideoPbFragment.this.dmq().getPbData().dkZ().bnQ().getUserId() != null && VideoPbFragment.this.lRB != null) {
                                            int h = VideoPbFragment.this.mko.h(VideoPbFragment.this.dmq().getPbData());
                                            cb dkZ = VideoPbFragment.this.dmq().getPbData().dkZ();
                                            if (!dkZ.bmx()) {
                                                if (dkZ.bmy()) {
                                                    i = 3;
                                                } else if (dkZ.bpN()) {
                                                    i = 4;
                                                } else {
                                                    i = dkZ.bpO() ? 5 : 1;
                                                }
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12526").dR("tid", VideoPbFragment.this.dmq().dot()).ap("obj_locate", 1).dR("obj_id", VideoPbFragment.this.dmq().getPbData().dkZ().bnQ().getUserId()).ap("obj_type", VideoPbFragment.this.lRB.bjZ() ? 0 : 1).ap("obj_source", h).ap("obj_param1", i));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                VideoPbFragment.this.lRq = view;
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.wl(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.mko != null && VideoPbFragment.this.eZd != null && VideoPbFragment.this.dmq().getPbData() != null && VideoPbFragment.this.dmq().getPbData().dkZ() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        f pbData = VideoPbFragment.this.dmq().getPbData();
                        if (pbData.dkZ().bnH() != 0) {
                            int currentItem = VideoPbFragment.this.eZd.getCurrentItem();
                            if (!com.baidu.tbadk.a.d.bja() && currentItem == VideoPbFragment.mjS) {
                                VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mjT);
                            } else if (com.baidu.tbadk.a.d.bja() || currentItem == VideoPbFragment.mjT) {
                                if (!com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dug() == null) {
                                    return;
                                }
                                if ((!com.baidu.tbadk.a.d.bja() || VideoPbFragment.this.dui() != null) && VideoPbFragment.this.cFO() != null) {
                                    com.baidu.tbadk.core.util.ar dR = new com.baidu.tbadk.core.util.ar("c13403").dR("tid", VideoPbFragment.this.dmq().dot()).dR("fid", VideoPbFragment.this.dmq().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView cFO = VideoPbFragment.this.cFO();
                                    if (cFO != null) {
                                        boolean canScrollVertically = cFO.canScrollVertically(1);
                                        boolean canScrollVertically2 = cFO.canScrollVertically(-1);
                                        if (VideoPbFragment.this.ZM != null) {
                                            VideoPbFragment.this.ZM.setExpanded(false, true);
                                        }
                                        if (cFO.getLayoutManager() != null && (cFO.getLayoutManager() instanceof LinearLayoutManager)) {
                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) cFO.getLayoutManager();
                                            if (!canScrollVertically2 && canScrollVertically) {
                                                if (VideoPbFragment.this.lRt != -1 || VideoPbFragment.this.lRu != Integer.MIN_VALUE) {
                                                    if (VideoPbFragment.this.lRt > 3 || (VideoPbFragment.this.lRt == 3 && VideoPbFragment.this.lRu < (-equipmentHeight))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lRt, VideoPbFragment.this.lRu + equipmentHeight);
                                                        cFO.smoothScrollBy(0, equipmentHeight);
                                                    } else if (VideoPbFragment.this.lRt >= 2) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lRt, VideoPbFragment.this.lRu + (equipmentHeight / 2));
                                                        cFO.smoothScrollBy(0, equipmentHeight / 2);
                                                    } else if (VideoPbFragment.this.lRt == 1) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lRt, VideoPbFragment.this.lRu + (equipmentHeight / 4));
                                                        cFO.smoothScrollBy(0, equipmentHeight / 4);
                                                    } else {
                                                        cFO.smoothScrollBy(0, -VideoPbFragment.this.lRu);
                                                    }
                                                    dR.ap("obj_locate", 2);
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                int firstVisiblePosition = cFO.getFirstVisiblePosition();
                                                View childAt = cFO.getChildAt(0);
                                                int top = childAt == null ? 0 : childAt.getTop();
                                                VideoPbFragment.this.lRt = firstVisiblePosition;
                                                VideoPbFragment.this.lRu = top;
                                                if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && cFO.getCount() >= 6)) {
                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                    cFO.smoothScrollToPosition(0);
                                                } else {
                                                    cFO.smoothScrollToPosition(0);
                                                }
                                                dR.ap("obj_locate", 1);
                                            }
                                            TiebaStatic.log(dR);
                                            com.baidu.tbadk.pageExtra.c bR = com.baidu.tbadk.pageExtra.d.bR(view);
                                            com.baidu.tbadk.core.util.ar arVar5 = new com.baidu.tbadk.core.util.ar("c12942");
                                            arVar5.ap("obj_type", 1);
                                            arVar5.ap("obj_locate", 4);
                                            arVar5.dR("tid", VideoPbFragment.this.dmq().dot());
                                            arVar5.dR(IntentConfig.NID, pbData.dkZ().bmo());
                                            if (bR != null) {
                                                arVar5.dR("obj_cur_page", bR.getCurrentPageKey());
                                            }
                                            if (com.baidu.tbadk.pageExtra.d.bDM() != null) {
                                                arVar5.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDM());
                                            }
                                            TiebaStatic.log(arVar5);
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
                            if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null && VideoPbFragment.this.dmq().getPbData().dkZ() != null && VideoPbFragment.this.dmq().getPbData().dkZ().bnQ() != null) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", VideoPbFragment.this.dmq().dot()).dR("fid", VideoPbFragment.this.dmq().getPbData().getForumId()).ap("obj_locate", 2).dR("uid", VideoPbFragment.this.dmq().getPbData().dkZ().bnQ().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.wm(false);
                        VideoPbFragment.this.dnq();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.lSc >= 0) {
                        if (VideoPbFragment.this.dmq() != null) {
                            VideoPbFragment.this.dmq().dpf();
                        }
                        if (com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dui() != null && VideoPbFragment.this.dui().duP() != null) {
                            VideoPbFragment.this.dui().duP().setData(VideoPbFragment.this.dmq().getPbData());
                        } else if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dug() != null && VideoPbFragment.this.dug().duP() != null) {
                            VideoPbFragment.this.dug().duP().setData(VideoPbFragment.this.dmq().getPbData());
                        }
                        VideoPbFragment.this.lSc = 0;
                        VideoPbFragment.this.mkq = Integer.MIN_VALUE;
                        if (com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dui() != null) {
                            VideoPbFragment.this.dui().dc(VideoPbFragment.this.dmq().dpi(), VideoPbFragment.this.dmq().dpj());
                            VideoPbFragment.this.dmq().cZ(0, 0);
                        } else if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dug() != null) {
                            VideoPbFragment.this.dug().dc(VideoPbFragment.this.dmq().dpi(), VideoPbFragment.this.dmq().dpj());
                            VideoPbFragment.this.dmq().cZ(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.dmq() != null) {
                        com.baidu.tbadk.core.util.ar arVar6 = new com.baidu.tbadk.core.util.ar("c13398");
                        arVar6.dR("tid", VideoPbFragment.this.dmq().dot());
                        arVar6.dR("fid", VideoPbFragment.this.dmq().getForumId());
                        arVar6.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar6.ap("obj_locate", 2);
                        TiebaStatic.log(arVar6);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bh.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.brQ().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.dql();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.dql();
                } else if (VideoPbFragment.this.mko.dsl() != null && view == VideoPbFragment.this.mko.dsl().dpL()) {
                    VideoPbFragment.this.mko.drd();
                    if (VideoPbFragment.this.dmq() != null) {
                        VideoPbFragment.this.ixM.setThreadId(VideoPbFragment.this.dmq().dot());
                    }
                    if (VideoPbFragment.this.dmq() == null || !VideoPbFragment.this.dmq().isPrivacy()) {
                        VideoPbFragment.this.ixM.crP();
                        if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null && VideoPbFragment.this.dmq().getPbData().getThreadId() != null && VideoPbFragment.this.dmq().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                            i3 = 2;
                        }
                        if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null) {
                            VideoPbFragment.this.ixM.k(3, i3, VideoPbFragment.this.dmq().getPbData().getThreadId());
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                    if (VideoPbFragment.this.dmq().getPbData() != null) {
                        VideoPbFragment.this.ixM.k(3, 3, VideoPbFragment.this.dmq().getPbData().getThreadId());
                    }
                } else if (view.getId() == R.id.pb_floor_right_top_feedback || view.getId() == R.id.pb_post_op_more) {
                    com.baidu.tbadk.core.util.ar arVar7 = new com.baidu.tbadk.core.util.ar("c13398");
                    arVar7.dR("tid", VideoPbFragment.this.dmq().dot());
                    arVar7.dR("fid", VideoPbFragment.this.dmq().getForumId());
                    arVar7.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar7.ap("obj_locate", 7);
                    TiebaStatic.log(arVar7);
                    VideoPbFragment.this.mko.wu(false);
                    VideoPbFragment.this.mko.dtX().onLongClick(view);
                }
            }
        }
    };
    private View.OnClickListener lOd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.mko != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.mko.f(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.mko.dL(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.mko.f(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.mko.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private CustomMessageListener juD = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(VideoPbFragment.this.getPageContext(), VideoPbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            VideoPbFragment.this.mko.wu(true);
            return VideoPbFragment.this.mko.dtX().onLongClick(view);
        }
    };
    public SortSwitchButton.a lSB = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zp(int i) {
            if (VideoPbFragment.this.mko != null) {
                VideoPbFragment.this.mko.drd();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.dmq() == null || VideoPbFragment.this.dmq().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.cCU();
                VideoPbFragment.this.dqK();
                if (VideoPbFragment.this.dmq().getPbData() != null && VideoPbFragment.this.dmq().getPbData().lJY != null && VideoPbFragment.this.dmq().getPbData().lJY.size() > i) {
                    int intValue = VideoPbFragment.this.dmq().getPbData().lJY.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13699").dR("tid", VideoPbFragment.this.dmq().dou()).dR("fid", VideoPbFragment.this.dmq().getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).ap("obj_type", FN(intValue)));
                    if (VideoPbFragment.this.dmq().FU(intValue)) {
                        VideoPbFragment.this.mIsLoading = true;
                    }
                }
                return true;
            }
        }

        private int FN(int i) {
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
    private a mkp = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void dnB() {
        if (dmq() != null && dmq().getPbData() != null && dmq().getPbData().dkZ() != null) {
            cb dkZ = dmq().getPbData().dkZ();
            dkZ.mRecomAbTag = dmq().dpp();
            dkZ.mRecomWeight = dmq().dpn();
            dkZ.mRecomSource = dmq().dpo();
            dkZ.mRecomExtra = dmq().dpq();
            dkZ.eUg = dmq().doB();
            if (dkZ.getFid() == 0) {
                dkZ.setFid(com.baidu.adp.lib.f.b.toLong(dmq().getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dkZ, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uZ(boolean z) {
        if (dmq() != null && dmq().getPbData() != null && dmq().getPbData().dkZ() != null) {
            cb dkZ = dmq().getPbData().dkZ();
            dkZ.mRecomAbTag = dmq().dpp();
            dkZ.mRecomWeight = dmq().dpn();
            dkZ.mRecomSource = dmq().dpo();
            dkZ.mRecomExtra = dmq().dpq();
            if (dkZ.getFid() == 0) {
                dkZ.setFid(com.baidu.adp.lib.f.b.toLong(dmq().getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dkZ, "c13563");
            TbPageTag ft = com.baidu.tbadk.pageInfo.c.ft(getContext());
            if (a2 != null && ft != null && PageStayDurationConstants.PageName.VIDEO_LIST.equals(ft.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            if (a2 != null) {
                a2.ap("reply_type", 1);
                if (z) {
                    a2.ap("obj_type", 2);
                } else {
                    a2.ap("obj_type", 1);
                }
                com.baidu.tbadk.pageExtra.c fq = com.baidu.tbadk.pageExtra.d.fq(getContext());
                if (fq != null) {
                    a2.dR("obj_cur_page", fq.getCurrentPageKey());
                }
                if (com.baidu.tbadk.pageExtra.d.bDM() != null) {
                    a2.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDM());
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
            String string = !TextUtils.isEmpty(bVar.nzx) ? bVar.nzx : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.Au(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.jF(true);
                aVar.b(getPageContext());
                aVar.bqx();
            } else {
                a(0, bVar.mSuccess, bVar.nzx, z);
            }
            if (bVar.mSuccess) {
                if (bVar.iNf == 1) {
                    ArrayList<PostData> dlb = dmq().getPbData().dlb();
                    int size = dlb.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dlb.get(i).getId())) {
                            i++;
                        } else {
                            dlb.remove(i);
                            break;
                        }
                    }
                    dmq().getPbData().dkZ().nk(dmq().getPbData().dkZ().bnH() - 1);
                    if (com.baidu.tbadk.a.d.bja() && dui() != null) {
                        dui().duR();
                    } else if (dug() != null) {
                        dug().duR();
                    }
                } else if (bVar.iNf == 0) {
                    dnC();
                } else if (bVar.iNf == 2) {
                    ArrayList<PostData> dlb2 = dmq().getPbData().dlb();
                    int size2 = dlb2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dlb2.get(i2).dNu().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dlb2.get(i2).dNu().get(i3).getId())) {
                                i3++;
                            } else {
                                dlb2.get(i2).dNu().remove(i3);
                                dlb2.get(i2).dNw();
                                z2 = true;
                                break;
                            }
                        }
                        dlb2.get(i2).Te(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        if (com.baidu.tbadk.a.d.bja() && dui() != null) {
                            dui().duR();
                        } else if (dug() != null) {
                            dug().duR();
                        }
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = dmq().getPbData().dln().lLH;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dNu().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dNu().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dNu().remove(i2);
                    list.get(i).dNw();
                    z = true;
                    break;
                }
            }
            list.get(i).Te(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            if (com.baidu.tbadk.a.d.bja() && dui() != null) {
                dui().duR();
            } else if (dug() != null) {
                dug().duR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (gVar != null && dmq() != null && dmq().getPbData() != null && dmq().getPbData().dkZ() != null) {
            a(this.geq.getLoadDataMode(), gVar.mSuccess, gVar.nzx, false);
            if (gVar.mSuccess) {
                this.lRE = true;
                if (i == 2 || i == 3) {
                    this.lRF = true;
                    this.lRG = false;
                } else if (i == 4 || i == 5) {
                    this.lRF = false;
                    this.lRG = true;
                }
                if (i == 2) {
                    dmq().getPbData().dkZ().nn(1);
                    dmq().setIsGood(1);
                } else if (i == 3) {
                    dmq().getPbData().dkZ().nn(0);
                    dmq().setIsGood(0);
                } else if (i == 4) {
                    dmq().getPbData().dkZ().nm(1);
                    dmq().FO(1);
                } else if (i == 5) {
                    dmq().getPbData().dkZ().nm(0);
                    dmq().FO(0);
                }
            } else {
                if (gVar != null && !TextUtils.isEmpty(gVar.nzx)) {
                    string = gVar.nzx;
                } else {
                    string = getString(R.string.operation_failed);
                }
                l.showToast(getPageContext().getPageActivity(), string);
            }
            if (dmq().getPbData().dkZ() != null && duh() != null) {
                duh().dvb();
            }
        }
    }

    private void dnC() {
        if (dmq().dow() || dmq().doy()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", dmq().dot());
            PbActivity pbActivity = this.lQT;
            PbActivity pbActivity2 = this.lQT;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, dmq().dot()));
        if (dnF()) {
            this.lQT.finish();
        }
    }

    private boolean dnF() {
        if (dmq() == null) {
            return true;
        }
        if (dmq().getPbData() == null || !dmq().getPbData().dlC()) {
            if (dmq().bjZ()) {
                final MarkData doO = dmq().doO();
                if (doO == null || !dmq().getIsFromMark() || cFO() == null) {
                    return true;
                }
                final MarkData FV = dmq().FV(cFO().getFirstVisiblePosition());
                if (FV == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", doO);
                    this.lQT.setResult(-1, intent);
                    return true;
                } else if (FV.getPostId() == null || FV.getPostId().equals(doO.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", doO);
                    this.lQT.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.Au(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.lRB != null) {
                                if (VideoPbFragment.this.lRB.bjZ()) {
                                    VideoPbFragment.this.lRB.bka();
                                    VideoPbFragment.this.lRB.ja(false);
                                }
                                VideoPbFragment.this.lRB.a(FV);
                                VideoPbFragment.this.lRB.ja(true);
                                VideoPbFragment.this.lRB.bkb();
                            }
                            doO.setPostId(FV.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", doO);
                            VideoPbFragment.this.lQT.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dmE();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, true));
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", doO);
                            VideoPbFragment.this.lQT.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dmE();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, false));
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.bqx();
                    return false;
                }
            } else if (dmq().getPbData() == null || dmq().getPbData().dlb() == null || dmq().getPbData().dlb().size() <= 0 || !dmq().getIsFromMark()) {
                return true;
            } else {
                this.lQT.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmE() {
        this.lQT.dmE();
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
    public void wl(boolean z) {
        com.baidu.tieba.pb.data.f pbData;
        int i;
        if (dmq() != null && this.mko != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = dmq().getPbData()) != null) {
                cb dkZ = pbData.dkZ();
                if (dkZ != null && dkZ.bnQ() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", dmq().dot()).dR("fid", pbData.getForumId()).ap("obj_locate", 4).dR("uid", dkZ.bnQ().getUserId()));
                }
                if (dkZ != null) {
                    if (dkZ.bmx()) {
                        i = 2;
                    } else if (dkZ.bmy()) {
                        i = 3;
                    } else if (dkZ.bpN()) {
                        i = 4;
                    } else if (dkZ.bpO()) {
                        i = 5;
                    }
                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    arVar.dR("tid", dmq().dot());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.dR("fid", dmq().getForumId());
                    if (!z) {
                        arVar.ap("obj_locate", 6);
                    } else {
                        arVar.ap("obj_locate", 5);
                    }
                    arVar.ap("obj_name", i);
                    arVar.ap("obj_type", 2);
                    if (dkZ != null) {
                        if (dkZ.bmx()) {
                            arVar.ap("obj_type", 10);
                        } else if (dkZ.bmy()) {
                            arVar.ap("obj_type", 9);
                        } else if (dkZ.bpO()) {
                            arVar.ap("obj_type", 8);
                        } else if (dkZ.bpN()) {
                            arVar.ap("obj_type", 7);
                        } else if (dkZ.isShareThread) {
                            arVar.ap("obj_type", 6);
                        } else if (dkZ.threadType == 0) {
                            arVar.ap("obj_type", 1);
                        } else if (dkZ.threadType == 40) {
                            arVar.ap("obj_type", 2);
                        } else if (dkZ.threadType == 49) {
                            arVar.ap("obj_type", 3);
                        } else if (dkZ.threadType == 54) {
                            arVar.ap("obj_type", 4);
                        } else {
                            arVar.ap("obj_type", 5);
                        }
                        arVar.dR(IntentConfig.NID, dkZ.bmo());
                        arVar.ap(IntentConfig.CARD_TYPE, dkZ.bpR());
                        arVar.dR(IntentConfig.RECOM_SOURCE, dkZ.mRecomSource);
                        arVar.dR("ab_tag", dkZ.mRecomAbTag);
                        arVar.dR("weight", dkZ.mRecomWeight);
                        arVar.dR("extra", dkZ.mRecomExtra);
                        arVar.dR(IntentConfig.NID, dkZ.bmo());
                        if (dkZ.getBaijiahaoData() != null && !au.isEmpty(dkZ.getBaijiahaoData().oriUgcVid)) {
                            arVar.dR("obj_param6", dkZ.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (doa() != null) {
                        com.baidu.tbadk.pageInfo.c.b(doa(), arVar);
                    }
                    TiebaStatic.log(arVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (dmq().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> dlb = pbData.dlb();
                        if ((dlb == null || dlb.size() <= 0) && dmq().dov()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.mko.drd();
                        cCU();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11939"));
                        if (!AntiHelper.d(getContext(), dkZ)) {
                            if (this.lZB != null) {
                                this.lZB.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                FL(z ? 2 : 1);
                                return;
                            }
                            this.mko.showLoadingDialog();
                            dmq().doZ().z(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                arVar2.dR("tid", dmq().dot());
                arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar2.dR("fid", dmq().getForumId());
                if (!z) {
                }
                arVar2.ap("obj_name", i);
                arVar2.ap("obj_type", 2);
                if (dkZ != null) {
                }
                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (doa() != null) {
                }
                TiebaStatic.log(arVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment dtN() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
        M(videoPbViewModel.dus());
        N(videoPbViewModel.dus());
        if (dmq() != null && dmq().getPbData() != null) {
            boolean isFromMark = dmq().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = dmq().getPbData();
            if (isFromMark) {
                PostData L = L(pbData);
                if (pbData.bjY() != null && !pbData.bjY().equals(L.getId()) && this.eZd != null) {
                    if (com.baidu.tbadk.a.d.bja()) {
                        this.eZd.setCurrentItem(mjU);
                    } else {
                        this.eZd.setCurrentItem(mjT);
                    }
                }
            }
        }
        videoPbViewModel.dut().observe(this, new Observer<cb>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aS */
            public void onChanged(@Nullable cb cbVar) {
                BdTypeRecyclerView cFO;
                if (cbVar != null && cbVar.boh() != null) {
                    if (VideoPbFragment.this.mkb.getVideoUrl() == null || !VideoPbFragment.this.mkb.getVideoUrl().equals(cbVar.boh().video_url)) {
                        if (!au.isEmpty(VideoPbFragment.this.mkb.getVideoUrl())) {
                            VideoPbFragment.this.lRh = true;
                            if (com.baidu.tbadk.a.d.bja()) {
                                VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mjU);
                            } else {
                                VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mjS);
                            }
                            if (com.baidu.tbadk.a.d.bja() && (cFO = VideoPbFragment.this.cFO()) != null) {
                                cFO.scrollToPosition(0);
                            }
                        }
                        if (VideoPbFragment.this.mkc == null || !VideoPbFragment.this.mkc.isPlaying()) {
                            VideoPbFragment.this.dtO();
                            VideoPbFragment.this.aR(cbVar);
                        }
                        VideoPbFragment.this.dtP();
                        if (VideoPbFragment.this.mkc.duF()) {
                            VideoPbFragment.this.mkc.start();
                        }
                        boolean z = !au.equals(VideoPbFragment.this.mkb.getVideoUrl(), cbVar.boh().video_url);
                        VideoPbFragment.this.mkb.setData(cbVar);
                        if (com.baidu.tbadk.a.d.bja()) {
                            VideoPbFragment.this.mkb.ww(false);
                        } else {
                            VideoPbFragment.this.mkb.ww(VideoPbFragment.this.eZd.getCurrentItem() == 0);
                        }
                        if (z) {
                            VideoPbFragment.this.mkb.startPlay();
                            VideoPbFragment.this.mkb.dvs();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.mkb.setData(cbVar);
                }
            }
        });
        videoPbViewModel.duB().observe(this, new Observer<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: r */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.eZd.setCurrentItem(num.intValue());
            }
        });
        videoPbViewModel.dux().observe(this, new Observer<cb>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aS */
            public void onChanged(@Nullable cb cbVar) {
                VideoPbFragment.this.mkb.aW(cbVar);
            }
        });
        videoPbViewModel.duy().observe(this, new Observer<cb>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aS */
            public void onChanged(@Nullable cb cbVar) {
                VideoPbFragment.this.mkb.aX(cbVar);
            }
        });
        videoPbViewModel.duz().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.dtZ();
            }
        });
        videoPbViewModel.duA().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtO() {
        ViewGroup.LayoutParams layoutParams = this.mke.getLayoutParams();
        layoutParams.height = 0;
        this.mke.setLayoutParams(layoutParams);
        this.mke.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtP() {
        if (this.mkc == null) {
            this.mkc = new e(getBaseFragmentActivity(), this.mka);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(doa()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.mka.getOriginHeight() + statusBarHeight);
            final VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.mkc.b(videoPbViewModel.duu(), rect);
            if (this.mkc.duF()) {
                this.mkc.c(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (com.baidu.tbadk.a.d.bja()) {
                            if (videoPbViewModel.duv() || VideoPbFragment.this.dmq().dps() == VideoPbFragment.mjU) {
                                VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mjU);
                            }
                        } else if (videoPbViewModel.duv() || VideoPbFragment.this.dmq().dps() == VideoPbFragment.mjT) {
                            VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mjT);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (com.baidu.tbadk.a.d.bja()) {
                            if (videoPbViewModel.duv() || VideoPbFragment.this.dmq().dps() == VideoPbFragment.mjU) {
                                VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mjU);
                            }
                        } else if (videoPbViewModel.duv() || VideoPbFragment.this.dmq().dps() == VideoPbFragment.mjT) {
                            VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mjT);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (com.baidu.tbadk.a.d.bja()) {
                if (videoPbViewModel.duv() || dmq().dps() == mjU) {
                    this.eZd.setCurrentItem(mjU);
                }
            } else if (videoPbViewModel.duv() || dmq().dps() == mjT) {
                this.eZd.setCurrentItem(mjT);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.mku && (this.mkv || dum())) {
            dul();
            UtilHelper.hideStatusBar(doa(), doa().getRootView());
            this.mkv = false;
            if (this.mkb != null) {
                this.mkb.wo(false);
            }
        }
        if (i == 4) {
            return this.mkb.dAA();
        }
        if (i == 24) {
            return this.mkb.dvp();
        }
        if (i == 25) {
            return this.mkb.dvq();
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
    public void aR(cb cbVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect dpr;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (cbVar != null && cbVar.boh() != null) {
            int intValue = cbVar.boh().video_width.intValue();
            int intValue2 = cbVar.boh().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (dmq() != null || (dpr = dmq().dpr()) == null) ? ceil : dpr.height();
                i = 0;
                layoutParams = this.mka.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.mka.setLayoutParams(layoutParams);
                this.mka.setMaxHeight(ceil);
                this.mka.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.mka.setOriginHeight(height);
                if (!com.baidu.tbadk.a.d.bja()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mjW.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, mjV);
                    } else {
                        layoutParams3.height = mjV;
                    }
                    this.mjW.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.ZM.getLayoutParams();
                if (!com.baidu.tbadk.a.d.bja()) {
                    ceil += mjV;
                }
                if (layoutParams2 != null) {
                    layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                } else {
                    layoutParams2.height = ceil;
                }
                this.ZM.setLayoutParams(layoutParams2);
                if (i == 0 && (this.ZM.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.ZM.getLayoutParams()).getBehavior();
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
        if (dmq() != null) {
        }
        i = 0;
        layoutParams = this.mka.getLayoutParams();
        if (layoutParams != null) {
        }
        this.mka.setLayoutParams(layoutParams);
        this.mka.setMaxHeight(ceil2);
        this.mka.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.mka.setOriginHeight(height);
        if (!com.baidu.tbadk.a.d.bja()) {
        }
        layoutParams2 = (CoordinatorLayout.LayoutParams) this.ZM.getLayoutParams();
        if (!com.baidu.tbadk.a.d.bja()) {
        }
        if (layoutParams2 != null) {
        }
        this.ZM.setLayoutParams(layoutParams2);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.lRb = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        at(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.lRW = new com.baidu.tbadk.core.view.c();
        this.lRW.toastTime = 1000L;
        if (this.mko != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.mko.lRX;
            userMuteAddAndDelCustomMessage.setTag(this.mko.lRX);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.mko.lRX;
            userMuteCheckCustomMessage.setTag(this.mko.lRX);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.ixM = new com.baidu.tieba.callfans.a(getPageContext());
        com.baidu.tieba.s.c.dMr().A(getUniqueId());
    }

    private void initData() {
        this.lRB = com.baidu.tbadk.baseEditMark.a.a(this.lQT);
        if (this.lRB != null) {
            this.lRB.a(this.lSH);
        }
        this.geq = new ForumManageModel(this.lQT);
        this.geq.setLoadDataCallBack(this.ixR);
        this.faF = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.mko = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void at(Bundle bundle) {
        this.lRO = new g();
        d(this.lRO);
        this.lRP = (com.baidu.tbadk.editortools.pb.e) this.lRO.fg(getActivity());
        this.lRP.a(this.lQT.getPageContext());
        this.lRP.a(this.fDW);
        this.lRP.a(this.fDO);
        this.lRP.setFrom(1);
        this.lRP.a(this.lQT.getPageContext(), bundle);
        this.lRP.bBh().c(new k(getActivity()));
        this.lRP.bBh().kN(true);
        uY(true);
        this.lRP.a(dmq().doK(), dmq().dot(), dmq().dpb());
        registerListener(this.lSm);
        registerListener(this.lSG);
        registerListener(this.lSl);
        registerListener(this.lSj);
        registerListener(this.jhJ);
        if (!dmq().doB()) {
            this.lRP.CX(dmq().dot());
        }
        if (dmq().dpc()) {
            this.lRP.CV(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.lRP.CV(dqn());
        }
        this.kWo = new ar();
        if (this.lRP.bBN() != null) {
            this.kWo.f(this.lRP.bBN().getInputView());
        }
        this.lRP.a(this.fDP);
        this.kSl = new am(getPageContext());
        this.kSl.a(new am.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == am.faA) {
                        VideoPbFragment.this.lRP.a((String) null, (WriteData) null);
                    } else if (i == am.faB && VideoPbFragment.this.mae != null && VideoPbFragment.this.mae.dne() != null) {
                        VideoPbFragment.this.mae.dne().bCm();
                    } else if (i == am.faC) {
                        VideoPbFragment.this.c(VideoPbFragment.this.lRS);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = (RelativeLayout) layoutInflater.inflate(R.layout.video_pb_fragment, viewGroup, false);
        initUI();
        return this.rootView;
    }

    private void initUI() {
        this.jlc = new com.baidu.tieba.f.b(getActivity());
        this.jlc.a(lSP);
        this.mku = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        bEL();
        this.ZM = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.mjY = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.mka = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.mkb = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.mka);
        this.mkb.setStageType("2002");
        this.mkb.setUniqueId(getUniqueId());
        this.mkb.af(this);
        this.mkb.dT(doa().getRootView());
        this.mkb.dU(this.mkd);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.mjW = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.mke = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.eZd = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.mjZ = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.lPR = (MaskView) this.rootView.findViewById(R.id.mask_view);
        this.mjZ.setOnClickListener(this.aEh);
        dtR();
        dtQ();
        dtS();
        this.mjX = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.eZd.setAdapter(this.mjX);
        this.mjW.setViewPager(this.eZd);
        this.mjW.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dui() != null) {
                        VideoPbFragment.this.dui().wv(false);
                    } else if (VideoPbFragment.this.dug() != null) {
                        VideoPbFragment.this.dug().wv(false);
                    }
                    if (VideoPbFragment.this.duh() != null) {
                        VideoPbFragment.this.duh().wv(true);
                        VideoPbFragment.this.Gv(VideoPbFragment.this.duh().duV() != 0 ? 0 : 8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(VideoPbFragment.this.getActivity()).get(VideoPbViewModel.class);
                    if (videoPbViewModel.duz() != null && videoPbViewModel.duz().getValue() != null && videoPbViewModel.duz().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.mkb.ww(z);
                    VideoPbFragment.this.dql();
                    if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13592").dR("tid", VideoPbFragment.this.dmq().dot()).dR("fid", VideoPbFragment.this.dmq().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.duh() != null) {
                        VideoPbFragment.this.duh().wv(false);
                    }
                    if (com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dui() != null) {
                        VideoPbFragment.this.dui().wv(true);
                        int duV = VideoPbFragment.this.dui().duV();
                        int duW = VideoPbFragment.this.dui().duW();
                        if (duV != 0) {
                            VideoPbFragment.this.Gv(8);
                            VideoPbFragment.this.dui().Gv(0);
                        } else if (duW != 0) {
                            VideoPbFragment.this.dui().Gv(8);
                            VideoPbFragment.this.Gv(0);
                        } else {
                            VideoPbFragment.this.dui().Gv(8);
                            VideoPbFragment.this.Gv(8);
                        }
                    } else if (VideoPbFragment.this.dug() != null) {
                        VideoPbFragment.this.dug().wv(true);
                        int duV2 = VideoPbFragment.this.dug().duV();
                        int duW2 = VideoPbFragment.this.dug().duW();
                        if (duV2 != 0) {
                            VideoPbFragment.this.Gv(8);
                            VideoPbFragment.this.dug().Gv(0);
                        } else if (duW2 != 0) {
                            VideoPbFragment.this.dug().Gv(8);
                            VideoPbFragment.this.Gv(0);
                        } else {
                            VideoPbFragment.this.dug().Gv(8);
                            VideoPbFragment.this.Gv(8);
                        }
                    }
                    VideoPbFragment.this.mkb.ww(false);
                    VideoPbFragment.this.ZM.setExpanded(false, true);
                    if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13593").dR("tid", VideoPbFragment.this.dmq().dot()).dR("fid", VideoPbFragment.this.dmq().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.mjX.Gx(i);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.lZc = this.rootView.findViewById(R.id.viewstub_progress);
        dtT();
        bWn();
        if (!this.mku && this.mkv) {
            dul();
            UtilHelper.hideStatusBar(doa(), doa().getRootView());
            this.mkv = false;
        }
        if (com.baidu.tbadk.a.d.bja()) {
            this.mjW.getLayoutParams().height = 0;
        }
    }

    private void dtQ() {
        this.mkg = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.mkk = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.mkh = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.mki = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.mkj = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.mkl = this.rootView.findViewById(R.id.ala_live_point);
        this.mkk.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.mkk.setConrers(15);
        this.mkj.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.mki.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.lKI == null || VideoPbFragment.this.lKI.dvh()) {
                    if (VideoPbFragment.this.lKI != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13608").dR("tid", VideoPbFragment.this.dmq().getPbData().getThreadId()));
                        VideoPbFragment.this.lKI.mmr = true;
                    }
                } else {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13591"));
                }
                VideoPbFragment.this.dub();
            }
        });
        this.mkj.setOnClickListener(this.mkf);
        this.mke.setOnClickListener(this.mkf);
    }

    private void dtR() {
        this.mjW.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.mjW.setContainerLayoutParams(layoutParams);
        this.mjW.setRectPaintColor(R.color.CAM_X0302);
        this.mjW.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.mjW.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.mjW.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.mjW.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.mjW.setExpandedTabLayoutParams(layoutParams2);
    }

    public void wm(boolean z) {
        if (this.ZM != null) {
            this.ZM.setExpanded(z);
        }
    }

    private void dtS() {
        this.lZu = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.lZv = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.lZF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lZG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lZx = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lZx.setVisibility(0);
        this.lZx.setIsRound(true);
        this.lZx.setBorderWidth(l.getDimens(getContext(), R.dimen.L_X01));
        this.lZx.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.lZx.setPlaceHolder(0);
        dqr();
        this.kpg = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lZw = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lZw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(VideoPbFragment.this.getActivity(), "pb_huitie"))) {
                    VideoPbFragment.this.wm(false);
                    VideoPbFragment.this.dnq();
                    if (VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null && VideoPbFragment.this.dmq().getPbData().dkZ() != null && VideoPbFragment.this.dmq().getPbData().dkZ().bnQ() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13701").dR("tid", VideoPbFragment.this.dmq().dou()).dR("fid", VideoPbFragment.this.dmq().getPbData().getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", VideoPbFragment.this.dmq().dot()).dR("fid", VideoPbFragment.this.dmq().getPbData().getForumId()).ap("obj_locate", 1).dR("uid", VideoPbFragment.this.dmq().getPbData().dkZ().bnQ().getUserId()));
                    }
                }
            }
        });
        this.lZy = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lZy.setOnClickListener(this.aEh);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lZz = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.lZz.setOnClickListener(this.aEh);
        if (booleanExtra) {
            this.lZz.setVisibility(8);
        } else {
            this.lZz.setVisibility(0);
        }
        this.lZA = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.lZA.setOnClickListener(this.aEh);
        this.lZB = new com.baidu.tieba.pb.view.d(this.lZA);
        this.lZB.dvx();
        this.lZC = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lZC.setVisibility(0);
        vK(false);
    }

    public void wn(boolean z) {
        DetailInfoAndReplyFragment dui = dui();
        if (dui != null && dui.duP() != null && dui.duP().duL() != null && dui.duP().duK() != null) {
            dui.duP().duL().uT(z);
            dui.duP().duK().vS(z);
        }
        if (this.lPR != null) {
            this.lPR.setVisibility(z ? 0 : 8);
        }
    }

    private void dqr() {
        if (this.lZx != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lZx.setImageResource(0);
            this.lZx.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.lZx.setImageResource(R.drawable.transparent_bg);
    }

    private void bEL() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cCV();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.mkd = this.rootView.findViewById(R.id.status_bar_background);
        if (this.mku) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(doa());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.mkd.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(doa());
            this.mkd.setLayoutParams(layoutParams2);
            this.mkd.setVisibility(0);
        }
        this.fLW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aEh);
        this.gYc = (ImageView) this.fLW.findViewById(R.id.widget_navi_back_button);
        SvgManager.bsR().a(this.gYc, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jwO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aEh);
        this.ahC = (ImageView) this.jwO.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.jwO.setLayoutParams(layoutParams3);
        SvgManager.bsR().a(this.ahC, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jwO.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.jsz);
        this.mNavigationBar.setOnTouchListener(this.mkw);
    }

    public void dtT() {
        setEditorTools(this.lRP.bBh());
    }

    private void bWn() {
        this.lQO = new PbFakeFloorModel(getPageContext());
        this.mae = new r(getPageContext(), this.lQO, this.rootView);
        this.mae.V(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dql();
            }
        });
        this.mae.a(this.lSD);
        this.lQO.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.lQO.u(postData);
                if (com.baidu.tbadk.a.d.bja() || VideoPbFragment.this.dui() != null) {
                    VideoPbFragment.this.dui().duR();
                } else if (VideoPbFragment.this.dug() != null) {
                    VideoPbFragment.this.dug().duR();
                }
                VideoPbFragment.this.mae.dna();
                VideoPbFragment.this.acR.bzD();
                VideoPbFragment.this.vK(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, PostData postData2, boolean z, boolean z2) {
        PbActivity.a Pw;
        PostData L;
        String dot = dmq().dot();
        String id = postData.getId();
        String str = "";
        if (postData2 != null) {
            str = postData2.getId();
        }
        int i = 0;
        if (dmq().getPbData() != null) {
            i = dmq().getPbData().dlo();
        }
        if (dug() != null && dug().duT() != null) {
            Pw = dug().duT().Pw(id);
        } else if (dui() != null && dui().duT() != null) {
            Pw = dui().duT().Pw(id);
        } else {
            return;
        }
        if (postData != null && dmq() != null && dmq().getPbData() != null && Pw != null) {
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dot, id, "pb", true, null, false, str, i, postData.dtl(), dmq().getPbData().getAnti(), false, postData.bnQ().getIconInfo()).addBigImageData(Pw.lNv, Pw.eJM, Pw.eJK, Pw.index);
            if (z2) {
                addBigImageData.setHighLightPostId(str);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(dmq().getForumId());
            addBigImageData.setBjhData(dmq().doD());
            addBigImageData.setKeyPageStartFrom(dmq().dpe());
            addBigImageData.setFromFrsForumId(dmq().getFromForumId());
            addBigImageData.setIsOpenEditor(z);
            if (dmq().getPbData().dlI() != null) {
                addBigImageData.setHasForumRule(dmq().getPbData().dlI().has_forum_rule.intValue());
            }
            if (dmq().getPbData().getUserData() != null) {
                addBigImageData.setIsManager(dmq().getPbData().getUserData().getIs_manager());
            }
            if (dmq().getPbData().getForum().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(dmq().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(dmq().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (dmq().getPbData().getForum() != null) {
                addBigImageData.setForumHeadUrl(dmq().getPbData().getForum().getImage_url());
                addBigImageData.setUserLevel(dmq().getPbData().getForum().getUser_level());
            }
            if (dmq() != null && (L = L(dmq().getPbData())) != null) {
                addBigImageData.setMainPostMaskVisibly(L.nxk || postData.nxk);
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lQT = (PbActivity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (dmq() != null) {
            dmq().aD(bundle);
        }
        if (getPageContext() != null && getPageContext().getPageActivity() != null) {
            getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isPaused = true;
        getVoiceManager().onPause(getPageContext());
        this.mkb.sp(true);
        if (dmq() != null && !dmq().doB()) {
            this.lRP.CW(dmq().dot());
        }
        com.baidu.tbadk.BdToken.c.bhn().bhy();
        MessageManager.getInstance().unRegisterListener(this.lSw);
        MessageManager.getInstance().unRegisterListener(this.lSx);
        MessageManager.getInstance().unRegisterListener(this.lSy);
        MessageManager.getInstance().unRegisterListener(this.juD);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        getVoiceManager().onResume(getPageContext());
        this.mkb.sp(false);
        dnW();
        registerListener(this.lSw);
        registerListener(this.lSx);
        registerListener(this.lSy);
        registerListener(this.juD);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.mjX != null && this.eZd != null) {
            this.mjX.Gx(z ? this.eZd.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        dqr();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.dMr().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dMr().B(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.lZB != null) {
            this.lZB.onDestroy();
        }
        if (this.geq != null) {
            this.geq.cancelLoadData();
        }
        if (this.mkb != null) {
            this.mkb.onDestroy();
        }
        if (this.lRm != null) {
            this.lRm.cancelLoadData();
        }
        if (this.kSl != null) {
            this.kSl.onDestroy();
        }
        if (dmq() != null) {
            dmq().cancelLoadData();
            dmq().destory();
            if (dmq().doY() != null) {
                dmq().doY().onDestroy();
            }
        }
        if (this.lRP != null) {
            this.lRP.onDestroy();
        }
        this.lRW = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.lQT);
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        ap.setBackgroundColor(this.mStatusBar, R.color.CAM_X0611);
        ap.setBackgroundColor(this.mkd, R.color.CAM_X0608);
        ap.setBackgroundColor(this.mjW, R.color.CAM_X0207);
        if (this.mjW != null) {
            this.mjW.onChangeSkinType();
        }
        if (this.kWo != null) {
            this.kWo.onChangeSkinType();
        }
        if (this.mkc == null || !this.mkc.isPlaying()) {
            ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        }
        if (this.acR != null) {
            this.acR.onChangeSkinType(i);
        }
        if (this.mae != null) {
            this.mae.onChangeSkinType(i);
        }
        if (this.lZx != null) {
            this.lZx.setBorderColor(ap.getColor(R.color.CAM_X0401));
        }
        if (this.lZw != null) {
            this.lZw.setBackgroundDrawable(ap.aL(l.getDimens(getContext(), R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
        }
        if (dmq() != null && dmq().bjZ()) {
            WebPManager.a(this.lZz, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.a(this.lZz, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.a(this.lZy, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        SvgManager.bsR().a(this.mki, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (dmq() != null) {
            x(dmq().getPbData());
        }
        ap.setBackgroundResource(this.mjY, R.drawable.personalize_tab_shadow);
        ap.setBackgroundColor(this.mke, R.color.CAM_X0206);
        ap.setBackgroundColor(this.lZv, R.color.CAM_X0207);
        ap.setBackgroundColor(this.lZu, R.color.CAM_X0203);
        ap.setViewTextColor(this.mkh, R.color.CAM_X0109);
        ap.setViewTextColor(this.mkg, R.color.CAM_X0105);
        ap.setViewTextColor(this.kpg, R.color.CAM_X0109);
        ap.setViewTextColor(this.lZD, R.color.CAM_X0105);
        ap.setViewTextColor(this.lZC, R.color.CAM_X0107);
        ap.d(this.lZC, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        if (com.baidu.tbadk.a.d.bja() && dui() != null) {
            dui().onChangeSkinType(i);
        } else if (dug() != null) {
            dug().onChangeSkinType(i);
        }
        if (duh() != null) {
            duh().onChangeSkinType(i);
        }
        if (this.mkl != null) {
            this.mkl.setBackgroundDrawable(ap.aL(l.getDimens(this.mkl.getContext(), R.dimen.tbds32), ap.getColor(R.color.CAM_X0309)));
        }
        cCU();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jgg == null) {
            this.jgg = VoiceManager.instance();
        }
        return this.jgg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCU() {
        if (this.jgg != null) {
            this.jgg.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dnY() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dnZ() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dmq() {
        return this.lQT.dmq();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity doa() {
        return this.lQT;
    }

    public com.baidu.tbadk.baseEditMark.a dtU() {
        return this.lRB;
    }

    public View.OnClickListener dtV() {
        return this.aEh;
    }

    public View.OnClickListener dtW() {
        return this.lOd;
    }

    public View.OnLongClickListener dtX() {
        return this.mOnLongClickListener;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (com.baidu.tieba.pb.pb.main.au.PL(objArr[i].getLink()) && (drawable = ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView cFO() {
        Iterator<BaseFragment> it = this.mjX.duq().iterator();
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

    private void uY(boolean z) {
        this.lRP.kV(z);
        this.lRP.kW(z);
        this.lRP.kX(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.mko != null) {
            if (z) {
                this.mko.drd();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.mko.dre();
            } else {
                this.mko.drd();
            }
        }
    }

    public boolean FI(int i) {
        if (this.kSl == null || dmq() == null || dmq().getPbData() == null || dmq().getPbData().getAnti() == null) {
            return true;
        }
        return this.kSl.aK(dmq().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean dnt() {
        if ((dmq() != null && dmq().getPbData().dlC()) || this.kSl == null || dmq() == null || dmq().getPbData() == null || dmq().getPbData().getAnti() == null) {
            return true;
        }
        return this.kSl.ox(dmq().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && dmq() != null) {
            gVar.setForumName(dmq().dmj());
            if (dmq().getPbData() != null && dmq().getPbData().getForum() != null) {
                gVar.a(dmq().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(dmq());
        }
    }

    public void dqC() {
        if (this.acR != null) {
            this.acR.display();
            if (this.lRP != null) {
                this.lRP.bBS();
            }
            drm();
        }
    }

    public com.baidu.tbadk.editortools.pb.e dnf() {
        return this.lRP;
    }

    private boolean dnp() {
        PbModel dmq = dmq();
        if (dmq == null || dmq.getPbData() == null) {
            return false;
        }
        cb dkZ = dmq.getPbData().dkZ();
        dmq.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), dkZ);
    }

    public void dnq() {
        if (checkUpIsLogin() && dmq() != null && dmq().getPbData() != null && dmq().getPbData().getForum() != null && !dnp()) {
            if (dmq().getPbData().dlC()) {
                cSm();
                return;
            }
            if (this.jkC == null) {
                this.jkC = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jkC.Ae(0);
                this.jkC.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qM(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void B(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qN(boolean z) {
                        if (z) {
                            if (VideoPbFragment.this.lRP != null && VideoPbFragment.this.lRP.bBh() != null) {
                                VideoPbFragment.this.lRP.bBh().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            VideoPbFragment.this.cSm();
                        }
                    }
                });
            }
            this.jkC.G(dmq().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dmq().dot(), 0L));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.lRP.onActivityResult(i, i2, intent);
        if (this.lRm != null) {
            this.lRm.onActivityResult(i, i2, intent);
        }
        if (this.mae != null) {
            this.mae.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dnD();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dCR().I(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.lRS = emotionImageData;
                        if (FI(am.faC)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                default:
                    return;
                case 25055:
                    if (this.lRo != null) {
                        this.lRo.performClick();
                        return;
                    }
                    return;
                case 25056:
                    if (this.lRp != null) {
                        this.lRp.performClick();
                        return;
                    }
                    return;
                case 25057:
                    if (drC() != null) {
                        drC().performClick();
                        return;
                    }
                    return;
                case 25058:
                    if (this.lRq != null) {
                        this.lRq.performClick();
                        return;
                    }
                    return;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (doa() != null) {
            if (this.mkv && !TbSingleton.getInstance().isNotchScreen(doa()) && !TbSingleton.getInstance().isCutoutScreen(doa())) {
                dul();
                UtilHelper.hideStatusBar(doa(), doa().getRootView());
                this.mkv = false;
            }
            this.mkp.mkK = z;
            dtY();
            dtZ();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.lQT;
        if (i == 0) {
            dqh();
            if (this.mae != null) {
                this.mae.dna();
            }
            vK(false);
        }
        dql();
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
                        this.lRP.resetData();
                        this.lRP.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lRP.c(writeData);
                        m qU = this.lRP.bBh().qU(6);
                        if (qU != null && qU.fBo != null) {
                            qU.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lQT;
                        if (i == -1) {
                            this.lRP.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.mae != null && this.mae.dne() != null) {
                            com.baidu.tbadk.editortools.pb.h dne = this.mae.dne();
                            dne.setThreadData(dmq().getPbData().dkZ());
                            dne.c(writeData);
                            dne.setVoiceModel(pbEditorData.getVoiceModel());
                            m qU2 = dne.bBh().qU(6);
                            if (qU2 != null && qU2.fBo != null) {
                                qU2.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lQT;
                            if (i == -1) {
                                dne.bCm();
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
                if (dmq() != null && !dmq().doB()) {
                    antiData.setBlock_forum_name(dmq().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(dmq().getPbData().getForum().getId());
                    antiData.setUser_name(dmq().getPbData().getUserData().getUserName());
                    antiData.setUser_id(dmq().getPbData().getUserData().getUserId());
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
                com.baidu.tieba.tbadkCore.writeModel.g.i(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bX(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.mko != null) {
                this.mko.Dc(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void doc() {
        if (dmq() != null && this.lQT != null) {
            if (this.lRP == null || !this.lRP.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.lRP = (com.baidu.tbadk.editortools.pb.e) dVar.fg(getContext());
                this.lRP.a(this.lQT.getPageContext());
                this.lRP.a(this.fDW);
                this.lRP.a(this.fDO);
                this.lRP.a(this.lQT.getPageContext(), this.lQT.getIntent() == null ? null : this.lQT.getIntent().getExtras());
                this.lRP.bBh().kN(true);
                setEditorTools(this.lRP.bBh());
                if (!dmq().doB()) {
                    this.lRP.CX(dmq().dot());
                }
                if (dmq().dpc()) {
                    this.lRP.CV(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.lRP.CV(dqn());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acR = editorTools;
        this.acR.setId(R.id.pb_editor);
        this.acR.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dql();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.acR.getParent() == null) {
            this.rootView.addView(this.acR, layoutParams);
        }
        this.acR.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.acR.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof u) {
                    if (((u) aVar.data).bwv() == EmotionGroupType.BIG_EMOTION || ((u) aVar.data).bwv() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.lRP.c((u) aVar.data);
                            VideoPbFragment.this.lRP.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dqh();
        this.lRP.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.acR != null && VideoPbFragment.this.acR.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.kWo != null && VideoPbFragment.this.kWo.drF() != null) {
                    if (!VideoPbFragment.this.kWo.drF().dWq()) {
                        VideoPbFragment.this.kWo.vQ(false);
                    }
                    VideoPbFragment.this.kWo.drF().zu(false);
                }
            }
        });
    }

    public void cSm() {
        if (!checkUpIsLogin()) {
            if (dmq() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").ap("obj_locate", 2).dR("fid", dmq().getForumId()));
            }
        } else if (dnt()) {
            if (this.lRP != null && (this.lRP.bCc() || this.lRP.bCd())) {
                this.lRP.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.acR != null) {
                dqC();
                this.mkp.mkJ = false;
                if (this.acR.qU(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.acR.qU(2).fBo, false, null);
                }
            }
            drm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dnp() && dnt()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lRr);
                this.lRs = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.mae != null && postData != null) {
                String str3 = "";
                if (postData.dNz() != null) {
                    str3 = postData.dNz().toString();
                }
                this.mae.Pq(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bnQ().getName_show(), str3));
            }
            if (dmq() != null && dmq().getPbData() != null && dmq().getPbData().dlC()) {
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.lQT.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.lRr[1] + VideoPbFragment.this.lRs) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cFO() != null) {
                            VideoPbFragment.this.cFO().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.mae != null) {
                            VideoPbFragment.this.lRP.bBh().setVisibility(8);
                            VideoPbFragment.this.mae.j(str, str2, VideoPbFragment.this.dqn(), (VideoPbFragment.this.dmq() == null || VideoPbFragment.this.dmq().getPbData() == null || VideoPbFragment.this.dmq().getPbData().dkZ() == null || !VideoPbFragment.this.dmq().getPbData().dkZ().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dne = VideoPbFragment.this.mae.dne();
                            if (dne != null && VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null) {
                                dne.a(VideoPbFragment.this.dmq().getPbData().getAnti());
                                dne.setThreadData(VideoPbFragment.this.dmq().getPbData().dkZ());
                            }
                            if (VideoPbFragment.this.kWo.drH() == null && VideoPbFragment.this.mae.dne().bCu() != null) {
                                VideoPbFragment.this.mae.dne().bCu().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kWo != null && VideoPbFragment.this.kWo.drG() != null) {
                                            if (!VideoPbFragment.this.kWo.drG().dWq()) {
                                                VideoPbFragment.this.kWo.vR(false);
                                            }
                                            VideoPbFragment.this.kWo.drG().zu(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kWo.g(VideoPbFragment.this.mae.dne().bCu().getInputView());
                                VideoPbFragment.this.mae.dne().a(VideoPbFragment.this.lRU);
                            }
                        }
                        VideoPbFragment.this.drm();
                    }
                }, 0L);
                return;
            }
            if (this.lRR == null) {
                this.lRR = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lRR.Ae(1);
                this.lRR.a(new AnonymousClass49(str, str2));
            }
            if (dmq() != null && dmq().getPbData() != null && dmq().getPbData().getForum() != null) {
                this.lRR.G(dmq().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dmq().dot(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$49  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass49 implements c.a {
        final /* synthetic */ String lSY;
        final /* synthetic */ String lSZ;

        AnonymousClass49(String str, String str2) {
            this.lSY = str;
            this.lSZ = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qM(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void B(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qN(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.lRr[1] + VideoPbFragment.this.lRs) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cFO() != null) {
                            VideoPbFragment.this.cFO().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.mae != null) {
                            VideoPbFragment.this.lRP.bBh().setVisibility(8);
                            VideoPbFragment.this.mae.j(AnonymousClass49.this.lSY, AnonymousClass49.this.lSZ, VideoPbFragment.this.dqn(), (VideoPbFragment.this.dmq() == null || VideoPbFragment.this.dmq().getPbData() == null || VideoPbFragment.this.dmq().getPbData().dkZ() == null || !VideoPbFragment.this.dmq().getPbData().dkZ().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dne = VideoPbFragment.this.mae.dne();
                            if (dne != null && VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null) {
                                dne.a(VideoPbFragment.this.dmq().getPbData().getAnti());
                                dne.setThreadData(VideoPbFragment.this.dmq().getPbData().dkZ());
                            }
                            if (VideoPbFragment.this.kWo.drH() == null && VideoPbFragment.this.mae.dne().bCu() != null) {
                                VideoPbFragment.this.mae.dne().bCu().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kWo != null && VideoPbFragment.this.kWo.drG() != null) {
                                            if (!VideoPbFragment.this.kWo.drG().dWq()) {
                                                VideoPbFragment.this.kWo.vR(false);
                                            }
                                            VideoPbFragment.this.kWo.drG().zu(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kWo.g(VideoPbFragment.this.mae.dne().bCu().getInputView());
                                VideoPbFragment.this.mae.dne().a(VideoPbFragment.this.lRU);
                            }
                        }
                        VideoPbFragment.this.drm();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData L;
        ad adVar;
        StringBuilder sb = null;
        if (fVar != null && (L = L(fVar)) != null) {
            String userId = L.bnQ().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, L.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dlo()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (L.bnQ() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, L.bnQ().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, L.bnQ().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, L.bnQ().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, L.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, L.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dlo()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bx> dlw = fVar.dlw();
                if (y.getCount(dlw) > 0) {
                    sb = new StringBuilder();
                    for (bx bxVar : dlw) {
                        if (bxVar != null && !StringUtils.isNull(bxVar.getForumName()) && (adVar = bxVar.ePM) != null && adVar.eNw && !adVar.eNx && (adVar.type == 1 || adVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bxVar.getForumName(), 12)).append(TbadkCoreApplication.getInst().getString(R.string.forum)).append("、");
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
    public void dnD() {
        MarkData FV;
        if (dmq() != null && dmq().getPbData() != null) {
            if (com.baidu.tbadk.a.d.bja() || dug() != null) {
                if ((!com.baidu.tbadk.a.d.bja() || dui() != null) && this.lRB != null) {
                    if (dmq().getPbData() != null && dmq().getPbData().dlC()) {
                        FV = dmq().FV(0);
                    } else if (this.eZd != null && this.eZd.getCurrentItem() == mjS) {
                        FV = dmq().o(L(dmq().getPbData()));
                    } else if (com.baidu.tbadk.a.d.bja()) {
                        FV = dmq().FV(dui().dqP());
                    } else {
                        FV = dmq().FV(dug().dqP());
                    }
                    if (FV != null) {
                        if (!FV.isApp() || (FV = dmq().FV(dug().dqP() + 1)) != null) {
                            dqK();
                            this.lRB.a(FV);
                            if (!this.lRB.bjZ()) {
                                this.lRB.bkb();
                                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                                return;
                            }
                            this.lRB.bka();
                            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FK(int i) {
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
            if (this.lRm == null) {
                this.lRm = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lQT);
                this.lRm.b(this.fDO);
                this.lRm.c(this.fDW);
            }
            this.lRm.a(emotionImageData, dmq(), dmq().getPbData());
        }
    }

    public PostData L(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dlm() != null) {
            return fVar.dlm();
        }
        if (!y.isEmpty(fVar.dlb())) {
            Iterator<PostData> it = fVar.dlb().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dNx() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dli();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.bnQ() != null && postData.bnQ().getUserTbVipInfoData() != null && postData.bnQ().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bnQ().getGodUserData().setIntro(postData.bnQ().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dkZ() == null || fVar.dkZ().bnQ() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bnQ = fVar.dkZ().bnQ();
        String userId = bnQ.getUserId();
        HashMap<String, MetaData> userMap = fVar.dkZ().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bnQ;
        }
        postData.JE(1);
        postData.setId(fVar.dkZ().bog());
        postData.setTitle(fVar.dkZ().getTitle());
        postData.setTime(fVar.dkZ().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dnI() {
        ArrayList<PostData> dlb;
        int count;
        int i;
        if (dmq() == null || dmq().getPbData() == null || dmq().getPbData().dlb() == null || (count = y.getCount((dlb = dmq().getPbData().dlb()))) == 0) {
            return "";
        }
        if (dmq().doM()) {
            Iterator<PostData> it = dlb.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dNx() == 1) {
                    return next.getId();
                }
            }
        }
        if (cFO() == null) {
            i = 0;
        } else if (com.baidu.tbadk.a.d.bja()) {
            i = dui().dqO();
        } else {
            i = dug().dqO();
        }
        PostData postData = (PostData) y.getItem(dlb, i);
        if (postData == null || postData.bnQ() == null) {
            return "";
        }
        if (dmq().Pz(postData.bnQ().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) y.getItem(dlb, i2);
            if (postData2 == null || postData2.bnQ() == null || postData2.bnQ().getUserId() == null) {
                break;
            } else if (dmq().Pz(postData2.bnQ().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) y.getItem(dlb, i3);
            if (postData3 == null || postData3.bnQ() == null || postData3.bnQ().getUserId() == null) {
                return "";
            }
            if (dmq().Pz(postData3.bnQ().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnE() {
        if (dmq() != null) {
            com.baidu.tieba.pb.data.f pbData = dmq().getPbData();
            dmq().vo(true);
            if (this.lRB != null) {
                pbData.Pk(this.lRB.bjY());
            }
            if (com.baidu.tbadk.a.d.bja() && dui() != null) {
                dui().duR();
            } else if (dug() != null) {
                dug().duR();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (dmq() != null) {
            dqM();
            dmq().vo(z);
            if (this.lRB != null) {
                this.lRB.ja(z);
                if (markData != null) {
                    this.lRB.a(markData);
                }
            }
            if (dmq().bjZ()) {
                dnE();
            } else if (com.baidu.tbadk.a.d.bja() && dui() != null) {
                dui().duR();
            } else if (dug() != null) {
                dug().duR();
            }
        }
    }

    public void b(q qVar) {
        boolean z;
        MetaData metaData;
        if (dmq() != null && dmq().getPbData() != null && qVar.dlR() != null) {
            String id = qVar.dlR().getId();
            ArrayList<PostData> dlb = dmq().getPbData().dlb();
            int i = 0;
            while (true) {
                if (i >= dlb.size()) {
                    z = true;
                    break;
                }
                PostData postData = dlb.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dma = qVar.dma();
                    postData.JD(qVar.getTotalCount());
                    if (postData.dNu() == null || dma == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dma.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.bnQ() != null && (metaData = postData.getUserMap().get(next.bnQ().getUserId())) != null) {
                                next.a(metaData);
                                next.yw(true);
                                next.a(getPageContext(), dmq().Pz(metaData.getUserId()));
                            }
                        }
                        z = dma.size() != postData.dNu().size();
                        if (postData.dNu() != null && postData.dNu().size() < 2) {
                            postData.dNu().clear();
                            postData.dNu().addAll(dma);
                        }
                    }
                    if (postData.dNq() != null) {
                        postData.dNr();
                    }
                }
            }
            if (!dmq().getIsFromMark() && z) {
                if (com.baidu.tbadk.a.d.bja() && dui() != null) {
                    dui().duR();
                } else if (dug() != null) {
                    dug().duR();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnv() {
        if (dmq() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.So(dmq().getForumId()) && dmq().getPbData() != null && dmq().getPbData().getForum() != null) {
            if (dmq().getPbData().getForum().isLike() == 1) {
                dmq().dpa().gp(dmq().getForumId(), dmq().dot());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            cb dkZ = fVar.dkZ();
            if (dkZ != null && dkZ.bmz()) {
                doc();
            } else {
                d(this.lRO);
            }
            if (this.lRP != null) {
                vI(this.lRP.bBV());
                this.lRP.a(fVar.getAnti());
                this.lRP.a(fVar.getForum(), fVar.getUserData());
                this.lRP.setThreadData(dkZ);
                if (dmq() != null) {
                    this.lRP.a(dmq().doK(), dmq().dot(), dmq().dpb());
                }
                if (dkZ != null) {
                    this.lRP.kY(dkZ.bpp());
                }
            }
        }
    }

    public void dql() {
        reset();
        dqh();
        this.mae.dna();
        vK(false);
    }

    private void reset() {
        if (this.lRP != null && this.acR != null) {
            com.baidu.tbadk.editortools.pb.a.bBK().setStatus(0);
            this.lRP.bCf();
            this.lRP.bBu();
            if (this.lRP.getWriteImagesInfo() != null) {
                this.lRP.getWriteImagesInfo().setMaxImagesAllowed(this.lRP.isBJH ? 1 : 9);
            }
            this.lRP.re(SendView.ALL);
            this.lRP.rf(SendView.ALL);
            com.baidu.tbadk.editortools.h qR = this.acR.qR(23);
            com.baidu.tbadk.editortools.h qR2 = this.acR.qR(2);
            com.baidu.tbadk.editortools.h qR3 = this.acR.qR(5);
            if (qR2 != null) {
                qR2.display();
            }
            if (qR3 != null) {
                qR3.display();
            }
            if (qR != null) {
                qR.hide();
            }
            this.acR.invalidate();
        }
    }

    public void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dkZ() != null) {
            x(fVar);
            this.lZz.setVisibility(fVar.dlC() ? 8 : 0);
            if (fVar.bjZ()) {
                WebPManager.a(this.lZz, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lZz, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String Gd = Gd(fVar.dkZ().bnH());
            if (this.lZC != null) {
                this.lZC.setText(Gd);
            }
            if (this.lZD != null) {
                this.lZD.setText(Gd);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dkZ()));
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bd(fVar.dkZ())) {
            if (this.lZB != null) {
                this.lZB.setEnable(false);
                this.lZB.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.lZA.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.lZA.setLayoutParams(layoutParams);
            WebPManager.a(this.lZA, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.lZB == null || !this.lZB.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.lZA.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.lZA.setLayoutParams(layoutParams2);
            WebPManager.a(this.lZA, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    private String Gd(int i) {
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
            return numberFormat.format(i / 10000.0f) + "W";
        } else if (i >= 10000) {
            numberFormat.setMaximumFractionDigits(1);
            return numberFormat.format(i / 10000.0f) + "W";
        } else {
            return "" + i;
        }
    }

    public void vK(boolean z) {
        if (this.lZv != null) {
            vI(this.lRP.bBV());
            if (this.lZr) {
                vz(z);
            } else {
                vA(z);
            }
            dtY();
            dtZ();
        }
    }

    public void drm() {
        if (this.lZv != null) {
            this.lZu.setVisibility(8);
            this.lZv.setVisibility(8);
            this.mkp.mkJ = false;
            dtY();
            dtZ();
        }
    }

    private void dtY() {
        if (this.mkb != null) {
            if (this.mkp.dup()) {
                this.mkb.xp(false);
            } else {
                this.mkb.xp(this.mkb.isVertical() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtZ() {
        if (this.mkb != null && this.eZd != null) {
            if (com.baidu.tbadk.a.d.bja()) {
                this.mkb.ww(false);
            } else if (this.eZd.getCurrentItem() != 0) {
                this.mkb.ww(false);
            } else if (this.mkp.dup()) {
                this.mkb.ww(false);
            } else {
                VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
                if (videoPbViewModel != null) {
                    this.mkb.ww(videoPbViewModel.duz() == null || videoPbViewModel.duz().getValue() == null || videoPbViewModel.duz().getValue().booleanValue());
                }
            }
        }
    }

    private void FL(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(doa(), dnu(), i);
    }

    private int dnu() {
        if (dmq() == null || dmq().getPbData() == null || dmq().getPbData().dkZ() == null) {
            return -1;
        }
        return dmq().getPbData().dkZ().boC();
    }

    public void vI(boolean z) {
        this.lZr = z;
    }

    public void vz(boolean z) {
        if (this.lZv != null && this.kpg != null) {
            this.kpg.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lZv.startAnimation(alphaAnimation);
            }
            this.lZu.setVisibility(0);
            this.lZv.setVisibility(0);
            this.mkp.mkJ = true;
        }
    }

    public void vA(boolean z) {
        if (this.lZv != null && this.kpg != null) {
            this.kpg.setText(dqn());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lZv.startAnimation(alphaAnimation);
            }
            this.lZu.setVisibility(0);
            this.lZv.setVisibility(0);
            this.mkp.mkJ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null && this.lKI == null) {
            this.lKI = aVar;
            this.mkg.setText(aVar.getTitle());
            this.mkh.setText(aVar.dve());
            String dvf = aVar.dvf();
            TBSpecificationBtn tBSpecificationBtn = this.mkj;
            if (TextUtils.isEmpty(dvf)) {
                dvf = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(dvf);
            this.mkk.startLoad(aVar.getImage(), 10, false);
            this.mkl.setVisibility(aVar.dvh() ? 0 : 8);
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.lKI == null || VideoPbFragment.this.lKI.dvh()) {
                        if (VideoPbFragment.this.lKI != null && VideoPbFragment.this.dmq() != null && VideoPbFragment.this.dmq().getPbData() != null && VideoPbFragment.this.dmq().getPbData().getForum() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13712").dR("fid", VideoPbFragment.this.dmq().getPbData().getForum().getId()).dR("fname", VideoPbFragment.this.dmq().getPbData().getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.dmq().getPbData().getThreadId()).v("obj_param1", VideoPbFragment.this.lKI.userId));
                        }
                    } else {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13608").dR("obj_id", VideoPbFragment.this.lKI.getTitle()).dR("obj_name", VideoPbFragment.this.lKI.dve()).ap("obj_type", 2).dR("fid", VideoPbFragment.this.dmq().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.dmq().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.dua();
                }
            }, aVar.dvg().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dua() {
        ViewGroup.LayoutParams layoutParams = this.mke.getLayoutParams();
        if (layoutParams != null) {
            if (this.mkm == null || !this.mkm.isRunning()) {
                this.mke.setAlpha(0.0f);
                this.mke.setVisibility(0);
                g(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dub() {
        if (this.mke.getLayoutParams() != null) {
            if (this.mkm == null || !this.mkm.isRunning()) {
                duc();
            }
        }
    }

    private void duc() {
        final ViewGroup.LayoutParams layoutParams = this.mke.getLayoutParams();
        if (layoutParams != null) {
            if (this.mkn == null || !this.mkn.isRunning()) {
                this.mkn = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.mkn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.mke.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.mkn.setDuration(200L);
                this.mkn.start();
                this.mkn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPbFragment.this.f(layoutParams);
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
    public void f(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.ZM.getLayoutParams();
        final int i = layoutParams2.height;
        this.mkm = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mkm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.klQ);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.klQ);
                VideoPbFragment.this.mke.setLayoutParams(layoutParams);
                VideoPbFragment.this.ZM.setLayoutParams(layoutParams2);
            }
        });
        this.mkm.setDuration(300L);
        this.mkm.start();
        this.mkm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.mke.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void g(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.ZM.getLayoutParams();
        final int i = layoutParams2.height;
        this.mkm = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mkm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.klQ);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.mke.setLayoutParams(layoutParams);
                VideoPbFragment.this.ZM.setLayoutParams(layoutParams2);
            }
        });
        this.mkm.setDuration(300L);
        this.mkm.start();
        this.mkm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.dud();
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
    public void dud() {
        this.mkm = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mkm.setDuration(300L);
        this.mkm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.mke.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.mkm.start();
    }

    public String dqn() {
        if (!au.isEmpty(this.may)) {
            return this.may;
        }
        this.may = TbadkCoreApplication.getInst().getResources().getString(ao.dqd());
        return this.may;
    }

    public void dqM() {
        hideProgressBar();
        if (com.baidu.tbadk.a.d.bja() && dui() != null) {
            dui().endLoadData();
            dui().dqN();
        } else if (dug() != null) {
            dug().endLoadData();
            dug().dqN();
        }
    }

    public boolean dC(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bkT().isShowImages()) {
                    return Pv(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (dmq() == null || dmq().getPbData() == null) {
                        return true;
                    }
                    if (this.mae != null) {
                        this.mae.dna();
                    }
                    q qVar = new q();
                    qVar.a(dmq().getPbData().getForum());
                    qVar.setThreadData(dmq().getPbData().dkZ());
                    qVar.g(postData);
                    this.lQO.d(qVar);
                    this.lQO.setPostId(postData.getId());
                    a(view, postData.bnQ().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lRP != null) {
                        vI(this.lRP.bBV());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void due() {
        if (this.lRP != null) {
            vI(this.lRP.bBV());
        }
        dql();
        this.mko.drd();
    }

    private boolean Pv(String str) {
        if (!StringUtils.isNull(str) && bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("bubble_link", "");
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

    public void dqG() {
        if (this.lZc != null) {
            this.lZc.setVisibility(0);
        }
    }

    public void dqH() {
        if (this.lZc != null) {
            this.lZc.setVisibility(8);
        }
    }

    public void Gv(int i) {
        if (this.mjY != null) {
            this.mjY.setVisibility(i);
        }
    }

    public void dqK() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a dny() {
        return this.lSF;
    }

    public void dqh() {
        if (this.acR != null) {
            this.acR.hide();
        }
    }

    public void cCV() {
        if (this.lQT.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lQT.getCurrentFocus());
        }
    }

    public void N(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dkZ() != null) {
            String valueOf = String.valueOf(fVar.dkZ().bnH());
            if (fVar.dkZ().bnH() == 0) {
                valueOf = "";
            }
            this.mjW.Ei(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.mjX.duq()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (dmq() != null && dmq().getPbData() != null && dmq().getPbData().dkZ() != null && dmq().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(lZW)).intValue();
                if (intValue == lZX) {
                    if (!this.geq.dOs()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.geq.Ts(au.R(jSONArray));
                        }
                        this.geq.a(dmq().getPbData().getForum().getId(), dmq().getPbData().getForum().getName(), dmq().getPbData().dkZ().getId(), str, intValue3, intValue2, booleanValue, dmq().getPbData().dkZ().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == lZY || intValue == maa) {
                    if (dmq().doX() != null) {
                        dmq().doX().FD(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == lZY) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(String str, String str2) {
        bf.bsV().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bIg() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bIh() {
        if (this.fUl == null) {
            this.fUl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bIt */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bkT().isShowImages();
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
                /* renamed from: c */
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
                /* renamed from: d */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.k.bkT().isShowImages()) {
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
                /* renamed from: e */
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
        return this.fUl;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bIi() {
        if (this.fXB == null) {
            this.fXB = TbRichTextView.K(getPageContext().getPageActivity(), 8);
        }
        return this.fXB;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bIj() {
        if (this.fUm == null) {
            this.fUm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cwZ */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bkT().isShowImages();
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
                    if (com.baidu.tbadk.core.k.bkT().isShowImages()) {
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
                    gifView.bCN();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fUm;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bIk() {
        if (this.fXC == null) {
            this.fXC = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dod */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dH */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dI */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).ccu();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dJ */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fXC;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bIl() {
        if (this.fXD == null) {
            this.fXD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dof */
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
        return this.fXD;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bIm() {
        this.fXE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: doe */
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
        return this.fXE;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lRf = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (com.baidu.tieba.pb.pb.main.au.PL(str) && dmq() != null && dmq().dot() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11664").ap("obj_param1", 1).dR("post_id", dmq().dot()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                mVar.mLink = str;
                mVar.type = 3;
                mVar.fAm = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
            }
        } else {
            com.baidu.tieba.pb.pb.main.au.drJ().h(getPageContext(), str);
        }
        this.lRf = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
        com.baidu.tieba.pb.pb.main.au.drJ().h(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lRf = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aH(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mko.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b duN = this.mko.duN();
            if (duN == null) {
                this.mko.dno();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                duN.getItemView(1).setVisibility(8);
            } else {
                duN.getItemView(1).setVisibility(0);
            }
            duN.bqz();
            this.lRf = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aI(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            bf.bsV().b(getPageContext(), new String[]{str});
            this.lRf = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a duf() {
        return this.faF;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bFG() {
        return this.bST;
    }

    public ReplyFragment dug() {
        if (this.mjX == null || !(this.mjX.Gw(mjT) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.mjX.Gw(mjT);
    }

    public DetailInfoFragment duh() {
        if (this.mjX == null || !(this.mjX.Gw(mjS) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.mjX.Gw(mjS);
    }

    public DetailInfoAndReplyFragment dui() {
        if (this.mjX == null || !(this.mjX.Gw(mjU) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.mjX.Gw(mjU);
    }

    public boolean dmi() {
        PbModel dmq = this.lQT.dmq();
        if (dmq == null) {
            return false;
        }
        return dmq.dmi();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dll;
        PbModel dmq = this.lQT.dmq();
        if (dmq != null && dmq.getPbData() != null && !dmq.getPbData().dlC()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = dmq.getPbData().dkZ().getId();
            if (dmq.isShareThread() && dmq.getPbData().dkZ().eTc != null) {
                historyMessage.threadName = dmq.getPbData().dkZ().eTc.showText;
            } else {
                historyMessage.threadName = dmq.getPbData().dkZ().getTitle();
            }
            if (dmq.isShareThread() && !dmi()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = dmq.getPbData().getForum().getName();
            }
            ArrayList<PostData> dlb = dmq.getPbData().dlb();
            int dqO = dug() != null ? dug().dqO() : 0;
            if (dlb != null && dqO >= 0 && dqO < dlb.size()) {
                historyMessage.postID = dlb.get(dqO).getId();
            }
            historyMessage.isHostOnly = dmq.getHostMode();
            historyMessage.isSquence = dmq.dov();
            historyMessage.isShareThread = dmq.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lRP != null) {
            this.lRP.onDestroy();
        }
        if (dmq != null && (dmq.dow() || dmq.doy())) {
            Intent intent = new Intent();
            intent.putExtra("tid", dmq.dot());
            if (this.lRE) {
                if (this.lRG) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", dmq.cvi());
                }
                if (this.lRF) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", dmq.getIsGood());
                }
            }
            if (dmq.getPbData() != null && System.currentTimeMillis() - this.lRb >= 40000 && (dll = dmq.getPbData().dll()) != null && !y.isEmpty(dll.getDataList())) {
                intent.putExtra("guess_like_data", dll);
            }
            PbActivity pbActivity = this.lQT;
            PbActivity pbActivity2 = this.lQT;
            pbActivity.setResult(-1, intent);
        }
        if (dnF()) {
            if (dmq != null) {
                com.baidu.tieba.pb.data.f pbData = dmq.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.lRh) {
                        if (this.mka != null) {
                            Rect rect = new Rect();
                            this.mka.getGlobalVisibleRect(rect);
                            aj.dpS().g(rect);
                        }
                        aj.dpS().FZ(this.eZd.getCurrentItem());
                        BdTypeRecyclerView cFO = cFO();
                        Parcelable parcelable = null;
                        if (cFO != null) {
                            parcelable = cFO.onSaveInstanceState();
                        }
                        aj.dpS().a(dmq.doE(), parcelable, dmq.dov(), dmq.getHostMode(), false);
                    }
                }
            } else {
                aj.dpS().reset();
            }
            dmE();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mkb != null && !this.mkb.isVertical()) {
            if ((this.mkb.isFullScreen() && configuration.orientation == 1) || (!this.mkb.isFullScreen() && configuration.orientation == 2)) {
                this.mkb.wx(false);
            }
        }
    }

    public boolean cFv() {
        if (this.mkb == null) {
            return false;
        }
        return this.mkb.isVertical();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.dMr().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        public boolean mkJ;
        public boolean mkK;

        private a() {
            this.mkK = true;
        }

        public boolean dup() {
            return (this.mkJ && this.mkK) ? false : true;
        }
    }

    public void duj() {
        this.lRt = -1;
        this.lRu = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnW() {
        if (dmq() != null && !au.isEmpty(dmq().dot())) {
            com.baidu.tbadk.BdToken.c.bhn().q(com.baidu.tbadk.BdToken.b.eCf, com.baidu.adp.lib.f.b.toLong(dmq().dot(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.mjZ.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duk() {
        if (this.mky == null) {
            this.mky = ObjectAnimator.ofFloat(this.mkd, "alpha", 0.0f, 1.0f);
            this.mky.setDuration(200L);
        }
        this.mky.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dul() {
        if (this.mkz == null) {
            this.mkz = ObjectAnimator.ofFloat(this.mkd, "alpha", 1.0f, 0.0f);
            this.mkz.setDuration(200L);
        }
        this.mkz.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dum() {
        return this.mkb != null && this.mkb.dun();
    }

    public boolean dun() {
        return this.mkv;
    }

    public void wo(boolean z) {
        this.mkv = z;
    }

    public void vf(boolean z) {
        this.lRi = z;
    }

    public boolean dnU() {
        return this.lRi;
    }

    public LinearLayout drC() {
        return this.lZw;
    }
}
