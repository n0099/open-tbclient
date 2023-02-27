package com.baidu.ugc.editvideo.magicmusic;
/* loaded from: classes7.dex */
public enum EffectType {
    NO_MATCH(0),
    NO(0),
    TRANSITION_TRAN_LEFT(20),
    TRANSITION_TRAN_RIGHT(21),
    TRANSITION_TRAN_REPEAT(22),
    TRANSITION_ALPHA_ONE(23),
    TRANSITION_ALPHA_TWO(24),
    TRANSITION_ALPHA_REPEAT(25),
    TRANSITION_BOTH_SCREEN(26),
    TRANSITION_ONE(27),
    TRANSITION_TWO(28),
    TRANSITION_SHADOW(29),
    TRANSITION_BIG_SMALL_SCREEN(30),
    HORIZONTAL_TRANSLATION(-1),
    VERTICAL_TRANSLATION(-2),
    ROTATE(-3),
    SOUL_OUT(10),
    SCALE_BIG(11),
    WHITE_BLACK(12),
    NINE_FRAME(13),
    THREE_FRAME(14),
    FOUR_FRAME(15),
    SIX_FRAME(16),
    D_FAKE(17),
    D_SKIN_NEEDLING(18),
    LR_MIRROR(19),
    TB_MIRROR(101),
    LR_TB_MIRROR(102),
    WAGGLE(103),
    DIZZINESS(104),
    HALLUCINATION(105),
    TIME_REPEAT(1),
    TIME_REVERSE(2),
    PARTICLE_SNOWFLAKE(41),
    PARTICLE_HEART(42),
    PARTICLE_BOMB(44),
    PARTICLE_SAKULA(46),
    PARTICLE_SNOW(47),
    PARTICLE_BANANA(49),
    PARTICLE_FLAME(50),
    PARTICLE_PINKSTAR(51),
    PARTICLE_MAGICSTICK(52),
    PARTICLE_FLASH(53);
    
    public int type;

    EffectType(int i) {
        this.type = i;
    }

    public static EffectType findType(int i) {
        EffectType[] values;
        for (EffectType effectType : values()) {
            if (effectType.getType() == i) {
                return effectType;
            }
        }
        return NO_MATCH;
    }

    public int getType() {
        return this.type;
    }
}
