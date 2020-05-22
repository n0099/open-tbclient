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
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.g;
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
import com.baidu.tbadk.widget.richText.h;
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
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.pb.pb.main.ax;
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
public class VideoPbFragment extends BaseFragment implements VoiceManager.c, TbRichTextView.c, h, com.baidu.tieba.pb.videopb.a, b {
    private AppBarLayout Wr;
    private EditorTools Zt;
    private ImageView aex;
    private CustomViewPager dLI;
    private com.baidu.adp.lib.d.b<ImageView> eBr;
    private com.baidu.adp.lib.d.b<GifView> eBs;
    private com.baidu.adp.lib.d.b<TextView> eEf;
    private com.baidu.adp.lib.d.b<View> eEg;
    private com.baidu.adp.lib.d.b<LinearLayout> eEh;
    private com.baidu.adp.lib.d.b<RelativeLayout> eEi;
    public View eun;
    private ImageView fxl;
    private VoiceManager hnh;
    private com.baidu.tieba.frs.profession.permission.c hqP;
    private com.baidu.tieba.f.b hrk;
    public aj iPP;
    private com.baidu.tieba.pb.videopb.c.a jEG;
    private PbFakeFloorModel jJT;
    private PbActivity jJW;
    public ax jKD;
    private g jKL;
    private com.baidu.tbadk.editortools.pb.e jKM;
    private com.baidu.tieba.frs.profession.permission.c jKO;
    private EmotionImageData jKP;
    private com.baidu.tbadk.core.view.c jKT;
    private com.baidu.tieba.pb.pb.main.emotion.model.a jKn;
    int jKq;
    private View jRP;
    private LinearLayout jRR;
    private HeadImageView jRS;
    private ImageView jRT;
    private ImageView jRU;
    private ImageView jRV;
    private com.baidu.tieba.pb.view.c jRW;
    private TextView jRX;
    private TextView jRY;
    private View jRy;
    private String jSP;
    private int jSa;
    private int jSb;
    private t jSy;
    public View jXw;
    private NewPagerSlidingTabBaseStrip kbY;
    private VideoPbFragmentAdapter kbZ;
    private ObjectAnimator kcA;
    private ObjectAnimator kcB;
    private View kca;
    private View kcb;
    private VideoContainerLayout kcc;
    private com.baidu.tieba.pb.videopb.videoView.a kcd;
    private f kce;
    private View kcf;
    private View kcg;
    private TextView kci;
    private TextView kcj;
    private ImageView kck;
    private TBSpecificationBtn kcl;
    private TbImageView kcm;
    private View kcn;
    private ValueAnimator kco;
    private ValueAnimator kcp;
    public com.baidu.tieba.pb.videopb.b.a kcq;
    private float kcu;
    private float kcv;
    private boolean kcw;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int kbV = 0;
    public static int kbW = 1;
    public static int jSq = 3;
    public static int jSr = 0;
    public static int jSs = 3;
    public static int jSt = 4;
    public static int jSu = 5;
    public static int jSv = 6;
    private static final int ifs = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int kbX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a jLK = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void bZ(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cDm();
            } else {
                com.baidu.tieba.pb.a.b.cDl();
            }
        }
    };
    private long jKd = 0;
    View.OnClickListener kch = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.jEG == null || VideoPbFragment.this.jEG.cLJ()) {
                if (VideoPbFragment.this.jEG != null) {
                    if (VideoPbFragment.this.jEG.isChushou) {
                        VideoPbFragment.this.dN(VideoPbFragment.this.jEG.thirdRoomId, VideoPbFragment.this.jEG.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.jEG.cLK();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null && VideoPbFragment.this.cDy().getPbData().getForum() != null) {
                        TiebaStatic.log(new an("c13713").dh("fid", VideoPbFragment.this.cDy().getPbData().getForum().getId()).dh("fname", VideoPbFragment.this.cDy().getPbData().getForum().getName()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", VideoPbFragment.this.cDy().getPbData().getThreadId()).s("obj_param1", VideoPbFragment.this.jEG.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new an("c13590").dh("obj_id", VideoPbFragment.this.jEG.getTitle()).dh("obj_name", VideoPbFragment.this.jEG.cLG()).ag("obj_type", 2).dh("fid", VideoPbFragment.this.cDy().getPbData().getForumId()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", VideoPbFragment.this.cDy().getPbData().getThreadId()));
            String link = VideoPbFragment.this.jEG.getLink();
            if (!TextUtils.isEmpty(link)) {
                if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                    ba.aUZ().b(VideoPbFragment.this.getPageContext(), new String[]{link});
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
    private com.baidu.tbadk.baseEditMark.a jKx = null;
    private com.baidu.tbadk.coreExtra.model.a dNL = null;
    private ForumManageModel gEV = null;
    private boolean jKh = false;
    private View jRQ = null;
    private TextView igY = null;
    private boolean jRM = false;
    private String emL = null;
    private boolean jKA = false;
    private boolean jKB = false;
    private boolean jKC = false;
    private boolean jKj = false;
    int[] jKp = new int[2];
    private int jKr = -1;
    private int jKs = Integer.MIN_VALUE;
    private int jKZ = 0;
    private int kcs = Integer.MIN_VALUE;
    private boolean beu = false;
    private final PbModel.a jLz = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g nc;
            VideoPbFragment.this.cHD();
            VideoPbFragment.this.cnH();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.sa(false);
            if (z && eVar != null) {
                bk cCi = eVar.cCi();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).d(eVar, i2);
                VideoPbFragment.this.I(eVar);
                com.baidu.tieba.pb.videopb.c.a cCL = eVar.cCL();
                if (cCL != null && !cCL.kec) {
                    VideoPbFragment.this.a(cCL);
                }
                VideoPbFragment.this.J(eVar);
                VideoPbFragment.this.c(z, i, i2, i3, eVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.jKx != null) {
                    VideoPbFragment.this.jKx.gC(eVar.aML());
                }
                AntiData anti = eVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.emL = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.emL) && VideoPbFragment.this.jKM != null && VideoPbFragment.this.jKM.bcW() != null && (nc = VideoPbFragment.this.jKM.bcW().nc(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.emL)) {
                        ((View) nc).setOnClickListener(VideoPbFragment.this.eny);
                    }
                }
                if (VideoPbFragment.this.iPP != null && cCi != null && cCi.aQx() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(cCi.aQx());
                    VideoPbFragment.this.iPP.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.cDy().cFt());
                        jSONObject.put("fid", VideoPbFragment.this.cDy().getForumId());
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
                if (VideoPbFragment.this.cKQ() != null) {
                    if (i != -1) {
                        ArrayList<PostData> arrayList = null;
                        if (VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null) {
                            arrayList = VideoPbFragment.this.cDy().getPbData().cCk();
                        }
                        if (v.getCount(arrayList) == 0 || (v.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).ddu() == 1)) {
                            if (VideoPbFragment.this.cKQ().cEW()) {
                                VideoPbFragment.this.cKQ().Jz(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                VideoPbFragment.this.cKQ().Jz(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            VideoPbFragment.this.cKQ().Jy(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                        }
                    } else {
                        VideoPbFragment.this.cKQ().Jy("");
                    }
                    VideoPbFragment.this.cKQ().endLoadData();
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.dct().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0471a jLB = new a.InterfaceC0471a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0471a
        public void c(boolean z, boolean z2, String str) {
            VideoPbFragment.this.cHD();
            if (z && VideoPbFragment.this.cDy() != null) {
                if (VideoPbFragment.this.jKx != null) {
                    VideoPbFragment.this.jKx.gC(z2);
                }
                VideoPbFragment.this.cDy().rG(z2);
                if (VideoPbFragment.this.cDy().aML()) {
                    VideoPbFragment.this.cEH();
                } else if (VideoPbFragment.this.cKQ() != null) {
                    VideoPbFragment.this.cKQ().cLB();
                }
                if (z2) {
                    if (VideoPbFragment.this.jKx != null) {
                        if (VideoPbFragment.this.jKx.aMO() != null && VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null && VideoPbFragment.this.cDy().getPbData().cCi() != null && VideoPbFragment.this.cDy().getPbData().cCi().aQx() != null) {
                            MarkData aMO = VideoPbFragment.this.jKx.aMO();
                            MetaData aQx = VideoPbFragment.this.cDy().getPbData().cCi().aQx();
                            if (aMO != null && aQx != null) {
                                if (!aq.equals(TbadkCoreApplication.getCurrentAccount(), aQx.getUserId()) && !aQx.hadConcerned()) {
                                    VideoPbFragment.this.kcq.b(aQx);
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
                    VideoPbFragment.this.cEE();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b emP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bdt() {
            if (VideoPbFragment.this.jKD == null || VideoPbFragment.this.jKD.cIt() == null || !VideoPbFragment.this.jKD.cIt().dmi()) {
                return !VideoPbFragment.this.Af(aj.dNG);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.jKD.cIt().dmk());
            if (VideoPbFragment.this.jKM != null && (VideoPbFragment.this.jKM.bdJ() || VideoPbFragment.this.jKM.bdK())) {
                VideoPbFragment.this.jKM.a(false, VideoPbFragment.this.jKD.cIw());
            }
            VideoPbFragment.this.jKD.sf(true);
            return true;
        }
    };
    private final CustomMessageListener jLg = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.cDy() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.jKM != null) {
                    VideoPbFragment.this.rY(VideoPbFragment.this.jKM.bdC());
                }
                VideoPbFragment.this.cHg();
                VideoPbFragment.this.kcq.cHU();
            }
        }
    };
    private CustomMessageListener jLj = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
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
    private final CustomMessageListener hov = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.beu) {
                VideoPbFragment.this.cEY();
            }
        }
    };
    private CustomMessageListener jLA = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.cEy();
            }
        }
    };
    private CustomMessageListener jLu = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.kcq != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kcq.jKU) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.kcq.bGf();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.kcq.getExtra();
                DataRes dataRes = aVar.lzt;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (aq.isEmpty(str)) {
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
                    VideoPbFragment.this.kcq.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.kcq.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener jLs = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.kcq != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kcq.jKU) {
                VideoPbFragment.this.kcq.bGf();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.cDy().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cCy().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.jKT.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.kcq.yo(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.kcq.cEV();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.jKT.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener jLt = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.kcq != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kcq.jKU) {
                VideoPbFragment.this.kcq.bGf();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.jKT.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.jKT.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b jKR = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bdt() {
            if (VideoPbFragment.this.jKD == null || VideoPbFragment.this.jKD.cIu() == null || !VideoPbFragment.this.jKD.cIu().dmi()) {
                return !VideoPbFragment.this.Af(aj.dNH);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.jKD.cIu().dmk());
            if (VideoPbFragment.this.jSy != null && VideoPbFragment.this.jSy.cEi() != null && VideoPbFragment.this.jSy.cEi().bdK()) {
                VideoPbFragment.this.jSy.cEi().a(VideoPbFragment.this.jKD.cIw());
            }
            VideoPbFragment.this.jKD.sg(true);
            return true;
        }
    };
    private final NewWriteModel.d emV = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null) {
                    anVar.dh("fid", VideoPbFragment.this.cDy().getPbData().getForumId());
                }
                anVar.dh("tid", VideoPbFragment.this.cDy().cFt());
                anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            VideoPbFragment.this.bVn();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.cDy() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.cDy().Jt(postWriteCallBackData.getPostId());
                    if (VideoPbFragment.this.cKQ() != null) {
                        VideoPbFragment.this.jKZ = VideoPbFragment.this.cKQ().cHF();
                        VideoPbFragment.this.kcs = VideoPbFragment.this.cKQ().cLE();
                        VideoPbFragment.this.cDy().cD(VideoPbFragment.this.jKZ, VideoPbFragment.this.kcs);
                    }
                }
                if (VideoPbFragment.this.dLI != null) {
                    VideoPbFragment.this.dLI.setCurrentItem(VideoPbFragment.kbW);
                }
                VideoPbFragment.this.kcq.cHU();
                VideoPbFragment.this.jKD.cIs();
                if (VideoPbFragment.this.jKM != null) {
                    VideoPbFragment.this.rY(VideoPbFragment.this.jKM.bdC());
                }
                VideoPbFragment.this.cHc();
                VideoPbFragment.this.sa(true);
                VideoPbFragment.this.cDy().cFO();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && VideoPbFragment.this.cKQ() != null) {
                            VideoPbFragment.this.cKQ().cLB();
                        }
                    } else if (VideoPbFragment.this.cDy().getHostMode()) {
                        com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.cDy().getPbData();
                        if (pbData != null && pbData.cCi() != null && pbData.cCi().aQx() != null && (userId = pbData.cCi().aQx().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.cDy().cFF()) {
                            VideoPbFragment.this.cHB();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.cDy().cFF()) {
                        VideoPbFragment.this.cHB();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.rt(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.jKM.bdJ() || VideoPbFragment.this.jKM.bdK()) {
                    VideoPbFragment.this.jKM.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.jKD.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.iPP != null) {
                    VideoPbFragment.this.iPP.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (aaVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener eny = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.emL);
        }
    };
    private CustomMessageListener jLi = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.jKM != null) {
                    VideoPbFragment.this.rY(VideoPbFragment.this.jKM.bdC());
                }
                VideoPbFragment.this.sa(false);
            }
        }
    };
    private int kct = 0;
    private boolean kcx = true;
    private View.OnTouchListener kcy = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.kct == 1) {
                if (!VideoPbFragment.this.kcx) {
                    VideoPbFragment.this.cKU();
                    UtilHelper.showStatusBar(VideoPbFragment.this.cFc(), VideoPbFragment.this.cFc().getRootView());
                    VideoPbFragment.this.kcx = true;
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(VideoPbFragment.this.kcz);
                    com.baidu.adp.lib.f.e.ld().postDelayed(VideoPbFragment.this.kcz, 3000L);
                }
            } else if (VideoPbFragment.this.kct == 2 && (VideoPbFragment.this.kcx || VideoPbFragment.this.cKW())) {
                VideoPbFragment.this.cKV();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cFc(), VideoPbFragment.this.cFc().getRootView());
                VideoPbFragment.this.kcx = false;
                if (VideoPbFragment.this.kcd != null) {
                    VideoPbFragment.this.kcd.sA(false);
                }
            }
            VideoPbFragment.this.kct = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener hxD = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.kct = 0;
            VideoPbFragment.this.kcu = 0.0f;
            VideoPbFragment.this.kcv = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.kcu += f;
            VideoPbFragment.this.kcv += f2;
            if (VideoPbFragment.this.kct == 0 && !VideoPbFragment.this.kcw && VideoPbFragment.this.kcd != null && !VideoPbFragment.this.kcd.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.kcv) <= Math.abs(VideoPbFragment.this.kcu) || VideoPbFragment.this.kcv > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.kcv) > Math.abs(VideoPbFragment.this.kcu) && VideoPbFragment.this.kcv > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.kct = 2;
                    }
                } else {
                    VideoPbFragment.this.kct = 1;
                }
            }
            return true;
        }
    };
    private Runnable kcz = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.kcx && !VideoPbFragment.this.cKW()) {
                VideoPbFragment.this.cKV();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cFc(), VideoPbFragment.this.cFc().getRootView());
                VideoPbFragment.this.kcx = false;
            }
        }
    };
    private final com.baidu.adp.base.d gFa = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.cDy() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.gEV.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.gEV.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.cDy().cFO();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.jZp != 1002 || bVar.fEF) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.OU, dVar.lnC, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.gEV.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.gEV.getLoadDataMode(), gVar.OU, gVar.lnC, false);
                    VideoPbFragment.this.kcq.aP(gVar.lnF);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener evw = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.hrk.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d jLx = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null) {
                    anVar.dh("fid", VideoPbFragment.this.cDy().getPbData().getForumId());
                }
                if (VideoPbFragment.this.cDy() != null) {
                    anVar.dh("tid", VideoPbFragment.this.cDy().cFt());
                }
                anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (VideoPbFragment.this.jKD != null) {
                    VideoPbFragment.this.jKD.cIr();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.iPP != null) {
                    VideoPbFragment.this.iPP.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.jKD != null) {
                if (VideoPbFragment.this.jSy != null && VideoPbFragment.this.jSy.cEi() != null && VideoPbFragment.this.jSy.cEi().bdK()) {
                    VideoPbFragment.this.jSy.cEi().a(postWriteCallBackData);
                }
                VideoPbFragment.this.jKD.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c emO = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bdu() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            boolean w;
            int i2 = 3;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    an anVar = new an("c13398");
                    anVar.dh("tid", VideoPbFragment.this.cDy().cFt());
                    anVar.dh("fid", VideoPbFragment.this.cDy().getForumId());
                    anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.ag("obj_locate", 1);
                    TiebaStatic.log(anVar);
                    if (VideoPbFragment.this.jKh) {
                        VideoPbFragment.this.jKh = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null && VideoPbFragment.this.jJT != null && postData.aQx() != null && postData.ddu() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.jSy != null) {
                                    VideoPbFragment.this.jSy.cEe();
                                }
                                n nVar = new n();
                                nVar.a(VideoPbFragment.this.cDy().getPbData().getForum());
                                nVar.setThreadData(VideoPbFragment.this.cDy().getPbData().cCi());
                                nVar.g(postData);
                                VideoPbFragment.this.jJT.d(nVar);
                                VideoPbFragment.this.jJT.setPostId(postData.getId());
                                VideoPbFragment.this.b(view, postData.aQx().getUserId(), "");
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.cDy().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.jKM != null) {
                                    VideoPbFragment.this.rY(VideoPbFragment.this.jKM.bdC());
                                }
                            }
                        }
                    }
                } else if (VideoPbFragment.this.cKQ() != null && VideoPbFragment.this.cKQ().cHQ() != null && view == VideoPbFragment.this.cKQ().cHQ()) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.cDy().rE(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        VideoPbFragment.this.cKQ().cHC();
                    }
                } else if (VideoPbFragment.this.kcq != null && VideoPbFragment.this.kcq.cIZ() != null && view == VideoPbFragment.this.kcq.cIZ().cGC()) {
                    VideoPbFragment.this.kcq.aEa();
                } else if (VideoPbFragment.this.kcq != null && ((VideoPbFragment.this.kcq.cIZ() != null && view == VideoPbFragment.this.kcq.cIZ().cGD()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.kcq.cHU();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.bVn();
                        VideoPbFragment.this.cHB();
                        if (view.getId() == R.id.owner_reply) {
                            w = VideoPbFragment.this.cDy().w(true, VideoPbFragment.this.cEL());
                        } else {
                            w = view.getId() == R.id.all_reply ? VideoPbFragment.this.cDy().w(false, VideoPbFragment.this.cEL()) : VideoPbFragment.this.cDy().Jq(VideoPbFragment.this.cEL());
                        }
                        view.setTag(Boolean.valueOf(w));
                        if (w) {
                            VideoPbFragment.this.cnI();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.eun) {
                    if (VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null) {
                        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            an anVar2 = new an("c13266");
                            anVar2.dh("uid", TbadkCoreApplication.getCurrentAccount());
                            anVar2.dh("fid", VideoPbFragment.this.cDy().getPbData().getForumId());
                            anVar2.dh("tid", VideoPbFragment.this.cDy().cFt());
                            anVar2.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(anVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.jJW, VideoPbFragment.this.eun);
                        VideoPbFragment.this.jJW.finish();
                    }
                } else if (view == VideoPbFragment.this.jXw && VideoPbFragment.this.kcq != null) {
                    if (VideoPbFragment.this.cDy() == null || VideoPbFragment.this.cDy().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> cCk = VideoPbFragment.this.cDy().getPbData().cCk();
                    if ((cCk == null || cCk.size() <= 0) && VideoPbFragment.this.cDy().cFv()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new an("c12378").dh("tid", VideoPbFragment.this.cDy().cFt()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("fid", VideoPbFragment.this.cDy().getForumId()));
                    VideoPbFragment.this.kcq.cEz();
                } else if (VideoPbFragment.this.kcq.cIZ() != null && view == VideoPbFragment.this.kcq.cIZ().cGH()) {
                    if (VideoPbFragment.this.cDy() != null) {
                        VideoPbFragment.this.kcq.cHU();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.bVn();
                            VideoPbFragment.this.cHB();
                            VideoPbFragment.this.cDy().Al(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.kcq != null && VideoPbFragment.this.kcq.cIZ() != null && view == VideoPbFragment.this.kcq.cIZ().cGD()) {
                    VideoPbFragment.this.kcq.aEa();
                } else if (VideoPbFragment.this.kcq != null && ((VideoPbFragment.this.kcq.cIZ() != null && view == VideoPbFragment.this.kcq.cIZ().cGJ()) || view.getId() == R.id.pb_sort_type)) {
                    VideoPbFragment.this.kcq.cHU();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.bVn();
                            VideoPbFragment.this.cHB();
                            VideoPbFragment.this.kcq.cP(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.cDy().cFM()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.kcq != null && VideoPbFragment.this.kcq.cIZ() != null && view == VideoPbFragment.this.kcq.cIZ().cGB()) {
                    if (VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null && VideoPbFragment.this.cDy().getPbData().cCi() != null) {
                        VideoPbFragment.this.kcq.aEa();
                        TiebaStatic.log(new an("c13062"));
                        VideoPbFragment.this.kcq.Jl(VideoPbFragment.this.cDy().getPbData().cCi().aQP());
                    }
                } else if (VideoPbFragment.this.kcq != null && VideoPbFragment.this.kcq.cIZ() != null && view == VideoPbFragment.this.kcq.cIZ().cGK()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        am.y(true, false);
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).ag("obj_type", 0).ag("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).ag("obj_type", 1).ag("obj_source", 1));
                    }
                    VideoPbFragment.this.kcq.cIY();
                } else if (VideoPbFragment.this.kcq != null && (view == VideoPbFragment.this.kcq.cHz() || (VideoPbFragment.this.kcq.cIZ() != null && (view == VideoPbFragment.this.kcq.cIZ().cGG() || view == VideoPbFragment.this.kcq.cIZ().cGE())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.cDy() != null || VideoPbFragment.this.cDy().getPbData() != null) {
                        if ((VideoPbFragment.this.cDy().getPbData().cCx() == 1 || VideoPbFragment.this.cDy().getPbData().cCx() == 3) && !VideoPbFragment.this.gEV.dek()) {
                            VideoPbFragment.this.kcq.cHU();
                            if (VideoPbFragment.this.kcq.cIZ() != null && view == VideoPbFragment.this.kcq.cIZ().cGE()) {
                                if (VideoPbFragment.this.cDy().getPbData().cCi().aQs() == 1) {
                                    i = 5;
                                } else {
                                    i = 4;
                                }
                            } else if (VideoPbFragment.this.kcq.cIZ() != null && view == VideoPbFragment.this.kcq.cIZ().cGG()) {
                                i = VideoPbFragment.this.cDy().getPbData().cCi().aQt() == 1 ? 3 : 6;
                            } else {
                                i = view == VideoPbFragment.this.kcq.cHz() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.cDy().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.cDy().getPbData().cCi().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.gEV.b(id, name, id2, i, VideoPbFragment.this.kcq.cHA());
                        }
                    }
                } else if (VideoPbFragment.this.kcq != null && VideoPbFragment.this.kcq.cIZ() != null && view == VideoPbFragment.this.kcq.cIZ().cGI()) {
                    if (VideoPbFragment.this.cDy() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.kcq.cHU();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.cDy().getPbData(), VideoPbFragment.this.cDy().cFv(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.cDy().getPbData().getForum().getId(), VideoPbFragment.this.cDy().getPbData().getForum().getName(), VideoPbFragment.this.cDy().getPbData().cCi().getId(), String.valueOf(VideoPbFragment.this.cDy().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.kcq != null && VideoPbFragment.this.kcq.cIZ() != null && view == VideoPbFragment.this.kcq.cIZ().cGF()) {
                    if (VideoPbFragment.this.cDy() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.cDy().getPbData(), VideoPbFragment.this.cDy().cFv(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.kcq.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.kcq.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.kcq.aEa();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        an anVar3 = new an("c13398");
                        anVar3.dh("tid", VideoPbFragment.this.cDy().cFt());
                        anVar3.dh("fid", VideoPbFragment.this.cDy().getForumId());
                        anVar3.dh("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar3.ag("obj_locate", 4);
                        TiebaStatic.log(anVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new an("c10517").ag("obj_locate", 3).dh("fid", VideoPbFragment.this.cDy().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null) {
                        if (VideoPbFragment.this.kcq != null) {
                            VideoPbFragment.this.kcq.cHU();
                        }
                        PostData postData2 = (PostData) ((SparseArray) view.getTag()).get(R.id.tag_load_sub_data);
                        if (postData2 != null) {
                            if (postData2.ddG() == 1) {
                                TiebaStatic.log(new an("c12630"));
                            }
                            if (postData2.llH != null) {
                                an aUR = postData2.llH.aUR();
                                aUR.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    aUR.ag("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    aUR.ag("obj_locate", 8);
                                }
                                TiebaStatic.log(aUR);
                            }
                            String cFt = VideoPbFragment.this.cDy().cFt();
                            String id3 = postData2.getId();
                            int cCx = VideoPbFragment.this.cDy().getPbData() != null ? VideoPbFragment.this.cDy().getPbData().cCx() : 0;
                            VideoPbFragment.this.bVn();
                            TiebaStatic.log("c11742");
                            if (VideoPbFragment.this.cKQ() != null && VideoPbFragment.this.cKQ().cLD() != null) {
                                PbActivity.a Jo = VideoPbFragment.this.cKQ().cLD().Jo(id3);
                                if (postData2 != null && VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null && Jo != null) {
                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cFt, id3, "pb", true, null, false, null, cCx, postData2.cJX(), VideoPbFragment.this.cDy().getPbData().getAnti(), false, postData2.aQx().getIconInfo()).addBigImageData(Jo.jGX, Jo.jGY, Jo.jGZ, Jo.index);
                                    addBigImageData.setKeyFromForumId(VideoPbFragment.this.cDy().getForumId());
                                    addBigImageData.setBjhData(VideoPbFragment.this.cDy().cFC());
                                    addBigImageData.setKeyPageStartFrom(VideoPbFragment.this.cDy().cGd());
                                    addBigImageData.setFromFrsForumId(VideoPbFragment.this.cDy().getFromForumId());
                                    VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img) {
                    if (VideoPbFragment.this.cDy() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            an anVar4 = new an("c13398");
                            anVar4.dh("tid", VideoPbFragment.this.cDy().cFt());
                            anVar4.dh("fid", VideoPbFragment.this.cDy().getForumId());
                            anVar4.dh("uid", TbadkCoreApplication.getCurrentAccount());
                            anVar4.ag("obj_locate", 6);
                            TiebaStatic.log(anVar4);
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData3 = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData3.llH != null) {
                                    an aUR2 = postData3.llH.aUR();
                                    aUR2.delete("obj_locate");
                                    aUR2.ag("obj_locate", 8);
                                    TiebaStatic.log(aUR2);
                                } else if (view.getId() == R.id.post_info_commont_img) {
                                    TiebaStatic.log(new an("c13700").dh("tid", VideoPbFragment.this.cDy().cFu()).dh("fid", VideoPbFragment.this.cDy().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dh("post_id", postData3.getId()).ag("obj_type", 3));
                                }
                                if (VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null && VideoPbFragment.this.jJT != null && postData3.aQx() != null && postData3.ddu() != 1) {
                                    if (VideoPbFragment.this.jSy != null) {
                                        VideoPbFragment.this.jSy.cEe();
                                    }
                                    n nVar2 = new n();
                                    nVar2.a(VideoPbFragment.this.cDy().getPbData().getForum());
                                    nVar2.setThreadData(VideoPbFragment.this.cDy().getPbData().cCi());
                                    nVar2.g(postData3);
                                    VideoPbFragment.this.jJT.d(nVar2);
                                    VideoPbFragment.this.jJT.setPostId(postData3.getId());
                                    VideoPbFragment.this.b(view, postData3.aQx().getUserId(), "");
                                    if (VideoPbFragment.this.jKM != null) {
                                        VideoPbFragment.this.rY(VideoPbFragment.this.jKM.bdC());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.kcq != null && VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cKQ() != null) {
                        VideoPbFragment.this.kcq.cHU();
                        if (VideoPbFragment.this.Ag(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.cDy() != null) {
                            VideoPbFragment.this.cEG();
                            if (VideoPbFragment.this.cDy().getPbData() != null && VideoPbFragment.this.cDy().getPbData().cCi() != null && VideoPbFragment.this.cDy().getPbData().cCi().aQx() != null) {
                                TiebaStatic.log(new an("c13402").dh("tid", VideoPbFragment.this.cDy().cFt()).dh("fid", VideoPbFragment.this.cDy().getPbData().getForumId()).ag("obj_locate", 3).dh("uid", VideoPbFragment.this.cDy().getPbData().cCi().aQx().getUserId()));
                            }
                            if (VideoPbFragment.this.cDy().getPbData().cCi() != null && VideoPbFragment.this.cDy().getPbData().cCi().aQx() != null && VideoPbFragment.this.cDy().getPbData().cCi().aQx().getUserId() != null && VideoPbFragment.this.jKx != null) {
                                int h = VideoPbFragment.this.kcq.h(VideoPbFragment.this.cDy().getPbData());
                                bk cCi = VideoPbFragment.this.cDy().getPbData().cCi();
                                if (cCi.aPm()) {
                                    i2 = 2;
                                } else if (!cCi.aPn()) {
                                    if (cCi.aSv()) {
                                        i2 = 4;
                                    } else {
                                        i2 = cCi.aSw() ? 5 : 1;
                                    }
                                }
                                TiebaStatic.log(new an("c12526").dh("tid", VideoPbFragment.this.cDy().cFt()).ag("obj_locate", 1).dh("obj_id", VideoPbFragment.this.cDy().getPbData().cCi().aQx().getUserId()).ag("obj_type", VideoPbFragment.this.jKx.aML() ? 0 : 1).ag("obj_source", h).ag("obj_param1", i2));
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.sy(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.cDy() != null && VideoPbFragment.this.kcq != null && VideoPbFragment.this.dLI != null && VideoPbFragment.this.cDy().getPbData() != null && VideoPbFragment.this.cDy().getPbData().cCi() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.cDy().getPbData();
                        if (pbData.cCi().aQo() != 0) {
                            int currentItem = VideoPbFragment.this.dLI.getCurrentItem();
                            if (currentItem == VideoPbFragment.kbV) {
                                VideoPbFragment.this.dLI.setCurrentItem(VideoPbFragment.kbW);
                            } else if (currentItem == VideoPbFragment.kbW) {
                                if (VideoPbFragment.this.cKQ() != null && VideoPbFragment.this.bXR() != null) {
                                    an dh = new an("c13403").dh("tid", VideoPbFragment.this.cDy().cFt()).dh("fid", VideoPbFragment.this.cDy().getPbData().getForumId()).dh("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView bXR = VideoPbFragment.this.bXR();
                                    boolean canScrollVertically = bXR.canScrollVertically(1);
                                    boolean canScrollVertically2 = bXR.canScrollVertically(-1);
                                    if (VideoPbFragment.this.Wr != null) {
                                        VideoPbFragment.this.Wr.setExpanded(false, true);
                                    }
                                    if (bXR.getLayoutManager() != null && (bXR.getLayoutManager() instanceof LinearLayoutManager)) {
                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) bXR.getLayoutManager();
                                        if (!canScrollVertically2 && canScrollVertically) {
                                            if (VideoPbFragment.this.jKr != -1 || VideoPbFragment.this.jKs != Integer.MIN_VALUE) {
                                                if (VideoPbFragment.this.jKr > 3 || (VideoPbFragment.this.jKr == 3 && VideoPbFragment.this.jKs < (-equipmentHeight))) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.jKr, VideoPbFragment.this.jKs + equipmentHeight);
                                                    bXR.smoothScrollBy(0, equipmentHeight);
                                                } else if (VideoPbFragment.this.jKr >= 2) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.jKr, VideoPbFragment.this.jKs + (equipmentHeight / 2));
                                                    bXR.smoothScrollBy(0, equipmentHeight / 2);
                                                } else if (VideoPbFragment.this.jKr == 1) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.jKr, VideoPbFragment.this.jKs + (equipmentHeight / 4));
                                                    bXR.smoothScrollBy(0, equipmentHeight / 4);
                                                } else {
                                                    bXR.smoothScrollBy(0, -VideoPbFragment.this.jKs);
                                                }
                                                dh.ag("obj_locate", 2);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            int firstVisiblePosition = bXR.getFirstVisiblePosition();
                                            View childAt = bXR.getChildAt(0);
                                            int top2 = childAt == null ? 0 : childAt.getTop();
                                            VideoPbFragment.this.jKr = firstVisiblePosition;
                                            VideoPbFragment.this.jKs = top2;
                                            if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top2 < (-equipmentHeight) && bXR.getCount() >= 6)) {
                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                bXR.smoothScrollToPosition(0);
                                            } else {
                                                bXR.smoothScrollToPosition(0);
                                            }
                                            dh.ag("obj_locate", 1);
                                        }
                                        TiebaStatic.log(dh);
                                        TiebaStatic.log(new an("c12942").ag("obj_type", 1).ag("obj_locate", 4).dh("tid", VideoPbFragment.this.cDy().cFt()).dh("nid", pbData.cCi().getNid()));
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null && VideoPbFragment.this.cDy().getPbData().cCi() != null && VideoPbFragment.this.cDy().getPbData().cCi().aQx() != null) {
                                TiebaStatic.log(new an("c13402").dh("tid", VideoPbFragment.this.cDy().cFt()).dh("fid", VideoPbFragment.this.cDy().getPbData().getForumId()).ag("obj_locate", 2).dh("uid", VideoPbFragment.this.cDy().getPbData().cCi().aQx().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.sz(false);
                        VideoPbFragment.this.cEu();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.jKZ >= 0) {
                        if (VideoPbFragment.this.cDy() != null) {
                            VideoPbFragment.this.cDy().cGe();
                        }
                        if (VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cKQ() != null && VideoPbFragment.this.cKQ().cLC() != null) {
                            VideoPbFragment.this.cKQ().cLC().setData(VideoPbFragment.this.cDy().getPbData());
                        }
                        VideoPbFragment.this.jKZ = 0;
                        VideoPbFragment.this.kcs = Integer.MIN_VALUE;
                        if (VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cKQ() != null) {
                            VideoPbFragment.this.cKQ().cG(VideoPbFragment.this.cDy().cGh(), VideoPbFragment.this.cDy().cGi());
                            VideoPbFragment.this.cDy().cD(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.cDy() != null) {
                        an anVar5 = new an("c13398");
                        anVar5.dh("tid", VideoPbFragment.this.cDy().cFt());
                        anVar5.dh("fid", VideoPbFragment.this.cDy().getForumId());
                        anVar5.dh("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar5.ag("obj_locate", 2);
                        TiebaStatic.log(anVar5);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bc.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.cHg();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.cHg();
                }
            }
        }
    };
    private View.OnClickListener jHE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.kcq != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.kcq.c(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.kcq.cI(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.kcq.c(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.kcq.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    public SortSwitchButton.a jLw = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean ut(int i) {
            if (VideoPbFragment.this.kcq != null) {
                VideoPbFragment.this.kcq.cHU();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.cDy() == null || VideoPbFragment.this.cDy().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.bVn();
                VideoPbFragment.this.cHB();
                if (VideoPbFragment.this.cDy().getPbData() != null && VideoPbFragment.this.cDy().getPbData().jDV != null && VideoPbFragment.this.cDy().getPbData().jDV.size() > i) {
                    int intValue = VideoPbFragment.this.cDy().getPbData().jDV.get(i).sort_type.intValue();
                    TiebaStatic.log(new an("c13699").dh("tid", VideoPbFragment.this.cDy().cFu()).dh("fid", VideoPbFragment.this.cDy().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", Ai(intValue)));
                    if (VideoPbFragment.this.cDy().Aq(intValue)) {
                        VideoPbFragment.this.mIsLoading = true;
                    }
                }
                return true;
            }
        }

        private int Ai(int i) {
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
    private a kcr = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void cEE() {
        if (cDy() != null && cDy().getPbData() != null && cDy().getPbData().cCi() != null) {
            bk cCi = cDy().getPbData().cCi();
            cCi.mRecomAbTag = cDy().cGo();
            cCi.mRecomWeight = cDy().cGm();
            cCi.mRecomSource = cDy().cGn();
            cCi.mRecomExtra = cDy().cGp();
            if (cCi.getFid() == 0) {
                cCi.setFid(com.baidu.adp.lib.f.b.toLong(cDy().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cCi, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt(boolean z) {
        if (cDy() != null && cDy().getPbData() != null && cDy().getPbData().cCi() != null) {
            bk cCi = cDy().getPbData().cCi();
            cCi.mRecomAbTag = cDy().cGo();
            cCi.mRecomWeight = cDy().cGm();
            cCi.mRecomSource = cDy().cGn();
            cCi.mRecomExtra = cDy().cGp();
            if (cCi.getFid() == 0) {
                cCi.setFid(com.baidu.adp.lib.f.b.toLong(cDy().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cCi, "c13563");
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
            if (aq.isEmpty(str)) {
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
            String string = !TextUtils.isEmpty(bVar.lnC) ? bVar.lnC : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.vO(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.gW(true);
                aVar.b(getPageContext());
                aVar.aST();
            } else {
                a(0, bVar.OU, bVar.lnC, z);
            }
            if (bVar.OU) {
                if (bVar.gUl == 1) {
                    ArrayList<PostData> cCk = cDy().getPbData().cCk();
                    int size = cCk.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cCk.get(i).getId())) {
                            i++;
                        } else {
                            cCk.remove(i);
                            break;
                        }
                    }
                    cDy().getPbData().cCi().kq(cDy().getPbData().cCi().aQo() - 1);
                    if (cKQ() != null) {
                        cKQ().cLB();
                    }
                } else if (bVar.gUl == 0) {
                    cEF();
                } else if (bVar.gUl == 2) {
                    ArrayList<PostData> cCk2 = cDy().getPbData().cCk();
                    int size2 = cCk2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cCk2.get(i2).ddr().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cCk2.get(i2).ddr().get(i3).getId())) {
                                i3++;
                            } else {
                                cCk2.get(i2).ddr().remove(i3);
                                cCk2.get(i2).ddt();
                                z2 = true;
                                break;
                            }
                        }
                        cCk2.get(i2).MB(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3 && cKQ() != null) {
                        cKQ().cLB();
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = cDy().getPbData().cCw().jFy;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).ddr().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).ddr().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).ddr().remove(i2);
                    list.get(i).ddt();
                    z = true;
                    break;
                }
            }
            list.get(i).MB(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2 && cKQ() != null) {
            cKQ().cLB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && cDy() != null && cDy().getPbData() != null && cDy().getPbData().cCi() != null) {
            a(this.gEV.getLoadDataMode(), gVar.OU, gVar.lnC, false);
            if (gVar.OU) {
                this.jKA = true;
                if (i == 2 || i == 3) {
                    this.jKB = true;
                    this.jKC = false;
                } else if (i == 4 || i == 5) {
                    this.jKB = false;
                    this.jKC = true;
                }
                if (i == 2) {
                    cDy().getPbData().cCi().kt(1);
                    cDy().setIsGood(1);
                } else if (i == 3) {
                    cDy().getPbData().cCi().kt(0);
                    cDy().setIsGood(0);
                } else if (i == 4) {
                    cDy().getPbData().cCi().ks(1);
                    cDy().Ak(1);
                } else if (i == 5) {
                    cDy().getPbData().cCi().ks(0);
                    cDy().Ak(0);
                }
            }
            if (cDy().getPbData().cCi() != null && cKR() != null) {
                cKR().cLy();
            }
        }
    }

    private void cEF() {
        if (cDy().cFw() || cDy().cFy()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", cDy().cFt());
            PbActivity pbActivity = this.jJW;
            PbActivity pbActivity2 = this.jJW;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, cDy().cFt()));
        if (cEI()) {
            this.jJW.finish();
        }
    }

    private boolean cEI() {
        if (cDy() == null) {
            return true;
        }
        if (cDy().getPbData() == null || !cDy().getPbData().cCJ()) {
            if (cDy().aML()) {
                final MarkData cFN = cDy().cFN();
                if (cFN == null || !cDy().getIsFromMark() || bXR() == null) {
                    return true;
                }
                final MarkData Ar = cDy().Ar(bXR().getFirstVisiblePosition());
                if (Ar == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cFN);
                    this.jJW.setResult(-1, intent);
                    return true;
                } else if (Ar.getPostId() == null || Ar.getPostId().equals(cFN.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cFN);
                    this.jJW.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.vO(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.jKx != null) {
                                if (VideoPbFragment.this.jKx.aML()) {
                                    VideoPbFragment.this.jKx.aMM();
                                    VideoPbFragment.this.jKx.gC(false);
                                }
                                VideoPbFragment.this.jKx.a(Ar);
                                VideoPbFragment.this.jKx.gC(true);
                                VideoPbFragment.this.jKx.aMN();
                            }
                            cFN.setPostId(Ar.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cFN);
                            VideoPbFragment.this.jJW.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cDL();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cFN);
                            VideoPbFragment.this.jJW.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cDL();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.aST();
                    return false;
                }
            } else if (cDy().getPbData() == null || cDy().getPbData().cCk() == null || cDy().getPbData().cCk().size() <= 0 || !cDy().getIsFromMark()) {
                return true;
            } else {
                this.jJW.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDL() {
        this.jJW.cDL();
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
    public void sy(boolean z) {
        com.baidu.tieba.pb.data.e pbData;
        int i;
        if (cDy() != null && this.kcq != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = cDy().getPbData()) != null) {
                bk cCi = pbData.cCi();
                if (cCi != null && cCi.aQx() != null) {
                    TiebaStatic.log(new an("c13402").dh("tid", cDy().cFt()).dh("fid", pbData.getForumId()).ag("obj_locate", 4).dh("uid", cCi.aQx().getUserId()));
                }
                if (cCi != null) {
                    if (cCi.aPm()) {
                        i = 2;
                    } else if (cCi.aPn()) {
                        i = 3;
                    } else if (cCi.aSv()) {
                        i = 4;
                    } else if (cCi.aSw()) {
                        i = 5;
                    }
                    an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    anVar.dh("tid", cDy().cFt());
                    anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.dh("fid", cDy().getForumId());
                    if (!z) {
                        anVar.ag("obj_locate", 6);
                    } else {
                        anVar.ag("obj_locate", 5);
                    }
                    anVar.ag("obj_name", i);
                    anVar.ag("obj_type", 2);
                    if (cCi != null) {
                        if (cCi.aPm()) {
                            anVar.ag("obj_type", 10);
                        } else if (cCi.aPn()) {
                            anVar.ag("obj_type", 9);
                        } else if (cCi.aSw()) {
                            anVar.ag("obj_type", 8);
                        } else if (cCi.aSv()) {
                            anVar.ag("obj_type", 7);
                        } else if (cCi.isShareThread) {
                            anVar.ag("obj_type", 6);
                        } else if (cCi.threadType == 0) {
                            anVar.ag("obj_type", 1);
                        } else if (cCi.threadType == 40) {
                            anVar.ag("obj_type", 2);
                        } else if (cCi.threadType == 49) {
                            anVar.ag("obj_type", 3);
                        } else if (cCi.threadType == 54) {
                            anVar.ag("obj_type", 4);
                        } else {
                            anVar.ag("obj_type", 5);
                        }
                        anVar.dh("nid", cCi.getNid());
                        anVar.ag(IntentConfig.CARD_TYPE, cCi.aSA());
                        anVar.dh(IntentConfig.RECOM_SOURCE, cCi.mRecomSource);
                        anVar.dh("ab_tag", cCi.mRecomAbTag);
                        anVar.dh("weight", cCi.mRecomWeight);
                        anVar.dh("extra", cCi.mRecomExtra);
                        anVar.dh("nid", cCi.getNid());
                        if (cCi.getBaijiahaoData() != null && !aq.isEmpty(cCi.getBaijiahaoData().oriUgcVid)) {
                            anVar.dh("obj_param6", cCi.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (cFc() != null) {
                        com.baidu.tbadk.pageInfo.c.b(cFc(), anVar);
                    }
                    TiebaStatic.log(anVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (cDy().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> cCk = pbData.cCk();
                        if ((cCk == null || cCk.size() <= 0) && cDy().cFv()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.kcq.cHU();
                        bVn();
                        TiebaStatic.log(new an("c11939"));
                        if (!AntiHelper.d(getContext(), cCi)) {
                            if (this.jRW != null) {
                                this.jRW.setEnable(false);
                                w(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                Ah(z ? 2 : 1);
                                return;
                            }
                            this.kcq.showLoadingDialog();
                            cDy().cFY().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.dh("tid", cDy().cFt());
                anVar2.dh("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.dh("fid", cDy().getForumId());
                if (!z) {
                }
                anVar2.ag("obj_name", i);
                anVar2.ag("obj_type", 2);
                if (cCi != null) {
                }
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (cFc() != null) {
                }
                TiebaStatic.log(anVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment cKx() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        I(eVar.cLc());
        J(eVar.cLc());
        if (cDy() != null && cDy().getPbData() != null) {
            boolean isFromMark = cDy().getIsFromMark();
            com.baidu.tieba.pb.data.e pbData = cDy().getPbData();
            if (isFromMark) {
                PostData H = H(pbData);
                if (pbData.aMK() != null && !pbData.aMK().equals(H.getId()) && this.dLI != null) {
                    this.dLI.setCurrentItem(kbW);
                }
            }
        }
        eVar.cLd().observe(this, new q<bk>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bk bkVar) {
                if (bkVar != null && bkVar.aQQ() != null) {
                    if (VideoPbFragment.this.kcd.getVideoUrl() == null || !VideoPbFragment.this.kcd.getVideoUrl().equals(bkVar.aQQ().video_url)) {
                        if (!aq.isEmpty(VideoPbFragment.this.kcd.getVideoUrl())) {
                            VideoPbFragment.this.jKj = true;
                            VideoPbFragment.this.dLI.setCurrentItem(VideoPbFragment.kbV);
                        }
                        if (VideoPbFragment.this.kce == null || !VideoPbFragment.this.kce.isPlaying()) {
                            VideoPbFragment.this.cKy();
                            VideoPbFragment.this.aN(bkVar);
                        }
                        VideoPbFragment.this.cKz();
                        if (VideoPbFragment.this.kce.cLq()) {
                            VideoPbFragment.this.kce.start();
                        }
                        boolean z = !aq.equals(VideoPbFragment.this.kcd.getVideoUrl(), bkVar.aQQ().video_url);
                        VideoPbFragment.this.kcd.setData(bkVar);
                        VideoPbFragment.this.kcd.sH(VideoPbFragment.this.dLI.getCurrentItem() == 0);
                        if (z) {
                            VideoPbFragment.this.kcd.startPlay();
                            VideoPbFragment.this.kcd.cLV();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.kcd.setData(bkVar);
                }
            }
        });
        eVar.cLm().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: q */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.dLI.setCurrentItem(num.intValue());
            }
        });
        eVar.cLh().observe(this, new q<bk>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bk bkVar) {
                VideoPbFragment.this.kcd.aS(bkVar);
            }
        });
        eVar.cLi().observe(this, new q<bk>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bk bkVar) {
                VideoPbFragment.this.kcd.aT(bkVar);
            }
        });
        eVar.cLj().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.cKJ();
            }
        });
        eVar.cLk().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKy() {
        ViewGroup.LayoutParams layoutParams = this.kcg.getLayoutParams();
        layoutParams.height = 0;
        this.kcg.setLayoutParams(layoutParams);
        this.kcg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKz() {
        if (this.kce == null) {
            this.kce = new f(getBaseFragmentActivity(), this.kcc);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(cFc()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.kcc.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.kce.c(eVar.cLe(), rect);
            if (this.kce.cLq()) {
                this.kce.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (eVar.cLf() || VideoPbFragment.this.cDy().getTabIndex() == VideoPbFragment.kbW) {
                            VideoPbFragment.this.dLI.setCurrentItem(VideoPbFragment.kbW);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (eVar.cLf() || VideoPbFragment.this.cDy().getTabIndex() == VideoPbFragment.kbW) {
                            VideoPbFragment.this.dLI.setCurrentItem(VideoPbFragment.kbW);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (eVar.cLf() || cDy().getTabIndex() == kbW) {
                this.dLI.setCurrentItem(kbW);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.kcw && (this.kcx || cKW())) {
            cKV();
            UtilHelper.hideStatusBar(cFc(), cFc().getRootView());
            this.kcx = false;
            if (this.kcd != null) {
                this.kcd.sA(false);
            }
        }
        if (i == 4) {
            return this.kcd.cRz();
        }
        if (i == 24) {
            return this.kcd.cLS();
        }
        if (i == 25) {
            return this.kcd.cLT();
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
    public void aN(bk bkVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        CoordinatorLayout.LayoutParams layoutParams3;
        Rect cGq;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bkVar != null && bkVar.aQQ() != null) {
            int intValue = bkVar.aQQ().video_width.intValue();
            int intValue2 = bkVar.aQQ().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (cDy() != null || (cGq = cDy().cGq()) == null) ? ceil : cGq.height();
                i = 0;
                layoutParams = this.kcc.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.kcc.setLayoutParams(layoutParams);
                this.kcc.setMaxHeight(ceil);
                this.kcc.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.kcc.setOriginHeight(height);
                layoutParams2 = (RelativeLayout.LayoutParams) this.kbY.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, kbX);
                } else {
                    layoutParams2.height = kbX;
                }
                this.kbY.setLayoutParams(layoutParams2);
                layoutParams3 = (CoordinatorLayout.LayoutParams) this.Wr.getLayoutParams();
                int i2 = ceil + kbX;
                if (layoutParams3 != null) {
                    layoutParams3 = new CoordinatorLayout.LayoutParams(-1, i2);
                } else {
                    layoutParams3.height = i2;
                }
                this.Wr.setLayoutParams(layoutParams3);
                if (i == 0 && (this.Wr.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.Wr.getLayoutParams()).getBehavior();
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
        if (cDy() != null) {
        }
        i = 0;
        layoutParams = this.kcc.getLayoutParams();
        if (layoutParams != null) {
        }
        this.kcc.setLayoutParams(layoutParams);
        this.kcc.setMaxHeight(ceil2);
        this.kcc.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.kcc.setOriginHeight(height);
        layoutParams2 = (RelativeLayout.LayoutParams) this.kbY.getLayoutParams();
        if (layoutParams2 != null) {
        }
        this.kbY.setLayoutParams(layoutParams2);
        layoutParams3 = (CoordinatorLayout.LayoutParams) this.Wr.getLayoutParams();
        int i22 = ceil2 + kbX;
        if (layoutParams3 != null) {
        }
        this.Wr.setLayoutParams(layoutParams3);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.jKd = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        aq(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.jKT = new com.baidu.tbadk.core.view.c();
        this.jKT.toastTime = 1000L;
        if (this.kcq != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.kcq.jKU;
            userMuteAddAndDelCustomMessage.setTag(this.kcq.jKU);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.kcq.jKU;
            userMuteCheckCustomMessage.setTag(this.kcq.jKU);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        com.baidu.tieba.s.c.dct().z(getUniqueId());
    }

    private void initData() {
        this.jKx = com.baidu.tbadk.baseEditMark.a.a(this.jJW);
        if (this.jKx != null) {
            this.jKx.a(this.jLB);
        }
        this.gEV = new ForumManageModel(this.jJW);
        this.gEV.setLoadDataCallBack(this.gFa);
        this.dNL = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.kcq = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void aq(Bundle bundle) {
        this.jKL = new g();
        d(this.jKL);
        this.jKM = (com.baidu.tbadk.editortools.pb.e) this.jKL.dN(getActivity());
        this.jKM.a(this.jJW.getPageContext());
        this.jKM.a(this.emV);
        this.jKM.a(this.emO);
        this.jKM.a(this.jJW.getPageContext(), bundle);
        this.jKM.bcW().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.jKM.bcW().hW(true);
        rs(true);
        this.jKM.a(cDy().cFJ(), cDy().cFt(), cDy().cGa());
        registerListener(this.jLj);
        registerListener(this.jLA);
        registerListener(this.jLi);
        registerListener(this.jLg);
        registerListener(this.hov);
        if (!cDy().cFA()) {
            this.jKM.yj(cDy().cFt());
        }
        if (cDy().cGb()) {
            this.jKM.yh(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.jKM.yh(cHi());
        }
        this.jKD = new ax();
        if (this.jKM.bdv() != null) {
            this.jKD.d(this.jKM.bdv().getInputView());
        }
        this.jKM.a(this.emP);
        this.iPP = new aj(getPageContext());
        this.iPP.a(new aj.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
            @Override // com.baidu.tbadk.core.util.aj.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == aj.dNG) {
                        VideoPbFragment.this.jKM.a((String) null, (WriteData) null);
                    } else if (i == aj.dNH && VideoPbFragment.this.jSy != null && VideoPbFragment.this.jSy.cEi() != null) {
                        VideoPbFragment.this.jSy.cEi().bdR();
                    } else if (i == aj.dNI) {
                        VideoPbFragment.this.c(VideoPbFragment.this.jKP);
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
        this.hrk = new com.baidu.tieba.f.b(getActivity());
        this.hrk.a(jLK);
        this.kcw = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        brb();
        this.Wr = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.kca = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.kcc = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.kcd = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.kcc);
        this.kcd.setUniqueId(getUniqueId());
        this.kcd.ac(this);
        this.kcd.cQ(cFc().getRootView());
        this.kcd.cR(this.kcf);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.kbY = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.kcg = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.dLI = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.kcb = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.kcb.setOnClickListener(this.aUZ);
        cKB();
        cKA();
        cKC();
        this.kbZ = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.dLI.setAdapter(this.kbZ);
        this.kbY.setViewPager(this.dLI);
        this.kbY.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (VideoPbFragment.this.cKQ() != null) {
                        VideoPbFragment.this.cKQ().sG(false);
                    }
                    if (VideoPbFragment.this.cKR() != null) {
                        VideoPbFragment.this.cKR().sG(true);
                        VideoPbFragment.this.AP(VideoPbFragment.this.cKR().cLA() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.cLj() != null && eVar.cLj().getValue() != null && eVar.cLj().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.kcd.sH(z);
                    VideoPbFragment.this.cHg();
                    if (VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null) {
                        TiebaStatic.log(new an("c13592").dh("tid", VideoPbFragment.this.cDy().cFt()).dh("fid", VideoPbFragment.this.cDy().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.cKR() != null) {
                        VideoPbFragment.this.cKR().sG(false);
                    }
                    if (VideoPbFragment.this.cKQ() != null) {
                        VideoPbFragment.this.cKQ().sG(true);
                        int cLA = VideoPbFragment.this.cKQ().cLA();
                        int cLF = VideoPbFragment.this.cKQ().cLF();
                        if (cLA != 0) {
                            VideoPbFragment.this.AP(8);
                            VideoPbFragment.this.cKQ().AP(0);
                        } else if (cLF != 0) {
                            VideoPbFragment.this.cKQ().AP(8);
                            VideoPbFragment.this.AP(0);
                        } else {
                            VideoPbFragment.this.cKQ().AP(8);
                            VideoPbFragment.this.AP(8);
                        }
                    }
                    VideoPbFragment.this.kcd.sH(false);
                    VideoPbFragment.this.Wr.setExpanded(false, true);
                    if (VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null) {
                        TiebaStatic.log(new an("c13593").dh("tid", VideoPbFragment.this.cDy().cFt()).dh("fid", VideoPbFragment.this.cDy().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.kbZ.AR(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jRy = this.rootView.findViewById(R.id.viewstub_progress);
        cKD();
        bvm();
        if (!this.kcw && this.kcx) {
            cKV();
            UtilHelper.hideStatusBar(cFc(), cFc().getRootView());
            this.kcx = false;
        }
    }

    private void cKA() {
        this.kci = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.kcm = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.kcj = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.kck = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.kcl = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.kcn = this.rootView.findViewById(R.id.ala_live_point);
        this.kcm.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.kcm.setConrers(15);
        this.kcl.setConfig(new com.baidu.tbadk.core.view.commonBtn.d());
        this.kck.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.jEG == null || VideoPbFragment.this.jEG.cLJ()) {
                    if (VideoPbFragment.this.jEG != null) {
                        TiebaStatic.log(new an("c13608").dh("tid", VideoPbFragment.this.cDy().getPbData().getThreadId()));
                        VideoPbFragment.this.jEG.kec = true;
                    }
                } else {
                    TiebaStatic.log(new an("c13591"));
                }
                VideoPbFragment.this.cKL();
            }
        });
        this.kcl.setOnClickListener(this.kch);
        this.kcg.setOnClickListener(this.kch);
    }

    private void cKB() {
        this.kbY.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.kbY.setContainerLayoutParams(layoutParams);
        this.kbY.setRectPaintColor(R.color.cp_link_tip_a);
        this.kbY.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.kbY.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.kbY.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.kbY.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.kbY.setExpandedTabLayoutParams(layoutParams2);
    }

    public void sz(boolean z) {
        if (this.Wr != null) {
            this.Wr.setExpanded(z);
        }
    }

    private void cKC() {
        this.jRP = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.jRQ = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.jSa = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jSb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.jRS = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.jRS.setVisibility(com.baidu.tbadk.a.d.aMt() ? 0 : 8);
        if (com.baidu.tbadk.a.d.aMt()) {
            this.jRS.setIsRound(true);
            this.jRS.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.jRS.setBorderColor(am.getColor(R.color.cp_border_a));
            this.jRS.setPlaceHolder(1);
            this.jRS.setDefaultResource(R.color.cp_bg_line_e);
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.jRS.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            }
        }
        this.igY = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.jRR = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.jRR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.sz(false);
                VideoPbFragment.this.cEu();
                if (VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null && VideoPbFragment.this.cDy().getPbData().cCi() != null && VideoPbFragment.this.cDy().getPbData().cCi().aQx() != null) {
                    if (com.baidu.tbadk.a.d.aMt()) {
                        TiebaStatic.log(new an("c13701").dh("tid", VideoPbFragment.this.cDy().cFu()).dh("fid", VideoPbFragment.this.cDy().getPbData().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    }
                    TiebaStatic.log(new an("c13402").dh("tid", VideoPbFragment.this.cDy().cFt()).dh("fid", VideoPbFragment.this.cDy().getPbData().getForumId()).ag("obj_locate", 1).dh("uid", VideoPbFragment.this.cDy().getPbData().cCi().aQx().getUserId()));
                }
            }
        });
        this.jRT = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.jRT.setOnClickListener(this.aUZ);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.jRU = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.jRU.setOnClickListener(this.aUZ);
        if (booleanExtra) {
            this.jRU.setVisibility(8);
        } else {
            this.jRU.setVisibility(0);
        }
        this.jRV = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.jRV.setOnClickListener(this.aUZ);
        this.jRW = new com.baidu.tieba.pb.view.c(this.jRV);
        this.jRW.cMf();
        if (com.baidu.tbadk.a.d.aMt()) {
            this.jRX = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
            this.jRX.setVisibility(0);
        } else {
            this.jRY = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_number);
            this.jRY.setVisibility(0);
        }
        sa(false);
    }

    private void brb() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.bVo();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.kcf = this.rootView.findViewById(R.id.status_bar_background);
        if (this.kcw) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(cFc());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.kcf.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(cFc());
            this.kcf.setLayoutParams(layoutParams2);
            this.kcf.setVisibility(0);
        }
        this.eun = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aUZ);
        this.fxl = (ImageView) this.eun.findViewById(R.id.widget_navi_back_button);
        SvgManager.aUV().a(this.fxl, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jXw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aUZ);
        this.aex = (ImageView) this.jXw.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.jXw.setLayoutParams(layoutParams3);
        SvgManager.aUV().a(this.aex, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jXw.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.hxD);
        this.mNavigationBar.setOnTouchListener(this.kcy);
    }

    public void cKD() {
        setEditorTools(this.jKM.bcW());
    }

    private void bvm() {
        this.jJT = new PbFakeFloorModel(getPageContext());
        this.jSy = new t(getPageContext(), this.jJT, this.rootView);
        this.jSy.a(this.jLx);
        this.jJT.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.jJT.t(postData);
                if (VideoPbFragment.this.cKQ() != null) {
                    VideoPbFragment.this.cKQ().cLB();
                }
                VideoPbFragment.this.jSy.cEe();
                VideoPbFragment.this.Zt.bbz();
                VideoPbFragment.this.sa(false);
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.jJW = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (cDy() != null) {
            cDy().aA(bundle);
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
        this.beu = true;
        getVoiceManager().onPause(getPageContext());
        this.kcd.or(true);
        if (cDy() != null && !cDy().cFA()) {
            this.jKM.yi(cDy().cFt());
        }
        com.baidu.tbadk.BdToken.c.aLi().aLn();
        MessageManager.getInstance().unRegisterListener(this.jLs);
        MessageManager.getInstance().unRegisterListener(this.jLt);
        MessageManager.getInstance().unRegisterListener(this.jLu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.beu = false;
        getVoiceManager().onResume(getPageContext());
        this.kcd.or(false);
        cEY();
        registerListener(this.jLs);
        registerListener(this.jLt);
        registerListener(this.jLu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.kbZ != null && this.dLI != null) {
            this.kbZ.AR(z ? this.dLI.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (com.baidu.tbadk.a.d.aMt() && this.jRS != null) {
            this.jRS.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.dct().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dct().A(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.jRW != null) {
            this.jRW.onDestroy();
        }
        if (this.gEV != null) {
            this.gEV.cancelLoadData();
        }
        if (this.kcd != null) {
            this.kcd.onDestroy();
        }
        if (this.jKn != null) {
            this.jKn.cancelLoadData();
        }
        if (this.iPP != null) {
            this.iPP.onDestroy();
        }
        if (cDy() != null) {
            cDy().cancelLoadData();
            cDy().destory();
            if (cDy().cFX() != null) {
                cDy().cFX().onDestroy();
            }
        }
        if (this.jKM != null) {
            this.jKM.onDestroy();
        }
        this.jKT = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.jJW);
        this.kbY.onChangeSkinType();
        am.setBackgroundColor(this.kbY, R.color.cp_bg_line_h);
        this.jKD.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.kce == null || !this.kce.isPlaying()) {
            am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        am.setBackgroundColor(this.kcf, R.color.cp_mask_b_alpha66);
        if (this.Zt != null) {
            this.Zt.onChangeSkinType(i);
        }
        if (this.jSy != null) {
            this.jSy.onChangeSkinType(i);
        }
        if (this.igY != null) {
            am.setViewTextColor(this.igY, (int) R.color.cp_cont_d);
        }
        if (this.jRS != null) {
            this.jRS.setBorderColor(am.getColor(R.color.cp_border_a));
        }
        if (this.jRR != null) {
            this.jRR.setBackgroundDrawable(am.aE(l.getDimens(getContext(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
        }
        if (this.jRU != null && cDy() != null) {
            if (cDy().aML()) {
                SvgManager.aUV().a(this.jRU, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aUV().a(this.jRU, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.jRT != null) {
            SvgManager.aUV().a(this.jRT, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (cDy() != null) {
            w(cDy().getPbData());
        }
        if (this.jRX != null) {
            am.c(this.jRX, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_cont_h, R.color.cp_cont_h);
            am.setViewTextColor(this.jRX, (int) R.color.cp_cont_a);
        }
        if (this.jRY != null) {
            am.setViewTextColor(this.jRY, (int) R.color.cp_cont_b);
        }
        if (this.jRP != null) {
            am.setBackgroundResource(this.jRP, R.drawable.bottom_shadow);
        }
        am.setBackgroundColor(this.jRQ, R.color.cp_bg_line_h);
        if (cKQ() != null) {
            cKQ().onChangeSkinType(i);
        }
        if (cKR() != null) {
            cKR().onChangeSkinType(i);
        }
        if (this.kca != null) {
            am.setBackgroundResource(this.kca, R.drawable.personalize_tab_shadow);
        }
        if (this.kcg != null) {
            am.setBackgroundColor(this.kcg, R.color.cp_bg_line_g);
        }
        if (this.kck != null) {
            SvgManager.aUV().a(this.kck, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.kci != null) {
            am.setViewTextColor(this.kci, (int) R.color.cp_cont_b);
        }
        if (this.kcj != null) {
            am.setViewTextColor(this.kcj, (int) R.color.cp_cont_d);
        }
        if (this.kcn != null) {
            this.kcn.setBackgroundDrawable(am.aE(l.getDimens(this.kcn.getContext(), R.dimen.tbds32), am.getColor(R.color.cp_other_c)));
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hnh == null) {
            this.hnh = VoiceManager.instance();
        }
        return this.hnh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVn() {
        if (this.hnh != null) {
            this.hnh.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cFa() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cFb() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel cDy() {
        return this.jJW.cDy();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cFc() {
        return this.jJW;
    }

    public com.baidu.tbadk.baseEditMark.a cKE() {
        return this.jKx;
    }

    public View.OnClickListener cKF() {
        return this.aUZ;
    }

    public View.OnClickListener cKG() {
        return this.jHE;
    }

    public View.OnLongClickListener cKH() {
        return this.kcq.cKH();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (com.baidu.tieba.pb.pb.main.ba.JD(objArr[i].getLink()) && (drawable = am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView bXR() {
        Iterator<BaseFragment> it = this.kbZ.cLa().iterator();
        while (it.hasNext()) {
            BaseFragment next = it.next();
            if (next instanceof ReplyFragment) {
                return ((ReplyFragment) next).getListView();
            }
        }
        return null;
    }

    private void rs(boolean z) {
        this.jKM.ia(z);
        this.jKM.ib(z);
        this.jKM.ic(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.kcq != null) {
            if (z) {
                this.kcq.cHU();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.kcq.cHV();
            } else {
                this.kcq.cHU();
            }
        }
    }

    public boolean Af(int i) {
        if (this.iPP == null || cDy() == null || cDy().getPbData() == null || cDy().getPbData().getAnti() == null) {
            return true;
        }
        return this.iPP.aD(cDy().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean cEw() {
        if ((cDy() != null && cDy().getPbData().cCJ()) || this.iPP == null || cDy() == null || cDy().getPbData() == null || cDy().getPbData().getAnti() == null) {
            return true;
        }
        return this.iPP.kZ(cDy().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && cDy() != null) {
            gVar.setForumName(cDy().cDp());
            if (cDy().getPbData() != null && cDy().getPbData().getForum() != null) {
                gVar.a(cDy().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(cDy());
        }
    }

    public void cHw() {
        if (this.Zt != null) {
            this.Zt.display();
            if (this.jKM != null) {
                this.jKM.bdz();
            }
            cIe();
        }
    }

    private boolean cEt() {
        PbModel cDy = cDy();
        if (cDy == null || cDy.getPbData() == null) {
            return false;
        }
        bk cCi = cDy.getPbData().cCi();
        cDy.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cCi);
    }

    public void cEu() {
        if (checkUpIsLogin() && cDy() != null && cDy().getPbData() != null && cDy().getPbData().getForum() != null && !cEt()) {
            if (cDy().getPbData().cCJ()) {
                cgO();
                return;
            }
            if (this.hqP == null) {
                this.hqP = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hqP.uZ(0);
                this.hqP.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void na(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void x(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void nb(boolean z) {
                        if (z) {
                            VideoPbFragment.this.cgO();
                        }
                    }
                });
            }
            this.hqP.D(cDy().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cDy().cFt(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.jKM.onActivityResult(i, i2, intent);
        if (this.jKn != null) {
            this.jKn.onActivityResult(i, i2, intent);
        }
        if (this.jSy != null) {
            this.jSy.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cEG();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cTS().D(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.jKP = emotionImageData;
                        if (Af(aj.dNI)) {
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
        if (cFc() != null) {
            if (this.kcx && !TbSingleton.getInstance().isNotchScreen(cFc()) && !TbSingleton.getInstance().isCutoutScreen(cFc())) {
                cKV();
                UtilHelper.hideStatusBar(cFc(), cFc().getRootView());
                this.kcx = false;
            }
            this.kcr.kcK = z;
            cKI();
            cKJ();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.jJW;
        if (i == 0) {
            cHc();
            if (this.jSy != null) {
                this.jSy.cEe();
            }
            sa(false);
        }
        cHg();
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
                        this.jKM.resetData();
                        this.jKM.setVoiceModel(pbEditorData.getVoiceModel());
                        this.jKM.b(writeData);
                        com.baidu.tbadk.editortools.l nf = this.jKM.bcW().nf(6);
                        if (nf != null && nf.ekV != null) {
                            nf.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.jJW;
                        if (i == -1) {
                            this.jKM.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.jSy != null && this.jSy.cEi() != null) {
                            com.baidu.tbadk.editortools.pb.h cEi = this.jSy.cEi();
                            cEi.setThreadData(cDy().getPbData().cCi());
                            cEi.b(writeData);
                            cEi.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l nf2 = cEi.bcW().nf(6);
                            if (nf2 != null && nf2.ekV != null) {
                                nf2.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.jJW;
                            if (i == -1) {
                                cEi.bdR();
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
                if (cDy() != null && !cDy().cFA()) {
                    antiData.setBlock_forum_name(cDy().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(cDy().getPbData().getForum().getId());
                    antiData.setUser_name(cDy().getPbData().getUserData().getUserName());
                    antiData.setUser_id(cDy().getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bv(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.kcq != null) {
                this.kcq.yo(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void cFe() {
        if (cDy() != null && this.jJW != null) {
            if (this.jKM == null || !this.jKM.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.jKM = (com.baidu.tbadk.editortools.pb.e) dVar.dN(getContext());
                this.jKM.a(this.jJW.getPageContext());
                this.jKM.a(this.emV);
                this.jKM.a(this.emO);
                this.jKM.a(this.jJW.getPageContext(), this.jJW.getIntent() == null ? null : this.jJW.getIntent().getExtras());
                this.jKM.bcW().hW(true);
                setEditorTools(this.jKM.bcW());
                if (!cDy().cFA()) {
                    this.jKM.yj(cDy().cFt());
                }
                if (cDy().cGb()) {
                    this.jKM.yh(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.jKM.yh(cHi());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Zt = editorTools;
        this.Zt.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Zt.getParent() == null) {
            this.rootView.addView(this.Zt, layoutParams);
        }
        this.Zt.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.Zt.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).aYc() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).aYc() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.jKM.c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            VideoPbFragment.this.jKM.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cHc();
        this.jKM.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.Zt != null && VideoPbFragment.this.Zt.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.jKD != null && VideoPbFragment.this.jKD.cIt() != null) {
                    if (!VideoPbFragment.this.jKD.cIt().dmj()) {
                        VideoPbFragment.this.jKD.sf(false);
                    }
                    VideoPbFragment.this.jKD.cIt().vm(false);
                }
            }
        });
    }

    public void cgO() {
        if (!checkUpIsLogin()) {
            if (cDy() != null) {
                TiebaStatic.log(new an("c10517").ag("obj_locate", 2).dh("fid", cDy().getForumId()));
            }
        } else if (cEw()) {
            if (this.jKM != null && (this.jKM.bdJ() || this.jKM.bdK())) {
                this.jKM.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Zt != null) {
                cHw();
                this.kcr.kcJ = false;
                if (this.Zt.nf(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.Zt.nf(2).ekV, false, null);
                }
            }
            cIe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cEt() && cEw()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.jKp);
                this.jKq = ((View) view.getParent()).getMeasuredHeight();
            }
            if (cDy() != null && cDy().getPbData() != null && cDy().getPbData().cCJ()) {
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.jJW.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.bXR().smoothScrollBy(0, (VideoPbFragment.this.jKp[1] + VideoPbFragment.this.jKq) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.jSy != null) {
                            VideoPbFragment.this.jKM.bcW().setVisibility(8);
                            VideoPbFragment.this.jSy.g(str, str2, VideoPbFragment.this.cHi(), (VideoPbFragment.this.cDy() == null || VideoPbFragment.this.cDy().getPbData() == null || VideoPbFragment.this.cDy().getPbData().cCi() == null || !VideoPbFragment.this.cDy().getPbData().cCi().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cEi = VideoPbFragment.this.jSy.cEi();
                            if (cEi != null && VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null) {
                                cEi.a(VideoPbFragment.this.cDy().getPbData().getAnti());
                                cEi.setThreadData(VideoPbFragment.this.cDy().getPbData().cCi());
                            }
                            if (VideoPbFragment.this.jKD.cIv() == null && VideoPbFragment.this.jSy.cEi().bdZ() != null) {
                                VideoPbFragment.this.jSy.cEi().bdZ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.jKD != null && VideoPbFragment.this.jKD.cIu() != null) {
                                            if (!VideoPbFragment.this.jKD.cIu().dmj()) {
                                                VideoPbFragment.this.jKD.sg(false);
                                            }
                                            VideoPbFragment.this.jKD.cIu().vm(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.jKD.e(VideoPbFragment.this.jSy.cEi().bdZ().getInputView());
                                VideoPbFragment.this.jSy.cEi().a(VideoPbFragment.this.jKR);
                            }
                        }
                        VideoPbFragment.this.cIe();
                    }
                }, 0L);
                return;
            }
            if (this.jKO == null) {
                this.jKO = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jKO.uZ(1);
                this.jKO.a(new AnonymousClass44(str, str2));
            }
            if (cDy() != null && cDy().getPbData() != null && cDy().getPbData().getForum() != null) {
                this.jKO.D(cDy().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cDy().cFt(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$44  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass44 implements c.a {
        final /* synthetic */ String jLW;
        final /* synthetic */ String jLX;

        AnonymousClass44(String str, String str2) {
            this.jLW = str;
            this.jLX = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void na(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void x(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nb(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.bXR().smoothScrollBy(0, (VideoPbFragment.this.jKp[1] + VideoPbFragment.this.jKq) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.jSy != null) {
                            VideoPbFragment.this.jKM.bcW().setVisibility(8);
                            VideoPbFragment.this.jSy.g(AnonymousClass44.this.jLW, AnonymousClass44.this.jLX, VideoPbFragment.this.cHi(), (VideoPbFragment.this.cDy() == null || VideoPbFragment.this.cDy().getPbData() == null || VideoPbFragment.this.cDy().getPbData().cCi() == null || !VideoPbFragment.this.cDy().getPbData().cCi().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cEi = VideoPbFragment.this.jSy.cEi();
                            if (cEi != null && VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null) {
                                cEi.a(VideoPbFragment.this.cDy().getPbData().getAnti());
                                cEi.setThreadData(VideoPbFragment.this.cDy().getPbData().cCi());
                            }
                            if (VideoPbFragment.this.jKD.cIv() == null && VideoPbFragment.this.jSy.cEi().bdZ() != null) {
                                VideoPbFragment.this.jSy.cEi().bdZ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.jKD != null && VideoPbFragment.this.jKD.cIu() != null) {
                                            if (!VideoPbFragment.this.jKD.cIu().dmj()) {
                                                VideoPbFragment.this.jKD.sg(false);
                                            }
                                            VideoPbFragment.this.jKD.cIu().vm(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.jKD.e(VideoPbFragment.this.jSy.cEi().bdZ().getInputView());
                                VideoPbFragment.this.jSy.cEi().a(VideoPbFragment.this.jKR);
                            }
                        }
                        VideoPbFragment.this.cIe();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        PostData H;
        com.baidu.tbadk.core.data.v vVar;
        StringBuilder sb = null;
        if (eVar != null && (H = H(eVar)) != null) {
            String userId = H.aQx().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, H.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cCx()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (H.aQx() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, H.aQx().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, H.aQx().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, H.aQx().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, H.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, H.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cCx()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bg> cCE = eVar.cCE();
                if (v.getCount(cCE) > 0) {
                    sb = new StringBuilder();
                    for (bg bgVar : cCE) {
                        if (bgVar != null && !StringUtils.isNull(bgVar.getForumName()) && (vVar = bgVar.dEk) != null && vVar.dCh && !vVar.dCi && (vVar.type == 1 || vVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bgVar.getForumName(), 12)).append(TbadkCoreApplication.getInst().getString(R.string.forum)).append("、");
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
    public void cEG() {
        MarkData Ar;
        if (cDy() != null && cDy().getPbData() != null && cKQ() != null && this.jKx != null) {
            if (cDy().getPbData() != null && cDy().getPbData().cCJ()) {
                Ar = cDy().Ar(0);
            } else if (this.dLI != null && this.dLI.getCurrentItem() == kbV) {
                Ar = cDy().o(H(cDy().getPbData()));
            } else {
                Ar = cDy().Ar(cKQ().cHG());
            }
            if (Ar != null) {
                if (!Ar.isApp() || (Ar = cDy().Ar(cKQ().cHG() + 1)) != null) {
                    cHB();
                    this.jKx.a(Ar);
                    if (!this.jKx.aML()) {
                        this.jKx.aMN();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.jKx.aMM();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ag(int i) {
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
            if (this.jKn == null) {
                this.jKn = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.jJW);
                this.jKn.b(this.emO);
                this.jKn.c(this.emV);
            }
            this.jKn.a(emotionImageData, cDy(), cDy().getPbData());
        }
    }

    public PostData H(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.cCv() != null) {
            return eVar.cCv();
        }
        if (!v.isEmpty(eVar.cCk())) {
            Iterator<PostData> it = eVar.cCk().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.ddu() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.cCr();
        }
        if (postData == null) {
            postData = a(eVar);
        }
        if (postData != null && postData.aQx() != null && postData.aQx().getUserTbVipInfoData() != null && postData.aQx().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aQx().getGodUserData().setIntro(postData.aQx().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cCi() == null || eVar.cCi().aQx() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aQx = eVar.cCi().aQx();
        String userId = aQx.getUserId();
        HashMap<String, MetaData> userMap = eVar.cCi().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aQx;
        }
        postData.DS(1);
        postData.setId(eVar.cCi().aQP());
        postData.setTitle(eVar.cCi().getTitle());
        postData.setTime(eVar.cCi().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cEL() {
        ArrayList<PostData> cCk;
        int count;
        int i;
        if (cDy() == null || cDy().getPbData() == null || cDy().getPbData().cCk() == null || (count = v.getCount((cCk = cDy().getPbData().cCk()))) == 0) {
            return "";
        }
        if (cDy().cFL()) {
            Iterator<PostData> it = cCk.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.ddu() == 1) {
                    return next.getId();
                }
            }
        }
        if (bXR() == null) {
            i = 0;
        } else {
            i = cKQ().cHF();
        }
        PostData postData = (PostData) v.getItem(cCk, i);
        if (postData == null || postData.aQx() == null) {
            return "";
        }
        if (cDy().Jr(postData.aQx().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) v.getItem(cCk, i2);
            if (postData2 == null || postData2.aQx() == null || postData2.aQx().getUserId() == null) {
                break;
            } else if (cDy().Jr(postData2.aQx().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) v.getItem(cCk, i3);
            if (postData3 == null || postData3.aQx() == null || postData3.aQx().getUserId() == null) {
                return "";
            }
            if (cDy().Jr(postData3.aQx().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEH() {
        if (cDy() != null) {
            com.baidu.tieba.pb.data.e pbData = cDy().getPbData();
            cDy().rG(true);
            if (this.jKx != null) {
                pbData.Jc(this.jKx.aMK());
            }
            if (cKQ() != null) {
                cKQ().cLB();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (cDy() != null) {
            cHD();
            cDy().rG(z);
            if (this.jKx != null) {
                this.jKx.gC(z);
                if (markData != null) {
                    this.jKx.a(markData);
                }
            }
            if (cDy().aML()) {
                cEH();
            } else if (cKQ() != null) {
                cKQ().cLB();
            }
        }
    }

    public void b(n nVar) {
        MetaData metaData;
        boolean z = true;
        if (cDy() != null && cDy().getPbData() != null && nVar.cDc() != null) {
            String id = nVar.cDc().getId();
            ArrayList<PostData> cCk = cDy().getPbData().cCk();
            int i = 0;
            while (true) {
                if (i >= cCk.size()) {
                    break;
                }
                PostData postData = cCk.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cDg = nVar.cDg();
                    postData.DR(nVar.getTotalCount());
                    if (postData.ddr() != null && cDg != null) {
                        Iterator<PostData> it = cDg.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aQx() != null && (metaData = postData.getUserMap().get(next.aQx().getUserId())) != null) {
                                next.a(metaData);
                                next.uu(true);
                                next.a(getPageContext(), cDy().Jr(metaData.getUserId()));
                            }
                        }
                        boolean z2 = cDg.size() != postData.ddr().size();
                        postData.ddr().clear();
                        postData.ddr().addAll(cDg);
                        z = z2;
                    }
                    if (postData.ddn() != null) {
                        postData.ddo();
                    }
                }
            }
            if (!cDy().getIsFromMark() && z && cKQ() != null) {
                cKQ().cLB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEy() {
        if (cDy() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.LP(cDy().getForumId()) && cDy().getPbData() != null && cDy().getPbData().getForum() != null) {
            if (cDy().getPbData().getForum().isLike() == 1) {
                cDy().cFZ().fj(cDy().getForumId(), cDy().cFt());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            bk cCi = eVar.cCi();
            if (cCi != null && cCi.aSx()) {
                cFe();
            } else {
                d(this.jKL);
            }
            if (this.jKM != null) {
                rY(this.jKM.bdC());
                this.jKM.a(eVar.getAnti());
                this.jKM.a(eVar.getForum(), eVar.getUserData());
                this.jKM.setThreadData(cCi);
                if (cDy() != null) {
                    this.jKM.a(cDy().cFJ(), cDy().cFt(), cDy().cGa());
                }
                if (cCi != null) {
                    this.jKM.id(cCi.aRV());
                }
            }
        }
    }

    public void cHg() {
        reset();
        cHc();
        this.jSy.cEe();
        sa(false);
    }

    private void reset() {
        if (this.jKM != null && this.Zt != null) {
            com.baidu.tbadk.editortools.pb.a.bds().setStatus(0);
            this.jKM.bdM();
            this.jKM.bdg();
            if (this.jKM.getWriteImagesInfo() != null) {
                this.jKM.getWriteImagesInfo().setMaxImagesAllowed(this.jKM.isBJH ? 1 : 9);
            }
            this.jKM.nl(SendView.ALL);
            this.jKM.nm(SendView.ALL);
            com.baidu.tbadk.editortools.g nc = this.Zt.nc(23);
            com.baidu.tbadk.editortools.g nc2 = this.Zt.nc(2);
            com.baidu.tbadk.editortools.g nc3 = this.Zt.nc(5);
            if (nc2 != null) {
                nc2.display();
            }
            if (nc3 != null) {
                nc3.display();
            }
            if (nc != null) {
                nc.hide();
            }
            this.Zt.invalidate();
        }
    }

    public void t(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCi() != null) {
            w(eVar);
            this.jRU.setVisibility(eVar.cCJ() ? 8 : 0);
            if (eVar.aML()) {
                SvgManager.aUV().a(this.jRU, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aUV().a(this.jRU, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String Az = Az(eVar.cCi().aQo());
            if (this.jRX != null) {
                this.jRX.setText(Az);
            }
            if (this.jRY != null) {
                this.jRY.setText(Az);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.cCi()));
        }
    }

    public void w(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.aZ(eVar.cCi())) {
            if (this.jRW != null) {
                this.jRW.setEnable(false);
                this.jRW.onDestroy();
            }
            SvgManager.aUV().a(this.jRV, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.jRW == null || !this.jRW.isEnable()) {
            SvgManager.aUV().a(this.jRV, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private String Az(int i) {
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

    public void sa(boolean z) {
        if (this.jRQ != null) {
            rY(this.jKM.bdC());
            if (this.jRM) {
                rP(z);
            } else {
                rQ(z);
            }
            cKI();
            cKJ();
        }
    }

    public void cIe() {
        if (this.jRQ != null) {
            this.jRP.setVisibility(8);
            this.jRQ.setVisibility(8);
            this.kcr.kcJ = false;
            cKI();
            cKJ();
        }
    }

    private void cKI() {
        if (this.kcd != null) {
            if (this.kcr.cKZ()) {
                this.kcd.ty(false);
            } else {
                this.kcd.ty(this.kcd.bxC() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKJ() {
        if (this.kcd != null && this.dLI != null) {
            if (this.dLI.getCurrentItem() != 0) {
                this.kcd.sH(false);
            } else if (this.kcr.cKZ()) {
                this.kcd.sH(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.kcd.sH(eVar.cLj() == null || eVar.cLj().getValue() == null || eVar.cLj().getValue().booleanValue());
                }
            }
        }
    }

    private void Ah(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(cFc(), cEx(), i);
    }

    private int cEx() {
        if (cDy() == null || cDy().getPbData() == null || cDy().getPbData().cCi() == null) {
            return -1;
        }
        return cDy().getPbData().cCi().aRl();
    }

    public void rY(boolean z) {
        this.jRM = z;
    }

    public void rP(boolean z) {
        if (this.jRQ != null && this.igY != null) {
            this.igY.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.jRQ.startAnimation(alphaAnimation);
            }
            this.jRP.setVisibility(0);
            this.jRQ.setVisibility(0);
            this.kcr.kcJ = true;
        }
    }

    public void rQ(boolean z) {
        if (this.jRQ != null && this.igY != null) {
            this.igY.setText(cHi());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.jRQ.startAnimation(alphaAnimation);
            }
            this.jRP.setVisibility(0);
            this.jRQ.setVisibility(0);
            this.kcr.kcJ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null) {
            this.jEG = aVar;
            this.kci.setText(aVar.getTitle());
            this.kcj.setText(aVar.cLG());
            String cLH = aVar.cLH();
            TBSpecificationBtn tBSpecificationBtn = this.kcl;
            if (TextUtils.isEmpty(cLH)) {
                cLH = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(cLH);
            this.kcm.startLoad(aVar.getImage(), 10, false);
            this.kcn.setVisibility(aVar.cLJ() ? 0 : 8);
            com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.jEG == null || VideoPbFragment.this.jEG.cLJ()) {
                        if (VideoPbFragment.this.jEG != null && VideoPbFragment.this.cDy() != null && VideoPbFragment.this.cDy().getPbData() != null && VideoPbFragment.this.cDy().getPbData().getForum() != null) {
                            TiebaStatic.log(new an("c13712").dh("fid", VideoPbFragment.this.cDy().getPbData().getForum().getId()).dh("fname", VideoPbFragment.this.cDy().getPbData().getForum().getName()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", VideoPbFragment.this.cDy().getPbData().getThreadId()).s("obj_param1", VideoPbFragment.this.jEG.userId));
                        }
                    } else {
                        TiebaStatic.log(new an("c13608").dh("obj_id", VideoPbFragment.this.jEG.getTitle()).dh("obj_name", VideoPbFragment.this.jEG.cLG()).ag("obj_type", 2).dh("fid", VideoPbFragment.this.cDy().getPbData().getForumId()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", VideoPbFragment.this.cDy().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.cKK();
                }
            }, aVar.cLI().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKK() {
        ViewGroup.LayoutParams layoutParams = this.kcg.getLayoutParams();
        if (layoutParams != null) {
            if (this.kco == null || !this.kco.isRunning()) {
                this.kcg.setAlpha(0.0f);
                this.kcg.setVisibility(0);
                f(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKL() {
        if (this.kcg.getLayoutParams() != null) {
            if (this.kco == null || !this.kco.isRunning()) {
                cKM();
            }
        }
    }

    private void cKM() {
        final ViewGroup.LayoutParams layoutParams = this.kcg.getLayoutParams();
        if (layoutParams != null) {
            if (this.kcp == null || !this.kcp.isRunning()) {
                this.kcp = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.kcp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.kcg.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.kcp.setDuration(200L);
                this.kcp.start();
                this.kcp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
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
        final ViewGroup.LayoutParams layoutParams2 = this.Wr.getLayoutParams();
        final int i = layoutParams2.height;
        this.kco = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kco.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.ifs);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.ifs);
                VideoPbFragment.this.kcg.setLayoutParams(layoutParams);
                VideoPbFragment.this.Wr.setLayoutParams(layoutParams2);
            }
        });
        this.kco.setDuration(300L);
        this.kco.start();
        this.kco.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.kcg.setVisibility(8);
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
        final ViewGroup.LayoutParams layoutParams2 = this.Wr.getLayoutParams();
        final int i = layoutParams2.height;
        this.kco = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kco.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.ifs);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.kcg.setLayoutParams(layoutParams);
                VideoPbFragment.this.Wr.setLayoutParams(layoutParams2);
            }
        });
        this.kco.setDuration(300L);
        this.kco.start();
        this.kco.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.cKN();
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
    public void cKN() {
        this.kco = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kco.setDuration(300L);
        this.kco.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.kcg.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.kco.start();
    }

    public String cHi() {
        if (!aq.isEmpty(this.jSP)) {
            return this.jSP;
        }
        this.jSP = TbadkCoreApplication.getInst().getResources().getString(au.cGX());
        return this.jSP;
    }

    public void cHD() {
        hideProgressBar();
        if (cKQ() != null) {
            cKQ().endLoadData();
            cKQ().cHE();
        }
    }

    public boolean cB(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.aNQ().isShowImages()) {
                    return Jn(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (cDy() == null || cDy().getPbData() == null) {
                        return true;
                    }
                    if (this.jSy != null) {
                        this.jSy.cEe();
                    }
                    n nVar = new n();
                    nVar.a(cDy().getPbData().getForum());
                    nVar.setThreadData(cDy().getPbData().cCi());
                    nVar.g(postData);
                    this.jJT.d(nVar);
                    this.jJT.setPostId(postData.getId());
                    b(view, postData.aQx().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.jKM != null) {
                        rY(this.jKM.bdC());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void cKO() {
        if (this.jKM != null) {
            rY(this.jKM.bdC());
        }
        cHg();
        this.kcq.cHU();
    }

    private boolean Jn(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("bubble_link", "");
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

    public void cnI() {
        if (this.jRy != null) {
            this.jRy.setVisibility(0);
        }
    }

    public void cnH() {
        if (this.jRy != null) {
            this.jRy.setVisibility(8);
        }
    }

    public void AP(int i) {
        if (this.kca != null) {
            this.kca.setVisibility(i);
        }
    }

    public void cHB() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a cEB() {
        return this.jLz;
    }

    public void cHc() {
        if (this.Zt != null) {
            this.Zt.hide();
        }
    }

    public void bVo() {
        if (this.jJW.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.jJW.getCurrentFocus());
        }
    }

    public void J(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCi() != null) {
            String valueOf = String.valueOf(eVar.cCi().aQo());
            if (eVar.cCi().aQo() == 0) {
                valueOf = "";
            }
            this.kbY.zf(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        for (BaseFragment baseFragment : this.kbZ.cLa()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, eVar, str, i4);
            }
        }
        b(z, i, i2, i3, eVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (cDy() != null && cDy().getPbData() != null && cDy().getPbData().cCi() != null && cDy().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(jSr)).intValue();
                if (intValue == jSs) {
                    if (!this.gEV.dek()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.gEV.MG(aq.O(jSONArray));
                        }
                        this.gEV.a(cDy().getPbData().getForum().getId(), cDy().getPbData().getForum().getName(), cDy().getPbData().cCi().getId(), str, intValue3, intValue2, booleanValue, cDy().getPbData().cCi().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == jSt || intValue == jSv) {
                    if (cDy().cFW() != null) {
                        cDy().cFW().Ab(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == jSt) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dN(String str, String str2) {
        ba.aUZ().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int biX() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> biY() {
        if (this.eBr == null) {
            this.eBr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bjk */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.aNQ().isShowImages();
                    foreDrawableImageView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
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
                        if (com.baidu.tbadk.core.k.aNQ().isShowImages()) {
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
        return this.eBr;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> biZ() {
        if (this.eEf == null) {
            this.eEf = TbRichTextView.u(getPageContext().getPageActivity(), 8);
        }
        return this.eEf;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bja() {
        if (this.eBs == null) {
            this.eBs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bPO */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.aNQ().isShowImages();
                    gifView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
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
                    if (com.baidu.tbadk.core.k.aNQ().isShowImages()) {
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
                    gifView.ber();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.eBs;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bjb() {
        if (this.eEg == null) {
            this.eEg = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cFf */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cE */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cF */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).deL();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cG */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.eEg;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bjc() {
        if (this.eEh == null) {
            this.eEh = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cFh */
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
                /* renamed from: c */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.eEh;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bjd() {
        this.eEi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFg */
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
        return this.eEi;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void al(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.jKh = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void f(Context context, String str, boolean z) {
        if (com.baidu.tieba.pb.pb.main.ba.JD(str) && cDy() != null && cDy().cFt() != null) {
            TiebaStatic.log(new an("c11664").ag("obj_param1", 1).dh("post_id", cDy().cFt()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.ejY = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
            }
        } else {
            com.baidu.tieba.pb.pb.main.ba.cIx().d(getPageContext(), str);
        }
        this.jKh = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void am(Context context, String str) {
        com.baidu.tieba.pb.pb.main.ba.cIx().d(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.jKh = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void an(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void s(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.kcq.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b cLt = this.kcq.cLt();
            if (cLt == null) {
                this.kcq.cEs();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                cLt.getItemView(1).setVisibility(8);
            } else {
                cLt.getItemView(1).setVisibility(0);
            }
            cLt.aSU();
            this.jKh = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ap(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            ba.aUZ().b(getPageContext(), new String[]{str});
            this.jKh = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a cKP() {
        return this.dNL;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bgM() {
        return this.evw;
    }

    public ReplyFragment cKQ() {
        if (this.kbZ == null || !(this.kbZ.AQ(kbW) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.kbZ.AQ(kbW);
    }

    public DetailInfoFragment cKR() {
        if (this.kbZ == null || !(this.kbZ.AQ(kbV) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.kbZ.AQ(kbV);
    }

    public boolean cDo() {
        PbModel cDy = this.jJW.cDy();
        if (cDy == null) {
            return false;
        }
        return cDy.cDo();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cCu;
        PbModel cDy = this.jJW.cDy();
        if (cDy != null && cDy.getPbData() != null && !cDy.getPbData().cCJ()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = cDy.getPbData().cCi().getId();
            if (cDy.isShareThread() && cDy.getPbData().cCi().dHm != null) {
                historyMessage.threadName = cDy.getPbData().cCi().dHm.showText;
            } else {
                historyMessage.threadName = cDy.getPbData().cCi().getTitle();
            }
            if (cDy.isShareThread() && !cDo()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = cDy.getPbData().getForum().getName();
            }
            ArrayList<PostData> cCk = cDy.getPbData().cCk();
            int cHF = cKQ() != null ? cKQ().cHF() : 0;
            if (cCk != null && cHF >= 0 && cHF < cCk.size()) {
                historyMessage.postID = cCk.get(cHF).getId();
            }
            historyMessage.isHostOnly = cDy.getHostMode();
            historyMessage.isSquence = cDy.cFv();
            historyMessage.isShareThread = cDy.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.jKM != null) {
            this.jKM.onDestroy();
        }
        if (cDy != null && (cDy.cFw() || cDy.cFy())) {
            Intent intent = new Intent();
            intent.putExtra("tid", cDy.cFt());
            if (this.jKA) {
                if (this.jKC) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", cDy.bOc());
                }
                if (this.jKB) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", cDy.getIsGood());
                }
            }
            if (cDy.getPbData() != null && System.currentTimeMillis() - this.jKd >= 40000 && (cCu = cDy.getPbData().cCu()) != null && !v.isEmpty(cCu.getDataList())) {
                intent.putExtra("guess_like_data", cCu);
            }
            PbActivity pbActivity = this.jJW;
            PbActivity pbActivity2 = this.jJW;
            pbActivity.setResult(-1, intent);
        }
        if (cEI()) {
            if (cDy != null) {
                com.baidu.tieba.pb.data.e pbData = cDy.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.jKj) {
                        if (this.kcc != null) {
                            Rect rect = new Rect();
                            this.kcc.getGlobalVisibleRect(rect);
                            ao.cGM().h(rect);
                        }
                        ao.cGM().Av(this.dLI.getCurrentItem());
                        BdTypeRecyclerView bXR = bXR();
                        Parcelable parcelable = null;
                        if (bXR != null) {
                            parcelable = bXR.onSaveInstanceState();
                        }
                        ao.cGM().a(cDy.cFD(), parcelable, cDy.cFv(), cDy.getHostMode(), false);
                    }
                }
            } else {
                ao.cGM().reset();
            }
            cDL();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.kcd != null && !this.kcd.bxC()) {
            if ((this.kcd.isFullScreen() && configuration.orientation == 1) || (!this.kcd.isFullScreen() && configuration.orientation == 2)) {
                this.kcd.sI(false);
            }
        }
    }

    public boolean cKS() {
        if (this.kcd == null) {
            return false;
        }
        return this.kcd.bxC();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.dct().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        public boolean kcJ;
        public boolean kcK;

        private a() {
            this.kcK = true;
        }

        public boolean cKZ() {
            return (this.kcJ && this.kcK) ? false : true;
        }
    }

    public void cKT() {
        this.jKr = -1;
        this.jKs = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEY() {
        if (cDy() != null && !aq.isEmpty(cDy().cFt())) {
            com.baidu.tbadk.BdToken.c.aLi().o(com.baidu.tbadk.BdToken.b.dtS, com.baidu.adp.lib.f.b.toLong(cDy().cFt(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.kcb.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKU() {
        if (this.kcA == null) {
            this.kcA = ObjectAnimator.ofFloat(this.kcf, "alpha", 0.0f, 1.0f);
            this.kcA.setDuration(200L);
        }
        this.kcA.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKV() {
        if (this.kcB == null) {
            this.kcB = ObjectAnimator.ofFloat(this.kcf, "alpha", 1.0f, 0.0f);
            this.kcB.setDuration(200L);
        }
        this.kcB.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKW() {
        return this.kcd != null && this.kcd.cKX();
    }

    public boolean cKX() {
        return this.kcx;
    }

    public void sA(boolean z) {
        this.kcx = z;
    }
}
