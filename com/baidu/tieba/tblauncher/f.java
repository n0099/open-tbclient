package com.baidu.tieba.tblauncher;

import android.net.Uri;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes16.dex */
public class f {
    public static void B(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM3);
                String queryParameter7 = uri.getQueryParameter("tid");
                String queryParameter8 = uri.getQueryParameter("kw");
                String queryParameter9 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.dPh);
                String queryParameter10 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.dPi);
                String queryParameter11 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.dPj);
                String queryParameter12 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.dPk);
                String queryParameter13 = uri.getQueryParameter("obj_name");
                String queryParameter14 = uri.getQueryParameter("eqid");
                aq aqVar = new aq("c13561");
                aqVar.dD("obj_locate", queryParameter2);
                aqVar.dD("obj_type", queryParameter3);
                aqVar.dD("obj_param1", queryParameter4);
                aqVar.dD(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aqVar.dD(TiebaInitialize.Params.OBJ_PARAM3, queryParameter6);
                aqVar.dD("tid", queryParameter7);
                aqVar.dD("fname", queryParameter8);
                aqVar.dD(com.baidu.tbadk.BdToken.f.dPh, queryParameter9);
                aqVar.dD(com.baidu.tbadk.BdToken.f.dPi, queryParameter10);
                aqVar.dD(com.baidu.tbadk.BdToken.f.dPj, queryParameter11);
                aqVar.dD(com.baidu.tbadk.BdToken.f.dPk, queryParameter12);
                aqVar.dD("obj_source", queryParameter);
                aqVar.dD("obj_name", queryParameter13);
                aqVar.dD("query", queryParameter14);
                TiebaStatic.log(aqVar);
            }
        }
    }

    public static void C(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "PC".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("kw");
                String queryParameter7 = uri.getQueryParameter("obj_name");
                String queryParameter8 = uri.getQueryParameter("fname");
                aq aqVar = new aq("c13561");
                aqVar.dD("obj_locate", queryParameter2);
                aqVar.dD("obj_type", queryParameter3);
                aqVar.dD("obj_param1", queryParameter4);
                aqVar.dD(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aqVar.dD("fname", queryParameter6);
                aqVar.dD("obj_source", queryParameter);
                aqVar.dD("obj_name", queryParameter7);
                aqVar.dD("fname", queryParameter8);
                TiebaStatic.log(aqVar);
            }
        }
    }

    public static void D(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("kw");
                String queryParameter7 = uri.getQueryParameter("obj_name");
                String queryParameter8 = uri.getQueryParameter("topic_id");
                aq aqVar = new aq("c13561");
                aqVar.dD("obj_locate", queryParameter2);
                aqVar.dD("obj_type", queryParameter3);
                aqVar.dD("obj_param1", queryParameter4);
                aqVar.dD(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aqVar.dD("fname", queryParameter6);
                aqVar.dD("obj_source", queryParameter);
                aqVar.dD("obj_name", queryParameter7);
                aqVar.dD("topic_id", queryParameter8);
                TiebaStatic.log(aqVar);
            }
        }
    }

    public static void E(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("obj_name");
                aq aqVar = new aq("c13561");
                aqVar.dD("obj_locate", queryParameter2);
                aqVar.dD("obj_type", queryParameter3);
                aqVar.dD("obj_param1", queryParameter4);
                aqVar.dD(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aqVar.dD("obj_source", queryParameter);
                aqVar.dD("obj_name", queryParameter6);
                TiebaStatic.log(aqVar);
            }
        }
    }

    public static void F(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "PC".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                uri.getQueryParameter("kw");
                String queryParameter6 = uri.getQueryParameter("obj_name");
                uri.getQueryParameter("fname");
                aq aqVar = new aq("c13561");
                aqVar.dD("obj_locate", queryParameter2);
                aqVar.dD("obj_type", queryParameter3);
                aqVar.dD("obj_param1", queryParameter4);
                aqVar.dD(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aqVar.dD("obj_source", queryParameter);
                aqVar.dD("obj_name", queryParameter6);
                TiebaStatic.log(aqVar);
            }
        }
    }
}
