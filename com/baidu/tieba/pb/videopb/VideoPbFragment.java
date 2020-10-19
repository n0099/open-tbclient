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
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.data.u;
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
import com.baidu.tbadk.widget.richText.f;
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
/* loaded from: classes22.dex */
public class VideoPbFragment extends BaseFragment implements VoiceManager.c, TbRichTextView.c, i, com.baidu.tieba.pb.videopb.a, b {
    private AppBarLayout Yg;
    private EditorTools abj;
    private ImageView agR;
    private CustomViewPager ewX;
    public View fjs;
    private com.baidu.adp.lib.d.b<ImageView> fry;
    private com.baidu.adp.lib.d.b<GifView> frz;
    private com.baidu.adp.lib.d.b<TextView> fuR;
    private com.baidu.adp.lib.d.b<View> fuS;
    private com.baidu.adp.lib.d.b<LinearLayout> fuT;
    private com.baidu.adp.lib.d.b<RelativeLayout> fuU;
    private ImageView gpI;
    private com.baidu.tieba.callfans.a hGy;
    private VoiceManager ioV;
    private com.baidu.tieba.f.b itR;
    private com.baidu.tieba.frs.profession.permission.c itr;
    private com.baidu.tieba.pb.videopb.c.a kVi;
    public am kdd;
    public bb khj;
    private PbFakeFloorModel laH;
    private PbActivity laM;
    private g lbC;
    private com.baidu.tbadk.editortools.pb.e lbD;
    private com.baidu.tieba.frs.profession.permission.c lbF;
    private EmotionImageData lbG;
    private com.baidu.tbadk.core.view.c lbK;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lbe;
    int lbh;
    private View liS;
    private v ljS;
    private View ljj;
    private LinearLayout ljl;
    private HeadImageView ljm;
    private ImageView ljn;
    private ImageView ljo;
    private ImageView ljp;
    private com.baidu.tieba.pb.view.c ljq;
    private TextView ljr;
    private TextView ljs;
    private int lju;
    private int ljv;
    private String lkj;
    public View loT;
    private View ltA;
    private VideoContainerLayout ltB;
    private com.baidu.tieba.pb.videopb.videoView.a ltC;
    private f ltD;
    private View ltE;
    private View ltF;
    private TextView ltH;
    private TextView ltI;
    private ImageView ltJ;
    private TBSpecificationBtn ltK;
    private TbImageView ltL;
    private View ltM;
    private ValueAnimator ltN;
    private ValueAnimator ltO;
    public com.baidu.tieba.pb.videopb.b.a ltP;
    private float ltT;
    private float ltU;
    private boolean ltV;
    private ObjectAnimator ltZ;
    private NewPagerSlidingTabBaseStrip ltx;
    private VideoPbFragmentAdapter lty;
    private View ltz;
    private ObjectAnimator lua;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int ltt = 0;
    public static int ltu = 1;
    public static int ltv = 0;
    public static int ljK = 3;
    public static int ljL = 0;
    public static int ljM = 3;
    public static int ljN = 4;
    public static int ljO = 5;
    public static int ljP = 6;
    private static final int joa = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int ltw = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a lcD = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void cu(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.ddE();
            } else {
                com.baidu.tieba.pb.a.b.ddD();
            }
        }
    };
    private long laT = 0;
    private boolean lba = false;
    View.OnClickListener ltG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.kVi == null || VideoPbFragment.this.kVi.dms()) {
                if (VideoPbFragment.this.kVi != null) {
                    if (VideoPbFragment.this.kVi.isChushou) {
                        VideoPbFragment.this.ex(VideoPbFragment.this.kVi.thirdRoomId, VideoPbFragment.this.kVi.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.kVi.dmt();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null && VideoPbFragment.this.ddQ().getPbData().getForum() != null) {
                        TiebaStatic.log(new aq("c13713").dK("fid", VideoPbFragment.this.ddQ().getPbData().getForum().getId()).dK("fname", VideoPbFragment.this.ddQ().getPbData().getForum().getName()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("tid", VideoPbFragment.this.ddQ().getPbData().getThreadId()).u("obj_param1", VideoPbFragment.this.kVi.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new aq("c13590").dK("obj_id", VideoPbFragment.this.kVi.getTitle()).dK("obj_name", VideoPbFragment.this.kVi.dmp()).aj("obj_type", 2).dK("fid", VideoPbFragment.this.ddQ().getPbData().getForumId()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("tid", VideoPbFragment.this.ddQ().getPbData().getThreadId()));
            String link = VideoPbFragment.this.kVi.getLink();
            if (!TextUtils.isEmpty(link)) {
                if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                    be.bmY().b(VideoPbFragment.this.getPageContext(), new String[]{link});
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
    private com.baidu.tbadk.baseEditMark.a lbp = null;
    private com.baidu.tbadk.coreExtra.model.a ezg = null;
    private ForumManageModel hGw = null;
    private boolean laX = false;
    private View ljk = null;
    private TextView jrF = null;
    private boolean ljg = false;
    private String fbv = null;
    private boolean lbs = false;
    private boolean lbt = false;
    private boolean lbu = false;
    private boolean laZ = false;
    int[] lbg = new int[2];
    private int lbi = -1;
    private int lbj = Integer.MIN_VALUE;
    private int lbQ = 0;
    private int ltR = Integer.MIN_VALUE;
    private boolean bwE = false;
    private boolean kYN = com.baidu.tbadk.a.d.bdC();
    private final PbModel.a lct = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            h qM;
            VideoPbFragment.this.dia();
            VideoPbFragment.this.cNL();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.us(false);
            if (z && fVar != null) {
                bw dcA = fVar.dcA();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(fVar, i2);
                VideoPbFragment.this.J(fVar);
                com.baidu.tieba.pb.videopb.c.a ddf = fVar.ddf();
                if (ddf != null && !ddf.lvS) {
                    VideoPbFragment.this.a(ddf);
                }
                VideoPbFragment.this.K(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.lbp != null) {
                    VideoPbFragment.this.lbp.hU(fVar.bec());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.fbv = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.fbv) && VideoPbFragment.this.lbD != null && VideoPbFragment.this.lbD.bvf() != null && (qM = VideoPbFragment.this.lbD.bvf().qM(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.fbv)) {
                        ((View) qM).setOnClickListener(VideoPbFragment.this.fch);
                    }
                }
                if (VideoPbFragment.this.kdd != null && dcA != null && dcA.bih() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(dcA.bih());
                    VideoPbFragment.this.kdd.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.ddQ().dfO());
                        jSONObject.put("fid", VideoPbFragment.this.ddQ().getForumId());
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
                if ((!com.baidu.tbadk.a.d.bdE() || VideoPbFragment.this.dlt() != null) && VideoPbFragment.this.dlr() != null) {
                    if (com.baidu.tbadk.a.d.bdE()) {
                        if (i != -1) {
                            ArrayList<PostData> arrayList = null;
                            if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null) {
                                arrayList = VideoPbFragment.this.ddQ().getPbData().dcC();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dEp() == 1)) {
                                if (VideoPbFragment.this.dlt().dfo()) {
                                    VideoPbFragment.this.dlt().OZ(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dlt().OZ(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dlt().OY(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dlt().OY("");
                        }
                        VideoPbFragment.this.dlt().endLoadData();
                    } else {
                        if (i != -1) {
                            ArrayList<PostData> arrayList2 = null;
                            if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null) {
                                arrayList2 = VideoPbFragment.this.ddQ().getPbData().dcC();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 1 && arrayList2.get(0) != null && arrayList2.get(0).dEp() == 1)) {
                                if (VideoPbFragment.this.dlr().dfo()) {
                                    VideoPbFragment.this.dlr().OZ(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dlr().OZ(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dlr().OY(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dlr().OY("");
                        }
                        VideoPbFragment.this.dlr().endLoadData();
                    }
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.dDn().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0547a lcv = new a.InterfaceC0547a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0547a
        public void c(boolean z, boolean z2, String str) {
            VideoPbFragment.this.dia();
            if (z && VideoPbFragment.this.ddQ() != null) {
                if (VideoPbFragment.this.lbp != null) {
                    VideoPbFragment.this.lbp.hU(z2);
                }
                VideoPbFragment.this.ddQ().tX(z2);
                if (VideoPbFragment.this.ddQ().bec()) {
                    VideoPbFragment.this.deZ();
                } else if (com.baidu.tbadk.a.d.bdE() && VideoPbFragment.this.dlt() != null) {
                    VideoPbFragment.this.dlt().dmc();
                } else if (VideoPbFragment.this.dlr() != null) {
                    VideoPbFragment.this.dlr().dmc();
                }
                if (z2) {
                    if (VideoPbFragment.this.lbp != null) {
                        if (VideoPbFragment.this.lbp.bef() != null && VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null && VideoPbFragment.this.ddQ().getPbData().dcA() != null && VideoPbFragment.this.ddQ().getPbData().dcA().bih() != null) {
                            MarkData bef = VideoPbFragment.this.lbp.bef();
                            MetaData bih = VideoPbFragment.this.ddQ().getPbData().dcA().bih();
                            if (bef != null && bih != null) {
                                if (!at.equals(TbadkCoreApplication.getCurrentAccount(), bih.getUserId()) && !bih.hadConcerned()) {
                                    VideoPbFragment.this.ltP.b(bih);
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
                    VideoPbFragment.this.deW();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b fbz = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bvJ() {
            if (VideoPbFragment.this.khj == null || VideoPbFragment.this.khj.diS() == null || !VideoPbFragment.this.khj.diS().dNl()) {
                return !VideoPbFragment.this.Fj(am.ezb);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.khj.diS().dNn());
            if (VideoPbFragment.this.lbD != null && (VideoPbFragment.this.lbD.bwa() || VideoPbFragment.this.lbD.bwb())) {
                VideoPbFragment.this.lbD.a(false, VideoPbFragment.this.khj.diV());
            }
            VideoPbFragment.this.khj.uy(true);
            return true;
        }
    };
    private final CustomMessageListener lbX = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.ddQ() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.lbD != null) {
                    VideoPbFragment.this.uq(VideoPbFragment.this.lbD.bvT());
                }
                VideoPbFragment.this.dhD();
                VideoPbFragment.this.ltP.dir();
            }
        }
    };
    private CustomMessageListener lca = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
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
    private final CustomMessageListener iqx = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.bwE) {
                VideoPbFragment.this.dfr();
            }
        }
    };
    private CustomMessageListener lcu = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.64
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.deQ();
            }
        }
    };
    private CustomMessageListener lcm = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.ltP != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.ltP.lbL) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.ltP.cbz();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.ltP.getExtra();
                DataRes dataRes = aVar.mTb;
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
                    VideoPbFragment.this.ltP.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.ltP.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener lck = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.ltP != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.ltP.lbL) {
                VideoPbFragment.this.ltP.cbz();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.ddQ().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dcQ().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lbK.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.ltP.Dm(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.ltP.dfn();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (at.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.lbK.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lcl = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.ltP != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.ltP.lbL) {
                VideoPbFragment.this.ltP.cbz();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lbK.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (at.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.lbK.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b lbI = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bvJ() {
            if (VideoPbFragment.this.khj == null || VideoPbFragment.this.khj.diT() == null || !VideoPbFragment.this.khj.diT().dNl()) {
                return !VideoPbFragment.this.Fj(am.ezc);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.khj.diT().dNn());
            if (VideoPbFragment.this.ljS != null && VideoPbFragment.this.ljS.deA() != null && VideoPbFragment.this.ljS.deA().bwb()) {
                VideoPbFragment.this.ljS.deA().a(VideoPbFragment.this.khj.diV());
            }
            VideoPbFragment.this.khj.uz(true);
            return true;
        }
    };
    private final NewWriteModel.d fbF = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c13268");
                aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null) {
                    aqVar.dK("fid", VideoPbFragment.this.ddQ().getPbData().getForumId());
                }
                aqVar.dK("tid", VideoPbFragment.this.ddQ().dfO());
                aqVar.dK("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            VideoPbFragment.this.ctc();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.ddQ() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.ddQ().OT(postWriteCallBackData.getPostId());
                    if (com.baidu.tbadk.a.d.bdE() && VideoPbFragment.this.dlt() != null) {
                        VideoPbFragment.this.lbQ = VideoPbFragment.this.dlt().dic();
                        VideoPbFragment.this.ltR = VideoPbFragment.this.dlt().dmf();
                        VideoPbFragment.this.ddQ().cX(VideoPbFragment.this.lbQ, VideoPbFragment.this.ltR);
                    } else if (VideoPbFragment.this.dlr() != null) {
                        VideoPbFragment.this.lbQ = VideoPbFragment.this.dlr().dic();
                        VideoPbFragment.this.ltR = VideoPbFragment.this.dlr().dmf();
                        VideoPbFragment.this.ddQ().cX(VideoPbFragment.this.lbQ, VideoPbFragment.this.ltR);
                    }
                }
                if (VideoPbFragment.this.ewX != null) {
                    if (com.baidu.tbadk.a.d.bdE()) {
                        VideoPbFragment.this.ewX.setCurrentItem(VideoPbFragment.ltv);
                    } else {
                        VideoPbFragment.this.ewX.setCurrentItem(VideoPbFragment.ltu);
                    }
                }
                VideoPbFragment.this.ltP.dir();
                VideoPbFragment.this.khj.diR();
                if (VideoPbFragment.this.lbD != null) {
                    VideoPbFragment.this.uq(VideoPbFragment.this.lbD.bvT());
                }
                VideoPbFragment.this.dhz();
                VideoPbFragment.this.us(true);
                VideoPbFragment.this.ddQ().dgj();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (com.baidu.tbadk.a.d.bdE() && VideoPbFragment.this.dlt() != null) {
                                VideoPbFragment.this.dlt().dmc();
                            } else if (VideoPbFragment.this.dlr() != null) {
                                VideoPbFragment.this.dlr().dmc();
                            }
                        }
                    } else if (VideoPbFragment.this.ddQ().getHostMode()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.ddQ().getPbData();
                        if (pbData != null && pbData.dcA() != null && pbData.dcA().bih() != null && (userId = pbData.dcA().bih().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.ddQ().dga()) {
                            VideoPbFragment.this.dhY();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.ddQ().dga()) {
                        VideoPbFragment.this.dhY();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.tI(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.lbD.bwa() || VideoPbFragment.this.lbD.bwb()) {
                    VideoPbFragment.this.lbD.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.khj.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.kdd != null) {
                    VideoPbFragment.this.kdd.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.AH(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AH(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new aq("c13746").aj("obj_locate", 1).aj("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bkJ();
                TiebaStatic.log(new aq("c13745").aj("obj_locate", 1).aj("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener fch = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.fbv);
        }
    };
    private CustomMessageListener lbZ = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.lbD != null) {
                    VideoPbFragment.this.uq(VideoPbFragment.this.lbD.bvT());
                }
                VideoPbFragment.this.us(false);
            }
        }
    };
    private int ltS = 0;
    private boolean ltW = true;
    private View.OnTouchListener ltX = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.ltS == 1) {
                if (!VideoPbFragment.this.ltW) {
                    VideoPbFragment.this.dlw();
                    UtilHelper.showStatusBar(VideoPbFragment.this.dfv(), VideoPbFragment.this.dfv().getRootView());
                    VideoPbFragment.this.ltW = true;
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(VideoPbFragment.this.ltY);
                    com.baidu.adp.lib.f.e.mY().postDelayed(VideoPbFragment.this.ltY, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (VideoPbFragment.this.ltS == 2 && (VideoPbFragment.this.ltW || VideoPbFragment.this.dly())) {
                VideoPbFragment.this.dlx();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dfv(), VideoPbFragment.this.dfv().getRootView());
                VideoPbFragment.this.ltW = false;
                if (VideoPbFragment.this.ltC != null) {
                    VideoPbFragment.this.ltC.uU(false);
                }
            }
            VideoPbFragment.this.ltS = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener iAX = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.ltS = 0;
            VideoPbFragment.this.ltT = 0.0f;
            VideoPbFragment.this.ltU = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.ltT += f;
            VideoPbFragment.this.ltU += f2;
            if (VideoPbFragment.this.ltS == 0 && !VideoPbFragment.this.ltV && VideoPbFragment.this.ltC != null && !VideoPbFragment.this.ltC.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.ltU) <= Math.abs(VideoPbFragment.this.ltT) || VideoPbFragment.this.ltU > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.ltU) > Math.abs(VideoPbFragment.this.ltT) && VideoPbFragment.this.ltU > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.ltS = 2;
                    }
                } else {
                    VideoPbFragment.this.ltS = 1;
                }
            }
            return true;
        }
    };
    private Runnable ltY = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.ltW && !VideoPbFragment.this.dly()) {
                VideoPbFragment.this.dlx();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dfv(), VideoPbFragment.this.dfv().getRootView());
                VideoPbFragment.this.ltW = false;
            }
        }
    };
    private final com.baidu.adp.base.d hGD = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.ddQ() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.hGw.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.hGw.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.ddQ().dgj();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.lqP != 1002 || bVar.gyX) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.QO, dVar.mGW, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.hGw.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.hGw.getLoadDataMode(), gVar.QO, gVar.mGW, false);
                    VideoPbFragment.this.ltP.aZ(gVar.mGZ);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener fkK = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.itR.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d lcr = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c13268");
                aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null) {
                    aqVar.dK("fid", VideoPbFragment.this.ddQ().getPbData().getForumId());
                }
                if (VideoPbFragment.this.ddQ() != null) {
                    aqVar.dK("tid", VideoPbFragment.this.ddQ().dfO());
                }
                aqVar.dK("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (VideoPbFragment.this.khj != null) {
                    VideoPbFragment.this.khj.diQ();
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
                if (VideoPbFragment.this.kdd != null) {
                    VideoPbFragment.this.kdd.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.AH(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AH(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new aq("c13746").aj("obj_locate", 1).aj("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bkJ();
                TiebaStatic.log(new aq("c13745").aj("obj_locate", 1).aj("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.khj != null) {
                if (VideoPbFragment.this.ljS != null && VideoPbFragment.this.ljS.deA() != null && VideoPbFragment.this.ljS.deA().bwb()) {
                    VideoPbFragment.this.ljS.deA().a(postWriteCallBackData);
                }
                VideoPbFragment.this.khj.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c fby = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bvK() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener aEX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
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
                    aqVar.dK("tid", VideoPbFragment.this.ddQ().dfO());
                    aqVar.dK("fid", VideoPbFragment.this.ddQ().getForumId());
                    aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.aj("obj_locate", 1);
                    TiebaStatic.log(aqVar);
                    if (VideoPbFragment.this.laX) {
                        VideoPbFragment.this.laX = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null && VideoPbFragment.this.laH != null && postData.bih() != null && postData.dEp() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.ljS != null) {
                                    VideoPbFragment.this.ljS.dew();
                                }
                                p pVar = new p();
                                pVar.a(VideoPbFragment.this.ddQ().getPbData().getForum());
                                pVar.setThreadData(VideoPbFragment.this.ddQ().getPbData().dcA());
                                pVar.g(postData);
                                VideoPbFragment.this.laH.d(pVar);
                                VideoPbFragment.this.laH.setPostId(postData.getId());
                                VideoPbFragment.this.a(view, postData.bih().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.ddQ().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.lbD != null) {
                                    VideoPbFragment.this.uq(VideoPbFragment.this.lbD.bvT());
                                }
                            }
                        }
                    }
                } else if ((VideoPbFragment.this.dlr() != null && VideoPbFragment.this.dlr().din() != null && view == VideoPbFragment.this.dlr().din()) || ((com.baidu.tbadk.a.d.bdE() && VideoPbFragment.this.dlt() != null && VideoPbFragment.this.dlt().din() != null && view == VideoPbFragment.this.dlt().din()) || view.getId() == R.id.pb_more)) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.ddQ().tV(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        if (com.baidu.tbadk.a.d.bdE()) {
                            VideoPbFragment.this.dlt().dhZ();
                        } else {
                            VideoPbFragment.this.dlr().dhZ();
                        }
                    }
                } else if (VideoPbFragment.this.ltP != null && VideoPbFragment.this.ltP.djy() != null && view == VideoPbFragment.this.ltP.djy().dgY()) {
                    VideoPbFragment.this.ltP.aVi();
                } else if ((VideoPbFragment.this.ltP != null && ((VideoPbFragment.this.ltP.djy() != null && view == VideoPbFragment.this.ltP.djy().dgZ()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) || view.getId() == R.id.floor_owner_reply || view.getId() == R.id.reply_title) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.ltP.dir();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.ctc();
                        VideoPbFragment.this.dhY();
                        if (view.getId() == R.id.owner_reply) {
                            z = VideoPbFragment.this.ddQ().z(true, VideoPbFragment.this.dfd());
                        } else {
                            z = view.getId() == R.id.all_reply ? VideoPbFragment.this.ddQ().z(false, VideoPbFragment.this.dfd()) : VideoPbFragment.this.ddQ().OQ(VideoPbFragment.this.dfd());
                        }
                        view.setTag(Boolean.valueOf(z));
                        if (z) {
                            VideoPbFragment.this.cNM();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.fjs) {
                    if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null) {
                        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            aq aqVar2 = new aq("c13266");
                            aqVar2.dK("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar2.dK("fid", VideoPbFragment.this.ddQ().getPbData().getForumId());
                            aqVar2.dK("tid", VideoPbFragment.this.ddQ().dfO());
                            aqVar2.dK("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(aqVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.laM, VideoPbFragment.this.fjs);
                        VideoPbFragment.this.laM.finish();
                    }
                } else if (view == VideoPbFragment.this.loT && VideoPbFragment.this.ltP != null) {
                    if (VideoPbFragment.this.ddQ() == null || VideoPbFragment.this.ddQ().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> dcC = VideoPbFragment.this.ddQ().getPbData().dcC();
                    if ((dcC == null || dcC.size() <= 0) && VideoPbFragment.this.ddQ().dfQ()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new aq("c12378").dK("tid", VideoPbFragment.this.ddQ().dfO()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("fid", VideoPbFragment.this.ddQ().getForumId()));
                    VideoPbFragment.this.ltP.deR();
                } else if (VideoPbFragment.this.ltP.djy() != null && view == VideoPbFragment.this.ltP.djy().dhd()) {
                    if (VideoPbFragment.this.ddQ() != null) {
                        VideoPbFragment.this.ltP.dir();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.ctc();
                            VideoPbFragment.this.dhY();
                            VideoPbFragment.this.ddQ().Fp(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.ltP != null && VideoPbFragment.this.ltP.djy() != null && view == VideoPbFragment.this.ltP.djy().dgZ()) {
                    VideoPbFragment.this.ltP.aVi();
                } else if (VideoPbFragment.this.ltP != null && ((VideoPbFragment.this.ltP.djy() != null && view == VideoPbFragment.this.ltP.djy().dhg()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                    VideoPbFragment.this.ltP.dir();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.ctc();
                            VideoPbFragment.this.dhY();
                            VideoPbFragment.this.ltP.dm(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.ddQ().dgh()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.ltP != null && VideoPbFragment.this.ltP.djy() != null && view == VideoPbFragment.this.ltP.djy().dgX()) {
                    if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null && VideoPbFragment.this.ddQ().getPbData().dcA() != null) {
                        VideoPbFragment.this.ltP.aVi();
                        TiebaStatic.log(new aq("c13062"));
                        VideoPbFragment.this.ltP.OL(VideoPbFragment.this.ddQ().getPbData().dcA().biy());
                    }
                } else if (view.getId() == R.id.pb_floor_feedback) {
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (VideoPbFragment.this.ltP != null) {
                        VideoPbFragment.this.ltP.f(sparseArray);
                    }
                } else if (VideoPbFragment.this.ltP != null && VideoPbFragment.this.ltP.djy() != null && view == VideoPbFragment.this.ltP.djy().dhh()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        ap.C(true, false);
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).aj("obj_type", 0).aj("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).aj("obj_type", 1).aj("obj_source", 1));
                    }
                    VideoPbFragment.this.ltP.djx();
                } else if (VideoPbFragment.this.ltP != null && (view == VideoPbFragment.this.ltP.dhW() || (VideoPbFragment.this.ltP.djy() != null && (view == VideoPbFragment.this.ltP.djy().dhc() || view == VideoPbFragment.this.ltP.djy().dha())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.ddQ() != null || VideoPbFragment.this.ddQ().getPbData() != null) {
                        if ((VideoPbFragment.this.ddQ().getPbData().dcP() == 1 || VideoPbFragment.this.ddQ().getPbData().dcP() == 3) && !VideoPbFragment.this.hGw.dFa()) {
                            VideoPbFragment.this.ltP.dir();
                            if (VideoPbFragment.this.ltP.djy() != null && view == VideoPbFragment.this.ltP.djy().dha()) {
                                if (VideoPbFragment.this.ddQ().getPbData().dcA().bic() == 1) {
                                    i2 = 5;
                                } else {
                                    i2 = 4;
                                }
                            } else if (VideoPbFragment.this.ltP.djy() != null && view == VideoPbFragment.this.ltP.djy().dhc()) {
                                if (VideoPbFragment.this.ddQ().getPbData().dcA().bid() != 1) {
                                    i2 = 6;
                                }
                            } else {
                                i2 = view == VideoPbFragment.this.ltP.dhW() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.ddQ().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.ddQ().getPbData().dcA().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.hGw.b(id, name, id2, i2, VideoPbFragment.this.ltP.dhX());
                        }
                    }
                } else if (VideoPbFragment.this.ltP != null && VideoPbFragment.this.ltP.djy() != null && view == VideoPbFragment.this.ltP.djy().dhf()) {
                    if (VideoPbFragment.this.ddQ() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.ltP.dir();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.ddQ().getPbData(), VideoPbFragment.this.ddQ().dfQ(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.ddQ().getPbData().getForum().getId(), VideoPbFragment.this.ddQ().getPbData().getForum().getName(), VideoPbFragment.this.ddQ().getPbData().dcA().getId(), String.valueOf(VideoPbFragment.this.ddQ().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.ltP != null && VideoPbFragment.this.ltP.djy() != null && view == VideoPbFragment.this.ltP.djy().dhb()) {
                    if (VideoPbFragment.this.ddQ() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.ddQ().getPbData(), VideoPbFragment.this.ddQ().dfQ(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.ltP.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.ltP.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.ltP.aVi();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        aq aqVar3 = new aq("c13398");
                        aqVar3.dK("tid", VideoPbFragment.this.ddQ().dfO());
                        aqVar3.dK("fid", VideoPbFragment.this.ddQ().getForumId());
                        aqVar3.dK("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar3.aj("obj_locate", 4);
                        TiebaStatic.log(aqVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new aq("c10517").aj("obj_locate", 3).dK("fid", VideoPbFragment.this.ddQ().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null) {
                        if (VideoPbFragment.this.ltP != null) {
                            VideoPbFragment.this.ltP.dir();
                        }
                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                        PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                        PostData postData3 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                        if (postData2 != null) {
                            if (postData2.dEB() == 1) {
                                TiebaStatic.log(new aq("c12630"));
                            }
                            if (postData2.mFc != null) {
                                aq bmQ = postData2.mFc.bmQ();
                                bmQ.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    bmQ.aj("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    bmQ.aj("obj_locate", 8);
                                }
                                TiebaStatic.log(bmQ);
                            }
                            VideoPbFragment.this.ctc();
                            TiebaStatic.log("c11742");
                            if (postData3 != null) {
                                VideoPbFragment.this.a(postData2, postData3, false, true);
                            } else {
                                VideoPbFragment.this.a(postData2, (PostData) null, false, false);
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                    if (VideoPbFragment.this.ddQ() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            aq aqVar4 = new aq("c13398");
                            aqVar4.dK("tid", VideoPbFragment.this.ddQ().dfO());
                            aqVar4.dK("fid", VideoPbFragment.this.ddQ().getForumId());
                            aqVar4.dK("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar4.aj("obj_locate", 6);
                            TiebaStatic.log(aqVar4);
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData4.mFc != null) {
                                    aq bmQ2 = postData4.mFc.bmQ();
                                    bmQ2.delete("obj_locate");
                                    bmQ2.aj("obj_locate", 8);
                                    TiebaStatic.log(bmQ2);
                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                    TiebaStatic.log(new aq("c13700").dK("tid", VideoPbFragment.this.ddQ().dfP()).dK("fid", VideoPbFragment.this.ddQ().getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dK("post_id", postData4.getId()).aj("obj_type", 3));
                                }
                                if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null && VideoPbFragment.this.laH != null && postData4.bih() != null && postData4.dEp() != 1) {
                                    if (VideoPbFragment.this.ljS != null) {
                                        VideoPbFragment.this.ljS.dew();
                                    }
                                    if ((VideoPbFragment.this.kYN || com.baidu.tbadk.a.d.bds()) && postData4.dEm() != null && postData4.dEm().size() != 0) {
                                        if (com.baidu.tbadk.a.d.bdt()) {
                                            VideoPbFragment.this.a(postData4, (PostData) null, false, false);
                                            return;
                                        } else {
                                            VideoPbFragment.this.a(postData4, (PostData) null, true, false);
                                            return;
                                        }
                                    }
                                    p pVar2 = new p();
                                    pVar2.a(VideoPbFragment.this.ddQ().getPbData().getForum());
                                    pVar2.setThreadData(VideoPbFragment.this.ddQ().getPbData().dcA());
                                    pVar2.g(postData4);
                                    VideoPbFragment.this.laH.d(pVar2);
                                    VideoPbFragment.this.laH.setPostId(postData4.getId());
                                    VideoPbFragment.this.a(view, postData4.bih().getUserId(), "", postData4);
                                    if (VideoPbFragment.this.lbD != null) {
                                        VideoPbFragment.this.uq(VideoPbFragment.this.lbD.bvT());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.ltP != null && VideoPbFragment.this.ddQ() != null) {
                        if (com.baidu.tbadk.a.d.bdE() || VideoPbFragment.this.dlr() != null) {
                            if (!com.baidu.tbadk.a.d.bdE() || VideoPbFragment.this.dlt() != null) {
                                VideoPbFragment.this.ltP.dir();
                                if (VideoPbFragment.this.Fk(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.ddQ() != null) {
                                    VideoPbFragment.this.deY();
                                    if (VideoPbFragment.this.ddQ().getPbData() != null && VideoPbFragment.this.ddQ().getPbData().dcA() != null && VideoPbFragment.this.ddQ().getPbData().dcA().bih() != null) {
                                        TiebaStatic.log(new aq("c13402").dK("tid", VideoPbFragment.this.ddQ().dfO()).dK("fid", VideoPbFragment.this.ddQ().getPbData().getForumId()).aj("obj_locate", 3).dK("uid", VideoPbFragment.this.ddQ().getPbData().dcA().bih().getUserId()));
                                    }
                                    if (VideoPbFragment.this.ddQ().getPbData().dcA() != null && VideoPbFragment.this.ddQ().getPbData().dcA().bih() != null && VideoPbFragment.this.ddQ().getPbData().dcA().bih().getUserId() != null && VideoPbFragment.this.lbp != null) {
                                        int h = VideoPbFragment.this.ltP.h(VideoPbFragment.this.ddQ().getPbData());
                                        bw dcA = VideoPbFragment.this.ddQ().getPbData().dcA();
                                        if (!dcA.bgP()) {
                                            if (dcA.bgQ()) {
                                                i = 3;
                                            } else if (dcA.bkc()) {
                                                i = 4;
                                            } else {
                                                i = dcA.bkd() ? 5 : 1;
                                            }
                                        }
                                        TiebaStatic.log(new aq("c12526").dK("tid", VideoPbFragment.this.ddQ().dfO()).aj("obj_locate", 1).dK("obj_id", VideoPbFragment.this.ddQ().getPbData().dcA().bih().getUserId()).aj("obj_type", VideoPbFragment.this.lbp.bec() ? 0 : 1).aj("obj_source", h).aj("obj_param1", i));
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.uS(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ltP != null && VideoPbFragment.this.ewX != null && VideoPbFragment.this.ddQ().getPbData() != null && VideoPbFragment.this.ddQ().getPbData().dcA() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.ddQ().getPbData();
                        if (pbData.dcA().bhY() != 0) {
                            int currentItem = VideoPbFragment.this.ewX.getCurrentItem();
                            if (!com.baidu.tbadk.a.d.bdE() && currentItem == VideoPbFragment.ltt) {
                                VideoPbFragment.this.ewX.setCurrentItem(VideoPbFragment.ltu);
                            } else if (com.baidu.tbadk.a.d.bdE() || currentItem == VideoPbFragment.ltu) {
                                if (!com.baidu.tbadk.a.d.bdE() && VideoPbFragment.this.dlr() == null) {
                                    return;
                                }
                                if ((!com.baidu.tbadk.a.d.bdE() || VideoPbFragment.this.dlt() != null) && VideoPbFragment.this.cvV() != null) {
                                    aq dK = new aq("c13403").dK("tid", VideoPbFragment.this.ddQ().dfO()).dK("fid", VideoPbFragment.this.ddQ().getPbData().getForumId()).dK("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView cvV = VideoPbFragment.this.cvV();
                                    if (cvV != null) {
                                        boolean canScrollVertically = cvV.canScrollVertically(1);
                                        boolean canScrollVertically2 = cvV.canScrollVertically(-1);
                                        if (VideoPbFragment.this.Yg != null) {
                                            VideoPbFragment.this.Yg.setExpanded(false, true);
                                        }
                                        if (cvV.getLayoutManager() != null && (cvV.getLayoutManager() instanceof LinearLayoutManager)) {
                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) cvV.getLayoutManager();
                                            if (!canScrollVertically2 && canScrollVertically) {
                                                if (VideoPbFragment.this.lbi != -1 || VideoPbFragment.this.lbj != Integer.MIN_VALUE) {
                                                    if (VideoPbFragment.this.lbi > 3 || (VideoPbFragment.this.lbi == 3 && VideoPbFragment.this.lbj < (-equipmentHeight))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lbi, VideoPbFragment.this.lbj + equipmentHeight);
                                                        cvV.smoothScrollBy(0, equipmentHeight);
                                                    } else if (VideoPbFragment.this.lbi >= 2) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lbi, VideoPbFragment.this.lbj + (equipmentHeight / 2));
                                                        cvV.smoothScrollBy(0, equipmentHeight / 2);
                                                    } else if (VideoPbFragment.this.lbi == 1) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lbi, VideoPbFragment.this.lbj + (equipmentHeight / 4));
                                                        cvV.smoothScrollBy(0, equipmentHeight / 4);
                                                    } else {
                                                        cvV.smoothScrollBy(0, -VideoPbFragment.this.lbj);
                                                    }
                                                    dK.aj("obj_locate", 2);
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                int firstVisiblePosition = cvV.getFirstVisiblePosition();
                                                View childAt = cvV.getChildAt(0);
                                                int top = childAt == null ? 0 : childAt.getTop();
                                                VideoPbFragment.this.lbi = firstVisiblePosition;
                                                VideoPbFragment.this.lbj = top;
                                                if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && cvV.getCount() >= 6)) {
                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                    cvV.smoothScrollToPosition(0);
                                                } else {
                                                    cvV.smoothScrollToPosition(0);
                                                }
                                                dK.aj("obj_locate", 1);
                                            }
                                            TiebaStatic.log(dK);
                                            TiebaStatic.log(new aq("c12942").aj("obj_type", 1).aj("obj_locate", 4).dK("tid", VideoPbFragment.this.ddQ().dfO()).dK("nid", pbData.dcA().getNid()));
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
                            if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null && VideoPbFragment.this.ddQ().getPbData().dcA() != null && VideoPbFragment.this.ddQ().getPbData().dcA().bih() != null) {
                                TiebaStatic.log(new aq("c13402").dK("tid", VideoPbFragment.this.ddQ().dfO()).dK("fid", VideoPbFragment.this.ddQ().getPbData().getForumId()).aj("obj_locate", 2).dK("uid", VideoPbFragment.this.ddQ().getPbData().dcA().bih().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.uT(false);
                        VideoPbFragment.this.deM();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.lbQ >= 0) {
                        if (VideoPbFragment.this.ddQ() != null) {
                            VideoPbFragment.this.ddQ().dgz();
                        }
                        if (com.baidu.tbadk.a.d.bdE() && VideoPbFragment.this.dlt() != null && VideoPbFragment.this.dlt().dma() != null) {
                            VideoPbFragment.this.dlt().dma().setData(VideoPbFragment.this.ddQ().getPbData());
                        } else if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.dlr() != null && VideoPbFragment.this.dlr().dma() != null) {
                            VideoPbFragment.this.dlr().dma().setData(VideoPbFragment.this.ddQ().getPbData());
                        }
                        VideoPbFragment.this.lbQ = 0;
                        VideoPbFragment.this.ltR = Integer.MIN_VALUE;
                        if (com.baidu.tbadk.a.d.bdE() && VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.dlt() != null) {
                            VideoPbFragment.this.dlt().da(VideoPbFragment.this.ddQ().dgC(), VideoPbFragment.this.ddQ().dgD());
                            VideoPbFragment.this.ddQ().cX(0, 0);
                        } else if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.dlr() != null) {
                            VideoPbFragment.this.dlr().da(VideoPbFragment.this.ddQ().dgC(), VideoPbFragment.this.ddQ().dgD());
                            VideoPbFragment.this.ddQ().cX(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.ddQ() != null) {
                        aq aqVar5 = new aq("c13398");
                        aqVar5.dK("tid", VideoPbFragment.this.ddQ().dfO());
                        aqVar5.dK("fid", VideoPbFragment.this.ddQ().getForumId());
                        aqVar5.dK("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar5.aj("obj_locate", 2);
                        TiebaStatic.log(aqVar5);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bg.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.blO().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.dhD();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.dhD();
                } else if (VideoPbFragment.this.ltP.djy() != null && view == VideoPbFragment.this.ltP.djy().dhe()) {
                    VideoPbFragment.this.ltP.dir();
                    if (VideoPbFragment.this.ddQ() != null) {
                        VideoPbFragment.this.hGy.setThreadId(VideoPbFragment.this.ddQ().dfO());
                    }
                    if (VideoPbFragment.this.ddQ() == null || !VideoPbFragment.this.ddQ().isPrivacy()) {
                        VideoPbFragment.this.hGy.cif();
                        if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null && VideoPbFragment.this.ddQ().getPbData().getThreadId() != null && VideoPbFragment.this.ddQ().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                            i3 = 2;
                        }
                        if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null) {
                            VideoPbFragment.this.hGy.k(3, i3, VideoPbFragment.this.ddQ().getPbData().getThreadId());
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                    if (VideoPbFragment.this.ddQ().getPbData() != null) {
                        VideoPbFragment.this.hGy.k(3, 3, VideoPbFragment.this.ddQ().getPbData().getThreadId());
                    }
                }
            }
        }
    };
    private View.OnClickListener kYf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.ltP != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.ltP.c(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.ltP.dg(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.ltP.c(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.ltP.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private CustomMessageListener jEs = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(VideoPbFragment.this.getPageContext(), VideoPbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    public SortSwitchButton.a lcp = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean yQ(int i) {
            if (VideoPbFragment.this.ltP != null) {
                VideoPbFragment.this.ltP.dir();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.ddQ() == null || VideoPbFragment.this.ddQ().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.ctc();
                VideoPbFragment.this.dhY();
                if (VideoPbFragment.this.ddQ().getPbData() != null && VideoPbFragment.this.ddQ().getPbData().kUy != null && VideoPbFragment.this.ddQ().getPbData().kUy.size() > i) {
                    int intValue = VideoPbFragment.this.ddQ().getPbData().kUy.get(i).sort_type.intValue();
                    TiebaStatic.log(new aq("c13699").dK("tid", VideoPbFragment.this.ddQ().dfP()).dK("fid", VideoPbFragment.this.ddQ().getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).aj("obj_type", Fn(intValue)));
                    if (VideoPbFragment.this.ddQ().Fu(intValue)) {
                        VideoPbFragment.this.mIsLoading = true;
                    }
                }
                return true;
            }
        }

        private int Fn(int i) {
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
    private a ltQ = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void deW() {
        if (ddQ() != null && ddQ().getPbData() != null && ddQ().getPbData().dcA() != null) {
            bw dcA = ddQ().getPbData().dcA();
            dcA.mRecomAbTag = ddQ().dgJ();
            dcA.mRecomWeight = ddQ().dgH();
            dcA.mRecomSource = ddQ().dgI();
            dcA.mRecomExtra = ddQ().dgK();
            if (dcA.getFid() == 0) {
                dcA.setFid(com.baidu.adp.lib.f.b.toLong(ddQ().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dcA, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(boolean z) {
        if (ddQ() != null && ddQ().getPbData() != null && ddQ().getPbData().dcA() != null) {
            bw dcA = ddQ().getPbData().dcA();
            dcA.mRecomAbTag = ddQ().dgJ();
            dcA.mRecomWeight = ddQ().dgH();
            dcA.mRecomSource = ddQ().dgI();
            dcA.mRecomExtra = ddQ().dgK();
            if (dcA.getFid() == 0) {
                dcA.setFid(com.baidu.adp.lib.f.b.toLong(ddQ().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dcA, "c13563");
            TbPageTag eu = com.baidu.tbadk.pageInfo.c.eu(getContext());
            if (a2 != null && eu != null && PageStayDurationConstants.PageName.VIDEO_LIST.equals(eu.locatePage)) {
                a2.dK("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dK("obj_pre_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            if (a2 != null) {
                a2.aj("reply_type", 1);
                if (z) {
                    a2.aj("obj_type", 2);
                } else {
                    a2.aj("obj_type", 1);
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
            String string = !TextUtils.isEmpty(bVar.mGW) ? bVar.mGW : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.AH(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.iz(true);
                aVar.b(getPageContext());
                aVar.bkJ();
            } else {
                a(0, bVar.QO, bVar.mGW, z);
            }
            if (bVar.QO) {
                if (bVar.hVJ == 1) {
                    ArrayList<PostData> dcC = ddQ().getPbData().dcC();
                    int size = dcC.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dcC.get(i).getId())) {
                            i++;
                        } else {
                            dcC.remove(i);
                            break;
                        }
                    }
                    ddQ().getPbData().dcA().nO(ddQ().getPbData().dcA().bhY() - 1);
                    if (com.baidu.tbadk.a.d.bdE() && dlt() != null) {
                        dlt().dmc();
                    } else if (dlr() != null) {
                        dlr().dmc();
                    }
                } else if (bVar.hVJ == 0) {
                    deX();
                } else if (bVar.hVJ == 2) {
                    ArrayList<PostData> dcC2 = ddQ().getPbData().dcC();
                    int size2 = dcC2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dcC2.get(i2).dEm().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dcC2.get(i2).dEm().get(i3).getId())) {
                                i3++;
                            } else {
                                dcC2.get(i2).dEm().remove(i3);
                                dcC2.get(i2).dEo();
                                z2 = true;
                                break;
                            }
                        }
                        dcC2.get(i2).Sb(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        if (com.baidu.tbadk.a.d.bdE() && dlt() != null) {
                            dlt().dmc();
                        } else if (dlr() != null) {
                            dlr().dmc();
                        }
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = ddQ().getPbData().dcO().kWd;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dEm().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dEm().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dEm().remove(i2);
                    list.get(i).dEo();
                    z = true;
                    break;
                }
            }
            list.get(i).Sb(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            if (com.baidu.tbadk.a.d.bdE() && dlt() != null) {
                dlt().dmc();
            } else if (dlr() != null) {
                dlr().dmc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && ddQ() != null && ddQ().getPbData() != null && ddQ().getPbData().dcA() != null) {
            a(this.hGw.getLoadDataMode(), gVar.QO, gVar.mGW, false);
            if (gVar.QO) {
                this.lbs = true;
                if (i == 2 || i == 3) {
                    this.lbt = true;
                    this.lbu = false;
                } else if (i == 4 || i == 5) {
                    this.lbt = false;
                    this.lbu = true;
                }
                if (i == 2) {
                    ddQ().getPbData().dcA().nR(1);
                    ddQ().setIsGood(1);
                } else if (i == 3) {
                    ddQ().getPbData().dcA().nR(0);
                    ddQ().setIsGood(0);
                } else if (i == 4) {
                    ddQ().getPbData().dcA().nQ(1);
                    ddQ().Fo(1);
                } else if (i == 5) {
                    ddQ().getPbData().dcA().nQ(0);
                    ddQ().Fo(0);
                }
            }
            if (ddQ().getPbData().dcA() != null && dls() != null) {
                dls().dmm();
            }
        }
    }

    private void deX() {
        if (ddQ().dfR() || ddQ().dfT()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", ddQ().dfO());
            PbActivity pbActivity = this.laM;
            PbActivity pbActivity2 = this.laM;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ddQ().dfO()));
        if (dfa()) {
            this.laM.finish();
        }
    }

    private boolean dfa() {
        if (ddQ() == null) {
            return true;
        }
        if (ddQ().getPbData() == null || !ddQ().getPbData().ddd()) {
            if (ddQ().bec()) {
                final MarkData dgi = ddQ().dgi();
                if (dgi == null || !ddQ().getIsFromMark() || cvV() == null) {
                    return true;
                }
                final MarkData Fv = ddQ().Fv(cvV().getFirstVisiblePosition());
                if (Fv == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dgi);
                    this.laM.setResult(-1, intent);
                    return true;
                } else if (Fv.getPostId() == null || Fv.getPostId().equals(dgi.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dgi);
                    this.laM.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.AH(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.lbp != null) {
                                if (VideoPbFragment.this.lbp.bec()) {
                                    VideoPbFragment.this.lbp.bed();
                                    VideoPbFragment.this.lbp.hU(false);
                                }
                                VideoPbFragment.this.lbp.a(Fv);
                                VideoPbFragment.this.lbp.hU(true);
                                VideoPbFragment.this.lbp.bee();
                            }
                            dgi.setPostId(Fv.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dgi);
                            VideoPbFragment.this.laM.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.ded();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dgi);
                            VideoPbFragment.this.laM.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.ded();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.bkJ();
                    return false;
                }
            } else if (ddQ().getPbData() == null || ddQ().getPbData().dcC() == null || ddQ().getPbData().dcC().size() <= 0 || !ddQ().getIsFromMark()) {
                return true;
            } else {
                this.laM.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ded() {
        this.laM.ded();
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
    public void uS(boolean z) {
        com.baidu.tieba.pb.data.f pbData;
        int i;
        if (ddQ() != null && this.ltP != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = ddQ().getPbData()) != null) {
                bw dcA = pbData.dcA();
                if (dcA != null && dcA.bih() != null) {
                    TiebaStatic.log(new aq("c13402").dK("tid", ddQ().dfO()).dK("fid", pbData.getForumId()).aj("obj_locate", 4).dK("uid", dcA.bih().getUserId()));
                }
                if (dcA != null) {
                    if (dcA.bgP()) {
                        i = 2;
                    } else if (dcA.bgQ()) {
                        i = 3;
                    } else if (dcA.bkc()) {
                        i = 4;
                    } else if (dcA.bkd()) {
                        i = 5;
                    }
                    aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    aqVar.dK("tid", ddQ().dfO());
                    aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dK("fid", ddQ().getForumId());
                    if (!z) {
                        aqVar.aj("obj_locate", 6);
                    } else {
                        aqVar.aj("obj_locate", 5);
                    }
                    aqVar.aj("obj_name", i);
                    aqVar.aj("obj_type", 2);
                    if (dcA != null) {
                        if (dcA.bgP()) {
                            aqVar.aj("obj_type", 10);
                        } else if (dcA.bgQ()) {
                            aqVar.aj("obj_type", 9);
                        } else if (dcA.bkd()) {
                            aqVar.aj("obj_type", 8);
                        } else if (dcA.bkc()) {
                            aqVar.aj("obj_type", 7);
                        } else if (dcA.isShareThread) {
                            aqVar.aj("obj_type", 6);
                        } else if (dcA.threadType == 0) {
                            aqVar.aj("obj_type", 1);
                        } else if (dcA.threadType == 40) {
                            aqVar.aj("obj_type", 2);
                        } else if (dcA.threadType == 49) {
                            aqVar.aj("obj_type", 3);
                        } else if (dcA.threadType == 54) {
                            aqVar.aj("obj_type", 4);
                        } else {
                            aqVar.aj("obj_type", 5);
                        }
                        aqVar.dK("nid", dcA.getNid());
                        aqVar.aj(IntentConfig.CARD_TYPE, dcA.bkg());
                        aqVar.dK(IntentConfig.RECOM_SOURCE, dcA.mRecomSource);
                        aqVar.dK("ab_tag", dcA.mRecomAbTag);
                        aqVar.dK("weight", dcA.mRecomWeight);
                        aqVar.dK("extra", dcA.mRecomExtra);
                        aqVar.dK("nid", dcA.getNid());
                        if (dcA.getBaijiahaoData() != null && !at.isEmpty(dcA.getBaijiahaoData().oriUgcVid)) {
                            aqVar.dK("obj_param6", dcA.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        aqVar.dK("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (dfv() != null) {
                        com.baidu.tbadk.pageInfo.c.b(dfv(), aqVar);
                    }
                    TiebaStatic.log(aqVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (ddQ().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> dcC = pbData.dcC();
                        if ((dcC == null || dcC.size() <= 0) && ddQ().dfQ()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.ltP.dir();
                        ctc();
                        TiebaStatic.log(new aq("c11939"));
                        if (!AntiHelper.d(getContext(), dcA)) {
                            if (this.ljq != null) {
                                this.ljq.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                Fl(z ? 2 : 1);
                                return;
                            }
                            this.ltP.showLoadingDialog();
                            ddQ().dgt().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                aq aqVar2 = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar2.dK("tid", ddQ().dfO());
                aqVar2.dK("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.dK("fid", ddQ().getForumId());
                if (!z) {
                }
                aqVar2.aj("obj_name", i);
                aqVar2.aj("obj_type", 2);
                if (dcA != null) {
                }
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (dfv() != null) {
                }
                TiebaStatic.log(aqVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment dkY() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        J(eVar.dlE());
        K(eVar.dlE());
        if (ddQ() != null && ddQ().getPbData() != null) {
            boolean isFromMark = ddQ().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = ddQ().getPbData();
            if (isFromMark) {
                PostData I = I(pbData);
                if (pbData.beb() != null && !pbData.beb().equals(I.getId()) && this.ewX != null) {
                    if (com.baidu.tbadk.a.d.bdE()) {
                        this.ewX.setCurrentItem(ltv);
                    } else {
                        this.ewX.setCurrentItem(ltu);
                    }
                }
            }
        }
        eVar.dlF().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bw bwVar) {
                BdTypeRecyclerView cvV;
                if (bwVar != null && bwVar.biz() != null) {
                    if (VideoPbFragment.this.ltC.getVideoUrl() == null || !VideoPbFragment.this.ltC.getVideoUrl().equals(bwVar.biz().video_url)) {
                        if (!at.isEmpty(VideoPbFragment.this.ltC.getVideoUrl())) {
                            VideoPbFragment.this.laZ = true;
                            if (com.baidu.tbadk.a.d.bdE()) {
                                VideoPbFragment.this.ewX.setCurrentItem(VideoPbFragment.ltv);
                            } else {
                                VideoPbFragment.this.ewX.setCurrentItem(VideoPbFragment.ltt);
                            }
                            if (com.baidu.tbadk.a.d.bdE() && (cvV = VideoPbFragment.this.cvV()) != null) {
                                cvV.scrollToPosition(0);
                            }
                        }
                        if (VideoPbFragment.this.ltD == null || !VideoPbFragment.this.ltD.isPlaying()) {
                            VideoPbFragment.this.dkZ();
                            VideoPbFragment.this.aN(bwVar);
                        }
                        VideoPbFragment.this.dla();
                        if (VideoPbFragment.this.ltD.dlS()) {
                            VideoPbFragment.this.ltD.start();
                        }
                        boolean z = !at.equals(VideoPbFragment.this.ltC.getVideoUrl(), bwVar.biz().video_url);
                        VideoPbFragment.this.ltC.setData(bwVar);
                        if (com.baidu.tbadk.a.d.bdE()) {
                            VideoPbFragment.this.ltC.vb(false);
                        } else {
                            VideoPbFragment.this.ltC.vb(VideoPbFragment.this.ewX.getCurrentItem() == 0);
                        }
                        if (z) {
                            VideoPbFragment.this.ltC.startPlay();
                            VideoPbFragment.this.ltC.dmE();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.ltC.setData(bwVar);
                }
            }
        });
        eVar.dlO().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: s */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.ewX.setCurrentItem(num.intValue());
            }
        });
        eVar.dlJ().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bw bwVar) {
                VideoPbFragment.this.ltC.aS(bwVar);
            }
        });
        eVar.dlK().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bw bwVar) {
                VideoPbFragment.this.ltC.aT(bwVar);
            }
        });
        eVar.dlL().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.dlk();
            }
        });
        eVar.dlM().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkZ() {
        ViewGroup.LayoutParams layoutParams = this.ltF.getLayoutParams();
        layoutParams.height = 0;
        this.ltF.setLayoutParams(layoutParams);
        this.ltF.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dla() {
        if (this.ltD == null) {
            this.ltD = new f(getBaseFragmentActivity(), this.ltB);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(dfv()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.ltB.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.ltD.b(eVar.dlG(), rect);
            if (this.ltD.dlS()) {
                this.ltD.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (com.baidu.tbadk.a.d.bdE()) {
                            if (eVar.dlH() || VideoPbFragment.this.ddQ().getTabIndex() == VideoPbFragment.ltv) {
                                VideoPbFragment.this.ewX.setCurrentItem(VideoPbFragment.ltv);
                            }
                        } else if (eVar.dlH() || VideoPbFragment.this.ddQ().getTabIndex() == VideoPbFragment.ltu) {
                            VideoPbFragment.this.ewX.setCurrentItem(VideoPbFragment.ltu);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (com.baidu.tbadk.a.d.bdE()) {
                            if (eVar.dlH() || VideoPbFragment.this.ddQ().getTabIndex() == VideoPbFragment.ltv) {
                                VideoPbFragment.this.ewX.setCurrentItem(VideoPbFragment.ltv);
                            }
                        } else if (eVar.dlH() || VideoPbFragment.this.ddQ().getTabIndex() == VideoPbFragment.ltu) {
                            VideoPbFragment.this.ewX.setCurrentItem(VideoPbFragment.ltu);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (com.baidu.tbadk.a.d.bdE()) {
                if (eVar.dlH() || ddQ().getTabIndex() == ltv) {
                    this.ewX.setCurrentItem(ltv);
                }
            } else if (eVar.dlH() || ddQ().getTabIndex() == ltu) {
                this.ewX.setCurrentItem(ltu);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.ltV && (this.ltW || dly())) {
            dlx();
            UtilHelper.hideStatusBar(dfv(), dfv().getRootView());
            this.ltW = false;
            if (this.ltC != null) {
                this.ltC.uU(false);
            }
        }
        if (i == 4) {
            return this.ltC.drS();
        }
        if (i == 24) {
            return this.ltC.dmB();
        }
        if (i == 25) {
            return this.ltC.dmC();
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
    public void aN(bw bwVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect dgL;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bwVar != null && bwVar.biz() != null) {
            int intValue = bwVar.biz().video_width.intValue();
            int intValue2 = bwVar.biz().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (ddQ() != null || (dgL = ddQ().dgL()) == null) ? ceil : dgL.height();
                i = 0;
                layoutParams = this.ltB.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.ltB.setLayoutParams(layoutParams);
                this.ltB.setMaxHeight(ceil);
                this.ltB.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.ltB.setOriginHeight(height);
                if (!com.baidu.tbadk.a.d.bdE()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.ltx.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, ltw);
                    } else {
                        layoutParams3.height = ltw;
                    }
                    this.ltx.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.Yg.getLayoutParams();
                if (!com.baidu.tbadk.a.d.bdE()) {
                    ceil += ltw;
                }
                if (layoutParams2 != null) {
                    layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                } else {
                    layoutParams2.height = ceil;
                }
                this.Yg.setLayoutParams(layoutParams2);
                if (i == 0 && (this.Yg.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.Yg.getLayoutParams()).getBehavior();
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
        if (ddQ() != null) {
        }
        i = 0;
        layoutParams = this.ltB.getLayoutParams();
        if (layoutParams != null) {
        }
        this.ltB.setLayoutParams(layoutParams);
        this.ltB.setMaxHeight(ceil2);
        this.ltB.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.ltB.setOriginHeight(height);
        if (!com.baidu.tbadk.a.d.bdE()) {
        }
        layoutParams2 = (CoordinatorLayout.LayoutParams) this.Yg.getLayoutParams();
        if (!com.baidu.tbadk.a.d.bdE()) {
        }
        if (layoutParams2 != null) {
        }
        this.Yg.setLayoutParams(layoutParams2);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.laT = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        ar(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.lbK = new com.baidu.tbadk.core.view.c();
        this.lbK.toastTime = 1000L;
        if (this.ltP != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.ltP.lbL;
            userMuteAddAndDelCustomMessage.setTag(this.ltP.lbL);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.ltP.lbL;
            userMuteCheckCustomMessage.setTag(this.ltP.lbL);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.hGy = new com.baidu.tieba.callfans.a(getPageContext());
        com.baidu.tieba.s.c.dDn().z(getUniqueId());
    }

    private void initData() {
        this.lbp = com.baidu.tbadk.baseEditMark.a.a(this.laM);
        if (this.lbp != null) {
            this.lbp.a(this.lcv);
        }
        this.hGw = new ForumManageModel(this.laM);
        this.hGw.setLoadDataCallBack(this.hGD);
        this.ezg = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.ltP = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void ar(Bundle bundle) {
        this.lbC = new g();
        d(this.lbC);
        this.lbD = (com.baidu.tbadk.editortools.pb.e) this.lbC.ei(getActivity());
        this.lbD.a(this.laM.getPageContext());
        this.lbD.a(this.fbF);
        this.lbD.a(this.fby);
        this.lbD.setFrom(1);
        this.lbD.a(this.laM.getPageContext(), bundle);
        this.lbD.bvf().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lbD.bvf().jF(true);
        tH(true);
        this.lbD.a(ddQ().dge(), ddQ().dfO(), ddQ().dgv());
        registerListener(this.lca);
        registerListener(this.lcu);
        registerListener(this.lbZ);
        registerListener(this.lbX);
        registerListener(this.iqx);
        if (!ddQ().dfV()) {
            this.lbD.Dh(ddQ().dfO());
        }
        if (ddQ().dgw()) {
            this.lbD.Df(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.lbD.Df(dhF());
        }
        this.khj = new bb();
        if (this.lbD.bvL() != null) {
            this.khj.e(this.lbD.bvL().getInputView());
        }
        this.lbD.a(this.fbz);
        this.kdd = new am(getPageContext());
        this.kdd.a(new am.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z) {
                    if (i == am.ezb) {
                        VideoPbFragment.this.lbD.a((String) null, (WriteData) null);
                    } else if (i == am.ezc && VideoPbFragment.this.ljS != null && VideoPbFragment.this.ljS.deA() != null) {
                        VideoPbFragment.this.ljS.deA().bwj();
                    } else if (i == am.ezd) {
                        VideoPbFragment.this.c(VideoPbFragment.this.lbG);
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
        this.itR = new com.baidu.tieba.f.b(getActivity());
        this.itR.a(lcD);
        this.ltV = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        byD();
        this.Yg = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.ltz = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.ltB = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.ltC = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.ltB);
        this.ltC.setStageType("2002");
        this.ltC.setUniqueId(getUniqueId());
        this.ltC.af(this);
        this.ltC.dn(dfv().getRootView());
        this.ltC.m41do(this.ltE);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.ltx = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.ltF = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.ewX = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.ltA = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.ltA.setOnClickListener(this.aEX);
        dlc();
        dlb();
        dld();
        this.lty = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.ewX.setAdapter(this.lty);
        this.ltx.setViewPager(this.ewX);
        this.ltx.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (com.baidu.tbadk.a.d.bdE() && VideoPbFragment.this.dlt() != null) {
                        VideoPbFragment.this.dlt().va(false);
                    } else if (VideoPbFragment.this.dlr() != null) {
                        VideoPbFragment.this.dlr().va(false);
                    }
                    if (VideoPbFragment.this.dls() != null) {
                        VideoPbFragment.this.dls().va(true);
                        VideoPbFragment.this.FU(VideoPbFragment.this.dls().dmg() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.dlL() != null && eVar.dlL().getValue() != null && eVar.dlL().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.ltC.vb(z);
                    VideoPbFragment.this.dhD();
                    if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null) {
                        TiebaStatic.log(new aq("c13592").dK("tid", VideoPbFragment.this.ddQ().dfO()).dK("fid", VideoPbFragment.this.ddQ().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.dls() != null) {
                        VideoPbFragment.this.dls().va(false);
                    }
                    if (com.baidu.tbadk.a.d.bdE() && VideoPbFragment.this.dlt() != null) {
                        VideoPbFragment.this.dlt().va(true);
                        int dmg = VideoPbFragment.this.dlt().dmg();
                        int dmh = VideoPbFragment.this.dlt().dmh();
                        if (dmg != 0) {
                            VideoPbFragment.this.FU(8);
                            VideoPbFragment.this.dlt().FU(0);
                        } else if (dmh != 0) {
                            VideoPbFragment.this.dlt().FU(8);
                            VideoPbFragment.this.FU(0);
                        } else {
                            VideoPbFragment.this.dlt().FU(8);
                            VideoPbFragment.this.FU(8);
                        }
                    } else if (VideoPbFragment.this.dlr() != null) {
                        VideoPbFragment.this.dlr().va(true);
                        int dmg2 = VideoPbFragment.this.dlr().dmg();
                        int dmh2 = VideoPbFragment.this.dlr().dmh();
                        if (dmg2 != 0) {
                            VideoPbFragment.this.FU(8);
                            VideoPbFragment.this.dlr().FU(0);
                        } else if (dmh2 != 0) {
                            VideoPbFragment.this.dlr().FU(8);
                            VideoPbFragment.this.FU(0);
                        } else {
                            VideoPbFragment.this.dlr().FU(8);
                            VideoPbFragment.this.FU(8);
                        }
                    }
                    VideoPbFragment.this.ltC.vb(false);
                    VideoPbFragment.this.Yg.setExpanded(false, true);
                    if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null) {
                        TiebaStatic.log(new aq("c13593").dK("tid", VideoPbFragment.this.ddQ().dfO()).dK("fid", VideoPbFragment.this.ddQ().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.lty.FW(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.liS = this.rootView.findViewById(R.id.viewstub_progress);
        dle();
        bON();
        if (!this.ltV && this.ltW) {
            dlx();
            UtilHelper.hideStatusBar(dfv(), dfv().getRootView());
            this.ltW = false;
        }
        if (com.baidu.tbadk.a.d.bdE()) {
            this.ltx.getLayoutParams().height = 0;
        }
    }

    private void dlb() {
        this.ltH = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.ltL = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.ltI = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.ltJ = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.ltK = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.ltM = this.rootView.findViewById(R.id.ala_live_point);
        this.ltL.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.ltL.setConrers(15);
        this.ltK.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.ltJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.kVi == null || VideoPbFragment.this.kVi.dms()) {
                    if (VideoPbFragment.this.kVi != null) {
                        TiebaStatic.log(new aq("c13608").dK("tid", VideoPbFragment.this.ddQ().getPbData().getThreadId()));
                        VideoPbFragment.this.kVi.lvS = true;
                    }
                } else {
                    TiebaStatic.log(new aq("c13591"));
                }
                VideoPbFragment.this.dlm();
            }
        });
        this.ltK.setOnClickListener(this.ltG);
        this.ltF.setOnClickListener(this.ltG);
    }

    private void dlc() {
        this.ltx.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.ltx.setContainerLayoutParams(layoutParams);
        this.ltx.setRectPaintColor(R.color.cp_link_tip_a);
        this.ltx.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.ltx.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.ltx.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.ltx.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.ltx.setExpandedTabLayoutParams(layoutParams2);
    }

    public void uT(boolean z) {
        if (this.Yg != null) {
            this.Yg.setExpanded(z);
        }
    }

    private void dld() {
        this.ljj = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.ljk = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.lju = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.ljv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.ljm = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.ljm.setVisibility(0);
        this.ljm.setIsRound(true);
        this.ljm.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
        this.ljm.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.ljm.setPlaceHolder(1);
        this.ljm.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.ljm.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        this.jrF = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.ljl = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.ljl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.uT(false);
                VideoPbFragment.this.deM();
                if (VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null && VideoPbFragment.this.ddQ().getPbData().dcA() != null && VideoPbFragment.this.ddQ().getPbData().dcA().bih() != null) {
                    TiebaStatic.log(new aq("c13701").dK("tid", VideoPbFragment.this.ddQ().dfP()).dK("fid", VideoPbFragment.this.ddQ().getPbData().getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new aq("c13402").dK("tid", VideoPbFragment.this.ddQ().dfO()).dK("fid", VideoPbFragment.this.ddQ().getPbData().getForumId()).aj("obj_locate", 1).dK("uid", VideoPbFragment.this.ddQ().getPbData().dcA().bih().getUserId()));
                }
            }
        });
        this.ljn = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.ljn.setOnClickListener(this.aEX);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.ljo = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.ljo.setOnClickListener(this.aEX);
        if (booleanExtra) {
            this.ljo.setVisibility(8);
        } else {
            this.ljo.setVisibility(0);
        }
        this.ljp = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.ljp.setOnClickListener(this.aEX);
        this.ljq = new com.baidu.tieba.pb.view.c(this.ljp);
        this.ljq.dmN();
        this.ljr = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.ljr.setVisibility(0);
        us(false);
    }

    private void byD() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.ctd();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.ltE = this.rootView.findViewById(R.id.status_bar_background);
        if (this.ltV) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(dfv());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.ltE.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(dfv());
            this.ltE.setLayoutParams(layoutParams2);
            this.ltE.setVisibility(0);
        }
        this.fjs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aEX);
        this.gpI = (ImageView) this.fjs.findViewById(R.id.widget_navi_back_button);
        SvgManager.bmU().a(this.gpI, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.loT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aEX);
        this.agR = (ImageView) this.loT.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.loT.setLayoutParams(layoutParams3);
        SvgManager.bmU().a(this.agR, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.loT.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.iAX);
        this.mNavigationBar.setOnTouchListener(this.ltX);
    }

    public void dle() {
        setEditorTools(this.lbD.bvf());
    }

    private void bON() {
        this.laH = new PbFakeFloorModel(getPageContext());
        this.ljS = new v(getPageContext(), this.laH, this.rootView);
        this.ljS.T(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dhD();
            }
        });
        this.ljS.a(this.lcr);
        this.laH.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.laH.t(postData);
                if (com.baidu.tbadk.a.d.bdE() || VideoPbFragment.this.dlt() != null) {
                    VideoPbFragment.this.dlt().dmc();
                } else if (VideoPbFragment.this.dlr() != null) {
                    VideoPbFragment.this.dlr().dmc();
                }
                VideoPbFragment.this.ljS.dew();
                VideoPbFragment.this.abj.btC();
                VideoPbFragment.this.us(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, PostData postData2, boolean z, boolean z2) {
        PbActivity.a OO;
        String dfO = ddQ().dfO();
        String id = postData.getId();
        String str = "";
        if (postData2 != null) {
            str = postData2.getId();
        }
        int i = 0;
        if (ddQ().getPbData() != null) {
            i = ddQ().getPbData().dcP();
        }
        if (dlr() != null && dlr().dme() != null) {
            OO = dlr().dme().OO(id);
        } else if (dlt() != null && dlt().dme() != null) {
            OO = dlt().dme().OO(id);
        } else {
            return;
        }
        if (postData != null && ddQ() != null && ddQ().getPbData() != null && OO != null) {
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dfO, id, "pb", true, null, false, str, i, postData.dkx(), ddQ().getPbData().getAnti(), false, postData.bih().getIconInfo()).addBigImageData(OO.kXA, OO.eje, OO.ejc, OO.index);
            if (z2) {
                addBigImageData.setHighLightPostId(str);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(ddQ().getForumId());
            addBigImageData.setBjhData(ddQ().dfX());
            addBigImageData.setKeyPageStartFrom(ddQ().dgy());
            addBigImageData.setFromFrsForumId(ddQ().getFromForumId());
            addBigImageData.setIsOpenEditor(z);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.laM = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (ddQ() != null) {
            ddQ().aC(bundle);
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
        this.bwE = true;
        getVoiceManager().onPause(getPageContext());
        this.ltC.qD(true);
        if (ddQ() != null && !ddQ().dfV()) {
            this.lbD.Dg(ddQ().dfO());
        }
        com.baidu.tbadk.BdToken.c.bbM().bbX();
        MessageManager.getInstance().unRegisterListener(this.lck);
        MessageManager.getInstance().unRegisterListener(this.lcl);
        MessageManager.getInstance().unRegisterListener(this.lcm);
        MessageManager.getInstance().unRegisterListener(this.jEs);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bwE = false;
        getVoiceManager().onResume(getPageContext());
        this.ltC.qD(false);
        dfr();
        registerListener(this.lck);
        registerListener(this.lcl);
        registerListener(this.lcm);
        registerListener(this.jEs);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.lty != null && this.ewX != null) {
            this.lty.FW(z ? this.ewX.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (this.ljm != null) {
            this.ljm.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.dDn().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dDn().A(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.ljq != null) {
            this.ljq.onDestroy();
        }
        if (this.hGw != null) {
            this.hGw.cancelLoadData();
        }
        if (this.ltC != null) {
            this.ltC.onDestroy();
        }
        if (this.lbe != null) {
            this.lbe.cancelLoadData();
        }
        if (this.kdd != null) {
            this.kdd.onDestroy();
        }
        if (ddQ() != null) {
            ddQ().cancelLoadData();
            ddQ().destory();
            if (ddQ().dgs() != null) {
                ddQ().dgs().onDestroy();
            }
        }
        if (this.lbD != null) {
            this.lbD.onDestroy();
        }
        this.lbK = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.laM);
        this.ltx.onChangeSkinType();
        ap.setBackgroundColor(this.ltx, R.color.cp_bg_line_h);
        this.khj.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.ltD == null || !this.ltD.isPlaying()) {
            ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        ap.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        ap.setBackgroundColor(this.ltE, R.color.cp_mask_b_alpha66);
        if (this.abj != null) {
            this.abj.onChangeSkinType(i);
        }
        if (this.ljS != null) {
            this.ljS.onChangeSkinType(i);
        }
        if (this.jrF != null) {
            ap.setViewTextColor(this.jrF, R.color.cp_cont_d);
        }
        if (this.ljm != null) {
            this.ljm.setBorderColor(ap.getColor(R.color.cp_border_a));
        }
        if (this.ljl != null) {
            this.ljl.setBackgroundDrawable(ap.aN(l.getDimens(getContext(), R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
        }
        if (this.ljo != null && ddQ() != null) {
            if (ddQ().bec()) {
                SvgManager.bmU().a(this.ljo, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bmU().a(this.ljo, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.ljn != null) {
            SvgManager.bmU().a(this.ljn, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (ddQ() != null) {
            x(ddQ().getPbData());
        }
        if (this.ljr != null) {
            ap.c(this.ljr, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_bg_line_h, R.color.cp_bg_line_h);
            ap.setViewTextColor(this.ljr, R.color.cp_cont_j);
        }
        if (this.ljs != null) {
            ap.setViewTextColor(this.ljs, R.color.cp_cont_b);
        }
        if (this.ljj != null) {
            ap.setBackgroundResource(this.ljj, R.drawable.bottom_shadow);
        }
        ap.setBackgroundColor(this.ljk, R.color.cp_bg_line_h);
        if (com.baidu.tbadk.a.d.bdE() && dlt() != null) {
            dlt().onChangeSkinType(i);
        } else if (dlr() != null) {
            dlr().onChangeSkinType(i);
        }
        if (dls() != null) {
            dls().onChangeSkinType(i);
        }
        if (this.ltz != null) {
            ap.setBackgroundResource(this.ltz, R.drawable.personalize_tab_shadow);
        }
        if (this.ltF != null) {
            ap.setBackgroundColor(this.ltF, R.color.cp_bg_line_g);
        }
        if (this.ltJ != null) {
            SvgManager.bmU().a(this.ltJ, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.ltH != null) {
            ap.setViewTextColor(this.ltH, R.color.cp_cont_b);
        }
        if (this.ltI != null) {
            ap.setViewTextColor(this.ltI, R.color.cp_cont_d);
        }
        if (this.ltM != null) {
            this.ltM.setBackgroundDrawable(ap.aN(l.getDimens(this.ltM.getContext(), R.dimen.tbds32), ap.getColor(R.color.cp_other_c)));
        }
        ctc();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.ioV == null) {
            this.ioV = VoiceManager.instance();
        }
        return this.ioV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctc() {
        if (this.ioV != null) {
            this.ioV.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dft() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dfu() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel ddQ() {
        return this.laM.ddQ();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dfv() {
        return this.laM;
    }

    public com.baidu.tbadk.baseEditMark.a dlf() {
        return this.lbp;
    }

    public View.OnClickListener dlg() {
        return this.aEX;
    }

    public View.OnClickListener dlh() {
        return this.kYf;
    }

    public View.OnLongClickListener dli() {
        return this.ltP.dli();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (com.baidu.tieba.pb.pb.main.be.Pd(objArr[i].getLink()) && (drawable = ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView cvV() {
        Iterator<BaseFragment> it = this.lty.dlC().iterator();
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

    private void tH(boolean z) {
        this.lbD.jM(z);
        this.lbD.jN(z);
        this.lbD.jO(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.ltP != null) {
            if (z) {
                this.ltP.dir();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.ltP.dis();
            } else {
                this.ltP.dir();
            }
        }
    }

    public boolean Fj(int i) {
        if (this.kdd == null || ddQ() == null || ddQ().getPbData() == null || ddQ().getPbData().getAnti() == null) {
            return true;
        }
        return this.kdd.aM(ddQ().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean deO() {
        if ((ddQ() != null && ddQ().getPbData().ddd()) || this.kdd == null || ddQ() == null || ddQ().getPbData() == null || ddQ().getPbData().getAnti() == null) {
            return true;
        }
        return this.kdd.oy(ddQ().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && ddQ() != null) {
            gVar.setForumName(ddQ().ddH());
            if (ddQ().getPbData() != null && ddQ().getPbData().getForum() != null) {
                gVar.a(ddQ().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(ddQ());
        }
    }

    public void dhT() {
        if (this.abj != null) {
            this.abj.display();
            if (this.lbD != null) {
                this.lbD.bvQ();
            }
            diB();
        }
    }

    public com.baidu.tbadk.editortools.pb.e deB() {
        return this.lbD;
    }

    private boolean deL() {
        PbModel ddQ = ddQ();
        if (ddQ == null || ddQ.getPbData() == null) {
            return false;
        }
        bw dcA = ddQ.getPbData().dcA();
        ddQ.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), dcA);
    }

    public void deM() {
        if (checkUpIsLogin() && ddQ() != null && ddQ().getPbData() != null && ddQ().getPbData().getForum() != null && !deL()) {
            if (ddQ().getPbData().ddd()) {
                cGu();
                return;
            }
            if (this.itr == null) {
                this.itr = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.itr.zw(0);
                this.itr.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void ph(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void C(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void pi(boolean z) {
                        if (z) {
                            if (VideoPbFragment.this.lbD != null && VideoPbFragment.this.lbD.bvf() != null) {
                                VideoPbFragment.this.lbD.bvf().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            VideoPbFragment.this.cGu();
                        }
                    }
                });
            }
            this.itr.D(ddQ().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(ddQ().dfO(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.lbD.onActivityResult(i, i2, intent);
        if (this.lbe != null) {
            this.lbe.onActivityResult(i, i2, intent);
        }
        if (this.ljS != null) {
            this.ljS.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    deY();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.duk().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.lbG = emotionImageData;
                        if (Fj(am.ezd)) {
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
        if (dfv() != null) {
            if (this.ltW && !TbSingleton.getInstance().isNotchScreen(dfv()) && !TbSingleton.getInstance().isCutoutScreen(dfv())) {
                dlx();
                UtilHelper.hideStatusBar(dfv(), dfv().getRootView());
                this.ltW = false;
            }
            this.ltQ.lul = z;
            dlj();
            dlk();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.laM;
        if (i == 0) {
            dhz();
            if (this.ljS != null) {
                this.ljS.dew();
            }
            us(false);
        }
        dhD();
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
                        this.lbD.resetData();
                        this.lbD.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lbD.b(writeData);
                        m qP = this.lbD.bvf().qP(6);
                        if (qP != null && qP.eYZ != null) {
                            qP.eYZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.laM;
                        if (i == -1) {
                            this.lbD.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.ljS != null && this.ljS.deA() != null) {
                            com.baidu.tbadk.editortools.pb.h deA = this.ljS.deA();
                            deA.setThreadData(ddQ().getPbData().dcA());
                            deA.b(writeData);
                            deA.setVoiceModel(pbEditorData.getVoiceModel());
                            m qP2 = deA.bvf().qP(6);
                            if (qP2 != null && qP2.eYZ != null) {
                                qP2.eYZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.laM;
                            if (i == -1) {
                                deA.bwj();
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
                if (ddQ() != null && !ddQ().dfV()) {
                    antiData.setBlock_forum_name(ddQ().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(ddQ().getPbData().getForum().getId());
                    antiData.setUser_name(ddQ().getPbData().getUserData().getUserName());
                    antiData.setUser_id(ddQ().getPbData().getUserData().getUserId());
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
                com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bM(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.ltP != null) {
                this.ltP.Dm(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void dfx() {
        if (ddQ() != null && this.laM != null) {
            if (this.lbD == null || !this.lbD.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.lbD = (com.baidu.tbadk.editortools.pb.e) dVar.ei(getContext());
                this.lbD.a(this.laM.getPageContext());
                this.lbD.a(this.fbF);
                this.lbD.a(this.fby);
                this.lbD.a(this.laM.getPageContext(), this.laM.getIntent() == null ? null : this.laM.getIntent().getExtras());
                this.lbD.bvf().jF(true);
                setEditorTools(this.lbD.bvf());
                if (!ddQ().dfV()) {
                    this.lbD.Dh(ddQ().dfO());
                }
                if (ddQ().dgw()) {
                    this.lbD.Df(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.lbD.Df(dhF());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.abj = editorTools;
        this.abj.setId(R.id.pb_editor);
        this.abj.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dhD();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.abj.getParent() == null) {
            this.rootView.addView(this.abj, layoutParams);
        }
        this.abj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.abj.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof u) {
                    if (((u) aVar.data).bqt() == EmotionGroupType.BIG_EMOTION || ((u) aVar.data).bqt() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.lbD.c((u) aVar.data);
                            VideoPbFragment.this.lbD.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dhz();
        this.lbD.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.abj != null && VideoPbFragment.this.abj.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.khj != null && VideoPbFragment.this.khj.diS() != null) {
                    if (!VideoPbFragment.this.khj.diS().dNm()) {
                        VideoPbFragment.this.khj.uy(false);
                    }
                    VideoPbFragment.this.khj.diS().xQ(false);
                }
            }
        });
    }

    public void cGu() {
        if (!checkUpIsLogin()) {
            if (ddQ() != null) {
                TiebaStatic.log(new aq("c10517").aj("obj_locate", 2).dK("fid", ddQ().getForumId()));
            }
        } else if (deO()) {
            if (this.lbD != null && (this.lbD.bwa() || this.lbD.bwb())) {
                this.lbD.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.abj != null) {
                dhT();
                this.ltQ.luk = false;
                if (this.abj.qP(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.abj.qP(2).eYZ, false, null);
                }
            }
            diB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !deL() && deO()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lbg);
                this.lbh = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.ljS != null && postData != null) {
                String str3 = "";
                if (postData.dEr() != null) {
                    str3 = postData.dEr().toString();
                }
                this.ljS.OI(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bih().getName_show(), str3));
            }
            if (ddQ() != null && ddQ().getPbData() != null && ddQ().getPbData().ddd()) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.laM.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.lbg[1] + VideoPbFragment.this.lbh) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cvV() != null) {
                            VideoPbFragment.this.cvV().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.ljS != null) {
                            VideoPbFragment.this.lbD.bvf().setVisibility(8);
                            VideoPbFragment.this.ljS.h(str, str2, VideoPbFragment.this.dhF(), (VideoPbFragment.this.ddQ() == null || VideoPbFragment.this.ddQ().getPbData() == null || VideoPbFragment.this.ddQ().getPbData().dcA() == null || !VideoPbFragment.this.ddQ().getPbData().dcA().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h deA = VideoPbFragment.this.ljS.deA();
                            if (deA != null && VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null) {
                                deA.a(VideoPbFragment.this.ddQ().getPbData().getAnti());
                                deA.setThreadData(VideoPbFragment.this.ddQ().getPbData().dcA());
                            }
                            if (VideoPbFragment.this.khj.diU() == null && VideoPbFragment.this.ljS.deA().bwr() != null) {
                                VideoPbFragment.this.ljS.deA().bwr().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.khj != null && VideoPbFragment.this.khj.diT() != null) {
                                            if (!VideoPbFragment.this.khj.diT().dNm()) {
                                                VideoPbFragment.this.khj.uz(false);
                                            }
                                            VideoPbFragment.this.khj.diT().xQ(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.khj.f(VideoPbFragment.this.ljS.deA().bwr().getInputView());
                                VideoPbFragment.this.ljS.deA().a(VideoPbFragment.this.lbI);
                            }
                        }
                        VideoPbFragment.this.diB();
                    }
                }, 0L);
                return;
            }
            if (this.lbF == null) {
                this.lbF = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lbF.zw(1);
                this.lbF.a(new AnonymousClass48(str, str2));
            }
            if (ddQ() != null && ddQ().getPbData() != null && ddQ().getPbData().getForum() != null) {
                this.lbF.D(ddQ().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(ddQ().dfO(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$48  reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass48 implements c.a {
        final /* synthetic */ String lcN;
        final /* synthetic */ String lcO;

        AnonymousClass48(String str, String str2) {
            this.lcN = str;
            this.lcO = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ph(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pi(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.lbg[1] + VideoPbFragment.this.lbh) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cvV() != null) {
                            VideoPbFragment.this.cvV().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.ljS != null) {
                            VideoPbFragment.this.lbD.bvf().setVisibility(8);
                            VideoPbFragment.this.ljS.h(AnonymousClass48.this.lcN, AnonymousClass48.this.lcO, VideoPbFragment.this.dhF(), (VideoPbFragment.this.ddQ() == null || VideoPbFragment.this.ddQ().getPbData() == null || VideoPbFragment.this.ddQ().getPbData().dcA() == null || !VideoPbFragment.this.ddQ().getPbData().dcA().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h deA = VideoPbFragment.this.ljS.deA();
                            if (deA != null && VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null) {
                                deA.a(VideoPbFragment.this.ddQ().getPbData().getAnti());
                                deA.setThreadData(VideoPbFragment.this.ddQ().getPbData().dcA());
                            }
                            if (VideoPbFragment.this.khj.diU() == null && VideoPbFragment.this.ljS.deA().bwr() != null) {
                                VideoPbFragment.this.ljS.deA().bwr().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.khj != null && VideoPbFragment.this.khj.diT() != null) {
                                            if (!VideoPbFragment.this.khj.diT().dNm()) {
                                                VideoPbFragment.this.khj.uz(false);
                                            }
                                            VideoPbFragment.this.khj.diT().xQ(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.khj.f(VideoPbFragment.this.ljS.deA().bwr().getInputView());
                                VideoPbFragment.this.ljS.deA().a(VideoPbFragment.this.lbI);
                            }
                        }
                        VideoPbFragment.this.diB();
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
            String userId = I.bih().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, I.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dcP()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (I.bih() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, I.bih().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, I.bih().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, I.bih().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, I.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, I.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dcP()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bs> dcX = fVar.dcX();
                if (com.baidu.tbadk.core.util.y.getCount(dcX) > 0) {
                    sb = new StringBuilder();
                    for (bs bsVar : dcX) {
                        if (bsVar != null && !StringUtils.isNull(bsVar.getForumName()) && (abVar = bsVar.eoN) != null && abVar.emw && !abVar.emx && (abVar.type == 1 || abVar.type == 2)) {
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
    public void deY() {
        MarkData Fv;
        if (ddQ() != null && ddQ().getPbData() != null) {
            if (com.baidu.tbadk.a.d.bdE() || dlr() != null) {
                if ((!com.baidu.tbadk.a.d.bdE() || dlt() != null) && this.lbp != null) {
                    if (ddQ().getPbData() != null && ddQ().getPbData().ddd()) {
                        Fv = ddQ().Fv(0);
                    } else if (this.ewX != null && this.ewX.getCurrentItem() == ltt) {
                        Fv = ddQ().o(I(ddQ().getPbData()));
                    } else if (com.baidu.tbadk.a.d.bdE()) {
                        Fv = ddQ().Fv(dlt().did());
                    } else {
                        Fv = ddQ().Fv(dlr().did());
                    }
                    if (Fv != null) {
                        if (!Fv.isApp() || (Fv = ddQ().Fv(dlr().did() + 1)) != null) {
                            dhY();
                            this.lbp.a(Fv);
                            if (!this.lbp.bec()) {
                                this.lbp.bee();
                                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                                return;
                            }
                            this.lbp.bed();
                            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fk(int i) {
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
            if (this.lbe == null) {
                this.lbe = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.laM);
                this.lbe.b(this.fby);
                this.lbe.c(this.fbF);
            }
            this.lbe.a(emotionImageData, ddQ(), ddQ().getPbData());
        }
    }

    public PostData I(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dcN() != null) {
            return fVar.dcN();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dcC())) {
            Iterator<PostData> it = fVar.dcC().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dEp() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dcJ();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.bih() != null && postData.bih().getUserTbVipInfoData() != null && postData.bih().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bih().getGodUserData().setIntro(postData.bih().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dcA() == null || fVar.dcA().bih() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bih = fVar.dcA().bih();
        String userId = bih.getUserId();
        HashMap<String, MetaData> userMap = fVar.dcA().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bih;
        }
        postData.IY(1);
        postData.setId(fVar.dcA().biy());
        postData.setTitle(fVar.dcA().getTitle());
        postData.setTime(fVar.dcA().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dfd() {
        ArrayList<PostData> dcC;
        int count;
        int i;
        if (ddQ() == null || ddQ().getPbData() == null || ddQ().getPbData().dcC() == null || (count = com.baidu.tbadk.core.util.y.getCount((dcC = ddQ().getPbData().dcC()))) == 0) {
            return "";
        }
        if (ddQ().dgg()) {
            Iterator<PostData> it = dcC.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dEp() == 1) {
                    return next.getId();
                }
            }
        }
        if (cvV() == null) {
            i = 0;
        } else if (com.baidu.tbadk.a.d.bdE()) {
            i = dlt().dic();
        } else {
            i = dlr().dic();
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dcC, i);
        if (postData == null || postData.bih() == null) {
            return "";
        }
        if (ddQ().OR(postData.bih().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(dcC, i2);
            if (postData2 == null || postData2.bih() == null || postData2.bih().getUserId() == null) {
                break;
            } else if (ddQ().OR(postData2.bih().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(dcC, i3);
            if (postData3 == null || postData3.bih() == null || postData3.bih().getUserId() == null) {
                return "";
            }
            if (ddQ().OR(postData3.bih().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deZ() {
        if (ddQ() != null) {
            com.baidu.tieba.pb.data.f pbData = ddQ().getPbData();
            ddQ().tX(true);
            if (this.lbp != null) {
                pbData.OC(this.lbp.beb());
            }
            if (com.baidu.tbadk.a.d.bdE() && dlt() != null) {
                dlt().dmc();
            } else if (dlr() != null) {
                dlr().dmc();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (ddQ() != null) {
            dia();
            ddQ().tX(z);
            if (this.lbp != null) {
                this.lbp.hU(z);
                if (markData != null) {
                    this.lbp.a(markData);
                }
            }
            if (ddQ().bec()) {
                deZ();
            } else if (com.baidu.tbadk.a.d.bdE() && dlt() != null) {
                dlt().dmc();
            } else if (dlr() != null) {
                dlr().dmc();
            }
        }
    }

    public void b(p pVar) {
        boolean z;
        MetaData metaData;
        if (ddQ() != null && ddQ().getPbData() != null && pVar.ddq() != null) {
            String id = pVar.ddq().getId();
            ArrayList<PostData> dcC = ddQ().getPbData().dcC();
            int i = 0;
            while (true) {
                if (i >= dcC.size()) {
                    z = true;
                    break;
                }
                PostData postData = dcC.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> ddy = pVar.ddy();
                    postData.IX(pVar.getTotalCount());
                    if (postData.dEm() == null || ddy == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = ddy.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.bih() != null && (metaData = postData.getUserMap().get(next.bih().getUserId())) != null) {
                                next.a(metaData);
                                next.wU(true);
                                next.a(getPageContext(), ddQ().OR(metaData.getUserId()));
                            }
                        }
                        z = ddy.size() != postData.dEm().size();
                        if (postData.dEm() != null && postData.dEm().size() < 2) {
                            postData.dEm().clear();
                            postData.dEm().addAll(ddy);
                        }
                    }
                    if (postData.dEi() != null) {
                        postData.dEj();
                    }
                }
            }
            if (!ddQ().getIsFromMark() && z) {
                if (com.baidu.tbadk.a.d.bdE() && dlt() != null) {
                    dlt().dmc();
                } else if (dlr() != null) {
                    dlr().dmc();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deQ() {
        if (ddQ() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.Rl(ddQ().getForumId()) && ddQ().getPbData() != null && ddQ().getPbData().getForum() != null) {
            if (ddQ().getPbData().getForum().isLike() == 1) {
                ddQ().dgu().gd(ddQ().getForumId(), ddQ().dfO());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            bw dcA = fVar.dcA();
            if (dcA != null && dcA.bgR()) {
                dfx();
            } else {
                d(this.lbC);
            }
            if (this.lbD != null) {
                uq(this.lbD.bvT());
                this.lbD.a(fVar.getAnti());
                this.lbD.a(fVar.getForum(), fVar.getUserData());
                this.lbD.setThreadData(dcA);
                if (ddQ() != null) {
                    this.lbD.a(ddQ().dge(), ddQ().dfO(), ddQ().dgv());
                }
                if (dcA != null) {
                    this.lbD.jP(dcA.bjE());
                }
            }
        }
    }

    public void dhD() {
        reset();
        dhz();
        this.ljS.dew();
        us(false);
    }

    private void reset() {
        if (this.lbD != null && this.abj != null) {
            com.baidu.tbadk.editortools.pb.a.bvI().setStatus(0);
            this.lbD.bwd();
            this.lbD.bvs();
            if (this.lbD.getWriteImagesInfo() != null) {
                this.lbD.getWriteImagesInfo().setMaxImagesAllowed(this.lbD.isBJH ? 1 : 9);
            }
            this.lbD.qZ(SendView.ALL);
            this.lbD.ra(SendView.ALL);
            h qM = this.abj.qM(23);
            h qM2 = this.abj.qM(2);
            h qM3 = this.abj.qM(5);
            if (qM2 != null) {
                qM2.display();
            }
            if (qM3 != null) {
                qM3.display();
            }
            if (qM != null) {
                qM.hide();
            }
            this.abj.invalidate();
        }
    }

    public void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dcA() != null) {
            x(fVar);
            this.ljo.setVisibility(fVar.ddd() ? 8 : 0);
            if (fVar.bec()) {
                SvgManager.bmU().a(this.ljo, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bmU().a(this.ljo, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String FD = FD(fVar.dcA().bhY());
            if (this.ljr != null) {
                this.ljr.setText(FD);
            }
            if (this.ljs != null) {
                this.ljs.setText(FD);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dcA()));
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.aZ(fVar.dcA())) {
            if (this.ljq != null) {
                this.ljq.setEnable(false);
                this.ljq.onDestroy();
            }
            SvgManager.bmU().a(this.ljp, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.ljq == null || !this.ljq.isEnable()) {
            SvgManager.bmU().a(this.ljp, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private String FD(int i) {
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

    public void us(boolean z) {
        if (this.ljk != null) {
            uq(this.lbD.bvT());
            if (this.ljg) {
                uh(z);
            } else {
                ui(z);
            }
            dlj();
            dlk();
        }
    }

    public void diB() {
        if (this.ljk != null) {
            this.ljj.setVisibility(8);
            this.ljk.setVisibility(8);
            this.ltQ.luk = false;
            dlj();
            dlk();
        }
    }

    private void dlj() {
        if (this.ltC != null) {
            if (this.ltQ.dlB()) {
                this.ltC.vT(false);
            } else {
                this.ltC.vT(this.ltC.bRF() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlk() {
        if (this.ltC != null && this.ewX != null) {
            if (com.baidu.tbadk.a.d.bdE()) {
                this.ltC.vb(false);
            } else if (this.ewX.getCurrentItem() != 0) {
                this.ltC.vb(false);
            } else if (this.ltQ.dlB()) {
                this.ltC.vb(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.ltC.vb(eVar.dlL() == null || eVar.dlL().getValue() == null || eVar.dlL().getValue().booleanValue());
                }
            }
        }
    }

    private void Fl(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(dfv(), deP(), i);
    }

    private int deP() {
        if (ddQ() == null || ddQ().getPbData() == null || ddQ().getPbData().dcA() == null) {
            return -1;
        }
        return ddQ().getPbData().dcA().biU();
    }

    public void uq(boolean z) {
        this.ljg = z;
    }

    public void uh(boolean z) {
        if (this.ljk != null && this.jrF != null) {
            this.jrF.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.ljk.startAnimation(alphaAnimation);
            }
            this.ljj.setVisibility(0);
            this.ljk.setVisibility(0);
            this.ltQ.luk = true;
        }
    }

    public void ui(boolean z) {
        if (this.ljk != null && this.jrF != null) {
            this.jrF.setText(dhF());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.ljk.startAnimation(alphaAnimation);
            }
            this.ljj.setVisibility(0);
            this.ljk.setVisibility(0);
            this.ltQ.luk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null && this.kVi == null) {
            this.kVi = aVar;
            this.ltH.setText(aVar.getTitle());
            this.ltI.setText(aVar.dmp());
            String dmq = aVar.dmq();
            TBSpecificationBtn tBSpecificationBtn = this.ltK;
            if (TextUtils.isEmpty(dmq)) {
                dmq = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(dmq);
            this.ltL.startLoad(aVar.getImage(), 10, false);
            this.ltM.setVisibility(aVar.dms() ? 0 : 8);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.kVi == null || VideoPbFragment.this.kVi.dms()) {
                        if (VideoPbFragment.this.kVi != null && VideoPbFragment.this.ddQ() != null && VideoPbFragment.this.ddQ().getPbData() != null && VideoPbFragment.this.ddQ().getPbData().getForum() != null) {
                            TiebaStatic.log(new aq("c13712").dK("fid", VideoPbFragment.this.ddQ().getPbData().getForum().getId()).dK("fname", VideoPbFragment.this.ddQ().getPbData().getForum().getName()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("tid", VideoPbFragment.this.ddQ().getPbData().getThreadId()).u("obj_param1", VideoPbFragment.this.kVi.userId));
                        }
                    } else {
                        TiebaStatic.log(new aq("c13608").dK("obj_id", VideoPbFragment.this.kVi.getTitle()).dK("obj_name", VideoPbFragment.this.kVi.dmp()).aj("obj_type", 2).dK("fid", VideoPbFragment.this.ddQ().getPbData().getForumId()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("tid", VideoPbFragment.this.ddQ().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.dll();
                }
            }, aVar.dmr().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dll() {
        ViewGroup.LayoutParams layoutParams = this.ltF.getLayoutParams();
        if (layoutParams != null) {
            if (this.ltN == null || !this.ltN.isRunning()) {
                this.ltF.setAlpha(0.0f);
                this.ltF.setVisibility(0);
                e(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlm() {
        if (this.ltF.getLayoutParams() != null) {
            if (this.ltN == null || !this.ltN.isRunning()) {
                dln();
            }
        }
    }

    private void dln() {
        final ViewGroup.LayoutParams layoutParams = this.ltF.getLayoutParams();
        if (layoutParams != null) {
            if (this.ltO == null || !this.ltO.isRunning()) {
                this.ltO = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.ltO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.ltF.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.ltO.setDuration(200L);
                this.ltO.start();
                this.ltO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
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
        final ViewGroup.LayoutParams layoutParams2 = this.Yg.getLayoutParams();
        final int i = layoutParams2.height;
        this.ltN = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.ltN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.joa);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.joa);
                VideoPbFragment.this.ltF.setLayoutParams(layoutParams);
                VideoPbFragment.this.Yg.setLayoutParams(layoutParams2);
            }
        });
        this.ltN.setDuration(300L);
        this.ltN.start();
        this.ltN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.ltF.setVisibility(8);
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
        final ViewGroup.LayoutParams layoutParams2 = this.Yg.getLayoutParams();
        final int i = layoutParams2.height;
        this.ltN = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ltN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.joa);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.ltF.setLayoutParams(layoutParams);
                VideoPbFragment.this.Yg.setLayoutParams(layoutParams2);
            }
        });
        this.ltN.setDuration(300L);
        this.ltN.start();
        this.ltN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.dlo();
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
    public void dlo() {
        this.ltN = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ltN.setDuration(300L);
        this.ltN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.ltF.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.ltN.start();
    }

    public String dhF() {
        if (!at.isEmpty(this.lkj)) {
            return this.lkj;
        }
        this.lkj = TbadkCoreApplication.getInst().getResources().getString(ay.dhu());
        return this.lkj;
    }

    public void dia() {
        hideProgressBar();
        if (com.baidu.tbadk.a.d.bdE() && dlt() != null) {
            dlt().endLoadData();
            dlt().dib();
        } else if (dlr() != null) {
            dlr().endLoadData();
            dlr().dib();
        }
    }

    public boolean cZ(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bfo().isShowImages()) {
                    return ON(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (ddQ() == null || ddQ().getPbData() == null) {
                        return true;
                    }
                    if (this.ljS != null) {
                        this.ljS.dew();
                    }
                    p pVar = new p();
                    pVar.a(ddQ().getPbData().getForum());
                    pVar.setThreadData(ddQ().getPbData().dcA());
                    pVar.g(postData);
                    this.laH.d(pVar);
                    this.laH.setPostId(postData.getId());
                    a(view, postData.bih().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lbD != null) {
                        uq(this.lbD.bvT());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void dlp() {
        if (this.lbD != null) {
            uq(this.lbD.bvT());
        }
        dhD();
        this.ltP.dir();
    }

    private boolean ON(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.blO().getString("bubble_link", "");
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

    public void cNM() {
        if (this.liS != null) {
            this.liS.setVisibility(0);
        }
    }

    public void cNL() {
        if (this.liS != null) {
            this.liS.setVisibility(8);
        }
    }

    public void FU(int i) {
        if (this.ltz != null) {
            this.ltz.setVisibility(i);
        }
    }

    public void dhY() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a deT() {
        return this.lct;
    }

    public void dhz() {
        if (this.abj != null) {
            this.abj.hide();
        }
    }

    public void ctd() {
        if (this.laM.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.laM.getCurrentFocus());
        }
    }

    public void K(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dcA() != null) {
            String valueOf = String.valueOf(fVar.dcA().bhY());
            if (fVar.dcA().bhY() == 0) {
                valueOf = "";
            }
            this.ltx.Ee(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.lty.dlC()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (ddQ() != null && ddQ().getPbData() != null && ddQ().getPbData().dcA() != null && ddQ().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(ljL)).intValue();
                if (intValue == ljM) {
                    if (!this.hGw.dFa()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.hGw.Sd(at.R(jSONArray));
                        }
                        this.hGw.a(ddQ().getPbData().getForum().getId(), ddQ().getPbData().getForum().getName(), ddQ().getPbData().dcA().getId(), str, intValue3, intValue2, booleanValue, ddQ().getPbData().dcA().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == ljN || intValue == ljP) {
                    if (ddQ().dgr() != null) {
                        ddQ().dgr().Ff(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == ljN) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(String str, String str2) {
        be.bmY().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bCb() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> bCc() {
        if (this.fry == null) {
            this.fry = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bCo */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bfo().isShowImages();
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
                        if (com.baidu.tbadk.core.k.bfo().isShowImages()) {
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
        return this.fry;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> bCd() {
        if (this.fuR == null) {
            this.fuR = TbRichTextView.A(getPageContext().getPageActivity(), 8);
        }
        return this.fuR;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> bCe() {
        if (this.frz == null) {
            this.frz = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnk */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bfo().isShowImages();
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
                    if (com.baidu.tbadk.core.k.bfo().isShowImages()) {
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
                    gifView.bwJ();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.frz;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bCf() {
        if (this.fuS == null) {
            this.fuS = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dfy */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dc */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dd */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).bTK();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: de */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fuS;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bCg() {
        if (this.fuT == null) {
            this.fuT = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dfA */
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
        return this.fuT;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> bCh() {
        this.fuU = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dfz */
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
        return this.fuU;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aw(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.laX = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (com.baidu.tieba.pb.pb.main.be.Pd(str) && ddQ() != null && ddQ().dfO() != null) {
            TiebaStatic.log(new aq("c11664").aj("obj_param1", 1).dK("post_id", ddQ().dfO()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.eXY = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            com.baidu.tieba.pb.pb.main.be.diW().f(getPageContext(), str);
        }
        this.laX = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ax(Context context, String str) {
        com.baidu.tieba.pb.pb.main.be.diW().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.laX = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ay(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void az(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void u(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.ltP.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b dlY = this.ltP.dlY();
            if (dlY == null) {
                this.ltP.deK();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                dlY.getItemView(1).setVisibility(8);
            } else {
                dlY.getItemView(1).setVisibility(0);
            }
            dlY.bkL();
            this.laX = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aA(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.bmY().b(getPageContext(), new String[]{str});
            this.laX = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a dlq() {
        return this.ezg;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bzB() {
        return this.fkK;
    }

    public ReplyFragment dlr() {
        if (this.lty == null || !(this.lty.FV(ltu) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.lty.FV(ltu);
    }

    public DetailInfoFragment dls() {
        if (this.lty == null || !(this.lty.FV(ltt) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.lty.FV(ltt);
    }

    public DetailInfoAndReplyFragment dlt() {
        if (this.lty == null || !(this.lty.FV(ltv) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.lty.FV(ltv);
    }

    public boolean ddG() {
        PbModel ddQ = this.laM.ddQ();
        if (ddQ == null) {
            return false;
        }
        return ddQ.ddG();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dcM;
        PbModel ddQ = this.laM.ddQ();
        if (ddQ != null && ddQ.getPbData() != null && !ddQ.getPbData().ddd()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = ddQ.getPbData().dcA().getId();
            if (ddQ.isShareThread() && ddQ.getPbData().dcA().erY != null) {
                historyMessage.threadName = ddQ.getPbData().dcA().erY.showText;
            } else {
                historyMessage.threadName = ddQ.getPbData().dcA().getTitle();
            }
            if (ddQ.isShareThread() && !ddG()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = ddQ.getPbData().getForum().getName();
            }
            ArrayList<PostData> dcC = ddQ.getPbData().dcC();
            int dic = dlr() != null ? dlr().dic() : 0;
            if (dcC != null && dic >= 0 && dic < dcC.size()) {
                historyMessage.postID = dcC.get(dic).getId();
            }
            historyMessage.isHostOnly = ddQ.getHostMode();
            historyMessage.isSquence = ddQ.dfQ();
            historyMessage.isShareThread = ddQ.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lbD != null) {
            this.lbD.onDestroy();
        }
        if (ddQ != null && (ddQ.dfR() || ddQ.dfT())) {
            Intent intent = new Intent();
            intent.putExtra("tid", ddQ.dfO());
            if (this.lbs) {
                if (this.lbu) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", ddQ.clu());
                }
                if (this.lbt) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", ddQ.getIsGood());
                }
            }
            if (ddQ.getPbData() != null && System.currentTimeMillis() - this.laT >= 40000 && (dcM = ddQ.getPbData().dcM()) != null && !com.baidu.tbadk.core.util.y.isEmpty(dcM.getDataList())) {
                intent.putExtra("guess_like_data", dcM);
            }
            PbActivity pbActivity = this.laM;
            PbActivity pbActivity2 = this.laM;
            pbActivity.setResult(-1, intent);
        }
        if (dfa()) {
            if (ddQ != null) {
                com.baidu.tieba.pb.data.f pbData = ddQ.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.laZ) {
                        if (this.ltB != null) {
                            Rect rect = new Rect();
                            this.ltB.getGlobalVisibleRect(rect);
                            as.dhj().h(rect);
                        }
                        as.dhj().Fz(this.ewX.getCurrentItem());
                        BdTypeRecyclerView cvV = cvV();
                        Parcelable parcelable = null;
                        if (cvV != null) {
                            parcelable = cvV.onSaveInstanceState();
                        }
                        as.dhj().a(ddQ.dfY(), parcelable, ddQ.dfQ(), ddQ.getHostMode(), false);
                    }
                }
            } else {
                as.dhj().reset();
            }
            ded();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.ltC != null && !this.ltC.bRF()) {
            if ((this.ltC.isFullScreen() && configuration.orientation == 1) || (!this.ltC.isFullScreen() && configuration.orientation == 2)) {
                this.ltC.vc(false);
            }
        }
    }

    public boolean dlu() {
        if (this.ltC == null) {
            return false;
        }
        return this.ltC.bRF();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.dDn().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a {
        public boolean luk;
        public boolean lul;

        private a() {
            this.lul = true;
        }

        public boolean dlB() {
            return (this.luk && this.lul) ? false : true;
        }
    }

    public void dlv() {
        this.lbi = -1;
        this.lbj = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfr() {
        if (ddQ() != null && !at.isEmpty(ddQ().dfO())) {
            com.baidu.tbadk.BdToken.c.bbM().q(com.baidu.tbadk.BdToken.b.ebN, com.baidu.adp.lib.f.b.toLong(ddQ().dfO(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.ltA.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlw() {
        if (this.ltZ == null) {
            this.ltZ = ObjectAnimator.ofFloat(this.ltE, "alpha", 0.0f, 1.0f);
            this.ltZ.setDuration(200L);
        }
        this.ltZ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlx() {
        if (this.lua == null) {
            this.lua = ObjectAnimator.ofFloat(this.ltE, "alpha", 1.0f, 0.0f);
            this.lua.setDuration(200L);
        }
        this.lua.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dly() {
        return this.ltC != null && this.ltC.dlz();
    }

    public boolean dlz() {
        return this.ltW;
    }

    public void uU(boolean z) {
        this.ltW = z;
    }

    public void tO(boolean z) {
        this.lba = z;
    }

    public boolean dfp() {
        return this.lba;
    }
}
