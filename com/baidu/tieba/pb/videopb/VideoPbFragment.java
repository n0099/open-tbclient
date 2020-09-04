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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.h;
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
import com.baidu.tbadk.widget.richText.i;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.pb.pb.main.bb;
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
/* loaded from: classes16.dex */
public class VideoPbFragment extends BaseFragment implements VoiceManager.c, TbRichTextView.c, i, com.baidu.tieba.pb.videopb.a, b {
    private AppBarLayout Xx;
    private EditorTools aaA;
    private ImageView agh;
    public View eUq;
    private CustomViewPager eiA;
    private com.baidu.adp.lib.d.b<ImageView> fcr;
    private com.baidu.adp.lib.d.b<GifView> fcs;
    private com.baidu.adp.lib.d.b<TextView> ffJ;
    private com.baidu.adp.lib.d.b<View> ffK;
    private com.baidu.adp.lib.d.b<LinearLayout> ffL;
    private com.baidu.adp.lib.d.b<RelativeLayout> ffM;
    private ImageView gae;
    private VoiceManager hSU;
    private com.baidu.tieba.f.b hXQ;
    private com.baidu.tieba.frs.profession.permission.c hXq;
    private com.baidu.tieba.callfans.a hkB;
    public am jFD;
    public bb jJI;
    private PbFakeFloorModel kCX;
    private g kDR;
    private com.baidu.tbadk.editortools.pb.e kDS;
    private com.baidu.tieba.frs.profession.permission.c kDU;
    private EmotionImageData kDV;
    private com.baidu.tbadk.core.view.c kDZ;
    private PbActivity kDc;
    private com.baidu.tieba.pb.pb.main.emotion.model.a kDu;
    int kDx;
    private ImageView kLA;
    private ImageView kLB;
    private ImageView kLC;
    private com.baidu.tieba.pb.view.c kLD;
    private TextView kLE;
    private TextView kLF;
    private int kLH;
    private int kLI;
    private View kLf;
    private View kLw;
    private LinearLayout kLy;
    private HeadImageView kLz;
    private v kMf;
    private String kMw;
    public View kQZ;
    private NewPagerSlidingTabBaseStrip kVB;
    private VideoPbFragmentAdapter kVC;
    private View kVD;
    private View kVE;
    private VideoContainerLayout kVF;
    private com.baidu.tieba.pb.videopb.videoView.a kVG;
    private f kVH;
    private View kVI;
    private View kVJ;
    private TextView kVL;
    private TextView kVM;
    private ImageView kVN;
    private TBSpecificationBtn kVO;
    private TbImageView kVP;
    private View kVQ;
    private ValueAnimator kVR;
    private ValueAnimator kVS;
    public com.baidu.tieba.pb.videopb.b.a kVT;
    private float kVX;
    private float kVY;
    private boolean kVZ;
    private ObjectAnimator kWd;
    private ObjectAnimator kWe;
    private com.baidu.tieba.pb.videopb.c.a kxz;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int kVx = 0;
    public static int kVy = 1;
    public static int kVz = 0;
    public static int kLX = 3;
    public static int kLY = 0;
    public static int kLZ = 3;
    public static int kMa = 4;
    public static int kMb = 5;
    public static int kMc = 6;
    private static final int iQv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int kVA = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a kES = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void cq(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cWs();
            } else {
                com.baidu.tieba.pb.a.b.cWr();
            }
        }
    };
    private long kDj = 0;
    View.OnClickListener kVK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.kxz == null || VideoPbFragment.this.kxz.dff()) {
                if (VideoPbFragment.this.kxz != null) {
                    if (VideoPbFragment.this.kxz.isChushou) {
                        VideoPbFragment.this.em(VideoPbFragment.this.kxz.thirdRoomId, VideoPbFragment.this.kxz.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.kxz.dfg();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null && VideoPbFragment.this.cWE().getPbData().getForum() != null) {
                        TiebaStatic.log(new aq("c13713").dD("fid", VideoPbFragment.this.cWE().getPbData().getForum().getId()).dD("fname", VideoPbFragment.this.cWE().getPbData().getForum().getName()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", VideoPbFragment.this.cWE().getPbData().getThreadId()).u("obj_param1", VideoPbFragment.this.kxz.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new aq("c13590").dD("obj_id", VideoPbFragment.this.kxz.getTitle()).dD("obj_name", VideoPbFragment.this.kxz.dfc()).ai("obj_type", 2).dD("fid", VideoPbFragment.this.cWE().getPbData().getForumId()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", VideoPbFragment.this.cWE().getPbData().getThreadId()));
            String link = VideoPbFragment.this.kxz.getLink();
            if (!TextUtils.isEmpty(link)) {
                if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                    be.bju().b(VideoPbFragment.this.getPageContext(), new String[]{link});
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
    private com.baidu.tbadk.baseEditMark.a kDE = null;
    private com.baidu.tbadk.coreExtra.model.a ekH = null;
    private ForumManageModel hkz = null;
    private boolean kDn = false;
    private View kLx = null;
    private TextView iUa = null;
    private boolean kLt = false;
    private String eMx = null;
    private boolean kDH = false;
    private boolean kDI = false;
    private boolean kDJ = false;
    private boolean kDp = false;
    int[] kDw = new int[2];
    private int kDy = -1;
    private int kDz = Integer.MIN_VALUE;
    private int kEf = 0;
    private int kVV = Integer.MIN_VALUE;
    private boolean bpH = false;
    private boolean kBf = com.baidu.tbadk.a.d.baf();
    private final PbModel.a kEI = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            h qb;
            VideoPbFragment.this.daO();
            VideoPbFragment.this.cGw();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.tE(false);
            if (z && fVar != null) {
                bw cVm = fVar.cVm();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(fVar, i2);
                VideoPbFragment.this.J(fVar);
                com.baidu.tieba.pb.videopb.c.a cVR = fVar.cVR();
                if (cVR != null && !cVR.kXV) {
                    VideoPbFragment.this.a(cVR);
                }
                VideoPbFragment.this.K(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.kDE != null) {
                    VideoPbFragment.this.kDE.hB(fVar.baA());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.eMx = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.eMx) && VideoPbFragment.this.kDS != null && VideoPbFragment.this.kDS.brw() != null && (qb = VideoPbFragment.this.kDS.brw().qb(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.eMx)) {
                        ((View) qb).setOnClickListener(VideoPbFragment.this.eNj);
                    }
                }
                if (VideoPbFragment.this.jFD != null && cVm != null && cVm.beE() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(cVm.beE());
                    VideoPbFragment.this.jFD.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.cWE().cYC());
                        jSONObject.put("fid", VideoPbFragment.this.cWE().getForumId());
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
                if ((!com.baidu.tbadk.a.d.bah() || VideoPbFragment.this.deg() != null) && VideoPbFragment.this.dee() != null) {
                    if (com.baidu.tbadk.a.d.bah()) {
                        if (i != -1) {
                            ArrayList<PostData> arrayList = null;
                            if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null) {
                                arrayList = VideoPbFragment.this.cWE().getPbData().cVo();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dwK() == 1)) {
                                if (VideoPbFragment.this.deg().cYc()) {
                                    VideoPbFragment.this.deg().NJ(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.deg().NJ(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.deg().NI(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.deg().NI("");
                        }
                        VideoPbFragment.this.deg().endLoadData();
                    } else {
                        if (i != -1) {
                            ArrayList<PostData> arrayList2 = null;
                            if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null) {
                                arrayList2 = VideoPbFragment.this.cWE().getPbData().cVo();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 1 && arrayList2.get(0) != null && arrayList2.get(0).dwK() == 1)) {
                                if (VideoPbFragment.this.dee().cYc()) {
                                    VideoPbFragment.this.dee().NJ(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dee().NJ(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dee().NI(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dee().NI("");
                        }
                        VideoPbFragment.this.dee().endLoadData();
                    }
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.dvJ().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0535a kEK = new a.InterfaceC0535a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0535a
        public void c(boolean z, boolean z2, String str) {
            VideoPbFragment.this.daO();
            if (z && VideoPbFragment.this.cWE() != null) {
                if (VideoPbFragment.this.kDE != null) {
                    VideoPbFragment.this.kDE.hB(z2);
                }
                VideoPbFragment.this.cWE().tj(z2);
                if (VideoPbFragment.this.cWE().baA()) {
                    VideoPbFragment.this.cXN();
                } else if (com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.deg() != null) {
                    VideoPbFragment.this.deg().deP();
                } else if (VideoPbFragment.this.dee() != null) {
                    VideoPbFragment.this.dee().deP();
                }
                if (z2) {
                    if (VideoPbFragment.this.kDE != null) {
                        if (VideoPbFragment.this.kDE.baD() != null && VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null && VideoPbFragment.this.cWE().getPbData().cVm() != null && VideoPbFragment.this.cWE().getPbData().cVm().beE() != null) {
                            MarkData baD = VideoPbFragment.this.kDE.baD();
                            MetaData beE = VideoPbFragment.this.cWE().getPbData().cVm().beE();
                            if (baD != null && beE != null) {
                                if (!at.equals(TbadkCoreApplication.getCurrentAccount(), beE.getUserId()) && !beE.hadConcerned()) {
                                    VideoPbFragment.this.kVT.b(beE);
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
                    VideoPbFragment.this.cXK();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b eMB = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean brV() {
            if (VideoPbFragment.this.jJI == null || VideoPbFragment.this.jJI.dbF() == null || !VideoPbFragment.this.jJI.dbF().dFF()) {
                return !VideoPbFragment.this.Ec(am.ekC);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.jJI.dbF().dFH());
            if (VideoPbFragment.this.kDS != null && (VideoPbFragment.this.kDS.bsm() || VideoPbFragment.this.kDS.bsn())) {
                VideoPbFragment.this.kDS.a(false, VideoPbFragment.this.jJI.dbI());
            }
            VideoPbFragment.this.jJI.tK(true);
            return true;
        }
    };
    private final CustomMessageListener kEm = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.cWE() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.kDS != null) {
                    VideoPbFragment.this.tC(VideoPbFragment.this.kDS.bsf());
                }
                VideoPbFragment.this.dar();
                VideoPbFragment.this.kVT.dbf();
            }
        }
    };
    private CustomMessageListener kEp = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
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
    private final CustomMessageListener hUw = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.bpH) {
                VideoPbFragment.this.cYf();
            }
        }
    };
    private CustomMessageListener kEJ = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.cXE();
            }
        }
    };
    private CustomMessageListener kEB = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.64
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.kVT != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kVT.kEa) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.kVT.bWr();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.kVT.getExtra();
                DataRes dataRes = aVar.mtF;
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
                    VideoPbFragment.this.kVT.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.kVT.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener kEz = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.kVT != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kVT.kEa) {
                VideoPbFragment.this.kVT.bWr();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.cWE().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cVC().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.kDZ.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.kVT.Ce(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.kVT.cYb();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (at.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.kDZ.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener kEA = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.kVT != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kVT.kEa) {
                VideoPbFragment.this.kVT.bWr();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.kDZ.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (at.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.kDZ.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b kDX = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean brV() {
            if (VideoPbFragment.this.jJI == null || VideoPbFragment.this.jJI.dbG() == null || !VideoPbFragment.this.jJI.dbG().dFF()) {
                return !VideoPbFragment.this.Ec(am.ekD);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.jJI.dbG().dFH());
            if (VideoPbFragment.this.kMf != null && VideoPbFragment.this.kMf.cXo() != null && VideoPbFragment.this.kMf.cXo().bsn()) {
                VideoPbFragment.this.kMf.cXo().a(VideoPbFragment.this.jJI.dbI());
            }
            VideoPbFragment.this.jJI.tL(true);
            return true;
        }
    };
    private final NewWriteModel.d eMH = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c13268");
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null) {
                    aqVar.dD("fid", VideoPbFragment.this.cWE().getPbData().getForumId());
                }
                aqVar.dD("tid", VideoPbFragment.this.cWE().cYC());
                aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            VideoPbFragment.this.cms();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.cWE() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.cWE().ND(postWriteCallBackData.getPostId());
                    if (com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.deg() != null) {
                        VideoPbFragment.this.kEf = VideoPbFragment.this.deg().daQ();
                        VideoPbFragment.this.kVV = VideoPbFragment.this.deg().deS();
                        VideoPbFragment.this.cWE().cU(VideoPbFragment.this.kEf, VideoPbFragment.this.kVV);
                    } else if (VideoPbFragment.this.dee() != null) {
                        VideoPbFragment.this.kEf = VideoPbFragment.this.dee().daQ();
                        VideoPbFragment.this.kVV = VideoPbFragment.this.dee().deS();
                        VideoPbFragment.this.cWE().cU(VideoPbFragment.this.kEf, VideoPbFragment.this.kVV);
                    }
                }
                if (VideoPbFragment.this.eiA != null) {
                    if (com.baidu.tbadk.a.d.bah()) {
                        VideoPbFragment.this.eiA.setCurrentItem(VideoPbFragment.kVz);
                    } else {
                        VideoPbFragment.this.eiA.setCurrentItem(VideoPbFragment.kVy);
                    }
                }
                VideoPbFragment.this.kVT.dbf();
                VideoPbFragment.this.jJI.dbE();
                if (VideoPbFragment.this.kDS != null) {
                    VideoPbFragment.this.tC(VideoPbFragment.this.kDS.bsf());
                }
                VideoPbFragment.this.dan();
                VideoPbFragment.this.tE(true);
                VideoPbFragment.this.cWE().cYX();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.deg() != null) {
                                VideoPbFragment.this.deg().deP();
                            } else if (VideoPbFragment.this.dee() != null) {
                                VideoPbFragment.this.dee().deP();
                            }
                        }
                    } else if (VideoPbFragment.this.cWE().getHostMode()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.cWE().getPbData();
                        if (pbData != null && pbData.cVm() != null && pbData.cVm().beE() != null && (userId = pbData.cVm().beE().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.cWE().cYO()) {
                            VideoPbFragment.this.daM();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.cWE().cYO()) {
                        VideoPbFragment.this.daM();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.sU(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.kDS.bsm() || VideoPbFragment.this.kDS.bsn()) {
                    VideoPbFragment.this.kDS.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.jJI.g(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.jFD != null) {
                    VideoPbFragment.this.jFD.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.zA(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zA(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new aq("c13746").ai("obj_locate", 1).ai("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bhg();
                TiebaStatic.log(new aq("c13745").ai("obj_locate", 1).ai("obj_type", 2));
            } else if (agVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener eNj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.eMx);
        }
    };
    private CustomMessageListener kEo = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.kDS != null) {
                    VideoPbFragment.this.tC(VideoPbFragment.this.kDS.bsf());
                }
                VideoPbFragment.this.tE(false);
            }
        }
    };
    private int kVW = 0;
    private boolean kWa = true;
    private View.OnTouchListener kWb = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.kVW == 1) {
                if (!VideoPbFragment.this.kWa) {
                    VideoPbFragment.this.dej();
                    UtilHelper.showStatusBar(VideoPbFragment.this.cYj(), VideoPbFragment.this.cYj().getRootView());
                    VideoPbFragment.this.kWa = true;
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(VideoPbFragment.this.kWc);
                    com.baidu.adp.lib.f.e.mS().postDelayed(VideoPbFragment.this.kWc, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (VideoPbFragment.this.kVW == 2 && (VideoPbFragment.this.kWa || VideoPbFragment.this.del())) {
                VideoPbFragment.this.dek();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cYj(), VideoPbFragment.this.cYj().getRootView());
                VideoPbFragment.this.kWa = false;
                if (VideoPbFragment.this.kVG != null) {
                    VideoPbFragment.this.kVG.uf(false);
                }
            }
            VideoPbFragment.this.kVW = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener ifc = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.kVW = 0;
            VideoPbFragment.this.kVX = 0.0f;
            VideoPbFragment.this.kVY = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.kVX += f;
            VideoPbFragment.this.kVY += f2;
            if (VideoPbFragment.this.kVW == 0 && !VideoPbFragment.this.kVZ && VideoPbFragment.this.kVG != null && !VideoPbFragment.this.kVG.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.kVY) <= Math.abs(VideoPbFragment.this.kVX) || VideoPbFragment.this.kVY > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.kVY) > Math.abs(VideoPbFragment.this.kVX) && VideoPbFragment.this.kVY > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.kVW = 2;
                    }
                } else {
                    VideoPbFragment.this.kVW = 1;
                }
            }
            return true;
        }
    };
    private Runnable kWc = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.kWa && !VideoPbFragment.this.del()) {
                VideoPbFragment.this.dek();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cYj(), VideoPbFragment.this.cYj().getRootView());
                VideoPbFragment.this.kWa = false;
            }
        }
    };
    private final com.baidu.adp.base.d hkG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.cWE() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.hkz.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.hkz.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.cWE().cYX();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.kSU != 1002 || bVar.ghv) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.Qf, dVar.mhO, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.hkz.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.hkz.getLoadDataMode(), gVar.Qf, gVar.mhO, false);
                    VideoPbFragment.this.kVT.aX(gVar.mhR);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener eVH = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.hXQ.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d kEG = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c13268");
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null) {
                    aqVar.dD("fid", VideoPbFragment.this.cWE().getPbData().getForumId());
                }
                if (VideoPbFragment.this.cWE() != null) {
                    aqVar.dD("tid", VideoPbFragment.this.cWE().cYC());
                }
                aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (VideoPbFragment.this.jJI != null) {
                    VideoPbFragment.this.jJI.dbD();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.jFD != null) {
                    VideoPbFragment.this.jFD.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.zA(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zA(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new aq("c13746").ai("obj_locate", 1).ai("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bhg();
                TiebaStatic.log(new aq("c13745").ai("obj_locate", 1).ai("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.jJI != null) {
                if (VideoPbFragment.this.kMf != null && VideoPbFragment.this.kMf.cXo() != null && VideoPbFragment.this.kMf.cXo().bsn()) {
                    VideoPbFragment.this.kMf.cXo().a(postWriteCallBackData);
                }
                VideoPbFragment.this.jJI.h(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c eMA = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void brW() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener aBm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        /* JADX DEBUG: Multi-variable search result rejected for r1v149, resolved type: com.baidu.tieba.pb.videopb.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray sparseArray;
            boolean z;
            int i = 2;
            int i2 = 3;
            int i3 = 1;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    aq aqVar = new aq("c13398");
                    aqVar.dD("tid", VideoPbFragment.this.cWE().cYC());
                    aqVar.dD("fid", VideoPbFragment.this.cWE().getForumId());
                    aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.ai("obj_locate", 1);
                    TiebaStatic.log(aqVar);
                    if (VideoPbFragment.this.kDn) {
                        VideoPbFragment.this.kDn = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null && VideoPbFragment.this.kCX != null && postData.beE() != null && postData.dwK() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.kMf != null) {
                                    VideoPbFragment.this.kMf.cXk();
                                }
                                p pVar = new p();
                                pVar.a(VideoPbFragment.this.cWE().getPbData().getForum());
                                pVar.setThreadData(VideoPbFragment.this.cWE().getPbData().cVm());
                                pVar.g(postData);
                                VideoPbFragment.this.kCX.d(pVar);
                                VideoPbFragment.this.kCX.setPostId(postData.getId());
                                VideoPbFragment.this.a(view, postData.beE().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.cWE().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.kDS != null) {
                                    VideoPbFragment.this.tC(VideoPbFragment.this.kDS.bsf());
                                }
                            }
                        }
                    }
                } else if ((VideoPbFragment.this.dee() != null && VideoPbFragment.this.dee().dbb() != null && view == VideoPbFragment.this.dee().dbb()) || ((com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.deg() != null && VideoPbFragment.this.deg().dbb() != null && view == VideoPbFragment.this.deg().dbb()) || view.getId() == R.id.pb_more)) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.cWE().th(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        if (com.baidu.tbadk.a.d.bah()) {
                            VideoPbFragment.this.deg().daN();
                        } else {
                            VideoPbFragment.this.dee().daN();
                        }
                    }
                } else if (VideoPbFragment.this.kVT != null && VideoPbFragment.this.kVT.dcl() != null && view == VideoPbFragment.this.kVT.dcl().cZM()) {
                    VideoPbFragment.this.kVT.aRN();
                } else if ((VideoPbFragment.this.kVT != null && ((VideoPbFragment.this.kVT.dcl() != null && view == VideoPbFragment.this.kVT.dcl().cZN()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) || view.getId() == R.id.floor_owner_reply || view.getId() == R.id.reply_title) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.kVT.dbf();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.cms();
                        VideoPbFragment.this.daM();
                        if (view.getId() == R.id.owner_reply) {
                            z = VideoPbFragment.this.cWE().z(true, VideoPbFragment.this.cXR());
                        } else {
                            z = view.getId() == R.id.all_reply ? VideoPbFragment.this.cWE().z(false, VideoPbFragment.this.cXR()) : VideoPbFragment.this.cWE().NA(VideoPbFragment.this.cXR());
                        }
                        view.setTag(Boolean.valueOf(z));
                        if (z) {
                            VideoPbFragment.this.cGx();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.eUq) {
                    if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null) {
                        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            aq aqVar2 = new aq("c13266");
                            aqVar2.dD("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar2.dD("fid", VideoPbFragment.this.cWE().getPbData().getForumId());
                            aqVar2.dD("tid", VideoPbFragment.this.cWE().cYC());
                            aqVar2.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(aqVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.kDc, VideoPbFragment.this.eUq);
                        VideoPbFragment.this.kDc.finish();
                    }
                } else if (view == VideoPbFragment.this.kQZ && VideoPbFragment.this.kVT != null) {
                    if (VideoPbFragment.this.cWE() == null || VideoPbFragment.this.cWE().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> cVo = VideoPbFragment.this.cWE().getPbData().cVo();
                    if ((cVo == null || cVo.size() <= 0) && VideoPbFragment.this.cWE().cYE()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new aq("c12378").dD("tid", VideoPbFragment.this.cWE().cYC()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", VideoPbFragment.this.cWE().getForumId()));
                    VideoPbFragment.this.kVT.cXF();
                } else if (VideoPbFragment.this.kVT.dcl() != null && view == VideoPbFragment.this.kVT.dcl().cZR()) {
                    if (VideoPbFragment.this.cWE() != null) {
                        VideoPbFragment.this.kVT.dbf();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.cms();
                            VideoPbFragment.this.daM();
                            VideoPbFragment.this.cWE().Ei(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.kVT != null && VideoPbFragment.this.kVT.dcl() != null && view == VideoPbFragment.this.kVT.dcl().cZN()) {
                    VideoPbFragment.this.kVT.aRN();
                } else if (VideoPbFragment.this.kVT != null && ((VideoPbFragment.this.kVT.dcl() != null && view == VideoPbFragment.this.kVT.dcl().cZU()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                    VideoPbFragment.this.kVT.dbf();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.cms();
                            VideoPbFragment.this.daM();
                            VideoPbFragment.this.kVT.da(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.cWE().cYV()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.kVT != null && VideoPbFragment.this.kVT.dcl() != null && view == VideoPbFragment.this.kVT.dcl().cZL()) {
                    if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null && VideoPbFragment.this.cWE().getPbData().cVm() != null) {
                        VideoPbFragment.this.kVT.aRN();
                        TiebaStatic.log(new aq("c13062"));
                        VideoPbFragment.this.kVT.Nv(VideoPbFragment.this.cWE().getPbData().cVm().beV());
                    }
                } else if (view.getId() == R.id.pb_floor_feedback) {
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (VideoPbFragment.this.kVT != null) {
                        VideoPbFragment.this.kVT.f(sparseArray);
                    }
                } else if (VideoPbFragment.this.kVT != null && VideoPbFragment.this.kVT.dcl() != null && view == VideoPbFragment.this.kVT.dcl().cZV()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        ap.C(true, false);
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).ai("obj_type", 0).ai("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).ai("obj_type", 1).ai("obj_source", 1));
                    }
                    VideoPbFragment.this.kVT.dck();
                } else if (VideoPbFragment.this.kVT != null && (view == VideoPbFragment.this.kVT.daK() || (VideoPbFragment.this.kVT.dcl() != null && (view == VideoPbFragment.this.kVT.dcl().cZQ() || view == VideoPbFragment.this.kVT.dcl().cZO())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.cWE() != null || VideoPbFragment.this.cWE().getPbData() != null) {
                        if ((VideoPbFragment.this.cWE().getPbData().cVB() == 1 || VideoPbFragment.this.cWE().getPbData().cVB() == 3) && !VideoPbFragment.this.hkz.dxv()) {
                            VideoPbFragment.this.kVT.dbf();
                            if (VideoPbFragment.this.kVT.dcl() != null && view == VideoPbFragment.this.kVT.dcl().cZO()) {
                                if (VideoPbFragment.this.cWE().getPbData().cVm().bez() == 1) {
                                    i2 = 5;
                                } else {
                                    i2 = 4;
                                }
                            } else if (VideoPbFragment.this.kVT.dcl() != null && view == VideoPbFragment.this.kVT.dcl().cZQ()) {
                                if (VideoPbFragment.this.cWE().getPbData().cVm().beA() != 1) {
                                    i2 = 6;
                                }
                            } else {
                                i2 = view == VideoPbFragment.this.kVT.daK() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.cWE().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.cWE().getPbData().cVm().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.hkz.b(id, name, id2, i2, VideoPbFragment.this.kVT.daL());
                        }
                    }
                } else if (VideoPbFragment.this.kVT != null && VideoPbFragment.this.kVT.dcl() != null && view == VideoPbFragment.this.kVT.dcl().cZT()) {
                    if (VideoPbFragment.this.cWE() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.kVT.dbf();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.cWE().getPbData(), VideoPbFragment.this.cWE().cYE(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.cWE().getPbData().getForum().getId(), VideoPbFragment.this.cWE().getPbData().getForum().getName(), VideoPbFragment.this.cWE().getPbData().cVm().getId(), String.valueOf(VideoPbFragment.this.cWE().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.kVT != null && VideoPbFragment.this.kVT.dcl() != null && view == VideoPbFragment.this.kVT.dcl().cZP()) {
                    if (VideoPbFragment.this.cWE() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.cWE().getPbData(), VideoPbFragment.this.cWE().cYE(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.kVT.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.kVT.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.kVT.aRN();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        aq aqVar3 = new aq("c13398");
                        aqVar3.dD("tid", VideoPbFragment.this.cWE().cYC());
                        aqVar3.dD("fid", VideoPbFragment.this.cWE().getForumId());
                        aqVar3.dD("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar3.ai("obj_locate", 4);
                        TiebaStatic.log(aqVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new aq("c10517").ai("obj_locate", 3).dD("fid", VideoPbFragment.this.cWE().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null) {
                        if (VideoPbFragment.this.kVT != null) {
                            VideoPbFragment.this.kVT.dbf();
                        }
                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                        PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                        PostData postData3 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                        if (postData2 != null) {
                            if (postData2.dwW() == 1) {
                                TiebaStatic.log(new aq("c12630"));
                            }
                            if (postData2.mfX != null) {
                                aq bjm = postData2.mfX.bjm();
                                bjm.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    bjm.ai("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    bjm.ai("obj_locate", 8);
                                }
                                TiebaStatic.log(bjm);
                            }
                            VideoPbFragment.this.cms();
                            TiebaStatic.log("c11742");
                            if (postData3 != null) {
                                VideoPbFragment.this.a(postData2, postData3, false, true);
                            } else {
                                VideoPbFragment.this.a(postData2, (PostData) null, false, false);
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                    if (VideoPbFragment.this.cWE() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            aq aqVar4 = new aq("c13398");
                            aqVar4.dD("tid", VideoPbFragment.this.cWE().cYC());
                            aqVar4.dD("fid", VideoPbFragment.this.cWE().getForumId());
                            aqVar4.dD("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar4.ai("obj_locate", 6);
                            TiebaStatic.log(aqVar4);
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData4.mfX != null) {
                                    aq bjm2 = postData4.mfX.bjm();
                                    bjm2.delete("obj_locate");
                                    bjm2.ai("obj_locate", 8);
                                    TiebaStatic.log(bjm2);
                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                    TiebaStatic.log(new aq("c13700").dD("tid", VideoPbFragment.this.cWE().cYD()).dD("fid", VideoPbFragment.this.cWE().getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", postData4.getId()).ai("obj_type", 3));
                                }
                                if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null && VideoPbFragment.this.kCX != null && postData4.beE() != null && postData4.dwK() != 1) {
                                    if (VideoPbFragment.this.kMf != null) {
                                        VideoPbFragment.this.kMf.cXk();
                                    }
                                    if ((VideoPbFragment.this.kBf || com.baidu.tbadk.a.d.aZV()) && postData4.dwH() != null && postData4.dwH().size() != 0) {
                                        if (com.baidu.tbadk.a.d.aZW()) {
                                            VideoPbFragment.this.a(postData4, (PostData) null, false, false);
                                            return;
                                        } else {
                                            VideoPbFragment.this.a(postData4, (PostData) null, true, false);
                                            return;
                                        }
                                    }
                                    p pVar2 = new p();
                                    pVar2.a(VideoPbFragment.this.cWE().getPbData().getForum());
                                    pVar2.setThreadData(VideoPbFragment.this.cWE().getPbData().cVm());
                                    pVar2.g(postData4);
                                    VideoPbFragment.this.kCX.d(pVar2);
                                    VideoPbFragment.this.kCX.setPostId(postData4.getId());
                                    VideoPbFragment.this.a(view, postData4.beE().getUserId(), "", postData4);
                                    if (VideoPbFragment.this.kDS != null) {
                                        VideoPbFragment.this.tC(VideoPbFragment.this.kDS.bsf());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.kVT != null && VideoPbFragment.this.cWE() != null) {
                        if (com.baidu.tbadk.a.d.bah() || VideoPbFragment.this.dee() != null) {
                            if (!com.baidu.tbadk.a.d.bah() || VideoPbFragment.this.deg() != null) {
                                VideoPbFragment.this.kVT.dbf();
                                if (VideoPbFragment.this.Ed(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.cWE() != null) {
                                    VideoPbFragment.this.cXM();
                                    if (VideoPbFragment.this.cWE().getPbData() != null && VideoPbFragment.this.cWE().getPbData().cVm() != null && VideoPbFragment.this.cWE().getPbData().cVm().beE() != null) {
                                        TiebaStatic.log(new aq("c13402").dD("tid", VideoPbFragment.this.cWE().cYC()).dD("fid", VideoPbFragment.this.cWE().getPbData().getForumId()).ai("obj_locate", 3).dD("uid", VideoPbFragment.this.cWE().getPbData().cVm().beE().getUserId()));
                                    }
                                    if (VideoPbFragment.this.cWE().getPbData().cVm() != null && VideoPbFragment.this.cWE().getPbData().cVm().beE() != null && VideoPbFragment.this.cWE().getPbData().cVm().beE().getUserId() != null && VideoPbFragment.this.kDE != null) {
                                        int h = VideoPbFragment.this.kVT.h(VideoPbFragment.this.cWE().getPbData());
                                        bw cVm = VideoPbFragment.this.cWE().getPbData().cVm();
                                        if (!cVm.bdm()) {
                                            if (cVm.bdn()) {
                                                i = 3;
                                            } else if (cVm.bgz()) {
                                                i = 4;
                                            } else {
                                                i = cVm.bgA() ? 5 : 1;
                                            }
                                        }
                                        TiebaStatic.log(new aq("c12526").dD("tid", VideoPbFragment.this.cWE().cYC()).ai("obj_locate", 1).dD("obj_id", VideoPbFragment.this.cWE().getPbData().cVm().beE().getUserId()).ai("obj_type", VideoPbFragment.this.kDE.baA() ? 0 : 1).ai("obj_source", h).ai("obj_param1", i));
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.ud(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.kVT != null && VideoPbFragment.this.eiA != null && VideoPbFragment.this.cWE().getPbData() != null && VideoPbFragment.this.cWE().getPbData().cVm() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.cWE().getPbData();
                        if (pbData.cVm().bev() != 0) {
                            int currentItem = VideoPbFragment.this.eiA.getCurrentItem();
                            if (!com.baidu.tbadk.a.d.bah() && currentItem == VideoPbFragment.kVx) {
                                VideoPbFragment.this.eiA.setCurrentItem(VideoPbFragment.kVy);
                            } else if (com.baidu.tbadk.a.d.bah() || currentItem == VideoPbFragment.kVy) {
                                if (!com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.dee() == null) {
                                    return;
                                }
                                if ((!com.baidu.tbadk.a.d.bah() || VideoPbFragment.this.deg() != null) && VideoPbFragment.this.cpl() != null) {
                                    aq dD = new aq("c13403").dD("tid", VideoPbFragment.this.cWE().cYC()).dD("fid", VideoPbFragment.this.cWE().getPbData().getForumId()).dD("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView cpl = VideoPbFragment.this.cpl();
                                    if (cpl != null) {
                                        boolean canScrollVertically = cpl.canScrollVertically(1);
                                        boolean canScrollVertically2 = cpl.canScrollVertically(-1);
                                        if (VideoPbFragment.this.Xx != null) {
                                            VideoPbFragment.this.Xx.setExpanded(false, true);
                                        }
                                        if (cpl.getLayoutManager() != null && (cpl.getLayoutManager() instanceof LinearLayoutManager)) {
                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) cpl.getLayoutManager();
                                            if (!canScrollVertically2 && canScrollVertically) {
                                                if (VideoPbFragment.this.kDy != -1 || VideoPbFragment.this.kDz != Integer.MIN_VALUE) {
                                                    if (VideoPbFragment.this.kDy > 3 || (VideoPbFragment.this.kDy == 3 && VideoPbFragment.this.kDz < (-equipmentHeight))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.kDy, VideoPbFragment.this.kDz + equipmentHeight);
                                                        cpl.smoothScrollBy(0, equipmentHeight);
                                                    } else if (VideoPbFragment.this.kDy >= 2) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.kDy, VideoPbFragment.this.kDz + (equipmentHeight / 2));
                                                        cpl.smoothScrollBy(0, equipmentHeight / 2);
                                                    } else if (VideoPbFragment.this.kDy == 1) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.kDy, VideoPbFragment.this.kDz + (equipmentHeight / 4));
                                                        cpl.smoothScrollBy(0, equipmentHeight / 4);
                                                    } else {
                                                        cpl.smoothScrollBy(0, -VideoPbFragment.this.kDz);
                                                    }
                                                    dD.ai("obj_locate", 2);
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                int firstVisiblePosition = cpl.getFirstVisiblePosition();
                                                View childAt = cpl.getChildAt(0);
                                                int top = childAt == null ? 0 : childAt.getTop();
                                                VideoPbFragment.this.kDy = firstVisiblePosition;
                                                VideoPbFragment.this.kDz = top;
                                                if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && cpl.getCount() >= 6)) {
                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                    cpl.smoothScrollToPosition(0);
                                                } else {
                                                    cpl.smoothScrollToPosition(0);
                                                }
                                                dD.ai("obj_locate", 1);
                                            }
                                            TiebaStatic.log(dD);
                                            TiebaStatic.log(new aq("c12942").ai("obj_type", 1).ai("obj_locate", 4).dD("tid", VideoPbFragment.this.cWE().cYC()).dD("nid", pbData.cVm().getNid()));
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
                            if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null && VideoPbFragment.this.cWE().getPbData().cVm() != null && VideoPbFragment.this.cWE().getPbData().cVm().beE() != null) {
                                TiebaStatic.log(new aq("c13402").dD("tid", VideoPbFragment.this.cWE().cYC()).dD("fid", VideoPbFragment.this.cWE().getPbData().getForumId()).ai("obj_locate", 2).dD("uid", VideoPbFragment.this.cWE().getPbData().cVm().beE().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.ue(false);
                        VideoPbFragment.this.cXA();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.kEf >= 0) {
                        if (VideoPbFragment.this.cWE() != null) {
                            VideoPbFragment.this.cWE().cZn();
                        }
                        if (com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.deg() != null && VideoPbFragment.this.deg().deN() != null) {
                            VideoPbFragment.this.deg().deN().setData(VideoPbFragment.this.cWE().getPbData());
                        } else if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.dee() != null && VideoPbFragment.this.dee().deN() != null) {
                            VideoPbFragment.this.dee().deN().setData(VideoPbFragment.this.cWE().getPbData());
                        }
                        VideoPbFragment.this.kEf = 0;
                        VideoPbFragment.this.kVV = Integer.MIN_VALUE;
                        if (com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.cWE() != null && VideoPbFragment.this.deg() != null) {
                            VideoPbFragment.this.deg().cX(VideoPbFragment.this.cWE().cZq(), VideoPbFragment.this.cWE().cZr());
                            VideoPbFragment.this.cWE().cU(0, 0);
                        } else if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.dee() != null) {
                            VideoPbFragment.this.dee().cX(VideoPbFragment.this.cWE().cZq(), VideoPbFragment.this.cWE().cZr());
                            VideoPbFragment.this.cWE().cU(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.cWE() != null) {
                        aq aqVar5 = new aq("c13398");
                        aqVar5.dD("tid", VideoPbFragment.this.cWE().cYC());
                        aqVar5.dD("fid", VideoPbFragment.this.cWE().getForumId());
                        aqVar5.dD("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar5.ai("obj_locate", 2);
                        TiebaStatic.log(aqVar5);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bg.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.bik().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.dar();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.dar();
                } else if (VideoPbFragment.this.kVT.dcl() != null && view == VideoPbFragment.this.kVT.dcl().cZS()) {
                    VideoPbFragment.this.kVT.dbf();
                    if (VideoPbFragment.this.cWE() != null) {
                        VideoPbFragment.this.hkB.setThreadId(VideoPbFragment.this.cWE().cYC());
                    }
                    if (VideoPbFragment.this.cWE() == null || !VideoPbFragment.this.cWE().isPrivacy()) {
                        VideoPbFragment.this.hkB.cbu();
                        if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null && VideoPbFragment.this.cWE().getPbData().getThreadId() != null && VideoPbFragment.this.cWE().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                            i3 = 2;
                        }
                        if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null) {
                            VideoPbFragment.this.hkB.i(3, i3, VideoPbFragment.this.cWE().getPbData().getThreadId());
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                    if (VideoPbFragment.this.cWE().getPbData() != null) {
                        VideoPbFragment.this.hkB.i(3, 3, VideoPbFragment.this.cWE().getPbData().getThreadId());
                    }
                }
            }
        }
    };
    private View.OnClickListener kAx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.kVT != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.kVT.c(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.kVT.cT(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.kVT.c(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.kVT.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    public SortSwitchButton.a kEE = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean xL(int i) {
            if (VideoPbFragment.this.kVT != null) {
                VideoPbFragment.this.kVT.dbf();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.cWE() == null || VideoPbFragment.this.cWE().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.cms();
                VideoPbFragment.this.daM();
                if (VideoPbFragment.this.cWE().getPbData() != null && VideoPbFragment.this.cWE().getPbData().kwO != null && VideoPbFragment.this.cWE().getPbData().kwO.size() > i) {
                    int intValue = VideoPbFragment.this.cWE().getPbData().kwO.get(i).sort_type.intValue();
                    TiebaStatic.log(new aq("c13699").dD("tid", VideoPbFragment.this.cWE().cYD()).dD("fid", VideoPbFragment.this.cWE().getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).ai("obj_type", Eg(intValue)));
                    if (VideoPbFragment.this.cWE().En(intValue)) {
                        VideoPbFragment.this.mIsLoading = true;
                    }
                }
                return true;
            }
        }

        private int Eg(int i) {
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
    private a kVU = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void cXK() {
        if (cWE() != null && cWE().getPbData() != null && cWE().getPbData().cVm() != null) {
            bw cVm = cWE().getPbData().cVm();
            cVm.mRecomAbTag = cWE().cZx();
            cVm.mRecomWeight = cWE().cZv();
            cVm.mRecomSource = cWE().cZw();
            cVm.mRecomExtra = cWE().cZy();
            if (cVm.getFid() == 0) {
                cVm.setFid(com.baidu.adp.lib.f.b.toLong(cWE().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cVm, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sU(boolean z) {
        if (cWE() != null && cWE().getPbData() != null && cWE().getPbData().cVm() != null) {
            bw cVm = cWE().getPbData().cVm();
            cVm.mRecomAbTag = cWE().cZx();
            cVm.mRecomWeight = cWE().cZv();
            cVm.mRecomSource = cWE().cZw();
            cVm.mRecomExtra = cWE().cZy();
            if (cVm.getFid() == 0) {
                cVm.setFid(com.baidu.adp.lib.f.b.toLong(cWE().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cVm, "c13563");
            TbPageTag el = com.baidu.tbadk.pageInfo.c.el(getContext());
            if (a2 != null && el != null && PageStayDurationConstants.PageName.VIDEO_LIST.equals(el.locatePage)) {
                a2.dD("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dD("obj_pre_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            if (a2 != null) {
                a2.ai("reply_type", 1);
                if (z) {
                    a2.ai("obj_type", 2);
                } else {
                    a2.ai("obj_type", 1);
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
            String string = !TextUtils.isEmpty(bVar.mhO) ? bVar.mhO : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.zA(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.ig(true);
                aVar.b(getPageContext());
                aVar.bhg();
            } else {
                a(0, bVar.Qf, bVar.mhO, z);
            }
            if (bVar.Qf) {
                if (bVar.hzM == 1) {
                    ArrayList<PostData> cVo = cWE().getPbData().cVo();
                    int size = cVo.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cVo.get(i).getId())) {
                            i++;
                        } else {
                            cVo.remove(i);
                            break;
                        }
                    }
                    cWE().getPbData().cVm().ng(cWE().getPbData().cVm().bev() - 1);
                    if (com.baidu.tbadk.a.d.bah() && deg() != null) {
                        deg().deP();
                    } else if (dee() != null) {
                        dee().deP();
                    }
                } else if (bVar.hzM == 0) {
                    cXL();
                } else if (bVar.hzM == 2) {
                    ArrayList<PostData> cVo2 = cWE().getPbData().cVo();
                    int size2 = cVo2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cVo2.get(i2).dwH().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cVo2.get(i2).dwH().get(i3).getId())) {
                                i3++;
                            } else {
                                cVo2.get(i2).dwH().remove(i3);
                                cVo2.get(i2).dwJ();
                                z2 = true;
                                break;
                            }
                        }
                        cVo2.get(i2).QN(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        if (com.baidu.tbadk.a.d.bah() && deg() != null) {
                            deg().deP();
                        } else if (dee() != null) {
                            dee().deP();
                        }
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = cWE().getPbData().cVA().kyv;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dwH().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dwH().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dwH().remove(i2);
                    list.get(i).dwJ();
                    z = true;
                    break;
                }
            }
            list.get(i).QN(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            if (com.baidu.tbadk.a.d.bah() && deg() != null) {
                deg().deP();
            } else if (dee() != null) {
                dee().deP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && cWE() != null && cWE().getPbData() != null && cWE().getPbData().cVm() != null) {
            a(this.hkz.getLoadDataMode(), gVar.Qf, gVar.mhO, false);
            if (gVar.Qf) {
                this.kDH = true;
                if (i == 2 || i == 3) {
                    this.kDI = true;
                    this.kDJ = false;
                } else if (i == 4 || i == 5) {
                    this.kDI = false;
                    this.kDJ = true;
                }
                if (i == 2) {
                    cWE().getPbData().cVm().nj(1);
                    cWE().setIsGood(1);
                } else if (i == 3) {
                    cWE().getPbData().cVm().nj(0);
                    cWE().setIsGood(0);
                } else if (i == 4) {
                    cWE().getPbData().cVm().ni(1);
                    cWE().Eh(1);
                } else if (i == 5) {
                    cWE().getPbData().cVm().ni(0);
                    cWE().Eh(0);
                }
            }
            if (cWE().getPbData().cVm() != null && def() != null) {
                def().deZ();
            }
        }
    }

    private void cXL() {
        if (cWE().cYF() || cWE().cYH()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", cWE().cYC());
            PbActivity pbActivity = this.kDc;
            PbActivity pbActivity2 = this.kDc;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, cWE().cYC()));
        if (cXO()) {
            this.kDc.finish();
        }
    }

    private boolean cXO() {
        if (cWE() == null) {
            return true;
        }
        if (cWE().getPbData() == null || !cWE().getPbData().cVP()) {
            if (cWE().baA()) {
                final MarkData cYW = cWE().cYW();
                if (cYW == null || !cWE().getIsFromMark() || cpl() == null) {
                    return true;
                }
                final MarkData Eo = cWE().Eo(cpl().getFirstVisiblePosition());
                if (Eo == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cYW);
                    this.kDc.setResult(-1, intent);
                    return true;
                } else if (Eo.getPostId() == null || Eo.getPostId().equals(cYW.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cYW);
                    this.kDc.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.zA(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.kDE != null) {
                                if (VideoPbFragment.this.kDE.baA()) {
                                    VideoPbFragment.this.kDE.baB();
                                    VideoPbFragment.this.kDE.hB(false);
                                }
                                VideoPbFragment.this.kDE.a(Eo);
                                VideoPbFragment.this.kDE.hB(true);
                                VideoPbFragment.this.kDE.baC();
                            }
                            cYW.setPostId(Eo.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cYW);
                            VideoPbFragment.this.kDc.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cWR();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cYW);
                            VideoPbFragment.this.kDc.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cWR();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.bhg();
                    return false;
                }
            } else if (cWE().getPbData() == null || cWE().getPbData().cVo() == null || cWE().getPbData().cVo().size() <= 0 || !cWE().getIsFromMark()) {
                return true;
            } else {
                this.kDc.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWR() {
        this.kDc.cWR();
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
    public void ud(boolean z) {
        com.baidu.tieba.pb.data.f pbData;
        int i;
        if (cWE() != null && this.kVT != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = cWE().getPbData()) != null) {
                bw cVm = pbData.cVm();
                if (cVm != null && cVm.beE() != null) {
                    TiebaStatic.log(new aq("c13402").dD("tid", cWE().cYC()).dD("fid", pbData.getForumId()).ai("obj_locate", 4).dD("uid", cVm.beE().getUserId()));
                }
                if (cVm != null) {
                    if (cVm.bdm()) {
                        i = 2;
                    } else if (cVm.bdn()) {
                        i = 3;
                    } else if (cVm.bgz()) {
                        i = 4;
                    } else if (cVm.bgA()) {
                        i = 5;
                    }
                    aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    aqVar.dD("tid", cWE().cYC());
                    aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dD("fid", cWE().getForumId());
                    if (!z) {
                        aqVar.ai("obj_locate", 6);
                    } else {
                        aqVar.ai("obj_locate", 5);
                    }
                    aqVar.ai("obj_name", i);
                    aqVar.ai("obj_type", 2);
                    if (cVm != null) {
                        if (cVm.bdm()) {
                            aqVar.ai("obj_type", 10);
                        } else if (cVm.bdn()) {
                            aqVar.ai("obj_type", 9);
                        } else if (cVm.bgA()) {
                            aqVar.ai("obj_type", 8);
                        } else if (cVm.bgz()) {
                            aqVar.ai("obj_type", 7);
                        } else if (cVm.isShareThread) {
                            aqVar.ai("obj_type", 6);
                        } else if (cVm.threadType == 0) {
                            aqVar.ai("obj_type", 1);
                        } else if (cVm.threadType == 40) {
                            aqVar.ai("obj_type", 2);
                        } else if (cVm.threadType == 49) {
                            aqVar.ai("obj_type", 3);
                        } else if (cVm.threadType == 54) {
                            aqVar.ai("obj_type", 4);
                        } else {
                            aqVar.ai("obj_type", 5);
                        }
                        aqVar.dD("nid", cVm.getNid());
                        aqVar.ai(IntentConfig.CARD_TYPE, cVm.bgD());
                        aqVar.dD(IntentConfig.RECOM_SOURCE, cVm.mRecomSource);
                        aqVar.dD("ab_tag", cVm.mRecomAbTag);
                        aqVar.dD("weight", cVm.mRecomWeight);
                        aqVar.dD("extra", cVm.mRecomExtra);
                        aqVar.dD("nid", cVm.getNid());
                        if (cVm.getBaijiahaoData() != null && !at.isEmpty(cVm.getBaijiahaoData().oriUgcVid)) {
                            aqVar.dD("obj_param6", cVm.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (cYj() != null) {
                        com.baidu.tbadk.pageInfo.c.b(cYj(), aqVar);
                    }
                    TiebaStatic.log(aqVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (cWE().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> cVo = pbData.cVo();
                        if ((cVo == null || cVo.size() <= 0) && cWE().cYE()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.kVT.dbf();
                        cms();
                        TiebaStatic.log(new aq("c11939"));
                        if (!AntiHelper.d(getContext(), cVm)) {
                            if (this.kLD != null) {
                                this.kLD.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                Ee(z ? 2 : 1);
                                return;
                            }
                            this.kVT.showLoadingDialog();
                            cWE().cZh().A(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                aq aqVar2 = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar2.dD("tid", cWE().cYC());
                aqVar2.dD("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.dD("fid", cWE().getForumId());
                if (!z) {
                }
                aqVar2.ai("obj_name", i);
                aqVar2.ai("obj_type", 2);
                if (cVm != null) {
                }
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (cYj() != null) {
                }
                TiebaStatic.log(aqVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment ddL() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        J(eVar.der());
        K(eVar.der());
        if (cWE() != null && cWE().getPbData() != null) {
            boolean isFromMark = cWE().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = cWE().getPbData();
            if (isFromMark) {
                PostData I = I(pbData);
                if (pbData.baz() != null && !pbData.baz().equals(I.getId()) && this.eiA != null) {
                    if (com.baidu.tbadk.a.d.bah()) {
                        this.eiA.setCurrentItem(kVz);
                    } else {
                        this.eiA.setCurrentItem(kVy);
                    }
                }
            }
        }
        eVar.des().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aN */
            public void onChanged(@Nullable bw bwVar) {
                BdTypeRecyclerView cpl;
                if (bwVar != null && bwVar.beW() != null) {
                    if (VideoPbFragment.this.kVG.getVideoUrl() == null || !VideoPbFragment.this.kVG.getVideoUrl().equals(bwVar.beW().video_url)) {
                        if (!at.isEmpty(VideoPbFragment.this.kVG.getVideoUrl())) {
                            VideoPbFragment.this.kDp = true;
                            if (com.baidu.tbadk.a.d.bah()) {
                                VideoPbFragment.this.eiA.setCurrentItem(VideoPbFragment.kVz);
                            } else {
                                VideoPbFragment.this.eiA.setCurrentItem(VideoPbFragment.kVx);
                            }
                            if (com.baidu.tbadk.a.d.bah() && (cpl = VideoPbFragment.this.cpl()) != null) {
                                cpl.scrollToPosition(0);
                            }
                        }
                        if (VideoPbFragment.this.kVH == null || !VideoPbFragment.this.kVH.isPlaying()) {
                            VideoPbFragment.this.ddM();
                            VideoPbFragment.this.aM(bwVar);
                        }
                        VideoPbFragment.this.ddN();
                        if (VideoPbFragment.this.kVH.deF()) {
                            VideoPbFragment.this.kVH.start();
                        }
                        boolean z = !at.equals(VideoPbFragment.this.kVG.getVideoUrl(), bwVar.beW().video_url);
                        VideoPbFragment.this.kVG.setData(bwVar);
                        if (com.baidu.tbadk.a.d.bah()) {
                            VideoPbFragment.this.kVG.um(false);
                        } else {
                            VideoPbFragment.this.kVG.um(VideoPbFragment.this.eiA.getCurrentItem() == 0);
                        }
                        if (z) {
                            VideoPbFragment.this.kVG.startPlay();
                            VideoPbFragment.this.kVG.dfr();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.kVG.setData(bwVar);
                }
            }
        });
        eVar.deB().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: q */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.eiA.setCurrentItem(num.intValue());
            }
        });
        eVar.dew().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aN */
            public void onChanged(@Nullable bw bwVar) {
                VideoPbFragment.this.kVG.aR(bwVar);
            }
        });
        eVar.dex().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aN */
            public void onChanged(@Nullable bw bwVar) {
                VideoPbFragment.this.kVG.aS(bwVar);
            }
        });
        eVar.dey().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: p */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.ddX();
            }
        });
        eVar.dez().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: p */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddM() {
        ViewGroup.LayoutParams layoutParams = this.kVJ.getLayoutParams();
        layoutParams.height = 0;
        this.kVJ.setLayoutParams(layoutParams);
        this.kVJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddN() {
        if (this.kVH == null) {
            this.kVH = new f(getBaseFragmentActivity(), this.kVF);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(cYj()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.kVF.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.kVH.b(eVar.det(), rect);
            if (this.kVH.deF()) {
                this.kVH.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (com.baidu.tbadk.a.d.bah()) {
                            if (eVar.deu() || VideoPbFragment.this.cWE().getTabIndex() == VideoPbFragment.kVz) {
                                VideoPbFragment.this.eiA.setCurrentItem(VideoPbFragment.kVz);
                            }
                        } else if (eVar.deu() || VideoPbFragment.this.cWE().getTabIndex() == VideoPbFragment.kVy) {
                            VideoPbFragment.this.eiA.setCurrentItem(VideoPbFragment.kVy);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (com.baidu.tbadk.a.d.bah()) {
                            if (eVar.deu() || VideoPbFragment.this.cWE().getTabIndex() == VideoPbFragment.kVz) {
                                VideoPbFragment.this.eiA.setCurrentItem(VideoPbFragment.kVz);
                            }
                        } else if (eVar.deu() || VideoPbFragment.this.cWE().getTabIndex() == VideoPbFragment.kVy) {
                            VideoPbFragment.this.eiA.setCurrentItem(VideoPbFragment.kVy);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (com.baidu.tbadk.a.d.bah()) {
                if (eVar.deu() || cWE().getTabIndex() == kVz) {
                    this.eiA.setCurrentItem(kVz);
                }
            } else if (eVar.deu() || cWE().getTabIndex() == kVy) {
                this.eiA.setCurrentItem(kVy);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.kVZ && (this.kWa || del())) {
            dek();
            UtilHelper.hideStatusBar(cYj(), cYj().getRootView());
            this.kWa = false;
            if (this.kVG != null) {
                this.kVG.uf(false);
            }
        }
        if (i == 4) {
            return this.kVG.dkA();
        }
        if (i == 24) {
            return this.kVG.dfo();
        }
        if (i == 25) {
            return this.kVG.dfp();
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
    public void aM(bw bwVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect cZz;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bwVar != null && bwVar.beW() != null) {
            int intValue = bwVar.beW().video_width.intValue();
            int intValue2 = bwVar.beW().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (cWE() != null || (cZz = cWE().cZz()) == null) ? ceil : cZz.height();
                i = 0;
                layoutParams = this.kVF.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.kVF.setLayoutParams(layoutParams);
                this.kVF.setMaxHeight(ceil);
                this.kVF.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.kVF.setOriginHeight(height);
                if (!com.baidu.tbadk.a.d.bah()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.kVB.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, kVA);
                    } else {
                        layoutParams3.height = kVA;
                    }
                    this.kVB.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.Xx.getLayoutParams();
                if (!com.baidu.tbadk.a.d.bah()) {
                    ceil += kVA;
                }
                if (layoutParams2 != null) {
                    layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                } else {
                    layoutParams2.height = ceil;
                }
                this.Xx.setLayoutParams(layoutParams2);
                if (i == 0 && (this.Xx.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.Xx.getLayoutParams()).getBehavior();
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
        if (cWE() != null) {
        }
        i = 0;
        layoutParams = this.kVF.getLayoutParams();
        if (layoutParams != null) {
        }
        this.kVF.setLayoutParams(layoutParams);
        this.kVF.setMaxHeight(ceil2);
        this.kVF.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.kVF.setOriginHeight(height);
        if (!com.baidu.tbadk.a.d.bah()) {
        }
        layoutParams2 = (CoordinatorLayout.LayoutParams) this.Xx.getLayoutParams();
        if (!com.baidu.tbadk.a.d.bah()) {
        }
        if (layoutParams2 != null) {
        }
        this.Xx.setLayoutParams(layoutParams2);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.kDj = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        ar(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.kDZ = new com.baidu.tbadk.core.view.c();
        this.kDZ.toastTime = 1000L;
        if (this.kVT != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.kVT.kEa;
            userMuteAddAndDelCustomMessage.setTag(this.kVT.kEa);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.kVT.kEa;
            userMuteCheckCustomMessage.setTag(this.kVT.kEa);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.hkB = new com.baidu.tieba.callfans.a(getPageContext());
        com.baidu.tieba.s.c.dvJ().A(getUniqueId());
    }

    private void initData() {
        this.kDE = com.baidu.tbadk.baseEditMark.a.a(this.kDc);
        if (this.kDE != null) {
            this.kDE.a(this.kEK);
        }
        this.hkz = new ForumManageModel(this.kDc);
        this.hkz.setLoadDataCallBack(this.hkG);
        this.ekH = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.kVT = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void ar(Bundle bundle) {
        this.kDR = new g();
        d(this.kDR);
        this.kDS = (com.baidu.tbadk.editortools.pb.e) this.kDR.ec(getActivity());
        this.kDS.a(this.kDc.getPageContext());
        this.kDS.a(this.eMH);
        this.kDS.a(this.eMA);
        this.kDS.a(this.kDc.getPageContext(), bundle);
        this.kDS.brw().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.kDS.brw().jj(true);
        sT(true);
        this.kDS.a(cWE().cYS(), cWE().cYC(), cWE().cZj());
        registerListener(this.kEp);
        registerListener(this.kEJ);
        registerListener(this.kEo);
        registerListener(this.kEm);
        registerListener(this.hUw);
        if (!cWE().cYJ()) {
            this.kDS.BZ(cWE().cYC());
        }
        if (cWE().cZk()) {
            this.kDS.BX(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.kDS.BX(dat());
        }
        this.jJI = new bb();
        if (this.kDS.brX() != null) {
            this.jJI.f(this.kDS.brX().getInputView());
        }
        this.kDS.a(this.eMB);
        this.jFD = new am(getPageContext());
        this.jFD.a(new am.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == am.ekC) {
                        VideoPbFragment.this.kDS.a((String) null, (WriteData) null);
                    } else if (i == am.ekD && VideoPbFragment.this.kMf != null && VideoPbFragment.this.kMf.cXo() != null) {
                        VideoPbFragment.this.kMf.cXo().bsv();
                    } else if (i == am.ekE) {
                        VideoPbFragment.this.c(VideoPbFragment.this.kDV);
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
        this.hXQ = new com.baidu.tieba.f.b(getActivity());
        this.hXQ.a(kES);
        this.kVZ = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        buP();
        this.Xx = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.kVD = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.kVF = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.kVG = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.kVF);
        this.kVG.setStageType("2002");
        this.kVG.setUniqueId(getUniqueId());
        this.kVG.af(this);
        this.kVG.db(cYj().getRootView());
        this.kVG.dc(this.kVI);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.kVB = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.kVJ = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.eiA = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.kVE = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.kVE.setOnClickListener(this.aBm);
        ddP();
        ddO();
        ddQ();
        this.kVC = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.eiA.setAdapter(this.kVC);
        this.kVB.setViewPager(this.eiA);
        this.kVB.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.deg() != null) {
                        VideoPbFragment.this.deg().ul(false);
                    } else if (VideoPbFragment.this.dee() != null) {
                        VideoPbFragment.this.dee().ul(false);
                    }
                    if (VideoPbFragment.this.def() != null) {
                        VideoPbFragment.this.def().ul(true);
                        VideoPbFragment.this.EN(VideoPbFragment.this.def().deT() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.dey() != null && eVar.dey().getValue() != null && eVar.dey().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.kVG.um(z);
                    VideoPbFragment.this.dar();
                    if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null) {
                        TiebaStatic.log(new aq("c13592").dD("tid", VideoPbFragment.this.cWE().cYC()).dD("fid", VideoPbFragment.this.cWE().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.def() != null) {
                        VideoPbFragment.this.def().ul(false);
                    }
                    if (com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.deg() != null) {
                        VideoPbFragment.this.deg().ul(true);
                        int deT = VideoPbFragment.this.deg().deT();
                        int deU = VideoPbFragment.this.deg().deU();
                        if (deT != 0) {
                            VideoPbFragment.this.EN(8);
                            VideoPbFragment.this.deg().EN(0);
                        } else if (deU != 0) {
                            VideoPbFragment.this.deg().EN(8);
                            VideoPbFragment.this.EN(0);
                        } else {
                            VideoPbFragment.this.deg().EN(8);
                            VideoPbFragment.this.EN(8);
                        }
                    } else if (VideoPbFragment.this.dee() != null) {
                        VideoPbFragment.this.dee().ul(true);
                        int deT2 = VideoPbFragment.this.dee().deT();
                        int deU2 = VideoPbFragment.this.dee().deU();
                        if (deT2 != 0) {
                            VideoPbFragment.this.EN(8);
                            VideoPbFragment.this.dee().EN(0);
                        } else if (deU2 != 0) {
                            VideoPbFragment.this.dee().EN(8);
                            VideoPbFragment.this.EN(0);
                        } else {
                            VideoPbFragment.this.dee().EN(8);
                            VideoPbFragment.this.EN(8);
                        }
                    }
                    VideoPbFragment.this.kVG.um(false);
                    VideoPbFragment.this.Xx.setExpanded(false, true);
                    if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null) {
                        TiebaStatic.log(new aq("c13593").dD("tid", VideoPbFragment.this.cWE().cYC()).dD("fid", VideoPbFragment.this.cWE().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.kVC.EP(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.kLf = this.rootView.findViewById(R.id.viewstub_progress);
        ddR();
        bKT();
        if (!this.kVZ && this.kWa) {
            dek();
            UtilHelper.hideStatusBar(cYj(), cYj().getRootView());
            this.kWa = false;
        }
        if (com.baidu.tbadk.a.d.bah()) {
            this.kVB.getLayoutParams().height = 0;
        }
    }

    private void ddO() {
        this.kVL = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.kVP = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.kVM = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.kVN = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.kVO = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.kVQ = this.rootView.findViewById(R.id.ala_live_point);
        this.kVP.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.kVP.setConrers(15);
        this.kVO.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.kVN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.kxz == null || VideoPbFragment.this.kxz.dff()) {
                    if (VideoPbFragment.this.kxz != null) {
                        TiebaStatic.log(new aq("c13608").dD("tid", VideoPbFragment.this.cWE().getPbData().getThreadId()));
                        VideoPbFragment.this.kxz.kXV = true;
                    }
                } else {
                    TiebaStatic.log(new aq("c13591"));
                }
                VideoPbFragment.this.ddZ();
            }
        });
        this.kVO.setOnClickListener(this.kVK);
        this.kVJ.setOnClickListener(this.kVK);
    }

    private void ddP() {
        this.kVB.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.kVB.setContainerLayoutParams(layoutParams);
        this.kVB.setRectPaintColor(R.color.cp_link_tip_a);
        this.kVB.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.kVB.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.kVB.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.kVB.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.kVB.setExpandedTabLayoutParams(layoutParams2);
    }

    public void ue(boolean z) {
        if (this.Xx != null) {
            this.Xx.setExpanded(z);
        }
    }

    private void ddQ() {
        this.kLw = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.kLx = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.kLH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.kLI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.kLz = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.kLz.setVisibility(0);
        this.kLz.setIsRound(true);
        this.kLz.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
        this.kLz.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.kLz.setPlaceHolder(1);
        this.kLz.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.kLz.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        this.iUa = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.kLy = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.kLy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.ue(false);
                VideoPbFragment.this.cXA();
                if (VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null && VideoPbFragment.this.cWE().getPbData().cVm() != null && VideoPbFragment.this.cWE().getPbData().cVm().beE() != null) {
                    TiebaStatic.log(new aq("c13701").dD("tid", VideoPbFragment.this.cWE().cYD()).dD("fid", VideoPbFragment.this.cWE().getPbData().getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new aq("c13402").dD("tid", VideoPbFragment.this.cWE().cYC()).dD("fid", VideoPbFragment.this.cWE().getPbData().getForumId()).ai("obj_locate", 1).dD("uid", VideoPbFragment.this.cWE().getPbData().cVm().beE().getUserId()));
                }
            }
        });
        this.kLA = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.kLA.setOnClickListener(this.aBm);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.kLB = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.kLB.setOnClickListener(this.aBm);
        if (booleanExtra) {
            this.kLB.setVisibility(8);
        } else {
            this.kLB.setVisibility(0);
        }
        this.kLC = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.kLC.setOnClickListener(this.aBm);
        this.kLD = new com.baidu.tieba.pb.view.c(this.kLC);
        this.kLD.dfB();
        this.kLE = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.kLE.setVisibility(0);
        tE(false);
    }

    private void buP() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cmt();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.kVI = this.rootView.findViewById(R.id.status_bar_background);
        if (this.kVZ) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(cYj());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.kVI.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(cYj());
            this.kVI.setLayoutParams(layoutParams2);
            this.kVI.setVisibility(0);
        }
        this.eUq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aBm);
        this.gae = (ImageView) this.eUq.findViewById(R.id.widget_navi_back_button);
        SvgManager.bjq().a(this.gae, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.kQZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aBm);
        this.agh = (ImageView) this.kQZ.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.kQZ.setLayoutParams(layoutParams3);
        SvgManager.bjq().a(this.agh, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.kQZ.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.ifc);
        this.mNavigationBar.setOnTouchListener(this.kWb);
    }

    public void ddR() {
        setEditorTools(this.kDS.brw());
    }

    private void bKT() {
        this.kCX = new PbFakeFloorModel(getPageContext());
        this.kMf = new v(getPageContext(), this.kCX, this.rootView);
        this.kMf.T(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dar();
            }
        });
        this.kMf.a(this.kEG);
        this.kCX.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.kCX.t(postData);
                if (com.baidu.tbadk.a.d.bah() || VideoPbFragment.this.deg() != null) {
                    VideoPbFragment.this.deg().deP();
                } else if (VideoPbFragment.this.dee() != null) {
                    VideoPbFragment.this.dee().deP();
                }
                VideoPbFragment.this.kMf.cXk();
                VideoPbFragment.this.aaA.bpY();
                VideoPbFragment.this.tE(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, PostData postData2, boolean z, boolean z2) {
        PbActivity.a Ny;
        String cYC = cWE().cYC();
        String id = postData.getId();
        String str = "";
        if (postData2 != null) {
            str = postData2.getId();
        }
        int i = 0;
        if (cWE().getPbData() != null) {
            i = cWE().getPbData().cVB();
        }
        if (dee() != null && dee().deR() != null) {
            Ny = dee().deR().Ny(id);
        } else if (deg() != null && deg().deR() != null) {
            Ny = deg().deR().Ny(id);
        } else {
            return;
        }
        if (postData != null && cWE() != null && cWE().getPbData() != null && Ny != null) {
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(cYC, id, "pb", true, null, false, str, i, postData.ddk(), cWE().getPbData().getAnti(), false, postData.beE().getIconInfo()).addBigImageData(Ny.kzS, Ny.dUS, Ny.dUQ, Ny.index);
            if (z2) {
                addBigImageData.setHighLightPostId(str);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(cWE().getForumId());
            addBigImageData.setBjhData(cWE().cYL());
            addBigImageData.setKeyPageStartFrom(cWE().cZm());
            addBigImageData.setFromFrsForumId(cWE().getFromForumId());
            addBigImageData.setIsOpenEditor(z);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.kDc = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (cWE() != null) {
            cWE().aC(bundle);
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
        this.bpH = true;
        getVoiceManager().onPause(getPageContext());
        this.kVG.pP(true);
        if (cWE() != null && !cWE().cYJ()) {
            this.kDS.BY(cWE().cYC());
        }
        com.baidu.tbadk.BdToken.c.aYs().aYC();
        MessageManager.getInstance().unRegisterListener(this.kEz);
        MessageManager.getInstance().unRegisterListener(this.kEA);
        MessageManager.getInstance().unRegisterListener(this.kEB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bpH = false;
        getVoiceManager().onResume(getPageContext());
        this.kVG.pP(false);
        cYf();
        registerListener(this.kEz);
        registerListener(this.kEA);
        registerListener(this.kEB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.kVC != null && this.eiA != null) {
            this.kVC.EP(z ? this.eiA.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (this.kLz != null) {
            this.kLz.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.dvJ().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dvJ().B(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.kLD != null) {
            this.kLD.onDestroy();
        }
        if (this.hkz != null) {
            this.hkz.cancelLoadData();
        }
        if (this.kVG != null) {
            this.kVG.onDestroy();
        }
        if (this.kDu != null) {
            this.kDu.cancelLoadData();
        }
        if (this.jFD != null) {
            this.jFD.onDestroy();
        }
        if (cWE() != null) {
            cWE().cancelLoadData();
            cWE().destory();
            if (cWE().cZg() != null) {
                cWE().cZg().onDestroy();
            }
        }
        if (this.kDS != null) {
            this.kDS.onDestroy();
        }
        this.kDZ = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.kDc);
        this.kVB.onChangeSkinType();
        ap.setBackgroundColor(this.kVB, R.color.cp_bg_line_h);
        this.jJI.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.kVH == null || !this.kVH.isPlaying()) {
            ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        ap.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        ap.setBackgroundColor(this.kVI, R.color.cp_mask_b_alpha66);
        if (this.aaA != null) {
            this.aaA.onChangeSkinType(i);
        }
        if (this.kMf != null) {
            this.kMf.onChangeSkinType(i);
        }
        if (this.iUa != null) {
            ap.setViewTextColor(this.iUa, R.color.cp_cont_d);
        }
        if (this.kLz != null) {
            this.kLz.setBorderColor(ap.getColor(R.color.cp_border_a));
        }
        if (this.kLy != null) {
            this.kLy.setBackgroundDrawable(ap.aO(l.getDimens(getContext(), R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
        }
        if (this.kLB != null && cWE() != null) {
            if (cWE().baA()) {
                SvgManager.bjq().a(this.kLB, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bjq().a(this.kLB, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.kLA != null) {
            SvgManager.bjq().a(this.kLA, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (cWE() != null) {
            x(cWE().getPbData());
        }
        if (this.kLE != null) {
            ap.c(this.kLE, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_cont_h, R.color.cp_cont_h);
            ap.setViewTextColor(this.kLE, R.color.cp_cont_a);
        }
        if (this.kLF != null) {
            ap.setViewTextColor(this.kLF, R.color.cp_cont_b);
        }
        if (this.kLw != null) {
            ap.setBackgroundResource(this.kLw, R.drawable.bottom_shadow);
        }
        ap.setBackgroundColor(this.kLx, R.color.cp_bg_line_h);
        if (com.baidu.tbadk.a.d.bah() && deg() != null) {
            deg().onChangeSkinType(i);
        } else if (dee() != null) {
            dee().onChangeSkinType(i);
        }
        if (def() != null) {
            def().onChangeSkinType(i);
        }
        if (this.kVD != null) {
            ap.setBackgroundResource(this.kVD, R.drawable.personalize_tab_shadow);
        }
        if (this.kVJ != null) {
            ap.setBackgroundColor(this.kVJ, R.color.cp_bg_line_g);
        }
        if (this.kVN != null) {
            SvgManager.bjq().a(this.kVN, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.kVL != null) {
            ap.setViewTextColor(this.kVL, R.color.cp_cont_b);
        }
        if (this.kVM != null) {
            ap.setViewTextColor(this.kVM, R.color.cp_cont_d);
        }
        if (this.kVQ != null) {
            this.kVQ.setBackgroundDrawable(ap.aO(l.getDimens(this.kVQ.getContext(), R.dimen.tbds32), ap.getColor(R.color.cp_other_c)));
        }
        cms();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hSU == null) {
            this.hSU = VoiceManager.instance();
        }
        return this.hSU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cms() {
        if (this.hSU != null) {
            this.hSU.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cYh() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cYi() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel cWE() {
        return this.kDc.cWE();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cYj() {
        return this.kDc;
    }

    public com.baidu.tbadk.baseEditMark.a ddS() {
        return this.kDE;
    }

    public View.OnClickListener ddT() {
        return this.aBm;
    }

    public View.OnClickListener ddU() {
        return this.kAx;
    }

    public View.OnLongClickListener ddV() {
        return this.kVT.ddV();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (com.baidu.tieba.pb.pb.main.be.NN(objArr[i].getLink()) && (drawable = ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView cpl() {
        Iterator<BaseFragment> it = this.kVC.dep().iterator();
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

    private void sT(boolean z) {
        this.kDS.jn(z);
        this.kDS.jo(z);
        this.kDS.jp(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.kVT != null) {
            if (z) {
                this.kVT.dbf();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.kVT.dbg();
            } else {
                this.kVT.dbf();
            }
        }
    }

    public boolean Ec(int i) {
        if (this.jFD == null || cWE() == null || cWE().getPbData() == null || cWE().getPbData().getAnti() == null) {
            return true;
        }
        return this.jFD.aN(cWE().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean cXC() {
        if ((cWE() != null && cWE().getPbData().cVP()) || this.jFD == null || cWE() == null || cWE().getPbData() == null || cWE().getPbData().getAnti() == null) {
            return true;
        }
        return this.jFD.nP(cWE().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && cWE() != null) {
            gVar.setForumName(cWE().cWv());
            if (cWE().getPbData() != null && cWE().getPbData().getForum() != null) {
                gVar.a(cWE().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(cWE());
        }
    }

    public void daH() {
        if (this.aaA != null) {
            this.aaA.display();
            if (this.kDS != null) {
                this.kDS.bsc();
            }
            dbp();
        }
    }

    public com.baidu.tbadk.editortools.pb.e cXp() {
        return this.kDS;
    }

    private boolean cXz() {
        PbModel cWE = cWE();
        if (cWE == null || cWE.getPbData() == null) {
            return false;
        }
        bw cVm = cWE.getPbData().cVm();
        cWE.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cVm);
    }

    public void cXA() {
        if (checkUpIsLogin() && cWE() != null && cWE().getPbData() != null && cWE().getPbData().getForum() != null && !cXz()) {
            if (cWE().getPbData().cVP()) {
                cze();
                return;
            }
            if (this.hXq == null) {
                this.hXq = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hXq.yr(0);
                this.hXq.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void ow(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void z(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void ox(boolean z) {
                        if (z) {
                            if (VideoPbFragment.this.kDS != null && VideoPbFragment.this.kDS.brw() != null) {
                                VideoPbFragment.this.kDS.brw().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            VideoPbFragment.this.cze();
                        }
                    }
                });
            }
            this.hXq.C(cWE().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cWE().cYC(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.kDS.onActivityResult(i, i2, intent);
        if (this.kDu != null) {
            this.kDu.onActivityResult(i, i2, intent);
        }
        if (this.kMf != null) {
            this.kMf.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cXM();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dmP().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.kDV = emotionImageData;
                        if (Ec(am.ekE)) {
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
        if (cYj() != null) {
            if (this.kWa && !TbSingleton.getInstance().isNotchScreen(cYj()) && !TbSingleton.getInstance().isCutoutScreen(cYj())) {
                dek();
                UtilHelper.hideStatusBar(cYj(), cYj().getRootView());
                this.kWa = false;
            }
            this.kVU.kWp = z;
            ddW();
            ddX();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.kDc;
        if (i == 0) {
            dan();
            if (this.kMf != null) {
                this.kMf.cXk();
            }
            tE(false);
        }
        dar();
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
                        this.kDS.resetData();
                        this.kDS.setVoiceModel(pbEditorData.getVoiceModel());
                        this.kDS.b(writeData);
                        m qe = this.kDS.brw().qe(6);
                        if (qe != null && qe.eKB != null) {
                            qe.eKB.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.kDc;
                        if (i == -1) {
                            this.kDS.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.kMf != null && this.kMf.cXo() != null) {
                            com.baidu.tbadk.editortools.pb.h cXo = this.kMf.cXo();
                            cXo.setThreadData(cWE().getPbData().cVm());
                            cXo.b(writeData);
                            cXo.setVoiceModel(pbEditorData.getVoiceModel());
                            m qe2 = cXo.brw().qe(6);
                            if (qe2 != null && qe2.eKB != null) {
                                qe2.eKB.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.kDc;
                            if (i == -1) {
                                cXo.bsv();
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
                if (cWE() != null && !cWE().cYJ()) {
                    antiData.setBlock_forum_name(cWE().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(cWE().getPbData().getForum().getId());
                    antiData.setUser_name(cWE().getPbData().getUserData().getUserName());
                    antiData.setUser_id(cWE().getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.by(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.kVT != null) {
                this.kVT.Ce(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void cYl() {
        if (cWE() != null && this.kDc != null) {
            if (this.kDS == null || !this.kDS.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.kDS = (com.baidu.tbadk.editortools.pb.e) dVar.ec(getContext());
                this.kDS.a(this.kDc.getPageContext());
                this.kDS.a(this.eMH);
                this.kDS.a(this.eMA);
                this.kDS.a(this.kDc.getPageContext(), this.kDc.getIntent() == null ? null : this.kDc.getIntent().getExtras());
                this.kDS.brw().jj(true);
                setEditorTools(this.kDS.brw());
                if (!cWE().cYJ()) {
                    this.kDS.BZ(cWE().cYC());
                }
                if (cWE().cZk()) {
                    this.kDS.BX(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.kDS.BX(dat());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.aaA = editorTools;
        this.aaA.setId(R.id.pb_editor);
        this.aaA.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dar();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.aaA.getParent() == null) {
            this.rootView.addView(this.aaA, layoutParams);
        }
        this.aaA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.aaA.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof t) {
                    if (((t) aVar.data).bmP() == EmotionGroupType.BIG_EMOTION || ((t) aVar.data).bmP() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.kDS.c((t) aVar.data);
                            VideoPbFragment.this.kDS.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dan();
        this.kDS.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.aaA != null && VideoPbFragment.this.aaA.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.jJI != null && VideoPbFragment.this.jJI.dbF() != null) {
                    if (!VideoPbFragment.this.jJI.dbF().dFG()) {
                        VideoPbFragment.this.jJI.tK(false);
                    }
                    VideoPbFragment.this.jJI.dbF().xa(false);
                }
            }
        });
    }

    public void cze() {
        if (!checkUpIsLogin()) {
            if (cWE() != null) {
                TiebaStatic.log(new aq("c10517").ai("obj_locate", 2).dD("fid", cWE().getForumId()));
            }
        } else if (cXC()) {
            if (this.kDS != null && (this.kDS.bsm() || this.kDS.bsn())) {
                this.kDS.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.aaA != null) {
                daH();
                this.kVU.kWo = false;
                if (this.aaA.qe(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.aaA.qe(2).eKB, false, null);
                }
            }
            dbp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !cXz() && cXC()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.kDw);
                this.kDx = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.kMf != null && postData != null) {
                String str3 = "";
                if (postData.dwM() != null) {
                    str3 = postData.dwM().toString();
                }
                this.kMf.Ns(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.beE().getName_show(), str3));
            }
            if (cWE() != null && cWE().getPbData() != null && cWE().getPbData().cVP()) {
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.kDc.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.kDw[1] + VideoPbFragment.this.kDx) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cpl() != null) {
                            VideoPbFragment.this.cpl().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.kMf != null) {
                            VideoPbFragment.this.kDS.brw().setVisibility(8);
                            VideoPbFragment.this.kMf.g(str, str2, VideoPbFragment.this.dat(), (VideoPbFragment.this.cWE() == null || VideoPbFragment.this.cWE().getPbData() == null || VideoPbFragment.this.cWE().getPbData().cVm() == null || !VideoPbFragment.this.cWE().getPbData().cVm().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cXo = VideoPbFragment.this.kMf.cXo();
                            if (cXo != null && VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null) {
                                cXo.a(VideoPbFragment.this.cWE().getPbData().getAnti());
                                cXo.setThreadData(VideoPbFragment.this.cWE().getPbData().cVm());
                            }
                            if (VideoPbFragment.this.jJI.dbH() == null && VideoPbFragment.this.kMf.cXo().bsD() != null) {
                                VideoPbFragment.this.kMf.cXo().bsD().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.jJI != null && VideoPbFragment.this.jJI.dbG() != null) {
                                            if (!VideoPbFragment.this.jJI.dbG().dFG()) {
                                                VideoPbFragment.this.jJI.tL(false);
                                            }
                                            VideoPbFragment.this.jJI.dbG().xa(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.jJI.g(VideoPbFragment.this.kMf.cXo().bsD().getInputView());
                                VideoPbFragment.this.kMf.cXo().a(VideoPbFragment.this.kDX);
                            }
                        }
                        VideoPbFragment.this.dbp();
                    }
                }, 0L);
                return;
            }
            if (this.kDU == null) {
                this.kDU = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.kDU.yr(1);
                this.kDU.a(new AnonymousClass47(str, str2));
            }
            if (cWE() != null && cWE().getPbData() != null && cWE().getPbData().getForum() != null) {
                this.kDU.C(cWE().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cWE().cYC(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$47  reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass47 implements c.a {
        final /* synthetic */ String kFc;
        final /* synthetic */ String kFd;

        AnonymousClass47(String str, String str2) {
            this.kFc = str;
            this.kFd = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ow(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ox(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.kDw[1] + VideoPbFragment.this.kDx) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cpl() != null) {
                            VideoPbFragment.this.cpl().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.kMf != null) {
                            VideoPbFragment.this.kDS.brw().setVisibility(8);
                            VideoPbFragment.this.kMf.g(AnonymousClass47.this.kFc, AnonymousClass47.this.kFd, VideoPbFragment.this.dat(), (VideoPbFragment.this.cWE() == null || VideoPbFragment.this.cWE().getPbData() == null || VideoPbFragment.this.cWE().getPbData().cVm() == null || !VideoPbFragment.this.cWE().getPbData().cVm().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cXo = VideoPbFragment.this.kMf.cXo();
                            if (cXo != null && VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null) {
                                cXo.a(VideoPbFragment.this.cWE().getPbData().getAnti());
                                cXo.setThreadData(VideoPbFragment.this.cWE().getPbData().cVm());
                            }
                            if (VideoPbFragment.this.jJI.dbH() == null && VideoPbFragment.this.kMf.cXo().bsD() != null) {
                                VideoPbFragment.this.kMf.cXo().bsD().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.jJI != null && VideoPbFragment.this.jJI.dbG() != null) {
                                            if (!VideoPbFragment.this.jJI.dbG().dFG()) {
                                                VideoPbFragment.this.jJI.tL(false);
                                            }
                                            VideoPbFragment.this.jJI.dbG().xa(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.jJI.g(VideoPbFragment.this.kMf.cXo().bsD().getInputView());
                                VideoPbFragment.this.kMf.cXo().a(VideoPbFragment.this.kDX);
                            }
                        }
                        VideoPbFragment.this.dbp();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData I;
        ab abVar;
        StringBuilder sb = null;
        if (fVar != null && (I = I(fVar)) != null) {
            String userId = I.beE().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, I.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cVB()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (I.beE() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, I.beE().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, I.beE().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, I.beE().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, I.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, I.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cVB()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bs> cVJ = fVar.cVJ();
                if (com.baidu.tbadk.core.util.y.getCount(cVJ) > 0) {
                    sb = new StringBuilder();
                    for (bs bsVar : cVJ) {
                        if (bsVar != null && !StringUtils.isNull(bsVar.getForumName()) && (abVar = bsVar.eay) != null && abVar.dYk && !abVar.dYl && (abVar.type == 1 || abVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bsVar.getForumName(), 12)).append(TbadkCoreApplication.getInst().getString(R.string.forum)).append("、");
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
    public void cXM() {
        MarkData Eo;
        if (cWE() != null && cWE().getPbData() != null) {
            if (com.baidu.tbadk.a.d.bah() || dee() != null) {
                if ((!com.baidu.tbadk.a.d.bah() || deg() != null) && this.kDE != null) {
                    if (cWE().getPbData() != null && cWE().getPbData().cVP()) {
                        Eo = cWE().Eo(0);
                    } else if (this.eiA != null && this.eiA.getCurrentItem() == kVx) {
                        Eo = cWE().o(I(cWE().getPbData()));
                    } else if (com.baidu.tbadk.a.d.bah()) {
                        Eo = cWE().Eo(deg().daR());
                    } else {
                        Eo = cWE().Eo(dee().daR());
                    }
                    if (Eo != null) {
                        if (!Eo.isApp() || (Eo = cWE().Eo(dee().daR() + 1)) != null) {
                            daM();
                            this.kDE.a(Eo);
                            if (!this.kDE.baA()) {
                                this.kDE.baC();
                                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                                return;
                            }
                            this.kDE.baB();
                            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ed(int i) {
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
            if (this.kDu == null) {
                this.kDu = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.kDc);
                this.kDu.b(this.eMA);
                this.kDu.c(this.eMH);
            }
            this.kDu.a(emotionImageData, cWE(), cWE().getPbData());
        }
    }

    public PostData I(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.cVz() != null) {
            return fVar.cVz();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.cVo())) {
            Iterator<PostData> it = fVar.cVo().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dwK() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.cVv();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.beE() != null && postData.beE().getUserTbVipInfoData() != null && postData.beE().getUserTbVipInfoData().getvipIntro() != null) {
            postData.beE().getGodUserData().setIntro(postData.beE().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.cVm() == null || fVar.cVm().beE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData beE = fVar.cVm().beE();
        String userId = beE.getUserId();
        HashMap<String, MetaData> userMap = fVar.cVm().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = beE;
        }
        postData.HP(1);
        postData.setId(fVar.cVm().beV());
        postData.setTitle(fVar.cVm().getTitle());
        postData.setTime(fVar.cVm().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cXR() {
        ArrayList<PostData> cVo;
        int count;
        int i;
        if (cWE() == null || cWE().getPbData() == null || cWE().getPbData().cVo() == null || (count = com.baidu.tbadk.core.util.y.getCount((cVo = cWE().getPbData().cVo()))) == 0) {
            return "";
        }
        if (cWE().cYU()) {
            Iterator<PostData> it = cVo.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dwK() == 1) {
                    return next.getId();
                }
            }
        }
        if (cpl() == null) {
            i = 0;
        } else if (com.baidu.tbadk.a.d.bah()) {
            i = deg().daQ();
        } else {
            i = dee().daQ();
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(cVo, i);
        if (postData == null || postData.beE() == null) {
            return "";
        }
        if (cWE().NB(postData.beE().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(cVo, i2);
            if (postData2 == null || postData2.beE() == null || postData2.beE().getUserId() == null) {
                break;
            } else if (cWE().NB(postData2.beE().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(cVo, i3);
            if (postData3 == null || postData3.beE() == null || postData3.beE().getUserId() == null) {
                return "";
            }
            if (cWE().NB(postData3.beE().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXN() {
        if (cWE() != null) {
            com.baidu.tieba.pb.data.f pbData = cWE().getPbData();
            cWE().tj(true);
            if (this.kDE != null) {
                pbData.Nl(this.kDE.baz());
            }
            if (com.baidu.tbadk.a.d.bah() && deg() != null) {
                deg().deP();
            } else if (dee() != null) {
                dee().deP();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (cWE() != null) {
            daO();
            cWE().tj(z);
            if (this.kDE != null) {
                this.kDE.hB(z);
                if (markData != null) {
                    this.kDE.a(markData);
                }
            }
            if (cWE().baA()) {
                cXN();
            } else if (com.baidu.tbadk.a.d.bah() && deg() != null) {
                deg().deP();
            } else if (dee() != null) {
                dee().deP();
            }
        }
    }

    public void b(p pVar) {
        boolean z;
        MetaData metaData;
        if (cWE() != null && cWE().getPbData() != null && pVar.cWi() != null) {
            String id = pVar.cWi().getId();
            ArrayList<PostData> cVo = cWE().getPbData().cVo();
            int i = 0;
            while (true) {
                if (i >= cVo.size()) {
                    z = true;
                    break;
                }
                PostData postData = cVo.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cWm = pVar.cWm();
                    postData.HO(pVar.getTotalCount());
                    if (postData.dwH() == null || cWm == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = cWm.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.beE() != null && (metaData = postData.getUserMap().get(next.beE().getUserId())) != null) {
                                next.a(metaData);
                                next.we(true);
                                next.a(getPageContext(), cWE().NB(metaData.getUserId()));
                            }
                        }
                        z = cWm.size() != postData.dwH().size();
                        if (postData.dwH() != null && postData.dwH().size() < 2) {
                            postData.dwH().clear();
                            postData.dwH().addAll(cWm);
                        }
                    }
                    if (postData.dwD() != null) {
                        postData.dwE();
                    }
                }
            }
            if (!cWE().getIsFromMark() && z) {
                if (com.baidu.tbadk.a.d.bah() && deg() != null) {
                    deg().deP();
                } else if (dee() != null) {
                    dee().deP();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXE() {
        if (cWE() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.PX(cWE().getForumId()) && cWE().getPbData() != null && cWE().getPbData().getForum() != null) {
            if (cWE().getPbData().getForum().isLike() == 1) {
                cWE().cZi().fK(cWE().getForumId(), cWE().cYC());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            bw cVm = fVar.cVm();
            if (cVm != null && cVm.bdo()) {
                cYl();
            } else {
                d(this.kDR);
            }
            if (this.kDS != null) {
                tC(this.kDS.bsf());
                this.kDS.a(fVar.getAnti());
                this.kDS.a(fVar.getForum(), fVar.getUserData());
                this.kDS.setThreadData(cVm);
                if (cWE() != null) {
                    this.kDS.a(cWE().cYS(), cWE().cYC(), cWE().cZj());
                }
                if (cVm != null) {
                    this.kDS.jq(cVm.bgb());
                }
            }
        }
    }

    public void dar() {
        reset();
        dan();
        this.kMf.cXk();
        tE(false);
    }

    private void reset() {
        if (this.kDS != null && this.aaA != null) {
            com.baidu.tbadk.editortools.pb.a.brU().setStatus(0);
            this.kDS.bsp();
            this.kDS.brH();
            if (this.kDS.getWriteImagesInfo() != null) {
                this.kDS.getWriteImagesInfo().setMaxImagesAllowed(this.kDS.isBJH ? 1 : 9);
            }
            this.kDS.qk(SendView.ALL);
            this.kDS.ql(SendView.ALL);
            h qb = this.aaA.qb(23);
            h qb2 = this.aaA.qb(2);
            h qb3 = this.aaA.qb(5);
            if (qb2 != null) {
                qb2.display();
            }
            if (qb3 != null) {
                qb3.display();
            }
            if (qb != null) {
                qb.hide();
            }
            this.aaA.invalidate();
        }
    }

    public void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cVm() != null) {
            x(fVar);
            this.kLB.setVisibility(fVar.cVP() ? 8 : 0);
            if (fVar.baA()) {
                SvgManager.bjq().a(this.kLB, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bjq().a(this.kLB, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String Ew = Ew(fVar.cVm().bev());
            if (this.kLE != null) {
                this.kLE.setText(Ew);
            }
            if (this.kLF != null) {
                this.kLF.setText(Ew);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.cVm()));
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.aY(fVar.cVm())) {
            if (this.kLD != null) {
                this.kLD.setEnable(false);
                this.kLD.onDestroy();
            }
            SvgManager.bjq().a(this.kLC, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.kLD == null || !this.kLD.isEnable()) {
            SvgManager.bjq().a(this.kLC, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private String Ew(int i) {
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

    public void tE(boolean z) {
        if (this.kLx != null) {
            tC(this.kDS.bsf());
            if (this.kLt) {
                tt(z);
            } else {
                tu(z);
            }
            ddW();
            ddX();
        }
    }

    public void dbp() {
        if (this.kLx != null) {
            this.kLw.setVisibility(8);
            this.kLx.setVisibility(8);
            this.kVU.kWo = false;
            ddW();
            ddX();
        }
    }

    private void ddW() {
        if (this.kVG != null) {
            if (this.kVU.deo()) {
                this.kVG.ve(false);
            } else {
                this.kVG.ve(this.kVG.bNf() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddX() {
        if (this.kVG != null && this.eiA != null) {
            if (com.baidu.tbadk.a.d.bah()) {
                this.kVG.um(false);
            } else if (this.eiA.getCurrentItem() != 0) {
                this.kVG.um(false);
            } else if (this.kVU.deo()) {
                this.kVG.um(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.kVG.um(eVar.dey() == null || eVar.dey().getValue() == null || eVar.dey().getValue().booleanValue());
                }
            }
        }
    }

    private void Ee(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(cYj(), cXD(), i);
    }

    private int cXD() {
        if (cWE() == null || cWE().getPbData() == null || cWE().getPbData().cVm() == null) {
            return -1;
        }
        return cWE().getPbData().cVm().bfr();
    }

    public void tC(boolean z) {
        this.kLt = z;
    }

    public void tt(boolean z) {
        if (this.kLx != null && this.iUa != null) {
            this.iUa.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kLx.startAnimation(alphaAnimation);
            }
            this.kLw.setVisibility(0);
            this.kLx.setVisibility(0);
            this.kVU.kWo = true;
        }
    }

    public void tu(boolean z) {
        if (this.kLx != null && this.iUa != null) {
            this.iUa.setText(dat());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kLx.startAnimation(alphaAnimation);
            }
            this.kLw.setVisibility(0);
            this.kLx.setVisibility(0);
            this.kVU.kWo = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null && this.kxz == null) {
            this.kxz = aVar;
            this.kVL.setText(aVar.getTitle());
            this.kVM.setText(aVar.dfc());
            String dfd = aVar.dfd();
            TBSpecificationBtn tBSpecificationBtn = this.kVO;
            if (TextUtils.isEmpty(dfd)) {
                dfd = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(dfd);
            this.kVP.startLoad(aVar.getImage(), 10, false);
            this.kVQ.setVisibility(aVar.dff() ? 0 : 8);
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.kxz == null || VideoPbFragment.this.kxz.dff()) {
                        if (VideoPbFragment.this.kxz != null && VideoPbFragment.this.cWE() != null && VideoPbFragment.this.cWE().getPbData() != null && VideoPbFragment.this.cWE().getPbData().getForum() != null) {
                            TiebaStatic.log(new aq("c13712").dD("fid", VideoPbFragment.this.cWE().getPbData().getForum().getId()).dD("fname", VideoPbFragment.this.cWE().getPbData().getForum().getName()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", VideoPbFragment.this.cWE().getPbData().getThreadId()).u("obj_param1", VideoPbFragment.this.kxz.userId));
                        }
                    } else {
                        TiebaStatic.log(new aq("c13608").dD("obj_id", VideoPbFragment.this.kxz.getTitle()).dD("obj_name", VideoPbFragment.this.kxz.dfc()).ai("obj_type", 2).dD("fid", VideoPbFragment.this.cWE().getPbData().getForumId()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", VideoPbFragment.this.cWE().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.ddY();
                }
            }, aVar.dfe().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddY() {
        ViewGroup.LayoutParams layoutParams = this.kVJ.getLayoutParams();
        if (layoutParams != null) {
            if (this.kVR == null || !this.kVR.isRunning()) {
                this.kVJ.setAlpha(0.0f);
                this.kVJ.setVisibility(0);
                e(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddZ() {
        if (this.kVJ.getLayoutParams() != null) {
            if (this.kVR == null || !this.kVR.isRunning()) {
                dea();
            }
        }
    }

    private void dea() {
        final ViewGroup.LayoutParams layoutParams = this.kVJ.getLayoutParams();
        if (layoutParams != null) {
            if (this.kVS == null || !this.kVS.isRunning()) {
                this.kVS = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.kVS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.kVJ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.kVS.setDuration(200L);
                this.kVS.start();
                this.kVS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
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
        final ViewGroup.LayoutParams layoutParams2 = this.Xx.getLayoutParams();
        final int i = layoutParams2.height;
        this.kVR = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kVR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.iQv);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.iQv);
                VideoPbFragment.this.kVJ.setLayoutParams(layoutParams);
                VideoPbFragment.this.Xx.setLayoutParams(layoutParams2);
            }
        });
        this.kVR.setDuration(300L);
        this.kVR.start();
        this.kVR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.kVJ.setVisibility(8);
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
        final ViewGroup.LayoutParams layoutParams2 = this.Xx.getLayoutParams();
        final int i = layoutParams2.height;
        this.kVR = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kVR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.iQv);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.kVJ.setLayoutParams(layoutParams);
                VideoPbFragment.this.Xx.setLayoutParams(layoutParams2);
            }
        });
        this.kVR.setDuration(300L);
        this.kVR.start();
        this.kVR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.deb();
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
    public void deb() {
        this.kVR = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kVR.setDuration(300L);
        this.kVR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.kVJ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.kVR.start();
    }

    public String dat() {
        if (!at.isEmpty(this.kMw)) {
            return this.kMw;
        }
        this.kMw = TbadkCoreApplication.getInst().getResources().getString(ay.dai());
        return this.kMw;
    }

    public void daO() {
        hideProgressBar();
        if (com.baidu.tbadk.a.d.bah() && deg() != null) {
            deg().endLoadData();
            deg().daP();
        } else if (dee() != null) {
            dee().endLoadData();
            dee().daP();
        }
    }

    public boolean cM(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bbM().isShowImages()) {
                    return Nx(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (cWE() == null || cWE().getPbData() == null) {
                        return true;
                    }
                    if (this.kMf != null) {
                        this.kMf.cXk();
                    }
                    p pVar = new p();
                    pVar.a(cWE().getPbData().getForum());
                    pVar.setThreadData(cWE().getPbData().cVm());
                    pVar.g(postData);
                    this.kCX.d(pVar);
                    this.kCX.setPostId(postData.getId());
                    a(view, postData.beE().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.kDS != null) {
                        tC(this.kDS.bsf());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void dec() {
        if (this.kDS != null) {
            tC(this.kDS.bsf());
        }
        dar();
        this.kVT.dbf();
    }

    private boolean Nx(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bik().getString("bubble_link", "");
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

    public void cGx() {
        if (this.kLf != null) {
            this.kLf.setVisibility(0);
        }
    }

    public void cGw() {
        if (this.kLf != null) {
            this.kLf.setVisibility(8);
        }
    }

    public void EN(int i) {
        if (this.kVD != null) {
            this.kVD.setVisibility(i);
        }
    }

    public void daM() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a cXH() {
        return this.kEI;
    }

    public void dan() {
        if (this.aaA != null) {
            this.aaA.hide();
        }
    }

    public void cmt() {
        if (this.kDc.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.kDc.getCurrentFocus());
        }
    }

    public void K(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cVm() != null) {
            String valueOf = String.valueOf(fVar.cVm().bev());
            if (fVar.cVm().bev() == 0) {
                valueOf = "";
            }
            this.kVB.CW(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.kVC.dep()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (cWE() != null && cWE().getPbData() != null && cWE().getPbData().cVm() != null && cWE().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(kLY)).intValue();
                if (intValue == kLZ) {
                    if (!this.hkz.dxv()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.hkz.QP(at.R(jSONArray));
                        }
                        this.hkz.a(cWE().getPbData().getForum().getId(), cWE().getPbData().getForum().getName(), cWE().getPbData().cVm().getId(), str, intValue3, intValue2, booleanValue, cWE().getPbData().cVm().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == kMa || intValue == kMc) {
                    if (cWE().cZf() != null) {
                        cWE().cZf().DY(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == kMa) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void em(String str, String str2) {
        be.bju().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int byi() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> byj() {
        if (this.fcr == null) {
            this.fcr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: byv */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bbM().isShowImages();
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
                        if (com.baidu.tbadk.core.k.bbM().isShowImages()) {
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
        return this.fcr;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> byk() {
        if (this.ffJ == null) {
            this.ffJ = TbRichTextView.y(getPageContext().getPageActivity(), 8);
        }
        return this.ffJ;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> byl() {
        if (this.fcs == null) {
            this.fcs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cgz */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bbM().isShowImages();
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
                    if (com.baidu.tbadk.core.k.bbM().isShowImages()) {
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
                    gifView.bsV();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fcs;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bym() {
        if (this.ffK == null) {
            this.ffK = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cYm */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cP */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cQ */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).bPf();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cR */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.ffK;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> byn() {
        if (this.ffL == null) {
            this.ffL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cYo */
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
        return this.ffL;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> byo() {
        this.ffM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cYn */
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
        return this.ffM;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aq(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.kDn = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (com.baidu.tieba.pb.pb.main.be.NN(str) && cWE() != null && cWE().cYC() != null) {
            TiebaStatic.log(new aq("c11664").ai("obj_param1", 1).dD("post_id", cWE().cYC()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.eJF = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
            }
        } else {
            com.baidu.tieba.pb.pb.main.be.dbJ().f(getPageContext(), str);
        }
        this.kDn = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ar(Context context, String str) {
        com.baidu.tieba.pb.pb.main.be.dbJ().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.kDn = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void as(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void at(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void r(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.kVT.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b deL = this.kVT.deL();
            if (deL == null) {
                this.kVT.cXy();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                deL.getItemView(1).setVisibility(8);
            } else {
                deL.getItemView(1).setVisibility(0);
            }
            deL.bhi();
            this.kDn = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void au(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.bju().b(getPageContext(), new String[]{str});
            this.kDn = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a ded() {
        return this.ekH;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bvI() {
        return this.eVH;
    }

    public ReplyFragment dee() {
        if (this.kVC == null || !(this.kVC.EO(kVy) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.kVC.EO(kVy);
    }

    public DetailInfoFragment def() {
        if (this.kVC == null || !(this.kVC.EO(kVx) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.kVC.EO(kVx);
    }

    public DetailInfoAndReplyFragment deg() {
        if (this.kVC == null || !(this.kVC.EO(kVz) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.kVC.EO(kVz);
    }

    public boolean cWu() {
        PbModel cWE = this.kDc.cWE();
        if (cWE == null) {
            return false;
        }
        return cWE.cWu();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cVy;
        PbModel cWE = this.kDc.cWE();
        if (cWE != null && cWE.getPbData() != null && !cWE.getPbData().cVP()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = cWE.getPbData().cVm().getId();
            if (cWE.isShareThread() && cWE.getPbData().cVm().edI != null) {
                historyMessage.threadName = cWE.getPbData().cVm().edI.showText;
            } else {
                historyMessage.threadName = cWE.getPbData().cVm().getTitle();
            }
            if (cWE.isShareThread() && !cWu()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = cWE.getPbData().getForum().getName();
            }
            ArrayList<PostData> cVo = cWE.getPbData().cVo();
            int daQ = dee() != null ? dee().daQ() : 0;
            if (cVo != null && daQ >= 0 && daQ < cVo.size()) {
                historyMessage.postID = cVo.get(daQ).getId();
            }
            historyMessage.isHostOnly = cWE.getHostMode();
            historyMessage.isSquence = cWE.cYE();
            historyMessage.isShareThread = cWE.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.kDS != null) {
            this.kDS.onDestroy();
        }
        if (cWE != null && (cWE.cYF() || cWE.cYH())) {
            Intent intent = new Intent();
            intent.putExtra("tid", cWE.cYC());
            if (this.kDH) {
                if (this.kDJ) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", cWE.ceJ());
                }
                if (this.kDI) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", cWE.getIsGood());
                }
            }
            if (cWE.getPbData() != null && System.currentTimeMillis() - this.kDj >= 40000 && (cVy = cWE.getPbData().cVy()) != null && !com.baidu.tbadk.core.util.y.isEmpty(cVy.getDataList())) {
                intent.putExtra("guess_like_data", cVy);
            }
            PbActivity pbActivity = this.kDc;
            PbActivity pbActivity2 = this.kDc;
            pbActivity.setResult(-1, intent);
        }
        if (cXO()) {
            if (cWE != null) {
                com.baidu.tieba.pb.data.f pbData = cWE.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.kDp) {
                        if (this.kVF != null) {
                            Rect rect = new Rect();
                            this.kVF.getGlobalVisibleRect(rect);
                            as.cZX().h(rect);
                        }
                        as.cZX().Es(this.eiA.getCurrentItem());
                        BdTypeRecyclerView cpl = cpl();
                        Parcelable parcelable = null;
                        if (cpl != null) {
                            parcelable = cpl.onSaveInstanceState();
                        }
                        as.cZX().a(cWE.cYM(), parcelable, cWE.cYE(), cWE.getHostMode(), false);
                    }
                }
            } else {
                as.cZX().reset();
            }
            cWR();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.kVG != null && !this.kVG.bNf()) {
            if ((this.kVG.isFullScreen() && configuration.orientation == 1) || (!this.kVG.isFullScreen() && configuration.orientation == 2)) {
                this.kVG.un(false);
            }
        }
    }

    public boolean deh() {
        if (this.kVG == null) {
            return false;
        }
        return this.kVG.bNf();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.dvJ().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class a {
        public boolean kWo;
        public boolean kWp;

        private a() {
            this.kWp = true;
        }

        public boolean deo() {
            return (this.kWo && this.kWp) ? false : true;
        }
    }

    public void dei() {
        this.kDy = -1;
        this.kDz = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYf() {
        if (cWE() != null && !at.isEmpty(cWE().cYC())) {
            com.baidu.tbadk.BdToken.c.aYs().p(com.baidu.tbadk.BdToken.b.dNJ, com.baidu.adp.lib.f.b.toLong(cWE().cYC(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.kVE.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dej() {
        if (this.kWd == null) {
            this.kWd = ObjectAnimator.ofFloat(this.kVI, "alpha", 0.0f, 1.0f);
            this.kWd.setDuration(200L);
        }
        this.kWd.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dek() {
        if (this.kWe == null) {
            this.kWe = ObjectAnimator.ofFloat(this.kVI, "alpha", 1.0f, 0.0f);
            this.kWe.setDuration(200L);
        }
        this.kWe.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean del() {
        return this.kVG != null && this.kVG.dem();
    }

    public boolean dem() {
        return this.kWa;
    }

    public void uf(boolean z) {
        this.kWa = z;
    }
}
