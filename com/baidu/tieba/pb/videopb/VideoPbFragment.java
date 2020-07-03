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
                com.baidu.tieba.pb.a.b.cHS();
            } else {
                com.baidu.tieba.pb.a.b.cHR();
            }
        }
    };
    private long keU = 0;
    View.OnClickListener kxa = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.jZw == null || VideoPbFragment.this.jZw.cQq()) {
                if (VideoPbFragment.this.jZw != null) {
                    if (VideoPbFragment.this.jZw.isChushou) {
                        VideoPbFragment.this.dS(VideoPbFragment.this.jZw.thirdRoomId, VideoPbFragment.this.jZw.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.jZw.cQr();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null && VideoPbFragment.this.cIe().getPbData().getForum() != null) {
                        TiebaStatic.log(new ao("c13713").dk("fid", VideoPbFragment.this.cIe().getPbData().getForum().getId()).dk("fname", VideoPbFragment.this.cIe().getPbData().getForum().getName()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("tid", VideoPbFragment.this.cIe().getPbData().getThreadId()).s("obj_param1", VideoPbFragment.this.jZw.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new ao("c13590").dk("obj_id", VideoPbFragment.this.jZw.getTitle()).dk("obj_name", VideoPbFragment.this.jZw.cQn()).ag("obj_type", 2).dk("fid", VideoPbFragment.this.cIe().getPbData().getForumId()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("tid", VideoPbFragment.this.cIe().getPbData().getThreadId()));
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
            VideoPbFragment.this.cMk();
            VideoPbFragment.this.crF();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.so(false);
            if (z && eVar != null) {
                bu cGN = eVar.cGN();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(eVar, i2);
                VideoPbFragment.this.J(eVar);
                com.baidu.tieba.pb.videopb.c.a cHr = eVar.cHr();
                if (cHr != null && !cHr.kyX) {
                    VideoPbFragment.this.a(cHr);
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
                if (VideoPbFragment.this.jhL != null && cGN != null && cGN.aSp() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(cGN.aSp());
                    VideoPbFragment.this.jhL.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.cIe().cJZ());
                        jSONObject.put("fid", VideoPbFragment.this.cIe().getForumId());
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
                if (VideoPbFragment.this.cPx() != null) {
                    if (i != -1) {
                        ArrayList<PostData> arrayList = null;
                        if (VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null) {
                            arrayList = VideoPbFragment.this.cIe().getPbData().cGP();
                        }
                        if (w.getCount(arrayList) == 0 || (w.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dhY() == 1)) {
                            if (VideoPbFragment.this.cPx().cJC()) {
                                VideoPbFragment.this.cPx().Kc(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                VideoPbFragment.this.cPx().Kc(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            VideoPbFragment.this.cPx().Kb(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                        }
                    } else {
                        VideoPbFragment.this.cPx().Kb("");
                    }
                    VideoPbFragment.this.cPx().endLoadData();
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.dgX().b(VideoPbFragment.this.getUniqueId(), false);
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
            VideoPbFragment.this.cMk();
            if (z && VideoPbFragment.this.cIe() != null) {
                if (VideoPbFragment.this.kfo != null) {
                    VideoPbFragment.this.kfo.gJ(z2);
                }
                VideoPbFragment.this.cIe().rT(z2);
                if (VideoPbFragment.this.cIe().aOo()) {
                    VideoPbFragment.this.cJn();
                } else if (VideoPbFragment.this.cPx() != null) {
                    VideoPbFragment.this.cPx().cQi();
                }
                if (z2) {
                    if (VideoPbFragment.this.kfo != null) {
                        if (VideoPbFragment.this.kfo.aOr() != null && VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null && VideoPbFragment.this.cIe().getPbData().cGN() != null && VideoPbFragment.this.cIe().getPbData().cGN().aSp() != null) {
                            MarkData aOr = VideoPbFragment.this.kfo.aOr();
                            MetaData aSp = VideoPbFragment.this.cIe().getPbData().cGN().aSp();
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
                    VideoPbFragment.this.cJk();
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
            if (VideoPbFragment.this.kfu == null || VideoPbFragment.this.kfu.cNa() == null || !VideoPbFragment.this.kfu.cNa().dqK()) {
                return !VideoPbFragment.this.Bj(ak.dUw);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kfu.cNa().dqM());
            if (VideoPbFragment.this.kfD != null && (VideoPbFragment.this.kfD.bfP() || VideoPbFragment.this.kfD.bfQ())) {
                VideoPbFragment.this.kfD.a(false, VideoPbFragment.this.kfu.cNd());
            }
            VideoPbFragment.this.kfu.st(true);
            return true;
        }
    };
    private final CustomMessageListener kfX = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.cIe() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.kfD != null) {
                    VideoPbFragment.this.sm(VideoPbFragment.this.kfD.bfI());
                }
                VideoPbFragment.this.cLN();
                VideoPbFragment.this.kxj.cMB();
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
                VideoPbFragment.this.cJE();
            }
        }
    };
    private CustomMessageListener kgr = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.cJe();
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
                VideoPbFragment.this.kxj.bJm();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.kxj.getExtra();
                DataRes dataRes = aVar.lUh;
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
                VideoPbFragment.this.kxj.bJm();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.cIe().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cHd().add(muteUser);
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
                    VideoPbFragment.this.kxj.cJB();
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
                VideoPbFragment.this.kxj.bJm();
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
            if (VideoPbFragment.this.kfu == null || VideoPbFragment.this.kfu.cNb() == null || !VideoPbFragment.this.kfu.cNb().dqK()) {
                return !VideoPbFragment.this.Bj(ak.dUx);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kfu.cNb().dqM());
            if (VideoPbFragment.this.knu != null && VideoPbFragment.this.knu.cIO() != null && VideoPbFragment.this.knu.cIO().bfQ()) {
                VideoPbFragment.this.knu.cIO().a(VideoPbFragment.this.kfu.cNd());
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
                if (VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null) {
                    aoVar.dk("fid", VideoPbFragment.this.cIe().getPbData().getForumId());
                }
                aoVar.dk("tid", VideoPbFragment.this.cIe().cJZ());
                aoVar.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aoVar);
            }
            VideoPbFragment.this.bYw();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.cIe() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.cIe().JW(postWriteCallBackData.getPostId());
                    if (VideoPbFragment.this.cPx() != null) {
                        VideoPbFragment.this.kfQ = VideoPbFragment.this.cPx().cMm();
                        VideoPbFragment.this.kxl = VideoPbFragment.this.cPx().cQl();
                        VideoPbFragment.this.cIe().cJ(VideoPbFragment.this.kfQ, VideoPbFragment.this.kxl);
                    }
                }
                if (VideoPbFragment.this.dSy != null) {
                    VideoPbFragment.this.dSy.setCurrentItem(VideoPbFragment.kwP);
                }
                VideoPbFragment.this.kxj.cMB();
                VideoPbFragment.this.kfu.cMZ();
                if (VideoPbFragment.this.kfD != null) {
                    VideoPbFragment.this.sm(VideoPbFragment.this.kfD.bfI());
                }
                VideoPbFragment.this.cLJ();
                VideoPbFragment.this.so(true);
                VideoPbFragment.this.cIe().cKu();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && VideoPbFragment.this.cPx() != null) {
                            VideoPbFragment.this.cPx().cQi();
                        }
                    } else if (VideoPbFragment.this.cIe().getHostMode()) {
                        com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.cIe().getPbData();
                        if (pbData != null && pbData.cGN() != null && pbData.cGN().aSp() != null && (userId = pbData.cGN().aSp().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.cIe().cKl()) {
                            VideoPbFragment.this.cMi();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.cIe().cKl()) {
                        VideoPbFragment.this.cMi();
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
                    VideoPbFragment.this.cPB();
                    UtilHelper.showStatusBar(VideoPbFragment.this.cJI(), VideoPbFragment.this.cJI().getRootView());
                    VideoPbFragment.this.kxq = true;
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(VideoPbFragment.this.kxs);
                    com.baidu.adp.lib.f.e.lt().postDelayed(VideoPbFragment.this.kxs, 3000L);
                }
            } else if (VideoPbFragment.this.kxm == 2 && (VideoPbFragment.this.kxq || VideoPbFragment.this.cPD())) {
                VideoPbFragment.this.cPC();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cJI(), VideoPbFragment.this.cJI().getRootView());
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
            if (VideoPbFragment.this.kxq && !VideoPbFragment.this.cPD()) {
                VideoPbFragment.this.cPC();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cJI(), VideoPbFragment.this.cJI().getRootView());
                VideoPbFragment.this.kxq = false;
            }
        }
    };
    private final com.baidu.adp.base.d gSe = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.cIe() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.gRX.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.gRX.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.cIe().cKu();
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
                if (VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null) {
                    aoVar.dk("fid", VideoPbFragment.this.cIe().getPbData().getForumId());
                }
                if (VideoPbFragment.this.cIe() != null) {
                    aoVar.dk("tid", VideoPbFragment.this.cIe().cJZ());
                }
                aoVar.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aoVar);
            }
            if (z) {
                if (VideoPbFragment.this.kfu != null) {
                    VideoPbFragment.this.kfu.cMY();
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
                if (VideoPbFragment.this.knu != null && VideoPbFragment.this.knu.cIO() != null && VideoPbFragment.this.knu.cIO().bfQ()) {
                    VideoPbFragment.this.knu.cIO().a(postWriteCallBackData);
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
                    aoVar.dk("tid", VideoPbFragment.this.cIe().cJZ());
                    aoVar.dk("fid", VideoPbFragment.this.cIe().getForumId());
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
                            if (VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null && VideoPbFragment.this.keK != null && postData.aSp() != null && postData.dhY() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.knu != null) {
                                    VideoPbFragment.this.knu.cIK();
                                }
                                n nVar = new n();
                                nVar.a(VideoPbFragment.this.cIe().getPbData().getForum());
                                nVar.setThreadData(VideoPbFragment.this.cIe().getPbData().cGN());
                                nVar.g(postData);
                                VideoPbFragment.this.keK.d(nVar);
                                VideoPbFragment.this.keK.setPostId(postData.getId());
                                VideoPbFragment.this.b(view, postData.aSp().getUserId(), "");
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.cIe().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.kfD != null) {
                                    VideoPbFragment.this.sm(VideoPbFragment.this.kfD.bfI());
                                }
                            }
                        }
                    }
                } else if (VideoPbFragment.this.cPx() != null && VideoPbFragment.this.cPx().cMx() != null && view == VideoPbFragment.this.cPx().cMx()) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.cIe().rR(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        VideoPbFragment.this.cPx().cMj();
                    }
                } else if (VideoPbFragment.this.kxj != null && VideoPbFragment.this.kxj.cNG() != null && view == VideoPbFragment.this.kxj.cNG().cLi()) {
                    VideoPbFragment.this.kxj.aFg();
                } else if (VideoPbFragment.this.kxj != null && ((VideoPbFragment.this.kxj.cNG() != null && view == VideoPbFragment.this.kxj.cNG().cLj()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.kxj.cMB();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.bYw();
                        VideoPbFragment.this.cMi();
                        if (view.getId() == R.id.owner_reply) {
                            y = VideoPbFragment.this.cIe().y(true, VideoPbFragment.this.cJr());
                        } else {
                            y = view.getId() == R.id.all_reply ? VideoPbFragment.this.cIe().y(false, VideoPbFragment.this.cJr()) : VideoPbFragment.this.cIe().JT(VideoPbFragment.this.cJr());
                        }
                        view.setTag(Boolean.valueOf(y));
                        if (y) {
                            VideoPbFragment.this.crG();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.eDr) {
                    if (VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null) {
                        if (!ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            ao aoVar2 = new ao("c13266");
                            aoVar2.dk("uid", TbadkCoreApplication.getCurrentAccount());
                            aoVar2.dk("fid", VideoPbFragment.this.cIe().getPbData().getForumId());
                            aoVar2.dk("tid", VideoPbFragment.this.cIe().cJZ());
                            aoVar2.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(aoVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.keN, VideoPbFragment.this.eDr);
                        VideoPbFragment.this.keN.finish();
                    }
                } else if (view == VideoPbFragment.this.ksu && VideoPbFragment.this.kxj != null) {
                    if (VideoPbFragment.this.cIe() == null || VideoPbFragment.this.cIe().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> cGP = VideoPbFragment.this.cIe().getPbData().cGP();
                    if ((cGP == null || cGP.size() <= 0) && VideoPbFragment.this.cIe().cKb()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new ao("c12378").dk("tid", VideoPbFragment.this.cIe().cJZ()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("fid", VideoPbFragment.this.cIe().getForumId()));
                    VideoPbFragment.this.kxj.cJf();
                } else if (VideoPbFragment.this.kxj.cNG() != null && view == VideoPbFragment.this.kxj.cNG().cLn()) {
                    if (VideoPbFragment.this.cIe() != null) {
                        VideoPbFragment.this.kxj.cMB();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.bYw();
                            VideoPbFragment.this.cMi();
                            VideoPbFragment.this.cIe().Bp(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.kxj != null && VideoPbFragment.this.kxj.cNG() != null && view == VideoPbFragment.this.kxj.cNG().cLj()) {
                    VideoPbFragment.this.kxj.aFg();
                } else if (VideoPbFragment.this.kxj != null && ((VideoPbFragment.this.kxj.cNG() != null && view == VideoPbFragment.this.kxj.cNG().cLq()) || view.getId() == R.id.pb_sort_type)) {
                    VideoPbFragment.this.kxj.cMB();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.bYw();
                            VideoPbFragment.this.cMi();
                            VideoPbFragment.this.kxj.cQ(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.cIe().cKs()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.kxj != null && VideoPbFragment.this.kxj.cNG() != null && view == VideoPbFragment.this.kxj.cNG().cLh()) {
                    if (VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null && VideoPbFragment.this.cIe().getPbData().cGN() != null) {
                        VideoPbFragment.this.kxj.aFg();
                        TiebaStatic.log(new ao("c13062"));
                        VideoPbFragment.this.kxj.JO(VideoPbFragment.this.cIe().getPbData().cGN().aSG());
                    }
                } else if (VideoPbFragment.this.kxj != null && VideoPbFragment.this.kxj.cNG() != null && view == VideoPbFragment.this.kxj.cNG().cLr()) {
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
                    VideoPbFragment.this.kxj.cNF();
                } else if (VideoPbFragment.this.kxj != null && (view == VideoPbFragment.this.kxj.cMg() || (VideoPbFragment.this.kxj.cNG() != null && (view == VideoPbFragment.this.kxj.cNG().cLm() || view == VideoPbFragment.this.kxj.cNG().cLk())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.cIe() != null || VideoPbFragment.this.cIe().getPbData() != null) {
                        if ((VideoPbFragment.this.cIe().getPbData().cHc() == 1 || VideoPbFragment.this.cIe().getPbData().cHc() == 3) && !VideoPbFragment.this.gRX.diL()) {
                            VideoPbFragment.this.kxj.cMB();
                            if (VideoPbFragment.this.kxj.cNG() != null && view == VideoPbFragment.this.kxj.cNG().cLk()) {
                                if (VideoPbFragment.this.cIe().getPbData().cGN().aSk() == 1) {
                                    i = 5;
                                } else {
                                    i = 4;
                                }
                            } else if (VideoPbFragment.this.kxj.cNG() != null && view == VideoPbFragment.this.kxj.cNG().cLm()) {
                                i = VideoPbFragment.this.cIe().getPbData().cGN().aSl() == 1 ? 3 : 6;
                            } else {
                                i = view == VideoPbFragment.this.kxj.cMg() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.cIe().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.cIe().getPbData().cGN().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.gRX.b(id, name, id2, i, VideoPbFragment.this.kxj.cMh());
                        }
                    }
                } else if (VideoPbFragment.this.kxj != null && VideoPbFragment.this.kxj.cNG() != null && view == VideoPbFragment.this.kxj.cNG().cLp()) {
                    if (VideoPbFragment.this.cIe() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.kxj.cMB();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.cIe().getPbData(), VideoPbFragment.this.cIe().cKb(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.cIe().getPbData().getForum().getId(), VideoPbFragment.this.cIe().getPbData().getForum().getName(), VideoPbFragment.this.cIe().getPbData().cGN().getId(), String.valueOf(VideoPbFragment.this.cIe().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.kxj != null && VideoPbFragment.this.kxj.cNG() != null && view == VideoPbFragment.this.kxj.cNG().cLl()) {
                    if (VideoPbFragment.this.cIe() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.cIe().getPbData(), VideoPbFragment.this.cIe().cKb(), 1);
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
                        aoVar3.dk("tid", VideoPbFragment.this.cIe().cJZ());
                        aoVar3.dk("fid", VideoPbFragment.this.cIe().getForumId());
                        aoVar3.dk("uid", TbadkCoreApplication.getCurrentAccount());
                        aoVar3.ag("obj_locate", 4);
                        TiebaStatic.log(aoVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new ao("c10517").ag("obj_locate", 3).dk("fid", VideoPbFragment.this.cIe().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null) {
                        if (VideoPbFragment.this.kxj != null) {
                            VideoPbFragment.this.kxj.cMB();
                        }
                        PostData postData2 = (PostData) ((SparseArray) view.getTag()).get(R.id.tag_load_sub_data);
                        if (postData2 != null) {
                            if (postData2.dik() == 1) {
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
                            String cJZ = VideoPbFragment.this.cIe().cJZ();
                            String id3 = postData2.getId();
                            int cHc = VideoPbFragment.this.cIe().getPbData() != null ? VideoPbFragment.this.cIe().getPbData().cHc() : 0;
                            VideoPbFragment.this.bYw();
                            TiebaStatic.log("c11742");
                            if (VideoPbFragment.this.cPx() != null && VideoPbFragment.this.cPx().cQk() != null) {
                                PbActivity.a JR = VideoPbFragment.this.cPx().cQk().JR(id3);
                                if (postData2 != null && VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null && JR != null) {
                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cJZ, id3, "pb", true, null, false, null, cHc, postData2.cOE(), VideoPbFragment.this.cIe().getPbData().getAnti(), false, postData2.aSp().getIconInfo()).addBigImageData(JR.kbN, JR.kbO, JR.kbP, JR.index);
                                    addBigImageData.setKeyFromForumId(VideoPbFragment.this.cIe().getForumId());
                                    addBigImageData.setBjhData(VideoPbFragment.this.cIe().cKi());
                                    addBigImageData.setKeyPageStartFrom(VideoPbFragment.this.cIe().cKJ());
                                    addBigImageData.setFromFrsForumId(VideoPbFragment.this.cIe().getFromForumId());
                                    VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img) {
                    if (VideoPbFragment.this.cIe() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            ao aoVar4 = new ao("c13398");
                            aoVar4.dk("tid", VideoPbFragment.this.cIe().cJZ());
                            aoVar4.dk("fid", VideoPbFragment.this.cIe().getForumId());
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
                                    TiebaStatic.log(new ao("c13700").dk("tid", VideoPbFragment.this.cIe().cKa()).dk("fid", VideoPbFragment.this.cIe().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dk("post_id", postData3.getId()).ag("obj_type", 3));
                                }
                                if (VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null && VideoPbFragment.this.keK != null && postData3.aSp() != null && postData3.dhY() != 1) {
                                    if (VideoPbFragment.this.knu != null) {
                                        VideoPbFragment.this.knu.cIK();
                                    }
                                    n nVar2 = new n();
                                    nVar2.a(VideoPbFragment.this.cIe().getPbData().getForum());
                                    nVar2.setThreadData(VideoPbFragment.this.cIe().getPbData().cGN());
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
                    } else if (VideoPbFragment.this.kxj != null && VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cPx() != null) {
                        VideoPbFragment.this.kxj.cMB();
                        if (VideoPbFragment.this.Bk(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.cIe() != null) {
                            VideoPbFragment.this.cJm();
                            if (VideoPbFragment.this.cIe().getPbData() != null && VideoPbFragment.this.cIe().getPbData().cGN() != null && VideoPbFragment.this.cIe().getPbData().cGN().aSp() != null) {
                                TiebaStatic.log(new ao("c13402").dk("tid", VideoPbFragment.this.cIe().cJZ()).dk("fid", VideoPbFragment.this.cIe().getPbData().getForumId()).ag("obj_locate", 3).dk("uid", VideoPbFragment.this.cIe().getPbData().cGN().aSp().getUserId()));
                            }
                            if (VideoPbFragment.this.cIe().getPbData().cGN() != null && VideoPbFragment.this.cIe().getPbData().cGN().aSp() != null && VideoPbFragment.this.cIe().getPbData().cGN().aSp().getUserId() != null && VideoPbFragment.this.kfo != null) {
                                int h = VideoPbFragment.this.kxj.h(VideoPbFragment.this.cIe().getPbData());
                                bu cGN = VideoPbFragment.this.cIe().getPbData().cGN();
                                if (cGN.aQX()) {
                                    i2 = 2;
                                } else if (!cGN.aQY()) {
                                    if (cGN.aUl()) {
                                        i2 = 4;
                                    } else {
                                        i2 = cGN.aUm() ? 5 : 1;
                                    }
                                }
                                TiebaStatic.log(new ao("c12526").dk("tid", VideoPbFragment.this.cIe().cJZ()).ag("obj_locate", 1).dk("obj_id", VideoPbFragment.this.cIe().getPbData().cGN().aSp().getUserId()).ag("obj_type", VideoPbFragment.this.kfo.aOo() ? 0 : 1).ag("obj_source", h).ag("obj_param1", i2));
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.sM(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.cIe() != null && VideoPbFragment.this.kxj != null && VideoPbFragment.this.dSy != null && VideoPbFragment.this.cIe().getPbData() != null && VideoPbFragment.this.cIe().getPbData().cGN() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.cIe().getPbData();
                        if (pbData.cGN().aSg() != 0) {
                            int currentItem = VideoPbFragment.this.dSy.getCurrentItem();
                            if (currentItem == VideoPbFragment.kwO) {
                                VideoPbFragment.this.dSy.setCurrentItem(VideoPbFragment.kwP);
                            } else if (currentItem == VideoPbFragment.kwP) {
                                if (VideoPbFragment.this.cPx() != null && VideoPbFragment.this.cbh() != null) {
                                    ao dk = new ao("c13403").dk("tid", VideoPbFragment.this.cIe().cJZ()).dk("fid", VideoPbFragment.this.cIe().getPbData().getForumId()).dk("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView cbh = VideoPbFragment.this.cbh();
                                    boolean canScrollVertically = cbh.canScrollVertically(1);
                                    boolean canScrollVertically2 = cbh.canScrollVertically(-1);
                                    if (VideoPbFragment.this.WW != null) {
                                        VideoPbFragment.this.WW.setExpanded(false, true);
                                    }
                                    if (cbh.getLayoutManager() != null && (cbh.getLayoutManager() instanceof LinearLayoutManager)) {
                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) cbh.getLayoutManager();
                                        if (!canScrollVertically2 && canScrollVertically) {
                                            if (VideoPbFragment.this.kfi != -1 || VideoPbFragment.this.kfj != Integer.MIN_VALUE) {
                                                if (VideoPbFragment.this.kfi > 3 || (VideoPbFragment.this.kfi == 3 && VideoPbFragment.this.kfj < (-equipmentHeight))) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.kfi, VideoPbFragment.this.kfj + equipmentHeight);
                                                    cbh.smoothScrollBy(0, equipmentHeight);
                                                } else if (VideoPbFragment.this.kfi >= 2) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.kfi, VideoPbFragment.this.kfj + (equipmentHeight / 2));
                                                    cbh.smoothScrollBy(0, equipmentHeight / 2);
                                                } else if (VideoPbFragment.this.kfi == 1) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.kfi, VideoPbFragment.this.kfj + (equipmentHeight / 4));
                                                    cbh.smoothScrollBy(0, equipmentHeight / 4);
                                                } else {
                                                    cbh.smoothScrollBy(0, -VideoPbFragment.this.kfj);
                                                }
                                                dk.ag("obj_locate", 2);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            int firstVisiblePosition = cbh.getFirstVisiblePosition();
                                            View childAt = cbh.getChildAt(0);
                                            int top2 = childAt == null ? 0 : childAt.getTop();
                                            VideoPbFragment.this.kfi = firstVisiblePosition;
                                            VideoPbFragment.this.kfj = top2;
                                            if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top2 < (-equipmentHeight) && cbh.getCount() >= 6)) {
                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                cbh.smoothScrollToPosition(0);
                                            } else {
                                                cbh.smoothScrollToPosition(0);
                                            }
                                            dk.ag("obj_locate", 1);
                                        }
                                        TiebaStatic.log(dk);
                                        TiebaStatic.log(new ao("c12942").ag("obj_type", 1).ag("obj_locate", 4).dk("tid", VideoPbFragment.this.cIe().cJZ()).dk("nid", pbData.cGN().getNid()));
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null && VideoPbFragment.this.cIe().getPbData().cGN() != null && VideoPbFragment.this.cIe().getPbData().cGN().aSp() != null) {
                                TiebaStatic.log(new ao("c13402").dk("tid", VideoPbFragment.this.cIe().cJZ()).dk("fid", VideoPbFragment.this.cIe().getPbData().getForumId()).ag("obj_locate", 2).dk("uid", VideoPbFragment.this.cIe().getPbData().cGN().aSp().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.sN(false);
                        VideoPbFragment.this.cJa();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.kfQ >= 0) {
                        if (VideoPbFragment.this.cIe() != null) {
                            VideoPbFragment.this.cIe().cKK();
                        }
                        if (VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cPx() != null && VideoPbFragment.this.cPx().cQj() != null) {
                            VideoPbFragment.this.cPx().cQj().setData(VideoPbFragment.this.cIe().getPbData());
                        }
                        VideoPbFragment.this.kfQ = 0;
                        VideoPbFragment.this.kxl = Integer.MIN_VALUE;
                        if (VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cPx() != null) {
                            VideoPbFragment.this.cPx().cM(VideoPbFragment.this.cIe().cKN(), VideoPbFragment.this.cIe().cKO());
                            VideoPbFragment.this.cIe().cJ(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.cIe() != null) {
                        ao aoVar5 = new ao("c13398");
                        aoVar5.dk("tid", VideoPbFragment.this.cIe().cJZ());
                        aoVar5.dk("fid", VideoPbFragment.this.cIe().getForumId());
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
                        VideoPbFragment.this.cLN();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.cLN();
                } else if (VideoPbFragment.this.kxj.cNG() != null && view == VideoPbFragment.this.kxj.cNG().cLo()) {
                    VideoPbFragment.this.kxj.cMB();
                    if (VideoPbFragment.this.cIe() != null) {
                        VideoPbFragment.this.gRZ.setThreadId(VideoPbFragment.this.cIe().cJZ());
                    }
                    if (VideoPbFragment.this.cIe() == null || !VideoPbFragment.this.cIe().isPrivacy()) {
                        VideoPbFragment.this.gRZ.bNV();
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
                VideoPbFragment.this.kxj.cMB();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.cIe() == null || VideoPbFragment.this.cIe().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.bYw();
                VideoPbFragment.this.cMi();
                if (VideoPbFragment.this.cIe().getPbData() != null && VideoPbFragment.this.cIe().getPbData().jYL != null && VideoPbFragment.this.cIe().getPbData().jYL.size() > i) {
                    int intValue = VideoPbFragment.this.cIe().getPbData().jYL.get(i).sort_type.intValue();
                    TiebaStatic.log(new ao("c13699").dk("tid", VideoPbFragment.this.cIe().cKa()).dk("fid", VideoPbFragment.this.cIe().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", Bn(intValue)));
                    if (VideoPbFragment.this.cIe().Bu(intValue)) {
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
    public void cJk() {
        if (cIe() != null && cIe().getPbData() != null && cIe().getPbData().cGN() != null) {
            bu cGN = cIe().getPbData().cGN();
            cGN.mRecomAbTag = cIe().cKU();
            cGN.mRecomWeight = cIe().cKS();
            cGN.mRecomSource = cIe().cKT();
            cGN.mRecomExtra = cIe().cKV();
            if (cGN.getFid() == 0) {
                cGN.setFid(com.baidu.adp.lib.f.b.toLong(cIe().getForumId(), 0L));
            }
            ao a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cGN, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rG(boolean z) {
        if (cIe() != null && cIe().getPbData() != null && cIe().getPbData().cGN() != null) {
            bu cGN = cIe().getPbData().cGN();
            cGN.mRecomAbTag = cIe().cKU();
            cGN.mRecomWeight = cIe().cKS();
            cGN.mRecomSource = cIe().cKT();
            cGN.mRecomExtra = cIe().cKV();
            if (cGN.getFid() == 0) {
                cGN.setFid(com.baidu.adp.lib.f.b.toLong(cIe().getForumId(), 0L));
            }
            ao a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cGN, "c13563");
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
                    ArrayList<PostData> cGP = cIe().getPbData().cGP();
                    int size = cGP.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cGP.get(i).getId())) {
                            i++;
                        } else {
                            cGP.remove(i);
                            break;
                        }
                    }
                    cIe().getPbData().cGN().kG(cIe().getPbData().cGN().aSg() - 1);
                    if (cPx() != null) {
                        cPx().cQi();
                    }
                } else if (bVar.hhf == 0) {
                    cJl();
                } else if (bVar.hhf == 2) {
                    ArrayList<PostData> cGP2 = cIe().getPbData().cGP();
                    int size2 = cGP2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cGP2.get(i2).dhV().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cGP2.get(i2).dhV().get(i3).getId())) {
                                i3++;
                            } else {
                                cGP2.get(i2).dhV().remove(i3);
                                cGP2.get(i2).dhX();
                                z2 = true;
                                break;
                            }
                        }
                        cGP2.get(i2).Nf(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3 && cPx() != null) {
                        cPx().cQi();
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = cIe().getPbData().cHb().kao;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dhV().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dhV().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dhV().remove(i2);
                    list.get(i).dhX();
                    z = true;
                    break;
                }
            }
            list.get(i).Nf(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2 && cPx() != null) {
            cPx().cQi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && cIe() != null && cIe().getPbData() != null && cIe().getPbData().cGN() != null) {
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
                    cIe().getPbData().cGN().kJ(1);
                    cIe().setIsGood(1);
                } else if (i == 3) {
                    cIe().getPbData().cGN().kJ(0);
                    cIe().setIsGood(0);
                } else if (i == 4) {
                    cIe().getPbData().cGN().kI(1);
                    cIe().Bo(1);
                } else if (i == 5) {
                    cIe().getPbData().cGN().kI(0);
                    cIe().Bo(0);
                }
            }
            if (cIe().getPbData().cGN() != null && cPy() != null) {
                cPy().cQf();
            }
        }
    }

    private void cJl() {
        if (cIe().cKc() || cIe().cKe()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", cIe().cJZ());
            PbActivity pbActivity = this.keN;
            PbActivity pbActivity2 = this.keN;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, cIe().cJZ()));
        if (cJo()) {
            this.keN.finish();
        }
    }

    private boolean cJo() {
        if (cIe() == null) {
            return true;
        }
        if (cIe().getPbData() == null || !cIe().getPbData().cHp()) {
            if (cIe().aOo()) {
                final MarkData cKt = cIe().cKt();
                if (cKt == null || !cIe().getIsFromMark() || cbh() == null) {
                    return true;
                }
                final MarkData Bv = cIe().Bv(cbh().getFirstVisiblePosition());
                if (Bv == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cKt);
                    this.keN.setResult(-1, intent);
                    return true;
                } else if (Bv.getPostId() == null || Bv.getPostId().equals(cKt.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cKt);
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
                            cKt.setPostId(Bv.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cKt);
                            VideoPbFragment.this.keN.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cIr();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cKt);
                            VideoPbFragment.this.keN.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cIr();
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
            } else if (cIe().getPbData() == null || cIe().getPbData().cGP() == null || cIe().getPbData().cGP().size() <= 0 || !cIe().getIsFromMark()) {
                return true;
            } else {
                this.keN.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIr() {
        this.keN.cIr();
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
        if (cIe() != null && this.kxj != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = cIe().getPbData()) != null) {
                bu cGN = pbData.cGN();
                if (cGN != null && cGN.aSp() != null) {
                    TiebaStatic.log(new ao("c13402").dk("tid", cIe().cJZ()).dk("fid", pbData.getForumId()).ag("obj_locate", 4).dk("uid", cGN.aSp().getUserId()));
                }
                if (cGN != null) {
                    if (cGN.aQX()) {
                        i = 2;
                    } else if (cGN.aQY()) {
                        i = 3;
                    } else if (cGN.aUl()) {
                        i = 4;
                    } else if (cGN.aUm()) {
                        i = 5;
                    }
                    ao aoVar = new ao(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    aoVar.dk("tid", cIe().cJZ());
                    aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                    aoVar.dk("fid", cIe().getForumId());
                    if (!z) {
                        aoVar.ag("obj_locate", 6);
                    } else {
                        aoVar.ag("obj_locate", 5);
                    }
                    aoVar.ag("obj_name", i);
                    aoVar.ag("obj_type", 2);
                    if (cGN != null) {
                        if (cGN.aQX()) {
                            aoVar.ag("obj_type", 10);
                        } else if (cGN.aQY()) {
                            aoVar.ag("obj_type", 9);
                        } else if (cGN.aUm()) {
                            aoVar.ag("obj_type", 8);
                        } else if (cGN.aUl()) {
                            aoVar.ag("obj_type", 7);
                        } else if (cGN.isShareThread) {
                            aoVar.ag("obj_type", 6);
                        } else if (cGN.threadType == 0) {
                            aoVar.ag("obj_type", 1);
                        } else if (cGN.threadType == 40) {
                            aoVar.ag("obj_type", 2);
                        } else if (cGN.threadType == 49) {
                            aoVar.ag("obj_type", 3);
                        } else if (cGN.threadType == 54) {
                            aoVar.ag("obj_type", 4);
                        } else {
                            aoVar.ag("obj_type", 5);
                        }
                        aoVar.dk("nid", cGN.getNid());
                        aoVar.ag(IntentConfig.CARD_TYPE, cGN.aUp());
                        aoVar.dk(IntentConfig.RECOM_SOURCE, cGN.mRecomSource);
                        aoVar.dk("ab_tag", cGN.mRecomAbTag);
                        aoVar.dk("weight", cGN.mRecomWeight);
                        aoVar.dk("extra", cGN.mRecomExtra);
                        aoVar.dk("nid", cGN.getNid());
                        if (cGN.getBaijiahaoData() != null && !ar.isEmpty(cGN.getBaijiahaoData().oriUgcVid)) {
                            aoVar.dk("obj_param6", cGN.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        aoVar.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (cJI() != null) {
                        com.baidu.tbadk.pageInfo.c.b(cJI(), aoVar);
                    }
                    TiebaStatic.log(aoVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (cIe().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> cGP = pbData.cGP();
                        if ((cGP == null || cGP.size() <= 0) && cIe().cKb()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.kxj.cMB();
                        bYw();
                        TiebaStatic.log(new ao("c11939"));
                        if (!AntiHelper.d(getContext(), cGN)) {
                            if (this.kmS != null) {
                                this.kmS.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                Bl(z ? 2 : 1);
                                return;
                            }
                            this.kxj.showLoadingDialog();
                            cIe().cKE().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                ao aoVar2 = new ao(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aoVar2.dk("tid", cIe().cJZ());
                aoVar2.dk("uid", TbadkCoreApplication.getCurrentAccount());
                aoVar2.dk("fid", cIe().getForumId());
                if (!z) {
                }
                aoVar2.ag("obj_name", i);
                aoVar2.ag("obj_type", 2);
                if (cGN != null) {
                }
                if (!ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (cJI() != null) {
                }
                TiebaStatic.log(aoVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment cPe() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        J(eVar.cPJ());
        K(eVar.cPJ());
        if (cIe() != null && cIe().getPbData() != null) {
            boolean isFromMark = cIe().getIsFromMark();
            com.baidu.tieba.pb.data.e pbData = cIe().getPbData();
            if (isFromMark) {
                PostData I = I(pbData);
                if (pbData.aOn() != null && !pbData.aOn().equals(I.getId()) && this.dSy != null) {
                    this.dSy.setCurrentItem(kwP);
                }
            }
        }
        eVar.cPK().observe(this, new q<bu>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
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
                            VideoPbFragment.this.cPf();
                            VideoPbFragment.this.aO(buVar);
                        }
                        VideoPbFragment.this.cPg();
                        if (VideoPbFragment.this.kwX.cPX()) {
                            VideoPbFragment.this.kwX.start();
                        }
                        boolean z = !ar.equals(VideoPbFragment.this.kwW.getVideoUrl(), buVar.aSH().video_url);
                        VideoPbFragment.this.kwW.setData(buVar);
                        VideoPbFragment.this.kwW.sV(VideoPbFragment.this.dSy.getCurrentItem() == 0);
                        if (z) {
                            VideoPbFragment.this.kwW.startPlay();
                            VideoPbFragment.this.kwW.cQC();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.kwW.setData(buVar);
                }
            }
        });
        eVar.cPT().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: q */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.dSy.setCurrentItem(num.intValue());
            }
        });
        eVar.cPO().observe(this, new q<bu>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aP */
            public void onChanged(@Nullable bu buVar) {
                VideoPbFragment.this.kwW.aT(buVar);
            }
        });
        eVar.cPP().observe(this, new q<bu>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aP */
            public void onChanged(@Nullable bu buVar) {
                VideoPbFragment.this.kwW.aU(buVar);
            }
        });
        eVar.cPQ().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.cPq();
            }
        });
        eVar.cPR().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPf() {
        ViewGroup.LayoutParams layoutParams = this.kwZ.getLayoutParams();
        layoutParams.height = 0;
        this.kwZ.setLayoutParams(layoutParams);
        this.kwZ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPg() {
        if (this.kwX == null) {
            this.kwX = new f(getBaseFragmentActivity(), this.kwV);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(cJI()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.kwV.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.kwX.b(eVar.cPL(), rect);
            if (this.kwX.cPX()) {
                this.kwX.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (eVar.cPM() || VideoPbFragment.this.cIe().getTabIndex() == VideoPbFragment.kwP) {
                            VideoPbFragment.this.dSy.setCurrentItem(VideoPbFragment.kwP);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (eVar.cPM() || VideoPbFragment.this.cIe().getTabIndex() == VideoPbFragment.kwP) {
                            VideoPbFragment.this.dSy.setCurrentItem(VideoPbFragment.kwP);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (eVar.cPM() || cIe().getTabIndex() == kwP) {
                this.dSy.setCurrentItem(kwP);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.kxp && (this.kxq || cPD())) {
            cPC();
            UtilHelper.hideStatusBar(cJI(), cJI().getRootView());
            this.kxq = false;
            if (this.kwW != null) {
                this.kwW.sO(false);
            }
        }
        if (i == 4) {
            return this.kwW.cWg();
        }
        if (i == 24) {
            return this.kwW.cQz();
        }
        if (i == 25) {
            return this.kwW.cQA();
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
        Rect cKW;
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
                int height = (cIe() != null || (cKW = cIe().cKW()) == null) ? ceil : cKW.height();
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
        if (cIe() != null) {
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
        com.baidu.tieba.s.c.dgX().z(getUniqueId());
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
        this.kfD.a(cIe().cKp(), cIe().cJZ(), cIe().cKG());
        registerListener(this.kga);
        registerListener(this.kgr);
        registerListener(this.kfZ);
        registerListener(this.kfX);
        registerListener(this.hBf);
        if (!cIe().cKg()) {
            this.kfD.yC(cIe().cJZ());
        }
        if (cIe().cKH()) {
            this.kfD.yA(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.kfD.yA(cLP());
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
                    } else if (i == ak.dUx && VideoPbFragment.this.knu != null && VideoPbFragment.this.knu.cIO() != null) {
                        VideoPbFragment.this.knu.cIO().bfX();
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
        this.kwW.cR(cJI().getRootView());
        this.kwW.cS(this.kwY);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.kwR = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.kwZ = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.dSy = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.kwU = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.kwU.setOnClickListener(this.aXG);
        cPi();
        cPh();
        cPj();
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
                    if (VideoPbFragment.this.cPx() != null) {
                        VideoPbFragment.this.cPx().sU(false);
                    }
                    if (VideoPbFragment.this.cPy() != null) {
                        VideoPbFragment.this.cPy().sU(true);
                        VideoPbFragment.this.BT(VideoPbFragment.this.cPy().cQh() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.cPQ() != null && eVar.cPQ().getValue() != null && eVar.cPQ().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.kwW.sV(z);
                    VideoPbFragment.this.cLN();
                    if (VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null) {
                        TiebaStatic.log(new ao("c13592").dk("tid", VideoPbFragment.this.cIe().cJZ()).dk("fid", VideoPbFragment.this.cIe().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.cPy() != null) {
                        VideoPbFragment.this.cPy().sU(false);
                    }
                    if (VideoPbFragment.this.cPx() != null) {
                        VideoPbFragment.this.cPx().sU(true);
                        int cQh = VideoPbFragment.this.cPx().cQh();
                        int cQm = VideoPbFragment.this.cPx().cQm();
                        if (cQh != 0) {
                            VideoPbFragment.this.BT(8);
                            VideoPbFragment.this.cPx().BT(0);
                        } else if (cQm != 0) {
                            VideoPbFragment.this.cPx().BT(8);
                            VideoPbFragment.this.BT(0);
                        } else {
                            VideoPbFragment.this.cPx().BT(8);
                            VideoPbFragment.this.BT(8);
                        }
                    }
                    VideoPbFragment.this.kwW.sV(false);
                    VideoPbFragment.this.WW.setExpanded(false, true);
                    if (VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null) {
                        TiebaStatic.log(new ao("c13593").dk("tid", VideoPbFragment.this.cIe().cJZ()).dk("fid", VideoPbFragment.this.cIe().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.kwS.BV(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.kmu = this.rootView.findViewById(R.id.viewstub_progress);
        cPk();
        byj();
        if (!this.kxp && this.kxq) {
            cPC();
            UtilHelper.hideStatusBar(cJI(), cJI().getRootView());
            this.kxq = false;
        }
    }

    private void cPh() {
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
                if (VideoPbFragment.this.jZw == null || VideoPbFragment.this.jZw.cQq()) {
                    if (VideoPbFragment.this.jZw != null) {
                        TiebaStatic.log(new ao("c13608").dk("tid", VideoPbFragment.this.cIe().getPbData().getThreadId()));
                        VideoPbFragment.this.jZw.kyX = true;
                    }
                } else {
                    TiebaStatic.log(new ao("c13591"));
                }
                VideoPbFragment.this.cPs();
            }
        });
        this.kxe.setOnClickListener(this.kxa);
        this.kwZ.setOnClickListener(this.kxa);
    }

    private void cPi() {
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

    private void cPj() {
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
                VideoPbFragment.this.cJa();
                if (VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null && VideoPbFragment.this.cIe().getPbData().cGN() != null && VideoPbFragment.this.cIe().getPbData().cGN().aSp() != null) {
                    if (com.baidu.tbadk.a.d.aNW()) {
                        TiebaStatic.log(new ao("c13701").dk("tid", VideoPbFragment.this.cIe().cKa()).dk("fid", VideoPbFragment.this.cIe().getPbData().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    }
                    TiebaStatic.log(new ao("c13402").dk("tid", VideoPbFragment.this.cIe().cJZ()).dk("fid", VideoPbFragment.this.cIe().getPbData().getForumId()).ag("obj_locate", 1).dk("uid", VideoPbFragment.this.cIe().getPbData().cGN().aSp().getUserId()));
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
        this.kmS.cQM();
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
                VideoPbFragment.this.bYx();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.kwY = this.rootView.findViewById(R.id.status_bar_background);
        if (this.kxp) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(cJI());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.kwY.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(cJI());
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

    public void cPk() {
        setEditorTools(this.kfD.bfa());
    }

    private void byj() {
        this.keK = new PbFakeFloorModel(getPageContext());
        this.knu = new t(getPageContext(), this.keK, this.rootView);
        this.knu.a(this.kgo);
        this.keK.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.keK.t(postData);
                if (VideoPbFragment.this.cPx() != null) {
                    VideoPbFragment.this.cPx().cQi();
                }
                VideoPbFragment.this.knu.cIK();
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
        if (cIe() != null) {
            cIe().aC(bundle);
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
        if (cIe() != null && !cIe().cKg()) {
            this.kfD.yB(cIe().cJZ());
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
        cJE();
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
        com.baidu.tieba.s.c.dgX().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dgX().A(getUniqueId());
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
        if (cIe() != null) {
            cIe().cancelLoadData();
            cIe().destory();
            if (cIe().cKD() != null) {
                cIe().cKD().onDestroy();
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
        if (this.kmQ != null && cIe() != null) {
            if (cIe().aOo()) {
                SvgManager.aWQ().a(this.kmQ, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aWQ().a(this.kmQ, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.kmP != null) {
            SvgManager.aWQ().a(this.kmP, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (cIe() != null) {
            x(cIe().getPbData());
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
        if (cPx() != null) {
            cPx().onChangeSkinType(i);
        }
        if (cPy() != null) {
            cPy().onChangeSkinType(i);
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
    public void bYw() {
        if (this.hzJ != null) {
            this.hzJ.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cJG() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cJH() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel cIe() {
        return this.keN.cIe();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cJI() {
        return this.keN;
    }

    public com.baidu.tbadk.baseEditMark.a cPl() {
        return this.kfo;
    }

    public View.OnClickListener cPm() {
        return this.aXG;
    }

    public View.OnClickListener cPn() {
        return this.kcu;
    }

    public View.OnLongClickListener cPo() {
        return this.kxj.cPo();
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

    public BdTypeRecyclerView cbh() {
        Iterator<BaseFragment> it = this.kwS.cPH().iterator();
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
                this.kxj.cMB();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.kxj.cMC();
            } else {
                this.kxj.cMB();
            }
        }
    }

    public boolean Bj(int i) {
        if (this.jhL == null || cIe() == null || cIe().getPbData() == null || cIe().getPbData().getAnti() == null) {
            return true;
        }
        return this.jhL.aF(cIe().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean cJc() {
        if ((cIe() != null && cIe().getPbData().cHp()) || this.jhL == null || cIe() == null || cIe().getPbData() == null || cIe().getPbData().getAnti() == null) {
            return true;
        }
        return this.jhL.lp(cIe().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && cIe() != null) {
            gVar.setForumName(cIe().cHV());
            if (cIe().getPbData() != null && cIe().getPbData().getForum() != null) {
                gVar.a(cIe().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(cIe());
        }
    }

    public void cMd() {
        if (this.ZX != null) {
            this.ZX.display();
            if (this.kfD != null) {
                this.kfD.bfF();
            }
            cML();
        }
    }

    public com.baidu.tbadk.editortools.pb.e cIP() {
        return this.kfD;
    }

    private boolean cIZ() {
        PbModel cIe = cIe();
        if (cIe == null || cIe.getPbData() == null) {
            return false;
        }
        bu cGN = cIe.getPbData().cGN();
        cIe.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cGN);
    }

    public void cJa() {
        if (checkUpIsLogin() && cIe() != null && cIe().getPbData() != null && cIe().getPbData().getForum() != null && !cIZ()) {
            if (cIe().getPbData().cHp()) {
                ckJ();
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
                            VideoPbFragment.this.ckJ();
                        }
                    }
                });
            }
            this.hDN.D(cIe().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cIe().cJZ(), 0L));
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
                    cJm();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cYy().G(getPageContext());
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
        if (cJI() != null) {
            if (this.kxq && !TbSingleton.getInstance().isNotchScreen(cJI()) && !TbSingleton.getInstance().isCutoutScreen(cJI())) {
                cPC();
                UtilHelper.hideStatusBar(cJI(), cJI().getRootView());
                this.kxq = false;
            }
            this.kxk.kxF = z;
            cPp();
            cPq();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.keN;
        if (i == 0) {
            cLJ();
            if (this.knu != null) {
                this.knu.cIK();
            }
            so(false);
        }
        cLN();
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
                        if (this.knu != null && this.knu.cIO() != null) {
                            h cIO = this.knu.cIO();
                            cIO.setThreadData(cIe().getPbData().cGN());
                            cIO.b(writeData);
                            cIO.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l nB2 = cIO.bfa().nB(6);
                            if (nB2 != null && nB2.etH != null) {
                                nB2.etH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.keN;
                            if (i == -1) {
                                cIO.bfX();
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
                if (cIe() != null && !cIe().cKg()) {
                    antiData.setBlock_forum_name(cIe().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(cIe().getPbData().getForum().getId());
                    antiData.setUser_name(cIe().getPbData().getUserData().getUserName());
                    antiData.setUser_id(cIe().getPbData().getUserData().getUserId());
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
    private void cJK() {
        if (cIe() != null && this.keN != null) {
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
                if (!cIe().cKg()) {
                    this.kfD.yC(cIe().cJZ());
                }
                if (cIe().cKH()) {
                    this.kfD.yA(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.kfD.yA(cLP());
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
        cLJ();
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
                if (VideoPbFragment.this.kfu != null && VideoPbFragment.this.kfu.cNa() != null) {
                    if (!VideoPbFragment.this.kfu.cNa().dqL()) {
                        VideoPbFragment.this.kfu.st(false);
                    }
                    VideoPbFragment.this.kfu.cNa().vF(false);
                }
            }
        });
    }

    public void ckJ() {
        if (!checkUpIsLogin()) {
            if (cIe() != null) {
                TiebaStatic.log(new ao("c10517").ag("obj_locate", 2).dk("fid", cIe().getForumId()));
            }
        } else if (cJc()) {
            if (this.kfD != null && (this.kfD.bfP() || this.kfD.bfQ())) {
                this.kfD.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.ZX != null) {
                cMd();
                this.kxk.kxE = false;
                if (this.ZX.nB(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.ZX.nB(2).etH, false, null);
                }
            }
            cML();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cIZ() && cJc()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.kfg);
                this.kfh = ((View) view.getParent()).getMeasuredHeight();
            }
            if (cIe() != null && cIe().getPbData() != null && cIe().getPbData().cHp()) {
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
                        VideoPbFragment.this.cbh().smoothScrollBy(0, (VideoPbFragment.this.kfg[1] + VideoPbFragment.this.kfh) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.knu != null) {
                            VideoPbFragment.this.kfD.bfa().setVisibility(8);
                            VideoPbFragment.this.knu.g(str, str2, VideoPbFragment.this.cLP(), (VideoPbFragment.this.cIe() == null || VideoPbFragment.this.cIe().getPbData() == null || VideoPbFragment.this.cIe().getPbData().cGN() == null || !VideoPbFragment.this.cIe().getPbData().cGN().isBjh()) ? false : true);
                            h cIO = VideoPbFragment.this.knu.cIO();
                            if (cIO != null && VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null) {
                                cIO.a(VideoPbFragment.this.cIe().getPbData().getAnti());
                                cIO.setThreadData(VideoPbFragment.this.cIe().getPbData().cGN());
                            }
                            if (VideoPbFragment.this.kfu.cNc() == null && VideoPbFragment.this.knu.cIO().bgf() != null) {
                                VideoPbFragment.this.knu.cIO().bgf().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kfu != null && VideoPbFragment.this.kfu.cNb() != null) {
                                            if (!VideoPbFragment.this.kfu.cNb().dqL()) {
                                                VideoPbFragment.this.kfu.su(false);
                                            }
                                            VideoPbFragment.this.kfu.cNb().vF(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kfu.f(VideoPbFragment.this.knu.cIO().bgf().getInputView());
                                VideoPbFragment.this.knu.cIO().a(VideoPbFragment.this.kfI);
                            }
                        }
                        VideoPbFragment.this.cML();
                    }
                }, 0L);
                return;
            }
            if (this.kfF == null) {
                this.kfF = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.kfF.vG(1);
                this.kfF.a(new AnonymousClass44(str, str2));
            }
            if (cIe() != null && cIe().getPbData() != null && cIe().getPbData().getForum() != null) {
                this.kfF.D(cIe().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cIe().cJZ(), 0L));
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
                        VideoPbFragment.this.cbh().smoothScrollBy(0, (VideoPbFragment.this.kfg[1] + VideoPbFragment.this.kfh) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.knu != null) {
                            VideoPbFragment.this.kfD.bfa().setVisibility(8);
                            VideoPbFragment.this.knu.g(AnonymousClass44.this.kgN, AnonymousClass44.this.kgO, VideoPbFragment.this.cLP(), (VideoPbFragment.this.cIe() == null || VideoPbFragment.this.cIe().getPbData() == null || VideoPbFragment.this.cIe().getPbData().cGN() == null || !VideoPbFragment.this.cIe().getPbData().cGN().isBjh()) ? false : true);
                            h cIO = VideoPbFragment.this.knu.cIO();
                            if (cIO != null && VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null) {
                                cIO.a(VideoPbFragment.this.cIe().getPbData().getAnti());
                                cIO.setThreadData(VideoPbFragment.this.cIe().getPbData().cGN());
                            }
                            if (VideoPbFragment.this.kfu.cNc() == null && VideoPbFragment.this.knu.cIO().bgf() != null) {
                                VideoPbFragment.this.knu.cIO().bgf().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kfu != null && VideoPbFragment.this.kfu.cNb() != null) {
                                            if (!VideoPbFragment.this.kfu.cNb().dqL()) {
                                                VideoPbFragment.this.kfu.su(false);
                                            }
                                            VideoPbFragment.this.kfu.cNb().vF(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kfu.f(VideoPbFragment.this.knu.cIO().bgf().getInputView());
                                VideoPbFragment.this.knu.cIO().a(VideoPbFragment.this.kfI);
                            }
                        }
                        VideoPbFragment.this.cML();
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cHc()));
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cHc()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bq> cHj = eVar.cHj();
                if (w.getCount(cHj) > 0) {
                    sb = new StringBuilder();
                    for (bq bqVar : cHj) {
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
    public void cJm() {
        MarkData Bv;
        if (cIe() != null && cIe().getPbData() != null && cPx() != null && this.kfo != null) {
            if (cIe().getPbData() != null && cIe().getPbData().cHp()) {
                Bv = cIe().Bv(0);
            } else if (this.dSy != null && this.dSy.getCurrentItem() == kwO) {
                Bv = cIe().o(I(cIe().getPbData()));
            } else {
                Bv = cIe().Bv(cPx().cMn());
            }
            if (Bv != null) {
                if (!Bv.isApp() || (Bv = cIe().Bv(cPx().cMn() + 1)) != null) {
                    cMi();
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
            this.kfe.a(emotionImageData, cIe(), cIe().getPbData());
        }
    }

    public PostData I(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.cHa() != null) {
            return eVar.cHa();
        }
        if (!w.isEmpty(eVar.cGP())) {
            Iterator<PostData> it = eVar.cGP().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dhY() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.cGW();
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
        if (eVar == null || eVar.cGN() == null || eVar.cGN().aSp() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aSp = eVar.cGN().aSp();
        String userId = aSp.getUserId();
        HashMap<String, MetaData> userMap = eVar.cGN().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aSp;
        }
        postData.EW(1);
        postData.setId(eVar.cGN().aSG());
        postData.setTitle(eVar.cGN().getTitle());
        postData.setTime(eVar.cGN().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cJr() {
        ArrayList<PostData> cGP;
        int count;
        int i;
        if (cIe() == null || cIe().getPbData() == null || cIe().getPbData().cGP() == null || (count = w.getCount((cGP = cIe().getPbData().cGP()))) == 0) {
            return "";
        }
        if (cIe().cKr()) {
            Iterator<PostData> it = cGP.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dhY() == 1) {
                    return next.getId();
                }
            }
        }
        if (cbh() == null) {
            i = 0;
        } else {
            i = cPx().cMm();
        }
        PostData postData = (PostData) w.getItem(cGP, i);
        if (postData == null || postData.aSp() == null) {
            return "";
        }
        if (cIe().JU(postData.aSp().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) w.getItem(cGP, i2);
            if (postData2 == null || postData2.aSp() == null || postData2.aSp().getUserId() == null) {
                break;
            } else if (cIe().JU(postData2.aSp().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) w.getItem(cGP, i3);
            if (postData3 == null || postData3.aSp() == null || postData3.aSp().getUserId() == null) {
                return "";
            }
            if (cIe().JU(postData3.aSp().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJn() {
        if (cIe() != null) {
            com.baidu.tieba.pb.data.e pbData = cIe().getPbData();
            cIe().rT(true);
            if (this.kfo != null) {
                pbData.JF(this.kfo.aOn());
            }
            if (cPx() != null) {
                cPx().cQi();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (cIe() != null) {
            cMk();
            cIe().rT(z);
            if (this.kfo != null) {
                this.kfo.gJ(z);
                if (markData != null) {
                    this.kfo.a(markData);
                }
            }
            if (cIe().aOo()) {
                cJn();
            } else if (cPx() != null) {
                cPx().cQi();
            }
        }
    }

    public void b(n nVar) {
        MetaData metaData;
        boolean z = true;
        if (cIe() != null && cIe().getPbData() != null && nVar.cHI() != null) {
            String id = nVar.cHI().getId();
            ArrayList<PostData> cGP = cIe().getPbData().cGP();
            int i = 0;
            while (true) {
                if (i >= cGP.size()) {
                    break;
                }
                PostData postData = cGP.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cHM = nVar.cHM();
                    postData.EV(nVar.getTotalCount());
                    if (postData.dhV() != null && cHM != null) {
                        Iterator<PostData> it = cHM.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aSp() != null && (metaData = postData.getUserMap().get(next.aSp().getUserId())) != null) {
                                next.a(metaData);
                                next.uJ(true);
                                next.a(getPageContext(), cIe().JU(metaData.getUserId()));
                            }
                        }
                        boolean z2 = cHM.size() != postData.dhV().size();
                        postData.dhV().clear();
                        postData.dhV().addAll(cHM);
                        z = z2;
                    }
                    if (postData.dhR() != null) {
                        postData.dhS();
                    }
                }
            }
            if (!cIe().getIsFromMark() && z && cPx() != null) {
                cPx().cQi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJe() {
        if (cIe() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.Mr(cIe().getForumId()) && cIe().getPbData() != null && cIe().getPbData().getForum() != null) {
            if (cIe().getPbData().getForum().isLike() == 1) {
                cIe().cKF().fq(cIe().getForumId(), cIe().cJZ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            bu cGN = eVar.cGN();
            if (cGN != null && cGN.aQZ()) {
                cJK();
            } else {
                d(this.kfC);
            }
            if (this.kfD != null) {
                sm(this.kfD.bfI());
                this.kfD.a(eVar.getAnti());
                this.kfD.a(eVar.getForum(), eVar.getUserData());
                this.kfD.setThreadData(cGN);
                if (cIe() != null) {
                    this.kfD.a(cIe().cKp(), cIe().cJZ(), cIe().cKG());
                }
                if (cGN != null) {
                    this.kfD.im(cGN.aTM());
                }
            }
        }
    }

    public void cLN() {
        reset();
        cLJ();
        this.knu.cIK();
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
        if (eVar != null && eVar.cGN() != null) {
            x(eVar);
            this.kmQ.setVisibility(eVar.cHp() ? 8 : 0);
            if (eVar.aOo()) {
                SvgManager.aWQ().a(this.kmQ, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aWQ().a(this.kmQ, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String BD = BD(eVar.cGN().aSg());
            if (this.kmT != null) {
                this.kmT.setText(BD);
            }
            if (this.kmU != null) {
                this.kmU.setText(BD);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.cGN()));
        }
    }

    public void x(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.ba(eVar.cGN())) {
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
            cPp();
            cPq();
        }
    }

    public void cML() {
        if (this.kmM != null) {
            this.kmL.setVisibility(8);
            this.kmM.setVisibility(8);
            this.kxk.kxE = false;
            cPp();
            cPq();
        }
    }

    private void cPp() {
        if (this.kwW != null) {
            if (this.kxk.cPG()) {
                this.kwW.tM(false);
            } else {
                this.kwW.tM(this.kwW.bAr() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPq() {
        if (this.kwW != null && this.dSy != null) {
            if (this.dSy.getCurrentItem() != 0) {
                this.kwW.sV(false);
            } else if (this.kxk.cPG()) {
                this.kwW.sV(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.kwW.sV(eVar.cPQ() == null || eVar.cPQ().getValue() == null || eVar.cPQ().getValue().booleanValue());
                }
            }
        }
    }

    private void Bl(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(cJI(), cJd(), i);
    }

    private int cJd() {
        if (cIe() == null || cIe().getPbData() == null || cIe().getPbData().cGN() == null) {
            return -1;
        }
        return cIe().getPbData().cGN().aTc();
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
            this.iyQ.setText(cLP());
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
            this.kxc.setText(aVar.cQn());
            String cQo = aVar.cQo();
            TBSpecificationBtn tBSpecificationBtn = this.kxe;
            if (TextUtils.isEmpty(cQo)) {
                cQo = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(cQo);
            this.kxf.startLoad(aVar.getImage(), 10, false);
            this.kxg.setVisibility(aVar.cQq() ? 0 : 8);
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.jZw == null || VideoPbFragment.this.jZw.cQq()) {
                        if (VideoPbFragment.this.jZw != null && VideoPbFragment.this.cIe() != null && VideoPbFragment.this.cIe().getPbData() != null && VideoPbFragment.this.cIe().getPbData().getForum() != null) {
                            TiebaStatic.log(new ao("c13712").dk("fid", VideoPbFragment.this.cIe().getPbData().getForum().getId()).dk("fname", VideoPbFragment.this.cIe().getPbData().getForum().getName()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("tid", VideoPbFragment.this.cIe().getPbData().getThreadId()).s("obj_param1", VideoPbFragment.this.jZw.userId));
                        }
                    } else {
                        TiebaStatic.log(new ao("c13608").dk("obj_id", VideoPbFragment.this.jZw.getTitle()).dk("obj_name", VideoPbFragment.this.jZw.cQn()).ag("obj_type", 2).dk("fid", VideoPbFragment.this.cIe().getPbData().getForumId()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("tid", VideoPbFragment.this.cIe().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.cPr();
                }
            }, aVar.cQp().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPr() {
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
    public void cPs() {
        if (this.kwZ.getLayoutParams() != null) {
            if (this.kxh == null || !this.kxh.isRunning()) {
                cPt();
            }
        }
    }

    private void cPt() {
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
                VideoPbFragment.this.cPu();
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
    public void cPu() {
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

    public String cLP() {
        if (!ar.isEmpty(this.knL)) {
            return this.knL;
        }
        this.knL = TbadkCoreApplication.getInst().getResources().getString(au.cLE());
        return this.knL;
    }

    public void cMk() {
        hideProgressBar();
        if (cPx() != null) {
            cPx().endLoadData();
            cPx().cMl();
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
                    if (cIe() == null || cIe().getPbData() == null) {
                        return true;
                    }
                    if (this.knu != null) {
                        this.knu.cIK();
                    }
                    n nVar = new n();
                    nVar.a(cIe().getPbData().getForum());
                    nVar.setThreadData(cIe().getPbData().cGN());
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

    public void cPv() {
        if (this.kfD != null) {
            sm(this.kfD.bfI());
        }
        cLN();
        this.kxj.cMB();
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

    public void crG() {
        if (this.kmu != null) {
            this.kmu.setVisibility(0);
        }
    }

    public void crF() {
        if (this.kmu != null) {
            this.kmu.setVisibility(8);
        }
    }

    public void BT(int i) {
        if (this.kwT != null) {
            this.kwT.setVisibility(i);
        }
    }

    public void cMi() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a cJh() {
        return this.kgq;
    }

    public void cLJ() {
        if (this.ZX != null) {
            this.ZX.hide();
        }
    }

    public void bYx() {
        if (this.keN.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.keN.getCurrentFocus());
        }
    }

    public void K(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cGN() != null) {
            String valueOf = String.valueOf(eVar.cGN().aSg());
            if (eVar.cGN().aSg() == 0) {
                valueOf = "";
            }
            this.kwR.zy(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        for (BaseFragment baseFragment : this.kwS.cPH()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, eVar, str, i4);
            }
        }
        b(z, i, i2, i3, eVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (cIe() != null && cIe().getPbData() != null && cIe().getPbData().cGN() != null && cIe().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(knn)).intValue();
                if (intValue == kno) {
                    if (!this.gRX.diL()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.gRX.Nj(ar.O(jSONArray));
                        }
                        this.gRX.a(cIe().getPbData().getForum().getId(), cIe().getPbData().getForum().getName(), cIe().getPbData().cGN().getId(), str, intValue3, intValue2, booleanValue, cIe().getPbData().cGN().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == knp || intValue == knr) {
                    if (cIe().cKC() != null) {
                        cIe().cKC().Bf(PbModel.UPGRADE_TO_PHOTO_LIVE);
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
    public int bly() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> blz() {
        if (this.eLl == null) {
            this.eLl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: blL */
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
    public com.baidu.adp.lib.d.b<TextView> blA() {
        if (this.eOC == null) {
            this.eOC = TbRichTextView.v(getPageContext().getPageActivity(), 8);
        }
        return this.eOC;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> blB() {
        if (this.eLm == null) {
            this.eLm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bST */
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
    public com.baidu.adp.lib.d.b<View> blC() {
        if (this.eOD == null) {
            this.eOD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cJL */
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
                    ((PlayVoiceBntNew) view).bCn();
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
    public com.baidu.adp.lib.d.b<LinearLayout> blD() {
        if (this.eOE == null) {
            this.eOE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cJN */
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
    public com.baidu.adp.lib.d.b<RelativeLayout> blE() {
        this.eOF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cJM */
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
        if (ba.Kg(str) && cIe() != null && cIe().cJZ() != null) {
            TiebaStatic.log(new ao("c11664").ag("obj_param1", 1).dk("post_id", cIe().cJZ()));
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
            ba.cNe().d(getPageContext(), str);
        }
        this.keY = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void am(Context context, String str) {
        ba.cNe().d(getPageContext(), str);
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
            com.baidu.tbadk.core.dialog.b cQa = this.kxj.cQa();
            if (cQa == null) {
                this.kxj.cIY();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                cQa.getItemView(1).setVisibility(8);
            } else {
                cQa.getItemView(1).setVisibility(0);
            }
            cQa.aUO();
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

    public com.baidu.tbadk.coreExtra.model.a cPw() {
        return this.dUB;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bja() {
        return this.eEC;
    }

    public ReplyFragment cPx() {
        if (this.kwS == null || !(this.kwS.BU(kwP) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.kwS.BU(kwP);
    }

    public DetailInfoFragment cPy() {
        if (this.kwS == null || !(this.kwS.BU(kwO) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.kwS.BU(kwO);
    }

    public boolean cHU() {
        PbModel cIe = this.keN.cIe();
        if (cIe == null) {
            return false;
        }
        return cIe.cHU();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cGZ;
        PbModel cIe = this.keN.cIe();
        if (cIe != null && cIe.getPbData() != null && !cIe.getPbData().cHp()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = cIe.getPbData().cGN().getId();
            if (cIe.isShareThread() && cIe.getPbData().cGN().dNX != null) {
                historyMessage.threadName = cIe.getPbData().cGN().dNX.showText;
            } else {
                historyMessage.threadName = cIe.getPbData().cGN().getTitle();
            }
            if (cIe.isShareThread() && !cHU()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = cIe.getPbData().getForum().getName();
            }
            ArrayList<PostData> cGP = cIe.getPbData().cGP();
            int cMm = cPx() != null ? cPx().cMm() : 0;
            if (cGP != null && cMm >= 0 && cMm < cGP.size()) {
                historyMessage.postID = cGP.get(cMm).getId();
            }
            historyMessage.isHostOnly = cIe.getHostMode();
            historyMessage.isSquence = cIe.cKb();
            historyMessage.isShareThread = cIe.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.kfD != null) {
            this.kfD.onDestroy();
        }
        if (cIe != null && (cIe.cKc() || cIe.cKe())) {
            Intent intent = new Intent();
            intent.putExtra("tid", cIe.cJZ());
            if (this.kfr) {
                if (this.kft) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", cIe.bRk());
                }
                if (this.kfs) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", cIe.getIsGood());
                }
            }
            if (cIe.getPbData() != null && System.currentTimeMillis() - this.keU >= 40000 && (cGZ = cIe.getPbData().cGZ()) != null && !w.isEmpty(cGZ.getDataList())) {
                intent.putExtra("guess_like_data", cGZ);
            }
            PbActivity pbActivity = this.keN;
            PbActivity pbActivity2 = this.keN;
            pbActivity.setResult(-1, intent);
        }
        if (cJo()) {
            if (cIe != null) {
                com.baidu.tieba.pb.data.e pbData = cIe.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.kfa) {
                        if (this.kwV != null) {
                            Rect rect = new Rect();
                            this.kwV.getGlobalVisibleRect(rect);
                            com.baidu.tieba.pb.pb.main.ao.cLt().h(rect);
                        }
                        com.baidu.tieba.pb.pb.main.ao.cLt().Bz(this.dSy.getCurrentItem());
                        BdTypeRecyclerView cbh = cbh();
                        Parcelable parcelable = null;
                        if (cbh != null) {
                            parcelable = cbh.onSaveInstanceState();
                        }
                        com.baidu.tieba.pb.pb.main.ao.cLt().a(cIe.cKj(), parcelable, cIe.cKb(), cIe.getHostMode(), false);
                    }
                }
            } else {
                com.baidu.tieba.pb.pb.main.ao.cLt().reset();
            }
            cIr();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.kwW != null && !this.kwW.bAr()) {
            if ((this.kwW.isFullScreen() && configuration.orientation == 1) || (!this.kwW.isFullScreen() && configuration.orientation == 2)) {
                this.kwW.sW(false);
            }
        }
    }

    public boolean cPz() {
        if (this.kwW == null) {
            return false;
        }
        return this.kwW.bAr();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.dgX().b(getUniqueId(), false);
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

        public boolean cPG() {
            return (this.kxE && this.kxF) ? false : true;
        }
    }

    public void cPA() {
        this.kfi = -1;
        this.kfj = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJE() {
        if (cIe() != null && !ar.isEmpty(cIe().cJZ())) {
            com.baidu.tbadk.BdToken.c.aMo().p(com.baidu.tbadk.BdToken.b.dyB, com.baidu.adp.lib.f.b.toLong(cIe().cJZ(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.kwU.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPB() {
        if (this.kxt == null) {
            this.kxt = ObjectAnimator.ofFloat(this.kwY, "alpha", 0.0f, 1.0f);
            this.kxt.setDuration(200L);
        }
        this.kxt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPC() {
        if (this.kxu == null) {
            this.kxu = ObjectAnimator.ofFloat(this.kwY, "alpha", 1.0f, 0.0f);
            this.kxu.setDuration(200L);
        }
        this.kxu.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cPD() {
        return this.kwW != null && this.kwW.cPE();
    }

    public boolean cPE() {
        return this.kxq;
    }

    public void sO(boolean z) {
        this.kxq = z;
    }
}
