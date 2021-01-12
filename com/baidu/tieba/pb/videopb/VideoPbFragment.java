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
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
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
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.aj;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.au;
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
    private AppBarLayout ZQ;
    private EditorTools acX;
    private ImageView ahO;
    private CustomViewPager eWN;
    public View fJL;
    private com.baidu.adp.lib.d.b<ImageView> fRW;
    private com.baidu.adp.lib.d.b<GifView> fRX;
    private com.baidu.adp.lib.d.b<TextView> fVl;
    private com.baidu.adp.lib.d.b<View> fVm;
    private com.baidu.adp.lib.d.b<LinearLayout> fVn;
    private com.baidu.adp.lib.d.b<RelativeLayout> fVo;
    private ImageView gVs;
    private com.baidu.tieba.callfans.a ise;
    private VoiceManager jaA;
    private com.baidu.tieba.frs.profession.permission.c jeV;
    private com.baidu.tieba.f.b jfv;
    public View jri;
    public al kKi;
    public ar kOl;
    private com.baidu.tieba.pb.videopb.c.a lBV;
    private PbFakeFloorModel lHU;
    private PbActivity lHZ;
    private g lIR;
    private com.baidu.tbadk.editortools.pb.e lIS;
    private com.baidu.tieba.frs.profession.permission.c lIU;
    private EmotionImageData lIV;
    private com.baidu.tbadk.core.view.c lIZ;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lIs;
    int lIv;
    private LinearLayout lQA;
    private HeadImageView lQB;
    private ImageView lQC;
    private ImageView lQD;
    private ImageView lQE;
    private com.baidu.tieba.pb.view.d lQF;
    private TextView lQG;
    private TextView lQH;
    private int lQJ;
    private int lQK;
    private View lQg;
    private View lQy;
    private r lRh;
    private String lRz;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private NewPagerSlidingTabBaseStrip maT;
    private VideoPbFragmentAdapter maU;
    private View maV;
    private View maW;
    private VideoContainerLayout maX;
    private com.baidu.tieba.pb.videopb.videoView.a maY;
    private e maZ;
    private View mba;
    private View mbb;
    private TextView mbd;
    private TextView mbe;
    private ImageView mbf;
    private TBSpecificationBtn mbg;
    private TbImageView mbh;
    private View mbi;
    private ValueAnimator mbj;
    private ValueAnimator mbk;
    public com.baidu.tieba.pb.videopb.b.a mbl;
    private float mbp;
    private float mbq;
    private boolean mbr;
    private ObjectAnimator mbv;
    private ObjectAnimator mbw;
    private RelativeLayout rootView;
    public static int maP = 0;
    public static int maQ = 1;
    public static int maR = 0;
    public static int lQZ = 3;
    public static int lRa = 0;
    public static int lRb = 3;
    public static int lRc = 4;
    public static int lRd = 5;
    public static int lRe = 6;
    private static final int kdG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int maS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a lJS = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void cV(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.djT();
            } else {
                com.baidu.tieba.pb.a.b.djS();
            }
        }
    };
    private long lIh = 0;
    private boolean lIo = false;
    View.OnClickListener mbc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.lBV == null || VideoPbFragment.this.lBV.dsU()) {
                if (VideoPbFragment.this.lBV != null) {
                    if (VideoPbFragment.this.lBV.isChushou) {
                        VideoPbFragment.this.eH(VideoPbFragment.this.lBV.thirdRoomId, VideoPbFragment.this.lBV.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.lBV.dsV();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null && VideoPbFragment.this.dkd().getPbData().getForum() != null) {
                        TiebaStatic.log(new aq("c13713").dW("fid", VideoPbFragment.this.dkd().getPbData().getForum().getId()).dW("fname", VideoPbFragment.this.dkd().getPbData().getForum().getName()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("tid", VideoPbFragment.this.dkd().getPbData().getThreadId()).w("obj_param1", VideoPbFragment.this.lBV.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new aq("c13590").dW("obj_id", VideoPbFragment.this.lBV.getTitle()).dW("obj_name", VideoPbFragment.this.lBV.dsR()).an("obj_type", 2).dW("fid", VideoPbFragment.this.dkd().getPbData().getForumId()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("tid", VideoPbFragment.this.dkd().getPbData().getThreadId()));
            String link = VideoPbFragment.this.lBV.getLink();
            if (!TextUtils.isEmpty(link)) {
                if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                    be.bsB().b(VideoPbFragment.this.getPageContext(), new String[]{link});
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
    private com.baidu.tbadk.baseEditMark.a lIE = null;
    private com.baidu.tbadk.coreExtra.model.a eYq = null;
    private ForumManageModel gca = null;
    private boolean lIl = false;
    private View lQz = null;
    private TextView kgY = null;
    private boolean lQv = false;
    private String fBw = null;
    private boolean lIH = false;
    private boolean lII = false;
    private boolean lIJ = false;
    private boolean lIn = false;
    int[] lIu = new int[2];
    private int lIw = -1;
    private int lIx = Integer.MIN_VALUE;
    private int lJf = 0;
    private int mbn = Integer.MIN_VALUE;
    private boolean isPaused = false;
    private boolean lIB = com.baidu.tbadk.a.d.biM();
    private final PbModel.a lJI = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h qM;
            VideoPbFragment.this.doy();
            VideoPbFragment.this.dot();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.vv(false);
            if (z && fVar != null) {
                bz diN = fVar.diN();
                ((VideoPbViewModel) ViewModelProviders.of(VideoPbFragment.this.getActivity()).get(VideoPbViewModel.class)).c(fVar, i2);
                VideoPbFragment.this.M(fVar);
                com.baidu.tieba.pb.videopb.c.a djs = fVar.djs();
                if (djs != null && !djs.mdo) {
                    VideoPbFragment.this.a(djs);
                }
                VideoPbFragment.this.N(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.lIE != null) {
                    VideoPbFragment.this.lIE.iY(fVar.bjE());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.fBw = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.fBw) && VideoPbFragment.this.lIS != null && VideoPbFragment.this.lIS.bAP() != null && (qM = VideoPbFragment.this.lIS.bAP().qM(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.fBw)) {
                        ((View) qM).setOnClickListener(VideoPbFragment.this.fCk);
                    }
                }
                if (VideoPbFragment.this.kKi != null && diN != null && diN.bnx() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(diN.bnx());
                    VideoPbFragment.this.kKi.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.dkd().dme());
                        jSONObject.put("fid", VideoPbFragment.this.dkd().getForumId());
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
                if ((!com.baidu.tbadk.a.d.biO() || VideoPbFragment.this.drV() != null) && VideoPbFragment.this.drT() != null) {
                    if (com.baidu.tbadk.a.d.biO()) {
                        if (i != -1) {
                            ArrayList<PostData> arrayList = null;
                            if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null) {
                                arrayList = VideoPbFragment.this.dkd().getPbData().diP();
                            }
                            if (x.getCount(arrayList) == 0 || (x.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dLm() == 1)) {
                                if (VideoPbFragment.this.drV().dlE()) {
                                    VideoPbFragment.this.drV().OP(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.drV().OP(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.drV().OO(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.drV().OO("");
                        }
                        VideoPbFragment.this.drV().endLoadData();
                    } else {
                        if (i != -1) {
                            ArrayList<PostData> arrayList2 = null;
                            if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null) {
                                arrayList2 = VideoPbFragment.this.dkd().getPbData().diP();
                            }
                            if (x.getCount(arrayList2) == 0 || (x.getCount(arrayList2) == 1 && arrayList2.get(0) != null && arrayList2.get(0).dLm() == 1)) {
                                if (VideoPbFragment.this.drT().dlE()) {
                                    VideoPbFragment.this.drT().OP(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.drT().OP(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.drT().OO(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.drT().OO("");
                        }
                        VideoPbFragment.this.drT().endLoadData();
                    }
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.dKg().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0557a lJK = new a.InterfaceC0557a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0557a
        public void g(boolean z, boolean z2, String str) {
            VideoPbFragment.this.doy();
            if (z && VideoPbFragment.this.dkd() != null) {
                if (VideoPbFragment.this.lIE != null) {
                    VideoPbFragment.this.lIE.iY(z2);
                }
                VideoPbFragment.this.dkd().uZ(z2);
                if (VideoPbFragment.this.dkd().bjE()) {
                    VideoPbFragment.this.dlp();
                } else if (com.baidu.tbadk.a.d.biO() && VideoPbFragment.this.drV() != null) {
                    VideoPbFragment.this.drV().dsE();
                } else if (VideoPbFragment.this.drT() != null) {
                    VideoPbFragment.this.drT().dsE();
                }
                if (z2) {
                    if (VideoPbFragment.this.lIE != null) {
                        if (VideoPbFragment.this.lIE.bjH() != null && VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null && VideoPbFragment.this.dkd().getPbData().diN() != null && VideoPbFragment.this.dkd().getPbData().diN().bnx() != null) {
                            MarkData bjH = VideoPbFragment.this.lIE.bjH();
                            MetaData bnx = VideoPbFragment.this.dkd().getPbData().diN().bnx();
                            if (bjH != null && bnx != null) {
                                if (!at.equals(TbadkCoreApplication.getCurrentAccount(), bnx.getUserId()) && !bnx.hadConcerned()) {
                                    VideoPbFragment.this.mbl.b(bnx);
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
                    VideoPbFragment.this.dlm();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b fBA = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBt() {
            if (VideoPbFragment.this.kOl == null || VideoPbFragment.this.kOl.dpr() == null || !VideoPbFragment.this.kOl.dpr().dUb()) {
                return !VideoPbFragment.this.Fp(al.eYl);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kOl.dpr().dUd());
            if (VideoPbFragment.this.lIS != null && (VideoPbFragment.this.lIS.bBK() || VideoPbFragment.this.lIS.bBL())) {
                VideoPbFragment.this.lIS.a(false, VideoPbFragment.this.kOl.dpu());
            }
            VideoPbFragment.this.kOl.vB(true);
            return true;
        }
    };
    private final CustomMessageListener lJm = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.dkd() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.lIS != null) {
                    VideoPbFragment.this.vt(VideoPbFragment.this.lIS.bBD());
                }
                VideoPbFragment.this.dnX();
                VideoPbFragment.this.mbl.doP();
            }
        }
    };
    private CustomMessageListener lJp = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
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
    private final CustomMessageListener jcd = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.64
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.isPaused) {
                VideoPbFragment.this.dlH();
            }
        }
    };
    private CustomMessageListener lJJ = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.dlg();
            }
        }
    };
    private CustomMessageListener lJB = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.66
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.mbl != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mbl.lJa) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.mbl.cjr();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.mbl.getExtra();
                DataRes dataRes = aVar.nAo;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (at.isEmpty(str)) {
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
                    VideoPbFragment.this.mbl.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.mbl.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener lJz = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.mbl != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mbl.lJa) {
                VideoPbFragment.this.mbl.cjr();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                f pbData = VideoPbFragment.this.dkd().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.djd().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lIZ.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.mbl.CL(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.mbl.dlD();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (at.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.lIZ.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lJA = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.mbl != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mbl.lJa) {
                VideoPbFragment.this.mbl.cjr();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lIZ.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (at.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.lIZ.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b lIX = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBt() {
            if (VideoPbFragment.this.kOl == null || VideoPbFragment.this.kOl.dps() == null || !VideoPbFragment.this.kOl.dps().dUb()) {
                return !VideoPbFragment.this.Fp(al.eYm);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kOl.dps().dUd());
            if (VideoPbFragment.this.lRh != null && VideoPbFragment.this.lRh.dkQ() != null && VideoPbFragment.this.lRh.dkQ().bBL()) {
                VideoPbFragment.this.lRh.dkQ().a(VideoPbFragment.this.kOl.dpu());
            }
            VideoPbFragment.this.kOl.vC(true);
            return true;
        }
    };
    private final NewWriteModel.d fBH = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c13268");
                aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null) {
                    aqVar.dW("fid", VideoPbFragment.this.dkd().getPbData().getForumId());
                }
                aqVar.dW("tid", VideoPbFragment.this.dkd().dme());
                aqVar.dW("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            VideoPbFragment.this.cBI();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.dkd() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.dkd().OJ(postWriteCallBackData.getPostId());
                    if (com.baidu.tbadk.a.d.biO() && VideoPbFragment.this.drV() != null) {
                        VideoPbFragment.this.lJf = VideoPbFragment.this.drV().doA();
                        VideoPbFragment.this.mbn = VideoPbFragment.this.drV().dsH();
                        VideoPbFragment.this.dkd().dc(VideoPbFragment.this.lJf, VideoPbFragment.this.mbn);
                    } else if (VideoPbFragment.this.drT() != null) {
                        VideoPbFragment.this.lJf = VideoPbFragment.this.drT().doA();
                        VideoPbFragment.this.mbn = VideoPbFragment.this.drT().dsH();
                        VideoPbFragment.this.dkd().dc(VideoPbFragment.this.lJf, VideoPbFragment.this.mbn);
                    }
                }
                if (VideoPbFragment.this.eWN != null) {
                    if (com.baidu.tbadk.a.d.biO()) {
                        VideoPbFragment.this.eWN.setCurrentItem(VideoPbFragment.maR);
                    } else {
                        VideoPbFragment.this.eWN.setCurrentItem(VideoPbFragment.maQ);
                    }
                }
                VideoPbFragment.this.mbl.doP();
                VideoPbFragment.this.kOl.dpq();
                if (VideoPbFragment.this.lIS != null) {
                    VideoPbFragment.this.vt(VideoPbFragment.this.lIS.bBD());
                }
                VideoPbFragment.this.dnT();
                VideoPbFragment.this.vv(true);
                VideoPbFragment.this.dkd().dmA();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (com.baidu.tbadk.a.d.biO() && VideoPbFragment.this.drV() != null) {
                                VideoPbFragment.this.drV().dsE();
                            } else if (VideoPbFragment.this.drT() != null) {
                                VideoPbFragment.this.drT().dsE();
                            }
                        }
                    } else if (VideoPbFragment.this.dkd().getHostMode()) {
                        f pbData = VideoPbFragment.this.dkd().getPbData();
                        if (pbData != null && pbData.diN() != null && pbData.diN().bnx() != null && (userId = pbData.diN().bnx().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.dkd().dmr()) {
                            VideoPbFragment.this.dow();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.dkd().dmr()) {
                        VideoPbFragment.this.dow();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.uK(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.lIS.bBK() || VideoPbFragment.this.lIS.bBL()) {
                    VideoPbFragment.this.lIS.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.kOl.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.kKi != null) {
                    VideoPbFragment.this.kKi.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Ad(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Ad(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new aq("c13746").an("obj_locate", 1).an("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bqe();
                TiebaStatic.log(new aq("c13745").an("obj_locate", 1).an("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener fCk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.fBw);
        }
    };
    private CustomMessageListener lJo = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.lIS != null) {
                    VideoPbFragment.this.vt(VideoPbFragment.this.lIS.bBD());
                }
                VideoPbFragment.this.vv(false);
            }
        }
    };
    private int mbo = 0;
    private boolean mbs = true;
    private View.OnTouchListener mbt = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.mbo == 1) {
                if (!VideoPbFragment.this.mbs) {
                    VideoPbFragment.this.drY();
                    UtilHelper.showStatusBar(VideoPbFragment.this.dlL(), VideoPbFragment.this.dlL().getRootView());
                    VideoPbFragment.this.mbs = true;
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(VideoPbFragment.this.mbu);
                    com.baidu.adp.lib.f.e.mB().postDelayed(VideoPbFragment.this.mbu, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (VideoPbFragment.this.mbo == 2 && (VideoPbFragment.this.mbs || VideoPbFragment.this.dsa())) {
                VideoPbFragment.this.drZ();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dlL(), VideoPbFragment.this.dlL().getRootView());
                VideoPbFragment.this.mbs = false;
                if (VideoPbFragment.this.maY != null) {
                    VideoPbFragment.this.maY.vX(false);
                }
            }
            VideoPbFragment.this.mbo = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener jmT = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.mbo = 0;
            VideoPbFragment.this.mbp = 0.0f;
            VideoPbFragment.this.mbq = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.mbp += f;
            VideoPbFragment.this.mbq += f2;
            if (VideoPbFragment.this.mbo == 0 && !VideoPbFragment.this.mbr && VideoPbFragment.this.maY != null && !VideoPbFragment.this.maY.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.mbq) <= Math.abs(VideoPbFragment.this.mbp) || VideoPbFragment.this.mbq > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.mbq) > Math.abs(VideoPbFragment.this.mbp) && VideoPbFragment.this.mbq > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.mbo = 2;
                    }
                } else {
                    VideoPbFragment.this.mbo = 1;
                }
            }
            return true;
        }
    };
    private Runnable mbu = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.mbs && !VideoPbFragment.this.dsa()) {
                VideoPbFragment.this.drZ();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dlL(), VideoPbFragment.this.dlL().getRootView());
                VideoPbFragment.this.mbs = false;
            }
        }
    };
    private final com.baidu.adp.base.e isj = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.dkd() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.gca.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.gca.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.dkd().dmA();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.lYg != 1002 || bVar.hgB) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.mSuccess, dVar.npN, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.gca.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.gca.getLoadDataMode(), gVar.mSuccess, gVar.npN, false);
                    VideoPbFragment.this.mbl.ba(gVar.npQ);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener bPd = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.jfv.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d lJG = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c13268");
                aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null) {
                    aqVar.dW("fid", VideoPbFragment.this.dkd().getPbData().getForumId());
                }
                if (VideoPbFragment.this.dkd() != null) {
                    aqVar.dW("tid", VideoPbFragment.this.dkd().dme());
                }
                aqVar.dW("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (VideoPbFragment.this.kOl != null) {
                    VideoPbFragment.this.kOl.dpp();
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
                if (VideoPbFragment.this.kKi != null) {
                    VideoPbFragment.this.kKi.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Ad(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Ad(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new aq("c13746").an("obj_locate", 1).an("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bqe();
                TiebaStatic.log(new aq("c13745").an("obj_locate", 1).an("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.kOl != null) {
                if (VideoPbFragment.this.lRh != null && VideoPbFragment.this.lRh.dkQ() != null && VideoPbFragment.this.lRh.dkQ().bBL()) {
                    VideoPbFragment.this.lRh.dkQ().a(postWriteCallBackData);
                }
                VideoPbFragment.this.kOl.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c fBz = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bBu() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public final View.OnClickListener aCu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        /* JADX DEBUG: Multi-variable search result rejected for r1v154, resolved type: com.baidu.tieba.pb.videopb.b.a */
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
                    aq aqVar = new aq("c13398");
                    aqVar.dW("tid", VideoPbFragment.this.dkd().dme());
                    aqVar.dW("fid", VideoPbFragment.this.dkd().getForumId());
                    aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.an("obj_locate", 1);
                    TiebaStatic.log(aqVar);
                    if (VideoPbFragment.this.lIl) {
                        VideoPbFragment.this.lIl = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null && VideoPbFragment.this.lHU != null && postData.bnx() != null && postData.dLm() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.lRh != null) {
                                    VideoPbFragment.this.lRh.dkM();
                                }
                                p pVar = new p();
                                pVar.a(VideoPbFragment.this.dkd().getPbData().getForum());
                                pVar.setThreadData(VideoPbFragment.this.dkd().getPbData().diN());
                                pVar.g(postData);
                                VideoPbFragment.this.lHU.d(pVar);
                                VideoPbFragment.this.lHU.setPostId(postData.getId());
                                VideoPbFragment.this.a(view, postData.bnx().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.dkd().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.lIS != null) {
                                    VideoPbFragment.this.vt(VideoPbFragment.this.lIS.bBD());
                                }
                            }
                        }
                    }
                } else if ((VideoPbFragment.this.drT() != null && VideoPbFragment.this.drT().doL() != null && view == VideoPbFragment.this.drT().doL()) || ((com.baidu.tbadk.a.d.biO() && VideoPbFragment.this.drV() != null && VideoPbFragment.this.drV().doL() != null && view == VideoPbFragment.this.drV().doL()) || view.getId() == R.id.pb_more)) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.dkd().uX(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        if (com.baidu.tbadk.a.d.biO()) {
                            VideoPbFragment.this.drV().dox();
                        } else {
                            VideoPbFragment.this.drT().dox();
                        }
                    }
                } else if (VideoPbFragment.this.mbl != null && VideoPbFragment.this.mbl.dpX() != null && view == VideoPbFragment.this.mbl.dpX().dnq()) {
                    VideoPbFragment.this.mbl.baz();
                } else if ((VideoPbFragment.this.mbl != null && ((VideoPbFragment.this.mbl.dpX() != null && view == VideoPbFragment.this.mbl.dpX().dnr()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) || view.getId() == R.id.floor_owner_reply || view.getId() == R.id.reply_title) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.mbl.doP();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.cBI();
                        VideoPbFragment.this.dow();
                        if (view.getId() == R.id.owner_reply) {
                            C = VideoPbFragment.this.dkd().C(true, VideoPbFragment.this.dlt());
                        } else {
                            C = view.getId() == R.id.all_reply ? VideoPbFragment.this.dkd().C(false, VideoPbFragment.this.dlt()) : VideoPbFragment.this.dkd().OG(VideoPbFragment.this.dlt());
                        }
                        view.setTag(Boolean.valueOf(C));
                        if (C) {
                            VideoPbFragment.this.dos();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.fJL) {
                    if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null) {
                        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            aq aqVar2 = new aq("c13266");
                            aqVar2.dW("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar2.dW("fid", VideoPbFragment.this.dkd().getPbData().getForumId());
                            aqVar2.dW("tid", VideoPbFragment.this.dkd().dme());
                            aqVar2.dW("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(aqVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.lHZ, VideoPbFragment.this.fJL);
                        VideoPbFragment.this.lHZ.finish();
                    }
                } else if (view == VideoPbFragment.this.jri && VideoPbFragment.this.mbl != null) {
                    if (VideoPbFragment.this.dkd() == null || VideoPbFragment.this.dkd().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> diP = VideoPbFragment.this.dkd().getPbData().diP();
                    if ((diP == null || diP.size() <= 0) && VideoPbFragment.this.dkd().dmg()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new aq("c12378").dW("tid", VideoPbFragment.this.dkd().dme()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("fid", VideoPbFragment.this.dkd().getForumId()));
                    VideoPbFragment.this.mbl.dlh();
                } else if (VideoPbFragment.this.mbl.dpX() != null && view == VideoPbFragment.this.mbl.dpX().dnw()) {
                    if (VideoPbFragment.this.dkd() != null) {
                        VideoPbFragment.this.mbl.doP();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.cBI();
                            VideoPbFragment.this.dow();
                            VideoPbFragment.this.dkd().Fw(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.mbl != null && VideoPbFragment.this.mbl.dpX() != null && view == VideoPbFragment.this.mbl.dpX().dnr()) {
                    VideoPbFragment.this.mbl.baz();
                } else if (VideoPbFragment.this.mbl != null && ((VideoPbFragment.this.mbl.dpX() != null && view == VideoPbFragment.this.mbl.dpX().dnz()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                    VideoPbFragment.this.mbl.doP();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.cBI();
                            VideoPbFragment.this.dow();
                            VideoPbFragment.this.mbl.dU(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.dkd().dmy()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.mbl != null && VideoPbFragment.this.mbl.dpX() != null && view == VideoPbFragment.this.mbl.dpX().dnp()) {
                    if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null && VideoPbFragment.this.dkd().getPbData().diN() != null) {
                        VideoPbFragment.this.mbl.baz();
                        TiebaStatic.log(new aq("c13062"));
                        VideoPbFragment.this.mbl.OB(VideoPbFragment.this.dkd().getPbData().diN().bnN());
                    }
                } else if (view.getId() == R.id.pb_floor_feedback) {
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (VideoPbFragment.this.mbl != null) {
                        VideoPbFragment.this.mbl.i(sparseArray);
                    }
                } else if (VideoPbFragment.this.mbl != null && VideoPbFragment.this.mbl.dpX() != null && view == VideoPbFragment.this.mbl.dpX().dnA()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        ao.C(true, false);
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).an("obj_type", 0).an("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.CAM_X0201_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).an("obj_type", 1).an("obj_source", 1));
                    }
                    VideoPbFragment.this.mbl.dpW();
                } else if (VideoPbFragment.this.mbl != null && (view == VideoPbFragment.this.mbl.dou() || (VideoPbFragment.this.mbl.dpX() != null && (view == VideoPbFragment.this.mbl.dpX().dnv() || view == VideoPbFragment.this.mbl.dpX().dnt())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if ((VideoPbFragment.this.dkd() != null || VideoPbFragment.this.dkd().getPbData() != null) && !VideoPbFragment.this.gca.dMh()) {
                        VideoPbFragment.this.mbl.doP();
                        if (VideoPbFragment.this.mbl.dpX() != null && view == VideoPbFragment.this.mbl.dpX().dnt()) {
                            if (VideoPbFragment.this.dkd().getPbData().diN().bns() == 1) {
                                i2 = 5;
                            } else {
                                i2 = 4;
                            }
                        } else if (VideoPbFragment.this.mbl.dpX() != null && view == VideoPbFragment.this.mbl.dpX().dnv()) {
                            if (VideoPbFragment.this.dkd().getPbData().diN().bnt() != 1) {
                                i2 = 6;
                            }
                        } else {
                            i2 = view == VideoPbFragment.this.mbl.dou() ? 2 : 0;
                        }
                        ForumData forum = VideoPbFragment.this.dkd().getPbData().getForum();
                        String name = forum.getName();
                        String id = forum.getId();
                        String id2 = VideoPbFragment.this.dkd().getPbData().diN().getId();
                        VideoPbFragment.this.showProgressBar();
                        VideoPbFragment.this.gca.c(id, name, id2, i2, VideoPbFragment.this.mbl.dov());
                    }
                } else if (VideoPbFragment.this.mbl != null && VideoPbFragment.this.mbl.dpX() != null && view == VideoPbFragment.this.mbl.dpX().dny()) {
                    if (VideoPbFragment.this.dkd() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.mbl.doP();
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.dkd().getPbData(), VideoPbFragment.this.dkd().dmg(), 1);
                        if (b2 != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.dkd().getPbData().getForum().getId(), VideoPbFragment.this.dkd().getPbData().getForum().getName(), VideoPbFragment.this.dkd().getPbData().diN().getId(), String.valueOf(VideoPbFragment.this.dkd().getPbData().getUserData().getUserId()), (String) b2.get(R.id.tag_forbid_user_name), (String) b2.get(R.id.tag_forbid_user_name_show), (String) b2.get(R.id.tag_forbid_user_post_id), (String) b2.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.mbl != null && VideoPbFragment.this.mbl.dpX() != null && view == VideoPbFragment.this.mbl.dpX().dnu()) {
                    if (VideoPbFragment.this.dkd() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b3 = VideoPbFragment.this.b(VideoPbFragment.this.dkd().getPbData(), VideoPbFragment.this.dkd().dmg(), 1);
                        if (b3 != null) {
                            if (StringUtils.isNull((String) b3.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.mbl.a(((Integer) b3.get(R.id.tag_del_post_type)).intValue(), (String) b3.get(R.id.tag_del_post_id), ((Integer) b3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b3.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.mbl.a(((Integer) b3.get(R.id.tag_del_post_type)).intValue(), (String) b3.get(R.id.tag_del_post_id), ((Integer) b3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b3.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b3.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.mbl.baz();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        aq aqVar3 = new aq("c13398");
                        aqVar3.dW("tid", VideoPbFragment.this.dkd().dme());
                        aqVar3.dW("fid", VideoPbFragment.this.dkd().getForumId());
                        aqVar3.dW("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar3.an("obj_locate", 4);
                        TiebaStatic.log(aqVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new aq("c10517").an("obj_locate", 3).dW("fid", VideoPbFragment.this.dkd().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null) {
                        if (VideoPbFragment.this.mbl != null) {
                            VideoPbFragment.this.mbl.doP();
                        }
                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                        PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                        PostData postData3 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                        if (postData2 != null) {
                            if (postData2.dLy() == 1) {
                                TiebaStatic.log(new aq("c12630"));
                            }
                            if (postData2.nnI != null) {
                                aq bst = postData2.nnI.bst();
                                bst.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    bst.an("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    bst.an("obj_locate", 8);
                                }
                                TiebaStatic.log(bst);
                            }
                            VideoPbFragment.this.cBI();
                            TiebaStatic.log("c11742");
                            if (postData3 != null) {
                                VideoPbFragment.this.a(postData2, postData3, false, true);
                            } else {
                                VideoPbFragment.this.a(postData2, (PostData) null, false, false);
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                    if (VideoPbFragment.this.dkd() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            aq aqVar4 = new aq("c13398");
                            aqVar4.dW("tid", VideoPbFragment.this.dkd().dme());
                            aqVar4.dW("fid", VideoPbFragment.this.dkd().getForumId());
                            aqVar4.dW("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar4.an("obj_locate", 6);
                            TiebaStatic.log(aqVar4);
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData4.nnI != null) {
                                    aq bst2 = postData4.nnI.bst();
                                    bst2.delete("obj_locate");
                                    bst2.an("obj_locate", 8);
                                    TiebaStatic.log(bst2);
                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                    TiebaStatic.log(new aq("c13700").dW("tid", VideoPbFragment.this.dkd().dmf()).dW("fid", VideoPbFragment.this.dkd().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dW("post_id", postData4.getId()).an("obj_source", 1).an("obj_type", 3));
                                }
                                if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null && VideoPbFragment.this.lHU != null && postData4.bnx() != null && postData4.dLm() != 1) {
                                    if (VideoPbFragment.this.lRh != null) {
                                        VideoPbFragment.this.lRh.dkM();
                                    }
                                    if (VideoPbFragment.this.lIB && postData4.dLj() != null && postData4.dLj().size() != 0) {
                                        VideoPbFragment.this.a(postData4, (PostData) null, true, false);
                                        return;
                                    }
                                    p pVar2 = new p();
                                    pVar2.a(VideoPbFragment.this.dkd().getPbData().getForum());
                                    pVar2.setThreadData(VideoPbFragment.this.dkd().getPbData().diN());
                                    pVar2.g(postData4);
                                    VideoPbFragment.this.lHU.d(pVar2);
                                    VideoPbFragment.this.lHU.setPostId(postData4.getId());
                                    VideoPbFragment.this.a(view, postData4.bnx().getUserId(), "", postData4);
                                    if (VideoPbFragment.this.lIS != null) {
                                        VideoPbFragment.this.vt(VideoPbFragment.this.lIS.bBD());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.mbl != null && VideoPbFragment.this.dkd() != null) {
                        if (com.baidu.tbadk.a.d.biO() || VideoPbFragment.this.drT() != null) {
                            if (!com.baidu.tbadk.a.d.biO() || VideoPbFragment.this.drV() != null) {
                                VideoPbFragment.this.mbl.doP();
                                if (VideoPbFragment.this.Fr(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.dkd() != null) {
                                    VideoPbFragment.this.dlo();
                                    if (VideoPbFragment.this.dkd().getPbData() != null && VideoPbFragment.this.dkd().getPbData().diN() != null && VideoPbFragment.this.dkd().getPbData().diN().bnx() != null) {
                                        TiebaStatic.log(new aq("c13402").dW("tid", VideoPbFragment.this.dkd().dme()).dW("fid", VideoPbFragment.this.dkd().getPbData().getForumId()).an("obj_locate", 3).dW("uid", VideoPbFragment.this.dkd().getPbData().diN().bnx().getUserId()));
                                    }
                                    if (VideoPbFragment.this.dkd().getPbData().diN() != null && VideoPbFragment.this.dkd().getPbData().diN().bnx() != null && VideoPbFragment.this.dkd().getPbData().diN().bnx().getUserId() != null && VideoPbFragment.this.lIE != null) {
                                        int h = VideoPbFragment.this.mbl.h(VideoPbFragment.this.dkd().getPbData());
                                        bz diN = VideoPbFragment.this.dkd().getPbData().diN();
                                        if (!diN.bme()) {
                                            if (diN.bmf()) {
                                                i = 3;
                                            } else if (diN.bpv()) {
                                                i = 4;
                                            } else {
                                                i = diN.bpw() ? 5 : 1;
                                            }
                                        }
                                        TiebaStatic.log(new aq("c12526").dW("tid", VideoPbFragment.this.dkd().dme()).an("obj_locate", 1).dW("obj_id", VideoPbFragment.this.dkd().getPbData().diN().bnx().getUserId()).an("obj_type", VideoPbFragment.this.lIE.bjE() ? 0 : 1).an("obj_source", h).an("obj_param1", i));
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.vV(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.mbl != null && VideoPbFragment.this.eWN != null && VideoPbFragment.this.dkd().getPbData() != null && VideoPbFragment.this.dkd().getPbData().diN() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        f pbData = VideoPbFragment.this.dkd().getPbData();
                        if (pbData.diN().bno() != 0) {
                            int currentItem = VideoPbFragment.this.eWN.getCurrentItem();
                            if (!com.baidu.tbadk.a.d.biO() && currentItem == VideoPbFragment.maP) {
                                VideoPbFragment.this.eWN.setCurrentItem(VideoPbFragment.maQ);
                            } else if (com.baidu.tbadk.a.d.biO() || currentItem == VideoPbFragment.maQ) {
                                if (!com.baidu.tbadk.a.d.biO() && VideoPbFragment.this.drT() == null) {
                                    return;
                                }
                                if ((!com.baidu.tbadk.a.d.biO() || VideoPbFragment.this.drV() != null) && VideoPbFragment.this.cEB() != null) {
                                    aq dW = new aq("c13403").dW("tid", VideoPbFragment.this.dkd().dme()).dW("fid", VideoPbFragment.this.dkd().getPbData().getForumId()).dW("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView cEB = VideoPbFragment.this.cEB();
                                    if (cEB != null) {
                                        boolean canScrollVertically = cEB.canScrollVertically(1);
                                        boolean canScrollVertically2 = cEB.canScrollVertically(-1);
                                        if (VideoPbFragment.this.ZQ != null) {
                                            VideoPbFragment.this.ZQ.setExpanded(false, true);
                                        }
                                        if (cEB.getLayoutManager() != null && (cEB.getLayoutManager() instanceof LinearLayoutManager)) {
                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) cEB.getLayoutManager();
                                            if (!canScrollVertically2 && canScrollVertically) {
                                                if (VideoPbFragment.this.lIw != -1 || VideoPbFragment.this.lIx != Integer.MIN_VALUE) {
                                                    if (VideoPbFragment.this.lIw > 3 || (VideoPbFragment.this.lIw == 3 && VideoPbFragment.this.lIx < (-equipmentHeight))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lIw, VideoPbFragment.this.lIx + equipmentHeight);
                                                        cEB.smoothScrollBy(0, equipmentHeight);
                                                    } else if (VideoPbFragment.this.lIw >= 2) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lIw, VideoPbFragment.this.lIx + (equipmentHeight / 2));
                                                        cEB.smoothScrollBy(0, equipmentHeight / 2);
                                                    } else if (VideoPbFragment.this.lIw == 1) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lIw, VideoPbFragment.this.lIx + (equipmentHeight / 4));
                                                        cEB.smoothScrollBy(0, equipmentHeight / 4);
                                                    } else {
                                                        cEB.smoothScrollBy(0, -VideoPbFragment.this.lIx);
                                                    }
                                                    dW.an("obj_locate", 2);
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                int firstVisiblePosition = cEB.getFirstVisiblePosition();
                                                View childAt = cEB.getChildAt(0);
                                                int top = childAt == null ? 0 : childAt.getTop();
                                                VideoPbFragment.this.lIw = firstVisiblePosition;
                                                VideoPbFragment.this.lIx = top;
                                                if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && cEB.getCount() >= 6)) {
                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                    cEB.smoothScrollToPosition(0);
                                                } else {
                                                    cEB.smoothScrollToPosition(0);
                                                }
                                                dW.an("obj_locate", 1);
                                            }
                                            TiebaStatic.log(dW);
                                            com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(view);
                                            aq aqVar5 = new aq("c12942");
                                            aqVar5.an("obj_type", 1);
                                            aqVar5.an("obj_locate", 4);
                                            aqVar5.dW("tid", VideoPbFragment.this.dkd().dme());
                                            aqVar5.dW(IntentConfig.NID, pbData.diN().blV());
                                            if (bV != null) {
                                                aqVar5.dW("obj_cur_page", bV.getCurrentPageKey());
                                            }
                                            if (com.baidu.tbadk.pageExtra.d.bDu() != null) {
                                                aqVar5.dW("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDu());
                                            }
                                            TiebaStatic.log(aqVar5);
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
                            if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null && VideoPbFragment.this.dkd().getPbData().diN() != null && VideoPbFragment.this.dkd().getPbData().diN().bnx() != null) {
                                TiebaStatic.log(new aq("c13402").dW("tid", VideoPbFragment.this.dkd().dme()).dW("fid", VideoPbFragment.this.dkd().getPbData().getForumId()).an("obj_locate", 2).dW("uid", VideoPbFragment.this.dkd().getPbData().diN().bnx().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.vW(false);
                        VideoPbFragment.this.dlc();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.lJf >= 0) {
                        if (VideoPbFragment.this.dkd() != null) {
                            VideoPbFragment.this.dkd().dmQ();
                        }
                        if (com.baidu.tbadk.a.d.biO() && VideoPbFragment.this.drV() != null && VideoPbFragment.this.drV().dsC() != null) {
                            VideoPbFragment.this.drV().dsC().setData(VideoPbFragment.this.dkd().getPbData());
                        } else if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.drT() != null && VideoPbFragment.this.drT().dsC() != null) {
                            VideoPbFragment.this.drT().dsC().setData(VideoPbFragment.this.dkd().getPbData());
                        }
                        VideoPbFragment.this.lJf = 0;
                        VideoPbFragment.this.mbn = Integer.MIN_VALUE;
                        if (com.baidu.tbadk.a.d.biO() && VideoPbFragment.this.dkd() != null && VideoPbFragment.this.drV() != null) {
                            VideoPbFragment.this.drV().df(VideoPbFragment.this.dkd().dmT(), VideoPbFragment.this.dkd().dmU());
                            VideoPbFragment.this.dkd().dc(0, 0);
                        } else if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.drT() != null) {
                            VideoPbFragment.this.drT().df(VideoPbFragment.this.dkd().dmT(), VideoPbFragment.this.dkd().dmU());
                            VideoPbFragment.this.dkd().dc(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.dkd() != null) {
                        aq aqVar6 = new aq("c13398");
                        aqVar6.dW("tid", VideoPbFragment.this.dkd().dme());
                        aqVar6.dW("fid", VideoPbFragment.this.dkd().getForumId());
                        aqVar6.dW("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar6.an("obj_locate", 2);
                        TiebaStatic.log(aqVar6);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bg.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.brx().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.dnX();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.dnX();
                } else if (VideoPbFragment.this.mbl.dpX() != null && view == VideoPbFragment.this.mbl.dpX().dnx()) {
                    VideoPbFragment.this.mbl.doP();
                    if (VideoPbFragment.this.dkd() != null) {
                        VideoPbFragment.this.ise.setThreadId(VideoPbFragment.this.dkd().dme());
                    }
                    if (VideoPbFragment.this.dkd() == null || !VideoPbFragment.this.dkd().isPrivacy()) {
                        VideoPbFragment.this.ise.cqF();
                        if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null && VideoPbFragment.this.dkd().getPbData().getThreadId() != null && VideoPbFragment.this.dkd().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                            i3 = 2;
                        }
                        if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null) {
                            VideoPbFragment.this.ise.l(3, i3, VideoPbFragment.this.dkd().getPbData().getThreadId());
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                    if (VideoPbFragment.this.dkd().getPbData() != null) {
                        VideoPbFragment.this.ise.l(3, 3, VideoPbFragment.this.dkd().getPbData().getThreadId());
                    }
                } else if (view.getId() == R.id.pb_floor_right_top_feedback || view.getId() == R.id.pb_post_op_more) {
                    aq aqVar7 = new aq("c13398");
                    aqVar7.dW("tid", VideoPbFragment.this.dkd().dme());
                    aqVar7.dW("fid", VideoPbFragment.this.dkd().getForumId());
                    aqVar7.dW("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar7.an("obj_locate", 7);
                    TiebaStatic.log(aqVar7);
                    VideoPbFragment.this.mbl.wd(false);
                    VideoPbFragment.this.mbl.drK().onLongClick(view);
                }
            }
        }
    };
    private View.OnClickListener lFn = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.mbl != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.mbl.f(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.mbl.dN(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.mbl.f(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.mbl.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private CustomMessageListener joX = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
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
            VideoPbFragment.this.mbl.wd(true);
            return VideoPbFragment.this.mbl.drK().onLongClick(view);
        }
    };
    public SortSwitchButton.a lJE = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zf(int i) {
            if (VideoPbFragment.this.mbl != null) {
                VideoPbFragment.this.mbl.doP();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.dkd() == null || VideoPbFragment.this.dkd().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.cBI();
                VideoPbFragment.this.dow();
                if (VideoPbFragment.this.dkd().getPbData() != null && VideoPbFragment.this.dkd().getPbData().lBl != null && VideoPbFragment.this.dkd().getPbData().lBl.size() > i) {
                    int intValue = VideoPbFragment.this.dkd().getPbData().lBl.get(i).sort_type.intValue();
                    TiebaStatic.log(new aq("c13699").dW("tid", VideoPbFragment.this.dkd().dmf()).dW("fid", VideoPbFragment.this.dkd().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).an("obj_type", Fu(intValue)));
                    if (VideoPbFragment.this.dkd().FB(intValue)) {
                        VideoPbFragment.this.mIsLoading = true;
                    }
                }
                return true;
            }
        }

        private int Fu(int i) {
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
    private a mbm = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void dlm() {
        if (dkd() != null && dkd().getPbData() != null && dkd().getPbData().diN() != null) {
            bz diN = dkd().getPbData().diN();
            diN.mRecomAbTag = dkd().dna();
            diN.mRecomWeight = dkd().dmY();
            diN.mRecomSource = dkd().dmZ();
            diN.mRecomExtra = dkd().dnb();
            diN.eRS = dkd().dmm();
            if (diN.getFid() == 0) {
                diN.setFid(com.baidu.adp.lib.f.b.toLong(dkd().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), diN, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uK(boolean z) {
        if (dkd() != null && dkd().getPbData() != null && dkd().getPbData().diN() != null) {
            bz diN = dkd().getPbData().diN();
            diN.mRecomAbTag = dkd().dna();
            diN.mRecomWeight = dkd().dmY();
            diN.mRecomSource = dkd().dmZ();
            diN.mRecomExtra = dkd().dnb();
            if (diN.getFid() == 0) {
                diN.setFid(com.baidu.adp.lib.f.b.toLong(dkd().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), diN, "c13563");
            TbPageTag fu = com.baidu.tbadk.pageInfo.c.fu(getContext());
            if (a2 != null && fu != null && PageStayDurationConstants.PageName.VIDEO_LIST.equals(fu.locatePage)) {
                a2.dW("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dW("obj_pre_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            if (a2 != null) {
                a2.an("reply_type", 1);
                if (z) {
                    a2.an("obj_type", 2);
                } else {
                    a2.an("obj_type", 1);
                }
                com.baidu.tbadk.pageExtra.c fr = com.baidu.tbadk.pageExtra.d.fr(getContext());
                if (fr != null) {
                    a2.dW("obj_cur_page", fr.getCurrentPageKey());
                }
                if (com.baidu.tbadk.pageExtra.d.bDu() != null) {
                    a2.dW("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDu());
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
            if (at.isEmpty(str)) {
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
            String string = !TextUtils.isEmpty(bVar.npN) ? bVar.npN : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.Ad(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.jD(true);
                aVar.b(getPageContext());
                aVar.bqe();
            } else {
                a(0, bVar.mSuccess, bVar.npN, z);
            }
            if (bVar.mSuccess) {
                if (bVar.iHw == 1) {
                    ArrayList<PostData> diP = dkd().getPbData().diP();
                    int size = diP.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(diP.get(i).getId())) {
                            i++;
                        } else {
                            diP.remove(i);
                            break;
                        }
                    }
                    dkd().getPbData().diN().nh(dkd().getPbData().diN().bno() - 1);
                    if (com.baidu.tbadk.a.d.biO() && drV() != null) {
                        drV().dsE();
                    } else if (drT() != null) {
                        drT().dsE();
                    }
                } else if (bVar.iHw == 0) {
                    dln();
                } else if (bVar.iHw == 2) {
                    ArrayList<PostData> diP2 = dkd().getPbData().diP();
                    int size2 = diP2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= diP2.get(i2).dLj().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(diP2.get(i2).dLj().get(i3).getId())) {
                                i3++;
                            } else {
                                diP2.get(i2).dLj().remove(i3);
                                diP2.get(i2).dLl();
                                z2 = true;
                                break;
                            }
                        }
                        diP2.get(i2).Sg(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        if (com.baidu.tbadk.a.d.biO() && drV() != null) {
                            drV().dsE();
                        } else if (drT() != null) {
                            drT().dsE();
                        }
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = dkd().getPbData().djb().lCS;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dLj().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dLj().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dLj().remove(i2);
                    list.get(i).dLl();
                    z = true;
                    break;
                }
            }
            list.get(i).Sg(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            if (com.baidu.tbadk.a.d.biO() && drV() != null) {
                drV().dsE();
            } else if (drT() != null) {
                drT().dsE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (gVar != null && dkd() != null && dkd().getPbData() != null && dkd().getPbData().diN() != null) {
            a(this.gca.getLoadDataMode(), gVar.mSuccess, gVar.npN, false);
            if (gVar.mSuccess) {
                this.lIH = true;
                if (i == 2 || i == 3) {
                    this.lII = true;
                    this.lIJ = false;
                } else if (i == 4 || i == 5) {
                    this.lII = false;
                    this.lIJ = true;
                }
                if (i == 2) {
                    dkd().getPbData().diN().nk(1);
                    dkd().setIsGood(1);
                } else if (i == 3) {
                    dkd().getPbData().diN().nk(0);
                    dkd().setIsGood(0);
                } else if (i == 4) {
                    dkd().getPbData().diN().nj(1);
                    dkd().Fv(1);
                } else if (i == 5) {
                    dkd().getPbData().diN().nj(0);
                    dkd().Fv(0);
                }
            } else {
                if (gVar != null && !TextUtils.isEmpty(gVar.npN)) {
                    string = gVar.npN;
                } else {
                    string = getString(R.string.operation_failed);
                }
                l.showToast(getPageContext().getPageActivity(), string);
            }
            if (dkd().getPbData().diN() != null && drU() != null) {
                drU().dsO();
            }
        }
    }

    private void dln() {
        if (dkd().dmh() || dkd().dmj()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", dkd().dme());
            PbActivity pbActivity = this.lHZ;
            PbActivity pbActivity2 = this.lHZ;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, dkd().dme()));
        if (dlq()) {
            this.lHZ.finish();
        }
    }

    private boolean dlq() {
        if (dkd() == null) {
            return true;
        }
        if (dkd().getPbData() == null || !dkd().getPbData().djq()) {
            if (dkd().bjE()) {
                final MarkData dmz = dkd().dmz();
                if (dmz == null || !dkd().getIsFromMark() || cEB() == null) {
                    return true;
                }
                final MarkData FC = dkd().FC(cEB().getFirstVisiblePosition());
                if (FC == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dmz);
                    this.lHZ.setResult(-1, intent);
                    return true;
                } else if (FC.getPostId() == null || FC.getPostId().equals(dmz.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dmz);
                    this.lHZ.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.Ad(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.lIE != null) {
                                if (VideoPbFragment.this.lIE.bjE()) {
                                    VideoPbFragment.this.lIE.bjF();
                                    VideoPbFragment.this.lIE.iY(false);
                                }
                                VideoPbFragment.this.lIE.a(FC);
                                VideoPbFragment.this.lIE.iY(true);
                                VideoPbFragment.this.lIE.bjG();
                            }
                            dmz.setPostId(FC.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dmz);
                            VideoPbFragment.this.lHZ.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dkr();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dmz);
                            VideoPbFragment.this.lHZ.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dkr();
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.bqe();
                    return false;
                }
            } else if (dkd().getPbData() == null || dkd().getPbData().diP() == null || dkd().getPbData().diP().size() <= 0 || !dkd().getIsFromMark()) {
                return true;
            } else {
                this.lHZ.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkr() {
        this.lHZ.dkr();
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
    public void vV(boolean z) {
        com.baidu.tieba.pb.data.f pbData;
        int i;
        if (dkd() != null && this.mbl != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = dkd().getPbData()) != null) {
                bz diN = pbData.diN();
                if (diN != null && diN.bnx() != null) {
                    TiebaStatic.log(new aq("c13402").dW("tid", dkd().dme()).dW("fid", pbData.getForumId()).an("obj_locate", 4).dW("uid", diN.bnx().getUserId()));
                }
                if (diN != null) {
                    if (diN.bme()) {
                        i = 2;
                    } else if (diN.bmf()) {
                        i = 3;
                    } else if (diN.bpv()) {
                        i = 4;
                    } else if (diN.bpw()) {
                        i = 5;
                    }
                    aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    aqVar.dW("tid", dkd().dme());
                    aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dW("fid", dkd().getForumId());
                    if (!z) {
                        aqVar.an("obj_locate", 6);
                    } else {
                        aqVar.an("obj_locate", 5);
                    }
                    aqVar.an("obj_name", i);
                    aqVar.an("obj_type", 2);
                    if (diN != null) {
                        if (diN.bme()) {
                            aqVar.an("obj_type", 10);
                        } else if (diN.bmf()) {
                            aqVar.an("obj_type", 9);
                        } else if (diN.bpw()) {
                            aqVar.an("obj_type", 8);
                        } else if (diN.bpv()) {
                            aqVar.an("obj_type", 7);
                        } else if (diN.isShareThread) {
                            aqVar.an("obj_type", 6);
                        } else if (diN.threadType == 0) {
                            aqVar.an("obj_type", 1);
                        } else if (diN.threadType == 40) {
                            aqVar.an("obj_type", 2);
                        } else if (diN.threadType == 49) {
                            aqVar.an("obj_type", 3);
                        } else if (diN.threadType == 54) {
                            aqVar.an("obj_type", 4);
                        } else {
                            aqVar.an("obj_type", 5);
                        }
                        aqVar.dW(IntentConfig.NID, diN.blV());
                        aqVar.an(IntentConfig.CARD_TYPE, diN.bpz());
                        aqVar.dW(IntentConfig.RECOM_SOURCE, diN.mRecomSource);
                        aqVar.dW("ab_tag", diN.mRecomAbTag);
                        aqVar.dW("weight", diN.mRecomWeight);
                        aqVar.dW("extra", diN.mRecomExtra);
                        aqVar.dW(IntentConfig.NID, diN.blV());
                        if (diN.getBaijiahaoData() != null && !at.isEmpty(diN.getBaijiahaoData().oriUgcVid)) {
                            aqVar.dW("obj_param6", diN.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        aqVar.dW("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (dlL() != null) {
                        com.baidu.tbadk.pageInfo.c.b(dlL(), aqVar);
                    }
                    TiebaStatic.log(aqVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (dkd().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> diP = pbData.diP();
                        if ((diP == null || diP.size() <= 0) && dkd().dmg()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.mbl.doP();
                        cBI();
                        TiebaStatic.log(new aq("c11939"));
                        if (!AntiHelper.d(getContext(), diN)) {
                            if (this.lQF != null) {
                                this.lQF.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                Fs(z ? 2 : 1);
                                return;
                            }
                            this.mbl.showLoadingDialog();
                            dkd().dmK().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                aq aqVar2 = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar2.dW("tid", dkd().dme());
                aqVar2.dW("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.dW("fid", dkd().getForumId());
                if (!z) {
                }
                aqVar2.an("obj_name", i);
                aqVar2.an("obj_type", 2);
                if (diN != null) {
                }
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (dlL() != null) {
                }
                TiebaStatic.log(aqVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment drA() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
        M(videoPbViewModel.dsg());
        N(videoPbViewModel.dsg());
        if (dkd() != null && dkd().getPbData() != null) {
            boolean isFromMark = dkd().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = dkd().getPbData();
            if (isFromMark) {
                PostData L = L(pbData);
                if (pbData.bjD() != null && !pbData.bjD().equals(L.getId()) && this.eWN != null) {
                    if (com.baidu.tbadk.a.d.biO()) {
                        this.eWN.setCurrentItem(maR);
                    } else {
                        this.eWN.setCurrentItem(maQ);
                    }
                }
            }
        }
        videoPbViewModel.dsh().observe(this, new Observer<bz>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aR */
            public void onChanged(@Nullable bz bzVar) {
                BdTypeRecyclerView cEB;
                if (bzVar != null && bzVar.bnO() != null) {
                    if (VideoPbFragment.this.maY.getVideoUrl() == null || !VideoPbFragment.this.maY.getVideoUrl().equals(bzVar.bnO().video_url)) {
                        if (!at.isEmpty(VideoPbFragment.this.maY.getVideoUrl())) {
                            VideoPbFragment.this.lIn = true;
                            if (com.baidu.tbadk.a.d.biO()) {
                                VideoPbFragment.this.eWN.setCurrentItem(VideoPbFragment.maR);
                            } else {
                                VideoPbFragment.this.eWN.setCurrentItem(VideoPbFragment.maP);
                            }
                            if (com.baidu.tbadk.a.d.biO() && (cEB = VideoPbFragment.this.cEB()) != null) {
                                cEB.scrollToPosition(0);
                            }
                        }
                        if (VideoPbFragment.this.maZ == null || !VideoPbFragment.this.maZ.isPlaying()) {
                            VideoPbFragment.this.drB();
                            VideoPbFragment.this.aQ(bzVar);
                        }
                        VideoPbFragment.this.drC();
                        if (VideoPbFragment.this.maZ.dsu()) {
                            VideoPbFragment.this.maZ.start();
                        }
                        boolean z = !at.equals(VideoPbFragment.this.maY.getVideoUrl(), bzVar.bnO().video_url);
                        VideoPbFragment.this.maY.setData(bzVar);
                        if (com.baidu.tbadk.a.d.biO()) {
                            VideoPbFragment.this.maY.wf(false);
                        } else {
                            VideoPbFragment.this.maY.wf(VideoPbFragment.this.eWN.getCurrentItem() == 0);
                        }
                        if (z) {
                            VideoPbFragment.this.maY.startPlay();
                            VideoPbFragment.this.maY.dtf();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.maY.setData(bzVar);
                }
            }
        });
        videoPbViewModel.dsq().observe(this, new Observer<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: u */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.eWN.setCurrentItem(num.intValue());
            }
        });
        videoPbViewModel.dsl().observe(this, new Observer<bz>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aR */
            public void onChanged(@Nullable bz bzVar) {
                VideoPbFragment.this.maY.aV(bzVar);
            }
        });
        videoPbViewModel.dsm().observe(this, new Observer<bz>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aR */
            public void onChanged(@Nullable bz bzVar) {
                VideoPbFragment.this.maY.aW(bzVar);
            }
        });
        videoPbViewModel.dsn().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: s */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.drM();
            }
        });
        videoPbViewModel.dso().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: s */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drB() {
        ViewGroup.LayoutParams layoutParams = this.mbb.getLayoutParams();
        layoutParams.height = 0;
        this.mbb.setLayoutParams(layoutParams);
        this.mbb.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drC() {
        if (this.maZ == null) {
            this.maZ = new e(getBaseFragmentActivity(), this.maX);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(dlL()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.maX.getOriginHeight() + statusBarHeight);
            final VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.maZ.b(videoPbViewModel.dsi(), rect);
            if (this.maZ.dsu()) {
                this.maZ.c(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (com.baidu.tbadk.a.d.biO()) {
                            if (videoPbViewModel.dsj() || VideoPbFragment.this.dkd().dnd() == VideoPbFragment.maR) {
                                VideoPbFragment.this.eWN.setCurrentItem(VideoPbFragment.maR);
                            }
                        } else if (videoPbViewModel.dsj() || VideoPbFragment.this.dkd().dnd() == VideoPbFragment.maQ) {
                            VideoPbFragment.this.eWN.setCurrentItem(VideoPbFragment.maQ);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (com.baidu.tbadk.a.d.biO()) {
                            if (videoPbViewModel.dsj() || VideoPbFragment.this.dkd().dnd() == VideoPbFragment.maR) {
                                VideoPbFragment.this.eWN.setCurrentItem(VideoPbFragment.maR);
                            }
                        } else if (videoPbViewModel.dsj() || VideoPbFragment.this.dkd().dnd() == VideoPbFragment.maQ) {
                            VideoPbFragment.this.eWN.setCurrentItem(VideoPbFragment.maQ);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (com.baidu.tbadk.a.d.biO()) {
                if (videoPbViewModel.dsj() || dkd().dnd() == maR) {
                    this.eWN.setCurrentItem(maR);
                }
            } else if (videoPbViewModel.dsj() || dkd().dnd() == maQ) {
                this.eWN.setCurrentItem(maQ);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.mbr && (this.mbs || dsa())) {
            drZ();
            UtilHelper.hideStatusBar(dlL(), dlL().getRootView());
            this.mbs = false;
            if (this.maY != null) {
                this.maY.vX(false);
            }
        }
        if (i == 4) {
            return this.maY.dys();
        }
        if (i == 24) {
            return this.maY.dtc();
        }
        if (i == 25) {
            return this.maY.dtd();
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
    public void aQ(bz bzVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect dnc;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bzVar != null && bzVar.bnO() != null) {
            int intValue = bzVar.bnO().video_width.intValue();
            int intValue2 = bzVar.bnO().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (dkd() != null || (dnc = dkd().dnc()) == null) ? ceil : dnc.height();
                i = 0;
                layoutParams = this.maX.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.maX.setLayoutParams(layoutParams);
                this.maX.setMaxHeight(ceil);
                this.maX.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.maX.setOriginHeight(height);
                if (!com.baidu.tbadk.a.d.biO()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.maT.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, maS);
                    } else {
                        layoutParams3.height = maS;
                    }
                    this.maT.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.ZQ.getLayoutParams();
                if (!com.baidu.tbadk.a.d.biO()) {
                    ceil += maS;
                }
                if (layoutParams2 != null) {
                    layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                } else {
                    layoutParams2.height = ceil;
                }
                this.ZQ.setLayoutParams(layoutParams2);
                if (i == 0 && (this.ZQ.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.ZQ.getLayoutParams()).getBehavior();
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
        if (dkd() != null) {
        }
        i = 0;
        layoutParams = this.maX.getLayoutParams();
        if (layoutParams != null) {
        }
        this.maX.setLayoutParams(layoutParams);
        this.maX.setMaxHeight(ceil2);
        this.maX.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.maX.setOriginHeight(height);
        if (!com.baidu.tbadk.a.d.biO()) {
        }
        layoutParams2 = (CoordinatorLayout.LayoutParams) this.ZQ.getLayoutParams();
        if (!com.baidu.tbadk.a.d.biO()) {
        }
        if (layoutParams2 != null) {
        }
        this.ZQ.setLayoutParams(layoutParams2);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.lIh = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        at(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.lIZ = new com.baidu.tbadk.core.view.c();
        this.lIZ.toastTime = 1000L;
        if (this.mbl != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.mbl.lJa;
            userMuteAddAndDelCustomMessage.setTag(this.mbl.lJa);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.mbl.lJa;
            userMuteCheckCustomMessage.setTag(this.mbl.lJa);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.ise = new com.baidu.tieba.callfans.a(getPageContext());
        com.baidu.tieba.s.c.dKg().z(getUniqueId());
    }

    private void initData() {
        this.lIE = com.baidu.tbadk.baseEditMark.a.a(this.lHZ);
        if (this.lIE != null) {
            this.lIE.a(this.lJK);
        }
        this.gca = new ForumManageModel(this.lHZ);
        this.gca.setLoadDataCallBack(this.isj);
        this.eYq = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.mbl = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void at(Bundle bundle) {
        this.lIR = new g();
        d(this.lIR);
        this.lIS = (com.baidu.tbadk.editortools.pb.e) this.lIR.fh(getActivity());
        this.lIS.a(this.lHZ.getPageContext());
        this.lIS.a(this.fBH);
        this.lIS.a(this.fBz);
        this.lIS.setFrom(1);
        this.lIS.a(this.lHZ.getPageContext(), bundle);
        this.lIS.bAP().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lIS.bAP().kK(true);
        uJ(true);
        this.lIS.a(dkd().dmv(), dkd().dme(), dkd().dmM());
        registerListener(this.lJp);
        registerListener(this.lJJ);
        registerListener(this.lJo);
        registerListener(this.lJm);
        registerListener(this.jcd);
        if (!dkd().dmm()) {
            this.lIS.CG(dkd().dme());
        }
        if (dkd().dmN()) {
            this.lIS.CE(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.lIS.CE(dnZ());
        }
        this.kOl = new ar();
        if (this.lIS.bBv() != null) {
            this.kOl.f(this.lIS.bBv().getInputView());
        }
        this.lIS.a(this.fBA);
        this.kKi = new al(getPageContext());
        this.kKi.a(new al.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // com.baidu.tbadk.core.util.al.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == al.eYl) {
                        VideoPbFragment.this.lIS.a((String) null, (WriteData) null);
                    } else if (i == al.eYm && VideoPbFragment.this.lRh != null && VideoPbFragment.this.lRh.dkQ() != null) {
                        VideoPbFragment.this.lRh.dkQ().bBU();
                    } else if (i == al.eYn) {
                        VideoPbFragment.this.c(VideoPbFragment.this.lIV);
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
        this.jfv = new com.baidu.tieba.f.b(getActivity());
        this.jfv.a(lJS);
        this.mbr = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        bEt();
        this.ZQ = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.maV = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.maX = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.maY = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.maX);
        this.maY.setStageType("2002");
        this.maY.setUniqueId(getUniqueId());
        this.maY.af(this);
        this.maY.dV(dlL().getRootView());
        this.maY.dW(this.mba);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.maT = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.mbb = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.eWN = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.maW = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.maW.setOnClickListener(this.aCu);
        drE();
        drD();
        drF();
        this.maU = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.eWN.setAdapter(this.maU);
        this.maT.setViewPager(this.eWN);
        this.maT.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (com.baidu.tbadk.a.d.biO() && VideoPbFragment.this.drV() != null) {
                        VideoPbFragment.this.drV().we(false);
                    } else if (VideoPbFragment.this.drT() != null) {
                        VideoPbFragment.this.drT().we(false);
                    }
                    if (VideoPbFragment.this.drU() != null) {
                        VideoPbFragment.this.drU().we(true);
                        VideoPbFragment.this.Gc(VideoPbFragment.this.drU().dsI() != 0 ? 0 : 8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(VideoPbFragment.this.getActivity()).get(VideoPbViewModel.class);
                    if (videoPbViewModel.dsn() != null && videoPbViewModel.dsn().getValue() != null && videoPbViewModel.dsn().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.maY.wf(z);
                    VideoPbFragment.this.dnX();
                    if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null) {
                        TiebaStatic.log(new aq("c13592").dW("tid", VideoPbFragment.this.dkd().dme()).dW("fid", VideoPbFragment.this.dkd().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.drU() != null) {
                        VideoPbFragment.this.drU().we(false);
                    }
                    if (com.baidu.tbadk.a.d.biO() && VideoPbFragment.this.drV() != null) {
                        VideoPbFragment.this.drV().we(true);
                        int dsI = VideoPbFragment.this.drV().dsI();
                        int dsJ = VideoPbFragment.this.drV().dsJ();
                        if (dsI != 0) {
                            VideoPbFragment.this.Gc(8);
                            VideoPbFragment.this.drV().Gc(0);
                        } else if (dsJ != 0) {
                            VideoPbFragment.this.drV().Gc(8);
                            VideoPbFragment.this.Gc(0);
                        } else {
                            VideoPbFragment.this.drV().Gc(8);
                            VideoPbFragment.this.Gc(8);
                        }
                    } else if (VideoPbFragment.this.drT() != null) {
                        VideoPbFragment.this.drT().we(true);
                        int dsI2 = VideoPbFragment.this.drT().dsI();
                        int dsJ2 = VideoPbFragment.this.drT().dsJ();
                        if (dsI2 != 0) {
                            VideoPbFragment.this.Gc(8);
                            VideoPbFragment.this.drT().Gc(0);
                        } else if (dsJ2 != 0) {
                            VideoPbFragment.this.drT().Gc(8);
                            VideoPbFragment.this.Gc(0);
                        } else {
                            VideoPbFragment.this.drT().Gc(8);
                            VideoPbFragment.this.Gc(8);
                        }
                    }
                    VideoPbFragment.this.maY.wf(false);
                    VideoPbFragment.this.ZQ.setExpanded(false, true);
                    if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null) {
                        TiebaStatic.log(new aq("c13593").dW("tid", VideoPbFragment.this.dkd().dme()).dW("fid", VideoPbFragment.this.dkd().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.maU.Ge(i);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.lQg = this.rootView.findViewById(R.id.viewstub_progress);
        drG();
        bVJ();
        if (!this.mbr && this.mbs) {
            drZ();
            UtilHelper.hideStatusBar(dlL(), dlL().getRootView());
            this.mbs = false;
        }
        if (com.baidu.tbadk.a.d.biO()) {
            this.maT.getLayoutParams().height = 0;
        }
    }

    private void drD() {
        this.mbd = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.mbh = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.mbe = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.mbf = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.mbg = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.mbi = this.rootView.findViewById(R.id.ala_live_point);
        this.mbh.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.mbh.setConrers(15);
        this.mbg.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.mbf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.lBV == null || VideoPbFragment.this.lBV.dsU()) {
                    if (VideoPbFragment.this.lBV != null) {
                        TiebaStatic.log(new aq("c13608").dW("tid", VideoPbFragment.this.dkd().getPbData().getThreadId()));
                        VideoPbFragment.this.lBV.mdo = true;
                    }
                } else {
                    TiebaStatic.log(new aq("c13591"));
                }
                VideoPbFragment.this.drO();
            }
        });
        this.mbg.setOnClickListener(this.mbc);
        this.mbb.setOnClickListener(this.mbc);
    }

    private void drE() {
        this.maT.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.maT.setContainerLayoutParams(layoutParams);
        this.maT.setRectPaintColor(R.color.CAM_X0302);
        this.maT.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.maT.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.maT.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.maT.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.maT.setExpandedTabLayoutParams(layoutParams2);
    }

    public void vW(boolean z) {
        if (this.ZQ != null) {
            this.ZQ.setExpanded(z);
        }
    }

    private void drF() {
        this.lQy = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.lQz = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.lQJ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lQK = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lQB = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lQB.setVisibility(0);
        this.lQB.setIsRound(true);
        this.lQB.setBorderWidth(l.getDimens(getContext(), R.dimen.L_X01));
        this.lQB.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.lQB.setPlaceHolder(0);
        dod();
        this.kgY = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lQA = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lQA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.vW(false);
                VideoPbFragment.this.dlc();
                if (VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null && VideoPbFragment.this.dkd().getPbData().diN() != null && VideoPbFragment.this.dkd().getPbData().diN().bnx() != null) {
                    TiebaStatic.log(new aq("c13701").dW("tid", VideoPbFragment.this.dkd().dmf()).dW("fid", VideoPbFragment.this.dkd().getPbData().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new aq("c13402").dW("tid", VideoPbFragment.this.dkd().dme()).dW("fid", VideoPbFragment.this.dkd().getPbData().getForumId()).an("obj_locate", 1).dW("uid", VideoPbFragment.this.dkd().getPbData().diN().bnx().getUserId()));
                }
            }
        });
        this.lQC = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lQC.setOnClickListener(this.aCu);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lQD = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.lQD.setOnClickListener(this.aCu);
        if (booleanExtra) {
            this.lQD.setVisibility(8);
        } else {
            this.lQD.setVisibility(0);
        }
        this.lQE = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.lQE.setOnClickListener(this.aCu);
        this.lQF = new com.baidu.tieba.pb.view.d(this.lQE);
        this.lQF.dto();
        this.lQG = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lQG.setVisibility(0);
        vv(false);
    }

    private void dod() {
        if (this.lQB != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lQB.setImageResource(0);
            this.lQB.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.lQB.setImageResource(R.drawable.transparent_bg);
    }

    private void bEt() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cBJ();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.mba = this.rootView.findViewById(R.id.status_bar_background);
        if (this.mbr) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(dlL());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.mba.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(dlL());
            this.mba.setLayoutParams(layoutParams2);
            this.mba.setVisibility(0);
        }
        this.fJL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aCu);
        this.gVs = (ImageView) this.fJL.findViewById(R.id.widget_navi_back_button);
        SvgManager.bsx().a(this.gVs, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jri = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aCu);
        this.ahO = (ImageView) this.jri.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.jri.setLayoutParams(layoutParams3);
        SvgManager.bsx().a(this.ahO, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jri.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.jmT);
        this.mNavigationBar.setOnTouchListener(this.mbt);
    }

    public void drG() {
        setEditorTools(this.lIS.bAP());
    }

    private void bVJ() {
        this.lHU = new PbFakeFloorModel(getPageContext());
        this.lRh = new r(getPageContext(), this.lHU, this.rootView);
        this.lRh.V(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dnX();
            }
        });
        this.lRh.a(this.lJG);
        this.lHU.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.lHU.u(postData);
                if (com.baidu.tbadk.a.d.biO() || VideoPbFragment.this.drV() != null) {
                    VideoPbFragment.this.drV().dsE();
                } else if (VideoPbFragment.this.drT() != null) {
                    VideoPbFragment.this.drT().dsE();
                }
                VideoPbFragment.this.lRh.dkM();
                VideoPbFragment.this.acX.bzl();
                VideoPbFragment.this.vv(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, PostData postData2, boolean z, boolean z2) {
        PbActivity.a OE;
        String dme = dkd().dme();
        String id = postData.getId();
        String str = "";
        if (postData2 != null) {
            str = postData2.getId();
        }
        int i = 0;
        if (dkd().getPbData() != null) {
            i = dkd().getPbData().djc();
        }
        if (drT() != null && drT().dsG() != null) {
            OE = drT().dsG().OE(id);
        } else if (drV() != null && drV().dsG() != null) {
            OE = drV().dsG().OE(id);
        } else {
            return;
        }
        if (postData != null && dkd() != null && dkd().getPbData() != null && OE != null) {
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dme, id, "pb", true, null, false, str, i, postData.dqX(), dkd().getPbData().getAnti(), false, postData.bnx().getIconInfo()).addBigImageData(OE.lEG, OE.eHG, OE.eHE, OE.index);
            if (z2) {
                addBigImageData.setHighLightPostId(str);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(dkd().getForumId());
            addBigImageData.setBjhData(dkd().dmo());
            addBigImageData.setKeyPageStartFrom(dkd().dmP());
            addBigImageData.setFromFrsForumId(dkd().getFromForumId());
            addBigImageData.setIsOpenEditor(z);
            if (dkd().getPbData().djw() != null) {
                addBigImageData.setHasForumRule(dkd().getPbData().djw().has_forum_rule.intValue());
            }
            if (dkd().getPbData().getUserData() != null) {
                addBigImageData.setIsManager(dkd().getPbData().getUserData().getIs_manager());
            }
            if (dkd().getPbData().getForum().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(dkd().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(dkd().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (dkd().getPbData().getForum() != null) {
                addBigImageData.setForumHeadUrl(dkd().getPbData().getForum().getImage_url());
                addBigImageData.setUserLevel(dkd().getPbData().getForum().getUser_level());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lHZ = (PbActivity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (dkd() != null) {
            dkd().aD(bundle);
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
        this.maY.sc(true);
        if (dkd() != null && !dkd().dmm()) {
            this.lIS.CF(dkd().dme());
        }
        com.baidu.tbadk.BdToken.c.bha().bhl();
        MessageManager.getInstance().unRegisterListener(this.lJz);
        MessageManager.getInstance().unRegisterListener(this.lJA);
        MessageManager.getInstance().unRegisterListener(this.lJB);
        MessageManager.getInstance().unRegisterListener(this.joX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        getVoiceManager().onResume(getPageContext());
        this.maY.sc(false);
        dlH();
        registerListener(this.lJz);
        registerListener(this.lJA);
        registerListener(this.lJB);
        registerListener(this.joX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.maU != null && this.eWN != null) {
            this.maU.Ge(z ? this.eWN.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        dod();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.dKg().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dKg().A(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.lQF != null) {
            this.lQF.onDestroy();
        }
        if (this.gca != null) {
            this.gca.cancelLoadData();
        }
        if (this.maY != null) {
            this.maY.onDestroy();
        }
        if (this.lIs != null) {
            this.lIs.cancelLoadData();
        }
        if (this.kKi != null) {
            this.kKi.onDestroy();
        }
        if (dkd() != null) {
            dkd().cancelLoadData();
            dkd().destory();
            if (dkd().dmJ() != null) {
                dkd().dmJ().onDestroy();
            }
        }
        if (this.lIS != null) {
            this.lIS.onDestroy();
        }
        this.lIZ = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.lHZ);
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        ao.setBackgroundColor(this.mStatusBar, R.color.CAM_X0611);
        ao.setBackgroundColor(this.mba, R.color.CAM_X0608);
        ao.setBackgroundColor(this.maT, R.color.CAM_X0207);
        if (this.maT != null) {
            this.maT.onChangeSkinType();
        }
        if (this.kOl != null) {
            this.kOl.onChangeSkinType();
        }
        if (this.maZ == null || !this.maZ.isPlaying()) {
            ao.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        }
        if (this.acX != null) {
            this.acX.onChangeSkinType(i);
        }
        if (this.lRh != null) {
            this.lRh.onChangeSkinType(i);
        }
        if (this.lQB != null) {
            this.lQB.setBorderColor(ao.getColor(R.color.CAM_X0401));
        }
        if (this.lQA != null) {
            this.lQA.setBackgroundDrawable(ao.aO(l.getDimens(getContext(), R.dimen.tbds47), ao.getColor(R.color.CAM_X0209)));
        }
        if (dkd() != null && dkd().bjE()) {
            WebPManager.a(this.lQD, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.a(this.lQD, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.a(this.lQC, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        SvgManager.bsx().a(this.mbf, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (dkd() != null) {
            x(dkd().getPbData());
        }
        ao.setBackgroundResource(this.maV, R.drawable.personalize_tab_shadow);
        ao.setBackgroundColor(this.mbb, R.color.CAM_X0206);
        ao.setBackgroundColor(this.lQz, R.color.CAM_X0207);
        ao.setBackgroundColor(this.lQy, R.color.CAM_X0203);
        ao.setViewTextColor(this.mbe, R.color.CAM_X0109);
        ao.setViewTextColor(this.mbd, R.color.CAM_X0105);
        ao.setViewTextColor(this.kgY, R.color.CAM_X0109);
        ao.setViewTextColor(this.lQH, R.color.CAM_X0105);
        ao.setViewTextColor(this.lQG, R.color.CAM_X0107);
        ao.d(this.lQG, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        if (com.baidu.tbadk.a.d.biO() && drV() != null) {
            drV().onChangeSkinType(i);
        } else if (drT() != null) {
            drT().onChangeSkinType(i);
        }
        if (drU() != null) {
            drU().onChangeSkinType(i);
        }
        if (this.mbi != null) {
            this.mbi.setBackgroundDrawable(ao.aO(l.getDimens(this.mbi.getContext(), R.dimen.tbds32), ao.getColor(R.color.CAM_X0309)));
        }
        cBI();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jaA == null) {
            this.jaA = VoiceManager.instance();
        }
        return this.jaA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBI() {
        if (this.jaA != null) {
            this.jaA.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dlJ() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dlK() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dkd() {
        return this.lHZ.dkd();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dlL() {
        return this.lHZ;
    }

    public com.baidu.tbadk.baseEditMark.a drH() {
        return this.lIE;
    }

    public View.OnClickListener drI() {
        return this.aCu;
    }

    public View.OnClickListener drJ() {
        return this.lFn;
    }

    public View.OnLongClickListener drK() {
        return this.mOnLongClickListener;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (au.OT(objArr[i].getLink()) && (drawable = ao.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView cEB() {
        Iterator<BaseFragment> it = this.maU.dse().iterator();
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

    private void uJ(boolean z) {
        this.lIS.kS(z);
        this.lIS.kT(z);
        this.lIS.kU(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.mbl != null) {
            if (z) {
                this.mbl.doP();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.mbl.doQ();
            } else {
                this.mbl.doP();
            }
        }
    }

    public boolean Fp(int i) {
        if (this.kKi == null || dkd() == null || dkd().getPbData() == null || dkd().getPbData().getAnti() == null) {
            return true;
        }
        return this.kKi.aN(dkd().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean dle() {
        if ((dkd() != null && dkd().getPbData().djq()) || this.kKi == null || dkd() == null || dkd().getPbData() == null || dkd().getPbData().getAnti() == null) {
            return true;
        }
        return this.kKi.os(dkd().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && dkd() != null) {
            gVar.setForumName(dkd().djW());
            if (dkd().getPbData() != null && dkd().getPbData().getForum() != null) {
                gVar.a(dkd().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(dkd());
        }
    }

    public void doo() {
        if (this.acX != null) {
            this.acX.rV();
            if (this.lIS != null) {
                this.lIS.bBA();
            }
            doY();
        }
    }

    public com.baidu.tbadk.editortools.pb.e dkR() {
        return this.lIS;
    }

    private boolean dlb() {
        PbModel dkd = dkd();
        if (dkd == null || dkd.getPbData() == null) {
            return false;
        }
        bz diN = dkd.getPbData().diN();
        dkd.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), diN);
    }

    public void dlc() {
        if (checkUpIsLogin() && dkd() != null && dkd().getPbData() != null && dkd().getPbData().getForum() != null && !dlb()) {
            if (dkd().getPbData().djq()) {
                cQn();
                return;
            }
            if (this.jeV == null) {
                this.jeV = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jeV.zU(0);
                this.jeV.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qC(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void B(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qD(boolean z) {
                        if (z) {
                            if (VideoPbFragment.this.lIS != null && VideoPbFragment.this.lIS.bAP() != null) {
                                VideoPbFragment.this.lIS.bAP().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            VideoPbFragment.this.cQn();
                        }
                    }
                });
            }
            this.jeV.H(dkd().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dkd().dme(), 0L));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.lIS.onActivityResult(i, i2, intent);
        if (this.lIs != null) {
            this.lIs.onActivityResult(i, i2, intent);
        }
        if (this.lRh != null) {
            this.lRh.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dlo();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dAJ().E(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.lIV = emotionImageData;
                        if (Fp(al.eYn)) {
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
        if (dlL() != null) {
            if (this.mbs && !TbSingleton.getInstance().isNotchScreen(dlL()) && !TbSingleton.getInstance().isCutoutScreen(dlL())) {
                drZ();
                UtilHelper.hideStatusBar(dlL(), dlL().getRootView());
                this.mbs = false;
            }
            this.mbm.mbH = z;
            drL();
            drM();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.lHZ;
        if (i == 0) {
            dnT();
            if (this.lRh != null) {
                this.lRh.dkM();
            }
            vv(false);
        }
        dnX();
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
                        this.lIS.resetData();
                        this.lIS.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lIS.c(writeData);
                        m qP = this.lIS.bAP().qP(6);
                        if (qP != null && qP.fyZ != null) {
                            qP.fyZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lHZ;
                        if (i == -1) {
                            this.lIS.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lRh != null && this.lRh.dkQ() != null) {
                            com.baidu.tbadk.editortools.pb.h dkQ = this.lRh.dkQ();
                            dkQ.setThreadData(dkd().getPbData().diN());
                            dkQ.c(writeData);
                            dkQ.setVoiceModel(pbEditorData.getVoiceModel());
                            m qP2 = dkQ.bAP().qP(6);
                            if (qP2 != null && qP2.fyZ != null) {
                                qP2.fyZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lHZ;
                            if (i == -1) {
                                dkQ.bBU();
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
                if (dkd() != null && !dkd().dmm()) {
                    antiData.setBlock_forum_name(dkd().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(dkd().getPbData().getForum().getId());
                    antiData.setUser_name(dkd().getPbData().getUserData().getUserName());
                    antiData.setUser_id(dkd().getPbData().getUserData().getUserId());
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
        if (AntiHelper.bQ(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.mbl != null) {
                this.mbl.CL(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void dlN() {
        if (dkd() != null && this.lHZ != null) {
            if (this.lIS == null || !this.lIS.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.lIS = (com.baidu.tbadk.editortools.pb.e) dVar.fh(getContext());
                this.lIS.a(this.lHZ.getPageContext());
                this.lIS.a(this.fBH);
                this.lIS.a(this.fBz);
                this.lIS.a(this.lHZ.getPageContext(), this.lHZ.getIntent() == null ? null : this.lHZ.getIntent().getExtras());
                this.lIS.bAP().kK(true);
                setEditorTools(this.lIS.bAP());
                if (!dkd().dmm()) {
                    this.lIS.CG(dkd().dme());
                }
                if (dkd().dmN()) {
                    this.lIS.CE(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.lIS.CE(dnZ());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acX = editorTools;
        this.acX.setId(R.id.pb_editor);
        this.acX.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dnX();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.acX.getParent() == null) {
            this.rootView.addView(this.acX, layoutParams);
        }
        this.acX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.acX.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof u) {
                    if (((u) aVar.data).bwd() == EmotionGroupType.BIG_EMOTION || ((u) aVar.data).bwd() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.lIS.c((u) aVar.data);
                            VideoPbFragment.this.lIS.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dnT();
        this.lIS.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.acX != null && VideoPbFragment.this.acX.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.kOl != null && VideoPbFragment.this.kOl.dpr() != null) {
                    if (!VideoPbFragment.this.kOl.dpr().dUc()) {
                        VideoPbFragment.this.kOl.vB(false);
                    }
                    VideoPbFragment.this.kOl.dpr().yY(false);
                }
            }
        });
    }

    public void cQn() {
        if (!checkUpIsLogin()) {
            if (dkd() != null) {
                TiebaStatic.log(new aq("c10517").an("obj_locate", 2).dW("fid", dkd().getForumId()));
            }
        } else if (dle()) {
            if (this.lIS != null && (this.lIS.bBK() || this.lIS.bBL())) {
                this.lIS.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.acX != null) {
                doo();
                this.mbm.mbG = false;
                if (this.acX.qP(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.acX.qP(2).fyZ, false, null);
                }
            }
            doY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dlb() && dle()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lIu);
                this.lIv = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.lRh != null && postData != null) {
                String str3 = "";
                if (postData.dLo() != null) {
                    str3 = postData.dLo().toString();
                }
                this.lRh.Oy(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bnx().getName_show(), str3));
            }
            if (dkd() != null && dkd().getPbData() != null && dkd().getPbData().djq()) {
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.lHZ.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.lIu[1] + VideoPbFragment.this.lIv) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cEB() != null) {
                            VideoPbFragment.this.cEB().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.lRh != null) {
                            VideoPbFragment.this.lIS.bAP().setVisibility(8);
                            VideoPbFragment.this.lRh.j(str, str2, VideoPbFragment.this.dnZ(), (VideoPbFragment.this.dkd() == null || VideoPbFragment.this.dkd().getPbData() == null || VideoPbFragment.this.dkd().getPbData().diN() == null || !VideoPbFragment.this.dkd().getPbData().diN().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dkQ = VideoPbFragment.this.lRh.dkQ();
                            if (dkQ != null && VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null) {
                                dkQ.a(VideoPbFragment.this.dkd().getPbData().getAnti());
                                dkQ.setThreadData(VideoPbFragment.this.dkd().getPbData().diN());
                            }
                            if (VideoPbFragment.this.kOl.dpt() == null && VideoPbFragment.this.lRh.dkQ().bCc() != null) {
                                VideoPbFragment.this.lRh.dkQ().bCc().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kOl != null && VideoPbFragment.this.kOl.dps() != null) {
                                            if (!VideoPbFragment.this.kOl.dps().dUc()) {
                                                VideoPbFragment.this.kOl.vC(false);
                                            }
                                            VideoPbFragment.this.kOl.dps().yY(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kOl.g(VideoPbFragment.this.lRh.dkQ().bCc().getInputView());
                                VideoPbFragment.this.lRh.dkQ().a(VideoPbFragment.this.lIX);
                            }
                        }
                        VideoPbFragment.this.doY();
                    }
                }, 0L);
                return;
            }
            if (this.lIU == null) {
                this.lIU = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lIU.zU(1);
                this.lIU.a(new AnonymousClass49(str, str2));
            }
            if (dkd() != null && dkd().getPbData() != null && dkd().getPbData().getForum() != null) {
                this.lIU.H(dkd().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dkd().dme(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$49  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass49 implements c.a {
        final /* synthetic */ String lKc;
        final /* synthetic */ String lKd;

        AnonymousClass49(String str, String str2) {
            this.lKc = str;
            this.lKd = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qC(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void B(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qD(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.lIu[1] + VideoPbFragment.this.lIv) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cEB() != null) {
                            VideoPbFragment.this.cEB().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.lRh != null) {
                            VideoPbFragment.this.lIS.bAP().setVisibility(8);
                            VideoPbFragment.this.lRh.j(AnonymousClass49.this.lKc, AnonymousClass49.this.lKd, VideoPbFragment.this.dnZ(), (VideoPbFragment.this.dkd() == null || VideoPbFragment.this.dkd().getPbData() == null || VideoPbFragment.this.dkd().getPbData().diN() == null || !VideoPbFragment.this.dkd().getPbData().diN().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dkQ = VideoPbFragment.this.lRh.dkQ();
                            if (dkQ != null && VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null) {
                                dkQ.a(VideoPbFragment.this.dkd().getPbData().getAnti());
                                dkQ.setThreadData(VideoPbFragment.this.dkd().getPbData().diN());
                            }
                            if (VideoPbFragment.this.kOl.dpt() == null && VideoPbFragment.this.lRh.dkQ().bCc() != null) {
                                VideoPbFragment.this.lRh.dkQ().bCc().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kOl != null && VideoPbFragment.this.kOl.dps() != null) {
                                            if (!VideoPbFragment.this.kOl.dps().dUc()) {
                                                VideoPbFragment.this.kOl.vC(false);
                                            }
                                            VideoPbFragment.this.kOl.dps().yY(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kOl.g(VideoPbFragment.this.lRh.dkQ().bCc().getInputView());
                                VideoPbFragment.this.lRh.dkQ().a(VideoPbFragment.this.lIX);
                            }
                        }
                        VideoPbFragment.this.doY();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData L;
        ac acVar;
        StringBuilder sb = null;
        if (fVar != null && (L = L(fVar)) != null) {
            String userId = L.bnx().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, L.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.djc()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (L.bnx() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, L.bnx().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, L.bnx().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, L.bnx().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, L.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, L.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.djc()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bv> djk = fVar.djk();
                if (x.getCount(djk) > 0) {
                    sb = new StringBuilder();
                    for (bv bvVar : djk) {
                        if (bvVar != null && !StringUtils.isNull(bvVar.getForumName()) && (acVar = bvVar.eNA) != null && acVar.eLk && !acVar.eLl && (acVar.type == 1 || acVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bvVar.getForumName(), 12)).append(TbadkCoreApplication.getInst().getString(R.string.forum)).append("、");
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
    public void dlo() {
        MarkData FC;
        if (dkd() != null && dkd().getPbData() != null) {
            if (com.baidu.tbadk.a.d.biO() || drT() != null) {
                if ((!com.baidu.tbadk.a.d.biO() || drV() != null) && this.lIE != null) {
                    if (dkd().getPbData() != null && dkd().getPbData().djq()) {
                        FC = dkd().FC(0);
                    } else if (this.eWN != null && this.eWN.getCurrentItem() == maP) {
                        FC = dkd().o(L(dkd().getPbData()));
                    } else if (com.baidu.tbadk.a.d.biO()) {
                        FC = dkd().FC(drV().doB());
                    } else {
                        FC = dkd().FC(drT().doB());
                    }
                    if (FC != null) {
                        if (!FC.isApp() || (FC = dkd().FC(drT().doB() + 1)) != null) {
                            dow();
                            this.lIE.a(FC);
                            if (!this.lIE.bjE()) {
                                this.lIE.bjG();
                                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                                return;
                            }
                            this.lIE.bjF();
                            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fr(int i) {
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
            if (this.lIs == null) {
                this.lIs = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lHZ);
                this.lIs.b(this.fBz);
                this.lIs.c(this.fBH);
            }
            this.lIs.a(emotionImageData, dkd(), dkd().getPbData());
        }
    }

    public PostData L(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dja() != null) {
            return fVar.dja();
        }
        if (!x.isEmpty(fVar.diP())) {
            Iterator<PostData> it = fVar.diP().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dLm() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.diW();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.bnx() != null && postData.bnx().getUserTbVipInfoData() != null && postData.bnx().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bnx().getGodUserData().setIntro(postData.bnx().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.diN() == null || fVar.diN().bnx() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bnx = fVar.diN().bnx();
        String userId = bnx.getUserId();
        HashMap<String, MetaData> userMap = fVar.diN().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bnx;
        }
        postData.Jk(1);
        postData.setId(fVar.diN().bnN());
        postData.setTitle(fVar.diN().getTitle());
        postData.setTime(fVar.diN().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dlt() {
        ArrayList<PostData> diP;
        int count;
        int i;
        if (dkd() == null || dkd().getPbData() == null || dkd().getPbData().diP() == null || (count = x.getCount((diP = dkd().getPbData().diP()))) == 0) {
            return "";
        }
        if (dkd().dmx()) {
            Iterator<PostData> it = diP.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dLm() == 1) {
                    return next.getId();
                }
            }
        }
        if (cEB() == null) {
            i = 0;
        } else if (com.baidu.tbadk.a.d.biO()) {
            i = drV().doA();
        } else {
            i = drT().doA();
        }
        PostData postData = (PostData) x.getItem(diP, i);
        if (postData == null || postData.bnx() == null) {
            return "";
        }
        if (dkd().OH(postData.bnx().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) x.getItem(diP, i2);
            if (postData2 == null || postData2.bnx() == null || postData2.bnx().getUserId() == null) {
                break;
            } else if (dkd().OH(postData2.bnx().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) x.getItem(diP, i3);
            if (postData3 == null || postData3.bnx() == null || postData3.bnx().getUserId() == null) {
                return "";
            }
            if (dkd().OH(postData3.bnx().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlp() {
        if (dkd() != null) {
            com.baidu.tieba.pb.data.f pbData = dkd().getPbData();
            dkd().uZ(true);
            if (this.lIE != null) {
                pbData.Os(this.lIE.bjD());
            }
            if (com.baidu.tbadk.a.d.biO() && drV() != null) {
                drV().dsE();
            } else if (drT() != null) {
                drT().dsE();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (dkd() != null) {
            doy();
            dkd().uZ(z);
            if (this.lIE != null) {
                this.lIE.iY(z);
                if (markData != null) {
                    this.lIE.a(markData);
                }
            }
            if (dkd().bjE()) {
                dlp();
            } else if (com.baidu.tbadk.a.d.biO() && drV() != null) {
                drV().dsE();
            } else if (drT() != null) {
                drT().dsE();
            }
        }
    }

    public void b(p pVar) {
        boolean z;
        MetaData metaData;
        if (dkd() != null && dkd().getPbData() != null && pVar.djF() != null) {
            String id = pVar.djF().getId();
            ArrayList<PostData> diP = dkd().getPbData().diP();
            int i = 0;
            while (true) {
                if (i >= diP.size()) {
                    z = true;
                    break;
                }
                PostData postData = diP.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> djN = pVar.djN();
                    postData.Jj(pVar.getTotalCount());
                    if (postData.dLj() == null || djN == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = djN.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.bnx() != null && (metaData = postData.getUserMap().get(next.bnx().getUserId())) != null) {
                                next.a(metaData);
                                next.yd(true);
                                next.a(getPageContext(), dkd().OH(metaData.getUserId()));
                            }
                        }
                        z = djN.size() != postData.dLj().size();
                        if (postData.dLj() != null && postData.dLj().size() < 2) {
                            postData.dLj().clear();
                            postData.dLj().addAll(djN);
                        }
                    }
                    if (postData.dLf() != null) {
                        postData.dLg();
                    }
                }
            }
            if (!dkd().getIsFromMark() && z) {
                if (com.baidu.tbadk.a.d.biO() && drV() != null) {
                    drV().dsE();
                } else if (drT() != null) {
                    drT().dsE();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlg() {
        if (dkd() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.Rq(dkd().getForumId()) && dkd().getPbData() != null && dkd().getPbData().getForum() != null) {
            if (dkd().getPbData().getForum().isLike() == 1) {
                dkd().dmL().gj(dkd().getForumId(), dkd().dme());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            bz diN = fVar.diN();
            if (diN != null && diN.bmg()) {
                dlN();
            } else {
                d(this.lIR);
            }
            if (this.lIS != null) {
                vt(this.lIS.bBD());
                this.lIS.a(fVar.getAnti());
                this.lIS.a(fVar.getForum(), fVar.getUserData());
                this.lIS.setThreadData(diN);
                if (dkd() != null) {
                    this.lIS.a(dkd().dmv(), dkd().dme(), dkd().dmM());
                }
                if (diN != null) {
                    this.lIS.kV(diN.boX());
                }
            }
        }
    }

    public void dnX() {
        reset();
        dnT();
        this.lRh.dkM();
        vv(false);
    }

    private void reset() {
        if (this.lIS != null && this.acX != null) {
            com.baidu.tbadk.editortools.pb.a.bBs().setStatus(0);
            this.lIS.bBN();
            this.lIS.bBc();
            if (this.lIS.getWriteImagesInfo() != null) {
                this.lIS.getWriteImagesInfo().setMaxImagesAllowed(this.lIS.isBJH ? 1 : 9);
            }
            this.lIS.qZ(SendView.ALL);
            this.lIS.ra(SendView.ALL);
            com.baidu.tbadk.editortools.h qM = this.acX.qM(23);
            com.baidu.tbadk.editortools.h qM2 = this.acX.qM(2);
            com.baidu.tbadk.editortools.h qM3 = this.acX.qM(5);
            if (qM2 != null) {
                qM2.rV();
            }
            if (qM3 != null) {
                qM3.rV();
            }
            if (qM != null) {
                qM.hide();
            }
            this.acX.invalidate();
        }
    }

    public void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.diN() != null) {
            x(fVar);
            this.lQD.setVisibility(fVar.djq() ? 8 : 0);
            if (fVar.bjE()) {
                WebPManager.a(this.lQD, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lQD, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String FK = FK(fVar.diN().bno());
            if (this.lQG != null) {
                this.lQG.setText(FK);
            }
            if (this.lQH != null) {
                this.lQH.setText(FK);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.diN()));
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bc(fVar.diN())) {
            if (this.lQF != null) {
                this.lQF.setEnable(false);
                this.lQF.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.lQE.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.lQE.setLayoutParams(layoutParams);
            WebPManager.a(this.lQE, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.lQF == null || !this.lQF.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.lQE.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.lQE.setLayoutParams(layoutParams2);
            WebPManager.a(this.lQE, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    private String FK(int i) {
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

    public void vv(boolean z) {
        if (this.lQz != null) {
            vt(this.lIS.bBD());
            if (this.lQv) {
                vk(z);
            } else {
                vl(z);
            }
            drL();
            drM();
        }
    }

    public void doY() {
        if (this.lQz != null) {
            this.lQy.setVisibility(8);
            this.lQz.setVisibility(8);
            this.mbm.mbG = false;
            drL();
            drM();
        }
    }

    private void drL() {
        if (this.maY != null) {
            if (this.mbm.dsd()) {
                this.maY.wX(false);
            } else {
                this.maY.wX(this.maY.isVertical() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drM() {
        if (this.maY != null && this.eWN != null) {
            if (com.baidu.tbadk.a.d.biO()) {
                this.maY.wf(false);
            } else if (this.eWN.getCurrentItem() != 0) {
                this.maY.wf(false);
            } else if (this.mbm.dsd()) {
                this.maY.wf(false);
            } else {
                VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
                if (videoPbViewModel != null) {
                    this.maY.wf(videoPbViewModel.dsn() == null || videoPbViewModel.dsn().getValue() == null || videoPbViewModel.dsn().getValue().booleanValue());
                }
            }
        }
    }

    private void Fs(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(dlL(), dlf(), i);
    }

    private int dlf() {
        if (dkd() == null || dkd().getPbData() == null || dkd().getPbData().diN() == null) {
            return -1;
        }
        return dkd().getPbData().diN().bok();
    }

    public void vt(boolean z) {
        this.lQv = z;
    }

    public void vk(boolean z) {
        if (this.lQz != null && this.kgY != null) {
            this.kgY.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lQz.startAnimation(alphaAnimation);
            }
            this.lQy.setVisibility(0);
            this.lQz.setVisibility(0);
            this.mbm.mbG = true;
        }
    }

    public void vl(boolean z) {
        if (this.lQz != null && this.kgY != null) {
            this.kgY.setText(dnZ());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lQz.startAnimation(alphaAnimation);
            }
            this.lQy.setVisibility(0);
            this.lQz.setVisibility(0);
            this.mbm.mbG = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null && this.lBV == null) {
            this.lBV = aVar;
            this.mbd.setText(aVar.getTitle());
            this.mbe.setText(aVar.dsR());
            String dsS = aVar.dsS();
            TBSpecificationBtn tBSpecificationBtn = this.mbg;
            if (TextUtils.isEmpty(dsS)) {
                dsS = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(dsS);
            this.mbh.startLoad(aVar.getImage(), 10, false);
            this.mbi.setVisibility(aVar.dsU() ? 0 : 8);
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.lBV == null || VideoPbFragment.this.lBV.dsU()) {
                        if (VideoPbFragment.this.lBV != null && VideoPbFragment.this.dkd() != null && VideoPbFragment.this.dkd().getPbData() != null && VideoPbFragment.this.dkd().getPbData().getForum() != null) {
                            TiebaStatic.log(new aq("c13712").dW("fid", VideoPbFragment.this.dkd().getPbData().getForum().getId()).dW("fname", VideoPbFragment.this.dkd().getPbData().getForum().getName()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("tid", VideoPbFragment.this.dkd().getPbData().getThreadId()).w("obj_param1", VideoPbFragment.this.lBV.userId));
                        }
                    } else {
                        TiebaStatic.log(new aq("c13608").dW("obj_id", VideoPbFragment.this.lBV.getTitle()).dW("obj_name", VideoPbFragment.this.lBV.dsR()).an("obj_type", 2).dW("fid", VideoPbFragment.this.dkd().getPbData().getForumId()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("tid", VideoPbFragment.this.dkd().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.drN();
                }
            }, aVar.dsT().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drN() {
        ViewGroup.LayoutParams layoutParams = this.mbb.getLayoutParams();
        if (layoutParams != null) {
            if (this.mbj == null || !this.mbj.isRunning()) {
                this.mbb.setAlpha(0.0f);
                this.mbb.setVisibility(0);
                f(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drO() {
        if (this.mbb.getLayoutParams() != null) {
            if (this.mbj == null || !this.mbj.isRunning()) {
                drP();
            }
        }
    }

    private void drP() {
        final ViewGroup.LayoutParams layoutParams = this.mbb.getLayoutParams();
        if (layoutParams != null) {
            if (this.mbk == null || !this.mbk.isRunning()) {
                this.mbk = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.mbk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.mbb.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.mbk.setDuration(200L);
                this.mbk.start();
                this.mbk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPbFragment.this.e(layoutParams);
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
    public void e(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.ZQ.getLayoutParams();
        final int i = layoutParams2.height;
        this.mbj = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mbj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.kdG);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.kdG);
                VideoPbFragment.this.mbb.setLayoutParams(layoutParams);
                VideoPbFragment.this.ZQ.setLayoutParams(layoutParams2);
            }
        });
        this.mbj.setDuration(300L);
        this.mbj.start();
        this.mbj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.mbb.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void f(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.ZQ.getLayoutParams();
        final int i = layoutParams2.height;
        this.mbj = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mbj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.kdG);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.mbb.setLayoutParams(layoutParams);
                VideoPbFragment.this.ZQ.setLayoutParams(layoutParams2);
            }
        });
        this.mbj.setDuration(300L);
        this.mbj.start();
        this.mbj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.drQ();
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
    public void drQ() {
        this.mbj = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mbj.setDuration(300L);
        this.mbj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.mbb.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.mbj.start();
    }

    public String dnZ() {
        if (!at.isEmpty(this.lRz)) {
            return this.lRz;
        }
        this.lRz = TbadkCoreApplication.getInst().getResources().getString(com.baidu.tieba.pb.pb.main.ao.dnP());
        return this.lRz;
    }

    public void doy() {
        hideProgressBar();
        if (com.baidu.tbadk.a.d.biO() && drV() != null) {
            drV().endLoadData();
            drV().doz();
        } else if (drT() != null) {
            drT().endLoadData();
            drT().doz();
        }
    }

    public boolean dE(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bkB().isShowImages()) {
                    return OD(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (dkd() == null || dkd().getPbData() == null) {
                        return true;
                    }
                    if (this.lRh != null) {
                        this.lRh.dkM();
                    }
                    p pVar = new p();
                    pVar.a(dkd().getPbData().getForum());
                    pVar.setThreadData(dkd().getPbData().diN());
                    pVar.g(postData);
                    this.lHU.d(pVar);
                    this.lHU.setPostId(postData.getId());
                    a(view, postData.bnx().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lIS != null) {
                        vt(this.lIS.bBD());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void drR() {
        if (this.lIS != null) {
            vt(this.lIS.bBD());
        }
        dnX();
        this.mbl.doP();
    }

    private boolean OD(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.brx().getString("bubble_link", "");
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

    public void dos() {
        if (this.lQg != null) {
            this.lQg.setVisibility(0);
        }
    }

    public void dot() {
        if (this.lQg != null) {
            this.lQg.setVisibility(8);
        }
    }

    public void Gc(int i) {
        if (this.maV != null) {
            this.maV.setVisibility(i);
        }
    }

    public void dow() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a dlj() {
        return this.lJI;
    }

    public void dnT() {
        if (this.acX != null) {
            this.acX.hide();
        }
    }

    public void cBJ() {
        if (this.lHZ.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lHZ.getCurrentFocus());
        }
    }

    public void N(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.diN() != null) {
            String valueOf = String.valueOf(fVar.diN().bno());
            if (fVar.diN().bno() == 0) {
                valueOf = "";
            }
            this.maT.DL(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.maU.dse()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (dkd() != null && dkd().getPbData() != null && dkd().getPbData().diN() != null && dkd().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(lRa)).intValue();
                if (intValue == lRb) {
                    if (!this.gca.dMh()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.gca.Su(at.S(jSONArray));
                        }
                        this.gca.a(dkd().getPbData().getForum().getId(), dkd().getPbData().getForum().getName(), dkd().getPbData().diN().getId(), str, intValue3, intValue2, booleanValue, dkd().getPbData().diN().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == lRc || intValue == lRe) {
                    if (dkd().dmI() != null) {
                        dkd().dmI().Fk(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == lRc) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(String str, String str2) {
        be.bsB().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bHN() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bHO() {
        if (this.fRW == null) {
            this.fRW = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bIa */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bkB().isShowImages();
                    foreDrawableImageView.setDefaultBg(ao.getDrawable(R.color.common_color_10220));
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
                        if (com.baidu.tbadk.core.k.bkB().isShowImages()) {
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
        return this.fRW;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bHP() {
        if (this.fVl == null) {
            this.fVl = TbRichTextView.K(getPageContext().getPageActivity(), 8);
        }
        return this.fVl;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bHQ() {
        if (this.fRX == null) {
            this.fRX = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cvN */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bkB().isShowImages();
                    gifView.setDefaultBg(ao.getDrawable(R.color.common_color_10220));
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
                    if (com.baidu.tbadk.core.k.bkB().isShowImages()) {
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
                    gifView.bCv();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fRX;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bHR() {
        if (this.fVm == null) {
            this.fVm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dlO */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dJ */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dK */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).cbz();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dL */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fVm;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bHS() {
        if (this.fVn == null) {
            this.fVn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dlQ */
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
        return this.fVn;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bHT() {
        this.fVo = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dlP */
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
        return this.fVo;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lIl = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (au.OT(str) && dkd() != null && dkd().dme() != null) {
            TiebaStatic.log(new aq("c11664").an("obj_param1", 1).dW("post_id", dkd().dme()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                mVar.mLink = str;
                mVar.type = 3;
                mVar.fxW = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
            }
        } else {
            au.dpv().f(getPageContext(), str);
        }
        this.lIl = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
        au.dpv().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lIl = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aH(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aI(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mbl.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b dsA = this.mbl.dsA();
            if (dsA == null) {
                this.mbl.dla();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                dsA.getItemView(1).setVisibility(8);
            } else {
                dsA.getItemView(1).setVisibility(0);
            }
            dsA.bqg();
            this.lIl = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aJ(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.bsB().b(getPageContext(), new String[]{str});
            this.lIl = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a drS() {
        return this.eYq;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bFn() {
        return this.bPd;
    }

    public ReplyFragment drT() {
        if (this.maU == null || !(this.maU.Gd(maQ) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.maU.Gd(maQ);
    }

    public DetailInfoFragment drU() {
        if (this.maU == null || !(this.maU.Gd(maP) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.maU.Gd(maP);
    }

    public DetailInfoAndReplyFragment drV() {
        if (this.maU == null || !(this.maU.Gd(maR) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.maU.Gd(maR);
    }

    public boolean djV() {
        PbModel dkd = this.lHZ.dkd();
        if (dkd == null) {
            return false;
        }
        return dkd.djV();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData diZ;
        PbModel dkd = this.lHZ.dkd();
        if (dkd != null && dkd.getPbData() != null && !dkd.getPbData().djq()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = dkd.getPbData().diN().getId();
            if (dkd.isShareThread() && dkd.getPbData().diN().eQQ != null) {
                historyMessage.threadName = dkd.getPbData().diN().eQQ.showText;
            } else {
                historyMessage.threadName = dkd.getPbData().diN().getTitle();
            }
            if (dkd.isShareThread() && !djV()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = dkd.getPbData().getForum().getName();
            }
            ArrayList<PostData> diP = dkd.getPbData().diP();
            int doA = drT() != null ? drT().doA() : 0;
            if (diP != null && doA >= 0 && doA < diP.size()) {
                historyMessage.postID = diP.get(doA).getId();
            }
            historyMessage.isHostOnly = dkd.getHostMode();
            historyMessage.isSquence = dkd.dmg();
            historyMessage.isShareThread = dkd.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lIS != null) {
            this.lIS.onDestroy();
        }
        if (dkd != null && (dkd.dmh() || dkd.dmj())) {
            Intent intent = new Intent();
            intent.putExtra("tid", dkd.dme());
            if (this.lIH) {
                if (this.lIJ) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", dkd.ctW());
                }
                if (this.lII) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", dkd.getIsGood());
                }
            }
            if (dkd.getPbData() != null && System.currentTimeMillis() - this.lIh >= 40000 && (diZ = dkd.getPbData().diZ()) != null && !x.isEmpty(diZ.getDataList())) {
                intent.putExtra("guess_like_data", diZ);
            }
            PbActivity pbActivity = this.lHZ;
            PbActivity pbActivity2 = this.lHZ;
            pbActivity.setResult(-1, intent);
        }
        if (dlq()) {
            if (dkd != null) {
                com.baidu.tieba.pb.data.f pbData = dkd.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.lIn) {
                        if (this.maX != null) {
                            Rect rect = new Rect();
                            this.maX.getGlobalVisibleRect(rect);
                            aj.dnE().g(rect);
                        }
                        aj.dnE().FG(this.eWN.getCurrentItem());
                        BdTypeRecyclerView cEB = cEB();
                        Parcelable parcelable = null;
                        if (cEB != null) {
                            parcelable = cEB.onSaveInstanceState();
                        }
                        aj.dnE().a(dkd.dmp(), parcelable, dkd.dmg(), dkd.getHostMode(), false);
                    }
                }
            } else {
                aj.dnE().reset();
            }
            dkr();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.maY != null && !this.maY.isVertical()) {
            if ((this.maY.isFullScreen() && configuration.orientation == 1) || (!this.maY.isFullScreen() && configuration.orientation == 2)) {
                this.maY.wg(false);
            }
        }
    }

    public boolean drW() {
        if (this.maY == null) {
            return false;
        }
        return this.maY.isVertical();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.dKg().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        public boolean mbG;
        public boolean mbH;

        private a() {
            this.mbH = true;
        }

        public boolean dsd() {
            return (this.mbG && this.mbH) ? false : true;
        }
    }

    public void drX() {
        this.lIw = -1;
        this.lIx = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlH() {
        if (dkd() != null && !at.isEmpty(dkd().dme())) {
            com.baidu.tbadk.BdToken.c.bha().p(com.baidu.tbadk.BdToken.b.ezZ, com.baidu.adp.lib.f.b.toLong(dkd().dme(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.maW.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drY() {
        if (this.mbv == null) {
            this.mbv = ObjectAnimator.ofFloat(this.mba, "alpha", 0.0f, 1.0f);
            this.mbv.setDuration(200L);
        }
        this.mbv.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drZ() {
        if (this.mbw == null) {
            this.mbw = ObjectAnimator.ofFloat(this.mba, "alpha", 1.0f, 0.0f);
            this.mbw.setDuration(200L);
        }
        this.mbw.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dsa() {
        return this.maY != null && this.maY.dsb();
    }

    public boolean dsb() {
        return this.mbs;
    }

    public void vX(boolean z) {
        this.mbs = z;
    }

    public void uQ(boolean z) {
        this.lIo = z;
    }

    public boolean dlF() {
        return this.lIo;
    }

    public LinearLayout dpo() {
        return this.lQA;
    }
}
