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
    private AppBarLayout Xv;
    private EditorTools aay;
    private ImageView agf;
    public View eUm;
    private CustomViewPager eiw;
    private com.baidu.adp.lib.d.b<ImageView> fcm;
    private com.baidu.adp.lib.d.b<GifView> fcn;
    private com.baidu.adp.lib.d.b<TextView> ffF;
    private com.baidu.adp.lib.d.b<View> ffG;
    private com.baidu.adp.lib.d.b<LinearLayout> ffH;
    private com.baidu.adp.lib.d.b<RelativeLayout> ffI;
    private ImageView gaa;
    private VoiceManager hSO;
    private com.baidu.tieba.f.b hXK;
    private com.baidu.tieba.frs.profession.permission.c hXk;
    private com.baidu.tieba.callfans.a hkx;
    public am jFx;
    public bb jJC;
    private PbFakeFloorModel kCQ;
    private PbActivity kCV;
    private g kDK;
    private com.baidu.tbadk.editortools.pb.e kDL;
    private com.baidu.tieba.frs.profession.permission.c kDN;
    private EmotionImageData kDO;
    private com.baidu.tbadk.core.view.c kDS;
    private com.baidu.tieba.pb.pb.main.emotion.model.a kDn;
    int kDq;
    private View kKY;
    private int kLA;
    private int kLB;
    private v kLY;
    private View kLp;
    private LinearLayout kLr;
    private HeadImageView kLs;
    private ImageView kLt;
    private ImageView kLu;
    private ImageView kLv;
    private com.baidu.tieba.pb.view.c kLw;
    private TextView kLx;
    private TextView kLy;
    private String kMp;
    public View kQS;
    private f kVA;
    private View kVB;
    private View kVC;
    private TextView kVE;
    private TextView kVF;
    private ImageView kVG;
    private TBSpecificationBtn kVH;
    private TbImageView kVI;
    private View kVJ;
    private ValueAnimator kVK;
    private ValueAnimator kVL;
    public com.baidu.tieba.pb.videopb.b.a kVM;
    private float kVQ;
    private float kVR;
    private boolean kVS;
    private ObjectAnimator kVW;
    private ObjectAnimator kVX;
    private NewPagerSlidingTabBaseStrip kVu;
    private VideoPbFragmentAdapter kVv;
    private View kVw;
    private View kVx;
    private VideoContainerLayout kVy;
    private com.baidu.tieba.pb.videopb.videoView.a kVz;
    private com.baidu.tieba.pb.videopb.c.a kxs;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int kVq = 0;
    public static int kVr = 1;
    public static int kVs = 0;
    public static int kLQ = 3;
    public static int kLR = 0;
    public static int kLS = 3;
    public static int kLT = 4;
    public static int kLU = 5;
    public static int kLV = 6;
    private static final int iQp = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int kVt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a kEL = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void cp(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cWr();
            } else {
                com.baidu.tieba.pb.a.b.cWq();
            }
        }
    };
    private long kDc = 0;
    View.OnClickListener kVD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.kxs == null || VideoPbFragment.this.kxs.dfe()) {
                if (VideoPbFragment.this.kxs != null) {
                    if (VideoPbFragment.this.kxs.isChushou) {
                        VideoPbFragment.this.el(VideoPbFragment.this.kxs.thirdRoomId, VideoPbFragment.this.kxs.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.kxs.dff();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null && VideoPbFragment.this.cWD().getPbData().getForum() != null) {
                        TiebaStatic.log(new aq("c13713").dD("fid", VideoPbFragment.this.cWD().getPbData().getForum().getId()).dD("fname", VideoPbFragment.this.cWD().getPbData().getForum().getName()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", VideoPbFragment.this.cWD().getPbData().getThreadId()).u("obj_param1", VideoPbFragment.this.kxs.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new aq("c13590").dD("obj_id", VideoPbFragment.this.kxs.getTitle()).dD("obj_name", VideoPbFragment.this.kxs.dfb()).ai("obj_type", 2).dD("fid", VideoPbFragment.this.cWD().getPbData().getForumId()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", VideoPbFragment.this.cWD().getPbData().getThreadId()));
            String link = VideoPbFragment.this.kxs.getLink();
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
    private com.baidu.tbadk.baseEditMark.a kDx = null;
    private com.baidu.tbadk.coreExtra.model.a ekD = null;
    private ForumManageModel hkv = null;
    private boolean kDg = false;
    private View kLq = null;
    private TextView iTU = null;
    private boolean kLm = false;
    private String eMt = null;
    private boolean kDA = false;
    private boolean kDB = false;
    private boolean kDC = false;
    private boolean kDi = false;
    int[] kDp = new int[2];
    private int kDr = -1;
    private int kDs = Integer.MIN_VALUE;
    private int kDY = 0;
    private int kVO = Integer.MIN_VALUE;
    private boolean bpE = false;
    private boolean kAY = com.baidu.tbadk.a.d.baf();
    private final PbModel.a kEB = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            h qb;
            VideoPbFragment.this.daN();
            VideoPbFragment.this.cGv();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.tC(false);
            if (z && fVar != null) {
                bw cVl = fVar.cVl();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(fVar, i2);
                VideoPbFragment.this.J(fVar);
                com.baidu.tieba.pb.videopb.c.a cVQ = fVar.cVQ();
                if (cVQ != null && !cVQ.kXO) {
                    VideoPbFragment.this.a(cVQ);
                }
                VideoPbFragment.this.K(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.kDx != null) {
                    VideoPbFragment.this.kDx.hA(fVar.baA());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.eMt = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.eMt) && VideoPbFragment.this.kDL != null && VideoPbFragment.this.kDL.brv() != null && (qb = VideoPbFragment.this.kDL.brv().qb(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.eMt)) {
                        ((View) qb).setOnClickListener(VideoPbFragment.this.eNf);
                    }
                }
                if (VideoPbFragment.this.jFx != null && cVl != null && cVl.beE() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(cVl.beE());
                    VideoPbFragment.this.jFx.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.cWD().cYB());
                        jSONObject.put("fid", VideoPbFragment.this.cWD().getForumId());
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
                if ((!com.baidu.tbadk.a.d.bah() || VideoPbFragment.this.def() != null) && VideoPbFragment.this.ded() != null) {
                    if (com.baidu.tbadk.a.d.bah()) {
                        if (i != -1) {
                            ArrayList<PostData> arrayList = null;
                            if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null) {
                                arrayList = VideoPbFragment.this.cWD().getPbData().cVn();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dwF() == 1)) {
                                if (VideoPbFragment.this.def().cYb()) {
                                    VideoPbFragment.this.def().NI(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.def().NI(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.def().NH(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.def().NH("");
                        }
                        VideoPbFragment.this.def().endLoadData();
                    } else {
                        if (i != -1) {
                            ArrayList<PostData> arrayList2 = null;
                            if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null) {
                                arrayList2 = VideoPbFragment.this.cWD().getPbData().cVn();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 1 && arrayList2.get(0) != null && arrayList2.get(0).dwF() == 1)) {
                                if (VideoPbFragment.this.ded().cYb()) {
                                    VideoPbFragment.this.ded().NI(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.ded().NI(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.ded().NH(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.ded().NH("");
                        }
                        VideoPbFragment.this.ded().endLoadData();
                    }
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.dvE().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0535a kED = new a.InterfaceC0535a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0535a
        public void c(boolean z, boolean z2, String str) {
            VideoPbFragment.this.daN();
            if (z && VideoPbFragment.this.cWD() != null) {
                if (VideoPbFragment.this.kDx != null) {
                    VideoPbFragment.this.kDx.hA(z2);
                }
                VideoPbFragment.this.cWD().th(z2);
                if (VideoPbFragment.this.cWD().baA()) {
                    VideoPbFragment.this.cXM();
                } else if (com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.def() != null) {
                    VideoPbFragment.this.def().deO();
                } else if (VideoPbFragment.this.ded() != null) {
                    VideoPbFragment.this.ded().deO();
                }
                if (z2) {
                    if (VideoPbFragment.this.kDx != null) {
                        if (VideoPbFragment.this.kDx.baD() != null && VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null && VideoPbFragment.this.cWD().getPbData().cVl() != null && VideoPbFragment.this.cWD().getPbData().cVl().beE() != null) {
                            MarkData baD = VideoPbFragment.this.kDx.baD();
                            MetaData beE = VideoPbFragment.this.cWD().getPbData().cVl().beE();
                            if (baD != null && beE != null) {
                                if (!at.equals(TbadkCoreApplication.getCurrentAccount(), beE.getUserId()) && !beE.hadConcerned()) {
                                    VideoPbFragment.this.kVM.b(beE);
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
                    VideoPbFragment.this.cXJ();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b eMx = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean brU() {
            if (VideoPbFragment.this.jJC == null || VideoPbFragment.this.jJC.dbE() == null || !VideoPbFragment.this.jJC.dbE().dFw()) {
                return !VideoPbFragment.this.Ec(am.eky);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.jJC.dbE().dFy());
            if (VideoPbFragment.this.kDL != null && (VideoPbFragment.this.kDL.bsl() || VideoPbFragment.this.kDL.bsm())) {
                VideoPbFragment.this.kDL.a(false, VideoPbFragment.this.jJC.dbH());
            }
            VideoPbFragment.this.jJC.tI(true);
            return true;
        }
    };
    private final CustomMessageListener kEf = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.cWD() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.kDL != null) {
                    VideoPbFragment.this.tA(VideoPbFragment.this.kDL.bse());
                }
                VideoPbFragment.this.daq();
                VideoPbFragment.this.kVM.dbe();
            }
        }
    };
    private CustomMessageListener kEi = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
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
    private final CustomMessageListener hUq = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.bpE) {
                VideoPbFragment.this.cYe();
            }
        }
    };
    private CustomMessageListener kEC = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.cXD();
            }
        }
    };
    private CustomMessageListener kEu = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.64
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.kVM != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kVM.kDT) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.kVM.bWq();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.kVM.getExtra();
                DataRes dataRes = aVar.mtn;
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
                    VideoPbFragment.this.kVM.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.kVM.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener kEs = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.kVM != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kVM.kDT) {
                VideoPbFragment.this.kVM.bWq();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.cWD().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cVB().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.kDS.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.kVM.Cd(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.kVM.cYa();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (at.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.kDS.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener kEt = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.kVM != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kVM.kDT) {
                VideoPbFragment.this.kVM.bWq();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.kDS.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (at.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.kDS.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b kDQ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean brU() {
            if (VideoPbFragment.this.jJC == null || VideoPbFragment.this.jJC.dbF() == null || !VideoPbFragment.this.jJC.dbF().dFw()) {
                return !VideoPbFragment.this.Ec(am.ekz);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.jJC.dbF().dFy());
            if (VideoPbFragment.this.kLY != null && VideoPbFragment.this.kLY.cXn() != null && VideoPbFragment.this.kLY.cXn().bsm()) {
                VideoPbFragment.this.kLY.cXn().a(VideoPbFragment.this.jJC.dbH());
            }
            VideoPbFragment.this.jJC.tJ(true);
            return true;
        }
    };
    private final NewWriteModel.d eMD = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c13268");
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null) {
                    aqVar.dD("fid", VideoPbFragment.this.cWD().getPbData().getForumId());
                }
                aqVar.dD("tid", VideoPbFragment.this.cWD().cYB());
                aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            VideoPbFragment.this.cmr();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.cWD() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.cWD().NC(postWriteCallBackData.getPostId());
                    if (com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.def() != null) {
                        VideoPbFragment.this.kDY = VideoPbFragment.this.def().daP();
                        VideoPbFragment.this.kVO = VideoPbFragment.this.def().deR();
                        VideoPbFragment.this.cWD().cU(VideoPbFragment.this.kDY, VideoPbFragment.this.kVO);
                    } else if (VideoPbFragment.this.ded() != null) {
                        VideoPbFragment.this.kDY = VideoPbFragment.this.ded().daP();
                        VideoPbFragment.this.kVO = VideoPbFragment.this.ded().deR();
                        VideoPbFragment.this.cWD().cU(VideoPbFragment.this.kDY, VideoPbFragment.this.kVO);
                    }
                }
                if (VideoPbFragment.this.eiw != null) {
                    if (com.baidu.tbadk.a.d.bah()) {
                        VideoPbFragment.this.eiw.setCurrentItem(VideoPbFragment.kVs);
                    } else {
                        VideoPbFragment.this.eiw.setCurrentItem(VideoPbFragment.kVr);
                    }
                }
                VideoPbFragment.this.kVM.dbe();
                VideoPbFragment.this.jJC.dbD();
                if (VideoPbFragment.this.kDL != null) {
                    VideoPbFragment.this.tA(VideoPbFragment.this.kDL.bse());
                }
                VideoPbFragment.this.dam();
                VideoPbFragment.this.tC(true);
                VideoPbFragment.this.cWD().cYW();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.def() != null) {
                                VideoPbFragment.this.def().deO();
                            } else if (VideoPbFragment.this.ded() != null) {
                                VideoPbFragment.this.ded().deO();
                            }
                        }
                    } else if (VideoPbFragment.this.cWD().getHostMode()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.cWD().getPbData();
                        if (pbData != null && pbData.cVl() != null && pbData.cVl().beE() != null && (userId = pbData.cVl().beE().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.cWD().cYN()) {
                            VideoPbFragment.this.daL();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.cWD().cYN()) {
                        VideoPbFragment.this.daL();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.sS(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.kDL.bsl() || VideoPbFragment.this.kDL.bsm()) {
                    VideoPbFragment.this.kDL.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.jJC.g(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.jFx != null) {
                    VideoPbFragment.this.jFx.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.zz(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zz(postWriteCallBackData.getErrorString());
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
    private View.OnClickListener eNf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.eMt);
        }
    };
    private CustomMessageListener kEh = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.kDL != null) {
                    VideoPbFragment.this.tA(VideoPbFragment.this.kDL.bse());
                }
                VideoPbFragment.this.tC(false);
            }
        }
    };
    private int kVP = 0;
    private boolean kVT = true;
    private View.OnTouchListener kVU = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.kVP == 1) {
                if (!VideoPbFragment.this.kVT) {
                    VideoPbFragment.this.dei();
                    UtilHelper.showStatusBar(VideoPbFragment.this.cYi(), VideoPbFragment.this.cYi().getRootView());
                    VideoPbFragment.this.kVT = true;
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(VideoPbFragment.this.kVV);
                    com.baidu.adp.lib.f.e.mS().postDelayed(VideoPbFragment.this.kVV, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (VideoPbFragment.this.kVP == 2 && (VideoPbFragment.this.kVT || VideoPbFragment.this.dek())) {
                VideoPbFragment.this.dej();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cYi(), VideoPbFragment.this.cYi().getRootView());
                VideoPbFragment.this.kVT = false;
                if (VideoPbFragment.this.kVz != null) {
                    VideoPbFragment.this.kVz.ud(false);
                }
            }
            VideoPbFragment.this.kVP = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener ieW = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.kVP = 0;
            VideoPbFragment.this.kVQ = 0.0f;
            VideoPbFragment.this.kVR = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.kVQ += f;
            VideoPbFragment.this.kVR += f2;
            if (VideoPbFragment.this.kVP == 0 && !VideoPbFragment.this.kVS && VideoPbFragment.this.kVz != null && !VideoPbFragment.this.kVz.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.kVR) <= Math.abs(VideoPbFragment.this.kVQ) || VideoPbFragment.this.kVR > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.kVR) > Math.abs(VideoPbFragment.this.kVQ) && VideoPbFragment.this.kVR > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.kVP = 2;
                    }
                } else {
                    VideoPbFragment.this.kVP = 1;
                }
            }
            return true;
        }
    };
    private Runnable kVV = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.kVT && !VideoPbFragment.this.dek()) {
                VideoPbFragment.this.dej();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cYi(), VideoPbFragment.this.cYi().getRootView());
                VideoPbFragment.this.kVT = false;
            }
        }
    };
    private final com.baidu.adp.base.d hkC = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.cWD() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.hkv.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.hkv.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.cWD().cYW();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.kSN != 1002 || bVar.ghr) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.Qf, dVar.mhz, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.hkv.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.hkv.getLoadDataMode(), gVar.Qf, gVar.mhz, false);
                    VideoPbFragment.this.kVM.aX(gVar.mhC);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener eVD = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.hXK.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d kEz = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c13268");
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null) {
                    aqVar.dD("fid", VideoPbFragment.this.cWD().getPbData().getForumId());
                }
                if (VideoPbFragment.this.cWD() != null) {
                    aqVar.dD("tid", VideoPbFragment.this.cWD().cYB());
                }
                aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (VideoPbFragment.this.jJC != null) {
                    VideoPbFragment.this.jJC.dbC();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.jFx != null) {
                    VideoPbFragment.this.jFx.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.zz(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zz(postWriteCallBackData.getErrorString());
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
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.jJC != null) {
                if (VideoPbFragment.this.kLY != null && VideoPbFragment.this.kLY.cXn() != null && VideoPbFragment.this.kLY.cXn().bsm()) {
                    VideoPbFragment.this.kLY.cXn().a(postWriteCallBackData);
                }
                VideoPbFragment.this.jJC.h(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c eMw = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void brV() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener aBk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
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
                    aqVar.dD("tid", VideoPbFragment.this.cWD().cYB());
                    aqVar.dD("fid", VideoPbFragment.this.cWD().getForumId());
                    aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.ai("obj_locate", 1);
                    TiebaStatic.log(aqVar);
                    if (VideoPbFragment.this.kDg) {
                        VideoPbFragment.this.kDg = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null && VideoPbFragment.this.kCQ != null && postData.beE() != null && postData.dwF() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.kLY != null) {
                                    VideoPbFragment.this.kLY.cXj();
                                }
                                p pVar = new p();
                                pVar.a(VideoPbFragment.this.cWD().getPbData().getForum());
                                pVar.setThreadData(VideoPbFragment.this.cWD().getPbData().cVl());
                                pVar.g(postData);
                                VideoPbFragment.this.kCQ.d(pVar);
                                VideoPbFragment.this.kCQ.setPostId(postData.getId());
                                VideoPbFragment.this.a(view, postData.beE().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.cWD().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.kDL != null) {
                                    VideoPbFragment.this.tA(VideoPbFragment.this.kDL.bse());
                                }
                            }
                        }
                    }
                } else if ((VideoPbFragment.this.ded() != null && VideoPbFragment.this.ded().dba() != null && view == VideoPbFragment.this.ded().dba()) || ((com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.def() != null && VideoPbFragment.this.def().dba() != null && view == VideoPbFragment.this.def().dba()) || view.getId() == R.id.pb_more)) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.cWD().tf(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        if (com.baidu.tbadk.a.d.bah()) {
                            VideoPbFragment.this.def().daM();
                        } else {
                            VideoPbFragment.this.ded().daM();
                        }
                    }
                } else if (VideoPbFragment.this.kVM != null && VideoPbFragment.this.kVM.dck() != null && view == VideoPbFragment.this.kVM.dck().cZL()) {
                    VideoPbFragment.this.kVM.aRN();
                } else if ((VideoPbFragment.this.kVM != null && ((VideoPbFragment.this.kVM.dck() != null && view == VideoPbFragment.this.kVM.dck().cZM()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) || view.getId() == R.id.floor_owner_reply || view.getId() == R.id.reply_title) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.kVM.dbe();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.cmr();
                        VideoPbFragment.this.daL();
                        if (view.getId() == R.id.owner_reply) {
                            z = VideoPbFragment.this.cWD().z(true, VideoPbFragment.this.cXQ());
                        } else {
                            z = view.getId() == R.id.all_reply ? VideoPbFragment.this.cWD().z(false, VideoPbFragment.this.cXQ()) : VideoPbFragment.this.cWD().Nz(VideoPbFragment.this.cXQ());
                        }
                        view.setTag(Boolean.valueOf(z));
                        if (z) {
                            VideoPbFragment.this.cGw();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.eUm) {
                    if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null) {
                        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            aq aqVar2 = new aq("c13266");
                            aqVar2.dD("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar2.dD("fid", VideoPbFragment.this.cWD().getPbData().getForumId());
                            aqVar2.dD("tid", VideoPbFragment.this.cWD().cYB());
                            aqVar2.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(aqVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.kCV, VideoPbFragment.this.eUm);
                        VideoPbFragment.this.kCV.finish();
                    }
                } else if (view == VideoPbFragment.this.kQS && VideoPbFragment.this.kVM != null) {
                    if (VideoPbFragment.this.cWD() == null || VideoPbFragment.this.cWD().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> cVn = VideoPbFragment.this.cWD().getPbData().cVn();
                    if ((cVn == null || cVn.size() <= 0) && VideoPbFragment.this.cWD().cYD()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new aq("c12378").dD("tid", VideoPbFragment.this.cWD().cYB()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", VideoPbFragment.this.cWD().getForumId()));
                    VideoPbFragment.this.kVM.cXE();
                } else if (VideoPbFragment.this.kVM.dck() != null && view == VideoPbFragment.this.kVM.dck().cZQ()) {
                    if (VideoPbFragment.this.cWD() != null) {
                        VideoPbFragment.this.kVM.dbe();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.cmr();
                            VideoPbFragment.this.daL();
                            VideoPbFragment.this.cWD().Ei(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.kVM != null && VideoPbFragment.this.kVM.dck() != null && view == VideoPbFragment.this.kVM.dck().cZM()) {
                    VideoPbFragment.this.kVM.aRN();
                } else if (VideoPbFragment.this.kVM != null && ((VideoPbFragment.this.kVM.dck() != null && view == VideoPbFragment.this.kVM.dck().cZT()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                    VideoPbFragment.this.kVM.dbe();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.cmr();
                            VideoPbFragment.this.daL();
                            VideoPbFragment.this.kVM.da(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.cWD().cYU()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.kVM != null && VideoPbFragment.this.kVM.dck() != null && view == VideoPbFragment.this.kVM.dck().cZK()) {
                    if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null && VideoPbFragment.this.cWD().getPbData().cVl() != null) {
                        VideoPbFragment.this.kVM.aRN();
                        TiebaStatic.log(new aq("c13062"));
                        VideoPbFragment.this.kVM.Nu(VideoPbFragment.this.cWD().getPbData().cVl().beV());
                    }
                } else if (view.getId() == R.id.pb_floor_feedback) {
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (VideoPbFragment.this.kVM != null) {
                        VideoPbFragment.this.kVM.f(sparseArray);
                    }
                } else if (VideoPbFragment.this.kVM != null && VideoPbFragment.this.kVM.dck() != null && view == VideoPbFragment.this.kVM.dck().cZU()) {
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
                    VideoPbFragment.this.kVM.dcj();
                } else if (VideoPbFragment.this.kVM != null && (view == VideoPbFragment.this.kVM.daJ() || (VideoPbFragment.this.kVM.dck() != null && (view == VideoPbFragment.this.kVM.dck().cZP() || view == VideoPbFragment.this.kVM.dck().cZN())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.cWD() != null || VideoPbFragment.this.cWD().getPbData() != null) {
                        if ((VideoPbFragment.this.cWD().getPbData().cVA() == 1 || VideoPbFragment.this.cWD().getPbData().cVA() == 3) && !VideoPbFragment.this.hkv.dxq()) {
                            VideoPbFragment.this.kVM.dbe();
                            if (VideoPbFragment.this.kVM.dck() != null && view == VideoPbFragment.this.kVM.dck().cZN()) {
                                if (VideoPbFragment.this.cWD().getPbData().cVl().bez() == 1) {
                                    i2 = 5;
                                } else {
                                    i2 = 4;
                                }
                            } else if (VideoPbFragment.this.kVM.dck() != null && view == VideoPbFragment.this.kVM.dck().cZP()) {
                                if (VideoPbFragment.this.cWD().getPbData().cVl().beA() != 1) {
                                    i2 = 6;
                                }
                            } else {
                                i2 = view == VideoPbFragment.this.kVM.daJ() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.cWD().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.cWD().getPbData().cVl().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.hkv.b(id, name, id2, i2, VideoPbFragment.this.kVM.daK());
                        }
                    }
                } else if (VideoPbFragment.this.kVM != null && VideoPbFragment.this.kVM.dck() != null && view == VideoPbFragment.this.kVM.dck().cZS()) {
                    if (VideoPbFragment.this.cWD() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.kVM.dbe();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.cWD().getPbData(), VideoPbFragment.this.cWD().cYD(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.cWD().getPbData().getForum().getId(), VideoPbFragment.this.cWD().getPbData().getForum().getName(), VideoPbFragment.this.cWD().getPbData().cVl().getId(), String.valueOf(VideoPbFragment.this.cWD().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.kVM != null && VideoPbFragment.this.kVM.dck() != null && view == VideoPbFragment.this.kVM.dck().cZO()) {
                    if (VideoPbFragment.this.cWD() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.cWD().getPbData(), VideoPbFragment.this.cWD().cYD(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.kVM.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.kVM.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.kVM.aRN();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        aq aqVar3 = new aq("c13398");
                        aqVar3.dD("tid", VideoPbFragment.this.cWD().cYB());
                        aqVar3.dD("fid", VideoPbFragment.this.cWD().getForumId());
                        aqVar3.dD("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar3.ai("obj_locate", 4);
                        TiebaStatic.log(aqVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new aq("c10517").ai("obj_locate", 3).dD("fid", VideoPbFragment.this.cWD().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null) {
                        if (VideoPbFragment.this.kVM != null) {
                            VideoPbFragment.this.kVM.dbe();
                        }
                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                        PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                        PostData postData3 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                        if (postData2 != null) {
                            if (postData2.dwR() == 1) {
                                TiebaStatic.log(new aq("c12630"));
                            }
                            if (postData2.mfI != null) {
                                aq bjm = postData2.mfI.bjm();
                                bjm.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    bjm.ai("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    bjm.ai("obj_locate", 8);
                                }
                                TiebaStatic.log(bjm);
                            }
                            VideoPbFragment.this.cmr();
                            TiebaStatic.log("c11742");
                            if (postData3 != null) {
                                VideoPbFragment.this.a(postData2, postData3, false, true);
                            } else {
                                VideoPbFragment.this.a(postData2, (PostData) null, false, false);
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                    if (VideoPbFragment.this.cWD() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            aq aqVar4 = new aq("c13398");
                            aqVar4.dD("tid", VideoPbFragment.this.cWD().cYB());
                            aqVar4.dD("fid", VideoPbFragment.this.cWD().getForumId());
                            aqVar4.dD("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar4.ai("obj_locate", 6);
                            TiebaStatic.log(aqVar4);
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData4.mfI != null) {
                                    aq bjm2 = postData4.mfI.bjm();
                                    bjm2.delete("obj_locate");
                                    bjm2.ai("obj_locate", 8);
                                    TiebaStatic.log(bjm2);
                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                    TiebaStatic.log(new aq("c13700").dD("tid", VideoPbFragment.this.cWD().cYC()).dD("fid", VideoPbFragment.this.cWD().getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", postData4.getId()).ai("obj_type", 3));
                                }
                                if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null && VideoPbFragment.this.kCQ != null && postData4.beE() != null && postData4.dwF() != 1) {
                                    if (VideoPbFragment.this.kLY != null) {
                                        VideoPbFragment.this.kLY.cXj();
                                    }
                                    if ((VideoPbFragment.this.kAY || com.baidu.tbadk.a.d.aZV()) && postData4.dwC() != null && postData4.dwC().size() != 0) {
                                        if (com.baidu.tbadk.a.d.aZW()) {
                                            VideoPbFragment.this.a(postData4, (PostData) null, false, false);
                                            return;
                                        } else {
                                            VideoPbFragment.this.a(postData4, (PostData) null, true, false);
                                            return;
                                        }
                                    }
                                    p pVar2 = new p();
                                    pVar2.a(VideoPbFragment.this.cWD().getPbData().getForum());
                                    pVar2.setThreadData(VideoPbFragment.this.cWD().getPbData().cVl());
                                    pVar2.g(postData4);
                                    VideoPbFragment.this.kCQ.d(pVar2);
                                    VideoPbFragment.this.kCQ.setPostId(postData4.getId());
                                    VideoPbFragment.this.a(view, postData4.beE().getUserId(), "", postData4);
                                    if (VideoPbFragment.this.kDL != null) {
                                        VideoPbFragment.this.tA(VideoPbFragment.this.kDL.bse());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.kVM != null && VideoPbFragment.this.cWD() != null) {
                        if (com.baidu.tbadk.a.d.bah() || VideoPbFragment.this.ded() != null) {
                            if (!com.baidu.tbadk.a.d.bah() || VideoPbFragment.this.def() != null) {
                                VideoPbFragment.this.kVM.dbe();
                                if (VideoPbFragment.this.Ed(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.cWD() != null) {
                                    VideoPbFragment.this.cXL();
                                    if (VideoPbFragment.this.cWD().getPbData() != null && VideoPbFragment.this.cWD().getPbData().cVl() != null && VideoPbFragment.this.cWD().getPbData().cVl().beE() != null) {
                                        TiebaStatic.log(new aq("c13402").dD("tid", VideoPbFragment.this.cWD().cYB()).dD("fid", VideoPbFragment.this.cWD().getPbData().getForumId()).ai("obj_locate", 3).dD("uid", VideoPbFragment.this.cWD().getPbData().cVl().beE().getUserId()));
                                    }
                                    if (VideoPbFragment.this.cWD().getPbData().cVl() != null && VideoPbFragment.this.cWD().getPbData().cVl().beE() != null && VideoPbFragment.this.cWD().getPbData().cVl().beE().getUserId() != null && VideoPbFragment.this.kDx != null) {
                                        int h = VideoPbFragment.this.kVM.h(VideoPbFragment.this.cWD().getPbData());
                                        bw cVl = VideoPbFragment.this.cWD().getPbData().cVl();
                                        if (!cVl.bdm()) {
                                            if (cVl.bdn()) {
                                                i = 3;
                                            } else if (cVl.bgz()) {
                                                i = 4;
                                            } else {
                                                i = cVl.bgA() ? 5 : 1;
                                            }
                                        }
                                        TiebaStatic.log(new aq("c12526").dD("tid", VideoPbFragment.this.cWD().cYB()).ai("obj_locate", 1).dD("obj_id", VideoPbFragment.this.cWD().getPbData().cVl().beE().getUserId()).ai("obj_type", VideoPbFragment.this.kDx.baA() ? 0 : 1).ai("obj_source", h).ai("obj_param1", i));
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.ub(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.kVM != null && VideoPbFragment.this.eiw != null && VideoPbFragment.this.cWD().getPbData() != null && VideoPbFragment.this.cWD().getPbData().cVl() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.cWD().getPbData();
                        if (pbData.cVl().bev() != 0) {
                            int currentItem = VideoPbFragment.this.eiw.getCurrentItem();
                            if (!com.baidu.tbadk.a.d.bah() && currentItem == VideoPbFragment.kVq) {
                                VideoPbFragment.this.eiw.setCurrentItem(VideoPbFragment.kVr);
                            } else if (com.baidu.tbadk.a.d.bah() || currentItem == VideoPbFragment.kVr) {
                                if (!com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.ded() == null) {
                                    return;
                                }
                                if ((!com.baidu.tbadk.a.d.bah() || VideoPbFragment.this.def() != null) && VideoPbFragment.this.cpk() != null) {
                                    aq dD = new aq("c13403").dD("tid", VideoPbFragment.this.cWD().cYB()).dD("fid", VideoPbFragment.this.cWD().getPbData().getForumId()).dD("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView cpk = VideoPbFragment.this.cpk();
                                    if (cpk != null) {
                                        boolean canScrollVertically = cpk.canScrollVertically(1);
                                        boolean canScrollVertically2 = cpk.canScrollVertically(-1);
                                        if (VideoPbFragment.this.Xv != null) {
                                            VideoPbFragment.this.Xv.setExpanded(false, true);
                                        }
                                        if (cpk.getLayoutManager() != null && (cpk.getLayoutManager() instanceof LinearLayoutManager)) {
                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) cpk.getLayoutManager();
                                            if (!canScrollVertically2 && canScrollVertically) {
                                                if (VideoPbFragment.this.kDr != -1 || VideoPbFragment.this.kDs != Integer.MIN_VALUE) {
                                                    if (VideoPbFragment.this.kDr > 3 || (VideoPbFragment.this.kDr == 3 && VideoPbFragment.this.kDs < (-equipmentHeight))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.kDr, VideoPbFragment.this.kDs + equipmentHeight);
                                                        cpk.smoothScrollBy(0, equipmentHeight);
                                                    } else if (VideoPbFragment.this.kDr >= 2) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.kDr, VideoPbFragment.this.kDs + (equipmentHeight / 2));
                                                        cpk.smoothScrollBy(0, equipmentHeight / 2);
                                                    } else if (VideoPbFragment.this.kDr == 1) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.kDr, VideoPbFragment.this.kDs + (equipmentHeight / 4));
                                                        cpk.smoothScrollBy(0, equipmentHeight / 4);
                                                    } else {
                                                        cpk.smoothScrollBy(0, -VideoPbFragment.this.kDs);
                                                    }
                                                    dD.ai("obj_locate", 2);
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                int firstVisiblePosition = cpk.getFirstVisiblePosition();
                                                View childAt = cpk.getChildAt(0);
                                                int top = childAt == null ? 0 : childAt.getTop();
                                                VideoPbFragment.this.kDr = firstVisiblePosition;
                                                VideoPbFragment.this.kDs = top;
                                                if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && cpk.getCount() >= 6)) {
                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                    cpk.smoothScrollToPosition(0);
                                                } else {
                                                    cpk.smoothScrollToPosition(0);
                                                }
                                                dD.ai("obj_locate", 1);
                                            }
                                            TiebaStatic.log(dD);
                                            TiebaStatic.log(new aq("c12942").ai("obj_type", 1).ai("obj_locate", 4).dD("tid", VideoPbFragment.this.cWD().cYB()).dD("nid", pbData.cVl().getNid()));
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
                            if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null && VideoPbFragment.this.cWD().getPbData().cVl() != null && VideoPbFragment.this.cWD().getPbData().cVl().beE() != null) {
                                TiebaStatic.log(new aq("c13402").dD("tid", VideoPbFragment.this.cWD().cYB()).dD("fid", VideoPbFragment.this.cWD().getPbData().getForumId()).ai("obj_locate", 2).dD("uid", VideoPbFragment.this.cWD().getPbData().cVl().beE().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.uc(false);
                        VideoPbFragment.this.cXz();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.kDY >= 0) {
                        if (VideoPbFragment.this.cWD() != null) {
                            VideoPbFragment.this.cWD().cZm();
                        }
                        if (com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.def() != null && VideoPbFragment.this.def().deM() != null) {
                            VideoPbFragment.this.def().deM().setData(VideoPbFragment.this.cWD().getPbData());
                        } else if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.ded() != null && VideoPbFragment.this.ded().deM() != null) {
                            VideoPbFragment.this.ded().deM().setData(VideoPbFragment.this.cWD().getPbData());
                        }
                        VideoPbFragment.this.kDY = 0;
                        VideoPbFragment.this.kVO = Integer.MIN_VALUE;
                        if (com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.cWD() != null && VideoPbFragment.this.def() != null) {
                            VideoPbFragment.this.def().cX(VideoPbFragment.this.cWD().cZp(), VideoPbFragment.this.cWD().cZq());
                            VideoPbFragment.this.cWD().cU(0, 0);
                        } else if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.ded() != null) {
                            VideoPbFragment.this.ded().cX(VideoPbFragment.this.cWD().cZp(), VideoPbFragment.this.cWD().cZq());
                            VideoPbFragment.this.cWD().cU(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.cWD() != null) {
                        aq aqVar5 = new aq("c13398");
                        aqVar5.dD("tid", VideoPbFragment.this.cWD().cYB());
                        aqVar5.dD("fid", VideoPbFragment.this.cWD().getForumId());
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
                        VideoPbFragment.this.daq();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.daq();
                } else if (VideoPbFragment.this.kVM.dck() != null && view == VideoPbFragment.this.kVM.dck().cZR()) {
                    VideoPbFragment.this.kVM.dbe();
                    if (VideoPbFragment.this.cWD() != null) {
                        VideoPbFragment.this.hkx.setThreadId(VideoPbFragment.this.cWD().cYB());
                    }
                    if (VideoPbFragment.this.cWD() == null || !VideoPbFragment.this.cWD().isPrivacy()) {
                        VideoPbFragment.this.hkx.cbt();
                        if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null && VideoPbFragment.this.cWD().getPbData().getThreadId() != null && VideoPbFragment.this.cWD().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                            i3 = 2;
                        }
                        if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null) {
                            VideoPbFragment.this.hkx.i(3, i3, VideoPbFragment.this.cWD().getPbData().getThreadId());
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                    if (VideoPbFragment.this.cWD().getPbData() != null) {
                        VideoPbFragment.this.hkx.i(3, 3, VideoPbFragment.this.cWD().getPbData().getThreadId());
                    }
                }
            }
        }
    };
    private View.OnClickListener kAq = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.kVM != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.kVM.c(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.kVM.cT(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.kVM.c(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.kVM.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    public SortSwitchButton.a kEx = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean xL(int i) {
            if (VideoPbFragment.this.kVM != null) {
                VideoPbFragment.this.kVM.dbe();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.cWD() == null || VideoPbFragment.this.cWD().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.cmr();
                VideoPbFragment.this.daL();
                if (VideoPbFragment.this.cWD().getPbData() != null && VideoPbFragment.this.cWD().getPbData().kwH != null && VideoPbFragment.this.cWD().getPbData().kwH.size() > i) {
                    int intValue = VideoPbFragment.this.cWD().getPbData().kwH.get(i).sort_type.intValue();
                    TiebaStatic.log(new aq("c13699").dD("tid", VideoPbFragment.this.cWD().cYC()).dD("fid", VideoPbFragment.this.cWD().getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).ai("obj_type", Eg(intValue)));
                    if (VideoPbFragment.this.cWD().En(intValue)) {
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
    private a kVN = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void cXJ() {
        if (cWD() != null && cWD().getPbData() != null && cWD().getPbData().cVl() != null) {
            bw cVl = cWD().getPbData().cVl();
            cVl.mRecomAbTag = cWD().cZw();
            cVl.mRecomWeight = cWD().cZu();
            cVl.mRecomSource = cWD().cZv();
            cVl.mRecomExtra = cWD().cZx();
            if (cVl.getFid() == 0) {
                cVl.setFid(com.baidu.adp.lib.f.b.toLong(cWD().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cVl, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sS(boolean z) {
        if (cWD() != null && cWD().getPbData() != null && cWD().getPbData().cVl() != null) {
            bw cVl = cWD().getPbData().cVl();
            cVl.mRecomAbTag = cWD().cZw();
            cVl.mRecomWeight = cWD().cZu();
            cVl.mRecomSource = cWD().cZv();
            cVl.mRecomExtra = cWD().cZx();
            if (cVl.getFid() == 0) {
                cVl.setFid(com.baidu.adp.lib.f.b.toLong(cWD().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cVl, "c13563");
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
            String string = !TextUtils.isEmpty(bVar.mhz) ? bVar.mhz : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.zz(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.m39if(true);
                aVar.b(getPageContext());
                aVar.bhg();
            } else {
                a(0, bVar.Qf, bVar.mhz, z);
            }
            if (bVar.Qf) {
                if (bVar.hzG == 1) {
                    ArrayList<PostData> cVn = cWD().getPbData().cVn();
                    int size = cVn.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cVn.get(i).getId())) {
                            i++;
                        } else {
                            cVn.remove(i);
                            break;
                        }
                    }
                    cWD().getPbData().cVl().ng(cWD().getPbData().cVl().bev() - 1);
                    if (com.baidu.tbadk.a.d.bah() && def() != null) {
                        def().deO();
                    } else if (ded() != null) {
                        ded().deO();
                    }
                } else if (bVar.hzG == 0) {
                    cXK();
                } else if (bVar.hzG == 2) {
                    ArrayList<PostData> cVn2 = cWD().getPbData().cVn();
                    int size2 = cVn2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cVn2.get(i2).dwC().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cVn2.get(i2).dwC().get(i3).getId())) {
                                i3++;
                            } else {
                                cVn2.get(i2).dwC().remove(i3);
                                cVn2.get(i2).dwE();
                                z2 = true;
                                break;
                            }
                        }
                        cVn2.get(i2).QN(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        if (com.baidu.tbadk.a.d.bah() && def() != null) {
                            def().deO();
                        } else if (ded() != null) {
                            ded().deO();
                        }
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = cWD().getPbData().cVz().kyo;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dwC().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dwC().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dwC().remove(i2);
                    list.get(i).dwE();
                    z = true;
                    break;
                }
            }
            list.get(i).QN(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            if (com.baidu.tbadk.a.d.bah() && def() != null) {
                def().deO();
            } else if (ded() != null) {
                ded().deO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && cWD() != null && cWD().getPbData() != null && cWD().getPbData().cVl() != null) {
            a(this.hkv.getLoadDataMode(), gVar.Qf, gVar.mhz, false);
            if (gVar.Qf) {
                this.kDA = true;
                if (i == 2 || i == 3) {
                    this.kDB = true;
                    this.kDC = false;
                } else if (i == 4 || i == 5) {
                    this.kDB = false;
                    this.kDC = true;
                }
                if (i == 2) {
                    cWD().getPbData().cVl().nj(1);
                    cWD().setIsGood(1);
                } else if (i == 3) {
                    cWD().getPbData().cVl().nj(0);
                    cWD().setIsGood(0);
                } else if (i == 4) {
                    cWD().getPbData().cVl().ni(1);
                    cWD().Eh(1);
                } else if (i == 5) {
                    cWD().getPbData().cVl().ni(0);
                    cWD().Eh(0);
                }
            }
            if (cWD().getPbData().cVl() != null && dee() != null) {
                dee().deY();
            }
        }
    }

    private void cXK() {
        if (cWD().cYE() || cWD().cYG()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", cWD().cYB());
            PbActivity pbActivity = this.kCV;
            PbActivity pbActivity2 = this.kCV;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, cWD().cYB()));
        if (cXN()) {
            this.kCV.finish();
        }
    }

    private boolean cXN() {
        if (cWD() == null) {
            return true;
        }
        if (cWD().getPbData() == null || !cWD().getPbData().cVO()) {
            if (cWD().baA()) {
                final MarkData cYV = cWD().cYV();
                if (cYV == null || !cWD().getIsFromMark() || cpk() == null) {
                    return true;
                }
                final MarkData Eo = cWD().Eo(cpk().getFirstVisiblePosition());
                if (Eo == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cYV);
                    this.kCV.setResult(-1, intent);
                    return true;
                } else if (Eo.getPostId() == null || Eo.getPostId().equals(cYV.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cYV);
                    this.kCV.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.zz(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.kDx != null) {
                                if (VideoPbFragment.this.kDx.baA()) {
                                    VideoPbFragment.this.kDx.baB();
                                    VideoPbFragment.this.kDx.hA(false);
                                }
                                VideoPbFragment.this.kDx.a(Eo);
                                VideoPbFragment.this.kDx.hA(true);
                                VideoPbFragment.this.kDx.baC();
                            }
                            cYV.setPostId(Eo.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cYV);
                            VideoPbFragment.this.kCV.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cWQ();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cYV);
                            VideoPbFragment.this.kCV.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cWQ();
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
            } else if (cWD().getPbData() == null || cWD().getPbData().cVn() == null || cWD().getPbData().cVn().size() <= 0 || !cWD().getIsFromMark()) {
                return true;
            } else {
                this.kCV.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWQ() {
        this.kCV.cWQ();
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
    public void ub(boolean z) {
        com.baidu.tieba.pb.data.f pbData;
        int i;
        if (cWD() != null && this.kVM != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = cWD().getPbData()) != null) {
                bw cVl = pbData.cVl();
                if (cVl != null && cVl.beE() != null) {
                    TiebaStatic.log(new aq("c13402").dD("tid", cWD().cYB()).dD("fid", pbData.getForumId()).ai("obj_locate", 4).dD("uid", cVl.beE().getUserId()));
                }
                if (cVl != null) {
                    if (cVl.bdm()) {
                        i = 2;
                    } else if (cVl.bdn()) {
                        i = 3;
                    } else if (cVl.bgz()) {
                        i = 4;
                    } else if (cVl.bgA()) {
                        i = 5;
                    }
                    aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    aqVar.dD("tid", cWD().cYB());
                    aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dD("fid", cWD().getForumId());
                    if (!z) {
                        aqVar.ai("obj_locate", 6);
                    } else {
                        aqVar.ai("obj_locate", 5);
                    }
                    aqVar.ai("obj_name", i);
                    aqVar.ai("obj_type", 2);
                    if (cVl != null) {
                        if (cVl.bdm()) {
                            aqVar.ai("obj_type", 10);
                        } else if (cVl.bdn()) {
                            aqVar.ai("obj_type", 9);
                        } else if (cVl.bgA()) {
                            aqVar.ai("obj_type", 8);
                        } else if (cVl.bgz()) {
                            aqVar.ai("obj_type", 7);
                        } else if (cVl.isShareThread) {
                            aqVar.ai("obj_type", 6);
                        } else if (cVl.threadType == 0) {
                            aqVar.ai("obj_type", 1);
                        } else if (cVl.threadType == 40) {
                            aqVar.ai("obj_type", 2);
                        } else if (cVl.threadType == 49) {
                            aqVar.ai("obj_type", 3);
                        } else if (cVl.threadType == 54) {
                            aqVar.ai("obj_type", 4);
                        } else {
                            aqVar.ai("obj_type", 5);
                        }
                        aqVar.dD("nid", cVl.getNid());
                        aqVar.ai(IntentConfig.CARD_TYPE, cVl.bgD());
                        aqVar.dD(IntentConfig.RECOM_SOURCE, cVl.mRecomSource);
                        aqVar.dD("ab_tag", cVl.mRecomAbTag);
                        aqVar.dD("weight", cVl.mRecomWeight);
                        aqVar.dD("extra", cVl.mRecomExtra);
                        aqVar.dD("nid", cVl.getNid());
                        if (cVl.getBaijiahaoData() != null && !at.isEmpty(cVl.getBaijiahaoData().oriUgcVid)) {
                            aqVar.dD("obj_param6", cVl.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (cYi() != null) {
                        com.baidu.tbadk.pageInfo.c.b(cYi(), aqVar);
                    }
                    TiebaStatic.log(aqVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (cWD().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> cVn = pbData.cVn();
                        if ((cVn == null || cVn.size() <= 0) && cWD().cYD()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.kVM.dbe();
                        cmr();
                        TiebaStatic.log(new aq("c11939"));
                        if (!AntiHelper.d(getContext(), cVl)) {
                            if (this.kLw != null) {
                                this.kLw.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                Ee(z ? 2 : 1);
                                return;
                            }
                            this.kVM.showLoadingDialog();
                            cWD().cZg().A(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                aq aqVar2 = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar2.dD("tid", cWD().cYB());
                aqVar2.dD("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.dD("fid", cWD().getForumId());
                if (!z) {
                }
                aqVar2.ai("obj_name", i);
                aqVar2.ai("obj_type", 2);
                if (cVl != null) {
                }
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (cYi() != null) {
                }
                TiebaStatic.log(aqVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment ddK() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        J(eVar.deq());
        K(eVar.deq());
        if (cWD() != null && cWD().getPbData() != null) {
            boolean isFromMark = cWD().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = cWD().getPbData();
            if (isFromMark) {
                PostData I = I(pbData);
                if (pbData.baz() != null && !pbData.baz().equals(I.getId()) && this.eiw != null) {
                    if (com.baidu.tbadk.a.d.bah()) {
                        this.eiw.setCurrentItem(kVs);
                    } else {
                        this.eiw.setCurrentItem(kVr);
                    }
                }
            }
        }
        eVar.der().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aN */
            public void onChanged(@Nullable bw bwVar) {
                BdTypeRecyclerView cpk;
                if (bwVar != null && bwVar.beW() != null) {
                    if (VideoPbFragment.this.kVz.getVideoUrl() == null || !VideoPbFragment.this.kVz.getVideoUrl().equals(bwVar.beW().video_url)) {
                        if (!at.isEmpty(VideoPbFragment.this.kVz.getVideoUrl())) {
                            VideoPbFragment.this.kDi = true;
                            if (com.baidu.tbadk.a.d.bah()) {
                                VideoPbFragment.this.eiw.setCurrentItem(VideoPbFragment.kVs);
                            } else {
                                VideoPbFragment.this.eiw.setCurrentItem(VideoPbFragment.kVq);
                            }
                            if (com.baidu.tbadk.a.d.bah() && (cpk = VideoPbFragment.this.cpk()) != null) {
                                cpk.scrollToPosition(0);
                            }
                        }
                        if (VideoPbFragment.this.kVA == null || !VideoPbFragment.this.kVA.isPlaying()) {
                            VideoPbFragment.this.ddL();
                            VideoPbFragment.this.aM(bwVar);
                        }
                        VideoPbFragment.this.ddM();
                        if (VideoPbFragment.this.kVA.deE()) {
                            VideoPbFragment.this.kVA.start();
                        }
                        boolean z = !at.equals(VideoPbFragment.this.kVz.getVideoUrl(), bwVar.beW().video_url);
                        VideoPbFragment.this.kVz.setData(bwVar);
                        if (com.baidu.tbadk.a.d.bah()) {
                            VideoPbFragment.this.kVz.uk(false);
                        } else {
                            VideoPbFragment.this.kVz.uk(VideoPbFragment.this.eiw.getCurrentItem() == 0);
                        }
                        if (z) {
                            VideoPbFragment.this.kVz.startPlay();
                            VideoPbFragment.this.kVz.dfq();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.kVz.setData(bwVar);
                }
            }
        });
        eVar.deA().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: q */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.eiw.setCurrentItem(num.intValue());
            }
        });
        eVar.dev().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aN */
            public void onChanged(@Nullable bw bwVar) {
                VideoPbFragment.this.kVz.aR(bwVar);
            }
        });
        eVar.dew().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aN */
            public void onChanged(@Nullable bw bwVar) {
                VideoPbFragment.this.kVz.aS(bwVar);
            }
        });
        eVar.dex().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: p */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.ddW();
            }
        });
        eVar.dey().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: p */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddL() {
        ViewGroup.LayoutParams layoutParams = this.kVC.getLayoutParams();
        layoutParams.height = 0;
        this.kVC.setLayoutParams(layoutParams);
        this.kVC.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddM() {
        if (this.kVA == null) {
            this.kVA = new f(getBaseFragmentActivity(), this.kVy);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(cYi()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.kVy.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.kVA.b(eVar.des(), rect);
            if (this.kVA.deE()) {
                this.kVA.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (com.baidu.tbadk.a.d.bah()) {
                            if (eVar.det() || VideoPbFragment.this.cWD().getTabIndex() == VideoPbFragment.kVs) {
                                VideoPbFragment.this.eiw.setCurrentItem(VideoPbFragment.kVs);
                            }
                        } else if (eVar.det() || VideoPbFragment.this.cWD().getTabIndex() == VideoPbFragment.kVr) {
                            VideoPbFragment.this.eiw.setCurrentItem(VideoPbFragment.kVr);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (com.baidu.tbadk.a.d.bah()) {
                            if (eVar.det() || VideoPbFragment.this.cWD().getTabIndex() == VideoPbFragment.kVs) {
                                VideoPbFragment.this.eiw.setCurrentItem(VideoPbFragment.kVs);
                            }
                        } else if (eVar.det() || VideoPbFragment.this.cWD().getTabIndex() == VideoPbFragment.kVr) {
                            VideoPbFragment.this.eiw.setCurrentItem(VideoPbFragment.kVr);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (com.baidu.tbadk.a.d.bah()) {
                if (eVar.det() || cWD().getTabIndex() == kVs) {
                    this.eiw.setCurrentItem(kVs);
                }
            } else if (eVar.det() || cWD().getTabIndex() == kVr) {
                this.eiw.setCurrentItem(kVr);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.kVS && (this.kVT || dek())) {
            dej();
            UtilHelper.hideStatusBar(cYi(), cYi().getRootView());
            this.kVT = false;
            if (this.kVz != null) {
                this.kVz.ud(false);
            }
        }
        if (i == 4) {
            return this.kVz.dkx();
        }
        if (i == 24) {
            return this.kVz.dfn();
        }
        if (i == 25) {
            return this.kVz.dfo();
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
        Rect cZy;
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
                int height = (cWD() != null || (cZy = cWD().cZy()) == null) ? ceil : cZy.height();
                i = 0;
                layoutParams = this.kVy.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.kVy.setLayoutParams(layoutParams);
                this.kVy.setMaxHeight(ceil);
                this.kVy.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.kVy.setOriginHeight(height);
                if (!com.baidu.tbadk.a.d.bah()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.kVu.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, kVt);
                    } else {
                        layoutParams3.height = kVt;
                    }
                    this.kVu.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.Xv.getLayoutParams();
                if (!com.baidu.tbadk.a.d.bah()) {
                    ceil += kVt;
                }
                if (layoutParams2 != null) {
                    layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                } else {
                    layoutParams2.height = ceil;
                }
                this.Xv.setLayoutParams(layoutParams2);
                if (i == 0 && (this.Xv.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.Xv.getLayoutParams()).getBehavior();
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
        if (cWD() != null) {
        }
        i = 0;
        layoutParams = this.kVy.getLayoutParams();
        if (layoutParams != null) {
        }
        this.kVy.setLayoutParams(layoutParams);
        this.kVy.setMaxHeight(ceil2);
        this.kVy.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.kVy.setOriginHeight(height);
        if (!com.baidu.tbadk.a.d.bah()) {
        }
        layoutParams2 = (CoordinatorLayout.LayoutParams) this.Xv.getLayoutParams();
        if (!com.baidu.tbadk.a.d.bah()) {
        }
        if (layoutParams2 != null) {
        }
        this.Xv.setLayoutParams(layoutParams2);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.kDc = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        ar(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.kDS = new com.baidu.tbadk.core.view.c();
        this.kDS.toastTime = 1000L;
        if (this.kVM != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.kVM.kDT;
            userMuteAddAndDelCustomMessage.setTag(this.kVM.kDT);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.kVM.kDT;
            userMuteCheckCustomMessage.setTag(this.kVM.kDT);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.hkx = new com.baidu.tieba.callfans.a(getPageContext());
        com.baidu.tieba.s.c.dvE().A(getUniqueId());
    }

    private void initData() {
        this.kDx = com.baidu.tbadk.baseEditMark.a.a(this.kCV);
        if (this.kDx != null) {
            this.kDx.a(this.kED);
        }
        this.hkv = new ForumManageModel(this.kCV);
        this.hkv.setLoadDataCallBack(this.hkC);
        this.ekD = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.kVM = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void ar(Bundle bundle) {
        this.kDK = new g();
        d(this.kDK);
        this.kDL = (com.baidu.tbadk.editortools.pb.e) this.kDK.ec(getActivity());
        this.kDL.a(this.kCV.getPageContext());
        this.kDL.a(this.eMD);
        this.kDL.a(this.eMw);
        this.kDL.a(this.kCV.getPageContext(), bundle);
        this.kDL.brv().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.kDL.brv().jh(true);
        sR(true);
        this.kDL.a(cWD().cYR(), cWD().cYB(), cWD().cZi());
        registerListener(this.kEi);
        registerListener(this.kEC);
        registerListener(this.kEh);
        registerListener(this.kEf);
        registerListener(this.hUq);
        if (!cWD().cYI()) {
            this.kDL.BY(cWD().cYB());
        }
        if (cWD().cZj()) {
            this.kDL.BW(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.kDL.BW(das());
        }
        this.jJC = new bb();
        if (this.kDL.brW() != null) {
            this.jJC.f(this.kDL.brW().getInputView());
        }
        this.kDL.a(this.eMx);
        this.jFx = new am(getPageContext());
        this.jFx.a(new am.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == am.eky) {
                        VideoPbFragment.this.kDL.a((String) null, (WriteData) null);
                    } else if (i == am.ekz && VideoPbFragment.this.kLY != null && VideoPbFragment.this.kLY.cXn() != null) {
                        VideoPbFragment.this.kLY.cXn().bsu();
                    } else if (i == am.ekA) {
                        VideoPbFragment.this.c(VideoPbFragment.this.kDO);
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
        this.hXK = new com.baidu.tieba.f.b(getActivity());
        this.hXK.a(kEL);
        this.kVS = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        buO();
        this.Xv = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.kVw = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.kVy = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.kVz = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.kVy);
        this.kVz.setStageType("2002");
        this.kVz.setUniqueId(getUniqueId());
        this.kVz.af(this);
        this.kVz.db(cYi().getRootView());
        this.kVz.dc(this.kVB);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.kVu = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.kVC = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.eiw = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.kVx = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.kVx.setOnClickListener(this.aBk);
        ddO();
        ddN();
        ddP();
        this.kVv = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.eiw.setAdapter(this.kVv);
        this.kVu.setViewPager(this.eiw);
        this.kVu.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.def() != null) {
                        VideoPbFragment.this.def().uj(false);
                    } else if (VideoPbFragment.this.ded() != null) {
                        VideoPbFragment.this.ded().uj(false);
                    }
                    if (VideoPbFragment.this.dee() != null) {
                        VideoPbFragment.this.dee().uj(true);
                        VideoPbFragment.this.EN(VideoPbFragment.this.dee().deS() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.dex() != null && eVar.dex().getValue() != null && eVar.dex().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.kVz.uk(z);
                    VideoPbFragment.this.daq();
                    if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null) {
                        TiebaStatic.log(new aq("c13592").dD("tid", VideoPbFragment.this.cWD().cYB()).dD("fid", VideoPbFragment.this.cWD().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.dee() != null) {
                        VideoPbFragment.this.dee().uj(false);
                    }
                    if (com.baidu.tbadk.a.d.bah() && VideoPbFragment.this.def() != null) {
                        VideoPbFragment.this.def().uj(true);
                        int deS = VideoPbFragment.this.def().deS();
                        int deT = VideoPbFragment.this.def().deT();
                        if (deS != 0) {
                            VideoPbFragment.this.EN(8);
                            VideoPbFragment.this.def().EN(0);
                        } else if (deT != 0) {
                            VideoPbFragment.this.def().EN(8);
                            VideoPbFragment.this.EN(0);
                        } else {
                            VideoPbFragment.this.def().EN(8);
                            VideoPbFragment.this.EN(8);
                        }
                    } else if (VideoPbFragment.this.ded() != null) {
                        VideoPbFragment.this.ded().uj(true);
                        int deS2 = VideoPbFragment.this.ded().deS();
                        int deT2 = VideoPbFragment.this.ded().deT();
                        if (deS2 != 0) {
                            VideoPbFragment.this.EN(8);
                            VideoPbFragment.this.ded().EN(0);
                        } else if (deT2 != 0) {
                            VideoPbFragment.this.ded().EN(8);
                            VideoPbFragment.this.EN(0);
                        } else {
                            VideoPbFragment.this.ded().EN(8);
                            VideoPbFragment.this.EN(8);
                        }
                    }
                    VideoPbFragment.this.kVz.uk(false);
                    VideoPbFragment.this.Xv.setExpanded(false, true);
                    if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null) {
                        TiebaStatic.log(new aq("c13593").dD("tid", VideoPbFragment.this.cWD().cYB()).dD("fid", VideoPbFragment.this.cWD().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.kVv.EP(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.kKY = this.rootView.findViewById(R.id.viewstub_progress);
        ddQ();
        bKS();
        if (!this.kVS && this.kVT) {
            dej();
            UtilHelper.hideStatusBar(cYi(), cYi().getRootView());
            this.kVT = false;
        }
        if (com.baidu.tbadk.a.d.bah()) {
            this.kVu.getLayoutParams().height = 0;
        }
    }

    private void ddN() {
        this.kVE = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.kVI = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.kVF = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.kVG = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.kVH = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.kVJ = this.rootView.findViewById(R.id.ala_live_point);
        this.kVI.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.kVI.setConrers(15);
        this.kVH.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.kVG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.kxs == null || VideoPbFragment.this.kxs.dfe()) {
                    if (VideoPbFragment.this.kxs != null) {
                        TiebaStatic.log(new aq("c13608").dD("tid", VideoPbFragment.this.cWD().getPbData().getThreadId()));
                        VideoPbFragment.this.kxs.kXO = true;
                    }
                } else {
                    TiebaStatic.log(new aq("c13591"));
                }
                VideoPbFragment.this.ddY();
            }
        });
        this.kVH.setOnClickListener(this.kVD);
        this.kVC.setOnClickListener(this.kVD);
    }

    private void ddO() {
        this.kVu.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.kVu.setContainerLayoutParams(layoutParams);
        this.kVu.setRectPaintColor(R.color.cp_link_tip_a);
        this.kVu.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.kVu.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.kVu.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.kVu.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.kVu.setExpandedTabLayoutParams(layoutParams2);
    }

    public void uc(boolean z) {
        if (this.Xv != null) {
            this.Xv.setExpanded(z);
        }
    }

    private void ddP() {
        this.kLp = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.kLq = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.kLA = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.kLB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.kLs = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.kLs.setVisibility(0);
        this.kLs.setIsRound(true);
        this.kLs.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
        this.kLs.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.kLs.setPlaceHolder(1);
        this.kLs.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.kLs.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        this.iTU = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.kLr = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.kLr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.uc(false);
                VideoPbFragment.this.cXz();
                if (VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null && VideoPbFragment.this.cWD().getPbData().cVl() != null && VideoPbFragment.this.cWD().getPbData().cVl().beE() != null) {
                    TiebaStatic.log(new aq("c13701").dD("tid", VideoPbFragment.this.cWD().cYC()).dD("fid", VideoPbFragment.this.cWD().getPbData().getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new aq("c13402").dD("tid", VideoPbFragment.this.cWD().cYB()).dD("fid", VideoPbFragment.this.cWD().getPbData().getForumId()).ai("obj_locate", 1).dD("uid", VideoPbFragment.this.cWD().getPbData().cVl().beE().getUserId()));
                }
            }
        });
        this.kLt = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.kLt.setOnClickListener(this.aBk);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.kLu = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.kLu.setOnClickListener(this.aBk);
        if (booleanExtra) {
            this.kLu.setVisibility(8);
        } else {
            this.kLu.setVisibility(0);
        }
        this.kLv = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.kLv.setOnClickListener(this.aBk);
        this.kLw = new com.baidu.tieba.pb.view.c(this.kLv);
        this.kLw.dfA();
        this.kLx = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.kLx.setVisibility(0);
        tC(false);
    }

    private void buO() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cms();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.kVB = this.rootView.findViewById(R.id.status_bar_background);
        if (this.kVS) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(cYi());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.kVB.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(cYi());
            this.kVB.setLayoutParams(layoutParams2);
            this.kVB.setVisibility(0);
        }
        this.eUm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aBk);
        this.gaa = (ImageView) this.eUm.findViewById(R.id.widget_navi_back_button);
        SvgManager.bjq().a(this.gaa, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.kQS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aBk);
        this.agf = (ImageView) this.kQS.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.kQS.setLayoutParams(layoutParams3);
        SvgManager.bjq().a(this.agf, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.kQS.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.ieW);
        this.mNavigationBar.setOnTouchListener(this.kVU);
    }

    public void ddQ() {
        setEditorTools(this.kDL.brv());
    }

    private void bKS() {
        this.kCQ = new PbFakeFloorModel(getPageContext());
        this.kLY = new v(getPageContext(), this.kCQ, this.rootView);
        this.kLY.T(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.daq();
            }
        });
        this.kLY.a(this.kEz);
        this.kCQ.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.kCQ.t(postData);
                if (com.baidu.tbadk.a.d.bah() || VideoPbFragment.this.def() != null) {
                    VideoPbFragment.this.def().deO();
                } else if (VideoPbFragment.this.ded() != null) {
                    VideoPbFragment.this.ded().deO();
                }
                VideoPbFragment.this.kLY.cXj();
                VideoPbFragment.this.aay.bpX();
                VideoPbFragment.this.tC(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, PostData postData2, boolean z, boolean z2) {
        PbActivity.a Nx;
        String cYB = cWD().cYB();
        String id = postData.getId();
        String str = "";
        if (postData2 != null) {
            str = postData2.getId();
        }
        int i = 0;
        if (cWD().getPbData() != null) {
            i = cWD().getPbData().cVA();
        }
        if (ded() != null && ded().deQ() != null) {
            Nx = ded().deQ().Nx(id);
        } else if (def() != null && def().deQ() != null) {
            Nx = def().deQ().Nx(id);
        } else {
            return;
        }
        if (postData != null && cWD() != null && cWD().getPbData() != null && Nx != null) {
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(cYB, id, "pb", true, null, false, str, i, postData.ddj(), cWD().getPbData().getAnti(), false, postData.beE().getIconInfo()).addBigImageData(Nx.kzL, Nx.dUO, Nx.dUM, Nx.index);
            if (z2) {
                addBigImageData.setHighLightPostId(str);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(cWD().getForumId());
            addBigImageData.setBjhData(cWD().cYK());
            addBigImageData.setKeyPageStartFrom(cWD().cZl());
            addBigImageData.setFromFrsForumId(cWD().getFromForumId());
            addBigImageData.setIsOpenEditor(z);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.kCV = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (cWD() != null) {
            cWD().aC(bundle);
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
        this.bpE = true;
        getVoiceManager().onPause(getPageContext());
        this.kVz.pN(true);
        if (cWD() != null && !cWD().cYI()) {
            this.kDL.BX(cWD().cYB());
        }
        com.baidu.tbadk.BdToken.c.aYs().aYC();
        MessageManager.getInstance().unRegisterListener(this.kEs);
        MessageManager.getInstance().unRegisterListener(this.kEt);
        MessageManager.getInstance().unRegisterListener(this.kEu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bpE = false;
        getVoiceManager().onResume(getPageContext());
        this.kVz.pN(false);
        cYe();
        registerListener(this.kEs);
        registerListener(this.kEt);
        registerListener(this.kEu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.kVv != null && this.eiw != null) {
            this.kVv.EP(z ? this.eiw.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (this.kLs != null) {
            this.kLs.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.dvE().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dvE().B(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.kLw != null) {
            this.kLw.onDestroy();
        }
        if (this.hkv != null) {
            this.hkv.cancelLoadData();
        }
        if (this.kVz != null) {
            this.kVz.onDestroy();
        }
        if (this.kDn != null) {
            this.kDn.cancelLoadData();
        }
        if (this.jFx != null) {
            this.jFx.onDestroy();
        }
        if (cWD() != null) {
            cWD().cancelLoadData();
            cWD().destory();
            if (cWD().cZf() != null) {
                cWD().cZf().onDestroy();
            }
        }
        if (this.kDL != null) {
            this.kDL.onDestroy();
        }
        this.kDS = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.kCV);
        this.kVu.onChangeSkinType();
        ap.setBackgroundColor(this.kVu, R.color.cp_bg_line_h);
        this.jJC.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.kVA == null || !this.kVA.isPlaying()) {
            ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        ap.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        ap.setBackgroundColor(this.kVB, R.color.cp_mask_b_alpha66);
        if (this.aay != null) {
            this.aay.onChangeSkinType(i);
        }
        if (this.kLY != null) {
            this.kLY.onChangeSkinType(i);
        }
        if (this.iTU != null) {
            ap.setViewTextColor(this.iTU, R.color.cp_cont_d);
        }
        if (this.kLs != null) {
            this.kLs.setBorderColor(ap.getColor(R.color.cp_border_a));
        }
        if (this.kLr != null) {
            this.kLr.setBackgroundDrawable(ap.aO(l.getDimens(getContext(), R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
        }
        if (this.kLu != null && cWD() != null) {
            if (cWD().baA()) {
                SvgManager.bjq().a(this.kLu, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bjq().a(this.kLu, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.kLt != null) {
            SvgManager.bjq().a(this.kLt, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (cWD() != null) {
            x(cWD().getPbData());
        }
        if (this.kLx != null) {
            ap.c(this.kLx, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_cont_h, R.color.cp_cont_h);
            ap.setViewTextColor(this.kLx, R.color.cp_cont_a);
        }
        if (this.kLy != null) {
            ap.setViewTextColor(this.kLy, R.color.cp_cont_b);
        }
        if (this.kLp != null) {
            ap.setBackgroundResource(this.kLp, R.drawable.bottom_shadow);
        }
        ap.setBackgroundColor(this.kLq, R.color.cp_bg_line_h);
        if (com.baidu.tbadk.a.d.bah() && def() != null) {
            def().onChangeSkinType(i);
        } else if (ded() != null) {
            ded().onChangeSkinType(i);
        }
        if (dee() != null) {
            dee().onChangeSkinType(i);
        }
        if (this.kVw != null) {
            ap.setBackgroundResource(this.kVw, R.drawable.personalize_tab_shadow);
        }
        if (this.kVC != null) {
            ap.setBackgroundColor(this.kVC, R.color.cp_bg_line_g);
        }
        if (this.kVG != null) {
            SvgManager.bjq().a(this.kVG, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.kVE != null) {
            ap.setViewTextColor(this.kVE, R.color.cp_cont_b);
        }
        if (this.kVF != null) {
            ap.setViewTextColor(this.kVF, R.color.cp_cont_d);
        }
        if (this.kVJ != null) {
            this.kVJ.setBackgroundDrawable(ap.aO(l.getDimens(this.kVJ.getContext(), R.dimen.tbds32), ap.getColor(R.color.cp_other_c)));
        }
        cmr();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hSO == null) {
            this.hSO = VoiceManager.instance();
        }
        return this.hSO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmr() {
        if (this.hSO != null) {
            this.hSO.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cYg() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cYh() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel cWD() {
        return this.kCV.cWD();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cYi() {
        return this.kCV;
    }

    public com.baidu.tbadk.baseEditMark.a ddR() {
        return this.kDx;
    }

    public View.OnClickListener ddS() {
        return this.aBk;
    }

    public View.OnClickListener ddT() {
        return this.kAq;
    }

    public View.OnLongClickListener ddU() {
        return this.kVM.ddU();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (com.baidu.tieba.pb.pb.main.be.NM(objArr[i].getLink()) && (drawable = ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView cpk() {
        Iterator<BaseFragment> it = this.kVv.deo().iterator();
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

    private void sR(boolean z) {
        this.kDL.jl(z);
        this.kDL.jm(z);
        this.kDL.jn(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.kVM != null) {
            if (z) {
                this.kVM.dbe();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.kVM.dbf();
            } else {
                this.kVM.dbe();
            }
        }
    }

    public boolean Ec(int i) {
        if (this.jFx == null || cWD() == null || cWD().getPbData() == null || cWD().getPbData().getAnti() == null) {
            return true;
        }
        return this.jFx.aN(cWD().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean cXB() {
        if ((cWD() != null && cWD().getPbData().cVO()) || this.jFx == null || cWD() == null || cWD().getPbData() == null || cWD().getPbData().getAnti() == null) {
            return true;
        }
        return this.jFx.nP(cWD().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && cWD() != null) {
            gVar.setForumName(cWD().cWu());
            if (cWD().getPbData() != null && cWD().getPbData().getForum() != null) {
                gVar.a(cWD().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(cWD());
        }
    }

    public void daG() {
        if (this.aay != null) {
            this.aay.display();
            if (this.kDL != null) {
                this.kDL.bsb();
            }
            dbo();
        }
    }

    public com.baidu.tbadk.editortools.pb.e cXo() {
        return this.kDL;
    }

    private boolean cXy() {
        PbModel cWD = cWD();
        if (cWD == null || cWD.getPbData() == null) {
            return false;
        }
        bw cVl = cWD.getPbData().cVl();
        cWD.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cVl);
    }

    public void cXz() {
        if (checkUpIsLogin() && cWD() != null && cWD().getPbData() != null && cWD().getPbData().getForum() != null && !cXy()) {
            if (cWD().getPbData().cVO()) {
                czd();
                return;
            }
            if (this.hXk == null) {
                this.hXk = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hXk.yr(0);
                this.hXk.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void ou(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void z(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void ov(boolean z) {
                        if (z) {
                            if (VideoPbFragment.this.kDL != null && VideoPbFragment.this.kDL.brv() != null) {
                                VideoPbFragment.this.kDL.brv().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            VideoPbFragment.this.czd();
                        }
                    }
                });
            }
            this.hXk.C(cWD().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cWD().cYB(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.kDL.onActivityResult(i, i2, intent);
        if (this.kDn != null) {
            this.kDn.onActivityResult(i, i2, intent);
        }
        if (this.kLY != null) {
            this.kLY.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cXL();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dmM().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.kDO = emotionImageData;
                        if (Ec(am.ekA)) {
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
        if (cYi() != null) {
            if (this.kVT && !TbSingleton.getInstance().isNotchScreen(cYi()) && !TbSingleton.getInstance().isCutoutScreen(cYi())) {
                dej();
                UtilHelper.hideStatusBar(cYi(), cYi().getRootView());
                this.kVT = false;
            }
            this.kVN.kWi = z;
            ddV();
            ddW();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.kCV;
        if (i == 0) {
            dam();
            if (this.kLY != null) {
                this.kLY.cXj();
            }
            tC(false);
        }
        daq();
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
                        this.kDL.resetData();
                        this.kDL.setVoiceModel(pbEditorData.getVoiceModel());
                        this.kDL.b(writeData);
                        m qe = this.kDL.brv().qe(6);
                        if (qe != null && qe.eKx != null) {
                            qe.eKx.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.kCV;
                        if (i == -1) {
                            this.kDL.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.kLY != null && this.kLY.cXn() != null) {
                            com.baidu.tbadk.editortools.pb.h cXn = this.kLY.cXn();
                            cXn.setThreadData(cWD().getPbData().cVl());
                            cXn.b(writeData);
                            cXn.setVoiceModel(pbEditorData.getVoiceModel());
                            m qe2 = cXn.brv().qe(6);
                            if (qe2 != null && qe2.eKx != null) {
                                qe2.eKx.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.kCV;
                            if (i == -1) {
                                cXn.bsu();
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
                if (cWD() != null && !cWD().cYI()) {
                    antiData.setBlock_forum_name(cWD().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(cWD().getPbData().getForum().getId());
                    antiData.setUser_name(cWD().getPbData().getUserData().getUserName());
                    antiData.setUser_id(cWD().getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bz(i, str)) {
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
            if (this.kVM != null) {
                this.kVM.Cd(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void cYk() {
        if (cWD() != null && this.kCV != null) {
            if (this.kDL == null || !this.kDL.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.kDL = (com.baidu.tbadk.editortools.pb.e) dVar.ec(getContext());
                this.kDL.a(this.kCV.getPageContext());
                this.kDL.a(this.eMD);
                this.kDL.a(this.eMw);
                this.kDL.a(this.kCV.getPageContext(), this.kCV.getIntent() == null ? null : this.kCV.getIntent().getExtras());
                this.kDL.brv().jh(true);
                setEditorTools(this.kDL.brv());
                if (!cWD().cYI()) {
                    this.kDL.BY(cWD().cYB());
                }
                if (cWD().cZj()) {
                    this.kDL.BW(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.kDL.BW(das());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.aay = editorTools;
        this.aay.setId(R.id.pb_editor);
        this.aay.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.daq();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.aay.getParent() == null) {
            this.rootView.addView(this.aay, layoutParams);
        }
        this.aay.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.aay.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43
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
                            VideoPbFragment.this.kDL.c((t) aVar.data);
                            VideoPbFragment.this.kDL.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dam();
        this.kDL.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.aay != null && VideoPbFragment.this.aay.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.jJC != null && VideoPbFragment.this.jJC.dbE() != null) {
                    if (!VideoPbFragment.this.jJC.dbE().dFx()) {
                        VideoPbFragment.this.jJC.tI(false);
                    }
                    VideoPbFragment.this.jJC.dbE().wY(false);
                }
            }
        });
    }

    public void czd() {
        if (!checkUpIsLogin()) {
            if (cWD() != null) {
                TiebaStatic.log(new aq("c10517").ai("obj_locate", 2).dD("fid", cWD().getForumId()));
            }
        } else if (cXB()) {
            if (this.kDL != null && (this.kDL.bsl() || this.kDL.bsm())) {
                this.kDL.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.aay != null) {
                daG();
                this.kVN.kWh = false;
                if (this.aay.qe(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.aay.qe(2).eKx, false, null);
                }
            }
            dbo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !cXy() && cXB()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.kDp);
                this.kDq = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.kLY != null && postData != null) {
                String str3 = "";
                if (postData.dwH() != null) {
                    str3 = postData.dwH().toString();
                }
                this.kLY.Nr(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.beE().getName_show(), str3));
            }
            if (cWD() != null && cWD().getPbData() != null && cWD().getPbData().cVO()) {
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.kCV.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.kDp[1] + VideoPbFragment.this.kDq) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cpk() != null) {
                            VideoPbFragment.this.cpk().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.kLY != null) {
                            VideoPbFragment.this.kDL.brv().setVisibility(8);
                            VideoPbFragment.this.kLY.g(str, str2, VideoPbFragment.this.das(), (VideoPbFragment.this.cWD() == null || VideoPbFragment.this.cWD().getPbData() == null || VideoPbFragment.this.cWD().getPbData().cVl() == null || !VideoPbFragment.this.cWD().getPbData().cVl().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cXn = VideoPbFragment.this.kLY.cXn();
                            if (cXn != null && VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null) {
                                cXn.a(VideoPbFragment.this.cWD().getPbData().getAnti());
                                cXn.setThreadData(VideoPbFragment.this.cWD().getPbData().cVl());
                            }
                            if (VideoPbFragment.this.jJC.dbG() == null && VideoPbFragment.this.kLY.cXn().bsC() != null) {
                                VideoPbFragment.this.kLY.cXn().bsC().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.jJC != null && VideoPbFragment.this.jJC.dbF() != null) {
                                            if (!VideoPbFragment.this.jJC.dbF().dFx()) {
                                                VideoPbFragment.this.jJC.tJ(false);
                                            }
                                            VideoPbFragment.this.jJC.dbF().wY(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.jJC.g(VideoPbFragment.this.kLY.cXn().bsC().getInputView());
                                VideoPbFragment.this.kLY.cXn().a(VideoPbFragment.this.kDQ);
                            }
                        }
                        VideoPbFragment.this.dbo();
                    }
                }, 0L);
                return;
            }
            if (this.kDN == null) {
                this.kDN = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.kDN.yr(1);
                this.kDN.a(new AnonymousClass47(str, str2));
            }
            if (cWD() != null && cWD().getPbData() != null && cWD().getPbData().getForum() != null) {
                this.kDN.C(cWD().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cWD().cYB(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$47  reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass47 implements c.a {
        final /* synthetic */ String kEV;
        final /* synthetic */ String kEW;

        AnonymousClass47(String str, String str2) {
            this.kEV = str;
            this.kEW = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ou(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ov(boolean z) {
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
                        int i = (VideoPbFragment.this.kDp[1] + VideoPbFragment.this.kDq) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cpk() != null) {
                            VideoPbFragment.this.cpk().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.kLY != null) {
                            VideoPbFragment.this.kDL.brv().setVisibility(8);
                            VideoPbFragment.this.kLY.g(AnonymousClass47.this.kEV, AnonymousClass47.this.kEW, VideoPbFragment.this.das(), (VideoPbFragment.this.cWD() == null || VideoPbFragment.this.cWD().getPbData() == null || VideoPbFragment.this.cWD().getPbData().cVl() == null || !VideoPbFragment.this.cWD().getPbData().cVl().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cXn = VideoPbFragment.this.kLY.cXn();
                            if (cXn != null && VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null) {
                                cXn.a(VideoPbFragment.this.cWD().getPbData().getAnti());
                                cXn.setThreadData(VideoPbFragment.this.cWD().getPbData().cVl());
                            }
                            if (VideoPbFragment.this.jJC.dbG() == null && VideoPbFragment.this.kLY.cXn().bsC() != null) {
                                VideoPbFragment.this.kLY.cXn().bsC().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.jJC != null && VideoPbFragment.this.jJC.dbF() != null) {
                                            if (!VideoPbFragment.this.jJC.dbF().dFx()) {
                                                VideoPbFragment.this.jJC.tJ(false);
                                            }
                                            VideoPbFragment.this.jJC.dbF().wY(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.jJC.g(VideoPbFragment.this.kLY.cXn().bsC().getInputView());
                                VideoPbFragment.this.kLY.cXn().a(VideoPbFragment.this.kDQ);
                            }
                        }
                        VideoPbFragment.this.dbo();
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cVA()));
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cVA()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bs> cVI = fVar.cVI();
                if (com.baidu.tbadk.core.util.y.getCount(cVI) > 0) {
                    sb = new StringBuilder();
                    for (bs bsVar : cVI) {
                        if (bsVar != null && !StringUtils.isNull(bsVar.getForumName()) && (abVar = bsVar.eau) != null && abVar.dYg && !abVar.dYh && (abVar.type == 1 || abVar.type == 2)) {
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
    public void cXL() {
        MarkData Eo;
        if (cWD() != null && cWD().getPbData() != null) {
            if (com.baidu.tbadk.a.d.bah() || ded() != null) {
                if ((!com.baidu.tbadk.a.d.bah() || def() != null) && this.kDx != null) {
                    if (cWD().getPbData() != null && cWD().getPbData().cVO()) {
                        Eo = cWD().Eo(0);
                    } else if (this.eiw != null && this.eiw.getCurrentItem() == kVq) {
                        Eo = cWD().o(I(cWD().getPbData()));
                    } else if (com.baidu.tbadk.a.d.bah()) {
                        Eo = cWD().Eo(def().daQ());
                    } else {
                        Eo = cWD().Eo(ded().daQ());
                    }
                    if (Eo != null) {
                        if (!Eo.isApp() || (Eo = cWD().Eo(ded().daQ() + 1)) != null) {
                            daL();
                            this.kDx.a(Eo);
                            if (!this.kDx.baA()) {
                                this.kDx.baC();
                                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                                return;
                            }
                            this.kDx.baB();
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
            if (this.kDn == null) {
                this.kDn = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.kCV);
                this.kDn.b(this.eMw);
                this.kDn.c(this.eMD);
            }
            this.kDn.a(emotionImageData, cWD(), cWD().getPbData());
        }
    }

    public PostData I(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.cVy() != null) {
            return fVar.cVy();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.cVn())) {
            Iterator<PostData> it = fVar.cVn().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dwF() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.cVu();
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
        if (fVar == null || fVar.cVl() == null || fVar.cVl().beE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData beE = fVar.cVl().beE();
        String userId = beE.getUserId();
        HashMap<String, MetaData> userMap = fVar.cVl().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = beE;
        }
        postData.HP(1);
        postData.setId(fVar.cVl().beV());
        postData.setTitle(fVar.cVl().getTitle());
        postData.setTime(fVar.cVl().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cXQ() {
        ArrayList<PostData> cVn;
        int count;
        int i;
        if (cWD() == null || cWD().getPbData() == null || cWD().getPbData().cVn() == null || (count = com.baidu.tbadk.core.util.y.getCount((cVn = cWD().getPbData().cVn()))) == 0) {
            return "";
        }
        if (cWD().cYT()) {
            Iterator<PostData> it = cVn.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dwF() == 1) {
                    return next.getId();
                }
            }
        }
        if (cpk() == null) {
            i = 0;
        } else if (com.baidu.tbadk.a.d.bah()) {
            i = def().daP();
        } else {
            i = ded().daP();
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(cVn, i);
        if (postData == null || postData.beE() == null) {
            return "";
        }
        if (cWD().NA(postData.beE().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(cVn, i2);
            if (postData2 == null || postData2.beE() == null || postData2.beE().getUserId() == null) {
                break;
            } else if (cWD().NA(postData2.beE().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(cVn, i3);
            if (postData3 == null || postData3.beE() == null || postData3.beE().getUserId() == null) {
                return "";
            }
            if (cWD().NA(postData3.beE().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXM() {
        if (cWD() != null) {
            com.baidu.tieba.pb.data.f pbData = cWD().getPbData();
            cWD().th(true);
            if (this.kDx != null) {
                pbData.Nk(this.kDx.baz());
            }
            if (com.baidu.tbadk.a.d.bah() && def() != null) {
                def().deO();
            } else if (ded() != null) {
                ded().deO();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (cWD() != null) {
            daN();
            cWD().th(z);
            if (this.kDx != null) {
                this.kDx.hA(z);
                if (markData != null) {
                    this.kDx.a(markData);
                }
            }
            if (cWD().baA()) {
                cXM();
            } else if (com.baidu.tbadk.a.d.bah() && def() != null) {
                def().deO();
            } else if (ded() != null) {
                ded().deO();
            }
        }
    }

    public void b(p pVar) {
        boolean z;
        MetaData metaData;
        if (cWD() != null && cWD().getPbData() != null && pVar.cWh() != null) {
            String id = pVar.cWh().getId();
            ArrayList<PostData> cVn = cWD().getPbData().cVn();
            int i = 0;
            while (true) {
                if (i >= cVn.size()) {
                    z = true;
                    break;
                }
                PostData postData = cVn.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cWl = pVar.cWl();
                    postData.HO(pVar.getTotalCount());
                    if (postData.dwC() == null || cWl == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = cWl.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.beE() != null && (metaData = postData.getUserMap().get(next.beE().getUserId())) != null) {
                                next.a(metaData);
                                next.wc(true);
                                next.a(getPageContext(), cWD().NA(metaData.getUserId()));
                            }
                        }
                        z = cWl.size() != postData.dwC().size();
                        if (postData.dwC() != null && postData.dwC().size() < 2) {
                            postData.dwC().clear();
                            postData.dwC().addAll(cWl);
                        }
                    }
                    if (postData.dwy() != null) {
                        postData.dwz();
                    }
                }
            }
            if (!cWD().getIsFromMark() && z) {
                if (com.baidu.tbadk.a.d.bah() && def() != null) {
                    def().deO();
                } else if (ded() != null) {
                    ded().deO();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXD() {
        if (cWD() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.PX(cWD().getForumId()) && cWD().getPbData() != null && cWD().getPbData().getForum() != null) {
            if (cWD().getPbData().getForum().isLike() == 1) {
                cWD().cZh().fJ(cWD().getForumId(), cWD().cYB());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            bw cVl = fVar.cVl();
            if (cVl != null && cVl.bdo()) {
                cYk();
            } else {
                d(this.kDK);
            }
            if (this.kDL != null) {
                tA(this.kDL.bse());
                this.kDL.a(fVar.getAnti());
                this.kDL.a(fVar.getForum(), fVar.getUserData());
                this.kDL.setThreadData(cVl);
                if (cWD() != null) {
                    this.kDL.a(cWD().cYR(), cWD().cYB(), cWD().cZi());
                }
                if (cVl != null) {
                    this.kDL.jo(cVl.bgb());
                }
            }
        }
    }

    public void daq() {
        reset();
        dam();
        this.kLY.cXj();
        tC(false);
    }

    private void reset() {
        if (this.kDL != null && this.aay != null) {
            com.baidu.tbadk.editortools.pb.a.brT().setStatus(0);
            this.kDL.bso();
            this.kDL.brG();
            if (this.kDL.getWriteImagesInfo() != null) {
                this.kDL.getWriteImagesInfo().setMaxImagesAllowed(this.kDL.isBJH ? 1 : 9);
            }
            this.kDL.qk(SendView.ALL);
            this.kDL.ql(SendView.ALL);
            h qb = this.aay.qb(23);
            h qb2 = this.aay.qb(2);
            h qb3 = this.aay.qb(5);
            if (qb2 != null) {
                qb2.display();
            }
            if (qb3 != null) {
                qb3.display();
            }
            if (qb != null) {
                qb.hide();
            }
            this.aay.invalidate();
        }
    }

    public void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cVl() != null) {
            x(fVar);
            this.kLu.setVisibility(fVar.cVO() ? 8 : 0);
            if (fVar.baA()) {
                SvgManager.bjq().a(this.kLu, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bjq().a(this.kLu, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String Ew = Ew(fVar.cVl().bev());
            if (this.kLx != null) {
                this.kLx.setText(Ew);
            }
            if (this.kLy != null) {
                this.kLy.setText(Ew);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.cVl()));
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.aY(fVar.cVl())) {
            if (this.kLw != null) {
                this.kLw.setEnable(false);
                this.kLw.onDestroy();
            }
            SvgManager.bjq().a(this.kLv, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.kLw == null || !this.kLw.isEnable()) {
            SvgManager.bjq().a(this.kLv, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void tC(boolean z) {
        if (this.kLq != null) {
            tA(this.kDL.bse());
            if (this.kLm) {
                tr(z);
            } else {
                ts(z);
            }
            ddV();
            ddW();
        }
    }

    public void dbo() {
        if (this.kLq != null) {
            this.kLp.setVisibility(8);
            this.kLq.setVisibility(8);
            this.kVN.kWh = false;
            ddV();
            ddW();
        }
    }

    private void ddV() {
        if (this.kVz != null) {
            if (this.kVN.den()) {
                this.kVz.vc(false);
            } else {
                this.kVz.vc(this.kVz.bNe() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddW() {
        if (this.kVz != null && this.eiw != null) {
            if (com.baidu.tbadk.a.d.bah()) {
                this.kVz.uk(false);
            } else if (this.eiw.getCurrentItem() != 0) {
                this.kVz.uk(false);
            } else if (this.kVN.den()) {
                this.kVz.uk(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.kVz.uk(eVar.dex() == null || eVar.dex().getValue() == null || eVar.dex().getValue().booleanValue());
                }
            }
        }
    }

    private void Ee(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(cYi(), cXC(), i);
    }

    private int cXC() {
        if (cWD() == null || cWD().getPbData() == null || cWD().getPbData().cVl() == null) {
            return -1;
        }
        return cWD().getPbData().cVl().bfr();
    }

    public void tA(boolean z) {
        this.kLm = z;
    }

    public void tr(boolean z) {
        if (this.kLq != null && this.iTU != null) {
            this.iTU.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kLq.startAnimation(alphaAnimation);
            }
            this.kLp.setVisibility(0);
            this.kLq.setVisibility(0);
            this.kVN.kWh = true;
        }
    }

    public void ts(boolean z) {
        if (this.kLq != null && this.iTU != null) {
            this.iTU.setText(das());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kLq.startAnimation(alphaAnimation);
            }
            this.kLp.setVisibility(0);
            this.kLq.setVisibility(0);
            this.kVN.kWh = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null && this.kxs == null) {
            this.kxs = aVar;
            this.kVE.setText(aVar.getTitle());
            this.kVF.setText(aVar.dfb());
            String dfc = aVar.dfc();
            TBSpecificationBtn tBSpecificationBtn = this.kVH;
            if (TextUtils.isEmpty(dfc)) {
                dfc = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(dfc);
            this.kVI.startLoad(aVar.getImage(), 10, false);
            this.kVJ.setVisibility(aVar.dfe() ? 0 : 8);
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.kxs == null || VideoPbFragment.this.kxs.dfe()) {
                        if (VideoPbFragment.this.kxs != null && VideoPbFragment.this.cWD() != null && VideoPbFragment.this.cWD().getPbData() != null && VideoPbFragment.this.cWD().getPbData().getForum() != null) {
                            TiebaStatic.log(new aq("c13712").dD("fid", VideoPbFragment.this.cWD().getPbData().getForum().getId()).dD("fname", VideoPbFragment.this.cWD().getPbData().getForum().getName()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", VideoPbFragment.this.cWD().getPbData().getThreadId()).u("obj_param1", VideoPbFragment.this.kxs.userId));
                        }
                    } else {
                        TiebaStatic.log(new aq("c13608").dD("obj_id", VideoPbFragment.this.kxs.getTitle()).dD("obj_name", VideoPbFragment.this.kxs.dfb()).ai("obj_type", 2).dD("fid", VideoPbFragment.this.cWD().getPbData().getForumId()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", VideoPbFragment.this.cWD().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.ddX();
                }
            }, aVar.dfd().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddX() {
        ViewGroup.LayoutParams layoutParams = this.kVC.getLayoutParams();
        if (layoutParams != null) {
            if (this.kVK == null || !this.kVK.isRunning()) {
                this.kVC.setAlpha(0.0f);
                this.kVC.setVisibility(0);
                e(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddY() {
        if (this.kVC.getLayoutParams() != null) {
            if (this.kVK == null || !this.kVK.isRunning()) {
                ddZ();
            }
        }
    }

    private void ddZ() {
        final ViewGroup.LayoutParams layoutParams = this.kVC.getLayoutParams();
        if (layoutParams != null) {
            if (this.kVL == null || !this.kVL.isRunning()) {
                this.kVL = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.kVL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.kVC.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.kVL.setDuration(200L);
                this.kVL.start();
                this.kVL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
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
        final ViewGroup.LayoutParams layoutParams2 = this.Xv.getLayoutParams();
        final int i = layoutParams2.height;
        this.kVK = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kVK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.iQp);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.iQp);
                VideoPbFragment.this.kVC.setLayoutParams(layoutParams);
                VideoPbFragment.this.Xv.setLayoutParams(layoutParams2);
            }
        });
        this.kVK.setDuration(300L);
        this.kVK.start();
        this.kVK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.kVC.setVisibility(8);
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
        final ViewGroup.LayoutParams layoutParams2 = this.Xv.getLayoutParams();
        final int i = layoutParams2.height;
        this.kVK = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kVK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.iQp);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.kVC.setLayoutParams(layoutParams);
                VideoPbFragment.this.Xv.setLayoutParams(layoutParams2);
            }
        });
        this.kVK.setDuration(300L);
        this.kVK.start();
        this.kVK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.dea();
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
    public void dea() {
        this.kVK = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kVK.setDuration(300L);
        this.kVK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.kVC.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.kVK.start();
    }

    public String das() {
        if (!at.isEmpty(this.kMp)) {
            return this.kMp;
        }
        this.kMp = TbadkCoreApplication.getInst().getResources().getString(ay.dah());
        return this.kMp;
    }

    public void daN() {
        hideProgressBar();
        if (com.baidu.tbadk.a.d.bah() && def() != null) {
            def().endLoadData();
            def().daO();
        } else if (ded() != null) {
            ded().endLoadData();
            ded().daO();
        }
    }

    public boolean cM(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bbM().isShowImages()) {
                    return Nw(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (cWD() == null || cWD().getPbData() == null) {
                        return true;
                    }
                    if (this.kLY != null) {
                        this.kLY.cXj();
                    }
                    p pVar = new p();
                    pVar.a(cWD().getPbData().getForum());
                    pVar.setThreadData(cWD().getPbData().cVl());
                    pVar.g(postData);
                    this.kCQ.d(pVar);
                    this.kCQ.setPostId(postData.getId());
                    a(view, postData.beE().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.kDL != null) {
                        tA(this.kDL.bse());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void deb() {
        if (this.kDL != null) {
            tA(this.kDL.bse());
        }
        daq();
        this.kVM.dbe();
    }

    private boolean Nw(String str) {
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

    public void cGw() {
        if (this.kKY != null) {
            this.kKY.setVisibility(0);
        }
    }

    public void cGv() {
        if (this.kKY != null) {
            this.kKY.setVisibility(8);
        }
    }

    public void EN(int i) {
        if (this.kVw != null) {
            this.kVw.setVisibility(i);
        }
    }

    public void daL() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a cXG() {
        return this.kEB;
    }

    public void dam() {
        if (this.aay != null) {
            this.aay.hide();
        }
    }

    public void cms() {
        if (this.kCV.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.kCV.getCurrentFocus());
        }
    }

    public void K(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cVl() != null) {
            String valueOf = String.valueOf(fVar.cVl().bev());
            if (fVar.cVl().bev() == 0) {
                valueOf = "";
            }
            this.kVu.CV(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.kVv.deo()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (cWD() != null && cWD().getPbData() != null && cWD().getPbData().cVl() != null && cWD().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(kLR)).intValue();
                if (intValue == kLS) {
                    if (!this.hkv.dxq()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.hkv.QP(at.R(jSONArray));
                        }
                        this.hkv.a(cWD().getPbData().getForum().getId(), cWD().getPbData().getForum().getName(), cWD().getPbData().cVl().getId(), str, intValue3, intValue2, booleanValue, cWD().getPbData().cVl().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == kLT || intValue == kLV) {
                    if (cWD().cZe() != null) {
                        cWD().cZe().DY(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == kLT) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void el(String str, String str2) {
        be.bju().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int byh() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> byi() {
        if (this.fcm == null) {
            this.fcm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: byu */
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
        return this.fcm;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> byj() {
        if (this.ffF == null) {
            this.ffF = TbRichTextView.y(getPageContext().getPageActivity(), 8);
        }
        return this.ffF;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> byk() {
        if (this.fcn == null) {
            this.fcn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cgy */
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
                    gifView.bsU();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fcn;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> byl() {
        if (this.ffG == null) {
            this.ffG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cYl */
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
                    ((PlayVoiceBntNew) view).bPe();
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
        return this.ffG;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bym() {
        if (this.ffH == null) {
            this.ffH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cYn */
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
        return this.ffH;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> byn() {
        this.ffI = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cYm */
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
        return this.ffI;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aq(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.kDg = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (com.baidu.tieba.pb.pb.main.be.NM(str) && cWD() != null && cWD().cYB() != null) {
            TiebaStatic.log(new aq("c11664").ai("obj_param1", 1).dD("post_id", cWD().cYB()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.eJB = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
            }
        } else {
            com.baidu.tieba.pb.pb.main.be.dbI().f(getPageContext(), str);
        }
        this.kDg = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ar(Context context, String str) {
        com.baidu.tieba.pb.pb.main.be.dbI().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.kDg = true;
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
            this.kVM.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b deK = this.kVM.deK();
            if (deK == null) {
                this.kVM.cXx();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                deK.getItemView(1).setVisibility(8);
            } else {
                deK.getItemView(1).setVisibility(0);
            }
            deK.bhi();
            this.kDg = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void au(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.bju().b(getPageContext(), new String[]{str});
            this.kDg = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a dec() {
        return this.ekD;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bvH() {
        return this.eVD;
    }

    public ReplyFragment ded() {
        if (this.kVv == null || !(this.kVv.EO(kVr) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.kVv.EO(kVr);
    }

    public DetailInfoFragment dee() {
        if (this.kVv == null || !(this.kVv.EO(kVq) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.kVv.EO(kVq);
    }

    public DetailInfoAndReplyFragment def() {
        if (this.kVv == null || !(this.kVv.EO(kVs) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.kVv.EO(kVs);
    }

    public boolean cWt() {
        PbModel cWD = this.kCV.cWD();
        if (cWD == null) {
            return false;
        }
        return cWD.cWt();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cVx;
        PbModel cWD = this.kCV.cWD();
        if (cWD != null && cWD.getPbData() != null && !cWD.getPbData().cVO()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = cWD.getPbData().cVl().getId();
            if (cWD.isShareThread() && cWD.getPbData().cVl().edE != null) {
                historyMessage.threadName = cWD.getPbData().cVl().edE.showText;
            } else {
                historyMessage.threadName = cWD.getPbData().cVl().getTitle();
            }
            if (cWD.isShareThread() && !cWt()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = cWD.getPbData().getForum().getName();
            }
            ArrayList<PostData> cVn = cWD.getPbData().cVn();
            int daP = ded() != null ? ded().daP() : 0;
            if (cVn != null && daP >= 0 && daP < cVn.size()) {
                historyMessage.postID = cVn.get(daP).getId();
            }
            historyMessage.isHostOnly = cWD.getHostMode();
            historyMessage.isSquence = cWD.cYD();
            historyMessage.isShareThread = cWD.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.kDL != null) {
            this.kDL.onDestroy();
        }
        if (cWD != null && (cWD.cYE() || cWD.cYG())) {
            Intent intent = new Intent();
            intent.putExtra("tid", cWD.cYB());
            if (this.kDA) {
                if (this.kDC) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", cWD.ceI());
                }
                if (this.kDB) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", cWD.getIsGood());
                }
            }
            if (cWD.getPbData() != null && System.currentTimeMillis() - this.kDc >= 40000 && (cVx = cWD.getPbData().cVx()) != null && !com.baidu.tbadk.core.util.y.isEmpty(cVx.getDataList())) {
                intent.putExtra("guess_like_data", cVx);
            }
            PbActivity pbActivity = this.kCV;
            PbActivity pbActivity2 = this.kCV;
            pbActivity.setResult(-1, intent);
        }
        if (cXN()) {
            if (cWD != null) {
                com.baidu.tieba.pb.data.f pbData = cWD.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.kDi) {
                        if (this.kVy != null) {
                            Rect rect = new Rect();
                            this.kVy.getGlobalVisibleRect(rect);
                            as.cZW().h(rect);
                        }
                        as.cZW().Es(this.eiw.getCurrentItem());
                        BdTypeRecyclerView cpk = cpk();
                        Parcelable parcelable = null;
                        if (cpk != null) {
                            parcelable = cpk.onSaveInstanceState();
                        }
                        as.cZW().a(cWD.cYL(), parcelable, cWD.cYD(), cWD.getHostMode(), false);
                    }
                }
            } else {
                as.cZW().reset();
            }
            cWQ();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.kVz != null && !this.kVz.bNe()) {
            if ((this.kVz.isFullScreen() && configuration.orientation == 1) || (!this.kVz.isFullScreen() && configuration.orientation == 2)) {
                this.kVz.ul(false);
            }
        }
    }

    public boolean deg() {
        if (this.kVz == null) {
            return false;
        }
        return this.kVz.bNe();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.dvE().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class a {
        public boolean kWh;
        public boolean kWi;

        private a() {
            this.kWi = true;
        }

        public boolean den() {
            return (this.kWh && this.kWi) ? false : true;
        }
    }

    public void deh() {
        this.kDr = -1;
        this.kDs = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYe() {
        if (cWD() != null && !at.isEmpty(cWD().cYB())) {
            com.baidu.tbadk.BdToken.c.aYs().p(com.baidu.tbadk.BdToken.b.dNF, com.baidu.adp.lib.f.b.toLong(cWD().cYB(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.kVx.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dei() {
        if (this.kVW == null) {
            this.kVW = ObjectAnimator.ofFloat(this.kVB, "alpha", 0.0f, 1.0f);
            this.kVW.setDuration(200L);
        }
        this.kVW.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dej() {
        if (this.kVX == null) {
            this.kVX = ObjectAnimator.ofFloat(this.kVB, "alpha", 1.0f, 0.0f);
            this.kVX.setDuration(200L);
        }
        this.kVX.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dek() {
        return this.kVz != null && this.kVz.del();
    }

    public boolean del() {
        return this.kVT;
    }

    public void ud(boolean z) {
        this.kVT = z;
    }
}
