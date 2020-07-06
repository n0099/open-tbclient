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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
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
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.editortools.pb.h;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.gif.GifView;
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
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.pb.pb.main.ax;
import com.baidu.tieba.pb.pb.main.ba;
import com.baidu.tieba.pb.pb.main.t;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
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
/* loaded from: classes9.dex */
public class VideoPbFragment extends BaseFragment implements VoiceManager.c, TbRichTextView.c, i, com.baidu.tieba.pb.videopb.a, b {
    private AppBarLayout WW;
    private EditorTools ZX;
    private ImageView afe;
    private CustomViewPager dSy;
    public View eDr;
    private com.baidu.adp.lib.d.b<ImageView> eLl;
    private com.baidu.adp.lib.d.b<GifView> eLm;
    private com.baidu.adp.lib.d.b<TextView> eOC;
    private com.baidu.adp.lib.d.b<View> eOD;
    private com.baidu.adp.lib.d.b<LinearLayout> eOE;
    private com.baidu.adp.lib.d.b<RelativeLayout> eOF;
    private ImageView fIH;
    private com.baidu.tieba.callfans.a gRZ;
    private com.baidu.tieba.frs.profession.permission.c hDN;
    private com.baidu.tieba.f.b hEm;
    private VoiceManager hzJ;
    private com.baidu.tieba.pb.videopb.c.a jZw;
    public ak jhL;
    private PbFakeFloorModel keK;
    private PbActivity keN;
    private g kfC;
    private com.baidu.tbadk.editortools.pb.e kfD;
    private com.baidu.tieba.frs.profession.permission.c kfF;
    private EmotionImageData kfG;
    private com.baidu.tbadk.core.view.c kfK;
    private com.baidu.tieba.pb.pb.main.emotion.model.a kfe;
    int kfh;
    public ax kfu;
    private View kmL;
    private LinearLayout kmN;
    private HeadImageView kmO;
    private ImageView kmP;
    private ImageView kmQ;
    private ImageView kmR;
    private com.baidu.tieba.pb.view.c kmS;
    private TextView kmT;
    private TextView kmU;
    private int kmW;
    private int kmX;
    private View kmu;
    private String knL;
    private t knu;
    public View ksu;
    private NewPagerSlidingTabBaseStrip kwR;
    private VideoPbFragmentAdapter kwS;
    private View kwT;
    private View kwU;
    private VideoContainerLayout kwV;
    private com.baidu.tieba.pb.videopb.videoView.a kwW;
    private f kwX;
    private View kwY;
    private View kwZ;
    private TextView kxb;
    private TextView kxc;
    private ImageView kxd;
    private TBSpecificationBtn kxe;
    private TbImageView kxf;
    private View kxg;
    private ValueAnimator kxh;
    private ValueAnimator kxi;
    public com.baidu.tieba.pb.videopb.b.a kxj;
    private float kxn;
    private float kxo;
    private boolean kxp;
    private ObjectAnimator kxt;
    private ObjectAnimator kxu;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int kwO = 0;
    public static int kwP = 1;
    public static int knm = 3;
    public static int knn = 0;
    public static int kno = 3;
    public static int knp = 4;
    public static int knq = 5;
    public static int knr = 6;
    private static final int ivr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int kwQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a kgB = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void ce(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cHT();
            } else {
                com.baidu.tieba.pb.a.b.cHS();
            }
        }
    };
    private long keU = 0;
    View.OnClickListener kxa = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.jZw == null || VideoPbFragment.this.jZw.cQr()) {
                if (VideoPbFragment.this.jZw != null) {
                    if (VideoPbFragment.this.jZw.isChushou) {
                        VideoPbFragment.this.dS(VideoPbFragment.this.jZw.thirdRoomId, VideoPbFragment.this.jZw.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.jZw.cQs();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null && VideoPbFragment.this.cIf().getPbData().getForum() != null) {
                        TiebaStatic.log(new ao("c13713").dk("fid", VideoPbFragment.this.cIf().getPbData().getForum().getId()).dk("fname", VideoPbFragment.this.cIf().getPbData().getForum().getName()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("tid", VideoPbFragment.this.cIf().getPbData().getThreadId()).s("obj_param1", VideoPbFragment.this.jZw.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new ao("c13590").dk("obj_id", VideoPbFragment.this.jZw.getTitle()).dk("obj_name", VideoPbFragment.this.jZw.cQo()).ag("obj_type", 2).dk("fid", VideoPbFragment.this.cIf().getPbData().getForumId()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("tid", VideoPbFragment.this.cIf().getPbData().getThreadId()));
            String link = VideoPbFragment.this.jZw.getLink();
            if (!TextUtils.isEmpty(link)) {
                if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                    bc.aWU().b(VideoPbFragment.this.getPageContext(), new String[]{link});
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
    private com.baidu.tbadk.baseEditMark.a kfo = null;
    private com.baidu.tbadk.coreExtra.model.a dUB = null;
    private ForumManageModel gRX = null;
    private boolean keY = false;
    private View kmM = null;
    private TextView iyQ = null;
    private boolean kmI = false;
    private String evB = null;
    private boolean kfr = false;
    private boolean kfs = false;
    private boolean kft = false;
    private boolean kfa = false;
    int[] kfg = new int[2];
    private int kfi = -1;
    private int kfj = Integer.MIN_VALUE;
    private int kfQ = 0;
    private int kxl = Integer.MIN_VALUE;
    private boolean bjF = false;
    private final PbModel.a kgq = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g ny;
            VideoPbFragment.this.cMl();
            VideoPbFragment.this.crG();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.so(false);
            if (z && eVar != null) {
                bu cGO = eVar.cGO();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(eVar, i2);
                VideoPbFragment.this.J(eVar);
                com.baidu.tieba.pb.videopb.c.a cHs = eVar.cHs();
                if (cHs != null && !cHs.kyX) {
                    VideoPbFragment.this.a(cHs);
                }
                VideoPbFragment.this.K(eVar);
                VideoPbFragment.this.c(z, i, i2, i3, eVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.kfo != null) {
                    VideoPbFragment.this.kfo.gJ(eVar.aOo());
                }
                AntiData anti = eVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.evB = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.evB) && VideoPbFragment.this.kfD != null && VideoPbFragment.this.kfD.bfa() != null && (ny = VideoPbFragment.this.kfD.bfa().ny(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.evB)) {
                        ((View) ny).setOnClickListener(VideoPbFragment.this.ewn);
                    }
                }
                if (VideoPbFragment.this.jhL != null && cGO != null && cGO.aSp() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(cGO.aSp());
                    VideoPbFragment.this.jhL.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.cIf().cKa());
                        jSONObject.put("fid", VideoPbFragment.this.cIf().getForumId());
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
                if (VideoPbFragment.this.cPy() != null) {
                    if (i != -1) {
                        ArrayList<PostData> arrayList = null;
                        if (VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null) {
                            arrayList = VideoPbFragment.this.cIf().getPbData().cGQ();
                        }
                        if (w.getCount(arrayList) == 0 || (w.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dhZ() == 1)) {
                            if (VideoPbFragment.this.cPy().cJD()) {
                                VideoPbFragment.this.cPy().Kc(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                VideoPbFragment.this.cPy().Kc(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            VideoPbFragment.this.cPy().Kb(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                        }
                    } else {
                        VideoPbFragment.this.cPy().Kb("");
                    }
                    VideoPbFragment.this.cPy().endLoadData();
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.dgY().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0477a kgs = new a.InterfaceC0477a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0477a
        public void c(boolean z, boolean z2, String str) {
            VideoPbFragment.this.cMl();
            if (z && VideoPbFragment.this.cIf() != null) {
                if (VideoPbFragment.this.kfo != null) {
                    VideoPbFragment.this.kfo.gJ(z2);
                }
                VideoPbFragment.this.cIf().rT(z2);
                if (VideoPbFragment.this.cIf().aOo()) {
                    VideoPbFragment.this.cJo();
                } else if (VideoPbFragment.this.cPy() != null) {
                    VideoPbFragment.this.cPy().cQj();
                }
                if (z2) {
                    if (VideoPbFragment.this.kfo != null) {
                        if (VideoPbFragment.this.kfo.aOr() != null && VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null && VideoPbFragment.this.cIf().getPbData().cGO() != null && VideoPbFragment.this.cIf().getPbData().cGO().aSp() != null) {
                            MarkData aOr = VideoPbFragment.this.kfo.aOr();
                            MetaData aSp = VideoPbFragment.this.cIf().getPbData().cGO().aSp();
                            if (aOr != null && aSp != null) {
                                if (!ar.equals(TbadkCoreApplication.getCurrentAccount(), aSp.getUserId()) && !aSp.hadConcerned()) {
                                    VideoPbFragment.this.kxj.b(aSp);
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
                    VideoPbFragment.this.cJl();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b evF = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bfy() {
            if (VideoPbFragment.this.kfu == null || VideoPbFragment.this.kfu.cNb() == null || !VideoPbFragment.this.kfu.cNb().dqO()) {
                return !VideoPbFragment.this.Bj(ak.dUw);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kfu.cNb().dqQ());
            if (VideoPbFragment.this.kfD != null && (VideoPbFragment.this.kfD.bfP() || VideoPbFragment.this.kfD.bfQ())) {
                VideoPbFragment.this.kfD.a(false, VideoPbFragment.this.kfu.cNe());
            }
            VideoPbFragment.this.kfu.st(true);
            return true;
        }
    };
    private final CustomMessageListener kfX = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.cIf() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.kfD != null) {
                    VideoPbFragment.this.sm(VideoPbFragment.this.kfD.bfI());
                }
                VideoPbFragment.this.cLO();
                VideoPbFragment.this.kxj.cMC();
            }
        }
    };
    private CustomMessageListener kga = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        VideoPbFragment.this.b((n) eVar.getData());
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
    private final CustomMessageListener hBf = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.bjF) {
                VideoPbFragment.this.cJF();
            }
        }
    };
    private CustomMessageListener kgr = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.cJf();
            }
        }
    };
    private CustomMessageListener kgl = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.kxj != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kxj.kfL) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.kxj.bJn();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.kxj.getExtra();
                DataRes dataRes = aVar.lUk;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (ar.isEmpty(str)) {
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
                    VideoPbFragment.this.kxj.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.kxj.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener kgj = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.kxj != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kxj.kfL) {
                VideoPbFragment.this.kxj.bJn();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.cIf().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cHe().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.kfK.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.kxj.yH(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.kxj.cJC();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ar.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.kfK.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener kgk = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.kxj != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kxj.kfL) {
                VideoPbFragment.this.kxj.bJn();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.kfK.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ar.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.kfK.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b kfI = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bfy() {
            if (VideoPbFragment.this.kfu == null || VideoPbFragment.this.kfu.cNc() == null || !VideoPbFragment.this.kfu.cNc().dqO()) {
                return !VideoPbFragment.this.Bj(ak.dUx);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kfu.cNc().dqQ());
            if (VideoPbFragment.this.knu != null && VideoPbFragment.this.knu.cIP() != null && VideoPbFragment.this.knu.cIP().bfQ()) {
                VideoPbFragment.this.knu.cIP().a(VideoPbFragment.this.kfu.cNe());
            }
            VideoPbFragment.this.kfu.su(true);
            return true;
        }
    };
    private final NewWriteModel.d evL = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                ao aoVar = new ao("c13268");
                aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null) {
                    aoVar.dk("fid", VideoPbFragment.this.cIf().getPbData().getForumId());
                }
                aoVar.dk("tid", VideoPbFragment.this.cIf().cKa());
                aoVar.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aoVar);
            }
            VideoPbFragment.this.bYx();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.cIf() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.cIf().JW(postWriteCallBackData.getPostId());
                    if (VideoPbFragment.this.cPy() != null) {
                        VideoPbFragment.this.kfQ = VideoPbFragment.this.cPy().cMn();
                        VideoPbFragment.this.kxl = VideoPbFragment.this.cPy().cQm();
                        VideoPbFragment.this.cIf().cJ(VideoPbFragment.this.kfQ, VideoPbFragment.this.kxl);
                    }
                }
                if (VideoPbFragment.this.dSy != null) {
                    VideoPbFragment.this.dSy.setCurrentItem(VideoPbFragment.kwP);
                }
                VideoPbFragment.this.kxj.cMC();
                VideoPbFragment.this.kfu.cNa();
                if (VideoPbFragment.this.kfD != null) {
                    VideoPbFragment.this.sm(VideoPbFragment.this.kfD.bfI());
                }
                VideoPbFragment.this.cLK();
                VideoPbFragment.this.so(true);
                VideoPbFragment.this.cIf().cKv();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && VideoPbFragment.this.cPy() != null) {
                            VideoPbFragment.this.cPy().cQj();
                        }
                    } else if (VideoPbFragment.this.cIf().getHostMode()) {
                        com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.cIf().getPbData();
                        if (pbData != null && pbData.cGO() != null && pbData.cGO().aSp() != null && (userId = pbData.cGO().aSp().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.cIf().cKm()) {
                            VideoPbFragment.this.cMj();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.cIf().cKm()) {
                        VideoPbFragment.this.cMj();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.rG(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.kfD.bfP() || VideoPbFragment.this.kfD.bfQ()) {
                    VideoPbFragment.this.kfD.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.kfu.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.jhL != null) {
                    VideoPbFragment.this.jhL.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (ar.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (ar.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.we(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.we(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new ao("c13746").ag("obj_locate", 1).ag("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).aUN();
                TiebaStatic.log(new ao("c13745").ag("obj_locate", 1).ag("obj_type", 2));
            } else if (adVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener ewn = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.evB);
        }
    };
    private CustomMessageListener kfZ = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.kfD != null) {
                    VideoPbFragment.this.sm(VideoPbFragment.this.kfD.bfI());
                }
                VideoPbFragment.this.so(false);
            }
        }
    };
    private int kxm = 0;
    private boolean kxq = true;
    private View.OnTouchListener kxr = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.kxm == 1) {
                if (!VideoPbFragment.this.kxq) {
                    VideoPbFragment.this.cPC();
                    UtilHelper.showStatusBar(VideoPbFragment.this.cJJ(), VideoPbFragment.this.cJJ().getRootView());
                    VideoPbFragment.this.kxq = true;
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(VideoPbFragment.this.kxs);
                    com.baidu.adp.lib.f.e.lt().postDelayed(VideoPbFragment.this.kxs, 3000L);
                }
            } else if (VideoPbFragment.this.kxm == 2 && (VideoPbFragment.this.kxq || VideoPbFragment.this.cPE())) {
                VideoPbFragment.this.cPD();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cJJ(), VideoPbFragment.this.cJJ().getRootView());
                VideoPbFragment.this.kxq = false;
                if (VideoPbFragment.this.kwW != null) {
                    VideoPbFragment.this.kwW.sO(false);
                }
            }
            VideoPbFragment.this.kxm = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener hKL = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.kxm = 0;
            VideoPbFragment.this.kxn = 0.0f;
            VideoPbFragment.this.kxo = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.kxn += f;
            VideoPbFragment.this.kxo += f2;
            if (VideoPbFragment.this.kxm == 0 && !VideoPbFragment.this.kxp && VideoPbFragment.this.kwW != null && !VideoPbFragment.this.kwW.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.kxo) <= Math.abs(VideoPbFragment.this.kxn) || VideoPbFragment.this.kxo > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.kxo) > Math.abs(VideoPbFragment.this.kxn) && VideoPbFragment.this.kxo > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.kxm = 2;
                    }
                } else {
                    VideoPbFragment.this.kxm = 1;
                }
            }
            return true;
        }
    };
    private Runnable kxs = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.kxq && !VideoPbFragment.this.cPE()) {
                VideoPbFragment.this.cPD();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cJJ(), VideoPbFragment.this.cJJ().getRootView());
                VideoPbFragment.this.kxq = false;
            }
        }
    };
    private final com.baidu.adp.base.d gSe = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.cIf() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.gRX.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.gRX.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.cIf().cKv();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.kun != 1002 || bVar.fPZ) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.Pv, dVar.lIA, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.gRX.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.gRX.getLoadDataMode(), gVar.Pv, gVar.lIA, false);
                    VideoPbFragment.this.kxj.aQ(gVar.lID);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener eEC = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.hEm.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d kgo = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            if (!ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                ao aoVar = new ao("c13268");
                aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null) {
                    aoVar.dk("fid", VideoPbFragment.this.cIf().getPbData().getForumId());
                }
                if (VideoPbFragment.this.cIf() != null) {
                    aoVar.dk("tid", VideoPbFragment.this.cIf().cKa());
                }
                aoVar.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aoVar);
            }
            if (z) {
                if (VideoPbFragment.this.kfu != null) {
                    VideoPbFragment.this.kfu.cMZ();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.jhL != null) {
                    VideoPbFragment.this.jhL.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (ar.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (ar.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.we(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.we(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new ao("c13746").ag("obj_locate", 1).ag("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).aUN();
                TiebaStatic.log(new ao("c13745").ag("obj_locate", 1).ag("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.kfu != null) {
                if (VideoPbFragment.this.knu != null && VideoPbFragment.this.knu.cIP() != null && VideoPbFragment.this.knu.cIP().bfQ()) {
                    VideoPbFragment.this.knu.cIP().a(postWriteCallBackData);
                }
                VideoPbFragment.this.kfu.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c evE = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bfz() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener aXG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            boolean y;
            int i2 = 3;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    ao aoVar = new ao("c13398");
                    aoVar.dk("tid", VideoPbFragment.this.cIf().cKa());
                    aoVar.dk("fid", VideoPbFragment.this.cIf().getForumId());
                    aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                    aoVar.ag("obj_locate", 1);
                    TiebaStatic.log(aoVar);
                    if (VideoPbFragment.this.keY) {
                        VideoPbFragment.this.keY = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null && VideoPbFragment.this.keK != null && postData.aSp() != null && postData.dhZ() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.knu != null) {
                                    VideoPbFragment.this.knu.cIL();
                                }
                                n nVar = new n();
                                nVar.a(VideoPbFragment.this.cIf().getPbData().getForum());
                                nVar.setThreadData(VideoPbFragment.this.cIf().getPbData().cGO());
                                nVar.g(postData);
                                VideoPbFragment.this.keK.d(nVar);
                                VideoPbFragment.this.keK.setPostId(postData.getId());
                                VideoPbFragment.this.b(view, postData.aSp().getUserId(), "");
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.cIf().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.kfD != null) {
                                    VideoPbFragment.this.sm(VideoPbFragment.this.kfD.bfI());
                                }
                            }
                        }
                    }
                } else if (VideoPbFragment.this.cPy() != null && VideoPbFragment.this.cPy().cMy() != null && view == VideoPbFragment.this.cPy().cMy()) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.cIf().rR(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        VideoPbFragment.this.cPy().cMk();
                    }
                } else if (VideoPbFragment.this.kxj != null && VideoPbFragment.this.kxj.cNH() != null && view == VideoPbFragment.this.kxj.cNH().cLj()) {
                    VideoPbFragment.this.kxj.aFg();
                } else if (VideoPbFragment.this.kxj != null && ((VideoPbFragment.this.kxj.cNH() != null && view == VideoPbFragment.this.kxj.cNH().cLk()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.kxj.cMC();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.bYx();
                        VideoPbFragment.this.cMj();
                        if (view.getId() == R.id.owner_reply) {
                            y = VideoPbFragment.this.cIf().y(true, VideoPbFragment.this.cJs());
                        } else {
                            y = view.getId() == R.id.all_reply ? VideoPbFragment.this.cIf().y(false, VideoPbFragment.this.cJs()) : VideoPbFragment.this.cIf().JT(VideoPbFragment.this.cJs());
                        }
                        view.setTag(Boolean.valueOf(y));
                        if (y) {
                            VideoPbFragment.this.crH();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.eDr) {
                    if (VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null) {
                        if (!ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            ao aoVar2 = new ao("c13266");
                            aoVar2.dk("uid", TbadkCoreApplication.getCurrentAccount());
                            aoVar2.dk("fid", VideoPbFragment.this.cIf().getPbData().getForumId());
                            aoVar2.dk("tid", VideoPbFragment.this.cIf().cKa());
                            aoVar2.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(aoVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.keN, VideoPbFragment.this.eDr);
                        VideoPbFragment.this.keN.finish();
                    }
                } else if (view == VideoPbFragment.this.ksu && VideoPbFragment.this.kxj != null) {
                    if (VideoPbFragment.this.cIf() == null || VideoPbFragment.this.cIf().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> cGQ = VideoPbFragment.this.cIf().getPbData().cGQ();
                    if ((cGQ == null || cGQ.size() <= 0) && VideoPbFragment.this.cIf().cKc()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new ao("c12378").dk("tid", VideoPbFragment.this.cIf().cKa()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("fid", VideoPbFragment.this.cIf().getForumId()));
                    VideoPbFragment.this.kxj.cJg();
                } else if (VideoPbFragment.this.kxj.cNH() != null && view == VideoPbFragment.this.kxj.cNH().cLo()) {
                    if (VideoPbFragment.this.cIf() != null) {
                        VideoPbFragment.this.kxj.cMC();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.bYx();
                            VideoPbFragment.this.cMj();
                            VideoPbFragment.this.cIf().Bp(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.kxj != null && VideoPbFragment.this.kxj.cNH() != null && view == VideoPbFragment.this.kxj.cNH().cLk()) {
                    VideoPbFragment.this.kxj.aFg();
                } else if (VideoPbFragment.this.kxj != null && ((VideoPbFragment.this.kxj.cNH() != null && view == VideoPbFragment.this.kxj.cNH().cLr()) || view.getId() == R.id.pb_sort_type)) {
                    VideoPbFragment.this.kxj.cMC();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.bYx();
                            VideoPbFragment.this.cMj();
                            VideoPbFragment.this.kxj.cQ(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.cIf().cKt()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.kxj != null && VideoPbFragment.this.kxj.cNH() != null && view == VideoPbFragment.this.kxj.cNH().cLi()) {
                    if (VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null && VideoPbFragment.this.cIf().getPbData().cGO() != null) {
                        VideoPbFragment.this.kxj.aFg();
                        TiebaStatic.log(new ao("c13062"));
                        VideoPbFragment.this.kxj.JO(VideoPbFragment.this.cIf().getPbData().cGO().aSG());
                    }
                } else if (VideoPbFragment.this.kxj != null && VideoPbFragment.this.kxj.cNH() != null && view == VideoPbFragment.this.kxj.cNH().cLs()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        an.y(true, false);
                        TiebaStatic.log(new ao(TbadkCoreStatisticKey.SET_NIGHT_MODE).ag("obj_type", 0).ag("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new ao(TbadkCoreStatisticKey.SET_NIGHT_MODE).ag("obj_type", 1).ag("obj_source", 1));
                    }
                    VideoPbFragment.this.kxj.cNG();
                } else if (VideoPbFragment.this.kxj != null && (view == VideoPbFragment.this.kxj.cMh() || (VideoPbFragment.this.kxj.cNH() != null && (view == VideoPbFragment.this.kxj.cNH().cLn() || view == VideoPbFragment.this.kxj.cNH().cLl())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.cIf() != null || VideoPbFragment.this.cIf().getPbData() != null) {
                        if ((VideoPbFragment.this.cIf().getPbData().cHd() == 1 || VideoPbFragment.this.cIf().getPbData().cHd() == 3) && !VideoPbFragment.this.gRX.diM()) {
                            VideoPbFragment.this.kxj.cMC();
                            if (VideoPbFragment.this.kxj.cNH() != null && view == VideoPbFragment.this.kxj.cNH().cLl()) {
                                if (VideoPbFragment.this.cIf().getPbData().cGO().aSk() == 1) {
                                    i = 5;
                                } else {
                                    i = 4;
                                }
                            } else if (VideoPbFragment.this.kxj.cNH() != null && view == VideoPbFragment.this.kxj.cNH().cLn()) {
                                i = VideoPbFragment.this.cIf().getPbData().cGO().aSl() == 1 ? 3 : 6;
                            } else {
                                i = view == VideoPbFragment.this.kxj.cMh() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.cIf().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.cIf().getPbData().cGO().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.gRX.b(id, name, id2, i, VideoPbFragment.this.kxj.cMi());
                        }
                    }
                } else if (VideoPbFragment.this.kxj != null && VideoPbFragment.this.kxj.cNH() != null && view == VideoPbFragment.this.kxj.cNH().cLq()) {
                    if (VideoPbFragment.this.cIf() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.kxj.cMC();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.cIf().getPbData(), VideoPbFragment.this.cIf().cKc(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.cIf().getPbData().getForum().getId(), VideoPbFragment.this.cIf().getPbData().getForum().getName(), VideoPbFragment.this.cIf().getPbData().cGO().getId(), String.valueOf(VideoPbFragment.this.cIf().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.kxj != null && VideoPbFragment.this.kxj.cNH() != null && view == VideoPbFragment.this.kxj.cNH().cLm()) {
                    if (VideoPbFragment.this.cIf() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.cIf().getPbData(), VideoPbFragment.this.cIf().cKc(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.kxj.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.kxj.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.kxj.aFg();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        ao aoVar3 = new ao("c13398");
                        aoVar3.dk("tid", VideoPbFragment.this.cIf().cKa());
                        aoVar3.dk("fid", VideoPbFragment.this.cIf().getForumId());
                        aoVar3.dk("uid", TbadkCoreApplication.getCurrentAccount());
                        aoVar3.ag("obj_locate", 4);
                        TiebaStatic.log(aoVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new ao("c10517").ag("obj_locate", 3).dk("fid", VideoPbFragment.this.cIf().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null) {
                        if (VideoPbFragment.this.kxj != null) {
                            VideoPbFragment.this.kxj.cMC();
                        }
                        PostData postData2 = (PostData) ((SparseArray) view.getTag()).get(R.id.tag_load_sub_data);
                        if (postData2 != null) {
                            if (postData2.dil() == 1) {
                                TiebaStatic.log(new ao("c12630"));
                            }
                            if (postData2.lGI != null) {
                                ao aWM = postData2.lGI.aWM();
                                aWM.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    aWM.ag("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    aWM.ag("obj_locate", 8);
                                }
                                TiebaStatic.log(aWM);
                            }
                            String cKa = VideoPbFragment.this.cIf().cKa();
                            String id3 = postData2.getId();
                            int cHd = VideoPbFragment.this.cIf().getPbData() != null ? VideoPbFragment.this.cIf().getPbData().cHd() : 0;
                            VideoPbFragment.this.bYx();
                            TiebaStatic.log("c11742");
                            if (VideoPbFragment.this.cPy() != null && VideoPbFragment.this.cPy().cQl() != null) {
                                PbActivity.a JR = VideoPbFragment.this.cPy().cQl().JR(id3);
                                if (postData2 != null && VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null && JR != null) {
                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cKa, id3, "pb", true, null, false, null, cHd, postData2.cOF(), VideoPbFragment.this.cIf().getPbData().getAnti(), false, postData2.aSp().getIconInfo()).addBigImageData(JR.kbN, JR.kbO, JR.kbP, JR.index);
                                    addBigImageData.setKeyFromForumId(VideoPbFragment.this.cIf().getForumId());
                                    addBigImageData.setBjhData(VideoPbFragment.this.cIf().cKj());
                                    addBigImageData.setKeyPageStartFrom(VideoPbFragment.this.cIf().cKK());
                                    addBigImageData.setFromFrsForumId(VideoPbFragment.this.cIf().getFromForumId());
                                    VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img) {
                    if (VideoPbFragment.this.cIf() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            ao aoVar4 = new ao("c13398");
                            aoVar4.dk("tid", VideoPbFragment.this.cIf().cKa());
                            aoVar4.dk("fid", VideoPbFragment.this.cIf().getForumId());
                            aoVar4.dk("uid", TbadkCoreApplication.getCurrentAccount());
                            aoVar4.ag("obj_locate", 6);
                            TiebaStatic.log(aoVar4);
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData3 = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData3.lGI != null) {
                                    ao aWM2 = postData3.lGI.aWM();
                                    aWM2.delete("obj_locate");
                                    aWM2.ag("obj_locate", 8);
                                    TiebaStatic.log(aWM2);
                                } else if (view.getId() == R.id.post_info_commont_img) {
                                    TiebaStatic.log(new ao("c13700").dk("tid", VideoPbFragment.this.cIf().cKb()).dk("fid", VideoPbFragment.this.cIf().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dk("post_id", postData3.getId()).ag("obj_type", 3));
                                }
                                if (VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null && VideoPbFragment.this.keK != null && postData3.aSp() != null && postData3.dhZ() != 1) {
                                    if (VideoPbFragment.this.knu != null) {
                                        VideoPbFragment.this.knu.cIL();
                                    }
                                    n nVar2 = new n();
                                    nVar2.a(VideoPbFragment.this.cIf().getPbData().getForum());
                                    nVar2.setThreadData(VideoPbFragment.this.cIf().getPbData().cGO());
                                    nVar2.g(postData3);
                                    VideoPbFragment.this.keK.d(nVar2);
                                    VideoPbFragment.this.keK.setPostId(postData3.getId());
                                    VideoPbFragment.this.b(view, postData3.aSp().getUserId(), "");
                                    if (VideoPbFragment.this.kfD != null) {
                                        VideoPbFragment.this.sm(VideoPbFragment.this.kfD.bfI());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.kxj != null && VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cPy() != null) {
                        VideoPbFragment.this.kxj.cMC();
                        if (VideoPbFragment.this.Bk(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.cIf() != null) {
                            VideoPbFragment.this.cJn();
                            if (VideoPbFragment.this.cIf().getPbData() != null && VideoPbFragment.this.cIf().getPbData().cGO() != null && VideoPbFragment.this.cIf().getPbData().cGO().aSp() != null) {
                                TiebaStatic.log(new ao("c13402").dk("tid", VideoPbFragment.this.cIf().cKa()).dk("fid", VideoPbFragment.this.cIf().getPbData().getForumId()).ag("obj_locate", 3).dk("uid", VideoPbFragment.this.cIf().getPbData().cGO().aSp().getUserId()));
                            }
                            if (VideoPbFragment.this.cIf().getPbData().cGO() != null && VideoPbFragment.this.cIf().getPbData().cGO().aSp() != null && VideoPbFragment.this.cIf().getPbData().cGO().aSp().getUserId() != null && VideoPbFragment.this.kfo != null) {
                                int h = VideoPbFragment.this.kxj.h(VideoPbFragment.this.cIf().getPbData());
                                bu cGO = VideoPbFragment.this.cIf().getPbData().cGO();
                                if (cGO.aQX()) {
                                    i2 = 2;
                                } else if (!cGO.aQY()) {
                                    if (cGO.aUl()) {
                                        i2 = 4;
                                    } else {
                                        i2 = cGO.aUm() ? 5 : 1;
                                    }
                                }
                                TiebaStatic.log(new ao("c12526").dk("tid", VideoPbFragment.this.cIf().cKa()).ag("obj_locate", 1).dk("obj_id", VideoPbFragment.this.cIf().getPbData().cGO().aSp().getUserId()).ag("obj_type", VideoPbFragment.this.kfo.aOo() ? 0 : 1).ag("obj_source", h).ag("obj_param1", i2));
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.sM(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.cIf() != null && VideoPbFragment.this.kxj != null && VideoPbFragment.this.dSy != null && VideoPbFragment.this.cIf().getPbData() != null && VideoPbFragment.this.cIf().getPbData().cGO() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.cIf().getPbData();
                        if (pbData.cGO().aSg() != 0) {
                            int currentItem = VideoPbFragment.this.dSy.getCurrentItem();
                            if (currentItem == VideoPbFragment.kwO) {
                                VideoPbFragment.this.dSy.setCurrentItem(VideoPbFragment.kwP);
                            } else if (currentItem == VideoPbFragment.kwP) {
                                if (VideoPbFragment.this.cPy() != null && VideoPbFragment.this.cbi() != null) {
                                    ao dk = new ao("c13403").dk("tid", VideoPbFragment.this.cIf().cKa()).dk("fid", VideoPbFragment.this.cIf().getPbData().getForumId()).dk("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView cbi = VideoPbFragment.this.cbi();
                                    boolean canScrollVertically = cbi.canScrollVertically(1);
                                    boolean canScrollVertically2 = cbi.canScrollVertically(-1);
                                    if (VideoPbFragment.this.WW != null) {
                                        VideoPbFragment.this.WW.setExpanded(false, true);
                                    }
                                    if (cbi.getLayoutManager() != null && (cbi.getLayoutManager() instanceof LinearLayoutManager)) {
                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) cbi.getLayoutManager();
                                        if (!canScrollVertically2 && canScrollVertically) {
                                            if (VideoPbFragment.this.kfi != -1 || VideoPbFragment.this.kfj != Integer.MIN_VALUE) {
                                                if (VideoPbFragment.this.kfi > 3 || (VideoPbFragment.this.kfi == 3 && VideoPbFragment.this.kfj < (-equipmentHeight))) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.kfi, VideoPbFragment.this.kfj + equipmentHeight);
                                                    cbi.smoothScrollBy(0, equipmentHeight);
                                                } else if (VideoPbFragment.this.kfi >= 2) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.kfi, VideoPbFragment.this.kfj + (equipmentHeight / 2));
                                                    cbi.smoothScrollBy(0, equipmentHeight / 2);
                                                } else if (VideoPbFragment.this.kfi == 1) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.kfi, VideoPbFragment.this.kfj + (equipmentHeight / 4));
                                                    cbi.smoothScrollBy(0, equipmentHeight / 4);
                                                } else {
                                                    cbi.smoothScrollBy(0, -VideoPbFragment.this.kfj);
                                                }
                                                dk.ag("obj_locate", 2);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            int firstVisiblePosition = cbi.getFirstVisiblePosition();
                                            View childAt = cbi.getChildAt(0);
                                            int top2 = childAt == null ? 0 : childAt.getTop();
                                            VideoPbFragment.this.kfi = firstVisiblePosition;
                                            VideoPbFragment.this.kfj = top2;
                                            if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top2 < (-equipmentHeight) && cbi.getCount() >= 6)) {
                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                cbi.smoothScrollToPosition(0);
                                            } else {
                                                cbi.smoothScrollToPosition(0);
                                            }
                                            dk.ag("obj_locate", 1);
                                        }
                                        TiebaStatic.log(dk);
                                        TiebaStatic.log(new ao("c12942").ag("obj_type", 1).ag("obj_locate", 4).dk("tid", VideoPbFragment.this.cIf().cKa()).dk("nid", pbData.cGO().getNid()));
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null && VideoPbFragment.this.cIf().getPbData().cGO() != null && VideoPbFragment.this.cIf().getPbData().cGO().aSp() != null) {
                                TiebaStatic.log(new ao("c13402").dk("tid", VideoPbFragment.this.cIf().cKa()).dk("fid", VideoPbFragment.this.cIf().getPbData().getForumId()).ag("obj_locate", 2).dk("uid", VideoPbFragment.this.cIf().getPbData().cGO().aSp().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.sN(false);
                        VideoPbFragment.this.cJb();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.kfQ >= 0) {
                        if (VideoPbFragment.this.cIf() != null) {
                            VideoPbFragment.this.cIf().cKL();
                        }
                        if (VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cPy() != null && VideoPbFragment.this.cPy().cQk() != null) {
                            VideoPbFragment.this.cPy().cQk().setData(VideoPbFragment.this.cIf().getPbData());
                        }
                        VideoPbFragment.this.kfQ = 0;
                        VideoPbFragment.this.kxl = Integer.MIN_VALUE;
                        if (VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cPy() != null) {
                            VideoPbFragment.this.cPy().cM(VideoPbFragment.this.cIf().cKO(), VideoPbFragment.this.cIf().cKP());
                            VideoPbFragment.this.cIf().cJ(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.cIf() != null) {
                        ao aoVar5 = new ao("c13398");
                        aoVar5.dk("tid", VideoPbFragment.this.cIf().cKa());
                        aoVar5.dk("fid", VideoPbFragment.this.cIf().getForumId());
                        aoVar5.dk("uid", TbadkCoreApplication.getCurrentAccount());
                        aoVar5.ag("obj_locate", 2);
                        TiebaStatic.log(aoVar5);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (be.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.aVP().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.cLO();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.cLO();
                } else if (VideoPbFragment.this.kxj.cNH() != null && view == VideoPbFragment.this.kxj.cNH().cLp()) {
                    VideoPbFragment.this.kxj.cMC();
                    if (VideoPbFragment.this.cIf() != null) {
                        VideoPbFragment.this.gRZ.setThreadId(VideoPbFragment.this.cIf().cKa());
                    }
                    if (VideoPbFragment.this.cIf() == null || !VideoPbFragment.this.cIf().isPrivacy()) {
                        VideoPbFragment.this.gRZ.bNW();
                    } else {
                        VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                    }
                }
            }
        }
    };
    private View.OnClickListener kcu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.kxj != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.kxj.c(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.kxj.cJ(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.kxj.c(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.kxj.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    public SortSwitchButton.a kgn = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean va(int i) {
            if (VideoPbFragment.this.kxj != null) {
                VideoPbFragment.this.kxj.cMC();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.cIf() == null || VideoPbFragment.this.cIf().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.bYx();
                VideoPbFragment.this.cMj();
                if (VideoPbFragment.this.cIf().getPbData() != null && VideoPbFragment.this.cIf().getPbData().jYL != null && VideoPbFragment.this.cIf().getPbData().jYL.size() > i) {
                    int intValue = VideoPbFragment.this.cIf().getPbData().jYL.get(i).sort_type.intValue();
                    TiebaStatic.log(new ao("c13699").dk("tid", VideoPbFragment.this.cIf().cKb()).dk("fid", VideoPbFragment.this.cIf().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", Bn(intValue)));
                    if (VideoPbFragment.this.cIf().Bu(intValue)) {
                        VideoPbFragment.this.mIsLoading = true;
                    }
                }
                return true;
            }
        }

        private int Bn(int i) {
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
    private a kxk = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void cJl() {
        if (cIf() != null && cIf().getPbData() != null && cIf().getPbData().cGO() != null) {
            bu cGO = cIf().getPbData().cGO();
            cGO.mRecomAbTag = cIf().cKV();
            cGO.mRecomWeight = cIf().cKT();
            cGO.mRecomSource = cIf().cKU();
            cGO.mRecomExtra = cIf().cKW();
            if (cGO.getFid() == 0) {
                cGO.setFid(com.baidu.adp.lib.f.b.toLong(cIf().getForumId(), 0L));
            }
            ao a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cGO, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rG(boolean z) {
        if (cIf() != null && cIf().getPbData() != null && cIf().getPbData().cGO() != null) {
            bu cGO = cIf().getPbData().cGO();
            cGO.mRecomAbTag = cIf().cKV();
            cGO.mRecomWeight = cIf().cKT();
            cGO.mRecomSource = cIf().cKU();
            cGO.mRecomExtra = cIf().cKW();
            if (cGO.getFid() == 0) {
                cGO.setFid(com.baidu.adp.lib.f.b.toLong(cIf().getForumId(), 0L));
            }
            ao a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cGO, "c13563");
            if (a2 != null) {
                a2.ag("reply_type", 1);
                if (z) {
                    a2.ag("obj_type", 2);
                } else {
                    a2.ag("obj_type", 1);
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
            if (ar.isEmpty(str)) {
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
            String string = !TextUtils.isEmpty(bVar.lIA) ? bVar.lIA : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.we(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.hf(true);
                aVar.b(getPageContext());
                aVar.aUN();
            } else {
                a(0, bVar.Pv, bVar.lIA, z);
            }
            if (bVar.Pv) {
                if (bVar.hhf == 1) {
                    ArrayList<PostData> cGQ = cIf().getPbData().cGQ();
                    int size = cGQ.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cGQ.get(i).getId())) {
                            i++;
                        } else {
                            cGQ.remove(i);
                            break;
                        }
                    }
                    cIf().getPbData().cGO().kG(cIf().getPbData().cGO().aSg() - 1);
                    if (cPy() != null) {
                        cPy().cQj();
                    }
                } else if (bVar.hhf == 0) {
                    cJm();
                } else if (bVar.hhf == 2) {
                    ArrayList<PostData> cGQ2 = cIf().getPbData().cGQ();
                    int size2 = cGQ2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cGQ2.get(i2).dhW().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cGQ2.get(i2).dhW().get(i3).getId())) {
                                i3++;
                            } else {
                                cGQ2.get(i2).dhW().remove(i3);
                                cGQ2.get(i2).dhY();
                                z2 = true;
                                break;
                            }
                        }
                        cGQ2.get(i2).Nf(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3 && cPy() != null) {
                        cPy().cQj();
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = cIf().getPbData().cHc().kao;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dhW().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dhW().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dhW().remove(i2);
                    list.get(i).dhY();
                    z = true;
                    break;
                }
            }
            list.get(i).Nf(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2 && cPy() != null) {
            cPy().cQj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && cIf() != null && cIf().getPbData() != null && cIf().getPbData().cGO() != null) {
            a(this.gRX.getLoadDataMode(), gVar.Pv, gVar.lIA, false);
            if (gVar.Pv) {
                this.kfr = true;
                if (i == 2 || i == 3) {
                    this.kfs = true;
                    this.kft = false;
                } else if (i == 4 || i == 5) {
                    this.kfs = false;
                    this.kft = true;
                }
                if (i == 2) {
                    cIf().getPbData().cGO().kJ(1);
                    cIf().setIsGood(1);
                } else if (i == 3) {
                    cIf().getPbData().cGO().kJ(0);
                    cIf().setIsGood(0);
                } else if (i == 4) {
                    cIf().getPbData().cGO().kI(1);
                    cIf().Bo(1);
                } else if (i == 5) {
                    cIf().getPbData().cGO().kI(0);
                    cIf().Bo(0);
                }
            }
            if (cIf().getPbData().cGO() != null && cPz() != null) {
                cPz().cQg();
            }
        }
    }

    private void cJm() {
        if (cIf().cKd() || cIf().cKf()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", cIf().cKa());
            PbActivity pbActivity = this.keN;
            PbActivity pbActivity2 = this.keN;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, cIf().cKa()));
        if (cJp()) {
            this.keN.finish();
        }
    }

    private boolean cJp() {
        if (cIf() == null) {
            return true;
        }
        if (cIf().getPbData() == null || !cIf().getPbData().cHq()) {
            if (cIf().aOo()) {
                final MarkData cKu = cIf().cKu();
                if (cKu == null || !cIf().getIsFromMark() || cbi() == null) {
                    return true;
                }
                final MarkData Bv = cIf().Bv(cbi().getFirstVisiblePosition());
                if (Bv == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cKu);
                    this.keN.setResult(-1, intent);
                    return true;
                } else if (Bv.getPostId() == null || Bv.getPostId().equals(cKu.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cKu);
                    this.keN.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.we(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.kfo != null) {
                                if (VideoPbFragment.this.kfo.aOo()) {
                                    VideoPbFragment.this.kfo.aOp();
                                    VideoPbFragment.this.kfo.gJ(false);
                                }
                                VideoPbFragment.this.kfo.a(Bv);
                                VideoPbFragment.this.kfo.gJ(true);
                                VideoPbFragment.this.kfo.aOq();
                            }
                            cKu.setPostId(Bv.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cKu);
                            VideoPbFragment.this.keN.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cIs();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cKu);
                            VideoPbFragment.this.keN.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cIs();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.aUN();
                    return false;
                }
            } else if (cIf().getPbData() == null || cIf().getPbData().cGQ() == null || cIf().getPbData().cGQ().size() <= 0 || !cIf().getIsFromMark()) {
                return true;
            } else {
                this.keN.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIs() {
        this.keN.cIs();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void sM(boolean z) {
        com.baidu.tieba.pb.data.e pbData;
        int i;
        if (cIf() != null && this.kxj != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = cIf().getPbData()) != null) {
                bu cGO = pbData.cGO();
                if (cGO != null && cGO.aSp() != null) {
                    TiebaStatic.log(new ao("c13402").dk("tid", cIf().cKa()).dk("fid", pbData.getForumId()).ag("obj_locate", 4).dk("uid", cGO.aSp().getUserId()));
                }
                if (cGO != null) {
                    if (cGO.aQX()) {
                        i = 2;
                    } else if (cGO.aQY()) {
                        i = 3;
                    } else if (cGO.aUl()) {
                        i = 4;
                    } else if (cGO.aUm()) {
                        i = 5;
                    }
                    ao aoVar = new ao(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    aoVar.dk("tid", cIf().cKa());
                    aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                    aoVar.dk("fid", cIf().getForumId());
                    if (!z) {
                        aoVar.ag("obj_locate", 6);
                    } else {
                        aoVar.ag("obj_locate", 5);
                    }
                    aoVar.ag("obj_name", i);
                    aoVar.ag("obj_type", 2);
                    if (cGO != null) {
                        if (cGO.aQX()) {
                            aoVar.ag("obj_type", 10);
                        } else if (cGO.aQY()) {
                            aoVar.ag("obj_type", 9);
                        } else if (cGO.aUm()) {
                            aoVar.ag("obj_type", 8);
                        } else if (cGO.aUl()) {
                            aoVar.ag("obj_type", 7);
                        } else if (cGO.isShareThread) {
                            aoVar.ag("obj_type", 6);
                        } else if (cGO.threadType == 0) {
                            aoVar.ag("obj_type", 1);
                        } else if (cGO.threadType == 40) {
                            aoVar.ag("obj_type", 2);
                        } else if (cGO.threadType == 49) {
                            aoVar.ag("obj_type", 3);
                        } else if (cGO.threadType == 54) {
                            aoVar.ag("obj_type", 4);
                        } else {
                            aoVar.ag("obj_type", 5);
                        }
                        aoVar.dk("nid", cGO.getNid());
                        aoVar.ag(IntentConfig.CARD_TYPE, cGO.aUp());
                        aoVar.dk(IntentConfig.RECOM_SOURCE, cGO.mRecomSource);
                        aoVar.dk("ab_tag", cGO.mRecomAbTag);
                        aoVar.dk("weight", cGO.mRecomWeight);
                        aoVar.dk("extra", cGO.mRecomExtra);
                        aoVar.dk("nid", cGO.getNid());
                        if (cGO.getBaijiahaoData() != null && !ar.isEmpty(cGO.getBaijiahaoData().oriUgcVid)) {
                            aoVar.dk("obj_param6", cGO.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        aoVar.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (cJJ() != null) {
                        com.baidu.tbadk.pageInfo.c.b(cJJ(), aoVar);
                    }
                    TiebaStatic.log(aoVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (cIf().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> cGQ = pbData.cGQ();
                        if ((cGQ == null || cGQ.size() <= 0) && cIf().cKc()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.kxj.cMC();
                        bYx();
                        TiebaStatic.log(new ao("c11939"));
                        if (!AntiHelper.d(getContext(), cGO)) {
                            if (this.kmS != null) {
                                this.kmS.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                Bl(z ? 2 : 1);
                                return;
                            }
                            this.kxj.showLoadingDialog();
                            cIf().cKF().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                ao aoVar2 = new ao(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aoVar2.dk("tid", cIf().cKa());
                aoVar2.dk("uid", TbadkCoreApplication.getCurrentAccount());
                aoVar2.dk("fid", cIf().getForumId());
                if (!z) {
                }
                aoVar2.ag("obj_name", i);
                aoVar2.ag("obj_type", 2);
                if (cGO != null) {
                }
                if (!ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (cJJ() != null) {
                }
                TiebaStatic.log(aoVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment cPf() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        J(eVar.cPK());
        K(eVar.cPK());
        if (cIf() != null && cIf().getPbData() != null) {
            boolean isFromMark = cIf().getIsFromMark();
            com.baidu.tieba.pb.data.e pbData = cIf().getPbData();
            if (isFromMark) {
                PostData I = I(pbData);
                if (pbData.aOn() != null && !pbData.aOn().equals(I.getId()) && this.dSy != null) {
                    this.dSy.setCurrentItem(kwP);
                }
            }
        }
        eVar.cPL().observe(this, new q<bu>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aP */
            public void onChanged(@Nullable bu buVar) {
                if (buVar != null && buVar.aSH() != null) {
                    if (VideoPbFragment.this.kwW.getVideoUrl() == null || !VideoPbFragment.this.kwW.getVideoUrl().equals(buVar.aSH().video_url)) {
                        if (!ar.isEmpty(VideoPbFragment.this.kwW.getVideoUrl())) {
                            VideoPbFragment.this.kfa = true;
                            VideoPbFragment.this.dSy.setCurrentItem(VideoPbFragment.kwO);
                        }
                        if (VideoPbFragment.this.kwX == null || !VideoPbFragment.this.kwX.isPlaying()) {
                            VideoPbFragment.this.cPg();
                            VideoPbFragment.this.aO(buVar);
                        }
                        VideoPbFragment.this.cPh();
                        if (VideoPbFragment.this.kwX.cPY()) {
                            VideoPbFragment.this.kwX.start();
                        }
                        boolean z = !ar.equals(VideoPbFragment.this.kwW.getVideoUrl(), buVar.aSH().video_url);
                        VideoPbFragment.this.kwW.setData(buVar);
                        VideoPbFragment.this.kwW.sV(VideoPbFragment.this.dSy.getCurrentItem() == 0);
                        if (z) {
                            VideoPbFragment.this.kwW.startPlay();
                            VideoPbFragment.this.kwW.cQD();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.kwW.setData(buVar);
                }
            }
        });
        eVar.cPU().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: q */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.dSy.setCurrentItem(num.intValue());
            }
        });
        eVar.cPP().observe(this, new q<bu>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aP */
            public void onChanged(@Nullable bu buVar) {
                VideoPbFragment.this.kwW.aT(buVar);
            }
        });
        eVar.cPQ().observe(this, new q<bu>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aP */
            public void onChanged(@Nullable bu buVar) {
                VideoPbFragment.this.kwW.aU(buVar);
            }
        });
        eVar.cPR().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.cPr();
            }
        });
        eVar.cPS().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPg() {
        ViewGroup.LayoutParams layoutParams = this.kwZ.getLayoutParams();
        layoutParams.height = 0;
        this.kwZ.setLayoutParams(layoutParams);
        this.kwZ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPh() {
        if (this.kwX == null) {
            this.kwX = new f(getBaseFragmentActivity(), this.kwV);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(cJJ()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.kwV.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.kwX.b(eVar.cPM(), rect);
            if (this.kwX.cPY()) {
                this.kwX.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (eVar.cPN() || VideoPbFragment.this.cIf().getTabIndex() == VideoPbFragment.kwP) {
                            VideoPbFragment.this.dSy.setCurrentItem(VideoPbFragment.kwP);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (eVar.cPN() || VideoPbFragment.this.cIf().getTabIndex() == VideoPbFragment.kwP) {
                            VideoPbFragment.this.dSy.setCurrentItem(VideoPbFragment.kwP);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (eVar.cPN() || cIf().getTabIndex() == kwP) {
                this.dSy.setCurrentItem(kwP);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.kxp && (this.kxq || cPE())) {
            cPD();
            UtilHelper.hideStatusBar(cJJ(), cJJ().getRootView());
            this.kxq = false;
            if (this.kwW != null) {
                this.kwW.sO(false);
            }
        }
        if (i == 4) {
            return this.kwW.cWh();
        }
        if (i == 24) {
            return this.kwW.cQA();
        }
        if (i == 25) {
            return this.kwW.cQB();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aO(bu buVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        CoordinatorLayout.LayoutParams layoutParams3;
        Rect cKX;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (buVar != null && buVar.aSH() != null) {
            int intValue = buVar.aSH().video_width.intValue();
            int intValue2 = buVar.aSH().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (cIf() != null || (cKX = cIf().cKX()) == null) ? ceil : cKX.height();
                i = 0;
                layoutParams = this.kwV.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.kwV.setLayoutParams(layoutParams);
                this.kwV.setMaxHeight(ceil);
                this.kwV.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.kwV.setOriginHeight(height);
                layoutParams2 = (RelativeLayout.LayoutParams) this.kwR.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, kwQ);
                } else {
                    layoutParams2.height = kwQ;
                }
                this.kwR.setLayoutParams(layoutParams2);
                layoutParams3 = (CoordinatorLayout.LayoutParams) this.WW.getLayoutParams();
                int i2 = ceil + kwQ;
                if (layoutParams3 != null) {
                    layoutParams3 = new CoordinatorLayout.LayoutParams(-1, i2);
                } else {
                    layoutParams3.height = i2;
                }
                this.WW.setLayoutParams(layoutParams3);
                if (i == 0 && (this.WW.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.WW.getLayoutParams()).getBehavior();
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
        if (cIf() != null) {
        }
        i = 0;
        layoutParams = this.kwV.getLayoutParams();
        if (layoutParams != null) {
        }
        this.kwV.setLayoutParams(layoutParams);
        this.kwV.setMaxHeight(ceil2);
        this.kwV.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.kwV.setOriginHeight(height);
        layoutParams2 = (RelativeLayout.LayoutParams) this.kwR.getLayoutParams();
        if (layoutParams2 != null) {
        }
        this.kwR.setLayoutParams(layoutParams2);
        layoutParams3 = (CoordinatorLayout.LayoutParams) this.WW.getLayoutParams();
        int i22 = ceil2 + kwQ;
        if (layoutParams3 != null) {
        }
        this.WW.setLayoutParams(layoutParams3);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.keU = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        ar(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.kfK = new com.baidu.tbadk.core.view.c();
        this.kfK.toastTime = 1000L;
        if (this.kxj != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.kxj.kfL;
            userMuteAddAndDelCustomMessage.setTag(this.kxj.kfL);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.kxj.kfL;
            userMuteCheckCustomMessage.setTag(this.kxj.kfL);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.gRZ = new com.baidu.tieba.callfans.a(getPageContext());
        com.baidu.tieba.s.c.dgY().z(getUniqueId());
    }

    private void initData() {
        this.kfo = com.baidu.tbadk.baseEditMark.a.a(this.keN);
        if (this.kfo != null) {
            this.kfo.a(this.kgs);
        }
        this.gRX = new ForumManageModel(this.keN);
        this.gRX.setLoadDataCallBack(this.gSe);
        this.dUB = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.kxj = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void ar(Bundle bundle) {
        this.kfC = new g();
        d(this.kfC);
        this.kfD = (com.baidu.tbadk.editortools.pb.e) this.kfC.dO(getActivity());
        this.kfD.a(this.keN.getPageContext());
        this.kfD.a(this.evL);
        this.kfD.a(this.evE);
        this.kfD.a(this.keN.getPageContext(), bundle);
        this.kfD.bfa().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.kfD.bfa().m32if(true);
        rF(true);
        this.kfD.a(cIf().cKq(), cIf().cKa(), cIf().cKH());
        registerListener(this.kga);
        registerListener(this.kgr);
        registerListener(this.kfZ);
        registerListener(this.kfX);
        registerListener(this.hBf);
        if (!cIf().cKh()) {
            this.kfD.yC(cIf().cKa());
        }
        if (cIf().cKI()) {
            this.kfD.yA(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.kfD.yA(cLQ());
        }
        this.kfu = new ax();
        if (this.kfD.bfA() != null) {
            this.kfu.e(this.kfD.bfA().getInputView());
        }
        this.kfD.a(this.evF);
        this.jhL = new ak(getPageContext());
        this.jhL.a(new ak.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
            @Override // com.baidu.tbadk.core.util.ak.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == ak.dUw) {
                        VideoPbFragment.this.kfD.a((String) null, (WriteData) null);
                    } else if (i == ak.dUx && VideoPbFragment.this.knu != null && VideoPbFragment.this.knu.cIP() != null) {
                        VideoPbFragment.this.knu.cIP().bfX();
                    } else if (i == ak.dUy) {
                        VideoPbFragment.this.c(VideoPbFragment.this.kfG);
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
        this.hEm = new com.baidu.tieba.f.b(getActivity());
        this.hEm.a(kgB);
        this.kxp = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        biq();
        this.WW = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.kwT = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.kwV = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.kwW = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.kwV);
        this.kwW.setUniqueId(getUniqueId());
        this.kwW.ad(this);
        this.kwW.cR(cJJ().getRootView());
        this.kwW.cS(this.kwY);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.kwR = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.kwZ = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.dSy = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.kwU = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.kwU.setOnClickListener(this.aXG);
        cPj();
        cPi();
        cPk();
        this.kwS = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.dSy.setAdapter(this.kwS);
        this.kwR.setViewPager(this.dSy);
        this.kwR.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (VideoPbFragment.this.cPy() != null) {
                        VideoPbFragment.this.cPy().sU(false);
                    }
                    if (VideoPbFragment.this.cPz() != null) {
                        VideoPbFragment.this.cPz().sU(true);
                        VideoPbFragment.this.BT(VideoPbFragment.this.cPz().cQi() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.cPR() != null && eVar.cPR().getValue() != null && eVar.cPR().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.kwW.sV(z);
                    VideoPbFragment.this.cLO();
                    if (VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null) {
                        TiebaStatic.log(new ao("c13592").dk("tid", VideoPbFragment.this.cIf().cKa()).dk("fid", VideoPbFragment.this.cIf().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.cPz() != null) {
                        VideoPbFragment.this.cPz().sU(false);
                    }
                    if (VideoPbFragment.this.cPy() != null) {
                        VideoPbFragment.this.cPy().sU(true);
                        int cQi = VideoPbFragment.this.cPy().cQi();
                        int cQn = VideoPbFragment.this.cPy().cQn();
                        if (cQi != 0) {
                            VideoPbFragment.this.BT(8);
                            VideoPbFragment.this.cPy().BT(0);
                        } else if (cQn != 0) {
                            VideoPbFragment.this.cPy().BT(8);
                            VideoPbFragment.this.BT(0);
                        } else {
                            VideoPbFragment.this.cPy().BT(8);
                            VideoPbFragment.this.BT(8);
                        }
                    }
                    VideoPbFragment.this.kwW.sV(false);
                    VideoPbFragment.this.WW.setExpanded(false, true);
                    if (VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null) {
                        TiebaStatic.log(new ao("c13593").dk("tid", VideoPbFragment.this.cIf().cKa()).dk("fid", VideoPbFragment.this.cIf().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.kwS.BV(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.kmu = this.rootView.findViewById(R.id.viewstub_progress);
        cPl();
        byk();
        if (!this.kxp && this.kxq) {
            cPD();
            UtilHelper.hideStatusBar(cJJ(), cJJ().getRootView());
            this.kxq = false;
        }
    }

    private void cPi() {
        this.kxb = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.kxf = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.kxc = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.kxd = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.kxe = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.kxg = this.rootView.findViewById(R.id.ala_live_point);
        this.kxf.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.kxf.setConrers(15);
        this.kxe.setConfig(new com.baidu.tbadk.core.view.commonBtn.d());
        this.kxd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.jZw == null || VideoPbFragment.this.jZw.cQr()) {
                    if (VideoPbFragment.this.jZw != null) {
                        TiebaStatic.log(new ao("c13608").dk("tid", VideoPbFragment.this.cIf().getPbData().getThreadId()));
                        VideoPbFragment.this.jZw.kyX = true;
                    }
                } else {
                    TiebaStatic.log(new ao("c13591"));
                }
                VideoPbFragment.this.cPt();
            }
        });
        this.kxe.setOnClickListener(this.kxa);
        this.kwZ.setOnClickListener(this.kxa);
    }

    private void cPj() {
        this.kwR.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.kwR.setContainerLayoutParams(layoutParams);
        this.kwR.setRectPaintColor(R.color.cp_link_tip_a);
        this.kwR.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.kwR.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.kwR.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.kwR.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.kwR.setExpandedTabLayoutParams(layoutParams2);
    }

    public void sN(boolean z) {
        if (this.WW != null) {
            this.WW.setExpanded(z);
        }
    }

    private void cPk() {
        this.kmL = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.kmM = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.kmW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.kmX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.kmO = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.kmO.setVisibility(com.baidu.tbadk.a.d.aNW() ? 0 : 8);
        if (com.baidu.tbadk.a.d.aNW()) {
            this.kmO.setIsRound(true);
            this.kmO.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.kmO.setBorderColor(an.getColor(R.color.cp_border_a));
            this.kmO.setPlaceHolder(1);
            this.kmO.setDefaultResource(R.color.cp_bg_line_e);
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.kmO.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            }
        }
        this.iyQ = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.kmN = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.kmN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.sN(false);
                VideoPbFragment.this.cJb();
                if (VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null && VideoPbFragment.this.cIf().getPbData().cGO() != null && VideoPbFragment.this.cIf().getPbData().cGO().aSp() != null) {
                    if (com.baidu.tbadk.a.d.aNW()) {
                        TiebaStatic.log(new ao("c13701").dk("tid", VideoPbFragment.this.cIf().cKb()).dk("fid", VideoPbFragment.this.cIf().getPbData().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    }
                    TiebaStatic.log(new ao("c13402").dk("tid", VideoPbFragment.this.cIf().cKa()).dk("fid", VideoPbFragment.this.cIf().getPbData().getForumId()).ag("obj_locate", 1).dk("uid", VideoPbFragment.this.cIf().getPbData().cGO().aSp().getUserId()));
                }
            }
        });
        this.kmP = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.kmP.setOnClickListener(this.aXG);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.kmQ = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.kmQ.setOnClickListener(this.aXG);
        if (booleanExtra) {
            this.kmQ.setVisibility(8);
        } else {
            this.kmQ.setVisibility(0);
        }
        this.kmR = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.kmR.setOnClickListener(this.aXG);
        this.kmS = new com.baidu.tieba.pb.view.c(this.kmR);
        this.kmS.cQN();
        if (com.baidu.tbadk.a.d.aNW()) {
            this.kmT = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
            this.kmT.setVisibility(0);
        } else {
            this.kmU = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_number);
            this.kmU.setVisibility(0);
        }
        so(false);
    }

    private void biq() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.bYy();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.kwY = this.rootView.findViewById(R.id.status_bar_background);
        if (this.kxp) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(cJJ());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.kwY.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(cJJ());
            this.kwY.setLayoutParams(layoutParams2);
            this.kwY.setVisibility(0);
        }
        this.eDr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aXG);
        this.fIH = (ImageView) this.eDr.findViewById(R.id.widget_navi_back_button);
        SvgManager.aWQ().a(this.fIH, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.ksu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aXG);
        this.afe = (ImageView) this.ksu.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.ksu.setLayoutParams(layoutParams3);
        SvgManager.aWQ().a(this.afe, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.ksu.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.hKL);
        this.mNavigationBar.setOnTouchListener(this.kxr);
    }

    public void cPl() {
        setEditorTools(this.kfD.bfa());
    }

    private void byk() {
        this.keK = new PbFakeFloorModel(getPageContext());
        this.knu = new t(getPageContext(), this.keK, this.rootView);
        this.knu.a(this.kgo);
        this.keK.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.keK.t(postData);
                if (VideoPbFragment.this.cPy() != null) {
                    VideoPbFragment.this.cPy().cQj();
                }
                VideoPbFragment.this.knu.cIL();
                VideoPbFragment.this.ZX.bdC();
                VideoPbFragment.this.so(false);
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.keN = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (cIf() != null) {
            cIf().aC(bundle);
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
        this.bjF = true;
        getVoiceManager().onPause(getPageContext());
        this.kwW.oC(true);
        if (cIf() != null && !cIf().cKh()) {
            this.kfD.yB(cIf().cKa());
        }
        com.baidu.tbadk.BdToken.c.aMo().aMy();
        MessageManager.getInstance().unRegisterListener(this.kgj);
        MessageManager.getInstance().unRegisterListener(this.kgk);
        MessageManager.getInstance().unRegisterListener(this.kgl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bjF = false;
        getVoiceManager().onResume(getPageContext());
        this.kwW.oC(false);
        cJF();
        registerListener(this.kgj);
        registerListener(this.kgk);
        registerListener(this.kgl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.kwS != null && this.dSy != null) {
            this.kwS.BV(z ? this.dSy.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (com.baidu.tbadk.a.d.aNW() && this.kmO != null) {
            this.kmO.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.dgY().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dgY().A(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.kmS != null) {
            this.kmS.onDestroy();
        }
        if (this.gRX != null) {
            this.gRX.cancelLoadData();
        }
        if (this.kwW != null) {
            this.kwW.onDestroy();
        }
        if (this.kfe != null) {
            this.kfe.cancelLoadData();
        }
        if (this.jhL != null) {
            this.jhL.onDestroy();
        }
        if (cIf() != null) {
            cIf().cancelLoadData();
            cIf().destory();
            if (cIf().cKE() != null) {
                cIf().cKE().onDestroy();
            }
        }
        if (this.kfD != null) {
            this.kfD.onDestroy();
        }
        this.kfK = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.keN);
        this.kwR.onChangeSkinType();
        an.setBackgroundColor(this.kwR, R.color.cp_bg_line_h);
        this.kfu.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.kwX == null || !this.kwX.isPlaying()) {
            an.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        an.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        an.setBackgroundColor(this.kwY, R.color.cp_mask_b_alpha66);
        if (this.ZX != null) {
            this.ZX.onChangeSkinType(i);
        }
        if (this.knu != null) {
            this.knu.onChangeSkinType(i);
        }
        if (this.iyQ != null) {
            an.setViewTextColor(this.iyQ, (int) R.color.cp_cont_d);
        }
        if (this.kmO != null) {
            this.kmO.setBorderColor(an.getColor(R.color.cp_border_a));
        }
        if (this.kmN != null) {
            this.kmN.setBackgroundDrawable(an.aG(l.getDimens(getContext(), R.dimen.tbds47), an.getColor(R.color.cp_bg_line_j)));
        }
        if (this.kmQ != null && cIf() != null) {
            if (cIf().aOo()) {
                SvgManager.aWQ().a(this.kmQ, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aWQ().a(this.kmQ, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.kmP != null) {
            SvgManager.aWQ().a(this.kmP, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (cIf() != null) {
            x(cIf().getPbData());
        }
        if (this.kmT != null) {
            an.c(this.kmT, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_cont_h, R.color.cp_cont_h);
            an.setViewTextColor(this.kmT, (int) R.color.cp_cont_a);
        }
        if (this.kmU != null) {
            an.setViewTextColor(this.kmU, (int) R.color.cp_cont_b);
        }
        if (this.kmL != null) {
            an.setBackgroundResource(this.kmL, R.drawable.bottom_shadow);
        }
        an.setBackgroundColor(this.kmM, R.color.cp_bg_line_h);
        if (cPy() != null) {
            cPy().onChangeSkinType(i);
        }
        if (cPz() != null) {
            cPz().onChangeSkinType(i);
        }
        if (this.kwT != null) {
            an.setBackgroundResource(this.kwT, R.drawable.personalize_tab_shadow);
        }
        if (this.kwZ != null) {
            an.setBackgroundColor(this.kwZ, R.color.cp_bg_line_g);
        }
        if (this.kxd != null) {
            SvgManager.aWQ().a(this.kxd, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.kxb != null) {
            an.setViewTextColor(this.kxb, (int) R.color.cp_cont_b);
        }
        if (this.kxc != null) {
            an.setViewTextColor(this.kxc, (int) R.color.cp_cont_d);
        }
        if (this.kxg != null) {
            this.kxg.setBackgroundDrawable(an.aG(l.getDimens(this.kxg.getContext(), R.dimen.tbds32), an.getColor(R.color.cp_other_c)));
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hzJ == null) {
            this.hzJ = VoiceManager.instance();
        }
        return this.hzJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYx() {
        if (this.hzJ != null) {
            this.hzJ.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cJH() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cJI() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel cIf() {
        return this.keN.cIf();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cJJ() {
        return this.keN;
    }

    public com.baidu.tbadk.baseEditMark.a cPm() {
        return this.kfo;
    }

    public View.OnClickListener cPn() {
        return this.aXG;
    }

    public View.OnClickListener cPo() {
        return this.kcu;
    }

    public View.OnLongClickListener cPp() {
        return this.kxj.cPp();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (ba.Kg(objArr[i].getLink()) && (drawable = an.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView cbi() {
        Iterator<BaseFragment> it = this.kwS.cPI().iterator();
        while (it.hasNext()) {
            BaseFragment next = it.next();
            if (next instanceof ReplyFragment) {
                return ((ReplyFragment) next).getListView();
            }
        }
        return null;
    }

    private void rF(boolean z) {
        this.kfD.ij(z);
        this.kfD.ik(z);
        this.kfD.il(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.kxj != null) {
            if (z) {
                this.kxj.cMC();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.kxj.cMD();
            } else {
                this.kxj.cMC();
            }
        }
    }

    public boolean Bj(int i) {
        if (this.jhL == null || cIf() == null || cIf().getPbData() == null || cIf().getPbData().getAnti() == null) {
            return true;
        }
        return this.jhL.aF(cIf().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean cJd() {
        if ((cIf() != null && cIf().getPbData().cHq()) || this.jhL == null || cIf() == null || cIf().getPbData() == null || cIf().getPbData().getAnti() == null) {
            return true;
        }
        return this.jhL.lp(cIf().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && cIf() != null) {
            gVar.setForumName(cIf().cHW());
            if (cIf().getPbData() != null && cIf().getPbData().getForum() != null) {
                gVar.a(cIf().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(cIf());
        }
    }

    public void cMe() {
        if (this.ZX != null) {
            this.ZX.display();
            if (this.kfD != null) {
                this.kfD.bfF();
            }
            cMM();
        }
    }

    public com.baidu.tbadk.editortools.pb.e cIQ() {
        return this.kfD;
    }

    private boolean cJa() {
        PbModel cIf = cIf();
        if (cIf == null || cIf.getPbData() == null) {
            return false;
        }
        bu cGO = cIf.getPbData().cGO();
        cIf.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cGO);
    }

    public void cJb() {
        if (checkUpIsLogin() && cIf() != null && cIf().getPbData() != null && cIf().getPbData().getForum() != null && !cJa()) {
            if (cIf().getPbData().cHq()) {
                ckK();
                return;
            }
            if (this.hDN == null) {
                this.hDN = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hDN.vG(0);
                this.hDN.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void nl(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void z(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void nm(boolean z) {
                        if (z) {
                            VideoPbFragment.this.ckK();
                        }
                    }
                });
            }
            this.hDN.D(cIf().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cIf().cKa(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.kfD.onActivityResult(i, i2, intent);
        if (this.kfe != null) {
            this.kfe.onActivityResult(i, i2, intent);
        }
        if (this.knu != null) {
            this.knu.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cJn();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cYz().G(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.kfG = emotionImageData;
                        if (Bj(ak.dUy)) {
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
        if (cJJ() != null) {
            if (this.kxq && !TbSingleton.getInstance().isNotchScreen(cJJ()) && !TbSingleton.getInstance().isCutoutScreen(cJJ())) {
                cPD();
                UtilHelper.hideStatusBar(cJJ(), cJJ().getRootView());
                this.kxq = false;
            }
            this.kxk.kxF = z;
            cPq();
            cPr();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.keN;
        if (i == 0) {
            cLK();
            if (this.knu != null) {
                this.knu.cIL();
            }
            so(false);
        }
        cLO();
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
                        this.kfD.resetData();
                        this.kfD.setVoiceModel(pbEditorData.getVoiceModel());
                        this.kfD.b(writeData);
                        com.baidu.tbadk.editortools.l nB = this.kfD.bfa().nB(6);
                        if (nB != null && nB.etH != null) {
                            nB.etH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.keN;
                        if (i == -1) {
                            this.kfD.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.knu != null && this.knu.cIP() != null) {
                            h cIP = this.knu.cIP();
                            cIP.setThreadData(cIf().getPbData().cGO());
                            cIP.b(writeData);
                            cIP.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l nB2 = cIP.bfa().nB(6);
                            if (nB2 != null && nB2.etH != null) {
                                nB2.etH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.keN;
                            if (i == -1) {
                                cIP.bfX();
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
                if (cIf() != null && !cIf().cKh()) {
                    antiData.setBlock_forum_name(cIf().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(cIf().getPbData().getForum().getId());
                    antiData.setUser_name(cIf().getPbData().getUserData().getUserName());
                    antiData.setUser_id(cIf().getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bA(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", av.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", av.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", av.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.kxj != null) {
                this.kxj.yH(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void cJL() {
        if (cIf() != null && this.keN != null) {
            if (this.kfD == null || !this.kfD.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.kfD = (com.baidu.tbadk.editortools.pb.e) dVar.dO(getContext());
                this.kfD.a(this.keN.getPageContext());
                this.kfD.a(this.evL);
                this.kfD.a(this.evE);
                this.kfD.a(this.keN.getPageContext(), this.keN.getIntent() == null ? null : this.keN.getIntent().getExtras());
                this.kfD.bfa().m32if(true);
                setEditorTools(this.kfD.bfa());
                if (!cIf().cKh()) {
                    this.kfD.yC(cIf().cKa());
                }
                if (cIf().cKI()) {
                    this.kfD.yA(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.kfD.yA(cLQ());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.ZX = editorTools;
        this.ZX.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.ZX.getParent() == null) {
            this.rootView.addView(this.ZX, layoutParams);
        }
        this.ZX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.ZX.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).bai() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).bai() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.kfD.c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            VideoPbFragment.this.kfD.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cLK();
        this.kfD.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.ZX != null && VideoPbFragment.this.ZX.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.kfu != null && VideoPbFragment.this.kfu.cNb() != null) {
                    if (!VideoPbFragment.this.kfu.cNb().dqP()) {
                        VideoPbFragment.this.kfu.st(false);
                    }
                    VideoPbFragment.this.kfu.cNb().vF(false);
                }
            }
        });
    }

    public void ckK() {
        if (!checkUpIsLogin()) {
            if (cIf() != null) {
                TiebaStatic.log(new ao("c10517").ag("obj_locate", 2).dk("fid", cIf().getForumId()));
            }
        } else if (cJd()) {
            if (this.kfD != null && (this.kfD.bfP() || this.kfD.bfQ())) {
                this.kfD.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.ZX != null) {
                cMe();
                this.kxk.kxE = false;
                if (this.ZX.nB(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.ZX.nB(2).etH, false, null);
                }
            }
            cMM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cJa() && cJd()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.kfg);
                this.kfh = ((View) view.getParent()).getMeasuredHeight();
            }
            if (cIf() != null && cIf().getPbData() != null && cIf().getPbData().cHq()) {
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.keN.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.cbi().smoothScrollBy(0, (VideoPbFragment.this.kfg[1] + VideoPbFragment.this.kfh) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.knu != null) {
                            VideoPbFragment.this.kfD.bfa().setVisibility(8);
                            VideoPbFragment.this.knu.g(str, str2, VideoPbFragment.this.cLQ(), (VideoPbFragment.this.cIf() == null || VideoPbFragment.this.cIf().getPbData() == null || VideoPbFragment.this.cIf().getPbData().cGO() == null || !VideoPbFragment.this.cIf().getPbData().cGO().isBjh()) ? false : true);
                            h cIP = VideoPbFragment.this.knu.cIP();
                            if (cIP != null && VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null) {
                                cIP.a(VideoPbFragment.this.cIf().getPbData().getAnti());
                                cIP.setThreadData(VideoPbFragment.this.cIf().getPbData().cGO());
                            }
                            if (VideoPbFragment.this.kfu.cNd() == null && VideoPbFragment.this.knu.cIP().bgf() != null) {
                                VideoPbFragment.this.knu.cIP().bgf().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kfu != null && VideoPbFragment.this.kfu.cNc() != null) {
                                            if (!VideoPbFragment.this.kfu.cNc().dqP()) {
                                                VideoPbFragment.this.kfu.su(false);
                                            }
                                            VideoPbFragment.this.kfu.cNc().vF(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kfu.f(VideoPbFragment.this.knu.cIP().bgf().getInputView());
                                VideoPbFragment.this.knu.cIP().a(VideoPbFragment.this.kfI);
                            }
                        }
                        VideoPbFragment.this.cMM();
                    }
                }, 0L);
                return;
            }
            if (this.kfF == null) {
                this.kfF = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.kfF.vG(1);
                this.kfF.a(new AnonymousClass44(str, str2));
            }
            if (cIf() != null && cIf().getPbData() != null && cIf().getPbData().getForum() != null) {
                this.kfF.D(cIf().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cIf().cKa(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$44  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass44 implements c.a {
        final /* synthetic */ String kgN;
        final /* synthetic */ String kgO;

        AnonymousClass44(String str, String str2) {
            this.kgN = str;
            this.kgO = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nl(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nm(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.cbi().smoothScrollBy(0, (VideoPbFragment.this.kfg[1] + VideoPbFragment.this.kfh) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.knu != null) {
                            VideoPbFragment.this.kfD.bfa().setVisibility(8);
                            VideoPbFragment.this.knu.g(AnonymousClass44.this.kgN, AnonymousClass44.this.kgO, VideoPbFragment.this.cLQ(), (VideoPbFragment.this.cIf() == null || VideoPbFragment.this.cIf().getPbData() == null || VideoPbFragment.this.cIf().getPbData().cGO() == null || !VideoPbFragment.this.cIf().getPbData().cGO().isBjh()) ? false : true);
                            h cIP = VideoPbFragment.this.knu.cIP();
                            if (cIP != null && VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null) {
                                cIP.a(VideoPbFragment.this.cIf().getPbData().getAnti());
                                cIP.setThreadData(VideoPbFragment.this.cIf().getPbData().cGO());
                            }
                            if (VideoPbFragment.this.kfu.cNd() == null && VideoPbFragment.this.knu.cIP().bgf() != null) {
                                VideoPbFragment.this.knu.cIP().bgf().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kfu != null && VideoPbFragment.this.kfu.cNc() != null) {
                                            if (!VideoPbFragment.this.kfu.cNc().dqP()) {
                                                VideoPbFragment.this.kfu.su(false);
                                            }
                                            VideoPbFragment.this.kfu.cNc().vF(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kfu.f(VideoPbFragment.this.knu.cIP().bgf().getInputView());
                                VideoPbFragment.this.knu.cIP().a(VideoPbFragment.this.kfI);
                            }
                        }
                        VideoPbFragment.this.cMM();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        PostData I;
        z zVar;
        StringBuilder sb = null;
        if (eVar != null && (I = I(eVar)) != null) {
            String userId = I.aSp().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, I.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cHd()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (I.aSp() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, I.aSp().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, I.aSp().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, I.aSp().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, I.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, I.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cHd()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bq> cHk = eVar.cHk();
                if (w.getCount(cHk) > 0) {
                    sb = new StringBuilder();
                    for (bq bqVar : cHk) {
                        if (bqVar != null && !StringUtils.isNull(bqVar.getForumName()) && (zVar = bqVar.dKO) != null && zVar.dIC && !zVar.dID && (zVar.type == 1 || zVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bqVar.getForumName(), 12)).append(TbadkCoreApplication.getInst().getString(R.string.forum)).append("、");
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
    public void cJn() {
        MarkData Bv;
        if (cIf() != null && cIf().getPbData() != null && cPy() != null && this.kfo != null) {
            if (cIf().getPbData() != null && cIf().getPbData().cHq()) {
                Bv = cIf().Bv(0);
            } else if (this.dSy != null && this.dSy.getCurrentItem() == kwO) {
                Bv = cIf().o(I(cIf().getPbData()));
            } else {
                Bv = cIf().Bv(cPy().cMo());
            }
            if (Bv != null) {
                if (!Bv.isApp() || (Bv = cIf().Bv(cPy().cMo() + 1)) != null) {
                    cMj();
                    this.kfo.a(Bv);
                    if (!this.kfo.aOo()) {
                        this.kfo.aOq();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.kfo.aOp();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Bk(int i) {
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
            if (this.kfe == null) {
                this.kfe = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.keN);
                this.kfe.b(this.evE);
                this.kfe.c(this.evL);
            }
            this.kfe.a(emotionImageData, cIf(), cIf().getPbData());
        }
    }

    public PostData I(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.cHb() != null) {
            return eVar.cHb();
        }
        if (!w.isEmpty(eVar.cGQ())) {
            Iterator<PostData> it = eVar.cGQ().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dhZ() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.cGX();
        }
        if (postData == null) {
            postData = a(eVar);
        }
        if (postData != null && postData.aSp() != null && postData.aSp().getUserTbVipInfoData() != null && postData.aSp().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aSp().getGodUserData().setIntro(postData.aSp().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cGO() == null || eVar.cGO().aSp() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aSp = eVar.cGO().aSp();
        String userId = aSp.getUserId();
        HashMap<String, MetaData> userMap = eVar.cGO().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aSp;
        }
        postData.EW(1);
        postData.setId(eVar.cGO().aSG());
        postData.setTitle(eVar.cGO().getTitle());
        postData.setTime(eVar.cGO().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cJs() {
        ArrayList<PostData> cGQ;
        int count;
        int i;
        if (cIf() == null || cIf().getPbData() == null || cIf().getPbData().cGQ() == null || (count = w.getCount((cGQ = cIf().getPbData().cGQ()))) == 0) {
            return "";
        }
        if (cIf().cKs()) {
            Iterator<PostData> it = cGQ.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dhZ() == 1) {
                    return next.getId();
                }
            }
        }
        if (cbi() == null) {
            i = 0;
        } else {
            i = cPy().cMn();
        }
        PostData postData = (PostData) w.getItem(cGQ, i);
        if (postData == null || postData.aSp() == null) {
            return "";
        }
        if (cIf().JU(postData.aSp().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) w.getItem(cGQ, i2);
            if (postData2 == null || postData2.aSp() == null || postData2.aSp().getUserId() == null) {
                break;
            } else if (cIf().JU(postData2.aSp().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) w.getItem(cGQ, i3);
            if (postData3 == null || postData3.aSp() == null || postData3.aSp().getUserId() == null) {
                return "";
            }
            if (cIf().JU(postData3.aSp().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJo() {
        if (cIf() != null) {
            com.baidu.tieba.pb.data.e pbData = cIf().getPbData();
            cIf().rT(true);
            if (this.kfo != null) {
                pbData.JF(this.kfo.aOn());
            }
            if (cPy() != null) {
                cPy().cQj();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (cIf() != null) {
            cMl();
            cIf().rT(z);
            if (this.kfo != null) {
                this.kfo.gJ(z);
                if (markData != null) {
                    this.kfo.a(markData);
                }
            }
            if (cIf().aOo()) {
                cJo();
            } else if (cPy() != null) {
                cPy().cQj();
            }
        }
    }

    public void b(n nVar) {
        MetaData metaData;
        boolean z = true;
        if (cIf() != null && cIf().getPbData() != null && nVar.cHJ() != null) {
            String id = nVar.cHJ().getId();
            ArrayList<PostData> cGQ = cIf().getPbData().cGQ();
            int i = 0;
            while (true) {
                if (i >= cGQ.size()) {
                    break;
                }
                PostData postData = cGQ.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cHN = nVar.cHN();
                    postData.EV(nVar.getTotalCount());
                    if (postData.dhW() != null && cHN != null) {
                        Iterator<PostData> it = cHN.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aSp() != null && (metaData = postData.getUserMap().get(next.aSp().getUserId())) != null) {
                                next.a(metaData);
                                next.uJ(true);
                                next.a(getPageContext(), cIf().JU(metaData.getUserId()));
                            }
                        }
                        boolean z2 = cHN.size() != postData.dhW().size();
                        postData.dhW().clear();
                        postData.dhW().addAll(cHN);
                        z = z2;
                    }
                    if (postData.dhS() != null) {
                        postData.dhT();
                    }
                }
            }
            if (!cIf().getIsFromMark() && z && cPy() != null) {
                cPy().cQj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJf() {
        if (cIf() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.Mr(cIf().getForumId()) && cIf().getPbData() != null && cIf().getPbData().getForum() != null) {
            if (cIf().getPbData().getForum().isLike() == 1) {
                cIf().cKG().fq(cIf().getForumId(), cIf().cKa());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            bu cGO = eVar.cGO();
            if (cGO != null && cGO.aQZ()) {
                cJL();
            } else {
                d(this.kfC);
            }
            if (this.kfD != null) {
                sm(this.kfD.bfI());
                this.kfD.a(eVar.getAnti());
                this.kfD.a(eVar.getForum(), eVar.getUserData());
                this.kfD.setThreadData(cGO);
                if (cIf() != null) {
                    this.kfD.a(cIf().cKq(), cIf().cKa(), cIf().cKH());
                }
                if (cGO != null) {
                    this.kfD.im(cGO.aTM());
                }
            }
        }
    }

    public void cLO() {
        reset();
        cLK();
        this.knu.cIL();
        so(false);
    }

    private void reset() {
        if (this.kfD != null && this.ZX != null) {
            com.baidu.tbadk.editortools.pb.a.bfx().setStatus(0);
            this.kfD.bfS();
            this.kfD.bfk();
            if (this.kfD.getWriteImagesInfo() != null) {
                this.kfD.getWriteImagesInfo().setMaxImagesAllowed(this.kfD.isBJH ? 1 : 9);
            }
            this.kfD.nH(SendView.ALL);
            this.kfD.nI(SendView.ALL);
            com.baidu.tbadk.editortools.g ny = this.ZX.ny(23);
            com.baidu.tbadk.editortools.g ny2 = this.ZX.ny(2);
            com.baidu.tbadk.editortools.g ny3 = this.ZX.ny(5);
            if (ny2 != null) {
                ny2.display();
            }
            if (ny3 != null) {
                ny3.display();
            }
            if (ny != null) {
                ny.hide();
            }
            this.ZX.invalidate();
        }
    }

    public void u(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cGO() != null) {
            x(eVar);
            this.kmQ.setVisibility(eVar.cHq() ? 8 : 0);
            if (eVar.aOo()) {
                SvgManager.aWQ().a(this.kmQ, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aWQ().a(this.kmQ, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String BD = BD(eVar.cGO().aSg());
            if (this.kmT != null) {
                this.kmT.setText(BD);
            }
            if (this.kmU != null) {
                this.kmU.setText(BD);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.cGO()));
        }
    }

    public void x(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.ba(eVar.cGO())) {
            if (this.kmS != null) {
                this.kmS.setEnable(false);
                this.kmS.onDestroy();
            }
            SvgManager.aWQ().a(this.kmR, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.kmS == null || !this.kmS.isEnable()) {
            SvgManager.aWQ().a(this.kmR, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private String BD(int i) {
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

    public void so(boolean z) {
        if (this.kmM != null) {
            sm(this.kfD.bfI());
            if (this.kmI) {
                sd(z);
            } else {
                se(z);
            }
            cPq();
            cPr();
        }
    }

    public void cMM() {
        if (this.kmM != null) {
            this.kmL.setVisibility(8);
            this.kmM.setVisibility(8);
            this.kxk.kxE = false;
            cPq();
            cPr();
        }
    }

    private void cPq() {
        if (this.kwW != null) {
            if (this.kxk.cPH()) {
                this.kwW.tM(false);
            } else {
                this.kwW.tM(this.kwW.bAs() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPr() {
        if (this.kwW != null && this.dSy != null) {
            if (this.dSy.getCurrentItem() != 0) {
                this.kwW.sV(false);
            } else if (this.kxk.cPH()) {
                this.kwW.sV(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.kwW.sV(eVar.cPR() == null || eVar.cPR().getValue() == null || eVar.cPR().getValue().booleanValue());
                }
            }
        }
    }

    private void Bl(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(cJJ(), cJe(), i);
    }

    private int cJe() {
        if (cIf() == null || cIf().getPbData() == null || cIf().getPbData().cGO() == null) {
            return -1;
        }
        return cIf().getPbData().cGO().aTc();
    }

    public void sm(boolean z) {
        this.kmI = z;
    }

    public void sd(boolean z) {
        if (this.kmM != null && this.iyQ != null) {
            this.iyQ.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kmM.startAnimation(alphaAnimation);
            }
            this.kmL.setVisibility(0);
            this.kmM.setVisibility(0);
            this.kxk.kxE = true;
        }
    }

    public void se(boolean z) {
        if (this.kmM != null && this.iyQ != null) {
            this.iyQ.setText(cLQ());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kmM.startAnimation(alphaAnimation);
            }
            this.kmL.setVisibility(0);
            this.kmM.setVisibility(0);
            this.kxk.kxE = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null) {
            this.jZw = aVar;
            this.kxb.setText(aVar.getTitle());
            this.kxc.setText(aVar.cQo());
            String cQp = aVar.cQp();
            TBSpecificationBtn tBSpecificationBtn = this.kxe;
            if (TextUtils.isEmpty(cQp)) {
                cQp = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(cQp);
            this.kxf.startLoad(aVar.getImage(), 10, false);
            this.kxg.setVisibility(aVar.cQr() ? 0 : 8);
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.jZw == null || VideoPbFragment.this.jZw.cQr()) {
                        if (VideoPbFragment.this.jZw != null && VideoPbFragment.this.cIf() != null && VideoPbFragment.this.cIf().getPbData() != null && VideoPbFragment.this.cIf().getPbData().getForum() != null) {
                            TiebaStatic.log(new ao("c13712").dk("fid", VideoPbFragment.this.cIf().getPbData().getForum().getId()).dk("fname", VideoPbFragment.this.cIf().getPbData().getForum().getName()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("tid", VideoPbFragment.this.cIf().getPbData().getThreadId()).s("obj_param1", VideoPbFragment.this.jZw.userId));
                        }
                    } else {
                        TiebaStatic.log(new ao("c13608").dk("obj_id", VideoPbFragment.this.jZw.getTitle()).dk("obj_name", VideoPbFragment.this.jZw.cQo()).ag("obj_type", 2).dk("fid", VideoPbFragment.this.cIf().getPbData().getForumId()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("tid", VideoPbFragment.this.cIf().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.cPs();
                }
            }, aVar.cQq().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPs() {
        ViewGroup.LayoutParams layoutParams = this.kwZ.getLayoutParams();
        if (layoutParams != null) {
            if (this.kxh == null || !this.kxh.isRunning()) {
                this.kwZ.setAlpha(0.0f);
                this.kwZ.setVisibility(0);
                e(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPt() {
        if (this.kwZ.getLayoutParams() != null) {
            if (this.kxh == null || !this.kxh.isRunning()) {
                cPu();
            }
        }
    }

    private void cPu() {
        final ViewGroup.LayoutParams layoutParams = this.kwZ.getLayoutParams();
        if (layoutParams != null) {
            if (this.kxi == null || !this.kxi.isRunning()) {
                this.kxi = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.kxi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.kwZ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.kxi.setDuration(200L);
                this.kxi.start();
                this.kxi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
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
        final ViewGroup.LayoutParams layoutParams2 = this.WW.getLayoutParams();
        final int i = layoutParams2.height;
        this.kxh = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kxh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.ivr);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.ivr);
                VideoPbFragment.this.kwZ.setLayoutParams(layoutParams);
                VideoPbFragment.this.WW.setLayoutParams(layoutParams2);
            }
        });
        this.kxh.setDuration(300L);
        this.kxh.start();
        this.kxh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.kwZ.setVisibility(8);
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
        final ViewGroup.LayoutParams layoutParams2 = this.WW.getLayoutParams();
        final int i = layoutParams2.height;
        this.kxh = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kxh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.ivr);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.kwZ.setLayoutParams(layoutParams);
                VideoPbFragment.this.WW.setLayoutParams(layoutParams2);
            }
        });
        this.kxh.setDuration(300L);
        this.kxh.start();
        this.kxh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.cPv();
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
    public void cPv() {
        this.kxh = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kxh.setDuration(300L);
        this.kxh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.kwZ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.kxh.start();
    }

    public String cLQ() {
        if (!ar.isEmpty(this.knL)) {
            return this.knL;
        }
        this.knL = TbadkCoreApplication.getInst().getResources().getString(au.cLF());
        return this.knL;
    }

    public void cMl() {
        hideProgressBar();
        if (cPy() != null) {
            cPy().endLoadData();
            cPy().cMm();
        }
    }

    public boolean cC(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.aPA().isShowImages()) {
                    return JQ(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (cIf() == null || cIf().getPbData() == null) {
                        return true;
                    }
                    if (this.knu != null) {
                        this.knu.cIL();
                    }
                    n nVar = new n();
                    nVar.a(cIf().getPbData().getForum());
                    nVar.setThreadData(cIf().getPbData().cGO());
                    nVar.g(postData);
                    this.keK.d(nVar);
                    this.keK.setPostId(postData.getId());
                    b(view, postData.aSp().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.kfD != null) {
                        sm(this.kfD.bfI());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void cPw() {
        if (this.kfD != null) {
            sm(this.kfD.bfI());
        }
        cLO();
        this.kxj.cMC();
    }

    private boolean JQ(String str) {
        if (!StringUtils.isNull(str) && be.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString("bubble_link", "");
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

    public void crH() {
        if (this.kmu != null) {
            this.kmu.setVisibility(0);
        }
    }

    public void crG() {
        if (this.kmu != null) {
            this.kmu.setVisibility(8);
        }
    }

    public void BT(int i) {
        if (this.kwT != null) {
            this.kwT.setVisibility(i);
        }
    }

    public void cMj() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a cJi() {
        return this.kgq;
    }

    public void cLK() {
        if (this.ZX != null) {
            this.ZX.hide();
        }
    }

    public void bYy() {
        if (this.keN.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.keN.getCurrentFocus());
        }
    }

    public void K(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cGO() != null) {
            String valueOf = String.valueOf(eVar.cGO().aSg());
            if (eVar.cGO().aSg() == 0) {
                valueOf = "";
            }
            this.kwR.zy(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        for (BaseFragment baseFragment : this.kwS.cPI()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, eVar, str, i4);
            }
        }
        b(z, i, i2, i3, eVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (cIf() != null && cIf().getPbData() != null && cIf().getPbData().cGO() != null && cIf().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(knn)).intValue();
                if (intValue == kno) {
                    if (!this.gRX.diM()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.gRX.Nj(ar.O(jSONArray));
                        }
                        this.gRX.a(cIf().getPbData().getForum().getId(), cIf().getPbData().getForum().getName(), cIf().getPbData().cGO().getId(), str, intValue3, intValue2, booleanValue, cIf().getPbData().cGO().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == knp || intValue == knr) {
                    if (cIf().cKD() != null) {
                        cIf().cKD().Bf(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == knp) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dS(String str, String str2) {
        bc.aWU().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int blz() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> blA() {
        if (this.eLl == null) {
            this.eLl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: blM */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.aPA().isShowImages();
                    foreDrawableImageView.setDefaultBg(an.getDrawable(R.color.common_color_10220));
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
                        if (com.baidu.tbadk.core.k.aPA().isShowImages()) {
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
        return this.eLl;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> blB() {
        if (this.eOC == null) {
            this.eOC = TbRichTextView.v(getPageContext().getPageActivity(), 8);
        }
        return this.eOC;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> blC() {
        if (this.eLm == null) {
            this.eLm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bSU */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.aPA().isShowImages();
                    gifView.setDefaultBg(an.getDrawable(R.color.common_color_10220));
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
                    if (com.baidu.tbadk.core.k.aPA().isShowImages()) {
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
                    gifView.bgx();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.eLm;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> blD() {
        if (this.eOD == null) {
            this.eOD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cJM */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cF */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cG */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).bCo();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cH */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.eOD;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> blE() {
        if (this.eOE == null) {
            this.eOE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cJO */
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
        return this.eOE;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> blF() {
        this.eOF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cJN */
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
        return this.eOF;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void al(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.keY = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (ba.Kg(str) && cIf() != null && cIf().cKa() != null) {
            TiebaStatic.log(new ao("c11664").ag("obj_param1", 1).dk("post_id", cIf().cKa()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.esJ = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
            }
        } else {
            ba.cNf().d(getPageContext(), str);
        }
        this.keY = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void am(Context context, String str) {
        ba.cNf().d(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.keY = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void an(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void s(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.kxj.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b cQb = this.kxj.cQb();
            if (cQb == null) {
                this.kxj.cIZ();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                cQb.getItemView(1).setVisibility(8);
            } else {
                cQb.getItemView(1).setVisibility(0);
            }
            cQb.aUO();
            this.keY = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ap(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            bc.aWU().b(getPageContext(), new String[]{str});
            this.keY = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a cPx() {
        return this.dUB;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bjb() {
        return this.eEC;
    }

    public ReplyFragment cPy() {
        if (this.kwS == null || !(this.kwS.BU(kwP) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.kwS.BU(kwP);
    }

    public DetailInfoFragment cPz() {
        if (this.kwS == null || !(this.kwS.BU(kwO) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.kwS.BU(kwO);
    }

    public boolean cHV() {
        PbModel cIf = this.keN.cIf();
        if (cIf == null) {
            return false;
        }
        return cIf.cHV();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cHa;
        PbModel cIf = this.keN.cIf();
        if (cIf != null && cIf.getPbData() != null && !cIf.getPbData().cHq()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = cIf.getPbData().cGO().getId();
            if (cIf.isShareThread() && cIf.getPbData().cGO().dNX != null) {
                historyMessage.threadName = cIf.getPbData().cGO().dNX.showText;
            } else {
                historyMessage.threadName = cIf.getPbData().cGO().getTitle();
            }
            if (cIf.isShareThread() && !cHV()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = cIf.getPbData().getForum().getName();
            }
            ArrayList<PostData> cGQ = cIf.getPbData().cGQ();
            int cMn = cPy() != null ? cPy().cMn() : 0;
            if (cGQ != null && cMn >= 0 && cMn < cGQ.size()) {
                historyMessage.postID = cGQ.get(cMn).getId();
            }
            historyMessage.isHostOnly = cIf.getHostMode();
            historyMessage.isSquence = cIf.cKc();
            historyMessage.isShareThread = cIf.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.kfD != null) {
            this.kfD.onDestroy();
        }
        if (cIf != null && (cIf.cKd() || cIf.cKf())) {
            Intent intent = new Intent();
            intent.putExtra("tid", cIf.cKa());
            if (this.kfr) {
                if (this.kft) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", cIf.bRl());
                }
                if (this.kfs) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", cIf.getIsGood());
                }
            }
            if (cIf.getPbData() != null && System.currentTimeMillis() - this.keU >= 40000 && (cHa = cIf.getPbData().cHa()) != null && !w.isEmpty(cHa.getDataList())) {
                intent.putExtra("guess_like_data", cHa);
            }
            PbActivity pbActivity = this.keN;
            PbActivity pbActivity2 = this.keN;
            pbActivity.setResult(-1, intent);
        }
        if (cJp()) {
            if (cIf != null) {
                com.baidu.tieba.pb.data.e pbData = cIf.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.kfa) {
                        if (this.kwV != null) {
                            Rect rect = new Rect();
                            this.kwV.getGlobalVisibleRect(rect);
                            com.baidu.tieba.pb.pb.main.ao.cLu().h(rect);
                        }
                        com.baidu.tieba.pb.pb.main.ao.cLu().Bz(this.dSy.getCurrentItem());
                        BdTypeRecyclerView cbi = cbi();
                        Parcelable parcelable = null;
                        if (cbi != null) {
                            parcelable = cbi.onSaveInstanceState();
                        }
                        com.baidu.tieba.pb.pb.main.ao.cLu().a(cIf.cKk(), parcelable, cIf.cKc(), cIf.getHostMode(), false);
                    }
                }
            } else {
                com.baidu.tieba.pb.pb.main.ao.cLu().reset();
            }
            cIs();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.kwW != null && !this.kwW.bAs()) {
            if ((this.kwW.isFullScreen() && configuration.orientation == 1) || (!this.kwW.isFullScreen() && configuration.orientation == 2)) {
                this.kwW.sW(false);
            }
        }
    }

    public boolean cPA() {
        if (this.kwW == null) {
            return false;
        }
        return this.kwW.bAs();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.dgY().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        public boolean kxE;
        public boolean kxF;

        private a() {
            this.kxF = true;
        }

        public boolean cPH() {
            return (this.kxE && this.kxF) ? false : true;
        }
    }

    public void cPB() {
        this.kfi = -1;
        this.kfj = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJF() {
        if (cIf() != null && !ar.isEmpty(cIf().cKa())) {
            com.baidu.tbadk.BdToken.c.aMo().p(com.baidu.tbadk.BdToken.b.dyB, com.baidu.adp.lib.f.b.toLong(cIf().cKa(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.kwU.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPC() {
        if (this.kxt == null) {
            this.kxt = ObjectAnimator.ofFloat(this.kwY, "alpha", 0.0f, 1.0f);
            this.kxt.setDuration(200L);
        }
        this.kxt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPD() {
        if (this.kxu == null) {
            this.kxu = ObjectAnimator.ofFloat(this.kwY, "alpha", 1.0f, 0.0f);
            this.kxu.setDuration(200L);
        }
        this.kxu.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cPE() {
        return this.kwW != null && this.kwW.cPF();
    }

    public boolean cPF() {
        return this.kxq;
    }

    public void sO(boolean z) {
        this.kxq = z;
    }
}
