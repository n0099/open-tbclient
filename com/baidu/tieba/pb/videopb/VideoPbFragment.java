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
    private CustomViewPager cYa;
    public View dFK;
    private com.baidu.adp.lib.d.b<ImageView> dMn;
    private com.baidu.adp.lib.d.b<GifView> dMo;
    private com.baidu.adp.lib.d.b<TextView> dPb;
    private com.baidu.adp.lib.d.b<View> dPc;
    private com.baidu.adp.lib.d.b<LinearLayout> dPd;
    private com.baidu.adp.lib.d.b<RelativeLayout> dPe;
    private ImageView eEw;
    private VoiceManager gol;
    private com.baidu.tieba.frs.profession.permission.c grM;
    private com.baidu.tieba.f.b gso;
    public aj hPy;
    private com.baidu.tieba.pb.videopb.c.a iCo;
    private PbFakeFloorModel iGY;
    public ap iHH;
    private g iHP;
    private com.baidu.tbadk.editortools.pb.e iHQ;
    private com.baidu.tieba.frs.profession.permission.c iHS;
    private EmotionImageData iHT;
    private com.baidu.tbadk.core.view.d iHX;
    private PbActivity iHb;
    private com.baidu.tieba.pb.pb.main.emotion.model.a iHs;
    int iHv;
    private ImageView iOA;
    private com.baidu.tieba.pb.view.c iOB;
    private TextView iOC;
    private int iOE;
    private int iOF;
    private View iOf;
    private View iOw;
    private ImageView iOy;
    private ImageView iOz;
    private s iPc;
    private String iPt;
    public View iTO;
    private ImageView iYA;
    private TBSpecificationBtn iYB;
    private TbImageView iYC;
    private ValueAnimator iYD;
    private ValueAnimator iYE;
    public com.baidu.tieba.pb.videopb.b.a iYF;
    private float iYJ;
    private float iYK;
    private boolean iYL;
    private ObjectAnimator iYQ;
    private ObjectAnimator iYR;
    private NewPagerSlidingTabBaseStrip iYo;
    private VideoPbFragmentAdapter iYp;
    private View iYq;
    private View iYr;
    private VideoContainerLayout iYs;
    private com.baidu.tieba.pb.videopb.videoView.a iYt;
    private f iYu;
    private View iYv;
    private View iYw;
    private TextView iYy;
    private TextView iYz;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int iYl = 0;
    public static int iYm = 1;
    public static int iOU = 3;
    public static int iOV = 0;
    public static int iOW = 3;
    public static int iOX = 4;
    public static int iOY = 5;
    public static int iOZ = 6;
    private static final int hfk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int iYn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a iIM = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void bk(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.clp();
            } else {
                com.baidu.tieba.pb.a.b.clo();
            }
        }
    };
    private long iHi = 0;
    View.OnClickListener iYx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.iCo != null) {
                TiebaStatic.log(new an("c13590").cy("obj_id", VideoPbFragment.this.iCo.getTitle()).cy("obj_name", VideoPbFragment.this.iCo.ctJ()).X("obj_type", 2).cy("fid", VideoPbFragment.this.clB().getPbData().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("tid", VideoPbFragment.this.clB().getPbData().getThreadId()));
                String link = VideoPbFragment.this.iCo.getLink();
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
    private com.baidu.tbadk.baseEditMark.a iHB = null;
    private com.baidu.tbadk.coreExtra.model.a dab = null;
    private ForumManageModel fKy = null;
    private boolean iHm = false;
    private View iOx = null;
    private TextView hgM = null;
    private boolean iOt = false;
    private String dyq = null;
    private boolean iHE = false;
    private boolean iHF = false;
    private boolean iHG = false;
    private boolean iHo = false;
    int[] iHu = new int[2];
    private int iHw = -1;
    private int iHx = Integer.MIN_VALUE;
    private int iId = 0;
    private int iYH = Integer.MIN_VALUE;
    private boolean isPaused = false;
    private final PbModel.a iIC = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g mm;
            VideoPbFragment.this.cpH();
            VideoPbFragment.this.bWr();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.qr(false);
            if (z && eVar != null) {
                bj cku = eVar.cku();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(eVar, i2);
                VideoPbFragment.this.G(eVar);
                com.baidu.tieba.pb.videopb.c.a ckU = eVar.ckU();
                if (ckU != null) {
                    VideoPbFragment.this.a(ckU);
                }
                VideoPbFragment.this.H(eVar);
                VideoPbFragment.this.c(z, i, i2, i3, eVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.iHB != null) {
                    VideoPbFragment.this.iHB.fm(eVar.ayL());
                }
                AntiData anti = eVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.dyq = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.dyq) && VideoPbFragment.this.iHQ != null && VideoPbFragment.this.iHQ.aOt() != null && (mm = VideoPbFragment.this.iHQ.aOt().mm(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.dyq)) {
                        ((View) mm).setOnClickListener(VideoPbFragment.this.dzb);
                    }
                }
                if (VideoPbFragment.this.hPy != null && cku != null && cku.aCo() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(cku.aCo());
                    VideoPbFragment.this.hPy.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.clB().cny());
                        jSONObject.put("fid", VideoPbFragment.this.clB().getForumId());
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
                if (VideoPbFragment.this.csT() != null) {
                    if (i != -1) {
                        ArrayList<PostData> arrayList = null;
                        if (VideoPbFragment.this.clB() != null && VideoPbFragment.this.clB().getPbData() != null) {
                            arrayList = VideoPbFragment.this.clB().getPbData().ckw();
                        }
                        if (v.getCount(arrayList) == 0 || (v.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).cLa() == 1)) {
                            if (VideoPbFragment.this.csT().cnc()) {
                                VideoPbFragment.this.csT().Gd(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                VideoPbFragment.this.csT().Gd(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            VideoPbFragment.this.csT().Gc(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                        }
                    } else {
                        VideoPbFragment.this.csT().Gc("");
                    }
                    VideoPbFragment.this.csT().endLoadData();
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.cKa().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0374a iIE = new a.InterfaceC0374a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0374a
        public void c(boolean z, boolean z2, String str) {
            VideoPbFragment.this.cpH();
            if (z && VideoPbFragment.this.clB() != null) {
                if (VideoPbFragment.this.iHB != null) {
                    VideoPbFragment.this.iHB.fm(z2);
                }
                VideoPbFragment.this.clB().pX(z2);
                if (VideoPbFragment.this.clB().ayL()) {
                    VideoPbFragment.this.cmN();
                } else if (VideoPbFragment.this.csT() != null) {
                    VideoPbFragment.this.csT().ctE();
                }
                if (z2) {
                    if (VideoPbFragment.this.iHB != null) {
                        if (VideoPbFragment.this.iHB.ayO() != null && VideoPbFragment.this.clB() != null && VideoPbFragment.this.clB().getPbData() != null && VideoPbFragment.this.clB().getPbData().cku() != null && VideoPbFragment.this.clB().getPbData().cku().aCo() != null) {
                            MarkData ayO = VideoPbFragment.this.iHB.ayO();
                            MetaData aCo = VideoPbFragment.this.clB().getPbData().cku().aCo();
                            if (ayO != null && aCo != null) {
                                if (!aq.equals(TbadkCoreApplication.getCurrentAccount(), aCo.getUserId()) && !aCo.hadConcerned()) {
                                    VideoPbFragment.this.iYF.b(aCo);
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
                    VideoPbFragment.this.cmK();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b dyu = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOQ() {
            if (VideoPbFragment.this.iHH == null || VideoPbFragment.this.iHH.cqx() == null || !VideoPbFragment.this.iHH.cqx().cUe()) {
                return !VideoPbFragment.this.yN(aj.cZW);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.iHH.cqx().cUg());
            if (VideoPbFragment.this.iHQ != null && (VideoPbFragment.this.iHQ.aPg() || VideoPbFragment.this.iHQ.aPh())) {
                VideoPbFragment.this.iHQ.a(false, VideoPbFragment.this.iHH.cqA());
            }
            VideoPbFragment.this.iHH.qw(true);
            return true;
        }
    };
    private final CustomMessageListener iIk = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.clB() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.iHQ != null) {
                    VideoPbFragment.this.qp(VideoPbFragment.this.iHQ.aOZ());
                }
                VideoPbFragment.this.cpk();
                VideoPbFragment.this.iYF.cpY();
            }
        }
    };
    private CustomMessageListener iIn = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
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
    private final CustomMessageListener gpx = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.isPaused) {
                VideoPbFragment.this.cne();
            }
        }
    };
    private CustomMessageListener iID = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.cmE();
            }
        }
    };
    private CustomMessageListener iIy = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.iYF != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.iYF.iHY) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.iYF.bqr();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.iYF.getExtra();
                DataRes dataRes = aVar.kuG;
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
                    VideoPbFragment.this.iYF.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.iYF.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener iIw = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.iYF != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.iYF.iHY) {
                VideoPbFragment.this.iYF.bqr();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.clB().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.ckH().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.iHX.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.iYF.vq(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.iYF.cnb();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.iHX.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iIx = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.iYF != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.iYF.iHY) {
                VideoPbFragment.this.iYF.bqr();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.iHX.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.iHX.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b iHV = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOQ() {
            if (VideoPbFragment.this.iHH == null || VideoPbFragment.this.iHH.cqy() == null || !VideoPbFragment.this.iHH.cqy().cUe()) {
                return !VideoPbFragment.this.yN(aj.cZX);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.iHH.cqy().cUg());
            if (VideoPbFragment.this.iPc != null && VideoPbFragment.this.iPc.cmn() != null && VideoPbFragment.this.iPc.cmn().aPh()) {
                VideoPbFragment.this.iPc.cmn().a(VideoPbFragment.this.iHH.cqA());
            }
            VideoPbFragment.this.iHH.qx(true);
            return true;
        }
    };
    private final NewWriteModel.d dyA = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.clB() != null && VideoPbFragment.this.clB().getPbData() != null) {
                    anVar.cy("fid", VideoPbFragment.this.clB().getPbData().getForumId());
                }
                anVar.cy("tid", VideoPbFragment.this.clB().cny());
                anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            VideoPbFragment.this.bEk();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.clB() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.clB().FX(postWriteCallBackData.getPostId());
                    if (VideoPbFragment.this.csT() != null) {
                        VideoPbFragment.this.iId = VideoPbFragment.this.csT().cpJ();
                        VideoPbFragment.this.iYH = VideoPbFragment.this.csT().ctH();
                        VideoPbFragment.this.clB().cr(VideoPbFragment.this.iId, VideoPbFragment.this.iYH);
                    }
                }
                if (VideoPbFragment.this.cYa != null) {
                    VideoPbFragment.this.cYa.setCurrentItem(VideoPbFragment.iYm);
                }
                VideoPbFragment.this.iYF.cpY();
                VideoPbFragment.this.iHH.cqw();
                if (VideoPbFragment.this.iHQ != null) {
                    VideoPbFragment.this.qp(VideoPbFragment.this.iHQ.aOZ());
                }
                VideoPbFragment.this.cpg();
                VideoPbFragment.this.qr(true);
                VideoPbFragment.this.clB().cnS();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && VideoPbFragment.this.csT() != null) {
                            VideoPbFragment.this.csT().ctE();
                        }
                    } else if (VideoPbFragment.this.clB().getHostMode()) {
                        com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.clB().getPbData();
                        if (pbData != null && pbData.cku() != null && pbData.cku().aCo() != null && (userId = pbData.cku().aCo().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.clB().cnJ()) {
                            VideoPbFragment.this.cpF();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.clB().cnJ()) {
                        VideoPbFragment.this.cpF();
                    }
                    VideoPbFragment.this.cmD();
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.iHQ.aPg() || VideoPbFragment.this.iHQ.aPh()) {
                    VideoPbFragment.this.iHQ.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.iHH.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.hPy != null) {
                    VideoPbFragment.this.hPy.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (aaVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener dzb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.dyq);
        }
    };
    private CustomMessageListener iIm = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.iHQ != null) {
                    VideoPbFragment.this.qp(VideoPbFragment.this.iHQ.aOZ());
                }
                VideoPbFragment.this.qr(false);
            }
        }
    };
    private int iYI = 0;
    private boolean iYM = true;
    private View.OnTouchListener iYN = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.iYI == 1) {
                if (!VideoPbFragment.this.iYM) {
                    VideoPbFragment.this.csX();
                    UtilHelper.showStatusBar(VideoPbFragment.this.cni(), VideoPbFragment.this.cni().getRootView());
                    VideoPbFragment.this.iYM = true;
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(VideoPbFragment.this.iYP);
                    com.baidu.adp.lib.f.e.gx().postDelayed(VideoPbFragment.this.iYP, 3000L);
                }
            } else if (VideoPbFragment.this.iYI == 2 && (VideoPbFragment.this.iYM || VideoPbFragment.this.csZ())) {
                VideoPbFragment.this.csY();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cni(), VideoPbFragment.this.cni().getRootView());
                VideoPbFragment.this.iYM = false;
                if (VideoPbFragment.this.iYt != null) {
                    VideoPbFragment.this.iYt.qS(false);
                }
            }
            VideoPbFragment.this.iYI = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener iYO = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.iYI = 0;
            VideoPbFragment.this.iYJ = 0.0f;
            VideoPbFragment.this.iYK = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.iYJ += f;
            VideoPbFragment.this.iYK += f2;
            if (VideoPbFragment.this.iYI == 0 && !VideoPbFragment.this.iYL && VideoPbFragment.this.iYt != null && !VideoPbFragment.this.iYt.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.iYK) <= Math.abs(VideoPbFragment.this.iYJ) || VideoPbFragment.this.iYK > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.iYK) > Math.abs(VideoPbFragment.this.iYJ) && VideoPbFragment.this.iYK > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.iYI = 2;
                    }
                } else {
                    VideoPbFragment.this.iYI = 1;
                }
            }
            return true;
        }
    };
    private Runnable iYP = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.iYM && !VideoPbFragment.this.csZ()) {
                VideoPbFragment.this.csY();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cni(), VideoPbFragment.this.cni().getRootView());
                VideoPbFragment.this.iYM = false;
            }
        }
    };
    private final com.baidu.adp.base.d fKD = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.clB() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.fKy.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.fKy.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.clB().cnS();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.iVH != 1002 || bVar.eLF) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.mSuccess, dVar.kji, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.fKy.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.fKy.getLoadDataMode(), gVar.mSuccess, gVar.kji, false);
                    VideoPbFragment.this.iYF.aM(gVar.kjl);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener drA = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.gso.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d iIA = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.clB() != null && VideoPbFragment.this.clB().getPbData() != null) {
                    anVar.cy("fid", VideoPbFragment.this.clB().getPbData().getForumId());
                }
                if (VideoPbFragment.this.clB() != null) {
                    anVar.cy("tid", VideoPbFragment.this.clB().cny());
                }
                anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (VideoPbFragment.this.iHH != null) {
                    VideoPbFragment.this.iHH.cqv();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.hPy != null) {
                    VideoPbFragment.this.hPy.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.iHH != null) {
                if (VideoPbFragment.this.iPc != null && VideoPbFragment.this.iPc.cmn() != null && VideoPbFragment.this.iPc.cmn().aPh()) {
                    VideoPbFragment.this.iPc.cmn().a(postWriteCallBackData);
                }
                VideoPbFragment.this.iHH.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c dyt = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aOR() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener auX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            boolean v;
            int i2 = 2;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    an anVar = new an("c13398");
                    anVar.cy("tid", VideoPbFragment.this.clB().cny());
                    anVar.cy("fid", VideoPbFragment.this.clB().getForumId());
                    anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.X("obj_locate", 1);
                    TiebaStatic.log(anVar);
                    if (VideoPbFragment.this.iHm) {
                        VideoPbFragment.this.iHm = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.clB() != null && VideoPbFragment.this.clB().getPbData() != null && VideoPbFragment.this.iGY != null && postData.aCo() != null && postData.cLa() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.iPc != null) {
                                    VideoPbFragment.this.iPc.cmj();
                                }
                                com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                                lVar.a(VideoPbFragment.this.clB().getPbData().getForum());
                                lVar.setThreadData(VideoPbFragment.this.clB().getPbData().cku());
                                lVar.f(postData);
                                VideoPbFragment.this.iGY.d(lVar);
                                VideoPbFragment.this.iGY.setPostId(postData.getId());
                                VideoPbFragment.this.b(view, postData.aCo().getUserId(), "");
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.clB().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.iHQ != null) {
                                    VideoPbFragment.this.qp(VideoPbFragment.this.iHQ.aOZ());
                                }
                            }
                        }
                    }
                } else if (VideoPbFragment.this.csT() != null && VideoPbFragment.this.csT().cpU() != null && view == VideoPbFragment.this.csT().cpU()) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.clB().pV(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        VideoPbFragment.this.csT().cpG();
                    }
                } else if (VideoPbFragment.this.iYF != null && VideoPbFragment.this.iYF.crc() != null && view == VideoPbFragment.this.iYF.crc().coG()) {
                    VideoPbFragment.this.iYF.arU();
                } else if (VideoPbFragment.this.iYF != null && ((VideoPbFragment.this.iYF.crc() != null && view == VideoPbFragment.this.iYF.crc().coH()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.iYF.cpY();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.bEk();
                        VideoPbFragment.this.cpF();
                        if (view.getId() == R.id.owner_reply) {
                            v = VideoPbFragment.this.clB().v(true, VideoPbFragment.this.cmR());
                        } else {
                            v = view.getId() == R.id.all_reply ? VideoPbFragment.this.clB().v(false, VideoPbFragment.this.cmR()) : VideoPbFragment.this.clB().FU(VideoPbFragment.this.cmR());
                        }
                        view.setTag(Boolean.valueOf(v));
                        if (v) {
                            VideoPbFragment.this.bWs();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.dFK) {
                    if (VideoPbFragment.this.clB() != null && VideoPbFragment.this.clB().getPbData() != null) {
                        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            an anVar2 = new an("c13266");
                            anVar2.cy("uid", TbadkCoreApplication.getCurrentAccount());
                            anVar2.cy("fid", VideoPbFragment.this.clB().getPbData().getForumId());
                            anVar2.cy("tid", VideoPbFragment.this.clB().cny());
                            anVar2.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(anVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.iHb, VideoPbFragment.this.dFK);
                        VideoPbFragment.this.iHb.finish();
                    }
                } else if (view == VideoPbFragment.this.iTO && VideoPbFragment.this.iYF != null) {
                    if (VideoPbFragment.this.clB() == null || VideoPbFragment.this.clB().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> ckw = VideoPbFragment.this.clB().getPbData().ckw();
                    if ((ckw == null || ckw.size() <= 0) && VideoPbFragment.this.clB().cnz()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new an("c12378").cy("tid", VideoPbFragment.this.clB().cny()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", VideoPbFragment.this.clB().getForumId()));
                    VideoPbFragment.this.iYF.cmF();
                } else if (VideoPbFragment.this.iYF != null && VideoPbFragment.this.iYF.crc() != null && view == VideoPbFragment.this.iYF.crc().coH()) {
                    VideoPbFragment.this.iYF.arU();
                } else if (VideoPbFragment.this.iYF != null && ((VideoPbFragment.this.iYF.crc() != null && view == VideoPbFragment.this.iYF.crc().coN()) || view.getId() == R.id.pb_sort_type)) {
                    VideoPbFragment.this.iYF.cpY();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.bEk();
                            VideoPbFragment.this.cpF();
                            VideoPbFragment.this.iYF.cG(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.clB().cnQ()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.iYF != null && VideoPbFragment.this.iYF.crc() != null && view == VideoPbFragment.this.iYF.crc().coF()) {
                    if (VideoPbFragment.this.clB() != null && VideoPbFragment.this.clB().getPbData() != null && VideoPbFragment.this.clB().getPbData().cku() != null) {
                        VideoPbFragment.this.iYF.arU();
                        TiebaStatic.log(new an("c13062"));
                        VideoPbFragment.this.iYF.FP(VideoPbFragment.this.clB().getPbData().cku().aCE());
                    }
                } else if (VideoPbFragment.this.iYF != null && VideoPbFragment.this.iYF.crc() != null && view == VideoPbFragment.this.iYF.crc().coO()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        am.v(true, false);
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).X("obj_type", 0).X("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).X("obj_type", 1).X("obj_source", 1));
                    }
                    VideoPbFragment.this.iYF.crb();
                } else if (VideoPbFragment.this.iYF != null && (view == VideoPbFragment.this.iYF.cpD() || (VideoPbFragment.this.iYF.crc() != null && (view == VideoPbFragment.this.iYF.crc().coK() || view == VideoPbFragment.this.iYF.crc().coI())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.clB() != null || VideoPbFragment.this.clB().getPbData() != null) {
                        if ((VideoPbFragment.this.clB().getPbData().ckG() == 1 || VideoPbFragment.this.clB().getPbData().ckG() == 3) && !VideoPbFragment.this.fKy.cLO()) {
                            VideoPbFragment.this.iYF.cpY();
                            if (VideoPbFragment.this.iYF.crc() != null && view == VideoPbFragment.this.iYF.crc().coI()) {
                                if (VideoPbFragment.this.clB().getPbData().cku().aCj() == 1) {
                                    i = 5;
                                } else {
                                    i = 4;
                                }
                            } else if (VideoPbFragment.this.iYF.crc() != null && view == VideoPbFragment.this.iYF.crc().coK()) {
                                i = VideoPbFragment.this.clB().getPbData().cku().aCk() == 1 ? 3 : 6;
                            } else {
                                i = view == VideoPbFragment.this.iYF.cpD() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.clB().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.clB().getPbData().cku().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.fKy.b(id, name, id2, i, VideoPbFragment.this.iYF.cpE());
                        }
                    }
                } else if (VideoPbFragment.this.iYF != null && VideoPbFragment.this.iYF.crc() != null && view == VideoPbFragment.this.iYF.crc().coM()) {
                    if (VideoPbFragment.this.clB() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.iYF.cpY();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.clB().getPbData(), VideoPbFragment.this.clB().cnz(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.clB().getPbData().getForum().getId(), VideoPbFragment.this.clB().getPbData().getForum().getName(), VideoPbFragment.this.clB().getPbData().cku().getId(), String.valueOf(VideoPbFragment.this.clB().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.iYF != null && VideoPbFragment.this.iYF.crc() != null && view == VideoPbFragment.this.iYF.crc().coJ()) {
                    if (VideoPbFragment.this.clB() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.clB().getPbData(), VideoPbFragment.this.clB().cnz(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.iYF.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.iYF.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.iYF.arU();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        an anVar3 = new an("c13398");
                        anVar3.cy("tid", VideoPbFragment.this.clB().cny());
                        anVar3.cy("fid", VideoPbFragment.this.clB().getForumId());
                        anVar3.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar3.X("obj_locate", 4);
                        TiebaStatic.log(anVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new an("c10517").X("obj_locate", 3).cy("fid", VideoPbFragment.this.clB().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.clB() != null && VideoPbFragment.this.clB().getPbData() != null) {
                        if (VideoPbFragment.this.iYF != null) {
                            VideoPbFragment.this.iYF.cpY();
                        }
                        PostData postData2 = (PostData) ((SparseArray) view.getTag()).get(R.id.tag_load_sub_data);
                        if (postData2 != null) {
                            if (postData2.cLm() == 1) {
                                TiebaStatic.log(new an("c12630"));
                            }
                            if (postData2.khr != null) {
                                an aGy = postData2.khr.aGy();
                                aGy.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    aGy.X("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    aGy.X("obj_locate", 8);
                                }
                                TiebaStatic.log(aGy);
                            }
                            String cny = VideoPbFragment.this.clB().cny();
                            String id3 = postData2.getId();
                            int ckG = VideoPbFragment.this.clB().getPbData() != null ? VideoPbFragment.this.clB().getPbData().ckG() : 0;
                            VideoPbFragment.this.bEk();
                            TiebaStatic.log("c11742");
                            if (VideoPbFragment.this.csT() != null && VideoPbFragment.this.csT().ctG() != null) {
                                PbActivity.a FS = VideoPbFragment.this.csT().ctG().FS(id3);
                                if (postData2 != null && VideoPbFragment.this.clB() != null && VideoPbFragment.this.clB().getPbData() != null && FS != null) {
                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cny, id3, "pb", true, null, false, null, ckG, postData2.crZ(), VideoPbFragment.this.clB().getPbData().getAnti(), false, postData2.aCo().getIconInfo()).addBigImageData(FS.iEn, FS.iEo, FS.iEp, FS.index);
                                    addBigImageData.setKeyFromForumId(VideoPbFragment.this.clB().getForumId());
                                    addBigImageData.setBjhData(VideoPbFragment.this.clB().cnG());
                                    addBigImageData.setKeyPageStartFrom(VideoPbFragment.this.clB().coh());
                                    addBigImageData.setFromFrsForumId(VideoPbFragment.this.clB().getFromForumId());
                                    VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply) {
                    if (VideoPbFragment.this.clB() != null) {
                        an anVar4 = new an("c13398");
                        anVar4.cy("tid", VideoPbFragment.this.clB().cny());
                        anVar4.cy("fid", VideoPbFragment.this.clB().getForumId());
                        anVar4.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar4.X("obj_locate", 6);
                        TiebaStatic.log(anVar4);
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData3 = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                if (postData3.khr != null) {
                                    an aGy2 = postData3.khr.aGy();
                                    aGy2.delete("obj_locate");
                                    aGy2.X("obj_locate", 8);
                                    TiebaStatic.log(aGy2);
                                }
                                if (VideoPbFragment.this.clB() != null && VideoPbFragment.this.clB().getPbData() != null && VideoPbFragment.this.iGY != null && postData3.aCo() != null && postData3.cLa() != 1) {
                                    if (VideoPbFragment.this.iPc != null) {
                                        VideoPbFragment.this.iPc.cmj();
                                    }
                                    com.baidu.tieba.pb.data.l lVar2 = new com.baidu.tieba.pb.data.l();
                                    lVar2.a(VideoPbFragment.this.clB().getPbData().getForum());
                                    lVar2.setThreadData(VideoPbFragment.this.clB().getPbData().cku());
                                    lVar2.f(postData3);
                                    VideoPbFragment.this.iGY.d(lVar2);
                                    VideoPbFragment.this.iGY.setPostId(postData3.getId());
                                    VideoPbFragment.this.b(view, postData3.aCo().getUserId(), "");
                                    if (VideoPbFragment.this.iHQ != null) {
                                        VideoPbFragment.this.qp(VideoPbFragment.this.iHQ.aOZ());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.iYF != null && VideoPbFragment.this.clB() != null && VideoPbFragment.this.csT() != null) {
                        VideoPbFragment.this.iYF.cpY();
                        if (VideoPbFragment.this.yO(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.clB() != null) {
                            VideoPbFragment.this.cmM();
                            if (VideoPbFragment.this.clB().getPbData() != null && VideoPbFragment.this.clB().getPbData().cku() != null && VideoPbFragment.this.clB().getPbData().cku().aCo() != null) {
                                TiebaStatic.log(new an("c13402").cy("tid", VideoPbFragment.this.clB().cny()).cy("fid", VideoPbFragment.this.clB().getPbData().getForumId()).X("obj_locate", 3).cy("uid", VideoPbFragment.this.clB().getPbData().cku().aCo().getUserId()));
                            }
                            if (VideoPbFragment.this.clB().getPbData().cku() != null && VideoPbFragment.this.clB().getPbData().cku().aCo() != null && VideoPbFragment.this.clB().getPbData().cku().aCo().getUserId() != null && VideoPbFragment.this.iHB != null) {
                                int g = VideoPbFragment.this.iYF.g(VideoPbFragment.this.clB().getPbData());
                                bj cku = VideoPbFragment.this.clB().getPbData().cku();
                                if (!cku.aBd()) {
                                    if (cku.aBe()) {
                                        i2 = 3;
                                    } else if (cku.aEg()) {
                                        i2 = 4;
                                    } else {
                                        i2 = cku.aEh() ? 5 : 1;
                                    }
                                }
                                TiebaStatic.log(new an("c12526").cy("tid", VideoPbFragment.this.clB().cny()).X("obj_locate", 1).cy("obj_id", VideoPbFragment.this.clB().getPbData().cku().aCo().getUserId()).X("obj_type", VideoPbFragment.this.iHB.ayL() ? 0 : 1).X("obj_source", g).X("obj_param1", i2));
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.qQ(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.clB() != null && VideoPbFragment.this.iYF != null && VideoPbFragment.this.cYa != null && VideoPbFragment.this.clB().getPbData() != null && VideoPbFragment.this.clB().getPbData().cku() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        if (VideoPbFragment.this.clB().getPbData().cku().aCf() != 0) {
                            int currentItem = VideoPbFragment.this.cYa.getCurrentItem();
                            if (currentItem == VideoPbFragment.iYl) {
                                VideoPbFragment.this.cYa.setCurrentItem(VideoPbFragment.iYm);
                            } else if (currentItem == VideoPbFragment.iYm) {
                                if (VideoPbFragment.this.csT() != null && VideoPbFragment.this.bGF() != null) {
                                    an cy = new an("c13403").cy("tid", VideoPbFragment.this.clB().cny()).cy("fid", VideoPbFragment.this.clB().getPbData().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView bGF = VideoPbFragment.this.bGF();
                                    boolean canScrollVertically = bGF.canScrollVertically(1);
                                    boolean canScrollVertically2 = bGF.canScrollVertically(-1);
                                    if (VideoPbFragment.this.CD != null) {
                                        VideoPbFragment.this.CD.setExpanded(false, true);
                                    }
                                    if (bGF.getLayoutManager() != null && (bGF.getLayoutManager() instanceof LinearLayoutManager)) {
                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) bGF.getLayoutManager();
                                        if (!canScrollVertically2 && canScrollVertically) {
                                            if (VideoPbFragment.this.iHw != -1 || VideoPbFragment.this.iHx != Integer.MIN_VALUE) {
                                                if (VideoPbFragment.this.iHw > 3 || (VideoPbFragment.this.iHw == 3 && VideoPbFragment.this.iHx < (-equipmentHeight))) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iHw, VideoPbFragment.this.iHx + equipmentHeight);
                                                    bGF.smoothScrollBy(0, equipmentHeight);
                                                } else if (VideoPbFragment.this.iHw >= 2) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iHw, VideoPbFragment.this.iHx + (equipmentHeight / 2));
                                                    bGF.smoothScrollBy(0, equipmentHeight / 2);
                                                } else if (VideoPbFragment.this.iHw == 1) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iHw, VideoPbFragment.this.iHx + (equipmentHeight / 4));
                                                    bGF.smoothScrollBy(0, equipmentHeight / 4);
                                                } else {
                                                    bGF.smoothScrollBy(0, -VideoPbFragment.this.iHx);
                                                }
                                                cy.X("obj_locate", 2);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            int firstVisiblePosition = bGF.getFirstVisiblePosition();
                                            View childAt = bGF.getChildAt(0);
                                            int top2 = childAt == null ? 0 : childAt.getTop();
                                            VideoPbFragment.this.iHw = firstVisiblePosition;
                                            VideoPbFragment.this.iHx = top2;
                                            if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top2 < (-equipmentHeight) && bGF.getCount() >= 6)) {
                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                bGF.smoothScrollToPosition(0);
                                            } else {
                                                bGF.smoothScrollToPosition(0);
                                            }
                                            cy.X("obj_locate", 1);
                                        }
                                        TiebaStatic.log(cy);
                                        TiebaStatic.log(new an("c12942").X("obj_type", 1).X("obj_locate", 4).cy("tid", VideoPbFragment.this.clB().cny()));
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (VideoPbFragment.this.clB() != null && VideoPbFragment.this.clB().getPbData() != null && VideoPbFragment.this.clB().getPbData().cku() != null && VideoPbFragment.this.clB().getPbData().cku().aCo() != null) {
                                TiebaStatic.log(new an("c13402").cy("tid", VideoPbFragment.this.clB().cny()).cy("fid", VideoPbFragment.this.clB().getPbData().getForumId()).X("obj_locate", 2).cy("uid", VideoPbFragment.this.clB().getPbData().cku().aCo().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.qR(false);
                        VideoPbFragment.this.cmz();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.iId >= 0) {
                        if (VideoPbFragment.this.clB() != null) {
                            VideoPbFragment.this.clB().coi();
                        }
                        if (VideoPbFragment.this.clB() != null && VideoPbFragment.this.csT() != null && VideoPbFragment.this.csT().ctF() != null) {
                            VideoPbFragment.this.csT().ctF().setData(VideoPbFragment.this.clB().getPbData());
                        }
                        VideoPbFragment.this.iId = 0;
                        VideoPbFragment.this.iYH = Integer.MIN_VALUE;
                        if (VideoPbFragment.this.clB() != null && VideoPbFragment.this.csT() != null) {
                            VideoPbFragment.this.csT().cu(VideoPbFragment.this.clB().col(), VideoPbFragment.this.clB().com());
                            VideoPbFragment.this.clB().cr(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.clB() != null) {
                        an anVar5 = new an("c13398");
                        anVar5.cy("tid", VideoPbFragment.this.clB().cny());
                        anVar5.cy("fid", VideoPbFragment.this.clB().getForumId());
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
                        VideoPbFragment.this.cpk();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.cpk();
                }
            }
        }
    };
    private View.OnClickListener iES = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.iYF != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.iYF.b(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.iYF.cA(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.iYF.b(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.iYF.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private a iYG = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void cmK() {
        if (clB() != null && clB().getPbData() != null && clB().getPbData().cku() != null) {
            bj cku = clB().getPbData().cku();
            cku.mRecomAbTag = clB().cos();
            cku.mRecomWeight = clB().coq();
            cku.mRecomSource = clB().cor();
            cku.mRecomExtra = clB().cot();
            if (cku.getFid() == 0) {
                cku.setFid(com.baidu.adp.lib.f.b.toLong(clB().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cku, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmD() {
        if (clB() != null && clB().getPbData() != null && clB().getPbData().cku() != null) {
            bj cku = clB().getPbData().cku();
            cku.mRecomAbTag = clB().cos();
            cku.mRecomWeight = clB().coq();
            cku.mRecomSource = clB().cor();
            cku.mRecomExtra = clB().cot();
            if (cku.getFid() == 0) {
                cku.setFid(com.baidu.adp.lib.f.b.toLong(clB().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cku, "c13563");
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
            String string = !TextUtils.isEmpty(bVar.kji) ? bVar.kji : getString(R.string.delete_fail);
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
                a(0, bVar.mSuccess, bVar.kji, z);
            }
            if (bVar.mSuccess) {
                if (bVar.fXX == 1) {
                    ArrayList<PostData> ckw = clB().getPbData().ckw();
                    int size = ckw.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(ckw.get(i).getId())) {
                            i++;
                        } else {
                            ckw.remove(i);
                            break;
                        }
                    }
                    clB().getPbData().cku().jJ(clB().getPbData().cku().aCf() - 1);
                    if (csT() != null) {
                        csT().ctE();
                    }
                } else if (bVar.fXX == 0) {
                    cmL();
                } else if (bVar.fXX == 2) {
                    ArrayList<PostData> ckw2 = clB().getPbData().ckw();
                    int size2 = ckw2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= ckw2.get(i2).cKX().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(ckw2.get(i2).cKX().get(i3).getId())) {
                                i3++;
                            } else {
                                ckw2.get(i2).cKX().remove(i3);
                                ckw2.get(i2).cKZ();
                                z2 = true;
                                break;
                            }
                        }
                        ckw2.get(i2).Jb(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3 && csT() != null) {
                        csT().ctE();
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = clB().getPbData().ckF().iCS;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cKX().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cKX().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cKX().remove(i2);
                    list.get(i).cKZ();
                    z = true;
                    break;
                }
            }
            list.get(i).Jb(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2 && csT() != null) {
            csT().ctE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && clB() != null && clB().getPbData() != null && clB().getPbData().cku() != null) {
            a(this.fKy.getLoadDataMode(), gVar.mSuccess, gVar.kji, false);
            if (gVar.mSuccess) {
                this.iHE = true;
                if (i == 2 || i == 3) {
                    this.iHF = true;
                    this.iHG = false;
                } else if (i == 4 || i == 5) {
                    this.iHF = false;
                    this.iHG = true;
                }
                if (i == 2) {
                    clB().getPbData().cku().jM(1);
                    clB().setIsGood(1);
                } else if (i == 3) {
                    clB().getPbData().cku().jM(0);
                    clB().setIsGood(0);
                } else if (i == 4) {
                    clB().getPbData().cku().jL(1);
                    clB().yQ(1);
                } else if (i == 5) {
                    clB().getPbData().cku().jL(0);
                    clB().yQ(0);
                }
            }
            if (clB().getPbData().cku() != null && csU() != null) {
                csU().ctB();
            }
        }
    }

    private void cmL() {
        if (clB().cnA() || clB().cnC()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", clB().cny());
            PbActivity pbActivity = this.iHb;
            PbActivity pbActivity2 = this.iHb;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, clB().cny()));
        if (cmO()) {
            this.iHb.finish();
        }
    }

    private boolean cmO() {
        if (clB() == null) {
            return true;
        }
        if (clB().getPbData() == null || !clB().getPbData().ckS()) {
            if (clB().ayL()) {
                final MarkData cnR = clB().cnR();
                if (cnR == null || !clB().getIsFromMark() || bGF() == null) {
                    return true;
                }
                final MarkData yX = clB().yX(bGF().getFirstVisiblePosition());
                if (yX == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cnR);
                    this.iHb.setResult(-1, intent);
                    return true;
                } else if (yX.getPostId() == null || yX.getPostId().equals(cnR.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cnR);
                    this.iHb.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.sS(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.iHB != null) {
                                if (VideoPbFragment.this.iHB.ayL()) {
                                    VideoPbFragment.this.iHB.ayM();
                                    VideoPbFragment.this.iHB.fm(false);
                                }
                                VideoPbFragment.this.iHB.a(yX);
                                VideoPbFragment.this.iHB.fm(true);
                                VideoPbFragment.this.iHB.ayN();
                            }
                            cnR.setPostId(yX.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cnR);
                            VideoPbFragment.this.iHb.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.clO();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cnR);
                            VideoPbFragment.this.iHb.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.clO();
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
            } else if (clB().getPbData() == null || clB().getPbData().ckw() == null || clB().getPbData().ckw().size() <= 0 || !clB().getIsFromMark()) {
                return true;
            } else {
                this.iHb.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clO() {
        this.iHb.clO();
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
        if (clB() != null && this.iYF != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = clB().getPbData()) != null) {
                bj cku = pbData.cku();
                if (cku != null && cku.aCo() != null) {
                    TiebaStatic.log(new an("c13402").cy("tid", clB().cny()).cy("fid", pbData.getForumId()).X("obj_locate", 4).cy("uid", cku.aCo().getUserId()));
                }
                if (cku != null) {
                    if (cku.aBd()) {
                        i = 2;
                    } else if (cku.aBe()) {
                        i = 3;
                    } else if (cku.aEg()) {
                        i = 4;
                    } else if (cku.aEh()) {
                        i = 5;
                    }
                    an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    anVar.cy("tid", clB().cny());
                    anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cy("fid", clB().getForumId());
                    if (!z) {
                        anVar.X("obj_locate", 6);
                    } else {
                        anVar.X("obj_locate", 5);
                    }
                    anVar.X("obj_name", i);
                    anVar.X("obj_type", 2);
                    if (cku != null) {
                        if (cku.aBd()) {
                            anVar.X("obj_type", 10);
                        } else if (cku.aBe()) {
                            anVar.X("obj_type", 9);
                        } else if (cku.aEh()) {
                            anVar.X("obj_type", 8);
                        } else if (cku.aEg()) {
                            anVar.X("obj_type", 7);
                        } else if (cku.isShareThread) {
                            anVar.X("obj_type", 6);
                        } else if (cku.threadType == 0) {
                            anVar.X("obj_type", 1);
                        } else if (cku.threadType == 40) {
                            anVar.X("obj_type", 2);
                        } else if (cku.threadType == 49) {
                            anVar.X("obj_type", 3);
                        } else if (cku.threadType == 54) {
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
                    } else if (clB().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> ckw = pbData.ckw();
                        if ((ckw == null || ckw.size() <= 0) && clB().cnz()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.iYF.cpY();
                        bEk();
                        TiebaStatic.log(new an("c11939"));
                        if (!AntiHelper.d(getContext(), cku)) {
                            if (this.iOB != null) {
                                this.iOB.setEnable(false);
                                t(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                yP(z ? 2 : 1);
                                return;
                            }
                            this.iYF.showLoadingDialog();
                            clB().coc().t(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.cy("tid", clB().cny());
                anVar2.cy("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.cy("fid", clB().getForumId());
                if (!z) {
                }
                anVar2.X("obj_name", i);
                anVar2.X("obj_type", 2);
                if (cku != null) {
                }
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                TiebaStatic.log(anVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment csz() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        G(eVar.ctf());
        H(eVar.ctf());
        if (clB() != null && clB().getPbData() != null) {
            boolean isFromMark = clB().getIsFromMark();
            com.baidu.tieba.pb.data.e pbData = clB().getPbData();
            if (isFromMark) {
                PostData F = F(pbData);
                if (pbData.ayK() != null && !pbData.ayK().equals(F.getId()) && this.cYa != null) {
                    this.cYa.setCurrentItem(iYm);
                }
            }
        }
        eVar.ctg().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aM */
            public void onChanged(@Nullable bj bjVar) {
                if (bjVar != null && bjVar.aCF() != null) {
                    if (VideoPbFragment.this.iYt.getVideoUrl() == null || !VideoPbFragment.this.iYt.getVideoUrl().equals(bjVar.aCF().video_url)) {
                        if (!aq.isEmpty(VideoPbFragment.this.iYt.getVideoUrl())) {
                            VideoPbFragment.this.iHo = true;
                            VideoPbFragment.this.cYa.setCurrentItem(VideoPbFragment.iYl);
                        }
                        if (VideoPbFragment.this.iYu == null || !VideoPbFragment.this.iYu.isPlaying()) {
                            VideoPbFragment.this.csA();
                            VideoPbFragment.this.aL(bjVar);
                        }
                        VideoPbFragment.this.csB();
                        if (VideoPbFragment.this.iYu.ctt()) {
                            VideoPbFragment.this.iYu.start();
                        }
                        boolean z = !aq.equals(VideoPbFragment.this.iYt.getVideoUrl(), bjVar.aCF().video_url);
                        VideoPbFragment.this.iYt.setData(bjVar);
                        VideoPbFragment.this.iYt.ctQ();
                        VideoPbFragment.this.iYt.qZ(VideoPbFragment.this.cYa.getCurrentItem() == 0);
                        if (z) {
                            VideoPbFragment.this.iYt.startPlay();
                            VideoPbFragment.this.iYt.ctZ();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.iYt.setData(bjVar);
                }
            }
        });
        eVar.ctp().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: p */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.cYa.setCurrentItem(num.intValue());
            }
        });
        eVar.ctk().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aM */
            public void onChanged(@Nullable bj bjVar) {
                VideoPbFragment.this.iYt.aQ(bjVar);
            }
        });
        eVar.ctl().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aM */
            public void onChanged(@Nullable bj bjVar) {
                VideoPbFragment.this.iYt.aR(bjVar);
            }
        });
        eVar.ctm().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.csM();
            }
        });
        eVar.ctn().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csA() {
        ViewGroup.LayoutParams layoutParams = this.iYw.getLayoutParams();
        layoutParams.height = 0;
        this.iYw.setLayoutParams(layoutParams);
        this.iYw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csB() {
        if (this.iYu == null) {
            this.iYu = new f(getBaseFragmentActivity(), this.iYs);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(cni()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.iYs.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.iYu.b(eVar.cth(), rect);
            if (this.iYu.ctt()) {
                this.iYu.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (eVar.cti() || VideoPbFragment.this.clB().getTabIndex() == VideoPbFragment.iYm) {
                            VideoPbFragment.this.cYa.setCurrentItem(VideoPbFragment.iYm);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (eVar.cti() || VideoPbFragment.this.clB().getTabIndex() == VideoPbFragment.iYm) {
                            VideoPbFragment.this.cYa.setCurrentItem(VideoPbFragment.iYm);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (eVar.cti() || clB().getTabIndex() == iYm) {
                this.cYa.setCurrentItem(iYm);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.iYL && (this.iYM || csZ())) {
            csY();
            UtilHelper.hideStatusBar(cni(), cni().getRootView());
            this.iYM = false;
            if (this.iYt != null) {
                this.iYt.qS(false);
            }
        }
        if (i == 4) {
            return this.iYt.onBackPress();
        }
        if (i == 24) {
            return this.iYt.ctV();
        }
        if (i == 25) {
            return this.iYt.ctW();
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
        Rect cou;
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
                int height = (clB() != null || (cou = clB().cou()) == null) ? ceil : cou.height();
                i = 0;
                layoutParams = this.iYs.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.iYs.setLayoutParams(layoutParams);
                this.iYs.setMaxHeight(ceil);
                this.iYs.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.iYs.setOriginHeight(height);
                layoutParams2 = (RelativeLayout.LayoutParams) this.iYo.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, iYn);
                } else {
                    layoutParams2.height = iYn;
                }
                this.iYo.setLayoutParams(layoutParams2);
                layoutParams3 = (CoordinatorLayout.LayoutParams) this.CD.getLayoutParams();
                int i2 = ceil + iYn;
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
        if (clB() != null) {
        }
        i = 0;
        layoutParams = this.iYs.getLayoutParams();
        if (layoutParams != null) {
        }
        this.iYs.setLayoutParams(layoutParams);
        this.iYs.setMaxHeight(ceil2);
        this.iYs.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.iYs.setOriginHeight(height);
        layoutParams2 = (RelativeLayout.LayoutParams) this.iYo.getLayoutParams();
        if (layoutParams2 != null) {
        }
        this.iYo.setLayoutParams(layoutParams2);
        layoutParams3 = (CoordinatorLayout.LayoutParams) this.CD.getLayoutParams();
        int i22 = ceil2 + iYn;
        if (layoutParams3 != null) {
        }
        this.CD.setLayoutParams(layoutParams3);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.iHi = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        ak(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.iHX = new com.baidu.tbadk.core.view.d();
        this.iHX.toastTime = 1000L;
        if (this.iYF != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.iYF.iHY;
            userMuteAddAndDelCustomMessage.setTag(this.iYF.iHY);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.iYF.iHY;
            userMuteCheckCustomMessage.setTag(this.iYF.iHY);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        com.baidu.tieba.s.c.cKa().w(getUniqueId());
    }

    private void initData() {
        this.iHB = com.baidu.tbadk.baseEditMark.a.a(this.iHb);
        if (this.iHB != null) {
            this.iHB.a(this.iIE);
        }
        this.fKy = new ForumManageModel(this.iHb);
        this.fKy.setLoadDataCallBack(this.fKD);
        this.dab = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.iYF = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void ak(Bundle bundle) {
        this.iHP = new g();
        d(this.iHP);
        this.iHQ = (com.baidu.tbadk.editortools.pb.e) this.iHP.dV(getActivity());
        this.iHQ.a(this.iHb.getPageContext());
        this.iHQ.a(this.dyA);
        this.iHQ.a(this.dyt);
        this.iHQ.a(this.iHb.getPageContext(), bundle);
        this.iHQ.aOt().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.iHQ.aOt().gB(true);
        pK(true);
        this.iHQ.a(clB().cnN(), clB().cny(), clB().coe());
        registerListener(this.iIn);
        registerListener(this.iID);
        registerListener(this.iIm);
        registerListener(this.iIk);
        registerListener(this.gpx);
        if (!clB().cnE()) {
            this.iHQ.vl(clB().cny());
        }
        if (clB().cof()) {
            this.iHQ.vk(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.iHQ.vk(cpm());
        }
        this.iHH = new ap();
        if (this.iHQ.aOS() != null) {
            this.iHH.e(this.iHQ.aOS().getInputView());
        }
        this.iHQ.a(this.dyu);
        this.hPy = new aj(getPageContext());
        this.hPy.a(new aj.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
            @Override // com.baidu.tbadk.core.util.aj.a
            public void l(boolean z, int i) {
                if (z) {
                    if (i == aj.cZW) {
                        VideoPbFragment.this.iHQ.a((String) null, (WriteData) null);
                    } else if (i == aj.cZX && VideoPbFragment.this.iPc != null && VideoPbFragment.this.iPc.cmn() != null) {
                        VideoPbFragment.this.iPc.cmn().aPo();
                    } else if (i == aj.cZY) {
                        VideoPbFragment.this.c(VideoPbFragment.this.iHT);
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
        this.gso = new com.baidu.tieba.f.b(getActivity());
        this.gso.a(iIM);
        this.iYL = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        bcJ();
        this.CD = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.iYq = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.iYs = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.iYt = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.iYs);
        this.iYt.setUniqueId(getUniqueId());
        this.iYt.ad(this);
        this.iYt.cH(cni().getRootView());
        this.iYt.cI(this.iYv);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.iYo = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.iYw = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.cYa = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.iYr = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.iYr.setOnClickListener(this.auX);
        csD();
        csC();
        csE();
        this.iYp = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.cYa.setAdapter(this.iYp);
        this.iYo.setViewPager(this.cYa);
        this.iYo.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (VideoPbFragment.this.csT() != null) {
                        VideoPbFragment.this.csT().qY(false);
                    }
                    if (VideoPbFragment.this.csU() != null) {
                        VideoPbFragment.this.csU().qY(true);
                        VideoPbFragment.this.zv(VideoPbFragment.this.csU().ctD() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.ctm() != null && eVar.ctm().getValue() != null && eVar.ctm().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.iYt.qZ(z);
                    VideoPbFragment.this.cpk();
                    if (VideoPbFragment.this.clB() != null && VideoPbFragment.this.clB().getPbData() != null) {
                        TiebaStatic.log(new an("c13592").cy("tid", VideoPbFragment.this.clB().cny()).cy("fid", VideoPbFragment.this.clB().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.csU() != null) {
                        VideoPbFragment.this.csU().qY(false);
                    }
                    if (VideoPbFragment.this.csT() != null) {
                        VideoPbFragment.this.csT().qY(true);
                        int ctD = VideoPbFragment.this.csT().ctD();
                        int ctI = VideoPbFragment.this.csT().ctI();
                        if (ctD != 0) {
                            VideoPbFragment.this.zv(8);
                            VideoPbFragment.this.csT().zv(0);
                        } else if (ctI != 0) {
                            VideoPbFragment.this.csT().zv(8);
                            VideoPbFragment.this.zv(0);
                        } else {
                            VideoPbFragment.this.csT().zv(8);
                            VideoPbFragment.this.zv(8);
                        }
                    }
                    VideoPbFragment.this.iYt.qZ(false);
                    VideoPbFragment.this.CD.setExpanded(false, true);
                    if (VideoPbFragment.this.clB() != null && VideoPbFragment.this.clB().getPbData() != null) {
                        TiebaStatic.log(new an("c13593").cy("tid", VideoPbFragment.this.clB().cny()).cy("fid", VideoPbFragment.this.clB().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.iYp.zx(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.iOf = this.rootView.findViewById(R.id.viewstub_progress);
        csF();
        csG();
        if (!this.iYL && this.iYM) {
            csY();
            UtilHelper.hideStatusBar(cni(), cni().getRootView());
            this.iYM = false;
        }
    }

    private void csC() {
        this.iYy = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.iYC = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.iYz = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.iYA = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.iYB = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.iYC.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iYC.setConrers(15);
        this.iYB.setConfig(new com.baidu.tbadk.core.view.commonBtn.d());
        this.iYA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c13591"));
                VideoPbFragment.this.csO();
            }
        });
        this.iYB.setOnClickListener(this.iYx);
        this.iYw.setOnClickListener(this.iYx);
    }

    private void csD() {
        this.iYo.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.iYo.setContainerLayoutParams(layoutParams);
        this.iYo.setRectPaintColor(R.color.cp_link_tip_a);
        this.iYo.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.iYo.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.iYo.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.iYo.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.iYo.setExpandedTabLayoutParams(layoutParams2);
    }

    public void qR(boolean z) {
        if (this.CD != null) {
            this.CD.setExpanded(z);
        }
    }

    private void csE() {
        this.iOw = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.iOx = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.iOE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iOF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.hgM = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.hgM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.qR(false);
                VideoPbFragment.this.cmz();
                if (VideoPbFragment.this.clB() != null && VideoPbFragment.this.clB().getPbData() != null && VideoPbFragment.this.clB().getPbData().cku() != null && VideoPbFragment.this.clB().getPbData().cku().aCo() != null) {
                    TiebaStatic.log(new an("c13402").cy("tid", VideoPbFragment.this.clB().cny()).cy("fid", VideoPbFragment.this.clB().getPbData().getForumId()).X("obj_locate", 1).cy("uid", VideoPbFragment.this.clB().getPbData().cku().aCo().getUserId()));
                }
            }
        });
        this.iOy = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.iOy.setOnClickListener(this.auX);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.iOz = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.iOz.setOnClickListener(this.auX);
        if (booleanExtra) {
            this.iOz.setVisibility(8);
        } else {
            this.iOz.setVisibility(0);
        }
        this.iOA = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.iOA.setOnClickListener(this.auX);
        this.iOB = new com.baidu.tieba.pb.view.c(this.iOA);
        this.iOB.cuj();
        this.iOC = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        qr(false);
    }

    private void bcJ() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.bEl();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.iYv = this.rootView.findViewById(R.id.status_bar_background);
        if (this.iYL) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(cni());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.iYv.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(cni());
            this.iYv.setLayoutParams(layoutParams2);
            this.iYv.setVisibility(0);
        }
        this.dFK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.auX);
        this.eEw = (ImageView) this.dFK.findViewById(R.id.widget_navi_back_button);
        SvgManager.aGC().a(this.eEw, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iTO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.auX);
        this.Lb = (ImageView) this.iTO.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.iTO.setLayoutParams(layoutParams3);
        SvgManager.aGC().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iTO.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.iYO);
        this.mNavigationBar.setOnTouchListener(this.iYN);
    }

    public void csF() {
        setEditorTools(this.iHQ.aOt());
    }

    private void csG() {
        this.iGY = new PbFakeFloorModel(getPageContext());
        this.iPc = new s(getPageContext(), this.iGY, this.rootView);
        this.iPc.a(this.iIA);
        this.iGY.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                VideoPbFragment.this.iGY.q(postData);
                if (VideoPbFragment.this.csT() != null) {
                    VideoPbFragment.this.csT().ctE();
                }
                VideoPbFragment.this.iPc.cmj();
                VideoPbFragment.this.FO.aMQ();
                VideoPbFragment.this.qr(false);
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.iHb = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (clB() != null) {
            clB().au(bundle);
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
        this.iYt.mL(true);
        if (clB() != null && !clB().cnE()) {
            this.iHQ.saveDraft(clB().cny());
        }
        com.baidu.tbadk.BdToken.c.axz().axE();
        MessageManager.getInstance().unRegisterListener(this.iIw);
        MessageManager.getInstance().unRegisterListener(this.iIx);
        MessageManager.getInstance().unRegisterListener(this.iIy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        getVoiceManager().onResume(getPageContext());
        this.iYt.mL(false);
        cne();
        registerListener(this.iIw);
        registerListener(this.iIx);
        registerListener(this.iIy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.iYp != null && this.cYa != null) {
            this.iYp.zx(z ? this.cYa.getCurrentItem() : -1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.cKa().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.cKa().x(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.iOB != null) {
            this.iOB.onDestroy();
        }
        if (this.fKy != null) {
            this.fKy.cancelLoadData();
        }
        if (this.iYt != null) {
            this.iYt.onDestroy();
        }
        if (this.iHs != null) {
            this.iHs.cancelLoadData();
        }
        if (this.hPy != null) {
            this.hPy.onDestroy();
        }
        if (clB() != null) {
            clB().cancelLoadData();
            clB().destory();
            if (clB().cob() != null) {
                clB().cob().onDestroy();
            }
        }
        if (this.iHQ != null) {
            this.iHQ.onDestroy();
        }
        this.iHX = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.iHb);
        this.iYo.onChangeSkinType();
        am.setBackgroundColor(this.iYo, R.color.cp_bg_line_h);
        this.iHH.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.iYu == null || !this.iYu.isPlaying()) {
            am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        am.setBackgroundColor(this.iYv, R.color.cp_mask_b_alpha66);
        if (this.FO != null) {
            this.FO.onChangeSkinType(i);
        }
        if (this.iPc != null) {
            this.iPc.onChangeSkinType(i);
        }
        if (this.hgM != null) {
            am.setViewTextColor(this.hgM, (int) R.color.cp_cont_d);
            this.hgM.setBackgroundDrawable(am.ay(l.getDimens(getContext(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
        }
        if (this.iOz != null && clB() != null) {
            if (clB().ayL()) {
                SvgManager.aGC().a(this.iOz, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aGC().a(this.iOz, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.iOy != null) {
            SvgManager.aGC().a(this.iOy, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (clB() != null) {
            t(clB().getPbData());
        }
        am.setViewTextColor(this.iOC, (int) R.color.cp_cont_b);
        if (this.iOw != null) {
            am.setBackgroundResource(this.iOw, R.drawable.bottom_shadow);
        }
        am.setBackgroundColor(this.iOx, R.color.cp_bg_line_h);
        if (csT() != null) {
            csT().onChangeSkinType(i);
        }
        if (csU() != null) {
            csU().onChangeSkinType(i);
        }
        if (this.iYq != null) {
            am.setBackgroundResource(this.iYq, R.drawable.personalize_tab_shadow);
        }
        if (this.iYw != null) {
            am.setBackgroundColor(this.iYw, R.color.cp_bg_line_g);
        }
        if (this.iYA != null) {
            SvgManager.aGC().a(this.iYA, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iYy != null) {
            am.setViewTextColor(this.iYy, (int) R.color.cp_cont_b);
        }
        if (this.iYz != null) {
            am.setViewTextColor(this.iYz, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gol == null) {
            this.gol = VoiceManager.instance();
        }
        return this.gol;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEk() {
        if (this.gol != null) {
            this.gol.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cng() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cnh() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel clB() {
        return this.iHb.clB();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cni() {
        return this.iHb;
    }

    public com.baidu.tbadk.baseEditMark.a csH() {
        return this.iHB;
    }

    public View.OnClickListener csI() {
        return this.auX;
    }

    public View.OnClickListener csJ() {
        return this.iES;
    }

    public View.OnLongClickListener csK() {
        return this.iYF.csK();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (as.Gh(objArr[i].getLink()) && (drawable = am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView bGF() {
        Iterator<BaseFragment> it = this.iYp.ctd().iterator();
        while (it.hasNext()) {
            BaseFragment next = it.next();
            if (next instanceof ReplyFragment) {
                return ((ReplyFragment) next).getListView();
            }
        }
        return null;
    }

    private void pK(boolean z) {
        this.iHQ.gF(z);
        this.iHQ.gG(z);
        this.iHQ.gH(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.iYF != null) {
            if (z) {
                this.iYF.cpY();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.iYF.cpZ();
            } else {
                this.iYF.cpY();
            }
        }
    }

    public boolean yN(int i) {
        if (this.hPy == null || clB() == null || clB().getPbData() == null || clB().getPbData().getAnti() == null) {
            return true;
        }
        return this.hPy.ax(clB().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean cmB() {
        if ((clB() != null && clB().getPbData().ckS()) || this.hPy == null || clB() == null || clB().getPbData() == null || clB().getPbData().getAnti() == null) {
            return true;
        }
        return this.hPy.ks(clB().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && clB() != null) {
            gVar.setForumName(clB().cls());
            if (clB().getPbData() != null && clB().getPbData().getForum() != null) {
                gVar.a(clB().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(clB());
        }
    }

    public void cpA() {
        if (this.FO != null) {
            this.FO.display();
            if (this.iHQ != null) {
                this.iHQ.aOW();
            }
            cqi();
        }
    }

    private boolean cmy() {
        PbModel clB = clB();
        if (clB == null || clB.getPbData() == null) {
            return false;
        }
        bj cku = clB.getPbData().cku();
        clB.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cku);
    }

    public void cmz() {
        if (checkUpIsLogin() && clB() != null && clB().getPbData() != null && clB().getPbData().getForum() != null && !cmy()) {
            if (clB().getPbData().ckS()) {
                bPx();
                return;
            }
            if (this.grM == null) {
                this.grM = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.grM.tP(0);
                this.grM.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lw(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void t(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lx(boolean z) {
                        if (z) {
                            VideoPbFragment.this.bPx();
                        }
                    }
                });
            }
            this.grM.C(clB().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(clB().cny(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.iHQ.onActivityResult(i, i2, intent);
        if (this.iHs != null) {
            this.iHs.onActivityResult(i, i2, intent);
        }
        if (this.iPc != null) {
            this.iPc.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cmM();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cCa().A(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.iHT = emotionImageData;
                        if (yN(aj.cZY)) {
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
        if (cni() != null) {
            if (this.iYM && !TbSingleton.getInstance().isNotchScreen(cni()) && !TbSingleton.getInstance().isCutoutScreen(cni())) {
                csY();
                UtilHelper.hideStatusBar(cni(), cni().getRootView());
                this.iYM = false;
            }
            this.iYG.iZa = z;
            csL();
            csM();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.iHb;
        if (i == 0) {
            cpg();
            if (this.iPc != null) {
                this.iPc.cmj();
            }
            qr(false);
        }
        cpk();
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
                        this.iHQ.resetData();
                        this.iHQ.setVoiceModel(pbEditorData.getVoiceModel());
                        this.iHQ.b(writeData);
                        com.baidu.tbadk.editortools.l mp = this.iHQ.aOt().mp(6);
                        if (mp != null && mp.dwA != null) {
                            mp.dwA.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.iHb;
                        if (i == -1) {
                            this.iHQ.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.iPc != null && this.iPc.cmn() != null) {
                            com.baidu.tbadk.editortools.pb.h cmn = this.iPc.cmn();
                            cmn.setThreadData(clB().getPbData().cku());
                            cmn.b(writeData);
                            cmn.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l mp2 = cmn.aOt().mp(6);
                            if (mp2 != null && mp2.dwA != null) {
                                mp2.dwA.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.iHb;
                            if (i == -1) {
                                cmn.aPo();
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
                if (clB() != null && !clB().cnE()) {
                    antiData.setBlock_forum_name(clB().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(clB().getPbData().getForum().getId());
                    antiData.setUser_name(clB().getPbData().getUserData().getUserName());
                    antiData.setUser_id(clB().getPbData().getUserData().getUserId());
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
            if (this.iYF != null) {
                this.iYF.vq(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void cnk() {
        if (clB() != null && this.iHb != null) {
            if (this.iHQ == null || !this.iHQ.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.iHQ = (com.baidu.tbadk.editortools.pb.e) dVar.dV(getContext());
                this.iHQ.a(this.iHb.getPageContext());
                this.iHQ.a(this.dyA);
                this.iHQ.a(this.dyt);
                this.iHQ.a(this.iHb.getPageContext(), this.iHb.getIntent() == null ? null : this.iHb.getIntent().getExtras());
                this.iHQ.aOt().gB(true);
                setEditorTools(this.iHQ.aOt());
                if (!clB().cnE()) {
                    this.iHQ.vl(clB().cny());
                }
                if (clB().cof()) {
                    this.iHQ.vk(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.iHQ.vk(cpm());
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
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).aJw() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).aJw() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.iHQ.c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            VideoPbFragment.this.iHQ.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cpg();
        this.iHQ.b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
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
                if (VideoPbFragment.this.iHH != null && VideoPbFragment.this.iHH.cqx() != null) {
                    if (!VideoPbFragment.this.iHH.cqx().cUf()) {
                        VideoPbFragment.this.iHH.qw(false);
                    }
                    VideoPbFragment.this.iHH.cqx().tH(false);
                }
            }
        });
    }

    public void bPx() {
        if (!checkUpIsLogin()) {
            if (clB() != null) {
                TiebaStatic.log(new an("c10517").X("obj_locate", 2).cy("fid", clB().getForumId()));
            }
        } else if (cmB()) {
            if (this.iHQ != null && (this.iHQ.aPg() || this.iHQ.aPh())) {
                this.iHQ.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.FO != null) {
                cpA();
                this.iYG.iYZ = false;
                if (this.FO.mp(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.FO.mp(2).dwA, false, null);
                }
            }
            cqi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cmy() && cmB()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.iHu);
                this.iHv = ((View) view.getParent()).getMeasuredHeight();
            }
            if (clB() != null && clB().getPbData() != null && clB().getPbData().ckS()) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.iHb.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.bGF().smoothScrollBy(0, (VideoPbFragment.this.iHu[1] + VideoPbFragment.this.iHv) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.iPc != null) {
                            VideoPbFragment.this.iHQ.aOt().setVisibility(8);
                            VideoPbFragment.this.iPc.g(str, str2, VideoPbFragment.this.cpm(), (VideoPbFragment.this.clB() == null || VideoPbFragment.this.clB().getPbData() == null || VideoPbFragment.this.clB().getPbData().cku() == null || !VideoPbFragment.this.clB().getPbData().cku().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cmn = VideoPbFragment.this.iPc.cmn();
                            if (cmn != null && VideoPbFragment.this.clB() != null && VideoPbFragment.this.clB().getPbData() != null) {
                                cmn.a(VideoPbFragment.this.clB().getPbData().getAnti());
                                cmn.setThreadData(VideoPbFragment.this.clB().getPbData().cku());
                            }
                            if (VideoPbFragment.this.iHH.cqz() == null && VideoPbFragment.this.iPc.cmn().aPw() != null) {
                                VideoPbFragment.this.iPc.cmn().aPw().c(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.iHH != null && VideoPbFragment.this.iHH.cqy() != null) {
                                            if (!VideoPbFragment.this.iHH.cqy().cUf()) {
                                                VideoPbFragment.this.iHH.qx(false);
                                            }
                                            VideoPbFragment.this.iHH.cqy().tH(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.iHH.f(VideoPbFragment.this.iPc.cmn().aPw().getInputView());
                                VideoPbFragment.this.iPc.cmn().a(VideoPbFragment.this.iHV);
                            }
                        }
                        VideoPbFragment.this.cqi();
                    }
                }, 0L);
                return;
            }
            if (this.iHS == null) {
                this.iHS = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iHS.tP(1);
                this.iHS.a(new AnonymousClass43(str, str2));
            }
            if (clB() != null && clB().getPbData() != null && clB().getPbData().getForum() != null) {
                this.iHS.C(clB().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(clB().cny(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$43  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass43 implements c.a {
        final /* synthetic */ String iIY;
        final /* synthetic */ String iIZ;

        AnonymousClass43(String str, String str2) {
            this.iIY = str;
            this.iIZ = str2;
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
                        VideoPbFragment.this.bGF().smoothScrollBy(0, (VideoPbFragment.this.iHu[1] + VideoPbFragment.this.iHv) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.iPc != null) {
                            VideoPbFragment.this.iHQ.aOt().setVisibility(8);
                            VideoPbFragment.this.iPc.g(AnonymousClass43.this.iIY, AnonymousClass43.this.iIZ, VideoPbFragment.this.cpm(), (VideoPbFragment.this.clB() == null || VideoPbFragment.this.clB().getPbData() == null || VideoPbFragment.this.clB().getPbData().cku() == null || !VideoPbFragment.this.clB().getPbData().cku().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cmn = VideoPbFragment.this.iPc.cmn();
                            if (cmn != null && VideoPbFragment.this.clB() != null && VideoPbFragment.this.clB().getPbData() != null) {
                                cmn.a(VideoPbFragment.this.clB().getPbData().getAnti());
                                cmn.setThreadData(VideoPbFragment.this.clB().getPbData().cku());
                            }
                            if (VideoPbFragment.this.iHH.cqz() == null && VideoPbFragment.this.iPc.cmn().aPw() != null) {
                                VideoPbFragment.this.iPc.cmn().aPw().c(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.iHH != null && VideoPbFragment.this.iHH.cqy() != null) {
                                            if (!VideoPbFragment.this.iHH.cqy().cUf()) {
                                                VideoPbFragment.this.iHH.qx(false);
                                            }
                                            VideoPbFragment.this.iHH.cqy().tH(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.iHH.f(VideoPbFragment.this.iPc.cmn().aPw().getInputView());
                                VideoPbFragment.this.iPc.cmn().a(VideoPbFragment.this.iHV);
                            }
                        }
                        VideoPbFragment.this.cqi();
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.ckG()));
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.ckG()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bf> ckN = eVar.ckN();
                if (v.getCount(ckN) > 0) {
                    sb = new StringBuilder();
                    for (bf bfVar : ckN) {
                        if (bfVar != null && !StringUtils.isNull(bfVar.getForumName()) && (wVar = bfVar.cQP) != null && wVar.cOJ && !wVar.cOK && (wVar.type == 1 || wVar.type == 2)) {
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
    public void cmM() {
        MarkData yX;
        if (clB() != null && clB().getPbData() != null && csT() != null && this.iHB != null) {
            if (clB().getPbData() != null && clB().getPbData().ckS()) {
                yX = clB().yX(0);
            } else if (this.cYa != null && this.cYa.getCurrentItem() == iYl) {
                yX = clB().l(F(clB().getPbData()));
            } else {
                yX = clB().yX(csT().cpK());
            }
            if (yX != null) {
                if (!yX.isApp() || (yX = clB().yX(csT().cpK() + 1)) != null) {
                    cpF();
                    this.iHB.a(yX);
                    if (!this.iHB.ayL()) {
                        this.iHB.ayN();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.iHB.ayM();
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
            if (this.iHs == null) {
                this.iHs = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.iHb);
                this.iHs.b(this.dyt);
                this.iHs.c(this.dyA);
            }
            this.iHs.a(emotionImageData, clB(), clB().getPbData());
        }
    }

    public PostData F(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.ckE() != null) {
            return eVar.ckE();
        }
        if (!v.isEmpty(eVar.ckw())) {
            Iterator<PostData> it = eVar.ckw().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cLa() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.ckB();
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
        if (eVar == null || eVar.cku() == null || eVar.cku().aCo() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aCo = eVar.cku().aCo();
        String userId = aCo.getUserId();
        HashMap<String, MetaData> userMap = eVar.cku().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aCo;
        }
        postData.Cw(1);
        postData.setId(eVar.cku().aCE());
        postData.setTitle(eVar.cku().getTitle());
        postData.setTime(eVar.cku().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cmR() {
        ArrayList<PostData> ckw;
        int count;
        int i;
        if (clB() == null || clB().getPbData() == null || clB().getPbData().ckw() == null || (count = v.getCount((ckw = clB().getPbData().ckw()))) == 0) {
            return "";
        }
        if (clB().cnP()) {
            Iterator<PostData> it = ckw.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cLa() == 1) {
                    return next.getId();
                }
            }
        }
        if (bGF() == null) {
            i = 0;
        } else {
            i = csT().cpJ();
        }
        PostData postData = (PostData) v.getItem(ckw, i);
        if (postData == null || postData.aCo() == null) {
            return "";
        }
        if (clB().FV(postData.aCo().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) v.getItem(ckw, i2);
            if (postData2 == null || postData2.aCo() == null || postData2.aCo().getUserId() == null) {
                break;
            } else if (clB().FV(postData2.aCo().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) v.getItem(ckw, i3);
            if (postData3 == null || postData3.aCo() == null || postData3.aCo().getUserId() == null) {
                return "";
            }
            if (clB().FV(postData3.aCo().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmN() {
        if (clB() != null) {
            com.baidu.tieba.pb.data.e pbData = clB().getPbData();
            clB().pX(true);
            if (this.iHB != null) {
                pbData.FI(this.iHB.ayK());
            }
            if (csT() != null) {
                csT().ctE();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (clB() != null) {
            cpH();
            clB().pX(z);
            if (this.iHB != null) {
                this.iHB.fm(z);
                if (markData != null) {
                    this.iHB.a(markData);
                }
            }
            if (clB().ayL()) {
                cmN();
            } else if (csT() != null) {
                csT().ctE();
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        MetaData metaData;
        boolean z = true;
        if (clB() != null && clB().getPbData() != null && lVar.clf() != null) {
            String id = lVar.clf().getId();
            ArrayList<PostData> ckw = clB().getPbData().ckw();
            int i = 0;
            while (true) {
                if (i >= ckw.size()) {
                    break;
                }
                PostData postData = ckw.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> clj = lVar.clj();
                    postData.Cv(lVar.getTotalCount());
                    if (postData.cKX() != null && clj != null) {
                        Iterator<PostData> it = clj.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aCo() != null && (metaData = postData.getUserMap().get(next.aCo().getUserId())) != null) {
                                next.a(metaData);
                                next.sO(true);
                                next.a(getPageContext(), clB().FV(metaData.getUserId()));
                            }
                        }
                        boolean z2 = clj.size() != postData.cKX().size();
                        postData.cKX().clear();
                        postData.cKX().addAll(clj);
                        z = z2;
                    }
                    if (postData.cKT() != null) {
                        postData.cKU();
                    }
                }
            }
            if (!clB().getIsFromMark() && z && csT() != null) {
                csT().ctE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmE() {
        if (clB() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.Iw(clB().getForumId()) && clB().getPbData() != null && clB().getPbData().getForum() != null) {
            if (clB().getPbData().getForum().isLike() == 1) {
                clB().cod().ev(clB().getForumId(), clB().cny());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            bj cku = eVar.cku();
            if (cku != null && cku.aEi()) {
                cnk();
            } else {
                d(this.iHP);
            }
            if (this.iHQ != null) {
                qp(this.iHQ.aOZ());
                this.iHQ.a(eVar.getAnti());
                this.iHQ.a(eVar.getForum(), eVar.getUserData());
                this.iHQ.setThreadData(cku);
                if (clB() != null) {
                    this.iHQ.a(clB().cnN(), clB().cny(), clB().coe());
                }
                if (cku != null) {
                    this.iHQ.gI(cku.aDG());
                }
            }
        }
    }

    public void cpk() {
        reset();
        cpg();
        this.iPc.cmj();
        qr(false);
    }

    private void reset() {
        if (this.iHQ != null && this.FO != null) {
            com.baidu.tbadk.editortools.pb.a.aOP().setStatus(0);
            this.iHQ.aPj();
            this.iHQ.aOD();
            if (this.iHQ.getWriteImagesInfo() != null) {
                this.iHQ.getWriteImagesInfo().setMaxImagesAllowed(this.iHQ.isBJH ? 1 : 9);
            }
            this.iHQ.mv(SendView.ALL);
            this.iHQ.mw(SendView.ALL);
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
        if (eVar != null && eVar.cku() != null) {
            t(eVar);
            if (eVar.ayL()) {
                SvgManager.aGC().a(this.iOz, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aGC().a(this.iOz, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.iOC.setText(zf(eVar.cku().aCf()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.cku()));
        }
    }

    public void t(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.aY(eVar.cku())) {
            if (this.iOB != null) {
                this.iOB.setEnable(false);
                this.iOB.onDestroy();
            }
            SvgManager.aGC().a(this.iOA, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.iOB == null || !this.iOB.isEnable()) {
            SvgManager.aGC().a(this.iOA, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
        if (this.iOx != null) {
            qp(this.iHQ.aOZ());
            if (this.iOt) {
                qg(z);
            } else {
                qh(z);
            }
            csL();
            csM();
        }
    }

    public void cqi() {
        if (this.iOx != null) {
            this.iOw.setVisibility(8);
            this.iOx.setVisibility(8);
            this.iYG.iYZ = false;
            csL();
            csM();
        }
    }

    private void csL() {
        if (this.iYt != null) {
            if (this.iYG.ctc()) {
                this.iYt.rQ(false);
            } else {
                this.iYt.rQ(this.iYt.bim() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csM() {
        if (this.iYt != null && this.cYa != null) {
            if (this.cYa.getCurrentItem() != 0) {
                this.iYt.qZ(false);
            } else if (this.iYG.ctc()) {
                this.iYt.qZ(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.iYt.qZ(eVar.ctm() == null || eVar.ctm().getValue() == null || eVar.ctm().getValue().booleanValue());
                }
            }
        }
    }

    private void yP(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(cni(), cmC(), i);
    }

    private int cmC() {
        if (clB() == null || clB().getPbData() == null || clB().getPbData().cku() == null) {
            return -1;
        }
        return clB().getPbData().cku().aCY();
    }

    public void qp(boolean z) {
        this.iOt = z;
    }

    public void qg(boolean z) {
        if (this.iOx != null && this.hgM != null) {
            this.hgM.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iOx.startAnimation(alphaAnimation);
            }
            this.iOw.setVisibility(0);
            this.iOx.setVisibility(0);
            this.iYG.iYZ = true;
        }
    }

    public void qh(boolean z) {
        if (this.iOx != null && this.hgM != null) {
            this.hgM.setText(cpm());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iOx.startAnimation(alphaAnimation);
            }
            this.iOw.setVisibility(0);
            this.iOx.setVisibility(0);
            this.iYG.iYZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null) {
            this.iCo = aVar;
            this.iYy.setText(aVar.getTitle());
            this.iYz.setText(aVar.ctJ());
            String ctK = aVar.ctK();
            TBSpecificationBtn tBSpecificationBtn = this.iYB;
            if (TextUtils.isEmpty(ctK)) {
                ctK = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(ctK);
            this.iYC.startLoad(aVar.getImage(), 10, false);
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
                @Override // java.lang.Runnable
                public void run() {
                    TiebaStatic.log(new an("c13608").cy("obj_id", VideoPbFragment.this.iCo.getTitle()).cy("obj_name", VideoPbFragment.this.iCo.ctJ()).X("obj_type", 2).cy("fid", VideoPbFragment.this.clB().getPbData().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("tid", VideoPbFragment.this.clB().getPbData().getThreadId()));
                    VideoPbFragment.this.csN();
                }
            }, aVar.ctL().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csN() {
        ViewGroup.LayoutParams layoutParams = this.iYw.getLayoutParams();
        if (layoutParams != null) {
            if (this.iYD == null || !this.iYD.isRunning()) {
                this.iYw.setAlpha(0.0f);
                this.iYw.setVisibility(0);
                f(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csO() {
        if (this.iYw.getLayoutParams() != null) {
            if (this.iYD == null || !this.iYD.isRunning()) {
                csP();
            }
        }
    }

    private void csP() {
        final ViewGroup.LayoutParams layoutParams = this.iYw.getLayoutParams();
        if (layoutParams != null) {
            if (this.iYE == null || !this.iYE.isRunning()) {
                this.iYE = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.iYE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.iYw.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.iYE.setDuration(200L);
                this.iYE.start();
                this.iYE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
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
        this.iYD = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.iYD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.hfk);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.hfk);
                VideoPbFragment.this.iYw.setLayoutParams(layoutParams);
                VideoPbFragment.this.CD.setLayoutParams(layoutParams2);
            }
        });
        this.iYD.setDuration(300L);
        this.iYD.start();
        this.iYD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.iYw.setVisibility(8);
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
        this.iYD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iYD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.hfk);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.iYw.setLayoutParams(layoutParams);
                VideoPbFragment.this.CD.setLayoutParams(layoutParams2);
            }
        });
        this.iYD.setDuration(300L);
        this.iYD.start();
        this.iYD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.csQ();
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
    public void csQ() {
        this.iYD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iYD.setDuration(300L);
        this.iYD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.iYw.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.iYD.start();
    }

    public String cpm() {
        if (!aq.isEmpty(this.iPt)) {
            return this.iPt;
        }
        this.iPt = TbadkCoreApplication.getInst().getResources().getString(com.baidu.tieba.pb.pb.main.am.cpb());
        return this.iPt;
    }

    public void cpH() {
        hideProgressBar();
        if (csT() != null) {
            csT().endLoadData();
            csT().cpI();
        }
    }

    public boolean ct(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && i.azO().isShowImages()) {
                    return FR(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (clB() == null || clB().getPbData() == null) {
                        return true;
                    }
                    if (this.iPc != null) {
                        this.iPc.cmj();
                    }
                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                    lVar.a(clB().getPbData().getForum());
                    lVar.setThreadData(clB().getPbData().cku());
                    lVar.f(postData);
                    this.iGY.d(lVar);
                    this.iGY.setPostId(postData.getId());
                    b(view, postData.aCo().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.iHQ != null) {
                        qp(this.iHQ.aOZ());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void csR() {
        if (this.iHQ != null) {
            qp(this.iHQ.aOZ());
        }
        cpk();
        this.iYF.cpY();
    }

    private boolean FR(String str) {
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

    public void bWs() {
        if (this.iOf != null) {
            this.iOf.setVisibility(0);
        }
    }

    public void bWr() {
        if (this.iOf != null) {
            this.iOf.setVisibility(8);
        }
    }

    public void zv(int i) {
        if (this.iYq != null) {
            this.iYq.setVisibility(i);
        }
    }

    public void cpF() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a cmH() {
        return this.iIC;
    }

    public void cpg() {
        if (this.FO != null) {
            this.FO.hide();
        }
    }

    public void bEl() {
        if (this.iHb.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iHb.getCurrentFocus());
        }
    }

    public void H(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cku() != null) {
            String valueOf = String.valueOf(eVar.cku().aCf());
            if (eVar.cku().aCf() == 0) {
                valueOf = "";
            }
            this.iYo.wi(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        for (BaseFragment baseFragment : this.iYp.ctd()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, eVar, str, i4);
            }
        }
        b(z, i, i2, i3, eVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (clB() != null && clB().getPbData() != null && clB().getPbData().cku() != null && clB().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(iOV)).intValue();
                if (intValue == iOW) {
                    if (!this.fKy.cLO()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.fKy.Jg(aq.O(jSONArray));
                        }
                        this.fKy.a(clB().getPbData().getForum().getId(), clB().getPbData().getForum().getName(), clB().getPbData().cku().getId(), str, intValue3, intValue2, booleanValue, clB().getPbData().cku().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == iOX || intValue == iOZ) {
                    if (clB().coa() != null) {
                        clB().coa().yI(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == iOX) {
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
    public int aUz() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aUA() {
        if (this.dMn == null) {
            this.dMn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aUM */
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
        return this.dMn;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aUB() {
        if (this.dPb == null) {
            this.dPb = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dPb;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aUC() {
        if (this.dMo == null) {
            this.dMo = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bGZ */
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
                    gifView.aPO();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.dMo;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aUD() {
        if (this.dPc == null) {
            this.dPc = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnl */
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
                    ((PlayVoiceBntNew) view).cMh();
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
        return this.dPc;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aUE() {
        if (this.dPd == null) {
            this.dPd = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnn */
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
        return this.dPd;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aUF() {
        this.dPe = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cnm */
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
        return this.dPe;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iHm = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str, boolean z) {
        if (as.Gh(str) && clB() != null && clB().cny() != null) {
            TiebaStatic.log(new an("c11664").X("obj_param1", 1).cy("post_id", clB().cny()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.dvD = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            as.cqB().c(getPageContext(), str);
        }
        this.iHm = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aD(Context context, String str) {
        as.cqB().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.iHm = true;
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
            this.iYF.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b ctw = this.iYF.ctw();
            if (ctw == null) {
                this.iYF.cmx();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                ctw.getItemView(1).setVisibility(8);
            } else {
                ctw.getItemView(1).setVisibility(0);
            }
            ctw.aED();
            this.iHm = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            ba.aGG().b(getPageContext(), new String[]{str});
            this.iHm = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a csS() {
        return this.dab;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener aSp() {
        return this.drA;
    }

    public ReplyFragment csT() {
        if (this.iYp == null || !(this.iYp.zw(iYm) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.iYp.zw(iYm);
    }

    public DetailInfoFragment csU() {
        if (this.iYp == null || !(this.iYp.zw(iYl) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.iYp.zw(iYl);
    }

    public boolean clr() {
        PbModel clB = this.iHb.clB();
        if (clB == null) {
            return false;
        }
        return clB.clr();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData ckD;
        PbModel clB = this.iHb.clB();
        if (clB != null && clB.getPbData() != null && !clB.getPbData().ckS()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = clB.getPbData().cku().getId();
            if (clB.isShareThread() && clB.getPbData().cku().cTQ != null) {
                historyMessage.threadName = clB.getPbData().cku().cTQ.showText;
            } else {
                historyMessage.threadName = clB.getPbData().cku().getTitle();
            }
            if (clB.isShareThread() && !clr()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = clB.getPbData().getForum().getName();
            }
            ArrayList<PostData> ckw = clB.getPbData().ckw();
            int cpJ = csT() != null ? csT().cpJ() : 0;
            if (ckw != null && cpJ >= 0 && cpJ < ckw.size()) {
                historyMessage.postID = ckw.get(cpJ).getId();
            }
            historyMessage.isHostOnly = clB.getHostMode();
            historyMessage.isSquence = clB.cnz();
            historyMessage.isShareThread = clB.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.iHQ != null) {
            this.iHQ.onDestroy();
        }
        if (clB != null && (clB.cnA() || clB.cnC())) {
            Intent intent = new Intent();
            intent.putExtra("tid", clB.cny());
            if (this.iHE) {
                if (this.iHG) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", clB.bxQ());
                }
                if (this.iHF) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", clB.getIsGood());
                }
            }
            if (clB.getPbData() != null && System.currentTimeMillis() - this.iHi >= 40000 && (ckD = clB.getPbData().ckD()) != null && !v.isEmpty(ckD.getDataList())) {
                intent.putExtra("guess_like_data", ckD);
            }
            PbActivity pbActivity = this.iHb;
            PbActivity pbActivity2 = this.iHb;
            pbActivity.setResult(-1, intent);
        }
        if (cmO()) {
            if (clB != null) {
                com.baidu.tieba.pb.data.e pbData = clB.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.iHo) {
                        if (this.iYs != null) {
                            Rect rect = new Rect();
                            this.iYs.getGlobalVisibleRect(rect);
                            ah.coQ().h(rect);
                        }
                        ah.coQ().zb(this.cYa.getCurrentItem());
                        BdTypeRecyclerView bGF = bGF();
                        Parcelable parcelable = null;
                        if (bGF != null) {
                            parcelable = bGF.onSaveInstanceState();
                        }
                        ah.coQ().a(clB.cnH(), parcelable, clB.cnz(), clB.getHostMode(), false);
                    }
                }
            } else {
                ah.coQ().reset();
            }
            clO();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.iYt != null && !this.iYt.bim()) {
            if ((this.iYt.isFullScreen() && configuration.orientation == 1) || (!this.iYt.isFullScreen() && configuration.orientation == 2)) {
                this.iYt.ra(false);
            }
        }
    }

    public boolean csV() {
        if (this.iYt == null) {
            return false;
        }
        return this.iYt.bim();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.cKa().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        public boolean iYZ;
        public boolean iZa;

        private a() {
            this.iZa = true;
        }

        public boolean ctc() {
            return (this.iYZ && this.iZa) ? false : true;
        }
    }

    public void csW() {
        this.iHw = -1;
        this.iHx = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cne() {
        if (clB() != null && !aq.isEmpty(clB().cny())) {
            com.baidu.tbadk.BdToken.c.axz().o(com.baidu.tbadk.BdToken.b.cGL, com.baidu.adp.lib.f.b.toLong(clB().cny(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.iYr.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csX() {
        if (this.iYQ == null) {
            this.iYQ = ObjectAnimator.ofFloat(this.iYv, "alpha", 0.0f, 1.0f);
            this.iYQ.setDuration(200L);
        }
        this.iYQ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csY() {
        if (this.iYR == null) {
            this.iYR = ObjectAnimator.ofFloat(this.iYv, "alpha", 1.0f, 0.0f);
            this.iYR.setDuration(200L);
        }
        this.iYR.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean csZ() {
        return this.iYt != null && this.iYt.cta();
    }

    public boolean cta() {
        return this.iYM;
    }

    public void qS(boolean z) {
        this.iYM = z;
    }
}
