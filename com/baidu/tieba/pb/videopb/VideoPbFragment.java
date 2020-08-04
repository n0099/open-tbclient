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
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
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
import com.baidu.tieba.pb.pb.main.ay;
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
/* loaded from: classes16.dex */
public class VideoPbFragment extends BaseFragment implements VoiceManager.c, TbRichTextView.c, i, com.baidu.tieba.pb.videopb.a, b {
    private AppBarLayout WP;
    private EditorTools ZS;
    private ImageView aeV;
    private CustomViewPager dYQ;
    public View eJG;
    private com.baidu.adp.lib.d.b<ImageView> eRG;
    private com.baidu.adp.lib.d.b<GifView> eRH;
    private com.baidu.adp.lib.d.b<TextView> eUX;
    private com.baidu.adp.lib.d.b<View> eUY;
    private com.baidu.adp.lib.d.b<LinearLayout> eUZ;
    private com.baidu.adp.lib.d.b<RelativeLayout> eVa;
    private ImageView fOc;
    private com.baidu.tieba.callfans.a gXE;
    private VoiceManager hFy;
    private com.baidu.tieba.frs.profession.permission.c hJL;
    private com.baidu.tieba.f.b hKk;
    public al jqz;
    public View kBn;
    private NewPagerSlidingTabBaseStrip kFN;
    private VideoPbFragmentAdapter kFO;
    private View kFP;
    private View kFQ;
    private VideoContainerLayout kFR;
    private com.baidu.tieba.pb.videopb.videoView.a kFS;
    private f kFT;
    private View kFU;
    private View kFV;
    private TextView kFX;
    private TextView kFY;
    private ImageView kFZ;
    private TBSpecificationBtn kGa;
    private TbImageView kGb;
    private View kGc;
    private ValueAnimator kGd;
    private ValueAnimator kGe;
    public com.baidu.tieba.pb.videopb.b.a kGf;
    private float kGj;
    private float kGk;
    private boolean kGl;
    private ObjectAnimator kGp;
    private ObjectAnimator kGq;
    private com.baidu.tieba.pb.videopb.c.a khZ;
    private PbActivity knE;
    private com.baidu.tieba.pb.pb.main.emotion.model.a knV;
    int knY;
    private PbFakeFloorModel knz;
    private com.baidu.tbadk.core.view.c koB;
    public bb kol;
    private g kot;
    private com.baidu.tbadk.editortools.pb.e kou;
    private com.baidu.tieba.frs.profession.permission.c kow;
    private EmotionImageData kox;
    private View kvK;
    private LinearLayout kvM;
    private HeadImageView kvN;
    private ImageView kvO;
    private ImageView kvP;
    private ImageView kvQ;
    private com.baidu.tieba.pb.view.c kvR;
    private TextView kvS;
    private TextView kvT;
    private int kvV;
    private int kvW;
    private View kvt;
    private String kwK;
    private v kwt;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int kFJ = 0;
    public static int kFK = 1;
    public static int kFL = 0;
    public static int kwl = 3;
    public static int kwm = 0;
    public static int kwn = 3;
    public static int kwo = 4;
    public static int kwp = 5;
    public static int kwq = 6;
    private static final int iBx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int kFM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a kpt = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void cg(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cLD();
            } else {
                com.baidu.tieba.pb.a.b.cLC();
            }
        }
    };
    private long knL = 0;
    View.OnClickListener kFW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.khZ == null || VideoPbFragment.this.khZ.cUh()) {
                if (VideoPbFragment.this.khZ != null) {
                    if (VideoPbFragment.this.khZ.isChushou) {
                        VideoPbFragment.this.dU(VideoPbFragment.this.khZ.thirdRoomId, VideoPbFragment.this.khZ.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.khZ.cUi();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null && VideoPbFragment.this.cLP().getPbData().getForum() != null) {
                        TiebaStatic.log(new ap("c13713").dn("fid", VideoPbFragment.this.cLP().getPbData().getForum().getId()).dn("fname", VideoPbFragment.this.cLP().getPbData().getForum().getName()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("tid", VideoPbFragment.this.cLP().getPbData().getThreadId()).t("obj_param1", VideoPbFragment.this.khZ.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new ap("c13590").dn("obj_id", VideoPbFragment.this.khZ.getTitle()).dn("obj_name", VideoPbFragment.this.khZ.cUe()).ah("obj_type", 2).dn("fid", VideoPbFragment.this.cLP().getPbData().getForumId()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("tid", VideoPbFragment.this.cLP().getPbData().getThreadId()));
            String link = VideoPbFragment.this.khZ.getLink();
            if (!TextUtils.isEmpty(link)) {
                if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                    bd.baV().b(VideoPbFragment.this.getPageContext(), new String[]{link});
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
    private com.baidu.tbadk.baseEditMark.a kof = null;
    private com.baidu.tbadk.coreExtra.model.a eaU = null;
    private ForumManageModel gXC = null;
    private boolean knP = false;
    private View kvL = null;
    private TextView iEW = null;
    private boolean kvH = false;
    private String eBU = null;
    private boolean koi = false;
    private boolean koj = false;
    private boolean kok = false;
    private boolean knR = false;
    int[] knX = new int[2];
    private int knZ = -1;
    private int koa = Integer.MIN_VALUE;
    private int koH = 0;
    private int kGh = Integer.MIN_VALUE;
    private boolean bjZ = false;
    private boolean klG = com.baidu.tbadk.a.d.aRO();
    private final PbModel.a kpj = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.g nQ;
            VideoPbFragment.this.cPX();
            VideoPbFragment.this.cvE();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.sT(false);
            if (z && fVar != null) {
                bv cKx = fVar.cKx();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(fVar, i2);
                VideoPbFragment.this.J(fVar);
                com.baidu.tieba.pb.videopb.c.a cLc = fVar.cLc();
                if (cLc != null && !cLc.kIb) {
                    VideoPbFragment.this.a(cLc);
                }
                VideoPbFragment.this.K(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.kof != null) {
                    VideoPbFragment.this.kof.he(fVar.aSj());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.eBU = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.eBU) && VideoPbFragment.this.kou != null && VideoPbFragment.this.kou.biJ() != null && (nQ = VideoPbFragment.this.kou.biJ().nQ(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.eBU)) {
                        ((View) nQ).setOnClickListener(VideoPbFragment.this.eCG);
                    }
                }
                if (VideoPbFragment.this.jqz != null && cKx != null && cKx.aWl() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(cKx.aWl());
                    VideoPbFragment.this.jqz.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.cLP().cNL());
                        jSONObject.put("fid", VideoPbFragment.this.cLP().getForumId());
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
                if ((!com.baidu.tbadk.a.d.aRQ() || VideoPbFragment.this.cTn() != null) && VideoPbFragment.this.cTl() != null) {
                    if (com.baidu.tbadk.a.d.aRQ()) {
                        if (i != -1) {
                            ArrayList<PostData> arrayList = null;
                            if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null) {
                                arrayList = VideoPbFragment.this.cLP().getPbData().cKz();
                            }
                            if (x.getCount(arrayList) == 0 || (x.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dli() == 1)) {
                                if (VideoPbFragment.this.cTn().cNn()) {
                                    VideoPbFragment.this.cTn().KP(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.cTn().KP(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.cTn().KO(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.cTn().KO("");
                        }
                        VideoPbFragment.this.cTn().endLoadData();
                    } else {
                        if (i != -1) {
                            ArrayList<PostData> arrayList2 = null;
                            if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null) {
                                arrayList2 = VideoPbFragment.this.cLP().getPbData().cKz();
                            }
                            if (x.getCount(arrayList2) == 0 || (x.getCount(arrayList2) == 1 && arrayList2.get(0) != null && arrayList2.get(0).dli() == 1)) {
                                if (VideoPbFragment.this.cTl().cNn()) {
                                    VideoPbFragment.this.cTl().KP(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.cTl().KP(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.cTl().KO(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.cTl().KO("");
                        }
                        VideoPbFragment.this.cTl().endLoadData();
                    }
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.dkh().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0489a kpl = new a.InterfaceC0489a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0489a
        public void c(boolean z, boolean z2, String str) {
            VideoPbFragment.this.cPX();
            if (z && VideoPbFragment.this.cLP() != null) {
                if (VideoPbFragment.this.kof != null) {
                    VideoPbFragment.this.kof.he(z2);
                }
                VideoPbFragment.this.cLP().sy(z2);
                if (VideoPbFragment.this.cLP().aSj()) {
                    VideoPbFragment.this.cMY();
                } else if (com.baidu.tbadk.a.d.aRQ() && VideoPbFragment.this.cTn() != null) {
                    VideoPbFragment.this.cTn().cTS();
                } else if (VideoPbFragment.this.cTl() != null) {
                    VideoPbFragment.this.cTl().cTS();
                }
                if (z2) {
                    if (VideoPbFragment.this.kof != null) {
                        if (VideoPbFragment.this.kof.aSm() != null && VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null && VideoPbFragment.this.cLP().getPbData().cKx() != null && VideoPbFragment.this.cLP().getPbData().cKx().aWl() != null) {
                            MarkData aSm = VideoPbFragment.this.kof.aSm();
                            MetaData aWl = VideoPbFragment.this.cLP().getPbData().cKx().aWl();
                            if (aSm != null && aWl != null) {
                                if (!as.equals(TbadkCoreApplication.getCurrentAccount(), aWl.getUserId()) && !aWl.hadConcerned()) {
                                    VideoPbFragment.this.kGf.b(aWl);
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
                    VideoPbFragment.this.cMV();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b eBY = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bji() {
            if (VideoPbFragment.this.kol == null || VideoPbFragment.this.kol.cQO() == null || !VideoPbFragment.this.kol.cQO().dub()) {
                return !VideoPbFragment.this.BI(al.eaP);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kol.cQO().dud());
            if (VideoPbFragment.this.kou != null && (VideoPbFragment.this.kou.bjz() || VideoPbFragment.this.kou.bjA())) {
                VideoPbFragment.this.kou.a(false, VideoPbFragment.this.kol.cQR());
            }
            VideoPbFragment.this.kol.sZ(true);
            return true;
        }
    };
    private final CustomMessageListener koO = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.cLP() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.kou != null) {
                    VideoPbFragment.this.sR(VideoPbFragment.this.kou.bjs());
                }
                VideoPbFragment.this.cPA();
                VideoPbFragment.this.kGf.cQo();
            }
        }
    };
    private CustomMessageListener koR = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
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
    private final CustomMessageListener hHa = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.bjZ) {
                VideoPbFragment.this.cNp();
            }
        }
    };
    private CustomMessageListener kpk = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.cMP();
            }
        }
    };
    private CustomMessageListener kpd = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.64
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.kGf != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kGf.koC) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.kGf.bMt();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.kGf.getExtra();
                DataRes dataRes = aVar.mbC;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (as.isEmpty(str)) {
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
                    VideoPbFragment.this.kGf.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.kGf.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener kpb = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.kGf != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kGf.koC) {
                VideoPbFragment.this.kGf.bMt();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.cLP().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cKN().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.koB.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.kGf.zN(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.kGf.cNm();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (as.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.koB.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener kpc = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.kGf != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kGf.koC) {
                VideoPbFragment.this.kGf.bMt();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.koB.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (as.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.koB.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b koz = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bji() {
            if (VideoPbFragment.this.kol == null || VideoPbFragment.this.kol.cQP() == null || !VideoPbFragment.this.kol.cQP().dub()) {
                return !VideoPbFragment.this.BI(al.eaQ);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kol.cQP().dud());
            if (VideoPbFragment.this.kwt != null && VideoPbFragment.this.kwt.cMz() != null && VideoPbFragment.this.kwt.cMz().bjA()) {
                VideoPbFragment.this.kwt.cMz().a(VideoPbFragment.this.kol.cQR());
            }
            VideoPbFragment.this.kol.ta(true);
            return true;
        }
    };
    private final NewWriteModel.d eCe = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                ap apVar = new ap("c13268");
                apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null) {
                    apVar.dn("fid", VideoPbFragment.this.cLP().getPbData().getForumId());
                }
                apVar.dn("tid", VideoPbFragment.this.cLP().cNL());
                apVar.dn("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(apVar);
            }
            VideoPbFragment.this.cbU();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.cLP() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.cLP().KJ(postWriteCallBackData.getPostId());
                    if (com.baidu.tbadk.a.d.aRQ() && VideoPbFragment.this.cTn() != null) {
                        VideoPbFragment.this.koH = VideoPbFragment.this.cTn().cPZ();
                        VideoPbFragment.this.kGh = VideoPbFragment.this.cTn().cTV();
                        VideoPbFragment.this.cLP().cM(VideoPbFragment.this.koH, VideoPbFragment.this.kGh);
                    } else if (VideoPbFragment.this.cTl() != null) {
                        VideoPbFragment.this.koH = VideoPbFragment.this.cTl().cPZ();
                        VideoPbFragment.this.kGh = VideoPbFragment.this.cTl().cTV();
                        VideoPbFragment.this.cLP().cM(VideoPbFragment.this.koH, VideoPbFragment.this.kGh);
                    }
                }
                if (VideoPbFragment.this.dYQ != null) {
                    if (com.baidu.tbadk.a.d.aRQ()) {
                        VideoPbFragment.this.dYQ.setCurrentItem(VideoPbFragment.kFL);
                    } else {
                        VideoPbFragment.this.dYQ.setCurrentItem(VideoPbFragment.kFK);
                    }
                }
                VideoPbFragment.this.kGf.cQo();
                VideoPbFragment.this.kol.cQN();
                if (VideoPbFragment.this.kou != null) {
                    VideoPbFragment.this.sR(VideoPbFragment.this.kou.bjs());
                }
                VideoPbFragment.this.cPw();
                VideoPbFragment.this.sT(true);
                VideoPbFragment.this.cLP().cOg();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (com.baidu.tbadk.a.d.aRQ() && VideoPbFragment.this.cTn() != null) {
                                VideoPbFragment.this.cTn().cTS();
                            } else if (VideoPbFragment.this.cTl() != null) {
                                VideoPbFragment.this.cTl().cTS();
                            }
                        }
                    } else if (VideoPbFragment.this.cLP().getHostMode()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.cLP().getPbData();
                        if (pbData != null && pbData.cKx() != null && pbData.cKx().aWl() != null && (userId = pbData.cKx().aWl().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.cLP().cNX()) {
                            VideoPbFragment.this.cPV();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.cLP().cNX()) {
                        VideoPbFragment.this.cPV();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.sl(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.kou.bjz() || VideoPbFragment.this.kou.bjA()) {
                    VideoPbFragment.this.kou.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.kol.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.jqz != null) {
                    VideoPbFragment.this.jqz.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (as.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (as.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.xl(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.xl(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new ap("c13746").ah("obj_locate", 1).ah("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).aYL();
                TiebaStatic.log(new ap("c13745").ah("obj_locate", 1).ah("obj_type", 2));
            } else if (adVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener eCG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.eBU);
        }
    };
    private CustomMessageListener koQ = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.kou != null) {
                    VideoPbFragment.this.sR(VideoPbFragment.this.kou.bjs());
                }
                VideoPbFragment.this.sT(false);
            }
        }
    };
    private int kGi = 0;
    private boolean kGm = true;
    private View.OnTouchListener kGn = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.kGi == 1) {
                if (!VideoPbFragment.this.kGm) {
                    VideoPbFragment.this.cTq();
                    UtilHelper.showStatusBar(VideoPbFragment.this.cNt(), VideoPbFragment.this.cNt().getRootView());
                    VideoPbFragment.this.kGm = true;
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(VideoPbFragment.this.kGo);
                    com.baidu.adp.lib.f.e.lt().postDelayed(VideoPbFragment.this.kGo, 3000L);
                }
            } else if (VideoPbFragment.this.kGi == 2 && (VideoPbFragment.this.kGm || VideoPbFragment.this.cTs())) {
                VideoPbFragment.this.cTr();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cNt(), VideoPbFragment.this.cNt().getRootView());
                VideoPbFragment.this.kGm = false;
                if (VideoPbFragment.this.kFS != null) {
                    VideoPbFragment.this.kFS.tu(false);
                }
            }
            VideoPbFragment.this.kGi = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener hQN = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.kGi = 0;
            VideoPbFragment.this.kGj = 0.0f;
            VideoPbFragment.this.kGk = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.kGj += f;
            VideoPbFragment.this.kGk += f2;
            if (VideoPbFragment.this.kGi == 0 && !VideoPbFragment.this.kGl && VideoPbFragment.this.kFS != null && !VideoPbFragment.this.kFS.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.kGk) <= Math.abs(VideoPbFragment.this.kGj) || VideoPbFragment.this.kGk > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.kGk) > Math.abs(VideoPbFragment.this.kGj) && VideoPbFragment.this.kGk > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.kGi = 2;
                    }
                } else {
                    VideoPbFragment.this.kGi = 1;
                }
            }
            return true;
        }
    };
    private Runnable kGo = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.kGm && !VideoPbFragment.this.cTs()) {
                VideoPbFragment.this.cTr();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cNt(), VideoPbFragment.this.cNt().getRootView());
                VideoPbFragment.this.kGm = false;
            }
        }
    };
    private final com.baidu.adp.base.d gXJ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.cLP() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.gXC.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.gXC.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.cLP().cOg();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.kDh != 1002 || bVar.fVs) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.Pv, dVar.lPQ, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.gXC.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.gXC.getLoadDataMode(), gVar.Pv, gVar.lPQ, false);
                    VideoPbFragment.this.kGf.aR(gVar.lPT);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener eKY = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.hKk.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d kph = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            if (!as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                ap apVar = new ap("c13268");
                apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null) {
                    apVar.dn("fid", VideoPbFragment.this.cLP().getPbData().getForumId());
                }
                if (VideoPbFragment.this.cLP() != null) {
                    apVar.dn("tid", VideoPbFragment.this.cLP().cNL());
                }
                apVar.dn("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(apVar);
            }
            if (z) {
                if (VideoPbFragment.this.kol != null) {
                    VideoPbFragment.this.kol.cQM();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.jqz != null) {
                    VideoPbFragment.this.jqz.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (as.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (as.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.xl(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.xl(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new ap("c13746").ah("obj_locate", 1).ah("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).aYL();
                TiebaStatic.log(new ap("c13745").ah("obj_locate", 1).ah("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.kol != null) {
                if (VideoPbFragment.this.kwt != null && VideoPbFragment.this.kwt.cMz() != null && VideoPbFragment.this.kwt.cMz().bjA()) {
                    VideoPbFragment.this.kwt.cMz().a(postWriteCallBackData);
                }
                VideoPbFragment.this.kol.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c eBX = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bjj() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener awi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        /* JADX DEBUG: Multi-variable search result rejected for r1v194, resolved type: com.baidu.tieba.pb.videopb.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray sparseArray;
            boolean y;
            int i = 2;
            int i2 = 3;
            int i3 = 1;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    ap apVar = new ap("c13398");
                    apVar.dn("tid", VideoPbFragment.this.cLP().cNL());
                    apVar.dn("fid", VideoPbFragment.this.cLP().getForumId());
                    apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                    apVar.ah("obj_locate", 1);
                    TiebaStatic.log(apVar);
                    if (VideoPbFragment.this.knP) {
                        VideoPbFragment.this.knP = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null && VideoPbFragment.this.knz != null && postData.aWl() != null && postData.dli() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.kwt != null) {
                                    VideoPbFragment.this.kwt.cMv();
                                }
                                p pVar = new p();
                                pVar.a(VideoPbFragment.this.cLP().getPbData().getForum());
                                pVar.setThreadData(VideoPbFragment.this.cLP().getPbData().cKx());
                                pVar.g(postData);
                                VideoPbFragment.this.knz.d(pVar);
                                VideoPbFragment.this.knz.setPostId(postData.getId());
                                VideoPbFragment.this.a(view, postData.aWl().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.cLP().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.kou != null) {
                                    VideoPbFragment.this.sR(VideoPbFragment.this.kou.bjs());
                                }
                            }
                        }
                    }
                } else if ((VideoPbFragment.this.cTl() != null && VideoPbFragment.this.cTl().cQk() != null && view == VideoPbFragment.this.cTl().cQk()) || ((com.baidu.tbadk.a.d.aRQ() && VideoPbFragment.this.cTn() != null && VideoPbFragment.this.cTn().cQk() != null && view == VideoPbFragment.this.cTn().cQk()) || view.getId() == R.id.pb_more)) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.cLP().sw(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        if (com.baidu.tbadk.a.d.aRQ()) {
                            VideoPbFragment.this.cTn().cPW();
                        } else {
                            VideoPbFragment.this.cTl().cPW();
                        }
                    }
                } else if (VideoPbFragment.this.kGf != null && VideoPbFragment.this.kGf.cRu() != null && view == VideoPbFragment.this.kGf.cRu().cOV()) {
                    VideoPbFragment.this.kGf.aIX();
                } else if ((VideoPbFragment.this.kGf != null && ((VideoPbFragment.this.kGf.cRu() != null && view == VideoPbFragment.this.kGf.cRu().cOW()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) || view.getId() == R.id.floor_owner_reply || view.getId() == R.id.reply_title) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.kGf.cQo();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.cbU();
                        VideoPbFragment.this.cPV();
                        if (view.getId() == R.id.owner_reply) {
                            y = VideoPbFragment.this.cLP().y(true, VideoPbFragment.this.cNc());
                        } else {
                            y = view.getId() == R.id.all_reply ? VideoPbFragment.this.cLP().y(false, VideoPbFragment.this.cNc()) : VideoPbFragment.this.cLP().KG(VideoPbFragment.this.cNc());
                        }
                        view.setTag(Boolean.valueOf(y));
                        if (y) {
                            VideoPbFragment.this.cvF();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.eJG) {
                    if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null) {
                        if (!as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            ap apVar2 = new ap("c13266");
                            apVar2.dn("uid", TbadkCoreApplication.getCurrentAccount());
                            apVar2.dn("fid", VideoPbFragment.this.cLP().getPbData().getForumId());
                            apVar2.dn("tid", VideoPbFragment.this.cLP().cNL());
                            apVar2.dn("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(apVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.knE, VideoPbFragment.this.eJG);
                        VideoPbFragment.this.knE.finish();
                    }
                } else if (view == VideoPbFragment.this.kBn && VideoPbFragment.this.kGf != null) {
                    if (VideoPbFragment.this.cLP() == null || VideoPbFragment.this.cLP().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> cKz = VideoPbFragment.this.cLP().getPbData().cKz();
                    if ((cKz == null || cKz.size() <= 0) && VideoPbFragment.this.cLP().cNN()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new ap("c12378").dn("tid", VideoPbFragment.this.cLP().cNL()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("fid", VideoPbFragment.this.cLP().getForumId()));
                    VideoPbFragment.this.kGf.cMQ();
                } else if (VideoPbFragment.this.kGf.cRu() != null && view == VideoPbFragment.this.kGf.cRu().cPa()) {
                    if (VideoPbFragment.this.cLP() != null) {
                        VideoPbFragment.this.kGf.cQo();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.cbU();
                            VideoPbFragment.this.cPV();
                            VideoPbFragment.this.cLP().BO(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.kGf != null && VideoPbFragment.this.kGf.cRu() != null && view == VideoPbFragment.this.kGf.cRu().cOW()) {
                    VideoPbFragment.this.kGf.aIX();
                } else if (VideoPbFragment.this.kGf != null && ((VideoPbFragment.this.kGf.cRu() != null && view == VideoPbFragment.this.kGf.cRu().cPd()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                    VideoPbFragment.this.kGf.cQo();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.cbU();
                            VideoPbFragment.this.cPV();
                            VideoPbFragment.this.kGf.cW(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.cLP().cOe()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.kGf != null && VideoPbFragment.this.kGf.cRu() != null && view == VideoPbFragment.this.kGf.cRu().cOU()) {
                    if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null && VideoPbFragment.this.cLP().getPbData().cKx() != null) {
                        VideoPbFragment.this.kGf.aIX();
                        TiebaStatic.log(new ap("c13062"));
                        VideoPbFragment.this.kGf.KB(VideoPbFragment.this.cLP().getPbData().cKx().aWC());
                    }
                } else if (view.getId() == R.id.pb_floor_feedback) {
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (VideoPbFragment.this.kGf != null) {
                        VideoPbFragment.this.kGf.f(sparseArray);
                    }
                } else if (VideoPbFragment.this.kGf != null && VideoPbFragment.this.kGf.cRu() != null && view == VideoPbFragment.this.kGf.cRu().cPe()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        ao.z(true, false);
                        TiebaStatic.log(new ap(TbadkCoreStatisticKey.SET_NIGHT_MODE).ah("obj_type", 0).ah("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new ap(TbadkCoreStatisticKey.SET_NIGHT_MODE).ah("obj_type", 1).ah("obj_source", 1));
                    }
                    VideoPbFragment.this.kGf.cRt();
                } else if (VideoPbFragment.this.kGf != null && (view == VideoPbFragment.this.kGf.cPT() || (VideoPbFragment.this.kGf.cRu() != null && (view == VideoPbFragment.this.kGf.cRu().cOZ() || view == VideoPbFragment.this.kGf.cRu().cOX())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.cLP() != null || VideoPbFragment.this.cLP().getPbData() != null) {
                        if ((VideoPbFragment.this.cLP().getPbData().cKM() == 1 || VideoPbFragment.this.cLP().getPbData().cKM() == 3) && !VideoPbFragment.this.gXC.dlV()) {
                            VideoPbFragment.this.kGf.cQo();
                            if (VideoPbFragment.this.kGf.cRu() != null && view == VideoPbFragment.this.kGf.cRu().cOX()) {
                                if (VideoPbFragment.this.cLP().getPbData().cKx().aWg() == 1) {
                                    i2 = 5;
                                } else {
                                    i2 = 4;
                                }
                            } else if (VideoPbFragment.this.kGf.cRu() != null && view == VideoPbFragment.this.kGf.cRu().cOZ()) {
                                if (VideoPbFragment.this.cLP().getPbData().cKx().aWh() != 1) {
                                    i2 = 6;
                                }
                            } else {
                                i2 = view == VideoPbFragment.this.kGf.cPT() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.cLP().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.cLP().getPbData().cKx().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.gXC.b(id, name, id2, i2, VideoPbFragment.this.kGf.cPU());
                        }
                    }
                } else if (VideoPbFragment.this.kGf != null && VideoPbFragment.this.kGf.cRu() != null && view == VideoPbFragment.this.kGf.cRu().cPc()) {
                    if (VideoPbFragment.this.cLP() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.kGf.cQo();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.cLP().getPbData(), VideoPbFragment.this.cLP().cNN(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.cLP().getPbData().getForum().getId(), VideoPbFragment.this.cLP().getPbData().getForum().getName(), VideoPbFragment.this.cLP().getPbData().cKx().getId(), String.valueOf(VideoPbFragment.this.cLP().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.kGf != null && VideoPbFragment.this.kGf.cRu() != null && view == VideoPbFragment.this.kGf.cRu().cOY()) {
                    if (VideoPbFragment.this.cLP() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.cLP().getPbData(), VideoPbFragment.this.cLP().cNN(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.kGf.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.kGf.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.kGf.aIX();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        ap apVar3 = new ap("c13398");
                        apVar3.dn("tid", VideoPbFragment.this.cLP().cNL());
                        apVar3.dn("fid", VideoPbFragment.this.cLP().getForumId());
                        apVar3.dn("uid", TbadkCoreApplication.getCurrentAccount());
                        apVar3.ah("obj_locate", 4);
                        TiebaStatic.log(apVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new ap("c10517").ah("obj_locate", 3).dn("fid", VideoPbFragment.this.cLP().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null) {
                        if (VideoPbFragment.this.kGf != null) {
                            VideoPbFragment.this.kGf.cQo();
                        }
                        PostData postData2 = (PostData) ((SparseArray) view.getTag()).get(R.id.tag_load_sub_data);
                        if (postData2 != null) {
                            if (postData2.dlu() == 1) {
                                TiebaStatic.log(new ap("c12630"));
                            }
                            if (postData2.lNY != null) {
                                ap baN = postData2.lNY.baN();
                                baN.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    baN.ah("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    baN.ah("obj_locate", 8);
                                }
                                TiebaStatic.log(baN);
                            }
                            VideoPbFragment.this.cbU();
                            TiebaStatic.log("c11742");
                            VideoPbFragment.this.a(postData2, false);
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                    if (VideoPbFragment.this.cLP() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            ap apVar4 = new ap("c13398");
                            apVar4.dn("tid", VideoPbFragment.this.cLP().cNL());
                            apVar4.dn("fid", VideoPbFragment.this.cLP().getForumId());
                            apVar4.dn("uid", TbadkCoreApplication.getCurrentAccount());
                            apVar4.ah("obj_locate", 6);
                            TiebaStatic.log(apVar4);
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData3 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData3.lNY != null) {
                                    ap baN2 = postData3.lNY.baN();
                                    baN2.delete("obj_locate");
                                    baN2.ah("obj_locate", 8);
                                    TiebaStatic.log(baN2);
                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                    TiebaStatic.log(new ap("c13700").dn("tid", VideoPbFragment.this.cLP().cNM()).dn("fid", VideoPbFragment.this.cLP().getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("post_id", postData3.getId()).ah("obj_type", 3));
                                }
                                if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null && VideoPbFragment.this.knz != null && postData3.aWl() != null && postData3.dli() != 1) {
                                    if (VideoPbFragment.this.kwt != null) {
                                        VideoPbFragment.this.kwt.cMv();
                                    }
                                    if ((VideoPbFragment.this.klG || com.baidu.tbadk.a.d.aRF()) && postData3.dlf() != null && postData3.dlf().size() != 0) {
                                        if (com.baidu.tbadk.a.d.aRG()) {
                                            VideoPbFragment.this.a(postData3, false);
                                            return;
                                        } else {
                                            VideoPbFragment.this.a(postData3, true);
                                            return;
                                        }
                                    }
                                    p pVar2 = new p();
                                    pVar2.a(VideoPbFragment.this.cLP().getPbData().getForum());
                                    pVar2.setThreadData(VideoPbFragment.this.cLP().getPbData().cKx());
                                    pVar2.g(postData3);
                                    VideoPbFragment.this.knz.d(pVar2);
                                    VideoPbFragment.this.knz.setPostId(postData3.getId());
                                    VideoPbFragment.this.a(view, postData3.aWl().getUserId(), "", postData3);
                                    if (VideoPbFragment.this.kou != null) {
                                        VideoPbFragment.this.sR(VideoPbFragment.this.kou.bjs());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.kGf == null || VideoPbFragment.this.cLP() == null || VideoPbFragment.this.cTl() == null) {
                    } else {
                        if (!com.baidu.tbadk.a.d.aRQ() || VideoPbFragment.this.cTn() != null) {
                            VideoPbFragment.this.kGf.cQo();
                            if (VideoPbFragment.this.BJ(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.cLP() != null) {
                                VideoPbFragment.this.cMX();
                                if (VideoPbFragment.this.cLP().getPbData() != null && VideoPbFragment.this.cLP().getPbData().cKx() != null && VideoPbFragment.this.cLP().getPbData().cKx().aWl() != null) {
                                    TiebaStatic.log(new ap("c13402").dn("tid", VideoPbFragment.this.cLP().cNL()).dn("fid", VideoPbFragment.this.cLP().getPbData().getForumId()).ah("obj_locate", 3).dn("uid", VideoPbFragment.this.cLP().getPbData().cKx().aWl().getUserId()));
                                }
                                if (VideoPbFragment.this.cLP().getPbData().cKx() != null && VideoPbFragment.this.cLP().getPbData().cKx().aWl() != null && VideoPbFragment.this.cLP().getPbData().cKx().aWl().getUserId() != null && VideoPbFragment.this.kof != null) {
                                    int h = VideoPbFragment.this.kGf.h(VideoPbFragment.this.cLP().getPbData());
                                    bv cKx = VideoPbFragment.this.cLP().getPbData().cKx();
                                    if (!cKx.aUT()) {
                                        if (cKx.aUU()) {
                                            i = 3;
                                        } else if (cKx.aYg()) {
                                            i = 4;
                                        } else {
                                            i = cKx.aYh() ? 5 : 1;
                                        }
                                    }
                                    TiebaStatic.log(new ap("c12526").dn("tid", VideoPbFragment.this.cLP().cNL()).ah("obj_locate", 1).dn("obj_id", VideoPbFragment.this.cLP().getPbData().cKx().aWl().getUserId()).ah("obj_type", VideoPbFragment.this.kof.aSj() ? 0 : 1).ah("obj_source", h).ah("obj_param1", i));
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.ts(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.kGf != null && VideoPbFragment.this.dYQ != null && VideoPbFragment.this.cLP().getPbData() != null && VideoPbFragment.this.cLP().getPbData().cKx() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.cLP().getPbData();
                        if (pbData.cKx().aWc() != 0) {
                            int currentItem = VideoPbFragment.this.dYQ.getCurrentItem();
                            if (!com.baidu.tbadk.a.d.aRQ() && currentItem == VideoPbFragment.kFJ) {
                                VideoPbFragment.this.dYQ.setCurrentItem(VideoPbFragment.kFK);
                            } else if (com.baidu.tbadk.a.d.aRQ() || currentItem == VideoPbFragment.kFK) {
                                if (!com.baidu.tbadk.a.d.aRQ() && VideoPbFragment.this.cTl() == null) {
                                    return;
                                }
                                if ((!com.baidu.tbadk.a.d.aRQ() || VideoPbFragment.this.cTn() != null) && VideoPbFragment.this.ceG() != null) {
                                    ap dn = new ap("c13403").dn("tid", VideoPbFragment.this.cLP().cNL()).dn("fid", VideoPbFragment.this.cLP().getPbData().getForumId()).dn("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView ceG = VideoPbFragment.this.ceG();
                                    if (ceG != null) {
                                        boolean canScrollVertically = ceG.canScrollVertically(1);
                                        boolean canScrollVertically2 = ceG.canScrollVertically(-1);
                                        if (VideoPbFragment.this.WP != null) {
                                            VideoPbFragment.this.WP.setExpanded(false, true);
                                        }
                                        if (ceG.getLayoutManager() != null && (ceG.getLayoutManager() instanceof LinearLayoutManager)) {
                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) ceG.getLayoutManager();
                                            if (!canScrollVertically2 && canScrollVertically) {
                                                if (VideoPbFragment.this.knZ != -1 || VideoPbFragment.this.koa != Integer.MIN_VALUE) {
                                                    if (VideoPbFragment.this.knZ > 3 || (VideoPbFragment.this.knZ == 3 && VideoPbFragment.this.koa < (-equipmentHeight))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.knZ, VideoPbFragment.this.koa + equipmentHeight);
                                                        ceG.smoothScrollBy(0, equipmentHeight);
                                                    } else if (VideoPbFragment.this.knZ >= 2) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.knZ, VideoPbFragment.this.koa + (equipmentHeight / 2));
                                                        ceG.smoothScrollBy(0, equipmentHeight / 2);
                                                    } else if (VideoPbFragment.this.knZ == 1) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.knZ, VideoPbFragment.this.koa + (equipmentHeight / 4));
                                                        ceG.smoothScrollBy(0, equipmentHeight / 4);
                                                    } else {
                                                        ceG.smoothScrollBy(0, -VideoPbFragment.this.koa);
                                                    }
                                                    dn.ah("obj_locate", 2);
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                int firstVisiblePosition = ceG.getFirstVisiblePosition();
                                                View childAt = ceG.getChildAt(0);
                                                int top = childAt == null ? 0 : childAt.getTop();
                                                VideoPbFragment.this.knZ = firstVisiblePosition;
                                                VideoPbFragment.this.koa = top;
                                                if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && ceG.getCount() >= 6)) {
                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                    ceG.smoothScrollToPosition(0);
                                                } else {
                                                    ceG.smoothScrollToPosition(0);
                                                }
                                                dn.ah("obj_locate", 1);
                                            }
                                            TiebaStatic.log(dn);
                                            TiebaStatic.log(new ap("c12942").ah("obj_type", 1).ah("obj_locate", 4).dn("tid", VideoPbFragment.this.cLP().cNL()).dn("nid", pbData.cKx().getNid()));
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
                            if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null && VideoPbFragment.this.cLP().getPbData().cKx() != null && VideoPbFragment.this.cLP().getPbData().cKx().aWl() != null) {
                                TiebaStatic.log(new ap("c13402").dn("tid", VideoPbFragment.this.cLP().cNL()).dn("fid", VideoPbFragment.this.cLP().getPbData().getForumId()).ah("obj_locate", 2).dn("uid", VideoPbFragment.this.cLP().getPbData().cKx().aWl().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.tt(false);
                        VideoPbFragment.this.cML();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.koH >= 0) {
                        if (VideoPbFragment.this.cLP() != null) {
                            VideoPbFragment.this.cLP().cOw();
                        }
                        if (com.baidu.tbadk.a.d.aRQ() && VideoPbFragment.this.cTn() != null && VideoPbFragment.this.cTn().cTR() != null) {
                            VideoPbFragment.this.cTn().cTR().setData(VideoPbFragment.this.cLP().getPbData());
                        } else if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cTl() != null && VideoPbFragment.this.cTl().cTR() != null) {
                            VideoPbFragment.this.cTl().cTR().setData(VideoPbFragment.this.cLP().getPbData());
                        }
                        VideoPbFragment.this.koH = 0;
                        VideoPbFragment.this.kGh = Integer.MIN_VALUE;
                        if (com.baidu.tbadk.a.d.aRQ() && VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cTn() != null) {
                            VideoPbFragment.this.cTn().cP(VideoPbFragment.this.cLP().cOz(), VideoPbFragment.this.cLP().cOA());
                            VideoPbFragment.this.cLP().cM(0, 0);
                        } else if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cTl() != null) {
                            VideoPbFragment.this.cTl().cP(VideoPbFragment.this.cLP().cOz(), VideoPbFragment.this.cLP().cOA());
                            VideoPbFragment.this.cLP().cM(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.cLP() != null) {
                        ap apVar5 = new ap("c13398");
                        apVar5.dn("tid", VideoPbFragment.this.cLP().cNL());
                        apVar5.dn("fid", VideoPbFragment.this.cLP().getForumId());
                        apVar5.dn("uid", TbadkCoreApplication.getCurrentAccount());
                        apVar5.ah("obj_locate", 2);
                        TiebaStatic.log(apVar5);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bf.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.aZP().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.cPA();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.cPA();
                } else if (VideoPbFragment.this.kGf.cRu() != null && view == VideoPbFragment.this.kGf.cRu().cPb()) {
                    VideoPbFragment.this.kGf.cQo();
                    if (VideoPbFragment.this.cLP() != null) {
                        VideoPbFragment.this.gXE.setThreadId(VideoPbFragment.this.cLP().cNL());
                    }
                    if (VideoPbFragment.this.cLP() == null || !VideoPbFragment.this.cLP().isPrivacy()) {
                        VideoPbFragment.this.gXE.bRh();
                        if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null && VideoPbFragment.this.cLP().getPbData().getThreadId() != null && VideoPbFragment.this.cLP().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                            i3 = 2;
                        }
                        if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null) {
                            VideoPbFragment.this.gXE.j(3, i3, VideoPbFragment.this.cLP().getPbData().getThreadId());
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                    if (VideoPbFragment.this.cLP().getPbData() != null) {
                        VideoPbFragment.this.gXE.j(3, 3, VideoPbFragment.this.cLP().getPbData().getThreadId());
                    }
                }
            }
        }
    };
    private View.OnClickListener kkY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.kGf != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.kGf.c(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.kGf.cP(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.kGf.c(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.kGf.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    public SortSwitchButton.a kpg = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean vs(int i) {
            if (VideoPbFragment.this.kGf != null) {
                VideoPbFragment.this.kGf.cQo();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.cLP() == null || VideoPbFragment.this.cLP().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.cbU();
                VideoPbFragment.this.cPV();
                if (VideoPbFragment.this.cLP().getPbData() != null && VideoPbFragment.this.cLP().getPbData().kho != null && VideoPbFragment.this.cLP().getPbData().kho.size() > i) {
                    int intValue = VideoPbFragment.this.cLP().getPbData().kho.get(i).sort_type.intValue();
                    TiebaStatic.log(new ap("c13699").dn("tid", VideoPbFragment.this.cLP().cNM()).dn("fid", VideoPbFragment.this.cLP().getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()).ah("obj_type", BM(intValue)));
                    if (VideoPbFragment.this.cLP().BT(intValue)) {
                        VideoPbFragment.this.mIsLoading = true;
                    }
                }
                return true;
            }
        }

        private int BM(int i) {
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
    private a kGg = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void cMV() {
        if (cLP() != null && cLP().getPbData() != null && cLP().getPbData().cKx() != null) {
            bv cKx = cLP().getPbData().cKx();
            cKx.mRecomAbTag = cLP().cOG();
            cKx.mRecomWeight = cLP().cOE();
            cKx.mRecomSource = cLP().cOF();
            cKx.mRecomExtra = cLP().cOH();
            if (cKx.getFid() == 0) {
                cKx.setFid(com.baidu.adp.lib.f.b.toLong(cLP().getForumId(), 0L));
            }
            ap a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cKx, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sl(boolean z) {
        if (cLP() != null && cLP().getPbData() != null && cLP().getPbData().cKx() != null) {
            bv cKx = cLP().getPbData().cKx();
            cKx.mRecomAbTag = cLP().cOG();
            cKx.mRecomWeight = cLP().cOE();
            cKx.mRecomSource = cLP().cOF();
            cKx.mRecomExtra = cLP().cOH();
            if (cKx.getFid() == 0) {
                cKx.setFid(com.baidu.adp.lib.f.b.toLong(cLP().getForumId(), 0L));
            }
            ap a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cKx, "c13563");
            TbPageTag ec = com.baidu.tbadk.pageInfo.c.ec(getContext());
            if (a2 != null && ec != null && PageStayDurationConstants.PageName.VIDEO_LIST.equals(ec.locatePage)) {
                a2.dn("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dn("obj_pre_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            if (a2 != null) {
                a2.ah("reply_type", 1);
                if (z) {
                    a2.ah("obj_type", 2);
                } else {
                    a2.ah("obj_type", 1);
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
            if (as.isEmpty(str)) {
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
            String string = !TextUtils.isEmpty(bVar.lPQ) ? bVar.lPQ : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.xl(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.hJ(true);
                aVar.b(getPageContext());
                aVar.aYL();
            } else {
                a(0, bVar.Pv, bVar.lPQ, z);
            }
            if (bVar.Pv) {
                if (bVar.hmP == 1) {
                    ArrayList<PostData> cKz = cLP().getPbData().cKz();
                    int size = cKz.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cKz.get(i).getId())) {
                            i++;
                        } else {
                            cKz.remove(i);
                            break;
                        }
                    }
                    cLP().getPbData().cKx().la(cLP().getPbData().cKx().aWc() - 1);
                    if (com.baidu.tbadk.a.d.aRQ() && cTn() != null) {
                        cTn().cTS();
                    } else if (cTl() != null) {
                        cTl().cTS();
                    }
                } else if (bVar.hmP == 0) {
                    cMW();
                } else if (bVar.hmP == 2) {
                    ArrayList<PostData> cKz2 = cLP().getPbData().cKz();
                    int size2 = cKz2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cKz2.get(i2).dlf().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cKz2.get(i2).dlf().get(i3).getId())) {
                                i3++;
                            } else {
                                cKz2.get(i2).dlf().remove(i3);
                                cKz2.get(i2).dlh();
                                z2 = true;
                                break;
                            }
                        }
                        cKz2.get(i2).NN(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        if (com.baidu.tbadk.a.d.aRQ() && cTn() != null) {
                            cTn().cTS();
                        } else if (cTl() != null) {
                            cTl().cTS();
                        }
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = cLP().getPbData().cKL().kiW;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dlf().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dlf().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dlf().remove(i2);
                    list.get(i).dlh();
                    z = true;
                    break;
                }
            }
            list.get(i).NN(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            if (com.baidu.tbadk.a.d.aRQ() && cTn() != null) {
                cTn().cTS();
            } else if (cTl() != null) {
                cTl().cTS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && cLP() != null && cLP().getPbData() != null && cLP().getPbData().cKx() != null) {
            a(this.gXC.getLoadDataMode(), gVar.Pv, gVar.lPQ, false);
            if (gVar.Pv) {
                this.koi = true;
                if (i == 2 || i == 3) {
                    this.koj = true;
                    this.kok = false;
                } else if (i == 4 || i == 5) {
                    this.koj = false;
                    this.kok = true;
                }
                if (i == 2) {
                    cLP().getPbData().cKx().ld(1);
                    cLP().setIsGood(1);
                } else if (i == 3) {
                    cLP().getPbData().cKx().ld(0);
                    cLP().setIsGood(0);
                } else if (i == 4) {
                    cLP().getPbData().cKx().lc(1);
                    cLP().BN(1);
                } else if (i == 5) {
                    cLP().getPbData().cKx().lc(0);
                    cLP().BN(0);
                }
            }
            if (cLP().getPbData().cKx() != null && cTm() != null) {
                cTm().cUb();
            }
        }
    }

    private void cMW() {
        if (cLP().cNO() || cLP().cNQ()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", cLP().cNL());
            PbActivity pbActivity = this.knE;
            PbActivity pbActivity2 = this.knE;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, cLP().cNL()));
        if (cMZ()) {
            this.knE.finish();
        }
    }

    private boolean cMZ() {
        if (cLP() == null) {
            return true;
        }
        if (cLP().getPbData() == null || !cLP().getPbData().cLa()) {
            if (cLP().aSj()) {
                final MarkData cOf = cLP().cOf();
                if (cOf == null || !cLP().getIsFromMark() || ceG() == null) {
                    return true;
                }
                final MarkData BU = cLP().BU(ceG().getFirstVisiblePosition());
                if (BU == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cOf);
                    this.knE.setResult(-1, intent);
                    return true;
                } else if (BU.getPostId() == null || BU.getPostId().equals(cOf.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cOf);
                    this.knE.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.xl(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.kof != null) {
                                if (VideoPbFragment.this.kof.aSj()) {
                                    VideoPbFragment.this.kof.aSk();
                                    VideoPbFragment.this.kof.he(false);
                                }
                                VideoPbFragment.this.kof.a(BU);
                                VideoPbFragment.this.kof.he(true);
                                VideoPbFragment.this.kof.aSl();
                            }
                            cOf.setPostId(BU.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cOf);
                            VideoPbFragment.this.knE.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cMc();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cOf);
                            VideoPbFragment.this.knE.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cMc();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.aYL();
                    return false;
                }
            } else if (cLP().getPbData() == null || cLP().getPbData().cKz() == null || cLP().getPbData().cKz().size() <= 0 || !cLP().getIsFromMark()) {
                return true;
            } else {
                this.knE.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMc() {
        this.knE.cMc();
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
    public void ts(boolean z) {
        com.baidu.tieba.pb.data.f pbData;
        int i;
        if (cLP() != null && this.kGf != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = cLP().getPbData()) != null) {
                bv cKx = pbData.cKx();
                if (cKx != null && cKx.aWl() != null) {
                    TiebaStatic.log(new ap("c13402").dn("tid", cLP().cNL()).dn("fid", pbData.getForumId()).ah("obj_locate", 4).dn("uid", cKx.aWl().getUserId()));
                }
                if (cKx != null) {
                    if (cKx.aUT()) {
                        i = 2;
                    } else if (cKx.aUU()) {
                        i = 3;
                    } else if (cKx.aYg()) {
                        i = 4;
                    } else if (cKx.aYh()) {
                        i = 5;
                    }
                    ap apVar = new ap(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    apVar.dn("tid", cLP().cNL());
                    apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                    apVar.dn("fid", cLP().getForumId());
                    if (!z) {
                        apVar.ah("obj_locate", 6);
                    } else {
                        apVar.ah("obj_locate", 5);
                    }
                    apVar.ah("obj_name", i);
                    apVar.ah("obj_type", 2);
                    if (cKx != null) {
                        if (cKx.aUT()) {
                            apVar.ah("obj_type", 10);
                        } else if (cKx.aUU()) {
                            apVar.ah("obj_type", 9);
                        } else if (cKx.aYh()) {
                            apVar.ah("obj_type", 8);
                        } else if (cKx.aYg()) {
                            apVar.ah("obj_type", 7);
                        } else if (cKx.isShareThread) {
                            apVar.ah("obj_type", 6);
                        } else if (cKx.threadType == 0) {
                            apVar.ah("obj_type", 1);
                        } else if (cKx.threadType == 40) {
                            apVar.ah("obj_type", 2);
                        } else if (cKx.threadType == 49) {
                            apVar.ah("obj_type", 3);
                        } else if (cKx.threadType == 54) {
                            apVar.ah("obj_type", 4);
                        } else {
                            apVar.ah("obj_type", 5);
                        }
                        apVar.dn("nid", cKx.getNid());
                        apVar.ah(IntentConfig.CARD_TYPE, cKx.aYk());
                        apVar.dn(IntentConfig.RECOM_SOURCE, cKx.mRecomSource);
                        apVar.dn("ab_tag", cKx.mRecomAbTag);
                        apVar.dn("weight", cKx.mRecomWeight);
                        apVar.dn("extra", cKx.mRecomExtra);
                        apVar.dn("nid", cKx.getNid());
                        if (cKx.getBaijiahaoData() != null && !as.isEmpty(cKx.getBaijiahaoData().oriUgcVid)) {
                            apVar.dn("obj_param6", cKx.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        apVar.dn("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (cNt() != null) {
                        com.baidu.tbadk.pageInfo.c.b(cNt(), apVar);
                    }
                    TiebaStatic.log(apVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (cLP().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> cKz = pbData.cKz();
                        if ((cKz == null || cKz.size() <= 0) && cLP().cNN()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.kGf.cQo();
                        cbU();
                        TiebaStatic.log(new ap("c11939"));
                        if (!AntiHelper.d(getContext(), cKx)) {
                            if (this.kvR != null) {
                                this.kvR.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                BK(z ? 2 : 1);
                                return;
                            }
                            this.kGf.showLoadingDialog();
                            cLP().cOq().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                ap apVar2 = new ap(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                apVar2.dn("tid", cLP().cNL());
                apVar2.dn("uid", TbadkCoreApplication.getCurrentAccount());
                apVar2.dn("fid", cLP().getForumId());
                if (!z) {
                }
                apVar2.ah("obj_name", i);
                apVar2.ah("obj_type", 2);
                if (cKx != null) {
                }
                if (!as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (cNt() != null) {
                }
                TiebaStatic.log(apVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment cSS() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        J(eVar.cTy());
        K(eVar.cTy());
        if (cLP() != null && cLP().getPbData() != null) {
            boolean isFromMark = cLP().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = cLP().getPbData();
            if (isFromMark) {
                PostData I = I(pbData);
                if (pbData.aSi() != null && !pbData.aSi().equals(I.getId()) && this.dYQ != null) {
                    if (com.baidu.tbadk.a.d.aRQ()) {
                        this.dYQ.setCurrentItem(kFL);
                    } else {
                        this.dYQ.setCurrentItem(kFK);
                    }
                }
            }
        }
        eVar.cTz().observe(this, new q<bv>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aM */
            public void onChanged(@Nullable bv bvVar) {
                BdTypeRecyclerView ceG;
                if (bvVar != null && bvVar.aWD() != null) {
                    if (VideoPbFragment.this.kFS.getVideoUrl() == null || !VideoPbFragment.this.kFS.getVideoUrl().equals(bvVar.aWD().video_url)) {
                        if (!as.isEmpty(VideoPbFragment.this.kFS.getVideoUrl())) {
                            VideoPbFragment.this.knR = true;
                            if (com.baidu.tbadk.a.d.aRQ()) {
                                VideoPbFragment.this.dYQ.setCurrentItem(VideoPbFragment.kFL);
                            } else {
                                VideoPbFragment.this.dYQ.setCurrentItem(VideoPbFragment.kFJ);
                            }
                            if (com.baidu.tbadk.a.d.aRQ() && (ceG = VideoPbFragment.this.ceG()) != null) {
                                ceG.scrollToPosition(0);
                            }
                        }
                        if (VideoPbFragment.this.kFT == null || !VideoPbFragment.this.kFT.isPlaying()) {
                            VideoPbFragment.this.cST();
                            VideoPbFragment.this.aL(bvVar);
                        }
                        VideoPbFragment.this.cSU();
                        if (VideoPbFragment.this.kFT.cTM()) {
                            VideoPbFragment.this.kFT.start();
                        }
                        boolean z = !as.equals(VideoPbFragment.this.kFS.getVideoUrl(), bvVar.aWD().video_url);
                        VideoPbFragment.this.kFS.setData(bvVar);
                        if (com.baidu.tbadk.a.d.aRQ()) {
                            VideoPbFragment.this.kFS.tB(false);
                        } else {
                            VideoPbFragment.this.kFS.tB(VideoPbFragment.this.dYQ.getCurrentItem() == 0);
                        }
                        if (z) {
                            VideoPbFragment.this.kFS.startPlay();
                            VideoPbFragment.this.kFS.cUt();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.kFS.setData(bvVar);
                }
            }
        });
        eVar.cTI().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: p */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.dYQ.setCurrentItem(num.intValue());
            }
        });
        eVar.cTD().observe(this, new q<bv>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aM */
            public void onChanged(@Nullable bv bvVar) {
                VideoPbFragment.this.kFS.aQ(bvVar);
            }
        });
        eVar.cTE().observe(this, new q<bv>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aM */
            public void onChanged(@Nullable bv bvVar) {
                VideoPbFragment.this.kFS.aR(bvVar);
            }
        });
        eVar.cTF().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: n */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.cTe();
            }
        });
        eVar.cTG().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: n */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cST() {
        ViewGroup.LayoutParams layoutParams = this.kFV.getLayoutParams();
        layoutParams.height = 0;
        this.kFV.setLayoutParams(layoutParams);
        this.kFV.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSU() {
        if (this.kFT == null) {
            this.kFT = new f(getBaseFragmentActivity(), this.kFR);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(cNt()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.kFR.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.kFT.b(eVar.cTA(), rect);
            if (this.kFT.cTM()) {
                this.kFT.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (com.baidu.tbadk.a.d.aRQ()) {
                            if (eVar.cTB() || VideoPbFragment.this.cLP().getTabIndex() == VideoPbFragment.kFL) {
                                VideoPbFragment.this.dYQ.setCurrentItem(VideoPbFragment.kFL);
                            }
                        } else if (eVar.cTB() || VideoPbFragment.this.cLP().getTabIndex() == VideoPbFragment.kFK) {
                            VideoPbFragment.this.dYQ.setCurrentItem(VideoPbFragment.kFK);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (com.baidu.tbadk.a.d.aRQ()) {
                            if (eVar.cTB() || VideoPbFragment.this.cLP().getTabIndex() == VideoPbFragment.kFL) {
                                VideoPbFragment.this.dYQ.setCurrentItem(VideoPbFragment.kFL);
                            }
                        } else if (eVar.cTB() || VideoPbFragment.this.cLP().getTabIndex() == VideoPbFragment.kFK) {
                            VideoPbFragment.this.dYQ.setCurrentItem(VideoPbFragment.kFK);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (com.baidu.tbadk.a.d.aRQ()) {
                if (eVar.cTB() || cLP().getTabIndex() == kFL) {
                    this.dYQ.setCurrentItem(kFL);
                }
            } else if (eVar.cTB() || cLP().getTabIndex() == kFK) {
                this.dYQ.setCurrentItem(kFK);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.kGl && (this.kGm || cTs())) {
            cTr();
            UtilHelper.hideStatusBar(cNt(), cNt().getRootView());
            this.kGm = false;
            if (this.kFS != null) {
                this.kFS.tu(false);
            }
        }
        if (i == 4) {
            return this.kFS.cZt();
        }
        if (i == 24) {
            return this.kFS.cUq();
        }
        if (i == 25) {
            return this.kFS.cUr();
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
    public void aL(bv bvVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect cOI;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bvVar != null && bvVar.aWD() != null) {
            int intValue = bvVar.aWD().video_width.intValue();
            int intValue2 = bvVar.aWD().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (cLP() != null || (cOI = cLP().cOI()) == null) ? ceil : cOI.height();
                i = 0;
                layoutParams = this.kFR.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.kFR.setLayoutParams(layoutParams);
                this.kFR.setMaxHeight(ceil);
                this.kFR.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.kFR.setOriginHeight(height);
                if (!com.baidu.tbadk.a.d.aRQ()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.kFN.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, kFM);
                    } else {
                        layoutParams3.height = kFM;
                    }
                    this.kFN.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.WP.getLayoutParams();
                if (!com.baidu.tbadk.a.d.aRQ()) {
                    ceil += kFM;
                }
                if (layoutParams2 != null) {
                    layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                } else {
                    layoutParams2.height = ceil;
                }
                this.WP.setLayoutParams(layoutParams2);
                if (i == 0 && (this.WP.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.WP.getLayoutParams()).getBehavior();
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
        if (cLP() != null) {
        }
        i = 0;
        layoutParams = this.kFR.getLayoutParams();
        if (layoutParams != null) {
        }
        this.kFR.setLayoutParams(layoutParams);
        this.kFR.setMaxHeight(ceil2);
        this.kFR.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.kFR.setOriginHeight(height);
        if (!com.baidu.tbadk.a.d.aRQ()) {
        }
        layoutParams2 = (CoordinatorLayout.LayoutParams) this.WP.getLayoutParams();
        if (!com.baidu.tbadk.a.d.aRQ()) {
        }
        if (layoutParams2 != null) {
        }
        this.WP.setLayoutParams(layoutParams2);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.knL = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        as(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.koB = new com.baidu.tbadk.core.view.c();
        this.koB.toastTime = 1000L;
        if (this.kGf != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.kGf.koC;
            userMuteAddAndDelCustomMessage.setTag(this.kGf.koC);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.kGf.koC;
            userMuteCheckCustomMessage.setTag(this.kGf.koC);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.gXE = new com.baidu.tieba.callfans.a(getPageContext());
        com.baidu.tieba.s.c.dkh().A(getUniqueId());
    }

    private void initData() {
        this.kof = com.baidu.tbadk.baseEditMark.a.a(this.knE);
        if (this.kof != null) {
            this.kof.a(this.kpl);
        }
        this.gXC = new ForumManageModel(this.knE);
        this.gXC.setLoadDataCallBack(this.gXJ);
        this.eaU = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.kGf = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void as(Bundle bundle) {
        this.kot = new g();
        d(this.kot);
        this.kou = (com.baidu.tbadk.editortools.pb.e) this.kot.dT(getActivity());
        this.kou.a(this.knE.getPageContext());
        this.kou.a(this.eCe);
        this.kou.a(this.eBX);
        this.kou.a(this.knE.getPageContext(), bundle);
        this.kou.biJ().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.kou.biJ().iJ(true);
        sk(true);
        this.kou.a(cLP().cOb(), cLP().cNL(), cLP().cOs());
        registerListener(this.koR);
        registerListener(this.kpk);
        registerListener(this.koQ);
        registerListener(this.koO);
        registerListener(this.hHa);
        if (!cLP().cNS()) {
            this.kou.zI(cLP().cNL());
        }
        if (cLP().cOt()) {
            this.kou.zG(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.kou.zG(cPC());
        }
        this.kol = new bb();
        if (this.kou.bjk() != null) {
            this.kol.e(this.kou.bjk().getInputView());
        }
        this.kou.a(this.eBY);
        this.jqz = new al(getPageContext());
        this.jqz.a(new al.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
            @Override // com.baidu.tbadk.core.util.al.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == al.eaP) {
                        VideoPbFragment.this.kou.a((String) null, (WriteData) null);
                    } else if (i == al.eaQ && VideoPbFragment.this.kwt != null && VideoPbFragment.this.kwt.cMz() != null) {
                        VideoPbFragment.this.kwt.cMz().bjI();
                    } else if (i == al.eaR) {
                        VideoPbFragment.this.c(VideoPbFragment.this.kox);
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
        this.hKk = new com.baidu.tieba.f.b(getActivity());
        this.hKk.a(kpt);
        this.kGl = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        bmb();
        this.WP = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.kFP = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.kFR = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.kFS = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.kFR);
        this.kFS.setUniqueId(getUniqueId());
        this.kFS.af(this);
        this.kFS.cX(cNt().getRootView());
        this.kFS.cY(this.kFU);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.kFN = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.kFV = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.dYQ = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.kFQ = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.kFQ.setOnClickListener(this.awi);
        cSW();
        cSV();
        cSX();
        this.kFO = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.dYQ.setAdapter(this.kFO);
        this.kFN.setViewPager(this.dYQ);
        this.kFN.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (com.baidu.tbadk.a.d.aRQ() && VideoPbFragment.this.cTn() != null) {
                        VideoPbFragment.this.cTn().tA(false);
                    } else if (VideoPbFragment.this.cTl() != null) {
                        VideoPbFragment.this.cTl().tA(false);
                    }
                    if (VideoPbFragment.this.cTm() != null) {
                        VideoPbFragment.this.cTm().tA(true);
                        VideoPbFragment.this.Ct(VideoPbFragment.this.cTm().cTW() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.cTF() != null && eVar.cTF().getValue() != null && eVar.cTF().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.kFS.tB(z);
                    VideoPbFragment.this.cPA();
                    if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null) {
                        TiebaStatic.log(new ap("c13592").dn("tid", VideoPbFragment.this.cLP().cNL()).dn("fid", VideoPbFragment.this.cLP().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.cTm() != null) {
                        VideoPbFragment.this.cTm().tA(false);
                    }
                    if (com.baidu.tbadk.a.d.aRQ() && VideoPbFragment.this.cTn() != null) {
                        VideoPbFragment.this.cTn().tA(true);
                        int cTW = VideoPbFragment.this.cTn().cTW();
                        int cTX = VideoPbFragment.this.cTn().cTX();
                        if (cTW != 0) {
                            VideoPbFragment.this.Ct(8);
                            VideoPbFragment.this.cTn().Ct(0);
                        } else if (cTX != 0) {
                            VideoPbFragment.this.cTn().Ct(8);
                            VideoPbFragment.this.Ct(0);
                        } else {
                            VideoPbFragment.this.cTn().Ct(8);
                            VideoPbFragment.this.Ct(8);
                        }
                    } else if (VideoPbFragment.this.cTl() != null) {
                        VideoPbFragment.this.cTl().tA(true);
                        int cTW2 = VideoPbFragment.this.cTl().cTW();
                        int cTX2 = VideoPbFragment.this.cTl().cTX();
                        if (cTW2 != 0) {
                            VideoPbFragment.this.Ct(8);
                            VideoPbFragment.this.cTl().Ct(0);
                        } else if (cTX2 != 0) {
                            VideoPbFragment.this.cTl().Ct(8);
                            VideoPbFragment.this.Ct(0);
                        } else {
                            VideoPbFragment.this.cTl().Ct(8);
                            VideoPbFragment.this.Ct(8);
                        }
                    }
                    VideoPbFragment.this.kFS.tB(false);
                    VideoPbFragment.this.WP.setExpanded(false, true);
                    if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null) {
                        TiebaStatic.log(new ap("c13593").dn("tid", VideoPbFragment.this.cLP().cNL()).dn("fid", VideoPbFragment.this.cLP().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.kFO.Cv(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.kvt = this.rootView.findViewById(R.id.viewstub_progress);
        cSY();
        bBy();
        if (!this.kGl && this.kGm) {
            cTr();
            UtilHelper.hideStatusBar(cNt(), cNt().getRootView());
            this.kGm = false;
        }
        if (com.baidu.tbadk.a.d.aRQ()) {
            this.kFN.getLayoutParams().height = 0;
            this.kFN.setVisibility(8);
        }
    }

    private void cSV() {
        this.kFX = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.kGb = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.kFY = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.kFZ = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.kGa = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.kGc = this.rootView.findViewById(R.id.ala_live_point);
        this.kGb.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.kGb.setConrers(15);
        this.kGa.setConfig(new com.baidu.tbadk.core.view.commonBtn.d());
        this.kFZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.khZ == null || VideoPbFragment.this.khZ.cUh()) {
                    if (VideoPbFragment.this.khZ != null) {
                        TiebaStatic.log(new ap("c13608").dn("tid", VideoPbFragment.this.cLP().getPbData().getThreadId()));
                        VideoPbFragment.this.khZ.kIb = true;
                    }
                } else {
                    TiebaStatic.log(new ap("c13591"));
                }
                VideoPbFragment.this.cTg();
            }
        });
        this.kGa.setOnClickListener(this.kFW);
        this.kFV.setOnClickListener(this.kFW);
    }

    private void cSW() {
        this.kFN.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.kFN.setContainerLayoutParams(layoutParams);
        this.kFN.setRectPaintColor(R.color.cp_link_tip_a);
        this.kFN.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.kFN.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.kFN.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.kFN.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.kFN.setExpandedTabLayoutParams(layoutParams2);
    }

    public void tt(boolean z) {
        if (this.WP != null) {
            this.WP.setExpanded(z);
        }
    }

    private void cSX() {
        this.kvK = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.kvL = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.kvV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.kvW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.kvN = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.kvN.setVisibility(0);
        this.kvN.setIsRound(true);
        this.kvN.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
        this.kvN.setBorderColor(ao.getColor(R.color.cp_border_a));
        this.kvN.setPlaceHolder(1);
        this.kvN.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.kvN.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        this.iEW = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.kvM = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.kvM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.tt(false);
                VideoPbFragment.this.cML();
                if (VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null && VideoPbFragment.this.cLP().getPbData().cKx() != null && VideoPbFragment.this.cLP().getPbData().cKx().aWl() != null) {
                    TiebaStatic.log(new ap("c13701").dn("tid", VideoPbFragment.this.cLP().cNM()).dn("fid", VideoPbFragment.this.cLP().getPbData().getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new ap("c13402").dn("tid", VideoPbFragment.this.cLP().cNL()).dn("fid", VideoPbFragment.this.cLP().getPbData().getForumId()).ah("obj_locate", 1).dn("uid", VideoPbFragment.this.cLP().getPbData().cKx().aWl().getUserId()));
                }
            }
        });
        this.kvO = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.kvO.setOnClickListener(this.awi);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.kvP = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.kvP.setOnClickListener(this.awi);
        if (booleanExtra) {
            this.kvP.setVisibility(8);
        } else {
            this.kvP.setVisibility(0);
        }
        this.kvQ = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.kvQ.setOnClickListener(this.awi);
        this.kvR = new com.baidu.tieba.pb.view.c(this.kvQ);
        this.kvR.cUD();
        this.kvS = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.kvS.setVisibility(0);
        sT(false);
    }

    private void bmb() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cbV();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.kFU = this.rootView.findViewById(R.id.status_bar_background);
        if (this.kGl) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(cNt());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.kFU.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(cNt());
            this.kFU.setLayoutParams(layoutParams2);
            this.kFU.setVisibility(0);
        }
        this.eJG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.awi);
        this.fOc = (ImageView) this.eJG.findViewById(R.id.widget_navi_back_button);
        SvgManager.baR().a(this.fOc, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.kBn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.awi);
        this.aeV = (ImageView) this.kBn.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.kBn.setLayoutParams(layoutParams3);
        SvgManager.baR().a(this.aeV, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.kBn.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.hQN);
        this.mNavigationBar.setOnTouchListener(this.kGn);
    }

    public void cSY() {
        setEditorTools(this.kou.biJ());
    }

    private void bBy() {
        this.knz = new PbFakeFloorModel(getPageContext());
        this.kwt = new v(getPageContext(), this.knz, this.rootView);
        this.kwt.S(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cPA();
            }
        });
        this.kwt.a(this.kph);
        this.knz.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.knz.t(postData);
                if (com.baidu.tbadk.a.d.aRQ() || VideoPbFragment.this.cTn() != null) {
                    VideoPbFragment.this.cTn().cTS();
                } else if (VideoPbFragment.this.cTl() != null) {
                    VideoPbFragment.this.cTl().cTS();
                }
                VideoPbFragment.this.kwt.cMv();
                VideoPbFragment.this.ZS.bhl();
                VideoPbFragment.this.sT(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, boolean z) {
        PbActivity.a KE;
        String cNL = cLP().cNL();
        String id = postData.getId();
        int i = 0;
        if (cLP().getPbData() != null) {
            i = cLP().getPbData().cKM();
        }
        if (cTl() != null && cTl().cTU() != null) {
            KE = cTl().cTU().KE(id);
        } else if (cTn() != null && cTn().cTU() != null) {
            KE = cTn().cTU().KE(id);
        } else {
            return;
        }
        if (postData != null && cLP() != null && cLP().getPbData() != null && KE != null) {
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(cNL, id, "pb", true, null, false, null, i, postData.cSs(), cLP().getPbData().getAnti(), false, postData.aWl().getIconInfo()).addBigImageData(KE.kkt, KE.dLG, KE.dLE, KE.index);
            addBigImageData.setKeyFromForumId(cLP().getForumId());
            addBigImageData.setBjhData(cLP().cNU());
            addBigImageData.setKeyPageStartFrom(cLP().cOv());
            addBigImageData.setFromFrsForumId(cLP().getFromForumId());
            addBigImageData.setIsOpenEditor(z);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.knE = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (cLP() != null) {
            cLP().aD(bundle);
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
        this.bjZ = true;
        getVoiceManager().onPause(getPageContext());
        this.kFS.ph(true);
        if (cLP() != null && !cLP().cNS()) {
            this.kou.zH(cLP().cNL());
        }
        com.baidu.tbadk.BdToken.c.aQc().aQm();
        MessageManager.getInstance().unRegisterListener(this.kpb);
        MessageManager.getInstance().unRegisterListener(this.kpc);
        MessageManager.getInstance().unRegisterListener(this.kpd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bjZ = false;
        getVoiceManager().onResume(getPageContext());
        this.kFS.ph(false);
        cNp();
        registerListener(this.kpb);
        registerListener(this.kpc);
        registerListener(this.kpd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.kFO != null && this.dYQ != null) {
            this.kFO.Cv(z ? this.dYQ.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (this.kvN != null) {
            this.kvN.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.dkh().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dkh().B(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.kvR != null) {
            this.kvR.onDestroy();
        }
        if (this.gXC != null) {
            this.gXC.cancelLoadData();
        }
        if (this.kFS != null) {
            this.kFS.onDestroy();
        }
        if (this.knV != null) {
            this.knV.cancelLoadData();
        }
        if (this.jqz != null) {
            this.jqz.onDestroy();
        }
        if (cLP() != null) {
            cLP().cancelLoadData();
            cLP().destory();
            if (cLP().cOp() != null) {
                cLP().cOp().onDestroy();
            }
        }
        if (this.kou != null) {
            this.kou.onDestroy();
        }
        this.koB = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.knE);
        this.kFN.onChangeSkinType();
        ao.setBackgroundColor(this.kFN, R.color.cp_bg_line_h);
        this.kol.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.kFT == null || !this.kFT.isPlaying()) {
            ao.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        ao.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        ao.setBackgroundColor(this.kFU, R.color.cp_mask_b_alpha66);
        if (this.ZS != null) {
            this.ZS.onChangeSkinType(i);
        }
        if (this.kwt != null) {
            this.kwt.onChangeSkinType(i);
        }
        if (this.iEW != null) {
            ao.setViewTextColor(this.iEW, R.color.cp_cont_d);
        }
        if (this.kvN != null) {
            this.kvN.setBorderColor(ao.getColor(R.color.cp_border_a));
        }
        if (this.kvM != null) {
            this.kvM.setBackgroundDrawable(ao.aH(l.getDimens(getContext(), R.dimen.tbds47), ao.getColor(R.color.cp_bg_line_j)));
        }
        if (this.kvP != null && cLP() != null) {
            if (cLP().aSj()) {
                SvgManager.baR().a(this.kvP, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.baR().a(this.kvP, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.kvO != null) {
            SvgManager.baR().a(this.kvO, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (cLP() != null) {
            x(cLP().getPbData());
        }
        if (this.kvS != null) {
            ao.c(this.kvS, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_cont_h, R.color.cp_cont_h);
            ao.setViewTextColor(this.kvS, R.color.cp_cont_a);
        }
        if (this.kvT != null) {
            ao.setViewTextColor(this.kvT, R.color.cp_cont_b);
        }
        if (this.kvK != null) {
            ao.setBackgroundResource(this.kvK, R.drawable.bottom_shadow);
        }
        ao.setBackgroundColor(this.kvL, R.color.cp_bg_line_h);
        if (com.baidu.tbadk.a.d.aRQ() && cTn() != null) {
            cTn().onChangeSkinType(i);
        } else if (cTl() != null) {
            cTl().onChangeSkinType(i);
        }
        if (cTm() != null) {
            cTm().onChangeSkinType(i);
        }
        if (this.kFP != null) {
            ao.setBackgroundResource(this.kFP, R.drawable.personalize_tab_shadow);
        }
        if (this.kFV != null) {
            ao.setBackgroundColor(this.kFV, R.color.cp_bg_line_g);
        }
        if (this.kFZ != null) {
            SvgManager.baR().a(this.kFZ, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.kFX != null) {
            ao.setViewTextColor(this.kFX, R.color.cp_cont_b);
        }
        if (this.kFY != null) {
            ao.setViewTextColor(this.kFY, R.color.cp_cont_d);
        }
        if (this.kGc != null) {
            this.kGc.setBackgroundDrawable(ao.aH(l.getDimens(this.kGc.getContext(), R.dimen.tbds32), ao.getColor(R.color.cp_other_c)));
        }
        cbU();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hFy == null) {
            this.hFy = VoiceManager.instance();
        }
        return this.hFy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbU() {
        if (this.hFy != null) {
            this.hFy.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cNr() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cNs() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel cLP() {
        return this.knE.cLP();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cNt() {
        return this.knE;
    }

    public com.baidu.tbadk.baseEditMark.a cSZ() {
        return this.kof;
    }

    public View.OnClickListener cTa() {
        return this.awi;
    }

    public View.OnClickListener cTb() {
        return this.kkY;
    }

    public View.OnLongClickListener cTc() {
        return this.kGf.cTc();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (be.KT(objArr[i].getLink()) && (drawable = ao.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView ceG() {
        Iterator<BaseFragment> it = this.kFO.cTw().iterator();
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

    private void sk(boolean z) {
        this.kou.iN(z);
        this.kou.iO(z);
        this.kou.iP(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.kGf != null) {
            if (z) {
                this.kGf.cQo();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.kGf.cQp();
            } else {
                this.kGf.cQo();
            }
        }
    }

    public boolean BI(int i) {
        if (this.jqz == null || cLP() == null || cLP().getPbData() == null || cLP().getPbData().getAnti() == null) {
            return true;
        }
        return this.jqz.aG(cLP().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean cMN() {
        if ((cLP() != null && cLP().getPbData().cLa()) || this.jqz == null || cLP() == null || cLP().getPbData() == null || cLP().getPbData().getAnti() == null) {
            return true;
        }
        return this.jqz.lJ(cLP().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && cLP() != null) {
            gVar.setForumName(cLP().cLG());
            if (cLP().getPbData() != null && cLP().getPbData().getForum() != null) {
                gVar.a(cLP().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(cLP());
        }
    }

    public void cPQ() {
        if (this.ZS != null) {
            this.ZS.display();
            if (this.kou != null) {
                this.kou.bjp();
            }
            cQy();
        }
    }

    public com.baidu.tbadk.editortools.pb.e cMA() {
        return this.kou;
    }

    private boolean cMK() {
        PbModel cLP = cLP();
        if (cLP == null || cLP.getPbData() == null) {
            return false;
        }
        bv cKx = cLP.getPbData().cKx();
        cLP.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cKx);
    }

    public void cML() {
        if (checkUpIsLogin() && cLP() != null && cLP().getPbData() != null && cLP().getPbData().getForum() != null && !cMK()) {
            if (cLP().getPbData().cLa()) {
                cok();
                return;
            }
            if (this.hJL == null) {
                this.hJL = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hJL.vY(0);
                this.hJL.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void nQ(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void z(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void nR(boolean z) {
                        if (z) {
                            if (VideoPbFragment.this.kou != null && VideoPbFragment.this.kou.biJ() != null) {
                                VideoPbFragment.this.kou.biJ().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            VideoPbFragment.this.cok();
                        }
                    }
                });
            }
            this.hJL.B(cLP().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cLP().cNL(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.kou.onActivityResult(i, i2, intent);
        if (this.knV != null) {
            this.knV.onActivityResult(i, i2, intent);
        }
        if (this.kwt != null) {
            this.kwt.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cMX();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dbG().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.kox = emotionImageData;
                        if (BI(al.eaR)) {
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
        if (cNt() != null) {
            if (this.kGm && !TbSingleton.getInstance().isNotchScreen(cNt()) && !TbSingleton.getInstance().isCutoutScreen(cNt())) {
                cTr();
                UtilHelper.hideStatusBar(cNt(), cNt().getRootView());
                this.kGm = false;
            }
            this.kGg.kGB = z;
            cTd();
            cTe();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.knE;
        if (i == 0) {
            cPw();
            if (this.kwt != null) {
                this.kwt.cMv();
            }
            sT(false);
        }
        cPA();
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
                        this.kou.resetData();
                        this.kou.setVoiceModel(pbEditorData.getVoiceModel());
                        this.kou.b(writeData);
                        com.baidu.tbadk.editortools.l nT = this.kou.biJ().nT(6);
                        if (nT != null && nT.ezZ != null) {
                            nT.ezZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.knE;
                        if (i == -1) {
                            this.kou.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.kwt != null && this.kwt.cMz() != null) {
                            h cMz = this.kwt.cMz();
                            cMz.setThreadData(cLP().getPbData().cKx());
                            cMz.b(writeData);
                            cMz.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l nT2 = cMz.biJ().nT(6);
                            if (nT2 != null && nT2.ezZ != null) {
                                nT2.ezZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.knE;
                            if (i == -1) {
                                cMz.bjI();
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
                if (cLP() != null && !cLP().cNS()) {
                    antiData.setBlock_forum_name(cLP().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(cLP().getPbData().getForum().getId());
                    antiData.setUser_name(cLP().getPbData().getUserData().getUserName());
                    antiData.setUser_id(cLP().getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bB(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ah("obj_locate", aw.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ah("obj_locate", aw.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ah("obj_locate", aw.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.kGf != null) {
                this.kGf.zN(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void cNv() {
        if (cLP() != null && this.knE != null) {
            if (this.kou == null || !this.kou.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.kou = (com.baidu.tbadk.editortools.pb.e) dVar.dT(getContext());
                this.kou.a(this.knE.getPageContext());
                this.kou.a(this.eCe);
                this.kou.a(this.eBX);
                this.kou.a(this.knE.getPageContext(), this.knE.getIntent() == null ? null : this.knE.getIntent().getExtras());
                this.kou.biJ().iJ(true);
                setEditorTools(this.kou.biJ());
                if (!cLP().cNS()) {
                    this.kou.zI(cLP().cNL());
                }
                if (cLP().cOt()) {
                    this.kou.zG(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.kou.zG(cPC());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.ZS = editorTools;
        this.ZS.setId(R.id.pb_editor);
        this.ZS.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cPA();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.ZS.getParent() == null) {
            this.rootView.addView(this.ZS, layoutParams);
        }
        this.ZS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.ZS.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).bef() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).bef() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.kou.c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            VideoPbFragment.this.kou.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cPw();
        this.kou.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.ZS != null && VideoPbFragment.this.ZS.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.kol != null && VideoPbFragment.this.kol.cQO() != null) {
                    if (!VideoPbFragment.this.kol.cQO().duc()) {
                        VideoPbFragment.this.kol.sZ(false);
                    }
                    VideoPbFragment.this.kol.cQO().wj(false);
                }
            }
        });
    }

    public void cok() {
        if (!checkUpIsLogin()) {
            if (cLP() != null) {
                TiebaStatic.log(new ap("c10517").ah("obj_locate", 2).dn("fid", cLP().getForumId()));
            }
        } else if (cMN()) {
            if (this.kou != null && (this.kou.bjz() || this.kou.bjA())) {
                this.kou.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.ZS != null) {
                cPQ();
                this.kGg.kGA = false;
                if (this.ZS.nT(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.ZS.nT(2).ezZ, false, null);
                }
            }
            cQy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !cMK() && cMN()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.knX);
                this.knY = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.kwt != null && postData != null) {
                String str3 = "";
                if (postData.dlk() != null) {
                    str3 = postData.dlk().toString();
                }
                this.kwt.Ky(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.aWl().getName_show(), str3));
            }
            if (cLP() != null && cLP().getPbData() != null && cLP().getPbData().cLa()) {
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.knE.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.knX[1] + VideoPbFragment.this.knY) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.ceG() != null) {
                            VideoPbFragment.this.ceG().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.kwt != null) {
                            VideoPbFragment.this.kou.biJ().setVisibility(8);
                            VideoPbFragment.this.kwt.g(str, str2, VideoPbFragment.this.cPC(), (VideoPbFragment.this.cLP() == null || VideoPbFragment.this.cLP().getPbData() == null || VideoPbFragment.this.cLP().getPbData().cKx() == null || !VideoPbFragment.this.cLP().getPbData().cKx().isBjh()) ? false : true);
                            h cMz = VideoPbFragment.this.kwt.cMz();
                            if (cMz != null && VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null) {
                                cMz.a(VideoPbFragment.this.cLP().getPbData().getAnti());
                                cMz.setThreadData(VideoPbFragment.this.cLP().getPbData().cKx());
                            }
                            if (VideoPbFragment.this.kol.cQQ() == null && VideoPbFragment.this.kwt.cMz().bjQ() != null) {
                                VideoPbFragment.this.kwt.cMz().bjQ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kol != null && VideoPbFragment.this.kol.cQP() != null) {
                                            if (!VideoPbFragment.this.kol.cQP().duc()) {
                                                VideoPbFragment.this.kol.ta(false);
                                            }
                                            VideoPbFragment.this.kol.cQP().wj(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kol.f(VideoPbFragment.this.kwt.cMz().bjQ().getInputView());
                                VideoPbFragment.this.kwt.cMz().a(VideoPbFragment.this.koz);
                            }
                        }
                        VideoPbFragment.this.cQy();
                    }
                }, 0L);
                return;
            }
            if (this.kow == null) {
                this.kow = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.kow.vY(1);
                this.kow.a(new AnonymousClass47(str, str2));
            }
            if (cLP() != null && cLP().getPbData() != null && cLP().getPbData().getForum() != null) {
                this.kow.B(cLP().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cLP().cNL(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$47  reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass47 implements c.a {
        final /* synthetic */ String kpD;
        final /* synthetic */ String kpE;

        AnonymousClass47(String str, String str2) {
            this.kpD = str;
            this.kpE = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nQ(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nR(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.knX[1] + VideoPbFragment.this.knY) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.ceG() != null) {
                            VideoPbFragment.this.ceG().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.kwt != null) {
                            VideoPbFragment.this.kou.biJ().setVisibility(8);
                            VideoPbFragment.this.kwt.g(AnonymousClass47.this.kpD, AnonymousClass47.this.kpE, VideoPbFragment.this.cPC(), (VideoPbFragment.this.cLP() == null || VideoPbFragment.this.cLP().getPbData() == null || VideoPbFragment.this.cLP().getPbData().cKx() == null || !VideoPbFragment.this.cLP().getPbData().cKx().isBjh()) ? false : true);
                            h cMz = VideoPbFragment.this.kwt.cMz();
                            if (cMz != null && VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null) {
                                cMz.a(VideoPbFragment.this.cLP().getPbData().getAnti());
                                cMz.setThreadData(VideoPbFragment.this.cLP().getPbData().cKx());
                            }
                            if (VideoPbFragment.this.kol.cQQ() == null && VideoPbFragment.this.kwt.cMz().bjQ() != null) {
                                VideoPbFragment.this.kwt.cMz().bjQ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kol != null && VideoPbFragment.this.kol.cQP() != null) {
                                            if (!VideoPbFragment.this.kol.cQP().duc()) {
                                                VideoPbFragment.this.kol.ta(false);
                                            }
                                            VideoPbFragment.this.kol.cQP().wj(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kol.f(VideoPbFragment.this.kwt.cMz().bjQ().getInputView());
                                VideoPbFragment.this.kwt.cMz().a(VideoPbFragment.this.koz);
                            }
                        }
                        VideoPbFragment.this.cQy();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData I;
        aa aaVar;
        StringBuilder sb = null;
        if (fVar != null && (I = I(fVar)) != null) {
            String userId = I.aWl().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, I.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cKM()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (I.aWl() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, I.aWl().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, I.aWl().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, I.aWl().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, I.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, I.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cKM()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<br> cKU = fVar.cKU();
                if (x.getCount(cKU) > 0) {
                    sb = new StringBuilder();
                    for (br brVar : cKU) {
                        if (brVar != null && !StringUtils.isNull(brVar.getForumName()) && (aaVar = brVar.dRa) != null && aaVar.dON && !aaVar.dOO && (aaVar.type == 1 || aaVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(brVar.getForumName(), 12)).append(TbadkCoreApplication.getInst().getString(R.string.forum)).append("、");
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
    public void cMX() {
        MarkData BU;
        if (cLP() != null && cLP().getPbData() != null && cTl() != null) {
            if ((!com.baidu.tbadk.a.d.aRQ() || cTn() != null) && this.kof != null) {
                if (cLP().getPbData() != null && cLP().getPbData().cLa()) {
                    BU = cLP().BU(0);
                } else if (this.dYQ != null && this.dYQ.getCurrentItem() == kFJ) {
                    BU = cLP().o(I(cLP().getPbData()));
                } else if (com.baidu.tbadk.a.d.aRQ()) {
                    BU = cLP().BU(cTn().cQa());
                } else {
                    BU = cLP().BU(cTl().cQa());
                }
                if (BU != null) {
                    if (!BU.isApp() || (BU = cLP().BU(cTl().cQa() + 1)) != null) {
                        cPV();
                        this.kof.a(BU);
                        if (!this.kof.aSj()) {
                            this.kof.aSl();
                            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                            return;
                        }
                        this.kof.aSk();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BJ(int i) {
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
            if (this.knV == null) {
                this.knV = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.knE);
                this.knV.b(this.eBX);
                this.knV.c(this.eCe);
            }
            this.knV.a(emotionImageData, cLP(), cLP().getPbData());
        }
    }

    public PostData I(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.cKK() != null) {
            return fVar.cKK();
        }
        if (!x.isEmpty(fVar.cKz())) {
            Iterator<PostData> it = fVar.cKz().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dli() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.cKG();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.aWl() != null && postData.aWl().getUserTbVipInfoData() != null && postData.aWl().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aWl().getGodUserData().setIntro(postData.aWl().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.cKx() == null || fVar.cKx().aWl() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aWl = fVar.cKx().aWl();
        String userId = aWl.getUserId();
        HashMap<String, MetaData> userMap = fVar.cKx().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aWl;
        }
        postData.Fs(1);
        postData.setId(fVar.cKx().aWC());
        postData.setTitle(fVar.cKx().getTitle());
        postData.setTime(fVar.cKx().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cNc() {
        ArrayList<PostData> cKz;
        int count;
        int i;
        if (cLP() == null || cLP().getPbData() == null || cLP().getPbData().cKz() == null || (count = x.getCount((cKz = cLP().getPbData().cKz()))) == 0) {
            return "";
        }
        if (cLP().cOd()) {
            Iterator<PostData> it = cKz.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dli() == 1) {
                    return next.getId();
                }
            }
        }
        if (ceG() == null) {
            i = 0;
        } else if (com.baidu.tbadk.a.d.aRQ()) {
            i = cTn().cPZ();
        } else {
            i = cTl().cPZ();
        }
        PostData postData = (PostData) x.getItem(cKz, i);
        if (postData == null || postData.aWl() == null) {
            return "";
        }
        if (cLP().KH(postData.aWl().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) x.getItem(cKz, i2);
            if (postData2 == null || postData2.aWl() == null || postData2.aWl().getUserId() == null) {
                break;
            } else if (cLP().KH(postData2.aWl().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) x.getItem(cKz, i3);
            if (postData3 == null || postData3.aWl() == null || postData3.aWl().getUserId() == null) {
                return "";
            }
            if (cLP().KH(postData3.aWl().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMY() {
        if (cLP() != null) {
            com.baidu.tieba.pb.data.f pbData = cLP().getPbData();
            cLP().sy(true);
            if (this.kof != null) {
                pbData.Kr(this.kof.aSi());
            }
            if (com.baidu.tbadk.a.d.aRQ() && cTn() != null) {
                cTn().cTS();
            } else if (cTl() != null) {
                cTl().cTS();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (cLP() != null) {
            cPX();
            cLP().sy(z);
            if (this.kof != null) {
                this.kof.he(z);
                if (markData != null) {
                    this.kof.a(markData);
                }
            }
            if (cLP().aSj()) {
                cMY();
            } else if (com.baidu.tbadk.a.d.aRQ() && cTn() != null) {
                cTn().cTS();
            } else if (cTl() != null) {
                cTl().cTS();
            }
        }
    }

    public void b(p pVar) {
        MetaData metaData;
        boolean z = true;
        if (cLP() != null && cLP().getPbData() != null && pVar.cLt() != null) {
            String id = pVar.cLt().getId();
            ArrayList<PostData> cKz = cLP().getPbData().cKz();
            int i = 0;
            while (true) {
                if (i >= cKz.size()) {
                    break;
                }
                PostData postData = cKz.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cLx = pVar.cLx();
                    postData.Fr(pVar.getTotalCount());
                    if (postData.dlf() != null && cLx != null) {
                        Iterator<PostData> it = cLx.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aWl() != null && (metaData = postData.getUserMap().get(next.aWl().getUserId())) != null) {
                                next.a(metaData);
                                next.vn(true);
                                next.a(getPageContext(), cLP().KH(metaData.getUserId()));
                            }
                        }
                        boolean z2 = cLx.size() != postData.dlf().size();
                        postData.dlf().clear();
                        postData.dlf().addAll(cLx);
                        z = z2;
                    }
                    if (postData.dlb() != null) {
                        postData.dlc();
                    }
                }
            }
            if (!cLP().getIsFromMark() && z) {
                if (com.baidu.tbadk.a.d.aRQ() && cTn() != null) {
                    cTn().cTS();
                } else if (cTl() != null) {
                    cTl().cTS();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMP() {
        if (cLP() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.MZ(cLP().getForumId()) && cLP().getPbData() != null && cLP().getPbData().getForum() != null) {
            if (cLP().getPbData().getForum().isLike() == 1) {
                cLP().cOr().fs(cLP().getForumId(), cLP().cNL());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            bv cKx = fVar.cKx();
            if (cKx != null && cKx.aUV()) {
                cNv();
            } else {
                d(this.kot);
            }
            if (this.kou != null) {
                sR(this.kou.bjs());
                this.kou.a(fVar.getAnti());
                this.kou.a(fVar.getForum(), fVar.getUserData());
                this.kou.setThreadData(cKx);
                if (cLP() != null) {
                    this.kou.a(cLP().cOb(), cLP().cNL(), cLP().cOs());
                }
                if (cKx != null) {
                    this.kou.iQ(cKx.aXI());
                }
            }
        }
    }

    public void cPA() {
        reset();
        cPw();
        this.kwt.cMv();
        sT(false);
    }

    private void reset() {
        if (this.kou != null && this.ZS != null) {
            com.baidu.tbadk.editortools.pb.a.bjh().setStatus(0);
            this.kou.bjC();
            this.kou.biU();
            if (this.kou.getWriteImagesInfo() != null) {
                this.kou.getWriteImagesInfo().setMaxImagesAllowed(this.kou.isBJH ? 1 : 9);
            }
            this.kou.nZ(SendView.ALL);
            this.kou.oa(SendView.ALL);
            com.baidu.tbadk.editortools.g nQ = this.ZS.nQ(23);
            com.baidu.tbadk.editortools.g nQ2 = this.ZS.nQ(2);
            com.baidu.tbadk.editortools.g nQ3 = this.ZS.nQ(5);
            if (nQ2 != null) {
                nQ2.display();
            }
            if (nQ3 != null) {
                nQ3.display();
            }
            if (nQ != null) {
                nQ.hide();
            }
            this.ZS.invalidate();
        }
    }

    public void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cKx() != null) {
            x(fVar);
            this.kvP.setVisibility(fVar.cLa() ? 8 : 0);
            if (fVar.aSj()) {
                SvgManager.baR().a(this.kvP, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.baR().a(this.kvP, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String Cc = Cc(fVar.cKx().aWc());
            if (this.kvS != null) {
                this.kvS.setText(Cc);
            }
            if (this.kvT != null) {
                this.kvT.setText(Cc);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.cKx()));
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.aX(fVar.cKx())) {
            if (this.kvR != null) {
                this.kvR.setEnable(false);
                this.kvR.onDestroy();
            }
            SvgManager.baR().a(this.kvQ, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.kvR == null || !this.kvR.isEnable()) {
            SvgManager.baR().a(this.kvQ, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private String Cc(int i) {
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

    public void sT(boolean z) {
        if (this.kvL != null) {
            sR(this.kou.bjs());
            if (this.kvH) {
                sI(z);
            } else {
                sJ(z);
            }
            cTd();
            cTe();
        }
    }

    public void cQy() {
        if (this.kvL != null) {
            this.kvK.setVisibility(8);
            this.kvL.setVisibility(8);
            this.kGg.kGA = false;
            cTd();
            cTe();
        }
    }

    private void cTd() {
        if (this.kFS != null) {
            if (this.kGg.cTv()) {
                this.kFS.uq(false);
            } else {
                this.kFS.uq(this.kFS.bDD() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTe() {
        if (this.kFS != null && this.dYQ != null) {
            if (com.baidu.tbadk.a.d.aRQ()) {
                this.kFS.tB(false);
            } else if (this.dYQ.getCurrentItem() != 0) {
                this.kFS.tB(false);
            } else if (this.kGg.cTv()) {
                this.kFS.tB(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.kFS.tB(eVar.cTF() == null || eVar.cTF().getValue() == null || eVar.cTF().getValue().booleanValue());
                }
            }
        }
    }

    private void BK(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(cNt(), cMO(), i);
    }

    private int cMO() {
        if (cLP() == null || cLP().getPbData() == null || cLP().getPbData().cKx() == null) {
            return -1;
        }
        return cLP().getPbData().cKx().aWY();
    }

    public void sR(boolean z) {
        this.kvH = z;
    }

    public void sI(boolean z) {
        if (this.kvL != null && this.iEW != null) {
            this.iEW.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kvL.startAnimation(alphaAnimation);
            }
            this.kvK.setVisibility(0);
            this.kvL.setVisibility(0);
            this.kGg.kGA = true;
        }
    }

    public void sJ(boolean z) {
        if (this.kvL != null && this.iEW != null) {
            this.iEW.setText(cPC());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kvL.startAnimation(alphaAnimation);
            }
            this.kvK.setVisibility(0);
            this.kvL.setVisibility(0);
            this.kGg.kGA = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null && this.khZ == null) {
            this.khZ = aVar;
            this.kFX.setText(aVar.getTitle());
            this.kFY.setText(aVar.cUe());
            String cUf = aVar.cUf();
            TBSpecificationBtn tBSpecificationBtn = this.kGa;
            if (TextUtils.isEmpty(cUf)) {
                cUf = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(cUf);
            this.kGb.startLoad(aVar.getImage(), 10, false);
            this.kGc.setVisibility(aVar.cUh() ? 0 : 8);
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.khZ == null || VideoPbFragment.this.khZ.cUh()) {
                        if (VideoPbFragment.this.khZ != null && VideoPbFragment.this.cLP() != null && VideoPbFragment.this.cLP().getPbData() != null && VideoPbFragment.this.cLP().getPbData().getForum() != null) {
                            TiebaStatic.log(new ap("c13712").dn("fid", VideoPbFragment.this.cLP().getPbData().getForum().getId()).dn("fname", VideoPbFragment.this.cLP().getPbData().getForum().getName()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("tid", VideoPbFragment.this.cLP().getPbData().getThreadId()).t("obj_param1", VideoPbFragment.this.khZ.userId));
                        }
                    } else {
                        TiebaStatic.log(new ap("c13608").dn("obj_id", VideoPbFragment.this.khZ.getTitle()).dn("obj_name", VideoPbFragment.this.khZ.cUe()).ah("obj_type", 2).dn("fid", VideoPbFragment.this.cLP().getPbData().getForumId()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("tid", VideoPbFragment.this.cLP().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.cTf();
                }
            }, aVar.cUg().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTf() {
        ViewGroup.LayoutParams layoutParams = this.kFV.getLayoutParams();
        if (layoutParams != null) {
            if (this.kGd == null || !this.kGd.isRunning()) {
                this.kFV.setAlpha(0.0f);
                this.kFV.setVisibility(0);
                e(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTg() {
        if (this.kFV.getLayoutParams() != null) {
            if (this.kGd == null || !this.kGd.isRunning()) {
                cTh();
            }
        }
    }

    private void cTh() {
        final ViewGroup.LayoutParams layoutParams = this.kFV.getLayoutParams();
        if (layoutParams != null) {
            if (this.kGe == null || !this.kGe.isRunning()) {
                this.kGe = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.kGe.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.kFV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.kGe.setDuration(200L);
                this.kGe.start();
                this.kGe.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
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
        final ViewGroup.LayoutParams layoutParams2 = this.WP.getLayoutParams();
        final int i = layoutParams2.height;
        this.kGd = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kGd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.iBx);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.iBx);
                VideoPbFragment.this.kFV.setLayoutParams(layoutParams);
                VideoPbFragment.this.WP.setLayoutParams(layoutParams2);
            }
        });
        this.kGd.setDuration(300L);
        this.kGd.start();
        this.kGd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.kFV.setVisibility(8);
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
        final ViewGroup.LayoutParams layoutParams2 = this.WP.getLayoutParams();
        final int i = layoutParams2.height;
        this.kGd = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kGd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.iBx);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.kFV.setLayoutParams(layoutParams);
                VideoPbFragment.this.WP.setLayoutParams(layoutParams2);
            }
        });
        this.kGd.setDuration(300L);
        this.kGd.start();
        this.kGd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.cTi();
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
    public void cTi() {
        this.kGd = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kGd.setDuration(300L);
        this.kGd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.kFV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.kGd.start();
    }

    public String cPC() {
        if (!as.isEmpty(this.kwK)) {
            return this.kwK;
        }
        this.kwK = TbadkCoreApplication.getInst().getResources().getString(ay.cPr());
        return this.kwK;
    }

    public void cPX() {
        hideProgressBar();
        if (com.baidu.tbadk.a.d.aRQ() && cTn() != null) {
            cTn().endLoadData();
            cTn().cPY();
        } else if (cTl() != null) {
            cTl().endLoadData();
            cTl().cPY();
        }
    }

    public boolean cI(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.aTv().isShowImages()) {
                    return KD(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (cLP() == null || cLP().getPbData() == null) {
                        return true;
                    }
                    if (this.kwt != null) {
                        this.kwt.cMv();
                    }
                    p pVar = new p();
                    pVar.a(cLP().getPbData().getForum());
                    pVar.setThreadData(cLP().getPbData().cKx());
                    pVar.g(postData);
                    this.knz.d(pVar);
                    this.knz.setPostId(postData.getId());
                    a(view, postData.aWl().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.kou != null) {
                        sR(this.kou.bjs());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void cTj() {
        if (this.kou != null) {
            sR(this.kou.bjs());
        }
        cPA();
        this.kGf.cQo();
    }

    private boolean KD(String str) {
        if (!StringUtils.isNull(str) && bf.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString("bubble_link", "");
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

    public void cvF() {
        if (this.kvt != null) {
            this.kvt.setVisibility(0);
        }
    }

    public void cvE() {
        if (this.kvt != null) {
            this.kvt.setVisibility(8);
        }
    }

    public void Ct(int i) {
        if (this.kFP != null) {
            this.kFP.setVisibility(i);
        }
    }

    public void cPV() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a cMS() {
        return this.kpj;
    }

    public void cPw() {
        if (this.ZS != null) {
            this.ZS.hide();
        }
    }

    public void cbV() {
        if (this.knE.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.knE.getCurrentFocus());
        }
    }

    public void K(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cKx() != null) {
            String valueOf = String.valueOf(fVar.cKx().aWc());
            if (fVar.cKx().aWc() == 0) {
                valueOf = "";
            }
            this.kFN.AG(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.kFO.cTw()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (cLP() != null && cLP().getPbData() != null && cLP().getPbData().cKx() != null && cLP().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(kwm)).intValue();
                if (intValue == kwn) {
                    if (!this.gXC.dlV()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.gXC.NR(as.P(jSONArray));
                        }
                        this.gXC.a(cLP().getPbData().getForum().getId(), cLP().getPbData().getForum().getName(), cLP().getPbData().cKx().getId(), str, intValue3, intValue2, booleanValue, cLP().getPbData().cKx().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == kwo || intValue == kwq) {
                    if (cLP().cOo() != null) {
                        cLP().cOo().BE(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == kwo) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dU(String str, String str2) {
        bd.baV().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bpt() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> bpu() {
        if (this.eRG == null) {
            this.eRG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bpG */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.aTv().isShowImages();
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
                        if (com.baidu.tbadk.core.k.aTv().isShowImages()) {
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
        return this.eRG;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> bpv() {
        if (this.eUX == null) {
            this.eUX = TbRichTextView.w(getPageContext().getPageActivity(), 8);
        }
        return this.eUX;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> bpw() {
        if (this.eRH == null) {
            this.eRH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bWl */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.aTv().isShowImages();
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
                    if (com.baidu.tbadk.core.k.aTv().isShowImages()) {
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
                    gifView.bki();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.eRH;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bpx() {
        if (this.eUY == null) {
            this.eUY = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cNw */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cL */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cM */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).bFz();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cN */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.eUY;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bpy() {
        if (this.eUZ == null) {
            this.eUZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cNy */
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
        return this.eUZ;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> bpz() {
        this.eVa = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cNx */
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
        return this.eVa;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void am(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.knP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (be.KT(str) && cLP() != null && cLP().cNL() != null) {
            TiebaStatic.log(new ap("c11664").ah("obj_param1", 1).dn("post_id", cLP().cNL()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.ezd = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
            }
        } else {
            be.cQS().f(getPageContext(), str);
        }
        this.knP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void an(Context context, String str) {
        be.cQS().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.knP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ap(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void r(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.kGf.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b cTP = this.kGf.cTP();
            if (cTP == null) {
                this.kGf.cMJ();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                cTP.getItemView(1).setVisibility(8);
            } else {
                cTP.getItemView(1).setVisibility(0);
            }
            cTP.aYN();
            this.knP = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aq(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            bd.baV().b(getPageContext(), new String[]{str});
            this.knP = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a cTk() {
        return this.eaU;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bmU() {
        return this.eKY;
    }

    public ReplyFragment cTl() {
        if (this.kFO == null || !(this.kFO.Cu(kFK) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.kFO.Cu(kFK);
    }

    public DetailInfoFragment cTm() {
        if (this.kFO == null || !(this.kFO.Cu(kFJ) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.kFO.Cu(kFJ);
    }

    public DetailInfoAndReplyFragment cTn() {
        if (this.kFO == null || !(this.kFO.Cu(kFL) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.kFO.Cu(kFL);
    }

    public boolean cLF() {
        PbModel cLP = this.knE.cLP();
        if (cLP == null) {
            return false;
        }
        return cLP.cLF();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cKJ;
        PbModel cLP = this.knE.cLP();
        if (cLP != null && cLP.getPbData() != null && !cLP.getPbData().cLa()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = cLP.getPbData().cKx().getId();
            if (cLP.isShareThread() && cLP.getPbData().cKx().dUi != null) {
                historyMessage.threadName = cLP.getPbData().cKx().dUi.showText;
            } else {
                historyMessage.threadName = cLP.getPbData().cKx().getTitle();
            }
            if (cLP.isShareThread() && !cLF()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = cLP.getPbData().getForum().getName();
            }
            ArrayList<PostData> cKz = cLP.getPbData().cKz();
            int cPZ = cTl() != null ? cTl().cPZ() : 0;
            if (cKz != null && cPZ >= 0 && cPZ < cKz.size()) {
                historyMessage.postID = cKz.get(cPZ).getId();
            }
            historyMessage.isHostOnly = cLP.getHostMode();
            historyMessage.isSquence = cLP.cNN();
            historyMessage.isShareThread = cLP.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.kou != null) {
            this.kou.onDestroy();
        }
        if (cLP != null && (cLP.cNO() || cLP.cNQ())) {
            Intent intent = new Intent();
            intent.putExtra("tid", cLP.cNL());
            if (this.koi) {
                if (this.kok) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", cLP.bUx());
                }
                if (this.koj) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", cLP.getIsGood());
                }
            }
            if (cLP.getPbData() != null && System.currentTimeMillis() - this.knL >= 40000 && (cKJ = cLP.getPbData().cKJ()) != null && !x.isEmpty(cKJ.getDataList())) {
                intent.putExtra("guess_like_data", cKJ);
            }
            PbActivity pbActivity = this.knE;
            PbActivity pbActivity2 = this.knE;
            pbActivity.setResult(-1, intent);
        }
        if (cMZ()) {
            if (cLP != null) {
                com.baidu.tieba.pb.data.f pbData = cLP.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.knR) {
                        if (this.kFR != null) {
                            Rect rect = new Rect();
                            this.kFR.getGlobalVisibleRect(rect);
                            com.baidu.tieba.pb.pb.main.as.cPg().h(rect);
                        }
                        com.baidu.tieba.pb.pb.main.as.cPg().BY(this.dYQ.getCurrentItem());
                        BdTypeRecyclerView ceG = ceG();
                        Parcelable parcelable = null;
                        if (ceG != null) {
                            parcelable = ceG.onSaveInstanceState();
                        }
                        com.baidu.tieba.pb.pb.main.as.cPg().a(cLP.cNV(), parcelable, cLP.cNN(), cLP.getHostMode(), false);
                    }
                }
            } else {
                com.baidu.tieba.pb.pb.main.as.cPg().reset();
            }
            cMc();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.kFS != null && !this.kFS.bDD()) {
            if ((this.kFS.isFullScreen() && configuration.orientation == 1) || (!this.kFS.isFullScreen() && configuration.orientation == 2)) {
                this.kFS.tC(false);
            }
        }
    }

    public boolean cTo() {
        if (this.kFS == null) {
            return false;
        }
        return this.kFS.bDD();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.dkh().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class a {
        public boolean kGA;
        public boolean kGB;

        private a() {
            this.kGB = true;
        }

        public boolean cTv() {
            return (this.kGA && this.kGB) ? false : true;
        }
    }

    public void cTp() {
        this.knZ = -1;
        this.koa = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNp() {
        if (cLP() != null && !as.isEmpty(cLP().cNL())) {
            com.baidu.tbadk.BdToken.c.aQc().p(com.baidu.tbadk.BdToken.b.dEx, com.baidu.adp.lib.f.b.toLong(cLP().cNL(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.kFQ.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTq() {
        if (this.kGp == null) {
            this.kGp = ObjectAnimator.ofFloat(this.kFU, "alpha", 0.0f, 1.0f);
            this.kGp.setDuration(200L);
        }
        this.kGp.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTr() {
        if (this.kGq == null) {
            this.kGq = ObjectAnimator.ofFloat(this.kFU, "alpha", 1.0f, 0.0f);
            this.kGq.setDuration(200L);
        }
        this.kGq.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cTs() {
        return this.kFS != null && this.kFS.cTt();
    }

    public boolean cTt() {
        return this.kGm;
    }

    public void tu(boolean z) {
        this.kGm = z;
    }
}
