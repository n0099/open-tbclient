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
    private com.baidu.tieba.pb.videopb.c.a lGA;
    private PbActivity lMD;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lMW;
    int lMZ;
    private PbFakeFloorModel lMy;
    private com.baidu.tbadk.core.view.c lND;
    private g lNv;
    private com.baidu.tbadk.editortools.pb.e lNw;
    private com.baidu.tieba.frs.profession.permission.c lNy;
    private EmotionImageData lNz;
    private View lUK;
    private r lVL;
    private View lVc;
    private LinearLayout lVe;
    private HeadImageView lVf;
    private ImageView lVg;
    private ImageView lVh;
    private ImageView lVi;
    private com.baidu.tieba.pb.view.d lVj;
    private TextView lVk;
    private TextView lVl;
    private int lVn;
    private int lVo;
    private String lWd;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private View mfA;
    private View mfB;
    private VideoContainerLayout mfC;
    private com.baidu.tieba.pb.videopb.videoView.a mfD;
    private e mfE;
    private View mfF;
    private View mfG;
    private TextView mfI;
    private TextView mfJ;
    private ImageView mfK;
    private TBSpecificationBtn mfL;
    private TbImageView mfM;
    private View mfN;
    private ValueAnimator mfO;
    private ValueAnimator mfP;
    public com.baidu.tieba.pb.videopb.b.a mfQ;
    private float mfU;
    private float mfV;
    private boolean mfW;
    private NewPagerSlidingTabBaseStrip mfy;
    private VideoPbFragmentAdapter mfz;
    private ObjectAnimator mga;
    private ObjectAnimator mgb;
    private RelativeLayout rootView;
    public static int mfu = 0;
    public static int mfv = 1;
    public static int mfw = 0;
    public static int lVD = 3;
    public static int lVE = 0;
    public static int lVF = 3;
    public static int lVG = 4;
    public static int lVH = 5;
    public static int lVI = 6;
    private static final int kin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int mfx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a lOw = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void cZ(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.dnM();
            } else {
                com.baidu.tieba.pb.a.b.dnL();
            }
        }
    };
    private long lML = 0;
    private boolean lMS = false;
    View.OnClickListener mfH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.lGA == null || VideoPbFragment.this.lGA.dwM()) {
                if (VideoPbFragment.this.lGA != null) {
                    if (VideoPbFragment.this.lGA.isChushou) {
                        VideoPbFragment.this.eI(VideoPbFragment.this.lGA.thirdRoomId, VideoPbFragment.this.lGA.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.lGA.dwN();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null && VideoPbFragment.this.dnW().getPbData().getForum() != null) {
                        TiebaStatic.log(new aq("c13713").dX("fid", VideoPbFragment.this.dnW().getPbData().getForum().getId()).dX("fname", VideoPbFragment.this.dnW().getPbData().getForum().getName()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("tid", VideoPbFragment.this.dnW().getPbData().getThreadId()).w("obj_param1", VideoPbFragment.this.lGA.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new aq("c13590").dX("obj_id", VideoPbFragment.this.lGA.getTitle()).dX("obj_name", VideoPbFragment.this.lGA.dwJ()).an("obj_type", 2).dX("fid", VideoPbFragment.this.dnW().getPbData().getForumId()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("tid", VideoPbFragment.this.dnW().getPbData().getThreadId()));
            String link = VideoPbFragment.this.lGA.getLink();
            if (!TextUtils.isEmpty(link)) {
                if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                    be.bwv().b(VideoPbFragment.this.getPageContext(), new String[]{link});
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
    private com.baidu.tbadk.baseEditMark.a lNi = null;
    private com.baidu.tbadk.coreExtra.model.a fcZ = null;
    private ForumManageModel ggJ = null;
    private boolean lMP = false;
    private View lVd = null;
    private TextView klE = null;
    private boolean lUZ = false;
    private String fGe = null;
    private boolean lNl = false;
    private boolean lNm = false;
    private boolean lNn = false;
    private boolean lMR = false;
    int[] lMY = new int[2];
    private int lNa = -1;
    private int lNb = Integer.MIN_VALUE;
    private int lNJ = 0;
    private int mfS = Integer.MIN_VALUE;
    private boolean isPaused = false;
    private boolean lNf = com.baidu.tbadk.a.d.bmG();
    private final PbModel.a lOm = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h ss;
            VideoPbFragment.this.dsq();
            VideoPbFragment.this.dsl();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.vz(false);
            if (z && fVar != null) {
                bz dmF = fVar.dmF();
                ((VideoPbViewModel) ViewModelProviders.of(VideoPbFragment.this.getActivity()).get(VideoPbViewModel.class)).c(fVar, i2);
                VideoPbFragment.this.M(fVar);
                com.baidu.tieba.pb.videopb.c.a dnk = fVar.dnk();
                if (dnk != null && !dnk.mhT) {
                    VideoPbFragment.this.a(dnk);
                }
                VideoPbFragment.this.N(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.lNi != null) {
                    VideoPbFragment.this.lNi.jc(fVar.bny());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.fGe = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.fGe) && VideoPbFragment.this.lNw != null && VideoPbFragment.this.lNw.bEJ() != null && (ss = VideoPbFragment.this.lNw.bEJ().ss(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.fGe)) {
                        ((View) ss).setOnClickListener(VideoPbFragment.this.fGR);
                    }
                }
                if (VideoPbFragment.this.kON != null && dmF != null && dmF.brr() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(dmF.brr());
                    VideoPbFragment.this.kON.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.dnW().dpX());
                        jSONObject.put("fid", VideoPbFragment.this.dnW().getForumId());
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
                if ((!com.baidu.tbadk.a.d.bmI() || VideoPbFragment.this.dvN() != null) && VideoPbFragment.this.dvL() != null) {
                    if (com.baidu.tbadk.a.d.bmI()) {
                        if (i != -1) {
                            ArrayList<PostData> arrayList = null;
                            if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null) {
                                arrayList = VideoPbFragment.this.dnW().getPbData().dmH();
                            }
                            if (x.getCount(arrayList) == 0 || (x.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dPe() == 1)) {
                                if (VideoPbFragment.this.dvN().dpx()) {
                                    VideoPbFragment.this.dvN().PX(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dvN().PX(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dvN().PW(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dvN().PW("");
                        }
                        VideoPbFragment.this.dvN().endLoadData();
                    } else {
                        if (i != -1) {
                            ArrayList<PostData> arrayList2 = null;
                            if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null) {
                                arrayList2 = VideoPbFragment.this.dnW().getPbData().dmH();
                            }
                            if (x.getCount(arrayList2) == 0 || (x.getCount(arrayList2) == 1 && arrayList2.get(0) != null && arrayList2.get(0).dPe() == 1)) {
                                if (VideoPbFragment.this.dvL().dpx()) {
                                    VideoPbFragment.this.dvL().PX(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dvL().PX(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dvL().PW(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dvL().PW("");
                        }
                        VideoPbFragment.this.dvL().endLoadData();
                    }
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.dNY().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0574a lOo = new a.InterfaceC0574a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0574a
        public void g(boolean z, boolean z2, String str) {
            VideoPbFragment.this.dsq();
            if (z && VideoPbFragment.this.dnW() != null) {
                if (VideoPbFragment.this.lNi != null) {
                    VideoPbFragment.this.lNi.jc(z2);
                }
                VideoPbFragment.this.dnW().vd(z2);
                if (VideoPbFragment.this.dnW().bny()) {
                    VideoPbFragment.this.dpi();
                } else if (com.baidu.tbadk.a.d.bmI() && VideoPbFragment.this.dvN() != null) {
                    VideoPbFragment.this.dvN().dww();
                } else if (VideoPbFragment.this.dvL() != null) {
                    VideoPbFragment.this.dvL().dww();
                }
                if (z2) {
                    if (VideoPbFragment.this.lNi != null) {
                        if (VideoPbFragment.this.lNi.bnB() != null && VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null && VideoPbFragment.this.dnW().getPbData().dmF() != null && VideoPbFragment.this.dnW().getPbData().dmF().brr() != null) {
                            MarkData bnB = VideoPbFragment.this.lNi.bnB();
                            MetaData brr = VideoPbFragment.this.dnW().getPbData().dmF().brr();
                            if (bnB != null && brr != null) {
                                if (!at.equals(TbadkCoreApplication.getCurrentAccount(), brr.getUserId()) && !brr.hadConcerned()) {
                                    VideoPbFragment.this.mfQ.b(brr);
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
                    VideoPbFragment.this.dpf();
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
        public boolean bFn() {
            if (VideoPbFragment.this.kSQ == null || VideoPbFragment.this.kSQ.dtj() == null || !VideoPbFragment.this.kSQ.dtj().dXT()) {
                return !VideoPbFragment.this.GV(al.fcU);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kSQ.dtj().dXV());
            if (VideoPbFragment.this.lNw != null && (VideoPbFragment.this.lNw.bFE() || VideoPbFragment.this.lNw.bFF())) {
                VideoPbFragment.this.lNw.a(false, VideoPbFragment.this.kSQ.dtm());
            }
            VideoPbFragment.this.kSQ.vF(true);
            return true;
        }
    };
    private final CustomMessageListener lNQ = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.dnW() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.lNw != null) {
                    VideoPbFragment.this.vx(VideoPbFragment.this.lNw.bFx());
                }
                VideoPbFragment.this.drP();
                VideoPbFragment.this.mfQ.dsH();
            }
        }
    };
    private CustomMessageListener lNT = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
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
                VideoPbFragment.this.dpA();
            }
        }
    };
    private CustomMessageListener lOn = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.doZ();
            }
        }
    };
    private CustomMessageListener lOf = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.66
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.mfQ != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mfQ.lNE) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.mfQ.cnj();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.mfQ.getExtra();
                DataRes dataRes = aVar.nET;
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
                    VideoPbFragment.this.mfQ.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.mfQ.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener lOd = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.mfQ != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mfQ.lNE) {
                VideoPbFragment.this.mfQ.cnj();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                f pbData = VideoPbFragment.this.dnW().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dmV().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lND.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.mfQ.DW(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.mfQ.dpw();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (at.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.lND.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lOe = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.mfQ != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mfQ.lNE) {
                VideoPbFragment.this.mfQ.cnj();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lND.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (at.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.lND.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b lNB = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bFn() {
            if (VideoPbFragment.this.kSQ == null || VideoPbFragment.this.kSQ.dtk() == null || !VideoPbFragment.this.kSQ.dtk().dXT()) {
                return !VideoPbFragment.this.GV(al.fcV);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kSQ.dtk().dXV());
            if (VideoPbFragment.this.lVL != null && VideoPbFragment.this.lVL.doJ() != null && VideoPbFragment.this.lVL.doJ().bFF()) {
                VideoPbFragment.this.lVL.doJ().a(VideoPbFragment.this.kSQ.dtm());
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
                if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null) {
                    aqVar.dX("fid", VideoPbFragment.this.dnW().getPbData().getForumId());
                }
                aqVar.dX("tid", VideoPbFragment.this.dnW().dpX());
                aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            VideoPbFragment.this.cFA();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.dnW() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.dnW().PR(postWriteCallBackData.getPostId());
                    if (com.baidu.tbadk.a.d.bmI() && VideoPbFragment.this.dvN() != null) {
                        VideoPbFragment.this.lNJ = VideoPbFragment.this.dvN().dss();
                        VideoPbFragment.this.mfS = VideoPbFragment.this.dvN().dwz();
                        VideoPbFragment.this.dnW().dc(VideoPbFragment.this.lNJ, VideoPbFragment.this.mfS);
                    } else if (VideoPbFragment.this.dvL() != null) {
                        VideoPbFragment.this.lNJ = VideoPbFragment.this.dvL().dss();
                        VideoPbFragment.this.mfS = VideoPbFragment.this.dvL().dwz();
                        VideoPbFragment.this.dnW().dc(VideoPbFragment.this.lNJ, VideoPbFragment.this.mfS);
                    }
                }
                if (VideoPbFragment.this.fbv != null) {
                    if (com.baidu.tbadk.a.d.bmI()) {
                        VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfw);
                    } else {
                        VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfv);
                    }
                }
                VideoPbFragment.this.mfQ.dsH();
                VideoPbFragment.this.kSQ.dti();
                if (VideoPbFragment.this.lNw != null) {
                    VideoPbFragment.this.vx(VideoPbFragment.this.lNw.bFx());
                }
                VideoPbFragment.this.drL();
                VideoPbFragment.this.vz(true);
                VideoPbFragment.this.dnW().dqt();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (com.baidu.tbadk.a.d.bmI() && VideoPbFragment.this.dvN() != null) {
                                VideoPbFragment.this.dvN().dww();
                            } else if (VideoPbFragment.this.dvL() != null) {
                                VideoPbFragment.this.dvL().dww();
                            }
                        }
                    } else if (VideoPbFragment.this.dnW().getHostMode()) {
                        f pbData = VideoPbFragment.this.dnW().getPbData();
                        if (pbData != null && pbData.dmF() != null && pbData.dmF().brr() != null && (userId = pbData.dmF().brr().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.dnW().dqk()) {
                            VideoPbFragment.this.dso();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.dnW().dqk()) {
                        VideoPbFragment.this.dso();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.uO(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.lNw.bFE() || VideoPbFragment.this.lNw.bFF()) {
                    VideoPbFragment.this.lNw.a(false, postWriteCallBackData);
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
                    aVar.Bo(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bo(postWriteCallBackData.getErrorString());
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
                aVar.b(VideoPbFragment.this.getPageContext()).btY();
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
    private CustomMessageListener lNS = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.lNw != null) {
                    VideoPbFragment.this.vx(VideoPbFragment.this.lNw.bFx());
                }
                VideoPbFragment.this.vz(false);
            }
        }
    };
    private int mfT = 0;
    private boolean mfX = true;
    private View.OnTouchListener mfY = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.mfT == 1) {
                if (!VideoPbFragment.this.mfX) {
                    VideoPbFragment.this.dvQ();
                    UtilHelper.showStatusBar(VideoPbFragment.this.dpE(), VideoPbFragment.this.dpE().getRootView());
                    VideoPbFragment.this.mfX = true;
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(VideoPbFragment.this.mfZ);
                    com.baidu.adp.lib.f.e.mB().postDelayed(VideoPbFragment.this.mfZ, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (VideoPbFragment.this.mfT == 2 && (VideoPbFragment.this.mfX || VideoPbFragment.this.dvS())) {
                VideoPbFragment.this.dvR();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dpE(), VideoPbFragment.this.dpE().getRootView());
                VideoPbFragment.this.mfX = false;
                if (VideoPbFragment.this.mfD != null) {
                    VideoPbFragment.this.mfD.wb(false);
                }
            }
            VideoPbFragment.this.mfT = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener jrz = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.mfT = 0;
            VideoPbFragment.this.mfU = 0.0f;
            VideoPbFragment.this.mfV = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.mfU += f;
            VideoPbFragment.this.mfV += f2;
            if (VideoPbFragment.this.mfT == 0 && !VideoPbFragment.this.mfW && VideoPbFragment.this.mfD != null && !VideoPbFragment.this.mfD.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.mfV) <= Math.abs(VideoPbFragment.this.mfU) || VideoPbFragment.this.mfV > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.mfV) > Math.abs(VideoPbFragment.this.mfU) && VideoPbFragment.this.mfV > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.mfT = 2;
                    }
                } else {
                    VideoPbFragment.this.mfT = 1;
                }
            }
            return true;
        }
    };
    private Runnable mfZ = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.mfX && !VideoPbFragment.this.dvS()) {
                VideoPbFragment.this.dvR();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dpE(), VideoPbFragment.this.dpE().getRootView());
                VideoPbFragment.this.mfX = false;
            }
        }
    };
    private final com.baidu.adp.base.e iwQ = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.dnW() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.ggJ.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.ggJ.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.dnW().dqt();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.mcN != 1002 || bVar.hli) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.mSuccess, dVar.nut, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.ggJ.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.ggJ.getLoadDataMode(), gVar.mSuccess, gVar.nut, false);
                    VideoPbFragment.this.mfQ.bf(gVar.nuw);
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
    public NewWriteModel.d lOk = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c13268");
                aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null) {
                    aqVar.dX("fid", VideoPbFragment.this.dnW().getPbData().getForumId());
                }
                if (VideoPbFragment.this.dnW() != null) {
                    aqVar.dX("tid", VideoPbFragment.this.dnW().dpX());
                }
                aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (VideoPbFragment.this.kSQ != null) {
                    VideoPbFragment.this.kSQ.dth();
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
                    aVar.Bo(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bo(postWriteCallBackData.getErrorString());
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
                aVar.b(VideoPbFragment.this.getPageContext()).btY();
                TiebaStatic.log(new aq("c13745").an("obj_locate", 1).an("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.kSQ != null) {
                if (VideoPbFragment.this.lVL != null && VideoPbFragment.this.lVL.doJ() != null && VideoPbFragment.this.lVL.doJ().bFF()) {
                    VideoPbFragment.this.lVL.doJ().a(postWriteCallBackData);
                }
                VideoPbFragment.this.kSQ.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c fGh = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bFo() {
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
                    aqVar.dX("tid", VideoPbFragment.this.dnW().dpX());
                    aqVar.dX("fid", VideoPbFragment.this.dnW().getForumId());
                    aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.an("obj_locate", 1);
                    TiebaStatic.log(aqVar);
                    if (VideoPbFragment.this.lMP) {
                        VideoPbFragment.this.lMP = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null && VideoPbFragment.this.lMy != null && postData.brr() != null && postData.dPe() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.lVL != null) {
                                    VideoPbFragment.this.lVL.doF();
                                }
                                p pVar = new p();
                                pVar.a(VideoPbFragment.this.dnW().getPbData().getForum());
                                pVar.setThreadData(VideoPbFragment.this.dnW().getPbData().dmF());
                                pVar.g(postData);
                                VideoPbFragment.this.lMy.d(pVar);
                                VideoPbFragment.this.lMy.setPostId(postData.getId());
                                VideoPbFragment.this.a(view, postData.brr().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.dnW().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.lNw != null) {
                                    VideoPbFragment.this.vx(VideoPbFragment.this.lNw.bFx());
                                }
                            }
                        }
                    }
                } else if ((VideoPbFragment.this.dvL() != null && VideoPbFragment.this.dvL().dsD() != null && view == VideoPbFragment.this.dvL().dsD()) || ((com.baidu.tbadk.a.d.bmI() && VideoPbFragment.this.dvN() != null && VideoPbFragment.this.dvN().dsD() != null && view == VideoPbFragment.this.dvN().dsD()) || view.getId() == R.id.pb_more)) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.dnW().vb(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        if (com.baidu.tbadk.a.d.bmI()) {
                            VideoPbFragment.this.dvN().dsp();
                        } else {
                            VideoPbFragment.this.dvL().dsp();
                        }
                    }
                } else if (VideoPbFragment.this.mfQ != null && VideoPbFragment.this.mfQ.dtP() != null && view == VideoPbFragment.this.mfQ.dtP().drj()) {
                    VideoPbFragment.this.mfQ.bet();
                } else if ((VideoPbFragment.this.mfQ != null && ((VideoPbFragment.this.mfQ.dtP() != null && view == VideoPbFragment.this.mfQ.dtP().drk()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) || view.getId() == R.id.floor_owner_reply || view.getId() == R.id.reply_title) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.mfQ.dsH();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.cFA();
                        VideoPbFragment.this.dso();
                        if (view.getId() == R.id.owner_reply) {
                            C = VideoPbFragment.this.dnW().C(true, VideoPbFragment.this.dpm());
                        } else {
                            C = view.getId() == R.id.all_reply ? VideoPbFragment.this.dnW().C(false, VideoPbFragment.this.dpm()) : VideoPbFragment.this.dnW().PO(VideoPbFragment.this.dpm());
                        }
                        view.setTag(Boolean.valueOf(C));
                        if (C) {
                            VideoPbFragment.this.dsk();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.fOs) {
                    if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null) {
                        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            aq aqVar2 = new aq("c13266");
                            aqVar2.dX("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar2.dX("fid", VideoPbFragment.this.dnW().getPbData().getForumId());
                            aqVar2.dX("tid", VideoPbFragment.this.dnW().dpX());
                            aqVar2.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(aqVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.lMD, VideoPbFragment.this.fOs);
                        VideoPbFragment.this.lMD.finish();
                    }
                } else if (view == VideoPbFragment.this.jvO && VideoPbFragment.this.mfQ != null) {
                    if (VideoPbFragment.this.dnW() == null || VideoPbFragment.this.dnW().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> dmH = VideoPbFragment.this.dnW().getPbData().dmH();
                    if ((dmH == null || dmH.size() <= 0) && VideoPbFragment.this.dnW().dpZ()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new aq("c12378").dX("tid", VideoPbFragment.this.dnW().dpX()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("fid", VideoPbFragment.this.dnW().getForumId()));
                    VideoPbFragment.this.mfQ.dpa();
                } else if (VideoPbFragment.this.mfQ.dtP() != null && view == VideoPbFragment.this.mfQ.dtP().dro()) {
                    if (VideoPbFragment.this.dnW() != null) {
                        VideoPbFragment.this.mfQ.dsH();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.cFA();
                            VideoPbFragment.this.dso();
                            VideoPbFragment.this.dnW().Hc(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.mfQ != null && VideoPbFragment.this.mfQ.dtP() != null && view == VideoPbFragment.this.mfQ.dtP().drk()) {
                    VideoPbFragment.this.mfQ.bet();
                } else if (VideoPbFragment.this.mfQ != null && ((VideoPbFragment.this.mfQ.dtP() != null && view == VideoPbFragment.this.mfQ.dtP().drr()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                    VideoPbFragment.this.mfQ.dsH();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.cFA();
                            VideoPbFragment.this.dso();
                            VideoPbFragment.this.mfQ.dU(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.dnW().dqr()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.mfQ != null && VideoPbFragment.this.mfQ.dtP() != null && view == VideoPbFragment.this.mfQ.dtP().dri()) {
                    if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null && VideoPbFragment.this.dnW().getPbData().dmF() != null) {
                        VideoPbFragment.this.mfQ.bet();
                        TiebaStatic.log(new aq("c13062"));
                        VideoPbFragment.this.mfQ.PJ(VideoPbFragment.this.dnW().getPbData().dmF().brH());
                    }
                } else if (view.getId() == R.id.pb_floor_feedback) {
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (VideoPbFragment.this.mfQ != null) {
                        VideoPbFragment.this.mfQ.i(sparseArray);
                    }
                } else if (VideoPbFragment.this.mfQ != null && VideoPbFragment.this.mfQ.dtP() != null && view == VideoPbFragment.this.mfQ.dtP().drs()) {
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
                    VideoPbFragment.this.mfQ.dtO();
                } else if (VideoPbFragment.this.mfQ != null && (view == VideoPbFragment.this.mfQ.dsm() || (VideoPbFragment.this.mfQ.dtP() != null && (view == VideoPbFragment.this.mfQ.dtP().drn() || view == VideoPbFragment.this.mfQ.dtP().drl())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if ((VideoPbFragment.this.dnW() != null || VideoPbFragment.this.dnW().getPbData() != null) && !VideoPbFragment.this.ggJ.dPZ()) {
                        VideoPbFragment.this.mfQ.dsH();
                        if (VideoPbFragment.this.mfQ.dtP() != null && view == VideoPbFragment.this.mfQ.dtP().drl()) {
                            if (VideoPbFragment.this.dnW().getPbData().dmF().brm() == 1) {
                                i2 = 5;
                            } else {
                                i2 = 4;
                            }
                        } else if (VideoPbFragment.this.mfQ.dtP() != null && view == VideoPbFragment.this.mfQ.dtP().drn()) {
                            if (VideoPbFragment.this.dnW().getPbData().dmF().brn() != 1) {
                                i2 = 6;
                            }
                        } else {
                            i2 = view == VideoPbFragment.this.mfQ.dsm() ? 2 : 0;
                        }
                        ForumData forum = VideoPbFragment.this.dnW().getPbData().getForum();
                        String name = forum.getName();
                        String id = forum.getId();
                        String id2 = VideoPbFragment.this.dnW().getPbData().dmF().getId();
                        VideoPbFragment.this.showProgressBar();
                        VideoPbFragment.this.ggJ.c(id, name, id2, i2, VideoPbFragment.this.mfQ.dsn());
                    }
                } else if (VideoPbFragment.this.mfQ != null && VideoPbFragment.this.mfQ.dtP() != null && view == VideoPbFragment.this.mfQ.dtP().drq()) {
                    if (VideoPbFragment.this.dnW() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.mfQ.dsH();
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.dnW().getPbData(), VideoPbFragment.this.dnW().dpZ(), 1);
                        if (b2 != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.dnW().getPbData().getForum().getId(), VideoPbFragment.this.dnW().getPbData().getForum().getName(), VideoPbFragment.this.dnW().getPbData().dmF().getId(), String.valueOf(VideoPbFragment.this.dnW().getPbData().getUserData().getUserId()), (String) b2.get(R.id.tag_forbid_user_name), (String) b2.get(R.id.tag_forbid_user_name_show), (String) b2.get(R.id.tag_forbid_user_post_id), (String) b2.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.mfQ != null && VideoPbFragment.this.mfQ.dtP() != null && view == VideoPbFragment.this.mfQ.dtP().drm()) {
                    if (VideoPbFragment.this.dnW() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b3 = VideoPbFragment.this.b(VideoPbFragment.this.dnW().getPbData(), VideoPbFragment.this.dnW().dpZ(), 1);
                        if (b3 != null) {
                            if (StringUtils.isNull((String) b3.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.mfQ.a(((Integer) b3.get(R.id.tag_del_post_type)).intValue(), (String) b3.get(R.id.tag_del_post_id), ((Integer) b3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b3.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.mfQ.a(((Integer) b3.get(R.id.tag_del_post_type)).intValue(), (String) b3.get(R.id.tag_del_post_id), ((Integer) b3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b3.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b3.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.mfQ.bet();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        aq aqVar3 = new aq("c13398");
                        aqVar3.dX("tid", VideoPbFragment.this.dnW().dpX());
                        aqVar3.dX("fid", VideoPbFragment.this.dnW().getForumId());
                        aqVar3.dX("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar3.an("obj_locate", 4);
                        TiebaStatic.log(aqVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new aq("c10517").an("obj_locate", 3).dX("fid", VideoPbFragment.this.dnW().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null) {
                        if (VideoPbFragment.this.mfQ != null) {
                            VideoPbFragment.this.mfQ.dsH();
                        }
                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                        PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                        PostData postData3 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                        if (postData2 != null) {
                            if (postData2.dPq() == 1) {
                                TiebaStatic.log(new aq("c12630"));
                            }
                            if (postData2.nsp != null) {
                                aq bwn = postData2.nsp.bwn();
                                bwn.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    bwn.an("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    bwn.an("obj_locate", 8);
                                }
                                TiebaStatic.log(bwn);
                            }
                            VideoPbFragment.this.cFA();
                            TiebaStatic.log("c11742");
                            if (postData3 != null) {
                                VideoPbFragment.this.a(postData2, postData3, false, true);
                            } else {
                                VideoPbFragment.this.a(postData2, (PostData) null, false, false);
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                    if (VideoPbFragment.this.dnW() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            aq aqVar4 = new aq("c13398");
                            aqVar4.dX("tid", VideoPbFragment.this.dnW().dpX());
                            aqVar4.dX("fid", VideoPbFragment.this.dnW().getForumId());
                            aqVar4.dX("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar4.an("obj_locate", 6);
                            TiebaStatic.log(aqVar4);
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData4.nsp != null) {
                                    aq bwn2 = postData4.nsp.bwn();
                                    bwn2.delete("obj_locate");
                                    bwn2.an("obj_locate", 8);
                                    TiebaStatic.log(bwn2);
                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                    TiebaStatic.log(new aq("c13700").dX("tid", VideoPbFragment.this.dnW().dpY()).dX("fid", VideoPbFragment.this.dnW().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("post_id", postData4.getId()).an("obj_source", 1).an("obj_type", 3));
                                }
                                if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null && VideoPbFragment.this.lMy != null && postData4.brr() != null && postData4.dPe() != 1) {
                                    if (VideoPbFragment.this.lVL != null) {
                                        VideoPbFragment.this.lVL.doF();
                                    }
                                    if (VideoPbFragment.this.lNf && postData4.dPb() != null && postData4.dPb().size() != 0) {
                                        VideoPbFragment.this.a(postData4, (PostData) null, true, false);
                                        return;
                                    }
                                    p pVar2 = new p();
                                    pVar2.a(VideoPbFragment.this.dnW().getPbData().getForum());
                                    pVar2.setThreadData(VideoPbFragment.this.dnW().getPbData().dmF());
                                    pVar2.g(postData4);
                                    VideoPbFragment.this.lMy.d(pVar2);
                                    VideoPbFragment.this.lMy.setPostId(postData4.getId());
                                    VideoPbFragment.this.a(view, postData4.brr().getUserId(), "", postData4);
                                    if (VideoPbFragment.this.lNw != null) {
                                        VideoPbFragment.this.vx(VideoPbFragment.this.lNw.bFx());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.mfQ != null && VideoPbFragment.this.dnW() != null) {
                        if (com.baidu.tbadk.a.d.bmI() || VideoPbFragment.this.dvL() != null) {
                            if (!com.baidu.tbadk.a.d.bmI() || VideoPbFragment.this.dvN() != null) {
                                VideoPbFragment.this.mfQ.dsH();
                                if (VideoPbFragment.this.GX(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.dnW() != null) {
                                    VideoPbFragment.this.dph();
                                    if (VideoPbFragment.this.dnW().getPbData() != null && VideoPbFragment.this.dnW().getPbData().dmF() != null && VideoPbFragment.this.dnW().getPbData().dmF().brr() != null) {
                                        TiebaStatic.log(new aq("c13402").dX("tid", VideoPbFragment.this.dnW().dpX()).dX("fid", VideoPbFragment.this.dnW().getPbData().getForumId()).an("obj_locate", 3).dX("uid", VideoPbFragment.this.dnW().getPbData().dmF().brr().getUserId()));
                                    }
                                    if (VideoPbFragment.this.dnW().getPbData().dmF() != null && VideoPbFragment.this.dnW().getPbData().dmF().brr() != null && VideoPbFragment.this.dnW().getPbData().dmF().brr().getUserId() != null && VideoPbFragment.this.lNi != null) {
                                        int h = VideoPbFragment.this.mfQ.h(VideoPbFragment.this.dnW().getPbData());
                                        bz dmF = VideoPbFragment.this.dnW().getPbData().dmF();
                                        if (!dmF.bpY()) {
                                            if (dmF.bpZ()) {
                                                i = 3;
                                            } else if (dmF.btp()) {
                                                i = 4;
                                            } else {
                                                i = dmF.btq() ? 5 : 1;
                                            }
                                        }
                                        TiebaStatic.log(new aq("c12526").dX("tid", VideoPbFragment.this.dnW().dpX()).an("obj_locate", 1).dX("obj_id", VideoPbFragment.this.dnW().getPbData().dmF().brr().getUserId()).an("obj_type", VideoPbFragment.this.lNi.bny() ? 0 : 1).an("obj_source", h).an("obj_param1", i));
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.vZ(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.mfQ != null && VideoPbFragment.this.fbv != null && VideoPbFragment.this.dnW().getPbData() != null && VideoPbFragment.this.dnW().getPbData().dmF() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        f pbData = VideoPbFragment.this.dnW().getPbData();
                        if (pbData.dmF().bri() != 0) {
                            int currentItem = VideoPbFragment.this.fbv.getCurrentItem();
                            if (!com.baidu.tbadk.a.d.bmI() && currentItem == VideoPbFragment.mfu) {
                                VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfv);
                            } else if (com.baidu.tbadk.a.d.bmI() || currentItem == VideoPbFragment.mfv) {
                                if (!com.baidu.tbadk.a.d.bmI() && VideoPbFragment.this.dvL() == null) {
                                    return;
                                }
                                if ((!com.baidu.tbadk.a.d.bmI() || VideoPbFragment.this.dvN() != null) && VideoPbFragment.this.cIt() != null) {
                                    aq dX = new aq("c13403").dX("tid", VideoPbFragment.this.dnW().dpX()).dX("fid", VideoPbFragment.this.dnW().getPbData().getForumId()).dX("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView cIt = VideoPbFragment.this.cIt();
                                    if (cIt != null) {
                                        boolean canScrollVertically = cIt.canScrollVertically(1);
                                        boolean canScrollVertically2 = cIt.canScrollVertically(-1);
                                        if (VideoPbFragment.this.ZS != null) {
                                            VideoPbFragment.this.ZS.setExpanded(false, true);
                                        }
                                        if (cIt.getLayoutManager() != null && (cIt.getLayoutManager() instanceof LinearLayoutManager)) {
                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) cIt.getLayoutManager();
                                            if (!canScrollVertically2 && canScrollVertically) {
                                                if (VideoPbFragment.this.lNa != -1 || VideoPbFragment.this.lNb != Integer.MIN_VALUE) {
                                                    if (VideoPbFragment.this.lNa > 3 || (VideoPbFragment.this.lNa == 3 && VideoPbFragment.this.lNb < (-equipmentHeight))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lNa, VideoPbFragment.this.lNb + equipmentHeight);
                                                        cIt.smoothScrollBy(0, equipmentHeight);
                                                    } else if (VideoPbFragment.this.lNa >= 2) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lNa, VideoPbFragment.this.lNb + (equipmentHeight / 2));
                                                        cIt.smoothScrollBy(0, equipmentHeight / 2);
                                                    } else if (VideoPbFragment.this.lNa == 1) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lNa, VideoPbFragment.this.lNb + (equipmentHeight / 4));
                                                        cIt.smoothScrollBy(0, equipmentHeight / 4);
                                                    } else {
                                                        cIt.smoothScrollBy(0, -VideoPbFragment.this.lNb);
                                                    }
                                                    dX.an("obj_locate", 2);
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                int firstVisiblePosition = cIt.getFirstVisiblePosition();
                                                View childAt = cIt.getChildAt(0);
                                                int top = childAt == null ? 0 : childAt.getTop();
                                                VideoPbFragment.this.lNa = firstVisiblePosition;
                                                VideoPbFragment.this.lNb = top;
                                                if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && cIt.getCount() >= 6)) {
                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                    cIt.smoothScrollToPosition(0);
                                                } else {
                                                    cIt.smoothScrollToPosition(0);
                                                }
                                                dX.an("obj_locate", 1);
                                            }
                                            TiebaStatic.log(dX);
                                            com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(view);
                                            aq aqVar5 = new aq("c12942");
                                            aqVar5.an("obj_type", 1);
                                            aqVar5.an("obj_locate", 4);
                                            aqVar5.dX("tid", VideoPbFragment.this.dnW().dpX());
                                            aqVar5.dX(IntentConfig.NID, pbData.dmF().bpP());
                                            if (bV != null) {
                                                aqVar5.dX("obj_cur_page", bV.getCurrentPageKey());
                                            }
                                            if (com.baidu.tbadk.pageExtra.d.bHn() != null) {
                                                aqVar5.dX("obj_pre_page", com.baidu.tbadk.pageExtra.d.bHn());
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
                            if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null && VideoPbFragment.this.dnW().getPbData().dmF() != null && VideoPbFragment.this.dnW().getPbData().dmF().brr() != null) {
                                TiebaStatic.log(new aq("c13402").dX("tid", VideoPbFragment.this.dnW().dpX()).dX("fid", VideoPbFragment.this.dnW().getPbData().getForumId()).an("obj_locate", 2).dX("uid", VideoPbFragment.this.dnW().getPbData().dmF().brr().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.wa(false);
                        VideoPbFragment.this.doV();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.lNJ >= 0) {
                        if (VideoPbFragment.this.dnW() != null) {
                            VideoPbFragment.this.dnW().dqJ();
                        }
                        if (com.baidu.tbadk.a.d.bmI() && VideoPbFragment.this.dvN() != null && VideoPbFragment.this.dvN().dwu() != null) {
                            VideoPbFragment.this.dvN().dwu().setData(VideoPbFragment.this.dnW().getPbData());
                        } else if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dvL() != null && VideoPbFragment.this.dvL().dwu() != null) {
                            VideoPbFragment.this.dvL().dwu().setData(VideoPbFragment.this.dnW().getPbData());
                        }
                        VideoPbFragment.this.lNJ = 0;
                        VideoPbFragment.this.mfS = Integer.MIN_VALUE;
                        if (com.baidu.tbadk.a.d.bmI() && VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dvN() != null) {
                            VideoPbFragment.this.dvN().df(VideoPbFragment.this.dnW().dqM(), VideoPbFragment.this.dnW().dqN());
                            VideoPbFragment.this.dnW().dc(0, 0);
                        } else if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dvL() != null) {
                            VideoPbFragment.this.dvL().df(VideoPbFragment.this.dnW().dqM(), VideoPbFragment.this.dnW().dqN());
                            VideoPbFragment.this.dnW().dc(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.dnW() != null) {
                        aq aqVar6 = new aq("c13398");
                        aqVar6.dX("tid", VideoPbFragment.this.dnW().dpX());
                        aqVar6.dX("fid", VideoPbFragment.this.dnW().getForumId());
                        aqVar6.dX("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar6.an("obj_locate", 2);
                        TiebaStatic.log(aqVar6);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bg.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.bvr().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.drP();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.drP();
                } else if (VideoPbFragment.this.mfQ.dtP() != null && view == VideoPbFragment.this.mfQ.dtP().drp()) {
                    VideoPbFragment.this.mfQ.dsH();
                    if (VideoPbFragment.this.dnW() != null) {
                        VideoPbFragment.this.iwL.setThreadId(VideoPbFragment.this.dnW().dpX());
                    }
                    if (VideoPbFragment.this.dnW() == null || !VideoPbFragment.this.dnW().isPrivacy()) {
                        VideoPbFragment.this.iwL.cux();
                        if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null && VideoPbFragment.this.dnW().getPbData().getThreadId() != null && VideoPbFragment.this.dnW().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                            i3 = 2;
                        }
                        if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null) {
                            VideoPbFragment.this.iwL.l(3, i3, VideoPbFragment.this.dnW().getPbData().getThreadId());
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                    if (VideoPbFragment.this.dnW().getPbData() != null) {
                        VideoPbFragment.this.iwL.l(3, 3, VideoPbFragment.this.dnW().getPbData().getThreadId());
                    }
                } else if (view.getId() == R.id.pb_floor_right_top_feedback || view.getId() == R.id.pb_post_op_more) {
                    aq aqVar7 = new aq("c13398");
                    aqVar7.dX("tid", VideoPbFragment.this.dnW().dpX());
                    aqVar7.dX("fid", VideoPbFragment.this.dnW().getForumId());
                    aqVar7.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar7.an("obj_locate", 7);
                    TiebaStatic.log(aqVar7);
                    VideoPbFragment.this.mfQ.wh(false);
                    VideoPbFragment.this.mfQ.dvC().onLongClick(view);
                }
            }
        }
    };
    private View.OnClickListener lJR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.mfQ != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.mfQ.f(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.mfQ.dN(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.mfQ.f(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.mfQ.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
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
            VideoPbFragment.this.mfQ.wh(true);
            return VideoPbFragment.this.mfQ.dvC().onLongClick(view);
        }
    };
    public SortSwitchButton.a lOi = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean AL(int i) {
            if (VideoPbFragment.this.mfQ != null) {
                VideoPbFragment.this.mfQ.dsH();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.dnW() == null || VideoPbFragment.this.dnW().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.cFA();
                VideoPbFragment.this.dso();
                if (VideoPbFragment.this.dnW().getPbData() != null && VideoPbFragment.this.dnW().getPbData().lFQ != null && VideoPbFragment.this.dnW().getPbData().lFQ.size() > i) {
                    int intValue = VideoPbFragment.this.dnW().getPbData().lFQ.get(i).sort_type.intValue();
                    TiebaStatic.log(new aq("c13699").dX("tid", VideoPbFragment.this.dnW().dpY()).dX("fid", VideoPbFragment.this.dnW().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).an("obj_type", Ha(intValue)));
                    if (VideoPbFragment.this.dnW().Hh(intValue)) {
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
    private a mfR = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void dpf() {
        if (dnW() != null && dnW().getPbData() != null && dnW().getPbData().dmF() != null) {
            bz dmF = dnW().getPbData().dmF();
            dmF.mRecomAbTag = dnW().dqT();
            dmF.mRecomWeight = dnW().dqR();
            dmF.mRecomSource = dnW().dqS();
            dmF.mRecomExtra = dnW().dqU();
            dmF.eWD = dnW().dqf();
            if (dmF.getFid() == 0) {
                dmF.setFid(com.baidu.adp.lib.f.b.toLong(dnW().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dmF, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uO(boolean z) {
        if (dnW() != null && dnW().getPbData() != null && dnW().getPbData().dmF() != null) {
            bz dmF = dnW().getPbData().dmF();
            dmF.mRecomAbTag = dnW().dqT();
            dmF.mRecomWeight = dnW().dqR();
            dmF.mRecomSource = dnW().dqS();
            dmF.mRecomExtra = dnW().dqU();
            if (dmF.getFid() == 0) {
                dmF.setFid(com.baidu.adp.lib.f.b.toLong(dnW().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dmF, "c13563");
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
                if (com.baidu.tbadk.pageExtra.d.bHn() != null) {
                    a2.dX("obj_pre_page", com.baidu.tbadk.pageExtra.d.bHn());
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
            String string = !TextUtils.isEmpty(bVar.nut) ? bVar.nut : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.Bo(string);
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
                aVar.btY();
            } else {
                a(0, bVar.mSuccess, bVar.nut, z);
            }
            if (bVar.mSuccess) {
                if (bVar.iMd == 1) {
                    ArrayList<PostData> dmH = dnW().getPbData().dmH();
                    int size = dmH.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dmH.get(i).getId())) {
                            i++;
                        } else {
                            dmH.remove(i);
                            break;
                        }
                    }
                    dnW().getPbData().dmF().oN(dnW().getPbData().dmF().bri() - 1);
                    if (com.baidu.tbadk.a.d.bmI() && dvN() != null) {
                        dvN().dww();
                    } else if (dvL() != null) {
                        dvL().dww();
                    }
                } else if (bVar.iMd == 0) {
                    dpg();
                } else if (bVar.iMd == 2) {
                    ArrayList<PostData> dmH2 = dnW().getPbData().dmH();
                    int size2 = dmH2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dmH2.get(i2).dPb().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dmH2.get(i2).dPb().get(i3).getId())) {
                                i3++;
                            } else {
                                dmH2.get(i2).dPb().remove(i3);
                                dmH2.get(i2).dPd();
                                z2 = true;
                                break;
                            }
                        }
                        dmH2.get(i2).To(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        if (com.baidu.tbadk.a.d.bmI() && dvN() != null) {
                            dvN().dww();
                        } else if (dvL() != null) {
                            dvL().dww();
                        }
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = dnW().getPbData().dmT().lHx;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dPb().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dPb().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dPb().remove(i2);
                    list.get(i).dPd();
                    z = true;
                    break;
                }
            }
            list.get(i).To(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            if (com.baidu.tbadk.a.d.bmI() && dvN() != null) {
                dvN().dww();
            } else if (dvL() != null) {
                dvL().dww();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (gVar != null && dnW() != null && dnW().getPbData() != null && dnW().getPbData().dmF() != null) {
            a(this.ggJ.getLoadDataMode(), gVar.mSuccess, gVar.nut, false);
            if (gVar.mSuccess) {
                this.lNl = true;
                if (i == 2 || i == 3) {
                    this.lNm = true;
                    this.lNn = false;
                } else if (i == 4 || i == 5) {
                    this.lNm = false;
                    this.lNn = true;
                }
                if (i == 2) {
                    dnW().getPbData().dmF().oQ(1);
                    dnW().setIsGood(1);
                } else if (i == 3) {
                    dnW().getPbData().dmF().oQ(0);
                    dnW().setIsGood(0);
                } else if (i == 4) {
                    dnW().getPbData().dmF().oP(1);
                    dnW().Hb(1);
                } else if (i == 5) {
                    dnW().getPbData().dmF().oP(0);
                    dnW().Hb(0);
                }
            } else {
                if (gVar != null && !TextUtils.isEmpty(gVar.nut)) {
                    string = gVar.nut;
                } else {
                    string = getString(R.string.operation_failed);
                }
                l.showToast(getPageContext().getPageActivity(), string);
            }
            if (dnW().getPbData().dmF() != null && dvM() != null) {
                dvM().dwG();
            }
        }
    }

    private void dpg() {
        if (dnW().dqa() || dnW().dqc()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", dnW().dpX());
            PbActivity pbActivity = this.lMD;
            PbActivity pbActivity2 = this.lMD;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, dnW().dpX()));
        if (dpj()) {
            this.lMD.finish();
        }
    }

    private boolean dpj() {
        if (dnW() == null) {
            return true;
        }
        if (dnW().getPbData() == null || !dnW().getPbData().dni()) {
            if (dnW().bny()) {
                final MarkData dqs = dnW().dqs();
                if (dqs == null || !dnW().getIsFromMark() || cIt() == null) {
                    return true;
                }
                final MarkData Hi = dnW().Hi(cIt().getFirstVisiblePosition());
                if (Hi == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dqs);
                    this.lMD.setResult(-1, intent);
                    return true;
                } else if (Hi.getPostId() == null || Hi.getPostId().equals(dqs.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dqs);
                    this.lMD.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.Bo(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.lNi != null) {
                                if (VideoPbFragment.this.lNi.bny()) {
                                    VideoPbFragment.this.lNi.bnz();
                                    VideoPbFragment.this.lNi.jc(false);
                                }
                                VideoPbFragment.this.lNi.a(Hi);
                                VideoPbFragment.this.lNi.jc(true);
                                VideoPbFragment.this.lNi.bnA();
                            }
                            dqs.setPostId(Hi.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dqs);
                            VideoPbFragment.this.lMD.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dok();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dqs);
                            VideoPbFragment.this.lMD.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dok();
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.btY();
                    return false;
                }
            } else if (dnW().getPbData() == null || dnW().getPbData().dmH() == null || dnW().getPbData().dmH().size() <= 0 || !dnW().getIsFromMark()) {
                return true;
            } else {
                this.lMD.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dok() {
        this.lMD.dok();
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
        if (dnW() != null && this.mfQ != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = dnW().getPbData()) != null) {
                bz dmF = pbData.dmF();
                if (dmF != null && dmF.brr() != null) {
                    TiebaStatic.log(new aq("c13402").dX("tid", dnW().dpX()).dX("fid", pbData.getForumId()).an("obj_locate", 4).dX("uid", dmF.brr().getUserId()));
                }
                if (dmF != null) {
                    if (dmF.bpY()) {
                        i = 2;
                    } else if (dmF.bpZ()) {
                        i = 3;
                    } else if (dmF.btp()) {
                        i = 4;
                    } else if (dmF.btq()) {
                        i = 5;
                    }
                    aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    aqVar.dX("tid", dnW().dpX());
                    aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dX("fid", dnW().getForumId());
                    if (!z) {
                        aqVar.an("obj_locate", 6);
                    } else {
                        aqVar.an("obj_locate", 5);
                    }
                    aqVar.an("obj_name", i);
                    aqVar.an("obj_type", 2);
                    if (dmF != null) {
                        if (dmF.bpY()) {
                            aqVar.an("obj_type", 10);
                        } else if (dmF.bpZ()) {
                            aqVar.an("obj_type", 9);
                        } else if (dmF.btq()) {
                            aqVar.an("obj_type", 8);
                        } else if (dmF.btp()) {
                            aqVar.an("obj_type", 7);
                        } else if (dmF.isShareThread) {
                            aqVar.an("obj_type", 6);
                        } else if (dmF.threadType == 0) {
                            aqVar.an("obj_type", 1);
                        } else if (dmF.threadType == 40) {
                            aqVar.an("obj_type", 2);
                        } else if (dmF.threadType == 49) {
                            aqVar.an("obj_type", 3);
                        } else if (dmF.threadType == 54) {
                            aqVar.an("obj_type", 4);
                        } else {
                            aqVar.an("obj_type", 5);
                        }
                        aqVar.dX(IntentConfig.NID, dmF.bpP());
                        aqVar.an(IntentConfig.CARD_TYPE, dmF.btt());
                        aqVar.dX(IntentConfig.RECOM_SOURCE, dmF.mRecomSource);
                        aqVar.dX("ab_tag", dmF.mRecomAbTag);
                        aqVar.dX("weight", dmF.mRecomWeight);
                        aqVar.dX("extra", dmF.mRecomExtra);
                        aqVar.dX(IntentConfig.NID, dmF.bpP());
                        if (dmF.getBaijiahaoData() != null && !at.isEmpty(dmF.getBaijiahaoData().oriUgcVid)) {
                            aqVar.dX("obj_param6", dmF.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (dpE() != null) {
                        com.baidu.tbadk.pageInfo.c.b(dpE(), aqVar);
                    }
                    TiebaStatic.log(aqVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (dnW().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> dmH = pbData.dmH();
                        if ((dmH == null || dmH.size() <= 0) && dnW().dpZ()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.mfQ.dsH();
                        cFA();
                        TiebaStatic.log(new aq("c11939"));
                        if (!AntiHelper.d(getContext(), dmF)) {
                            if (this.lVj != null) {
                                this.lVj.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                GY(z ? 2 : 1);
                                return;
                            }
                            this.mfQ.showLoadingDialog();
                            dnW().dqD().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                aq aqVar2 = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar2.dX("tid", dnW().dpX());
                aqVar2.dX("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.dX("fid", dnW().getForumId());
                if (!z) {
                }
                aqVar2.an("obj_name", i);
                aqVar2.an("obj_type", 2);
                if (dmF != null) {
                }
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (dpE() != null) {
                }
                TiebaStatic.log(aqVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment dvs() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
        M(videoPbViewModel.dvY());
        N(videoPbViewModel.dvY());
        if (dnW() != null && dnW().getPbData() != null) {
            boolean isFromMark = dnW().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = dnW().getPbData();
            if (isFromMark) {
                PostData L = L(pbData);
                if (pbData.bnx() != null && !pbData.bnx().equals(L.getId()) && this.fbv != null) {
                    if (com.baidu.tbadk.a.d.bmI()) {
                        this.fbv.setCurrentItem(mfw);
                    } else {
                        this.fbv.setCurrentItem(mfv);
                    }
                }
            }
        }
        videoPbViewModel.dvZ().observe(this, new Observer<bz>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aR */
            public void onChanged(@Nullable bz bzVar) {
                BdTypeRecyclerView cIt;
                if (bzVar != null && bzVar.brI() != null) {
                    if (VideoPbFragment.this.mfD.getVideoUrl() == null || !VideoPbFragment.this.mfD.getVideoUrl().equals(bzVar.brI().video_url)) {
                        if (!at.isEmpty(VideoPbFragment.this.mfD.getVideoUrl())) {
                            VideoPbFragment.this.lMR = true;
                            if (com.baidu.tbadk.a.d.bmI()) {
                                VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfw);
                            } else {
                                VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfu);
                            }
                            if (com.baidu.tbadk.a.d.bmI() && (cIt = VideoPbFragment.this.cIt()) != null) {
                                cIt.scrollToPosition(0);
                            }
                        }
                        if (VideoPbFragment.this.mfE == null || !VideoPbFragment.this.mfE.isPlaying()) {
                            VideoPbFragment.this.dvt();
                            VideoPbFragment.this.aQ(bzVar);
                        }
                        VideoPbFragment.this.dvu();
                        if (VideoPbFragment.this.mfE.dwm()) {
                            VideoPbFragment.this.mfE.start();
                        }
                        boolean z = !at.equals(VideoPbFragment.this.mfD.getVideoUrl(), bzVar.brI().video_url);
                        VideoPbFragment.this.mfD.setData(bzVar);
                        if (com.baidu.tbadk.a.d.bmI()) {
                            VideoPbFragment.this.mfD.wj(false);
                        } else {
                            VideoPbFragment.this.mfD.wj(VideoPbFragment.this.fbv.getCurrentItem() == 0);
                        }
                        if (z) {
                            VideoPbFragment.this.mfD.startPlay();
                            VideoPbFragment.this.mfD.dwX();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.mfD.setData(bzVar);
                }
            }
        });
        videoPbViewModel.dwi().observe(this, new Observer<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: u */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.fbv.setCurrentItem(num.intValue());
            }
        });
        videoPbViewModel.dwd().observe(this, new Observer<bz>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aR */
            public void onChanged(@Nullable bz bzVar) {
                VideoPbFragment.this.mfD.aV(bzVar);
            }
        });
        videoPbViewModel.dwe().observe(this, new Observer<bz>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aR */
            public void onChanged(@Nullable bz bzVar) {
                VideoPbFragment.this.mfD.aW(bzVar);
            }
        });
        videoPbViewModel.dwf().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: s */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.dvE();
            }
        });
        videoPbViewModel.dwg().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: s */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvt() {
        ViewGroup.LayoutParams layoutParams = this.mfG.getLayoutParams();
        layoutParams.height = 0;
        this.mfG.setLayoutParams(layoutParams);
        this.mfG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvu() {
        if (this.mfE == null) {
            this.mfE = new e(getBaseFragmentActivity(), this.mfC);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(dpE()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.mfC.getOriginHeight() + statusBarHeight);
            final VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.mfE.b(videoPbViewModel.dwa(), rect);
            if (this.mfE.dwm()) {
                this.mfE.c(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (com.baidu.tbadk.a.d.bmI()) {
                            if (videoPbViewModel.dwb() || VideoPbFragment.this.dnW().dqW() == VideoPbFragment.mfw) {
                                VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfw);
                            }
                        } else if (videoPbViewModel.dwb() || VideoPbFragment.this.dnW().dqW() == VideoPbFragment.mfv) {
                            VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfv);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (com.baidu.tbadk.a.d.bmI()) {
                            if (videoPbViewModel.dwb() || VideoPbFragment.this.dnW().dqW() == VideoPbFragment.mfw) {
                                VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfw);
                            }
                        } else if (videoPbViewModel.dwb() || VideoPbFragment.this.dnW().dqW() == VideoPbFragment.mfv) {
                            VideoPbFragment.this.fbv.setCurrentItem(VideoPbFragment.mfv);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (com.baidu.tbadk.a.d.bmI()) {
                if (videoPbViewModel.dwb() || dnW().dqW() == mfw) {
                    this.fbv.setCurrentItem(mfw);
                }
            } else if (videoPbViewModel.dwb() || dnW().dqW() == mfv) {
                this.fbv.setCurrentItem(mfv);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.mfW && (this.mfX || dvS())) {
            dvR();
            UtilHelper.hideStatusBar(dpE(), dpE().getRootView());
            this.mfX = false;
            if (this.mfD != null) {
                this.mfD.wb(false);
            }
        }
        if (i == 4) {
            return this.mfD.dCk();
        }
        if (i == 24) {
            return this.mfD.dwU();
        }
        if (i == 25) {
            return this.mfD.dwV();
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
        Rect dqV;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bzVar != null && bzVar.brI() != null) {
            int intValue = bzVar.brI().video_width.intValue();
            int intValue2 = bzVar.brI().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (dnW() != null || (dqV = dnW().dqV()) == null) ? ceil : dqV.height();
                i = 0;
                layoutParams = this.mfC.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.mfC.setLayoutParams(layoutParams);
                this.mfC.setMaxHeight(ceil);
                this.mfC.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.mfC.setOriginHeight(height);
                if (!com.baidu.tbadk.a.d.bmI()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mfy.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, mfx);
                    } else {
                        layoutParams3.height = mfx;
                    }
                    this.mfy.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.ZS.getLayoutParams();
                if (!com.baidu.tbadk.a.d.bmI()) {
                    ceil += mfx;
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
        if (dnW() != null) {
        }
        i = 0;
        layoutParams = this.mfC.getLayoutParams();
        if (layoutParams != null) {
        }
        this.mfC.setLayoutParams(layoutParams);
        this.mfC.setMaxHeight(ceil2);
        this.mfC.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.mfC.setOriginHeight(height);
        if (!com.baidu.tbadk.a.d.bmI()) {
        }
        layoutParams2 = (CoordinatorLayout.LayoutParams) this.ZS.getLayoutParams();
        if (!com.baidu.tbadk.a.d.bmI()) {
        }
        if (layoutParams2 != null) {
        }
        this.ZS.setLayoutParams(layoutParams2);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.lML = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        at(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.lND = new com.baidu.tbadk.core.view.c();
        this.lND.toastTime = 1000L;
        if (this.mfQ != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.mfQ.lNE;
            userMuteAddAndDelCustomMessage.setTag(this.mfQ.lNE);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.mfQ.lNE;
            userMuteCheckCustomMessage.setTag(this.mfQ.lNE);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.iwL = new com.baidu.tieba.callfans.a(getPageContext());
        com.baidu.tieba.s.c.dNY().z(getUniqueId());
    }

    private void initData() {
        this.lNi = com.baidu.tbadk.baseEditMark.a.a(this.lMD);
        if (this.lNi != null) {
            this.lNi.a(this.lOo);
        }
        this.ggJ = new ForumManageModel(this.lMD);
        this.ggJ.setLoadDataCallBack(this.iwQ);
        this.fcZ = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.mfQ = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void at(Bundle bundle) {
        this.lNv = new g();
        d(this.lNv);
        this.lNw = (com.baidu.tbadk.editortools.pb.e) this.lNv.fj(getActivity());
        this.lNw.a(this.lMD.getPageContext());
        this.lNw.a(this.fGo);
        this.lNw.a(this.fGh);
        this.lNw.setFrom(1);
        this.lNw.a(this.lMD.getPageContext(), bundle);
        this.lNw.bEJ().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lNw.bEJ().kO(true);
        uN(true);
        this.lNw.a(dnW().dqo(), dnW().dpX(), dnW().dqF());
        registerListener(this.lNT);
        registerListener(this.lOn);
        registerListener(this.lNS);
        registerListener(this.lNQ);
        registerListener(this.jgK);
        if (!dnW().dqf()) {
            this.lNw.DR(dnW().dpX());
        }
        if (dnW().dqG()) {
            this.lNw.DP(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.lNw.DP(drR());
        }
        this.kSQ = new ar();
        if (this.lNw.bFp() != null) {
            this.kSQ.f(this.lNw.bFp().getInputView());
        }
        this.lNw.a(this.fGi);
        this.kON = new al(getPageContext());
        this.kON.a(new al.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // com.baidu.tbadk.core.util.al.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == al.fcU) {
                        VideoPbFragment.this.lNw.a((String) null, (WriteData) null);
                    } else if (i == al.fcV && VideoPbFragment.this.lVL != null && VideoPbFragment.this.lVL.doJ() != null) {
                        VideoPbFragment.this.lVL.doJ().bFN();
                    } else if (i == al.fcW) {
                        VideoPbFragment.this.c(VideoPbFragment.this.lNz);
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
        this.jkd.a(lOw);
        this.mfW = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        bIl();
        this.ZS = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.mfA = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.mfC = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.mfD = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.mfC);
        this.mfD.setStageType("2002");
        this.mfD.setUniqueId(getUniqueId());
        this.mfD.af(this);
        this.mfD.dV(dpE().getRootView());
        this.mfD.dW(this.mfF);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.mfy = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.mfG = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.fbv = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.mfB = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.mfB.setOnClickListener(this.aHh);
        dvw();
        dvv();
        dvx();
        this.mfz = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.fbv.setAdapter(this.mfz);
        this.mfy.setViewPager(this.fbv);
        this.mfy.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (com.baidu.tbadk.a.d.bmI() && VideoPbFragment.this.dvN() != null) {
                        VideoPbFragment.this.dvN().wi(false);
                    } else if (VideoPbFragment.this.dvL() != null) {
                        VideoPbFragment.this.dvL().wi(false);
                    }
                    if (VideoPbFragment.this.dvM() != null) {
                        VideoPbFragment.this.dvM().wi(true);
                        VideoPbFragment.this.HI(VideoPbFragment.this.dvM().dwA() != 0 ? 0 : 8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(VideoPbFragment.this.getActivity()).get(VideoPbViewModel.class);
                    if (videoPbViewModel.dwf() != null && videoPbViewModel.dwf().getValue() != null && videoPbViewModel.dwf().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.mfD.wj(z);
                    VideoPbFragment.this.drP();
                    if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null) {
                        TiebaStatic.log(new aq("c13592").dX("tid", VideoPbFragment.this.dnW().dpX()).dX("fid", VideoPbFragment.this.dnW().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.dvM() != null) {
                        VideoPbFragment.this.dvM().wi(false);
                    }
                    if (com.baidu.tbadk.a.d.bmI() && VideoPbFragment.this.dvN() != null) {
                        VideoPbFragment.this.dvN().wi(true);
                        int dwA = VideoPbFragment.this.dvN().dwA();
                        int dwB = VideoPbFragment.this.dvN().dwB();
                        if (dwA != 0) {
                            VideoPbFragment.this.HI(8);
                            VideoPbFragment.this.dvN().HI(0);
                        } else if (dwB != 0) {
                            VideoPbFragment.this.dvN().HI(8);
                            VideoPbFragment.this.HI(0);
                        } else {
                            VideoPbFragment.this.dvN().HI(8);
                            VideoPbFragment.this.HI(8);
                        }
                    } else if (VideoPbFragment.this.dvL() != null) {
                        VideoPbFragment.this.dvL().wi(true);
                        int dwA2 = VideoPbFragment.this.dvL().dwA();
                        int dwB2 = VideoPbFragment.this.dvL().dwB();
                        if (dwA2 != 0) {
                            VideoPbFragment.this.HI(8);
                            VideoPbFragment.this.dvL().HI(0);
                        } else if (dwB2 != 0) {
                            VideoPbFragment.this.dvL().HI(8);
                            VideoPbFragment.this.HI(0);
                        } else {
                            VideoPbFragment.this.dvL().HI(8);
                            VideoPbFragment.this.HI(8);
                        }
                    }
                    VideoPbFragment.this.mfD.wj(false);
                    VideoPbFragment.this.ZS.setExpanded(false, true);
                    if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null) {
                        TiebaStatic.log(new aq("c13593").dX("tid", VideoPbFragment.this.dnW().dpX()).dX("fid", VideoPbFragment.this.dnW().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.mfz.HK(i);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.lUK = this.rootView.findViewById(R.id.viewstub_progress);
        dvy();
        bZB();
        if (!this.mfW && this.mfX) {
            dvR();
            UtilHelper.hideStatusBar(dpE(), dpE().getRootView());
            this.mfX = false;
        }
        if (com.baidu.tbadk.a.d.bmI()) {
            this.mfy.getLayoutParams().height = 0;
        }
    }

    private void dvv() {
        this.mfI = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.mfM = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.mfJ = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.mfK = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.mfL = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.mfN = this.rootView.findViewById(R.id.ala_live_point);
        this.mfM.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.mfM.setConrers(15);
        this.mfL.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.mfK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.lGA == null || VideoPbFragment.this.lGA.dwM()) {
                    if (VideoPbFragment.this.lGA != null) {
                        TiebaStatic.log(new aq("c13608").dX("tid", VideoPbFragment.this.dnW().getPbData().getThreadId()));
                        VideoPbFragment.this.lGA.mhT = true;
                    }
                } else {
                    TiebaStatic.log(new aq("c13591"));
                }
                VideoPbFragment.this.dvG();
            }
        });
        this.mfL.setOnClickListener(this.mfH);
        this.mfG.setOnClickListener(this.mfH);
    }

    private void dvw() {
        this.mfy.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.mfy.setContainerLayoutParams(layoutParams);
        this.mfy.setRectPaintColor(R.color.CAM_X0302);
        this.mfy.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.mfy.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.mfy.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.mfy.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.mfy.setExpandedTabLayoutParams(layoutParams2);
    }

    public void wa(boolean z) {
        if (this.ZS != null) {
            this.ZS.setExpanded(z);
        }
    }

    private void dvx() {
        this.lVc = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.lVd = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.lVn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lVo = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lVf = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lVf.setVisibility(0);
        this.lVf.setIsRound(true);
        this.lVf.setBorderWidth(l.getDimens(getContext(), R.dimen.L_X01));
        this.lVf.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.lVf.setPlaceHolder(0);
        drV();
        this.klE = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lVe = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lVe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.wa(false);
                VideoPbFragment.this.doV();
                if (VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null && VideoPbFragment.this.dnW().getPbData().dmF() != null && VideoPbFragment.this.dnW().getPbData().dmF().brr() != null) {
                    TiebaStatic.log(new aq("c13701").dX("tid", VideoPbFragment.this.dnW().dpY()).dX("fid", VideoPbFragment.this.dnW().getPbData().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new aq("c13402").dX("tid", VideoPbFragment.this.dnW().dpX()).dX("fid", VideoPbFragment.this.dnW().getPbData().getForumId()).an("obj_locate", 1).dX("uid", VideoPbFragment.this.dnW().getPbData().dmF().brr().getUserId()));
                }
            }
        });
        this.lVg = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lVg.setOnClickListener(this.aHh);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lVh = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.lVh.setOnClickListener(this.aHh);
        if (booleanExtra) {
            this.lVh.setVisibility(8);
        } else {
            this.lVh.setVisibility(0);
        }
        this.lVi = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.lVi.setOnClickListener(this.aHh);
        this.lVj = new com.baidu.tieba.pb.view.d(this.lVi);
        this.lVj.dxg();
        this.lVk = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lVk.setVisibility(0);
        vz(false);
    }

    private void drV() {
        if (this.lVf != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lVf.setImageResource(0);
            this.lVf.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.lVf.setImageResource(R.drawable.transparent_bg);
    }

    private void bIl() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cFB();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.mfF = this.rootView.findViewById(R.id.status_bar_background);
        if (this.mfW) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(dpE());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.mfF.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(dpE());
            this.mfF.setLayoutParams(layoutParams2);
            this.mfF.setVisibility(0);
        }
        this.fOs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aHh);
        this.gZY = (ImageView) this.fOs.findViewById(R.id.widget_navi_back_button);
        SvgManager.bwr().a(this.gZY, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jvO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aHh);
        this.aiG = (ImageView) this.jvO.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.jvO.setLayoutParams(layoutParams3);
        SvgManager.bwr().a(this.aiG, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jvO.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.jrz);
        this.mNavigationBar.setOnTouchListener(this.mfY);
    }

    public void dvy() {
        setEditorTools(this.lNw.bEJ());
    }

    private void bZB() {
        this.lMy = new PbFakeFloorModel(getPageContext());
        this.lVL = new r(getPageContext(), this.lMy, this.rootView);
        this.lVL.V(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.drP();
            }
        });
        this.lVL.a(this.lOk);
        this.lMy.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.lMy.u(postData);
                if (com.baidu.tbadk.a.d.bmI() || VideoPbFragment.this.dvN() != null) {
                    VideoPbFragment.this.dvN().dww();
                } else if (VideoPbFragment.this.dvL() != null) {
                    VideoPbFragment.this.dvL().dww();
                }
                VideoPbFragment.this.lVL.doF();
                VideoPbFragment.this.acZ.bDf();
                VideoPbFragment.this.vz(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, PostData postData2, boolean z, boolean z2) {
        PbActivity.a PM;
        String dpX = dnW().dpX();
        String id = postData.getId();
        String str = "";
        if (postData2 != null) {
            str = postData2.getId();
        }
        int i = 0;
        if (dnW().getPbData() != null) {
            i = dnW().getPbData().dmU();
        }
        if (dvL() != null && dvL().dwy() != null) {
            PM = dvL().dwy().PM(id);
        } else if (dvN() != null && dvN().dwy() != null) {
            PM = dvN().dwy().PM(id);
        } else {
            return;
        }
        if (postData != null && dnW() != null && dnW().getPbData() != null && PM != null) {
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dpX, id, "pb", true, null, false, str, i, postData.duP(), dnW().getPbData().getAnti(), false, postData.brr().getIconInfo()).addBigImageData(PM.lJk, PM.eMr, PM.eMp, PM.index);
            if (z2) {
                addBigImageData.setHighLightPostId(str);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(dnW().getForumId());
            addBigImageData.setBjhData(dnW().dqh());
            addBigImageData.setKeyPageStartFrom(dnW().dqI());
            addBigImageData.setFromFrsForumId(dnW().getFromForumId());
            addBigImageData.setIsOpenEditor(z);
            if (dnW().getPbData().dno() != null) {
                addBigImageData.setHasForumRule(dnW().getPbData().dno().has_forum_rule.intValue());
            }
            if (dnW().getPbData().getUserData() != null) {
                addBigImageData.setIsManager(dnW().getPbData().getUserData().getIs_manager());
            }
            if (dnW().getPbData().getForum().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(dnW().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(dnW().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (dnW().getPbData().getForum() != null) {
                addBigImageData.setForumHeadUrl(dnW().getPbData().getForum().getImage_url());
                addBigImageData.setUserLevel(dnW().getPbData().getForum().getUser_level());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lMD = (PbActivity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (dnW() != null) {
            dnW().aD(bundle);
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
        this.mfD.sg(true);
        if (dnW() != null && !dnW().dqf()) {
            this.lNw.DQ(dnW().dpX());
        }
        com.baidu.tbadk.BdToken.c.bkU().blf();
        MessageManager.getInstance().unRegisterListener(this.lOd);
        MessageManager.getInstance().unRegisterListener(this.lOe);
        MessageManager.getInstance().unRegisterListener(this.lOf);
        MessageManager.getInstance().unRegisterListener(this.jtD);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        getVoiceManager().onResume(getPageContext());
        this.mfD.sg(false);
        dpA();
        registerListener(this.lOd);
        registerListener(this.lOe);
        registerListener(this.lOf);
        registerListener(this.jtD);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.mfz != null && this.fbv != null) {
            this.mfz.HK(z ? this.fbv.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        drV();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.dNY().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dNY().A(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.lVj != null) {
            this.lVj.onDestroy();
        }
        if (this.ggJ != null) {
            this.ggJ.cancelLoadData();
        }
        if (this.mfD != null) {
            this.mfD.onDestroy();
        }
        if (this.lMW != null) {
            this.lMW.cancelLoadData();
        }
        if (this.kON != null) {
            this.kON.onDestroy();
        }
        if (dnW() != null) {
            dnW().cancelLoadData();
            dnW().destory();
            if (dnW().dqC() != null) {
                dnW().dqC().onDestroy();
            }
        }
        if (this.lNw != null) {
            this.lNw.onDestroy();
        }
        this.lND = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.lMD);
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        ao.setBackgroundColor(this.mStatusBar, R.color.CAM_X0611);
        ao.setBackgroundColor(this.mfF, R.color.CAM_X0608);
        ao.setBackgroundColor(this.mfy, R.color.CAM_X0207);
        if (this.mfy != null) {
            this.mfy.onChangeSkinType();
        }
        if (this.kSQ != null) {
            this.kSQ.onChangeSkinType();
        }
        if (this.mfE == null || !this.mfE.isPlaying()) {
            ao.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        }
        if (this.acZ != null) {
            this.acZ.onChangeSkinType(i);
        }
        if (this.lVL != null) {
            this.lVL.onChangeSkinType(i);
        }
        if (this.lVf != null) {
            this.lVf.setBorderColor(ao.getColor(R.color.CAM_X0401));
        }
        if (this.lVe != null) {
            this.lVe.setBackgroundDrawable(ao.aO(l.getDimens(getContext(), R.dimen.tbds47), ao.getColor(R.color.CAM_X0209)));
        }
        if (dnW() != null && dnW().bny()) {
            WebPManager.a(this.lVh, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.a(this.lVh, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.a(this.lVg, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        SvgManager.bwr().a(this.mfK, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (dnW() != null) {
            x(dnW().getPbData());
        }
        ao.setBackgroundResource(this.mfA, R.drawable.personalize_tab_shadow);
        ao.setBackgroundColor(this.mfG, R.color.CAM_X0206);
        ao.setBackgroundColor(this.lVd, R.color.CAM_X0207);
        ao.setBackgroundColor(this.lVc, R.color.CAM_X0203);
        ao.setViewTextColor(this.mfJ, R.color.CAM_X0109);
        ao.setViewTextColor(this.mfI, R.color.CAM_X0105);
        ao.setViewTextColor(this.klE, R.color.CAM_X0109);
        ao.setViewTextColor(this.lVl, R.color.CAM_X0105);
        ao.setViewTextColor(this.lVk, R.color.CAM_X0107);
        ao.d(this.lVk, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        if (com.baidu.tbadk.a.d.bmI() && dvN() != null) {
            dvN().onChangeSkinType(i);
        } else if (dvL() != null) {
            dvL().onChangeSkinType(i);
        }
        if (dvM() != null) {
            dvM().onChangeSkinType(i);
        }
        if (this.mfN != null) {
            this.mfN.setBackgroundDrawable(ao.aO(l.getDimens(this.mfN.getContext(), R.dimen.tbds32), ao.getColor(R.color.CAM_X0309)));
        }
        cFA();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jfh == null) {
            this.jfh = VoiceManager.instance();
        }
        return this.jfh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFA() {
        if (this.jfh != null) {
            this.jfh.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dpC() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dpD() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dnW() {
        return this.lMD.dnW();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dpE() {
        return this.lMD;
    }

    public com.baidu.tbadk.baseEditMark.a dvz() {
        return this.lNi;
    }

    public View.OnClickListener dvA() {
        return this.aHh;
    }

    public View.OnClickListener dvB() {
        return this.lJR;
    }

    public View.OnLongClickListener dvC() {
        return this.mOnLongClickListener;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (au.Qb(objArr[i].getLink()) && (drawable = ao.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView cIt() {
        Iterator<BaseFragment> it = this.mfz.dvW().iterator();
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
        this.lNw.kW(z);
        this.lNw.kX(z);
        this.lNw.kY(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.mfQ != null) {
            if (z) {
                this.mfQ.dsH();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.mfQ.dsI();
            } else {
                this.mfQ.dsH();
            }
        }
    }

    public boolean GV(int i) {
        if (this.kON == null || dnW() == null || dnW().getPbData() == null || dnW().getPbData().getAnti() == null) {
            return true;
        }
        return this.kON.aN(dnW().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean doX() {
        if ((dnW() != null && dnW().getPbData().dni()) || this.kON == null || dnW() == null || dnW().getPbData() == null || dnW().getPbData().getAnti() == null) {
            return true;
        }
        return this.kON.pZ(dnW().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && dnW() != null) {
            gVar.setForumName(dnW().dnP());
            if (dnW().getPbData() != null && dnW().getPbData().getForum() != null) {
                gVar.a(dnW().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(dnW());
        }
    }

    public void dsg() {
        if (this.acZ != null) {
            this.acZ.rV();
            if (this.lNw != null) {
                this.lNw.bFu();
            }
            dsQ();
        }
    }

    public com.baidu.tbadk.editortools.pb.e doK() {
        return this.lNw;
    }

    private boolean doU() {
        PbModel dnW = dnW();
        if (dnW == null || dnW.getPbData() == null) {
            return false;
        }
        bz dmF = dnW.getPbData().dmF();
        dnW.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), dmF);
    }

    public void doV() {
        if (checkUpIsLogin() && dnW() != null && dnW().getPbData() != null && dnW().getPbData().getForum() != null && !doU()) {
            if (dnW().getPbData().dni()) {
                cUf();
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
                            if (VideoPbFragment.this.lNw != null && VideoPbFragment.this.lNw.bEJ() != null) {
                                VideoPbFragment.this.lNw.bEJ().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            VideoPbFragment.this.cUf();
                        }
                    }
                });
            }
            this.jjD.H(dnW().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dnW().dpX(), 0L));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.lNw.onActivityResult(i, i2, intent);
        if (this.lMW != null) {
            this.lMW.onActivityResult(i, i2, intent);
        }
        if (this.lVL != null) {
            this.lVL.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dph();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dEB().E(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.lNz = emotionImageData;
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
        if (dpE() != null) {
            if (this.mfX && !TbSingleton.getInstance().isNotchScreen(dpE()) && !TbSingleton.getInstance().isCutoutScreen(dpE())) {
                dvR();
                UtilHelper.hideStatusBar(dpE(), dpE().getRootView());
                this.mfX = false;
            }
            this.mfR.mgm = z;
            dvD();
            dvE();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.lMD;
        if (i == 0) {
            drL();
            if (this.lVL != null) {
                this.lVL.doF();
            }
            vz(false);
        }
        drP();
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
                        this.lNw.resetData();
                        this.lNw.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lNw.c(writeData);
                        m sv = this.lNw.bEJ().sv(6);
                        if (sv != null && sv.fDH != null) {
                            sv.fDH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lMD;
                        if (i == -1) {
                            this.lNw.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lVL != null && this.lVL.doJ() != null) {
                            com.baidu.tbadk.editortools.pb.h doJ = this.lVL.doJ();
                            doJ.setThreadData(dnW().getPbData().dmF());
                            doJ.c(writeData);
                            doJ.setVoiceModel(pbEditorData.getVoiceModel());
                            m sv2 = doJ.bEJ().sv(6);
                            if (sv2 != null && sv2.fDH != null) {
                                sv2.fDH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lMD;
                            if (i == -1) {
                                doJ.bFN();
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
                if (dnW() != null && !dnW().dqf()) {
                    antiData.setBlock_forum_name(dnW().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(dnW().getPbData().getForum().getId());
                    antiData.setUser_name(dnW().getPbData().getUserData().getUserName());
                    antiData.setUser_id(dnW().getPbData().getUserData().getUserId());
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
            if (this.mfQ != null) {
                this.mfQ.DW(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void dpG() {
        if (dnW() != null && this.lMD != null) {
            if (this.lNw == null || !this.lNw.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.lNw = (com.baidu.tbadk.editortools.pb.e) dVar.fj(getContext());
                this.lNw.a(this.lMD.getPageContext());
                this.lNw.a(this.fGo);
                this.lNw.a(this.fGh);
                this.lNw.a(this.lMD.getPageContext(), this.lMD.getIntent() == null ? null : this.lMD.getIntent().getExtras());
                this.lNw.bEJ().kO(true);
                setEditorTools(this.lNw.bEJ());
                if (!dnW().dqf()) {
                    this.lNw.DR(dnW().dpX());
                }
                if (dnW().dqG()) {
                    this.lNw.DP(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.lNw.DP(drR());
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
                VideoPbFragment.this.drP();
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
                    if (((u) aVar.data).bzX() == EmotionGroupType.BIG_EMOTION || ((u) aVar.data).bzX() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.lNw.c((u) aVar.data);
                            VideoPbFragment.this.lNw.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        drL();
        this.lNw.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
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
                if (VideoPbFragment.this.kSQ != null && VideoPbFragment.this.kSQ.dtj() != null) {
                    if (!VideoPbFragment.this.kSQ.dtj().dXU()) {
                        VideoPbFragment.this.kSQ.vF(false);
                    }
                    VideoPbFragment.this.kSQ.dtj().zc(false);
                }
            }
        });
    }

    public void cUf() {
        if (!checkUpIsLogin()) {
            if (dnW() != null) {
                TiebaStatic.log(new aq("c10517").an("obj_locate", 2).dX("fid", dnW().getForumId()));
            }
        } else if (doX()) {
            if (this.lNw != null && (this.lNw.bFE() || this.lNw.bFF())) {
                this.lNw.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.acZ != null) {
                dsg();
                this.mfR.mgl = false;
                if (this.acZ.sv(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.acZ.sv(2).fDH, false, null);
                }
            }
            dsQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !doU() && doX()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lMY);
                this.lMZ = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.lVL != null && postData != null) {
                String str3 = "";
                if (postData.dPg() != null) {
                    str3 = postData.dPg().toString();
                }
                this.lVL.PG(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.brr().getName_show(), str3));
            }
            if (dnW() != null && dnW().getPbData() != null && dnW().getPbData().dni()) {
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.lMD.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.lMY[1] + VideoPbFragment.this.lMZ) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cIt() != null) {
                            VideoPbFragment.this.cIt().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.lVL != null) {
                            VideoPbFragment.this.lNw.bEJ().setVisibility(8);
                            VideoPbFragment.this.lVL.j(str, str2, VideoPbFragment.this.drR(), (VideoPbFragment.this.dnW() == null || VideoPbFragment.this.dnW().getPbData() == null || VideoPbFragment.this.dnW().getPbData().dmF() == null || !VideoPbFragment.this.dnW().getPbData().dmF().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h doJ = VideoPbFragment.this.lVL.doJ();
                            if (doJ != null && VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null) {
                                doJ.a(VideoPbFragment.this.dnW().getPbData().getAnti());
                                doJ.setThreadData(VideoPbFragment.this.dnW().getPbData().dmF());
                            }
                            if (VideoPbFragment.this.kSQ.dtl() == null && VideoPbFragment.this.lVL.doJ().bFV() != null) {
                                VideoPbFragment.this.lVL.doJ().bFV().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kSQ != null && VideoPbFragment.this.kSQ.dtk() != null) {
                                            if (!VideoPbFragment.this.kSQ.dtk().dXU()) {
                                                VideoPbFragment.this.kSQ.vG(false);
                                            }
                                            VideoPbFragment.this.kSQ.dtk().zc(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kSQ.g(VideoPbFragment.this.lVL.doJ().bFV().getInputView());
                                VideoPbFragment.this.lVL.doJ().a(VideoPbFragment.this.lNB);
                            }
                        }
                        VideoPbFragment.this.dsQ();
                    }
                }, 0L);
                return;
            }
            if (this.lNy == null) {
                this.lNy = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lNy.BA(1);
                this.lNy.a(new AnonymousClass49(str, str2));
            }
            if (dnW() != null && dnW().getPbData() != null && dnW().getPbData().getForum() != null) {
                this.lNy.H(dnW().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dnW().dpX(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$49  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass49 implements c.a {
        final /* synthetic */ String lOG;
        final /* synthetic */ String lOH;

        AnonymousClass49(String str, String str2) {
            this.lOG = str;
            this.lOH = str2;
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
                        int i = (VideoPbFragment.this.lMY[1] + VideoPbFragment.this.lMZ) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cIt() != null) {
                            VideoPbFragment.this.cIt().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.lVL != null) {
                            VideoPbFragment.this.lNw.bEJ().setVisibility(8);
                            VideoPbFragment.this.lVL.j(AnonymousClass49.this.lOG, AnonymousClass49.this.lOH, VideoPbFragment.this.drR(), (VideoPbFragment.this.dnW() == null || VideoPbFragment.this.dnW().getPbData() == null || VideoPbFragment.this.dnW().getPbData().dmF() == null || !VideoPbFragment.this.dnW().getPbData().dmF().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h doJ = VideoPbFragment.this.lVL.doJ();
                            if (doJ != null && VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null) {
                                doJ.a(VideoPbFragment.this.dnW().getPbData().getAnti());
                                doJ.setThreadData(VideoPbFragment.this.dnW().getPbData().dmF());
                            }
                            if (VideoPbFragment.this.kSQ.dtl() == null && VideoPbFragment.this.lVL.doJ().bFV() != null) {
                                VideoPbFragment.this.lVL.doJ().bFV().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kSQ != null && VideoPbFragment.this.kSQ.dtk() != null) {
                                            if (!VideoPbFragment.this.kSQ.dtk().dXU()) {
                                                VideoPbFragment.this.kSQ.vG(false);
                                            }
                                            VideoPbFragment.this.kSQ.dtk().zc(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kSQ.g(VideoPbFragment.this.lVL.doJ().bFV().getInputView());
                                VideoPbFragment.this.lVL.doJ().a(VideoPbFragment.this.lNB);
                            }
                        }
                        VideoPbFragment.this.dsQ();
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
            String userId = L.brr().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, L.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dmU()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (L.brr() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, L.brr().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, L.brr().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, L.brr().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, L.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, L.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dmU()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bv> dnc = fVar.dnc();
                if (x.getCount(dnc) > 0) {
                    sb = new StringBuilder();
                    for (bv bvVar : dnc) {
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
    public void dph() {
        MarkData Hi;
        if (dnW() != null && dnW().getPbData() != null) {
            if (com.baidu.tbadk.a.d.bmI() || dvL() != null) {
                if ((!com.baidu.tbadk.a.d.bmI() || dvN() != null) && this.lNi != null) {
                    if (dnW().getPbData() != null && dnW().getPbData().dni()) {
                        Hi = dnW().Hi(0);
                    } else if (this.fbv != null && this.fbv.getCurrentItem() == mfu) {
                        Hi = dnW().o(L(dnW().getPbData()));
                    } else if (com.baidu.tbadk.a.d.bmI()) {
                        Hi = dnW().Hi(dvN().dst());
                    } else {
                        Hi = dnW().Hi(dvL().dst());
                    }
                    if (Hi != null) {
                        if (!Hi.isApp() || (Hi = dnW().Hi(dvL().dst() + 1)) != null) {
                            dso();
                            this.lNi.a(Hi);
                            if (!this.lNi.bny()) {
                                this.lNi.bnA();
                                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                                return;
                            }
                            this.lNi.bnz();
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
            if (this.lMW == null) {
                this.lMW = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lMD);
                this.lMW.b(this.fGh);
                this.lMW.c(this.fGo);
            }
            this.lMW.a(emotionImageData, dnW(), dnW().getPbData());
        }
    }

    public PostData L(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dmS() != null) {
            return fVar.dmS();
        }
        if (!x.isEmpty(fVar.dmH())) {
            Iterator<PostData> it = fVar.dmH().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dPe() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dmO();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.brr() != null && postData.brr().getUserTbVipInfoData() != null && postData.brr().getUserTbVipInfoData().getvipIntro() != null) {
            postData.brr().getGodUserData().setIntro(postData.brr().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dmF() == null || fVar.dmF().brr() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData brr = fVar.dmF().brr();
        String userId = brr.getUserId();
        HashMap<String, MetaData> userMap = fVar.dmF().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = brr;
        }
        postData.KR(1);
        postData.setId(fVar.dmF().brH());
        postData.setTitle(fVar.dmF().getTitle());
        postData.setTime(fVar.dmF().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dpm() {
        ArrayList<PostData> dmH;
        int count;
        int i;
        if (dnW() == null || dnW().getPbData() == null || dnW().getPbData().dmH() == null || (count = x.getCount((dmH = dnW().getPbData().dmH()))) == 0) {
            return "";
        }
        if (dnW().dqq()) {
            Iterator<PostData> it = dmH.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dPe() == 1) {
                    return next.getId();
                }
            }
        }
        if (cIt() == null) {
            i = 0;
        } else if (com.baidu.tbadk.a.d.bmI()) {
            i = dvN().dss();
        } else {
            i = dvL().dss();
        }
        PostData postData = (PostData) x.getItem(dmH, i);
        if (postData == null || postData.brr() == null) {
            return "";
        }
        if (dnW().PP(postData.brr().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) x.getItem(dmH, i2);
            if (postData2 == null || postData2.brr() == null || postData2.brr().getUserId() == null) {
                break;
            } else if (dnW().PP(postData2.brr().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) x.getItem(dmH, i3);
            if (postData3 == null || postData3.brr() == null || postData3.brr().getUserId() == null) {
                return "";
            }
            if (dnW().PP(postData3.brr().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpi() {
        if (dnW() != null) {
            com.baidu.tieba.pb.data.f pbData = dnW().getPbData();
            dnW().vd(true);
            if (this.lNi != null) {
                pbData.PA(this.lNi.bnx());
            }
            if (com.baidu.tbadk.a.d.bmI() && dvN() != null) {
                dvN().dww();
            } else if (dvL() != null) {
                dvL().dww();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (dnW() != null) {
            dsq();
            dnW().vd(z);
            if (this.lNi != null) {
                this.lNi.jc(z);
                if (markData != null) {
                    this.lNi.a(markData);
                }
            }
            if (dnW().bny()) {
                dpi();
            } else if (com.baidu.tbadk.a.d.bmI() && dvN() != null) {
                dvN().dww();
            } else if (dvL() != null) {
                dvL().dww();
            }
        }
    }

    public void b(p pVar) {
        boolean z;
        MetaData metaData;
        if (dnW() != null && dnW().getPbData() != null && pVar.dny() != null) {
            String id = pVar.dny().getId();
            ArrayList<PostData> dmH = dnW().getPbData().dmH();
            int i = 0;
            while (true) {
                if (i >= dmH.size()) {
                    z = true;
                    break;
                }
                PostData postData = dmH.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dnG = pVar.dnG();
                    postData.KQ(pVar.getTotalCount());
                    if (postData.dPb() == null || dnG == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dnG.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.brr() != null && (metaData = postData.getUserMap().get(next.brr().getUserId())) != null) {
                                next.a(metaData);
                                next.yh(true);
                                next.a(getPageContext(), dnW().PP(metaData.getUserId()));
                            }
                        }
                        z = dnG.size() != postData.dPb().size();
                        if (postData.dPb() != null && postData.dPb().size() < 2) {
                            postData.dPb().clear();
                            postData.dPb().addAll(dnG);
                        }
                    }
                    if (postData.dOX() != null) {
                        postData.dOY();
                    }
                }
            }
            if (!dnW().getIsFromMark() && z) {
                if (com.baidu.tbadk.a.d.bmI() && dvN() != null) {
                    dvN().dww();
                } else if (dvL() != null) {
                    dvL().dww();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doZ() {
        if (dnW() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.Sy(dnW().getForumId()) && dnW().getPbData() != null && dnW().getPbData().getForum() != null) {
            if (dnW().getPbData().getForum().isLike() == 1) {
                dnW().dqE().gk(dnW().getForumId(), dnW().dpX());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            bz dmF = fVar.dmF();
            if (dmF != null && dmF.bqa()) {
                dpG();
            } else {
                d(this.lNv);
            }
            if (this.lNw != null) {
                vx(this.lNw.bFx());
                this.lNw.a(fVar.getAnti());
                this.lNw.a(fVar.getForum(), fVar.getUserData());
                this.lNw.setThreadData(dmF);
                if (dnW() != null) {
                    this.lNw.a(dnW().dqo(), dnW().dpX(), dnW().dqF());
                }
                if (dmF != null) {
                    this.lNw.kZ(dmF.bsR());
                }
            }
        }
    }

    public void drP() {
        reset();
        drL();
        this.lVL.doF();
        vz(false);
    }

    private void reset() {
        if (this.lNw != null && this.acZ != null) {
            com.baidu.tbadk.editortools.pb.a.bFm().setStatus(0);
            this.lNw.bFH();
            this.lNw.bEW();
            if (this.lNw.getWriteImagesInfo() != null) {
                this.lNw.getWriteImagesInfo().setMaxImagesAllowed(this.lNw.isBJH ? 1 : 9);
            }
            this.lNw.sF(SendView.ALL);
            this.lNw.sG(SendView.ALL);
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
        if (fVar != null && fVar.dmF() != null) {
            x(fVar);
            this.lVh.setVisibility(fVar.dni() ? 8 : 0);
            if (fVar.bny()) {
                WebPManager.a(this.lVh, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lVh, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String Hq = Hq(fVar.dmF().bri());
            if (this.lVk != null) {
                this.lVk.setText(Hq);
            }
            if (this.lVl != null) {
                this.lVl.setText(Hq);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dmF()));
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bc(fVar.dmF())) {
            if (this.lVj != null) {
                this.lVj.setEnable(false);
                this.lVj.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.lVi.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.lVi.setLayoutParams(layoutParams);
            WebPManager.a(this.lVi, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.lVj == null || !this.lVj.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.lVi.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.lVi.setLayoutParams(layoutParams2);
            WebPManager.a(this.lVi, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
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
        if (this.lVd != null) {
            vx(this.lNw.bFx());
            if (this.lUZ) {
                vo(z);
            } else {
                vp(z);
            }
            dvD();
            dvE();
        }
    }

    public void dsQ() {
        if (this.lVd != null) {
            this.lVc.setVisibility(8);
            this.lVd.setVisibility(8);
            this.mfR.mgl = false;
            dvD();
            dvE();
        }
    }

    private void dvD() {
        if (this.mfD != null) {
            if (this.mfR.dvV()) {
                this.mfD.xb(false);
            } else {
                this.mfD.xb(this.mfD.isVertical() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvE() {
        if (this.mfD != null && this.fbv != null) {
            if (com.baidu.tbadk.a.d.bmI()) {
                this.mfD.wj(false);
            } else if (this.fbv.getCurrentItem() != 0) {
                this.mfD.wj(false);
            } else if (this.mfR.dvV()) {
                this.mfD.wj(false);
            } else {
                VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
                if (videoPbViewModel != null) {
                    this.mfD.wj(videoPbViewModel.dwf() == null || videoPbViewModel.dwf().getValue() == null || videoPbViewModel.dwf().getValue().booleanValue());
                }
            }
        }
    }

    private void GY(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(dpE(), doY(), i);
    }

    private int doY() {
        if (dnW() == null || dnW().getPbData() == null || dnW().getPbData().dmF() == null) {
            return -1;
        }
        return dnW().getPbData().dmF().bse();
    }

    public void vx(boolean z) {
        this.lUZ = z;
    }

    public void vo(boolean z) {
        if (this.lVd != null && this.klE != null) {
            this.klE.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lVd.startAnimation(alphaAnimation);
            }
            this.lVc.setVisibility(0);
            this.lVd.setVisibility(0);
            this.mfR.mgl = true;
        }
    }

    public void vp(boolean z) {
        if (this.lVd != null && this.klE != null) {
            this.klE.setText(drR());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lVd.startAnimation(alphaAnimation);
            }
            this.lVc.setVisibility(0);
            this.lVd.setVisibility(0);
            this.mfR.mgl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null && this.lGA == null) {
            this.lGA = aVar;
            this.mfI.setText(aVar.getTitle());
            this.mfJ.setText(aVar.dwJ());
            String dwK = aVar.dwK();
            TBSpecificationBtn tBSpecificationBtn = this.mfL;
            if (TextUtils.isEmpty(dwK)) {
                dwK = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(dwK);
            this.mfM.startLoad(aVar.getImage(), 10, false);
            this.mfN.setVisibility(aVar.dwM() ? 0 : 8);
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.lGA == null || VideoPbFragment.this.lGA.dwM()) {
                        if (VideoPbFragment.this.lGA != null && VideoPbFragment.this.dnW() != null && VideoPbFragment.this.dnW().getPbData() != null && VideoPbFragment.this.dnW().getPbData().getForum() != null) {
                            TiebaStatic.log(new aq("c13712").dX("fid", VideoPbFragment.this.dnW().getPbData().getForum().getId()).dX("fname", VideoPbFragment.this.dnW().getPbData().getForum().getName()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("tid", VideoPbFragment.this.dnW().getPbData().getThreadId()).w("obj_param1", VideoPbFragment.this.lGA.userId));
                        }
                    } else {
                        TiebaStatic.log(new aq("c13608").dX("obj_id", VideoPbFragment.this.lGA.getTitle()).dX("obj_name", VideoPbFragment.this.lGA.dwJ()).an("obj_type", 2).dX("fid", VideoPbFragment.this.dnW().getPbData().getForumId()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("tid", VideoPbFragment.this.dnW().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.dvF();
                }
            }, aVar.dwL().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvF() {
        ViewGroup.LayoutParams layoutParams = this.mfG.getLayoutParams();
        if (layoutParams != null) {
            if (this.mfO == null || !this.mfO.isRunning()) {
                this.mfG.setAlpha(0.0f);
                this.mfG.setVisibility(0);
                f(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvG() {
        if (this.mfG.getLayoutParams() != null) {
            if (this.mfO == null || !this.mfO.isRunning()) {
                dvH();
            }
        }
    }

    private void dvH() {
        final ViewGroup.LayoutParams layoutParams = this.mfG.getLayoutParams();
        if (layoutParams != null) {
            if (this.mfP == null || !this.mfP.isRunning()) {
                this.mfP = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.mfP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.mfG.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.mfP.setDuration(200L);
                this.mfP.start();
                this.mfP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
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
        this.mfO = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mfO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.kin);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.kin);
                VideoPbFragment.this.mfG.setLayoutParams(layoutParams);
                VideoPbFragment.this.ZS.setLayoutParams(layoutParams2);
            }
        });
        this.mfO.setDuration(300L);
        this.mfO.start();
        this.mfO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.mfG.setVisibility(8);
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
        this.mfO = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mfO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.kin);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.mfG.setLayoutParams(layoutParams);
                VideoPbFragment.this.ZS.setLayoutParams(layoutParams2);
            }
        });
        this.mfO.setDuration(300L);
        this.mfO.start();
        this.mfO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.dvI();
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
    public void dvI() {
        this.mfO = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mfO.setDuration(300L);
        this.mfO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.mfG.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.mfO.start();
    }

    public String drR() {
        if (!at.isEmpty(this.lWd)) {
            return this.lWd;
        }
        this.lWd = TbadkCoreApplication.getInst().getResources().getString(com.baidu.tieba.pb.pb.main.ao.drH());
        return this.lWd;
    }

    public void dsq() {
        hideProgressBar();
        if (com.baidu.tbadk.a.d.bmI() && dvN() != null) {
            dvN().endLoadData();
            dvN().dsr();
        } else if (dvL() != null) {
            dvL().endLoadData();
            dvL().dsr();
        }
    }

    public boolean dE(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bov().isShowImages()) {
                    return PL(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (dnW() == null || dnW().getPbData() == null) {
                        return true;
                    }
                    if (this.lVL != null) {
                        this.lVL.doF();
                    }
                    p pVar = new p();
                    pVar.a(dnW().getPbData().getForum());
                    pVar.setThreadData(dnW().getPbData().dmF());
                    pVar.g(postData);
                    this.lMy.d(pVar);
                    this.lMy.setPostId(postData.getId());
                    a(view, postData.brr().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lNw != null) {
                        vx(this.lNw.bFx());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void dvJ() {
        if (this.lNw != null) {
            vx(this.lNw.bFx());
        }
        drP();
        this.mfQ.dsH();
    }

    private boolean PL(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bvr().getString("bubble_link", "");
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

    public void dsk() {
        if (this.lUK != null) {
            this.lUK.setVisibility(0);
        }
    }

    public void dsl() {
        if (this.lUK != null) {
            this.lUK.setVisibility(8);
        }
    }

    public void HI(int i) {
        if (this.mfA != null) {
            this.mfA.setVisibility(i);
        }
    }

    public void dso() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a dpc() {
        return this.lOm;
    }

    public void drL() {
        if (this.acZ != null) {
            this.acZ.hide();
        }
    }

    public void cFB() {
        if (this.lMD.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lMD.getCurrentFocus());
        }
    }

    public void N(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmF() != null) {
            String valueOf = String.valueOf(fVar.dmF().bri());
            if (fVar.dmF().bri() == 0) {
                valueOf = "";
            }
            this.mfy.EW(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.mfz.dvW()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (dnW() != null && dnW().getPbData() != null && dnW().getPbData().dmF() != null && dnW().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(lVE)).intValue();
                if (intValue == lVF) {
                    if (!this.ggJ.dPZ()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.ggJ.TC(at.S(jSONArray));
                        }
                        this.ggJ.a(dnW().getPbData().getForum().getId(), dnW().getPbData().getForum().getName(), dnW().getPbData().dmF().getId(), str, intValue3, intValue2, booleanValue, dnW().getPbData().dmF().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == lVG || intValue == lVI) {
                    if (dnW().dqB() != null) {
                        dnW().dqB().GQ(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == lVG) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(String str, String str2) {
        be.bwv().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bLF() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bLG() {
        if (this.fWD == null) {
            this.fWD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bLS */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bov().isShowImages();
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
                        if (com.baidu.tbadk.core.k.bov().isShowImages()) {
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
    public com.baidu.adp.lib.d.b<TextView> bLH() {
        if (this.fZS == null) {
            this.fZS = TbRichTextView.K(getPageContext().getPageActivity(), 8);
        }
        return this.fZS;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bLI() {
        if (this.fWE == null) {
            this.fWE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: czF */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bov().isShowImages();
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
                    if (com.baidu.tbadk.core.k.bov().isShowImages()) {
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
                    gifView.bGo();
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
    public com.baidu.adp.lib.d.b<View> bLJ() {
        if (this.fZT == null) {
            this.fZT = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpH */
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
                    ((PlayVoiceBntNew) view).cfr();
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
    public com.baidu.adp.lib.d.b<LinearLayout> bLK() {
        if (this.fZU == null) {
            this.fZU = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpJ */
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
    public com.baidu.adp.lib.d.b<RelativeLayout> bLL() {
        this.fZV = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dpI */
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
        this.lMP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (au.Qb(str) && dnW() != null && dnW().dpX() != null) {
            TiebaStatic.log(new aq("c11664").an("obj_param1", 1).dX("post_id", dnW().dpX()));
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
            au.dtn().f(getPageContext(), str);
        }
        this.lMP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
        au.dtn().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lMP = true;
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
            this.mfQ.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b dws = this.mfQ.dws();
            if (dws == null) {
                this.mfQ.doT();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                dws.getItemView(1).setVisibility(8);
            } else {
                dws.getItemView(1).setVisibility(0);
            }
            dws.bua();
            this.lMP = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aJ(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.bwv().b(getPageContext(), new String[]{str});
            this.lMP = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a dvK() {
        return this.fcZ;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bJf() {
        return this.bTP;
    }

    public ReplyFragment dvL() {
        if (this.mfz == null || !(this.mfz.HJ(mfv) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.mfz.HJ(mfv);
    }

    public DetailInfoFragment dvM() {
        if (this.mfz == null || !(this.mfz.HJ(mfu) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.mfz.HJ(mfu);
    }

    public DetailInfoAndReplyFragment dvN() {
        if (this.mfz == null || !(this.mfz.HJ(mfw) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.mfz.HJ(mfw);
    }

    public boolean dnO() {
        PbModel dnW = this.lMD.dnW();
        if (dnW == null) {
            return false;
        }
        return dnW.dnO();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dmR;
        PbModel dnW = this.lMD.dnW();
        if (dnW != null && dnW.getPbData() != null && !dnW.getPbData().dni()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = dnW.getPbData().dmF().getId();
            if (dnW.isShareThread() && dnW.getPbData().dmF().eVB != null) {
                historyMessage.threadName = dnW.getPbData().dmF().eVB.showText;
            } else {
                historyMessage.threadName = dnW.getPbData().dmF().getTitle();
            }
            if (dnW.isShareThread() && !dnO()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = dnW.getPbData().getForum().getName();
            }
            ArrayList<PostData> dmH = dnW.getPbData().dmH();
            int dss = dvL() != null ? dvL().dss() : 0;
            if (dmH != null && dss >= 0 && dss < dmH.size()) {
                historyMessage.postID = dmH.get(dss).getId();
            }
            historyMessage.isHostOnly = dnW.getHostMode();
            historyMessage.isSquence = dnW.dpZ();
            historyMessage.isShareThread = dnW.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lNw != null) {
            this.lNw.onDestroy();
        }
        if (dnW != null && (dnW.dqa() || dnW.dqc())) {
            Intent intent = new Intent();
            intent.putExtra("tid", dnW.dpX());
            if (this.lNl) {
                if (this.lNn) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", dnW.cxO());
                }
                if (this.lNm) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", dnW.getIsGood());
                }
            }
            if (dnW.getPbData() != null && System.currentTimeMillis() - this.lML >= 40000 && (dmR = dnW.getPbData().dmR()) != null && !x.isEmpty(dmR.getDataList())) {
                intent.putExtra("guess_like_data", dmR);
            }
            PbActivity pbActivity = this.lMD;
            PbActivity pbActivity2 = this.lMD;
            pbActivity.setResult(-1, intent);
        }
        if (dpj()) {
            if (dnW != null) {
                com.baidu.tieba.pb.data.f pbData = dnW.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.lMR) {
                        if (this.mfC != null) {
                            Rect rect = new Rect();
                            this.mfC.getGlobalVisibleRect(rect);
                            aj.drw().g(rect);
                        }
                        aj.drw().Hm(this.fbv.getCurrentItem());
                        BdTypeRecyclerView cIt = cIt();
                        Parcelable parcelable = null;
                        if (cIt != null) {
                            parcelable = cIt.onSaveInstanceState();
                        }
                        aj.drw().a(dnW.dqi(), parcelable, dnW.dpZ(), dnW.getHostMode(), false);
                    }
                }
            } else {
                aj.drw().reset();
            }
            dok();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mfD != null && !this.mfD.isVertical()) {
            if ((this.mfD.isFullScreen() && configuration.orientation == 1) || (!this.mfD.isFullScreen() && configuration.orientation == 2)) {
                this.mfD.wk(false);
            }
        }
    }

    public boolean dvO() {
        if (this.mfD == null) {
            return false;
        }
        return this.mfD.isVertical();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.dNY().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        public boolean mgl;
        public boolean mgm;

        private a() {
            this.mgm = true;
        }

        public boolean dvV() {
            return (this.mgl && this.mgm) ? false : true;
        }
    }

    public void dvP() {
        this.lNa = -1;
        this.lNb = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpA() {
        if (dnW() != null && !at.isEmpty(dnW().dpX())) {
            com.baidu.tbadk.BdToken.c.bkU().p(com.baidu.tbadk.BdToken.b.eEL, com.baidu.adp.lib.f.b.toLong(dnW().dpX(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.mfB.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvQ() {
        if (this.mga == null) {
            this.mga = ObjectAnimator.ofFloat(this.mfF, "alpha", 0.0f, 1.0f);
            this.mga.setDuration(200L);
        }
        this.mga.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvR() {
        if (this.mgb == null) {
            this.mgb = ObjectAnimator.ofFloat(this.mfF, "alpha", 1.0f, 0.0f);
            this.mgb.setDuration(200L);
        }
        this.mgb.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dvS() {
        return this.mfD != null && this.mfD.dvT();
    }

    public boolean dvT() {
        return this.mfX;
    }

    public void wb(boolean z) {
        this.mfX = z;
    }

    public void uU(boolean z) {
        this.lMS = z;
    }

    public boolean dpy() {
        return this.lMS;
    }

    public LinearLayout dtg() {
        return this.lVe;
    }
}
