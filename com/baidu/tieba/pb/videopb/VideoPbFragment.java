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
    private AppBarLayout ZS;
    private EditorTools acZ;
    private ImageView aiG;
    public View fOs;
    private com.baidu.adp.lib.d.b<ImageView> fWD;
    private com.baidu.adp.lib.d.b<GifView> fWE;
    private com.baidu.adp.lib.d.b<TextView> fZS;
    private com.baidu.adp.lib.d.b<View> fZT;
    private com.baidu.adp.lib.d.b<LinearLayout> fZU;
    private com.baidu.adp.lib.d.b<RelativeLayout> fZV;
    private CustomViewPager fbv;
    private ImageView gZY;
    private com.baidu.tieba.callfans.a iwL;
    private VoiceManager jfh;
    private com.baidu.tieba.frs.profession.permission.c jjD;
    private com.baidu.tieba.f.b jkd;
    public View jvO;
    public al kON;
    public ar kSQ;
    private com.baidu.tieba.pb.videopb.c.a lGB;
    private PbActivity lME;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lMX;
    private PbFakeFloorModel lMz;
    private EmotionImageData lNA;
    private com.baidu.tbadk.core.view.c lNE;
    int lNa;
    private g lNw;
    private com.baidu.tbadk.editortools.pb.e lNx;
    private com.baidu.tieba.frs.profession.permission.c lNz;
    private View lUL;
    private r lVM;
    private View lVd;
    private LinearLayout lVf;
    private HeadImageView lVg;
    private ImageView lVh;
    private ImageView lVi;
    private ImageView lVj;
    private com.baidu.tieba.pb.view.d lVk;
    private TextView lVl;
    private TextView lVm;
    private int lVo;
    private int lVp;
    private String lWe;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private VideoPbFragmentAdapter mfA;
    private View mfB;
    private View mfC;
    private VideoContainerLayout mfD;
    private com.baidu.tieba.pb.videopb.videoView.a mfE;
    private e mfF;
    private View mfG;
    private View mfH;
    private TextView mfJ;
    private TextView mfK;
    private ImageView mfL;
    private TBSpecificationBtn mfM;
    private TbImageView mfN;
    private View mfO;
    private ValueAnimator mfP;
    private ValueAnimator mfQ;
    public com.baidu.tieba.pb.videopb.b.a mfR;
    private float mfV;
    private float mfW;
    private boolean mfX;
    private NewPagerSlidingTabBaseStrip mfz;
    private ObjectAnimator mgb;
    private ObjectAnimator mgc;
    private RelativeLayout rootView;
    public static int mfv = 0;
    public static int mfw = 1;
    public static int mfx = 0;
    public static int lVE = 3;
    public static int lVF = 0;
    public static int lVG = 3;
    public static int lVH = 4;
    public static int lVI = 5;
    public static int lVJ = 6;
    private static final int kin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int mfy = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a lOx = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void cZ(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.dnL();
            } else {
                com.baidu.tieba.pb.a.b.dnK();
            }
        }
    };
    private long lMM = 0;
    private boolean lMT = false;
    View.OnClickListener mfI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.lGB == null || VideoPbFragment.this.lGB.dwL()) {
                if (VideoPbFragment.this.lGB != null) {
                    if (VideoPbFragment.this.lGB.isChushou) {
                        VideoPbFragment.this.eI(VideoPbFragment.this.lGB.thirdRoomId, VideoPbFragment.this.lGB.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.lGB.dwM();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null && VideoPbFragment.this.dnV().getPbData().getForum() != null) {
                        TiebaStatic.log(new aq("c13713").dX("fid", VideoPbFragment.this.dnV().getPbData().getForum().getId()).dX("fname", VideoPbFragment.this.dnV().getPbData().getForum().getName()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("tid", VideoPbFragment.this.dnV().getPbData().getThreadId()).w("obj_param1", VideoPbFragment.this.lGB.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new aq("c13590").dX("obj_id", VideoPbFragment.this.lGB.getTitle()).dX("obj_name", VideoPbFragment.this.lGB.dwI()).an("obj_type", 2).dX("fid", VideoPbFragment.this.dnV().getPbData().getForumId()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("tid", VideoPbFragment.this.dnV().getPbData().getThreadId()));
            String link = VideoPbFragment.this.lGB.getLink();
            if (!TextUtils.isEmpty(link)) {
                if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                    be.bwu().b(VideoPbFragment.this.getPageContext(), new String[]{link});
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
    private com.baidu.tbadk.baseEditMark.a lNj = null;
    private com.baidu.tbadk.coreExtra.model.a fcZ = null;
    private ForumManageModel ggJ = null;
    private boolean lMQ = false;
    private View lVe = null;
    private TextView klE = null;
    private boolean lVa = false;
    private String fGe = null;
    private boolean lNm = false;
    private boolean lNn = false;
    private boolean lNo = false;
    private boolean lMS = false;
    int[] lMZ = new int[2];
    private int lNb = -1;
    private int lNc = Integer.MIN_VALUE;
    private int lNK = 0;
    private int mfT = Integer.MIN_VALUE;
    private boolean isPaused = false;
    private boolean lNg = com.baidu.tbadk.a.d.bmF();
    private final PbModel.a lOn = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h ss;
            VideoPbFragment.this.dsp();
            VideoPbFragment.this.dsk();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.vz(false);
            if (z && fVar != null) {
                bz dmE = fVar.dmE();
                ((VideoPbViewModel) ViewModelProviders.of(VideoPbFragment.this.getActivity()).get(VideoPbViewModel.class)).c(fVar, i2);
                VideoPbFragment.this.M(fVar);
                com.baidu.tieba.pb.videopb.c.a dnj = fVar.dnj();
                if (dnj != null && !dnj.mhU) {
                    VideoPbFragment.this.a(dnj);
                }
                VideoPbFragment.this.N(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.lNj != null) {
                    VideoPbFragment.this.lNj.jc(fVar.bnx());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.fGe = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.fGe) && VideoPbFragment.this.lNx != null && VideoPbFragment.this.lNx.bEI() != null && (ss = VideoPbFragment.this.lNx.bEI().ss(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.fGe)) {
                        ((View) ss).setOnClickListener(VideoPbFragment.this.fGR);
                    }
                }
                if (VideoPbFragment.this.kON != null && dmE != null && dmE.brq() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(dmE.brq());
                    VideoPbFragment.this.kON.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.dnV().dpW());
                        jSONObject.put("fid", VideoPbFragment.this.dnV().getForumId());
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
                if ((!com.baidu.tbadk.a.d.bmH() || VideoPbFragment.this.dvM() != null) && VideoPbFragment.this.dvK() != null) {
                    if (com.baidu.tbadk.a.d.bmH()) {
                        if (i != -1) {
                            ArrayList<PostData> arrayList = null;
                            if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null) {
                                arrayList = VideoPbFragment.this.dnV().getPbData().dmG();
                            }
                            if (x.getCount(arrayList) == 0 || (x.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dPd() == 1)) {
                                if (VideoPbFragment.this.dvM().dpw()) {
                                    VideoPbFragment.this.dvM().PY(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dvM().PY(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dvM().PX(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dvM().PX("");
                        }
                        VideoPbFragment.this.dvM().endLoadData();
                    } else {
                        if (i != -1) {
                            ArrayList<PostData> arrayList2 = null;
                            if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null) {
                                arrayList2 = VideoPbFragment.this.dnV().getPbData().dmG();
                            }
                            if (x.getCount(arrayList2) == 0 || (x.getCount(arrayList2) == 1 && arrayList2.get(0) != null && arrayList2.get(0).dPd() == 1)) {
                                if (VideoPbFragment.this.dvK().dpw()) {
                                    VideoPbFragment.this.dvK().PY(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dvK().PY(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dvK().PX(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dvK().PX("");
                        }
                        VideoPbFragment.this.dvK().endLoadData();
                    }
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.dNX().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0574a lOp = new a.InterfaceC0574a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0574a
        public void g(boolean z, boolean z2, String str) {
            VideoPbFragment.this.dsp();
            if (z && VideoPbFragment.this.dnV() != null) {
                if (VideoPbFragment.this.lNj != null) {
                    VideoPbFragment.this.lNj.jc(z2);
                }
                VideoPbFragment.this.dnV().vd(z2);
                if (VideoPbFragment.this.dnV().bnx()) {
                    VideoPbFragment.this.dph();
                } else if (com.baidu.tbadk.a.d.bmH() && VideoPbFragment.this.dvM() != null) {
                    VideoPbFragment.this.dvM().dwv();
                } else if (VideoPbFragment.this.dvK() != null) {
                    VideoPbFragment.this.dvK().dwv();
                }
                if (z2) {
                    if (VideoPbFragment.this.lNj != null) {
                        if (VideoPbFragment.this.lNj.bnA() != null && VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null && VideoPbFragment.this.dnV().getPbData().dmE() != null && VideoPbFragment.this.dnV().getPbData().dmE().brq() != null) {
                            MarkData bnA = VideoPbFragment.this.lNj.bnA();
                            MetaData brq = VideoPbFragment.this.dnV().getPbData().dmE().brq();
                            if (bnA != null && brq != null) {
                                if (!at.equals(TbadkCoreApplication.getCurrentAccount(), brq.getUserId()) && !brq.hadConcerned()) {
                                    VideoPbFragment.this.mfR.b(brq);
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
                    VideoPbFragment.this.dpe();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b fGi = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bFm() {
            if (VideoPbFragment.this.kSQ == null || VideoPbFragment.this.kSQ.dti() == null || !VideoPbFragment.this.kSQ.dti().dXS()) {
                return !VideoPbFragment.this.GV(al.fcU);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kSQ.dti().dXU());
            if (VideoPbFragment.this.lNx != null && (VideoPbFragment.this.lNx.bFD() || VideoPbFragment.this.lNx.bFE())) {
                VideoPbFragment.this.lNx.a(false, VideoPbFragment.this.kSQ.dtl());
            }
            VideoPbFragment.this.kSQ.vF(true);
            return true;
        }
    };
    private final CustomMessageListener lNR = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.dnV() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.lNx != null) {
                    VideoPbFragment.this.vx(VideoPbFragment.this.lNx.bFw());
                }
                VideoPbFragment.this.drO();
                VideoPbFragment.this.mfR.dsG();
            }
        }
    };
    private CustomMessageListener lNU = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
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
    private final CustomMessageListener jgK = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.64
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.isPaused) {
                VideoPbFragment.this.dpz();
            }
        }
    };
    private CustomMessageListener lOo = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.doY();
            }
        }
    };
    private CustomMessageListener lOg = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.66
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.mfR != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mfR.lNF) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.mfR.cni();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.mfR.getExtra();
                DataRes dataRes = aVar.nEU;
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
                    VideoPbFragment.this.mfR.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.mfR.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener lOe = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.mfR != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mfR.lNF) {
                VideoPbFragment.this.mfR.cni();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                f pbData = VideoPbFragment.this.dnV().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dmU().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lNE.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.mfR.DX(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.mfR.dpv();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (at.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.lNE.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lOf = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.mfR != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mfR.lNF) {
                VideoPbFragment.this.mfR.cni();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lNE.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (at.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.lNE.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b lNC = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bFm() {
            if (VideoPbFragment.this.kSQ == null || VideoPbFragment.this.kSQ.dtj() == null || !VideoPbFragment.this.kSQ.dtj().dXS()) {
                return !VideoPbFragment.this.GV(al.fcV);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kSQ.dtj().dXU());
            if (VideoPbFragment.this.lVM != null && VideoPbFragment.this.lVM.doI() != null && VideoPbFragment.this.lVM.doI().bFE()) {
                VideoPbFragment.this.lVM.doI().a(VideoPbFragment.this.kSQ.dtl());
            }
            VideoPbFragment.this.kSQ.vG(true);
            return true;
        }
    };
    private final NewWriteModel.d fGo = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c13268");
                aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null) {
                    aqVar.dX("fid", VideoPbFragment.this.dnV().getPbData().getForumId());
                }
                aqVar.dX("tid", VideoPbFragment.this.dnV().dpW());
                aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            VideoPbFragment.this.cFz();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.dnV() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.dnV().PS(postWriteCallBackData.getPostId());
                    if (com.baidu.tbadk.a.d.bmH() && VideoPbFragment.this.dvM() != null) {
                        VideoPbFragment.this.lNK = VideoPbFragment.this.dvM().dsr();
                        VideoPbFragment.this.mfT = VideoPbFragment.this.dvM().dwy();
                        VideoPbFragment.this.dnV().dc(VideoPbFragment.this.lNK, VideoPbFragment.this.mfT);
                    } else if (VideoPbFragment.this.dvK() != null) {
                        VideoPbFragment.this.lNK = VideoPbFragment.this.dvK().dsr();
                        VideoPbFragment.this.mfT = VideoPbFragment.this.dvK().dwy();
                        VideoPbFragment.this.dnV().dc(VideoPbFragment.this.lNK, VideoPbFragment.this.mfT);
                    }
                }
                if (VideoPbFragment.this.fbv != null) {
                    if (com.baidu.tbadk.a.d.bmH()) {
                        VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfx);
                    } else {
                        VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfw);
                    }
                }
                VideoPbFragment.this.mfR.dsG();
                VideoPbFragment.this.kSQ.dth();
                if (VideoPbFragment.this.lNx != null) {
                    VideoPbFragment.this.vx(VideoPbFragment.this.lNx.bFw());
                }
                VideoPbFragment.this.drK();
                VideoPbFragment.this.vz(true);
                VideoPbFragment.this.dnV().dqs();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (com.baidu.tbadk.a.d.bmH() && VideoPbFragment.this.dvM() != null) {
                                VideoPbFragment.this.dvM().dwv();
                            } else if (VideoPbFragment.this.dvK() != null) {
                                VideoPbFragment.this.dvK().dwv();
                            }
                        }
                    } else if (VideoPbFragment.this.dnV().getHostMode()) {
                        f pbData = VideoPbFragment.this.dnV().getPbData();
                        if (pbData != null && pbData.dmE() != null && pbData.dmE().brq() != null && (userId = pbData.dmE().brq().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.dnV().dqj()) {
                            VideoPbFragment.this.dsn();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.dnV().dqj()) {
                        VideoPbFragment.this.dsn();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.uO(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.lNx.bFD() || VideoPbFragment.this.lNx.bFE()) {
                    VideoPbFragment.this.lNx.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.kSQ.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.kON != null) {
                    VideoPbFragment.this.kON.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.Bp(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bp(postWriteCallBackData.getErrorString());
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
                aVar.b(VideoPbFragment.this.getPageContext()).btX();
                TiebaStatic.log(new aq("c13745").an("obj_locate", 1).an("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener fGR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.fGe);
        }
    };
    private CustomMessageListener lNT = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.lNx != null) {
                    VideoPbFragment.this.vx(VideoPbFragment.this.lNx.bFw());
                }
                VideoPbFragment.this.vz(false);
            }
        }
    };
    private int mfU = 0;
    private boolean mfY = true;
    private View.OnTouchListener mfZ = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.mfU == 1) {
                if (!VideoPbFragment.this.mfY) {
                    VideoPbFragment.this.dvP();
                    UtilHelper.showStatusBar(VideoPbFragment.this.dpD(), VideoPbFragment.this.dpD().getRootView());
                    VideoPbFragment.this.mfY = true;
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(VideoPbFragment.this.mga);
                    com.baidu.adp.lib.f.e.mB().postDelayed(VideoPbFragment.this.mga, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (VideoPbFragment.this.mfU == 2 && (VideoPbFragment.this.mfY || VideoPbFragment.this.dvR())) {
                VideoPbFragment.this.dvQ();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dpD(), VideoPbFragment.this.dpD().getRootView());
                VideoPbFragment.this.mfY = false;
                if (VideoPbFragment.this.mfE != null) {
                    VideoPbFragment.this.mfE.wb(false);
                }
            }
            VideoPbFragment.this.mfU = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener jrz = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.mfU = 0;
            VideoPbFragment.this.mfV = 0.0f;
            VideoPbFragment.this.mfW = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.mfV += f;
            VideoPbFragment.this.mfW += f2;
            if (VideoPbFragment.this.mfU == 0 && !VideoPbFragment.this.mfX && VideoPbFragment.this.mfE != null && !VideoPbFragment.this.mfE.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.mfW) <= Math.abs(VideoPbFragment.this.mfV) || VideoPbFragment.this.mfW > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.mfW) > Math.abs(VideoPbFragment.this.mfV) && VideoPbFragment.this.mfW > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.mfU = 2;
                    }
                } else {
                    VideoPbFragment.this.mfU = 1;
                }
            }
            return true;
        }
    };
    private Runnable mga = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.mfY && !VideoPbFragment.this.dvR()) {
                VideoPbFragment.this.dvQ();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dpD(), VideoPbFragment.this.dpD().getRootView());
                VideoPbFragment.this.mfY = false;
            }
        }
    };
    private final com.baidu.adp.base.e iwQ = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.dnV() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.ggJ.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.ggJ.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.dnV().dqs();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.mcO != 1002 || bVar.hli) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.mSuccess, dVar.nuu, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.ggJ.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.ggJ.getLoadDataMode(), gVar.mSuccess, gVar.nuu, false);
                    VideoPbFragment.this.mfR.bf(gVar.nux);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener bTP = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.jkd.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d lOl = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c13268");
                aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null) {
                    aqVar.dX("fid", VideoPbFragment.this.dnV().getPbData().getForumId());
                }
                if (VideoPbFragment.this.dnV() != null) {
                    aqVar.dX("tid", VideoPbFragment.this.dnV().dpW());
                }
                aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (VideoPbFragment.this.kSQ != null) {
                    VideoPbFragment.this.kSQ.dtg();
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
                if (VideoPbFragment.this.kON != null) {
                    VideoPbFragment.this.kON.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.Bp(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bp(postWriteCallBackData.getErrorString());
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
                aVar.b(VideoPbFragment.this.getPageContext()).btX();
                TiebaStatic.log(new aq("c13745").an("obj_locate", 1).an("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.kSQ != null) {
                if (VideoPbFragment.this.lVM != null && VideoPbFragment.this.lVM.doI() != null && VideoPbFragment.this.lVM.doI().bFE()) {
                    VideoPbFragment.this.lVM.doI().a(postWriteCallBackData);
                }
                VideoPbFragment.this.kSQ.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c fGh = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bFn() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public final View.OnClickListener aHh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
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
                    aqVar.dX("tid", VideoPbFragment.this.dnV().dpW());
                    aqVar.dX("fid", VideoPbFragment.this.dnV().getForumId());
                    aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.an("obj_locate", 1);
                    TiebaStatic.log(aqVar);
                    if (VideoPbFragment.this.lMQ) {
                        VideoPbFragment.this.lMQ = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null && VideoPbFragment.this.lMz != null && postData.brq() != null && postData.dPd() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.lVM != null) {
                                    VideoPbFragment.this.lVM.doE();
                                }
                                p pVar = new p();
                                pVar.a(VideoPbFragment.this.dnV().getPbData().getForum());
                                pVar.setThreadData(VideoPbFragment.this.dnV().getPbData().dmE());
                                pVar.g(postData);
                                VideoPbFragment.this.lMz.d(pVar);
                                VideoPbFragment.this.lMz.setPostId(postData.getId());
                                VideoPbFragment.this.a(view, postData.brq().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.dnV().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.lNx != null) {
                                    VideoPbFragment.this.vx(VideoPbFragment.this.lNx.bFw());
                                }
                            }
                        }
                    }
                } else if ((VideoPbFragment.this.dvK() != null && VideoPbFragment.this.dvK().dsC() != null && view == VideoPbFragment.this.dvK().dsC()) || ((com.baidu.tbadk.a.d.bmH() && VideoPbFragment.this.dvM() != null && VideoPbFragment.this.dvM().dsC() != null && view == VideoPbFragment.this.dvM().dsC()) || view.getId() == R.id.pb_more)) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.dnV().vb(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        if (com.baidu.tbadk.a.d.bmH()) {
                            VideoPbFragment.this.dvM().dso();
                        } else {
                            VideoPbFragment.this.dvK().dso();
                        }
                    }
                } else if (VideoPbFragment.this.mfR != null && VideoPbFragment.this.mfR.dtO() != null && view == VideoPbFragment.this.mfR.dtO().dri()) {
                    VideoPbFragment.this.mfR.bes();
                } else if ((VideoPbFragment.this.mfR != null && ((VideoPbFragment.this.mfR.dtO() != null && view == VideoPbFragment.this.mfR.dtO().drj()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) || view.getId() == R.id.floor_owner_reply || view.getId() == R.id.reply_title) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.mfR.dsG();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.cFz();
                        VideoPbFragment.this.dsn();
                        if (view.getId() == R.id.owner_reply) {
                            C = VideoPbFragment.this.dnV().C(true, VideoPbFragment.this.dpl());
                        } else {
                            C = view.getId() == R.id.all_reply ? VideoPbFragment.this.dnV().C(false, VideoPbFragment.this.dpl()) : VideoPbFragment.this.dnV().PP(VideoPbFragment.this.dpl());
                        }
                        view.setTag(Boolean.valueOf(C));
                        if (C) {
                            VideoPbFragment.this.dsj();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.fOs) {
                    if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null) {
                        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            aq aqVar2 = new aq("c13266");
                            aqVar2.dX("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar2.dX("fid", VideoPbFragment.this.dnV().getPbData().getForumId());
                            aqVar2.dX("tid", VideoPbFragment.this.dnV().dpW());
                            aqVar2.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(aqVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.lME, VideoPbFragment.this.fOs);
                        VideoPbFragment.this.lME.finish();
                    }
                } else if (view == VideoPbFragment.this.jvO && VideoPbFragment.this.mfR != null) {
                    if (VideoPbFragment.this.dnV() == null || VideoPbFragment.this.dnV().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> dmG = VideoPbFragment.this.dnV().getPbData().dmG();
                    if ((dmG == null || dmG.size() <= 0) && VideoPbFragment.this.dnV().dpY()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new aq("c12378").dX("tid", VideoPbFragment.this.dnV().dpW()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("fid", VideoPbFragment.this.dnV().getForumId()));
                    VideoPbFragment.this.mfR.doZ();
                } else if (VideoPbFragment.this.mfR.dtO() != null && view == VideoPbFragment.this.mfR.dtO().drn()) {
                    if (VideoPbFragment.this.dnV() != null) {
                        VideoPbFragment.this.mfR.dsG();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.cFz();
                            VideoPbFragment.this.dsn();
                            VideoPbFragment.this.dnV().Hc(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.mfR != null && VideoPbFragment.this.mfR.dtO() != null && view == VideoPbFragment.this.mfR.dtO().drj()) {
                    VideoPbFragment.this.mfR.bes();
                } else if (VideoPbFragment.this.mfR != null && ((VideoPbFragment.this.mfR.dtO() != null && view == VideoPbFragment.this.mfR.dtO().drq()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                    VideoPbFragment.this.mfR.dsG();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.cFz();
                            VideoPbFragment.this.dsn();
                            VideoPbFragment.this.mfR.dU(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.dnV().dqq()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.mfR != null && VideoPbFragment.this.mfR.dtO() != null && view == VideoPbFragment.this.mfR.dtO().drh()) {
                    if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null && VideoPbFragment.this.dnV().getPbData().dmE() != null) {
                        VideoPbFragment.this.mfR.bes();
                        TiebaStatic.log(new aq("c13062"));
                        VideoPbFragment.this.mfR.PK(VideoPbFragment.this.dnV().getPbData().dmE().brG());
                    }
                } else if (view.getId() == R.id.pb_floor_feedback) {
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (VideoPbFragment.this.mfR != null) {
                        VideoPbFragment.this.mfR.i(sparseArray);
                    }
                } else if (VideoPbFragment.this.mfR != null && VideoPbFragment.this.mfR.dtO() != null && view == VideoPbFragment.this.mfR.dtO().drr()) {
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
                    VideoPbFragment.this.mfR.dtN();
                } else if (VideoPbFragment.this.mfR != null && (view == VideoPbFragment.this.mfR.dsl() || (VideoPbFragment.this.mfR.dtO() != null && (view == VideoPbFragment.this.mfR.dtO().drm() || view == VideoPbFragment.this.mfR.dtO().drk())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if ((VideoPbFragment.this.dnV() != null || VideoPbFragment.this.dnV().getPbData() != null) && !VideoPbFragment.this.ggJ.dPY()) {
                        VideoPbFragment.this.mfR.dsG();
                        if (VideoPbFragment.this.mfR.dtO() != null && view == VideoPbFragment.this.mfR.dtO().drk()) {
                            if (VideoPbFragment.this.dnV().getPbData().dmE().brl() == 1) {
                                i2 = 5;
                            } else {
                                i2 = 4;
                            }
                        } else if (VideoPbFragment.this.mfR.dtO() != null && view == VideoPbFragment.this.mfR.dtO().drm()) {
                            if (VideoPbFragment.this.dnV().getPbData().dmE().brm() != 1) {
                                i2 = 6;
                            }
                        } else {
                            i2 = view == VideoPbFragment.this.mfR.dsl() ? 2 : 0;
                        }
                        ForumData forum = VideoPbFragment.this.dnV().getPbData().getForum();
                        String name = forum.getName();
                        String id = forum.getId();
                        String id2 = VideoPbFragment.this.dnV().getPbData().dmE().getId();
                        VideoPbFragment.this.showProgressBar();
                        VideoPbFragment.this.ggJ.c(id, name, id2, i2, VideoPbFragment.this.mfR.dsm());
                    }
                } else if (VideoPbFragment.this.mfR != null && VideoPbFragment.this.mfR.dtO() != null && view == VideoPbFragment.this.mfR.dtO().drp()) {
                    if (VideoPbFragment.this.dnV() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.mfR.dsG();
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.dnV().getPbData(), VideoPbFragment.this.dnV().dpY(), 1);
                        if (b2 != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.dnV().getPbData().getForum().getId(), VideoPbFragment.this.dnV().getPbData().getForum().getName(), VideoPbFragment.this.dnV().getPbData().dmE().getId(), String.valueOf(VideoPbFragment.this.dnV().getPbData().getUserData().getUserId()), (String) b2.get(R.id.tag_forbid_user_name), (String) b2.get(R.id.tag_forbid_user_name_show), (String) b2.get(R.id.tag_forbid_user_post_id), (String) b2.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.mfR != null && VideoPbFragment.this.mfR.dtO() != null && view == VideoPbFragment.this.mfR.dtO().drl()) {
                    if (VideoPbFragment.this.dnV() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b3 = VideoPbFragment.this.b(VideoPbFragment.this.dnV().getPbData(), VideoPbFragment.this.dnV().dpY(), 1);
                        if (b3 != null) {
                            if (StringUtils.isNull((String) b3.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.mfR.a(((Integer) b3.get(R.id.tag_del_post_type)).intValue(), (String) b3.get(R.id.tag_del_post_id), ((Integer) b3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b3.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.mfR.a(((Integer) b3.get(R.id.tag_del_post_type)).intValue(), (String) b3.get(R.id.tag_del_post_id), ((Integer) b3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b3.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b3.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.mfR.bes();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        aq aqVar3 = new aq("c13398");
                        aqVar3.dX("tid", VideoPbFragment.this.dnV().dpW());
                        aqVar3.dX("fid", VideoPbFragment.this.dnV().getForumId());
                        aqVar3.dX("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar3.an("obj_locate", 4);
                        TiebaStatic.log(aqVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new aq("c10517").an("obj_locate", 3).dX("fid", VideoPbFragment.this.dnV().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null) {
                        if (VideoPbFragment.this.mfR != null) {
                            VideoPbFragment.this.mfR.dsG();
                        }
                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                        PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                        PostData postData3 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                        if (postData2 != null) {
                            if (postData2.dPp() == 1) {
                                TiebaStatic.log(new aq("c12630"));
                            }
                            if (postData2.nsq != null) {
                                aq bwm = postData2.nsq.bwm();
                                bwm.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    bwm.an("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    bwm.an("obj_locate", 8);
                                }
                                TiebaStatic.log(bwm);
                            }
                            VideoPbFragment.this.cFz();
                            TiebaStatic.log("c11742");
                            if (postData3 != null) {
                                VideoPbFragment.this.a(postData2, postData3, false, true);
                            } else {
                                VideoPbFragment.this.a(postData2, (PostData) null, false, false);
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                    if (VideoPbFragment.this.dnV() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            aq aqVar4 = new aq("c13398");
                            aqVar4.dX("tid", VideoPbFragment.this.dnV().dpW());
                            aqVar4.dX("fid", VideoPbFragment.this.dnV().getForumId());
                            aqVar4.dX("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar4.an("obj_locate", 6);
                            TiebaStatic.log(aqVar4);
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData4.nsq != null) {
                                    aq bwm2 = postData4.nsq.bwm();
                                    bwm2.delete("obj_locate");
                                    bwm2.an("obj_locate", 8);
                                    TiebaStatic.log(bwm2);
                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                    TiebaStatic.log(new aq("c13700").dX("tid", VideoPbFragment.this.dnV().dpX()).dX("fid", VideoPbFragment.this.dnV().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("post_id", postData4.getId()).an("obj_source", 1).an("obj_type", 3));
                                }
                                if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null && VideoPbFragment.this.lMz != null && postData4.brq() != null && postData4.dPd() != 1) {
                                    if (VideoPbFragment.this.lVM != null) {
                                        VideoPbFragment.this.lVM.doE();
                                    }
                                    if (VideoPbFragment.this.lNg && postData4.dPa() != null && postData4.dPa().size() != 0) {
                                        VideoPbFragment.this.a(postData4, (PostData) null, true, false);
                                        return;
                                    }
                                    p pVar2 = new p();
                                    pVar2.a(VideoPbFragment.this.dnV().getPbData().getForum());
                                    pVar2.setThreadData(VideoPbFragment.this.dnV().getPbData().dmE());
                                    pVar2.g(postData4);
                                    VideoPbFragment.this.lMz.d(pVar2);
                                    VideoPbFragment.this.lMz.setPostId(postData4.getId());
                                    VideoPbFragment.this.a(view, postData4.brq().getUserId(), "", postData4);
                                    if (VideoPbFragment.this.lNx != null) {
                                        VideoPbFragment.this.vx(VideoPbFragment.this.lNx.bFw());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.mfR != null && VideoPbFragment.this.dnV() != null) {
                        if (com.baidu.tbadk.a.d.bmH() || VideoPbFragment.this.dvK() != null) {
                            if (!com.baidu.tbadk.a.d.bmH() || VideoPbFragment.this.dvM() != null) {
                                VideoPbFragment.this.mfR.dsG();
                                if (VideoPbFragment.this.GX(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.dnV() != null) {
                                    VideoPbFragment.this.dpg();
                                    if (VideoPbFragment.this.dnV().getPbData() != null && VideoPbFragment.this.dnV().getPbData().dmE() != null && VideoPbFragment.this.dnV().getPbData().dmE().brq() != null) {
                                        TiebaStatic.log(new aq("c13402").dX("tid", VideoPbFragment.this.dnV().dpW()).dX("fid", VideoPbFragment.this.dnV().getPbData().getForumId()).an("obj_locate", 3).dX("uid", VideoPbFragment.this.dnV().getPbData().dmE().brq().getUserId()));
                                    }
                                    if (VideoPbFragment.this.dnV().getPbData().dmE() != null && VideoPbFragment.this.dnV().getPbData().dmE().brq() != null && VideoPbFragment.this.dnV().getPbData().dmE().brq().getUserId() != null && VideoPbFragment.this.lNj != null) {
                                        int h = VideoPbFragment.this.mfR.h(VideoPbFragment.this.dnV().getPbData());
                                        bz dmE = VideoPbFragment.this.dnV().getPbData().dmE();
                                        if (!dmE.bpX()) {
                                            if (dmE.bpY()) {
                                                i = 3;
                                            } else if (dmE.bto()) {
                                                i = 4;
                                            } else {
                                                i = dmE.btp() ? 5 : 1;
                                            }
                                        }
                                        TiebaStatic.log(new aq("c12526").dX("tid", VideoPbFragment.this.dnV().dpW()).an("obj_locate", 1).dX("obj_id", VideoPbFragment.this.dnV().getPbData().dmE().brq().getUserId()).an("obj_type", VideoPbFragment.this.lNj.bnx() ? 0 : 1).an("obj_source", h).an("obj_param1", i));
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.vZ(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.mfR != null && VideoPbFragment.this.fbv != null && VideoPbFragment.this.dnV().getPbData() != null && VideoPbFragment.this.dnV().getPbData().dmE() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        f pbData = VideoPbFragment.this.dnV().getPbData();
                        if (pbData.dmE().brh() != 0) {
                            int currentItem = VideoPbFragment.this.fbv.getCurrentItem();
                            if (!com.baidu.tbadk.a.d.bmH() && currentItem == VideoPbFragment.mfv) {
                                VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfw);
                            } else if (com.baidu.tbadk.a.d.bmH() || currentItem == VideoPbFragment.mfw) {
                                if (!com.baidu.tbadk.a.d.bmH() && VideoPbFragment.this.dvK() == null) {
                                    return;
                                }
                                if ((!com.baidu.tbadk.a.d.bmH() || VideoPbFragment.this.dvM() != null) && VideoPbFragment.this.cIs() != null) {
                                    aq dX = new aq("c13403").dX("tid", VideoPbFragment.this.dnV().dpW()).dX("fid", VideoPbFragment.this.dnV().getPbData().getForumId()).dX("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView cIs = VideoPbFragment.this.cIs();
                                    if (cIs != null) {
                                        boolean canScrollVertically = cIs.canScrollVertically(1);
                                        boolean canScrollVertically2 = cIs.canScrollVertically(-1);
                                        if (VideoPbFragment.this.ZS != null) {
                                            VideoPbFragment.this.ZS.setExpanded(false, true);
                                        }
                                        if (cIs.getLayoutManager() != null && (cIs.getLayoutManager() instanceof LinearLayoutManager)) {
                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) cIs.getLayoutManager();
                                            if (!canScrollVertically2 && canScrollVertically) {
                                                if (VideoPbFragment.this.lNb != -1 || VideoPbFragment.this.lNc != Integer.MIN_VALUE) {
                                                    if (VideoPbFragment.this.lNb > 3 || (VideoPbFragment.this.lNb == 3 && VideoPbFragment.this.lNc < (-equipmentHeight))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lNb, VideoPbFragment.this.lNc + equipmentHeight);
                                                        cIs.smoothScrollBy(0, equipmentHeight);
                                                    } else if (VideoPbFragment.this.lNb >= 2) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lNb, VideoPbFragment.this.lNc + (equipmentHeight / 2));
                                                        cIs.smoothScrollBy(0, equipmentHeight / 2);
                                                    } else if (VideoPbFragment.this.lNb == 1) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lNb, VideoPbFragment.this.lNc + (equipmentHeight / 4));
                                                        cIs.smoothScrollBy(0, equipmentHeight / 4);
                                                    } else {
                                                        cIs.smoothScrollBy(0, -VideoPbFragment.this.lNc);
                                                    }
                                                    dX.an("obj_locate", 2);
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                int firstVisiblePosition = cIs.getFirstVisiblePosition();
                                                View childAt = cIs.getChildAt(0);
                                                int top = childAt == null ? 0 : childAt.getTop();
                                                VideoPbFragment.this.lNb = firstVisiblePosition;
                                                VideoPbFragment.this.lNc = top;
                                                if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && cIs.getCount() >= 6)) {
                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                    cIs.smoothScrollToPosition(0);
                                                } else {
                                                    cIs.smoothScrollToPosition(0);
                                                }
                                                dX.an("obj_locate", 1);
                                            }
                                            TiebaStatic.log(dX);
                                            com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(view);
                                            aq aqVar5 = new aq("c12942");
                                            aqVar5.an("obj_type", 1);
                                            aqVar5.an("obj_locate", 4);
                                            aqVar5.dX("tid", VideoPbFragment.this.dnV().dpW());
                                            aqVar5.dX(IntentConfig.NID, pbData.dmE().bpO());
                                            if (bV != null) {
                                                aqVar5.dX("obj_cur_page", bV.getCurrentPageKey());
                                            }
                                            if (com.baidu.tbadk.pageExtra.d.bHm() != null) {
                                                aqVar5.dX("obj_pre_page", com.baidu.tbadk.pageExtra.d.bHm());
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
                            if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null && VideoPbFragment.this.dnV().getPbData().dmE() != null && VideoPbFragment.this.dnV().getPbData().dmE().brq() != null) {
                                TiebaStatic.log(new aq("c13402").dX("tid", VideoPbFragment.this.dnV().dpW()).dX("fid", VideoPbFragment.this.dnV().getPbData().getForumId()).an("obj_locate", 2).dX("uid", VideoPbFragment.this.dnV().getPbData().dmE().brq().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.wa(false);
                        VideoPbFragment.this.doU();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.lNK >= 0) {
                        if (VideoPbFragment.this.dnV() != null) {
                            VideoPbFragment.this.dnV().dqI();
                        }
                        if (com.baidu.tbadk.a.d.bmH() && VideoPbFragment.this.dvM() != null && VideoPbFragment.this.dvM().dwt() != null) {
                            VideoPbFragment.this.dvM().dwt().setData(VideoPbFragment.this.dnV().getPbData());
                        } else if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dvK() != null && VideoPbFragment.this.dvK().dwt() != null) {
                            VideoPbFragment.this.dvK().dwt().setData(VideoPbFragment.this.dnV().getPbData());
                        }
                        VideoPbFragment.this.lNK = 0;
                        VideoPbFragment.this.mfT = Integer.MIN_VALUE;
                        if (com.baidu.tbadk.a.d.bmH() && VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dvM() != null) {
                            VideoPbFragment.this.dvM().df(VideoPbFragment.this.dnV().dqL(), VideoPbFragment.this.dnV().dqM());
                            VideoPbFragment.this.dnV().dc(0, 0);
                        } else if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dvK() != null) {
                            VideoPbFragment.this.dvK().df(VideoPbFragment.this.dnV().dqL(), VideoPbFragment.this.dnV().dqM());
                            VideoPbFragment.this.dnV().dc(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.dnV() != null) {
                        aq aqVar6 = new aq("c13398");
                        aqVar6.dX("tid", VideoPbFragment.this.dnV().dpW());
                        aqVar6.dX("fid", VideoPbFragment.this.dnV().getForumId());
                        aqVar6.dX("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar6.an("obj_locate", 2);
                        TiebaStatic.log(aqVar6);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bg.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.bvq().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.drO();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.drO();
                } else if (VideoPbFragment.this.mfR.dtO() != null && view == VideoPbFragment.this.mfR.dtO().dro()) {
                    VideoPbFragment.this.mfR.dsG();
                    if (VideoPbFragment.this.dnV() != null) {
                        VideoPbFragment.this.iwL.setThreadId(VideoPbFragment.this.dnV().dpW());
                    }
                    if (VideoPbFragment.this.dnV() == null || !VideoPbFragment.this.dnV().isPrivacy()) {
                        VideoPbFragment.this.iwL.cuw();
                        if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null && VideoPbFragment.this.dnV().getPbData().getThreadId() != null && VideoPbFragment.this.dnV().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                            i3 = 2;
                        }
                        if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null) {
                            VideoPbFragment.this.iwL.l(3, i3, VideoPbFragment.this.dnV().getPbData().getThreadId());
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                    if (VideoPbFragment.this.dnV().getPbData() != null) {
                        VideoPbFragment.this.iwL.l(3, 3, VideoPbFragment.this.dnV().getPbData().getThreadId());
                    }
                } else if (view.getId() == R.id.pb_floor_right_top_feedback || view.getId() == R.id.pb_post_op_more) {
                    aq aqVar7 = new aq("c13398");
                    aqVar7.dX("tid", VideoPbFragment.this.dnV().dpW());
                    aqVar7.dX("fid", VideoPbFragment.this.dnV().getForumId());
                    aqVar7.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar7.an("obj_locate", 7);
                    TiebaStatic.log(aqVar7);
                    VideoPbFragment.this.mfR.wh(false);
                    VideoPbFragment.this.mfR.dvB().onLongClick(view);
                }
            }
        }
    };
    private View.OnClickListener lJS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.mfR != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.mfR.f(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.mfR.dN(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.mfR.f(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.mfR.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private CustomMessageListener jtD = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
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
            VideoPbFragment.this.mfR.wh(true);
            return VideoPbFragment.this.mfR.dvB().onLongClick(view);
        }
    };
    public SortSwitchButton.a lOj = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean AL(int i) {
            if (VideoPbFragment.this.mfR != null) {
                VideoPbFragment.this.mfR.dsG();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.dnV() == null || VideoPbFragment.this.dnV().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.cFz();
                VideoPbFragment.this.dsn();
                if (VideoPbFragment.this.dnV().getPbData() != null && VideoPbFragment.this.dnV().getPbData().lFR != null && VideoPbFragment.this.dnV().getPbData().lFR.size() > i) {
                    int intValue = VideoPbFragment.this.dnV().getPbData().lFR.get(i).sort_type.intValue();
                    TiebaStatic.log(new aq("c13699").dX("tid", VideoPbFragment.this.dnV().dpX()).dX("fid", VideoPbFragment.this.dnV().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).an("obj_type", Ha(intValue)));
                    if (VideoPbFragment.this.dnV().Hh(intValue)) {
                        VideoPbFragment.this.mIsLoading = true;
                    }
                }
                return true;
            }
        }

        private int Ha(int i) {
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
    private a mfS = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void dpe() {
        if (dnV() != null && dnV().getPbData() != null && dnV().getPbData().dmE() != null) {
            bz dmE = dnV().getPbData().dmE();
            dmE.mRecomAbTag = dnV().dqS();
            dmE.mRecomWeight = dnV().dqQ();
            dmE.mRecomSource = dnV().dqR();
            dmE.mRecomExtra = dnV().dqT();
            dmE.eWD = dnV().dqe();
            if (dmE.getFid() == 0) {
                dmE.setFid(com.baidu.adp.lib.f.b.toLong(dnV().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dmE, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uO(boolean z) {
        if (dnV() != null && dnV().getPbData() != null && dnV().getPbData().dmE() != null) {
            bz dmE = dnV().getPbData().dmE();
            dmE.mRecomAbTag = dnV().dqS();
            dmE.mRecomWeight = dnV().dqQ();
            dmE.mRecomSource = dnV().dqR();
            dmE.mRecomExtra = dnV().dqT();
            if (dmE.getFid() == 0) {
                dmE.setFid(com.baidu.adp.lib.f.b.toLong(dnV().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dmE, "c13563");
            TbPageTag fw = com.baidu.tbadk.pageInfo.c.fw(getContext());
            if (a2 != null && fw != null && PageStayDurationConstants.PageName.VIDEO_LIST.equals(fw.locatePage)) {
                a2.dX("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dX("obj_pre_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            if (a2 != null) {
                a2.an("reply_type", 1);
                if (z) {
                    a2.an("obj_type", 2);
                } else {
                    a2.an("obj_type", 1);
                }
                com.baidu.tbadk.pageExtra.c ft = com.baidu.tbadk.pageExtra.d.ft(getContext());
                if (ft != null) {
                    a2.dX("obj_cur_page", ft.getCurrentPageKey());
                }
                if (com.baidu.tbadk.pageExtra.d.bHm() != null) {
                    a2.dX("obj_pre_page", com.baidu.tbadk.pageExtra.d.bHm());
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
            String string = !TextUtils.isEmpty(bVar.nuu) ? bVar.nuu : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.Bp(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.jH(true);
                aVar.b(getPageContext());
                aVar.btX();
            } else {
                a(0, bVar.mSuccess, bVar.nuu, z);
            }
            if (bVar.mSuccess) {
                if (bVar.iMd == 1) {
                    ArrayList<PostData> dmG = dnV().getPbData().dmG();
                    int size = dmG.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dmG.get(i).getId())) {
                            i++;
                        } else {
                            dmG.remove(i);
                            break;
                        }
                    }
                    dnV().getPbData().dmE().oN(dnV().getPbData().dmE().brh() - 1);
                    if (com.baidu.tbadk.a.d.bmH() && dvM() != null) {
                        dvM().dwv();
                    } else if (dvK() != null) {
                        dvK().dwv();
                    }
                } else if (bVar.iMd == 0) {
                    dpf();
                } else if (bVar.iMd == 2) {
                    ArrayList<PostData> dmG2 = dnV().getPbData().dmG();
                    int size2 = dmG2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dmG2.get(i2).dPa().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dmG2.get(i2).dPa().get(i3).getId())) {
                                i3++;
                            } else {
                                dmG2.get(i2).dPa().remove(i3);
                                dmG2.get(i2).dPc();
                                z2 = true;
                                break;
                            }
                        }
                        dmG2.get(i2).Tp(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        if (com.baidu.tbadk.a.d.bmH() && dvM() != null) {
                            dvM().dwv();
                        } else if (dvK() != null) {
                            dvK().dwv();
                        }
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = dnV().getPbData().dmS().lHy;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dPa().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dPa().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dPa().remove(i2);
                    list.get(i).dPc();
                    z = true;
                    break;
                }
            }
            list.get(i).Tp(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            if (com.baidu.tbadk.a.d.bmH() && dvM() != null) {
                dvM().dwv();
            } else if (dvK() != null) {
                dvK().dwv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (gVar != null && dnV() != null && dnV().getPbData() != null && dnV().getPbData().dmE() != null) {
            a(this.ggJ.getLoadDataMode(), gVar.mSuccess, gVar.nuu, false);
            if (gVar.mSuccess) {
                this.lNm = true;
                if (i == 2 || i == 3) {
                    this.lNn = true;
                    this.lNo = false;
                } else if (i == 4 || i == 5) {
                    this.lNn = false;
                    this.lNo = true;
                }
                if (i == 2) {
                    dnV().getPbData().dmE().oQ(1);
                    dnV().setIsGood(1);
                } else if (i == 3) {
                    dnV().getPbData().dmE().oQ(0);
                    dnV().setIsGood(0);
                } else if (i == 4) {
                    dnV().getPbData().dmE().oP(1);
                    dnV().Hb(1);
                } else if (i == 5) {
                    dnV().getPbData().dmE().oP(0);
                    dnV().Hb(0);
                }
            } else {
                if (gVar != null && !TextUtils.isEmpty(gVar.nuu)) {
                    string = gVar.nuu;
                } else {
                    string = getString(R.string.operation_failed);
                }
                l.showToast(getPageContext().getPageActivity(), string);
            }
            if (dnV().getPbData().dmE() != null && dvL() != null) {
                dvL().dwF();
            }
        }
    }

    private void dpf() {
        if (dnV().dpZ() || dnV().dqb()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", dnV().dpW());
            PbActivity pbActivity = this.lME;
            PbActivity pbActivity2 = this.lME;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, dnV().dpW()));
        if (dpi()) {
            this.lME.finish();
        }
    }

    private boolean dpi() {
        if (dnV() == null) {
            return true;
        }
        if (dnV().getPbData() == null || !dnV().getPbData().dnh()) {
            if (dnV().bnx()) {
                final MarkData dqr = dnV().dqr();
                if (dqr == null || !dnV().getIsFromMark() || cIs() == null) {
                    return true;
                }
                final MarkData Hi = dnV().Hi(cIs().getFirstVisiblePosition());
                if (Hi == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dqr);
                    this.lME.setResult(-1, intent);
                    return true;
                } else if (Hi.getPostId() == null || Hi.getPostId().equals(dqr.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dqr);
                    this.lME.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.Bp(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.lNj != null) {
                                if (VideoPbFragment.this.lNj.bnx()) {
                                    VideoPbFragment.this.lNj.bny();
                                    VideoPbFragment.this.lNj.jc(false);
                                }
                                VideoPbFragment.this.lNj.a(Hi);
                                VideoPbFragment.this.lNj.jc(true);
                                VideoPbFragment.this.lNj.bnz();
                            }
                            dqr.setPostId(Hi.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dqr);
                            VideoPbFragment.this.lME.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.doj();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dqr);
                            VideoPbFragment.this.lME.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.doj();
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.btX();
                    return false;
                }
            } else if (dnV().getPbData() == null || dnV().getPbData().dmG() == null || dnV().getPbData().dmG().size() <= 0 || !dnV().getIsFromMark()) {
                return true;
            } else {
                this.lME.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doj() {
        this.lME.doj();
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
    public void vZ(boolean z) {
        com.baidu.tieba.pb.data.f pbData;
        int i;
        if (dnV() != null && this.mfR != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = dnV().getPbData()) != null) {
                bz dmE = pbData.dmE();
                if (dmE != null && dmE.brq() != null) {
                    TiebaStatic.log(new aq("c13402").dX("tid", dnV().dpW()).dX("fid", pbData.getForumId()).an("obj_locate", 4).dX("uid", dmE.brq().getUserId()));
                }
                if (dmE != null) {
                    if (dmE.bpX()) {
                        i = 2;
                    } else if (dmE.bpY()) {
                        i = 3;
                    } else if (dmE.bto()) {
                        i = 4;
                    } else if (dmE.btp()) {
                        i = 5;
                    }
                    aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    aqVar.dX("tid", dnV().dpW());
                    aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dX("fid", dnV().getForumId());
                    if (!z) {
                        aqVar.an("obj_locate", 6);
                    } else {
                        aqVar.an("obj_locate", 5);
                    }
                    aqVar.an("obj_name", i);
                    aqVar.an("obj_type", 2);
                    if (dmE != null) {
                        if (dmE.bpX()) {
                            aqVar.an("obj_type", 10);
                        } else if (dmE.bpY()) {
                            aqVar.an("obj_type", 9);
                        } else if (dmE.btp()) {
                            aqVar.an("obj_type", 8);
                        } else if (dmE.bto()) {
                            aqVar.an("obj_type", 7);
                        } else if (dmE.isShareThread) {
                            aqVar.an("obj_type", 6);
                        } else if (dmE.threadType == 0) {
                            aqVar.an("obj_type", 1);
                        } else if (dmE.threadType == 40) {
                            aqVar.an("obj_type", 2);
                        } else if (dmE.threadType == 49) {
                            aqVar.an("obj_type", 3);
                        } else if (dmE.threadType == 54) {
                            aqVar.an("obj_type", 4);
                        } else {
                            aqVar.an("obj_type", 5);
                        }
                        aqVar.dX(IntentConfig.NID, dmE.bpO());
                        aqVar.an(IntentConfig.CARD_TYPE, dmE.bts());
                        aqVar.dX(IntentConfig.RECOM_SOURCE, dmE.mRecomSource);
                        aqVar.dX("ab_tag", dmE.mRecomAbTag);
                        aqVar.dX("weight", dmE.mRecomWeight);
                        aqVar.dX("extra", dmE.mRecomExtra);
                        aqVar.dX(IntentConfig.NID, dmE.bpO());
                        if (dmE.getBaijiahaoData() != null && !at.isEmpty(dmE.getBaijiahaoData().oriUgcVid)) {
                            aqVar.dX("obj_param6", dmE.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (dpD() != null) {
                        com.baidu.tbadk.pageInfo.c.b(dpD(), aqVar);
                    }
                    TiebaStatic.log(aqVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (dnV().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> dmG = pbData.dmG();
                        if ((dmG == null || dmG.size() <= 0) && dnV().dpY()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.mfR.dsG();
                        cFz();
                        TiebaStatic.log(new aq("c11939"));
                        if (!AntiHelper.d(getContext(), dmE)) {
                            if (this.lVk != null) {
                                this.lVk.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                GY(z ? 2 : 1);
                                return;
                            }
                            this.mfR.showLoadingDialog();
                            dnV().dqC().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                aq aqVar2 = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar2.dX("tid", dnV().dpW());
                aqVar2.dX("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.dX("fid", dnV().getForumId());
                if (!z) {
                }
                aqVar2.an("obj_name", i);
                aqVar2.an("obj_type", 2);
                if (dmE != null) {
                }
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (dpD() != null) {
                }
                TiebaStatic.log(aqVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment dvr() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
        M(videoPbViewModel.dvX());
        N(videoPbViewModel.dvX());
        if (dnV() != null && dnV().getPbData() != null) {
            boolean isFromMark = dnV().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = dnV().getPbData();
            if (isFromMark) {
                PostData L = L(pbData);
                if (pbData.bnw() != null && !pbData.bnw().equals(L.getId()) && this.fbv != null) {
                    if (com.baidu.tbadk.a.d.bmH()) {
                        this.fbv.setCurrentItem(mfx);
                    } else {
                        this.fbv.setCurrentItem(mfw);
                    }
                }
            }
        }
        videoPbViewModel.dvY().observe(this, new Observer<bz>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aR */
            public void onChanged(@Nullable bz bzVar) {
                BdTypeRecyclerView cIs;
                if (bzVar != null && bzVar.brH() != null) {
                    if (VideoPbFragment.this.mfE.getVideoUrl() == null || !VideoPbFragment.this.mfE.getVideoUrl().equals(bzVar.brH().video_url)) {
                        if (!at.isEmpty(VideoPbFragment.this.mfE.getVideoUrl())) {
                            VideoPbFragment.this.lMS = true;
                            if (com.baidu.tbadk.a.d.bmH()) {
                                VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfx);
                            } else {
                                VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfv);
                            }
                            if (com.baidu.tbadk.a.d.bmH() && (cIs = VideoPbFragment.this.cIs()) != null) {
                                cIs.scrollToPosition(0);
                            }
                        }
                        if (VideoPbFragment.this.mfF == null || !VideoPbFragment.this.mfF.isPlaying()) {
                            VideoPbFragment.this.dvs();
                            VideoPbFragment.this.aQ(bzVar);
                        }
                        VideoPbFragment.this.dvt();
                        if (VideoPbFragment.this.mfF.dwl()) {
                            VideoPbFragment.this.mfF.start();
                        }
                        boolean z = !at.equals(VideoPbFragment.this.mfE.getVideoUrl(), bzVar.brH().video_url);
                        VideoPbFragment.this.mfE.setData(bzVar);
                        if (com.baidu.tbadk.a.d.bmH()) {
                            VideoPbFragment.this.mfE.wj(false);
                        } else {
                            VideoPbFragment.this.mfE.wj(VideoPbFragment.this.fbv.getCurrentItem() == 0);
                        }
                        if (z) {
                            VideoPbFragment.this.mfE.startPlay();
                            VideoPbFragment.this.mfE.dwW();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.mfE.setData(bzVar);
                }
            }
        });
        videoPbViewModel.dwh().observe(this, new Observer<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: u */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.fbv.setCurrentItem(num.intValue());
            }
        });
        videoPbViewModel.dwc().observe(this, new Observer<bz>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aR */
            public void onChanged(@Nullable bz bzVar) {
                VideoPbFragment.this.mfE.aV(bzVar);
            }
        });
        videoPbViewModel.dwd().observe(this, new Observer<bz>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aR */
            public void onChanged(@Nullable bz bzVar) {
                VideoPbFragment.this.mfE.aW(bzVar);
            }
        });
        videoPbViewModel.dwe().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: s */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.dvD();
            }
        });
        videoPbViewModel.dwf().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: s */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvs() {
        ViewGroup.LayoutParams layoutParams = this.mfH.getLayoutParams();
        layoutParams.height = 0;
        this.mfH.setLayoutParams(layoutParams);
        this.mfH.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvt() {
        if (this.mfF == null) {
            this.mfF = new e(getBaseFragmentActivity(), this.mfD);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(dpD()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.mfD.getOriginHeight() + statusBarHeight);
            final VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.mfF.b(videoPbViewModel.dvZ(), rect);
            if (this.mfF.dwl()) {
                this.mfF.c(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (com.baidu.tbadk.a.d.bmH()) {
                            if (videoPbViewModel.dwa() || VideoPbFragment.this.dnV().dqV() == VideoPbFragment.mfx) {
                                VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfx);
                            }
                        } else if (videoPbViewModel.dwa() || VideoPbFragment.this.dnV().dqV() == VideoPbFragment.mfw) {
                            VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfw);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (com.baidu.tbadk.a.d.bmH()) {
                            if (videoPbViewModel.dwa() || VideoPbFragment.this.dnV().dqV() == VideoPbFragment.mfx) {
                                VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfx);
                            }
                        } else if (videoPbViewModel.dwa() || VideoPbFragment.this.dnV().dqV() == VideoPbFragment.mfw) {
                            VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfw);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (com.baidu.tbadk.a.d.bmH()) {
                if (videoPbViewModel.dwa() || dnV().dqV() == mfx) {
                    this.fbv.setCurrentItem(mfx);
                }
            } else if (videoPbViewModel.dwa() || dnV().dqV() == mfw) {
                this.fbv.setCurrentItem(mfw);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.mfX && (this.mfY || dvR())) {
            dvQ();
            UtilHelper.hideStatusBar(dpD(), dpD().getRootView());
            this.mfY = false;
            if (this.mfE != null) {
                this.mfE.wb(false);
            }
        }
        if (i == 4) {
            return this.mfE.dCj();
        }
        if (i == 24) {
            return this.mfE.dwT();
        }
        if (i == 25) {
            return this.mfE.dwU();
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
        Rect dqU;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bzVar != null && bzVar.brH() != null) {
            int intValue = bzVar.brH().video_width.intValue();
            int intValue2 = bzVar.brH().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (dnV() != null || (dqU = dnV().dqU()) == null) ? ceil : dqU.height();
                i = 0;
                layoutParams = this.mfD.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.mfD.setLayoutParams(layoutParams);
                this.mfD.setMaxHeight(ceil);
                this.mfD.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.mfD.setOriginHeight(height);
                if (!com.baidu.tbadk.a.d.bmH()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mfz.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, mfy);
                    } else {
                        layoutParams3.height = mfy;
                    }
                    this.mfz.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.ZS.getLayoutParams();
                if (!com.baidu.tbadk.a.d.bmH()) {
                    ceil += mfy;
                }
                if (layoutParams2 != null) {
                    layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                } else {
                    layoutParams2.height = ceil;
                }
                this.ZS.setLayoutParams(layoutParams2);
                if (i == 0 && (this.ZS.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.ZS.getLayoutParams()).getBehavior();
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
        if (dnV() != null) {
        }
        i = 0;
        layoutParams = this.mfD.getLayoutParams();
        if (layoutParams != null) {
        }
        this.mfD.setLayoutParams(layoutParams);
        this.mfD.setMaxHeight(ceil2);
        this.mfD.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.mfD.setOriginHeight(height);
        if (!com.baidu.tbadk.a.d.bmH()) {
        }
        layoutParams2 = (CoordinatorLayout.LayoutParams) this.ZS.getLayoutParams();
        if (!com.baidu.tbadk.a.d.bmH()) {
        }
        if (layoutParams2 != null) {
        }
        this.ZS.setLayoutParams(layoutParams2);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.lMM = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        at(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.lNE = new com.baidu.tbadk.core.view.c();
        this.lNE.toastTime = 1000L;
        if (this.mfR != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.mfR.lNF;
            userMuteAddAndDelCustomMessage.setTag(this.mfR.lNF);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.mfR.lNF;
            userMuteCheckCustomMessage.setTag(this.mfR.lNF);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.iwL = new com.baidu.tieba.callfans.a(getPageContext());
        com.baidu.tieba.s.c.dNX().z(getUniqueId());
    }

    private void initData() {
        this.lNj = com.baidu.tbadk.baseEditMark.a.a(this.lME);
        if (this.lNj != null) {
            this.lNj.a(this.lOp);
        }
        this.ggJ = new ForumManageModel(this.lME);
        this.ggJ.setLoadDataCallBack(this.iwQ);
        this.fcZ = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.mfR = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void at(Bundle bundle) {
        this.lNw = new g();
        d(this.lNw);
        this.lNx = (com.baidu.tbadk.editortools.pb.e) this.lNw.fj(getActivity());
        this.lNx.a(this.lME.getPageContext());
        this.lNx.a(this.fGo);
        this.lNx.a(this.fGh);
        this.lNx.setFrom(1);
        this.lNx.a(this.lME.getPageContext(), bundle);
        this.lNx.bEI().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lNx.bEI().kO(true);
        uN(true);
        this.lNx.a(dnV().dqn(), dnV().dpW(), dnV().dqE());
        registerListener(this.lNU);
        registerListener(this.lOo);
        registerListener(this.lNT);
        registerListener(this.lNR);
        registerListener(this.jgK);
        if (!dnV().dqe()) {
            this.lNx.DS(dnV().dpW());
        }
        if (dnV().dqF()) {
            this.lNx.DQ(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.lNx.DQ(drQ());
        }
        this.kSQ = new ar();
        if (this.lNx.bFo() != null) {
            this.kSQ.f(this.lNx.bFo().getInputView());
        }
        this.lNx.a(this.fGi);
        this.kON = new al(getPageContext());
        this.kON.a(new al.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // com.baidu.tbadk.core.util.al.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == al.fcU) {
                        VideoPbFragment.this.lNx.a((String) null, (WriteData) null);
                    } else if (i == al.fcV && VideoPbFragment.this.lVM != null && VideoPbFragment.this.lVM.doI() != null) {
                        VideoPbFragment.this.lVM.doI().bFM();
                    } else if (i == al.fcW) {
                        VideoPbFragment.this.c(VideoPbFragment.this.lNA);
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
        this.jkd = new com.baidu.tieba.f.b(getActivity());
        this.jkd.a(lOx);
        this.mfX = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        bIk();
        this.ZS = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.mfB = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.mfD = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.mfE = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.mfD);
        this.mfE.setStageType("2002");
        this.mfE.setUniqueId(getUniqueId());
        this.mfE.af(this);
        this.mfE.dV(dpD().getRootView());
        this.mfE.dW(this.mfG);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.mfz = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.mfH = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.fbv = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.mfC = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.mfC.setOnClickListener(this.aHh);
        dvv();
        dvu();
        dvw();
        this.mfA = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.fbv.setAdapter(this.mfA);
        this.mfz.setViewPager(this.fbv);
        this.mfz.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (com.baidu.tbadk.a.d.bmH() && VideoPbFragment.this.dvM() != null) {
                        VideoPbFragment.this.dvM().wi(false);
                    } else if (VideoPbFragment.this.dvK() != null) {
                        VideoPbFragment.this.dvK().wi(false);
                    }
                    if (VideoPbFragment.this.dvL() != null) {
                        VideoPbFragment.this.dvL().wi(true);
                        VideoPbFragment.this.HI(VideoPbFragment.this.dvL().dwz() != 0 ? 0 : 8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(VideoPbFragment.this.getActivity()).get(VideoPbViewModel.class);
                    if (videoPbViewModel.dwe() != null && videoPbViewModel.dwe().getValue() != null && videoPbViewModel.dwe().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.mfE.wj(z);
                    VideoPbFragment.this.drO();
                    if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null) {
                        TiebaStatic.log(new aq("c13592").dX("tid", VideoPbFragment.this.dnV().dpW()).dX("fid", VideoPbFragment.this.dnV().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.dvL() != null) {
                        VideoPbFragment.this.dvL().wi(false);
                    }
                    if (com.baidu.tbadk.a.d.bmH() && VideoPbFragment.this.dvM() != null) {
                        VideoPbFragment.this.dvM().wi(true);
                        int dwz = VideoPbFragment.this.dvM().dwz();
                        int dwA = VideoPbFragment.this.dvM().dwA();
                        if (dwz != 0) {
                            VideoPbFragment.this.HI(8);
                            VideoPbFragment.this.dvM().HI(0);
                        } else if (dwA != 0) {
                            VideoPbFragment.this.dvM().HI(8);
                            VideoPbFragment.this.HI(0);
                        } else {
                            VideoPbFragment.this.dvM().HI(8);
                            VideoPbFragment.this.HI(8);
                        }
                    } else if (VideoPbFragment.this.dvK() != null) {
                        VideoPbFragment.this.dvK().wi(true);
                        int dwz2 = VideoPbFragment.this.dvK().dwz();
                        int dwA2 = VideoPbFragment.this.dvK().dwA();
                        if (dwz2 != 0) {
                            VideoPbFragment.this.HI(8);
                            VideoPbFragment.this.dvK().HI(0);
                        } else if (dwA2 != 0) {
                            VideoPbFragment.this.dvK().HI(8);
                            VideoPbFragment.this.HI(0);
                        } else {
                            VideoPbFragment.this.dvK().HI(8);
                            VideoPbFragment.this.HI(8);
                        }
                    }
                    VideoPbFragment.this.mfE.wj(false);
                    VideoPbFragment.this.ZS.setExpanded(false, true);
                    if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null) {
                        TiebaStatic.log(new aq("c13593").dX("tid", VideoPbFragment.this.dnV().dpW()).dX("fid", VideoPbFragment.this.dnV().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.mfA.HK(i);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.lUL = this.rootView.findViewById(R.id.viewstub_progress);
        dvx();
        bZA();
        if (!this.mfX && this.mfY) {
            dvQ();
            UtilHelper.hideStatusBar(dpD(), dpD().getRootView());
            this.mfY = false;
        }
        if (com.baidu.tbadk.a.d.bmH()) {
            this.mfz.getLayoutParams().height = 0;
        }
    }

    private void dvu() {
        this.mfJ = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.mfN = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.mfK = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.mfL = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.mfM = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.mfO = this.rootView.findViewById(R.id.ala_live_point);
        this.mfN.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.mfN.setConrers(15);
        this.mfM.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.mfL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.lGB == null || VideoPbFragment.this.lGB.dwL()) {
                    if (VideoPbFragment.this.lGB != null) {
                        TiebaStatic.log(new aq("c13608").dX("tid", VideoPbFragment.this.dnV().getPbData().getThreadId()));
                        VideoPbFragment.this.lGB.mhU = true;
                    }
                } else {
                    TiebaStatic.log(new aq("c13591"));
                }
                VideoPbFragment.this.dvF();
            }
        });
        this.mfM.setOnClickListener(this.mfI);
        this.mfH.setOnClickListener(this.mfI);
    }

    private void dvv() {
        this.mfz.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.mfz.setContainerLayoutParams(layoutParams);
        this.mfz.setRectPaintColor(R.color.CAM_X0302);
        this.mfz.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.mfz.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.mfz.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.mfz.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.mfz.setExpandedTabLayoutParams(layoutParams2);
    }

    public void wa(boolean z) {
        if (this.ZS != null) {
            this.ZS.setExpanded(z);
        }
    }

    private void dvw() {
        this.lVd = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.lVe = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.lVo = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lVp = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lVg = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lVg.setVisibility(0);
        this.lVg.setIsRound(true);
        this.lVg.setBorderWidth(l.getDimens(getContext(), R.dimen.L_X01));
        this.lVg.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.lVg.setPlaceHolder(0);
        drU();
        this.klE = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lVf = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lVf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.wa(false);
                VideoPbFragment.this.doU();
                if (VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null && VideoPbFragment.this.dnV().getPbData().dmE() != null && VideoPbFragment.this.dnV().getPbData().dmE().brq() != null) {
                    TiebaStatic.log(new aq("c13701").dX("tid", VideoPbFragment.this.dnV().dpX()).dX("fid", VideoPbFragment.this.dnV().getPbData().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new aq("c13402").dX("tid", VideoPbFragment.this.dnV().dpW()).dX("fid", VideoPbFragment.this.dnV().getPbData().getForumId()).an("obj_locate", 1).dX("uid", VideoPbFragment.this.dnV().getPbData().dmE().brq().getUserId()));
                }
            }
        });
        this.lVh = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lVh.setOnClickListener(this.aHh);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lVi = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.lVi.setOnClickListener(this.aHh);
        if (booleanExtra) {
            this.lVi.setVisibility(8);
        } else {
            this.lVi.setVisibility(0);
        }
        this.lVj = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.lVj.setOnClickListener(this.aHh);
        this.lVk = new com.baidu.tieba.pb.view.d(this.lVj);
        this.lVk.dxf();
        this.lVl = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lVl.setVisibility(0);
        vz(false);
    }

    private void drU() {
        if (this.lVg != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lVg.setImageResource(0);
            this.lVg.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.lVg.setImageResource(R.drawable.transparent_bg);
    }

    private void bIk() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cFA();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.mfG = this.rootView.findViewById(R.id.status_bar_background);
        if (this.mfX) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(dpD());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.mfG.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(dpD());
            this.mfG.setLayoutParams(layoutParams2);
            this.mfG.setVisibility(0);
        }
        this.fOs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aHh);
        this.gZY = (ImageView) this.fOs.findViewById(R.id.widget_navi_back_button);
        SvgManager.bwq().a(this.gZY, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jvO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aHh);
        this.aiG = (ImageView) this.jvO.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.jvO.setLayoutParams(layoutParams3);
        SvgManager.bwq().a(this.aiG, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jvO.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.jrz);
        this.mNavigationBar.setOnTouchListener(this.mfZ);
    }

    public void dvx() {
        setEditorTools(this.lNx.bEI());
    }

    private void bZA() {
        this.lMz = new PbFakeFloorModel(getPageContext());
        this.lVM = new r(getPageContext(), this.lMz, this.rootView);
        this.lVM.V(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.drO();
            }
        });
        this.lVM.a(this.lOl);
        this.lMz.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.lMz.u(postData);
                if (com.baidu.tbadk.a.d.bmH() || VideoPbFragment.this.dvM() != null) {
                    VideoPbFragment.this.dvM().dwv();
                } else if (VideoPbFragment.this.dvK() != null) {
                    VideoPbFragment.this.dvK().dwv();
                }
                VideoPbFragment.this.lVM.doE();
                VideoPbFragment.this.acZ.bDe();
                VideoPbFragment.this.vz(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, PostData postData2, boolean z, boolean z2) {
        PbActivity.a PN;
        String dpW = dnV().dpW();
        String id = postData.getId();
        String str = "";
        if (postData2 != null) {
            str = postData2.getId();
        }
        int i = 0;
        if (dnV().getPbData() != null) {
            i = dnV().getPbData().dmT();
        }
        if (dvK() != null && dvK().dwx() != null) {
            PN = dvK().dwx().PN(id);
        } else if (dvM() != null && dvM().dwx() != null) {
            PN = dvM().dwx().PN(id);
        } else {
            return;
        }
        if (postData != null && dnV() != null && dnV().getPbData() != null && PN != null) {
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dpW, id, "pb", true, null, false, str, i, postData.duO(), dnV().getPbData().getAnti(), false, postData.brq().getIconInfo()).addBigImageData(PN.lJl, PN.eMr, PN.eMp, PN.index);
            if (z2) {
                addBigImageData.setHighLightPostId(str);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(dnV().getForumId());
            addBigImageData.setBjhData(dnV().dqg());
            addBigImageData.setKeyPageStartFrom(dnV().dqH());
            addBigImageData.setFromFrsForumId(dnV().getFromForumId());
            addBigImageData.setIsOpenEditor(z);
            if (dnV().getPbData().dnn() != null) {
                addBigImageData.setHasForumRule(dnV().getPbData().dnn().has_forum_rule.intValue());
            }
            if (dnV().getPbData().getUserData() != null) {
                addBigImageData.setIsManager(dnV().getPbData().getUserData().getIs_manager());
            }
            if (dnV().getPbData().getForum().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(dnV().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(dnV().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (dnV().getPbData().getForum() != null) {
                addBigImageData.setForumHeadUrl(dnV().getPbData().getForum().getImage_url());
                addBigImageData.setUserLevel(dnV().getPbData().getForum().getUser_level());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lME = (PbActivity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (dnV() != null) {
            dnV().aD(bundle);
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
        this.mfE.sg(true);
        if (dnV() != null && !dnV().dqe()) {
            this.lNx.DR(dnV().dpW());
        }
        com.baidu.tbadk.BdToken.c.bkT().ble();
        MessageManager.getInstance().unRegisterListener(this.lOe);
        MessageManager.getInstance().unRegisterListener(this.lOf);
        MessageManager.getInstance().unRegisterListener(this.lOg);
        MessageManager.getInstance().unRegisterListener(this.jtD);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        getVoiceManager().onResume(getPageContext());
        this.mfE.sg(false);
        dpz();
        registerListener(this.lOe);
        registerListener(this.lOf);
        registerListener(this.lOg);
        registerListener(this.jtD);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.mfA != null && this.fbv != null) {
            this.mfA.HK(z ? this.fbv.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        drU();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.dNX().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dNX().A(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.lVk != null) {
            this.lVk.onDestroy();
        }
        if (this.ggJ != null) {
            this.ggJ.cancelLoadData();
        }
        if (this.mfE != null) {
            this.mfE.onDestroy();
        }
        if (this.lMX != null) {
            this.lMX.cancelLoadData();
        }
        if (this.kON != null) {
            this.kON.onDestroy();
        }
        if (dnV() != null) {
            dnV().cancelLoadData();
            dnV().destory();
            if (dnV().dqB() != null) {
                dnV().dqB().onDestroy();
            }
        }
        if (this.lNx != null) {
            this.lNx.onDestroy();
        }
        this.lNE = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.lME);
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        ao.setBackgroundColor(this.mStatusBar, R.color.CAM_X0611);
        ao.setBackgroundColor(this.mfG, R.color.CAM_X0608);
        ao.setBackgroundColor(this.mfz, R.color.CAM_X0207);
        if (this.mfz != null) {
            this.mfz.onChangeSkinType();
        }
        if (this.kSQ != null) {
            this.kSQ.onChangeSkinType();
        }
        if (this.mfF == null || !this.mfF.isPlaying()) {
            ao.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        }
        if (this.acZ != null) {
            this.acZ.onChangeSkinType(i);
        }
        if (this.lVM != null) {
            this.lVM.onChangeSkinType(i);
        }
        if (this.lVg != null) {
            this.lVg.setBorderColor(ao.getColor(R.color.CAM_X0401));
        }
        if (this.lVf != null) {
            this.lVf.setBackgroundDrawable(ao.aO(l.getDimens(getContext(), R.dimen.tbds47), ao.getColor(R.color.CAM_X0209)));
        }
        if (dnV() != null && dnV().bnx()) {
            WebPManager.a(this.lVi, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.a(this.lVi, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.a(this.lVh, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        SvgManager.bwq().a(this.mfL, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (dnV() != null) {
            x(dnV().getPbData());
        }
        ao.setBackgroundResource(this.mfB, R.drawable.personalize_tab_shadow);
        ao.setBackgroundColor(this.mfH, R.color.CAM_X0206);
        ao.setBackgroundColor(this.lVe, R.color.CAM_X0207);
        ao.setBackgroundColor(this.lVd, R.color.CAM_X0203);
        ao.setViewTextColor(this.mfK, R.color.CAM_X0109);
        ao.setViewTextColor(this.mfJ, R.color.CAM_X0105);
        ao.setViewTextColor(this.klE, R.color.CAM_X0109);
        ao.setViewTextColor(this.lVm, R.color.CAM_X0105);
        ao.setViewTextColor(this.lVl, R.color.CAM_X0107);
        ao.d(this.lVl, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        if (com.baidu.tbadk.a.d.bmH() && dvM() != null) {
            dvM().onChangeSkinType(i);
        } else if (dvK() != null) {
            dvK().onChangeSkinType(i);
        }
        if (dvL() != null) {
            dvL().onChangeSkinType(i);
        }
        if (this.mfO != null) {
            this.mfO.setBackgroundDrawable(ao.aO(l.getDimens(this.mfO.getContext(), R.dimen.tbds32), ao.getColor(R.color.CAM_X0309)));
        }
        cFz();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jfh == null) {
            this.jfh = VoiceManager.instance();
        }
        return this.jfh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFz() {
        if (this.jfh != null) {
            this.jfh.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dpB() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dpC() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dnV() {
        return this.lME.dnV();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dpD() {
        return this.lME;
    }

    public com.baidu.tbadk.baseEditMark.a dvy() {
        return this.lNj;
    }

    public View.OnClickListener dvz() {
        return this.aHh;
    }

    public View.OnClickListener dvA() {
        return this.lJS;
    }

    public View.OnLongClickListener dvB() {
        return this.mOnLongClickListener;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (au.Qc(objArr[i].getLink()) && (drawable = ao.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView cIs() {
        Iterator<BaseFragment> it = this.mfA.dvV().iterator();
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

    private void uN(boolean z) {
        this.lNx.kW(z);
        this.lNx.kX(z);
        this.lNx.kY(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.mfR != null) {
            if (z) {
                this.mfR.dsG();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.mfR.dsH();
            } else {
                this.mfR.dsG();
            }
        }
    }

    public boolean GV(int i) {
        if (this.kON == null || dnV() == null || dnV().getPbData() == null || dnV().getPbData().getAnti() == null) {
            return true;
        }
        return this.kON.aN(dnV().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean doW() {
        if ((dnV() != null && dnV().getPbData().dnh()) || this.kON == null || dnV() == null || dnV().getPbData() == null || dnV().getPbData().getAnti() == null) {
            return true;
        }
        return this.kON.pZ(dnV().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && dnV() != null) {
            gVar.setForumName(dnV().dnO());
            if (dnV().getPbData() != null && dnV().getPbData().getForum() != null) {
                gVar.a(dnV().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(dnV());
        }
    }

    public void dsf() {
        if (this.acZ != null) {
            this.acZ.rV();
            if (this.lNx != null) {
                this.lNx.bFt();
            }
            dsP();
        }
    }

    public com.baidu.tbadk.editortools.pb.e doJ() {
        return this.lNx;
    }

    private boolean doT() {
        PbModel dnV = dnV();
        if (dnV == null || dnV.getPbData() == null) {
            return false;
        }
        bz dmE = dnV.getPbData().dmE();
        dnV.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), dmE);
    }

    public void doU() {
        if (checkUpIsLogin() && dnV() != null && dnV().getPbData() != null && dnV().getPbData().getForum() != null && !doT()) {
            if (dnV().getPbData().dnh()) {
                cUe();
                return;
            }
            if (this.jjD == null) {
                this.jjD = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jjD.BA(0);
                this.jjD.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qG(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void B(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qH(boolean z) {
                        if (z) {
                            if (VideoPbFragment.this.lNx != null && VideoPbFragment.this.lNx.bEI() != null) {
                                VideoPbFragment.this.lNx.bEI().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            VideoPbFragment.this.cUe();
                        }
                    }
                });
            }
            this.jjD.H(dnV().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dnV().dpW(), 0L));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.lNx.onActivityResult(i, i2, intent);
        if (this.lMX != null) {
            this.lMX.onActivityResult(i, i2, intent);
        }
        if (this.lVM != null) {
            this.lVM.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dpg();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dEA().E(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.lNA = emotionImageData;
                        if (GV(al.fcW)) {
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
        if (dpD() != null) {
            if (this.mfY && !TbSingleton.getInstance().isNotchScreen(dpD()) && !TbSingleton.getInstance().isCutoutScreen(dpD())) {
                dvQ();
                UtilHelper.hideStatusBar(dpD(), dpD().getRootView());
                this.mfY = false;
            }
            this.mfS.mgn = z;
            dvC();
            dvD();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.lME;
        if (i == 0) {
            drK();
            if (this.lVM != null) {
                this.lVM.doE();
            }
            vz(false);
        }
        drO();
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
                        this.lNx.resetData();
                        this.lNx.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lNx.c(writeData);
                        m sv = this.lNx.bEI().sv(6);
                        if (sv != null && sv.fDH != null) {
                            sv.fDH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lME;
                        if (i == -1) {
                            this.lNx.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lVM != null && this.lVM.doI() != null) {
                            com.baidu.tbadk.editortools.pb.h doI = this.lVM.doI();
                            doI.setThreadData(dnV().getPbData().dmE());
                            doI.c(writeData);
                            doI.setVoiceModel(pbEditorData.getVoiceModel());
                            m sv2 = doI.bEI().sv(6);
                            if (sv2 != null && sv2.fDH != null) {
                                sv2.fDH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lME;
                            if (i == -1) {
                                doI.bFM();
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
                if (dnV() != null && !dnV().dqe()) {
                    antiData.setBlock_forum_name(dnV().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(dnV().getPbData().getForum().getId());
                    antiData.setUser_name(dnV().getPbData().getUserData().getUserName());
                    antiData.setUser_id(dnV().getPbData().getUserData().getUserId());
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
        if (AntiHelper.bP(i, str)) {
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
            if (this.mfR != null) {
                this.mfR.DX(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void dpF() {
        if (dnV() != null && this.lME != null) {
            if (this.lNx == null || !this.lNx.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.lNx = (com.baidu.tbadk.editortools.pb.e) dVar.fj(getContext());
                this.lNx.a(this.lME.getPageContext());
                this.lNx.a(this.fGo);
                this.lNx.a(this.fGh);
                this.lNx.a(this.lME.getPageContext(), this.lME.getIntent() == null ? null : this.lME.getIntent().getExtras());
                this.lNx.bEI().kO(true);
                setEditorTools(this.lNx.bEI());
                if (!dnV().dqe()) {
                    this.lNx.DS(dnV().dpW());
                }
                if (dnV().dqF()) {
                    this.lNx.DQ(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.lNx.DQ(drQ());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acZ = editorTools;
        this.acZ.setId(R.id.pb_editor);
        this.acZ.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.drO();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.acZ.getParent() == null) {
            this.rootView.addView(this.acZ, layoutParams);
        }
        this.acZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.acZ.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof u) {
                    if (((u) aVar.data).bzW() == EmotionGroupType.BIG_EMOTION || ((u) aVar.data).bzW() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.lNx.c((u) aVar.data);
                            VideoPbFragment.this.lNx.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        drK();
        this.lNx.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.acZ != null && VideoPbFragment.this.acZ.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.kSQ != null && VideoPbFragment.this.kSQ.dti() != null) {
                    if (!VideoPbFragment.this.kSQ.dti().dXT()) {
                        VideoPbFragment.this.kSQ.vF(false);
                    }
                    VideoPbFragment.this.kSQ.dti().zc(false);
                }
            }
        });
    }

    public void cUe() {
        if (!checkUpIsLogin()) {
            if (dnV() != null) {
                TiebaStatic.log(new aq("c10517").an("obj_locate", 2).dX("fid", dnV().getForumId()));
            }
        } else if (doW()) {
            if (this.lNx != null && (this.lNx.bFD() || this.lNx.bFE())) {
                this.lNx.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.acZ != null) {
                dsf();
                this.mfS.mgm = false;
                if (this.acZ.sv(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.acZ.sv(2).fDH, false, null);
                }
            }
            dsP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !doT() && doW()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lMZ);
                this.lNa = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.lVM != null && postData != null) {
                String str3 = "";
                if (postData.dPf() != null) {
                    str3 = postData.dPf().toString();
                }
                this.lVM.PH(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.brq().getName_show(), str3));
            }
            if (dnV() != null && dnV().getPbData() != null && dnV().getPbData().dnh()) {
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.lME.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.lMZ[1] + VideoPbFragment.this.lNa) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cIs() != null) {
                            VideoPbFragment.this.cIs().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.lVM != null) {
                            VideoPbFragment.this.lNx.bEI().setVisibility(8);
                            VideoPbFragment.this.lVM.j(str, str2, VideoPbFragment.this.drQ(), (VideoPbFragment.this.dnV() == null || VideoPbFragment.this.dnV().getPbData() == null || VideoPbFragment.this.dnV().getPbData().dmE() == null || !VideoPbFragment.this.dnV().getPbData().dmE().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h doI = VideoPbFragment.this.lVM.doI();
                            if (doI != null && VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null) {
                                doI.a(VideoPbFragment.this.dnV().getPbData().getAnti());
                                doI.setThreadData(VideoPbFragment.this.dnV().getPbData().dmE());
                            }
                            if (VideoPbFragment.this.kSQ.dtk() == null && VideoPbFragment.this.lVM.doI().bFU() != null) {
                                VideoPbFragment.this.lVM.doI().bFU().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kSQ != null && VideoPbFragment.this.kSQ.dtj() != null) {
                                            if (!VideoPbFragment.this.kSQ.dtj().dXT()) {
                                                VideoPbFragment.this.kSQ.vG(false);
                                            }
                                            VideoPbFragment.this.kSQ.dtj().zc(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kSQ.g(VideoPbFragment.this.lVM.doI().bFU().getInputView());
                                VideoPbFragment.this.lVM.doI().a(VideoPbFragment.this.lNC);
                            }
                        }
                        VideoPbFragment.this.dsP();
                    }
                }, 0L);
                return;
            }
            if (this.lNz == null) {
                this.lNz = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lNz.BA(1);
                this.lNz.a(new AnonymousClass49(str, str2));
            }
            if (dnV() != null && dnV().getPbData() != null && dnV().getPbData().getForum() != null) {
                this.lNz.H(dnV().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dnV().dpW(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$49  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass49 implements c.a {
        final /* synthetic */ String lOH;
        final /* synthetic */ String lOI;

        AnonymousClass49(String str, String str2) {
            this.lOH = str;
            this.lOI = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qG(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void B(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qH(boolean z) {
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
                        int i = (VideoPbFragment.this.lMZ[1] + VideoPbFragment.this.lNa) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cIs() != null) {
                            VideoPbFragment.this.cIs().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.lVM != null) {
                            VideoPbFragment.this.lNx.bEI().setVisibility(8);
                            VideoPbFragment.this.lVM.j(AnonymousClass49.this.lOH, AnonymousClass49.this.lOI, VideoPbFragment.this.drQ(), (VideoPbFragment.this.dnV() == null || VideoPbFragment.this.dnV().getPbData() == null || VideoPbFragment.this.dnV().getPbData().dmE() == null || !VideoPbFragment.this.dnV().getPbData().dmE().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h doI = VideoPbFragment.this.lVM.doI();
                            if (doI != null && VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null) {
                                doI.a(VideoPbFragment.this.dnV().getPbData().getAnti());
                                doI.setThreadData(VideoPbFragment.this.dnV().getPbData().dmE());
                            }
                            if (VideoPbFragment.this.kSQ.dtk() == null && VideoPbFragment.this.lVM.doI().bFU() != null) {
                                VideoPbFragment.this.lVM.doI().bFU().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kSQ != null && VideoPbFragment.this.kSQ.dtj() != null) {
                                            if (!VideoPbFragment.this.kSQ.dtj().dXT()) {
                                                VideoPbFragment.this.kSQ.vG(false);
                                            }
                                            VideoPbFragment.this.kSQ.dtj().zc(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kSQ.g(VideoPbFragment.this.lVM.doI().bFU().getInputView());
                                VideoPbFragment.this.lVM.doI().a(VideoPbFragment.this.lNC);
                            }
                        }
                        VideoPbFragment.this.dsP();
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
            String userId = L.brq().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, L.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dmT()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (L.brq() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, L.brq().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, L.brq().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, L.brq().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, L.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, L.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dmT()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bv> dnb = fVar.dnb();
                if (x.getCount(dnb) > 0) {
                    sb = new StringBuilder();
                    for (bv bvVar : dnb) {
                        if (bvVar != null && !StringUtils.isNull(bvVar.getForumName()) && (acVar = bvVar.eSl) != null && acVar.ePV && !acVar.ePW && (acVar.type == 1 || acVar.type == 2)) {
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
    public void dpg() {
        MarkData Hi;
        if (dnV() != null && dnV().getPbData() != null) {
            if (com.baidu.tbadk.a.d.bmH() || dvK() != null) {
                if ((!com.baidu.tbadk.a.d.bmH() || dvM() != null) && this.lNj != null) {
                    if (dnV().getPbData() != null && dnV().getPbData().dnh()) {
                        Hi = dnV().Hi(0);
                    } else if (this.fbv != null && this.fbv.getCurrentItem() == mfv) {
                        Hi = dnV().o(L(dnV().getPbData()));
                    } else if (com.baidu.tbadk.a.d.bmH()) {
                        Hi = dnV().Hi(dvM().dss());
                    } else {
                        Hi = dnV().Hi(dvK().dss());
                    }
                    if (Hi != null) {
                        if (!Hi.isApp() || (Hi = dnV().Hi(dvK().dss() + 1)) != null) {
                            dsn();
                            this.lNj.a(Hi);
                            if (!this.lNj.bnx()) {
                                this.lNj.bnz();
                                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                                return;
                            }
                            this.lNj.bny();
                            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GX(int i) {
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
            if (this.lMX == null) {
                this.lMX = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lME);
                this.lMX.b(this.fGh);
                this.lMX.c(this.fGo);
            }
            this.lMX.a(emotionImageData, dnV(), dnV().getPbData());
        }
    }

    public PostData L(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dmR() != null) {
            return fVar.dmR();
        }
        if (!x.isEmpty(fVar.dmG())) {
            Iterator<PostData> it = fVar.dmG().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dPd() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dmN();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.brq() != null && postData.brq().getUserTbVipInfoData() != null && postData.brq().getUserTbVipInfoData().getvipIntro() != null) {
            postData.brq().getGodUserData().setIntro(postData.brq().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dmE() == null || fVar.dmE().brq() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData brq = fVar.dmE().brq();
        String userId = brq.getUserId();
        HashMap<String, MetaData> userMap = fVar.dmE().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = brq;
        }
        postData.KR(1);
        postData.setId(fVar.dmE().brG());
        postData.setTitle(fVar.dmE().getTitle());
        postData.setTime(fVar.dmE().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dpl() {
        ArrayList<PostData> dmG;
        int count;
        int i;
        if (dnV() == null || dnV().getPbData() == null || dnV().getPbData().dmG() == null || (count = x.getCount((dmG = dnV().getPbData().dmG()))) == 0) {
            return "";
        }
        if (dnV().dqp()) {
            Iterator<PostData> it = dmG.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dPd() == 1) {
                    return next.getId();
                }
            }
        }
        if (cIs() == null) {
            i = 0;
        } else if (com.baidu.tbadk.a.d.bmH()) {
            i = dvM().dsr();
        } else {
            i = dvK().dsr();
        }
        PostData postData = (PostData) x.getItem(dmG, i);
        if (postData == null || postData.brq() == null) {
            return "";
        }
        if (dnV().PQ(postData.brq().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) x.getItem(dmG, i2);
            if (postData2 == null || postData2.brq() == null || postData2.brq().getUserId() == null) {
                break;
            } else if (dnV().PQ(postData2.brq().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) x.getItem(dmG, i3);
            if (postData3 == null || postData3.brq() == null || postData3.brq().getUserId() == null) {
                return "";
            }
            if (dnV().PQ(postData3.brq().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dph() {
        if (dnV() != null) {
            com.baidu.tieba.pb.data.f pbData = dnV().getPbData();
            dnV().vd(true);
            if (this.lNj != null) {
                pbData.PB(this.lNj.bnw());
            }
            if (com.baidu.tbadk.a.d.bmH() && dvM() != null) {
                dvM().dwv();
            } else if (dvK() != null) {
                dvK().dwv();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (dnV() != null) {
            dsp();
            dnV().vd(z);
            if (this.lNj != null) {
                this.lNj.jc(z);
                if (markData != null) {
                    this.lNj.a(markData);
                }
            }
            if (dnV().bnx()) {
                dph();
            } else if (com.baidu.tbadk.a.d.bmH() && dvM() != null) {
                dvM().dwv();
            } else if (dvK() != null) {
                dvK().dwv();
            }
        }
    }

    public void b(p pVar) {
        boolean z;
        MetaData metaData;
        if (dnV() != null && dnV().getPbData() != null && pVar.dnx() != null) {
            String id = pVar.dnx().getId();
            ArrayList<PostData> dmG = dnV().getPbData().dmG();
            int i = 0;
            while (true) {
                if (i >= dmG.size()) {
                    z = true;
                    break;
                }
                PostData postData = dmG.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dnF = pVar.dnF();
                    postData.KQ(pVar.getTotalCount());
                    if (postData.dPa() == null || dnF == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dnF.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.brq() != null && (metaData = postData.getUserMap().get(next.brq().getUserId())) != null) {
                                next.a(metaData);
                                next.yh(true);
                                next.a(getPageContext(), dnV().PQ(metaData.getUserId()));
                            }
                        }
                        z = dnF.size() != postData.dPa().size();
                        if (postData.dPa() != null && postData.dPa().size() < 2) {
                            postData.dPa().clear();
                            postData.dPa().addAll(dnF);
                        }
                    }
                    if (postData.dOW() != null) {
                        postData.dOX();
                    }
                }
            }
            if (!dnV().getIsFromMark() && z) {
                if (com.baidu.tbadk.a.d.bmH() && dvM() != null) {
                    dvM().dwv();
                } else if (dvK() != null) {
                    dvK().dwv();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doY() {
        if (dnV() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.Sz(dnV().getForumId()) && dnV().getPbData() != null && dnV().getPbData().getForum() != null) {
            if (dnV().getPbData().getForum().isLike() == 1) {
                dnV().dqD().gk(dnV().getForumId(), dnV().dpW());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            bz dmE = fVar.dmE();
            if (dmE != null && dmE.bpZ()) {
                dpF();
            } else {
                d(this.lNw);
            }
            if (this.lNx != null) {
                vx(this.lNx.bFw());
                this.lNx.a(fVar.getAnti());
                this.lNx.a(fVar.getForum(), fVar.getUserData());
                this.lNx.setThreadData(dmE);
                if (dnV() != null) {
                    this.lNx.a(dnV().dqn(), dnV().dpW(), dnV().dqE());
                }
                if (dmE != null) {
                    this.lNx.kZ(dmE.bsQ());
                }
            }
        }
    }

    public void drO() {
        reset();
        drK();
        this.lVM.doE();
        vz(false);
    }

    private void reset() {
        if (this.lNx != null && this.acZ != null) {
            com.baidu.tbadk.editortools.pb.a.bFl().setStatus(0);
            this.lNx.bFG();
            this.lNx.bEV();
            if (this.lNx.getWriteImagesInfo() != null) {
                this.lNx.getWriteImagesInfo().setMaxImagesAllowed(this.lNx.isBJH ? 1 : 9);
            }
            this.lNx.sF(SendView.ALL);
            this.lNx.sG(SendView.ALL);
            com.baidu.tbadk.editortools.h ss = this.acZ.ss(23);
            com.baidu.tbadk.editortools.h ss2 = this.acZ.ss(2);
            com.baidu.tbadk.editortools.h ss3 = this.acZ.ss(5);
            if (ss2 != null) {
                ss2.rV();
            }
            if (ss3 != null) {
                ss3.rV();
            }
            if (ss != null) {
                ss.hide();
            }
            this.acZ.invalidate();
        }
    }

    public void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmE() != null) {
            x(fVar);
            this.lVi.setVisibility(fVar.dnh() ? 8 : 0);
            if (fVar.bnx()) {
                WebPManager.a(this.lVi, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lVi, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String Hq = Hq(fVar.dmE().brh());
            if (this.lVl != null) {
                this.lVl.setText(Hq);
            }
            if (this.lVm != null) {
                this.lVm.setText(Hq);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dmE()));
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bc(fVar.dmE())) {
            if (this.lVk != null) {
                this.lVk.setEnable(false);
                this.lVk.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.lVj.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.lVj.setLayoutParams(layoutParams);
            WebPManager.a(this.lVj, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.lVk == null || !this.lVk.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.lVj.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.lVj.setLayoutParams(layoutParams2);
            WebPManager.a(this.lVj, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    private String Hq(int i) {
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

    public void vz(boolean z) {
        if (this.lVe != null) {
            vx(this.lNx.bFw());
            if (this.lVa) {
                vo(z);
            } else {
                vp(z);
            }
            dvC();
            dvD();
        }
    }

    public void dsP() {
        if (this.lVe != null) {
            this.lVd.setVisibility(8);
            this.lVe.setVisibility(8);
            this.mfS.mgm = false;
            dvC();
            dvD();
        }
    }

    private void dvC() {
        if (this.mfE != null) {
            if (this.mfS.dvU()) {
                this.mfE.xb(false);
            } else {
                this.mfE.xb(this.mfE.isVertical() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvD() {
        if (this.mfE != null && this.fbv != null) {
            if (com.baidu.tbadk.a.d.bmH()) {
                this.mfE.wj(false);
            } else if (this.fbv.getCurrentItem() != 0) {
                this.mfE.wj(false);
            } else if (this.mfS.dvU()) {
                this.mfE.wj(false);
            } else {
                VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
                if (videoPbViewModel != null) {
                    this.mfE.wj(videoPbViewModel.dwe() == null || videoPbViewModel.dwe().getValue() == null || videoPbViewModel.dwe().getValue().booleanValue());
                }
            }
        }
    }

    private void GY(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(dpD(), doX(), i);
    }

    private int doX() {
        if (dnV() == null || dnV().getPbData() == null || dnV().getPbData().dmE() == null) {
            return -1;
        }
        return dnV().getPbData().dmE().bsd();
    }

    public void vx(boolean z) {
        this.lVa = z;
    }

    public void vo(boolean z) {
        if (this.lVe != null && this.klE != null) {
            this.klE.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lVe.startAnimation(alphaAnimation);
            }
            this.lVd.setVisibility(0);
            this.lVe.setVisibility(0);
            this.mfS.mgm = true;
        }
    }

    public void vp(boolean z) {
        if (this.lVe != null && this.klE != null) {
            this.klE.setText(drQ());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lVe.startAnimation(alphaAnimation);
            }
            this.lVd.setVisibility(0);
            this.lVe.setVisibility(0);
            this.mfS.mgm = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null && this.lGB == null) {
            this.lGB = aVar;
            this.mfJ.setText(aVar.getTitle());
            this.mfK.setText(aVar.dwI());
            String dwJ = aVar.dwJ();
            TBSpecificationBtn tBSpecificationBtn = this.mfM;
            if (TextUtils.isEmpty(dwJ)) {
                dwJ = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(dwJ);
            this.mfN.startLoad(aVar.getImage(), 10, false);
            this.mfO.setVisibility(aVar.dwL() ? 0 : 8);
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.lGB == null || VideoPbFragment.this.lGB.dwL()) {
                        if (VideoPbFragment.this.lGB != null && VideoPbFragment.this.dnV() != null && VideoPbFragment.this.dnV().getPbData() != null && VideoPbFragment.this.dnV().getPbData().getForum() != null) {
                            TiebaStatic.log(new aq("c13712").dX("fid", VideoPbFragment.this.dnV().getPbData().getForum().getId()).dX("fname", VideoPbFragment.this.dnV().getPbData().getForum().getName()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("tid", VideoPbFragment.this.dnV().getPbData().getThreadId()).w("obj_param1", VideoPbFragment.this.lGB.userId));
                        }
                    } else {
                        TiebaStatic.log(new aq("c13608").dX("obj_id", VideoPbFragment.this.lGB.getTitle()).dX("obj_name", VideoPbFragment.this.lGB.dwI()).an("obj_type", 2).dX("fid", VideoPbFragment.this.dnV().getPbData().getForumId()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("tid", VideoPbFragment.this.dnV().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.dvE();
                }
            }, aVar.dwK().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvE() {
        ViewGroup.LayoutParams layoutParams = this.mfH.getLayoutParams();
        if (layoutParams != null) {
            if (this.mfP == null || !this.mfP.isRunning()) {
                this.mfH.setAlpha(0.0f);
                this.mfH.setVisibility(0);
                f(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvF() {
        if (this.mfH.getLayoutParams() != null) {
            if (this.mfP == null || !this.mfP.isRunning()) {
                dvG();
            }
        }
    }

    private void dvG() {
        final ViewGroup.LayoutParams layoutParams = this.mfH.getLayoutParams();
        if (layoutParams != null) {
            if (this.mfQ == null || !this.mfQ.isRunning()) {
                this.mfQ = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.mfQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.mfH.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.mfQ.setDuration(200L);
                this.mfQ.start();
                this.mfQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
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
        final ViewGroup.LayoutParams layoutParams2 = this.ZS.getLayoutParams();
        final int i = layoutParams2.height;
        this.mfP = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mfP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.kin);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.kin);
                VideoPbFragment.this.mfH.setLayoutParams(layoutParams);
                VideoPbFragment.this.ZS.setLayoutParams(layoutParams2);
            }
        });
        this.mfP.setDuration(300L);
        this.mfP.start();
        this.mfP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.mfH.setVisibility(8);
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
        final ViewGroup.LayoutParams layoutParams2 = this.ZS.getLayoutParams();
        final int i = layoutParams2.height;
        this.mfP = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mfP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.kin);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.mfH.setLayoutParams(layoutParams);
                VideoPbFragment.this.ZS.setLayoutParams(layoutParams2);
            }
        });
        this.mfP.setDuration(300L);
        this.mfP.start();
        this.mfP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.dvH();
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
    public void dvH() {
        this.mfP = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mfP.setDuration(300L);
        this.mfP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.mfH.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.mfP.start();
    }

    public String drQ() {
        if (!at.isEmpty(this.lWe)) {
            return this.lWe;
        }
        this.lWe = TbadkCoreApplication.getInst().getResources().getString(com.baidu.tieba.pb.pb.main.ao.drG());
        return this.lWe;
    }

    public void dsp() {
        hideProgressBar();
        if (com.baidu.tbadk.a.d.bmH() && dvM() != null) {
            dvM().endLoadData();
            dvM().dsq();
        } else if (dvK() != null) {
            dvK().endLoadData();
            dvK().dsq();
        }
    }

    public boolean dE(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bou().isShowImages()) {
                    return PM(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (dnV() == null || dnV().getPbData() == null) {
                        return true;
                    }
                    if (this.lVM != null) {
                        this.lVM.doE();
                    }
                    p pVar = new p();
                    pVar.a(dnV().getPbData().getForum());
                    pVar.setThreadData(dnV().getPbData().dmE());
                    pVar.g(postData);
                    this.lMz.d(pVar);
                    this.lMz.setPostId(postData.getId());
                    a(view, postData.brq().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lNx != null) {
                        vx(this.lNx.bFw());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void dvI() {
        if (this.lNx != null) {
            vx(this.lNx.bFw());
        }
        drO();
        this.mfR.dsG();
    }

    private boolean PM(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bvq().getString("bubble_link", "");
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

    public void dsj() {
        if (this.lUL != null) {
            this.lUL.setVisibility(0);
        }
    }

    public void dsk() {
        if (this.lUL != null) {
            this.lUL.setVisibility(8);
        }
    }

    public void HI(int i) {
        if (this.mfB != null) {
            this.mfB.setVisibility(i);
        }
    }

    public void dsn() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a dpb() {
        return this.lOn;
    }

    public void drK() {
        if (this.acZ != null) {
            this.acZ.hide();
        }
    }

    public void cFA() {
        if (this.lME.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lME.getCurrentFocus());
        }
    }

    public void N(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmE() != null) {
            String valueOf = String.valueOf(fVar.dmE().brh());
            if (fVar.dmE().brh() == 0) {
                valueOf = "";
            }
            this.mfz.EX(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.mfA.dvV()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (dnV() != null && dnV().getPbData() != null && dnV().getPbData().dmE() != null && dnV().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(lVF)).intValue();
                if (intValue == lVG) {
                    if (!this.ggJ.dPY()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.ggJ.TD(at.S(jSONArray));
                        }
                        this.ggJ.a(dnV().getPbData().getForum().getId(), dnV().getPbData().getForum().getName(), dnV().getPbData().dmE().getId(), str, intValue3, intValue2, booleanValue, dnV().getPbData().dmE().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == lVH || intValue == lVJ) {
                    if (dnV().dqA() != null) {
                        dnV().dqA().GQ(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == lVH) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(String str, String str2) {
        be.bwu().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bLE() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bLF() {
        if (this.fWD == null) {
            this.fWD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bLR */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bou().isShowImages();
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
                        if (com.baidu.tbadk.core.k.bou().isShowImages()) {
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
        return this.fWD;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bLG() {
        if (this.fZS == null) {
            this.fZS = TbRichTextView.K(getPageContext().getPageActivity(), 8);
        }
        return this.fZS;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bLH() {
        if (this.fWE == null) {
            this.fWE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: czE */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bou().isShowImages();
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
                    if (com.baidu.tbadk.core.k.bou().isShowImages()) {
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
                    gifView.bGn();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fWE;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bLI() {
        if (this.fZT == null) {
            this.fZT = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpG */
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
                    ((PlayVoiceBntNew) view).cfq();
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
        return this.fZT;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bLJ() {
        if (this.fZU == null) {
            this.fZU = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpI */
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
        return this.fZU;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bLK() {
        this.fZV = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dpH */
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
        return this.fZV;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lMQ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (au.Qc(str) && dnV() != null && dnV().dpW() != null) {
            TiebaStatic.log(new aq("c11664").an("obj_param1", 1).dX("post_id", dnV().dpW()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                mVar.mLink = str;
                mVar.type = 3;
                mVar.fCE = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
            }
        } else {
            au.dtm().f(getPageContext(), str);
        }
        this.lMQ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
        au.dtm().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lMQ = true;
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
            this.mfR.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b dwr = this.mfR.dwr();
            if (dwr == null) {
                this.mfR.doS();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                dwr.getItemView(1).setVisibility(8);
            } else {
                dwr.getItemView(1).setVisibility(0);
            }
            dwr.btZ();
            this.lMQ = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aJ(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.bwu().b(getPageContext(), new String[]{str});
            this.lMQ = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a dvJ() {
        return this.fcZ;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bJe() {
        return this.bTP;
    }

    public ReplyFragment dvK() {
        if (this.mfA == null || !(this.mfA.HJ(mfw) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.mfA.HJ(mfw);
    }

    public DetailInfoFragment dvL() {
        if (this.mfA == null || !(this.mfA.HJ(mfv) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.mfA.HJ(mfv);
    }

    public DetailInfoAndReplyFragment dvM() {
        if (this.mfA == null || !(this.mfA.HJ(mfx) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.mfA.HJ(mfx);
    }

    public boolean dnN() {
        PbModel dnV = this.lME.dnV();
        if (dnV == null) {
            return false;
        }
        return dnV.dnN();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dmQ;
        PbModel dnV = this.lME.dnV();
        if (dnV != null && dnV.getPbData() != null && !dnV.getPbData().dnh()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = dnV.getPbData().dmE().getId();
            if (dnV.isShareThread() && dnV.getPbData().dmE().eVB != null) {
                historyMessage.threadName = dnV.getPbData().dmE().eVB.showText;
            } else {
                historyMessage.threadName = dnV.getPbData().dmE().getTitle();
            }
            if (dnV.isShareThread() && !dnN()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = dnV.getPbData().getForum().getName();
            }
            ArrayList<PostData> dmG = dnV.getPbData().dmG();
            int dsr = dvK() != null ? dvK().dsr() : 0;
            if (dmG != null && dsr >= 0 && dsr < dmG.size()) {
                historyMessage.postID = dmG.get(dsr).getId();
            }
            historyMessage.isHostOnly = dnV.getHostMode();
            historyMessage.isSquence = dnV.dpY();
            historyMessage.isShareThread = dnV.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lNx != null) {
            this.lNx.onDestroy();
        }
        if (dnV != null && (dnV.dpZ() || dnV.dqb())) {
            Intent intent = new Intent();
            intent.putExtra("tid", dnV.dpW());
            if (this.lNm) {
                if (this.lNo) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", dnV.cxN());
                }
                if (this.lNn) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", dnV.getIsGood());
                }
            }
            if (dnV.getPbData() != null && System.currentTimeMillis() - this.lMM >= 40000 && (dmQ = dnV.getPbData().dmQ()) != null && !x.isEmpty(dmQ.getDataList())) {
                intent.putExtra("guess_like_data", dmQ);
            }
            PbActivity pbActivity = this.lME;
            PbActivity pbActivity2 = this.lME;
            pbActivity.setResult(-1, intent);
        }
        if (dpi()) {
            if (dnV != null) {
                com.baidu.tieba.pb.data.f pbData = dnV.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.lMS) {
                        if (this.mfD != null) {
                            Rect rect = new Rect();
                            this.mfD.getGlobalVisibleRect(rect);
                            aj.drv().g(rect);
                        }
                        aj.drv().Hm(this.fbv.getCurrentItem());
                        BdTypeRecyclerView cIs = cIs();
                        Parcelable parcelable = null;
                        if (cIs != null) {
                            parcelable = cIs.onSaveInstanceState();
                        }
                        aj.drv().a(dnV.dqh(), parcelable, dnV.dpY(), dnV.getHostMode(), false);
                    }
                }
            } else {
                aj.drv().reset();
            }
            doj();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mfE != null && !this.mfE.isVertical()) {
            if ((this.mfE.isFullScreen() && configuration.orientation == 1) || (!this.mfE.isFullScreen() && configuration.orientation == 2)) {
                this.mfE.wk(false);
            }
        }
    }

    public boolean dvN() {
        if (this.mfE == null) {
            return false;
        }
        return this.mfE.isVertical();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.dNX().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        public boolean mgm;
        public boolean mgn;

        private a() {
            this.mgn = true;
        }

        public boolean dvU() {
            return (this.mgm && this.mgn) ? false : true;
        }
    }

    public void dvO() {
        this.lNb = -1;
        this.lNc = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpz() {
        if (dnV() != null && !at.isEmpty(dnV().dpW())) {
            com.baidu.tbadk.BdToken.c.bkT().p(com.baidu.tbadk.BdToken.b.eEL, com.baidu.adp.lib.f.b.toLong(dnV().dpW(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.mfC.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvP() {
        if (this.mgb == null) {
            this.mgb = ObjectAnimator.ofFloat(this.mfG, "alpha", 0.0f, 1.0f);
            this.mgb.setDuration(200L);
        }
        this.mgb.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvQ() {
        if (this.mgc == null) {
            this.mgc = ObjectAnimator.ofFloat(this.mfG, "alpha", 1.0f, 0.0f);
            this.mgc.setDuration(200L);
        }
        this.mgc.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dvR() {
        return this.mfE != null && this.mfE.dvS();
    }

    public boolean dvS() {
        return this.mfY;
    }

    public void wb(boolean z) {
        this.mfY = z;
    }

    public void uU(boolean z) {
        this.lMT = z;
    }

    public boolean dpx() {
        return this.lMT;
    }

    public LinearLayout dtf() {
        return this.lVf;
    }
}
