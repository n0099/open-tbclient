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
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.i;
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
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ah;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.s;
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
    private AppBarLayout CD;
    private EditorTools FO;
    private ImageView Lb;
    private CustomViewPager cYb;
    public View dFX;
    private com.baidu.adp.lib.d.b<ImageView> dMA;
    private com.baidu.adp.lib.d.b<GifView> dMB;
    private com.baidu.adp.lib.d.b<TextView> dPo;
    private com.baidu.adp.lib.d.b<View> dPp;
    private com.baidu.adp.lib.d.b<LinearLayout> dPq;
    private com.baidu.adp.lib.d.b<RelativeLayout> dPr;
    private ImageView eEJ;
    private VoiceManager goy;
    private com.baidu.tieba.frs.profession.permission.c grZ;
    private com.baidu.tieba.f.b gsB;
    public aj hPK;
    private com.baidu.tieba.pb.videopb.c.a iCA;
    private com.baidu.tieba.pb.pb.main.emotion.model.a iHE;
    int iHH;
    public ap iHT;
    private PbFakeFloorModel iHk;
    private PbActivity iHn;
    private g iIb;
    private com.baidu.tbadk.editortools.pb.e iIc;
    private com.baidu.tieba.frs.profession.permission.c iIe;
    private EmotionImageData iIf;
    private com.baidu.tbadk.core.view.d iIj;
    private View iOI;
    private ImageView iOK;
    private ImageView iOL;
    private ImageView iOM;
    private com.baidu.tieba.pb.view.c iON;
    private TextView iOO;
    private int iOQ;
    private int iOR;
    private View iOr;
    private String iPF;
    private s iPo;
    public View iUa;
    private NewPagerSlidingTabBaseStrip iYA;
    private VideoPbFragmentAdapter iYB;
    private View iYC;
    private View iYD;
    private VideoContainerLayout iYE;
    private com.baidu.tieba.pb.videopb.videoView.a iYF;
    private f iYG;
    private View iYH;
    private View iYI;
    private TextView iYK;
    private TextView iYL;
    private ImageView iYM;
    private TBSpecificationBtn iYN;
    private TbImageView iYO;
    private ValueAnimator iYP;
    private ValueAnimator iYQ;
    public com.baidu.tieba.pb.videopb.b.a iYR;
    private float iYV;
    private float iYW;
    private boolean iYX;
    private ObjectAnimator iZc;
    private ObjectAnimator iZd;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int iYx = 0;
    public static int iYy = 1;
    public static int iPg = 3;
    public static int iPh = 0;
    public static int iPi = 3;
    public static int iPj = 4;
    public static int iPk = 5;
    public static int iPl = 6;
    private static final int hfw = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int iYz = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a iIY = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void bk(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.clq();
            } else {
                com.baidu.tieba.pb.a.b.clp();
            }
        }
    };
    private long iHu = 0;
    View.OnClickListener iYJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.iCA != null) {
                TiebaStatic.log(new an("c13590").cy("obj_id", VideoPbFragment.this.iCA.getTitle()).cy("obj_name", VideoPbFragment.this.iCA.ctK()).X("obj_type", 2).cy("fid", VideoPbFragment.this.clC().getPbData().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("tid", VideoPbFragment.this.clC().getPbData().getThreadId()));
                String link = VideoPbFragment.this.iCA.getLink();
                if (!TextUtils.isEmpty(link)) {
                    if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                        ba.aGG().b(VideoPbFragment.this.getPageContext(), new String[]{link});
                        return;
                    }
                    Uri parse = Uri.parse(link);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(VideoPbFragment.this.getActivity(), parse.toString());
                    }
                }
            }
        }
    };
    private boolean mIsLoading = false;
    private com.baidu.tbadk.baseEditMark.a iHN = null;
    private com.baidu.tbadk.coreExtra.model.a dac = null;
    private ForumManageModel fKL = null;
    private boolean iHy = false;
    private View iOJ = null;
    private TextView hgY = null;
    private boolean iOF = false;
    private String dyD = null;
    private boolean iHQ = false;
    private boolean iHR = false;
    private boolean iHS = false;
    private boolean iHA = false;
    int[] iHG = new int[2];
    private int iHI = -1;
    private int iHJ = Integer.MIN_VALUE;
    private int iIp = 0;
    private int iYT = Integer.MIN_VALUE;
    private boolean isPaused = false;
    private final PbModel.a iIO = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g mm;
            VideoPbFragment.this.cpI();
            VideoPbFragment.this.bWs();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.qr(false);
            if (z && eVar != null) {
                bj ckv = eVar.ckv();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(eVar, i2);
                VideoPbFragment.this.G(eVar);
                com.baidu.tieba.pb.videopb.c.a ckV = eVar.ckV();
                if (ckV != null) {
                    VideoPbFragment.this.a(ckV);
                }
                VideoPbFragment.this.H(eVar);
                VideoPbFragment.this.c(z, i, i2, i3, eVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.iHN != null) {
                    VideoPbFragment.this.iHN.fm(eVar.ayL());
                }
                AntiData anti = eVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.dyD = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.dyD) && VideoPbFragment.this.iIc != null && VideoPbFragment.this.iIc.aOu() != null && (mm = VideoPbFragment.this.iIc.aOu().mm(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.dyD)) {
                        ((View) mm).setOnClickListener(VideoPbFragment.this.dzo);
                    }
                }
                if (VideoPbFragment.this.hPK != null && ckv != null && ckv.aCo() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(ckv.aCo());
                    VideoPbFragment.this.hPK.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.clC().cnz());
                        jSONObject.put("fid", VideoPbFragment.this.clC().getForumId());
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
                if (VideoPbFragment.this.csU() != null) {
                    if (i != -1) {
                        ArrayList<PostData> arrayList = null;
                        if (VideoPbFragment.this.clC() != null && VideoPbFragment.this.clC().getPbData() != null) {
                            arrayList = VideoPbFragment.this.clC().getPbData().ckx();
                        }
                        if (v.getCount(arrayList) == 0 || (v.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).cLb() == 1)) {
                            if (VideoPbFragment.this.csU().cnd()) {
                                VideoPbFragment.this.csU().Ge(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                VideoPbFragment.this.csU().Ge(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            VideoPbFragment.this.csU().Gd(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                        }
                    } else {
                        VideoPbFragment.this.csU().Gd("");
                    }
                    VideoPbFragment.this.csU().endLoadData();
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.cKb().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0374a iIQ = new a.InterfaceC0374a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0374a
        public void c(boolean z, boolean z2, String str) {
            VideoPbFragment.this.cpI();
            if (z && VideoPbFragment.this.clC() != null) {
                if (VideoPbFragment.this.iHN != null) {
                    VideoPbFragment.this.iHN.fm(z2);
                }
                VideoPbFragment.this.clC().pX(z2);
                if (VideoPbFragment.this.clC().ayL()) {
                    VideoPbFragment.this.cmO();
                } else if (VideoPbFragment.this.csU() != null) {
                    VideoPbFragment.this.csU().ctF();
                }
                if (z2) {
                    if (VideoPbFragment.this.iHN != null) {
                        if (VideoPbFragment.this.iHN.ayO() != null && VideoPbFragment.this.clC() != null && VideoPbFragment.this.clC().getPbData() != null && VideoPbFragment.this.clC().getPbData().ckv() != null && VideoPbFragment.this.clC().getPbData().ckv().aCo() != null) {
                            MarkData ayO = VideoPbFragment.this.iHN.ayO();
                            MetaData aCo = VideoPbFragment.this.clC().getPbData().ckv().aCo();
                            if (ayO != null && aCo != null) {
                                if (!aq.equals(TbadkCoreApplication.getCurrentAccount(), aCo.getUserId()) && !aCo.hadConcerned()) {
                                    VideoPbFragment.this.iYR.b(aCo);
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
                    VideoPbFragment.this.cmL();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b dyH = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOR() {
            if (VideoPbFragment.this.iHT == null || VideoPbFragment.this.iHT.cqy() == null || !VideoPbFragment.this.iHT.cqy().cUf()) {
                return !VideoPbFragment.this.yN(aj.cZX);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.iHT.cqy().cUh());
            if (VideoPbFragment.this.iIc != null && (VideoPbFragment.this.iIc.aPh() || VideoPbFragment.this.iIc.aPi())) {
                VideoPbFragment.this.iIc.a(false, VideoPbFragment.this.iHT.cqB());
            }
            VideoPbFragment.this.iHT.qw(true);
            return true;
        }
    };
    private final CustomMessageListener iIw = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.clC() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.iIc != null) {
                    VideoPbFragment.this.qp(VideoPbFragment.this.iIc.aPa());
                }
                VideoPbFragment.this.cpl();
                VideoPbFragment.this.iYR.cpZ();
            }
        }
    };
    private CustomMessageListener iIz = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        VideoPbFragment.this.b((com.baidu.tieba.pb.data.l) eVar.getData());
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
    private final CustomMessageListener gpK = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.isPaused) {
                VideoPbFragment.this.cnf();
            }
        }
    };
    private CustomMessageListener iIP = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.cmF();
            }
        }
    };
    private CustomMessageListener iIK = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.iYR != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.iYR.iIk) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.iYR.bqs();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.iYR.getExtra();
                DataRes dataRes = aVar.kuS;
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
                    VideoPbFragment.this.iYR.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.iYR.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener iII = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.iYR != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.iYR.iIk) {
                VideoPbFragment.this.iYR.bqs();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.clC().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.ckI().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.iIj.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.iYR.vr(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.iYR.cnc();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.iIj.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iIJ = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.iYR != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.iYR.iIk) {
                VideoPbFragment.this.iYR.bqs();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.iIj.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.iIj.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b iIh = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOR() {
            if (VideoPbFragment.this.iHT == null || VideoPbFragment.this.iHT.cqz() == null || !VideoPbFragment.this.iHT.cqz().cUf()) {
                return !VideoPbFragment.this.yN(aj.cZY);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.iHT.cqz().cUh());
            if (VideoPbFragment.this.iPo != null && VideoPbFragment.this.iPo.cmo() != null && VideoPbFragment.this.iPo.cmo().aPi()) {
                VideoPbFragment.this.iPo.cmo().a(VideoPbFragment.this.iHT.cqB());
            }
            VideoPbFragment.this.iHT.qx(true);
            return true;
        }
    };
    private final NewWriteModel.d dyN = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.clC() != null && VideoPbFragment.this.clC().getPbData() != null) {
                    anVar.cy("fid", VideoPbFragment.this.clC().getPbData().getForumId());
                }
                anVar.cy("tid", VideoPbFragment.this.clC().cnz());
                anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            VideoPbFragment.this.bEl();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.clC() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.clC().FY(postWriteCallBackData.getPostId());
                    if (VideoPbFragment.this.csU() != null) {
                        VideoPbFragment.this.iIp = VideoPbFragment.this.csU().cpK();
                        VideoPbFragment.this.iYT = VideoPbFragment.this.csU().ctI();
                        VideoPbFragment.this.clC().cr(VideoPbFragment.this.iIp, VideoPbFragment.this.iYT);
                    }
                }
                if (VideoPbFragment.this.cYb != null) {
                    VideoPbFragment.this.cYb.setCurrentItem(VideoPbFragment.iYy);
                }
                VideoPbFragment.this.iYR.cpZ();
                VideoPbFragment.this.iHT.cqx();
                if (VideoPbFragment.this.iIc != null) {
                    VideoPbFragment.this.qp(VideoPbFragment.this.iIc.aPa());
                }
                VideoPbFragment.this.cph();
                VideoPbFragment.this.qr(true);
                VideoPbFragment.this.clC().cnT();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && VideoPbFragment.this.csU() != null) {
                            VideoPbFragment.this.csU().ctF();
                        }
                    } else if (VideoPbFragment.this.clC().getHostMode()) {
                        com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.clC().getPbData();
                        if (pbData != null && pbData.ckv() != null && pbData.ckv().aCo() != null && (userId = pbData.ckv().aCo().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.clC().cnK()) {
                            VideoPbFragment.this.cpG();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.clC().cnK()) {
                        VideoPbFragment.this.cpG();
                    }
                    VideoPbFragment.this.cmE();
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.iIc.aPh() || VideoPbFragment.this.iIc.aPi()) {
                    VideoPbFragment.this.iIc.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.iHT.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.hPK != null) {
                    VideoPbFragment.this.hPK.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (aaVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener dzo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.dyD);
        }
    };
    private CustomMessageListener iIy = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.iIc != null) {
                    VideoPbFragment.this.qp(VideoPbFragment.this.iIc.aPa());
                }
                VideoPbFragment.this.qr(false);
            }
        }
    };
    private int iYU = 0;
    private boolean iYY = true;
    private View.OnTouchListener iYZ = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.iYU == 1) {
                if (!VideoPbFragment.this.iYY) {
                    VideoPbFragment.this.csY();
                    UtilHelper.showStatusBar(VideoPbFragment.this.cnj(), VideoPbFragment.this.cnj().getRootView());
                    VideoPbFragment.this.iYY = true;
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(VideoPbFragment.this.iZb);
                    com.baidu.adp.lib.f.e.gx().postDelayed(VideoPbFragment.this.iZb, 3000L);
                }
            } else if (VideoPbFragment.this.iYU == 2 && (VideoPbFragment.this.iYY || VideoPbFragment.this.cta())) {
                VideoPbFragment.this.csZ();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cnj(), VideoPbFragment.this.cnj().getRootView());
                VideoPbFragment.this.iYY = false;
                if (VideoPbFragment.this.iYF != null) {
                    VideoPbFragment.this.iYF.qS(false);
                }
            }
            VideoPbFragment.this.iYU = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener iZa = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.iYU = 0;
            VideoPbFragment.this.iYV = 0.0f;
            VideoPbFragment.this.iYW = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.iYV += f;
            VideoPbFragment.this.iYW += f2;
            if (VideoPbFragment.this.iYU == 0 && !VideoPbFragment.this.iYX && VideoPbFragment.this.iYF != null && !VideoPbFragment.this.iYF.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.iYW) <= Math.abs(VideoPbFragment.this.iYV) || VideoPbFragment.this.iYW > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.iYW) > Math.abs(VideoPbFragment.this.iYV) && VideoPbFragment.this.iYW > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.iYU = 2;
                    }
                } else {
                    VideoPbFragment.this.iYU = 1;
                }
            }
            return true;
        }
    };
    private Runnable iZb = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.iYY && !VideoPbFragment.this.cta()) {
                VideoPbFragment.this.csZ();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cnj(), VideoPbFragment.this.cnj().getRootView());
                VideoPbFragment.this.iYY = false;
            }
        }
    };
    private final com.baidu.adp.base.d fKQ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.clC() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.fKL.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.fKL.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.clC().cnT();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.iVT != 1002 || bVar.eLS) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.mSuccess, dVar.kju, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.fKL.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.fKL.getLoadDataMode(), gVar.mSuccess, gVar.kju, false);
                    VideoPbFragment.this.iYR.aM(gVar.kjx);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener drN = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.gsB.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d iIM = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.clC() != null && VideoPbFragment.this.clC().getPbData() != null) {
                    anVar.cy("fid", VideoPbFragment.this.clC().getPbData().getForumId());
                }
                if (VideoPbFragment.this.clC() != null) {
                    anVar.cy("tid", VideoPbFragment.this.clC().cnz());
                }
                anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (VideoPbFragment.this.iHT != null) {
                    VideoPbFragment.this.iHT.cqw();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.hPK != null) {
                    VideoPbFragment.this.hPK.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.iHT != null) {
                if (VideoPbFragment.this.iPo != null && VideoPbFragment.this.iPo.cmo() != null && VideoPbFragment.this.iPo.cmo().aPi()) {
                    VideoPbFragment.this.iPo.cmo().a(postWriteCallBackData);
                }
                VideoPbFragment.this.iHT.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c dyG = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aOS() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener auY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            boolean v;
            int i2 = 2;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    an anVar = new an("c13398");
                    anVar.cy("tid", VideoPbFragment.this.clC().cnz());
                    anVar.cy("fid", VideoPbFragment.this.clC().getForumId());
                    anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.X("obj_locate", 1);
                    TiebaStatic.log(anVar);
                    if (VideoPbFragment.this.iHy) {
                        VideoPbFragment.this.iHy = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.clC() != null && VideoPbFragment.this.clC().getPbData() != null && VideoPbFragment.this.iHk != null && postData.aCo() != null && postData.cLb() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.iPo != null) {
                                    VideoPbFragment.this.iPo.cmk();
                                }
                                com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                                lVar.a(VideoPbFragment.this.clC().getPbData().getForum());
                                lVar.setThreadData(VideoPbFragment.this.clC().getPbData().ckv());
                                lVar.f(postData);
                                VideoPbFragment.this.iHk.d(lVar);
                                VideoPbFragment.this.iHk.setPostId(postData.getId());
                                VideoPbFragment.this.b(view, postData.aCo().getUserId(), "");
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.clC().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.iIc != null) {
                                    VideoPbFragment.this.qp(VideoPbFragment.this.iIc.aPa());
                                }
                            }
                        }
                    }
                } else if (VideoPbFragment.this.csU() != null && VideoPbFragment.this.csU().cpV() != null && view == VideoPbFragment.this.csU().cpV()) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.clC().pV(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        VideoPbFragment.this.csU().cpH();
                    }
                } else if (VideoPbFragment.this.iYR != null && VideoPbFragment.this.iYR.crd() != null && view == VideoPbFragment.this.iYR.crd().coH()) {
                    VideoPbFragment.this.iYR.arU();
                } else if (VideoPbFragment.this.iYR != null && ((VideoPbFragment.this.iYR.crd() != null && view == VideoPbFragment.this.iYR.crd().coI()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.iYR.cpZ();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.bEl();
                        VideoPbFragment.this.cpG();
                        if (view.getId() == R.id.owner_reply) {
                            v = VideoPbFragment.this.clC().v(true, VideoPbFragment.this.cmS());
                        } else {
                            v = view.getId() == R.id.all_reply ? VideoPbFragment.this.clC().v(false, VideoPbFragment.this.cmS()) : VideoPbFragment.this.clC().FV(VideoPbFragment.this.cmS());
                        }
                        view.setTag(Boolean.valueOf(v));
                        if (v) {
                            VideoPbFragment.this.bWt();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.dFX) {
                    if (VideoPbFragment.this.clC() != null && VideoPbFragment.this.clC().getPbData() != null) {
                        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            an anVar2 = new an("c13266");
                            anVar2.cy("uid", TbadkCoreApplication.getCurrentAccount());
                            anVar2.cy("fid", VideoPbFragment.this.clC().getPbData().getForumId());
                            anVar2.cy("tid", VideoPbFragment.this.clC().cnz());
                            anVar2.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(anVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.iHn, VideoPbFragment.this.dFX);
                        VideoPbFragment.this.iHn.finish();
                    }
                } else if (view == VideoPbFragment.this.iUa && VideoPbFragment.this.iYR != null) {
                    if (VideoPbFragment.this.clC() == null || VideoPbFragment.this.clC().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> ckx = VideoPbFragment.this.clC().getPbData().ckx();
                    if ((ckx == null || ckx.size() <= 0) && VideoPbFragment.this.clC().cnA()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new an("c12378").cy("tid", VideoPbFragment.this.clC().cnz()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", VideoPbFragment.this.clC().getForumId()));
                    VideoPbFragment.this.iYR.cmG();
                } else if (VideoPbFragment.this.iYR != null && VideoPbFragment.this.iYR.crd() != null && view == VideoPbFragment.this.iYR.crd().coI()) {
                    VideoPbFragment.this.iYR.arU();
                } else if (VideoPbFragment.this.iYR != null && ((VideoPbFragment.this.iYR.crd() != null && view == VideoPbFragment.this.iYR.crd().coO()) || view.getId() == R.id.pb_sort_type)) {
                    VideoPbFragment.this.iYR.cpZ();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.bEl();
                            VideoPbFragment.this.cpG();
                            VideoPbFragment.this.iYR.cG(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.clC().cnR()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.iYR != null && VideoPbFragment.this.iYR.crd() != null && view == VideoPbFragment.this.iYR.crd().coG()) {
                    if (VideoPbFragment.this.clC() != null && VideoPbFragment.this.clC().getPbData() != null && VideoPbFragment.this.clC().getPbData().ckv() != null) {
                        VideoPbFragment.this.iYR.arU();
                        TiebaStatic.log(new an("c13062"));
                        VideoPbFragment.this.iYR.FQ(VideoPbFragment.this.clC().getPbData().ckv().aCE());
                    }
                } else if (VideoPbFragment.this.iYR != null && VideoPbFragment.this.iYR.crd() != null && view == VideoPbFragment.this.iYR.crd().coP()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        am.w(true, false);
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).X("obj_type", 0).X("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).X("obj_type", 1).X("obj_source", 1));
                    }
                    VideoPbFragment.this.iYR.crc();
                } else if (VideoPbFragment.this.iYR != null && (view == VideoPbFragment.this.iYR.cpE() || (VideoPbFragment.this.iYR.crd() != null && (view == VideoPbFragment.this.iYR.crd().coL() || view == VideoPbFragment.this.iYR.crd().coJ())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.clC() != null || VideoPbFragment.this.clC().getPbData() != null) {
                        if ((VideoPbFragment.this.clC().getPbData().ckH() == 1 || VideoPbFragment.this.clC().getPbData().ckH() == 3) && !VideoPbFragment.this.fKL.cLP()) {
                            VideoPbFragment.this.iYR.cpZ();
                            if (VideoPbFragment.this.iYR.crd() != null && view == VideoPbFragment.this.iYR.crd().coJ()) {
                                if (VideoPbFragment.this.clC().getPbData().ckv().aCj() == 1) {
                                    i = 5;
                                } else {
                                    i = 4;
                                }
                            } else if (VideoPbFragment.this.iYR.crd() != null && view == VideoPbFragment.this.iYR.crd().coL()) {
                                i = VideoPbFragment.this.clC().getPbData().ckv().aCk() == 1 ? 3 : 6;
                            } else {
                                i = view == VideoPbFragment.this.iYR.cpE() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.clC().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.clC().getPbData().ckv().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.fKL.b(id, name, id2, i, VideoPbFragment.this.iYR.cpF());
                        }
                    }
                } else if (VideoPbFragment.this.iYR != null && VideoPbFragment.this.iYR.crd() != null && view == VideoPbFragment.this.iYR.crd().coN()) {
                    if (VideoPbFragment.this.clC() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.iYR.cpZ();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.clC().getPbData(), VideoPbFragment.this.clC().cnA(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.clC().getPbData().getForum().getId(), VideoPbFragment.this.clC().getPbData().getForum().getName(), VideoPbFragment.this.clC().getPbData().ckv().getId(), String.valueOf(VideoPbFragment.this.clC().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.iYR != null && VideoPbFragment.this.iYR.crd() != null && view == VideoPbFragment.this.iYR.crd().coK()) {
                    if (VideoPbFragment.this.clC() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.clC().getPbData(), VideoPbFragment.this.clC().cnA(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.iYR.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.iYR.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.iYR.arU();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        an anVar3 = new an("c13398");
                        anVar3.cy("tid", VideoPbFragment.this.clC().cnz());
                        anVar3.cy("fid", VideoPbFragment.this.clC().getForumId());
                        anVar3.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar3.X("obj_locate", 4);
                        TiebaStatic.log(anVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new an("c10517").X("obj_locate", 3).cy("fid", VideoPbFragment.this.clC().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.clC() != null && VideoPbFragment.this.clC().getPbData() != null) {
                        if (VideoPbFragment.this.iYR != null) {
                            VideoPbFragment.this.iYR.cpZ();
                        }
                        PostData postData2 = (PostData) ((SparseArray) view.getTag()).get(R.id.tag_load_sub_data);
                        if (postData2 != null) {
                            if (postData2.cLn() == 1) {
                                TiebaStatic.log(new an("c12630"));
                            }
                            if (postData2.khD != null) {
                                an aGy = postData2.khD.aGy();
                                aGy.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    aGy.X("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    aGy.X("obj_locate", 8);
                                }
                                TiebaStatic.log(aGy);
                            }
                            String cnz = VideoPbFragment.this.clC().cnz();
                            String id3 = postData2.getId();
                            int ckH = VideoPbFragment.this.clC().getPbData() != null ? VideoPbFragment.this.clC().getPbData().ckH() : 0;
                            VideoPbFragment.this.bEl();
                            TiebaStatic.log("c11742");
                            if (VideoPbFragment.this.csU() != null && VideoPbFragment.this.csU().ctH() != null) {
                                PbActivity.a FT = VideoPbFragment.this.csU().ctH().FT(id3);
                                if (postData2 != null && VideoPbFragment.this.clC() != null && VideoPbFragment.this.clC().getPbData() != null && FT != null) {
                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cnz, id3, "pb", true, null, false, null, ckH, postData2.csa(), VideoPbFragment.this.clC().getPbData().getAnti(), false, postData2.aCo().getIconInfo()).addBigImageData(FT.iEz, FT.iEA, FT.iEB, FT.index);
                                    addBigImageData.setKeyFromForumId(VideoPbFragment.this.clC().getForumId());
                                    addBigImageData.setBjhData(VideoPbFragment.this.clC().cnH());
                                    addBigImageData.setKeyPageStartFrom(VideoPbFragment.this.clC().coi());
                                    addBigImageData.setFromFrsForumId(VideoPbFragment.this.clC().getFromForumId());
                                    VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply) {
                    if (VideoPbFragment.this.clC() != null) {
                        an anVar4 = new an("c13398");
                        anVar4.cy("tid", VideoPbFragment.this.clC().cnz());
                        anVar4.cy("fid", VideoPbFragment.this.clC().getForumId());
                        anVar4.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar4.X("obj_locate", 6);
                        TiebaStatic.log(anVar4);
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData3 = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                if (postData3.khD != null) {
                                    an aGy2 = postData3.khD.aGy();
                                    aGy2.delete("obj_locate");
                                    aGy2.X("obj_locate", 8);
                                    TiebaStatic.log(aGy2);
                                }
                                if (VideoPbFragment.this.clC() != null && VideoPbFragment.this.clC().getPbData() != null && VideoPbFragment.this.iHk != null && postData3.aCo() != null && postData3.cLb() != 1) {
                                    if (VideoPbFragment.this.iPo != null) {
                                        VideoPbFragment.this.iPo.cmk();
                                    }
                                    com.baidu.tieba.pb.data.l lVar2 = new com.baidu.tieba.pb.data.l();
                                    lVar2.a(VideoPbFragment.this.clC().getPbData().getForum());
                                    lVar2.setThreadData(VideoPbFragment.this.clC().getPbData().ckv());
                                    lVar2.f(postData3);
                                    VideoPbFragment.this.iHk.d(lVar2);
                                    VideoPbFragment.this.iHk.setPostId(postData3.getId());
                                    VideoPbFragment.this.b(view, postData3.aCo().getUserId(), "");
                                    if (VideoPbFragment.this.iIc != null) {
                                        VideoPbFragment.this.qp(VideoPbFragment.this.iIc.aPa());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.iYR != null && VideoPbFragment.this.clC() != null && VideoPbFragment.this.csU() != null) {
                        VideoPbFragment.this.iYR.cpZ();
                        if (VideoPbFragment.this.yO(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.clC() != null) {
                            VideoPbFragment.this.cmN();
                            if (VideoPbFragment.this.clC().getPbData() != null && VideoPbFragment.this.clC().getPbData().ckv() != null && VideoPbFragment.this.clC().getPbData().ckv().aCo() != null) {
                                TiebaStatic.log(new an("c13402").cy("tid", VideoPbFragment.this.clC().cnz()).cy("fid", VideoPbFragment.this.clC().getPbData().getForumId()).X("obj_locate", 3).cy("uid", VideoPbFragment.this.clC().getPbData().ckv().aCo().getUserId()));
                            }
                            if (VideoPbFragment.this.clC().getPbData().ckv() != null && VideoPbFragment.this.clC().getPbData().ckv().aCo() != null && VideoPbFragment.this.clC().getPbData().ckv().aCo().getUserId() != null && VideoPbFragment.this.iHN != null) {
                                int g = VideoPbFragment.this.iYR.g(VideoPbFragment.this.clC().getPbData());
                                bj ckv = VideoPbFragment.this.clC().getPbData().ckv();
                                if (!ckv.aBd()) {
                                    if (ckv.aBe()) {
                                        i2 = 3;
                                    } else if (ckv.aEg()) {
                                        i2 = 4;
                                    } else {
                                        i2 = ckv.aEh() ? 5 : 1;
                                    }
                                }
                                TiebaStatic.log(new an("c12526").cy("tid", VideoPbFragment.this.clC().cnz()).X("obj_locate", 1).cy("obj_id", VideoPbFragment.this.clC().getPbData().ckv().aCo().getUserId()).X("obj_type", VideoPbFragment.this.iHN.ayL() ? 0 : 1).X("obj_source", g).X("obj_param1", i2));
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.qQ(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.clC() != null && VideoPbFragment.this.iYR != null && VideoPbFragment.this.cYb != null && VideoPbFragment.this.clC().getPbData() != null && VideoPbFragment.this.clC().getPbData().ckv() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        if (VideoPbFragment.this.clC().getPbData().ckv().aCf() != 0) {
                            int currentItem = VideoPbFragment.this.cYb.getCurrentItem();
                            if (currentItem == VideoPbFragment.iYx) {
                                VideoPbFragment.this.cYb.setCurrentItem(VideoPbFragment.iYy);
                            } else if (currentItem == VideoPbFragment.iYy) {
                                if (VideoPbFragment.this.csU() != null && VideoPbFragment.this.bGG() != null) {
                                    an cy = new an("c13403").cy("tid", VideoPbFragment.this.clC().cnz()).cy("fid", VideoPbFragment.this.clC().getPbData().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView bGG = VideoPbFragment.this.bGG();
                                    boolean canScrollVertically = bGG.canScrollVertically(1);
                                    boolean canScrollVertically2 = bGG.canScrollVertically(-1);
                                    if (VideoPbFragment.this.CD != null) {
                                        VideoPbFragment.this.CD.setExpanded(false, true);
                                    }
                                    if (bGG.getLayoutManager() != null && (bGG.getLayoutManager() instanceof LinearLayoutManager)) {
                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) bGG.getLayoutManager();
                                        if (!canScrollVertically2 && canScrollVertically) {
                                            if (VideoPbFragment.this.iHI != -1 || VideoPbFragment.this.iHJ != Integer.MIN_VALUE) {
                                                if (VideoPbFragment.this.iHI > 3 || (VideoPbFragment.this.iHI == 3 && VideoPbFragment.this.iHJ < (-equipmentHeight))) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iHI, VideoPbFragment.this.iHJ + equipmentHeight);
                                                    bGG.smoothScrollBy(0, equipmentHeight);
                                                } else if (VideoPbFragment.this.iHI >= 2) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iHI, VideoPbFragment.this.iHJ + (equipmentHeight / 2));
                                                    bGG.smoothScrollBy(0, equipmentHeight / 2);
                                                } else if (VideoPbFragment.this.iHI == 1) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iHI, VideoPbFragment.this.iHJ + (equipmentHeight / 4));
                                                    bGG.smoothScrollBy(0, equipmentHeight / 4);
                                                } else {
                                                    bGG.smoothScrollBy(0, -VideoPbFragment.this.iHJ);
                                                }
                                                cy.X("obj_locate", 2);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            int firstVisiblePosition = bGG.getFirstVisiblePosition();
                                            View childAt = bGG.getChildAt(0);
                                            int top2 = childAt == null ? 0 : childAt.getTop();
                                            VideoPbFragment.this.iHI = firstVisiblePosition;
                                            VideoPbFragment.this.iHJ = top2;
                                            if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top2 < (-equipmentHeight) && bGG.getCount() >= 6)) {
                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                bGG.smoothScrollToPosition(0);
                                            } else {
                                                bGG.smoothScrollToPosition(0);
                                            }
                                            cy.X("obj_locate", 1);
                                        }
                                        TiebaStatic.log(cy);
                                        TiebaStatic.log(new an("c12942").X("obj_type", 1).X("obj_locate", 4).cy("tid", VideoPbFragment.this.clC().cnz()));
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (VideoPbFragment.this.clC() != null && VideoPbFragment.this.clC().getPbData() != null && VideoPbFragment.this.clC().getPbData().ckv() != null && VideoPbFragment.this.clC().getPbData().ckv().aCo() != null) {
                                TiebaStatic.log(new an("c13402").cy("tid", VideoPbFragment.this.clC().cnz()).cy("fid", VideoPbFragment.this.clC().getPbData().getForumId()).X("obj_locate", 2).cy("uid", VideoPbFragment.this.clC().getPbData().ckv().aCo().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.qR(false);
                        VideoPbFragment.this.cmA();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.iIp >= 0) {
                        if (VideoPbFragment.this.clC() != null) {
                            VideoPbFragment.this.clC().coj();
                        }
                        if (VideoPbFragment.this.clC() != null && VideoPbFragment.this.csU() != null && VideoPbFragment.this.csU().ctG() != null) {
                            VideoPbFragment.this.csU().ctG().setData(VideoPbFragment.this.clC().getPbData());
                        }
                        VideoPbFragment.this.iIp = 0;
                        VideoPbFragment.this.iYT = Integer.MIN_VALUE;
                        if (VideoPbFragment.this.clC() != null && VideoPbFragment.this.csU() != null) {
                            VideoPbFragment.this.csU().cu(VideoPbFragment.this.clC().com(), VideoPbFragment.this.clC().con());
                            VideoPbFragment.this.clC().cr(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.clC() != null) {
                        an anVar5 = new an("c13398");
                        anVar5.cy("tid", VideoPbFragment.this.clC().cnz());
                        anVar5.cy("fid", VideoPbFragment.this.clC().getForumId());
                        anVar5.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar5.X("obj_locate", 2);
                        TiebaStatic.log(anVar5);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bc.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.aFD().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.cpl();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.cpl();
                }
            }
        }
    };
    private View.OnClickListener iFe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.iYR != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.iYR.b(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.iYR.cA(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.iYR.b(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.iYR.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private a iYS = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void cmL() {
        if (clC() != null && clC().getPbData() != null && clC().getPbData().ckv() != null) {
            bj ckv = clC().getPbData().ckv();
            ckv.mRecomAbTag = clC().cot();
            ckv.mRecomWeight = clC().cor();
            ckv.mRecomSource = clC().cos();
            ckv.mRecomExtra = clC().cou();
            if (ckv.getFid() == 0) {
                ckv.setFid(com.baidu.adp.lib.f.b.toLong(clC().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), ckv, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmE() {
        if (clC() != null && clC().getPbData() != null && clC().getPbData().ckv() != null) {
            bj ckv = clC().getPbData().ckv();
            ckv.mRecomAbTag = clC().cot();
            ckv.mRecomWeight = clC().cor();
            ckv.mRecomSource = clC().cos();
            ckv.mRecomExtra = clC().cou();
            if (ckv.getFid() == 0) {
                ckv.setFid(com.baidu.adp.lib.f.b.toLong(clC().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), ckv, "c13563");
            if (a2 != null) {
                a2.X("reply_type", 1);
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
            String string = !TextUtils.isEmpty(bVar.kju) ? bVar.kju : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.sS(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.fG(true);
                aVar.b(getPageContext());
                aVar.aEC();
            } else {
                a(0, bVar.mSuccess, bVar.kju, z);
            }
            if (bVar.mSuccess) {
                if (bVar.fYk == 1) {
                    ArrayList<PostData> ckx = clC().getPbData().ckx();
                    int size = ckx.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(ckx.get(i).getId())) {
                            i++;
                        } else {
                            ckx.remove(i);
                            break;
                        }
                    }
                    clC().getPbData().ckv().jJ(clC().getPbData().ckv().aCf() - 1);
                    if (csU() != null) {
                        csU().ctF();
                    }
                } else if (bVar.fYk == 0) {
                    cmM();
                } else if (bVar.fYk == 2) {
                    ArrayList<PostData> ckx2 = clC().getPbData().ckx();
                    int size2 = ckx2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= ckx2.get(i2).cKY().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(ckx2.get(i2).cKY().get(i3).getId())) {
                                i3++;
                            } else {
                                ckx2.get(i2).cKY().remove(i3);
                                ckx2.get(i2).cLa();
                                z2 = true;
                                break;
                            }
                        }
                        ckx2.get(i2).Jc(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3 && csU() != null) {
                        csU().ctF();
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = clC().getPbData().ckG().iDe;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cKY().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cKY().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cKY().remove(i2);
                    list.get(i).cLa();
                    z = true;
                    break;
                }
            }
            list.get(i).Jc(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2 && csU() != null) {
            csU().ctF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && clC() != null && clC().getPbData() != null && clC().getPbData().ckv() != null) {
            a(this.fKL.getLoadDataMode(), gVar.mSuccess, gVar.kju, false);
            if (gVar.mSuccess) {
                this.iHQ = true;
                if (i == 2 || i == 3) {
                    this.iHR = true;
                    this.iHS = false;
                } else if (i == 4 || i == 5) {
                    this.iHR = false;
                    this.iHS = true;
                }
                if (i == 2) {
                    clC().getPbData().ckv().jM(1);
                    clC().setIsGood(1);
                } else if (i == 3) {
                    clC().getPbData().ckv().jM(0);
                    clC().setIsGood(0);
                } else if (i == 4) {
                    clC().getPbData().ckv().jL(1);
                    clC().yQ(1);
                } else if (i == 5) {
                    clC().getPbData().ckv().jL(0);
                    clC().yQ(0);
                }
            }
            if (clC().getPbData().ckv() != null && csV() != null) {
                csV().ctC();
            }
        }
    }

    private void cmM() {
        if (clC().cnB() || clC().cnD()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", clC().cnz());
            PbActivity pbActivity = this.iHn;
            PbActivity pbActivity2 = this.iHn;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, clC().cnz()));
        if (cmP()) {
            this.iHn.finish();
        }
    }

    private boolean cmP() {
        if (clC() == null) {
            return true;
        }
        if (clC().getPbData() == null || !clC().getPbData().ckT()) {
            if (clC().ayL()) {
                final MarkData cnS = clC().cnS();
                if (cnS == null || !clC().getIsFromMark() || bGG() == null) {
                    return true;
                }
                final MarkData yX = clC().yX(bGG().getFirstVisiblePosition());
                if (yX == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cnS);
                    this.iHn.setResult(-1, intent);
                    return true;
                } else if (yX.getPostId() == null || yX.getPostId().equals(cnS.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cnS);
                    this.iHn.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.sS(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.iHN != null) {
                                if (VideoPbFragment.this.iHN.ayL()) {
                                    VideoPbFragment.this.iHN.ayM();
                                    VideoPbFragment.this.iHN.fm(false);
                                }
                                VideoPbFragment.this.iHN.a(yX);
                                VideoPbFragment.this.iHN.fm(true);
                                VideoPbFragment.this.iHN.ayN();
                            }
                            cnS.setPostId(yX.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cnS);
                            VideoPbFragment.this.iHn.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.clP();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cnS);
                            VideoPbFragment.this.iHn.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.clP();
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.aEC();
                    return false;
                }
            } else if (clC().getPbData() == null || clC().getPbData().ckx() == null || clC().getPbData().ckx().size() <= 0 || !clC().getIsFromMark()) {
                return true;
            } else {
                this.iHn.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clP() {
        this.iHn.clP();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void qQ(boolean z) {
        com.baidu.tieba.pb.data.e pbData;
        int i;
        if (clC() != null && this.iYR != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = clC().getPbData()) != null) {
                bj ckv = pbData.ckv();
                if (ckv != null && ckv.aCo() != null) {
                    TiebaStatic.log(new an("c13402").cy("tid", clC().cnz()).cy("fid", pbData.getForumId()).X("obj_locate", 4).cy("uid", ckv.aCo().getUserId()));
                }
                if (ckv != null) {
                    if (ckv.aBd()) {
                        i = 2;
                    } else if (ckv.aBe()) {
                        i = 3;
                    } else if (ckv.aEg()) {
                        i = 4;
                    } else if (ckv.aEh()) {
                        i = 5;
                    }
                    an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    anVar.cy("tid", clC().cnz());
                    anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cy("fid", clC().getForumId());
                    if (!z) {
                        anVar.X("obj_locate", 6);
                    } else {
                        anVar.X("obj_locate", 5);
                    }
                    anVar.X("obj_name", i);
                    anVar.X("obj_type", 2);
                    if (ckv != null) {
                        if (ckv.aBd()) {
                            anVar.X("obj_type", 10);
                        } else if (ckv.aBe()) {
                            anVar.X("obj_type", 9);
                        } else if (ckv.aEh()) {
                            anVar.X("obj_type", 8);
                        } else if (ckv.aEg()) {
                            anVar.X("obj_type", 7);
                        } else if (ckv.isShareThread) {
                            anVar.X("obj_type", 6);
                        } else if (ckv.threadType == 0) {
                            anVar.X("obj_type", 1);
                        } else if (ckv.threadType == 40) {
                            anVar.X("obj_type", 2);
                        } else if (ckv.threadType == 49) {
                            anVar.X("obj_type", 3);
                        } else if (ckv.threadType == 54) {
                            anVar.X("obj_type", 4);
                        } else {
                            anVar.X("obj_type", 5);
                        }
                    }
                    if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    TiebaStatic.log(anVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (clC().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> ckx = pbData.ckx();
                        if ((ckx == null || ckx.size() <= 0) && clC().cnA()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.iYR.cpZ();
                        bEl();
                        TiebaStatic.log(new an("c11939"));
                        if (!AntiHelper.d(getContext(), ckv)) {
                            if (this.iON != null) {
                                this.iON.setEnable(false);
                                t(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                yP(z ? 2 : 1);
                                return;
                            }
                            this.iYR.showLoadingDialog();
                            clC().cod().t(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.cy("tid", clC().cnz());
                anVar2.cy("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.cy("fid", clC().getForumId());
                if (!z) {
                }
                anVar2.X("obj_name", i);
                anVar2.X("obj_type", 2);
                if (ckv != null) {
                }
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                TiebaStatic.log(anVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment csA() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        G(eVar.ctg());
        H(eVar.ctg());
        if (clC() != null && clC().getPbData() != null) {
            boolean isFromMark = clC().getIsFromMark();
            com.baidu.tieba.pb.data.e pbData = clC().getPbData();
            if (isFromMark) {
                PostData F = F(pbData);
                if (pbData.ayK() != null && !pbData.ayK().equals(F.getId()) && this.cYb != null) {
                    this.cYb.setCurrentItem(iYy);
                }
            }
        }
        eVar.cth().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aM */
            public void onChanged(@Nullable bj bjVar) {
                if (bjVar != null && bjVar.aCF() != null) {
                    if (VideoPbFragment.this.iYF.getVideoUrl() == null || !VideoPbFragment.this.iYF.getVideoUrl().equals(bjVar.aCF().video_url)) {
                        if (!aq.isEmpty(VideoPbFragment.this.iYF.getVideoUrl())) {
                            VideoPbFragment.this.iHA = true;
                            VideoPbFragment.this.cYb.setCurrentItem(VideoPbFragment.iYx);
                        }
                        if (VideoPbFragment.this.iYG == null || !VideoPbFragment.this.iYG.isPlaying()) {
                            VideoPbFragment.this.csB();
                            VideoPbFragment.this.aL(bjVar);
                        }
                        VideoPbFragment.this.csC();
                        if (VideoPbFragment.this.iYG.ctu()) {
                            VideoPbFragment.this.iYG.start();
                        }
                        boolean z = !aq.equals(VideoPbFragment.this.iYF.getVideoUrl(), bjVar.aCF().video_url);
                        VideoPbFragment.this.iYF.setData(bjVar);
                        VideoPbFragment.this.iYF.ctR();
                        VideoPbFragment.this.iYF.qZ(VideoPbFragment.this.cYb.getCurrentItem() == 0);
                        if (z) {
                            VideoPbFragment.this.iYF.startPlay();
                            VideoPbFragment.this.iYF.cua();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.iYF.setData(bjVar);
                }
            }
        });
        eVar.ctq().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: p */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.cYb.setCurrentItem(num.intValue());
            }
        });
        eVar.ctl().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aM */
            public void onChanged(@Nullable bj bjVar) {
                VideoPbFragment.this.iYF.aQ(bjVar);
            }
        });
        eVar.ctm().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aM */
            public void onChanged(@Nullable bj bjVar) {
                VideoPbFragment.this.iYF.aR(bjVar);
            }
        });
        eVar.ctn().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.csN();
            }
        });
        eVar.cto().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csB() {
        ViewGroup.LayoutParams layoutParams = this.iYI.getLayoutParams();
        layoutParams.height = 0;
        this.iYI.setLayoutParams(layoutParams);
        this.iYI.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csC() {
        if (this.iYG == null) {
            this.iYG = new f(getBaseFragmentActivity(), this.iYE);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(cnj()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.iYE.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.iYG.b(eVar.cti(), rect);
            if (this.iYG.ctu()) {
                this.iYG.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (eVar.ctj() || VideoPbFragment.this.clC().getTabIndex() == VideoPbFragment.iYy) {
                            VideoPbFragment.this.cYb.setCurrentItem(VideoPbFragment.iYy);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (eVar.ctj() || VideoPbFragment.this.clC().getTabIndex() == VideoPbFragment.iYy) {
                            VideoPbFragment.this.cYb.setCurrentItem(VideoPbFragment.iYy);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (eVar.ctj() || clC().getTabIndex() == iYy) {
                this.cYb.setCurrentItem(iYy);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.iYX && (this.iYY || cta())) {
            csZ();
            UtilHelper.hideStatusBar(cnj(), cnj().getRootView());
            this.iYY = false;
            if (this.iYF != null) {
                this.iYF.qS(false);
            }
        }
        if (i == 4) {
            return this.iYF.onBackPress();
        }
        if (i == 24) {
            return this.iYF.ctW();
        }
        if (i == 25) {
            return this.iYF.ctX();
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
    public void aL(bj bjVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        CoordinatorLayout.LayoutParams layoutParams3;
        Rect cov;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bjVar != null && bjVar.aCF() != null) {
            int intValue = bjVar.aCF().video_width.intValue();
            int intValue2 = bjVar.aCF().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (clC() != null || (cov = clC().cov()) == null) ? ceil : cov.height();
                i = 0;
                layoutParams = this.iYE.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.iYE.setLayoutParams(layoutParams);
                this.iYE.setMaxHeight(ceil);
                this.iYE.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.iYE.setOriginHeight(height);
                layoutParams2 = (RelativeLayout.LayoutParams) this.iYA.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, iYz);
                } else {
                    layoutParams2.height = iYz;
                }
                this.iYA.setLayoutParams(layoutParams2);
                layoutParams3 = (CoordinatorLayout.LayoutParams) this.CD.getLayoutParams();
                int i2 = ceil + iYz;
                if (layoutParams3 != null) {
                    layoutParams3 = new CoordinatorLayout.LayoutParams(-1, i2);
                } else {
                    layoutParams3.height = i2;
                }
                this.CD.setLayoutParams(layoutParams3);
                if (i == 0 && (this.CD.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.CD.getLayoutParams()).getBehavior();
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
        if (clC() != null) {
        }
        i = 0;
        layoutParams = this.iYE.getLayoutParams();
        if (layoutParams != null) {
        }
        this.iYE.setLayoutParams(layoutParams);
        this.iYE.setMaxHeight(ceil2);
        this.iYE.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.iYE.setOriginHeight(height);
        layoutParams2 = (RelativeLayout.LayoutParams) this.iYA.getLayoutParams();
        if (layoutParams2 != null) {
        }
        this.iYA.setLayoutParams(layoutParams2);
        layoutParams3 = (CoordinatorLayout.LayoutParams) this.CD.getLayoutParams();
        int i22 = ceil2 + iYz;
        if (layoutParams3 != null) {
        }
        this.CD.setLayoutParams(layoutParams3);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.iHu = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        ak(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.iIj = new com.baidu.tbadk.core.view.d();
        this.iIj.toastTime = 1000L;
        if (this.iYR != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.iYR.iIk;
            userMuteAddAndDelCustomMessage.setTag(this.iYR.iIk);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.iYR.iIk;
            userMuteCheckCustomMessage.setTag(this.iYR.iIk);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        com.baidu.tieba.s.c.cKb().w(getUniqueId());
    }

    private void initData() {
        this.iHN = com.baidu.tbadk.baseEditMark.a.a(this.iHn);
        if (this.iHN != null) {
            this.iHN.a(this.iIQ);
        }
        this.fKL = new ForumManageModel(this.iHn);
        this.fKL.setLoadDataCallBack(this.fKQ);
        this.dac = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.iYR = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void ak(Bundle bundle) {
        this.iIb = new g();
        d(this.iIb);
        this.iIc = (com.baidu.tbadk.editortools.pb.e) this.iIb.dV(getActivity());
        this.iIc.a(this.iHn.getPageContext());
        this.iIc.a(this.dyN);
        this.iIc.a(this.dyG);
        this.iIc.a(this.iHn.getPageContext(), bundle);
        this.iIc.aOu().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.iIc.aOu().gB(true);
        pK(true);
        this.iIc.a(clC().cnO(), clC().cnz(), clC().cof());
        registerListener(this.iIz);
        registerListener(this.iIP);
        registerListener(this.iIy);
        registerListener(this.iIw);
        registerListener(this.gpK);
        if (!clC().cnF()) {
            this.iIc.vm(clC().cnz());
        }
        if (clC().cog()) {
            this.iIc.vl(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.iIc.vl(cpn());
        }
        this.iHT = new ap();
        if (this.iIc.aOT() != null) {
            this.iHT.e(this.iIc.aOT().getInputView());
        }
        this.iIc.a(this.dyH);
        this.hPK = new aj(getPageContext());
        this.hPK.a(new aj.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
            @Override // com.baidu.tbadk.core.util.aj.a
            public void l(boolean z, int i) {
                if (z) {
                    if (i == aj.cZX) {
                        VideoPbFragment.this.iIc.a((String) null, (WriteData) null);
                    } else if (i == aj.cZY && VideoPbFragment.this.iPo != null && VideoPbFragment.this.iPo.cmo() != null) {
                        VideoPbFragment.this.iPo.cmo().aPp();
                    } else if (i == aj.cZZ) {
                        VideoPbFragment.this.c(VideoPbFragment.this.iIf);
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
        this.gsB = new com.baidu.tieba.f.b(getActivity());
        this.gsB.a(iIY);
        this.iYX = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        bcK();
        this.CD = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.iYC = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.iYE = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.iYF = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.iYE);
        this.iYF.setUniqueId(getUniqueId());
        this.iYF.ad(this);
        this.iYF.cH(cnj().getRootView());
        this.iYF.cI(this.iYH);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.iYA = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.iYI = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.cYb = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.iYD = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.iYD.setOnClickListener(this.auY);
        csE();
        csD();
        csF();
        this.iYB = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.cYb.setAdapter(this.iYB);
        this.iYA.setViewPager(this.cYb);
        this.iYA.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (VideoPbFragment.this.csU() != null) {
                        VideoPbFragment.this.csU().qY(false);
                    }
                    if (VideoPbFragment.this.csV() != null) {
                        VideoPbFragment.this.csV().qY(true);
                        VideoPbFragment.this.zv(VideoPbFragment.this.csV().ctE() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.ctn() != null && eVar.ctn().getValue() != null && eVar.ctn().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.iYF.qZ(z);
                    VideoPbFragment.this.cpl();
                    if (VideoPbFragment.this.clC() != null && VideoPbFragment.this.clC().getPbData() != null) {
                        TiebaStatic.log(new an("c13592").cy("tid", VideoPbFragment.this.clC().cnz()).cy("fid", VideoPbFragment.this.clC().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.csV() != null) {
                        VideoPbFragment.this.csV().qY(false);
                    }
                    if (VideoPbFragment.this.csU() != null) {
                        VideoPbFragment.this.csU().qY(true);
                        int ctE = VideoPbFragment.this.csU().ctE();
                        int ctJ = VideoPbFragment.this.csU().ctJ();
                        if (ctE != 0) {
                            VideoPbFragment.this.zv(8);
                            VideoPbFragment.this.csU().zv(0);
                        } else if (ctJ != 0) {
                            VideoPbFragment.this.csU().zv(8);
                            VideoPbFragment.this.zv(0);
                        } else {
                            VideoPbFragment.this.csU().zv(8);
                            VideoPbFragment.this.zv(8);
                        }
                    }
                    VideoPbFragment.this.iYF.qZ(false);
                    VideoPbFragment.this.CD.setExpanded(false, true);
                    if (VideoPbFragment.this.clC() != null && VideoPbFragment.this.clC().getPbData() != null) {
                        TiebaStatic.log(new an("c13593").cy("tid", VideoPbFragment.this.clC().cnz()).cy("fid", VideoPbFragment.this.clC().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.iYB.zx(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.iOr = this.rootView.findViewById(R.id.viewstub_progress);
        csG();
        csH();
        if (!this.iYX && this.iYY) {
            csZ();
            UtilHelper.hideStatusBar(cnj(), cnj().getRootView());
            this.iYY = false;
        }
    }

    private void csD() {
        this.iYK = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.iYO = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.iYL = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.iYM = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.iYN = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.iYO.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iYO.setConrers(15);
        this.iYN.setConfig(new com.baidu.tbadk.core.view.commonBtn.d());
        this.iYM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c13591"));
                VideoPbFragment.this.csP();
            }
        });
        this.iYN.setOnClickListener(this.iYJ);
        this.iYI.setOnClickListener(this.iYJ);
    }

    private void csE() {
        this.iYA.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.iYA.setContainerLayoutParams(layoutParams);
        this.iYA.setRectPaintColor(R.color.cp_link_tip_a);
        this.iYA.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.iYA.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.iYA.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.iYA.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.iYA.setExpandedTabLayoutParams(layoutParams2);
    }

    public void qR(boolean z) {
        if (this.CD != null) {
            this.CD.setExpanded(z);
        }
    }

    private void csF() {
        this.iOI = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.iOJ = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.iOQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iOR = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.hgY = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.hgY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.qR(false);
                VideoPbFragment.this.cmA();
                if (VideoPbFragment.this.clC() != null && VideoPbFragment.this.clC().getPbData() != null && VideoPbFragment.this.clC().getPbData().ckv() != null && VideoPbFragment.this.clC().getPbData().ckv().aCo() != null) {
                    TiebaStatic.log(new an("c13402").cy("tid", VideoPbFragment.this.clC().cnz()).cy("fid", VideoPbFragment.this.clC().getPbData().getForumId()).X("obj_locate", 1).cy("uid", VideoPbFragment.this.clC().getPbData().ckv().aCo().getUserId()));
                }
            }
        });
        this.iOK = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.iOK.setOnClickListener(this.auY);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.iOL = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.iOL.setOnClickListener(this.auY);
        if (booleanExtra) {
            this.iOL.setVisibility(8);
        } else {
            this.iOL.setVisibility(0);
        }
        this.iOM = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.iOM.setOnClickListener(this.auY);
        this.iON = new com.baidu.tieba.pb.view.c(this.iOM);
        this.iON.cuk();
        this.iOO = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        qr(false);
    }

    private void bcK() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.bEm();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.iYH = this.rootView.findViewById(R.id.status_bar_background);
        if (this.iYX) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(cnj());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.iYH.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(cnj());
            this.iYH.setLayoutParams(layoutParams2);
            this.iYH.setVisibility(0);
        }
        this.dFX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.auY);
        this.eEJ = (ImageView) this.dFX.findViewById(R.id.widget_navi_back_button);
        SvgManager.aGC().a(this.eEJ, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iUa = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.auY);
        this.Lb = (ImageView) this.iUa.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.iUa.setLayoutParams(layoutParams3);
        SvgManager.aGC().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iUa.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.iZa);
        this.mNavigationBar.setOnTouchListener(this.iYZ);
    }

    public void csG() {
        setEditorTools(this.iIc.aOu());
    }

    private void csH() {
        this.iHk = new PbFakeFloorModel(getPageContext());
        this.iPo = new s(getPageContext(), this.iHk, this.rootView);
        this.iPo.a(this.iIM);
        this.iHk.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                VideoPbFragment.this.iHk.q(postData);
                if (VideoPbFragment.this.csU() != null) {
                    VideoPbFragment.this.csU().ctF();
                }
                VideoPbFragment.this.iPo.cmk();
                VideoPbFragment.this.FO.aMR();
                VideoPbFragment.this.qr(false);
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.iHn = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (clC() != null) {
            clC().au(bundle);
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
        this.isPaused = true;
        getVoiceManager().onPause(getPageContext());
        this.iYF.mL(true);
        if (clC() != null && !clC().cnF()) {
            this.iIc.saveDraft(clC().cnz());
        }
        com.baidu.tbadk.BdToken.c.axz().axE();
        MessageManager.getInstance().unRegisterListener(this.iII);
        MessageManager.getInstance().unRegisterListener(this.iIJ);
        MessageManager.getInstance().unRegisterListener(this.iIK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        getVoiceManager().onResume(getPageContext());
        this.iYF.mL(false);
        cnf();
        registerListener(this.iII);
        registerListener(this.iIJ);
        registerListener(this.iIK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.iYB != null && this.cYb != null) {
            this.iYB.zx(z ? this.cYb.getCurrentItem() : -1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.cKb().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.cKb().x(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.iON != null) {
            this.iON.onDestroy();
        }
        if (this.fKL != null) {
            this.fKL.cancelLoadData();
        }
        if (this.iYF != null) {
            this.iYF.onDestroy();
        }
        if (this.iHE != null) {
            this.iHE.cancelLoadData();
        }
        if (this.hPK != null) {
            this.hPK.onDestroy();
        }
        if (clC() != null) {
            clC().cancelLoadData();
            clC().destory();
            if (clC().coc() != null) {
                clC().coc().onDestroy();
            }
        }
        if (this.iIc != null) {
            this.iIc.onDestroy();
        }
        this.iIj = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.iHn);
        this.iYA.onChangeSkinType();
        am.setBackgroundColor(this.iYA, R.color.cp_bg_line_h);
        this.iHT.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.iYG == null || !this.iYG.isPlaying()) {
            am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        am.setBackgroundColor(this.iYH, R.color.cp_mask_b_alpha66);
        if (this.FO != null) {
            this.FO.onChangeSkinType(i);
        }
        if (this.iPo != null) {
            this.iPo.onChangeSkinType(i);
        }
        if (this.hgY != null) {
            am.setViewTextColor(this.hgY, (int) R.color.cp_cont_d);
            this.hgY.setBackgroundDrawable(am.ay(l.getDimens(getContext(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
        }
        if (this.iOL != null && clC() != null) {
            if (clC().ayL()) {
                SvgManager.aGC().a(this.iOL, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aGC().a(this.iOL, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.iOK != null) {
            SvgManager.aGC().a(this.iOK, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (clC() != null) {
            t(clC().getPbData());
        }
        am.setViewTextColor(this.iOO, (int) R.color.cp_cont_b);
        if (this.iOI != null) {
            am.setBackgroundResource(this.iOI, R.drawable.bottom_shadow);
        }
        am.setBackgroundColor(this.iOJ, R.color.cp_bg_line_h);
        if (csU() != null) {
            csU().onChangeSkinType(i);
        }
        if (csV() != null) {
            csV().onChangeSkinType(i);
        }
        if (this.iYC != null) {
            am.setBackgroundResource(this.iYC, R.drawable.personalize_tab_shadow);
        }
        if (this.iYI != null) {
            am.setBackgroundColor(this.iYI, R.color.cp_bg_line_g);
        }
        if (this.iYM != null) {
            SvgManager.aGC().a(this.iYM, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iYK != null) {
            am.setViewTextColor(this.iYK, (int) R.color.cp_cont_b);
        }
        if (this.iYL != null) {
            am.setViewTextColor(this.iYL, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.goy == null) {
            this.goy = VoiceManager.instance();
        }
        return this.goy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEl() {
        if (this.goy != null) {
            this.goy.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cnh() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cni() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel clC() {
        return this.iHn.clC();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cnj() {
        return this.iHn;
    }

    public com.baidu.tbadk.baseEditMark.a csI() {
        return this.iHN;
    }

    public View.OnClickListener csJ() {
        return this.auY;
    }

    public View.OnClickListener csK() {
        return this.iFe;
    }

    public View.OnLongClickListener csL() {
        return this.iYR.csL();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (as.Gi(objArr[i].getLink()) && (drawable = am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.c(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 33);
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

    public BdTypeRecyclerView bGG() {
        Iterator<BaseFragment> it = this.iYB.cte().iterator();
        while (it.hasNext()) {
            BaseFragment next = it.next();
            if (next instanceof ReplyFragment) {
                return ((ReplyFragment) next).getListView();
            }
        }
        return null;
    }

    private void pK(boolean z) {
        this.iIc.gF(z);
        this.iIc.gG(z);
        this.iIc.gH(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.iYR != null) {
            if (z) {
                this.iYR.cpZ();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.iYR.cqa();
            } else {
                this.iYR.cpZ();
            }
        }
    }

    public boolean yN(int i) {
        if (this.hPK == null || clC() == null || clC().getPbData() == null || clC().getPbData().getAnti() == null) {
            return true;
        }
        return this.hPK.ax(clC().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean cmC() {
        if ((clC() != null && clC().getPbData().ckT()) || this.hPK == null || clC() == null || clC().getPbData() == null || clC().getPbData().getAnti() == null) {
            return true;
        }
        return this.hPK.ks(clC().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && clC() != null) {
            gVar.setForumName(clC().clt());
            if (clC().getPbData() != null && clC().getPbData().getForum() != null) {
                gVar.a(clC().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(clC());
        }
    }

    public void cpB() {
        if (this.FO != null) {
            this.FO.display();
            if (this.iIc != null) {
                this.iIc.aOX();
            }
            cqj();
        }
    }

    private boolean cmz() {
        PbModel clC = clC();
        if (clC == null || clC.getPbData() == null) {
            return false;
        }
        bj ckv = clC.getPbData().ckv();
        clC.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), ckv);
    }

    public void cmA() {
        if (checkUpIsLogin() && clC() != null && clC().getPbData() != null && clC().getPbData().getForum() != null && !cmz()) {
            if (clC().getPbData().ckT()) {
                bPy();
                return;
            }
            if (this.grZ == null) {
                this.grZ = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.grZ.tP(0);
                this.grZ.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lw(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void t(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lx(boolean z) {
                        if (z) {
                            VideoPbFragment.this.bPy();
                        }
                    }
                });
            }
            this.grZ.C(clC().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(clC().cnz(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.iIc.onActivityResult(i, i2, intent);
        if (this.iHE != null) {
            this.iHE.onActivityResult(i, i2, intent);
        }
        if (this.iPo != null) {
            this.iPo.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cmN();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cCb().A(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.iIf = emotionImageData;
                        if (yN(aj.cZZ)) {
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
        if (cnj() != null) {
            if (this.iYY && !TbSingleton.getInstance().isNotchScreen(cnj()) && !TbSingleton.getInstance().isCutoutScreen(cnj())) {
                csZ();
                UtilHelper.hideStatusBar(cnj(), cnj().getRootView());
                this.iYY = false;
            }
            this.iYS.iZm = z;
            csM();
            csN();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.iHn;
        if (i == 0) {
            cph();
            if (this.iPo != null) {
                this.iPo.cmk();
            }
            qr(false);
        }
        cpl();
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
                        this.iIc.resetData();
                        this.iIc.setVoiceModel(pbEditorData.getVoiceModel());
                        this.iIc.b(writeData);
                        com.baidu.tbadk.editortools.l mp = this.iIc.aOu().mp(6);
                        if (mp != null && mp.dwN != null) {
                            mp.dwN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.iHn;
                        if (i == -1) {
                            this.iIc.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.iPo != null && this.iPo.cmo() != null) {
                            com.baidu.tbadk.editortools.pb.h cmo = this.iPo.cmo();
                            cmo.setThreadData(clC().getPbData().ckv());
                            cmo.b(writeData);
                            cmo.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l mp2 = cmo.aOu().mp(6);
                            if (mp2 != null && mp2.dwN != null) {
                                mp2.dwN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.iHn;
                            if (i == -1) {
                                cmo.aPp();
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
                if (clC() != null && !clC().cnF()) {
                    antiData.setBlock_forum_name(clC().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(clC().getPbData().getForum().getId());
                    antiData.setUser_name(clC().getPbData().getUserData().getUserName());
                    antiData.setUser_id(clC().getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bb(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.iYR != null) {
                this.iYR.vr(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void cnl() {
        if (clC() != null && this.iHn != null) {
            if (this.iIc == null || !this.iIc.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.iIc = (com.baidu.tbadk.editortools.pb.e) dVar.dV(getContext());
                this.iIc.a(this.iHn.getPageContext());
                this.iIc.a(this.dyN);
                this.iIc.a(this.dyG);
                this.iIc.a(this.iHn.getPageContext(), this.iHn.getIntent() == null ? null : this.iHn.getIntent().getExtras());
                this.iIc.aOu().gB(true);
                setEditorTools(this.iIc.aOu());
                if (!clC().cnF()) {
                    this.iIc.vm(clC().cnz());
                }
                if (clC().cog()) {
                    this.iIc.vl(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.iIc.vl(cpn());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
        this.FO.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.FO.getParent() == null) {
            this.rootView.addView(this.FO, layoutParams);
        }
        this.FO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.FO.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).aJx() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).aJx() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.iIc.c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            VideoPbFragment.this.iIc.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cph();
        this.iIc.b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.FO != null && VideoPbFragment.this.FO.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.iHT != null && VideoPbFragment.this.iHT.cqy() != null) {
                    if (!VideoPbFragment.this.iHT.cqy().cUg()) {
                        VideoPbFragment.this.iHT.qw(false);
                    }
                    VideoPbFragment.this.iHT.cqy().tH(false);
                }
            }
        });
    }

    public void bPy() {
        if (!checkUpIsLogin()) {
            if (clC() != null) {
                TiebaStatic.log(new an("c10517").X("obj_locate", 2).cy("fid", clC().getForumId()));
            }
        } else if (cmC()) {
            if (this.iIc != null && (this.iIc.aPh() || this.iIc.aPi())) {
                this.iIc.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.FO != null) {
                cpB();
                this.iYS.iZl = false;
                if (this.FO.mp(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.FO.mp(2).dwN, false, null);
                }
            }
            cqj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cmz() && cmC()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.iHG);
                this.iHH = ((View) view.getParent()).getMeasuredHeight();
            }
            if (clC() != null && clC().getPbData() != null && clC().getPbData().ckT()) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.iHn.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.bGG().smoothScrollBy(0, (VideoPbFragment.this.iHG[1] + VideoPbFragment.this.iHH) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.iPo != null) {
                            VideoPbFragment.this.iIc.aOu().setVisibility(8);
                            VideoPbFragment.this.iPo.g(str, str2, VideoPbFragment.this.cpn(), (VideoPbFragment.this.clC() == null || VideoPbFragment.this.clC().getPbData() == null || VideoPbFragment.this.clC().getPbData().ckv() == null || !VideoPbFragment.this.clC().getPbData().ckv().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cmo = VideoPbFragment.this.iPo.cmo();
                            if (cmo != null && VideoPbFragment.this.clC() != null && VideoPbFragment.this.clC().getPbData() != null) {
                                cmo.a(VideoPbFragment.this.clC().getPbData().getAnti());
                                cmo.setThreadData(VideoPbFragment.this.clC().getPbData().ckv());
                            }
                            if (VideoPbFragment.this.iHT.cqA() == null && VideoPbFragment.this.iPo.cmo().aPx() != null) {
                                VideoPbFragment.this.iPo.cmo().aPx().c(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.iHT != null && VideoPbFragment.this.iHT.cqz() != null) {
                                            if (!VideoPbFragment.this.iHT.cqz().cUg()) {
                                                VideoPbFragment.this.iHT.qx(false);
                                            }
                                            VideoPbFragment.this.iHT.cqz().tH(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.iHT.f(VideoPbFragment.this.iPo.cmo().aPx().getInputView());
                                VideoPbFragment.this.iPo.cmo().a(VideoPbFragment.this.iIh);
                            }
                        }
                        VideoPbFragment.this.cqj();
                    }
                }, 0L);
                return;
            }
            if (this.iIe == null) {
                this.iIe = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iIe.tP(1);
                this.iIe.a(new AnonymousClass43(str, str2));
            }
            if (clC() != null && clC().getPbData() != null && clC().getPbData().getForum() != null) {
                this.iIe.C(clC().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(clC().cnz(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$43  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass43 implements c.a {
        final /* synthetic */ String iJk;
        final /* synthetic */ String iJl;

        AnonymousClass43(String str, String str2) {
            this.iJk = str;
            this.iJl = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lw(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void t(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lx(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.bGG().smoothScrollBy(0, (VideoPbFragment.this.iHG[1] + VideoPbFragment.this.iHH) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.iPo != null) {
                            VideoPbFragment.this.iIc.aOu().setVisibility(8);
                            VideoPbFragment.this.iPo.g(AnonymousClass43.this.iJk, AnonymousClass43.this.iJl, VideoPbFragment.this.cpn(), (VideoPbFragment.this.clC() == null || VideoPbFragment.this.clC().getPbData() == null || VideoPbFragment.this.clC().getPbData().ckv() == null || !VideoPbFragment.this.clC().getPbData().ckv().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cmo = VideoPbFragment.this.iPo.cmo();
                            if (cmo != null && VideoPbFragment.this.clC() != null && VideoPbFragment.this.clC().getPbData() != null) {
                                cmo.a(VideoPbFragment.this.clC().getPbData().getAnti());
                                cmo.setThreadData(VideoPbFragment.this.clC().getPbData().ckv());
                            }
                            if (VideoPbFragment.this.iHT.cqA() == null && VideoPbFragment.this.iPo.cmo().aPx() != null) {
                                VideoPbFragment.this.iPo.cmo().aPx().c(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.iHT != null && VideoPbFragment.this.iHT.cqz() != null) {
                                            if (!VideoPbFragment.this.iHT.cqz().cUg()) {
                                                VideoPbFragment.this.iHT.qx(false);
                                            }
                                            VideoPbFragment.this.iHT.cqz().tH(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.iHT.f(VideoPbFragment.this.iPo.cmo().aPx().getInputView());
                                VideoPbFragment.this.iPo.cmo().a(VideoPbFragment.this.iIh);
                            }
                        }
                        VideoPbFragment.this.cqj();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        PostData F;
        w wVar;
        StringBuilder sb = null;
        if (eVar != null && (F = F(eVar)) != null) {
            String userId = F.aCo().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, F.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.ckH()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (F.aCo() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, F.aCo().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, F.aCo().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, F.aCo().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, F.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, F.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.ckH()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bf> ckO = eVar.ckO();
                if (v.getCount(ckO) > 0) {
                    sb = new StringBuilder();
                    for (bf bfVar : ckO) {
                        if (bfVar != null && !StringUtils.isNull(bfVar.getForumName()) && (wVar = bfVar.cQQ) != null && wVar.cOK && !wVar.cOL && (wVar.type == 1 || wVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bfVar.getForumName(), 12)).append(TbadkCoreApplication.getInst().getString(R.string.forum)).append("、");
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
    public void cmN() {
        MarkData yX;
        if (clC() != null && clC().getPbData() != null && csU() != null && this.iHN != null) {
            if (clC().getPbData() != null && clC().getPbData().ckT()) {
                yX = clC().yX(0);
            } else if (this.cYb != null && this.cYb.getCurrentItem() == iYx) {
                yX = clC().l(F(clC().getPbData()));
            } else {
                yX = clC().yX(csU().cpL());
            }
            if (yX != null) {
                if (!yX.isApp() || (yX = clC().yX(csU().cpL() + 1)) != null) {
                    cpG();
                    this.iHN.a(yX);
                    if (!this.iHN.ayL()) {
                        this.iHN.ayN();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.iHN.ayM();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yO(int i) {
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
            if (this.iHE == null) {
                this.iHE = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.iHn);
                this.iHE.b(this.dyG);
                this.iHE.c(this.dyN);
            }
            this.iHE.a(emotionImageData, clC(), clC().getPbData());
        }
    }

    public PostData F(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.ckF() != null) {
            return eVar.ckF();
        }
        if (!v.isEmpty(eVar.ckx())) {
            Iterator<PostData> it = eVar.ckx().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cLb() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.ckC();
        }
        if (postData == null) {
            postData = a(eVar);
        }
        if (postData != null && postData.aCo() != null && postData.aCo().getUserTbVipInfoData() != null && postData.aCo().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aCo().getGodUserData().setIntro(postData.aCo().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.ckv() == null || eVar.ckv().aCo() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aCo = eVar.ckv().aCo();
        String userId = aCo.getUserId();
        HashMap<String, MetaData> userMap = eVar.ckv().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aCo;
        }
        postData.Cw(1);
        postData.setId(eVar.ckv().aCE());
        postData.setTitle(eVar.ckv().getTitle());
        postData.setTime(eVar.ckv().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cmS() {
        ArrayList<PostData> ckx;
        int count;
        int i;
        if (clC() == null || clC().getPbData() == null || clC().getPbData().ckx() == null || (count = v.getCount((ckx = clC().getPbData().ckx()))) == 0) {
            return "";
        }
        if (clC().cnQ()) {
            Iterator<PostData> it = ckx.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cLb() == 1) {
                    return next.getId();
                }
            }
        }
        if (bGG() == null) {
            i = 0;
        } else {
            i = csU().cpK();
        }
        PostData postData = (PostData) v.getItem(ckx, i);
        if (postData == null || postData.aCo() == null) {
            return "";
        }
        if (clC().FW(postData.aCo().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) v.getItem(ckx, i2);
            if (postData2 == null || postData2.aCo() == null || postData2.aCo().getUserId() == null) {
                break;
            } else if (clC().FW(postData2.aCo().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) v.getItem(ckx, i3);
            if (postData3 == null || postData3.aCo() == null || postData3.aCo().getUserId() == null) {
                return "";
            }
            if (clC().FW(postData3.aCo().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmO() {
        if (clC() != null) {
            com.baidu.tieba.pb.data.e pbData = clC().getPbData();
            clC().pX(true);
            if (this.iHN != null) {
                pbData.FJ(this.iHN.ayK());
            }
            if (csU() != null) {
                csU().ctF();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (clC() != null) {
            cpI();
            clC().pX(z);
            if (this.iHN != null) {
                this.iHN.fm(z);
                if (markData != null) {
                    this.iHN.a(markData);
                }
            }
            if (clC().ayL()) {
                cmO();
            } else if (csU() != null) {
                csU().ctF();
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        MetaData metaData;
        boolean z = true;
        if (clC() != null && clC().getPbData() != null && lVar.clg() != null) {
            String id = lVar.clg().getId();
            ArrayList<PostData> ckx = clC().getPbData().ckx();
            int i = 0;
            while (true) {
                if (i >= ckx.size()) {
                    break;
                }
                PostData postData = ckx.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> clk = lVar.clk();
                    postData.Cv(lVar.getTotalCount());
                    if (postData.cKY() != null && clk != null) {
                        Iterator<PostData> it = clk.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aCo() != null && (metaData = postData.getUserMap().get(next.aCo().getUserId())) != null) {
                                next.a(metaData);
                                next.sO(true);
                                next.a(getPageContext(), clC().FW(metaData.getUserId()));
                            }
                        }
                        boolean z2 = clk.size() != postData.cKY().size();
                        postData.cKY().clear();
                        postData.cKY().addAll(clk);
                        z = z2;
                    }
                    if (postData.cKU() != null) {
                        postData.cKV();
                    }
                }
            }
            if (!clC().getIsFromMark() && z && csU() != null) {
                csU().ctF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmF() {
        if (clC() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.Ix(clC().getForumId()) && clC().getPbData() != null && clC().getPbData().getForum() != null) {
            if (clC().getPbData().getForum().isLike() == 1) {
                clC().coe().ev(clC().getForumId(), clC().cnz());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            bj ckv = eVar.ckv();
            if (ckv != null && ckv.aEi()) {
                cnl();
            } else {
                d(this.iIb);
            }
            if (this.iIc != null) {
                qp(this.iIc.aPa());
                this.iIc.a(eVar.getAnti());
                this.iIc.a(eVar.getForum(), eVar.getUserData());
                this.iIc.setThreadData(ckv);
                if (clC() != null) {
                    this.iIc.a(clC().cnO(), clC().cnz(), clC().cof());
                }
                if (ckv != null) {
                    this.iIc.gI(ckv.aDG());
                }
            }
        }
    }

    public void cpl() {
        reset();
        cph();
        this.iPo.cmk();
        qr(false);
    }

    private void reset() {
        if (this.iIc != null && this.FO != null) {
            com.baidu.tbadk.editortools.pb.a.aOQ().setStatus(0);
            this.iIc.aPk();
            this.iIc.aOE();
            if (this.iIc.getWriteImagesInfo() != null) {
                this.iIc.getWriteImagesInfo().setMaxImagesAllowed(this.iIc.isBJH ? 1 : 9);
            }
            this.iIc.mv(SendView.ALL);
            this.iIc.mw(SendView.ALL);
            com.baidu.tbadk.editortools.g mm = this.FO.mm(23);
            com.baidu.tbadk.editortools.g mm2 = this.FO.mm(2);
            com.baidu.tbadk.editortools.g mm3 = this.FO.mm(5);
            if (mm2 != null) {
                mm2.display();
            }
            if (mm3 != null) {
                mm3.display();
            }
            if (mm != null) {
                mm.hide();
            }
            this.FO.invalidate();
        }
    }

    public void q(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckv() != null) {
            t(eVar);
            if (eVar.ayL()) {
                SvgManager.aGC().a(this.iOL, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aGC().a(this.iOL, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.iOO.setText(zf(eVar.ckv().aCf()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.ckv()));
        }
    }

    public void t(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.aY(eVar.ckv())) {
            if (this.iON != null) {
                this.iON.setEnable(false);
                this.iON.onDestroy();
            }
            SvgManager.aGC().a(this.iOM, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.iON == null || !this.iON.isEnable()) {
            SvgManager.aGC().a(this.iOM, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private String zf(int i) {
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

    public void qr(boolean z) {
        if (this.iOJ != null) {
            qp(this.iIc.aPa());
            if (this.iOF) {
                qg(z);
            } else {
                qh(z);
            }
            csM();
            csN();
        }
    }

    public void cqj() {
        if (this.iOJ != null) {
            this.iOI.setVisibility(8);
            this.iOJ.setVisibility(8);
            this.iYS.iZl = false;
            csM();
            csN();
        }
    }

    private void csM() {
        if (this.iYF != null) {
            if (this.iYS.ctd()) {
                this.iYF.rQ(false);
            } else {
                this.iYF.rQ(this.iYF.bin() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csN() {
        if (this.iYF != null && this.cYb != null) {
            if (this.cYb.getCurrentItem() != 0) {
                this.iYF.qZ(false);
            } else if (this.iYS.ctd()) {
                this.iYF.qZ(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.iYF.qZ(eVar.ctn() == null || eVar.ctn().getValue() == null || eVar.ctn().getValue().booleanValue());
                }
            }
        }
    }

    private void yP(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(cnj(), cmD(), i);
    }

    private int cmD() {
        if (clC() == null || clC().getPbData() == null || clC().getPbData().ckv() == null) {
            return -1;
        }
        return clC().getPbData().ckv().aCY();
    }

    public void qp(boolean z) {
        this.iOF = z;
    }

    public void qg(boolean z) {
        if (this.iOJ != null && this.hgY != null) {
            this.hgY.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iOJ.startAnimation(alphaAnimation);
            }
            this.iOI.setVisibility(0);
            this.iOJ.setVisibility(0);
            this.iYS.iZl = true;
        }
    }

    public void qh(boolean z) {
        if (this.iOJ != null && this.hgY != null) {
            this.hgY.setText(cpn());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iOJ.startAnimation(alphaAnimation);
            }
            this.iOI.setVisibility(0);
            this.iOJ.setVisibility(0);
            this.iYS.iZl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null) {
            this.iCA = aVar;
            this.iYK.setText(aVar.getTitle());
            this.iYL.setText(aVar.ctK());
            String ctL = aVar.ctL();
            TBSpecificationBtn tBSpecificationBtn = this.iYN;
            if (TextUtils.isEmpty(ctL)) {
                ctL = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(ctL);
            this.iYO.startLoad(aVar.getImage(), 10, false);
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
                @Override // java.lang.Runnable
                public void run() {
                    TiebaStatic.log(new an("c13608").cy("obj_id", VideoPbFragment.this.iCA.getTitle()).cy("obj_name", VideoPbFragment.this.iCA.ctK()).X("obj_type", 2).cy("fid", VideoPbFragment.this.clC().getPbData().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("tid", VideoPbFragment.this.clC().getPbData().getThreadId()));
                    VideoPbFragment.this.csO();
                }
            }, aVar.ctM().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csO() {
        ViewGroup.LayoutParams layoutParams = this.iYI.getLayoutParams();
        if (layoutParams != null) {
            if (this.iYP == null || !this.iYP.isRunning()) {
                this.iYI.setAlpha(0.0f);
                this.iYI.setVisibility(0);
                f(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csP() {
        if (this.iYI.getLayoutParams() != null) {
            if (this.iYP == null || !this.iYP.isRunning()) {
                csQ();
            }
        }
    }

    private void csQ() {
        final ViewGroup.LayoutParams layoutParams = this.iYI.getLayoutParams();
        if (layoutParams != null) {
            if (this.iYQ == null || !this.iYQ.isRunning()) {
                this.iYQ = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.iYQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.iYI.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.iYQ.setDuration(200L);
                this.iYQ.start();
                this.iYQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
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
        final ViewGroup.LayoutParams layoutParams2 = this.CD.getLayoutParams();
        final int i = layoutParams2.height;
        this.iYP = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.iYP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.hfw);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.hfw);
                VideoPbFragment.this.iYI.setLayoutParams(layoutParams);
                VideoPbFragment.this.CD.setLayoutParams(layoutParams2);
            }
        });
        this.iYP.setDuration(300L);
        this.iYP.start();
        this.iYP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.iYI.setVisibility(8);
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
        final ViewGroup.LayoutParams layoutParams2 = this.CD.getLayoutParams();
        final int i = layoutParams2.height;
        this.iYP = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iYP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.hfw);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.iYI.setLayoutParams(layoutParams);
                VideoPbFragment.this.CD.setLayoutParams(layoutParams2);
            }
        });
        this.iYP.setDuration(300L);
        this.iYP.start();
        this.iYP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.csR();
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
    public void csR() {
        this.iYP = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iYP.setDuration(300L);
        this.iYP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.iYI.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.iYP.start();
    }

    public String cpn() {
        if (!aq.isEmpty(this.iPF)) {
            return this.iPF;
        }
        this.iPF = TbadkCoreApplication.getInst().getResources().getString(com.baidu.tieba.pb.pb.main.am.cpc());
        return this.iPF;
    }

    public void cpI() {
        hideProgressBar();
        if (csU() != null) {
            csU().endLoadData();
            csU().cpJ();
        }
    }

    public boolean ct(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && i.azO().isShowImages()) {
                    return FS(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (clC() == null || clC().getPbData() == null) {
                        return true;
                    }
                    if (this.iPo != null) {
                        this.iPo.cmk();
                    }
                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                    lVar.a(clC().getPbData().getForum());
                    lVar.setThreadData(clC().getPbData().ckv());
                    lVar.f(postData);
                    this.iHk.d(lVar);
                    this.iHk.setPostId(postData.getId());
                    b(view, postData.aCo().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.iIc != null) {
                        qp(this.iIc.aPa());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void csS() {
        if (this.iIc != null) {
            qp(this.iIc.aPa());
        }
        cpl();
        this.iYR.cpZ();
    }

    private boolean FS(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("bubble_link", "");
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

    public void bWt() {
        if (this.iOr != null) {
            this.iOr.setVisibility(0);
        }
    }

    public void bWs() {
        if (this.iOr != null) {
            this.iOr.setVisibility(8);
        }
    }

    public void zv(int i) {
        if (this.iYC != null) {
            this.iYC.setVisibility(i);
        }
    }

    public void cpG() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a cmI() {
        return this.iIO;
    }

    public void cph() {
        if (this.FO != null) {
            this.FO.hide();
        }
    }

    public void bEm() {
        if (this.iHn.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iHn.getCurrentFocus());
        }
    }

    public void H(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckv() != null) {
            String valueOf = String.valueOf(eVar.ckv().aCf());
            if (eVar.ckv().aCf() == 0) {
                valueOf = "";
            }
            this.iYA.wj(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        for (BaseFragment baseFragment : this.iYB.cte()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, eVar, str, i4);
            }
        }
        b(z, i, i2, i3, eVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (clC() != null && clC().getPbData() != null && clC().getPbData().ckv() != null && clC().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(iPh)).intValue();
                if (intValue == iPi) {
                    if (!this.fKL.cLP()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.fKL.Jh(aq.O(jSONArray));
                        }
                        this.fKL.a(clC().getPbData().getForum().getId(), clC().getPbData().getForum().getName(), clC().getPbData().ckv().getId(), str, intValue3, intValue2, booleanValue, clC().getPbData().ckv().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == iPj || intValue == iPl) {
                    if (clC().cob() != null) {
                        clC().cob().yI(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == iPj) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int aUA() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aUB() {
        if (this.dMA == null) {
            this.dMA = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aUN */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.azO().isShowImages();
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
                        if (i.azO().isShowImages()) {
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
        return this.dMA;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aUC() {
        if (this.dPo == null) {
            this.dPo = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dPo;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aUD() {
        if (this.dMB == null) {
            this.dMB = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bHa */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.azO().isShowImages();
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
                    if (i.azO().isShowImages()) {
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
                    gifView.aPP();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.dMB;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aUE() {
        if (this.dPp == null) {
            this.dPp = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnm */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cw */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cx */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).cMi();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cy */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.dPp;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aUF() {
        if (this.dPq == null) {
            this.dPq = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cno */
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
        return this.dPq;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aUG() {
        this.dPr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cnn */
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
        return this.dPr;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iHy = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str, boolean z) {
        if (as.Gi(str) && clC() != null && clC().cnz() != null) {
            TiebaStatic.log(new an("c11664").X("obj_param1", 1).cy("post_id", clC().cnz()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.dvQ = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            as.cqC().c(getPageContext(), str);
        }
        this.iHy = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aD(Context context, String str) {
        as.cqC().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.iHy = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void r(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.iYR.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b ctx = this.iYR.ctx();
            if (ctx == null) {
                this.iYR.cmy();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                ctx.getItemView(1).setVisibility(8);
            } else {
                ctx.getItemView(1).setVisibility(0);
            }
            ctx.aED();
            this.iHy = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            ba.aGG().b(getPageContext(), new String[]{str});
            this.iHy = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a csT() {
        return this.dac;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener aSq() {
        return this.drN;
    }

    public ReplyFragment csU() {
        if (this.iYB == null || !(this.iYB.zw(iYy) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.iYB.zw(iYy);
    }

    public DetailInfoFragment csV() {
        if (this.iYB == null || !(this.iYB.zw(iYx) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.iYB.zw(iYx);
    }

    public boolean cls() {
        PbModel clC = this.iHn.clC();
        if (clC == null) {
            return false;
        }
        return clC.cls();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData ckE;
        PbModel clC = this.iHn.clC();
        if (clC != null && clC.getPbData() != null && !clC.getPbData().ckT()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = clC.getPbData().ckv().getId();
            if (clC.isShareThread() && clC.getPbData().ckv().cTR != null) {
                historyMessage.threadName = clC.getPbData().ckv().cTR.showText;
            } else {
                historyMessage.threadName = clC.getPbData().ckv().getTitle();
            }
            if (clC.isShareThread() && !cls()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = clC.getPbData().getForum().getName();
            }
            ArrayList<PostData> ckx = clC.getPbData().ckx();
            int cpK = csU() != null ? csU().cpK() : 0;
            if (ckx != null && cpK >= 0 && cpK < ckx.size()) {
                historyMessage.postID = ckx.get(cpK).getId();
            }
            historyMessage.isHostOnly = clC.getHostMode();
            historyMessage.isSquence = clC.cnA();
            historyMessage.isShareThread = clC.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.iIc != null) {
            this.iIc.onDestroy();
        }
        if (clC != null && (clC.cnB() || clC.cnD())) {
            Intent intent = new Intent();
            intent.putExtra("tid", clC.cnz());
            if (this.iHQ) {
                if (this.iHS) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", clC.bxR());
                }
                if (this.iHR) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", clC.getIsGood());
                }
            }
            if (clC.getPbData() != null && System.currentTimeMillis() - this.iHu >= 40000 && (ckE = clC.getPbData().ckE()) != null && !v.isEmpty(ckE.getDataList())) {
                intent.putExtra("guess_like_data", ckE);
            }
            PbActivity pbActivity = this.iHn;
            PbActivity pbActivity2 = this.iHn;
            pbActivity.setResult(-1, intent);
        }
        if (cmP()) {
            if (clC != null) {
                com.baidu.tieba.pb.data.e pbData = clC.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.iHA) {
                        if (this.iYE != null) {
                            Rect rect = new Rect();
                            this.iYE.getGlobalVisibleRect(rect);
                            ah.coR().h(rect);
                        }
                        ah.coR().zb(this.cYb.getCurrentItem());
                        BdTypeRecyclerView bGG = bGG();
                        Parcelable parcelable = null;
                        if (bGG != null) {
                            parcelable = bGG.onSaveInstanceState();
                        }
                        ah.coR().a(clC.cnI(), parcelable, clC.cnA(), clC.getHostMode(), false);
                    }
                }
            } else {
                ah.coR().reset();
            }
            clP();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.iYF != null && !this.iYF.bin()) {
            if ((this.iYF.isFullScreen() && configuration.orientation == 1) || (!this.iYF.isFullScreen() && configuration.orientation == 2)) {
                this.iYF.ra(false);
            }
        }
    }

    public boolean csW() {
        if (this.iYF == null) {
            return false;
        }
        return this.iYF.bin();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.cKb().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        public boolean iZl;
        public boolean iZm;

        private a() {
            this.iZm = true;
        }

        public boolean ctd() {
            return (this.iZl && this.iZm) ? false : true;
        }
    }

    public void csX() {
        this.iHI = -1;
        this.iHJ = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnf() {
        if (clC() != null && !aq.isEmpty(clC().cnz())) {
            com.baidu.tbadk.BdToken.c.axz().o(com.baidu.tbadk.BdToken.b.cGM, com.baidu.adp.lib.f.b.toLong(clC().cnz(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.iYD.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csY() {
        if (this.iZc == null) {
            this.iZc = ObjectAnimator.ofFloat(this.iYH, "alpha", 0.0f, 1.0f);
            this.iZc.setDuration(200L);
        }
        this.iZc.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csZ() {
        if (this.iZd == null) {
            this.iZd = ObjectAnimator.ofFloat(this.iYH, "alpha", 1.0f, 0.0f);
            this.iZd.setDuration(200L);
        }
        this.iZd.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cta() {
        return this.iYF != null && this.iYF.ctb();
    }

    public boolean ctb() {
        return this.iYY;
    }

    public void qS(boolean z) {
        this.iYY = z;
    }
}
