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
import com.baidu.tbadk.coreExtra.data.ab;
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
    private com.baidu.adp.lib.d.b<ImageView> eBC;
    private com.baidu.adp.lib.d.b<GifView> eBD;
    private com.baidu.adp.lib.d.b<TextView> eEq;
    private com.baidu.adp.lib.d.b<View> eEr;
    private com.baidu.adp.lib.d.b<LinearLayout> eEs;
    private com.baidu.adp.lib.d.b<RelativeLayout> eEt;
    public View eun;
    private ImageView fxw;
    private VoiceManager hns;
    private com.baidu.tieba.frs.profession.permission.c hra;
    private com.baidu.tieba.f.b hrv;
    public aj iQC;
    private com.baidu.tieba.pb.videopb.c.a jFM;
    private PbFakeFloorModel jKZ;
    public ax jLJ;
    private g jLR;
    private com.baidu.tbadk.editortools.pb.e jLS;
    private com.baidu.tieba.frs.profession.permission.c jLU;
    private EmotionImageData jLV;
    private com.baidu.tbadk.core.view.c jLZ;
    private PbActivity jLc;
    private com.baidu.tieba.pb.pb.main.emotion.model.a jLt;
    int jLw;
    private View jSE;
    private View jSV;
    private LinearLayout jSX;
    private HeadImageView jSY;
    private ImageView jSZ;
    private t jTE;
    private String jTV;
    private ImageView jTa;
    private ImageView jTb;
    private com.baidu.tieba.pb.view.c jTc;
    private TextView jTd;
    private TextView jTe;
    private int jTg;
    private int jTh;
    public View jYC;
    private float kdA;
    private float kdB;
    private boolean kdC;
    private ObjectAnimator kdG;
    private ObjectAnimator kdH;
    private NewPagerSlidingTabBaseStrip kde;
    private VideoPbFragmentAdapter kdf;
    private View kdg;
    private View kdh;
    private VideoContainerLayout kdi;
    private com.baidu.tieba.pb.videopb.videoView.a kdj;
    private f kdk;
    private View kdl;
    private View kdm;
    private TextView kdo;
    private TextView kdp;
    private ImageView kdq;
    private TBSpecificationBtn kdr;
    private TbImageView kds;
    private View kdt;
    private ValueAnimator kdu;
    private ValueAnimator kdv;
    public com.baidu.tieba.pb.videopb.b.a kdw;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int kdb = 0;
    public static int kdc = 1;
    public static int jTw = 3;
    public static int jTx = 0;
    public static int jTy = 3;
    public static int jTz = 4;
    public static int jTA = 5;
    public static int jTB = 6;
    private static final int igf = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int kdd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a jMQ = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void bZ(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cDC();
            } else {
                com.baidu.tieba.pb.a.b.cDB();
            }
        }
    };
    private long jLj = 0;
    View.OnClickListener kdn = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.jFM == null || VideoPbFragment.this.jFM.cLZ()) {
                if (VideoPbFragment.this.jFM != null) {
                    if (VideoPbFragment.this.jFM.isChushou) {
                        VideoPbFragment.this.dN(VideoPbFragment.this.jFM.thirdRoomId, VideoPbFragment.this.jFM.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.jFM.cMa();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null && VideoPbFragment.this.cDO().getPbData().getForum() != null) {
                        TiebaStatic.log(new an("c13713").dh("fid", VideoPbFragment.this.cDO().getPbData().getForum().getId()).dh("fname", VideoPbFragment.this.cDO().getPbData().getForum().getName()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", VideoPbFragment.this.cDO().getPbData().getThreadId()).s("obj_param1", VideoPbFragment.this.jFM.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new an("c13590").dh("obj_id", VideoPbFragment.this.jFM.getTitle()).dh("obj_name", VideoPbFragment.this.jFM.cLW()).ag("obj_type", 2).dh("fid", VideoPbFragment.this.cDO().getPbData().getForumId()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", VideoPbFragment.this.cDO().getPbData().getThreadId()));
            String link = VideoPbFragment.this.jFM.getLink();
            if (!TextUtils.isEmpty(link)) {
                if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                    ba.aVa().b(VideoPbFragment.this.getPageContext(), new String[]{link});
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
    private com.baidu.tbadk.baseEditMark.a jLD = null;
    private com.baidu.tbadk.coreExtra.model.a dNL = null;
    private ForumManageModel gFg = null;
    private boolean jLn = false;
    private View jSW = null;
    private TextView ihL = null;
    private boolean jSS = false;
    private String emL = null;
    private boolean jLG = false;
    private boolean jLH = false;
    private boolean jLI = false;
    private boolean jLp = false;
    int[] jLv = new int[2];
    private int jLx = -1;
    private int jLy = Integer.MIN_VALUE;
    private int jMf = 0;
    private int kdy = Integer.MIN_VALUE;
    private boolean beu = false;
    private final PbModel.a jMF = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g ne;
            VideoPbFragment.this.cHT();
            VideoPbFragment.this.cnQ();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.sa(false);
            if (z && eVar != null) {
                bk cCy = eVar.cCy();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).d(eVar, i2);
                VideoPbFragment.this.I(eVar);
                com.baidu.tieba.pb.videopb.c.a cDb = eVar.cDb();
                if (cDb != null && !cDb.kfj) {
                    VideoPbFragment.this.a(cDb);
                }
                VideoPbFragment.this.J(eVar);
                VideoPbFragment.this.c(z, i, i2, i3, eVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.jLD != null) {
                    VideoPbFragment.this.jLD.gC(eVar.aML());
                }
                AntiData anti = eVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.emL = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.emL) && VideoPbFragment.this.jLS != null && VideoPbFragment.this.jLS.bcX() != null && (ne = VideoPbFragment.this.jLS.bcX().ne(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.emL)) {
                        ((View) ne).setOnClickListener(VideoPbFragment.this.eny);
                    }
                }
                if (VideoPbFragment.this.iQC != null && cCy != null && cCy.aQx() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(cCy.aQx());
                    VideoPbFragment.this.iQC.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.cDO().cFJ());
                        jSONObject.put("fid", VideoPbFragment.this.cDO().getForumId());
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
                if (VideoPbFragment.this.cLg() != null) {
                    if (i != -1) {
                        ArrayList<PostData> arrayList = null;
                        if (VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null) {
                            arrayList = VideoPbFragment.this.cDO().getPbData().cCA();
                        }
                        if (v.getCount(arrayList) == 0 || (v.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).ddJ() == 1)) {
                            if (VideoPbFragment.this.cLg().cFm()) {
                                VideoPbFragment.this.cLg().JA(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                VideoPbFragment.this.cLg().JA(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            VideoPbFragment.this.cLg().Jz(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                        }
                    } else {
                        VideoPbFragment.this.cLg().Jz("");
                    }
                    VideoPbFragment.this.cLg().endLoadData();
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.dcI().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0471a jMH = new a.InterfaceC0471a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0471a
        public void c(boolean z, boolean z2, String str) {
            VideoPbFragment.this.cHT();
            if (z && VideoPbFragment.this.cDO() != null) {
                if (VideoPbFragment.this.jLD != null) {
                    VideoPbFragment.this.jLD.gC(z2);
                }
                VideoPbFragment.this.cDO().rG(z2);
                if (VideoPbFragment.this.cDO().aML()) {
                    VideoPbFragment.this.cEX();
                } else if (VideoPbFragment.this.cLg() != null) {
                    VideoPbFragment.this.cLg().cLR();
                }
                if (z2) {
                    if (VideoPbFragment.this.jLD != null) {
                        if (VideoPbFragment.this.jLD.aMO() != null && VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null && VideoPbFragment.this.cDO().getPbData().cCy() != null && VideoPbFragment.this.cDO().getPbData().cCy().aQx() != null) {
                            MarkData aMO = VideoPbFragment.this.jLD.aMO();
                            MetaData aQx = VideoPbFragment.this.cDO().getPbData().cCy().aQx();
                            if (aMO != null && aQx != null) {
                                if (!aq.equals(TbadkCoreApplication.getCurrentAccount(), aQx.getUserId()) && !aQx.hadConcerned()) {
                                    VideoPbFragment.this.kdw.b(aQx);
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
                    VideoPbFragment.this.cEU();
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
        public boolean bdu() {
            if (VideoPbFragment.this.jLJ == null || VideoPbFragment.this.jLJ.cIJ() == null || !VideoPbFragment.this.jLJ.cIJ().dmx()) {
                return !VideoPbFragment.this.Ah(aj.dNG);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.jLJ.cIJ().dmz());
            if (VideoPbFragment.this.jLS != null && (VideoPbFragment.this.jLS.bdK() || VideoPbFragment.this.jLS.bdL())) {
                VideoPbFragment.this.jLS.a(false, VideoPbFragment.this.jLJ.cIM());
            }
            VideoPbFragment.this.jLJ.sf(true);
            return true;
        }
    };
    private final CustomMessageListener jMm = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.cDO() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.jLS != null) {
                    VideoPbFragment.this.rY(VideoPbFragment.this.jLS.bdD());
                }
                VideoPbFragment.this.cHw();
                VideoPbFragment.this.kdw.cIk();
            }
        }
    };
    private CustomMessageListener jMp = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
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
    private final CustomMessageListener hoG = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.beu) {
                VideoPbFragment.this.cFo();
            }
        }
    };
    private CustomMessageListener jMG = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.cEO();
            }
        }
    };
    private CustomMessageListener jMA = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.kdw != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kdw.jMa) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.kdw.bGh();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.kdw.getExtra();
                DataRes dataRes = aVar.lAC;
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
                    VideoPbFragment.this.kdw.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.kdw.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener jMy = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.kdw != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kdw.jMa) {
                VideoPbFragment.this.kdw.bGh();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.cDO().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cCO().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.jLZ.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.kdw.yo(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.kdw.cFl();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.jLZ.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener jMz = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.kdw != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.kdw.jMa) {
                VideoPbFragment.this.kdw.bGh();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.jLZ.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.jLZ.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b jLX = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bdu() {
            if (VideoPbFragment.this.jLJ == null || VideoPbFragment.this.jLJ.cIK() == null || !VideoPbFragment.this.jLJ.cIK().dmx()) {
                return !VideoPbFragment.this.Ah(aj.dNH);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.jLJ.cIK().dmz());
            if (VideoPbFragment.this.jTE != null && VideoPbFragment.this.jTE.cEy() != null && VideoPbFragment.this.jTE.cEy().bdL()) {
                VideoPbFragment.this.jTE.cEy().a(VideoPbFragment.this.jLJ.cIM());
            }
            VideoPbFragment.this.jLJ.sg(true);
            return true;
        }
    };
    private final NewWriteModel.d emV = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ab abVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null) {
                    anVar.dh("fid", VideoPbFragment.this.cDO().getPbData().getForumId());
                }
                anVar.dh("tid", VideoPbFragment.this.cDO().cFJ());
                anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            VideoPbFragment.this.bVp();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.cDO() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.cDO().Ju(postWriteCallBackData.getPostId());
                    if (VideoPbFragment.this.cLg() != null) {
                        VideoPbFragment.this.jMf = VideoPbFragment.this.cLg().cHV();
                        VideoPbFragment.this.kdy = VideoPbFragment.this.cLg().cLU();
                        VideoPbFragment.this.cDO().cD(VideoPbFragment.this.jMf, VideoPbFragment.this.kdy);
                    }
                }
                if (VideoPbFragment.this.dLI != null) {
                    VideoPbFragment.this.dLI.setCurrentItem(VideoPbFragment.kdc);
                }
                VideoPbFragment.this.kdw.cIk();
                VideoPbFragment.this.jLJ.cII();
                if (VideoPbFragment.this.jLS != null) {
                    VideoPbFragment.this.rY(VideoPbFragment.this.jLS.bdD());
                }
                VideoPbFragment.this.cHs();
                VideoPbFragment.this.sa(true);
                VideoPbFragment.this.cDO().cGe();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && VideoPbFragment.this.cLg() != null) {
                            VideoPbFragment.this.cLg().cLR();
                        }
                    } else if (VideoPbFragment.this.cDO().getHostMode()) {
                        com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.cDO().getPbData();
                        if (pbData != null && pbData.cCy() != null && pbData.cCy().aQx() != null && (userId = pbData.cCy().aQx().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.cDO().cFV()) {
                            VideoPbFragment.this.cHR();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.cDO().cFV()) {
                        VideoPbFragment.this.cHR();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.rt(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.jLS.bdK() || VideoPbFragment.this.jLS.bdL()) {
                    VideoPbFragment.this.jLS.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.jLJ.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.iQC != null) {
                    VideoPbFragment.this.iQC.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (abVar == null && i != 227001) {
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
    private CustomMessageListener jMo = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.jLS != null) {
                    VideoPbFragment.this.rY(VideoPbFragment.this.jLS.bdD());
                }
                VideoPbFragment.this.sa(false);
            }
        }
    };
    private int kdz = 0;
    private boolean kdD = true;
    private View.OnTouchListener kdE = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.kdz == 1) {
                if (!VideoPbFragment.this.kdD) {
                    VideoPbFragment.this.cLk();
                    UtilHelper.showStatusBar(VideoPbFragment.this.cFs(), VideoPbFragment.this.cFs().getRootView());
                    VideoPbFragment.this.kdD = true;
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(VideoPbFragment.this.kdF);
                    com.baidu.adp.lib.f.e.ld().postDelayed(VideoPbFragment.this.kdF, 3000L);
                }
            } else if (VideoPbFragment.this.kdz == 2 && (VideoPbFragment.this.kdD || VideoPbFragment.this.cLm())) {
                VideoPbFragment.this.cLl();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cFs(), VideoPbFragment.this.cFs().getRootView());
                VideoPbFragment.this.kdD = false;
                if (VideoPbFragment.this.kdj != null) {
                    VideoPbFragment.this.kdj.sA(false);
                }
            }
            VideoPbFragment.this.kdz = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener hxO = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.kdz = 0;
            VideoPbFragment.this.kdA = 0.0f;
            VideoPbFragment.this.kdB = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.kdA += f;
            VideoPbFragment.this.kdB += f2;
            if (VideoPbFragment.this.kdz == 0 && !VideoPbFragment.this.kdC && VideoPbFragment.this.kdj != null && !VideoPbFragment.this.kdj.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.kdB) <= Math.abs(VideoPbFragment.this.kdA) || VideoPbFragment.this.kdB > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.kdB) > Math.abs(VideoPbFragment.this.kdA) && VideoPbFragment.this.kdB > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.kdz = 2;
                    }
                } else {
                    VideoPbFragment.this.kdz = 1;
                }
            }
            return true;
        }
    };
    private Runnable kdF = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.kdD && !VideoPbFragment.this.cLm()) {
                VideoPbFragment.this.cLl();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cFs(), VideoPbFragment.this.cFs().getRootView());
                VideoPbFragment.this.kdD = false;
            }
        }
    };
    private final com.baidu.adp.base.d gFl = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.cDO() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.gFg.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.gFg.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.cDO().cGe();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.kaw != 1002 || bVar.fEQ) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.OU, dVar.loP, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.gFg.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.gFg.getLoadDataMode(), gVar.OU, gVar.loP, false);
                    VideoPbFragment.this.kdw.aP(gVar.loS);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener evw = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.hrv.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d jMD = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ab abVar, WriteData writeData, AntiData antiData) {
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null) {
                    anVar.dh("fid", VideoPbFragment.this.cDO().getPbData().getForumId());
                }
                if (VideoPbFragment.this.cDO() != null) {
                    anVar.dh("tid", VideoPbFragment.this.cDO().cFJ());
                }
                anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (VideoPbFragment.this.jLJ != null) {
                    VideoPbFragment.this.jLJ.cIH();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.iQC != null) {
                    VideoPbFragment.this.iQC.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.jLJ != null) {
                if (VideoPbFragment.this.jTE != null && VideoPbFragment.this.jTE.cEy() != null && VideoPbFragment.this.jTE.cEy().bdL()) {
                    VideoPbFragment.this.jTE.cEy().a(postWriteCallBackData);
                }
                VideoPbFragment.this.jLJ.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c emO = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bdv() {
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
                    anVar.dh("tid", VideoPbFragment.this.cDO().cFJ());
                    anVar.dh("fid", VideoPbFragment.this.cDO().getForumId());
                    anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.ag("obj_locate", 1);
                    TiebaStatic.log(anVar);
                    if (VideoPbFragment.this.jLn) {
                        VideoPbFragment.this.jLn = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null && VideoPbFragment.this.jKZ != null && postData.aQx() != null && postData.ddJ() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.jTE != null) {
                                    VideoPbFragment.this.jTE.cEu();
                                }
                                n nVar = new n();
                                nVar.a(VideoPbFragment.this.cDO().getPbData().getForum());
                                nVar.setThreadData(VideoPbFragment.this.cDO().getPbData().cCy());
                                nVar.g(postData);
                                VideoPbFragment.this.jKZ.d(nVar);
                                VideoPbFragment.this.jKZ.setPostId(postData.getId());
                                VideoPbFragment.this.b(view, postData.aQx().getUserId(), "");
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.cDO().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.jLS != null) {
                                    VideoPbFragment.this.rY(VideoPbFragment.this.jLS.bdD());
                                }
                            }
                        }
                    }
                } else if (VideoPbFragment.this.cLg() != null && VideoPbFragment.this.cLg().cIg() != null && view == VideoPbFragment.this.cLg().cIg()) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.cDO().rE(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        VideoPbFragment.this.cLg().cHS();
                    }
                } else if (VideoPbFragment.this.kdw != null && VideoPbFragment.this.kdw.cJp() != null && view == VideoPbFragment.this.kdw.cJp().cGS()) {
                    VideoPbFragment.this.kdw.aEa();
                } else if (VideoPbFragment.this.kdw != null && ((VideoPbFragment.this.kdw.cJp() != null && view == VideoPbFragment.this.kdw.cJp().cGT()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.kdw.cIk();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.bVp();
                        VideoPbFragment.this.cHR();
                        if (view.getId() == R.id.owner_reply) {
                            w = VideoPbFragment.this.cDO().w(true, VideoPbFragment.this.cFb());
                        } else {
                            w = view.getId() == R.id.all_reply ? VideoPbFragment.this.cDO().w(false, VideoPbFragment.this.cFb()) : VideoPbFragment.this.cDO().Jr(VideoPbFragment.this.cFb());
                        }
                        view.setTag(Boolean.valueOf(w));
                        if (w) {
                            VideoPbFragment.this.cnR();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.eun) {
                    if (VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null) {
                        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            an anVar2 = new an("c13266");
                            anVar2.dh("uid", TbadkCoreApplication.getCurrentAccount());
                            anVar2.dh("fid", VideoPbFragment.this.cDO().getPbData().getForumId());
                            anVar2.dh("tid", VideoPbFragment.this.cDO().cFJ());
                            anVar2.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(anVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.jLc, VideoPbFragment.this.eun);
                        VideoPbFragment.this.jLc.finish();
                    }
                } else if (view == VideoPbFragment.this.jYC && VideoPbFragment.this.kdw != null) {
                    if (VideoPbFragment.this.cDO() == null || VideoPbFragment.this.cDO().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> cCA = VideoPbFragment.this.cDO().getPbData().cCA();
                    if ((cCA == null || cCA.size() <= 0) && VideoPbFragment.this.cDO().cFL()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new an("c12378").dh("tid", VideoPbFragment.this.cDO().cFJ()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("fid", VideoPbFragment.this.cDO().getForumId()));
                    VideoPbFragment.this.kdw.cEP();
                } else if (VideoPbFragment.this.kdw.cJp() != null && view == VideoPbFragment.this.kdw.cJp().cGX()) {
                    if (VideoPbFragment.this.cDO() != null) {
                        VideoPbFragment.this.kdw.cIk();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.bVp();
                            VideoPbFragment.this.cHR();
                            VideoPbFragment.this.cDO().An(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.kdw != null && VideoPbFragment.this.kdw.cJp() != null && view == VideoPbFragment.this.kdw.cJp().cGT()) {
                    VideoPbFragment.this.kdw.aEa();
                } else if (VideoPbFragment.this.kdw != null && ((VideoPbFragment.this.kdw.cJp() != null && view == VideoPbFragment.this.kdw.cJp().cGZ()) || view.getId() == R.id.pb_sort_type)) {
                    VideoPbFragment.this.kdw.cIk();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.bVp();
                            VideoPbFragment.this.cHR();
                            VideoPbFragment.this.kdw.cP(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.cDO().cGc()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.kdw != null && VideoPbFragment.this.kdw.cJp() != null && view == VideoPbFragment.this.kdw.cJp().cGR()) {
                    if (VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null && VideoPbFragment.this.cDO().getPbData().cCy() != null) {
                        VideoPbFragment.this.kdw.aEa();
                        TiebaStatic.log(new an("c13062"));
                        VideoPbFragment.this.kdw.Jm(VideoPbFragment.this.cDO().getPbData().cCy().aQP());
                    }
                } else if (VideoPbFragment.this.kdw != null && VideoPbFragment.this.kdw.cJp() != null && view == VideoPbFragment.this.kdw.cJp().cHa()) {
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
                    VideoPbFragment.this.kdw.cJo();
                } else if (VideoPbFragment.this.kdw != null && (view == VideoPbFragment.this.kdw.cHP() || (VideoPbFragment.this.kdw.cJp() != null && (view == VideoPbFragment.this.kdw.cJp().cGW() || view == VideoPbFragment.this.kdw.cJp().cGU())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.cDO() != null || VideoPbFragment.this.cDO().getPbData() != null) {
                        if ((VideoPbFragment.this.cDO().getPbData().cCN() == 1 || VideoPbFragment.this.cDO().getPbData().cCN() == 3) && !VideoPbFragment.this.gFg.dez()) {
                            VideoPbFragment.this.kdw.cIk();
                            if (VideoPbFragment.this.kdw.cJp() != null && view == VideoPbFragment.this.kdw.cJp().cGU()) {
                                if (VideoPbFragment.this.cDO().getPbData().cCy().aQs() == 1) {
                                    i = 5;
                                } else {
                                    i = 4;
                                }
                            } else if (VideoPbFragment.this.kdw.cJp() != null && view == VideoPbFragment.this.kdw.cJp().cGW()) {
                                i = VideoPbFragment.this.cDO().getPbData().cCy().aQt() == 1 ? 3 : 6;
                            } else {
                                i = view == VideoPbFragment.this.kdw.cHP() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.cDO().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.cDO().getPbData().cCy().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.gFg.b(id, name, id2, i, VideoPbFragment.this.kdw.cHQ());
                        }
                    }
                } else if (VideoPbFragment.this.kdw != null && VideoPbFragment.this.kdw.cJp() != null && view == VideoPbFragment.this.kdw.cJp().cGY()) {
                    if (VideoPbFragment.this.cDO() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.kdw.cIk();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.cDO().getPbData(), VideoPbFragment.this.cDO().cFL(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.cDO().getPbData().getForum().getId(), VideoPbFragment.this.cDO().getPbData().getForum().getName(), VideoPbFragment.this.cDO().getPbData().cCy().getId(), String.valueOf(VideoPbFragment.this.cDO().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.kdw != null && VideoPbFragment.this.kdw.cJp() != null && view == VideoPbFragment.this.kdw.cJp().cGV()) {
                    if (VideoPbFragment.this.cDO() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.cDO().getPbData(), VideoPbFragment.this.cDO().cFL(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.kdw.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.kdw.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.kdw.aEa();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        an anVar3 = new an("c13398");
                        anVar3.dh("tid", VideoPbFragment.this.cDO().cFJ());
                        anVar3.dh("fid", VideoPbFragment.this.cDO().getForumId());
                        anVar3.dh("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar3.ag("obj_locate", 4);
                        TiebaStatic.log(anVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new an("c10517").ag("obj_locate", 3).dh("fid", VideoPbFragment.this.cDO().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null) {
                        if (VideoPbFragment.this.kdw != null) {
                            VideoPbFragment.this.kdw.cIk();
                        }
                        PostData postData2 = (PostData) ((SparseArray) view.getTag()).get(R.id.tag_load_sub_data);
                        if (postData2 != null) {
                            if (postData2.ddV() == 1) {
                                TiebaStatic.log(new an("c12630"));
                            }
                            if (postData2.lmQ != null) {
                                an aUS = postData2.lmQ.aUS();
                                aUS.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    aUS.ag("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    aUS.ag("obj_locate", 8);
                                }
                                TiebaStatic.log(aUS);
                            }
                            String cFJ = VideoPbFragment.this.cDO().cFJ();
                            String id3 = postData2.getId();
                            int cCN = VideoPbFragment.this.cDO().getPbData() != null ? VideoPbFragment.this.cDO().getPbData().cCN() : 0;
                            VideoPbFragment.this.bVp();
                            TiebaStatic.log("c11742");
                            if (VideoPbFragment.this.cLg() != null && VideoPbFragment.this.cLg().cLT() != null) {
                                PbActivity.a Jp = VideoPbFragment.this.cLg().cLT().Jp(id3);
                                if (postData2 != null && VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null && Jp != null) {
                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cFJ, id3, "pb", true, null, false, null, cCN, postData2.cKn(), VideoPbFragment.this.cDO().getPbData().getAnti(), false, postData2.aQx().getIconInfo()).addBigImageData(Jp.jId, Jp.jIe, Jp.jIf, Jp.index);
                                    addBigImageData.setKeyFromForumId(VideoPbFragment.this.cDO().getForumId());
                                    addBigImageData.setBjhData(VideoPbFragment.this.cDO().cFS());
                                    addBigImageData.setKeyPageStartFrom(VideoPbFragment.this.cDO().cGt());
                                    addBigImageData.setFromFrsForumId(VideoPbFragment.this.cDO().getFromForumId());
                                    VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img) {
                    if (VideoPbFragment.this.cDO() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            an anVar4 = new an("c13398");
                            anVar4.dh("tid", VideoPbFragment.this.cDO().cFJ());
                            anVar4.dh("fid", VideoPbFragment.this.cDO().getForumId());
                            anVar4.dh("uid", TbadkCoreApplication.getCurrentAccount());
                            anVar4.ag("obj_locate", 6);
                            TiebaStatic.log(anVar4);
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData3 = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData3.lmQ != null) {
                                    an aUS2 = postData3.lmQ.aUS();
                                    aUS2.delete("obj_locate");
                                    aUS2.ag("obj_locate", 8);
                                    TiebaStatic.log(aUS2);
                                } else if (view.getId() == R.id.post_info_commont_img) {
                                    TiebaStatic.log(new an("c13700").dh("tid", VideoPbFragment.this.cDO().cFK()).dh("fid", VideoPbFragment.this.cDO().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dh("post_id", postData3.getId()).ag("obj_type", 3));
                                }
                                if (VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null && VideoPbFragment.this.jKZ != null && postData3.aQx() != null && postData3.ddJ() != 1) {
                                    if (VideoPbFragment.this.jTE != null) {
                                        VideoPbFragment.this.jTE.cEu();
                                    }
                                    n nVar2 = new n();
                                    nVar2.a(VideoPbFragment.this.cDO().getPbData().getForum());
                                    nVar2.setThreadData(VideoPbFragment.this.cDO().getPbData().cCy());
                                    nVar2.g(postData3);
                                    VideoPbFragment.this.jKZ.d(nVar2);
                                    VideoPbFragment.this.jKZ.setPostId(postData3.getId());
                                    VideoPbFragment.this.b(view, postData3.aQx().getUserId(), "");
                                    if (VideoPbFragment.this.jLS != null) {
                                        VideoPbFragment.this.rY(VideoPbFragment.this.jLS.bdD());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.kdw != null && VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cLg() != null) {
                        VideoPbFragment.this.kdw.cIk();
                        if (VideoPbFragment.this.Ai(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.cDO() != null) {
                            VideoPbFragment.this.cEW();
                            if (VideoPbFragment.this.cDO().getPbData() != null && VideoPbFragment.this.cDO().getPbData().cCy() != null && VideoPbFragment.this.cDO().getPbData().cCy().aQx() != null) {
                                TiebaStatic.log(new an("c13402").dh("tid", VideoPbFragment.this.cDO().cFJ()).dh("fid", VideoPbFragment.this.cDO().getPbData().getForumId()).ag("obj_locate", 3).dh("uid", VideoPbFragment.this.cDO().getPbData().cCy().aQx().getUserId()));
                            }
                            if (VideoPbFragment.this.cDO().getPbData().cCy() != null && VideoPbFragment.this.cDO().getPbData().cCy().aQx() != null && VideoPbFragment.this.cDO().getPbData().cCy().aQx().getUserId() != null && VideoPbFragment.this.jLD != null) {
                                int h = VideoPbFragment.this.kdw.h(VideoPbFragment.this.cDO().getPbData());
                                bk cCy = VideoPbFragment.this.cDO().getPbData().cCy();
                                if (cCy.aPm()) {
                                    i2 = 2;
                                } else if (!cCy.aPn()) {
                                    if (cCy.aSv()) {
                                        i2 = 4;
                                    } else {
                                        i2 = cCy.aSw() ? 5 : 1;
                                    }
                                }
                                TiebaStatic.log(new an("c12526").dh("tid", VideoPbFragment.this.cDO().cFJ()).ag("obj_locate", 1).dh("obj_id", VideoPbFragment.this.cDO().getPbData().cCy().aQx().getUserId()).ag("obj_type", VideoPbFragment.this.jLD.aML() ? 0 : 1).ag("obj_source", h).ag("obj_param1", i2));
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.sy(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.cDO() != null && VideoPbFragment.this.kdw != null && VideoPbFragment.this.dLI != null && VideoPbFragment.this.cDO().getPbData() != null && VideoPbFragment.this.cDO().getPbData().cCy() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.cDO().getPbData();
                        if (pbData.cCy().aQo() != 0) {
                            int currentItem = VideoPbFragment.this.dLI.getCurrentItem();
                            if (currentItem == VideoPbFragment.kdb) {
                                VideoPbFragment.this.dLI.setCurrentItem(VideoPbFragment.kdc);
                            } else if (currentItem == VideoPbFragment.kdc) {
                                if (VideoPbFragment.this.cLg() != null && VideoPbFragment.this.bXU() != null) {
                                    an dh = new an("c13403").dh("tid", VideoPbFragment.this.cDO().cFJ()).dh("fid", VideoPbFragment.this.cDO().getPbData().getForumId()).dh("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView bXU = VideoPbFragment.this.bXU();
                                    boolean canScrollVertically = bXU.canScrollVertically(1);
                                    boolean canScrollVertically2 = bXU.canScrollVertically(-1);
                                    if (VideoPbFragment.this.Wr != null) {
                                        VideoPbFragment.this.Wr.setExpanded(false, true);
                                    }
                                    if (bXU.getLayoutManager() != null && (bXU.getLayoutManager() instanceof LinearLayoutManager)) {
                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) bXU.getLayoutManager();
                                        if (!canScrollVertically2 && canScrollVertically) {
                                            if (VideoPbFragment.this.jLx != -1 || VideoPbFragment.this.jLy != Integer.MIN_VALUE) {
                                                if (VideoPbFragment.this.jLx > 3 || (VideoPbFragment.this.jLx == 3 && VideoPbFragment.this.jLy < (-equipmentHeight))) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.jLx, VideoPbFragment.this.jLy + equipmentHeight);
                                                    bXU.smoothScrollBy(0, equipmentHeight);
                                                } else if (VideoPbFragment.this.jLx >= 2) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.jLx, VideoPbFragment.this.jLy + (equipmentHeight / 2));
                                                    bXU.smoothScrollBy(0, equipmentHeight / 2);
                                                } else if (VideoPbFragment.this.jLx == 1) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.jLx, VideoPbFragment.this.jLy + (equipmentHeight / 4));
                                                    bXU.smoothScrollBy(0, equipmentHeight / 4);
                                                } else {
                                                    bXU.smoothScrollBy(0, -VideoPbFragment.this.jLy);
                                                }
                                                dh.ag("obj_locate", 2);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            int firstVisiblePosition = bXU.getFirstVisiblePosition();
                                            View childAt = bXU.getChildAt(0);
                                            int top2 = childAt == null ? 0 : childAt.getTop();
                                            VideoPbFragment.this.jLx = firstVisiblePosition;
                                            VideoPbFragment.this.jLy = top2;
                                            if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top2 < (-equipmentHeight) && bXU.getCount() >= 6)) {
                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                bXU.smoothScrollToPosition(0);
                                            } else {
                                                bXU.smoothScrollToPosition(0);
                                            }
                                            dh.ag("obj_locate", 1);
                                        }
                                        TiebaStatic.log(dh);
                                        TiebaStatic.log(new an("c12942").ag("obj_type", 1).ag("obj_locate", 4).dh("tid", VideoPbFragment.this.cDO().cFJ()).dh("nid", pbData.cCy().getNid()));
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null && VideoPbFragment.this.cDO().getPbData().cCy() != null && VideoPbFragment.this.cDO().getPbData().cCy().aQx() != null) {
                                TiebaStatic.log(new an("c13402").dh("tid", VideoPbFragment.this.cDO().cFJ()).dh("fid", VideoPbFragment.this.cDO().getPbData().getForumId()).ag("obj_locate", 2).dh("uid", VideoPbFragment.this.cDO().getPbData().cCy().aQx().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.sz(false);
                        VideoPbFragment.this.cEK();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.jMf >= 0) {
                        if (VideoPbFragment.this.cDO() != null) {
                            VideoPbFragment.this.cDO().cGu();
                        }
                        if (VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cLg() != null && VideoPbFragment.this.cLg().cLS() != null) {
                            VideoPbFragment.this.cLg().cLS().setData(VideoPbFragment.this.cDO().getPbData());
                        }
                        VideoPbFragment.this.jMf = 0;
                        VideoPbFragment.this.kdy = Integer.MIN_VALUE;
                        if (VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cLg() != null) {
                            VideoPbFragment.this.cLg().cG(VideoPbFragment.this.cDO().cGx(), VideoPbFragment.this.cDO().cGy());
                            VideoPbFragment.this.cDO().cD(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.cDO() != null) {
                        an anVar5 = new an("c13398");
                        anVar5.dh("tid", VideoPbFragment.this.cDO().cFJ());
                        anVar5.dh("fid", VideoPbFragment.this.cDO().getForumId());
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
                        VideoPbFragment.this.cHw();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.cHw();
                }
            }
        }
    };
    private View.OnClickListener jIK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.kdw != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.kdw.c(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.kdw.cI(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.kdw.c(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.kdw.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    public SortSwitchButton.a jMC = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean uv(int i) {
            if (VideoPbFragment.this.kdw != null) {
                VideoPbFragment.this.kdw.cIk();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.cDO() == null || VideoPbFragment.this.cDO().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.bVp();
                VideoPbFragment.this.cHR();
                if (VideoPbFragment.this.cDO().getPbData() != null && VideoPbFragment.this.cDO().getPbData().jFb != null && VideoPbFragment.this.cDO().getPbData().jFb.size() > i) {
                    int intValue = VideoPbFragment.this.cDO().getPbData().jFb.get(i).sort_type.intValue();
                    TiebaStatic.log(new an("c13699").dh("tid", VideoPbFragment.this.cDO().cFK()).dh("fid", VideoPbFragment.this.cDO().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", Ak(intValue)));
                    if (VideoPbFragment.this.cDO().As(intValue)) {
                        VideoPbFragment.this.mIsLoading = true;
                    }
                }
                return true;
            }
        }

        private int Ak(int i) {
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
    private a kdx = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void cEU() {
        if (cDO() != null && cDO().getPbData() != null && cDO().getPbData().cCy() != null) {
            bk cCy = cDO().getPbData().cCy();
            cCy.mRecomAbTag = cDO().cGE();
            cCy.mRecomWeight = cDO().cGC();
            cCy.mRecomSource = cDO().cGD();
            cCy.mRecomExtra = cDO().cGF();
            if (cCy.getFid() == 0) {
                cCy.setFid(com.baidu.adp.lib.f.b.toLong(cDO().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cCy, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt(boolean z) {
        if (cDO() != null && cDO().getPbData() != null && cDO().getPbData().cCy() != null) {
            bk cCy = cDO().getPbData().cCy();
            cCy.mRecomAbTag = cDO().cGE();
            cCy.mRecomWeight = cDO().cGC();
            cCy.mRecomSource = cDO().cGD();
            cCy.mRecomExtra = cDO().cGF();
            if (cCy.getFid() == 0) {
                cCy.setFid(com.baidu.adp.lib.f.b.toLong(cDO().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cCy, "c13563");
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
            String string = !TextUtils.isEmpty(bVar.loP) ? bVar.loP : getString(R.string.delete_fail);
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
                a(0, bVar.OU, bVar.loP, z);
            }
            if (bVar.OU) {
                if (bVar.gUw == 1) {
                    ArrayList<PostData> cCA = cDO().getPbData().cCA();
                    int size = cCA.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cCA.get(i).getId())) {
                            i++;
                        } else {
                            cCA.remove(i);
                            break;
                        }
                    }
                    cDO().getPbData().cCy().ks(cDO().getPbData().cCy().aQo() - 1);
                    if (cLg() != null) {
                        cLg().cLR();
                    }
                } else if (bVar.gUw == 0) {
                    cEV();
                } else if (bVar.gUw == 2) {
                    ArrayList<PostData> cCA2 = cDO().getPbData().cCA();
                    int size2 = cCA2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cCA2.get(i2).ddG().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cCA2.get(i2).ddG().get(i3).getId())) {
                                i3++;
                            } else {
                                cCA2.get(i2).ddG().remove(i3);
                                cCA2.get(i2).ddI();
                                z2 = true;
                                break;
                            }
                        }
                        cCA2.get(i2).MC(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3 && cLg() != null) {
                        cLg().cLR();
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = cDO().getPbData().cCM().jGE;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).ddG().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).ddG().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).ddG().remove(i2);
                    list.get(i).ddI();
                    z = true;
                    break;
                }
            }
            list.get(i).MC(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2 && cLg() != null) {
            cLg().cLR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && cDO() != null && cDO().getPbData() != null && cDO().getPbData().cCy() != null) {
            a(this.gFg.getLoadDataMode(), gVar.OU, gVar.loP, false);
            if (gVar.OU) {
                this.jLG = true;
                if (i == 2 || i == 3) {
                    this.jLH = true;
                    this.jLI = false;
                } else if (i == 4 || i == 5) {
                    this.jLH = false;
                    this.jLI = true;
                }
                if (i == 2) {
                    cDO().getPbData().cCy().kv(1);
                    cDO().setIsGood(1);
                } else if (i == 3) {
                    cDO().getPbData().cCy().kv(0);
                    cDO().setIsGood(0);
                } else if (i == 4) {
                    cDO().getPbData().cCy().ku(1);
                    cDO().Am(1);
                } else if (i == 5) {
                    cDO().getPbData().cCy().ku(0);
                    cDO().Am(0);
                }
            }
            if (cDO().getPbData().cCy() != null && cLh() != null) {
                cLh().cLO();
            }
        }
    }

    private void cEV() {
        if (cDO().cFM() || cDO().cFO()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", cDO().cFJ());
            PbActivity pbActivity = this.jLc;
            PbActivity pbActivity2 = this.jLc;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, cDO().cFJ()));
        if (cEY()) {
            this.jLc.finish();
        }
    }

    private boolean cEY() {
        if (cDO() == null) {
            return true;
        }
        if (cDO().getPbData() == null || !cDO().getPbData().cCZ()) {
            if (cDO().aML()) {
                final MarkData cGd = cDO().cGd();
                if (cGd == null || !cDO().getIsFromMark() || bXU() == null) {
                    return true;
                }
                final MarkData At = cDO().At(bXU().getFirstVisiblePosition());
                if (At == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cGd);
                    this.jLc.setResult(-1, intent);
                    return true;
                } else if (At.getPostId() == null || At.getPostId().equals(cGd.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cGd);
                    this.jLc.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.vO(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.jLD != null) {
                                if (VideoPbFragment.this.jLD.aML()) {
                                    VideoPbFragment.this.jLD.aMM();
                                    VideoPbFragment.this.jLD.gC(false);
                                }
                                VideoPbFragment.this.jLD.a(At);
                                VideoPbFragment.this.jLD.gC(true);
                                VideoPbFragment.this.jLD.aMN();
                            }
                            cGd.setPostId(At.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cGd);
                            VideoPbFragment.this.jLc.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cEb();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cGd);
                            VideoPbFragment.this.jLc.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cEb();
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
            } else if (cDO().getPbData() == null || cDO().getPbData().cCA() == null || cDO().getPbData().cCA().size() <= 0 || !cDO().getIsFromMark()) {
                return true;
            } else {
                this.jLc.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEb() {
        this.jLc.cEb();
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
        if (cDO() != null && this.kdw != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = cDO().getPbData()) != null) {
                bk cCy = pbData.cCy();
                if (cCy != null && cCy.aQx() != null) {
                    TiebaStatic.log(new an("c13402").dh("tid", cDO().cFJ()).dh("fid", pbData.getForumId()).ag("obj_locate", 4).dh("uid", cCy.aQx().getUserId()));
                }
                if (cCy != null) {
                    if (cCy.aPm()) {
                        i = 2;
                    } else if (cCy.aPn()) {
                        i = 3;
                    } else if (cCy.aSv()) {
                        i = 4;
                    } else if (cCy.aSw()) {
                        i = 5;
                    }
                    an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    anVar.dh("tid", cDO().cFJ());
                    anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.dh("fid", cDO().getForumId());
                    if (!z) {
                        anVar.ag("obj_locate", 6);
                    } else {
                        anVar.ag("obj_locate", 5);
                    }
                    anVar.ag("obj_name", i);
                    anVar.ag("obj_type", 2);
                    if (cCy != null) {
                        if (cCy.aPm()) {
                            anVar.ag("obj_type", 10);
                        } else if (cCy.aPn()) {
                            anVar.ag("obj_type", 9);
                        } else if (cCy.aSw()) {
                            anVar.ag("obj_type", 8);
                        } else if (cCy.aSv()) {
                            anVar.ag("obj_type", 7);
                        } else if (cCy.isShareThread) {
                            anVar.ag("obj_type", 6);
                        } else if (cCy.threadType == 0) {
                            anVar.ag("obj_type", 1);
                        } else if (cCy.threadType == 40) {
                            anVar.ag("obj_type", 2);
                        } else if (cCy.threadType == 49) {
                            anVar.ag("obj_type", 3);
                        } else if (cCy.threadType == 54) {
                            anVar.ag("obj_type", 4);
                        } else {
                            anVar.ag("obj_type", 5);
                        }
                        anVar.dh("nid", cCy.getNid());
                        anVar.ag(IntentConfig.CARD_TYPE, cCy.aSA());
                        anVar.dh(IntentConfig.RECOM_SOURCE, cCy.mRecomSource);
                        anVar.dh("ab_tag", cCy.mRecomAbTag);
                        anVar.dh("weight", cCy.mRecomWeight);
                        anVar.dh("extra", cCy.mRecomExtra);
                        anVar.dh("nid", cCy.getNid());
                        if (cCy.getBaijiahaoData() != null && !aq.isEmpty(cCy.getBaijiahaoData().oriUgcVid)) {
                            anVar.dh("obj_param6", cCy.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (cFs() != null) {
                        com.baidu.tbadk.pageInfo.c.b(cFs(), anVar);
                    }
                    TiebaStatic.log(anVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (cDO().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> cCA = pbData.cCA();
                        if ((cCA == null || cCA.size() <= 0) && cDO().cFL()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.kdw.cIk();
                        bVp();
                        TiebaStatic.log(new an("c11939"));
                        if (!AntiHelper.d(getContext(), cCy)) {
                            if (this.jTc != null) {
                                this.jTc.setEnable(false);
                                w(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                Aj(z ? 2 : 1);
                                return;
                            }
                            this.kdw.showLoadingDialog();
                            cDO().cGo().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.dh("tid", cDO().cFJ());
                anVar2.dh("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.dh("fid", cDO().getForumId());
                if (!z) {
                }
                anVar2.ag("obj_name", i);
                anVar2.ag("obj_type", 2);
                if (cCy != null) {
                }
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (cFs() != null) {
                }
                TiebaStatic.log(anVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment cKN() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        I(eVar.cLs());
        J(eVar.cLs());
        if (cDO() != null && cDO().getPbData() != null) {
            boolean isFromMark = cDO().getIsFromMark();
            com.baidu.tieba.pb.data.e pbData = cDO().getPbData();
            if (isFromMark) {
                PostData H = H(pbData);
                if (pbData.aMK() != null && !pbData.aMK().equals(H.getId()) && this.dLI != null) {
                    this.dLI.setCurrentItem(kdc);
                }
            }
        }
        eVar.cLt().observe(this, new q<bk>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bk bkVar) {
                if (bkVar != null && bkVar.aQQ() != null) {
                    if (VideoPbFragment.this.kdj.getVideoUrl() == null || !VideoPbFragment.this.kdj.getVideoUrl().equals(bkVar.aQQ().video_url)) {
                        if (!aq.isEmpty(VideoPbFragment.this.kdj.getVideoUrl())) {
                            VideoPbFragment.this.jLp = true;
                            VideoPbFragment.this.dLI.setCurrentItem(VideoPbFragment.kdb);
                        }
                        if (VideoPbFragment.this.kdk == null || !VideoPbFragment.this.kdk.isPlaying()) {
                            VideoPbFragment.this.cKO();
                            VideoPbFragment.this.aN(bkVar);
                        }
                        VideoPbFragment.this.cKP();
                        if (VideoPbFragment.this.kdk.cLG()) {
                            VideoPbFragment.this.kdk.start();
                        }
                        boolean z = !aq.equals(VideoPbFragment.this.kdj.getVideoUrl(), bkVar.aQQ().video_url);
                        VideoPbFragment.this.kdj.setData(bkVar);
                        VideoPbFragment.this.kdj.sH(VideoPbFragment.this.dLI.getCurrentItem() == 0);
                        if (z) {
                            VideoPbFragment.this.kdj.startPlay();
                            VideoPbFragment.this.kdj.cMl();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.kdj.setData(bkVar);
                }
            }
        });
        eVar.cLC().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: q */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.dLI.setCurrentItem(num.intValue());
            }
        });
        eVar.cLx().observe(this, new q<bk>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bk bkVar) {
                VideoPbFragment.this.kdj.aS(bkVar);
            }
        });
        eVar.cLy().observe(this, new q<bk>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bk bkVar) {
                VideoPbFragment.this.kdj.aT(bkVar);
            }
        });
        eVar.cLz().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.cKZ();
            }
        });
        eVar.cLA().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKO() {
        ViewGroup.LayoutParams layoutParams = this.kdm.getLayoutParams();
        layoutParams.height = 0;
        this.kdm.setLayoutParams(layoutParams);
        this.kdm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKP() {
        if (this.kdk == null) {
            this.kdk = new f(getBaseFragmentActivity(), this.kdi);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(cFs()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.kdi.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.kdk.c(eVar.cLu(), rect);
            if (this.kdk.cLG()) {
                this.kdk.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (eVar.cLv() || VideoPbFragment.this.cDO().getTabIndex() == VideoPbFragment.kdc) {
                            VideoPbFragment.this.dLI.setCurrentItem(VideoPbFragment.kdc);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (eVar.cLv() || VideoPbFragment.this.cDO().getTabIndex() == VideoPbFragment.kdc) {
                            VideoPbFragment.this.dLI.setCurrentItem(VideoPbFragment.kdc);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (eVar.cLv() || cDO().getTabIndex() == kdc) {
                this.dLI.setCurrentItem(kdc);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.kdC && (this.kdD || cLm())) {
            cLl();
            UtilHelper.hideStatusBar(cFs(), cFs().getRootView());
            this.kdD = false;
            if (this.kdj != null) {
                this.kdj.sA(false);
            }
        }
        if (i == 4) {
            return this.kdj.cRP();
        }
        if (i == 24) {
            return this.kdj.cMi();
        }
        if (i == 25) {
            return this.kdj.cMj();
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
        Rect cGG;
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
                int height = (cDO() != null || (cGG = cDO().cGG()) == null) ? ceil : cGG.height();
                i = 0;
                layoutParams = this.kdi.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.kdi.setLayoutParams(layoutParams);
                this.kdi.setMaxHeight(ceil);
                this.kdi.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.kdi.setOriginHeight(height);
                layoutParams2 = (RelativeLayout.LayoutParams) this.kde.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, kdd);
                } else {
                    layoutParams2.height = kdd;
                }
                this.kde.setLayoutParams(layoutParams2);
                layoutParams3 = (CoordinatorLayout.LayoutParams) this.Wr.getLayoutParams();
                int i2 = ceil + kdd;
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
        if (cDO() != null) {
        }
        i = 0;
        layoutParams = this.kdi.getLayoutParams();
        if (layoutParams != null) {
        }
        this.kdi.setLayoutParams(layoutParams);
        this.kdi.setMaxHeight(ceil2);
        this.kdi.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.kdi.setOriginHeight(height);
        layoutParams2 = (RelativeLayout.LayoutParams) this.kde.getLayoutParams();
        if (layoutParams2 != null) {
        }
        this.kde.setLayoutParams(layoutParams2);
        layoutParams3 = (CoordinatorLayout.LayoutParams) this.Wr.getLayoutParams();
        int i22 = ceil2 + kdd;
        if (layoutParams3 != null) {
        }
        this.Wr.setLayoutParams(layoutParams3);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.jLj = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        aq(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.jLZ = new com.baidu.tbadk.core.view.c();
        this.jLZ.toastTime = 1000L;
        if (this.kdw != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.kdw.jMa;
            userMuteAddAndDelCustomMessage.setTag(this.kdw.jMa);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.kdw.jMa;
            userMuteCheckCustomMessage.setTag(this.kdw.jMa);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        com.baidu.tieba.s.c.dcI().z(getUniqueId());
    }

    private void initData() {
        this.jLD = com.baidu.tbadk.baseEditMark.a.a(this.jLc);
        if (this.jLD != null) {
            this.jLD.a(this.jMH);
        }
        this.gFg = new ForumManageModel(this.jLc);
        this.gFg.setLoadDataCallBack(this.gFl);
        this.dNL = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.kdw = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void aq(Bundle bundle) {
        this.jLR = new g();
        d(this.jLR);
        this.jLS = (com.baidu.tbadk.editortools.pb.e) this.jLR.dN(getActivity());
        this.jLS.a(this.jLc.getPageContext());
        this.jLS.a(this.emV);
        this.jLS.a(this.emO);
        this.jLS.a(this.jLc.getPageContext(), bundle);
        this.jLS.bcX().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.jLS.bcX().hW(true);
        rs(true);
        this.jLS.a(cDO().cFZ(), cDO().cFJ(), cDO().cGq());
        registerListener(this.jMp);
        registerListener(this.jMG);
        registerListener(this.jMo);
        registerListener(this.jMm);
        registerListener(this.hoG);
        if (!cDO().cFQ()) {
            this.jLS.yj(cDO().cFJ());
        }
        if (cDO().cGr()) {
            this.jLS.yh(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.jLS.yh(cHy());
        }
        this.jLJ = new ax();
        if (this.jLS.bdw() != null) {
            this.jLJ.e(this.jLS.bdw().getInputView());
        }
        this.jLS.a(this.emP);
        this.iQC = new aj(getPageContext());
        this.iQC.a(new aj.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
            @Override // com.baidu.tbadk.core.util.aj.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == aj.dNG) {
                        VideoPbFragment.this.jLS.a((String) null, (WriteData) null);
                    } else if (i == aj.dNH && VideoPbFragment.this.jTE != null && VideoPbFragment.this.jTE.cEy() != null) {
                        VideoPbFragment.this.jTE.cEy().bdS();
                    } else if (i == aj.dNI) {
                        VideoPbFragment.this.c(VideoPbFragment.this.jLV);
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
        this.hrv = new com.baidu.tieba.f.b(getActivity());
        this.hrv.a(jMQ);
        this.kdC = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        brd();
        this.Wr = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.kdg = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.kdi = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.kdj = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.kdi);
        this.kdj.setUniqueId(getUniqueId());
        this.kdj.ac(this);
        this.kdj.cQ(cFs().getRootView());
        this.kdj.cR(this.kdl);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.kde = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.kdm = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.dLI = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.kdh = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.kdh.setOnClickListener(this.aUZ);
        cKR();
        cKQ();
        cKS();
        this.kdf = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.dLI.setAdapter(this.kdf);
        this.kde.setViewPager(this.dLI);
        this.kde.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (VideoPbFragment.this.cLg() != null) {
                        VideoPbFragment.this.cLg().sG(false);
                    }
                    if (VideoPbFragment.this.cLh() != null) {
                        VideoPbFragment.this.cLh().sG(true);
                        VideoPbFragment.this.AR(VideoPbFragment.this.cLh().cLQ() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.cLz() != null && eVar.cLz().getValue() != null && eVar.cLz().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.kdj.sH(z);
                    VideoPbFragment.this.cHw();
                    if (VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null) {
                        TiebaStatic.log(new an("c13592").dh("tid", VideoPbFragment.this.cDO().cFJ()).dh("fid", VideoPbFragment.this.cDO().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.cLh() != null) {
                        VideoPbFragment.this.cLh().sG(false);
                    }
                    if (VideoPbFragment.this.cLg() != null) {
                        VideoPbFragment.this.cLg().sG(true);
                        int cLQ = VideoPbFragment.this.cLg().cLQ();
                        int cLV = VideoPbFragment.this.cLg().cLV();
                        if (cLQ != 0) {
                            VideoPbFragment.this.AR(8);
                            VideoPbFragment.this.cLg().AR(0);
                        } else if (cLV != 0) {
                            VideoPbFragment.this.cLg().AR(8);
                            VideoPbFragment.this.AR(0);
                        } else {
                            VideoPbFragment.this.cLg().AR(8);
                            VideoPbFragment.this.AR(8);
                        }
                    }
                    VideoPbFragment.this.kdj.sH(false);
                    VideoPbFragment.this.Wr.setExpanded(false, true);
                    if (VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null) {
                        TiebaStatic.log(new an("c13593").dh("tid", VideoPbFragment.this.cDO().cFJ()).dh("fid", VideoPbFragment.this.cDO().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.kdf.AT(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jSE = this.rootView.findViewById(R.id.viewstub_progress);
        cKT();
        bvo();
        if (!this.kdC && this.kdD) {
            cLl();
            UtilHelper.hideStatusBar(cFs(), cFs().getRootView());
            this.kdD = false;
        }
    }

    private void cKQ() {
        this.kdo = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.kds = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.kdp = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.kdq = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.kdr = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.kdt = this.rootView.findViewById(R.id.ala_live_point);
        this.kds.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.kds.setConrers(15);
        this.kdr.setConfig(new com.baidu.tbadk.core.view.commonBtn.d());
        this.kdq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.jFM == null || VideoPbFragment.this.jFM.cLZ()) {
                    if (VideoPbFragment.this.jFM != null) {
                        TiebaStatic.log(new an("c13608").dh("tid", VideoPbFragment.this.cDO().getPbData().getThreadId()));
                        VideoPbFragment.this.jFM.kfj = true;
                    }
                } else {
                    TiebaStatic.log(new an("c13591"));
                }
                VideoPbFragment.this.cLb();
            }
        });
        this.kdr.setOnClickListener(this.kdn);
        this.kdm.setOnClickListener(this.kdn);
    }

    private void cKR() {
        this.kde.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.kde.setContainerLayoutParams(layoutParams);
        this.kde.setRectPaintColor(R.color.cp_link_tip_a);
        this.kde.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.kde.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.kde.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.kde.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.kde.setExpandedTabLayoutParams(layoutParams2);
    }

    public void sz(boolean z) {
        if (this.Wr != null) {
            this.Wr.setExpanded(z);
        }
    }

    private void cKS() {
        this.jSV = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.jSW = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.jTg = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jTh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.jSY = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.jSY.setVisibility(com.baidu.tbadk.a.d.aMt() ? 0 : 8);
        if (com.baidu.tbadk.a.d.aMt()) {
            this.jSY.setIsRound(true);
            this.jSY.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.jSY.setBorderColor(am.getColor(R.color.cp_border_a));
            this.jSY.setPlaceHolder(1);
            this.jSY.setDefaultResource(R.color.cp_bg_line_e);
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.jSY.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            }
        }
        this.ihL = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.jSX = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.jSX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.sz(false);
                VideoPbFragment.this.cEK();
                if (VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null && VideoPbFragment.this.cDO().getPbData().cCy() != null && VideoPbFragment.this.cDO().getPbData().cCy().aQx() != null) {
                    if (com.baidu.tbadk.a.d.aMt()) {
                        TiebaStatic.log(new an("c13701").dh("tid", VideoPbFragment.this.cDO().cFK()).dh("fid", VideoPbFragment.this.cDO().getPbData().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    }
                    TiebaStatic.log(new an("c13402").dh("tid", VideoPbFragment.this.cDO().cFJ()).dh("fid", VideoPbFragment.this.cDO().getPbData().getForumId()).ag("obj_locate", 1).dh("uid", VideoPbFragment.this.cDO().getPbData().cCy().aQx().getUserId()));
                }
            }
        });
        this.jSZ = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.jSZ.setOnClickListener(this.aUZ);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.jTa = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.jTa.setOnClickListener(this.aUZ);
        if (booleanExtra) {
            this.jTa.setVisibility(8);
        } else {
            this.jTa.setVisibility(0);
        }
        this.jTb = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.jTb.setOnClickListener(this.aUZ);
        this.jTc = new com.baidu.tieba.pb.view.c(this.jTb);
        this.jTc.cMv();
        if (com.baidu.tbadk.a.d.aMt()) {
            this.jTd = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
            this.jTd.setVisibility(0);
        } else {
            this.jTe = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_number);
            this.jTe.setVisibility(0);
        }
        sa(false);
    }

    private void brd() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.bVq();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.kdl = this.rootView.findViewById(R.id.status_bar_background);
        if (this.kdC) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(cFs());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.kdl.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(cFs());
            this.kdl.setLayoutParams(layoutParams2);
            this.kdl.setVisibility(0);
        }
        this.eun = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aUZ);
        this.fxw = (ImageView) this.eun.findViewById(R.id.widget_navi_back_button);
        SvgManager.aUW().a(this.fxw, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jYC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aUZ);
        this.aex = (ImageView) this.jYC.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.jYC.setLayoutParams(layoutParams3);
        SvgManager.aUW().a(this.aex, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jYC.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.hxO);
        this.mNavigationBar.setOnTouchListener(this.kdE);
    }

    public void cKT() {
        setEditorTools(this.jLS.bcX());
    }

    private void bvo() {
        this.jKZ = new PbFakeFloorModel(getPageContext());
        this.jTE = new t(getPageContext(), this.jKZ, this.rootView);
        this.jTE.a(this.jMD);
        this.jKZ.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.jKZ.t(postData);
                if (VideoPbFragment.this.cLg() != null) {
                    VideoPbFragment.this.cLg().cLR();
                }
                VideoPbFragment.this.jTE.cEu();
                VideoPbFragment.this.Zt.bbA();
                VideoPbFragment.this.sa(false);
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.jLc = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (cDO() != null) {
            cDO().aA(bundle);
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
        this.kdj.or(true);
        if (cDO() != null && !cDO().cFQ()) {
            this.jLS.yi(cDO().cFJ());
        }
        com.baidu.tbadk.BdToken.c.aLi().aLn();
        MessageManager.getInstance().unRegisterListener(this.jMy);
        MessageManager.getInstance().unRegisterListener(this.jMz);
        MessageManager.getInstance().unRegisterListener(this.jMA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.beu = false;
        getVoiceManager().onResume(getPageContext());
        this.kdj.or(false);
        cFo();
        registerListener(this.jMy);
        registerListener(this.jMz);
        registerListener(this.jMA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.kdf != null && this.dLI != null) {
            this.kdf.AT(z ? this.dLI.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (com.baidu.tbadk.a.d.aMt() && this.jSY != null) {
            this.jSY.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.dcI().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dcI().A(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.jTc != null) {
            this.jTc.onDestroy();
        }
        if (this.gFg != null) {
            this.gFg.cancelLoadData();
        }
        if (this.kdj != null) {
            this.kdj.onDestroy();
        }
        if (this.jLt != null) {
            this.jLt.cancelLoadData();
        }
        if (this.iQC != null) {
            this.iQC.onDestroy();
        }
        if (cDO() != null) {
            cDO().cancelLoadData();
            cDO().destory();
            if (cDO().cGn() != null) {
                cDO().cGn().onDestroy();
            }
        }
        if (this.jLS != null) {
            this.jLS.onDestroy();
        }
        this.jLZ = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.jLc);
        this.kde.onChangeSkinType();
        am.setBackgroundColor(this.kde, R.color.cp_bg_line_h);
        this.jLJ.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.kdk == null || !this.kdk.isPlaying()) {
            am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        am.setBackgroundColor(this.kdl, R.color.cp_mask_b_alpha66);
        if (this.Zt != null) {
            this.Zt.onChangeSkinType(i);
        }
        if (this.jTE != null) {
            this.jTE.onChangeSkinType(i);
        }
        if (this.ihL != null) {
            am.setViewTextColor(this.ihL, (int) R.color.cp_cont_d);
        }
        if (this.jSY != null) {
            this.jSY.setBorderColor(am.getColor(R.color.cp_border_a));
        }
        if (this.jSX != null) {
            this.jSX.setBackgroundDrawable(am.aE(l.getDimens(getContext(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
        }
        if (this.jTa != null && cDO() != null) {
            if (cDO().aML()) {
                SvgManager.aUW().a(this.jTa, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aUW().a(this.jTa, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.jSZ != null) {
            SvgManager.aUW().a(this.jSZ, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (cDO() != null) {
            w(cDO().getPbData());
        }
        if (this.jTd != null) {
            am.c(this.jTd, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_cont_h, R.color.cp_cont_h);
            am.setViewTextColor(this.jTd, (int) R.color.cp_cont_a);
        }
        if (this.jTe != null) {
            am.setViewTextColor(this.jTe, (int) R.color.cp_cont_b);
        }
        if (this.jSV != null) {
            am.setBackgroundResource(this.jSV, R.drawable.bottom_shadow);
        }
        am.setBackgroundColor(this.jSW, R.color.cp_bg_line_h);
        if (cLg() != null) {
            cLg().onChangeSkinType(i);
        }
        if (cLh() != null) {
            cLh().onChangeSkinType(i);
        }
        if (this.kdg != null) {
            am.setBackgroundResource(this.kdg, R.drawable.personalize_tab_shadow);
        }
        if (this.kdm != null) {
            am.setBackgroundColor(this.kdm, R.color.cp_bg_line_g);
        }
        if (this.kdq != null) {
            SvgManager.aUW().a(this.kdq, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.kdo != null) {
            am.setViewTextColor(this.kdo, (int) R.color.cp_cont_b);
        }
        if (this.kdp != null) {
            am.setViewTextColor(this.kdp, (int) R.color.cp_cont_d);
        }
        if (this.kdt != null) {
            this.kdt.setBackgroundDrawable(am.aE(l.getDimens(this.kdt.getContext(), R.dimen.tbds32), am.getColor(R.color.cp_other_c)));
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hns == null) {
            this.hns = VoiceManager.instance();
        }
        return this.hns;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVp() {
        if (this.hns != null) {
            this.hns.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cFq() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cFr() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel cDO() {
        return this.jLc.cDO();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cFs() {
        return this.jLc;
    }

    public com.baidu.tbadk.baseEditMark.a cKU() {
        return this.jLD;
    }

    public View.OnClickListener cKV() {
        return this.aUZ;
    }

    public View.OnClickListener cKW() {
        return this.jIK;
    }

    public View.OnLongClickListener cKX() {
        return this.kdw.cKX();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (com.baidu.tieba.pb.pb.main.ba.JE(objArr[i].getLink()) && (drawable = am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView bXU() {
        Iterator<BaseFragment> it = this.kdf.cLq().iterator();
        while (it.hasNext()) {
            BaseFragment next = it.next();
            if (next instanceof ReplyFragment) {
                return ((ReplyFragment) next).getListView();
            }
        }
        return null;
    }

    private void rs(boolean z) {
        this.jLS.ia(z);
        this.jLS.ib(z);
        this.jLS.ic(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.kdw != null) {
            if (z) {
                this.kdw.cIk();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.kdw.cIl();
            } else {
                this.kdw.cIk();
            }
        }
    }

    public boolean Ah(int i) {
        if (this.iQC == null || cDO() == null || cDO().getPbData() == null || cDO().getPbData().getAnti() == null) {
            return true;
        }
        return this.iQC.aD(cDO().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean cEM() {
        if ((cDO() != null && cDO().getPbData().cCZ()) || this.iQC == null || cDO() == null || cDO().getPbData() == null || cDO().getPbData().getAnti() == null) {
            return true;
        }
        return this.iQC.lb(cDO().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && cDO() != null) {
            gVar.setForumName(cDO().cDF());
            if (cDO().getPbData() != null && cDO().getPbData().getForum() != null) {
                gVar.a(cDO().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(cDO());
        }
    }

    public void cHM() {
        if (this.Zt != null) {
            this.Zt.display();
            if (this.jLS != null) {
                this.jLS.bdA();
            }
            cIu();
        }
    }

    private boolean cEJ() {
        PbModel cDO = cDO();
        if (cDO == null || cDO.getPbData() == null) {
            return false;
        }
        bk cCy = cDO.getPbData().cCy();
        cDO.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cCy);
    }

    public void cEK() {
        if (checkUpIsLogin() && cDO() != null && cDO().getPbData() != null && cDO().getPbData().getForum() != null && !cEJ()) {
            if (cDO().getPbData().cCZ()) {
                cgX();
                return;
            }
            if (this.hra == null) {
                this.hra = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hra.vb(0);
                this.hra.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void na(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void x(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void nb(boolean z) {
                        if (z) {
                            VideoPbFragment.this.cgX();
                        }
                    }
                });
            }
            this.hra.D(cDO().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cDO().cFJ(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.jLS.onActivityResult(i, i2, intent);
        if (this.jLt != null) {
            this.jLt.onActivityResult(i, i2, intent);
        }
        if (this.jTE != null) {
            this.jTE.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cEW();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cUi().D(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.jLV = emotionImageData;
                        if (Ah(aj.dNI)) {
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
        if (cFs() != null) {
            if (this.kdD && !TbSingleton.getInstance().isNotchScreen(cFs()) && !TbSingleton.getInstance().isCutoutScreen(cFs())) {
                cLl();
                UtilHelper.hideStatusBar(cFs(), cFs().getRootView());
                this.kdD = false;
            }
            this.kdx.kdQ = z;
            cKY();
            cKZ();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.jLc;
        if (i == 0) {
            cHs();
            if (this.jTE != null) {
                this.jTE.cEu();
            }
            sa(false);
        }
        cHw();
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
                        this.jLS.resetData();
                        this.jLS.setVoiceModel(pbEditorData.getVoiceModel());
                        this.jLS.b(writeData);
                        com.baidu.tbadk.editortools.l nh = this.jLS.bcX().nh(6);
                        if (nh != null && nh.ekV != null) {
                            nh.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.jLc;
                        if (i == -1) {
                            this.jLS.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.jTE != null && this.jTE.cEy() != null) {
                            com.baidu.tbadk.editortools.pb.h cEy = this.jTE.cEy();
                            cEy.setThreadData(cDO().getPbData().cCy());
                            cEy.b(writeData);
                            cEy.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l nh2 = cEy.bcX().nh(6);
                            if (nh2 != null && nh2.ekV != null) {
                                nh2.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.jLc;
                            if (i == -1) {
                                cEy.bdS();
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
                if (cDO() != null && !cDO().cFQ()) {
                    antiData.setBlock_forum_name(cDO().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(cDO().getPbData().getForum().getId());
                    antiData.setUser_name(cDO().getPbData().getUserData().getUserName());
                    antiData.setUser_id(cDO().getPbData().getUserData().getUserId());
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
            if (this.kdw != null) {
                this.kdw.yo(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void cFu() {
        if (cDO() != null && this.jLc != null) {
            if (this.jLS == null || !this.jLS.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.jLS = (com.baidu.tbadk.editortools.pb.e) dVar.dN(getContext());
                this.jLS.a(this.jLc.getPageContext());
                this.jLS.a(this.emV);
                this.jLS.a(this.emO);
                this.jLS.a(this.jLc.getPageContext(), this.jLc.getIntent() == null ? null : this.jLc.getIntent().getExtras());
                this.jLS.bcX().hW(true);
                setEditorTools(this.jLS.bcX());
                if (!cDO().cFQ()) {
                    this.jLS.yj(cDO().cFJ());
                }
                if (cDO().cGr()) {
                    this.jLS.yh(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.jLS.yh(cHy());
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
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).aYd() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).aYd() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.jLS.c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            VideoPbFragment.this.jLS.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cHs();
        this.jLS.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
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
                if (VideoPbFragment.this.jLJ != null && VideoPbFragment.this.jLJ.cIJ() != null) {
                    if (!VideoPbFragment.this.jLJ.cIJ().dmy()) {
                        VideoPbFragment.this.jLJ.sf(false);
                    }
                    VideoPbFragment.this.jLJ.cIJ().vn(false);
                }
            }
        });
    }

    public void cgX() {
        if (!checkUpIsLogin()) {
            if (cDO() != null) {
                TiebaStatic.log(new an("c10517").ag("obj_locate", 2).dh("fid", cDO().getForumId()));
            }
        } else if (cEM()) {
            if (this.jLS != null && (this.jLS.bdK() || this.jLS.bdL())) {
                this.jLS.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Zt != null) {
                cHM();
                this.kdx.kdP = false;
                if (this.Zt.nh(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.Zt.nh(2).ekV, false, null);
                }
            }
            cIu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cEJ() && cEM()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.jLv);
                this.jLw = ((View) view.getParent()).getMeasuredHeight();
            }
            if (cDO() != null && cDO().getPbData() != null && cDO().getPbData().cCZ()) {
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.jLc.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.bXU().smoothScrollBy(0, (VideoPbFragment.this.jLv[1] + VideoPbFragment.this.jLw) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.jTE != null) {
                            VideoPbFragment.this.jLS.bcX().setVisibility(8);
                            VideoPbFragment.this.jTE.g(str, str2, VideoPbFragment.this.cHy(), (VideoPbFragment.this.cDO() == null || VideoPbFragment.this.cDO().getPbData() == null || VideoPbFragment.this.cDO().getPbData().cCy() == null || !VideoPbFragment.this.cDO().getPbData().cCy().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cEy = VideoPbFragment.this.jTE.cEy();
                            if (cEy != null && VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null) {
                                cEy.a(VideoPbFragment.this.cDO().getPbData().getAnti());
                                cEy.setThreadData(VideoPbFragment.this.cDO().getPbData().cCy());
                            }
                            if (VideoPbFragment.this.jLJ.cIL() == null && VideoPbFragment.this.jTE.cEy().bea() != null) {
                                VideoPbFragment.this.jTE.cEy().bea().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.jLJ != null && VideoPbFragment.this.jLJ.cIK() != null) {
                                            if (!VideoPbFragment.this.jLJ.cIK().dmy()) {
                                                VideoPbFragment.this.jLJ.sg(false);
                                            }
                                            VideoPbFragment.this.jLJ.cIK().vn(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.jLJ.f(VideoPbFragment.this.jTE.cEy().bea().getInputView());
                                VideoPbFragment.this.jTE.cEy().a(VideoPbFragment.this.jLX);
                            }
                        }
                        VideoPbFragment.this.cIu();
                    }
                }, 0L);
                return;
            }
            if (this.jLU == null) {
                this.jLU = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jLU.vb(1);
                this.jLU.a(new AnonymousClass44(str, str2));
            }
            if (cDO() != null && cDO().getPbData() != null && cDO().getPbData().getForum() != null) {
                this.jLU.D(cDO().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cDO().cFJ(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$44  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass44 implements c.a {
        final /* synthetic */ String jNc;
        final /* synthetic */ String jNd;

        AnonymousClass44(String str, String str2) {
            this.jNc = str;
            this.jNd = str2;
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
                        VideoPbFragment.this.bXU().smoothScrollBy(0, (VideoPbFragment.this.jLv[1] + VideoPbFragment.this.jLw) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.jTE != null) {
                            VideoPbFragment.this.jLS.bcX().setVisibility(8);
                            VideoPbFragment.this.jTE.g(AnonymousClass44.this.jNc, AnonymousClass44.this.jNd, VideoPbFragment.this.cHy(), (VideoPbFragment.this.cDO() == null || VideoPbFragment.this.cDO().getPbData() == null || VideoPbFragment.this.cDO().getPbData().cCy() == null || !VideoPbFragment.this.cDO().getPbData().cCy().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cEy = VideoPbFragment.this.jTE.cEy();
                            if (cEy != null && VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null) {
                                cEy.a(VideoPbFragment.this.cDO().getPbData().getAnti());
                                cEy.setThreadData(VideoPbFragment.this.cDO().getPbData().cCy());
                            }
                            if (VideoPbFragment.this.jLJ.cIL() == null && VideoPbFragment.this.jTE.cEy().bea() != null) {
                                VideoPbFragment.this.jTE.cEy().bea().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.jLJ != null && VideoPbFragment.this.jLJ.cIK() != null) {
                                            if (!VideoPbFragment.this.jLJ.cIK().dmy()) {
                                                VideoPbFragment.this.jLJ.sg(false);
                                            }
                                            VideoPbFragment.this.jLJ.cIK().vn(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.jLJ.f(VideoPbFragment.this.jTE.cEy().bea().getInputView());
                                VideoPbFragment.this.jTE.cEy().a(VideoPbFragment.this.jLX);
                            }
                        }
                        VideoPbFragment.this.cIu();
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cCN()));
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cCN()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bg> cCU = eVar.cCU();
                if (v.getCount(cCU) > 0) {
                    sb = new StringBuilder();
                    for (bg bgVar : cCU) {
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
    public void cEW() {
        MarkData At;
        if (cDO() != null && cDO().getPbData() != null && cLg() != null && this.jLD != null) {
            if (cDO().getPbData() != null && cDO().getPbData().cCZ()) {
                At = cDO().At(0);
            } else if (this.dLI != null && this.dLI.getCurrentItem() == kdb) {
                At = cDO().o(H(cDO().getPbData()));
            } else {
                At = cDO().At(cLg().cHW());
            }
            if (At != null) {
                if (!At.isApp() || (At = cDO().At(cLg().cHW() + 1)) != null) {
                    cHR();
                    this.jLD.a(At);
                    if (!this.jLD.aML()) {
                        this.jLD.aMN();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.jLD.aMM();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ai(int i) {
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
            if (this.jLt == null) {
                this.jLt = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.jLc);
                this.jLt.b(this.emO);
                this.jLt.c(this.emV);
            }
            this.jLt.a(emotionImageData, cDO(), cDO().getPbData());
        }
    }

    public PostData H(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.cCL() != null) {
            return eVar.cCL();
        }
        if (!v.isEmpty(eVar.cCA())) {
            Iterator<PostData> it = eVar.cCA().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.ddJ() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.cCH();
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
        if (eVar == null || eVar.cCy() == null || eVar.cCy().aQx() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aQx = eVar.cCy().aQx();
        String userId = aQx.getUserId();
        HashMap<String, MetaData> userMap = eVar.cCy().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aQx;
        }
        postData.DU(1);
        postData.setId(eVar.cCy().aQP());
        postData.setTitle(eVar.cCy().getTitle());
        postData.setTime(eVar.cCy().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cFb() {
        ArrayList<PostData> cCA;
        int count;
        int i;
        if (cDO() == null || cDO().getPbData() == null || cDO().getPbData().cCA() == null || (count = v.getCount((cCA = cDO().getPbData().cCA()))) == 0) {
            return "";
        }
        if (cDO().cGb()) {
            Iterator<PostData> it = cCA.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.ddJ() == 1) {
                    return next.getId();
                }
            }
        }
        if (bXU() == null) {
            i = 0;
        } else {
            i = cLg().cHV();
        }
        PostData postData = (PostData) v.getItem(cCA, i);
        if (postData == null || postData.aQx() == null) {
            return "";
        }
        if (cDO().Js(postData.aQx().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) v.getItem(cCA, i2);
            if (postData2 == null || postData2.aQx() == null || postData2.aQx().getUserId() == null) {
                break;
            } else if (cDO().Js(postData2.aQx().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) v.getItem(cCA, i3);
            if (postData3 == null || postData3.aQx() == null || postData3.aQx().getUserId() == null) {
                return "";
            }
            if (cDO().Js(postData3.aQx().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEX() {
        if (cDO() != null) {
            com.baidu.tieba.pb.data.e pbData = cDO().getPbData();
            cDO().rG(true);
            if (this.jLD != null) {
                pbData.Jd(this.jLD.aMK());
            }
            if (cLg() != null) {
                cLg().cLR();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (cDO() != null) {
            cHT();
            cDO().rG(z);
            if (this.jLD != null) {
                this.jLD.gC(z);
                if (markData != null) {
                    this.jLD.a(markData);
                }
            }
            if (cDO().aML()) {
                cEX();
            } else if (cLg() != null) {
                cLg().cLR();
            }
        }
    }

    public void b(n nVar) {
        MetaData metaData;
        boolean z = true;
        if (cDO() != null && cDO().getPbData() != null && nVar.cDs() != null) {
            String id = nVar.cDs().getId();
            ArrayList<PostData> cCA = cDO().getPbData().cCA();
            int i = 0;
            while (true) {
                if (i >= cCA.size()) {
                    break;
                }
                PostData postData = cCA.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cDw = nVar.cDw();
                    postData.DT(nVar.getTotalCount());
                    if (postData.ddG() != null && cDw != null) {
                        Iterator<PostData> it = cDw.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aQx() != null && (metaData = postData.getUserMap().get(next.aQx().getUserId())) != null) {
                                next.a(metaData);
                                next.uu(true);
                                next.a(getPageContext(), cDO().Js(metaData.getUserId()));
                            }
                        }
                        boolean z2 = cDw.size() != postData.ddG().size();
                        postData.ddG().clear();
                        postData.ddG().addAll(cDw);
                        z = z2;
                    }
                    if (postData.ddC() != null) {
                        postData.ddD();
                    }
                }
            }
            if (!cDO().getIsFromMark() && z && cLg() != null) {
                cLg().cLR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEO() {
        if (cDO() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.LQ(cDO().getForumId()) && cDO().getPbData() != null && cDO().getPbData().getForum() != null) {
            if (cDO().getPbData().getForum().isLike() == 1) {
                cDO().cGp().fj(cDO().getForumId(), cDO().cFJ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            bk cCy = eVar.cCy();
            if (cCy != null && cCy.aSx()) {
                cFu();
            } else {
                d(this.jLR);
            }
            if (this.jLS != null) {
                rY(this.jLS.bdD());
                this.jLS.a(eVar.getAnti());
                this.jLS.a(eVar.getForum(), eVar.getUserData());
                this.jLS.setThreadData(cCy);
                if (cDO() != null) {
                    this.jLS.a(cDO().cFZ(), cDO().cFJ(), cDO().cGq());
                }
                if (cCy != null) {
                    this.jLS.id(cCy.aRV());
                }
            }
        }
    }

    public void cHw() {
        reset();
        cHs();
        this.jTE.cEu();
        sa(false);
    }

    private void reset() {
        if (this.jLS != null && this.Zt != null) {
            com.baidu.tbadk.editortools.pb.a.bdt().setStatus(0);
            this.jLS.bdN();
            this.jLS.bdh();
            if (this.jLS.getWriteImagesInfo() != null) {
                this.jLS.getWriteImagesInfo().setMaxImagesAllowed(this.jLS.isBJH ? 1 : 9);
            }
            this.jLS.nn(SendView.ALL);
            this.jLS.no(SendView.ALL);
            com.baidu.tbadk.editortools.g ne = this.Zt.ne(23);
            com.baidu.tbadk.editortools.g ne2 = this.Zt.ne(2);
            com.baidu.tbadk.editortools.g ne3 = this.Zt.ne(5);
            if (ne2 != null) {
                ne2.display();
            }
            if (ne3 != null) {
                ne3.display();
            }
            if (ne != null) {
                ne.hide();
            }
            this.Zt.invalidate();
        }
    }

    public void t(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCy() != null) {
            w(eVar);
            this.jTa.setVisibility(eVar.cCZ() ? 8 : 0);
            if (eVar.aML()) {
                SvgManager.aUW().a(this.jTa, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aUW().a(this.jTa, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String AB = AB(eVar.cCy().aQo());
            if (this.jTd != null) {
                this.jTd.setText(AB);
            }
            if (this.jTe != null) {
                this.jTe.setText(AB);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.cCy()));
        }
    }

    public void w(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.aZ(eVar.cCy())) {
            if (this.jTc != null) {
                this.jTc.setEnable(false);
                this.jTc.onDestroy();
            }
            SvgManager.aUW().a(this.jTb, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.jTc == null || !this.jTc.isEnable()) {
            SvgManager.aUW().a(this.jTb, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private String AB(int i) {
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
        if (this.jSW != null) {
            rY(this.jLS.bdD());
            if (this.jSS) {
                rP(z);
            } else {
                rQ(z);
            }
            cKY();
            cKZ();
        }
    }

    public void cIu() {
        if (this.jSW != null) {
            this.jSV.setVisibility(8);
            this.jSW.setVisibility(8);
            this.kdx.kdP = false;
            cKY();
            cKZ();
        }
    }

    private void cKY() {
        if (this.kdj != null) {
            if (this.kdx.cLp()) {
                this.kdj.ty(false);
            } else {
                this.kdj.ty(this.kdj.bxE() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKZ() {
        if (this.kdj != null && this.dLI != null) {
            if (this.dLI.getCurrentItem() != 0) {
                this.kdj.sH(false);
            } else if (this.kdx.cLp()) {
                this.kdj.sH(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.kdj.sH(eVar.cLz() == null || eVar.cLz().getValue() == null || eVar.cLz().getValue().booleanValue());
                }
            }
        }
    }

    private void Aj(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(cFs(), cEN(), i);
    }

    private int cEN() {
        if (cDO() == null || cDO().getPbData() == null || cDO().getPbData().cCy() == null) {
            return -1;
        }
        return cDO().getPbData().cCy().aRl();
    }

    public void rY(boolean z) {
        this.jSS = z;
    }

    public void rP(boolean z) {
        if (this.jSW != null && this.ihL != null) {
            this.ihL.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.jSW.startAnimation(alphaAnimation);
            }
            this.jSV.setVisibility(0);
            this.jSW.setVisibility(0);
            this.kdx.kdP = true;
        }
    }

    public void rQ(boolean z) {
        if (this.jSW != null && this.ihL != null) {
            this.ihL.setText(cHy());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.jSW.startAnimation(alphaAnimation);
            }
            this.jSV.setVisibility(0);
            this.jSW.setVisibility(0);
            this.kdx.kdP = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null) {
            this.jFM = aVar;
            this.kdo.setText(aVar.getTitle());
            this.kdp.setText(aVar.cLW());
            String cLX = aVar.cLX();
            TBSpecificationBtn tBSpecificationBtn = this.kdr;
            if (TextUtils.isEmpty(cLX)) {
                cLX = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(cLX);
            this.kds.startLoad(aVar.getImage(), 10, false);
            this.kdt.setVisibility(aVar.cLZ() ? 0 : 8);
            com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.jFM == null || VideoPbFragment.this.jFM.cLZ()) {
                        if (VideoPbFragment.this.jFM != null && VideoPbFragment.this.cDO() != null && VideoPbFragment.this.cDO().getPbData() != null && VideoPbFragment.this.cDO().getPbData().getForum() != null) {
                            TiebaStatic.log(new an("c13712").dh("fid", VideoPbFragment.this.cDO().getPbData().getForum().getId()).dh("fname", VideoPbFragment.this.cDO().getPbData().getForum().getName()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", VideoPbFragment.this.cDO().getPbData().getThreadId()).s("obj_param1", VideoPbFragment.this.jFM.userId));
                        }
                    } else {
                        TiebaStatic.log(new an("c13608").dh("obj_id", VideoPbFragment.this.jFM.getTitle()).dh("obj_name", VideoPbFragment.this.jFM.cLW()).ag("obj_type", 2).dh("fid", VideoPbFragment.this.cDO().getPbData().getForumId()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", VideoPbFragment.this.cDO().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.cLa();
                }
            }, aVar.cLY().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLa() {
        ViewGroup.LayoutParams layoutParams = this.kdm.getLayoutParams();
        if (layoutParams != null) {
            if (this.kdu == null || !this.kdu.isRunning()) {
                this.kdm.setAlpha(0.0f);
                this.kdm.setVisibility(0);
                f(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLb() {
        if (this.kdm.getLayoutParams() != null) {
            if (this.kdu == null || !this.kdu.isRunning()) {
                cLc();
            }
        }
    }

    private void cLc() {
        final ViewGroup.LayoutParams layoutParams = this.kdm.getLayoutParams();
        if (layoutParams != null) {
            if (this.kdv == null || !this.kdv.isRunning()) {
                this.kdv = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.kdv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.kdm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.kdv.setDuration(200L);
                this.kdv.start();
                this.kdv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
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
        this.kdu = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kdu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.igf);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.igf);
                VideoPbFragment.this.kdm.setLayoutParams(layoutParams);
                VideoPbFragment.this.Wr.setLayoutParams(layoutParams2);
            }
        });
        this.kdu.setDuration(300L);
        this.kdu.start();
        this.kdu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.kdm.setVisibility(8);
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
        this.kdu = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kdu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.igf);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.kdm.setLayoutParams(layoutParams);
                VideoPbFragment.this.Wr.setLayoutParams(layoutParams2);
            }
        });
        this.kdu.setDuration(300L);
        this.kdu.start();
        this.kdu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.cLd();
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
    public void cLd() {
        this.kdu = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kdu.setDuration(300L);
        this.kdu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.kdm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.kdu.start();
    }

    public String cHy() {
        if (!aq.isEmpty(this.jTV)) {
            return this.jTV;
        }
        this.jTV = TbadkCoreApplication.getInst().getResources().getString(au.cHn());
        return this.jTV;
    }

    public void cHT() {
        hideProgressBar();
        if (cLg() != null) {
            cLg().endLoadData();
            cLg().cHU();
        }
    }

    public boolean cB(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.aNQ().isShowImages()) {
                    return Jo(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (cDO() == null || cDO().getPbData() == null) {
                        return true;
                    }
                    if (this.jTE != null) {
                        this.jTE.cEu();
                    }
                    n nVar = new n();
                    nVar.a(cDO().getPbData().getForum());
                    nVar.setThreadData(cDO().getPbData().cCy());
                    nVar.g(postData);
                    this.jKZ.d(nVar);
                    this.jKZ.setPostId(postData.getId());
                    b(view, postData.aQx().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.jLS != null) {
                        rY(this.jLS.bdD());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void cLe() {
        if (this.jLS != null) {
            rY(this.jLS.bdD());
        }
        cHw();
        this.kdw.cIk();
    }

    private boolean Jo(String str) {
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

    public void cnR() {
        if (this.jSE != null) {
            this.jSE.setVisibility(0);
        }
    }

    public void cnQ() {
        if (this.jSE != null) {
            this.jSE.setVisibility(8);
        }
    }

    public void AR(int i) {
        if (this.kdg != null) {
            this.kdg.setVisibility(i);
        }
    }

    public void cHR() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a cER() {
        return this.jMF;
    }

    public void cHs() {
        if (this.Zt != null) {
            this.Zt.hide();
        }
    }

    public void bVq() {
        if (this.jLc.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.jLc.getCurrentFocus());
        }
    }

    public void J(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCy() != null) {
            String valueOf = String.valueOf(eVar.cCy().aQo());
            if (eVar.cCy().aQo() == 0) {
                valueOf = "";
            }
            this.kde.zf(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        for (BaseFragment baseFragment : this.kdf.cLq()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, eVar, str, i4);
            }
        }
        b(z, i, i2, i3, eVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (cDO() != null && cDO().getPbData() != null && cDO().getPbData().cCy() != null && cDO().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(jTx)).intValue();
                if (intValue == jTy) {
                    if (!this.gFg.dez()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.gFg.MH(aq.O(jSONArray));
                        }
                        this.gFg.a(cDO().getPbData().getForum().getId(), cDO().getPbData().getForum().getName(), cDO().getPbData().cCy().getId(), str, intValue3, intValue2, booleanValue, cDO().getPbData().cCy().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == jTz || intValue == jTB) {
                    if (cDO().cGm() != null) {
                        cDO().cGm().Ad(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == jTz) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dN(String str, String str2) {
        ba.aVa().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int biZ() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bja() {
        if (this.eBC == null) {
            this.eBC = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bjm */
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
        return this.eBC;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bjb() {
        if (this.eEq == null) {
            this.eEq = TbRichTextView.u(getPageContext().getPageActivity(), 8);
        }
        return this.eEq;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bjc() {
        if (this.eBD == null) {
            this.eBD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bPQ */
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
                    gifView.bes();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.eBD;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bjd() {
        if (this.eEr == null) {
            this.eEr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cFv */
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
                    ((PlayVoiceBntNew) view).dfa();
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
        return this.eEr;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bje() {
        if (this.eEs == null) {
            this.eEs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cFx */
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
        return this.eEs;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bjf() {
        this.eEt = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFw */
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
        return this.eEt;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void al(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.jLn = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void f(Context context, String str, boolean z) {
        if (com.baidu.tieba.pb.pb.main.ba.JE(str) && cDO() != null && cDO().cFJ() != null) {
            TiebaStatic.log(new an("c11664").ag("obj_param1", 1).dh("post_id", cDO().cFJ()));
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
            com.baidu.tieba.pb.pb.main.ba.cIN().d(getPageContext(), str);
        }
        this.jLn = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void am(Context context, String str) {
        com.baidu.tieba.pb.pb.main.ba.cIN().d(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.jLn = true;
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
            this.kdw.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b cLJ = this.kdw.cLJ();
            if (cLJ == null) {
                this.kdw.cEI();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                cLJ.getItemView(1).setVisibility(8);
            } else {
                cLJ.getItemView(1).setVisibility(0);
            }
            cLJ.aSU();
            this.jLn = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ap(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            ba.aVa().b(getPageContext(), new String[]{str});
            this.jLn = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a cLf() {
        return this.dNL;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bgN() {
        return this.evw;
    }

    public ReplyFragment cLg() {
        if (this.kdf == null || !(this.kdf.AS(kdc) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.kdf.AS(kdc);
    }

    public DetailInfoFragment cLh() {
        if (this.kdf == null || !(this.kdf.AS(kdb) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.kdf.AS(kdb);
    }

    public boolean cDE() {
        PbModel cDO = this.jLc.cDO();
        if (cDO == null) {
            return false;
        }
        return cDO.cDE();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cCK;
        PbModel cDO = this.jLc.cDO();
        if (cDO != null && cDO.getPbData() != null && !cDO.getPbData().cCZ()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = cDO.getPbData().cCy().getId();
            if (cDO.isShareThread() && cDO.getPbData().cCy().dHm != null) {
                historyMessage.threadName = cDO.getPbData().cCy().dHm.showText;
            } else {
                historyMessage.threadName = cDO.getPbData().cCy().getTitle();
            }
            if (cDO.isShareThread() && !cDE()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = cDO.getPbData().getForum().getName();
            }
            ArrayList<PostData> cCA = cDO.getPbData().cCA();
            int cHV = cLg() != null ? cLg().cHV() : 0;
            if (cCA != null && cHV >= 0 && cHV < cCA.size()) {
                historyMessage.postID = cCA.get(cHV).getId();
            }
            historyMessage.isHostOnly = cDO.getHostMode();
            historyMessage.isSquence = cDO.cFL();
            historyMessage.isShareThread = cDO.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.jLS != null) {
            this.jLS.onDestroy();
        }
        if (cDO != null && (cDO.cFM() || cDO.cFO())) {
            Intent intent = new Intent();
            intent.putExtra("tid", cDO.cFJ());
            if (this.jLG) {
                if (this.jLI) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", cDO.bOe());
                }
                if (this.jLH) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", cDO.getIsGood());
                }
            }
            if (cDO.getPbData() != null && System.currentTimeMillis() - this.jLj >= 40000 && (cCK = cDO.getPbData().cCK()) != null && !v.isEmpty(cCK.getDataList())) {
                intent.putExtra("guess_like_data", cCK);
            }
            PbActivity pbActivity = this.jLc;
            PbActivity pbActivity2 = this.jLc;
            pbActivity.setResult(-1, intent);
        }
        if (cEY()) {
            if (cDO != null) {
                com.baidu.tieba.pb.data.e pbData = cDO.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.jLp) {
                        if (this.kdi != null) {
                            Rect rect = new Rect();
                            this.kdi.getGlobalVisibleRect(rect);
                            ao.cHc().h(rect);
                        }
                        ao.cHc().Ax(this.dLI.getCurrentItem());
                        BdTypeRecyclerView bXU = bXU();
                        Parcelable parcelable = null;
                        if (bXU != null) {
                            parcelable = bXU.onSaveInstanceState();
                        }
                        ao.cHc().a(cDO.cFT(), parcelable, cDO.cFL(), cDO.getHostMode(), false);
                    }
                }
            } else {
                ao.cHc().reset();
            }
            cEb();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.kdj != null && !this.kdj.bxE()) {
            if ((this.kdj.isFullScreen() && configuration.orientation == 1) || (!this.kdj.isFullScreen() && configuration.orientation == 2)) {
                this.kdj.sI(false);
            }
        }
    }

    public boolean cLi() {
        if (this.kdj == null) {
            return false;
        }
        return this.kdj.bxE();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.dcI().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        public boolean kdP;
        public boolean kdQ;

        private a() {
            this.kdQ = true;
        }

        public boolean cLp() {
            return (this.kdP && this.kdQ) ? false : true;
        }
    }

    public void cLj() {
        this.jLx = -1;
        this.jLy = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFo() {
        if (cDO() != null && !aq.isEmpty(cDO().cFJ())) {
            com.baidu.tbadk.BdToken.c.aLi().o(com.baidu.tbadk.BdToken.b.dtS, com.baidu.adp.lib.f.b.toLong(cDO().cFJ(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.kdh.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLk() {
        if (this.kdG == null) {
            this.kdG = ObjectAnimator.ofFloat(this.kdl, "alpha", 0.0f, 1.0f);
            this.kdG.setDuration(200L);
        }
        this.kdG.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLl() {
        if (this.kdH == null) {
            this.kdH = ObjectAnimator.ofFloat(this.kdl, "alpha", 1.0f, 0.0f);
            this.kdH.setDuration(200L);
        }
        this.kdH.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cLm() {
        return this.kdj != null && this.kdj.cLn();
    }

    public boolean cLn() {
        return this.kdD;
    }

    public void sA(boolean z) {
        this.kdD = z;
    }
}
